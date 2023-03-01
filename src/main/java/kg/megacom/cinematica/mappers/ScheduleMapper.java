package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.ScheduleDto;
import kg.megacom.cinematica.models.entities.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule, ScheduleDto>{
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
}
