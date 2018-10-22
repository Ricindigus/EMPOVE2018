package com.example.ricindigus.empove2018.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ricindigus.empove2018.modelo.pojos.Caratula;
import com.example.ricindigus.empove2018.modelo.pojos.Marco;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1;
import com.example.ricindigus.empove2018.modelo.pojos.Usuario;
import com.example.ricindigus.empove2018.modelo.pojos.Vivienda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Data {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context contexto){
        this.contexto = contexto;
        sqLiteOpenHelper = new DataBaseHelper(contexto);
    }

    public Data(Context contexto,int flag) throws IOException {
        this.contexto = contexto;
        sqLiteOpenHelper = new DataBaseHelper(contexto);
        createDataBase();
    }

    public Data(Context contexto, String inputPath) throws IOException {
        this.contexto = contexto;
        sqLiteOpenHelper = new DataBaseHelper(contexto);
        createDataBase(inputPath);
    }


    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(!dbExist){
            sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
            sqLiteDatabase.close();
            try{
                copyDataBase();
                sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_CARATULA);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FUNCIONARIOS);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_HOGARES);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_VISITA_ENCUESTADOR);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_VISITA_SUPERVISOR);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO1);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO2);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO3);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO4);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO5);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO6);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO7);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO8);
                sqLiteDatabase.close();
            }catch (IOException e){
                throw new Error("Error: copiando base de datos");
            }
        }

    }


    public void createDataBase(String inputPath) throws IOException {
        boolean dbExist = checkDataBase();
        if(dbExist){
            File dbFile = new File(SQLConstantes.DB_PATH + SQLConstantes.DB_NAME);
            SQLiteDatabase.deleteDatabase(dbFile);
        }
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        sqLiteDatabase.close();
        try{
            copyDataBase(inputPath);
            sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_CARATULA);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FUNCIONARIOS);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_HOGARES);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_VISITA_ENCUESTADOR);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_VISITA_SUPERVISOR);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO1);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO2);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO3);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO4);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO5);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO6);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO7);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO8);
            sqLiteDatabase.close();
        }catch (IOException e){
            throw new Error("Error: copiando base de datos");
        }
    }


    public void copyDataBase() throws IOException{
        InputStream myInput = contexto.getAssets().open(SQLConstantes.DB_NAME);
        String outFileName = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) != -1){
            if (length > 0){
                myOutput.write(buffer,0,length);
            }
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();
    }


    public void copyDataBase(String inputPath) throws IOException{
        InputStream myInput = new FileInputStream(inputPath);
        String outFileName = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) != -1){
            if (length > 0){
                myOutput.write(buffer,0,length);
            }
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();

    }

    public void open() throws SQLException {
        String myPath = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close(){
        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
        }
    }

    public boolean checkDataBase(){
        try{
            String myPath = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
            sqLiteDatabase = SQLiteDatabase.openDatabase(myPath,null, SQLiteDatabase.OPEN_READWRITE);
        }catch (Exception e){
            File dbFile = new File(SQLConstantes.DB_PATH + SQLConstantes.DB_NAME);
            return dbFile.exists();
        }
        if (sqLiteDatabase != null) sqLiteDatabase.close();

        return sqLiteDatabase != null ? true : false;
    }

    public Marco getMarco(String idVivienda){
        Marco marco = null;
        String[] whereArgs = new String[]{idVivienda};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamarco,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                marco = new Marco();
                marco.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_id)));
                marco.setAnio(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_anio)));
                marco.setMes(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_mes)));
                marco.setAnio(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_periodo)));
                marco.setConglomerado(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_conglomerado)));
                marco.setTselv(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_tselv)));
                marco.setNselv(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_nselv)));
                marco.setNorden(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_norden)));
                marco.setVivrem(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_vivrem)));
                marco.setMostrar(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_mostrar)));
                marco.setOdei(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_odei)));
                marco.setZona(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_zona)));
                marco.setManzana_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_manzana_id)));
                marco.setManzana_a(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_manzana_a)));
                marco.setAerini(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_aerini)));
                marco.setAerfin(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_aerfin)));
                marco.setTipvia(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_tipvia)));
                marco.setNomvia(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_nomvia)));
                marco.setNropta(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_nropta)));
                marco.setLote(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_lote)));
                marco.setPiso(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_piso)));
                marco.setBlock(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_block)));
                marco.setInterior(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_interior)));
                marco.setCcdd(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_ccdd)));
                marco.setDepartamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_departamento)));
                marco.setCcpp(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_ccpp)));
                marco.setProvincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_provincia)));
                marco.setCcdi(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_ccdi)));
                marco.setDistrito(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_distrito)));
                marco.setEquipo(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_equipo)));
                marco.setRuta(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_ruta)));
                marco.setUsuario_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_usuario_id)));
                marco.setCargo_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_cargo_id)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return marco;
    }

    public ArrayList<Vivienda> getAllViviendas(String idUsuario){
        ArrayList<Vivienda>  viviendas = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(idUsuario)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamarco,
                    null,SQLConstantes.WHERE_CLAUSE_USUARIO_ID,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                Vivienda vivienda = new Vivienda();
                vivienda.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_id)));
                vivienda.setAnio(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_anio)));
                vivienda.setMes(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_mes)));
                vivienda.setPeriodo(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_periodo)));
                vivienda.setConglomerado(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_conglomerado)));
                vivienda.setNorden(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_norden)));
                viviendas.add(vivienda);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return viviendas;
    }

    public ArrayList<Vivienda> getAllViviendasFiltrado(int anio, int mes, int periodo, int conglomerado){
        ArrayList<Vivienda>  viviendas = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(anio), String.valueOf(mes),String.valueOf(periodo),String.valueOf(conglomerado)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamarco,
                    null,SQLConstantes.WHERE_CLAUSE_ANIO + " AND " +
                            SQLConstantes.WHERE_CLAUSE_MES + " AND " +
                            SQLConstantes.WHERE_CLAUSE_PERIODO + " AND " +
                            SQLConstantes.WHERE_CLAUSE_CONGLOMERADO,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                Vivienda vivienda = new Vivienda();
                vivienda.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_id)));
                vivienda.setAnio(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_anio)));
                vivienda.setMes(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_mes)));
                vivienda.setPeriodo(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_periodo)));
                vivienda.setConglomerado(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_conglomerado)));
                vivienda.setNorden(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_norden)));
                viviendas.add(vivienda);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return viviendas;
    }

    public Usuario getUsuario(String nombre){
        Usuario usuario = null;
        String[] whereArgs = new String[]{nombre};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablausuario,
                    null,SQLConstantes.WHERE_CLAUSE_USUARIO_NOMBRE,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                usuario = new Usuario();
                usuario.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.usuario_id)));
                usuario.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_nombre)));
                usuario.setPassword(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_password)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return usuario;
    }

    public void insertarModulo(String nombreTabla, ContentValues contentValues){
        sqLiteDatabase.insert(nombreTabla,null,contentValues);
    }

    public boolean existeModulo(String nombreTabla,String idEncuestado){
        boolean existe = false;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(nombreTabla, null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                existe = true;
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return existe;
    }

    public void actualizarModulo(String nombreTabla, ContentValues contentValues, String idEncuestado){
        String[] whereArgs = new String[]{idEncuestado};
        sqLiteDatabase.update(nombreTabla,contentValues,SQLConstantes.WHERE_CLAUSE_ID,whereArgs);
    }

    /**
     * retornar pojo caratula
     * */

    public Caratula getCaratula(String idVivienda){
        Caratula caratula = null;
        String[] whereArgs = new String[]{idVivienda};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacaratula,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                caratula = new Caratula();
                caratula.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caratula_id)));
                caratula.setNom_dep(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_nom_dep)));
                caratula.setNom_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_nom_prov)));
                caratula.setNom_dist(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_nom_dist)));
                caratula.setNom_ccpp(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_nom_ccpp)));
                caratula.setZona(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_zona)));
                caratula.setManzana_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_manzana_id)));
                caratula.setAer(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_aer)));
                caratula.setVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_vivienda)));
                caratula.setTipvia(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_tipvia)));
                caratula.setNomvia(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_nomvia)));
                caratula.setNropta(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_nropta)));
                caratula.setBlock(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_block)));
                caratula.setInterior(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_interior)));
                caratula.setPiso(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_piso)));
                caratula.setMza(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_mza)));
                caratula.setLote(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_lote)));
                caratula.setKm(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_km)));
                caratula.setTelefono(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_telefono)));
                caratula.setT_hogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.caratula_t_hogar)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return caratula;
    }


    /**
    * retornar pojo modulo1
    * */

    public Modulo1 getModulo1(String idEncuestado){
        Modulo1 modulo1 = null;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo1,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo1 = new Modulo1();
                modulo1.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_id)));
                modulo1.setIdVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_idVivienda)));
                modulo1.setC1_p101(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p101)));
                modulo1.setC1_p101_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p101_o)));
                modulo1.setC1_p102(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p102)));
                modulo1.setC1_p102_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p102_o)));
                modulo1.setC1_p103(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p103)));
                modulo1.setC1_p103_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p103_o)));
                modulo1.setC1_p104(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p104)));
                modulo1.setC1_p104_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p104_o)));
                modulo1.setC1_p105(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p105)));
                modulo1.setC1_p106(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p106)));
                modulo1.setC1_p107(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p107)));
                modulo1.setC1_p108(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p108)));
                modulo1.setC1_p108_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p108_o)));
                modulo1.setC1_p109(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p109)));
                modulo1.setC1_p109_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p109_o)));
                modulo1.setC1_p110(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p110)));
                modulo1.setC1_p110_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p110_o)));
                modulo1.setC1_p111(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p111)));
                modulo1.setC1_p111_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p111_o)));
                modulo1.setC1_p112(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p112)));
                modulo1.setC1_p112_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p112_o)));
                modulo1.setC1_p113_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_1)));
                modulo1.setC1_p113_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_2)));
                modulo1.setC1_p113_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_3)));
                modulo1.setC1_p113_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_4)));
                modulo1.setC1_p113_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_5)));
                modulo1.setC1_p113_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_6)));
                modulo1.setC1_p113_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_7)));
                modulo1.setC1_p113_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_8)));
                modulo1.setC1_p113_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_9)));
                modulo1.setC1_p113_7_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_7_o)));
                modulo1.setC1_p113_8_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_8_o)));
                modulo1.setC1_p113_9_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_c1_p113_9_o)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo1;
    }


}
