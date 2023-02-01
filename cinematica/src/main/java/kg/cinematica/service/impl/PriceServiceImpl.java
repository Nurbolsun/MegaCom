package kg.cinematica.service.impl;

import kg.cinematica.dao.PriceRep;
import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRep rep;
    Pri
    @Override
    public PriceDto save(PriceDto t) {
        return null;
    }

    @Override
    public PriceDto findById(Long id) {
        return null;
    }

    @Override
    public PriceDto delete(Long id) {
        return null;
    }

    @Override
    public List<PriceDto> findAll() {
        return null;
    }

    @Override
    public List<PriceDto> sortByDate() {
        return null;
    }
}
