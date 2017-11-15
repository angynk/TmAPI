package Survey.Api.model.entity.json;


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
