package kg.cinematica.service.impl;

import kg.cinematica.dao.SeatScheduleRep;
import kg.cinematica.mappers.SeatScheduleMapper;
import kg.cinematica.models.dto.RoomMovieDto;
import kg.cinematica.models.dto.SeatDto;
import kg.cinematica.models.dto.SeatScheduleDto;
import kg.cinematica.models.requests.SeatScheduleRequest;
import kg.cinematica.service.RoomMovieService;
import kg.cinematica.service.RoomService;
import kg.cinematica.service.SeatScheduleService;
import kg.cinematica.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatScheduleServiceImpl implements SeatScheduleService {
    @Autowired
    private SeatScheduleRep rep;
    SeatScheduleMapper mapper = SeatScheduleMapper.INSTANCE;
    @Autowired
    private SeatService seatService;
    @Autowired
    private RoomMovieService rmServ;
    @Override
    public SeatScheduleDto save(SeatScheduleDto seatScheduleDto) {
        return mapper.toDto(rep.save(mapper.toEntity(seatScheduleDto)));
    }

    @Override
    public SeatScheduleDto findById(Long id) {
        return null;
    }

    @Override
    public SeatScheduleDto delete(Long id) {
        return null;
    }

    @Override
    public List<SeatScheduleDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<SeatScheduleDto> sortByDate() {
        return null;
    }

    @Override
    public SeatScheduleDto create(SeatScheduleRequest seatScheduleRequest) {
        SeatDto seatDto = seatService.findById(seatScheduleRequest.getSeatId());
        RoomMovieDto rmDto = rmServ.findById(seatScheduleRequest.getRoomMovieId());
        SeatScheduleDto seatScheduleDto = new SeatScheduleDto();
        seatScheduleDto.setStatus(seatScheduleRequest.getStatus());
        seatScheduleDto.setSeat(seatDto);
        seatScheduleDto.setRoomMovie(rmDto);
        return save(seatScheduleDto);
    }
}
