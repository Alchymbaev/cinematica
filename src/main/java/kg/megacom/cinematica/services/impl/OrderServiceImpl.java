package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.OrderRep;
import kg.megacom.cinematica.exceptions.OrderException;
import kg.megacom.cinematica.mappers.OrderMapper;
import kg.megacom.cinematica.models.dtos.OrderDto;
import kg.megacom.cinematica.models.dtos.RoomMoviePriceDto;
import kg.megacom.cinematica.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRep rep;

    OrderMapper mapper = OrderMapper.INSTANCE;

    @Override
    public OrderDto save(OrderDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public OrderDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new OrderException("Order not found")));
    }

    @Override
    public OrderDto delete(Long id) {
        OrderDto dto = findById(id);
        rep.delete(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

}
