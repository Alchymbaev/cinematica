package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRep extends JpaRepository<Seat, Long> {
}
