package com.example.ricindigus.empove2018.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ricindigus.empove2018.modelo.pojos.Caratula;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.modelo.pojos.ItemMarco;
import com.example.ricindigus.empove2018.modelo.pojos.Marco;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.Usuario;
import com.example.ricindigus.empove2018.modelo.pojos.VisitaEncuestador;

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

    public ArrayList<ItemMarco> getListMarco(String idUsuario){
        ArrayList<ItemMarco> itemMarcos = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(idUsuario)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamarco,
                    null,SQLConstantes.WHERE_CLAUSE_USUARIO_ID,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                ItemMarco itemMarco = new ItemMarco();
                itemMarco.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_id)));
                itemMarco.setAnio(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_anio)));
                itemMarco.setMes(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_mes)));
                itemMarco.setPeriodo(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_periodo)));
                itemMarco.setConglomerado(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_conglomerado)));
                itemMarco.setNorden(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_norden)));
                itemMarcos.add(itemMarco);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return itemMarcos;
    }

    public ArrayList<ItemMarco> getListMarcoFiltrado(int anio, int mes, int periodo, int conglomerado){
        ArrayList<ItemMarco> itemMarcos = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(anio), String.valueOf(mes),String.valueOf(periodo),String.valueOf(conglomerado)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamarco,
                    null,SQLConstantes.WHERE_CLAUSE_ANIO + " AND " +
                            SQLConstantes.WHERE_CLAUSE_MES + " AND " +
                            SQLConstantes.WHERE_CLAUSE_PERIODO + " AND " +
                            SQLConstantes.WHERE_CLAUSE_CONGLOMERADO,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                ItemMarco itemMarco = new ItemMarco();
                itemMarco.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_id)));
                itemMarco.setAnio(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_anio)));
                itemMarco.setMes(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_mes)));
                itemMarco.setPeriodo(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_periodo)));
                itemMarco.setConglomerado(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_conglomerado)));
                itemMarco.setNorden(cursor.getString(cursor.getColumnIndex(SQLConstantes.marco_norden)));
                itemMarcos.add(itemMarco);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return itemMarcos;
    }

    public ArrayList<Hogar> getAllHogaresVivienda(String idVivienda){
        ArrayList<Hogar> hogars = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(idVivienda)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablahogares,
                    null,SQLConstantes.WHERE_CLAUSE_VIVIENDA_ID,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                Hogar hogar = new Hogar();
                hogar.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_id)));
                hogar.setId_vivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_id_vivienda)));
                hogar.setNom_ape(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_nom_ape)));
                hogar.setEstado(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_estado)));
                hogar.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_numero)));
                hogars.add(hogar);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return hogars;
    }

    public Hogar getHogar(String id){
        Hogar hogar = null;
        String[] whereArgs = new String[]{String.valueOf(id)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablahogares,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if (cursor.getCount() == 1){
                cursor.moveToFirst();
                hogar = new Hogar();
                hogar.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_id)));
                hogar.setId_vivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_id_vivienda)));
                hogar.setNom_ape(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_nom_ape)));
                hogar.setEstado(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_estado)));
                hogar.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_numero)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return hogar;
    }

    public ArrayList<VisitaEncuestador> getAllVisitasHogar(String idHogar){
        ArrayList<VisitaEncuestador> visitaEncuestadors = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(idHogar)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablavisitasencuestador,
                    null,SQLConstantes.WHERE_CLAUSE_HOGAR_ID,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                VisitaEncuestador visitaEncuestador = new VisitaEncuestador();
                visitaEncuestador.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_id)));
                visitaEncuestador.setId_vivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_id_vivienda)));
                visitaEncuestador.setId_hogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_id_hogar)));
                visitaEncuestador.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_numero)));
                visitaEncuestador.setVis_fecha_dd(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_dd)));
                visitaEncuestador.setVis_fecha_mm(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_mm)));
                visitaEncuestador.setVis_fecha_aa(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_aa)));
                visitaEncuestador.setVis_hor_ini(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_hor_ini)));
                visitaEncuestador.setVis_min_ini(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_min_ini)));
                visitaEncuestador.setVis_hor_fin(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_hor_fin)));
                visitaEncuestador.setVis_min_fin(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_min_fin)));
                visitaEncuestador.setProx_vis_fecha_dd(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_prox_vis_fecha_dd)));
                visitaEncuestador.setProx_vis_fecha_mm(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_prox_vis_fecha_mm)));
                visitaEncuestador.setProx_vis_fecha_aa(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_prox_vis_fecha_aa)));
                visitaEncuestador.setProx_vis_hor(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_prox_vis_hor)));
                visitaEncuestador.setProx_vis_min(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_prox_vis_min)));
                visitaEncuestador.setVis_resu(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_resu)));
                visitaEncuestador.setVis_resu_esp(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_resu_esp)));
                visitaEncuestadors.add(visitaEncuestador);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return visitaEncuestadors;
    }


    public ArrayList<Residente> getAllResidentesHogar(String idHogar){
        ArrayList<Residente> residentes = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(idHogar)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaresidentes,
                    null,SQLConstantes.WHERE_CLAUSE_HOGAR_ID,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                Residente residente = new Residente();
                residente.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_id)));
                residente.setId_informante(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_idInformante)));
                residente.setId_hogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_idHogar)));
                residente.setId_vivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_idVivienda)));
                residente.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_numero)));
                residente.setC2_p202(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p202)));
                residente.setC2_p203(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p203)));
                residente.setC2_p204(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p204)));
                residente.setC2_p205_a(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p205_a)));
                residente.setC2_p205_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p205_m)));
                residente.setC2_p206(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p206)));
                residentes.add(residente);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return residentes;
    }

    public Residente getResidente(String id){
        Residente residente = null;
        String[] whereArgs = new String[]{String.valueOf(id)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaresidentes,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if (cursor.getCount() == 1){
                cursor.moveToFirst();
                residente = new Residente();
                residente.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_id)));
                residente.setId_informante(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_idInformante)));
                residente.setId_hogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_idHogar)));
                residente.setId_vivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_idVivienda)));
                residente.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_numero)));
                residente.setC2_p202(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p202)));
                residente.setC2_p203(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p203)));
                residente.setC2_p204(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p204)));
                residente.setC2_p205_a(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p205_a)));
                residente.setC2_p205_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p205_m)));
                residente.setC2_p206(cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p206)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return residente;
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

    public void insertarElemento(String nombreTabla, ContentValues contentValues){
        sqLiteDatabase.insert(nombreTabla,null,contentValues);
    }

    public boolean existeElemento(String nombreTabla, String idEncuestado){
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

    public void actualizarElemento(String nombreTabla, ContentValues contentValues, String idEncuestado){
        String[] whereArgs = new String[]{idEncuestado};
        sqLiteDatabase.update(nombreTabla,contentValues,SQLConstantes.WHERE_CLAUSE_ID,whereArgs);
    }

    public String[] getValores(String nombreTabla, String[] variables, String id){
        String[] valores = new String[variables.length];
        String[] whereArgs = new String[]{id};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(nombreTabla, variables,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                for (int i = 0; i < variables.length; i++) {
                    valores[i] = cursor.getString(cursor.getColumnIndex(variables[i]));
                }
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        return valores;
    }

    public String getValor(String nombreTabla, String variable, String idEmpresa){
        String valor = "";
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(nombreTabla, new String[]{variable},SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                valor = cursor.getString(cursor.getColumnIndex(variable));
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        if(valor == null) valor = "";
        return valor;
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


    public Modulo3 getModulo3(String idEncuestado){
        Modulo3 modulo3 = null;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo3,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo3 = new Modulo3();
                modulo3.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_id)));
                modulo3.setIdInformante(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_idInformante)));
                modulo3.setIdHogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_idHogar)));
                modulo3.setIdVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_idVivienda)));
                modulo3.setC3_p301_d(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p301_d)));
                modulo3.setC3_p301_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p301_m)));
                modulo3.setC3_p301_a(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p301_a )));
                modulo3.setC3_p302(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p302 )));
                modulo3.setC3_p303_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p303_m )));
                modulo3.setC3_p303_a(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p303_a )));
                modulo3.setC3_p303_no_nacio(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p303_no_nacio)));
                modulo3.setC3_p304(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p304 )));
                modulo3.setC3_p305(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p305 )));
                modulo3.setC3_p305_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p305_o)));
                modulo3.setC3_p306(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p306 )));
                modulo3.setC3_p306_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p306_o )));
                modulo3.setC3_p307_d(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p307_d )));
                modulo3.setC3_p307_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p307_m )));
                modulo3.setC3_p307_a(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p307_a )));
                modulo3.setC3_p308_e(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p308_e )));
                modulo3.setC3_p308_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p308_m )));
                modulo3.setC3_p310_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_1)));
                modulo3.setC3_p310_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_2)));
                modulo3.setC3_p310_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_3 )));
                modulo3.setC3_p310_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_4 )));
                modulo3.setC3_p310_4_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_4_o )));
                modulo3.setC3_p310_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_5 )));
                modulo3.setC3_p311(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p311)));
                modulo3.setC3_p312_dep(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p312_dist)));
                modulo3.setC3_p312_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p312_prov)));
                modulo3.setC3_p312_dist(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p312_dep)));
                modulo3.setC3_p313(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p313)));
                modulo3.setC3_p314(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p314 )));
                modulo3.setC3_p314_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p314_o)));
                modulo3.setC3_p315_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_1 )));
                modulo3.setC3_p315_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_2)));
                modulo3.setC3_p315_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_3 )));
                modulo3.setC3_p315_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_4 )));
                modulo3.setC3_p315_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_5 )));
                modulo3.setC3_p315_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_6)));
                modulo3.setC3_p315_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_7)));
                modulo3.setC3_p315_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_8)));
                modulo3.setC3_p315_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_9)));
                modulo3.setC3_p315_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_10 )));
                modulo3.setC3_p315_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_11 )));
                modulo3.setC3_p315_11_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_11_o)));
                modulo3.setC3_p315_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_12)));
                modulo3.setC3_p316(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p316)));
                modulo3.setC3_p316_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p316_o )));
                modulo3.setC3_p317(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p317 )));
                modulo3.setC3_p317_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p317_o)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo3;
    }

    public Modulo4 getModulo4(String idEncuestado){
        Modulo4 modulo4 = null;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo4,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo4 = new Modulo4();
                modulo4.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_id)));
                modulo4.setIdInformante(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_idInformante)));
                modulo4.setIdHogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_idHogar)));
                modulo4.setIdVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_idVivienda)));
                modulo4.setC4_p401_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p401_1)));
                modulo4.setC4_p401_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p401_2)));
                modulo4.setC4_p401_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p401_3)));
                modulo4.setC4_p401_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p401_4)));
                modulo4.setC4_p401_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p401_5)));
                modulo4.setC4_p401_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p401_o)));
                modulo4.setC4_p402(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p402)));
                modulo4.setC4_p403_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_1)));
                modulo4.setC4_p403_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_2)));
                modulo4.setC4_p403_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_3)));
                modulo4.setC4_p403_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_4)));
                modulo4.setC4_p403_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_5)));
                modulo4.setC4_p403_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_6)));
                modulo4.setC4_p403_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_7)));
                modulo4.setC4_p403_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_8)));
                modulo4.setC4_p403_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_9)));
                modulo4.setC4_p403_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_10)));
                modulo4.setC4_p403_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_11)));
                modulo4.setC4_p403_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_12)));
                modulo4.setC4_p403_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_13)));
                modulo4.setC4_p403_14(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_14)));
                modulo4.setC4_p403_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p403_o)));
                modulo4.setC4_p404(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p404)));
                modulo4.setC4_p405_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p405_1)));
                modulo4.setC4_p405_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p405_2)));
                modulo4.setC4_p405_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p405_3)));
                modulo4.setC4_p405_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p405_4)));
                modulo4.setC4_p405_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p405_5)));
                modulo4.setC4_p405_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p405_6)));
                modulo4.setC4_p405_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p405_7)));
                modulo4.setC4_p406_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_1)));
                modulo4.setC4_p406_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_2)));
                modulo4.setC4_p406_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_3)));
                modulo4.setC4_p406_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_4)));
                modulo4.setC4_p406_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_5)));
                modulo4.setC4_p406_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_6)));
                modulo4.setC4_p406_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_7)));
                modulo4.setC4_p406_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_8)));
                modulo4.setC4_p406_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p406_o)));
                modulo4.setC4_p407_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_1)));
                modulo4.setC4_p407_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_2)));
                modulo4.setC4_p407_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_3)));
                modulo4.setC4_p407_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_4)));
                modulo4.setC4_p407_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_5)));
                modulo4.setC4_p407_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_6)));
                modulo4.setC4_p407_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_7)));
                modulo4.setC4_p407_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_8)));
                modulo4.setC4_p407_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_9)));
                modulo4.setC4_p407_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_10)));
                modulo4.setC4_p407_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_11)));
                modulo4.setC4_p407_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_12)));
                modulo4.setC4_p407_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_13)));
                modulo4.setC4_p407_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p407_o)));
                modulo4.setC4_p408_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_1)));
                modulo4.setC4_p408_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_2)));
                modulo4.setC4_p408_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_3)));
                modulo4.setC4_p408_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_4)));
                modulo4.setC4_p408_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_5)));
                modulo4.setC4_p408_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_6)));
                modulo4.setC4_p408_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_7)));
                modulo4.setC4_p408_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_8)));
                modulo4.setC4_p408_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_9)));
                modulo4.setC4_p408_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_10)));
                modulo4.setC4_p408_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_11)));
                modulo4.setC4_p408_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_12)));
                modulo4.setC4_p408_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_13)));
                modulo4.setC4_p408_14(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_14)));
                modulo4.setC4_p408_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p408_o)));
                modulo4.setC4_p409(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p409)));
                modulo4.setC4_p410(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p410)));
                modulo4.setC4_p411(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411)));
                modulo4.setC4_p412(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p412)));
                modulo4.setC4_p413(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p413)));
                modulo4.setC4_p414(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p414)));
                modulo4.setC4_p415_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_1)));
                modulo4.setC4_p415_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_2)));
                modulo4.setC4_p415_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_3)));
                modulo4.setC4_p415_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_4)));
                modulo4.setC4_p415_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_5)));
                modulo4.setC4_p415_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_6)));
                modulo4.setC4_p415_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_7)));
                modulo4.setC4_p415_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_8)));
                modulo4.setC4_p415_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_o)));
                modulo4.setC4_p415_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415_9)));
                modulo4.setC4_p416_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_1)));
                modulo4.setC4_p416_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_2)));
                modulo4.setC4_p416_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_3)));
                modulo4.setC4_p416_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_4)));
                modulo4.setC4_p416_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_5)));
                modulo4.setC4_p416_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_6)));
                modulo4.setObs_cap4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_obs_cap4)));
                modulo4.setC4_estado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_estado)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo4;
    }


}
