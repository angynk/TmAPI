package Survey.Api.controller.processor;

import Survey.Api.controller.services.ServicioEstacionServicio;
import Survey.Api.model.entity.Config;
import Survey.Api.model.entity.EstacionTs;
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
                servicios.add(new Servicio(servicioTs.getNombre(),listaEstaciones,servicioTs.getTipo()));
            }
        }
        return servicios;
    }

    public List<EstacionTs> cargarServicios(){
        List<EstacionTs> estaciones = new ArrayList<>();
        List<Estacion> todasLasEstaciones = servicioEstacionServicio.encontrarTodasLasEstaciones();
        for(Estacion estacion:todasLasEstaciones){
            List<String> listaServicios = encontrarServiciosPorEstacion(estacion);
            if(listaServicios.size()>0){
                estaciones.add(new EstacionTs(estacion.getNombre(),estacion.getModo(),listaServicios));
            }
        }
        return estaciones;
    }

    private List<String> encontrarServiciosPorEstacion(Estacion estacion) {
        List<String> servicios = new ArrayList<>();
        List<ServicioEstacion> estacionsAsociadas = servicioEstacionServicio.encontrarServiciosAsociadas(estacion);
        for(ServicioEstacion servicioEstacion:estacionsAsociadas){
            servicios.add(servicioEstacion.getServicio().getNombre());
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

    public Config cargarTodosLosDatos() {

        Config config = new Config();
        List<Servicio> servicios = cargarInfoServicios();
        List<EstacionTs> estaaciones = cargarServicios();
        config.setEstacionTs(estaaciones);
        config.setServicios(servicios);

        return config;
    }
}
