package app.rk3.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class Generate204Controller {

    @GetMapping(path = "/generate_204")
    public Map generate204(HttpServletResponse response) {
        response.setStatus(HttpStatus.NO_CONTENT.value());
        return null;
    }

}
