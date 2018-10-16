package com.example.ricindigus.empove2018.modelo;

public class SQLConstantes {
    public static String DB_PATH = "/data/data/com.example.ricindigus.empove2018/databases/";
    public static String DB_NAME = "dbenpove.sqlite";

    public static String tablamarco = "marco";
    public static String tablausuario = "usuarios";

    /**
     * ----------------------------TABLAS INICIALES---------------------------
     * */

    //TABLA MARCO
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

    public static String usuario_id = "_id";
    public static String usuario_nombre = "nombre";
    public static String usuario_password= "password";




    /**
     * -----------------CLAUSULAS WHERE--------------------
     * */
    public static final String WHERE_CLAUSE_ID = "_id=?";
    public static final String WHERE_CLAUSE_ANIO = "anio=?";
    public static final String WHERE_CLAUSE_MES = "mes=?";
    public static final String WHERE_CLAUSE_PERIODO = "periodo=?";
    public static final String WHERE_CLAUSE_CONGLOMERADO = "conglomerado=?";
    public static final String WHERE_CLAUSE_USUARIO_ID = "usuario_id=?";
    public static final String WHERE_CLAUSE_USUARIO_NOMBRE = "nombre=?";


    /**
     * -----------------FINAL CLAUSULAS WHERE--------------------
     * */




//    public static final String[] COLUMNAS_NACIONAL = {
//            nacional_codigo,nacional_apepat,nacional_aplicacion,
//            nacional_aula, nacional_discapacidad, nacional_sede
//    };
}
