package Survey.Api.controller.processor;

import Survey.Api.controller.services.ServicioEstacionServicio;
import Survey.Api.model.entity.Servicio;
import Survey.Api.model.entity.db.Estacion;
import Survey.Api.model.entity.db.ServicioEstacion;
import Survey.Api.model.entity.db.ServicioTs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConfiguracionEncuesta {

    @Autowired
    private ServicioEstacionServicio servicioEstacionServicio;

    public List<Servicio> cargarInfoServicios(){
        List<Servicio> servicios = new ArrayList<>();
        List<ServicioTs> todosLosServicios = servicioEstacionServicio.encontrarTodosLosServicios();
        for(ServicioTs servicioTs:todosLosServicios) {
            List<String> listaEstaciones = encontrarEstacionesPorServicio(servicioTs);
            if(listaEstaciones.size()>0){
                servicios.add(new Servicio(servicioTs.getNombre(),listaEstaciones));
            }
        }
        return servicios;
    }

    private List<String> encontrarEstacionesPorServicio(ServicioTs servicioTs) {
        List<String> estaciones = new ArrayList<>();
        List<ServicioEstacion> estacionsAsociadas = servicioEstacionServicio.encontrarEstacionesAsociadas(servicioTs);
        for(ServicioEstacion servicioEstacion:estacionsAsociadas){
            estaciones.add(servicioEstacion.getEstacion().getNombre());
        }
        return estaciones;
    }

    public List<Servicio> generarInfoServicios(){
        List<Servicio> servicios = new ArrayList<>();
        Servicio b11 = new Servicio("B11",estacionesB11());
        Servicio k10 = new Servicio("K10",estacionesK10());
        servicios.add(b11);
        servicios.add(k10);
        return servicios;
    }

    public List<String> estacionesB11(){
        List<String> estaciones = new ArrayList<>();
        estaciones.add("Portal Sur");
        estaciones.add("Perdomo");
        estaciones.add("Madelena");
        estaciones.add("Sevillana");
        estaciones.add("Venecia");
        estaciones.add("Alquerìa");
        estaciones.add("General Santander");
        estaciones.add("Sena");
        estaciones.add("Santa Isabel");
        estaciones.add("Comuneros");
        return estaciones;
    }

    public List<String> estacionesK10(){
        List<String> estaciones = new ArrayList<>();
        estaciones.add("Portal 20 de Julio");
        estaciones.add("Country Sur");
        estaciones.add("Av 1 Mayo");
        estaciones.add("Ciudad Jardin");
        estaciones.add("Policarpa");
        estaciones.add("Hospitales");
        estaciones.add("Bicentenario");
        estaciones.add("Tercer Milenio");
        estaciones.add("Av Jimenez");
        estaciones.add("Calle 19");

        return estaciones;
    }
}
