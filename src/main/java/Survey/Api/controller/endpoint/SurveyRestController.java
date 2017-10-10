package Survey.Api.controller.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SurveyRestController {



    @RequestMapping(value = "/test/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> listAllUsers() {
        List<String> prueba = new ArrayList<>();
        prueba.add("Hola");
        return new ResponseEntity<List<String>>(prueba, HttpStatus.OK);
    }
}
