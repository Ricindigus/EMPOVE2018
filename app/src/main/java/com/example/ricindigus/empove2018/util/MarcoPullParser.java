package com.example.ricindigus.empove2018.util;

import android.content.Context;

import com.example.ricindigus.empove2018.modelo.pojos.Marco;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static android.os.Environment.getExternalStorageDirectory;


/**
 * Created by RICARDO on 10/08/2017.
 */

public class MarcoPullParser {
    private static final String _ID = "_ID";
    private static final String ANIO = "ANIO";
    private static final String MES = "MES";
    private static final String PERIODO = "PERIODO";
    private static final String ZONA = "ZONA";
    private static final String CCDD = "CCDD";
    private static final String DEPARTAMENTO = "DEPARTAMENTO";
    private static final String CCPP = "CCPP";
    private static final String PROVINCIA = "PROVINCIA";
    private static final String CCDI = "CCDI";
    private static final String DISTRITO = "DISTRITO";
    private static final String CODCCPP = "CODCCPP";
    private static final String NOMCCPP = "NOMCCPP";
    private static final String CONGLOMERADO = "CONGLOMERADO";
    private static final String NORDEN = "NROORDEN";
    private static final String MANZANA_ID = "MANZANA_ID";
    private static final String TIPVIA = "TIPVIA";
    private static final String NOMVIA = "NOMVIA";
    private static final String NROPTA = "NROPTA";
    private static final String LOTE = "LOTE";
    private static final String PISO = "PISO";
    private static final String MANZANA = "MANZANA";
    private static final String BLOCK = "BLOCK";
    private static final String INTERIOR = "INTERIOR";
    private static final String USUARIO_ID = "USUARIO_ID";
    private static final String USUARIO = "USUARIO";
    private static final String DNI = "DNI";
    private static final String NOMBRE = "NOMBRE";
    private static final String USUARIO_SUP_ID = "USUARIO_SUP_ID";


    private Marco currentMarco = null;
    private String currentTag = null;
    ArrayList<Marco> marcos = new ArrayList<Marco>();

    public ArrayList<Marco> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("marco.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTag(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return marcos;
    }

    public ArrayList<Marco> parseXML(Context context, String archivo){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            FileInputStream fis = null;
            try {
                File file = new File(archivo);
                FileInputStream fileInputStream = new FileInputStream(file);
                fis = new FileInputStream(file);
                xpp.setInput(fis, null);
                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTag(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return marcos;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentMarco!= null && currentTag != null){
            switch (currentTag){
                case _ID : currentMarco.set_id(xmlText);break;
                case ANIO : currentMarco.setAnio(xmlText);break;
                case MES : currentMarco.setMes(xmlText);break;
                case PERIODO :currentMarco.setPeriodo(xmlText);break;
                case ZONA : currentMarco.setZona(xmlText);break;
                case CCDD : currentMarco.setCcdd(xmlText);break;
                case DEPARTAMENTO : currentMarco.setDepartamento(xmlText);break;
                case CCPP : currentMarco.setCcpp(xmlText);break;
                case PROVINCIA : currentMarco.setProvincia(xmlText);break;
                case CCDI : currentMarco.setCcdi(xmlText);break;
                case DISTRITO : currentMarco.setDistrito(xmlText);break;
                case CODCCPP : currentMarco.setCodccpp(xmlText);break;
                case NOMCCPP : currentMarco.setNomccpp(xmlText);break;
                case CONGLOMERADO : currentMarco.setConglomerado(xmlText);break;
                case NORDEN : currentMarco.setNorden(xmlText);break;
                case MANZANA_ID : currentMarco.setManzana_id(xmlText);break;
                case MANZANA : currentMarco.setMza(xmlText);break;
                case TIPVIA : currentMarco.setTipvia(xmlText);break;
                case NOMVIA : currentMarco.setNomvia(xmlText);break;
                case NROPTA : currentMarco.setNropta(xmlText);break;
                case LOTE : currentMarco.setLote(xmlText);break;
                case PISO : currentMarco.setPiso(xmlText);break;
                case BLOCK : currentMarco.setBlock(xmlText);break;
                case INTERIOR : currentMarco.setInterior(xmlText);break;
                case USUARIO_ID : currentMarco.setUsuario_id(xmlText);break;
                case USUARIO : currentMarco.setUsuario(xmlText);break;
                case DNI : currentMarco.setDni(xmlText);break;
                case NOMBRE : currentMarco.setNombre(xmlText);break;
                case USUARIO_SUP_ID : currentMarco.setUsuario_sup_id(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("ITEM_MARCO")){
            currentMarco = new Marco();
            marcos.add(currentMarco);
        }else{
            currentTag = name;
        }
    }
}
