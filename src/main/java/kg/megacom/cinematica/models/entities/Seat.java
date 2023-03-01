package kg.megacom.cinematica.models.entities;

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
@Table(name = "tb_seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int row;
    int num;
    @ManyToOne
    @JoinColumn(name = "room_id")
    Room room;
    Date addDate;
    Date updateDate;

    @PrePersist
    protected void onCreate(){
        addDate = new Date();
        updateDate = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updateDate = new Date();
    }
}
