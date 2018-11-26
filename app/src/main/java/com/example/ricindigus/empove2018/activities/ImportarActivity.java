package com.example.ricindigus.empove2018.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Caratula;
import com.example.ricindigus.empove2018.modelo.pojos.Funcionario;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta309;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta318;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1H;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1V;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo7;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo8;
import com.example.ricindigus.empove2018.modelo.pojos.ResVisitaEncuestador;
import com.example.ricindigus.empove2018.modelo.pojos.ResVisitaSupervisor;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.VisitaEncuestador;
import com.example.ricindigus.empove2018.modelo.pojos.VisitaSupervisor;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


import static android.os.Environment.getExternalStorageDirectory;


public class ImportarActivity extends AppCompatActivity {
    private TextView txtImportar;
    private Button btnImportar;
    private Button btnVolver;
    private EditText edtArchivo;


    private Caratula caratula;
    private ArrayList<Hogar> hogares;
    private Hogar currentHogar;
    private ArrayList<VisitaEncuestador> visitaEncuestadors;
    private VisitaEncuestador currentVisitaEncuestador;
    private ArrayList<VisitaSupervisor> visitaSupervisors;
    private VisitaEncuestador currentVisitaSupervisor;
    private ResVisitaEncuestador resVisitaEncuestador;
    private ResVisitaSupervisor resVisitaSupervisor;
    private Funcionario funcionario;
    private Modulo1V modulo1V;
    private ArrayList<Modulo1H> modulo1HS;
    private Modulo1H currentModulo1H;
    private ArrayList<Residente> residentes;
    private Residente currentResidente;
    private ArrayList<Modulo3> modulo3s;
    private Modulo3 currentModulo3;
    private ArrayList<M3Pregunta309> m3Pregunta309s;
    private M3Pregunta309 currentM3Pregunta309;
    private ArrayList<M3Pregunta318> m3Pregunta318s;
    private M3Pregunta318 currentM3Pregunta318;
    private ArrayList<Modulo4> modulo4s;
    private Modulo4 currentModulo4;
    private ArrayList<Modulo5> modulo5s;
    private Modulo5 currentModulo5;
    private ArrayList<Modulo6> modulo6s;
    private Modulo6 currentModulo6;
    private ArrayList<Modulo7> modulo7s;
    private Modulo7 currentModulo7;
    private ArrayList<Modulo8> modulo8s;
    private Modulo8 currentModulo8;
    private String currentTag = null;
    private String currentVariable = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importar);

        txtImportar = (TextView) findViewById(R.id.txtImportar);
        btnImportar = (Button) findViewById(R.id.importacion_btnImportar);
        btnVolver = (Button) findViewById(R.id.importacion_btnVolver);
        edtArchivo = (EditText) findViewById(R.id.importacion_edtArchivo);

        btnImportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreArchivo = edtArchivo.getText().toString() + ".xml";
                parseXMLImportar(nombreArchivo);
                Toast.makeText(ImportarActivity.this, "Empresa importada", Toast.LENGTH_SHORT).show();
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void parseXMLImportar(String nombreArchivo){
        caratula = new Caratula();
        hogares = new ArrayList<>();
        visitaEncuestadors = new ArrayList<>();
        funcionario = new Funcionario();
        modulo1V = new Modulo1V();
        modulo1HS = new ArrayList<>();
        residentes = new ArrayList<>();
        modulo3s = new ArrayList<>();
        m3Pregunta309s = new ArrayList<>();
        m3Pregunta318s = new ArrayList<>();
        modulo4s = new ArrayList<>();
        modulo5s = new ArrayList<>();
        modulo6s = new ArrayList<>();
        modulo7s = new ArrayList<>();
        modulo8s = new ArrayList<>();

        XmlPullParserFactory factory;
        FileInputStream fis = null;
        try {
            StringBuilder sb = new StringBuilder();
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "ENPOVE2018");
            File file = new File(nuevaCarpeta, nombreArchivo);

            FileInputStream fileInputStream = new FileInputStream(file);
            fis = new FileInputStream(file);


            xpp.setInput(fis, null);
            int eventType = xpp.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG){
                    handleStarTag(xpp.getName());
                }else if(eventType == XmlPullParser.END_TAG){
                    handleEndTag(xpp.getName());
                }else if(eventType == XmlPullParser.TEXT){
                    handleText(xpp.getText());
                }
                eventType = xpp.next();
            }
            Data data = new Data(this);
            data.open();

            String idVivienda = edtArchivo.getText().toString();
            if(caratula.get_id()!=0){
                data.eliminarDato(SQLConstantes.tablacaratula,idVivienda);
                data.insertarElemento(SQLConstantes.tablacaratula,caratula.toValues());
            }
            if(visitaEncuestadors.size()>0){data.deleteAllVisitas(idVivienda);data.insertarVisitas(visitaEncuestadors);}
            if(hogares.size()>0){data.deleteAllHogares(idVivienda);data.insertarHogares(hogares);}

            if(!funcionario.get_id().equals("")){
                data.eliminarDato(SQLConstantes.tablafuncionarios,idVivienda);
                data.insertarElemento(SQLConstantes.tablafuncionarios,funcionario.toValues());
            }

//            if(!datosEntrevista.getID().equals("")){data.deleteDatosEntrevista(idEmpresa);data.insertarDatosEntrevista(datosEntrevista);}

//
//            if(!modulo1.getMODULO1_ID().equals("")){data.deleteModulo1(idEmpresa);data.insertarModulo1(modulo1);}
//            if(!modulo2.getMODULO2_ID().equals("")){data.deleteModulo2(idEmpresa);data.insertarModulo2(modulo2);}
//            if(!modulo3.getMODULO3_ID().equals("")){data.deleteModulo3(idEmpresa);data.insertarModulo3(modulo3);}
//            if(!modulo4.getMODULO4_ID().equals("")){data.deleteModulo4(idEmpresa);data.insertarModulo4(modulo4);}
//            if(!modulo5.getMODULO5_ID().equals("")){data.deleteModulo5(idEmpresa);data.insertarModulo5(modulo5);}
//            if(modulo5Dinamicos.size()>0){data.deleteAllModulo5Dinamico(idEmpresa);data.insertarModulos5Dinamico(modulo5Dinamicos);}
//            if(!modulo6.getMODULO6_ID().equals("")){data.deleteModulo6(idEmpresa);data.insertarModulo6(modulo6);}
//            if(!modulo7.getMODULO7_ID().equals("")){data.deleteModulo7(idEmpresa);data.insertarModulo7(modulo7);}
//            if(!modulo8.getMODULO8_ID().equals("")){data.deleteModulo8(idEmpresa);data.insertarModulo8(modulo8);}
//            if(!modulo9.getMODULO9_ID().equals("")){data.deleteModulo9(idEmpresa);data.insertarModulo9(modulo9);}
//            if(!modulo10.getMODULO10_ID().equals("")){data.deleteModulo10(idEmpresa);data.insertarModulo10(modulo10);}
            data.close();
//            txtImportar.setText(sb.toString());
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(ImportarActivity.this, "No existe el archivo", Toast.LENGTH_SHORT).show();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleText(String text) {
        String xmlText = text;
        switch (currentTag){

            case "CARATULA":agregarVariableCaratula(currentVariable,text);break;
            case "HOGAR":agregarVariableHogar(currentVariable,text);break;
            case "VISITA_ENCUESTADOR":
                agregarVariableVisitaEncuestador(currentVariable,text);break;
            case "FUNCIONARIO":agregarVariableFuncionario(currentVariable,text);break;
            case "MODULO1V":agregarVariableModulo1V(currentVariable,text);break;
//            case "MODULO2":agregarVariableModulo2(currentVariable,text);break;
//            case "MODULO3":agregarVariableModulo3(currentVariable,text);break;
//            case "MODULO4":agregarVariableModulo4(currentVariable,text);break;
//            case "MODULO5_I":agregarVariableModulo5(currentVariable,text);break;
//            case "MODULO5_II":agregarVariableModulo5Dinamico(currentVariable,text);break;
//            case "MODULO6":agregarVariableModulo6(currentVariable,text);break;
//            case "MODULO7":agregarVariableModulo7(currentVariable,text);break;
//            case "MODULO8":agregarVariableModulo8(currentVariable,text);break;
//            case "MODULO9":agregarVariableModulo9(currentVariable,text);break;
//            case "MODULO10": agregarVariableModulo10(currentVariable,text);break;
        }
    }

    private void handleStarTag(String name) {
        switch (name){
            case "CARATULA":currentTag = "CARATULA";break;
            case "HOGAR":currentTag = "HOGARES";currentHogar = new Hogar();break;
            case "VISITA_ENCUESTADOR":currentTag = "VISITA_ENCUESTADOR";
                currentVisitaEncuestador = new VisitaEncuestador();break;
            case "FUNCIONARIO":currentTag = "FUNCIONARIO";break;
            case "MODULO1V":currentTag = "MODULO1V";break;

//            case "MODULO1":currentTag = "MODULO1";break;
//            case "MODULO2":currentTag = "MODULO2";break;
//            case "MODULO3":currentTag = "MODULO3";break;
//            case "MODULO4":currentTag = "MODULO4";break;
//            case "MODULO5_I":currentTag = "MODULO5_I";break;
//            case "MODULO5_II":currentTag = "MODULO5_II";currentModulo5Dinamico = new Modulo5Dinamico();break;
//            case "MODULO6": currentTag = "MODULO6";break;
//            case "MODULO7":currentTag = "MODULO7";break;
//            case "MODULO8":currentTag = "MODULO8";break;
//            case "MODULO9":currentTag = "MODULO9";break;
//            case "MODULO10": currentTag = "MODULO10";break;
            default: currentVariable = name;break;
        }
    }
    public void handleEndTag(String name){
        switch (name){
            case "HOGAR": hogares.add(currentHogar);break;
            case "VISITA_ENCUESTADOR": visitaEncuestadors.add(currentVisitaEncuestador);break;
//            case "MODULO5_II":modulo5Dinamicos.add(currentModulo5Dinamico);break;
        }
    }


    public void agregarVariableCaratula(String campo, String valor){
        switch (campo){
            case SQLConstantes.caratula_id:caratula.set_id(Integer.parseInt(valor));break;
            case SQLConstantes.caratula_anio:caratula.setAnio(valor);break;
            case SQLConstantes.caratula_mes:caratula.setMes(valor);break;
            case SQLConstantes.caratula_periodo:caratula.setPeriodo(valor);break;
            case SQLConstantes.caratula_conglomerado:caratula.setConglomerado(valor);break;
            case SQLConstantes.caratula_nom_dep:caratula.setNom_dep(valor);break;
            case SQLConstantes.caratula_nom_prov:caratula.setNom_prov(valor);break;
            case SQLConstantes.caratula_nom_dist:caratula.setNom_dist(valor);break;
            case SQLConstantes.caratula_nom_ccpp:caratula.setNom_ccpp(valor);break;
            case SQLConstantes.caratula_zona:caratula.setZona(valor);break;
            case SQLConstantes.caratula_manzana_id:caratula.setManzana_id(valor);break;
            case SQLConstantes.caratula_vivienda:caratula.setVivienda(valor);break;
            case SQLConstantes.caratula_latitud:caratula.setLatitud(valor);break;
            case SQLConstantes.caratula_longitud:caratula.setLongitud(valor);break;
            case SQLConstantes.caratula_tipvia:caratula.setTipvia(valor);break;
            case SQLConstantes.caratula_tipvia_o:caratula.setTipvia_o(valor);break;
            case SQLConstantes.caratula_nomvia:caratula.setNomvia(valor);break;
            case SQLConstantes.caratula_nropta:caratula.setNropta(valor);break;
            case SQLConstantes.caratula_block:caratula.setBlock(valor);break;
            case SQLConstantes.caratula_interior:caratula.setInterior(valor);break;
            case SQLConstantes.caratula_piso:caratula.setPiso(valor);break;
            case SQLConstantes.caratula_mza:caratula.setMza(valor);break;
            case SQLConstantes.caratula_lote:caratula.setLote(valor);break;
            case SQLConstantes.caratula_km:caratula.setKm(valor);break;
            case SQLConstantes.caratula_telefono:caratula.setTelefono(valor);break;
            case SQLConstantes.caratula_t_hogar:caratula.setT_hogar(valor);break;
            case SQLConstantes.caratula_usuario:caratula.setUsuario(valor);break;
        }
    }
    public void agregarVariableHogar(String campo, String valor){
        switch (campo){
            case SQLConstantes.hogar_id:currentHogar.set_id(valor);break;
            case SQLConstantes.hogar_id_vivienda:currentHogar.setId_vivienda(valor);break;
            case SQLConstantes.hogar_numero:currentHogar.setNumero(valor);break;
            case SQLConstantes.hogar_nom_ape:currentHogar.setNom_ape(valor);break;
            case SQLConstantes.hogar_estado:currentHogar.setEstado(valor);break;
            case SQLConstantes.hogar_nroviven:currentHogar.setNroviven(valor);break;
            case SQLConstantes.hogar_nropersonas:currentHogar.setNropersonas(valor);break;
            case SQLConstantes.hogar_vive:currentHogar.setVive(valor);break;
        }
    }

    public void agregarVariableVisitaEncuestador(String campo, String valor){
        switch (campo){
            case SQLConstantes.visita_encuestador_id:
                currentVisitaEncuestador.set_id(valor);break;
            case SQLConstantes.visita_encuestador_id_vivienda:
                currentVisitaEncuestador.setId_vivienda(valor);break;
            case SQLConstantes.visita_encuestador_id_hogar:
                currentVisitaEncuestador.setId_hogar(valor);break;
            case SQLConstantes.visita_encuestador_numero:
                currentVisitaEncuestador.setNumero(valor);break;
            case SQLConstantes.visita_encuestador_vis_fecha_dd:
                currentVisitaEncuestador.setVis_fecha_dd(valor);break;
            case SQLConstantes.visita_encuestador_vis_fecha_mm:
                currentVisitaEncuestador.setVis_fecha_mm(valor);break;
            case SQLConstantes.visita_encuestador_vis_fecha_aa:
                currentVisitaEncuestador.setVis_fecha_aa(valor);break;
            case SQLConstantes.visita_encuestador_vis_hor_ini:
                currentVisitaEncuestador.setVis_hor_ini(valor);break;
            case SQLConstantes.visita_encuestador_vis_min_ini:
                currentVisitaEncuestador.setVis_min_ini(valor);break;
            case SQLConstantes.visita_encuestador_vis_hor_fin:
                currentVisitaEncuestador.setVis_hor_fin(valor);break;
            case SQLConstantes.visita_encuestador_vis_min_fin:
                currentVisitaEncuestador.setVis_min_fin(valor);break;
            case SQLConstantes.visita_encuestador_prox_vis_fecha_dd:
                currentVisitaEncuestador.setProx_vis_fecha_dd(valor);break;
            case SQLConstantes.visita_encuestador_prox_vis_fecha_mm:
                currentVisitaEncuestador.setProx_vis_fecha_mm(valor);break;
            case SQLConstantes.visita_encuestador_prox_vis_fecha_aa:
                currentVisitaEncuestador.setProx_vis_fecha_aa(valor);break;
            case SQLConstantes.visita_encuestador_prox_vis_hor:
                currentVisitaEncuestador.setProx_vis_hor(valor);break;
            case SQLConstantes.visita_encuestador_prox_vis_min:
                currentVisitaEncuestador.setProx_vis_min(valor);break;
            case SQLConstantes.visita_encuestador_vis_resu:
                currentVisitaEncuestador.setVis_resu(valor);break;
            case SQLConstantes.visita_encuestador_vis_resu_esp:
                currentVisitaEncuestador.setVis_resu_esp(valor);break;
        }
    }

    public void agregarVariableResultadoEncuestador(String campo, String valor){
        switch (campo){
            case SQLConstantes.resultado_encuestador_id:resVisitaEncuestador.set_id(valor);break;
            case SQLConstantes.resultado_encuestador_id_vivienda:resVisitaEncuestador.setId_vivienda(valor);break;
            case SQLConstantes.resultado_encuestador_vis_resultado_final:resVisitaEncuestador.setVis_resultado_final(valor);break;
            case SQLConstantes.resultado_encuestador_vis_fecha_final_dd:resVisitaEncuestador.setVis_fecha_final_dd(valor);break;
            case SQLConstantes.resultado_encuestador_vis_fecha_final_mm:resVisitaEncuestador.setVis_fecha_final_mm(valor);break;
            case SQLConstantes.resultado_encuestador_vis_fecha_final_aa:resVisitaEncuestador.setVis_fecha_final_aa(valor);break;
        }
    }


    public void agregarVariableVisitaSupervisor(String campo, String valor){
        switch (campo){
            case SQLConstantes.visita_encuestador_id:
                currentVisitaEncuestador.set_id(valor);break;
            case SQLConstantes.visita_encuestador_id_vivienda:
                currentVisitaEncuestador.setId_vivienda(valor);break;
            case SQLConstantes.visita_encuestador_id_hogar:
                currentVisitaEncuestador.setId_hogar(valor);break;
            case SQLConstantes.visita_encuestador_numero:
                currentVisitaEncuestador.setNumero(valor);break;
            case SQLConstantes.visita_encuestador_vis_fecha_dd:
                currentVisitaEncuestador.setVis_fecha_dd(valor);break;
            case SQLConstantes.visita_encuestador_vis_fecha_mm:
                currentVisitaEncuestador.setVis_fecha_mm(valor);break;
            case SQLConstantes.visita_encuestador_vis_fecha_aa:
                currentVisitaEncuestador.setVis_fecha_aa(valor);break;
            case SQLConstantes.visita_encuestador_vis_hor_ini:
                currentVisitaEncuestador.setVis_hor_ini(valor);break;
            case SQLConstantes.visita_encuestador_vis_min_ini:
                currentVisitaEncuestador.setVis_min_ini(valor);break;
            case SQLConstantes.visita_encuestador_vis_hor_fin:
                currentVisitaEncuestador.setVis_hor_fin(valor);break;
            case SQLConstantes.visita_encuestador_vis_min_fin:
                currentVisitaEncuestador.setVis_min_fin(valor);break;
            case SQLConstantes.visita_encuestador_vis_resu:
                currentVisitaEncuestador.setVis_resu(valor);break;
            case SQLConstantes.visita_encuestador_vis_resu_esp:
                currentVisitaEncuestador.setVis_resu_esp(valor);break;
        }
    }

    public void agregarVariableResultadoSupervisor(String campo, String valor){
        switch (campo){
            case SQLConstantes.resultado_supervisor_id:resVisitaSupervisor.set_id(valor);break;
            case SQLConstantes.resultado_supervisor_id_hogar:resVisitaSupervisor.setId_hogar(valor);break;
            case SQLConstantes.resultado_supervisor_id_vivienda:resVisitaSupervisor.setId_vivienda(valor);break;
            case SQLConstantes.resultado_supervisor_vis_resultado_final:resVisitaSupervisor.setVis_resultado_final(valor);break;
            case SQLConstantes.resultado_supervisor_vis_fecha_final_dd:resVisitaSupervisor.setVis_fecha_final_dd(valor);break;
            case SQLConstantes.resultado_supervisor_vis_fecha_final_mm:resVisitaSupervisor.setVis_fecha_final_mm(valor);break;
            case SQLConstantes.resultado_supervisor_vis_fecha_final_aa:resVisitaSupervisor.setVis_fecha_final_aa(valor);break;
        }
    }


    public void agregarVariableFuncionario(String campo, String valor){
        switch (campo){
            case SQLConstantes.funcionarios_id:funcionario.set_id(valor);break;
            case SQLConstantes.funcionarios_dni_encu:funcionario.setDni_encu(valor);break;
            case SQLConstantes.funcionarios_dni_sup:funcionario.setDni_sup(valor);break;
            case SQLConstantes.funcionarios_dni_coord:funcionario.setDni_coor(valor);break;
            case SQLConstantes.funcionarios_nombre_encu:funcionario.setNombre_encu(valor);break;
            case SQLConstantes.funcionarios_nombre_sup:funcionario.setNombre_sup(valor);break;
            case SQLConstantes.funcionarios_nombre_coord:funcionario.setNombre_coord(valor);break;
        }
    }


    public void agregarVariableModulo1V(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo1_v_id:modulo1V.set_id(valor);break;
            case SQLConstantes.modulo1_v_c1_p101:modulo1V.setC1_p101(valor);break;
            case SQLConstantes.modulo1_v_c1_p101_o:modulo1V.setC1_p101_o(valor);break;
            case SQLConstantes.modulo1_v_c1_p102:modulo1V.setC1_p102(valor);break;
            case SQLConstantes.modulo1_v_c1_p102_o:modulo1V.setC1_p102_o(valor);break;
            case SQLConstantes.modulo1_v_c1_p103:modulo1V.setC1_p103(valor);break;
            case SQLConstantes.modulo1_v_c1_p103_o:modulo1V.setC1_p103_o(valor);break;
            case SQLConstantes.modulo1_v_c1_p104:modulo1V.setC1_p104(valor);break;
            case SQLConstantes.modulo1_v_c1_p104_o:modulo1V.setC1_p104_o(valor);break;
            case SQLConstantes.modulo1_v_c1_p105:modulo1V.setC1_p105(valor);break;
            case SQLConstantes.modulo1_v_c1_p106:modulo1V.setC1_p106(valor);break;
            case SQLConstantes.modulo1_v_c1_p107:modulo1V.setC1_p107(valor);break;
            case SQLConstantes.modulo1_v_COB100A:modulo1V.setCOB100A(valor);break;
        }
    }

    public void agregarVariableModulo1H(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo1_h_id:currentModulo1H.set_id(valor);break;
            case SQLConstantes.modulo1_h_idVivienda:currentModulo1H.setIdVivienda(valor);
            case SQLConstantes.modulo1_h_c1_p108:currentModulo1H.setC1_p108(valor);
            case SQLConstantes.modulo1_h_c1_p108_o:currentModulo1H.setC1_p108_o(valor);
            case SQLConstantes.modulo1_h_c1_p109:currentModulo1H.setC1_p109(valor);
            case SQLConstantes.modulo1_h_c1_p109_o:currentModulo1H.setC1_p109_o(valor);
            case SQLConstantes.modulo1_h_c1_p110:currentModulo1H.setC1_p110(valor);
            case SQLConstantes.modulo1_h_c1_p110_o:currentModulo1H.setC1_p110_o(valor);
            case SQLConstantes.modulo1_h_c1_p111:currentModulo1H.setC1_p111(valor);
            case SQLConstantes.modulo1_h_c1_p111_o:currentModulo1H.setC1_p111_o(valor);
            case SQLConstantes.modulo1_h_c1_p112:currentModulo1H.setC1_p112(valor);
            case SQLConstantes.modulo1_h_c1_p112_o:currentModulo1H.setC1_p112_o(valor);
            case SQLConstantes.modulo1_h_c1_p113_1:currentModulo1H.setC1_p113_1(valor);
            case SQLConstantes.modulo1_h_c1_p113_2:currentModulo1H.setC1_p113_2(valor);
            case SQLConstantes.modulo1_h_c1_p113_3:currentModulo1H.setC1_p113_3(valor);
            case SQLConstantes.modulo1_h_c1_p113_4:currentModulo1H.setC1_p113_4(valor);
            case SQLConstantes.modulo1_h_c1_p113_5:currentModulo1H.setC1_p113_5(valor);
            case SQLConstantes.modulo1_h_c1_p113_6:currentModulo1H.setC1_p113_6(valor);
            case SQLConstantes.modulo1_h_c1_p113_7:currentModulo1H.setC1_p113_7(valor);
            case SQLConstantes.modulo1_h_c1_p113_8:currentModulo1H.setC1_p113_7_o(valor);
            case SQLConstantes.modulo1_h_c1_p113_9:currentModulo1H.setC1_p113_8(valor);
            case SQLConstantes.modulo1_h_c1_p113_7_o:currentModulo1H.setC1_p113_8_o(valor);
            case SQLConstantes.modulo1_h_c1_p113_8_o:currentModulo1H.setC1_p113_9(valor);
            case SQLConstantes.modulo1_h_c1_p113_9_o:currentModulo1H.setC1_p113_9_o(valor);
            case SQLConstantes.modulo1_h_COB100B:currentModulo1H.setCOB100B(valor);
        }
    }

    public void agregarVariableResidente(String campo, String valor){
        switch (campo){
            case SQLConstantes.residentes_id:currentResidente.set_id(valor);break;
            case SQLConstantes.residentes_id_informante:currentResidente.setId_informante(valor);
            case SQLConstantes.residentes_id_hogar:currentResidente.setId_hogar(valor);
            case SQLConstantes.residentes_id_vivienda:currentResidente.setId_vivienda(valor);
            case SQLConstantes.residentes_numero:currentResidente.setNumero(valor);
            case SQLConstantes.residentes_c2_p202:currentResidente.setC2_p202(valor);
            case SQLConstantes.residentes_c2_p203:currentResidente.setC2_p203(valor);
            case SQLConstantes.residentes_c2_p204:currentResidente.setC2_p204(valor);
            case SQLConstantes.residentes_c2_p205_a:currentResidente.setC2_p205_a(valor);
            case SQLConstantes.residentes_c2_p205_m:currentResidente.setC2_p205_m(valor);
            case SQLConstantes.residentes_c2_p206:currentResidente.setC2_p206(valor);
            case SQLConstantes.residentes_c2_p207:currentResidente.setC2_p207(valor);
            case SQLConstantes.residentes_COB200:currentResidente.setCOB200(valor);
            case SQLConstantes.residentes_encuestado_cobertura:currentResidente.setEncuestado_cobertura(valor);
        }
    }

    public void agregarVariableModulo3(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo3_id:currentModulo3.set_id(valor);break;
            case SQLConstantes.modulo3_id_informante:currentModulo3.setIdInformante(valor);
            case SQLConstantes.modulo3_id_hogar:currentModulo3.setIdHogar(valor);
            case SQLConstantes.modulo3_id_vivienda:currentModulo3.setIdVivienda(valor);
            case SQLConstantes.modulo3_c3_p301_d:currentModulo3.setC3_p301_d(valor);
            case SQLConstantes.modulo3_c3_p301_m:currentModulo3.setC3_p301_m(valor);
            case SQLConstantes.modulo3_c3_p301_a:currentModulo3.setC3_p301_a(valor);
            case SQLConstantes.modulo3_c3_p302:currentModulo3.setC3_p302(valor);
            case SQLConstantes.modulo3_c3_p303_m:currentModulo3.setC3_p303_m(valor);
            case SQLConstantes.modulo3_c3_p303_a:currentModulo3.setC3_p303_a(valor);
            case SQLConstantes.modulo3_c3_p303_no_nacio:currentModulo3.setC3_p303_no_nacio(valor);
            case SQLConstantes.modulo3_c3_p304:currentModulo3.setC3_p304(valor);
            case SQLConstantes.modulo3_c3_p305:currentModulo3.setC3_p305(valor);
            case SQLConstantes.modulo3_c3_p305_o:currentModulo3.setC3_p305_o(valor);
            case SQLConstantes.modulo3_c3_p306:currentModulo3.setC3_p306(valor);
            case SQLConstantes.modulo3_c3_p306_o:currentModulo3.setC3_p306_o(valor);
            case SQLConstantes.modulo3_c3_p307_d:currentModulo3.setC3_p307_d(valor);
            case SQLConstantes.modulo3_c3_p307_m:currentModulo3.setC3_p307_m(valor);
            case SQLConstantes.modulo3_c3_p307_a:currentModulo3.setC3_p307_a(valor);
            case SQLConstantes.modulo3_c3_p308_e:currentModulo3.setC3_p308_e(valor);
            case SQLConstantes.modulo3_c3_p308_m:currentModulo3.setC3_p308_m(valor);
            case SQLConstantes.modulo3_c3_p308_e_seleccion:currentModulo3.setC3_p308_e_seleccion(valor);
            case SQLConstantes.modulo3_c3_p308_m_seleccion:currentModulo3.setC3_p308_m_seleccion(valor);
            case SQLConstantes.modulo3_c3_p310_1:currentModulo3.setC3_p310_1(valor);
            case SQLConstantes.modulo3_c3_p310_2:currentModulo3.setC3_p310_2(valor);
            case SQLConstantes.modulo3_c3_p310_3:currentModulo3.setC3_p310_3(valor);
            case SQLConstantes.modulo3_c3_p310_4:currentModulo3.setC3_p310_4(valor);
            case SQLConstantes.modulo3_c3_p311:currentModulo3.setC3_p311(valor);
            case SQLConstantes.modulo3_c3_p312_dist:currentModulo3.setC3_p312_dist(valor);
            case SQLConstantes.modulo3_c3_p312_prov:currentModulo3.setC3_p312_prov(valor);
            case SQLConstantes.modulo3_c3_p312_dep:currentModulo3.setC3_p312_dep(valor);
            case SQLConstantes.modulo3_c3_p313:currentModulo3.setC3_p313(valor);
            case SQLConstantes.modulo3_c3_p314:currentModulo3.setC3_p314(valor);
            case SQLConstantes.modulo3_c3_p314_o:currentModulo3.setC3_p314_o(valor);
            case SQLConstantes.modulo3_c3_p315_1:currentModulo3.setC3_p315_1(valor);
            case SQLConstantes.modulo3_c3_p315_2:currentModulo3.setC3_p315_2(valor);
            case SQLConstantes.modulo3_c3_p315_3:currentModulo3.setC3_p315_3(valor);
            case SQLConstantes.modulo3_c3_p315_4:currentModulo3.setC3_p315_4(valor);
            case SQLConstantes.modulo3_c3_p315_5:currentModulo3.setC3_p315_5(valor);
            case SQLConstantes.modulo3_c3_p315_6:currentModulo3.setC3_p315_6(valor);
            case SQLConstantes.modulo3_c3_p315_7:currentModulo3.setC3_p315_7(valor);
            case SQLConstantes.modulo3_c3_p315_8:currentModulo3.setC3_p315_8(valor);
            case SQLConstantes.modulo3_c3_p315_9:currentModulo3.setC3_p315_9(valor);
            case SQLConstantes.modulo3_c3_p315_10:currentModulo3.setC3_p315_10(valor);
            case SQLConstantes.modulo3_c3_p315_10_o:currentModulo3.setC3_p315_10_o(valor);
            case SQLConstantes.modulo3_c3_p316:currentModulo3.setC3_p316(valor);
            case SQLConstantes.modulo3_c3_p316_o:currentModulo3.setC3_p316_o(valor);
            case SQLConstantes.modulo3_c3_p317:currentModulo3.setC3_p317(valor);
            case SQLConstantes.modulo3_c3_p318:currentModulo3.setC3_p318(valor);
            case SQLConstantes.modulo3_obs_cap3:currentModulo3.setObs_cap3(valor);
            case SQLConstantes.modulo3_COB300:currentModulo3.setCOB300(valor);
        }
    }

    public void agregarVariableModulo4(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo4_id:currentModulo4.set_id(valor);break;
            case SQLConstantes.modulo4_id_informante:currentModulo4.setIdInformante(valor);
            case SQLConstantes.modulo4_id_hogar:currentModulo4.setIdHogar(valor);
            case SQLConstantes.modulo4_id_vivienda:currentModulo4.setIdVivienda(valor);
            case SQLConstantes.modulo4_c4_p401_1:currentModulo4.setC4_p401_1(valor);
            case SQLConstantes.modulo4_c4_p401_2:currentModulo4.setC4_p401_2(valor);
            case SQLConstantes.modulo4_c4_p401_3:currentModulo4.setC4_p401_3(valor);
            case SQLConstantes.modulo4_c4_p401_4:currentModulo4.setC4_p401_4(valor);
            case SQLConstantes.modulo4_c4_p401_5:currentModulo4.setC4_p401_5(valor);
            case SQLConstantes.modulo4_c4_p401_o:currentModulo4.setC4_p401_o(valor);
            case SQLConstantes.modulo4_c4_p402:currentModulo4.setC4_p402(valor);
            case SQLConstantes.modulo4_c4_p403_1:currentModulo4.setC4_p403_1(valor);
            case SQLConstantes.modulo4_c4_p403_2:currentModulo4.setC4_p403_2(valor);
            case SQLConstantes.modulo4_c4_p403_3:currentModulo4.setC4_p403_3(valor);
            case SQLConstantes.modulo4_c4_p403_4:currentModulo4.setC4_p403_4(valor);
            case SQLConstantes.modulo4_c4_p403_5:currentModulo4.setC4_p403_5(valor);
            case SQLConstantes.modulo4_c4_p403_6:currentModulo4.setC4_p403_6(valor);
            case SQLConstantes.modulo4_c4_p403_7:currentModulo4.setC4_p403_7(valor);
            case SQLConstantes.modulo4_c4_p403_8:currentModulo4.setC4_p403_8(valor);
            case SQLConstantes.modulo4_c4_p403_9:currentModulo4.setC4_p403_9(valor);
            case SQLConstantes.modulo4_c4_p403_10:currentModulo4.setC4_p403_10(valor);
            case SQLConstantes.modulo4_c4_p403_11:currentModulo4.setC4_p403_11(valor);
            case SQLConstantes.modulo4_c4_p403_12:currentModulo4.setC4_p403_12(valor);
            case SQLConstantes.modulo4_c4_p403_13:currentModulo4.setC4_p403_13(valor);
            case SQLConstantes.modulo4_c4_p403_14:currentModulo4.setC4_p403_14(valor);
            case SQLConstantes.modulo4_c4_p403_o:currentModulo4.setC4_p403_o(valor);
            case SQLConstantes.modulo4_c4_p404:currentModulo4.setC4_p404(valor);
            case SQLConstantes.modulo4_c4_p405_1:currentModulo4.setC4_p405_1(valor);
            case SQLConstantes.modulo4_c4_p405_2:currentModulo4.setC4_p405_2(valor);
            case SQLConstantes.modulo4_c4_p405_4:currentModulo4.setC4_p405_4(valor);
            case SQLConstantes.modulo4_c4_p405_5:currentModulo4.setC4_p405_5(valor);
            case SQLConstantes.modulo4_c4_p405_3:currentModulo4.setC4_p405_3(valor);
            case SQLConstantes.modulo4_c4_p405_6:currentModulo4.setC4_p405_6(valor);
            case SQLConstantes.modulo4_c4_p405_7:currentModulo4.setC4_p405_7(valor);
            case SQLConstantes.modulo4_c4_p406_1:currentModulo4.setC4_p406_1(valor);
            case SQLConstantes.modulo4_c4_p406_2:currentModulo4.setC4_p406_2(valor);
            case SQLConstantes.modulo4_c4_p406_3:currentModulo4.setC4_p406_3(valor);
            case SQLConstantes.modulo4_c4_p406_4:currentModulo4.setC4_p406_4(valor);
            case SQLConstantes.modulo4_c4_p406_5:currentModulo4.setC4_p406_5(valor);
            case SQLConstantes.modulo4_c4_p406_6:currentModulo4.setC4_p406_6(valor);
            case SQLConstantes.modulo4_c4_p406_7:currentModulo4.setC4_p406_7(valor);
            case SQLConstantes.modulo4_c4_p406_8:currentModulo4.setC4_p406_8(valor);
            case SQLConstantes.modulo4_c4_p406_o:currentModulo4.setC4_p406_o(valor);
            case SQLConstantes.modulo4_c4_p407_1:currentModulo4.setC4_p407_1(valor);
            case SQLConstantes.modulo4_c4_p407_2:currentModulo4.setC4_p407_2(valor);
            case SQLConstantes.modulo4_c4_p407_3:currentModulo4.setC4_p407_3(valor);
            case SQLConstantes.modulo4_c4_p407_4:currentModulo4.setC4_p407_4(valor);
            case SQLConstantes.modulo4_c4_p407_5:currentModulo4.setC4_p407_5(valor);
            case SQLConstantes.modulo4_c4_p407_6:currentModulo4.setC4_p407_6(valor);
            case SQLConstantes.modulo4_c4_p407_7:currentModulo4.setC4_p407_7(valor);
            case SQLConstantes.modulo4_c4_p407_8:currentModulo4.setC4_p407_8(valor);
            case SQLConstantes.modulo4_c4_p407_9:currentModulo4.setC4_p407_9(valor);
            case SQLConstantes.modulo4_c4_p407_10:currentModulo4.setC4_p407_10(valor);
            case SQLConstantes.modulo4_c4_p407_11:currentModulo4.setC4_p407_11(valor);
            case SQLConstantes.modulo4_c4_p407_12:currentModulo4.setC4_p407_12(valor);
            case SQLConstantes.modulo4_c4_p407_13:currentModulo4.setC4_p407_13(valor);
            case SQLConstantes.modulo4_c4_p407_o:currentModulo4.setC4_p407_o(valor);
            case SQLConstantes.modulo4_c4_p408_1:currentModulo4.setC4_p408_1(valor);
            case SQLConstantes.modulo4_c4_p408_2:currentModulo4.setC4_p408_2(valor);
            case SQLConstantes.modulo4_c4_p408_3:currentModulo4.setC4_p408_3(valor);
            case SQLConstantes.modulo4_c4_p408_4:currentModulo4.setC4_p408_4(valor);
            case SQLConstantes.modulo4_c4_p408_5:currentModulo4.setC4_p408_5(valor);
            case SQLConstantes.modulo4_c4_p408_6:currentModulo4.setC4_p408_6(valor);
            case SQLConstantes.modulo4_c4_p409:currentModulo4.setC4_p409(valor);
            case SQLConstantes.modulo4_c4_p410:currentModulo4.setC4_p410(valor);
            case SQLConstantes.modulo4_c4_p411_1:currentModulo4.setC4_p411_1(valor);
            case SQLConstantes.modulo4_c4_p411_2:currentModulo4.setC4_p411_2(valor);
            case SQLConstantes.modulo4_c4_p411_3:currentModulo4.setC4_p411_3(valor);
            case SQLConstantes.modulo4_c4_p411_4:currentModulo4.setC4_p411_4(valor);
            case SQLConstantes.modulo4_c4_p411_5:currentModulo4.setC4_p411_5(valor);
            case SQLConstantes.modulo4_c4_p411_6:currentModulo4.setC4_p411_6(valor);
            case SQLConstantes.modulo4_c4_p411_7:currentModulo4.setC4_p411_7(valor);
            case SQLConstantes.modulo4_c4_p411_8:currentModulo4.setC4_p411_8(valor);
            case SQLConstantes.modulo4_c4_p411_9:currentModulo4.setC4_p411_9(valor);
            case SQLConstantes.modulo4_c4_p411_10:currentModulo4.setC4_p411_10(valor);
            case SQLConstantes.modulo4_c4_p411_11:currentModulo4.setC4_p411_11(valor);
            case SQLConstantes.modulo4_c4_p411_12:currentModulo4.setC4_p411_12(valor);
            case SQLConstantes.modulo4_c4_p411_13:currentModulo4.setC4_p411_13(valor);
            case SQLConstantes.modulo4_c4_p411_14:currentModulo4.setC4_p411_14(valor);
            case SQLConstantes.modulo4_c4_p411_o:currentModulo4.setC4_p411_o(valor);
            case SQLConstantes.modulo4_c4_p412:currentModulo4.setC4_p412(valor);
            case SQLConstantes.modulo4_c4_p413:currentModulo4.setC4_p413(valor);
            case SQLConstantes.modulo4_c4_p414:currentModulo4.setC4_p414(valor);
            case SQLConstantes.modulo4_c4_p415:currentModulo4.setC4_p415(valor);
            case SQLConstantes.modulo4_c4_p416_1:currentModulo4.setC4_p416_1(valor);
            case SQLConstantes.modulo4_c4_p416_2:currentModulo4.setC4_p416_2(valor);
            case SQLConstantes.modulo4_c4_p416_3:currentModulo4.setC4_p416_3(valor);
            case SQLConstantes.modulo4_c4_p416_4:currentModulo4.setC4_p416_4(valor);
            case SQLConstantes.modulo4_c4_p416_5:currentModulo4.setC4_p416_5(valor);
            case SQLConstantes.modulo4_c4_p416_6:currentModulo4.setC4_p416_6(valor);
            case SQLConstantes.modulo4_c4_p416_7:currentModulo4.setC4_p416_7(valor);
            case SQLConstantes.modulo4_c4_p416_8:currentModulo4.setC4_p416_8(valor);
            case SQLConstantes.modulo4_c4_p416_o:currentModulo4.setC4_p416_o(valor);
            case SQLConstantes.modulo4_obs_cap4:currentModulo4.setObs_cap4(valor);
            case SQLConstantes.modulo4_COB400:currentModulo4.setCOB400(valor);
        }
    }

    public void agregarVariableModulo5(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo5_id:currentModulo5.set_id(valor);break;

            case SQLConstantes.modulo5_id_informante:currentModulo5.setIdInformante(valor);break;
            case SQLConstantes.modulo5_id_hogar:currentModulo5.setIdHogar(valor);break;
            case SQLConstantes.modulo5_id_vivienda:currentModulo5.setIdVivienda(valor);break;
            case SQLConstantes.modulo5_c5_p501:currentModulo5.setC5_p501(valor);break;
            case SQLConstantes.modulo5_c5_p502_c:currentModulo5.setC5_p502_c(valor);break;
            case SQLConstantes.modulo5_c5_p502:currentModulo5.setC5_p502(valor);break;
            case SQLConstantes.modulo5_c5_p502_eleccion:currentModulo5.setC5_p502_eleccion(valor);break;
            case SQLConstantes.modulo5_c5_p502_o:currentModulo5.setC5_p502_o(valor);break;
            case SQLConstantes.modulo5_c5_p503:currentModulo5.setC5_p503(valor);break;
            case SQLConstantes.modulo5_c5_p504:currentModulo5.setC5_p504(valor);break;
            case SQLConstantes.modulo5_c5_p505:currentModulo5.setC5_p505(valor);break;
            case SQLConstantes.modulo5_c5_p506_1:currentModulo5.setC5_p506_1(valor);break;
            case SQLConstantes.modulo5_c5_p506_2:currentModulo5.setC5_p506_2(valor);break;
            case SQLConstantes.modulo5_c5_p506_3:currentModulo5.setC5_p506_3(valor);break;
            case SQLConstantes.modulo5_c5_p506_4:currentModulo5.setC5_p506_4(valor);break;
            case SQLConstantes.modulo5_c5_p507:currentModulo5.setC5_p507(valor);break;
            case SQLConstantes.modulo5_c5_p507_dist:currentModulo5.setC5_p507_dist(valor);break;
            case SQLConstantes.modulo5_c5_p507_prov:currentModulo5.setC5_p507_prov(valor);break;
            case SQLConstantes.modulo5_c5_p507_dep:currentModulo5.setC5_p507_dep(valor);break;
            case SQLConstantes.modulo5_c5_p508_1:currentModulo5.setC5_p508_1(valor);break;
            case SQLConstantes.modulo5_c5_p508_2:currentModulo5.setC5_p508_2(valor);break;
            case SQLConstantes.modulo5_c5_p508_3:currentModulo5.setC5_p508_3(valor);break;
            case SQLConstantes.modulo5_c5_p508_4:currentModulo5.setC5_p508_4(valor);break;
            case SQLConstantes.modulo5_c5_p508_5:currentModulo5.setC5_p508_5(valor);break;
            case SQLConstantes.modulo5_c5_p508_6:currentModulo5.setC5_p508_6(valor);break;
            case SQLConstantes.modulo5_c5_p508_7:currentModulo5.setC5_p508_7(valor);break;
            case SQLConstantes.modulo5_c5_p508_8:currentModulo5.setC5_p508_8(valor);break;
            case SQLConstantes.modulo5_c5_p508_9:currentModulo5.setC5_p508_9(valor);break;
            case SQLConstantes.modulo5_c5_p508_10:currentModulo5.setC5_p508_10(valor);break;
            case SQLConstantes.modulo5_c5_p508_11:currentModulo5.setC5_p508_11(valor);break;
            case SQLConstantes.modulo5_c5_p508_o:currentModulo5.setC5_p508_o(valor);break;
            case SQLConstantes.modulo5_c5_p509:currentModulo5.setC5_p509(valor);break;
            case SQLConstantes.modulo5_c5_p510:currentModulo5.setC5_p510(valor);break;
            case SQLConstantes.modulo5_c5_p511:currentModulo5.setC5_p511(valor);break;
            case SQLConstantes.modulo5_c5_p511_o:currentModulo5.setC5_p511_o(valor);break;
            case SQLConstantes.modulo5_c5_p512:currentModulo5.setC5_p512(valor);break;
            case SQLConstantes.modulo5_c5_p512_o:currentModulo5.setC5_p512_o(valor);break;
            case SQLConstantes.modulo5_c5_p513:currentModulo5.setC5_p513(valor);break;
            case SQLConstantes.modulo5_c5_p513_o:currentModulo5.setC5_p513_o(valor);break;
            case SQLConstantes.modulo5_obs_cap5:currentModulo5.setObs_cap5(valor);break;
            case SQLConstantes.modulo5_COB500:currentModulo5.setCOB500(valor);break;
        }
    }

    public void agregarVariableModulo6(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo4_id:currentModulo4.set_id(valor);break;

        }
    }

    public void agregarVariableModulo7(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo4_id:currentModulo4.set_id(valor);break;

        }
    }

    public void agregarVariableModulo8(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo4_id:currentModulo4.set_id(valor);break;

        }
    }
}
