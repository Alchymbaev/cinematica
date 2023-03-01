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
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String name;
    int year;
    @Column(columnDefinition = "TEXT")
    String description;
    String image;
    double rating;
    int pg; //Parental guidance suggested (Возрастное ограничени)
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
