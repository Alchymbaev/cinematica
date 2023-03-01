package kg.megacom.cinematica.services;

import kg.megacom.cinematica.models.dtos.MovieDto;
import kg.megacom.cinematica.models.responses.MovieInfoResponse;
import kg.megacom.cinematica.models.responses.MovieResponse;
import kg.megacom.cinematica.models.responses.SessionsResponse;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MovieService extends BaseService<MovieDto>{

    List<MovieResponse> getMovies(int limit, int offset);

    SessionsResponse getSession(int id, LocalDate date);
}
