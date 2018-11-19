package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Hogar {
    private String _id;
    private String id_vivienda;
    private String numero;
    private String nom_ape;
    private String estado;
    private String nropersonas;
    private String vive;
    private String nroviven;
    private String principal;




    public Hogar() {
        _id = "";
        id_vivienda = "";
        numero = "";
        nom_ape = "";
        estado = "";
        nropersonas = "";
        vive = "";
        nroviven = "0";
        principal = "";
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId_vivienda() {
        return id_vivienda;
    }

    public void setId_vivienda(String id_vivienda) {
        this.id_vivienda = id_vivienda;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom_ape() {
        return nom_ape;
    }

    public void setNom_ape(String nom_ape) {
        this.nom_ape = nom_ape;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNropersonas() {
        return nropersonas;
    }

    public void setNropersonas(String nropersonas) {
        this.nropersonas = nropersonas;
    }

    public String getVive() {
        return vive;
    }

    public void setVive(String vive) {
        this.vive = vive;
    }

    public String getNroviven() {
        return nroviven;
    }

    public void setNroviven(String nroviven) {
        this.nroviven = nroviven;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.hogar_id,_id);
        contentValues.put(SQLConstantes.hogar_id_vivienda,id_vivienda);
        contentValues.put(SQLConstantes.hogar_numero,numero);
        contentValues.put(SQLConstantes.hogar_nom_ape,nom_ape);
        contentValues.put(SQLConstantes.hogar_estado,estado);
        contentValues.put(SQLConstantes.hogar_nropersonas,nropersonas);
        contentValues.put(SQLConstantes.hogar_vive,vive);
        contentValues.put(SQLConstantes.hogar_nroviven,nroviven);
        contentValues.put(SQLConstantes.hogar_principal,principal);
        return  contentValues;
    }
}

