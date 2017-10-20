package Survey.Api.controller.processor;

import Survey.Api.controller.services.EncuestaAscDescServicio;
import Survey.Api.model.entity.CuadroEncuesta;
import Survey.Api.model.entity.EncuestasTerminadas;
import Survey.Api.model.entity.RegistroEncuestaAscDesc;
import Survey.Api.model.entity.Resultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GuardarDatosEncuesta {

    @Autowired
    EncuestaAscDescServicio encuestaAscDescServicio;

    public List<Resultado> guardarDatosAscDescTroncal(EncuestasTerminadas encuestas){
        List<Resultado> resultados = new ArrayList<>();
        for(CuadroEncuesta cuadroEncuesta:encuestas.getEncuestas()){
            resultados.add(guardarEncuesta(cuadroEncuesta));
        }

        return resultados;
    }

    public Resultado guardarEncuesta(CuadroEncuesta cuadroEncuesta){
        Resultado resultado = new Resultado();
        try{
            encuestaAscDescServicio.addCuadroEncuesta(cuadroEncuesta);
            List<RegistroEncuestaAscDesc> registros = cuadroEncuesta.getRegistros();
            for(RegistroEncuestaAscDesc registro:registros){
                registro.setCuadroEncuesta(cuadroEncuesta);
                encuestaAscDescServicio.addRegistroEncuestaAscDesc(registro);
            }
            resultado.setMensaje(Responses.response_encuesta_guardada);
            resultado.setStatus(Responses.response_ok);
            resultado.setId(cuadroEncuesta.getId_realm());

        }catch(Exception e){
            resultado.setMensaje(e.getMessage());
            resultado.setStatus(Responses.response_error);
            resultado.setId(-1);
        }
        return resultado;
    }
}
