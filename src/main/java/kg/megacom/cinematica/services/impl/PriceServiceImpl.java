package kg.megacom.cinematica.services.impl;

import kg.megacom.cinematica.dao.PriceRep;
import kg.megacom.cinematica.exceptions.PriceException;
import kg.megacom.cinematica.mappers.PriceMapper;
import kg.megacom.cinematica.models.dtos.PriceDto;
import kg.megacom.cinematica.models.enums.PriceTypeEnum;
import kg.megacom.cinematica.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRep rep;

    PriceMapper mapper = PriceMapper.INSTANCE;

    @Override
    public PriceDto save(PriceDto t) {
        return mapper.toDto(rep.save(mapper.toEntity(t)));
    }

    @Override
    public PriceDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new PriceException("Price not found")));
    }

    @Override
    public PriceDto delete(Long id) {
        PriceDto dto = findById(id);
        rep.delete(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<PriceDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

}
