package kg.megacom.beauties.services.impl;

import kg.megacom.beauties.dao.SaloonRep;
import kg.megacom.beauties.mappers.SaloonMapper;
import kg.megacom.beauties.models.dtos.SaloonDto;
import kg.megacom.beauties.services.SaloonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaloonServiceImpl implements SaloonService {
    @Autowired
    private SaloonRep rep;
    SaloonMapper mapper = SaloonMapper.INSTANCE;

    @Override
    public SaloonDto save(SaloonDto saloonDto) {
        return mapper.toDto(rep.save(mapper.toEntity(saloonDto)));
    }

    @Override
    public SaloonDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Салон не найден")));
    }

    @Override
    public SaloonDto delete(Long id) {
        SaloonDto salon = findById(id);
        salon.setActive(false);
        return save(salon);
    }

    @Override
    public List<SaloonDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
