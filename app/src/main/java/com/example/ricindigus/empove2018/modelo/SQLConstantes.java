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
     * TABLA MODULO 6
     * */
    public static String modulo6_id = "_id";
    public static String modulo6_idInformante = "idInformante";
    public static String modulo6_idHogar = "idHogar";
    public static String modulo6_idVivienda = "idVivienda";
    public static String modulo6_c6_p601 = "c6_p601";
    public static String modulo6_c6_p602 = "c6_p602";
    public static String modulo6_c6_p603 = "c6_p603";
    public static String modulo6_c6_p604_1 = "c6_p604_1";
    public static String modulo6_c6_p604_2 = "c6_p604_2";
    public static String modulo6_c6_p604_3 = "c6_p604_3";
    public static String modulo6_c6_p604_4 = "c6_p604_4";
    public static String modulo6_c6_p604_5 = "c6_p604_5";
    public static String modulo6_c6_p604_6 = "c6_p604_6";
    public static String modulo6_c6_p604_7 = "c6_p604_7";
    public static String modulo6_c6_p604_8 = "c6_p604_8";
    public static String modulo6_c6_p604_9 = "c6_p604_9";
    public static String modulo6_c6_p604_10 = "c6_p604_10";
    public static String modulo6_c6_p604_11 = "c6_p604_11";
    public static String modulo6_c6_p604_o = "c6_p604_o";
    public static String modulo6_c6_p605 = "c6_p605";
    public static String modulo6_c6_p606 = "c6_p606";
    public static String modulo6_c6_p607 = "c6_p607";
    public static String modulo6_c6_p608 = "c6_p608";
    public static String modulo6_c6_p608_o = "c6_p608_o";
    public static String modulo6_c6_p609 = "c6_p609";
    public static String modulo6_c6_p610_pd = "c6_p610_pd";
    public static String modulo6_c6_p610_pl = "c6_p610_pl";
    public static String modulo6_c6_p610_pm = "c6_p610_pm";
    public static String modulo6_c6_p610_pmi = "c6_p610_pmi";
    public static String modulo6_c6_p610_pj = "c6_p610_pj";
    public static String modulo6_c6_p610_pv = "c6_p610_pv";
    public static String modulo6_c6_p610_ps = "c6_p610_ps";
    public static String modulo6_c6_p610_pt = "c6_p610_pt";
    public static String modulo6_c6_p610_sd = "c6_p610_sd";
    public static String modulo6_c6_p610_sl = "c6_p610_sl";
    public static String modulo6_c6_p610_sm = "c6_p610_sm";
    public static String modulo6_c6_p610_smi = "c6_p610_smi";
    public static String modulo6_c6_p610_sj = "c6_p610_sj";
    public static String modulo6_c6_p610_sv = "c6_p610_sv";
    public static String modulo6_c6_p610_ss = "c6_p610_ss";
    public static String modulo6_c6_p610_st = "c6_p610_st";
    public static String modulo6_c6_p610_t = "c6_p610_t";
    public static String modulo6_c6_p611 = "c6_p611";
    public static String modulo6_c6_p612 = "c6_p612";
    public static String modulo6_c6_p612_nro = "c6_p612_nro";
    public static String modulo6_c6_p613 = "c6_p613";
    public static String modulo6_c6_p614_mon = "c6_p614_mon";
    public static String modulo6_c6_p614_esp = "c6_p614_esp";
    public static String modulo6_c6_p615_mon = "c6_p615_mon";
    public static String modulo6_c6_p615_esp = "c6_p615_esp";
    public static String modulo6_c6_p616_mon = "c6_p616_mon";
    public static String modulo6_c6_p616_esp = "c6_p616_esp";
    public static String modulo6_c6_p616_nas = "c6_p616_nas";
    public static String modulo6_c6_p617 = "c6_p617";
    public static String modulo6_c6_p617_dist = "c6_p617_dist";
    public static String modulo6_c6_p617_prov = "c6_p617_prov";
    public static String modulo6_c6_p617_dep = "c6_p617_dep";
    public static String modulo6_c6_p618_1 = "c6_p618_1";
    public static String modulo6_c6_p618_2 = "c6_p618_2";
    public static String modulo6_c6_p618_3 = "c6_p618_3";
    public static String modulo6_c6_p618_4 = "c6_p618_4";
    public static String modulo6_c6_p618_5 = "c6_p618_5";
    public static String modulo6_c6_p618_6 = "c6_p618_6";
    public static String modulo6_c6_p618_o = "c6_p618_o";
    public static String modulo6_c6_p619 = "c6_p619";
    public static String modulo6_c6_p620_1 = "c6_p620_1";
    public static String modulo6_c6_p620_2 = "c6_p620_2";
    public static String modulo6_c6_p620_3 = "c6_p620_3";
    public static String modulo6_c6_p620_4 = "c6_p620_4";
    public static String modulo6_c6_p620_5 = "c6_p620_5";
    public static String modulo6_c6_p620_6 = "c6_p620_6";
    public static String modulo6_c6_p620_7 = "c6_p620_7";
    public static String modulo6_c6_p620_8 = "c6_p620_8";
    public static String modulo6_c6_p620_9 = "c6_p620_9";
    public static String modulo6_c6_p620_o = "c6_p620_o";
    public static String modulo6_c6_p621 = "c6_p621";
    public static String modulo6_c6_p622 = "c6_p622";
    public static String modulo6_c6_p623 = "c6_p623";
    public static String modulo6_c6_p623_o = "c6_p623_o";
    public static String modulo6_c6_p624 = "c6_p624";
    public static String modulo6_c6_p624_o = "c6_p624_o";
    public static String modulo6_c6_p625 = "c6_p625";
    public static String modulo6_c6_p626 = "c6_p626";
    public static String modulo6_c6_p627 = "c6_p627";
    public static String modulo6_c6_p628 = "c6_p628";
    public static String modulo6_c6_p629_1 = "c6_p629_1";
    public static String modulo6_c6_p629_2 = "c6_p629_2";
    public static String modulo6_c6_p629_3 = "c6_p629_3";
    public static String modulo6_c6_p629_4 = "c6_p629_4";
    public static String modulo6_c6_p629_o = "c6_p629_o";
    public static String modulo6_c6_p629_f = "c6_p629_f";
    public static String modulo6_c6_p629_m = "c6_p629_m";
    public static String modulo6_c6_p630_1 = "c6_p630_1";
    public static String modulo6_c6_p630_1med = "c6_p630_1med";
    public static String modulo6_c6_p630_1o = "c6_p630_1o";
    public static String modulo6_c6_p630_1mont = "c6_p630_1mont";
    public static String modulo6_c6_p630_2 = "c6_p630_2";
    public static String modulo6_c6_p630_2med = "c6_p630_2med";
    public static String modulo6_c6_p630_2o = "c6_p630_2o";
    public static String modulo6_c6_p630_2mont = "c6_p630_2mont";
    public static String modulo6_obs_cap6 = "obs_cap6";
    public static String modulo6_c6_estado = "c6_estado";

    public static final String SQL_CREATE_TABLA_MODULO6 =
            "CREATE TABLE " + tablamodulo6 + "(" +
                    modulo6_id  + " INTEGER PRIMARY KEY," +
                    modulo6_idInformante + " TEXT," +
                    modulo6_idHogar + " TEXT," +
                    modulo6_idVivienda  + " TEXT," +
                    modulo6_c6_p601  +  " TEXT," +
                    modulo6_c6_p602  +  " TEXT," +
                    modulo6_c6_p603  +  " TEXT," +
                    modulo6_c6_p604_1  +  " TEXT," +
                    modulo6_c6_p604_2  +  " TEXT," +
                    modulo6_c6_p604_3  +  " TEXT," +
                    modulo6_c6_p604_4  +  " TEXT," +
                    modulo6_c6_p604_5  +  " TEXT," +
                    modulo6_c6_p604_6  +  " TEXT," +
                    modulo6_c6_p604_7  +  " TEXT," +
                    modulo6_c6_p604_8  +  " TEXT," +
                    modulo6_c6_p604_9  +  " TEXT," +
                    modulo6_c6_p604_10  +  " TEXT," +
                    modulo6_c6_p604_11  +  " TEXT," +
                    modulo6_c6_p604_o  +  " TEXT," +
                    modulo6_c6_p605  +  " TEXT," +
                    modulo6_c6_p606  +  " TEXT," +
                    modulo6_c6_p607  +  " TEXT," +
                    modulo6_c6_p608  +  " TEXT," +
                    modulo6_c6_p608_o  +  " TEXT," +
                    modulo6_c6_p609  +  " TEXT," +
                    modulo6_c6_p610_pd  +  " TEXT," +
                    modulo6_c6_p610_pl  +  " TEXT," +
                    modulo6_c6_p610_pm  +  " TEXT," +
                    modulo6_c6_p610_pmi  +  " TEXT," +
                    modulo6_c6_p610_pj  +  " TEXT," +
                    modulo6_c6_p610_pv  +  " TEXT," +
                    modulo6_c6_p610_ps  +  " TEXT," +
                    modulo6_c6_p610_pt  +  " TEXT," +
                    modulo6_c6_p610_sd  +  " TEXT," +
                    modulo6_c6_p610_sl  +  " TEXT," +
                    modulo6_c6_p610_sm  +  " TEXT," +
                    modulo6_c6_p610_smi  +  " TEXT," +
                    modulo6_c6_p610_sj  +  " TEXT," +
                    modulo6_c6_p610_sv  +  " TEXT," +
                    modulo6_c6_p610_ss  +  " TEXT," +
                    modulo6_c6_p610_st  +  " TEXT," +
                    modulo6_c6_p610_t  +  " TEXT," +
                    modulo6_c6_p611  +  " TEXT," +
                    modulo6_c6_p612  +  " TEXT," +
                    modulo6_c6_p612_nro  +  " TEXT," +
                    modulo6_c6_p613  +  " TEXT," +
                    modulo6_c6_p614_mon  +  " TEXT," +
                    modulo6_c6_p614_esp  +  " TEXT," +
                    modulo6_c6_p615_mon  +  " TEXT," +
                    modulo6_c6_p615_esp  +  " TEXT," +
                    modulo6_c6_p616_mon  +  " TEXT," +
                    modulo6_c6_p616_esp  +  " TEXT," +
                    modulo6_c6_p616_nas  +  " TEXT," +
                    modulo6_c6_p617  +  " TEXT," +
                    modulo6_c6_p617_dist  +  " TEXT," +
                    modulo6_c6_p617_prov  +  " TEXT," +
                    modulo6_c6_p617_dep  +  " TEXT," +
                    modulo6_c6_p618_1  +  " TEXT," +
                    modulo6_c6_p618_2  +  " TEXT," +
                    modulo6_c6_p618_3  +  " TEXT," +
                    modulo6_c6_p618_4  +  " TEXT," +
                    modulo6_c6_p618_5  +  " TEXT," +
                    modulo6_c6_p618_6  +  " TEXT," +
                    modulo6_c6_p618_o  +  " TEXT," +
                    modulo6_c6_p619  +  " TEXT," +
                    modulo6_c6_p620_1  +  " TEXT," +
                    modulo6_c6_p620_2  +  " TEXT," +
                    modulo6_c6_p620_3  +  " TEXT," +
                    modulo6_c6_p620_4  +  " TEXT," +
                    modulo6_c6_p620_5  +  " TEXT," +
                    modulo6_c6_p620_6  +  " TEXT," +
                    modulo6_c6_p620_7  +  " TEXT," +
                    modulo6_c6_p620_8  +  " TEXT," +
                    modulo6_c6_p620_9  +  " TEXT," +
                    modulo6_c6_p620_o  +  " TEXT," +
                    modulo6_c6_p621  +  " TEXT," +
                    modulo6_c6_p622  +  " TEXT," +
                    modulo6_c6_p623  +  " TEXT," +
                    modulo6_c6_p623_o  +  " TEXT," +
                    modulo6_c6_p624  +  " TEXT," +
                    modulo6_c6_p624_o  +  " TEXT," +
                    modulo6_c6_p625  +  " TEXT," +
                    modulo6_c6_p626  +  " TEXT," +
                    modulo6_c6_p627  +  " TEXT," +
                    modulo6_c6_p628  +  " TEXT," +
                    modulo6_c6_p629_1  +  " TEXT," +
                    modulo6_c6_p629_2  +  " TEXT," +
                    modulo6_c6_p629_3  +  " TEXT," +
                    modulo6_c6_p629_4  +  " TEXT," +
                    modulo6_c6_p629_o  +  " TEXT," +
                    modulo6_c6_p629_f  +  " TEXT," +
                    modulo6_c6_p629_m  +  " TEXT," +
                    modulo6_c6_p630_1  +  " TEXT," +
                    modulo6_c6_p630_1med  +  " TEXT," +
                    modulo6_c6_p630_1o  +  " TEXT," +
                    modulo6_c6_p630_1mont  +  " TEXT," +
                    modulo6_c6_p630_2  +  " TEXT," +
                    modulo6_c6_p630_2med  +  " TEXT," +
                    modulo6_c6_p630_2o  +  " TEXT," +
                    modulo6_c6_p630_2mont  +  " TEXT," +
                    modulo6_obs_cap6  +  " TEXT," +
                    modulo6_c6_estado  +  " TEXT" + ");"
            ;

    /**
     * TABLA MODULO 7
     * */
    public static String modulo7_id = "_id";
    public static String modulo7_idInformante = "idInformante";
    public static String modulo7_idHogar = "idHogar";
    public static String modulo7_idVivienda = "idVivienda";
    public static String modulo7_c7_p701 = "c7_p701";
    public static String modulo7_c7_p702_1 = "c7_p702_1";
    public static String modulo7_c7_p702_2 = "c7_p702_2";
    public static String modulo7_c7_p702_3 = "c7_p702_3";
    public static String modulo7_c7_p702_4 = "c7_p702_4";
    public static String modulo7_c7_p702_5 = "c7_p702_5";
    public static String modulo7_c7_p702_6 = "c7_p702_6";
    public static String modulo7_c7_p702_7 = "c7_p702_7";
    public static String modulo7_c7_p702_8 = "c7_p702_8";
    public static String modulo7_c7_p702_9 = "c7_p702_9";
    public static String modulo7_c7_p702_10 = "c7_p702_10";
    public static String modulo7_c7_p702_o = "c7_p702_o";
    public static String modulo7_c7_p703 = "c7_p703";
    public static String modulo7_c7_p704_1 = "c7_p704_1";
    public static String modulo7_c7_p704_2 = "c7_p704_2";
    public static String modulo7_c7_p704_3 = "c7_p704_3";
    public static String modulo7_c7_p704_4 = "c7_p704_4";
    public static String modulo7_c7_p704_5 = "c7_p704_5";
    public static String modulo7_c7_p704_6 = "c7_p704_6";
    public static String modulo7_c7_p704_o = "c7_p704_o";
    public static String modulo7_c7_p705_1 = "c7_p705_1";
    public static String modulo7_c7_p705_2 = "c7_p705_2";
    public static String modulo7_c7_p705_3 = "c7_p705_3";
    public static String modulo7_c7_p705_4 = "c7_p705_4";
    public static String modulo7_c7_p705_5 = "c7_p705_5";
    public static String modulo7_c7_p705_6 = "c7_p705_6";
    public static String modulo7_c7_p705_7 = "c7_p705_7";
    public static String modulo7_c7_p705_o = "c7_p705_o";
    public static String modulo7_c7_p706 = "c7_p706";
    public static String modulo7_c7_p707 = "c7_p707";
    public static String modulo7_c7_p707_o = "c7_p707_o";
    public static String modulo7_c7_p708_1 = "c7_p708_1";
    public static String modulo7_c7_p708_2 = "c7_p708_2";
    public static String modulo7_c7_p708_3 = "c7_p708_3";
    public static String modulo7_c7_p708_4 = "c7_p708_4";
    public static String modulo7_c7_p708_5 = "c7_p708_5";
    public static String modulo7_c7_p709_1 = "c7_p709_1";
    public static String modulo7_c7_p709_2 = "c7_p709_2";
    public static String modulo7_c7_p709_3 = "c7_p709_3";
    public static String modulo7_c7_p709_4 = "c7_p709_4";
    public static String modulo7_c7_p709_5 = "c7_p709_5";
    public static String modulo7_c7_p709_6 = "c7_p709_6";
    public static String modulo7_c7_p709_7 = "c7_p709_7";
    public static String modulo7_c7_p709_8 = "c7_p709_8";
    public static String modulo7_c7_p709_9 = "c7_p709_9";
    public static String modulo7_c7_p709_10 = "c7_p709_10";
    public static String modulo7_c7_p709_o = "c7_p709_o";
    public static String modulo7_obs_cap7 = "obs_cap7";
    public static String modulo7_c7_estado = "c7_estado";


    public static final String SQL_CREATE_TABLA_MODULO7 =
            "CREATE TABLE " + tablamodulo7 + "(" +
                    modulo7_id  + " INTEGER PRIMARY KEY," +
                    modulo7_idInformante + " TEXT," +
                    modulo7_idHogar + " TEXT," +
                    modulo7_idVivienda  + " TEXT," +
                    modulo7_c7_p701  +  " TEXT," +
                    modulo7_c7_p702_1  +  " TEXT," +
                    modulo7_c7_p702_2  +  " TEXT," +
                    modulo7_c7_p702_3  +  " TEXT," +
                    modulo7_c7_p702_4  +  " TEXT," +
                    modulo7_c7_p702_5  +  " TEXT," +
                    modulo7_c7_p702_6  +  " TEXT," +
                    modulo7_c7_p702_7  +  " TEXT," +
                    modulo7_c7_p702_8  +  " TEXT," +
                    modulo7_c7_p702_9  +  " TEXT," +
                    modulo7_c7_p702_10  +  " TEXT," +
                    modulo7_c7_p702_o  +  " TEXT," +
                    modulo7_c7_p703  +  " TEXT," +
                    modulo7_c7_p704_1  +  " TEXT," +
                    modulo7_c7_p704_2  +  " TEXT," +
                    modulo7_c7_p704_3  +  " TEXT," +
                    modulo7_c7_p704_4  +  " TEXT," +
                    modulo7_c7_p704_5  +  " TEXT," +
                    modulo7_c7_p704_6  +  " TEXT," +
                    modulo7_c7_p704_o  +  " TEXT," +
                    modulo7_c7_p705_1  +  " TEXT," +
                    modulo7_c7_p705_2  +  " TEXT," +
                    modulo7_c7_p705_3  +  " TEXT," +
                    modulo7_c7_p705_4  +  " TEXT," +
                    modulo7_c7_p705_5  +  " TEXT," +
                    modulo7_c7_p705_6  +  " TEXT," +
                    modulo7_c7_p705_7  +  " TEXT," +
                    modulo7_c7_p705_o  +  " TEXT," +
                    modulo7_c7_p706  +  " TEXT," +
                    modulo7_c7_p707  +  " TEXT," +
                    modulo7_c7_p707_o  +  " TEXT," +
                    modulo7_c7_p708_1  +  " TEXT," +
                    modulo7_c7_p708_2  +  " TEXT," +
                    modulo7_c7_p708_3  +  " TEXT," +
                    modulo7_c7_p708_4  +  " TEXT," +
                    modulo7_c7_p708_5  +  " TEXT," +
                    modulo7_c7_p709_1  +  " TEXT," +
                    modulo7_c7_p709_2  +  " TEXT," +
                    modulo7_c7_p709_3  +  " TEXT," +
                    modulo7_c7_p709_4  +  " TEXT," +
                    modulo7_c7_p709_5  +  " TEXT," +
                    modulo7_c7_p709_6  +  " TEXT," +
                    modulo7_c7_p709_7  +  " TEXT," +
                    modulo7_c7_p709_8  +  " TEXT," +
                    modulo7_c7_p709_9  +  " TEXT," +
                    modulo7_c7_p709_10  +  " TEXT," +
                    modulo7_c7_p709_o  +  " TEXT," +
                    modulo7_obs_cap7  +  " TEXT," +
                    modulo7_c7_estado  +  " TEXT" + ");"
            ;

    /**
     * TABLA MODULO 8
     * */
    public static String modulo8_id = "_id";
    public static String modulo8_idInformante = "idInformante";
    public static String modulo8_idHogar = "idHogar";
    public static String modulo8_idVivienda = "idVivienda";
    public static String modulo8_c8_p801 = "c8_p801";
    public static String modulo8_c8_p802 = "c8_p802";
    public static String modulo8_c8_p803 = "c8_p803";
    public static String modulo8_c8_p804 = "c8_p804";
    public static String modulo8_c8_p805_a = "c8_p805_a";
    public static String modulo8_c8_p805_b = "c8_p805_b";
    public static String modulo8_c8_p805_c = "c8_p805_c";
    public static String modulo8_c8_p805_d = "c8_p805_d";
    public static String modulo8_c8_p805_e = "c8_p805_e";
    public static String modulo8_c8_p806_a = "c8_p806_a";
    public static String modulo8_c8_p806_b = "c8_p806_b";
    public static String modulo8_c8_p806_c = "c8_p806_c";
    public static String modulo8_c8_p806_d = "c8_p806_d";
    public static String modulo8_c8_p806_e = "c8_p806_e";
    public static String modulo8_c8_p806_f = "c8_p806_f";
    public static String modulo8_c8_p807 = "c8_p807";
    public static String modulo8_c8_p808_1 = "c8_p808_1";
    public static String modulo8_c8_p808_2 = "c8_p808_2";
    public static String modulo8_c8_p808_3 = "c8_p808_3";
    public static String modulo8_c8_p808_4 = "c8_p808_4";
    public static String modulo8_c8_p808_5 = "c8_p808_5";
    public static String modulo8_c8_p808_6 = "c8_p808_6";
    public static String modulo8_c8_p808_7 = "c8_p808_7";
    public static String modulo8_c8_p808_8 = "c8_p808_8";
    public static String modulo8_c8_p808_9 = "c8_p808_9";
    public static String modulo8_c8_p808_10 = "c8_p808_10";
    public static String modulo8_c8_p808_11 = "c8_p808_11";
    public static String modulo8_c8_p808_12 = "c8_p808_12";
    public static String modulo8_c8_p808_13 = "c8_p808_13";
    public static String modulo8_c8_p808_o = "c8_p808_o";
    public static String modulo8_c8_p809 = "c8_p809";
    public static String modulo8_c8_p810_1 = "c8_p810_1";
    public static String modulo8_c8_p810_2 = "c8_p810_2";
    public static String modulo8_c8_p810_3 = "c8_p810_3";
    public static String modulo8_c8_p810_4 = "c8_p810_4";
    public static String modulo8_c8_p810_5 = "c8_p810_5";
    public static String modulo8_c8_p810_6 = "c8_p810_6";
    public static String modulo8_c8_p810_7 = "c8_p810_7";
    public static String modulo8_c8_p810_8 = "c8_p810_8";
    public static String modulo8_c8_p810_9 = "c8_p810_9";
    public static String modulo8_c8_p810_10 = "c8_p810_10";
    public static String modulo8_c8_p810_11 = "c8_p810_11";
    public static String modulo8_c8_p810_12 = "c8_p810_12";
    public static String modulo8_c8_p810_13 = "c8_p810_13";
    public static String modulo8_c8_p810_o = "c8_p810_o";
    public static String modulo8_c8_p811 = "c8_p811";
    public static String modulo8_c8_p812 = "c8_p812";
    public static String modulo8_c8_p813_1 = "c8_p813_1";
    public static String modulo8_c8_p813_2 = "c8_p813_2";
    public static String modulo8_c8_p813_3 = "c8_p813_3";
    public static String modulo8_c8_p813_4 = "c8_p813_4";
    public static String modulo8_c8_p813_5 = "c8_p813_5";
    public static String modulo8_c8_p813_6 = "c8_p813_6";
    public static String modulo8_c8_p813_7 = "c8_p813_7";
    public static String modulo8_c8_p813_8 = "c8_p813_8";
    public static String modulo8_c8_p813_9 = "c8_p813_9";
    public static String modulo8_c8_p813_10 = "c8_p813_10";
    public static String modulo8_c8_p813_11 = "c8_p813_11";
    public static String modulo8_c8_p813_12 = "c8_p813_12";
    public static String modulo8_c8_p813_13 = "c8_p813_13";
    public static String modulo8_c8_p813_14 = "c8_p813_14";
    public static String modulo8_c8_p813_o = "c8_p813_o";
    public static String modulo8_c8_p814_1 = "c8_p814_1";
    public static String modulo8_c8_p814_2 = "c8_p814_2";
    public static String modulo8_c8_p814_3 = "c8_p814_3";
    public static String modulo8_c8_p814_4 = "c8_p814_4";
    public static String modulo8_c8_p814_5 = "c8_p814_5";
    public static String modulo8_c8_p814_6 = "c8_p814_6";
    public static String modulo8_c8_p814_7 = "c8_p814_7";
    public static String modulo8_c8_p814_8 = "c8_p814_8";
    public static String modulo8_c8_p815 = "c8_p815";
    public static String modulo8_c8_p816_1 = "c8_p816_1";
    public static String modulo8_c8_p816_2 = "c8_p816_2";
    public static String modulo8_c8_p816_3 = "c8_p816_3";
    public static String modulo8_c8_p816_4 = "c8_p816_4";
    public static String modulo8_c8_p816_5 = "c8_p816_5";
    public static String modulo8_c8_p816_6 = "c8_p816_6";
    public static String modulo8_c8_p816_7 = "c8_p816_7";
    public static String modulo8_c8_p816_8 = "c8_p816_8";
    public static String modulo8_c8_p816_o = "c8_p816_o";
    public static String modulo8_c8_p817_1 = "c8_p817_1";
    public static String modulo8_c8_p817_2 = "c8_p817_2";
    public static String modulo8_c8_p817_3 = "c8_p817_3";
    public static String modulo8_c8_p818 = "c8_p818";
    public static String modulo8_c8_p819_1 = "c8_p819_1";
    public static String modulo8_c8_p819_2 = "c8_p819_2";
    public static String modulo8_c8_p819_3 = "c8_p819_3";
    public static String modulo8_c8_p819_4 = "c8_p819_4";
    public static String modulo8_c8_p819_5 = "c8_p819_5";
    public static String modulo8_c8_p819_6 = "c8_p819_6";
    public static String modulo8_c8_p819_7 = "c8_p819_7";
    public static String modulo8_c8_p819_8 = "c8_p819_8";
    public static String modulo8_c8_p819_9 = "c8_p819_9";
    public static String modulo8_c8_p819_10 = "c8_p819_10";
    public static String modulo8_c8_p819_11 = "c8_p819_11";
    public static String modulo8_c8_p819_12 = "c8_p819_12";
    public static String modulo8_c8_p819_13 = "c8_p819_13";
    public static String modulo8_c8_p819_14 = "c8_p819_14";
    public static String modulo8_c8_p819_o = "c8_p819_o";
    public static String modulo8_c8_p820_1 = "c8_p820_1";
    public static String modulo8_c8_p820_2 = "c8_p820_2";
    public static String modulo8_c8_p820_3 = "c8_p820_3";
    public static String modulo8_c8_p820_4 = "c8_p820_4";
    public static String modulo8_c8_p820_5 = "c8_p820_5";
    public static String modulo8_c8_p820_6 = "c8_p820_6";
    public static String modulo8_c8_p820_7 = "c8_p820_7";
    public static String modulo8_c8_p820_8 = "c8_p820_8";
    public static String modulo8_c8_p820_9 = "c8_p820_9";
    public static String modulo8_c8_p820_10 = "c8_p820_10";
    public static String modulo8_c8_p820_11 = "c8_p820_11";
    public static String modulo8_c8_p820_o = "c8_p820_o";
    public static String modulo8_c8_p821_1 = "c8_p821_1";
    public static String modulo8_c8_p821_2 = "c8_p821_2";
    public static String modulo8_c8_p821_3 = "c8_p821_3";
    public static String modulo8_c8_p821_4 = "c8_p821_4";
    public static String modulo8_c8_p821_5 = "c8_p821_5";
    public static String modulo8_c8_p821_6 = "c8_p821_6";
    public static String modulo8_c8_p821_7 = "c8_p821_7";
    public static String modulo8_c8_p821_8 = "c8_p821_8";
    public static String modulo8_c8_p822 = "c8_p822";
    public static String modulo8_c8_p823_1 = "c8_p823_1";
    public static String modulo8_c8_p823_2 = "c8_p823_2";
    public static String modulo8_c8_p823_3 = "c8_p823_3";
    public static String modulo8_c8_p823_4 = "c8_p823_4";
    public static String modulo8_c8_p823_5 = "c8_p823_5";
    public static String modulo8_c8_p823_o = "c8_p823_o";
    public static String modulo8_obs_cap8 = "obs_cap8";
    public static String modulo8_c8_estado = "c8_estado";


    public static final String SQL_CREATE_TABLA_MODULO8 =
            "CREATE TABLE " + tablamodulo8 + "(" +
                    modulo8_id  + " INTEGER PRIMARY KEY," +
                    modulo8_idInformante + " TEXT," +
                    modulo8_idHogar + " TEXT," +
                    modulo8_idVivienda  + " TEXT," +
                    modulo8_c8_p801  +  " TEXT," +
                    modulo8_c8_p802  +  " TEXT," +
                    modulo8_c8_p803  +  " TEXT," +
                    modulo8_c8_p804  +  " TEXT," +
                    modulo8_c8_p805_a  +  " TEXT," +
                    modulo8_c8_p805_b  +  " TEXT," +
                    modulo8_c8_p805_c  +  " TEXT," +
                    modulo8_c8_p805_d  +  " TEXT," +
                    modulo8_c8_p805_e  +  " TEXT," +
                    modulo8_c8_p806_a  +  " TEXT," +
                    modulo8_c8_p806_b  +  " TEXT," +
                    modulo8_c8_p806_c  +  " TEXT," +
                    modulo8_c8_p806_d  +  " TEXT," +
                    modulo8_c8_p806_e  +  " TEXT," +
                    modulo8_c8_p806_f  +  " TEXT," +
                    modulo8_c8_p807  +  " TEXT," +
                    modulo8_c8_p808_1  +  " TEXT," +
                    modulo8_c8_p808_2  +  " TEXT," +
                    modulo8_c8_p808_3  +  " TEXT," +
                    modulo8_c8_p808_4  +  " TEXT," +
                    modulo8_c8_p808_5  +  " TEXT," +
                    modulo8_c8_p808_6  +  " TEXT," +
                    modulo8_c8_p808_7  +  " TEXT," +
                    modulo8_c8_p808_8  +  " TEXT," +
                    modulo8_c8_p808_9  +  " TEXT," +
                    modulo8_c8_p808_10  +  " TEXT," +
                    modulo8_c8_p808_11  +  " TEXT," +
                    modulo8_c8_p808_12  +  " TEXT," +
                    modulo8_c8_p808_13  +  " TEXT," +
                    modulo8_c8_p808_o  +  " TEXT," +
                    modulo8_c8_p809  +  " TEXT," +
                    modulo8_c8_p810_1  +  " TEXT," +
                    modulo8_c8_p810_2  +  " TEXT," +
                    modulo8_c8_p810_3  +  " TEXT," +
                    modulo8_c8_p810_4  +  " TEXT," +
                    modulo8_c8_p810_5  +  " TEXT," +
                    modulo8_c8_p810_6  +  " TEXT," +
                    modulo8_c8_p810_7  +  " TEXT," +
                    modulo8_c8_p810_8  +  " TEXT," +
                    modulo8_c8_p810_9  +  " TEXT," +
                    modulo8_c8_p810_10  +  " TEXT," +
                    modulo8_c8_p810_11  +  " TEXT," +
                    modulo8_c8_p810_12  +  " TEXT," +
                    modulo8_c8_p810_13  +  " TEXT," +
                    modulo8_c8_p810_o  +  " TEXT," +
                    modulo8_c8_p811  +  " TEXT," +
                    modulo8_c8_p812  +  " TEXT," +
                    modulo8_c8_p813_1  +  " TEXT," +
                    modulo8_c8_p813_2  +  " TEXT," +
                    modulo8_c8_p813_3  +  " TEXT," +
                    modulo8_c8_p813_4  +  " TEXT," +
                    modulo8_c8_p813_5  +  " TEXT," +
                    modulo8_c8_p813_6  +  " TEXT," +
                    modulo8_c8_p813_7  +  " TEXT," +
                    modulo8_c8_p813_8  +  " TEXT," +
                    modulo8_c8_p813_9  +  " TEXT," +
                    modulo8_c8_p813_10  +  " TEXT," +
                    modulo8_c8_p813_11  +  " TEXT," +
                    modulo8_c8_p813_12  +  " TEXT," +
                    modulo8_c8_p813_13  +  " TEXT," +
                    modulo8_c8_p813_14  +  " TEXT," +
                    modulo8_c8_p813_o  +  " TEXT," +
                    modulo8_c8_p814_1  +  " TEXT," +
                    modulo8_c8_p814_2  +  " TEXT," +
                    modulo8_c8_p814_3  +  " TEXT," +
                    modulo8_c8_p814_4  +  " TEXT," +
                    modulo8_c8_p814_5  +  " TEXT," +
                    modulo8_c8_p814_6  +  " TEXT," +
                    modulo8_c8_p814_7  +  " TEXT," +
                    modulo8_c8_p814_8  +  " TEXT," +
                    modulo8_c8_p815  +  " TEXT," +
                    modulo8_c8_p816_1  +  " TEXT," +
                    modulo8_c8_p816_2  +  " TEXT," +
                    modulo8_c8_p816_3  +  " TEXT," +
                    modulo8_c8_p816_4  +  " TEXT," +
                    modulo8_c8_p816_5  +  " TEXT," +
                    modulo8_c8_p816_6  +  " TEXT," +
                    modulo8_c8_p816_7  +  " TEXT," +
                    modulo8_c8_p816_8  +  " TEXT," +
                    modulo8_c8_p816_o  +  " TEXT," +
                    modulo8_c8_p817_1  +  " TEXT," +
                    modulo8_c8_p817_2  +  " TEXT," +
                    modulo8_c8_p817_3  +  " TEXT," +
                    modulo8_c8_p818  +  " TEXT," +
                    modulo8_c8_p819_1  +  " TEXT," +
                    modulo8_c8_p819_2  +  " TEXT," +
                    modulo8_c8_p819_3  +  " TEXT," +
                    modulo8_c8_p819_4  +  " TEXT," +
                    modulo8_c8_p819_5  +  " TEXT," +
                    modulo8_c8_p819_6  +  " TEXT," +
                    modulo8_c8_p819_7  +  " TEXT," +
                    modulo8_c8_p819_8  +  " TEXT," +
                    modulo8_c8_p819_9  +  " TEXT," +
                    modulo8_c8_p819_10  +  " TEXT," +
                    modulo8_c8_p819_11  +  " TEXT," +
                    modulo8_c8_p819_12  +  " TEXT," +
                    modulo8_c8_p819_13  +  " TEXT," +
                    modulo8_c8_p819_14  +  " TEXT," +
                    modulo8_c8_p819_o  +  " TEXT," +
                    modulo8_c8_p820_1  +  " TEXT," +
                    modulo8_c8_p820_2  +  " TEXT," +
                    modulo8_c8_p820_3  +  " TEXT," +
                    modulo8_c8_p820_4  +  " TEXT," +
                    modulo8_c8_p820_5  +  " TEXT," +
                    modulo8_c8_p820_6  +  " TEXT," +
                    modulo8_c8_p820_7  +  " TEXT," +
                    modulo8_c8_p820_8  +  " TEXT," +
                    modulo8_c8_p820_9  +  " TEXT," +
                    modulo8_c8_p820_10  +  " TEXT," +
                    modulo8_c8_p820_11  +  " TEXT," +
                    modulo8_c8_p820_o  +  " TEXT," +
                    modulo8_c8_p821_1  +  " TEXT," +
                    modulo8_c8_p821_2  +  " TEXT," +
                    modulo8_c8_p821_3  +  " TEXT," +
                    modulo8_c8_p821_4  +  " TEXT," +
                    modulo8_c8_p821_5  +  " TEXT," +
                    modulo8_c8_p821_6  +  " TEXT," +
                    modulo8_c8_p821_7  +  " TEXT," +
                    modulo8_c8_p821_8  +  " TEXT," +
                    modulo8_c8_p822  +  " TEXT," +
                    modulo8_c8_p823_1  +  " TEXT," +
                    modulo8_c8_p823_2  +  " TEXT," +
                    modulo8_c8_p823_3  +  " TEXT," +
                    modulo8_c8_p823_4  +  " TEXT," +
                    modulo8_c8_p823_5  +  " TEXT," +
                    modulo8_c8_p823_o  +  " TEXT," +
                    modulo8_obs_cap8  +  " TEXT," +
                    modulo8_c8_estado  +  " TEXT" + ");"
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
