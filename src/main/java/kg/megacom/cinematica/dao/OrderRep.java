package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRep extends JpaRepository<Order, Long> {
}
