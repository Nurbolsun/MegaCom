package kg.megacom.authorizationservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.authorizationservice.models.Account;
import kg.megacom.authorizationservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Аккаунт")
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService service;


    @PostMapping("/save")
    @ApiOperation("Сохранение")
    Account save(@RequestBody Account account){
        return service.save(account);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск аккаунта по ID")
    Account findById(@RequestParam Long id){
        return service.findById(id);
    }



    @GetMapping("/findAll")
    @ApiOperation("Выыод всех аккаунтов")
    List<Account> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    Account delete(@RequestParam Long id) {
        return service.delete(id);
    }
}
