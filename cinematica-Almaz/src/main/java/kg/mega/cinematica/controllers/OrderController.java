package kg.mega.cinematica.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.cinematica.enums.PriceType;
import kg.mega.cinematica.models.dto.OrderDto;
import kg.mega.cinematica.models.responces.OrderResponse;
import kg.mega.cinematica.models.responces.Response;
import kg.mega.cinematica.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "Заказ")
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {


    private final OrderService service;
    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody OrderDto orderDto) {
            return new ResponseEntity<>(service.save(orderDto), HttpStatus.CREATED);
    }

    @PostMapping("/create")
    @ApiOperation("Заказ")
    ResponseEntity<OrderResponse> book(@RequestParam Long roomMovieId, @RequestBody Map<Long,PriceType> seatIdAndPriceType) {
        return new ResponseEntity<>(service.book(roomMovieId,seatIdAndPriceType), HttpStatus.CREATED);
    }


    @GetMapping("/findById")
    @ApiOperation("Поиск заказа по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return  ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод заказов")
    ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
            return ResponseEntity.ok(service.delete(id));
    }
}
