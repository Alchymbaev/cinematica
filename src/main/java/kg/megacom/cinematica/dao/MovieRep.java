package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.Movie;
import kg.megacom.cinematica.models.responses.MovieInfoResponse;
import kg.megacom.cinematica.models.responses.MovieResponse;
import kg.megacom.cinematica.models.responses.SessionsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MovieRep extends JpaRepository<Movie, Long> {
    @Query(value = "select m.* " +
            "from tb_movie as m where m.is_active = true " +
            "limit :limit offset :offset", nativeQuery = true)
    List<Movie> getMovies(int limit, int offset);


    @Query(value = "select m.id, m.name as movieName, m.description, m.pg, m.image,\n" +
            "\tc.id as cinemaID, c.name as cinemaName, r.id as roomID, r.name as roomName, \n" +
            "\trm.id as sessionID, p.standartPrice, p.childPrice, s.start_date_time\n" +
            "from tb_movie as m\n" +
            "left join tb_room_movie as rm on m.id = movie_id\n" +
            "left join tb_schedule as s on rm.schedule_id = s.id\n" +
            "left join tb_room as r on rm.room_id = r.id\n" +
            "left join tb_cinema as c on r.cinema_id = c.id\n" +
            "left join (\n" +
            "\tselect rmp.room_movie_id, \n" +
            "\tAVG(pa.price) FILTER(WHERE pa.price_type = 'ADULT') AS standartPrice,\n" +
            "\tAVG(pa.price) FILTER(WHERE pa.price_type = 'CHILD') AS childPrice\n" +
            "\tfrom tb_room_movie_price as rmp \n" +
            "\tleft join tb_price pa on rmp.price_id = pa.id\n" +
            "\tGROUP BY rmp.room_movie_id) p on p.room_movie_id = rm.id\n" +
            "where m.id = :id and TO_DATE(TO_CHAR(s.start_date_time, 'YYYY-MM-DD'), 'YYYY-MM-DD') = :date", nativeQuery = true)
    List<MovieInfoResponse> getMovieInfo(int id, LocalDate date);
}
