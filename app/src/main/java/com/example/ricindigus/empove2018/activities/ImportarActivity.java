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
    private VisitaSupervisor currentVisitaSupervisor;
    private ArrayList<ResVisitaEncuestador> resVisitaEncuestadors;
    private ResVisitaEncuestador currentResVisitaEncuestador;
    private ArrayList<ResVisitaSupervisor> resVisitaSupervisors;
    private ResVisitaSupervisor currentResVisitaSupervisor;
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

            //LEE DOCUMENTO XML Y PARSEA LOS DATOS , Y LLENA LAS VARIABLES
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
            //VARIABLES LLENAS
            //GUARDAR VARIABLES LLENADAS EN EL PARSEO
            Data data = new Data(this);
            data.open();
            String idVivienda = edtArchivo.getText().toString();
            //insertar la caratula
            if(caratula.get_id()!=0){ data.eliminarDato(SQLConstantes.tablacaratula,idVivienda);data.insertarElemento(SQLConstantes.tablacaratula,caratula.toValues()); }
            //insertar datos hogares
            if(hogares.size()>0){data.deleteAllHogares(idVivienda);data.insertarHogares(hogares);}
            //insertar datos visitas encuestador
            if(visitaEncuestadors.size()>0){data.deleteAllVisitasEncuestador(idVivienda);data.insertarVisitasEncuestador(visitaEncuestadors);}
            //insertar datos resultados encuestador
            if(resVisitaEncuestadors.size()>0){
                data.eliminarDatos(SQLConstantes.tablaresultadoencuestador,SQLConstantes.resultado_supervisor_id_vivienda,idVivienda);
                for (ResVisitaEncuestador resVisitaEncuestador : resVisitaEncuestadors)
                    data.insertarElemento(SQLConstantes.tablaresultadoencuestador,resVisitaEncuestador.toValues());
            }
            //insertar datos visitas supervisor
            if(visitaSupervisors.size()>0){data.deleteAllVisitasSupervisor(idVivienda);data.insertarVisitasSupervisor(visitaSupervisors);}
            //insertar datos resultados encuestador
            if(resVisitaSupervisors.size()>0){
                data.eliminarDatos(SQLConstantes.tablaresultadosupervisor,SQLConstantes.resultado_supervisor_id_vivienda,idVivienda);
                for (ResVisitaSupervisor resVisitaSupervisor : resVisitaSupervisors)
                    data.insertarElemento(SQLConstantes.tablaresultadosupervisor,resVisitaSupervisor.toValues());
            }
            //insertar el funcionario
            if(!funcionario.get_id().equals("")){ data.eliminarDato(SQLConstantes.tablafuncionarios,idVivienda);data.insertarElemento(SQLConstantes.tablafuncionarios,funcionario.toValues()); }
            //insertar el modulo 1 Vivienda
            if(!modulo1V.get_id().equals("")){ data.eliminarDato(SQLConstantes.tablamodulo1v,idVivienda);data.insertarElemento(SQLConstantes.tablamodulo1v,modulo1V.toValues()); }
            //insertar datos modulo1 Hogares
            if(modulo1HS.size()>0){
                data.eliminarDatos(SQLConstantes.tablamodulo1h,SQLConstantes.modulo1_h_idVivienda,idVivienda);
                for (Modulo1H modulo1H : modulo1HS)
                    data.insertarElemento(SQLConstantes.tablamodulo1h,modulo1H.toValues());
            }
            //insertar datos residentes
            if(residentes.size()>0){
                data.eliminarDatos(SQLConstantes.tablaresidentes,SQLConstantes.residentes_id_vivienda,idVivienda);
                for (Residente residente : residentes)
                    data.insertarElemento(SQLConstantes.tablaresidentes,residente.toValues());
            }

            //insertar modulos 3
            if(modulo3s.size()>0){
                data.eliminarDatos(SQLConstantes.tablamodulo3,SQLConstantes.modulo3_id_vivienda,idVivienda);
                for (Modulo3 modulo3 : modulo3s)
                    data.insertarElemento(SQLConstantes.tablamodulo3,modulo3.toValues());
            }

            //insertar modulos 4
            if(modulo4s.size()>0){
                data.eliminarDatos(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_id_vivienda,idVivienda);
                for (Modulo4 modulo4 : modulo4s)
                    data.insertarElemento(SQLConstantes.tablamodulo4,modulo4.toValues());
            }
            //insertar modulos 5
            if(modulo5s.size()>0){
                data.eliminarDatos(SQLConstantes.tablamodulo5,SQLConstantes.modulo5_id_vivienda,idVivienda);
                for (Modulo5 modulo5 : modulo5s)
                    data.insertarElemento(SQLConstantes.tablamodulo5,modulo5.toValues());
            }
            //insertar modulos 6
            if(modulo4s.size()>0){
                data.eliminarDatos(SQLConstantes.tablamodulo6,SQLConstantes.modulo6_id_vivienda,idVivienda);
                for (Modulo6 modulo6 : modulo6s)
                    data.insertarElemento(SQLConstantes.tablamodulo6,modulo6.toValues());
            }
            //insertar modulos 7
            if(modulo7s.size()>0){
                data.eliminarDatos(SQLConstantes.tablamodulo7,SQLConstantes.modulo7_id_vivienda,idVivienda);
                for (Modulo7 modulo7 : modulo7s)
                    data.insertarElemento(SQLConstantes.tablamodulo7,modulo7.toValues());
            }
            //insertar modulos 8
            if(modulo8s.size()>0){
                data.eliminarDatos(SQLConstantes.tablamodulo8,SQLConstantes.modulo8_id_vivienda,idVivienda);
                for (Modulo8 modulo8 : modulo8s)
                    data.insertarElemento(SQLConstantes.tablamodulo8,modulo8.toValues());
            }
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
            case "VISITA_ENCUESTADOR": agregarVariableVisitaEncuestador(currentVariable,text);break;
            case "VISITA_SUPERVISOR": agregarVariableVisitaSupervisor(currentVariable,text);break;
            case "RESULTADO_VISITA_ENCUESTADOR": agregarVariableVisitaEncuestador(currentVariable,text);break;
            case "RESULTADO_VISITA_SUPERVISOR": agregarVariableVisitaSupervisor(currentVariable,text);break;
            case "FUNCIONARIO":agregarVariableFuncionario(currentVariable,text);break;
            case "MODULO1V":agregarVariableModulo1V(currentVariable,text);break;
            case "MODULO1H":agregarVariableModulo1H(currentVariable,text);break;
            case "RESIDENTE":agregarVariableResidente(currentVariable,text);break;
            case "MODULO3":agregarVariableModulo3(currentVariable,text);break;
            case "MODULO4":agregarVariableModulo4(currentVariable,text);break;
            case "MODULO5":agregarVariableModulo5(currentVariable,text);break;
            case "MODULO6":agregarVariableModulo6(currentVariable,text);break;
            case "MODULO7":agregarVariableModulo7(currentVariable,text);break;
            case "MODULO8":agregarVariableModulo8(currentVariable,text);break;
        }
    }

    private void handleStarTag(String name) {
        switch (name){
            case "CARATULA":currentTag = "CARATULA";break;
            case "HOGAR":currentTag = "HOGARES";currentHogar = new Hogar();break;
            case "VISITA_ENCUESTADOR":currentTag = "VISITA_ENCUESTADOR";currentVisitaEncuestador = new VisitaEncuestador();break;
            case "VISITA_SUPERVISOR":currentTag = "VISITA_SUPERVISOR";currentVisitaSupervisor = new VisitaSupervisor();break;
            case "RESULTADO_VISITA_ENCUESTADOR":currentTag = "RESULTADO_VISITA_ENCUESTADOR";currentResVisitaEncuestador = new ResVisitaEncuestador();break;
            case "RESULTADO_VISITA_SUPERVISOR":currentTag = "RESULTADO_VISITA_SUPERVISOR";currentResVisitaSupervisor= new ResVisitaSupervisor();break;
            case "FUNCIONARIO":currentTag = "FUNCIONARIO";break;
            case "MODULO1V":currentTag = "MODULO1V";break;
            case "MODULO1H":currentTag = "MODULO1H";currentModulo1H = new Modulo1H();break;
            case "RESIDENTE":currentTag = "RESIDENTE";currentResidente = new Residente();break;
            case "MODULO3":currentTag = "MODULO3";currentModulo3 = new Modulo3();break;
            case "MODULO4":currentTag = "MODULO4";currentModulo4 = new Modulo4();break;
            case "MODULO5":currentTag = "MODULO5";currentModulo5 = new Modulo5();break;
            case "MODULO6":currentTag = "MODULO6";currentModulo6 = new Modulo6();break;
            case "MODULO7":currentTag = "MODULO7";currentModulo7 = new Modulo7();break;
            case "MODULO8":currentTag = "MODULO8";currentModulo8 = new Modulo8();break;
            default: currentVariable = name;break;
        }
    }
    public void handleEndTag(String name){
        switch (name){
            case "HOGAR": hogares.add(currentHogar);break;
            case "VISITA_ENCUESTADOR": visitaEncuestadors.add(currentVisitaEncuestador);break;
            case "VISITA_SUPERISOR": visitaSupervisors.add(currentVisitaSupervisor);break;
            case "RESULTADO_VISITA_ENCUESTADOR": resVisitaEncuestadors.add(currentResVisitaEncuestador);break;
            case "RESULTADO_VISITA_SUPERVISOR": resVisitaSupervisors.add(currentResVisitaSupervisor);break;
            case "MODULO1H": modulo1HS.add(currentModulo1H);break;
            case "RESIDENTE": residentes.add(currentResidente);break;
            case "MODULO3": modulo3s.add(currentModulo3);break;
            case "MODULO4": modulo4s.add(currentModulo4);break;
            case "MODULO5": modulo5s.add(currentModulo5);break;
            case "MODULO6": modulo6s.add(currentModulo6);break;
            case "MODULO7": modulo7s.add(currentModulo7);break;
            case "MODULO8": modulo8s.add(currentModulo8);break;
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
            case SQLConstantes.resultado_encuestador_id:currentResVisitaEncuestador.set_id(valor);break;
            case SQLConstantes.resultado_encuestador_id_vivienda:currentResVisitaEncuestador.setId_vivienda(valor);break;
            case SQLConstantes.resultado_encuestador_vis_resultado_final:currentResVisitaEncuestador.setVis_resultado_final(valor);break;
            case SQLConstantes.resultado_encuestador_vis_fecha_final_dd:currentResVisitaEncuestador.setVis_fecha_final_dd(valor);break;
            case SQLConstantes.resultado_encuestador_vis_fecha_final_mm:currentResVisitaEncuestador.setVis_fecha_final_mm(valor);break;
            case SQLConstantes.resultado_encuestador_vis_fecha_final_aa:currentResVisitaEncuestador.setVis_fecha_final_aa(valor);break;
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
            case SQLConstantes.resultado_supervisor_id:currentResVisitaSupervisor.set_id(valor);break;
            case SQLConstantes.resultado_supervisor_id_vivienda:currentResVisitaSupervisor.setId_vivienda(valor);break;
            case SQLConstantes.resultado_supervisor_vis_resultado_final:currentResVisitaSupervisor.setVis_resultado_final(valor);break;
            case SQLConstantes.resultado_supervisor_vis_fecha_final_dd:currentResVisitaSupervisor.setVis_fecha_final_dd(valor);break;
            case SQLConstantes.resultado_supervisor_vis_fecha_final_mm:currentResVisitaSupervisor.setVis_fecha_final_mm(valor);break;
            case SQLConstantes.resultado_supervisor_vis_fecha_final_aa:currentResVisitaSupervisor.setVis_fecha_final_aa(valor);break;
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
            case SQLConstantes.modulo1_h_idVivienda:currentModulo1H.setIdVivienda(valor);break;
            case SQLConstantes.modulo1_h_c1_p108:currentModulo1H.setC1_p108(valor);break;
            case SQLConstantes.modulo1_h_c1_p108_o:currentModulo1H.setC1_p108_o(valor);break;
            case SQLConstantes.modulo1_h_c1_p109:currentModulo1H.setC1_p109(valor);break;
            case SQLConstantes.modulo1_h_c1_p109_o:currentModulo1H.setC1_p109_o(valor);break;
            case SQLConstantes.modulo1_h_c1_p110:currentModulo1H.setC1_p110(valor);break;
            case SQLConstantes.modulo1_h_c1_p110_o:currentModulo1H.setC1_p110_o(valor);break;
            case SQLConstantes.modulo1_h_c1_p111:currentModulo1H.setC1_p111(valor);break;
            case SQLConstantes.modulo1_h_c1_p111_o:currentModulo1H.setC1_p111_o(valor);break;
            case SQLConstantes.modulo1_h_c1_p112:currentModulo1H.setC1_p112(valor);break;
            case SQLConstantes.modulo1_h_c1_p112_o:currentModulo1H.setC1_p112_o(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_1:currentModulo1H.setC1_p113_1(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_2:currentModulo1H.setC1_p113_2(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_3:currentModulo1H.setC1_p113_3(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_4:currentModulo1H.setC1_p113_4(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_5:currentModulo1H.setC1_p113_5(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_6:currentModulo1H.setC1_p113_6(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_7:currentModulo1H.setC1_p113_7(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_8:currentModulo1H.setC1_p113_7_o(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_9:currentModulo1H.setC1_p113_8(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_7_o:currentModulo1H.setC1_p113_8_o(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_8_o:currentModulo1H.setC1_p113_9(valor);break;
            case SQLConstantes.modulo1_h_c1_p113_9_o:currentModulo1H.setC1_p113_9_o(valor);break;
            case SQLConstantes.modulo1_h_COB100B:currentModulo1H.setCOB100B(valor);break;
        }
    }

    public void agregarVariableResidente(String campo, String valor){
        switch (campo){
            case SQLConstantes.residentes_id:currentResidente.set_id(valor);break;
            case SQLConstantes.residentes_id_informante:currentResidente.setId_informante(valor);break;
            case SQLConstantes.residentes_id_hogar:currentResidente.setId_hogar(valor);break;
            case SQLConstantes.residentes_id_vivienda:currentResidente.setId_vivienda(valor);break;
            case SQLConstantes.residentes_numero:currentResidente.setNumero(valor);break;
            case SQLConstantes.residentes_c2_p202:currentResidente.setC2_p202(valor);break;
            case SQLConstantes.residentes_c2_p203:currentResidente.setC2_p203(valor);break;
            case SQLConstantes.residentes_c2_p204:currentResidente.setC2_p204(valor);break;
            case SQLConstantes.residentes_c2_p205_a:currentResidente.setC2_p205_a(valor);break;
            case SQLConstantes.residentes_c2_p205_m:currentResidente.setC2_p205_m(valor);break;
            case SQLConstantes.residentes_c2_p206:currentResidente.setC2_p206(valor);break;
            case SQLConstantes.residentes_c2_p207:currentResidente.setC2_p207(valor);break;
            case SQLConstantes.residentes_COB200:currentResidente.setCOB200(valor);break;
            case SQLConstantes.residentes_encuestado_cobertura:currentResidente.setEncuestado_cobertura(valor);break;
        }
    }

    public void agregarVariableModulo3(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo3_id:currentModulo3.set_id(valor);break;
            case SQLConstantes.modulo3_id_informante:currentModulo3.setIdInformante(valor);break;
            case SQLConstantes.modulo3_id_hogar:currentModulo3.setIdHogar(valor);break;
            case SQLConstantes.modulo3_id_vivienda:currentModulo3.setIdVivienda(valor);break;
            case SQLConstantes.modulo3_c3_p301_d:currentModulo3.setC3_p301_d(valor);break;
            case SQLConstantes.modulo3_c3_p301_m:currentModulo3.setC3_p301_m(valor);break;
            case SQLConstantes.modulo3_c3_p301_a:currentModulo3.setC3_p301_a(valor);break;
            case SQLConstantes.modulo3_c3_p302:currentModulo3.setC3_p302(valor);break;
            case SQLConstantes.modulo3_c3_p303_m:currentModulo3.setC3_p303_m(valor);break;
            case SQLConstantes.modulo3_c3_p303_a:currentModulo3.setC3_p303_a(valor);break;
            case SQLConstantes.modulo3_c3_p303_no_nacio:currentModulo3.setC3_p303_no_nacio(valor);break;
            case SQLConstantes.modulo3_c3_p304:currentModulo3.setC3_p304(valor);break;
            case SQLConstantes.modulo3_c3_p305:currentModulo3.setC3_p305(valor);break;
            case SQLConstantes.modulo3_c3_p305_o:currentModulo3.setC3_p305_o(valor);break;
            case SQLConstantes.modulo3_c3_p306:currentModulo3.setC3_p306(valor);break;
            case SQLConstantes.modulo3_c3_p306_o:currentModulo3.setC3_p306_o(valor);break;
            case SQLConstantes.modulo3_c3_p307_d:currentModulo3.setC3_p307_d(valor);break;
            case SQLConstantes.modulo3_c3_p307_m:currentModulo3.setC3_p307_m(valor);break;
            case SQLConstantes.modulo3_c3_p307_a:currentModulo3.setC3_p307_a(valor);break;
            case SQLConstantes.modulo3_c3_p308_e:currentModulo3.setC3_p308_e(valor);break;
            case SQLConstantes.modulo3_c3_p308_m:currentModulo3.setC3_p308_m(valor);break;
            case SQLConstantes.modulo3_c3_p308_e_seleccion:currentModulo3.setC3_p308_e_seleccion(valor);break;
            case SQLConstantes.modulo3_c3_p308_m_seleccion:currentModulo3.setC3_p308_m_seleccion(valor);break;
            case SQLConstantes.modulo3_c3_p310_1:currentModulo3.setC3_p310_1(valor);break;
            case SQLConstantes.modulo3_c3_p310_2:currentModulo3.setC3_p310_2(valor);break;
            case SQLConstantes.modulo3_c3_p310_3:currentModulo3.setC3_p310_3(valor);break;
            case SQLConstantes.modulo3_c3_p310_4:currentModulo3.setC3_p310_4(valor);break;
            case SQLConstantes.modulo3_c3_p311:currentModulo3.setC3_p311(valor);break;
            case SQLConstantes.modulo3_c3_p312_dist:currentModulo3.setC3_p312_dist(valor);break;
            case SQLConstantes.modulo3_c3_p312_prov:currentModulo3.setC3_p312_prov(valor);break;
            case SQLConstantes.modulo3_c3_p312_dep:currentModulo3.setC3_p312_dep(valor);break;
            case SQLConstantes.modulo3_c3_p313:currentModulo3.setC3_p313(valor);break;
            case SQLConstantes.modulo3_c3_p314:currentModulo3.setC3_p314(valor);break;
            case SQLConstantes.modulo3_c3_p314_o:currentModulo3.setC3_p314_o(valor);break;
            case SQLConstantes.modulo3_c3_p315_1:currentModulo3.setC3_p315_1(valor);break;
            case SQLConstantes.modulo3_c3_p315_2:currentModulo3.setC3_p315_2(valor);break;
            case SQLConstantes.modulo3_c3_p315_3:currentModulo3.setC3_p315_3(valor);break;
            case SQLConstantes.modulo3_c3_p315_4:currentModulo3.setC3_p315_4(valor);break;
            case SQLConstantes.modulo3_c3_p315_5:currentModulo3.setC3_p315_5(valor);break;
            case SQLConstantes.modulo3_c3_p315_6:currentModulo3.setC3_p315_6(valor);break;
            case SQLConstantes.modulo3_c3_p315_7:currentModulo3.setC3_p315_7(valor);break;
            case SQLConstantes.modulo3_c3_p315_8:currentModulo3.setC3_p315_8(valor);break;
            case SQLConstantes.modulo3_c3_p315_9:currentModulo3.setC3_p315_9(valor);break;
            case SQLConstantes.modulo3_c3_p315_10:currentModulo3.setC3_p315_10(valor);break;
            case SQLConstantes.modulo3_c3_p315_10_o:currentModulo3.setC3_p315_10_o(valor);break;
            case SQLConstantes.modulo3_c3_p316:currentModulo3.setC3_p316(valor);break;
            case SQLConstantes.modulo3_c3_p316_o:currentModulo3.setC3_p316_o(valor);break;
            case SQLConstantes.modulo3_c3_p317:currentModulo3.setC3_p317(valor);break;
            case SQLConstantes.modulo3_c3_p318:currentModulo3.setC3_p318(valor);break;
            case SQLConstantes.modulo3_obs_cap3:currentModulo3.setObs_cap3(valor);break;
            case SQLConstantes.modulo3_COB300:currentModulo3.setCOB300(valor);break;
        }
    }

    public void agregarVariableModulo4(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo4_id:currentModulo4.set_id(valor);break;
            case SQLConstantes.modulo4_id_informante:currentModulo4.setIdInformante(valor);break;
            case SQLConstantes.modulo4_id_hogar:currentModulo4.setIdHogar(valor);break;
            case SQLConstantes.modulo4_id_vivienda:currentModulo4.setIdVivienda(valor);break;
            case SQLConstantes.modulo4_c4_p401_1:currentModulo4.setC4_p401_1(valor);break;
            case SQLConstantes.modulo4_c4_p401_2:currentModulo4.setC4_p401_2(valor);break;
            case SQLConstantes.modulo4_c4_p401_3:currentModulo4.setC4_p401_3(valor);break;
            case SQLConstantes.modulo4_c4_p401_4:currentModulo4.setC4_p401_4(valor);break;
            case SQLConstantes.modulo4_c4_p401_5:currentModulo4.setC4_p401_5(valor);break;
            case SQLConstantes.modulo4_c4_p401_o:currentModulo4.setC4_p401_o(valor);break;
            case SQLConstantes.modulo4_c4_p402:currentModulo4.setC4_p402(valor);break;
            case SQLConstantes.modulo4_c4_p403_1:currentModulo4.setC4_p403_1(valor);break;
            case SQLConstantes.modulo4_c4_p403_2:currentModulo4.setC4_p403_2(valor);break;
            case SQLConstantes.modulo4_c4_p403_3:currentModulo4.setC4_p403_3(valor);break;
            case SQLConstantes.modulo4_c4_p403_4:currentModulo4.setC4_p403_4(valor);break;
            case SQLConstantes.modulo4_c4_p403_5:currentModulo4.setC4_p403_5(valor);break;
            case SQLConstantes.modulo4_c4_p403_6:currentModulo4.setC4_p403_6(valor);break;
            case SQLConstantes.modulo4_c4_p403_7:currentModulo4.setC4_p403_7(valor);break;
            case SQLConstantes.modulo4_c4_p403_8:currentModulo4.setC4_p403_8(valor);break;
            case SQLConstantes.modulo4_c4_p403_9:currentModulo4.setC4_p403_9(valor);break;
            case SQLConstantes.modulo4_c4_p403_10:currentModulo4.setC4_p403_10(valor);break;
            case SQLConstantes.modulo4_c4_p403_11:currentModulo4.setC4_p403_11(valor);break;
            case SQLConstantes.modulo4_c4_p403_12:currentModulo4.setC4_p403_12(valor);break;
            case SQLConstantes.modulo4_c4_p403_13:currentModulo4.setC4_p403_13(valor);break;
            case SQLConstantes.modulo4_c4_p403_14:currentModulo4.setC4_p403_14(valor);break;
            case SQLConstantes.modulo4_c4_p403_o:currentModulo4.setC4_p403_o(valor);break;
            case SQLConstantes.modulo4_c4_p404:currentModulo4.setC4_p404(valor);break;
            case SQLConstantes.modulo4_c4_p405_1:currentModulo4.setC4_p405_1(valor);break;
            case SQLConstantes.modulo4_c4_p405_2:currentModulo4.setC4_p405_2(valor);break;
            case SQLConstantes.modulo4_c4_p405_4:currentModulo4.setC4_p405_4(valor);break;
            case SQLConstantes.modulo4_c4_p405_5:currentModulo4.setC4_p405_5(valor);break;
            case SQLConstantes.modulo4_c4_p405_3:currentModulo4.setC4_p405_3(valor);break;
            case SQLConstantes.modulo4_c4_p405_6:currentModulo4.setC4_p405_6(valor);break;
            case SQLConstantes.modulo4_c4_p405_7:currentModulo4.setC4_p405_7(valor);break;
            case SQLConstantes.modulo4_c4_p406_1:currentModulo4.setC4_p406_1(valor);break;
            case SQLConstantes.modulo4_c4_p406_2:currentModulo4.setC4_p406_2(valor);break;
            case SQLConstantes.modulo4_c4_p406_3:currentModulo4.setC4_p406_3(valor);break;
            case SQLConstantes.modulo4_c4_p406_4:currentModulo4.setC4_p406_4(valor);break;
            case SQLConstantes.modulo4_c4_p406_5:currentModulo4.setC4_p406_5(valor);break;
            case SQLConstantes.modulo4_c4_p406_6:currentModulo4.setC4_p406_6(valor);break;
            case SQLConstantes.modulo4_c4_p406_7:currentModulo4.setC4_p406_7(valor);break;
            case SQLConstantes.modulo4_c4_p406_8:currentModulo4.setC4_p406_8(valor);break;
            case SQLConstantes.modulo4_c4_p406_o:currentModulo4.setC4_p406_o(valor);break;
            case SQLConstantes.modulo4_c4_p407_1:currentModulo4.setC4_p407_1(valor);break;
            case SQLConstantes.modulo4_c4_p407_2:currentModulo4.setC4_p407_2(valor);break;
            case SQLConstantes.modulo4_c4_p407_3:currentModulo4.setC4_p407_3(valor);break;
            case SQLConstantes.modulo4_c4_p407_4:currentModulo4.setC4_p407_4(valor);break;
            case SQLConstantes.modulo4_c4_p407_5:currentModulo4.setC4_p407_5(valor);break;
            case SQLConstantes.modulo4_c4_p407_6:currentModulo4.setC4_p407_6(valor);break;
            case SQLConstantes.modulo4_c4_p407_7:currentModulo4.setC4_p407_7(valor);break;
            case SQLConstantes.modulo4_c4_p407_8:currentModulo4.setC4_p407_8(valor);break;
            case SQLConstantes.modulo4_c4_p407_9:currentModulo4.setC4_p407_9(valor);break;
            case SQLConstantes.modulo4_c4_p407_10:currentModulo4.setC4_p407_10(valor);break;
            case SQLConstantes.modulo4_c4_p407_11:currentModulo4.setC4_p407_11(valor);break;
            case SQLConstantes.modulo4_c4_p407_12:currentModulo4.setC4_p407_12(valor);break;
            case SQLConstantes.modulo4_c4_p407_13:currentModulo4.setC4_p407_13(valor);break;
            case SQLConstantes.modulo4_c4_p407_o:currentModulo4.setC4_p407_o(valor);break;
            case SQLConstantes.modulo4_c4_p408_1:currentModulo4.setC4_p408_1(valor);break;
            case SQLConstantes.modulo4_c4_p408_2:currentModulo4.setC4_p408_2(valor);break;
            case SQLConstantes.modulo4_c4_p408_3:currentModulo4.setC4_p408_3(valor);break;
            case SQLConstantes.modulo4_c4_p408_4:currentModulo4.setC4_p408_4(valor);break;
            case SQLConstantes.modulo4_c4_p408_5:currentModulo4.setC4_p408_5(valor);break;
            case SQLConstantes.modulo4_c4_p408_6:currentModulo4.setC4_p408_6(valor);break;
            case SQLConstantes.modulo4_c4_p409:currentModulo4.setC4_p409(valor);break;
            case SQLConstantes.modulo4_c4_p410:currentModulo4.setC4_p410(valor);break;
            case SQLConstantes.modulo4_c4_p411_1:currentModulo4.setC4_p411_1(valor);break;
            case SQLConstantes.modulo4_c4_p411_2:currentModulo4.setC4_p411_2(valor);break;
            case SQLConstantes.modulo4_c4_p411_3:currentModulo4.setC4_p411_3(valor);break;
            case SQLConstantes.modulo4_c4_p411_4:currentModulo4.setC4_p411_4(valor);break;
            case SQLConstantes.modulo4_c4_p411_5:currentModulo4.setC4_p411_5(valor);break;
            case SQLConstantes.modulo4_c4_p411_6:currentModulo4.setC4_p411_6(valor);break;
            case SQLConstantes.modulo4_c4_p411_7:currentModulo4.setC4_p411_7(valor);break;
            case SQLConstantes.modulo4_c4_p411_8:currentModulo4.setC4_p411_8(valor);break;
            case SQLConstantes.modulo4_c4_p411_9:currentModulo4.setC4_p411_9(valor);break;
            case SQLConstantes.modulo4_c4_p411_10:currentModulo4.setC4_p411_10(valor);break;
            case SQLConstantes.modulo4_c4_p411_11:currentModulo4.setC4_p411_11(valor);break;
            case SQLConstantes.modulo4_c4_p411_12:currentModulo4.setC4_p411_12(valor);break;
            case SQLConstantes.modulo4_c4_p411_13:currentModulo4.setC4_p411_13(valor);break;
            case SQLConstantes.modulo4_c4_p411_14:currentModulo4.setC4_p411_14(valor);break;
            case SQLConstantes.modulo4_c4_p411_o:currentModulo4.setC4_p411_o(valor);break;
            case SQLConstantes.modulo4_c4_p412:currentModulo4.setC4_p412(valor);break;
            case SQLConstantes.modulo4_c4_p413:currentModulo4.setC4_p413(valor);break;
            case SQLConstantes.modulo4_c4_p414:currentModulo4.setC4_p414(valor);break;
            case SQLConstantes.modulo4_c4_p415:currentModulo4.setC4_p415(valor);break;
            case SQLConstantes.modulo4_c4_p416_1:currentModulo4.setC4_p416_1(valor);break;
            case SQLConstantes.modulo4_c4_p416_2:currentModulo4.setC4_p416_2(valor);break;
            case SQLConstantes.modulo4_c4_p416_3:currentModulo4.setC4_p416_3(valor);break;
            case SQLConstantes.modulo4_c4_p416_4:currentModulo4.setC4_p416_4(valor);break;
            case SQLConstantes.modulo4_c4_p416_5:currentModulo4.setC4_p416_5(valor);break;
            case SQLConstantes.modulo4_c4_p416_6:currentModulo4.setC4_p416_6(valor);break;
            case SQLConstantes.modulo4_c4_p416_7:currentModulo4.setC4_p416_7(valor);break;
            case SQLConstantes.modulo4_c4_p416_8:currentModulo4.setC4_p416_8(valor);break;
            case SQLConstantes.modulo4_c4_p416_o:currentModulo4.setC4_p416_o(valor);break;
            case SQLConstantes.modulo4_obs_cap4:currentModulo4.setObs_cap4(valor);break;
            case SQLConstantes.modulo4_COB400:currentModulo4.setCOB400(valor);break;
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
            case SQLConstantes.modulo6_id:currentModulo6.set_id(valor);break;
            case SQLConstantes.modulo6_id_informante:currentModulo6.setIdInformante(valor);break;
            case SQLConstantes.modulo6_id_hogar:currentModulo6.setIdHogar(valor);break;
            case SQLConstantes.modulo6_id_vivienda:currentModulo6.setIdVivienda(valor);break;
            case SQLConstantes.modulo6_c6_p601:currentModulo6.setC6_p601(valor);break;
            case SQLConstantes.modulo6_c6_p602:currentModulo6.setC6_p602(valor);break;
            case SQLConstantes.modulo6_c6_p603:currentModulo6.setC6_p603(valor);break;
            case SQLConstantes.modulo6_c6_p604_1:currentModulo6.setC6_p604_1(valor);break;
            case SQLConstantes.modulo6_c6_p604_2:currentModulo6.setC6_p604_2(valor);break;
            case SQLConstantes.modulo6_c6_p604_3:currentModulo6.setC6_p604_3(valor);break;
            case SQLConstantes.modulo6_c6_p604_4:currentModulo6.setC6_p604_4(valor);break;
            case SQLConstantes.modulo6_c6_p604_5:currentModulo6.setC6_p604_5(valor);break;
            case SQLConstantes.modulo6_c6_p604_6:currentModulo6.setC6_p604_6(valor);break;
            case SQLConstantes.modulo6_c6_p604_7:currentModulo6.setC6_p604_7(valor);break;
            case SQLConstantes.modulo6_c6_p604_8:currentModulo6.setC6_p604_8(valor);break;
            case SQLConstantes.modulo6_c6_p604_9:currentModulo6.setC6_p604_9(valor);break;
            case SQLConstantes.modulo6_c6_p604_10:currentModulo6.setC6_p604_10(valor);break;
            case SQLConstantes.modulo6_c6_p604_11:currentModulo6.setC6_p604_11(valor);break;
            case SQLConstantes.modulo6_c6_p604_o:currentModulo6.setC6_p604_o(valor);break;
            case SQLConstantes.modulo6_c6_p605:currentModulo6.setC6_p605(valor);break;
            case SQLConstantes.modulo6_c6_p606:currentModulo6.setC6_p606(valor);break;
            case SQLConstantes.modulo6_c6_p607:currentModulo6.setC6_p607(valor);break;
            case SQLConstantes.modulo6_c6_p608:currentModulo6.setC6_p608(valor);break;
            case SQLConstantes.modulo6_c6_p608_o:currentModulo6.setC6_p608_o(valor);break;
            case SQLConstantes.modulo6_c6_p609:currentModulo6.setC6_p609(valor);break;
            case SQLConstantes.modulo6_c6_p610_pd:currentModulo6.setC6_p610_pd(valor);break;
            case SQLConstantes.modulo6_c6_p610_pl:currentModulo6.setC6_p610_pl(valor);break;
            case SQLConstantes.modulo6_c6_p610_pm:currentModulo6.setC6_p610_pm(valor);break;
            case SQLConstantes.modulo6_c6_p610_pmi:currentModulo6.setC6_p610_pmi(valor);break;
            case SQLConstantes.modulo6_c6_p610_pj:currentModulo6.setC6_p610_pj(valor);break;
            case SQLConstantes.modulo6_c6_p610_pv:currentModulo6.setC6_p610_pv(valor);break;
            case SQLConstantes.modulo6_c6_p610_ps:currentModulo6.setC6_p610_ps(valor);break;
            case SQLConstantes.modulo6_c6_p610_pt:currentModulo6.setC6_p610_pt(valor);break;
            case SQLConstantes.modulo6_c6_p610_sd:currentModulo6.setC6_p610_sd(valor);break;
            case SQLConstantes.modulo6_c6_p610_sl:currentModulo6.setC6_p610_sl(valor);break;
            case SQLConstantes.modulo6_c6_p610_sm:currentModulo6.setC6_p610_sm(valor);break;
            case SQLConstantes.modulo6_c6_p610_smi:currentModulo6.setC6_p610_smi(valor);break;
            case SQLConstantes.modulo6_c6_p610_sj:currentModulo6.setC6_p610_sj(valor);break;
            case SQLConstantes.modulo6_c6_p610_sv:currentModulo6.setC6_p610_sv(valor);break;
            case SQLConstantes.modulo6_c6_p610_ss:currentModulo6.setC6_p610_ss(valor);break;
            case SQLConstantes.modulo6_c6_p610_st:currentModulo6.setC6_p610_st(valor);break;
            case SQLConstantes.modulo6_c6_p610_t:currentModulo6.setC6_p610_t(valor);break;
            case SQLConstantes.modulo6_c6_p611:currentModulo6.setC6_p611(valor);break;
            case SQLConstantes.modulo6_c6_p611a:currentModulo6.setC6_p611a(valor);break;
            case SQLConstantes.modulo6_c6_p611b:currentModulo6.setC6_p611b(valor);break;
            case SQLConstantes.modulo6_c6_p612:currentModulo6.setC6_p612(valor);break;
            case SQLConstantes.modulo6_c6_p612_nro:currentModulo6.setC6_p612_nro(valor);break;
            case SQLConstantes.modulo6_c6_p613:currentModulo6.setC6_p613(valor);break;
            case SQLConstantes.modulo6_c6_p614_mon:currentModulo6.setC6_p614_mon(valor);break;
            case SQLConstantes.modulo6_c6_p614_esp:currentModulo6.setC6_p614_esp(valor);break;
            case SQLConstantes.modulo6_c6_p615_mon:currentModulo6.setC6_p615_mon(valor);break;
            case SQLConstantes.modulo6_c6_p615_esp:currentModulo6.setC6_p615_esp(valor);break;
            case SQLConstantes.modulo6_c6_p616_mon:currentModulo6.setC6_p616_mon(valor);break;
            case SQLConstantes.modulo6_c6_p616_esp:currentModulo6.setC6_p616_esp(valor);break;
            case SQLConstantes.modulo6_c6_p616_nas:currentModulo6.setC6_p616_nas(valor);break;
            case SQLConstantes.modulo6_c6_p617:currentModulo6.setC6_p617(valor);break;
            case SQLConstantes.modulo6_c6_p617_dist:currentModulo6.setC6_p617_dist(valor);break;
            case SQLConstantes.modulo6_c6_p617_prov:currentModulo6.setC6_p617_prov(valor);break;
            case SQLConstantes.modulo6_c6_p617_dep:currentModulo6.setC6_p617_dep(valor);break;
            case SQLConstantes.modulo6_c6_p618:currentModulo6.setC6_p618(valor);break;
            case SQLConstantes.modulo6_c6_p619:currentModulo6.setC6_p619(valor);break;
            case SQLConstantes.modulo6_c6_p619_o:currentModulo6.setC6_p619_o(valor);break;
            case SQLConstantes.modulo6_c6_p620:currentModulo6.setC6_p620(valor);break;
            case SQLConstantes.modulo6_c6_p621:currentModulo6.setC6_p621(valor);break;
            case SQLConstantes.modulo6_c6_p622:currentModulo6.setC6_p622(valor);break;
            case SQLConstantes.modulo6_c6_p622_o:currentModulo6.setC6_p622_o(valor);break;
            case SQLConstantes.modulo6_c6_p623:currentModulo6.setC6_p623(valor);break;
            case SQLConstantes.modulo6_c6_p623_o:currentModulo6.setC6_p623_o(valor);break;
            case SQLConstantes.modulo6_c6_p624:currentModulo6.setC6_p624(valor);break;
            case SQLConstantes.modulo6_c6_p625_1:currentModulo6.setC6_p625_1(valor);break;
            case SQLConstantes.modulo6_c6_p625_2:currentModulo6.setC6_p625_2(valor);break;
            case SQLConstantes.modulo6_c6_p625_3:currentModulo6.setC6_p625_3(valor);break;
            case SQLConstantes.modulo6_c6_p625_4:currentModulo6.setC6_p625_4(valor);break;
            case SQLConstantes.modulo6_c6_p625_5:currentModulo6.setC6_p625_5(valor);break;
            case SQLConstantes.modulo6_c6_p625_6:currentModulo6.setC6_p625_6(valor);break;
            case SQLConstantes.modulo6_c6_p625_o:currentModulo6.setC6_p625_o(valor);break;
            case SQLConstantes.modulo6_c6_p626:currentModulo6.setC6_p626(valor);break;
            case SQLConstantes.modulo6_c6_p627:currentModulo6.setC6_p627(valor);break;
            case SQLConstantes.modulo6_c6_p628:currentModulo6.setC6_p628(valor);break;
            case SQLConstantes.modulo6_c6_p629_1:currentModulo6.setC6_p629_1(valor);break;
            case SQLConstantes.modulo6_c6_p629_2:currentModulo6.setC6_p629_2(valor);break;
            case SQLConstantes.modulo6_c6_p629_3:currentModulo6.setC6_p629_3(valor);break;
            case SQLConstantes.modulo6_c6_p629_4:currentModulo6.setC6_p629_4(valor);break;
            case SQLConstantes.modulo6_c6_p629_o:currentModulo6.setC6_p629_o(valor);break;
            case SQLConstantes.modulo6_c6_p629_1_f:currentModulo6.setC6_p629_1_f(valor);break;
            case SQLConstantes.modulo6_c6_p629_1_m:currentModulo6.setC6_p629_1_m(valor);break;
            case SQLConstantes.modulo6_c6_p629_2_f:currentModulo6.setC6_p629_2_f(valor);break;
            case SQLConstantes.modulo6_c6_p629_2_m:currentModulo6.setC6_p629_2_m(valor);break;
            case SQLConstantes.modulo6_c6_p629_3_f:currentModulo6.setC6_p629_3_f(valor);break;
            case SQLConstantes.modulo6_c6_p629_3_m:currentModulo6.setC6_p629_3_m(valor);break;
            case SQLConstantes.modulo6_c6_p629_4_f:currentModulo6.setC6_p629_4_f(valor);break;
            case SQLConstantes.modulo6_c6_p629_4_m:currentModulo6.setC6_p629_4_m(valor);break;
            case SQLConstantes.modulo6_c6_p630_1:currentModulo6.setC6_p630_1(valor);break;
            case SQLConstantes.modulo6_c6_p630_1med:currentModulo6.setC6_p630_1med(valor);break;
            case SQLConstantes.modulo6_c6_p630_1o:currentModulo6.setC6_p630_1o(valor);break;
            case SQLConstantes.modulo6_c6_p630_1frec:currentModulo6.setC6_p630_1frec(valor);break;
            case SQLConstantes.modulo6_c6_p630_1frec_o:currentModulo6.setC6_p630_1frec_o(valor);break;
            case SQLConstantes.modulo6_c6_p630_1mont:currentModulo6.setC6_p630_1mont(valor);break;
            case SQLConstantes.modulo6_c6_p630_2:currentModulo6.setC6_p630_2(valor);break;
            case SQLConstantes.modulo6_c6_p630_2med:currentModulo6.setC6_p630_2med(valor);break;
            case SQLConstantes.modulo6_c6_p630_2o:currentModulo6.setC6_p630_2o(valor);break;
            case SQLConstantes.modulo6_c6_p630_2mont:currentModulo6.setC6_p630_2mont(valor);break;
            case SQLConstantes.modulo6_c6_p630_2frec:currentModulo6.setC6_p630_2frec(valor);break;
            case SQLConstantes.modulo6_c6_p630_2frec_o:currentModulo6.setC6_p630_2frec_o(valor);break;
            case SQLConstantes.modulo6_obs_cap6:currentModulo6.setObs_cap6(valor);break;
            case SQLConstantes.modulo6_COB600:currentModulo6.setCOB600(valor);break;
        }
    }

    public void agregarVariableModulo7(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo7_id:currentModulo7.set_id(valor);break;
            case SQLConstantes.modulo7_id_informante:currentModulo7.setIdInformante(valor);break;
            case SQLConstantes.modulo7_id_hogar:currentModulo7.setIdHogar(valor);break;
            case SQLConstantes.modulo7_id_vivienda:currentModulo7.setIdVivienda(valor);break;
            case SQLConstantes.modulo7_c7_p701:currentModulo7.setC7_p701(valor);break;
            case SQLConstantes.modulo7_c7_p702_1:currentModulo7.setC7_p702_1(valor);break;
            case SQLConstantes.modulo7_c7_p702_2:currentModulo7.setC7_p702_2(valor);break;
            case SQLConstantes.modulo7_c7_p702_3:currentModulo7.setC7_p702_3(valor);break;
            case SQLConstantes.modulo7_c7_p702_4:currentModulo7.setC7_p702_4(valor);break;
            case SQLConstantes.modulo7_c7_p702_5:currentModulo7.setC7_p702_5(valor);break;
            case SQLConstantes.modulo7_c7_p702_6:currentModulo7.setC7_p702_6(valor);break;
            case SQLConstantes.modulo7_c7_p702_7:currentModulo7.setC7_p702_7(valor);break;
            case SQLConstantes.modulo7_c7_p702_8:currentModulo7.setC7_p702_8(valor);break;
            case SQLConstantes.modulo7_c7_p702_9:currentModulo7.setC7_p702_9(valor);break;
            case SQLConstantes.modulo7_c7_p702_10:currentModulo7.setC7_p702_10(valor);break;
            case SQLConstantes.modulo7_c7_p702_o:currentModulo7.setC7_p702_o(valor);break;
            case SQLConstantes.modulo7_c7_p703:currentModulo7.setC7_p703(valor);break;
            case SQLConstantes.modulo7_c7_p704_1:currentModulo7.setC7_p704_1(valor);break;
            case SQLConstantes.modulo7_c7_p704_2:currentModulo7.setC7_p704_2(valor);break;
            case SQLConstantes.modulo7_c7_p704_3:currentModulo7.setC7_p704_3(valor);break;
            case SQLConstantes.modulo7_c7_p704_4:currentModulo7.setC7_p704_4(valor);break;
            case SQLConstantes.modulo7_c7_p704_5:currentModulo7.setC7_p704_5(valor);break;
            case SQLConstantes.modulo7_c7_p704_6:currentModulo7.setC7_p704_6(valor);break;
            case SQLConstantes.modulo7_c7_p704_o:currentModulo7.setC7_p704_o(valor);break;
            case SQLConstantes.modulo7_c7_p705_1:currentModulo7.setC7_p705_1(valor);break;
            case SQLConstantes.modulo7_c7_p705_2:currentModulo7.setC7_p705_2(valor);break;
            case SQLConstantes.modulo7_c7_p705_3:currentModulo7.setC7_p705_3(valor);break;
            case SQLConstantes.modulo7_c7_p705_4:currentModulo7.setC7_p705_4(valor);break;
            case SQLConstantes.modulo7_c7_p705_5:currentModulo7.setC7_p705_5(valor);break;
            case SQLConstantes.modulo7_c7_p705_6:currentModulo7.setC7_p705_6(valor);break;
            case SQLConstantes.modulo7_c7_p705_7:currentModulo7.setC7_p705_7(valor);break;
            case SQLConstantes.modulo7_c7_p705_o:currentModulo7.setC7_p705_o(valor);break;
            case SQLConstantes.modulo7_c7_p706:currentModulo7.setC7_p706(valor);break;
            case SQLConstantes.modulo7_c7_p707_1:currentModulo7.setC7_p707_1(valor);break;
            case SQLConstantes.modulo7_c7_p707_2:currentModulo7.setC7_p707_2(valor);break;
            case SQLConstantes.modulo7_c7_p707_3:currentModulo7.setC7_p707_3(valor);break;
            case SQLConstantes.modulo7_c7_p707_4:currentModulo7.setC7_p707_4(valor);break;
            case SQLConstantes.modulo7_c7_p707_5:currentModulo7.setC7_p707_5(valor);break;
            case SQLConstantes.modulo7_c7_p707_6:currentModulo7.setC7_p707_6(valor);break;
            case SQLConstantes.modulo7_c7_p707_7:currentModulo7.setC7_p707_7(valor);break;
            case SQLConstantes.modulo7_c7_p707_8:currentModulo7.setC7_p707_8(valor);break;
            case SQLConstantes.modulo7_c7_p707_9:currentModulo7.setC7_p707_9(valor);break;
            case SQLConstantes.modulo7_c7_p707_o:currentModulo7.setC7_p707_o(valor);break;
            case SQLConstantes.modulo7_c7_p708_1:currentModulo7.setC7_p708_1(valor);break;
            case SQLConstantes.modulo7_c7_p708_2:currentModulo7.setC7_p708_2(valor);break;
            case SQLConstantes.modulo7_c7_p708_3:currentModulo7.setC7_p708_3(valor);break;
            case SQLConstantes.modulo7_c7_p708_4:currentModulo7.setC7_p708_4(valor);break;
            case SQLConstantes.modulo7_c7_p708_5:currentModulo7.setC7_p708_5(valor);break;
            case SQLConstantes.modulo7_c7_p709_1:currentModulo7.setC7_p709_1(valor);break;
            case SQLConstantes.modulo7_c7_p709_2:currentModulo7.setC7_p709_2(valor);break;
            case SQLConstantes.modulo7_c7_p709_3:currentModulo7.setC7_p709_3(valor);break;
            case SQLConstantes.modulo7_c7_p709_4:currentModulo7.setC7_p709_4(valor);break;
            case SQLConstantes.modulo7_c7_p709_5:currentModulo7.setC7_p709_5(valor);break;
            case SQLConstantes.modulo7_c7_p709_6:currentModulo7.setC7_p709_6(valor);break;
            case SQLConstantes.modulo7_c7_p709_7:currentModulo7.setC7_p709_7(valor);break;
            case SQLConstantes.modulo7_c7_p709_8:currentModulo7.setC7_p709_8(valor);break;
            case SQLConstantes.modulo7_c7_p709_9:currentModulo7.setC7_p709_9(valor);break;
            case SQLConstantes.modulo7_c7_p709_10:currentModulo7.setC7_p709_10(valor);break;
            case SQLConstantes.modulo7_c7_p709_o:currentModulo7.setC7_p709_o(valor);break;
            case SQLConstantes.modulo7_obs_cap7:currentModulo7.setObs_cap7(valor);break;
            case SQLConstantes.modulo7_COB700:currentModulo7.setCOB700(valor);break;
        }
    }

    public void agregarVariableModulo8(String campo, String valor){
        switch (campo){
            case SQLConstantes.modulo8_id:currentModulo8.set_id(valor);break;
            case SQLConstantes.modulo8_id_informante:currentModulo8.setIdInformante(valor);break;
            case SQLConstantes.modulo8_id_hogar:currentModulo8.setIdHogar(valor);break;
            case SQLConstantes.modulo8_id_vivienda:currentModulo8.setIdVivienda(valor);break;
            case SQLConstantes.modulo8_c8_p801:currentModulo8.setC8_p801(valor);break;
            case SQLConstantes.modulo8_c8_p802:currentModulo8.setC8_p802(valor);break;
            case SQLConstantes.modulo8_c8_p803:currentModulo8.setC8_p803(valor);break;
            case SQLConstantes.modulo8_c8_p804:currentModulo8.setC8_p804(valor);break;
            case SQLConstantes.modulo8_c8_p805_1:currentModulo8.setC8_p805_1(valor);break;
            case SQLConstantes.modulo8_c8_p805_2:currentModulo8.setC8_p805_2(valor);break;
            case SQLConstantes.modulo8_c8_p805_3:currentModulo8.setC8_p805_3(valor);break;
            case SQLConstantes.modulo8_c8_p805_4:currentModulo8.setC8_p805_4(valor);break;
            case SQLConstantes.modulo8_c8_p805_5:currentModulo8.setC8_p805_5(valor);break;
            case SQLConstantes.modulo8_c8_p806_1:currentModulo8.setC8_p806_1(valor);break;
            case SQLConstantes.modulo8_c8_p806_2:currentModulo8.setC8_p806_2(valor);break;
            case SQLConstantes.modulo8_c8_p806_3:currentModulo8.setC8_p806_3(valor);break;
            case SQLConstantes.modulo8_c8_p806_4:currentModulo8.setC8_p806_4(valor);break;
            case SQLConstantes.modulo8_c8_p806_5:currentModulo8.setC8_p806_5(valor);break;
            case SQLConstantes.modulo8_c8_p806_6:currentModulo8.setC8_p806_6(valor);break;
            case SQLConstantes.modulo8_c8_p807:currentModulo8.setC8_p807(valor);break;
            case SQLConstantes.modulo8_c8_p808_1:currentModulo8.setC8_p808_1(valor);break;
            case SQLConstantes.modulo8_c8_p808_2:currentModulo8.setC8_p808_2(valor);break;
            case SQLConstantes.modulo8_c8_p808_3:currentModulo8.setC8_p808_3(valor);break;
            case SQLConstantes.modulo8_c8_p808_4:currentModulo8.setC8_p808_4(valor);break;
            case SQLConstantes.modulo8_c8_p808_5:currentModulo8.setC8_p808_5(valor);break;
            case SQLConstantes.modulo8_c8_p808_6:currentModulo8.setC8_p808_6(valor);break;
            case SQLConstantes.modulo8_c8_p808_7:currentModulo8.setC8_p808_7(valor);break;
            case SQLConstantes.modulo8_c8_p808_8:currentModulo8.setC8_p808_8(valor);break;
            case SQLConstantes.modulo8_c8_p808_9:currentModulo8.setC8_p808_9(valor);break;
            case SQLConstantes.modulo8_c8_p808_10:currentModulo8.setC8_p808_10(valor);break;
            case SQLConstantes.modulo8_c8_p808_11:currentModulo8.setC8_p808_11(valor);break;
            case SQLConstantes.modulo8_c8_p808_12:currentModulo8.setC8_p808_12(valor);break;
            case SQLConstantes.modulo8_c8_p808_13:currentModulo8.setC8_p808_13(valor);break;
            case SQLConstantes.modulo8_c8_p808_o:currentModulo8.setC8_p808_o(valor);break;
            case SQLConstantes.modulo8_c8_p809:currentModulo8.setC8_p809(valor);break;
            case SQLConstantes.modulo8_c8_p810_1:currentModulo8.setC8_p810_1(valor);break;
            case SQLConstantes.modulo8_c8_p810_2:currentModulo8.setC8_p810_2(valor);break;
            case SQLConstantes.modulo8_c8_p810_3:currentModulo8.setC8_p810_3(valor);break;
            case SQLConstantes.modulo8_c8_p810_4:currentModulo8.setC8_p810_4(valor);break;
            case SQLConstantes.modulo8_c8_p810_5:currentModulo8.setC8_p810_5(valor);break;
            case SQLConstantes.modulo8_c8_p810_6:currentModulo8.setC8_p810_6(valor);break;
            case SQLConstantes.modulo8_c8_p810_7:currentModulo8.setC8_p810_7(valor);break;
            case SQLConstantes.modulo8_c8_p810_8:currentModulo8.setC8_p810_8(valor);break;
            case SQLConstantes.modulo8_c8_p810_9:currentModulo8.setC8_p810_9(valor);break;
            case SQLConstantes.modulo8_c8_p810_10:currentModulo8.setC8_p810_10(valor);break;
            case SQLConstantes.modulo8_c8_p810_11:currentModulo8.setC8_p810_11(valor);break;
            case SQLConstantes.modulo8_c8_p810_12:currentModulo8.setC8_p810_12(valor);break;
            case SQLConstantes.modulo8_c8_p810_13:currentModulo8.setC8_p810_13(valor);break;
            case SQLConstantes.modulo8_c8_p810_o:currentModulo8.setC8_p810_o(valor);break;
            case SQLConstantes.modulo8_c8_p811:currentModulo8.setC8_p811(valor);break;
            case SQLConstantes.modulo8_c8_p812:currentModulo8.setC8_p812(valor);break;
            case SQLConstantes.modulo8_c8_p813_1:currentModulo8.setC8_p813_1(valor);break;
            case SQLConstantes.modulo8_c8_p813_2:currentModulo8.setC8_p813_2(valor);break;
            case SQLConstantes.modulo8_c8_p813_3:currentModulo8.setC8_p813_3(valor);break;
            case SQLConstantes.modulo8_c8_p813_4:currentModulo8.setC8_p813_4(valor);break;
            case SQLConstantes.modulo8_c8_p813_5:currentModulo8.setC8_p813_5(valor);break;
            case SQLConstantes.modulo8_c8_p813_6:currentModulo8.setC8_p813_6(valor);break;
            case SQLConstantes.modulo8_c8_p813_7:currentModulo8.setC8_p813_7(valor);break;
            case SQLConstantes.modulo8_c8_p813_8:currentModulo8.setC8_p813_8(valor);break;
            case SQLConstantes.modulo8_c8_p813_9:currentModulo8.setC8_p813_9(valor);break;
            case SQLConstantes.modulo8_c8_p813_10:currentModulo8.setC8_p813_10(valor);break;
            case SQLConstantes.modulo8_c8_p813_11:currentModulo8.setC8_p813_11(valor);break;
            case SQLConstantes.modulo8_c8_p813_12:currentModulo8.setC8_p813_12(valor);break;
            case SQLConstantes.modulo8_c8_p813_13:currentModulo8.setC8_p813_13(valor);break;
            case SQLConstantes.modulo8_c8_p813_14:currentModulo8.setC8_p813_14(valor);break;
            case SQLConstantes.modulo8_c8_p813_o:currentModulo8.setC8_p813_o(valor);break;
            case SQLConstantes.modulo8_c8_p814_1:currentModulo8.setC8_p814_1(valor);break;
            case SQLConstantes.modulo8_c8_p814_2:currentModulo8.setC8_p814_2(valor);break;
            case SQLConstantes.modulo8_c8_p814_3:currentModulo8.setC8_p814_3(valor);break;
            case SQLConstantes.modulo8_c8_p814_4:currentModulo8.setC8_p814_4(valor);break;
            case SQLConstantes.modulo8_c8_p814_5:currentModulo8.setC8_p814_5(valor);break;
            case SQLConstantes.modulo8_c8_p814_6:currentModulo8.setC8_p814_6(valor);break;
            case SQLConstantes.modulo8_c8_p814_7:currentModulo8.setC8_p814_7(valor);break;
            case SQLConstantes.modulo8_c8_p814_8:currentModulo8.setC8_p814_8(valor);break;
            case SQLConstantes.modulo8_c8_p815:currentModulo8.setC8_p815(valor);break;
            case SQLConstantes.modulo8_c8_p816_1:currentModulo8.setC8_p816_1(valor);break;
            case SQLConstantes.modulo8_c8_p816_2:currentModulo8.setC8_p816_2(valor);break;
            case SQLConstantes.modulo8_c8_p816_3:currentModulo8.setC8_p816_3(valor);break;
            case SQLConstantes.modulo8_c8_p816_4:currentModulo8.setC8_p816_4(valor);break;
            case SQLConstantes.modulo8_c8_p816_5:currentModulo8.setC8_p816_5(valor);break;
            case SQLConstantes.modulo8_c8_p816_6:currentModulo8.setC8_p816_6(valor);break;
            case SQLConstantes.modulo8_c8_p816_7:currentModulo8.setC8_p816_7(valor);break;
            case SQLConstantes.modulo8_c8_p816_8:currentModulo8.setC8_p816_8(valor);break;
            case SQLConstantes.modulo8_c8_p816_9:currentModulo8.setC8_p816_9(valor);break;
            case SQLConstantes.modulo8_c8_p816_10:currentModulo8.setC8_p816_10(valor);break;
            case SQLConstantes.modulo8_c8_p816_11:currentModulo8.setC8_p816_11(valor);break;
            case SQLConstantes.modulo8_c8_p816_12:currentModulo8.setC8_p816_12(valor);break;
            case SQLConstantes.modulo8_c8_p816_13:currentModulo8.setC8_p816_13(valor);break;
            case SQLConstantes.modulo8_c8_p816_o:currentModulo8.setC8_p816_o(valor);break;
            case SQLConstantes.modulo8_c8_p817:currentModulo8.setC8_p817(valor);break;
            case SQLConstantes.modulo8_c8_p818:currentModulo8.setC8_p818(valor);break;
            case SQLConstantes.modulo8_c8_p819_1:currentModulo8.setC8_p819_1(valor);break;
            case SQLConstantes.modulo8_c8_p819_2:currentModulo8.setC8_p819_2(valor);break;
            case SQLConstantes.modulo8_c8_p819_3:currentModulo8.setC8_p819_3(valor);break;
            case SQLConstantes.modulo8_c8_p819_4:currentModulo8.setC8_p819_4(valor);break;
            case SQLConstantes.modulo8_c8_p819_5:currentModulo8.setC8_p819_5(valor);break;
            case SQLConstantes.modulo8_c8_p819_6:currentModulo8.setC8_p819_6(valor);break;
            case SQLConstantes.modulo8_c8_p819_7:currentModulo8.setC8_p819_7(valor);break;
            case SQLConstantes.modulo8_c8_p819_8:currentModulo8.setC8_p819_8(valor);break;
            case SQLConstantes.modulo8_c8_p819_9:currentModulo8.setC8_p819_9(valor);break;
            case SQLConstantes.modulo8_c8_p819_10:currentModulo8.setC8_p819_10(valor);break;
            case SQLConstantes.modulo8_c8_p819_11:currentModulo8.setC8_p819_11(valor);break;
            case SQLConstantes.modulo8_c8_p819_12:currentModulo8.setC8_p819_12(valor);break;
            case SQLConstantes.modulo8_c8_p819_13:currentModulo8.setC8_p819_13(valor);break;
            case SQLConstantes.modulo8_c8_p819_14:currentModulo8.setC8_p819_14(valor);break;
            case SQLConstantes.modulo8_c8_p819_o:currentModulo8.setC8_p819_o(valor);break;
            case SQLConstantes.modulo8_c8_p820_1:currentModulo8.setC8_p820_1(valor);break;
            case SQLConstantes.modulo8_c8_p820_2:currentModulo8.setC8_p820_2(valor);break;
            case SQLConstantes.modulo8_c8_p820_3:currentModulo8.setC8_p820_3(valor);break;
            case SQLConstantes.modulo8_c8_p820_4:currentModulo8.setC8_p820_4(valor);break;
            case SQLConstantes.modulo8_c8_p820_5:currentModulo8.setC8_p820_5(valor);break;
            case SQLConstantes.modulo8_c8_p820_6:currentModulo8.setC8_p820_6(valor);break;
            case SQLConstantes.modulo8_c8_p820_7:currentModulo8.setC8_p820_7(valor);break;
            case SQLConstantes.modulo8_c8_p820_8:currentModulo8.setC8_p820_8(valor);break;
            case SQLConstantes.modulo8_c8_p820_9:currentModulo8.setC8_p820_9(valor);break;
            case SQLConstantes.modulo8_c8_p820_10:currentModulo8.setC8_p820_10(valor);break;
            case SQLConstantes.modulo8_c8_p820_11:currentModulo8.setC8_p820_11(valor);break;
            case SQLConstantes.modulo8_c8_p820_o:currentModulo8.setC8_p820_o(valor);break;
            case SQLConstantes.modulo8_c8_p821_1:currentModulo8.setC8_p821_1(valor);break;
            case SQLConstantes.modulo8_c8_p821_2:currentModulo8.setC8_p821_2(valor);break;
            case SQLConstantes.modulo8_c8_p821_3:currentModulo8.setC8_p821_3(valor);break;
            case SQLConstantes.modulo8_c8_p821_4:currentModulo8.setC8_p821_4(valor);break;
            case SQLConstantes.modulo8_c8_p821_5:currentModulo8.setC8_p821_5(valor);break;
            case SQLConstantes.modulo8_c8_p821_6:currentModulo8.setC8_p821_6(valor);break;
            case SQLConstantes.modulo8_c8_p821_7:currentModulo8.setC8_p821_7(valor);break;
            case SQLConstantes.modulo8_c8_p821_8:currentModulo8.setC8_p821_8(valor);break;
            case SQLConstantes.modulo8_c8_p822:currentModulo8.setC8_p822(valor);break;
            case SQLConstantes.modulo8_c8_p823_1:currentModulo8.setC8_p823_1(valor);break;
            case SQLConstantes.modulo8_c8_p823_2:currentModulo8.setC8_p823_2(valor);break;
            case SQLConstantes.modulo8_c8_p823_3:currentModulo8.setC8_p823_3(valor);break;
            case SQLConstantes.modulo8_c8_p823_4:currentModulo8.setC8_p823_4(valor);break;
            case SQLConstantes.modulo8_c8_p823_5:currentModulo8.setC8_p823_5(valor);break;
            case SQLConstantes.modulo8_c8_p823_o:currentModulo8.setC8_p823_o(valor);break;
            case SQLConstantes.modulo8_obs_cap8:currentModulo8.setObs_cap8(valor);break;
            case SQLConstantes.modulo8_COB800:currentModulo8.setCOB800(valor);break;
        }
    }
}
