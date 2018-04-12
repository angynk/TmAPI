package Survey.Api.controller.processor;

import Survey.Api.controller.services.*;
import Survey.Api.model.entity.CuadroEncuesta;
import Survey.Api.model.entity.db.*;
import Survey.Api.model.entity.json.EncuestaTM;
import Survey.Api.model.entity.json.EncuestasTerminadas;
import Survey.Api.model.entity.RegistroEncuestaAscDesc;
import Survey.Api.model.entity.Resultado;
import Survey.Api.model.entity.json.TipoEncuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

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

    @Autowired
    ODencuestaServicio oDencuestaServicio;

    @Autowired
    FOBusServicio foBusServicio;

    @Autowired
    EncuestaTiemposRecorridoServicio tiemposRecorridoServicio;

    private static Logger log = Logger.getLogger(QueueEncuesta.class);

    public boolean guardarDatosEncuesta(EncuestaTM encuestaTM){
        log.info("Guardando datos encuesta "+encuestaTM.getTipo()+" de "+encuestaTM.getAforador());
        if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_AD_ABORDO)){
            guardarEncuestaAscDescAbordo(encuestaTM.getAd_abordo(),encuestaTM);
        }else if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_FR_OCUPACION)){
            guardarEncuestaFOcupacion(encuestaTM.getFr_ocupacion(),encuestaTM);
        }else if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_AD_PUNTO)){
            guardarEncuestaAscDesPunto(encuestaTM.getAd_fijo(),encuestaTM);
        }else if (encuestaTM.getTipo().equals(TipoEncuesta.ENC_CONT_DESPACHOS)){
            guardarEncuestasConteoDespachos(encuestaTM.getCo_despacho(),encuestaTM);
        }else if ( encuestaTM.getTipo().equals(TipoEncuesta.ENC_ORIGEN_DESTINO)){
            guardarEncuestasOrigenDestino(encuestaTM.getOd_encuesta(),encuestaTM);
        }else if( encuestaTM.getTipo().equals(TipoEncuesta.ENC_FR_OCUPACION_BUS)){
            guardarEncuestaFOcupacionBus(encuestaTM.getFr_bus(),encuestaTM);
        }else if( encuestaTM.getTipo().equals(TipoEncuesta.ENC_TIEMPOS_RECORRIDO)){
            guardarEncuestaTiemposRecorrido(encuestaTM.getTi_recorridos(),encuestaTM);
        }
        return true;
    }

    private void guardarEncuestaFOcupacionBus(FOBus fr_bus, EncuestaTM encuestaTM) {
        fr_bus.setFecha_encuesta(encuestaTM.getFecha_encuesta());
        fr_bus.setDia_semana(encuestaTM.getDia_semana());
        fr_bus.setAforador(encuestaTM.getAforador());
        foBusServicio.addFoBus(fr_bus);
        List<RegistroFOBus> registros = fr_bus.getRegistros();
        for(RegistroFOBus registroFOBus: registros){
            registroFOBus.setIdFoBus(fr_bus);
            foBusServicio.addFOBusRegistro(registroFOBus);
        }
    }

    private void guardarEncuestasOrigenDestino(ODEncuesta od_encuesta, EncuestaTM encuestaTM) {
        od_encuesta.setFecha_encuesta(encuestaTM.getFecha_encuesta());
        od_encuesta.setDia_semana(encuestaTM.getDia_semana());
        od_encuesta.setAforador(encuestaTM.getAforador());
        oDencuestaServicio.addODEncuesta(od_encuesta);
        List<ODRegistro> registros = od_encuesta.getRegistros();
        for(ODRegistro odRegistro: registros){
            odRegistro.setIdEncuesta(od_encuesta);
            oDencuestaServicio.addODRegistro(odRegistro);
            List<ODTransbordo> transbordos = odRegistro.getTransbordos();
            for(ODTransbordo transbordo:transbordos){
                transbordo.setOdRegistro(odRegistro);
                oDencuestaServicio.addODTransbordo(transbordo);
            }
        }
    }


    private Resultado guardarEncuestasConteoDespachos(CoDespachosEncuesta co_despacho, EncuestaTM encuestaTM) {
        Resultado resultado = new Resultado();
        try{
            co_despacho.setFecha_encuesta(encuestaTM.getFecha_encuesta());
            co_despacho.setAforador(encuestaTM.getAforador());
            co_despacho.setDia_semana(encuestaTM.getDia_semana());
            conteoDespachosServicio.addConteoDespachos(co_despacho);
            List<RegistroConteoDespacho> registros = co_despacho.getRegistros();
            for(RegistroConteoDespacho registro:registros){
                registro.setConteoDespacho(co_despacho);
                conteoDespachosServicio.addRegistroConteoDespachos(registro);
            }
            resultado = retornarResultadoPositivo(encuestaTM);

        }catch(Exception e){
            retornarResultadoNegativo(e,encuestaTM);

        }
        return resultado;
    }

    private Resultado guardarEncuestaTiemposRecorrido(TRecorridosEncuesta t_recorridos, EncuestaTM encuestaTM) {
        Resultado resultado = new Resultado();
        try{
            t_recorridos.setFecha_encuesta(encuestaTM.getFecha_encuesta());
            t_recorridos.setAforador(encuestaTM.getAforador());
            tiemposRecorridoServicio.addTiempoRecorridos(t_recorridos);
            List<RegistroTRecorridos> registros = t_recorridos.getRegistros();
            for(RegistroTRecorridos registro:registros){
                registro.settRecorridosEncuesta(t_recorridos);
                tiemposRecorridoServicio.addRegistroTiempoRecorridos(registro);
            }
            resultado = retornarResultadoPositivo(encuestaTM);

        }catch(Exception e){
            retornarResultadoNegativo(e,encuestaTM);
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
            retornarResultadoNegativo(e,encuestaTM);
        }
        return resultado;
    }

    private Resultado guardarEncuestaFOcupacion(FOcupacionEncuesta fr_ocupacion, EncuestaTM encuestaTM) {
        Resultado resultado = new Resultado();

        try{
            fr_ocupacion.setFecha_encuesta(encuestaTM.getFecha_encuesta());
            fr_ocupacion.setAforador(encuestaTM.getAforador());
            fr_ocupacion.setDia_semana(encuestaTM.getDia_semana());
            encuestaFOcupacionServicio.addFOcupacionEncuesta(fr_ocupacion);
            List<RegistroEncuestaFOcupacion> registros = fr_ocupacion.getRegistros();
            for(RegistroEncuestaFOcupacion registro: registros){
                registro.setfOcupacionEncuesta(fr_ocupacion);
                encuestaFOcupacionServicio.addRegFOcupacionEncuesta(registro);
            }
            resultado = retornarResultadoPositivo(encuestaTM);
        }catch (Exception e){
            retornarResultadoNegativo(e,encuestaTM);
        }
        return resultado;
    }

    public Resultado guardarEncuestaAscDescAbordo(CuadroEncuesta cuadroEncuesta, EncuestaTM encuestaTM){
        Resultado resultado = new Resultado();
        try{
            cuadroEncuesta.setFecha_encuesta(encuestaTM.getFecha_encuesta());
            cuadroEncuesta.setDia_semana(EncuestaUtil.obtenerDiaDeLaSemana(encuestaTM.getFecha_encuesta()));
            cuadroEncuesta.setNombre_encuesta(encuestaTM.getNombre_encuesta());
            cuadroEncuesta.setAforador(encuestaTM.getAforador());
            List<RegistroEncuestaAscDesc> registros = cuadroEncuesta.getRegistros();
            if(registros.size()>0){
                cuadroEncuesta.setHoraInicio(EncuestaUtil.getTimeFromString(registros.get(0).getHora_llegada()));
            }
            encuestaAscDescServicio.addCuadroEncuesta(cuadroEncuesta);

            for(RegistroEncuestaAscDesc registro:registros){
                registro.setCuadroEncuesta(cuadroEncuesta);
                encuestaAscDescServicio.addRegistroEncuestaAscDesc(registro);
            }
           resultado = retornarResultadoPositivo(encuestaTM);

        }catch(Exception e){
            retornarResultadoNegativo(e,encuestaTM);
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

    private Resultado retornarResultadoNegativo(Exception e,EncuestaTM encuestaTM){
        Resultado resultado = new Resultado();
        resultado.setMensaje(e.getMessage());
        resultado.setStatus(Responses.response_error);
        resultado.setId(-1);
        log.info("No se pudo guardar la encuesta "+encuestaTM.getTipo()+" de "+encuestaTM.getAforador());
        return resultado;
    }
}
