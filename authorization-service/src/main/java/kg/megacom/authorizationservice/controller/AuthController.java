package kg.megacom.authorizationservice.controller;

import kg.megacom.authorizationservice.models.dtos.AccountDto;
import kg.megacom.authorizationservice.models.request.AuthRequest;
import kg.megacom.authorizationservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AccountService service;

    @PostMapping("/sign/in")
    String auth(@RequestBody AuthRequest request) {
        return service.auth(request);
    }

    @GetMapping("/get/by/name")
    AccountDto getByUserName(@RequestParam String name,
                             @RequestParam boolean active) {
        return service.findByUserName(name, active);
    }

    @GetMapping("/get/by/id")
    AccountDto getByUserId(@RequestParam Long id) {
        return service.getByUserId(id);
    }
}
