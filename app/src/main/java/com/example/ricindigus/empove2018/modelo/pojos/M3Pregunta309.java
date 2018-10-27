package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class M3Pregunta309 {
    private String _id;
    private String id_encuestado;
    private String c3_p309_p;
    private String c3_p309_c;
    private String c3_p309_mod;
    private String c3_p309_m;
    private String c3_p309_a;

    public M3Pregunta309() {
       _id = "";
       id_encuestado = "";
       c3_p309_p = "";
       c3_p309_c = "";
       c3_p309_mod = "";
       c3_p309_m = "";
       c3_p309_a = "";
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId_encuestado() {
        return id_encuestado;
    }

    public void setId_encuestado(String id_encuestado) {
        this.id_encuestado = id_encuestado;
    }

    public String getC3_p309_p() {
        return c3_p309_p;
    }

    public void setC3_p309_p(String c3_p309_p) {
        this.c3_p309_p = c3_p309_p;
    }

    public String getC3_p309_c() {
        return c3_p309_c;
    }

    public void setC3_p309_c(String c3_p309_c) {
        this.c3_p309_c = c3_p309_c;
    }

    public String getC3_p309_mod() {
        return c3_p309_mod;
    }

    public void setC3_p309_mod(String c3_p309_mod) {
        this.c3_p309_mod = c3_p309_mod;
    }

    public String getC3_p309_m() {
        return c3_p309_m;
    }

    public void setC3_p309_m(String c3_p309_m) {
        this.c3_p309_m = c3_p309_m;
    }

    public String getC3_p309_a() {
        return c3_p309_a;
    }

    public void setC3_p309_a(String c3_p309_a) {
        this.c3_p309_a = c3_p309_a;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_p309_id,_id);
        contentValues.put(SQLConstantes.modulo3_p309_idEncuestado,id_encuestado);
        contentValues.put(SQLConstantes.modulo3_c3_p309_p,c3_p309_p);
        contentValues.put(SQLConstantes.modulo3_c3_p309_c,c3_p309_c);
        contentValues.put(SQLConstantes.modulo3_c3_p309_mod,c3_p309_mod);
        contentValues.put(SQLConstantes.modulo3_c3_p309_m,c3_p309_m);
        contentValues.put(SQLConstantes.modulo3_c3_p309_a,c3_p309_a);
        return contentValues;
    }
}
