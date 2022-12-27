package kg.megacom.authorizationservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.authorizationservice.models.dtos.AccountDto;
import kg.megacom.authorizationservice.models.entities.Account;
import kg.megacom.authorizationservice.models.request.AuthRequest;
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
    AccountDto save(@RequestBody AccountDto accountDto){
        return service.save(accountDto);
    }

    @PostMapping("/create")
    @ApiOperation("Создание аккаунта")
    String save(@RequestBody AuthRequest request){
        return service.create(request);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск аккаунта по ID")
    AccountDto findById(@RequestParam Long id){
        return service.findById(id);
    }



    @GetMapping("/findAll")
    @ApiOperation("Выыод всех аккаунтов")
    List<AccountDto> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    AccountDto delete(@RequestParam Long id) {
        return service.delete(id);
    }
}
