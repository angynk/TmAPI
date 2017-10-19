package Survey.Api.model.entity;


public class Estacion {

    private String nombre;

    public Estacion() {
    }

    public Estacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
