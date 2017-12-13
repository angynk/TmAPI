package Survey.Api.controller.processor;

import Survey.Api.controller.queue.MessageSender;
import Survey.Api.model.entity.Resultado;
import Survey.Api.model.entity.json.EncuestaTM;
import Survey.Api.model.entity.json.EncuestasTerminadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueueEncuesta {

    @Autowired
    private MessageSender messageSender;

    public List<Resultado> sendEncuesta(EncuestasTerminadas encuestas) {
        List<Resultado>  resultados = new ArrayList<>();
        List<EncuestaTM> listaEncuestas = encuestas.getEncuestas();
        for(EncuestaTM encuestaTM:listaEncuestas){
            try{
                messageSender.sendMessage(encuestaTM);
                resultados.add(retornarResultadoPositivo(encuestaTM));
            }catch (Exception e){
                resultados.add(retornarResultadoNegativo(e));
            }
        }

        return resultados;
    }

    private Resultado retornarResultadoPositivo(EncuestaTM encuestaTM){
        Resultado resultado = new Resultado();
        resultado.setMensaje(Responses.response_encuesta_guardada);
        resultado.setStatus(Responses.response_ok);
        resultado.setId(encuestaTM.getId_realm());
        return resultado;
    }

    private Resultado retornarResultadoNegativo(Exception e){
        Resultado resultado = new Resultado();
        resultado.setMensaje(e.getMessage());
        resultado.setStatus(Responses.response_error);
        resultado.setId(-1);
        return resultado;
    }
}
