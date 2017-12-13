package Survey.Api.model.entity.json;


import java.io.Serializable;
import java.util.List;


public class EncuestasTerminadas implements Serializable{

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
