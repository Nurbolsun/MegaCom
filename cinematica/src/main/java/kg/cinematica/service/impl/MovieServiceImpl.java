package kg.cinematica.service.impl;

import kg.cinematica.dao.MovieRep;
import kg.cinematica.mappers.MovieMapper;
import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRep rep;
    MovieMapper mapper = MovieMapper.INSTANCE;

    @Override
    public MovieDto save(MovieDto movieDto) {
        return mapper.toDto(rep.save(mapper.toEntity(movieDto)));
    }

    @Override
    public MovieDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Фильм не найден!")));
    }

    @Override
    public MovieDto delete(Long id) {
        MovieDto movieDto = findById(id);
        movieDto.setActive(false);
        return save(movieDto);
    }

    @Override
    public List<MovieDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<MovieDto> sortByDate() {
        return null;
    }
}
