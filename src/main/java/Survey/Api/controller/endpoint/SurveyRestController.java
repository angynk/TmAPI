package Survey.Api.controller.endpoint;

import Survey.Api.model.webService.Config;
import Survey.Api.model.webService.Estacion;
import Survey.Api.model.webService.Resultado;
import Survey.Api.model.webService.Servicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class SurveyRestController {



    @RequestMapping(value = "/new/", method = RequestMethod.POST)
    public ResponseEntity<Resultado> sendSurveys() {
        Resultado resultado = new Resultado();
        resultado.setMensaje("Bien");
        System.out.println("Entre");
        return new ResponseEntity<Resultado>(resultado, HttpStatus.OK);
    }

    @RequestMapping(value = "/newD/", method = RequestMethod.POST)
    public Resultado senddATA() {
        Resultado resultado = new Resultado();
        resultado.setMensaje("Bien");
        System.out.println("Entre Nuevo");
        return resultado;
    }

    @RequestMapping(value = "/test/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> listAllUsers() {
        List<String> prueba = new ArrayList<>();
        prueba.add("Hola");
        return new ResponseEntity<List<String>>(prueba, HttpStatus.OK);
    }

    @RequestMapping(value = "/config/", method = RequestMethod.GET)
    public ResponseEntity<List<Config>> getAppConfiguration() {
        List<Config> prueba = new ArrayList<Config>();
        List<Servicio> servicios = new ArrayList<Servicio>();
        List<String> estaciones = new ArrayList<String>();
        estaciones.add("Portal 80");
        estaciones.add("Granja");
        estaciones.add("Minuto de Dios");
        servicios.add(new Servicio("D20",estaciones));
        prueba.add(new Config(servicios));
        return new ResponseEntity<List<Config>>(prueba, HttpStatus.OK);
    }
}
