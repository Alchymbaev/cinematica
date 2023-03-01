package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.OrderDetailRep;
import kg.megacom.cinematica.exceptions.OrderDetailException;
import kg.megacom.cinematica.exceptions.SeatScheduleException;
import kg.megacom.cinematica.mappers.OrderDetailMapper;
import kg.megacom.cinematica.mappers.OrderMapper;
import kg.megacom.cinematica.mappers.SeatScheduleMapper;
import kg.megacom.cinematica.models.dtos.*;
import kg.megacom.cinematica.models.enums.PriceTypeEnum;
import kg.megacom.cinematica.models.enums.SeatStatus;
import kg.megacom.cinematica.models.responses.OrderDetailResponse;
import kg.megacom.cinematica.models.responses.SeatResponse;
import kg.megacom.cinematica.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRep rep;
    @Autowired
    private SeatScheduleService seatScheduleService;
    @Autowired
    private RoomMoviePriceService roomMoviePriceService;
    @Autowired
    private OrderService orderService;

    OrderDetailMapper mapper = OrderDetailMapper.INSTANCE;
    SeatScheduleMapper seatScheduleMapper = SeatScheduleMapper.INSTANCE;
    OrderMapper orderMapper = OrderMapper.INSTANCE;

    @Override
    public OrderDetailDto save(OrderDetailDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public OrderDetailDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new OrderDetailException("OrderDetail not found")));
    }

    @Override
    public OrderDetailDto delete(Long id) {
        OrderDetailDto dto = findById(id);
        rep.delete(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<OrderDetailDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }


    @Override
    @Transactional
    public OrderDetailResponse bookTickets(Map<Long, PriceTypeEnum> map) {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setSeatsResponse(new ArrayList<>());
        OrderDto orderDto = new OrderDto();
        List<SeatScheduleDto> seatScheduleDtoList = new ArrayList<>();

        for (Map.Entry<Long, PriceTypeEnum> entry : map.entrySet()) {
            SeatScheduleDto seatScheduleDto = seatScheduleService.findById(entry.getKey());
            if (seatScheduleDto.getStatus() == SeatStatus.RESERVED){
                throw new SeatScheduleException("Seat is RESERVED");
            }
            seatScheduleDto.setStatus(SeatStatus.RESERVED);
            seatScheduleService.save(seatScheduleDto);
            seatScheduleDtoList.add(seatScheduleDto);
            RoomMoviePriceDto roomMoviePriceDto = getRoomMoviePrice(seatScheduleDto.getRoomMovie().getId(),  entry.getValue());

            orderDto.setPrice(orderDto == null ? roomMoviePriceDto.getPrice().getPrice() : (orderDto.getPrice() + roomMoviePriceDto.getPrice().getPrice()));

            SeatResponse seatResponse = new SeatResponse();
            seatResponse.setId(seatScheduleDto.getSeat().getId());
            seatResponse.setRow(seatScheduleDto.getSeat().getRow());
            seatResponse.setNum(seatScheduleDto.getSeat().getNum());
            seatResponse.setPrice(roomMoviePriceDto.getPrice().getPrice());
            seatResponse.setPriceType(roomMoviePriceDto.getPrice().getPriceType());

            if (orderDetailResponse.getCinemaName() == null){
                orderDetailResponse.setMovieName(seatScheduleDto.getRoomMovie().getMovie().getName());
                orderDetailResponse.setCinemaName(seatScheduleDto.getRoomMovie().getRoom().getCinema().getName());
                orderDetailResponse.setRoomName(seatScheduleDto.getRoomMovie().getRoom().getName());
                orderDetailResponse.setDate(seatScheduleDto.getRoomMovie().getSchedule().getStartDateTime());
                orderDetailResponse.getSeatsResponse().add(seatResponse);
            } else {
                orderDetailResponse.getSeatsResponse().add(seatResponse);
            }
        }
        OrderDto myOrder = orderService.save(orderDto);
        saveOrderDetails(seatScheduleDtoList, myOrder);
        orderDetailResponse.setTotalPrice(myOrder.getPrice());
        return orderDetailResponse;
    }

    private RoomMoviePriceDto getRoomMoviePrice(Long id, PriceTypeEnum priceType){
        List<RoomMoviePriceDto> roomMoviePriceDtoList = roomMoviePriceService.getRoomMoviePricesByRoomMovieId(id);
        RoomMoviePriceDto roomMoviePriceDto = null;
        for (RoomMoviePriceDto r : roomMoviePriceDtoList) {
            if (r.getPrice().getPriceType() == priceType){
                roomMoviePriceDto = r;
                break;
            }
        }
        return roomMoviePriceDto;
    }

    private void saveOrderDetails(List<SeatScheduleDto> seatScheduleDtoList, OrderDto myOrder){
        for (SeatScheduleDto s : seatScheduleDtoList) {
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setSeatSchedule(seatScheduleMapper.toEntity(s));
            orderDetailDto.setOrder(orderMapper.toEntity(myOrder));
            save(orderDetailDto);
        }
    }
}
