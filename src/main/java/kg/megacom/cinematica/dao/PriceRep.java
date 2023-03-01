package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.Price;
import kg.megacom.cinematica.models.enums.PriceTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRep extends JpaRepository<Price, Long> {
}
