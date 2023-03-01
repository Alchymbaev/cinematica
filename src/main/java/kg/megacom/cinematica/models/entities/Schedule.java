package kg.megacom.cinematica.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date startDateTime;
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
