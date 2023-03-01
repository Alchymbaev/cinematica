package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.RoomMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMovieRep extends JpaRepository<RoomMovie, Long> {
}
