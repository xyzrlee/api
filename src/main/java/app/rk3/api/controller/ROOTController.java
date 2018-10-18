package app.rk3.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ROOTController {

    @RequestMapping("/")
    public String root() {
        return "ok";
    }

}
