package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.MovieDto;
import kg.megacom.cinematica.models.dtos.OrderDetailDto;
import kg.megacom.cinematica.models.entities.Movie;
import kg.megacom.cinematica.models.entities.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailDto>{
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
}
