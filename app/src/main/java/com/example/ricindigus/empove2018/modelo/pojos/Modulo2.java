package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Modulo2 {
    private int _id;
    private String idInformante;
    private String idHogar;
    private String idVivienda;
    private String c2_p202;
    private String c2_p203;
    private String c2_p204;
    private String c2_p205;
    private String c2_p206;

    public Modulo2() {
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

    public String getC2_p202() {
        return c2_p202;
    }

    public void setC2_p202(String c2_p202) {
        this.c2_p202 = c2_p202;
    }

    public String getC2_p203() {
        return c2_p203;
    }

    public void setC2_p203(String c2_p203) {
        this.c2_p203 = c2_p203;
    }

    public String getC2_p204() {
        return c2_p204;
    }

    public void setC2_p204(String c2_p204) {
        this.c2_p204 = c2_p204;
    }

    public String getC2_p205() {
        return c2_p205;
    }

    public void setC2_p205(String c2_p205) {
        this.c2_p205 = c2_p205;
    }

    public String getC2_p206() {
        return c2_p206;
    }

    public void setC2_p206(String c2_p206) {
        this.c2_p206 = c2_p206;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo2_id,_id);
        contentValues.put(SQLConstantes.modulo2_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo2_idHogar,idHogar);
        contentValues.put(SQLConstantes.modulo2_idVivienda,idVivienda);
        contentValues.put(SQLConstantes.modulo2_c2_p202,c2_p202);
        contentValues.put(SQLConstantes.modulo2_c2_p203,c2_p203);
        contentValues.put(SQLConstantes.modulo2_c2_p204,c2_p204);
        contentValues.put(SQLConstantes.modulo2_c2_p205,c2_p205);
        contentValues.put(SQLConstantes.modulo2_c2_p206,c2_p206);
        return contentValues;
    }
}
