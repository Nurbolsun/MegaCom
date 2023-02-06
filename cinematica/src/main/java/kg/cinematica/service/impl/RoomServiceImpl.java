package kg.cinematica.service.impl;

import kg.cinematica.dao.RoomRep;
import kg.cinematica.mappers.RoomMapper;
import kg.cinematica.models.dto.CinemaDto;
import kg.cinematica.models.dto.RoomDto;
import kg.cinematica.models.requests.RoomRequest;
import kg.cinematica.service.CinemaService;
import kg.cinematica.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRep rep;

    RoomMapper mapper = RoomMapper.INSTANCE;

    @Autowired
    private CinemaService cinemaService;

    @Override
    public RoomDto save(RoomDto roomDto) {
        return mapper.toDto(rep.save(mapper.toEntity(roomDto)));
    }

    @Override
    public RoomDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Зал не найден!")));
    }

    @Override
    public RoomDto delete(Long id) {
        RoomDto roomDto = findById(id);
        roomDto.setActive(false);
        return save(roomDto);
    }

    @Override
    public List<RoomDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<RoomDto> sortByDate() {
        return null;
    }

    @Override
    public RoomDto create(RoomRequest roomRequest) {
        CinemaDto cinemaDto = cinemaService.findById(roomRequest.getCinemaId());

        RoomDto room = new RoomDto();
        room.setName(roomRequest.getName());
        room.setCinema(cinemaDto);
        return save(room);
    }
}
