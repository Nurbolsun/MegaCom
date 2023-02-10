package kg.cinematica.service.impl;

import kg.cinematica.dao.RoomMoviePriceRep;
import kg.cinematica.enums.Type;
import kg.cinematica.mappers.RoomMoviePriceMapper;
import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.models.dto.RoomMovieDto;
import kg.cinematica.models.dto.RoomMoviePriceDto;
import kg.cinematica.models.requests.RoomMoviePriceRequest;
import kg.cinematica.models.response.*;
import kg.cinematica.service.PriceService;
import kg.cinematica.service.RoomMoviePriceService;
import kg.cinematica.service.RoomMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class RoomMoviePriceServiceImpl implements RoomMoviePriceService {
    @Autowired
    private RoomMoviePriceRep rep;
    RoomMoviePriceMapper mapper = RoomMoviePriceMapper.INSTANCE;
    @Autowired
    private PriceService priceService;
    @Autowired
    private RoomMovieService roomMovieService;

    private Type priceType;

    @Override
    public RoomMoviePriceDto save(RoomMoviePriceDto roomMoviePriceDto) {
        return mapper.toDto(rep.save(mapper.toEntity(roomMoviePriceDto)));
    }

    @Override
    public RoomMoviePriceDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Не найдено!")));
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
    public Response create(Long roomMovieId, List<Long> priceList) {
        RoomMovieDto roomMovieDto = roomMovieService.findById(roomMovieId);
        for (Long id: priceList){
            PriceDto priceDto = priceService.findById(id);
            RoomMoviePriceDto roomMoviePriceDto = new RoomMoviePriceDto();
            roomMoviePriceDto.setRoomMovie(roomMovieDto);
            roomMoviePriceDto.setPrice(priceDto);
            save(roomMoviePriceDto);
        }
        return new Response("Успешно сохранено!");
    }

    @Override
    public List<RoomMoviePriceDto> findPriceByMovieId(Long movieId, LocalDate startDate) {

        return mapper.toDtos(rep.findPriceByMovieId(movieId, startDate));
    }

    @Override
    public GetRoomMovieResponse getRoomMovieByMovieId(Long movieId, LocalDate startDate) {
        List<RoomMoviePriceDto> roomMoviePriceDtoList = findPriceByMovieId(movieId, startDate);
        List<RoomMovieDto> roomMovieDtos = roomMovieService.findRoomMovieByMovieId(movieId, startDate);
        List<RoomResponse> roomResponses = new ArrayList<>();
        for (RoomMovieDto roomMovieItem : roomMovieDtos){
            RoomResponse roomResponse = new RoomResponse();
            roomResponse.setRoomId(roomMovieItem.getRoom().getId());
            roomResponse.setName(roomMovieItem.getRoom().getName());
            List<RoomMovieResponse> roomMovieResponseList = new ArrayList<>();
            RoomMovieResponse roomMovieResponse = new RoomMovieResponse();
            for (RoomMoviePriceDto item: roomMoviePriceDtoList){
                if (roomMovieItem.getSchedule().getId().equals(item.getRoomMovie().getSchedule().getId())){
                    if (!roomMovieResponseList.isEmpty() && roomMovieResponseList.get((int)
                    roomMovieResponseList.stream().count() - 1).getId() == item.getRoomMovie().getId()){
                        roomMovieResponse = roomMovieResponseList.get((int) roomMovieResponseList.stream().count() - 1);
                        roomMovieResponseList.remove((int) roomMovieResponseList.stream().count()-1);
                    }else {
                        roomMovieResponse.setId(item.getRoomMovie().getId());
                    }
                    priceType = item.getPrice().getType();
                    switch (priceType){
                        case CHILD:
                            roomMovieResponse.setChildPrice(item.getPrice().getPrice());
                            roomMovieResponse.setStartTime(item.getRoomMovie().getSchedule().getStartTime());
                            break;
                        case STUDENT:
                            roomMovieResponse.setStudentPrice(item.getPrice().getPrice());
                            roomMovieResponse.setStartTime(item.getRoomMovie().getSchedule().getStartTime());
                            break;
                        case ADULT:
                            roomMovieResponse.setAdultPrice(item.getPrice().getPrice());
                            roomMovieResponse.setStartTime(item.getRoomMovie().getSchedule().getStartTime());
                            break;
                    }
                }
            }
            roomMovieResponseList.add(roomMovieResponse);
            for (RoomResponse response: roomResponses){
                if (response.getRoomId().equals(roomResponse.getRoomId())){
                    roomMovieResponseList.addAll(response.getRoomMovie());
                    roomResponses.remove(response);
                    break;
                }
            }
            roomResponse.setRoomMovie(roomMovieResponseList);
            roomResponses.add(roomResponse);
        }
        List<CinemaResponse> cinemaResponses = new ArrayList<>();
        boolean inList = false;
        for (RoomMovieDto item : roomMovieDtos){
          CinemaResponse cinemaResponse = new CinemaResponse();
          cinemaResponse.setName(item.getRoom().getCinema().getName());
          List<RoomResponse> newRoomResponse = new ArrayList<>();
          for (RoomResponse roomResponseItem: roomResponses){
              if (item.getRoom().getId().equals(roomResponseItem.getRoomId())){
                  for (RoomResponse roomResponse: newRoomResponse){
                      if (roomResponse.getRoomId().equals(item.getRoom().getId())){
                          List<RoomMovieResponse> list = roomResponse.getRoomMovie();
                          list.addAll(roomResponseItem.getRoomMovie());
                          newRoomResponse.remove(roomResponse);
                          roomResponseItem.setRoomMovie(list);
                          break;
                      }
                  }
                  newRoomResponse.add(roomResponseItem);
              }
          }
          for (CinemaResponse response: cinemaResponses){
              if (response.getName().equals(cinemaResponse.getName())){
                  inList = true;
                  newRoomResponse.addAll(response.getRooms());
                  cinemaResponses.remove(response);
                  break;
              }
          }
            Set<RoomResponse> hashSet = new HashSet<>(newRoomResponse);
          newRoomResponse.clear();
          newRoomResponse.addAll(hashSet);
          cinemaResponse.setRooms(newRoomResponse);
          cinemaResponses.add(cinemaResponse);
        }
        GetRoomMovieResponse getRoomMovieResponse = new GetRoomMovieResponse();
        for (RoomMoviePriceDto item: roomMoviePriceDtoList){
            getRoomMovieResponse.setCinema(cinemaResponses);
            getRoomMovieResponse.setMovieName(item.getRoomMovie().getMovie().getName());
            getRoomMovieResponse.setMoviePg(item.getRoomMovie().getMovie().getPg());
            getRoomMovieResponse.setMovieImage(item.getRoomMovie().getMovie().getImage());
            getRoomMovieResponse.setDefinition(item.getRoomMovie().getMovie().getDef());
            getRoomMovieResponse.setMovieRating(item.getRoomMovie().getMovie().getRating());
        }
        return getRoomMovieResponse;
    }
}
