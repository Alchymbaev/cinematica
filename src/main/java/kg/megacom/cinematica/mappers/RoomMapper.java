package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.RoomDto;
import kg.megacom.cinematica.models.entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper extends BaseMapper<Room, RoomDto>{
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
}
