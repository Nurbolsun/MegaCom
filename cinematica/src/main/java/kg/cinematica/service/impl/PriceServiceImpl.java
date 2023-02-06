package kg.cinematica.service.impl;

import kg.cinematica.dao.PriceRep;
import kg.cinematica.mappers.PriceMapper;
import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.models.requests.PriceRequest;
import kg.cinematica.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRep rep;
    PriceMapper mapper = PriceMapper.INSTANCE;

    @Override
    public PriceDto save(PriceDto priceDto) {
        return mapper.toDto(rep.save(mapper.toEntity(priceDto)));
    }

    @Override
    public PriceDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("не найден!")));
    }

    @Override
    public PriceDto delete(Long id) {
        PriceDto priceDto = findById(id);
        priceDto.setActive(false);
        return save(priceDto);
    }

    @Override
    public List<PriceDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<PriceDto> sortByDate() {
        return null;
    }

    @Override
    public PriceDto create(PriceRequest priceRequest) {
        PriceDto priceDto = new PriceDto();
        priceDto.setPrice(priceRequest.getPrice());
        priceDto.setType(priceRequest.getType());
        return save(priceDto);
    }
}
