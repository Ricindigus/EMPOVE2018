package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Caratula {
    private int _id;
    private String anio;
    private String mes;
    private String periodo;
    private String conglomerado;
    private String nom_dep;
    private String nom_prov;
    private String nom_dist;
    private String nom_ccpp;
    private String zona;
    private String manzana_id;
    private String vivienda;
    private String latitud;
    private String longitud;
    private String tipvia;
    private String tipvia_o;
    private String nomvia;
    private String nropta;
    private String block;
    private String interior;
    private String piso;
    private String mza;
    private String lote;
    private String km;
    private String telefono;
    private String t_hogar;
    private String usuario;


    public Caratula() {
        _id = 0;
        anio="";
        mes="";
        periodo="";
        conglomerado="";
        nom_dep="";
        nom_prov="";
        nom_dist="";
        nom_ccpp="";
        zona="";
        manzana_id="";
        vivienda="";
        latitud="";
        longitud="";
        tipvia="";
        tipvia_o="";
        nomvia="";
        nropta="";
        block="";
        interior="";
        piso="";
        mza="";
        lote="";
        km="";
        telefono="";
        t_hogar="0";
        t_hogar="usuario";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getNom_dep() {
        return nom_dep;
    }

    public void setNom_dep(String nom_dep) {
        this.nom_dep = nom_dep;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public String getNom_dist() {
        return nom_dist;
    }

    public void setNom_dist(String nom_dist) {
        this.nom_dist = nom_dist;
    }

    public String getNom_ccpp() {
        return nom_ccpp;
    }

    public void setNom_ccpp(String nom_ccpp) {
        this.nom_ccpp = nom_ccpp;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getManzana_id() {
        return manzana_id;
    }

    public void setManzana_id(String manzana_id) {
        this.manzana_id = manzana_id;
    }

    public String getVivienda() {
        return vivienda;
    }

    public void setVivienda(String vivienda) {
        this.vivienda = vivienda;
    }

    public String getTipvia() {
        return tipvia;
    }

    public void setTipvia(String tipvia) {
        this.tipvia = tipvia;
    }

    public String getTipvia_o() {
        return tipvia_o;
    }

    public void setTipvia_o(String tipvia_o) {
        this.tipvia_o = tipvia_o;
    }

    public String getNomvia() {
        return nomvia;
    }

    public void setNomvia(String nomvia) {
        this.nomvia = nomvia;
    }

    public String getNropta() {
        return nropta;
    }

    public void setNropta(String nropta) {
        this.nropta = nropta;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getMza() {
        return mza;
    }

    public void setMza(String mza) {
        this.mza = mza;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getT_hogar() {
        return t_hogar;
    }

    public void setT_hogar(String t_hogar) {
        this.t_hogar = t_hogar;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.caratula_id,_id);
        contentValues.put(SQLConstantes.caratula_mes,mes);
        contentValues.put(SQLConstantes.caratula_anio,anio);
        contentValues.put(SQLConstantes.caratula_periodo,periodo);
        contentValues.put(SQLConstantes.caratula_conglomerado,conglomerado);
        contentValues.put(SQLConstantes.caratula_nom_dep,nom_dep);
        contentValues.put(SQLConstantes.caratula_nom_prov,nom_prov);
        contentValues.put(SQLConstantes.caratula_nom_dist,nom_dist);
        contentValues.put(SQLConstantes.caratula_nom_ccpp,nom_ccpp);
        contentValues.put(SQLConstantes.caratula_zona,zona);
        contentValues.put(SQLConstantes.caratula_manzana_id,manzana_id);
        contentValues.put(SQLConstantes.caratula_vivienda,vivienda);
        contentValues.put(SQLConstantes.caratula_longitud,longitud);
        contentValues.put(SQLConstantes.caratula_latitud,latitud);
        contentValues.put(SQLConstantes.caratula_tipvia,tipvia);
        contentValues.put(SQLConstantes.caratula_tipvia_o,tipvia_o);
        contentValues.put(SQLConstantes.caratula_nomvia,nomvia);
        contentValues.put(SQLConstantes.caratula_nropta,nropta);
        contentValues.put(SQLConstantes.caratula_block,block);
        contentValues.put(SQLConstantes.caratula_interior,interior);
        contentValues.put(SQLConstantes.caratula_piso,piso);
        contentValues.put(SQLConstantes.caratula_mza,mza);
        contentValues.put(SQLConstantes.caratula_lote,lote);
        contentValues.put(SQLConstantes.caratula_km,km);
        contentValues.put(SQLConstantes.caratula_telefono,telefono);
        contentValues.put(SQLConstantes.caratula_t_hogar,t_hogar);
        contentValues.put(SQLConstantes.caratula_usuario,usuario);
        return contentValues;
    }
}
