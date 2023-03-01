package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.SeatScheduleDto;
import kg.megacom.cinematica.models.entities.SeatSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatScheduleMapper extends BaseMapper<SeatSchedule, SeatScheduleDto>{
    SeatScheduleMapper INSTANCE = Mappers.getMapper(SeatScheduleMapper.class);
}
