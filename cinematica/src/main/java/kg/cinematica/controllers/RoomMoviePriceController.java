package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.RoomMoviePriceDto;
import kg.cinematica.models.requests.RoomMoviePriceRequest;
import kg.cinematica.service.RoomMoviePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Зал/Фильм/Цена")
@RestController
@RequestMapping("/api/v1/room_movie_price")
public class RoomMoviePriceController {
    @Autowired
    private RoomMoviePriceService service;

    @PostMapping("/save")
    @ApiOperation(("Сохранение"))
    ResponseEntity<?> save (@RequestParam Long roomMovieId, @RequestParam List<Long> priceId){
        try {
            return new ResponseEntity<>(service.create(roomMovieId, priceId), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск по id")
    ResponseEntity<?> findById(@RequestParam Long id){
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    @ApiOperation("Вывод всех")
    ResponseEntity<List<RoomMoviePriceDto>> findAll(){
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
