package Survey.Api.controller.processor;

import Survey.Api.controller.services.ConteoDespachosServicio;
import Survey.Api.controller.services.EncuestaAscDescPuntoServicio;
import Survey.Api.controller.services.EncuestaAscDescServicio;
import Survey.Api.controller.services.EncuestaFOcupacionServicio;
import Survey.Api.model.entity.CuadroEncuesta;
import Survey.Api.model.entity.db.*;
import Survey.Api.model.entity.json.EncuestaTM;
import Survey.Api.model.entity.json.EncuestasTerminadas;
import Survey.Api.model.entity.RegistroEncuestaAscDesc;
import Survey.Api.model.entity.Resultado;
import Survey.Api.model.entity.json.TipoEncuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@Component
public class GuardarDatosEncuesta {

    @Autowired
    EncuestaAscDescServicio encuestaAscDescServicio;

    @Autowired
    EncuestaFOcupacionServicio encuestaFOcupacionServicio;

    @Autowired
    EncuestaAscDescPuntoServicio encuestaAscDescPuntoServicio;

    @Autowired
    ConteoDespachosServicio conteoDespachosServicio;

    public List<Resultado> guardarDatosAscDescTroncal(EncuestasTerminadas encuestas){
        List<Resultado> resultados = new ArrayList<>();
        for(EncuestaTM encuestaTM:encuestas.getEncuestas()){
            Resultado resultado = new Resultado();
            if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_AD_ABORDO)){
               resultado = guardarEncuestaAscDescAbordo(encuestaTM.getAd_abordo(),encuestaTM);
            }else if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_FR_OCUPACION)){
                resultado = guardarEncuestaFOcupacion(encuestaTM.getFr_ocupacion(),encuestaTM);
            }else if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_AD_PUNTO)){
                resultado = guardarEncuestaAscDesPunto(encuestaTM.getAd_fijo(),encuestaTM);
            }else if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_CONT_DESPACHOS)){
                resultado = guardarEncuestasConteoDespachos(encuestaTM.getCo_despacho(),encuestaTM);
            }

            resultados.add(resultado);

        }

        return resultados;
    }

    private Resultado guardarEncuestasConteoDespachos(CoDespachosEncuesta co_despacho, EncuestaTM encuestaTM) {
        Resultado resultado = new Resultado();
        try{
            co_despacho.setFecha_encuesta(encuestaTM.getFecha_encuesta());
            co_despacho.setAforador(encuestaTM.getAforador());
            conteoDespachosServicio.addConteoDespachos(co_despacho);
            List<RegistroConteoDespacho> registros = co_despacho.getRegistros();
            for(RegistroConteoDespacho registro:registros){
                registro.setConteoDespacho(co_despacho);
                conteoDespachosServicio.addRegistroConteoDespachos(registro);
            }
            resultado = retornarResultadoPositivo(encuestaTM);

        }catch(Exception e){
            retornarResultadoNegativo(e);
        }
        return resultado;
    }

    private Resultado guardarEncuestaAscDesPunto(ADPuntoEncuesta ad_fijo, EncuestaTM encuestaTM) {
        Resultado resultado = new Resultado();
        try{
            ad_fijo.setFecha_encuesta(encuestaTM.getFecha_encuesta());
            ad_fijo.setAforador(encuestaTM.getAforador());
            encuestaAscDescPuntoServicio.addADPuntoEncuesta(ad_fijo);
            List<RegistroEncuestaADPunto> registros = ad_fijo.getRegistros();
            for(RegistroEncuestaADPunto registro:registros){
                registro.setAdPuntoEncuesta(ad_fijo);
                encuestaAscDescPuntoServicio.addADRegPuntoEncuesta(registro);
            }
            resultado = retornarResultadoPositivo(encuestaTM);

        }catch(Exception e){
            retornarResultadoNegativo(e);
        }
        return resultado;
    }

    private Resultado guardarEncuestaFOcupacion(FOcupacionEncuesta fr_ocupacion, EncuestaTM encuestaTM) {
        Resultado resultado = new Resultado();

        try{
            fr_ocupacion.setFecha_encuesta(encuestaTM.getFecha_encuesta());
            fr_ocupacion.setAforador(encuestaTM.getAforador());
            encuestaFOcupacionServicio.addFOcupacionEncuesta(fr_ocupacion);
            List<RegistroEncuestaFOcupacion> registros = fr_ocupacion.getRegistros();
            for(RegistroEncuestaFOcupacion registro: registros){
                registro.setfOcupacionEncuesta(fr_ocupacion);
                encuestaFOcupacionServicio.addRegFOcupacionEncuesta(registro);
            }
            resultado = retornarResultadoPositivo(encuestaTM);
        }catch (Exception e){
            retornarResultadoNegativo(e);
        }
        return resultado;
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
           resultado = retornarResultadoPositivo(encuestaTM);

        }catch(Exception e){
            retornarResultadoNegativo(e);
        }
        return resultado;
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
