package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.models.requests.PriceRequest;
import kg.cinematica.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Цена")
@RestController
@RequestMapping("/api/v1/price")
public class PriceController {
    @Autowired
    private PriceService service;

    @PostMapping("/save")
    @ApiOperation(("Сохранение / цены"))
    ResponseEntity<?> create(@ModelAttribute PriceRequest priceRequest){
        try {
            return new ResponseEntity<>(service.create(priceRequest), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/findAll")
    @ApiOperation("Вывод всех цен")
    ResponseEntity<List<PriceDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

}
