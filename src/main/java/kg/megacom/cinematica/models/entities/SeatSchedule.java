package kg.megacom.cinematica.models.entities;

import kg.megacom.cinematica.models.enums.SeatStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_seat_schedule")
public class SeatSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "seat_id")
    Seat seat;
    @ManyToOne
    @JoinColumn(name = "room_movie_id")
    RoomMovie roomMovie;
    @Enumerated(EnumType.STRING)
    SeatStatus status;

    @PrePersist
    protected void onCreate(){
        status = SeatStatus.FREE;
    }

}
