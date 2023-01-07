package kg.megacom.beauties.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.beauties.models.dtos.SaloonDto;
import kg.megacom.beauties.services.SaloonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Салон")
@RestController
@RequestMapping("/api/v1/saloon")
public class SaloonController {
    @Autowired
    private SaloonService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save (@RequestBody SaloonDto saloon){
        try {
            return new ResponseEntity<>(service.save(saloon), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск по id")
    ResponseEntity<?> finById(@RequestParam Long id){
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
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
    @GetMapping("/findAll")
    @ApiOperation("Вывод всех салонов")
    ResponseEntity<List<SaloonDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
