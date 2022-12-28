package kg.megacom.beauties.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;
import kg.megacom.beauties.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Клиент")
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private ClientServices service;


}
