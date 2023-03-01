package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.Movie;
import kg.megacom.cinematica.models.entities.SeatSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatScheduleRep extends JpaRepository<SeatSchedule, Long> {
    List<SeatSchedule> getSeatScheduleByRoomMovieId(Long roomMovieID);
}
