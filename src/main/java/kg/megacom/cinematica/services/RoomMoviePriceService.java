package kg.megacom.cinematica.services;

import kg.megacom.cinematica.models.dtos.RoomMoviePriceDto;

import java.util.List;

public interface RoomMoviePriceService extends BaseService<RoomMoviePriceDto>{
    List<RoomMoviePriceDto> getRoomMoviePricesByRoomMovieId(Long id);
}
