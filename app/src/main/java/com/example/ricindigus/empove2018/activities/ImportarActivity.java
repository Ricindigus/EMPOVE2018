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
    private Modulo1H currentModulo1V;
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
}
