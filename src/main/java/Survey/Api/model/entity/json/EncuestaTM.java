package Survey.Api.model.entity.json;

import Survey.Api.model.entity.CuadroEncuesta;
import Survey.Api.model.entity.db.ADPuntoEncuesta;
import Survey.Api.model.entity.db.CoDespachosEncuesta;
import Survey.Api.model.entity.db.FOcupacionEncuesta;


import java.io.Serializable;
import java.util.Date;


public class EncuestaTM implements Serializable{

    // Datos Básicos
    private Integer tipo;
    private String nombre_encuesta;
    private String aforador;
    private String identificador;
    private Date fecha_encuesta;
    private int id_realm;

    //Datos por encuesta
    private CuadroEncuesta ad_abordo; // ASCENSOS Y DESCENSOS TRONCAL ABORDO
    private FOcupacionEncuesta fr_ocupacion; // FRECUENCIA OCUPACIÓN
    private ADPuntoEncuesta ad_fijo; // FRECUENCIA OCUPACIÓN
    private CoDespachosEncuesta co_despacho; // CONTEO DESPACHOS

    public EncuestaTM() {
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNombre_encuesta() {
        return nombre_encuesta;
    }

    public void setNombre_encuesta(String nombre_encuesta) {
        this.nombre_encuesta = nombre_encuesta;
    }

    public String getAforador() {
        return aforador;
    }

    public void setAforador(String aforador) {
        this.aforador = aforador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Date getFecha_encuesta() {
        return fecha_encuesta;
    }

    public void setFecha_encuesta(Date fecha_encuesta) {
        this.fecha_encuesta = fecha_encuesta;
    }

    public CuadroEncuesta getAd_abordo() {
        return ad_abordo;
    }

    public void setAd_abordo(CuadroEncuesta ad_abordo) {
        this.ad_abordo = ad_abordo;
    }

    public FOcupacionEncuesta getFr_ocupacion() {
        return fr_ocupacion;
    }

    public void setFr_ocupacion(FOcupacionEncuesta fr_ocupacion) {
        this.fr_ocupacion = fr_ocupacion;
    }

    public int getId_realm() {
        return id_realm;
    }

    public void setId_realm(int id_realm) {
        this.id_realm = id_realm;
    }

    public ADPuntoEncuesta getAd_fijo() {
        return ad_fijo;
    }

    public void setAd_fijo(ADPuntoEncuesta ad_fijo) {
        this.ad_fijo = ad_fijo;
    }

    public CoDespachosEncuesta getCo_despacho() {
        return co_despacho;
    }

    public void setCo_despacho(CoDespachosEncuesta co_despacho) {
        this.co_despacho = co_despacho;
    }
}
