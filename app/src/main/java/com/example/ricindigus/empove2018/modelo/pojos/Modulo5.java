package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Modulo5 {
    private String _id;
    private String idInformante;
    private String idHogar;
    private String idVivienda;
    private String c5_p501;
    private String c5_p502_c;
    private String c5_p502;
    private String c5_p502_eleccion;
    private String c5_p502_o;
    private String c5_p503;
    private String c5_p504;
    private String c5_p505;
    private String c5_p506_1;
    private String c5_p506_2;
    private String c5_p506_3;
    private String c5_p506_4;
    private String c5_p507;
    private String c5_p507_dist;
    private String c5_p507_prov;
    private String c5_p507_dep;
    private String c5_p508_1;
    private String c5_p508_2;
    private String c5_p508_3;
    private String c5_p508_4;
    private String c5_p508_5;
    private String c5_p508_6;
    private String c5_p508_7;
    private String c5_p508_8;
    private String c5_p508_9;
    private String c5_p508_10;
    private String c5_p508_11;
    private String c5_p508_o;
    private String c5_p509;
    private String c5_p510;
    private String c5_p511;
    private String c5_p511_o;
    private String c5_p512;
    private String c5_p512_o;
    private String c5_p513;
    private String c5_p513_o;
    private String obs_cap5;
    private String c5_estado;

    public Modulo5(String _id, String idHogar, String idVivienda) {
        idInformante= "";
        this._id = _id;
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        c5_p501= "";
        c5_p502_c= "";
        c5_p502= "";
        c5_p502_eleccion= "";
        c5_p502_o= "";
        c5_p503= "";
        c5_p504= "";
        c5_p505= "";
        c5_p506_1= "";
        c5_p506_2= "";
        c5_p506_3= "";
        c5_p506_4= "";
        c5_p507= "";
        c5_p507_dist= "";
        c5_p507_prov= "";
        c5_p507_dep= "";
        c5_p508_1= "";
        c5_p508_2= "";
        c5_p508_3= "";
        c5_p508_4= "";
        c5_p508_5= "";
        c5_p508_6= "";
        c5_p508_7= "";
        c5_p508_8= "";
        c5_p508_9= "";
        c5_p508_10= "";
        c5_p508_11= "";
        c5_p508_o= "";
        c5_p509= "";
        c5_p510= "";
        c5_p511= "";
        c5_p511_o= "";
        c5_p512= "";
        c5_p512_o= "";
        c5_p513= "";
        c5_p513_o= "";
        obs_cap5= "";
        c5_estado= "";
    }

    public Modulo5() {
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

    public String getC5_p501() {
        return c5_p501;
    }

    public void setC5_p501(String c5_p501) {
        this.c5_p501 = c5_p501;
    }

    public String getC5_p502_c() {
        return c5_p502_c;
    }

    public void setC5_p502_c(String c5_p502_c) {
        this.c5_p502_c = c5_p502_c;
    }

    public String getC5_p502() {
        return c5_p502;
    }

    public void setC5_p502(String c5_p502) {
        this.c5_p502 = c5_p502;
    }

    public String getC5_p502_eleccion() {
        return c5_p502_eleccion;
    }

    public void setC5_p502_eleccion(String c5_p502_eleccion) {
        this.c5_p502_eleccion = c5_p502_eleccion;
    }

    public String getC5_p502_o() {
        return c5_p502_o;
    }

    public void setC5_p502_o(String c5_p502_o) {
        this.c5_p502_o = c5_p502_o;
    }

    public String getC5_p503() {
        return c5_p503;
    }

    public void setC5_p503(String c5_p503) {
        this.c5_p503 = c5_p503;
    }

    public String getC5_p504() {
        return c5_p504;
    }

    public void setC5_p504(String c5_p504) {
        this.c5_p504 = c5_p504;
    }

    public String getC5_p505() {
        return c5_p505;
    }

    public void setC5_p505(String c5_p505) {
        this.c5_p505 = c5_p505;
    }

    public String getC5_p506_1() {
        return c5_p506_1;
    }

    public void setC5_p506_1(String c5_p506_1) {
        this.c5_p506_1 = c5_p506_1;
    }

    public String getC5_p506_2() {
        return c5_p506_2;
    }

    public void setC5_p506_2(String c5_p506_2) {
        this.c5_p506_2 = c5_p506_2;
    }

    public String getC5_p506_3() {
        return c5_p506_3;
    }

    public void setC5_p506_3(String c5_p506_3) {
        this.c5_p506_3 = c5_p506_3;
    }

    public String getC5_p506_4() {
        return c5_p506_4;
    }

    public void setC5_p506_4(String c5_p506_4) {
        this.c5_p506_4 = c5_p506_4;
    }

    public String getC5_p507() {
        return c5_p507;
    }

    public void setC5_p507(String c5_p507) {
        this.c5_p507 = c5_p507;
    }

    public String getC5_p507_dist() {
        return c5_p507_dist;
    }

    public void setC5_p507_dist(String c5_p507_dist) {
        this.c5_p507_dist = c5_p507_dist;
    }

    public String getC5_p507_prov() {
        return c5_p507_prov;
    }

    public void setC5_p507_prov(String c5_p507_prov) {
        this.c5_p507_prov = c5_p507_prov;
    }

    public String getC5_p507_dep() {
        return c5_p507_dep;
    }

    public void setC5_p507_dep(String c5_p507_dep) {
        this.c5_p507_dep = c5_p507_dep;
    }

    public String getC5_p508_1() {
        return c5_p508_1;
    }

    public void setC5_p508_1(String c5_p508_1) {
        this.c5_p508_1 = c5_p508_1;
    }

    public String getC5_p508_2() {
        return c5_p508_2;
    }

    public void setC5_p508_2(String c5_p508_2) {
        this.c5_p508_2 = c5_p508_2;
    }

    public String getC5_p508_3() {
        return c5_p508_3;
    }

    public void setC5_p508_3(String c5_p508_3) {
        this.c5_p508_3 = c5_p508_3;
    }

    public String getC5_p508_4() {
        return c5_p508_4;
    }

    public void setC5_p508_4(String c5_p508_4) {
        this.c5_p508_4 = c5_p508_4;
    }

    public String getC5_p508_5() {
        return c5_p508_5;
    }

    public void setC5_p508_5(String c5_p508_5) {
        this.c5_p508_5 = c5_p508_5;
    }

    public String getC5_p508_6() {
        return c5_p508_6;
    }

    public void setC5_p508_6(String c5_p508_6) {
        this.c5_p508_6 = c5_p508_6;
    }

    public String getC5_p508_7() {
        return c5_p508_7;
    }

    public void setC5_p508_7(String c5_p508_7) {
        this.c5_p508_7 = c5_p508_7;
    }

    public String getC5_p508_8() {
        return c5_p508_8;
    }

    public void setC5_p508_8(String c5_p508_8) {
        this.c5_p508_8 = c5_p508_8;
    }

    public String getC5_p508_9() {
        return c5_p508_9;
    }

    public void setC5_p508_9(String c5_p508_9) {
        this.c5_p508_9 = c5_p508_9;
    }

    public String getC5_p508_10() {
        return c5_p508_10;
    }

    public void setC5_p508_10(String c5_p508_10) {
        this.c5_p508_10 = c5_p508_10;
    }

    public String getC5_p508_11() {
        return c5_p508_11;
    }

    public void setC5_p508_11(String c5_p508_11) {
        this.c5_p508_11 = c5_p508_11;
    }

    public String getC5_p508_o() {
        return c5_p508_o;
    }

    public void setC5_p508_o(String c5_p508_o) {
        this.c5_p508_o = c5_p508_o;
    }

    public String getC5_p509() {
        return c5_p509;
    }

    public void setC5_p509(String c5_p509) {
        this.c5_p509 = c5_p509;
    }

    public String getC5_p510() {
        return c5_p510;
    }

    public void setC5_p510(String c5_p510) {
        this.c5_p510 = c5_p510;
    }

    public String getC5_p511() {
        return c5_p511;
    }

    public void setC5_p511(String c5_p511) {
        this.c5_p511 = c5_p511;
    }

    public String getC5_p511_o() {
        return c5_p511_o;
    }

    public void setC5_p511_o(String c5_p511_o) {
        this.c5_p511_o = c5_p511_o;
    }

    public String getC5_p512() {
        return c5_p512;
    }

    public void setC5_p512(String c5_p512) {
        this.c5_p512 = c5_p512;
    }

    public String getC5_p512_o() {
        return c5_p512_o;
    }

    public void setC5_p512_o(String c5_p512_o) {
        this.c5_p512_o = c5_p512_o;
    }

    public String getC5_p513() {
        return c5_p513;
    }

    public void setC5_p513(String c5_p513) {
        this.c5_p513 = c5_p513;
    }

    public String getC5_p513_o() {
        return c5_p513_o;
    }

    public void setC5_p513_o(String c5_p513_o) {
        this.c5_p513_o = c5_p513_o;
    }

    public String getObs_cap5() {
        return obs_cap5;
    }

    public void setObs_cap5(String obs_cap5) {
        this.obs_cap5 = obs_cap5;
    }

    public String getC5_estado() {
        return c5_estado;
    }

    public void setC5_estado(String c5_estado) {
        this.c5_estado = c5_estado;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_id,_id);
        contentValues.put(SQLConstantes.modulo5_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo5_idHogar,idHogar);
        contentValues.put(SQLConstantes.modulo5_idVivienda,idVivienda);
        contentValues.put(SQLConstantes.modulo5_c5_p501,c5_p501);
        contentValues.put(SQLConstantes.modulo5_c5_p502_c,c5_p502_c);
        contentValues.put(SQLConstantes.modulo5_c5_p502,c5_p502);
        contentValues.put(SQLConstantes.modulo5_c5_p502_eleccion,c5_p502_eleccion);
        contentValues.put(SQLConstantes.modulo5_c5_p502_o,c5_p502_o);
        contentValues.put(SQLConstantes.modulo5_c5_p503,c5_p503);
        contentValues.put(SQLConstantes.modulo5_c5_p504,c5_p504);
        contentValues.put(SQLConstantes.modulo5_c5_p505,c5_p505);
        contentValues.put(SQLConstantes.modulo5_c5_p506_1,c5_p506_1);
        contentValues.put(SQLConstantes.modulo5_c5_p506_2,c5_p506_2);
        contentValues.put(SQLConstantes.modulo5_c5_p506_3,c5_p506_3);
        contentValues.put(SQLConstantes.modulo5_c5_p506_4,c5_p506_4);
        contentValues.put(SQLConstantes.modulo5_c5_p507,c5_p507);
        contentValues.put(SQLConstantes.modulo5_c5_p507_dist,c5_p507_dist);
        contentValues.put(SQLConstantes.modulo5_c5_p507_prov,c5_p507_prov);
        contentValues.put(SQLConstantes.modulo5_c5_p507_dep,c5_p507_dep);
        contentValues.put(SQLConstantes.modulo5_c5_p508_1,c5_p508_1);
        contentValues.put(SQLConstantes.modulo5_c5_p508_2,c5_p508_2);
        contentValues.put(SQLConstantes.modulo5_c5_p508_3,c5_p508_3);
        contentValues.put(SQLConstantes.modulo5_c5_p508_4,c5_p508_4);
        contentValues.put(SQLConstantes.modulo5_c5_p508_5,c5_p508_5);
        contentValues.put(SQLConstantes.modulo5_c5_p508_6,c5_p508_6);
        contentValues.put(SQLConstantes.modulo5_c5_p508_7,c5_p508_7);
        contentValues.put(SQLConstantes.modulo5_c5_p508_8,c5_p508_8);
        contentValues.put(SQLConstantes.modulo5_c5_p508_9,c5_p508_9);
        contentValues.put(SQLConstantes.modulo5_c5_p508_10,c5_p508_10);
        contentValues.put(SQLConstantes.modulo5_c5_p508_11,c5_p508_11);
        contentValues.put(SQLConstantes.modulo5_c5_p508_o,c5_p508_o);
        contentValues.put(SQLConstantes.modulo5_c5_p509,c5_p509);
        contentValues.put(SQLConstantes.modulo5_c5_p510,c5_p510);
        contentValues.put(SQLConstantes.modulo5_c5_p511,c5_p511);
        contentValues.put(SQLConstantes.modulo5_c5_p511_o,c5_p511_o);
        contentValues.put(SQLConstantes.modulo5_c5_p512,c5_p512);
        contentValues.put(SQLConstantes.modulo5_c5_p512_o,c5_p512_o);
        contentValues.put(SQLConstantes.modulo5_c5_p513,c5_p513);
        contentValues.put(SQLConstantes.modulo5_c5_p513_o,c5_p513_o);
        contentValues.put(SQLConstantes.modulo5_obs_cap5,obs_cap5);
        contentValues.put(SQLConstantes.modulo5_c5_estado,c5_estado);
        return contentValues;
    }
}
