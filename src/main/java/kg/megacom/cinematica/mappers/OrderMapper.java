package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.OrderDto;
import kg.megacom.cinematica.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto> {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
