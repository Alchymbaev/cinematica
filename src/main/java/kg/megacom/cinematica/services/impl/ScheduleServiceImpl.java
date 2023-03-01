package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.ScheduleRep;
import kg.megacom.cinematica.exceptions.ScheduleException;
import kg.megacom.cinematica.mappers.ScheduleMapper;
import kg.megacom.cinematica.models.dtos.ScheduleDto;
import kg.megacom.cinematica.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRep rep;

    ScheduleMapper mapper = ScheduleMapper.INSTANCE;

    @Override
    public ScheduleDto save(ScheduleDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public ScheduleDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new ScheduleException("Schedule not found")));
    }

    @Override
    public ScheduleDto delete(Long id) {
        ScheduleDto dto = findById(id);
        rep.delete(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<ScheduleDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
