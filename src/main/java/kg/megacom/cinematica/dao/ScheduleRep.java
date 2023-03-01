package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRep extends JpaRepository<Schedule, Long> {
}
