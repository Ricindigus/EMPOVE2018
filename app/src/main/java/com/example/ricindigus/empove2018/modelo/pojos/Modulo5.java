package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Modulo5 {
    private int _id;
    private String idInformante;
    private String idHogar;
    private String idVivienda;
    private String c5_p501;
    private String c5_p502_c;
    private String c5_p502;
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

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_id,_id);
        contentValues.put(SQLConstantes.modulo3_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_idHogar,idHogar);
        contentValues.put(SQLConstantes.modulo3_idVivienda,idVivienda);
        contentValues.put(SQLConstantes.modulo5_c5_p501,c5_p501);
        contentValues.put(SQLConstantes.modulo5_c5_p502_c,c5_p502_c);
        contentValues.put(SQLConstantes.modulo5_c5_p502,c5_p502);
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
