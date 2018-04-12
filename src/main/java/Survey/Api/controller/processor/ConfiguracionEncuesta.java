package Survey.Api.controller.processor;

import Survey.Api.controller.endpoint.Modo;
import Survey.Api.controller.services.ModoServicio;
import Survey.Api.controller.services.ServicioEstacionServicio;
import Survey.Api.model.entity.Config;
import Survey.Api.model.entity.ConfigModo;
import Survey.Api.model.entity.EstacionTs;
import Survey.Api.model.entity.Servicio;
import Survey.Api.model.entity.db.Estacion;
import Survey.Api.model.entity.db.ServicioEstacion;
import Survey.Api.model.entity.db.ServicioTs;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ConfiguracionEncuesta {

    @Autowired
    private ServicioEstacionServicio servicioEstacionServicio;

    @Autowired
    public ModoServicio modoServicio;

    @PostConstruct
    public void init(){
          actualizarListaConfiguracionModos();
    }

    private void actualizarListaConfiguracionModos() {
        cofiguracionModos = new HashMap<String, Config>();
        List<Survey.Api.model.entity.db.Modo> modosLista = modoServicio.getModoAll();
        for(Survey.Api.model.entity.db.Modo modo:modosLista){
            cofiguracionModos.put(modo.getAbreviatura(),cargarDatosModo(modo.getAbreviatura()));
        }
    }

    private Config cargarDatosModo(String modo) {
        Config config = new Config();
        List<Servicio> servicios = cargarInfoServicios(modo);
        List<EstacionTs> estaaciones = cargarServicios(modo);
        config.setEstacionTs(estaaciones);
        config.setServicios(servicios);
        return config;
    }

    private HashMap<String,Config> cofiguracionModos;

    private Config  configTroncal ;
    private Config  configTroncalOD ;
    private Config  configAlimentacion ;
    private Config  configZonal ;
    private Config  config;

    public List<Servicio> cargarInfoServicios(String modo){
        List<Servicio> servicios = new ArrayList<>();
        List<ServicioTs> todosLosServicios = servicioEstacionServicio.encontrarTodosLosServicios(modo);
        for(ServicioTs servicioTs:todosLosServicios) {
            List<String> listaEstaciones = encontrarEstacionesPorServicio(servicioTs);
            if(listaEstaciones.size()>0){
                servicios.add(new Servicio(servicioTs.getNombre(),listaEstaciones,servicioTs.getTipo()));
            }
        }
        return servicios;
    }

    public List<EstacionTs> cargarServicios(String modo){
        List<EstacionTs> estaciones = new ArrayList<>();
        List<Estacion> todasLasEstaciones = servicioEstacionServicio.encontrarTodasLasEstaciones(modo);
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

        config = new Config();
        List<Servicio> servicios = cargarInfoServicios("");
        List<EstacionTs> estaaciones = cargarServicios("");
        config.setEstacionTs(estaaciones);
        config.setServicios(servicios);

        return config;
    }

    public void cargarDatosTroncal(String modo){
        configTroncal = new Config();
        List<Servicio> servicios = cargarInfoServicios(modo);
        List<EstacionTs> estaaciones = cargarServicios(modo);
        configTroncal.setEstacionTs(estaaciones);
        configTroncal.setServicios(servicios);
    }

    public void cargarDatosAlimentacion(String modo){
        configAlimentacion = new Config();
        List<Servicio> servicios = cargarInfoServicios(modo);
        List<EstacionTs> estaaciones = cargarServicios(modo);
        configAlimentacion.setEstacionTs(estaaciones);
        configAlimentacion.setServicios(servicios);
    }

    public void cargarDatosTroncalOD(String modo){
        configTroncalOD = new Config();
        List<Servicio> servicios = cargarInfoServicios(modo);
        List<EstacionTs> estaaciones = cargarServicios(modo);
        configTroncalOD.setEstacionTs(estaaciones);
        configTroncalOD.setServicios(servicios);
    }

    public void cargarDatosZonal(String modo){
        configZonal = new Config();
        List<Servicio> servicios = cargarInfoServicios(modo);
        List<EstacionTs> estaaciones = cargarServicios(modo);
        configZonal.setEstacionTs(estaaciones);
        configZonal.setServicios(servicios);
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Config getConfigTroncal() {
        return configTroncal;
    }

    public void setConfigTroncal(Config configTroncal) {
        this.configTroncal = configTroncal;
    }

    public Config getConfigAlimentacion() {
        return configAlimentacion;
    }

    public void setConfigAlimentacion(Config configAlimentacion) {
        this.configAlimentacion = configAlimentacion;
    }

    public ServicioEstacionServicio getServicioEstacionServicio() {
        return servicioEstacionServicio;
    }

    public void setServicioEstacionServicio(ServicioEstacionServicio servicioEstacionServicio) {
        this.servicioEstacionServicio = servicioEstacionServicio;
    }

    public Config getConfigTroncalOD() {
        return configTroncalOD;
    }

    public void setConfigTroncalOD(Config configTroncalOD) {
        this.configTroncalOD = configTroncalOD;
    }

    public Config getConfigZonal() {
        return configZonal;
    }

    public void setConfigZonal(Config configZonal) {
        this.configZonal = configZonal;
    }

    public void updateServicios(String modo) {

        Config config = cargarDatosModo(modo);
        cofiguracionModos.remove(modo);
        cofiguracionModos.put(modo,config);
    }

    public Config getConfiguracion(String modo) {
        Config config = cofiguracionModos.get(modo);
        if(config==null){
            config = new Config();
        }
        return config;
    }

    public ConfigModo getConfiguracionModos() {
        ConfigModo configModo = new ConfigModo();
        List<Survey.Api.model.entity.db.Modo> modos = modoServicio.getModoAll();
        configModo.setModos(modos);
        return configModo;
    }

    public HashMap<String, Config> getCofiguracionModos() {
        return cofiguracionModos;
    }

    public void setCofiguracionModos(HashMap<String, Config> cofiguracionModos) {
        this.cofiguracionModos = cofiguracionModos;
    }
}
