package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class M3Pregunta309 {
    private String _id;
    private String idInformante;
    private String idHogar;
    private String idVivienda;
    private String c3_p309_p;
    private String c3_p309_c;
    private String c3_p309_mod;
    private String c3_p309_m;
    private String c3_p309_a;

    public M3Pregunta309() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdInformante() {
        return idInformante;
    }

    public void setIdInformante(String idInformante) {
        this.idInformante = idInformante;
    }

    public String getIdHogar() {
        return idHogar;
    }

    public void setIdHogar(String idHogar) {
        this.idHogar = idHogar;
    }

    public String getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(String idVivienda) {
        this.idVivienda = idVivienda;
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
        contentValues.put(SQLConstantes.modulo3_p309_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_p309_idHogar,idHogar);
        contentValues.put(SQLConstantes.modulo3_p309_idVivienda,idVivienda);
        contentValues.put(SQLConstantes.modulo3_c3_p309_p,c3_p309_p);
        contentValues.put(SQLConstantes.modulo3_c3_p309_c,c3_p309_c);
        contentValues.put(SQLConstantes.modulo3_c3_p309_mod,c3_p309_mod);
        contentValues.put(SQLConstantes.modulo3_c3_p309_m,c3_p309_m);
        contentValues.put(SQLConstantes.modulo3_c3_p309_a,c3_p309_a);
        return contentValues;
    }
}
