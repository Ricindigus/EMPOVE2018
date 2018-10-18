package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class M3Pregunta318 {
    private  int _id;
    private  String idInformante;
    private  String idHogar;
    private  String idVivienda;
    private  String c3_p318_f;
    private  String c3_p318_s;
    private  String c3_p318_e;
    private  String c3_p318_p;

    public M3Pregunta318() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
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

    public String getC3_p318_f() {
        return c3_p318_f;
    }

    public void setC3_p318_f(String c3_p318_f) {
        this.c3_p318_f = c3_p318_f;
    }

    public String getC3_p318_s() {
        return c3_p318_s;
    }

    public void setC3_p318_s(String c3_p318_s) {
        this.c3_p318_s = c3_p318_s;
    }

    public String getC3_p318_e() {
        return c3_p318_e;
    }

    public void setC3_p318_e(String c3_p318_e) {
        this.c3_p318_e = c3_p318_e;
    }

    public String getC3_p318_p() {
        return c3_p318_p;
    }

    public void setC3_p318_p(String c3_p318_p) {
        this.c3_p318_p = c3_p318_p;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_p318_id,_id);
        contentValues.put(SQLConstantes.modulo3_p318_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_p318_idHogar,idHogar);
        contentValues.put(SQLConstantes.modulo3_p318_idVivienda,idVivienda);
        contentValues.put(SQLConstantes.modulo3_c3_p318_f,c3_p318_f);
        contentValues.put(SQLConstantes.modulo3_c3_p318_s,c3_p318_s);
        contentValues.put(SQLConstantes.modulo3_c3_p318_e,c3_p318_e);
        contentValues.put(SQLConstantes.modulo3_c3_p318_p,c3_p318_p);
        return contentValues;
    }
}
