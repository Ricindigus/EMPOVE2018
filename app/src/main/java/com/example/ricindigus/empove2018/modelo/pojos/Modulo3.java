package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Modulo3 {
    private String _id;
    private String idInformante;
    private String idHogar;
    private String idVivienda;
    private String c3_p301_d;
    private String c3_p301_m;
    private String c3_p301_a;
    private String c3_p302;
    private String c3_p303_m;
    private String c3_p303_a;
    private String c3_p303_no_nacio;
    private String c3_p304;
    private String c3_p305;
    private String c3_p305_o;
    private String c3_p306;
    private String c3_p306_o;
    private String c3_p307_d;
    private String c3_p307_m;
    private String c3_p307_a;
    private String c3_p308_e;
    private String c3_p308_m;
    private String c3_p308_e_seleccion;
    private String c3_p308_m_seleccion;
    private String c3_p310_1;
    private String c3_p310_2;
    private String c3_p310_3;
    private String c3_p310_4;
    private String c3_p311;
    private String c3_p312_dist;
    private String c3_p312_prov;
    private String c3_p312_dep;
    private String c3_p313;
    private String c3_p314;
    private String c3_p314_o;
    private String c3_p315_1;
    private String c3_p315_2;
    private String c3_p315_3;
    private String c3_p315_4;
    private String c3_p315_5;
    private String c3_p315_6;
    private String c3_p315_7;
    private String c3_p315_8;
    private String c3_p315_9;
    private String c3_p315_10;
    private String c3_p315_10_o;
    private String c3_p316;
    private String c3_p316_o;
    private String c3_p317;
    private String c3_p318;
    private String obs_cap3;
    private String COB300;

    public Modulo3(String _id, String idHogar, String idVivienda) {
        this._id = _id;
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        idInformante = "";
        c3_p301_d= "";
        c3_p301_m= "";
        c3_p301_a= "";
        c3_p302= "";
        c3_p303_m = "";
        c3_p303_a = "";
        c3_p303_no_nacio= "";
        c3_p304= "";
        c3_p305= "";
        c3_p305_o= "";
        c3_p306= "";
        c3_p306_o= "";
        c3_p307_d= "";
        c3_p307_m= "";
        c3_p307_a= "";
        c3_p308_e= "";
        c3_p308_m= "";
        c3_p308_e_seleccion= "";
        c3_p308_m_seleccion= "";
        c3_p310_1= "";
        c3_p310_2= "";
        c3_p310_3= "";
        c3_p310_4= "";
        c3_p311= "";
        c3_p312_dist= "";
        c3_p312_prov= "";
        c3_p312_dep= "";
        c3_p313= "";
        c3_p314= "";
        c3_p314_o= "";
        c3_p315_1= "";
        c3_p315_2= "";
        c3_p315_3= "";
        c3_p315_4= "";
        c3_p315_5= "";
        c3_p315_6= "";
        c3_p315_7= "";
        c3_p315_8= "";
        c3_p315_9= "";
        c3_p315_10= "";
        c3_p315_10_o= "";
        c3_p316= "";
        c3_p316_o= "";
        c3_p317= "";
        c3_p318= "";
        obs_cap3= "";
        COB300= "0";
    }

    public Modulo3() { }

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

    public String getC3_p301_d() {
        return c3_p301_d;
    }

    public void setC3_p301_d(String c3_p301_d) {
        this.c3_p301_d = c3_p301_d;
    }

    public String getC3_p301_m() {
        return c3_p301_m;
    }

    public void setC3_p301_m(String c3_p301_m) {
        this.c3_p301_m = c3_p301_m;
    }

    public String getC3_p301_a() {
        return c3_p301_a;
    }

    public void setC3_p301_a(String c3_p301_a) {
        this.c3_p301_a = c3_p301_a;
    }

    public String getC3_p302() {
        return c3_p302;
    }

    public void setC3_p302(String c3_p302) {
        this.c3_p302 = c3_p302;
    }

    public String getC3_p303_m() {
        return c3_p303_m;
    }

    public void setC3_p303_m(String c3_p303_m) {
        this.c3_p303_m = c3_p303_m;
    }

    public String getC3_p303_a() {
        return c3_p303_a;
    }

    public void setC3_p303_a(String c3_p303_a) {
        this.c3_p303_a = c3_p303_a;
    }

    public String getC3_p303_no_nacio() {
        return c3_p303_no_nacio;
    }

    public void setC3_p303_no_nacio(String c3_p303_no_nacio) {
        this.c3_p303_no_nacio = c3_p303_no_nacio;
    }

    public String getC3_p304() {
        return c3_p304;
    }

    public void setC3_p304(String c3_p304) {
        this.c3_p304 = c3_p304;
    }

    public String getC3_p305() {
        return c3_p305;
    }

    public void setC3_p305(String c3_p305) {
        this.c3_p305 = c3_p305;
    }

    public String getC3_p305_o() {
        return c3_p305_o;
    }

    public void setC3_p305_o(String c3_p305_o) {
        this.c3_p305_o = c3_p305_o;
    }

    public String getC3_p306() {
        return c3_p306;
    }

    public void setC3_p306(String c3_p306) {
        this.c3_p306 = c3_p306;
    }

    public String getC3_p306_o() {
        return c3_p306_o;
    }

    public void setC3_p306_o(String c3_p306_o) {
        this.c3_p306_o = c3_p306_o;
    }

    public String getC3_p307_d() {
        return c3_p307_d;
    }

    public void setC3_p307_d(String c3_p307_d) {
        this.c3_p307_d = c3_p307_d;
    }

    public String getC3_p307_m() {
        return c3_p307_m;
    }

    public void setC3_p307_m(String c3_p307_m) {
        this.c3_p307_m = c3_p307_m;
    }

    public String getC3_p307_a() {
        return c3_p307_a;
    }

    public void setC3_p307_a(String c3_p307_a) {
        this.c3_p307_a = c3_p307_a;
    }

    public String getC3_p308_e() {
        return c3_p308_e;
    }

    public void setC3_p308_e(String c3_p308_e) {
        this.c3_p308_e = c3_p308_e;
    }

    public String getC3_p308_m() {
        return c3_p308_m;
    }

    public void setC3_p308_m(String c3_p308_m) {
        this.c3_p308_m = c3_p308_m;
    }

    public String getC3_p308_e_seleccion() {
        return c3_p308_e_seleccion;
    }

    public void setC3_p308_e_seleccion(String c3_p308_e_seleccion) {
        this.c3_p308_e_seleccion = c3_p308_e_seleccion;
    }

    public String getC3_p308_m_seleccion() {
        return c3_p308_m_seleccion;
    }

    public void setC3_p308_m_seleccion(String c3_p308_m_seleccion) {
        this.c3_p308_m_seleccion = c3_p308_m_seleccion;
    }

    public String getC3_p310_1() {
        return c3_p310_1;
    }

    public void setC3_p310_1(String c3_p310_1) {
        this.c3_p310_1 = c3_p310_1;
    }

    public String getC3_p310_2() {
        return c3_p310_2;
    }

    public void setC3_p310_2(String c3_p310_2) {
        this.c3_p310_2 = c3_p310_2;
    }

    public String getC3_p310_3() {
        return c3_p310_3;
    }

    public void setC3_p310_3(String c3_p310_3) {
        this.c3_p310_3 = c3_p310_3;
    }

    public String getC3_p310_4() {
        return c3_p310_4;
    }

    public void setC3_p310_4(String c3_p310_4) {
        this.c3_p310_4 = c3_p310_4;
    }

    public String getC3_p311() {
        return c3_p311;
    }

    public void setC3_p311(String c3_p311) {
        this.c3_p311 = c3_p311;
    }

    public String getC3_p312_dist() {
        return c3_p312_dist;
    }

    public void setC3_p312_dist(String c3_p312_dist) {
        this.c3_p312_dist = c3_p312_dist;
    }

    public String getC3_p312_prov() {
        return c3_p312_prov;
    }

    public void setC3_p312_prov(String c3_p312_prov) {
        this.c3_p312_prov = c3_p312_prov;
    }

    public String getC3_p312_dep() {
        return c3_p312_dep;
    }

    public void setC3_p312_dep(String c3_p312_dep) {
        this.c3_p312_dep = c3_p312_dep;
    }

    public String getC3_p313() {
        return c3_p313;
    }

    public void setC3_p313(String c3_p313) {
        this.c3_p313 = c3_p313;
    }

    public String getC3_p314() {
        return c3_p314;
    }

    public void setC3_p314(String c3_p314) {
        this.c3_p314 = c3_p314;
    }

    public String getC3_p314_o() {
        return c3_p314_o;
    }

    public void setC3_p314_o(String c3_p314_o) {
        this.c3_p314_o = c3_p314_o;
    }

    public String getC3_p315_1() {
        return c3_p315_1;
    }

    public void setC3_p315_1(String c3_p315_1) {
        this.c3_p315_1 = c3_p315_1;
    }

    public String getC3_p315_2() {
        return c3_p315_2;
    }

    public void setC3_p315_2(String c3_p315_2) {
        this.c3_p315_2 = c3_p315_2;
    }

    public String getC3_p315_3() {
        return c3_p315_3;
    }

    public void setC3_p315_3(String c3_p315_3) {
        this.c3_p315_3 = c3_p315_3;
    }

    public String getC3_p315_4() {
        return c3_p315_4;
    }

    public void setC3_p315_4(String c3_p315_4) {
        this.c3_p315_4 = c3_p315_4;
    }

    public String getC3_p315_5() {
        return c3_p315_5;
    }

    public void setC3_p315_5(String c3_p315_5) {
        this.c3_p315_5 = c3_p315_5;
    }

    public String getC3_p315_6() {
        return c3_p315_6;
    }

    public void setC3_p315_6(String c3_p315_6) {
        this.c3_p315_6 = c3_p315_6;
    }

    public String getC3_p315_7() {
        return c3_p315_7;
    }

    public void setC3_p315_7(String c3_p315_7) {
        this.c3_p315_7 = c3_p315_7;
    }

    public String getC3_p315_8() {
        return c3_p315_8;
    }

    public void setC3_p315_8(String c3_p315_8) {
        this.c3_p315_8 = c3_p315_8;
    }

    public String getC3_p315_9() {
        return c3_p315_9;
    }

    public void setC3_p315_9(String c3_p315_9) {
        this.c3_p315_9 = c3_p315_9;
    }

    public String getC3_p315_10() {
        return c3_p315_10;
    }

    public void setC3_p315_10(String c3_p315_10) {
        this.c3_p315_10 = c3_p315_10;
    }

    public String getC3_p315_10_o() {
        return c3_p315_10_o;
    }

    public void setC3_p315_10_o(String c3_p315_10_o) {
        this.c3_p315_10_o = c3_p315_10_o;
    }

    public String getC3_p316() {
        return c3_p316;
    }

    public void setC3_p316(String c3_p316) {
        this.c3_p316 = c3_p316;
    }

    public String getC3_p316_o() {
        return c3_p316_o;
    }

    public void setC3_p316_o(String c3_p316_o) {
        this.c3_p316_o = c3_p316_o;
    }

    public String getC3_p317() {
        return c3_p317;
    }

    public void setC3_p317(String c3_p317) {
        this.c3_p317 = c3_p317;
    }

    public String getC3_p318() {
        return c3_p318;
    }

    public void setC3_p318(String c3_p318) {
        this.c3_p318 = c3_p318;
    }

    public String getObs_cap3() {
        return obs_cap3;
    }

    public void setObs_cap3(String obs_cap3) {
        this.obs_cap3 = obs_cap3;
    }

    public String getCOB300() {
        return COB300;
    }

    public void setCOB300(String COB300) {
        this.COB300 = COB300;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_id,_id);
        contentValues.put(SQLConstantes.modulo3_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_idHogar,idHogar);
        contentValues.put(SQLConstantes.modulo3_idVivienda,idVivienda);
        contentValues.put(SQLConstantes.modulo3_c3_p301_d,c3_p301_d);
        contentValues.put(SQLConstantes.modulo3_c3_p301_m,c3_p301_m);
        contentValues.put(SQLConstantes.modulo3_c3_p301_a,c3_p301_a);
        contentValues.put(SQLConstantes.modulo3_c3_p302,c3_p302);
        contentValues.put(SQLConstantes.modulo3_c3_p303_m, c3_p303_m);
        contentValues.put(SQLConstantes.modulo3_c3_p303_a, c3_p303_a);
        contentValues.put(SQLConstantes.modulo3_c3_p303_no_nacio, c3_p303_no_nacio);
        contentValues.put(SQLConstantes.modulo3_c3_p304,c3_p304);
        contentValues.put(SQLConstantes.modulo3_c3_p305,c3_p305);
        contentValues.put(SQLConstantes.modulo3_c3_p305_o,c3_p305_o);
        contentValues.put(SQLConstantes.modulo3_c3_p306,c3_p306);
        contentValues.put(SQLConstantes.modulo3_c3_p306_o,c3_p306_o);
        contentValues.put(SQLConstantes.modulo3_c3_p307_d,c3_p307_d);
        contentValues.put(SQLConstantes.modulo3_c3_p307_m,c3_p307_m);
        contentValues.put(SQLConstantes.modulo3_c3_p307_a,c3_p307_a);
        contentValues.put(SQLConstantes.modulo3_c3_p308_e,c3_p308_e);
        contentValues.put(SQLConstantes.modulo3_c3_p308_m,c3_p308_m);
        contentValues.put(SQLConstantes.modulo3_c3_p308_e_seleccion,c3_p308_e_seleccion);
        contentValues.put(SQLConstantes.modulo3_c3_p308_m_seleccion,c3_p308_m_seleccion);
        contentValues.put(SQLConstantes.modulo3_c3_p310_1,c3_p310_1);
        contentValues.put(SQLConstantes.modulo3_c3_p310_2,c3_p310_2);
        contentValues.put(SQLConstantes.modulo3_c3_p310_3,c3_p310_3);
        contentValues.put(SQLConstantes.modulo3_c3_p310_4,c3_p310_4);
        contentValues.put(SQLConstantes.modulo3_c3_p311,c3_p311);
        contentValues.put(SQLConstantes.modulo3_c3_p312_dist,c3_p312_dist);
        contentValues.put(SQLConstantes.modulo3_c3_p312_prov,c3_p312_prov);
        contentValues.put(SQLConstantes.modulo3_c3_p312_dep,c3_p312_dep);
        contentValues.put(SQLConstantes.modulo3_c3_p313,c3_p313);
        contentValues.put(SQLConstantes.modulo3_c3_p314,c3_p314);
        contentValues.put(SQLConstantes.modulo3_c3_p314_o,c3_p314_o);
        contentValues.put(SQLConstantes.modulo3_c3_p315_1,c3_p315_1);
        contentValues.put(SQLConstantes.modulo3_c3_p315_2,c3_p315_2);
        contentValues.put(SQLConstantes.modulo3_c3_p315_3,c3_p315_3);
        contentValues.put(SQLConstantes.modulo3_c3_p315_4,c3_p315_4);
        contentValues.put(SQLConstantes.modulo3_c3_p315_5,c3_p315_5);
        contentValues.put(SQLConstantes.modulo3_c3_p315_6,c3_p315_6);
        contentValues.put(SQLConstantes.modulo3_c3_p315_7,c3_p315_7);
        contentValues.put(SQLConstantes.modulo3_c3_p315_8,c3_p315_8);
        contentValues.put(SQLConstantes.modulo3_c3_p315_9,c3_p315_9);
        contentValues.put(SQLConstantes.modulo3_c3_p315_10,c3_p315_10);
        contentValues.put(SQLConstantes.modulo3_c3_p315_10_o,c3_p315_10_o);
        contentValues.put(SQLConstantes.modulo3_c3_p316,c3_p316);
        contentValues.put(SQLConstantes.modulo3_c3_p316_o,c3_p316_o);
        contentValues.put(SQLConstantes.modulo3_c3_p317,c3_p317);
        contentValues.put(SQLConstantes.modulo3_c3_p318,c3_p318);
        contentValues.put(SQLConstantes.modulo3_obs_cap3,obs_cap3);
        contentValues.put(SQLConstantes.modulo3_COB300,COB300);
        return contentValues;
    }
}
