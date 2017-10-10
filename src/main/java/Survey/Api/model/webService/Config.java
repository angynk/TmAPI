package Survey.Api.model.webService;

import java.util.List;


public class Config {

    private List<Servicio> servicios;

    public Config() {
    }

    public Config(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
