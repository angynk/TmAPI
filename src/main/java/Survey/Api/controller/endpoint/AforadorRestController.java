package Survey.Api.controller.endpoint;

import Survey.Api.controller.services.LoginServicio;
import Survey.Api.model.entity.EncuestasTerminadas;
import Survey.Api.model.entity.Resultado;
import Survey.Api.model.entity.db.Aforador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class AforadorRestController {

    @Autowired
    LoginServicio loginServicio;

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity<Boolean> login(@RequestBody Aforador aforador) {
        boolean resultado = loginServicio.iniciarSesion(aforador.getUsuario(), aforador.getContrasena());
        return new ResponseEntity<Boolean>(resultado, HttpStatus.OK);
    }


}
