package com.example.ricindigus.empove2018.modelo;

public class SQLConstantes {
    public static String DB_PATH = "/data/data/com.example.ricindigus.empove2018/databases/";
    public static String DB_NAME = "dbenpove.sqlite";

    public static String tablamarco = "marco";
    public static String tablausuario = "usuarios";

    public static String tablacaratula = "caratula";
    public static String tablahogares = "caratula";
    public static String tablavisitasencuestador = "visitas_encuestador";
    public static String tablavisitassupervisor = "visitas_supervisor";
    public static String tablafuncionarios = "funcionarios";



    public static String tablamodulo1 = "modulo1";
    public static String tablamodulo2 = "modulo2";
    public static String tablamodulo3 = "modulo3";
    public static String tablam3p309rutas = "m3_p309_rutas";
    public static String tablam3p318personas = "m3_p318_personas";
    public static String tablamodulo4 = "modulo4";
    public static String tablamodulo5 = "modulo5";
    public static String tablamodulo6 = "modulo6";
    public static String tablamodulo7 = "modulo7";
    public static String tablamodulo8 = "modulo8";
    public static String tablamodulo9 = "modulo9";


    /**
     * TABLA MARCO
     * */
    public static String marco_id = "_id";
    public static String marco_anio = "anio";
    public static String marco_mes = "mes";
    public static String marco_periodo = "periodo";
    public static String marco_conglomerado = "conglomerado";
    public static String marco_tselv = "tselv";
    public static String marco_nselv = "nselv";
    public static String marco_norden = "norden";
    public static String marco_vivrem = "vivrem";
    public static String marco_mostrar = "mostrar";
    public static String marco_odei = "odei";
    public static String marco_zona = "zona";
    public static String marco_manzana_id = "manzana_id";
    public static String marco_manzana_a = "manzana_a";
    public static String marco_aerini = "aerini";
    public static String marco_aerfin = "aerfin";
    public static String marco_tipvia = "tipvia";
    public static String marco_nomvia = "nomvia";
    public static String marco_nropta = "nropta";
    public static String marco_lote = "lote";
    public static String marco_piso = "piso";
    public static String marco_block = "block";
    public static String marco_interior = "interior";
    public static String marco_ccdd = "ccdd";
    public static String marco_departamento = "departamento";
    public static String marco_ccpp = "ccpp";
    public static String marco_provincia = "provincia";
    public static String marco_ccdi = "ccdi";
    public static String marco_distrito = "distrito";
    public static String marco_equipo = "equipo";
    public static String marco_ruta = "ruta";
    public static String marco_usuario_id = "usuario_id";
    public static String marco_cargo_id = "cargo_id";

    /**
     * TABLA USUARIOS
     * */

    public static String usuario_id = "_id";
    public static String usuario_nombre = "nombre";
    public static String usuario_password= "password";


    /**
     * TABLA MODULO 1
     * */
    public static String modulo1_id = "_id";
    public static String modulo1_idVivienda = "idVivienda";
    public static String modulo1_c1_p101 = "c1_p101";
    public static String modulo1_c1_p101_o = "c1_p101_o";
    public static String modulo1_c1_p102 = "c1_p102";
    public static String modulo1_c1_p102_o = "c1_p102_o";
    public static String modulo1_c1_p103 = "c1_p103";
    public static String modulo1_c1_p103_o = "c1_p103_o";
    public static String modulo1_c1_p104 = "c1_p104";
    public static String modulo1_c1_p104_o = "c1_p104_o";
    public static String modulo1_c1_p105 = "c1_p105";
    public static String modulo1_c1_p106 = "c1_p106";
    public static String modulo1_c1_p107 = "c1_p107";
    public static String modulo1_c1_p108 = "c1_p108";
    public static String modulo1_c1_p108_o = "c1_p108_o";
    public static String modulo1_c1_p109 = "c1_p109";
    public static String modulo1_c1_p109_o = "c1_p109_o";
    public static String modulo1_c1_p110 = "c1_p110";
    public static String modulo1_c1_p110_o = "c1_p110_o";
    public static String modulo1_c1_p111 = "c1_p111";
    public static String modulo1_c1_p111_o = "c1_p111_o";
    public static String modulo1_c1_p112 = "c1_p112";
    public static String modulo1_c1_p112_o = "c1_p112_o";
    public static String modulo1_c1_p113_1 = "c1_p113_1";
    public static String modulo1_c1_p113_2 = "c1_p113_2";
    public static String modulo1_c1_p113_3 = "c1_p113_3";
    public static String modulo1_c1_p113_4 = "c1_p113_4";
    public static String modulo1_c1_p113_5 = "c1_p113_5";
    public static String modulo1_c1_p113_6 = "c1_p113_6";
    public static String modulo1_c1_p113_7 = "c1_p113_7";
    public static String modulo1_c1_p113_8 = "c1_p113_8";
    public static String modulo1_c1_p113_9 = "c1_p113_9";
    public static String modulo1_c1_p113_7_o = "c1_p113_7_o";
    public static String modulo1_c1_p113_8_o = "c1_p113_8_o";
    public static String modulo1_c1_p113_9_o = "c1_p113_9_o";

    public static final String SQL_CREATE_TABLA_MODULO1 =
            "CREATE TABLE " + tablamodulo1 + "(" +
                    modulo1_id  + " INTEGER PRIMARY KEY," +
                    modulo1_idVivienda  + " TEXT," +
                    modulo1_c1_p101  + " TEXT," +
                    modulo1_c1_p101_o  + " TEXT," +
                    modulo1_c1_p102  + " TEXT," +
                    modulo1_c1_p102_o  + " TEXT," +
                    modulo1_c1_p103  + " TEXT," +
                    modulo1_c1_p103_o + " TEXT," +
                    modulo1_c1_p104  + " TEXT," +
                    modulo1_c1_p104_o  + " TEXT," +
                    modulo1_c1_p105 + " TEXT," +
                    modulo1_c1_p106  + " TEXT," +
                    modulo1_c1_p107  + " TEXT," +
                    modulo1_c1_p108  + " TEXT," +
                    modulo1_c1_p108_o + " TEXT," +
                    modulo1_c1_p109  + " TEXT," +
                    modulo1_c1_p109_o  + " TEXT," +
                    modulo1_c1_p110  + " TEXT," +
                    modulo1_c1_p110_o  + " TEXT," +
                    modulo1_c1_p111  + " TEXT," +
                    modulo1_c1_p111_o  + " TEXT," +
                    modulo1_c1_p112  + " TEXT," +
                    modulo1_c1_p112_o  + " TEXT," +
                    modulo1_c1_p113_1  + " TEXT," +
                    modulo1_c1_p113_2  + " TEXT," +
                    modulo1_c1_p113_3  + " TEXT," +
                    modulo1_c1_p113_4  + " TEXT," +
                    modulo1_c1_p113_5  + " TEXT," +
                    modulo1_c1_p113_6  + " TEXT," +
                    modulo1_c1_p113_7  + " TEXT," +
                    modulo1_c1_p113_7_o  + " TEXT," +
                    modulo1_c1_p113_8  + " TEXT," +
                    modulo1_c1_p113_8_o  + " TEXT," +
                    modulo1_c1_p113_9  + " TEXT," +
                    modulo1_c1_p113_9_o + " TEXT" + ");"
            ;

    /**
     * TABLA MODULO 2
     * */
    public static String modulo2_id = "_id";
    public static String modulo2_idInformante = "idInformante";
    public static String modulo2_idHogar = "idHogar";
    public static String modulo2_idVivienda = "idVivienda";
    public static String modulo2_c2_p202 = "c2_p202";
    public static String modulo2_c2_p203 = "c2_p203";
    public static String modulo2_c2_p204 = "c2_p204";
    public static String modulo2_c2_p205 = "c2_p205";
    public static String modulo2_c2_p206 = "c2_p206";

    public static final String SQL_CREATE_TABLA_MODULO2 =
            "CREATE TABLE " + tablamodulo2 + "(" +
                    modulo2_id  + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    modulo2_idHogar + " TEXT," +
                    modulo2_idVivienda  + " TEXT," +
                    modulo2_c2_p202  + " TEXT," +
                    modulo2_c2_p203  + " TEXT," +
                    modulo2_c2_p204  + " TEXT," +
                    modulo2_c2_p205  + " TEXT," +
                    modulo2_c2_p206 + " TEXT" + ");"
            ;

    /**
     * TABLA MODULO 3
     * */
    public static String modulo3_id = "_id";
    public static String modulo3_idInformante = "idInformante";
    public static String modulo3_idHogar = "idHogar";
    public static String modulo3_idVivienda = "idVivienda";
    public static String modulo3_c3_p301_d = "c3_p301_d";
    public static String modulo3_c3_p301_m = "c3_p301_m";
    public static String modulo3_c3_p301_a = "c3_p301_a";
    public static String modulo3_c3_p302 = "c3_p302";
    public static String modulo3_c3_p303_m = "c3_p303_m";
    public static String modulo3_c3_p303_a = "c3_p303_a";
    public static String modulo3_c3_p303 = "c3_p303";
    public static String modulo3_c3_p304 = "c3_p304";
    public static String modulo3_c3_p305 = "c3_p305";
    public static String modulo3_c3_p305_o = "c3_p305_o";
    public static String modulo3_c3_p306 = "c3_p306";
    public static String modulo3_c3_p306_o = "c3_p306_o";
    public static String modulo3_c3_p307_d = "c3_p307_d";
    public static String modulo3_c3_p307_m = "c3_p307_m";
    public static String modulo3_c3_p307_a = "c3_p307_a";
    public static String modulo3_c3_p308_e = "c3_p308_e";
    public static String modulo3_c3_p308_m = "c3_p308_m";
    public static String modulo3_c3_p310_1 = "c3_p310_1";
    public static String modulo3_c3_p310_2 = "c3_p310_2";
    public static String modulo3_c3_p310_3 = "c3_p310_3";
    public static String modulo3_c3_p310_4 = "c3_p310_4";
    public static String modulo3_c3_p310_4_o = "c3_p310_4_o";
    public static String modulo3_c3_p310_5 = "c3_p310_5";
    public static String modulo3_c3_p311 = "c3_p311";
    public static String modulo3_c3_p312_dist = "c3_p312_dist";
    public static String modulo3_c3_p312_prov = "c3_p312_prov";
    public static String modulo3_c3_p312_dep = "c3_p312_dep";
    public static String modulo3_c3_p313 = "c3_p313";
    public static String modulo3_c3_p314 = "c3_p314";
    public static String modulo3_c3_p314_o = "c3_p314_o";
    public static String modulo3_c3_p315_1 = "c3_p315_1";
    public static String modulo3_c3_p315_2 = "c3_p315_2";
    public static String modulo3_c3_p315_3 = "c3_p315_3";
    public static String modulo3_c3_p315_4 = "c3_p315_4";
    public static String modulo3_c3_p315_5 = "c3_p315_5";
    public static String modulo3_c3_p315_6 = "c3_p315_6";
    public static String modulo3_c3_p315_7 = "c3_p315_7";
    public static String modulo3_c3_p315_8 = "c3_p315_8";
    public static String modulo3_c3_p315_9 = "c3_p315_9";
    public static String modulo3_c3_p315_10 = "c3_p315_10";
    public static String modulo3_c3_p315_11 = "c3_p315_11";
    public static String modulo3_c3_p315_11_o = "c3_p315_11_o";
    public static String modulo3_c3_p315_12 = "c3_p315_12";
    public static String modulo3_c3_p316 = "c3_p316";
    public static String modulo3_c3_p316_o = "c3_p316_o";
    public static String modulo3_c3_p317 = "c3_p317";
    public static String modulo3_c3_p317_o = "c3_p317_o";


    public static final String SQL_CREATE_TABLA_MODULO3 =
            "CREATE TABLE " + tablamodulo3 + "(" +
                    modulo3_id  + " INTEGER PRIMARY KEY," +
                    modulo3_idInformante + " TEXT," +
                    modulo3_idHogar + " TEXT," +
                    modulo3_idVivienda  + " TEXT," +
                    modulo3_c3_p301_d  + " TEXT," +
                    modulo3_c3_p301_m  + " TEXT," +
                    modulo3_c3_p301_a  + " TEXT," +
                    modulo3_c3_p302  + " TEXT," +
                    modulo3_c3_p303  + " TEXT," +
                    modulo3_c3_p303_a  + " TEXT," +
                    modulo3_c3_p303_m  + " TEXT," +
                    modulo3_c3_p304  + " TEXT," +
                    modulo3_c3_p305  + " TEXT," +
                    modulo3_c3_p305_o  + " TEXT," +
                    modulo3_c3_p306  + " TEXT," +
                    modulo3_c3_p306_o  + " TEXT," +
                    modulo3_c3_p307_d  + " TEXT," +
                    modulo3_c3_p307_m  + " TEXT," +
                    modulo3_c3_p307_a  + " TEXT," +
                    modulo3_c3_p308_e  + " TEXT," +
                    modulo3_c3_p308_m  + " TEXT," +
                    modulo3_c3_p310_1  + " TEXT," +
                    modulo3_c3_p310_2  + " TEXT," +
                    modulo3_c3_p310_3  + " TEXT," +
                    modulo3_c3_p310_4  + " TEXT," +
                    modulo3_c3_p310_4_o  + " TEXT," +
                    modulo3_c3_p310_5  + " TEXT," +
                    modulo3_c3_p311  + " TEXT," +
                    modulo3_c3_p312_dist  + " TEXT," +
                    modulo3_c3_p312_prov  + " TEXT," +
                    modulo3_c3_p312_dep  + " TEXT," +
                    modulo3_c3_p313  + " TEXT," +
                    modulo3_c3_p314  + " TEXT," +
                    modulo3_c3_p314_o  + " TEXT," +
                    modulo3_c3_p315_1  + " TEXT," +
                    modulo3_c3_p315_2  + " TEXT," +
                    modulo3_c3_p315_3  + " TEXT," +
                    modulo3_c3_p315_4  + " TEXT," +
                    modulo3_c3_p315_5  + " TEXT," +
                    modulo3_c3_p315_6  + " TEXT," +
                    modulo3_c3_p315_7  + " TEXT," +
                    modulo3_c3_p315_8  + " TEXT," +
                    modulo3_c3_p315_9  + " TEXT," +
                    modulo3_c3_p315_10  + " TEXT," +
                    modulo3_c3_p315_11  + " TEXT," +
                    modulo3_c3_p315_11_o  + " TEXT," +
                    modulo3_c3_p315_12  + " TEXT," +
                    modulo3_c3_p316  + " TEXT," +
                    modulo3_c3_p316_o  + " TEXT," +
                    modulo3_c3_p317  + " TEXT," +
                    modulo3_c3_p317_o + " TEXT" + ");"
            ;

    /**
     * TABLA MODULO 3 PREGUNTA 309 - RUTAS
     * */
    public static String modulo3_p309_id = "_id";
    public static String modulo3_p309_idInformante = "idInformante";
    public static String modulo3_p309_idHogar = "idHogar";
    public static String modulo3_p309_idVivienda = "idVivienda";
    public static String modulo3_c3_p309_p = "c3_p309_p";
    public static String modulo3_c3_p309_c = "c3_p309_c";
    public static String modulo3_c3_p309_mod = "c3_p309_mod";
    public static String modulo3_c3_p309_m = "c3_p309_m";
    public static String modulo3_c3_p309_a = "c3_p309_a";

    public static final String SQL_CREATE_TABLA_MODULO3_P309_RUTAS =
            "CREATE TABLE " + tablam3p309rutas + "(" +
                    modulo3_p309_id  + " INTEGER PRIMARY KEY," +
                    modulo3_p309_idInformante + " TEXT," +
                    modulo3_p309_idHogar + " TEXT," +
                    modulo3_p309_idVivienda  + " TEXT," +
                    modulo3_c3_p309_p  + " TEXT," +
                    modulo3_c3_p309_c  + " TEXT," +
                    modulo3_c3_p309_mod  + " TEXT," +
                    modulo3_c3_p309_m  + " TEXT," +
                    modulo3_c3_p309_a + " TEXT" + ");"
            ;

    /**
     * TABLA MODULO 3 PREGUNTA 318 - PERSONAS
     * */
    public static String modulo3_p318_id = "_id";
    public static String modulo3_p318_idInformante = "idInformante";
    public static String modulo3_p318_idHogar = "idHogar";
    public static String modulo3_p318_idVivienda = "idVivienda";
    public static String modulo3_c3_p318_f = "c3_p318_f";
    public static String modulo3_c3_p318_s = "c3_p318_s";
    public static String modulo3_c3_p318_e = "c3_p318_e";
    public static String modulo3_c3_p318_p = "c3_p318_p";

    public static final String SQL_CREATE_TABLA_MODULO3_P318_PERSONAS =
            "CREATE TABLE " + tablamodulo3 + "(" +
                    modulo3_p318_id  + " INTEGER PRIMARY KEY," +
                    modulo3_p318_idInformante + " TEXT," +
                    modulo3_p318_idHogar + " TEXT," +
                    modulo3_p318_idVivienda  + " TEXT," +
                    modulo3_c3_p318_f  + " TEXT," +
                    modulo3_c3_p318_s  + " TEXT," +
                    modulo3_c3_p318_e  + " TEXT," +
                    modulo3_c3_p318_p + " TEXT" + ");"
            ;

    /**
     * CLAUSULAS WHERE
     * */
    public static final String WHERE_CLAUSE_ID = "_id=?";
    public static final String WHERE_CLAUSE_ANIO = "anio=?";
    public static final String WHERE_CLAUSE_MES = "mes=?";
    public static final String WHERE_CLAUSE_PERIODO = "periodo=?";
    public static final String WHERE_CLAUSE_CONGLOMERADO = "conglomerado=?";
    public static final String WHERE_CLAUSE_USUARIO_ID = "usuario_id=?";
    public static final String WHERE_CLAUSE_USUARIO_NOMBRE = "nombre=?";







//    public static final String[] COLUMNAS_NACIONAL = {
//            nacional_codigo,nacional_apepat,nacional_aplicacion,
//            nacional_aula, nacional_discapacidad, nacional_sede
//    };
}
