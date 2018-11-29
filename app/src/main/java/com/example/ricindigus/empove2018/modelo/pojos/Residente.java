package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Residente {
    private String _id;
    private String id_informante;
    private String id_hogar;
    private String id_vivienda;
    private String numero;
    private String c2_p202;
    private String c2_p203;
    private String c2_p204;
    private String c2_p205_a;
    private String c2_p205_m;
    private String c2_p206;
    private String c2_p207;
    private String COB200;
    private String encuestado_cobertura;

    public Residente() {
        _id = "";
        id_informante = "";
        id_hogar = "";
        id_vivienda = "";
        c2_p202 = "";
        c2_p203 = "";
        c2_p204 = "";
        c2_p205_a = "";
        c2_p205_m = "";
        c2_p206 = "";
        c2_p207 = "";
        COB200 = "0";
        encuestado_cobertura = "0";
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getId_informante() {
        return id_informante;
    }

    public void setId_informante(String id_informante) {
        this.id_informante = id_informante;
    }

    public String getId_hogar() {
        return id_hogar;
    }

    public void setId_hogar(String id_hogar) {
        this.id_hogar = id_hogar;
    }

    public String getId_vivienda() {
        return id_vivienda;
    }

    public void setId_vivienda(String id_vivienda) {
        this.id_vivienda = id_vivienda;
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

    public String getC2_p205_a() {
        if(c2_p205_a==null){
            return "0";
        }else if(c2_p205_a.trim().equals("")){
            return "0";
        }else  return c2_p205_a;
    }

    public void setC2_p205_a(String c2_p205_a) {
        this.c2_p205_a = c2_p205_a;
    }

    public String getC2_p205_m() {
        return c2_p205_m;
    }

    public void setC2_p205_m(String c2_p205_m) {
        this.c2_p205_m = c2_p205_m;
    }

    public String getC2_p206() {
        return c2_p206;
    }

    public void setC2_p206(String c2_p206) {
        this.c2_p206 = c2_p206;
    }

    public String getC2_p207() {
        return c2_p207;
    }

    public void setC2_p207(String c2_p207) {
        this.c2_p207 = c2_p207;
    }

    public String getCOB200() {
        return COB200;
    }

    public void setCOB200(String COB200) {
        this.COB200 = COB200;
    }

    public String getEncuestado_cobertura() {
        return encuestado_cobertura;
    }

    public void setEncuestado_cobertura(String encuestado_cobertura) {
        this.encuestado_cobertura = encuestado_cobertura;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.residentes_id,_id);
        contentValues.put(SQLConstantes.residentes_numero,numero);
        contentValues.put(SQLConstantes.residentes_id_informante, id_informante);
        contentValues.put(SQLConstantes.residentes_id_hogar, id_hogar);
        contentValues.put(SQLConstantes.residentes_id_vivienda, id_vivienda);
        contentValues.put(SQLConstantes.residentes_c2_p202,c2_p202);
        contentValues.put(SQLConstantes.residentes_c2_p203,c2_p203);
        contentValues.put(SQLConstantes.residentes_c2_p204,c2_p204);
        contentValues.put(SQLConstantes.residentes_c2_p205_a,c2_p205_a);
        contentValues.put(SQLConstantes.residentes_c2_p205_m,c2_p205_m);
        contentValues.put(SQLConstantes.residentes_c2_p206,c2_p206);
        contentValues.put(SQLConstantes.residentes_c2_p207,c2_p207);
        contentValues.put(SQLConstantes.residentes_COB200,COB200);
        contentValues.put(SQLConstantes.residentes_encuestado_cobertura,encuestado_cobertura);
        return contentValues;
    }
}
