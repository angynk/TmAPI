package Survey.Api.model.entity;

import java.util.List;


public class EncuestasTerminadas {

    private List<CuadroEncuesta> encuestas;

    public EncuestasTerminadas() {
    }

    public List<CuadroEncuesta> getEncuestas() {
        return encuestas;
    }

    public void setEncuestas(List<CuadroEncuesta> encuestas) {
        this.encuestas = encuestas;
    }
}