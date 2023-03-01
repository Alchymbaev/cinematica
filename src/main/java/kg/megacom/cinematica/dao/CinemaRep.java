package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRep extends JpaRepository<Cinema, Long> {
}
