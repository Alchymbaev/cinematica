package kg.megacom.cinematica.dao;

import kg.megacom.cinematica.models.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRep extends JpaRepository<OrderDetail, Long> {
}
