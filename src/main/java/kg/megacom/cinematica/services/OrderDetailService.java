package kg.megacom.cinematica.services;

import kg.megacom.cinematica.models.dtos.OrderDetailDto;
import kg.megacom.cinematica.models.enums.PriceTypeEnum;
import kg.megacom.cinematica.models.responses.OrderDetailResponse;

import java.util.Map;

public interface OrderDetailService extends BaseService<OrderDetailDto> {
    OrderDetailResponse bookTickets(Map<Long, PriceTypeEnum> map);
}
