package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.MovieRep;
import kg.megacom.cinematica.exceptions.MovieException;
import kg.megacom.cinematica.mappers.MovieMapper;
import kg.megacom.cinematica.models.dtos.MovieDto;
import kg.megacom.cinematica.models.responses.*;
import kg.megacom.cinematica.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRep rep;

    MovieMapper mapper = MovieMapper.INSTANCE;

    @Override
    public MovieDto save(MovieDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public MovieDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new MovieException("Movie not found")));
    }

    @Override
    public MovieDto delete(Long id) {
        MovieDto dto = findById(id);
        dto.setActive(false);
        return save(dto);
    }

    @Override
    public List<MovieDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<MovieResponse> getMovies(int limit, int offset) {
        List<MovieDto> dtos = mapper.toDtos(rep.getMovies(limit, offset));
        List<MovieResponse> response = new ArrayList<>();
        for (MovieDto dto : dtos) {
            response.add(new MovieResponse(dto.getId(), dto.getName(), dto.getImage(), dto.getPg()));
        }
        return response;
    }

    private List<MovieInfoResponse> getMovieInfo(int id, LocalDate date) {
        return rep.getMovieInfo(id, date);
    }

    @Override
    public SessionsResponse getSession(int id, LocalDate date) {
        List<MovieInfoResponse> responses = getMovieInfo(id, date);
        SessionsResponse sessionsResponse = new SessionsResponse();
        sessionsResponse.setCinemas(new HashSet<>());
        sessionsResponse.getCinemas().forEach(x -> x.setRooms(new HashSet<>()));
        sessionsResponse.getCinemas().forEach(x -> x.getRooms().forEach(z -> z.setRoomMovieIDs(new HashSet<>())));

        if (responses.size() == 0) {
            throw new MovieException("There are no sessions for this date and time!");
        }

        sessionsResponse.setName(responses.get(0).getMovieName());
        sessionsResponse.setDescription(responses.get(0).getDescription());
        sessionsResponse.setPg(responses.get(0).getPg());
        sessionsResponse.setImage(responses.get(0).getImage());

        for (MovieInfoResponse mir : responses) {
            RoomMovieResponse roomMovie = new RoomMovieResponse();
            roomMovie.setId(mir.getSessionID());
            roomMovie.setStandartPrice(mir.getStandartPrice());
            roomMovie.setChildPrice(mir.getChildPrice());
            roomMovie.setStartTime(LocalDateTime.ofInstant(mir.getStart_date_time().toInstant(), ZoneId.systemDefault()).toLocalTime());
            if (sessionsResponse.getCinemas().size() == 0) {
                sessionsResponse.getCinemas().add(notExistCinemaAndRoom(mir, roomMovie));
            } else {
                checkCinema(sessionsResponse, roomMovie, mir);
            }
        }
        return sessionsResponse;
    }

    private void checkCinema(SessionsResponse sessionsResponse, RoomMovieResponse roomMovie, MovieInfoResponse mir){
        for (CinemaResponse cr : sessionsResponse.getCinemas()) {
            if (cr.getId().equals(mir.getCinemaID())) {
                checkRoom(cr, roomMovie, mir);
                return;
            }
        }
        sessionsResponse.getCinemas().add(notExistCinemaAndRoom(mir, roomMovie));
    }


    private void checkRoom(CinemaResponse cr, RoomMovieResponse roomMovie, MovieInfoResponse mir){
        for (RoomResponse r : cr.getRooms()) {
            if (r.getId().equals(mir.getRoomID())) {
                r.getRoomMovieIDs().add(roomMovie);
                return;
            }
        }
        cr.getRooms().add(notExistRoom(mir, roomMovie));
    }


    private CinemaResponse notExistCinemaAndRoom(MovieInfoResponse mir, RoomMovieResponse roomMovie){
        CinemaResponse cinema = new CinemaResponse();
        cinema.setId(mir.getCinemaID());
        cinema.setName(mir.getCinemaName());
        RoomResponse room = notExistRoom(mir, roomMovie);
        Set<RoomResponse> roomResponseSet = new HashSet<>();
        roomResponseSet.add(room);
        cinema.setRooms(roomResponseSet);
        return cinema;
    }

    private RoomResponse notExistRoom(MovieInfoResponse mir, RoomMovieResponse roomMovie){
        RoomResponse rm = new RoomResponse();
        rm.setId(mir.getRoomID());
        rm.setName(mir.getRoomName());
        Set<RoomMovieResponse> roomMovieResponseSet = new HashSet<>();
        roomMovieResponseSet.add(roomMovie);
        rm.setRoomMovieIDs(roomMovieResponseSet);
        return rm;
    }
}