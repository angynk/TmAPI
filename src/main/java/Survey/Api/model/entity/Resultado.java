package Survey.Api.model.entity;

/**
 * Created by nataly on 16/10/2017.
 */

public class Resultado {

    private String mensaje;
    private String status;
    private int id;

    public Resultado() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
