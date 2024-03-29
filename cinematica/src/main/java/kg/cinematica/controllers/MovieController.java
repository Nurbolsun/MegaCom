package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.models.entities.Movie;
import kg.cinematica.models.requests.MovieRequest;
import kg.cinematica.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Фильмы")
@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService service;

    @PostMapping("/save")
    @ApiOperation(("Сохранение фильма"))
    ResponseEntity<?> save (@ModelAttribute MovieRequest movieRequest){
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
    @ApiOperation("Вывод все филмов")
    ResponseEntity<List<MovieDto>> findAll(){
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
    @GetMapping("/findAllByActiveIsTrue")
    @ApiOperation("LIMIT and OFFSET")
    ResponseEntity<List<MovieDto>> findAllByActiveIsTrue(@RequestParam int limit, int offset){
        return ResponseEntity.ok(service.findAllActiveWithLimitOffset(limit, offset));
    }

}
