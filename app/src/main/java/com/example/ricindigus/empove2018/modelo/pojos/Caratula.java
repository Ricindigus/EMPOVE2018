package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Caratula {
    public static int _id;
    public static String nom_dep;
    public static String nom_prov;
    public static String nom_dist;
    public static String nom_ccpp;
    public static String zona;
    public static String manzana_id;
    public static String manzana_a;
    public static String aer_ini;
    public static String aer_fin;
    public static String vivienda;
    public static String tipvia;
    public static String nomvia;
    public static String nropta;
    public static String block;
    public static String interior;
    public static String piso;
    public static String mza;
    public static String lote;
    public static String km;
    public static String telefono;
    public static String t_hogar;

    public Caratula() {
    }

    public static int get_id() {
        return _id;
    }

    public static void set_id(int _id) {
        Caratula._id = _id;
    }

    public static String getNom_dep() {
        return nom_dep;
    }

    public static void setNom_dep(String nom_dep) {
        Caratula.nom_dep = nom_dep;
    }

    public static String getNom_prov() {
        return nom_prov;
    }

    public static void setNom_prov(String nom_prov) {
        Caratula.nom_prov = nom_prov;
    }

    public static String getNom_dist() {
        return nom_dist;
    }

    public static void setNom_dist(String nom_dist) {
        Caratula.nom_dist = nom_dist;
    }

    public static String getNom_ccpp() {
        return nom_ccpp;
    }

    public static void setNom_ccpp(String nom_ccpp) {
        Caratula.nom_ccpp = nom_ccpp;
    }

    public static String getZona() {
        return zona;
    }

    public static void setZona(String zona) {
        Caratula.zona = zona;
    }

    public static String getManzana_id() {
        return manzana_id;
    }

    public static void setManzana_id(String manzana_id) {
        Caratula.manzana_id = manzana_id;
    }

    public static String getManzana_a() {
        return manzana_a;
    }

    public static void setManzana_a(String manzana_a) {
        Caratula.manzana_a = manzana_a;
    }

    public static String getAer_ini() {
        return aer_ini;
    }

    public static void setAer_ini(String aer_ini) {
        Caratula.aer_ini = aer_ini;
    }

    public static String getAer_fin() {
        return aer_fin;
    }

    public static void setAer_fin(String aer_fin) {
        Caratula.aer_fin = aer_fin;
    }

    public static String getVivienda() {
        return vivienda;
    }

    public static void setVivienda(String vivienda) {
        Caratula.vivienda = vivienda;
    }

    public static String getTipvia() {
        return tipvia;
    }

    public static void setTipvia(String tipvia) {
        Caratula.tipvia = tipvia;
    }

    public static String getNomvia() {
        return nomvia;
    }

    public static void setNomvia(String nomvia) {
        Caratula.nomvia = nomvia;
    }

    public static String getNropta() {
        return nropta;
    }

    public static void setNropta(String nropta) {
        Caratula.nropta = nropta;
    }

    public static String getBlock() {
        return block;
    }

    public static void setBlock(String block) {
        Caratula.block = block;
    }

    public static String getInterior() {
        return interior;
    }

    public static void setInterior(String interior) {
        Caratula.interior = interior;
    }

    public static String getPiso() {
        return piso;
    }

    public static void setPiso(String piso) {
        Caratula.piso = piso;
    }

    public static String getMza() {
        return mza;
    }

    public static void setMza(String mza) {
        Caratula.mza = mza;
    }

    public static String getLote() {
        return lote;
    }

    public static void setLote(String lote) {
        Caratula.lote = lote;
    }

    public static String getKm() {
        return km;
    }

    public static void setKm(String km) {
        Caratula.km = km;
    }

    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        Caratula.telefono = telefono;
    }

    public static String getT_hogar() {
        return t_hogar;
    }

    public static void setT_hogar(String t_hogar) {
        Caratula.t_hogar = t_hogar;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.caratula_id,_id);
        contentValues.put(SQLConstantes.caratula_nom_dep,nom_dep);
        contentValues.put(SQLConstantes.caratula_nom_prov,nom_prov);
        contentValues.put(SQLConstantes.caratula_nom_dist,nom_dist);
        contentValues.put(SQLConstantes.caratula_nom_ccpp,nom_ccpp);
        contentValues.put(SQLConstantes.caratula_zona,zona);
        contentValues.put(SQLConstantes.caratula_manzana_id,manzana_id);
        contentValues.put(SQLConstantes.caratula_manzana_a,manzana_a);
        contentValues.put(SQLConstantes.caratula_aer_ini,aer_ini);
        contentValues.put(SQLConstantes.caratula_aer_fin,aer_fin);
        contentValues.put(SQLConstantes.caratula_vivienda,vivienda);
        contentValues.put(SQLConstantes.caratula_tipvia,tipvia);
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
        return contentValues;
    }
}
