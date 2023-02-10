package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.CinemaDto;
import kg.cinematica.models.requests.CinemaRequest;
import kg.cinematica.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Кинотеатр")
@RestController
@RequestMapping("/api/v1/cinema")
public class CinemaController {
    @Autowired
    private CinemaService service;

    @PostMapping
    @ApiOperation("Сохранение кинотеатра")
    ResponseEntity<?> save(@ModelAttribute CinemaRequest cinemaRequest){
        try {
            return new ResponseEntity<>(service.create(cinemaRequest), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск кинотеатр по ID")
    ResponseEntity<?> findById(@RequestParam Long id){
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    @ApiOperation("Вывод всех кинотеатров")
    ResponseEntity<List<CinemaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id){
        try {
            return ResponseEntity.ok(service.delete(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
