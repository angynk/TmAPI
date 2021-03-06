package Survey.Api.controller.endpoint;

import Survey.Api.controller.processor.GuardarDatosEncuesta;
import Survey.Api.controller.processor.QueueEncuesta;
import Survey.Api.model.entity.*;
import Survey.Api.model.entity.json.EncuestasTerminadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyRestController {

    @Autowired
    public GuardarDatosEncuesta guardarDatosEncuesta;

    @Autowired
    public QueueEncuesta queueEncuesta;

    @RequestMapping(value = "/new/", method = RequestMethod.POST)
    public ResponseEntity<List<Resultado>> sendSurveys(@RequestBody EncuestasTerminadas encuestas) {
          List<Resultado> resultados = queueEncuesta.sendEncuesta(encuestas);
        return new ResponseEntity<List<Resultado>>(resultados, HttpStatus.OK);
    }


}
