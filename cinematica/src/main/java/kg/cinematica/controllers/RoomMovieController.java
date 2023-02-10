package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.RoomMovieDto;
import kg.cinematica.models.requests.RoomMovieRequest;
import kg.cinematica.service.RoomMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Сеанс")
@RestController
@RequestMapping("/api/v1/room_movie")
public class RoomMovieController {
    @Autowired
    private RoomMovieService service;

    @PostMapping("/save")
    @ApiOperation(("Сохранение фильма"))
    ResponseEntity<?> save (@ModelAttribute RoomMovieRequest movieRequest){
        try {
            return new ResponseEntity<>(service.create(movieRequest), HttpStatus.CREATED);
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
    @ApiOperation("Вывод всех сеансов")
    ResponseEntity<List<RoomMovieDto>> findAll(){
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
