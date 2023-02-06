package kg.cinematica.service.impl;

import kg.cinematica.dao.SeatRep;
import kg.cinematica.mappers.SeatMapper;
import kg.cinematica.models.dto.RoomDto;
import kg.cinematica.models.dto.SeatDto;
import kg.cinematica.models.entities.Seat;
import kg.cinematica.models.requests.SeatRequest;
import kg.cinematica.service.RoomService;
import kg.cinematica.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRep rep;
    @Autowired
    RoomService roomService;

    SeatMapper mapper = SeatMapper.INSTANCE;

    @Override
    public SeatDto save(SeatDto seatDto) {
        return mapper.toDto(rep.save(mapper.toEntity(seatDto)));
    }

    @Override
    public SeatDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Место не найдено!")));
    }

    @Override
    public SeatDto delete(Long id) {
        SeatDto seatDto = findById(id);
        seatDto.setActive(false);
        return save(seatDto);
    }

    @Override
    public List<SeatDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<SeatDto> sortByDate() {
        return null;
    }

    @Override
    public SeatDto create(SeatRequest seatRequest) {
        RoomDto roomDto = roomService.findById(seatRequest.getRoomId());

        SeatDto seatDto = new SeatDto();
        seatDto.setNum(seatRequest.getNum());
        seatDto.setRow(seatRequest.getRow());
        seatDto.setRoom(roomDto);

        return save(seatDto);
    }

}
