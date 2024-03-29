package kg.mega.saloon.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.saloon.enums.WorkDayEnum;
import kg.mega.saloon.models.dto.ScheduleDto;
import kg.mega.saloon.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Api(tags = "График")
@RestController
@RequestMapping("api/v1/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestParam WorkDayEnum workDayEnum,
                           @RequestParam @DateTimeFormat(pattern = "HH:mm:ss") LocalTime startTime,
                           @RequestParam @DateTimeFormat(pattern = "HH:mm:ss")LocalTime endTime) {

        try {
            return new ResponseEntity<>(service.create(workDayEnum,startTime,endTime), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск графика по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всего графика")
    ResponseEntity<List<ScheduleDto>> findAll() {
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

    @GetMapping("/getScheduleByMasterName")
    @ApiOperation("Вывод графика по имени мастера")
    ResponseEntity<?> getScheduleByMasterName(@RequestParam String name) {
        try {
            return new ResponseEntity<>(service.getScheduleByMasterName(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getScheduleByMasterId")
    @ApiOperation("Вывод графика по ID мастера")
    ResponseEntity<?> getScheduleByMasterId(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(service.getScheduleByMasterId(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}