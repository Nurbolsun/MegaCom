package kg.megacom.authorizationservice.controller;

import io.swagger.annotations.Api;
import kg.megacom.authorizationservice.models.dtos.AccountDto;
import kg.megacom.authorizationservice.models.dtos.UsersDto;
import kg.megacom.authorizationservice.models.entities.Account;
import kg.megacom.authorizationservice.models.entities.Users;
import kg.megacom.authorizationservice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Пользователь")
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UsersService service;

    @PostMapping("/save")
    UsersDto save(@RequestBody UsersDto users){
        return service.save(users);
    }

    @GetMapping("/findById")
    UsersDto findById(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/findAll")
    List<UsersDto> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/delete")
    UsersDto delete(@RequestParam Long id) {
        return service.delete(id);
    }

    @PostMapping("/get/by/acc")
    UsersDto findByAcc(@RequestBody AccountDto account) {
        return service.findByAccount(account);
    }
}
