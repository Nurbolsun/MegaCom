package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.models.dto.RoomDto;
import kg.cinematica.models.requests.RoomRequest;
import kg.cinematica.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Залы")
@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
    @Autowired
    private RoomService service;

    @PostMapping("/save")
    @ApiOperation(("Сохранение зал"))
    ResponseEntity<?> save (@ModelAttribute RoomRequest roomRequest){
        try {
            return new ResponseEntity<>(service.create(roomRequest), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск по id зала")
    ResponseEntity<?> findById(@RequestParam Long id){
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    @ApiOperation("Вывод все залы")
    ResponseEntity<List<RoomDto>> findAll(){
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
