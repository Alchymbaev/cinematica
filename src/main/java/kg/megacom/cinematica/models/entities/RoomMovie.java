package kg.megacom.cinematica.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_room_movie")
public class RoomMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "room_id")
    Room room;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    Schedule schedule;
}
