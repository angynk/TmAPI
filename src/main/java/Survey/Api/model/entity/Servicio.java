package Survey.Api.model.entity;

import java.util.List;



public class Servicio {

    private String nombre;
    private List<String> estaciones;

    public Servicio() {
    }

    public Servicio(String nombre, List<String> estaciones) {
        this.nombre = nombre;
        this.estaciones = estaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(List<String> estaciones) {
        this.estaciones = estaciones;
    }
}
