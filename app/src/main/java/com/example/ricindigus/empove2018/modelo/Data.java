package com.example.ricindigus.empove2018.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ricindigus.empove2018.modelo.pojos.Caratula;
import com.example.ricindigus.empove2018.modelo.pojos.Estado;
import com.example.ricindigus.empove2018.modelo.pojos.Funcionario;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.modelo.pojos.ItemMarco;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta309;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta318;
import com.example.ricindigus.empove2018.modelo.pojos.Marco;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1H;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1V;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo7;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo8;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.Ubigeo;
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
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_RESULTADO_ENCUESTADOR);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_RESULTADO_SUPERVISOR);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO1H);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO1V);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO2);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO3);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO3_P309_RUTAS);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO3_P318_PERSONAS);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO4);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO5);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO6);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO7);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO8);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_LAYOUTS);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FRAGMENTS);
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
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_RESULTADO_ENCUESTADOR);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_RESULTADO_SUPERVISOR);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO1H);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO1V);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FRAGMENTS);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO2);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO3);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO3_P309_RUTAS);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO3_P318_PERSONAS);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO4);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO5);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO6);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO7);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MODULO8);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_LAYOUTS);
            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FRAGMENTS);


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


    public int getNumeroPais(String id){
        int numero = 0;
        String[] whereArgs = new String[]{id};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablapaises,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                numero = cursor.getInt(cursor.getColumnIndex(SQLConstantes.paises_numero));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return numero;
    }

    public String getCodigoPais(int numero){
        String id = "";
        String[] whereArgs = new String[]{String.valueOf(numero)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablapaises,
                    null,SQLConstantes.WHERE_CLAUSE_NUMERO,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                id = cursor.getString(cursor.getColumnIndex(SQLConstantes.paises_id));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return id;
    }

    public int getNumeroRutaPais(String id){
        int numero = 0;
        String[] whereArgs = new String[]{id};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablarutas,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                numero = cursor.getInt(cursor.getColumnIndex(SQLConstantes.rutas_numero));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return numero;
    }

    public String getCodigoRutaPais(int numero){
        String id = "";
        String[] whereArgs = new String[]{String.valueOf(numero)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablarutas,
                    null,SQLConstantes.WHERE_CLAUSE_NUMERO,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                id = cursor.getString(cursor.getColumnIndex(SQLConstantes.rutas_id));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return id;
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
                hogar.setNroviven(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_nroviven)));
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
                hogar.setNroviven(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_nroviven)));
                hogar.setNropersonas(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_nropersonas)));
                hogar.setVive(cursor.getString(cursor.getColumnIndex(SQLConstantes.hogar_vive)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return hogar;
    }

    public Funcionario getFuncionario(String id){
        Funcionario funcionario = null;
        String[] whereArgs = new String[]{String.valueOf(id)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafuncionarios,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if (cursor.getCount() == 1){
                cursor.moveToFirst();
                funcionario = new Funcionario();
                funcionario.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.funcionarios_id)));
                funcionario.setDni_coor(cursor.getString(cursor.getColumnIndex(SQLConstantes.funcionarios_dni_coord)));
                funcionario.setDni_encu(cursor.getString(cursor.getColumnIndex(SQLConstantes.funcionarios_dni_encu)));
                funcionario.setDni_sup(cursor.getString(cursor.getColumnIndex(SQLConstantes.funcionarios_dni_sup)));
                funcionario.setNombre_coord(cursor.getString(cursor.getColumnIndex(SQLConstantes.funcionarios_nombre_coord)));
                funcionario.setNombre_encu(cursor.getString(cursor.getColumnIndex(SQLConstantes.funcionarios_nombre_encu)));
                funcionario.setNombre_sup(cursor.getString(cursor.getColumnIndex(SQLConstantes.funcionarios_nombre_sup)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return funcionario;
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

    public Cursor getCursorVisitas(String tablaVisitas, String idHogar){
        String[] whereArgs = new String[]{idHogar};
        Cursor cursor = null;
        cursor = sqLiteDatabase.query(tablaVisitas,null, SQLConstantes.WHERE_CLAUSE_HOGAR_ID,whereArgs,null,null,null);
        if(cursor != null) cursor.moveToFirst();
        return cursor;
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

    public ArrayList<String> getListaSpinnerResidentesHogar(String idHogar){
        ArrayList<String> residentes = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(idHogar)};
        residentes.add("Seleccione informante");
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaresidentes,
                    null,SQLConstantes.WHERE_CLAUSE_HOGAR_ID,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                String numero = cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_numero));
                String nombre = cursor.getString(cursor.getColumnIndex(SQLConstantes.residentes_c2_p202));
                String residente = numero + "-" + nombre;
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

    public String getCodEstado(String numero){
        String codigo = null;
        String[] whereArgs = new String[]{numero};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaestados,
                    null,SQLConstantes.WHERE_CLAUSE_NUMERO,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                codigo = cursor.getString(cursor.getColumnIndex(SQLConstantes.estado_id));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return codigo;
    }


    public String getCodMunicipio(String numero,String codEstado){
        String codigo = null;
        String[] whereArgs = new String[]{numero,codEstado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamunicipios,
                    null,SQLConstantes.WHERE_CLAUSE_NUMERO + " AND " + SQLConstantes.WHERE_CLAUSE_ESTADO_COD,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                codigo = cursor.getString(cursor.getColumnIndex(SQLConstantes.municipios_cod_municipio));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return codigo;
    }

    public ArrayList<String> getMunicipios(String idEstado){
        ArrayList<String> municipios = new ArrayList<>();
        municipios.add("Seleccione municipio");
        String[] whereArgs = new String[]{String.valueOf(idEstado)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamunicipios,
                    null,SQLConstantes.WHERE_CLAUSE_ESTADO_COD,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                String municipio = cursor.getString(cursor.getColumnIndex(SQLConstantes.municipios_nom_municipio));
                municipios.add(municipio);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return municipios;
    }


    public ArrayList<String> getUbigeos(){
        ArrayList<String> ubigeos = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaubigeo, null,null,null,null,null,null);
            while (cursor.moveToNext()){
                String ubigeo = cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_descripcion));
                ubigeos.add(ubigeo);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return ubigeos;
    }

    public Ubigeo getUbigeo(String descripcion){
        Ubigeo ubigeo = null;
        String[] whereArgs = new String[]{descripcion};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaubigeo,
                    null,SQLConstantes.WHERE_CLAUSE_DESCRIPCION,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                ubigeo = new Ubigeo();
                ubigeo.setCod_departamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_cod_departamento)));
                ubigeo.setCod_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_cod_provincia)));
                ubigeo.setCod_distrito(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_cod_distrito)));
                ubigeo.setNom_departamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_nom_departamento)));
                ubigeo.setNom_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_nom_provincia)));
                ubigeo.setNom_distrito(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_nom_distrito)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return ubigeo;
    }

    public Ubigeo getUbigeoxId(String id){
        Ubigeo ubigeo = null;
        String[] whereArgs = new String[]{id};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaubigeo,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                ubigeo = new Ubigeo();
                ubigeo.setCod_departamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_cod_departamento)));
                ubigeo.setCod_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_cod_provincia)));
                ubigeo.setCod_distrito(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_cod_distrito)));
                ubigeo.setNom_departamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_nom_departamento)));
                ubigeo.setNom_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_nom_provincia)));
                ubigeo.setNom_distrito(cursor.getString(cursor.getColumnIndex(SQLConstantes.ubigeo_nom_distrito)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return ubigeo;
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

    public void actualizarValor(String nombreTabla, String variable, String valor, String idEncuestado){
        String[] whereArgs = new String[]{idEncuestado};
        ContentValues contentValues = new ContentValues();
        contentValues.put(variable,valor);
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

    public String getValor(String nombreTabla, String variable, String id){
        String valor = "";
        String[] whereArgs = new String[]{id};
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

    public boolean ocultarLayoutPregunta(String varLayoutPregunta,String idencuestado){
        boolean ocultar = false;
        if (getValor(SQLConstantes.tablalayouts,varLayoutPregunta,idencuestado).equals("0")) ocultar = true;
        return ocultar;
    }

    public void eliminarDato(String tabla, String id){
        String[] whereArgs = new String[]{id};
        sqLiteDatabase.delete(tabla,SQLConstantes.WHERE_CLAUSE_ID,whereArgs);
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

    public Modulo1V getModulo1V(String idEncuestado){
        Modulo1V modulo1V = null;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo1v,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo1V = new Modulo1V();
                modulo1V.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_id)));
                modulo1V.setC1_p101(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p101)));
                modulo1V.setC1_p101_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p101_o)));
                modulo1V.setC1_p102(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p102)));
                modulo1V.setC1_p102_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p102_o)));
                modulo1V.setC1_p103(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p103)));
                modulo1V.setC1_p103_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p103_o)));
                modulo1V.setC1_p104(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p104)));
                modulo1V.setC1_p104_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p104_o)));
                modulo1V.setC1_p105(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p105)));
                modulo1V.setC1_p106(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p106)));
                modulo1V.setC1_p107(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_v_c1_p107)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo1V;
    }

    public Modulo1H getModulo1H(String idEncuestado){
        Modulo1H modulo1H = null;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo1h,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo1H = new Modulo1H();
                modulo1H.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_id)));
                modulo1H.setIdVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_idVivienda)));
                modulo1H.setC1_p108(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p108)));
                modulo1H.setC1_p108_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p108_o)));
                modulo1H.setC1_p109(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p109)));
                modulo1H.setC1_p109_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p109_o)));
                modulo1H.setC1_p110(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p110)));
                modulo1H.setC1_p110_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p110_o)));
                modulo1H.setC1_p111(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p111)));
                modulo1H.setC1_p111_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p111_o)));
                modulo1H.setC1_p112(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p112)));
                modulo1H.setC1_p112_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p112_o)));
                modulo1H.setC1_p113_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_1)));
                modulo1H.setC1_p113_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_2)));
                modulo1H.setC1_p113_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_3)));
                modulo1H.setC1_p113_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_4)));
                modulo1H.setC1_p113_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_5)));
                modulo1H.setC1_p113_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_6)));
                modulo1H.setC1_p113_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_7)));
                modulo1H.setC1_p113_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_8)));
                modulo1H.setC1_p113_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_9)));
                modulo1H.setC1_p113_7_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_7_o)));
                modulo1H.setC1_p113_8_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_8_o)));
                modulo1H.setC1_p113_9_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo1_h_c1_p113_9_o)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo1H;
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
                modulo3.setC3_p308_e(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p308_e_seleccion )));
                modulo3.setC3_p308_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p308_m_seleccion )));
                modulo3.setC3_p310_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_1)));
                modulo3.setC3_p310_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_2)));
                modulo3.setC3_p310_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_3 )));
                modulo3.setC3_p310_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p310_4 )));
                modulo3.setC3_p311(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p311)));
                modulo3.setC3_p312_dep(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p312_dep)));
                modulo3.setC3_p312_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p312_prov)));
                modulo3.setC3_p312_dist(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p312_dist)));
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
                modulo3.setC3_p315_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_10)));
                modulo3.setC3_p315_10_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p315_10_o)));
                modulo3.setC3_p316(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p316)));
                modulo3.setC3_p316_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p316_o )));
                modulo3.setC3_p317(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p317 )));
                modulo3.setC3_p318(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo3;
    }

    public ArrayList<M3Pregunta309> getAllM3Pregunta309(String idEncuestado){
        ArrayList<M3Pregunta309> m3Pregunta309s = new ArrayList<>();
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablam3p309rutas,
                    null,SQLConstantes.WHERE_CLAUSE_ID_ENCUESTADO,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                M3Pregunta309 m3Pregunta309 = new M3Pregunta309();
                m3Pregunta309.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p309_id)));
                m3Pregunta309.setId_encuestado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p309_idEncuestado)));
                m3Pregunta309.setC3_p309_p(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_p)));
                m3Pregunta309.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p309_numero)));
                m3Pregunta309.setC3_p309_p_nom(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_p_nom)));
                m3Pregunta309.setC3_p309_c(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_c)));
                m3Pregunta309.setC3_p309_mod(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_mod)));
                m3Pregunta309.setC3_p309_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_m)));
                m3Pregunta309.setC3_p309_a(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_a)));
                m3Pregunta309.setC3_p309_m_cod(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_m_cod)));
                m3Pregunta309.setC3_p309_a_cod(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_a_cod)));
                m3Pregunta309s.add(m3Pregunta309);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return m3Pregunta309s;
    }

    public M3Pregunta309 getM3Pregunta309(String id){
        M3Pregunta309 m3Pregunta309 = null;
        String[] whereArgs = new String[]{id};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablam3p309rutas,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                m3Pregunta309 = new M3Pregunta309();
                m3Pregunta309.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p309_id)));
                m3Pregunta309.setId_encuestado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p309_idEncuestado)));
                m3Pregunta309.setC3_p309_p(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_p)));
                m3Pregunta309.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p309_numero)));
                m3Pregunta309.setC3_p309_p_nom(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_p_nom)));
                m3Pregunta309.setC3_p309_c(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_c)));
                m3Pregunta309.setC3_p309_mod(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_mod)));
                m3Pregunta309.setC3_p309_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_m)));
                m3Pregunta309.setC3_p309_a(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_a)));
                m3Pregunta309.setC3_p309_m_cod(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_m_cod)));
                m3Pregunta309.setC3_p309_a_cod(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p309_a_cod)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return m3Pregunta309;
    }

    public ArrayList<M3Pregunta318> getAllM3Pregunta318(String idEncuestado){
        ArrayList<M3Pregunta318> m3Pregunta318s = new ArrayList<>();
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablam3p318personas,
                    null,SQLConstantes.WHERE_CLAUSE_ID_ENCUESTADO,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                M3Pregunta318 m3Pregunta318 = new M3Pregunta318();
                m3Pregunta318.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p318_id)));
                m3Pregunta318.setIdEncuestado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p318_idEncuestado)));
                m3Pregunta318.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p318_numero)));
                m3Pregunta318.setC3_p318_f(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318_f)));
                m3Pregunta318.setC3_p318_s(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318_s)));
                m3Pregunta318.setC3_p318_e(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318_e)));
                m3Pregunta318.setC3_p318_p(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318_p)));
                m3Pregunta318s.add(m3Pregunta318);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return m3Pregunta318s;
    }

    public M3Pregunta318 getM3Pregunta318(String id){
        M3Pregunta318 m3Pregunta318 = null;
        String[] whereArgs = new String[]{id};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablam3p318personas,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                m3Pregunta318 = new M3Pregunta318();
                m3Pregunta318.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p318_id)));
                m3Pregunta318.setIdEncuestado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p318_idEncuestado)));
                m3Pregunta318.setNumero(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_p318_numero)));
                m3Pregunta318.setC3_p318_f(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318_f)));
                m3Pregunta318.setC3_p318_s(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318_s)));
                m3Pregunta318.setC3_p318_e(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318_e)));
                m3Pregunta318.setC3_p318_p(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo3_c3_p318_p)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return m3Pregunta318;
    }

    public Modulo5 getModulo5(String idEncuestado){
        Modulo5 modulo5 = null;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo5,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo5 = new Modulo5();
                modulo5.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_id)));
                modulo5.setIdInformante(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_idInformante)));
                modulo5.setIdHogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_idHogar)));
                modulo5.setIdVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_idVivienda)));
                modulo5.setC5_p501(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p501)));
                modulo5.setC5_p502_c(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p502_c)));
                modulo5.setC5_p502(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p502)));
                modulo5.setC5_p503(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p503)));
                modulo5.setC5_p504(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p504)));
                modulo5.setC5_p505(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p505)));
                modulo5.setC5_p506_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p506_1)));
                modulo5.setC5_p506_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p506_2)));
                modulo5.setC5_p506_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p506_3)));
                modulo5.setC5_p506_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p506_4)));
                modulo5.setC5_p507(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p507)));
                modulo5.setC5_p507_dist(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p507_dist)));
                modulo5.setC5_p507_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p507_prov)));
                modulo5.setC5_p507_dep(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p507_dep)));
                modulo5.setC5_p508_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_1)));
                modulo5.setC5_p508_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_2)));
                modulo5.setC5_p508_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_3)));
                modulo5.setC5_p508_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_4)));
                modulo5.setC5_p508_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_5)));
                modulo5.setC5_p508_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_6)));
                modulo5.setC5_p508_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_7)));
                modulo5.setC5_p508_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_8)));
                modulo5.setC5_p508_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_9)));
                modulo5.setC5_p508_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_10)));
                modulo5.setC5_p508_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_11)));
                modulo5.setC5_p508_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p508_o)));
                modulo5.setC5_p509(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p509)));
                modulo5.setC5_p510(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p510)));
                modulo5.setC5_p511(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p511)));
                modulo5.setC5_p511_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p511_o)));
                modulo5.setC5_p512(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p512)));
                modulo5.setC5_p512_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p512_o)));
                modulo5.setC5_p513(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p513)));
                modulo5.setC5_p513_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_p513_o)));
                modulo5.setObs_cap5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_obs_cap5)));
                modulo5.setC5_estado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo5_c5_estado)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo5;
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
                modulo4.setC4_p409(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p409)));
                modulo4.setC4_p410(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p410)));
                modulo4.setC4_p411_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_1)));
                modulo4.setC4_p411_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_2)));
                modulo4.setC4_p411_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_3)));
                modulo4.setC4_p411_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_4)));
                modulo4.setC4_p411_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_5)));
                modulo4.setC4_p411_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_6)));
                modulo4.setC4_p411_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_7)));
                modulo4.setC4_p411_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_8)));
                modulo4.setC4_p411_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_9)));
                modulo4.setC4_p411_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_10)));
                modulo4.setC4_p411_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_11)));
                modulo4.setC4_p411_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_12)));
                modulo4.setC4_p411_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_13)));
                modulo4.setC4_p411_14(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_14)));
                modulo4.setC4_p411_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p411_o)));
                modulo4.setC4_p412(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p412)));
                modulo4.setC4_p413(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p413)));
                modulo4.setC4_p414(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p414)));
                modulo4.setC4_p415(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p415)));
                modulo4.setC4_p416_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_1)));
                modulo4.setC4_p416_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_2)));
                modulo4.setC4_p416_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_3)));
                modulo4.setC4_p416_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_4)));
                modulo4.setC4_p416_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_5)));
                modulo4.setC4_p416_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_6)));
                modulo4.setC4_p416_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_7)));
                modulo4.setC4_p416_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_8)));
                modulo4.setC4_p416_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_p416_o)));
                modulo4.setObs_cap4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_obs_cap4)));
                modulo4.setC4_estado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo4_c4_estado)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo4;
    }

    public Modulo6 getModulo6(String idEncuestado){
        Modulo6 modulo6 = null;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo6,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo6 = new Modulo6();
                modulo6.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_id)));
                modulo6.setIdInformante(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_idInformante)));
                modulo6.setIdHogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_idHogar)));
                modulo6.setIdVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_idVivienda)));
                modulo6.setC6_p601(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p601)));
                modulo6.setC6_p602(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p602)));
                modulo6.setC6_p603(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p603)));
                modulo6.setC6_p604_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_1)));
                modulo6.setC6_p604_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_2)));
                modulo6.setC6_p604_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_3)));
                modulo6.setC6_p604_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_4)));
                modulo6.setC6_p604_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_5)));
                modulo6.setC6_p604_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_6)));
                modulo6.setC6_p604_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_7)));
                modulo6.setC6_p604_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_8)));
                modulo6.setC6_p604_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_9)));
                modulo6.setC6_p604_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_10)));
                modulo6.setC6_p604_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_11)));
                modulo6.setC6_p604_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p604_o)));
                modulo6.setC6_p605(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p605)));
                modulo6.setC6_p606(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p606)));
                modulo6.setC6_p607(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p607)));
                modulo6.setC6_p608(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p608)));
                modulo6.setC6_p608_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p608_o)));
                modulo6.setC6_p609(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p609)));
                modulo6.setC6_p610_pd(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_pd)));
                modulo6.setC6_p610_pl(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_pl)));
                modulo6.setC6_p610_pm(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_pm)));
                modulo6.setC6_p610_pmi(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_pmi)));
                modulo6.setC6_p610_pj(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_pj)));
                modulo6.setC6_p610_pv(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_pv)));
                modulo6.setC6_p610_ps(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_ps)));
                modulo6.setC6_p610_pt(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_pt)));
                modulo6.setC6_p610_sd(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_sd)));
                modulo6.setC6_p610_sl(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_sl)));
                modulo6.setC6_p610_sm(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_sm)));
                modulo6.setC6_p610_smi(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_smi)));
                modulo6.setC6_p610_sj(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_sj)));
                modulo6.setC6_p610_sv(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_sv)));
                modulo6.setC6_p610_ss(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_ss)));
                modulo6.setC6_p610_st(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_st)));
                modulo6.setC6_p610_t(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p610_t)));
                modulo6.setC6_p611(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p611)));
                modulo6.setC6_p612(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p612)));
                modulo6.setC6_p612_nro(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p612_nro)));
                modulo6.setC6_p613(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p613)));
                modulo6.setC6_p614_mon(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p614_mon)));
                modulo6.setC6_p614_esp(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p614_esp)));
                modulo6.setC6_p615_mon(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p615_mon)));
                modulo6.setC6_p615_esp(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p615_esp)));
                modulo6.setC6_p616_mon(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p616_mon)));
                modulo6.setC6_p616_esp(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p616_esp)));
                modulo6.setC6_p616_nas(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p616_nas)));
                modulo6.setC6_p617(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p617)));
                modulo6.setC6_p617_dist(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p617_dist)));
                modulo6.setC6_p617_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p617_prov)));
                modulo6.setC6_p617_dep(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p617_dep)));
                modulo6.setC6_p625_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p625_1)));
                modulo6.setC6_p625_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p625_2)));
                modulo6.setC6_p625_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p625_3)));
                modulo6.setC6_p625_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p625_4)));
                modulo6.setC6_p625_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p625_5)));
                modulo6.setC6_p625_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p625_6)));
                modulo6.setC6_p625_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p625_o)));
                modulo6.setC6_p618(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p618)));
                modulo6.setC6_p619_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_1)));
                modulo6.setC6_p619_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_2)));
                modulo6.setC6_p619_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_3)));
                modulo6.setC6_p619_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_4)));
                modulo6.setC6_p619_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_5)));
                modulo6.setC6_p619_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_6)));
                modulo6.setC6_p619_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_7)));
                modulo6.setC6_p619_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_8)));
                modulo6.setC6_p619_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_9)));
                modulo6.setC6_p619_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p619_o)));
                modulo6.setC6_p620(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p620)));
                modulo6.setC6_p621(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p621)));
                modulo6.setC6_p622(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p622)));
                modulo6.setC6_p622_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p622_o)));
                modulo6.setC6_p623(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p623)));
                modulo6.setC6_p623_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p623_o)));
                modulo6.setC6_p624(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p624)));
                modulo6.setC6_p626(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p626)));
                modulo6.setC6_p627(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p627)));
                modulo6.setC6_p628(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p628)));
                modulo6.setC6_p629_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_1)));
                modulo6.setC6_p629_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_2)));
                modulo6.setC6_p629_1_f(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_1_f)));
                modulo6.setC6_p629_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_4)));
                modulo6.setC6_p629_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_o)));
                modulo6.setC6_p629_1_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_1_m)));
                modulo6.setC6_p629_2_f(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_2_f)));
                modulo6.setC6_p629_2_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_2_m)));
                modulo6.setC6_p629_2_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_2_m)));
                modulo6.setC6_p629_3_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_3_m)));
                modulo6.setC6_p629_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_3)));
                modulo6.setC6_p629_4_f(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_4_f)));
                modulo6.setC6_p629_4_m(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p629_4_m)));
                modulo6.setC6_p630_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_1)));
                modulo6.setC6_p630_1med(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_1med)));
                modulo6.setC6_p630_1o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_1o)));
                modulo6.setC6_p630_1frec(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_1frec)));
                modulo6.setC6_p630_1mont(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_1mont)));
                modulo6.setC6_p630_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_2)));
                modulo6.setC6_p630_2med(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_2med)));
                modulo6.setC6_p630_2o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_2o)));
                modulo6.setC6_p630_2frec(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_2frec)));
                modulo6.setC6_p630_2mont(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_p630_2mont)));
                modulo6.setObs_cap6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_obs_cap6)));
                modulo6.setC6_estado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo6_c6_estado)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo6;
    }

    public boolean menor_edad_hogar(String idHogar){
        boolean existe=false;
        String[] whereArgs = new String[]{idHogar};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaresidentes,null, SQLConstantes.WHERE_CLAUSE_EXISTE_MENOR,whereArgs,null,null,null);
            if(cursor.getCount() >= 1){
                existe = true;
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return existe;
    }

    public Modulo7 getModulo7(String idPersona) {
        Modulo7 modulo7 = null;
        String[] whereArgs = new String[]{idPersona};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo7,
                    null,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo7 = new Modulo7();
                modulo7.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_id)));
                modulo7.setIdInformante(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_idInformante)));
                modulo7.setIdHogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_idHogar)));
                modulo7.setIdVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_idVivienda)));
                modulo7.setC7_p701(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p701)));
                modulo7.setC7_p702_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_1)));
                modulo7.setC7_p702_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_2)));
                modulo7.setC7_p702_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_3)));
                modulo7.setC7_p702_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_4)));
                modulo7.setC7_p702_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_5)));
                modulo7.setC7_p702_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_6)));
                modulo7.setC7_p702_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_7)));
                modulo7.setC7_p702_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_8)));
                modulo7.setC7_p702_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_9)));
                modulo7.setC7_p702_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_10)));
                modulo7.setC7_p702_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p702_o)));
                modulo7.setC7_p703(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p703)));
                modulo7.setC7_p704_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p704_1)));
                modulo7.setC7_p704_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p704_2)));
                modulo7.setC7_p704_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p704_3)));
                modulo7.setC7_p704_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p704_4)));
                modulo7.setC7_p704_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p704_5)));
                modulo7.setC7_p704_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p704_6)));
                modulo7.setC7_p704_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p704_o)));
                modulo7.setC7_p705_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p705_1)));
                modulo7.setC7_p705_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p705_2)));
                modulo7.setC7_p705_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p705_3)));
                modulo7.setC7_p705_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p705_4)));
                modulo7.setC7_p705_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p705_5)));
                modulo7.setC7_p705_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p705_6)));
                modulo7.setC7_p705_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p705_7)));
                modulo7.setC7_p705_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p705_o)));
                modulo7.setC7_p706(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p706)));
                modulo7.setC7_p707(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p707)));
                modulo7.setC7_p707_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p707_o)));
                modulo7.setC7_p708_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p708_1)));
                modulo7.setC7_p708_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p708_2)));
                modulo7.setC7_p708_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p708_3)));
                modulo7.setC7_p708_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p708_4)));
                modulo7.setC7_p708_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p708_5)));
                modulo7.setC7_p709_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_1)));
                modulo7.setC7_p709_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_2)));
                modulo7.setC7_p709_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_3)));
                modulo7.setC7_p709_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_4)));
                modulo7.setC7_p709_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_5)));
                modulo7.setC7_p709_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_6)));
                modulo7.setC7_p709_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_7)));
                modulo7.setC7_p709_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_8)));
                modulo7.setC7_p709_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_9)));
                modulo7.setC7_p709_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_10)));
                modulo7.setC7_p709_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_p709_o)));
                modulo7.setObs_cap7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_obs_cap7)));
                modulo7.setC7_estado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo7_c7_estado)));

            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return modulo7;
    }

    public Modulo8 getModulo8(String idEncuestado) {
        Modulo8 modulo8 = null;
        String[] whereArgs = new String[]{idEncuestado};
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.query(SQLConstantes.tablamodulo8,
                    null,SQLConstantes.WHERE_CLAUSE_ID, whereArgs, null,null, null);
            if(cursor.getCount() ==1){
                cursor.moveToFirst();
                modulo8 = new Modulo8();
                modulo8.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_id)));
                modulo8.setIdInformante(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_idInformante)));
                modulo8.setIdHogar(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_idHogar)));
                modulo8.setIdVivienda(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_idVivienda)));
                modulo8.setC8_p801(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p801)));
                modulo8.setC8_p802(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p802)));
                modulo8.setC8_p803(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p803)));
                modulo8.setC8_p804(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p804)));
                modulo8.setC8_p805_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p805_1)));
                modulo8.setC8_p805_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p805_2)));
                modulo8.setC8_p805_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p805_3)));
                modulo8.setC8_p805_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p805_4)));
                modulo8.setC8_p805_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p805_5)));
                modulo8.setC8_p806_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p806_1)));
                modulo8.setC8_p806_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p806_2)));
                modulo8.setC8_p806_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p806_3)));
                modulo8.setC8_p806_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p806_4)));
                modulo8.setC8_p806_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p806_5)));
                modulo8.setC8_p806_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p806_6)));
                modulo8.setC8_p807(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p807)));
                modulo8.setC8_p808_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_1)));
                modulo8.setC8_p808_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_2)));
                modulo8.setC8_p808_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_3)));
                modulo8.setC8_p808_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_4)));
                modulo8.setC8_p808_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_5)));
                modulo8.setC8_p808_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_6)));
                modulo8.setC8_p808_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_7)));
                modulo8.setC8_p808_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_8)));
                modulo8.setC8_p808_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_9)));
                modulo8.setC8_p808_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_10)));
                modulo8.setC8_p808_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_11)));
                modulo8.setC8_p808_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_12)));
                modulo8.setC8_p808_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_13)));
                modulo8.setC8_p808_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p808_o)));
                modulo8.setC8_p809(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p809)));
                modulo8.setC8_p810_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_1)));
                modulo8.setC8_p810_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_2)));
                modulo8.setC8_p810_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_3)));
                modulo8.setC8_p810_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_4)));
                modulo8.setC8_p810_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_5)));
                modulo8.setC8_p810_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_6)));
                modulo8.setC8_p810_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_7)));
                modulo8.setC8_p810_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_8)));
                modulo8.setC8_p810_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_9)));
                modulo8.setC8_p810_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_10)));
                modulo8.setC8_p810_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_11)));
                modulo8.setC8_p810_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_12)));
                modulo8.setC8_p810_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_13)));
                modulo8.setC8_p810_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p810_o)));
                modulo8.setC8_p811(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p811)));
                modulo8.setC8_p812(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p812)));
                modulo8.setC8_p813_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_1)));
                modulo8.setC8_p813_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_2)));
                modulo8.setC8_p813_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_3)));
                modulo8.setC8_p813_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_4)));
                modulo8.setC8_p813_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_5)));
                modulo8.setC8_p813_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_6)));
                modulo8.setC8_p813_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_7)));
                modulo8.setC8_p813_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_8)));
                modulo8.setC8_p813_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_9)));
                modulo8.setC8_p813_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_10)));
                modulo8.setC8_p813_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_11)));
                modulo8.setC8_p813_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_12)));
                modulo8.setC8_p813_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_13)));
                modulo8.setC8_p813_14(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_14)));
                modulo8.setC8_p813_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p813_o)));
                modulo8.setC8_p814_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p814_1)));
                modulo8.setC8_p814_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p814_2)));
                modulo8.setC8_p814_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p814_3)));
                modulo8.setC8_p814_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p814_4)));
                modulo8.setC8_p814_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p814_5)));
                modulo8.setC8_p814_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p814_6)));
                modulo8.setC8_p814_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p814_7)));
                modulo8.setC8_p814_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p814_8)));
                modulo8.setC8_p815(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p815)));
                modulo8.setC8_p816_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_1)));
                modulo8.setC8_p816_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_2)));
                modulo8.setC8_p816_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_3)));
                modulo8.setC8_p816_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_4)));
                modulo8.setC8_p816_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_5)));
                modulo8.setC8_p816_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_6)));
                modulo8.setC8_p816_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_7)));
                modulo8.setC8_p816_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_8)));
                modulo8.setC8_p816_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_9)));
                modulo8.setC8_p816_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_10)));
                modulo8.setC8_p816_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_11)));
                modulo8.setC8_p816_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_12)));
                modulo8.setC8_p816_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_13)));
                modulo8.setC8_p816_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p816_o)));
                modulo8.setC8_p817(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p817)));
                modulo8.setC8_p818(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p818)));
                modulo8.setC8_p819_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_1)));
                modulo8.setC8_p819_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_2)));
                modulo8.setC8_p819_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_3)));
                modulo8.setC8_p819_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_4)));
                modulo8.setC8_p819_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_5)));
                modulo8.setC8_p819_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_6)));
                modulo8.setC8_p819_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_7)));
                modulo8.setC8_p819_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_8)));
                modulo8.setC8_p819_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_9)));
                modulo8.setC8_p819_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_10)));
                modulo8.setC8_p819_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_11)));
                modulo8.setC8_p819_12(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_12)));
                modulo8.setC8_p819_13(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_13)));
                modulo8.setC8_p819_14(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_14)));
                modulo8.setC8_p819_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p819_o)));
                modulo8.setC8_p820_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_1)));
                modulo8.setC8_p820_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_2)));
                modulo8.setC8_p820_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_3)));
                modulo8.setC8_p820_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_4)));
                modulo8.setC8_p820_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_5)));
                modulo8.setC8_p820_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_6)));
                modulo8.setC8_p820_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_7)));
                modulo8.setC8_p820_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_8)));
                modulo8.setC8_p820_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_9)));
                modulo8.setC8_p820_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_10)));
                modulo8.setC8_p820_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_11)));
                modulo8.setC8_p820_o(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p820_o)));
                modulo8.setC8_p821_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p821_1)));
                modulo8.setC8_p821_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p821_2)));
                modulo8.setC8_p821_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p821_3)));
                modulo8.setC8_p821_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p821_4)));
                modulo8.setC8_p821_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p821_5)));
                modulo8.setC8_p821_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p821_6)));
                modulo8.setC8_p821_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p821_7)));
                modulo8.setC8_p821_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p821_8)));
                modulo8.setC8_p822(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p822)));
                modulo8.setC8_p823_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p823_1)));
                modulo8.setC8_p823_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p823_2)));
                modulo8.setC8_p823_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p823_3)));
                modulo8.setC8_p823_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p823_4)));
                modulo8.setC8_p823_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_p823_5)));
                modulo8.setObs_cap8(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_obs_cap8)));
                modulo8.setC8_estado(cursor.getString(cursor.getColumnIndex(SQLConstantes.modulo8_c8_estado)));

            }

        }finally {
            if (cursor!=null) cursor.close();
        }

        return modulo8;
    }


    public void borrarAllData(String tabla){
        sqLiteDatabase.execSQL("delete from "+ tabla);
    }

}
































