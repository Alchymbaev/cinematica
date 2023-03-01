package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.CinemaRep;
import kg.megacom.cinematica.exceptions.CinemaException;
import kg.megacom.cinematica.mappers.CinemaMapper;
import kg.megacom.cinematica.models.dtos.CinemaDto;
import kg.megacom.cinematica.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaRep rep;

    CinemaMapper mapper = CinemaMapper.INSTANCE;

    @Override
    public CinemaDto save(CinemaDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public CinemaDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new CinemaException("Cinema not found")));
    }

    @Override
    public CinemaDto delete(Long id) {
        CinemaDto dto = findById(id);
        dto.setActive(false);
        return save(dto);
    }

    @Override
    public List<CinemaDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
