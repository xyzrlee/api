package app.illl.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class Generate204 {

    @GetMapping(path = "/generate_204")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void generate204(HttpServletResponse response) {
    }

}
