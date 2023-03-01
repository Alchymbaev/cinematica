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
@Table(name = "tb_roomMovie_price")
public class RoomMoviePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "roomMovie_id")
    RoomMovie roomMovie;
    @ManyToOne
    @JoinColumn(name = "price_id")
    Price price;
}
