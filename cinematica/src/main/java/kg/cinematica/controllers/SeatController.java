package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.OrderDto;
import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.models.dto.ScheduleDto;
import kg.cinematica.models.dto.SeatDto;
import kg.cinematica.models.entities.Seat;
import kg.cinematica.models.requests.OrderRequest;
import kg.cinematica.models.requests.PriceRequest;
import kg.cinematica.models.requests.SeatRequest;
import kg.cinematica.service.ScheduleService;
import kg.cinematica.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.List;

@Api(tags = "Место/ряд")
@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {
    @Autowired
    SeatService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> create(@ModelAttribute SeatRequest seat){
        try {
            return new ResponseEntity<>(service.create(seat), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск место по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    @ApiOperation("Вывод всех мест")
    ResponseEntity<List<SeatDto>> findAll() {
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

}
