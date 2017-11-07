package Survey.Api.controller.processor;

import Survey.Api.controller.services.EncuestaAscDescServicio;
import Survey.Api.model.entity.CuadroEncuesta;
import Survey.Api.model.entity.json.EncuestaTM;
import Survey.Api.model.entity.json.EncuestasTerminadas;
import Survey.Api.model.entity.RegistroEncuestaAscDesc;
import Survey.Api.model.entity.Resultado;
import Survey.Api.model.entity.json.TipoEncuesta;
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
        for(EncuestaTM encuestaTM:encuestas.getEncuestas()){
            Resultado resultado = new Resultado();
            if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_AD_ABORDO)){
               resultado = guardarEncuestaAscDescAbordo(encuestaTM.getAd_abordo(),encuestaTM);
            }else if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_FR_OCUPACION)){

            }

            resultados.add(resultado);

        }

        return resultados;
    }

    public Resultado guardarEncuestaAscDescAbordo(CuadroEncuesta cuadroEncuesta, EncuestaTM encuestaTM){
        Resultado resultado = new Resultado();
        try{
            cuadroEncuesta.setFecha_encuesta(encuestaTM.getFecha_encuesta());
            cuadroEncuesta.setNombre_encuesta(encuestaTM.getNombre_encuesta());
            cuadroEncuesta.setAforador(encuestaTM.getAforador());
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
