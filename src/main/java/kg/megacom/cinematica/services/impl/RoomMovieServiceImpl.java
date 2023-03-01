package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.RoomMovieRep;
import kg.megacom.cinematica.exceptions.RoomMovieException;
import kg.megacom.cinematica.mappers.RoomMovieMapper;
import kg.megacom.cinematica.models.dtos.RoomMovieDto;
import kg.megacom.cinematica.services.RoomMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomMovieServiceImpl implements RoomMovieService {
    @Autowired
    private RoomMovieRep rep;

    RoomMovieMapper mapper = RoomMovieMapper.INSTANCE;

    @Override
    public RoomMovieDto save(RoomMovieDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public RoomMovieDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RoomMovieException("RoomMovie not found")));
    }

    @Override
    public RoomMovieDto delete(Long id) {
        RoomMovieDto dto = findById(id);
        rep.delete(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<RoomMovieDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
