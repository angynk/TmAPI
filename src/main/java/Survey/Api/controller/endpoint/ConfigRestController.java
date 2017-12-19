package Survey.Api.controller.endpoint;

import Survey.Api.controller.processor.ConfiguracionEncuesta;
import Survey.Api.model.entity.Config;
import Survey.Api.model.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigRestController {

    @Autowired
    public ConfiguracionEncuesta configuracionEncuesta;

    @RequestMapping(value = "/servicios/", method = RequestMethod.GET)
    public ResponseEntity<List<Servicio>> getServiciosEstacionesConfiguration() {
        List<Servicio> servicios = configuracionEncuesta.cargarInfoServicios();
        return new ResponseEntity<List<Servicio>>(servicios, HttpStatus.OK);
    }

    @RequestMapping(value = "/serviciosEstaciones/", method = RequestMethod.GET)
    public ResponseEntity<Config> getServiciosEstaciones() {
        Config config = configuracionEncuesta.getConfig();
        return new ResponseEntity<Config>(config, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateServicios/", method = RequestMethod.GET)
    public ResponseEntity<Boolean> updateServiciosEstaciones() {
        configuracionEncuesta.updateServicios();
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

}
