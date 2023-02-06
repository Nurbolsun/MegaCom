package kg.cinematica.service.impl;

import kg.cinematica.dao.RoomMoviePriceRep;
import kg.cinematica.mappers.RoomMoviePriceMapper;
import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.models.dto.RoomMovieDto;
import kg.cinematica.models.dto.RoomMoviePriceDto;
import kg.cinematica.models.requests.RoomMoviePriceRequest;
import kg.cinematica.service.PriceService;
import kg.cinematica.service.RoomMoviePriceService;
import kg.cinematica.service.RoomMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomMoviePriceServiceImpl implements RoomMoviePriceService {
    @Autowired
    private RoomMoviePriceRep rep;
    RoomMoviePriceMapper mapper = RoomMoviePriceMapper.INSTANCE;
    @Autowired
    private PriceService priceService;
    @Autowired
    private RoomMovieService roomMovieService;

    @Override
    public RoomMoviePriceDto save(RoomMoviePriceDto roomMoviePriceDto) {
        return mapper.toDto(rep.save(mapper.toEntity(roomMoviePriceDto)));
    }

    @Override
    public RoomMoviePriceDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Не найден!")));
    }

    @Override
    public RoomMoviePriceDto delete(Long id) {
        return null;
    }

    @Override
    public List<RoomMoviePriceDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<RoomMoviePriceDto> sortByDate() {
        return null;
    }

    @Override
    public RoomMoviePriceDto create(RoomMoviePriceRequest roomMoviePriceRequest) {
        PriceDto priceDto = priceService.findById(roomMoviePriceRequest.getPriceId());
        RoomMovieDto roomMovieDto = roomMovieService.findById(roomMoviePriceRequest.getRoomMovieId());
        RoomMoviePriceDto roomMoviePriceDto = new RoomMoviePriceDto();
        roomMoviePriceDto.setPrice(priceDto);
        roomMoviePriceDto.setRoomMovie(roomMovieDto);
        return save(roomMoviePriceDto);
    }
}
