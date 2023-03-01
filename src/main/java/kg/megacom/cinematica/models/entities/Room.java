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
@Table(name = "tb_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int seatCount;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    Cinema cinema;
    boolean isActive;
    Date addDate;
    Date updateDate;

    @PrePersist
    protected void onCreate(){
        isActive = true;
        addDate = new Date();
        updateDate = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updateDate = new Date();
    }
}
