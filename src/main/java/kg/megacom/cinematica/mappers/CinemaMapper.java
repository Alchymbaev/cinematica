package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.CinemaDto;
import kg.megacom.cinematica.models.entities.Cinema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CinemaMapper extends BaseMapper<Cinema, CinemaDto>{
    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);
}
