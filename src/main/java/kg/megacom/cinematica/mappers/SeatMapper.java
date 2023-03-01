package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.SeatDto;
import kg.megacom.cinematica.models.entities.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatMapper extends BaseMapper<Seat, SeatDto>{
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);
}
