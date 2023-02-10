package kg.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.cinematica.enums.Type;
import kg.cinematica.models.dto.OrderDto;
import kg.cinematica.models.requests.OrderRequest;
import kg.cinematica.models.response.OrderResponse;
import kg.cinematica.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Api(tags = "Заказать")
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestParam OrderDto order) throws ParseException {

        return new ResponseEntity<>(service.save(order), HttpStatus.CREATED);
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    @ApiOperation("Вывод всех заказов")
    ResponseEntity<List<OrderDto>> findAll() {
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
    @PostMapping("/book")
    @ApiOperation("Бронирование")
    ResponseEntity<OrderResponse> book (@RequestParam Long roomMovieId, @RequestBody Map<Long, Type> seatAndPrice){
        return new ResponseEntity<>(service.book(roomMovieId, seatAndPrice), HttpStatus.CREATED);
    }
}
