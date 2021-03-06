package Survey.Api.model.entity.json;

import Survey.Api.model.entity.CuadroEncuesta;
import Survey.Api.model.entity.db.*;


import java.io.Serializable;
import java.util.Date;


public class EncuestaTM implements Serializable{

    // Datos Básicos
    private Integer tipo;
    private String nombre_encuesta;
    private String aforador;
    private String identificador;
    private String dia_semana;
    private Date fecha_encuesta;
    private int id_realm;

    //Datos por encuesta
    private CuadroEncuesta ad_abordo; // ASCENSOS Y DESCENSOS TRONCAL ABORDO
    private FOcupacionEncuesta fr_ocupacion; // FRECUENCIA OCUPACIÓN
    private ADPuntoEncuesta ad_fijo; // FRECUENCIA OCUPACIÓN
    private CoDespachosEncuesta co_despacho; // CONTEO DESPACHOS
    private ODEncuesta od_encuesta; // ORIGEN DESTINO
    private FOBus fr_bus; // FRECUENCIA OCUPACION CON NUMERO DE BUS
    private TRecorridosEncuesta ti_recorridos; // TIEMPOS DE RECORRIDO


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

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public ODEncuesta getOd_encuesta() {
        return od_encuesta;
    }

    public void setOd_encuesta(ODEncuesta od_encuesta) {
        this.od_encuesta = od_encuesta;
    }

    public FOBus getFr_bus() {
        return fr_bus;
    }

    public void setFr_bus(FOBus fr_bus) {
        this.fr_bus = fr_bus;
    }

    public TRecorridosEncuesta getTi_recorridos() {
        return ti_recorridos;
    }

    public void setTi_recorridos(TRecorridosEncuesta ti_recorridos) {
        this.ti_recorridos = ti_recorridos;
    }
}
