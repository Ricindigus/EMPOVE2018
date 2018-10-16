package com.example.ricindigus.empove2018.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public ArrayList<Vivienda> getAllViviendas(int idUsuario){
        ArrayList<Vivienda>  viviendas = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(idUsuario)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablamarco,
                    null,SQLConstantes.WHERE_CLAUSE_USUARIO_ID,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                Vivienda vivienda = new Vivienda();
                vivienda.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_id)));
                vivienda.setAnio(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_anio)));
                vivienda.setMes(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_mes)));
                vivienda.setPeriodo(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_periodo)));
                vivienda.setConglomerado(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_conglomerado)));
                vivienda.setNorden(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_norden)));
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
                vivienda.setAnio(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_anio)));
                vivienda.setMes(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_mes)));
                vivienda.setPeriodo(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_periodo)));
                vivienda.setConglomerado(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_conglomerado)));
                vivienda.setNorden(cursor.getInt(cursor.getColumnIndex(SQLConstantes.marco_norden)));
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
}
