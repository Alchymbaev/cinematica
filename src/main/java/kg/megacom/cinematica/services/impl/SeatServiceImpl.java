package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.SeatRep;
import kg.megacom.cinematica.exceptions.SeatException;
import kg.megacom.cinematica.mappers.SeatMapper;
import kg.megacom.cinematica.models.dtos.SeatDto;
import kg.megacom.cinematica.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRep rep;

    SeatMapper mapper = SeatMapper.INSTANCE;

    @Override
    public SeatDto save(SeatDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public SeatDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new SeatException("Seat not found")));
    }

    @Override
    public SeatDto delete(Long id) {
        SeatDto dto = findById(id);
        rep.delete(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<SeatDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
