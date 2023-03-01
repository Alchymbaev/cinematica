package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.RoomMoviePrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomMoviePriceRep extends JpaRepository<RoomMoviePrice, Long> {
    List<RoomMoviePrice> getRoomMoviePricesByRoomMovieId(Long id);
}
