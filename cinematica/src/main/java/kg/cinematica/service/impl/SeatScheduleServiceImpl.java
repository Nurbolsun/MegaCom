package kg.cinematica.service.impl;

import kg.cinematica.dao.SeatScheduleRep;
import kg.cinematica.enums.Status;
import kg.cinematica.mappers.SeatScheduleMapper;
import kg.cinematica.models.dto.RoomDto;
import kg.cinematica.models.dto.RoomMovieDto;
import kg.cinematica.models.dto.SeatDto;
import kg.cinematica.models.dto.SeatScheduleDto;
import kg.cinematica.models.response.SeatScheduleResponse;
import kg.cinematica.service.RoomMovieService;
import kg.cinematica.service.RoomService;
import kg.cinematica.service.SeatScheduleService;
import kg.cinematica.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    RoomService roomService;
    @Override
    public SeatScheduleDto save(SeatScheduleDto seatScheduleDto) {
        return mapper.toDto(rep.save(mapper.toEntity(seatScheduleDto)));
    }

    @Override
    public SeatScheduleDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Не найдено!")));
    }

    @Override
    public SeatScheduleDto delete(Long id) {
        SeatScheduleDto seatScheduleDto =findById(id);
        seatScheduleDto.setActive(false);
        return save(seatScheduleDto);
    }

    @Override
    public List<SeatScheduleDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }


    @Override
    public SeatScheduleDto create(Long roomMovieId, List<Long> seatsId) {
        RoomMovieDto roomMovieDto = rmServ.findById(roomMovieId);
        SeatScheduleDto seatScheduleDto = new SeatScheduleDto();
        for (Long id : seatsId){
            SeatDto seatDto = seatService.findById(id);
            seatScheduleDto.setRoomMovie(roomMovieDto);
            seatScheduleDto.setSeat(seatDto);
            seatScheduleDto.setStatus(Status.BOUGHT);
            save(seatScheduleDto);
        }
        return seatScheduleDto;
    }

    @Override
    public List<SeatScheduleDto> findByRoomMovieId(Long roomMovieId) {
        return mapper.toDtos(rep.findByRoomMovieId(roomMovieId));
    }

    @Override
    public List<SeatScheduleDto> findByRoomMovieAndSeatsId(Long movieId, Long roomMovieId) {

        return mapper.toDtos(rep.findByRoomMovieAndSeatsId(roomMovieId));
    }

    @Override
    public List<SeatScheduleResponse> getRoomMovieId(Long getroomMovieId) {
        List<SeatScheduleDto> seatScheduleDtos = findByRoomMovieId(getroomMovieId);
        List<SeatScheduleResponse> seatScheduleResponseList = new ArrayList<>();
        RoomDto roomDto = roomService.findRoomByRoomMovieId(getroomMovieId);
        List<SeatDto> seatDtos = seatService.findSeatsByRoomId(roomDto.getId());
        for (SeatDto seatDtoItem: seatDtos){
            SeatScheduleResponse seatScheduleResponse = new SeatScheduleResponse();
            if (seatScheduleDtos.isEmpty()){
                seatScheduleResponse.setSeatScheduleId(seatDtoItem.getId());
                seatScheduleResponse.setStatus(Status.FREE);
                seatScheduleResponse.setNum(seatDtoItem.getNum());
                seatScheduleResponse.setRow(seatDtoItem.getRow());
            }
            for (SeatScheduleDto seatScheduleItem : seatScheduleDtos){
                SeatScheduleDto seatScheduleDto = seatScheduleItem;
                if (seatDtoItem.getId().equals(seatScheduleDto.getSeat().getId())){
                    seatScheduleResponse.setSeatScheduleId(seatScheduleDto.getSeat().getId());
                    seatScheduleResponse.setStatus(seatScheduleItem.getStatus());
                    seatScheduleResponse.setNum(seatScheduleItem.getSeat().getNum());
                    seatScheduleResponse.setRow(seatScheduleItem.getSeat().getRow());
                    break;
                }else {
                    seatScheduleResponse.setSeatScheduleId(seatDtoItem.getId());
                    seatScheduleResponse.setStatus(Status.FREE);
                    seatScheduleResponse.setNum(seatDtoItem.getNum());
                    seatScheduleResponse.setRow(seatDtoItem.getRow());
                }
            }
            seatScheduleResponseList.add(seatScheduleResponse);
        }
        return seatScheduleResponseList;
    }
}
