package kg.cinematica.service.impl;

import kg.cinematica.dao.CinemaRep;
import kg.cinematica.mappers.CinemaMapper;
import kg.cinematica.models.dto.CinemaDto;
import kg.cinematica.models.requests.CinemaRequest;
import kg.cinematica.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaRep rep;

    CinemaMapper mapper = CinemaMapper.INSTANCE;

    @Override
    public CinemaDto save(CinemaDto cinemaDto) {
        return mapper.toDto(rep.save(mapper.toEntity(cinemaDto)));
    }

    @Override
    public CinemaDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Кинотеатр не найден!")));
    }

    @Override
    public CinemaDto delete(Long id) {
        CinemaDto cinemaDto = findById(id);
        cinemaDto.setActive(false);
        return save(cinemaDto);
    }

    @Override
    public List<CinemaDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<CinemaDto> sortByDate() {
        return null;
    }

    @Override
    public CinemaDto create(CinemaRequest cinemaRequest) {
        CinemaDto cinemaDto = new CinemaDto();
        cinemaDto.setName(cinemaRequest.getName());
        cinemaDto.setAddress(cinemaRequest.getAddress());
        cinemaDto.setPhotoLink(cinemaRequest.getPhotoLink());
        return save(cinemaDto);
    }
}
