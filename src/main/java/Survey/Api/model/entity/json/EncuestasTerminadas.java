package Survey.Api.model.entity.json;

import Survey.Api.model.entity.CuadroEncuesta;

import java.util.List;


public class EncuestasTerminadas {

    private List<EncuestaTM> encuestas;

    public EncuestasTerminadas() {
    }

    public List<EncuestaTM> getEncuestas() {
        return encuestas;
    }

    public void setEncuestas(List<EncuestaTM> encuestas) {
        this.encuestas = encuestas;
    }
}
