package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.RoomMoviePriceDto;
import kg.megacom.cinematica.models.entities.RoomMoviePrice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMoviePriceMapper extends BaseMapper<RoomMoviePrice, RoomMoviePriceDto>{
    RoomMoviePriceMapper INSTANCE = Mappers.getMapper(RoomMoviePriceMapper.class);
}
