package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.SeatScheduleRep;
import kg.megacom.cinematica.exceptions.SeatScheduleException;
import kg.megacom.cinematica.mappers.SeatScheduleMapper;
import kg.megacom.cinematica.models.dtos.SeatScheduleDto;
import kg.megacom.cinematica.models.responses.SeatScheduleResponse;
import kg.megacom.cinematica.services.SeatScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatScheduleServiceImpl implements SeatScheduleService {
    @Autowired
    private SeatScheduleRep rep;

    SeatScheduleMapper mapper = SeatScheduleMapper.INSTANCE;

    @Override
    public SeatScheduleDto save(SeatScheduleDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public SeatScheduleDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new SeatScheduleException("SeatSchedule not found")));
    }

    @Override
    public SeatScheduleDto delete(Long id) {
        SeatScheduleDto dto = findById(id);
        rep.delete(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<SeatScheduleDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<SeatScheduleResponse> getSetSchedule(Long roomMovieID) {
        List<SeatScheduleDto> dtos = mapper.toDtos(rep.getSeatScheduleByRoomMovieId(roomMovieID));
        List<SeatScheduleResponse> response = new ArrayList<>();
        for (SeatScheduleDto ssd : dtos) {
            response.add(new SeatScheduleResponse(ssd.getId(), ssd.getStatus(), ssd.getSeat().getRow(), ssd.getSeat().getNum()));
        }
        return response;
    }
}
