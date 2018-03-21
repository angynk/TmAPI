package Survey.Api.controller.endpoint;

import Survey.Api.controller.processor.ConfiguracionEncuesta;
import Survey.Api.controller.services.ModoServicio;
import Survey.Api.model.entity.Config;
import Survey.Api.model.entity.ConfigModo;
import Survey.Api.model.entity.Servicio;
import Survey.Api.model.entity.db.*;
import Survey.Api.model.entity.db.Modo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigRestController {

    @Autowired
    public ConfiguracionEncuesta configuracionEncuesta;



    @RequestMapping(value = "/servicios/", method = RequestMethod.GET)
    public ResponseEntity<List<Servicio>> getServiciosEstacionesConfiguration() {
        List<Servicio> servicios = configuracionEncuesta.cargarInfoServicios("");
        return new ResponseEntity<List<Servicio>>(servicios, HttpStatus.OK);
    }

    @RequestMapping(value = "/servicioEstaciones/", method = RequestMethod.GET)
    public ResponseEntity<Config> getServiciosEstaciones(@RequestParam("modo") String modo) {
        Config config = configuracionEncuesta.getConfiguracion(modo);
        return new ResponseEntity<Config>(config, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateServicios/", method = RequestMethod.GET)
    public ResponseEntity<Boolean> updateServiciosEstaciones(@RequestParam("modo") String modo) {
        configuracionEncuesta.updateServicios(modo);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


    @RequestMapping(value = "/modos/", method = RequestMethod.GET)
    public ResponseEntity<ConfigModo> getModos() {
        ConfigModo config = configuracionEncuesta.getConfiguracionModos();
        return new ResponseEntity<ConfigModo>(config, HttpStatus.OK);
    }

}
