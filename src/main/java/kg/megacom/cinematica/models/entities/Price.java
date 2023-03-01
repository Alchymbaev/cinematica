package kg.megacom.cinematica.models.entities;

import kg.megacom.cinematica.models.enums.PriceTypeEnum;
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
@Table(name = "tb_price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double price;
    @Enumerated(EnumType.STRING)
    PriceTypeEnum priceType;
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
