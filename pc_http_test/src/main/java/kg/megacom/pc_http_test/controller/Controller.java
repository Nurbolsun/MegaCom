package kg.megacom.pc_http_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/controller")
public class Controller {
    @GetMapping("/getHome")
    public String getHome(){
        return "HomePage 1 for my students";
    }
    @GetMapping("/getMessage")
    public String getMessage(){
        return "My first message HELLO";
    }
}
