package kg.cinematica.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.models.dto.ScheduleDto;
import kg.cinematica.models.requests.ScheduleRequest;
import kg.cinematica.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Api(tags = "График")
@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save (@RequestParam (defaultValue = "HH:mm")@DateTimeFormat(pattern = "HH:mm") LocalTime startTime,
                            @RequestParam (defaultValue = "dd-MM-yyyy")@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate){
        try {
            return new ResponseEntity<>(service.create(startDate, startTime), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/findById")
    @ApiOperation("Найти график по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    @ApiOperation("Вывод всех график")
    ResponseEntity<List<ScheduleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление графика")
    ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
