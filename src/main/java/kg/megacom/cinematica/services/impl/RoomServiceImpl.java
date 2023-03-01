package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.RoomRep;
import kg.megacom.cinematica.exceptions.RoomException;
import kg.megacom.cinematica.mappers.RoomMapper;
import kg.megacom.cinematica.models.dtos.RoomDto;
import kg.megacom.cinematica.models.dtos.SeatDto;
import kg.megacom.cinematica.services.RoomService;
import kg.megacom.cinematica.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRep rep;
    @Autowired
    private SeatService seatService;

    RoomMapper mapper = RoomMapper.INSTANCE;

    @Override
    public RoomDto save(RoomDto t) {
        RoomDto roomDto = mapper.toDto(rep.save(mapper.toEntity(t)));
        setSeats(roomDto);
        return roomDto;
    }

    @Override
    public RoomDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RoomException("Room not found")));
    }

    @Override
    public RoomDto delete(Long id) {
        RoomDto dto = findById(id);
        dto.setActive(false);
        return save(dto);
    }

    @Override
    public List<RoomDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    private void setSeats(RoomDto roomDto){
        int row = 1;
        int num = 1;
        for (int i = 0; i < roomDto.getSeatCount(); i++) {
            SeatDto seatDto = new SeatDto();
            seatDto.setRow(row);
            seatDto.setNum(num);
            seatDto.setRoom(mapper.toEntity(roomDto));
            seatService.save(seatDto);
            num += 1;
            if (num > 5) {
                row += 1;
                num = 1;
            }
        }
    }
}
