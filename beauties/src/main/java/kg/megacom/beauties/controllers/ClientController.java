package kg.megacom.beauties.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.beauties.models.dtos.ClientDto;
import kg.megacom.beauties.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Клиент")
@RestController
@RequestMapping("api/v1/client")
public class ClientController {
    @Autowired
    private ClientServices service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ClientDto save(@RequestBody ClientDto client){
        return service.save(client);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск клиента по id")
    ClientDto findById(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех клиентов")
    List<ClientDto> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ClientDto delete(@RequestParam Long id){
        return service.delete(id);
    }


}
