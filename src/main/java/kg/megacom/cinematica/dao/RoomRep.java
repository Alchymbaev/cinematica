package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRep extends JpaRepository<Room, Long> {
}
