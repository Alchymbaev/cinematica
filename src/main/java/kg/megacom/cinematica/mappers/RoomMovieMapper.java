package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.RoomMovieDto;
import kg.megacom.cinematica.models.entities.RoomMovie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMovieMapper extends BaseMapper<RoomMovie, RoomMovieDto>{
    RoomMovieMapper INSTANCE = Mappers.getMapper(RoomMovieMapper.class);
}
