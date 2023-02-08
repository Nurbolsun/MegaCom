package kg.cinematica.service.impl;

import kg.cinematica.dao.RoomMovieRep;
import kg.cinematica.mappers.RoomMovieMapper;
import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.models.dto.RoomDto;
import kg.cinematica.models.dto.RoomMovieDto;
import kg.cinematica.models.dto.ScheduleDto;
import kg.cinematica.models.requests.RoomMovieRequest;
import kg.cinematica.models.response.Response;
import kg.cinematica.service.MovieService;
import kg.cinematica.service.RoomMovieService;
import kg.cinematica.service.RoomService;
import kg.cinematica.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class RoomMovieServiceImpl implements RoomMovieService {
    @Autowired
    private RoomMovieRep rep;
    RoomMovieMapper mapper =RoomMovieMapper.INSTANCE;
    @Autowired
    private RoomService roomService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ScheduleService scheduleService;

    @Override
    public RoomMovieDto save(RoomMovieDto roomMovieDto) {
        return mapper.toDto(rep.save(mapper.toEntity(roomMovieDto)));
    }

    @Override
    public RoomMovieDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Не найден!")));
    }

    @Override
    public RoomMovieDto delete(Long id) {
        return null;
    }

    @Override
    public List<RoomMovieDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }


    @Override
    public Response create(RoomMovieRequest roomMovieRequest) {
        RoomDto roomDto = roomService.findById(roomMovieRequest.getRoomId());
        MovieDto movieDto = movieService.findById(roomMovieRequest.getMovieId());
        ScheduleDto scheduleDto = scheduleService.findById(roomMovieRequest.getScheduleId());

        RoomMovieDto roomMovieDto = new RoomMovieDto();
        roomMovieDto.setMovie(movieDto);
        roomMovieDto.setRoom(roomDto);
        roomMovieDto.setSchedule(scheduleDto);
        save(roomMovieDto);
        return new Response("Успешно сохранено!");
    }

    @Override
    public List<RoomMovieDto> findRoomMovieByMovieId(Long movieId, LocalDate startDate) {
        return mapper.toDtos(rep.findRoomMovieByMovieId(movieId, startDate));
    }
}
