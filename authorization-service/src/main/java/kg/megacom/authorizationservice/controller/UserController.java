package kg.megacom.authorizationservice.controller;

import io.swagger.annotations.Api;
import kg.megacom.authorizationservice.models.Users;
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
    Users save(@RequestBody Users users){
        return service.save(users);
    }

    @GetMapping("/findById")
    Users findById(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/findAll")
    List<Users> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/delete")
    Users delete(@RequestParam Long id) {
        return service.delete(id);
    }
}
