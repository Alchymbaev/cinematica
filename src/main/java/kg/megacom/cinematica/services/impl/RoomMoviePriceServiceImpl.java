package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.RoomMoviePriceRep;
import kg.megacom.cinematica.exceptions.RoomMoviePriceException;
import kg.megacom.cinematica.mappers.RoomMoviePriceMapper;
import kg.megacom.cinematica.models.dtos.RoomMovieDto;
import kg.megacom.cinematica.models.dtos.RoomMoviePriceDto;
import kg.megacom.cinematica.services.RoomMoviePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomMoviePriceServiceImpl implements RoomMoviePriceService {

    @Autowired
    private RoomMoviePriceRep rep;

    RoomMoviePriceMapper mapper = RoomMoviePriceMapper.INSTANCE;

    @Override
    public RoomMoviePriceDto save(RoomMoviePriceDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public RoomMoviePriceDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RoomMoviePriceException("RoomMoviePrice not found")));
    }

    @Override
    public RoomMoviePriceDto delete(Long id) {
        RoomMoviePriceDto dto = findById(id);
        rep.delete(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<RoomMoviePriceDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<RoomMoviePriceDto> getRoomMoviePricesByRoomMovieId(Long id) {
        return mapper.toDtos(rep.getRoomMoviePricesByRoomMovieId(id));
    }
}
