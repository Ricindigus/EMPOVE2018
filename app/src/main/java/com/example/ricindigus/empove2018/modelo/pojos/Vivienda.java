package com.example.ricindigus.empove2018.modelo.pojos;

public class Vivienda {
    private int _id;
    private int anio;
    private int mes;
    private int periodo;
    private int conglomerado;
    private int norden;

    public Vivienda() {
    }

    public Vivienda(int _id, int anio, int mes, int periodo, int conglomerado, int norden) {
        this._id = _id;
        this.anio = anio;
        this.mes = mes;
        this.periodo = periodo;
        this.conglomerado = conglomerado;
        this.norden = norden;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getConglomerado() {
        return conglomerado;
    }

    public void setConglomerado(int conglomerado) {
        this.conglomerado = conglomerado;
    }

    public int getNorden() {
        return norden;
    }

    public void setNorden(int norden) {
        this.norden = norden;
    }
}
