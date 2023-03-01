package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.MovieDto;
import kg.megacom.cinematica.models.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper extends BaseMapper<Movie, MovieDto>{
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
}
