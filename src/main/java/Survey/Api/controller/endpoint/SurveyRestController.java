package Survey.Api.controller.endpoint;

import Survey.Api.model.webService.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyRestController {



    @RequestMapping(value = "/new/", method = RequestMethod.POST)
    public ResponseEntity<Resultado> sendSurveys(@RequestBody CuadroEncuesta cuadroEncuesta) {
        Resultado resultado = new Resultado();
        resultado.setMensaje(cuadroEncuesta.getServicio());
        crearArchivoTemporal(cuadroEncuesta);
        return new ResponseEntity<Resultado>(resultado, HttpStatus.OK);
    }

    private void crearArchivoTemporal(CuadroEncuesta cuadroEncuesta) {
        File file = new File("C:\\Servicios.txt");

        try {
            if (file.createNewFile()){
                System.out.println("File is created!");
            }else{
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(file);
            writer.write("Test data \n");
            writer.write("Servicio: "+cuadroEncuesta.getServicio());
            writer.write("\n");
            writer.write("Dia de la Semana: "+cuadroEncuesta.getDia_semana());
            writer.write("\n");
            writer.write("Numero Bus: "+cuadroEncuesta.getNum_bus());
            writer.write("\n");
            writer.write("Numero Puerta: "+cuadroEncuesta.getNum_puerta());
            writer.write("\n");
            writer.write("Numero Registros: "+cuadroEncuesta.getRegistros().size());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


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
