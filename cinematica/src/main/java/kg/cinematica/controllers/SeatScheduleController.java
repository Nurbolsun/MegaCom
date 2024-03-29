package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.SeatDto;
import kg.cinematica.models.dto.SeatScheduleDto;
import kg.cinematica.models.requests.SeatRequest;
import kg.cinematica.models.requests.SeatScheduleRequest;
import kg.cinematica.models.response.SeatScheduleResponse;
import kg.cinematica.service.SeatScheduleService;
import kg.cinematica.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Место/Грфик")
@RestController
@RequestMapping("/api/v1/seat_schedule")
public class SeatScheduleController {
    @Autowired
    SeatScheduleService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> create(@RequestParam Long roomMovieId, @RequestParam List<Long> seatsId){
        try {
            return new ResponseEntity<>(service.create(roomMovieId, seatsId), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск место/график по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    @ApiOperation("Вывод всех")
    ResponseEntity<List<SeatScheduleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getByRoomMovieId")
    @ApiOperation("Поиск свободные месты по id сеанса")
    ResponseEntity<List<SeatScheduleResponse>> getByRoomMovieId(@RequestParam Long roomMovieId){
        return ResponseEntity.ok(service.getRoomMovieId(roomMovieId));
    }
}
