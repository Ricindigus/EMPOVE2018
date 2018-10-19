package com.example.ricindigus.empove2018.modelo.pojos;

public class Vivienda {
    private int _id;
    private String anio;
    private String mes;
    private String periodo;
    private String conglomerado;
    private String norden;

    public Vivienda() {
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getConglomerado() {
        return conglomerado;
    }

    public void setConglomerado(String conglomerado) {
        this.conglomerado = conglomerado;
    }

    public String getNorden() {
        return norden;
    }

    public void setNorden(String norden) {
        this.norden = norden;
    }
}
