package com.example.ricindigus.empove2018.activities;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.adapters.ExportarAdapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Caratula;
import com.example.ricindigus.empove2018.modelo.pojos.CoberturaFragment;
import com.example.ricindigus.empove2018.modelo.pojos.ExportarItem;
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
import com.example.ricindigus.empove2018.modelo.pojos.POJOFragment;
import com.example.ricindigus.empove2018.modelo.pojos.POJOFragmentHogar;
import com.example.ricindigus.empove2018.modelo.pojos.POJOFragmentVivienda;
import com.example.ricindigus.empove2018.modelo.pojos.POJOLayout;
import com.example.ricindigus.empove2018.modelo.pojos.ResVisitaEncuestador;
import com.example.ricindigus.empove2018.modelo.pojos.ResVisitaSupervisor;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.VisitaEncuestador;
import com.example.ricindigus.empove2018.modelo.pojos.VisitaSupervisor;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import static android.os.Environment.getExternalStorageDirectory;

public class ExportarActivity extends AppCompatActivity {

    ArrayList<Caratula> marcos;
    ArrayList<VisitaEncuestador> visitas;
    ArrayList<ExportarItem> exportarItems;
    private String idUsuario;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ExportarAdapter exportarAdapter;
    private Button btnExportar;
    private Button btnVolver;
    private TextView txtMensaje;
    private ProgressBar progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exportar);
        recyclerView = (RecyclerView) findViewById(R.id.exportacion_recycler);
        btnExportar = (Button) findViewById(R.id.exportacion_btnExportar);
        btnVolver = (Button) findViewById(R.id.exportacion_btnVolver);
        txtMensaje = (TextView) findViewById(R.id.exportacion_txtMensaje);
        progreso = (ProgressBar) findViewById(R.id.exportacion_progreso);

        progreso.setMax(4200);
        txtMensaje.setVisibility(View.GONE);
        progreso.setVisibility(View.GONE);

        final Bundle recupera = getIntent().getExtras();
        if(recupera != null){
            idUsuario = recupera.getString("idUsuario");
        }
        inicializarDatos();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        exportarAdapter = new ExportarAdapter(exportarItems, this, new ExportarAdapter.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b, int pos) {
                if(b){
                    exportarItems.get(pos).setSeleccionado(1);
                }else{
                    exportarItems.get(pos).setSeleccionado(0);
                }
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(exportarAdapter);

        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyAsyncTask().execute(100);
//                mostrarMensaje(mensaje);
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void inicializarDatos() {
        boolean con_resultado=true;
        visitas  = new ArrayList<VisitaEncuestador>();

        marcos = new ArrayList<Caratula>();
        exportarItems = new ArrayList<>();
        Data data = new Data(this);
        data.open();
        marcos = data.getAllCaratulasUsuario(idUsuario);

        for(Caratula caratula: marcos){
            visitas = data.getAllVisitasReult(caratula.get_id()+"");
            con_resultado = false;
            for(VisitaEncuestador visita: visitas){
                con_resultado = true;
                if(visita.getVis_resu()==null){
                    con_resultado = false;
                    break;
                }
            }
            if(con_resultado) {
                ExportarItem exportarItem = new ExportarItem(0, caratula.get_id() + "", caratula.getAnio(), caratula.getMes(),
                        caratula.getPeriodo(), caratula.getConglomerado());
                exportarItems.add(exportarItem);
            }
        }


        data.close();
    }
    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void exportarVivienda(String idVivienda){
        Data data =  new Data(this);
        data.open();
        String nombreArchivo = idVivienda + ".xml";
        Caratula caratula = data.getCaratula(idVivienda);
        ArrayList<Hogar> hogares = data.getAllHogaresVivienda(idVivienda);
        ArrayList<VisitaEncuestador> visitaEncuestadors = data.getAllVisitasEncuestadorVivienda(idVivienda);
        ArrayList<VisitaSupervisor> visitaSupervisors = data.getAllVisitasSupervisorVivienda(idVivienda);
        ArrayList<ResVisitaEncuestador> resVisitaEncuestadors = data.getAllResultadoVisitaEncuestador(idVivienda);
        ArrayList<ResVisitaSupervisor> resVisitaSupervisors = data.getAllResultadoVisitaSupervisor(idVivienda);
        Funcionario funcionario = data.getFuncionario(idVivienda);
        Modulo1V modulo1V = data.getModulo1V(idVivienda);
        ArrayList<Modulo1H> modulo1HS = data.getAllModulo1H(idVivienda);
        ArrayList<Residente> residentes = data.getAllResidentesVivienda(idVivienda);
        ArrayList<Modulo3> modulo3s = data.getAllModulo3(idVivienda);
        ArrayList<M3Pregunta309> m3Pregunta309s = data.getAllM3Pregunta309Vivienda(idVivienda);
        ArrayList<M3Pregunta318> m3Pregunta318s = data.getAllM3Pregunta318Vivienda(idVivienda);
        ArrayList<Modulo4> modulo4s = data.getAllModulo4(idVivienda);
        ArrayList<Modulo5> modulo5s = data.getAllModulo5(idVivienda);
        ArrayList<Modulo6> modulo6s = data.getAllModulo6(idVivienda);
        ArrayList<Modulo7> modulo7s = data.getAllModulo7(idVivienda);
        ArrayList<Modulo8> modulo8s = data.getAllModulo8(idVivienda);
        ArrayList<POJOFragment> pojoFragments = new ArrayList<>();
        ArrayList<POJOFragmentVivienda> pojoFragmentViviendas = new ArrayList<>();
        ArrayList<POJOFragmentHogar> pojoFragmentHogars = new ArrayList<>();
        ArrayList<POJOLayout> pojoLayouts = new ArrayList<>();
        ArrayList<CoberturaFragment> coberturaFragments = new ArrayList<>();
        for (Residente residente : residentes){
            if (residente.getC2_p207().equals("1")){
                pojoFragments.add(data.getFragmentsLayouts(residente.get_id()));
                pojoFragmentViviendas.add(data.getFragmentsVivienda(residente.getId_vivienda()));
                pojoFragmentHogars.add(data.getFragmentsHogar(residente.getId_hogar()));
                pojoLayouts.add(data.getLayouts(residente.get_id()));
                coberturaFragments.add(data.getCoberturaFragments(residente.get_id()));
            }
        }



        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "ENPOVE");
            serializer.attribute("", "id",idVivienda);
            serializer.attribute("", "version",getString(R.string.app_version));
            if(caratula != null) {
                serializer.startTag("", "CARATULA");
                escribirCampoXml(serializer, SQLConstantes.caratula_id,caratula.get_id()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nom_dep,caratula.getNom_dep()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nom_prov,caratula.getNom_prov()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nom_dist ,caratula.getNom_dist()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nom_ccpp,caratula.getNom_ccpp()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_anio,caratula.getAnio()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_mes,caratula.getMes()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_periodo,caratula.getPeriodo()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_conglomerado,caratula.getConglomerado()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_zona ,caratula.getZona()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_manzana_id ,caratula.getManzana_id()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_vivienda ,caratula.getVivienda()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_latitud,caratula.getLatitud()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_longitud ,caratula.getLongitud()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_tipvia ,caratula.getTipvia()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_tipvia_o ,caratula.getTipvia_o()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nomvia ,caratula.getNomvia()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nropta ,caratula.getNropta()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_block ,caratula.getBlock()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_interior ,caratula.getInterior()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_piso ,caratula.getPiso()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_mza,caratula.getMza()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_lote ,caratula.getLote()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_km ,caratula.getKm()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_telefono ,caratula.getTelefono()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_t_hogar ,caratula.getT_hogar()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_usuario ,caratula.getUsuario()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_observaciones ,caratula.getObservaciones()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_cobertura,caratula.getCobertura()+"");
                serializer.endTag("", "CARATULA");
            }

            if(hogares.size()>0) {
                serializer.startTag("", "HOGARES");
                for (Hogar hogar : hogares) {
                    serializer.startTag("", "HOGAR");
                    escribirCampoXml(serializer, SQLConstantes.hogar_id, hogar.get_id());
                    escribirCampoXml(serializer, SQLConstantes.hogar_id_vivienda,hogar.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.hogar_numero,hogar.getNumero());
                    escribirCampoXml(serializer, SQLConstantes.hogar_nom_ape,hogar.getNom_ape());
                    escribirCampoXml(serializer, SQLConstantes.hogar_estado,hogar.getEstado());
                    escribirCampoXml(serializer, SQLConstantes.hogar_nropersonas,hogar.getNropersonas());
                    escribirCampoXml(serializer, SQLConstantes.hogar_vive,hogar.getVive());
                    escribirCampoXml(serializer, SQLConstantes.hogar_nroviven,hogar.getNroviven());
                    escribirCampoXml(serializer, SQLConstantes.hogar_principal,hogar.getPrincipal());
                    escribirCampoXml(serializer, SQLConstantes.hogar_cobertura,hogar.getCobertura());
                    serializer.endTag("", "HOGAR");
                }
                serializer.endTag("", "HOGARES");
            }

            if(visitaEncuestadors.size()>0) {
                serializer.startTag("", "VISITAS_ENCUESTADOR");
                for (VisitaEncuestador visita : visitaEncuestadors) {
                    serializer.startTag("", "VISITA_ENCUESTADOR");
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_id, visita.get_id());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_id_vivienda, visita.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_id_hogar, visita.getId_hogar());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_numero, visita.getNumero());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_fecha_dd, visita.getVis_fecha_dd());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_fecha_mm, visita.getVis_fecha_mm());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_fecha_aa, visita.getVis_fecha_aa());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_hor_ini, visita.getVis_hor_ini());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_min_ini, visita.getVis_min_ini());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_hor_fin, visita.getVis_hor_fin());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_min_fin, visita.getVis_min_fin());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_prox_vis_fecha_dd, visita.getProx_vis_fecha_dd());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_prox_vis_fecha_mm, visita.getProx_vis_fecha_mm());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_prox_vis_fecha_aa, visita.getProx_vis_fecha_aa());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_prox_vis_hor, visita.getProx_vis_hor());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_prox_vis_min, visita.getProx_vis_min());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_resu, visita.getVis_resu());
                    escribirCampoXml(serializer, SQLConstantes.visita_encuestador_vis_resu_esp, visita.getVis_resu_esp());
                    serializer.endTag("", "VISITA_ENCUESTADOR");
                }
                serializer.endTag("", "VISITAS_ENCUESTADOR");
            }

            if(resVisitaEncuestadors.size()>0) {
                serializer.startTag("", "RESULTADOS_VISITA_ENCUESTADOR");
                for (ResVisitaEncuestador resVisitaEncuestador : resVisitaEncuestadors) {
                    serializer.startTag("", "RESULTADO_VISITA_ENCUESTADOR");
                    escribirCampoXml(serializer, SQLConstantes.resultado_encuestador_id, resVisitaEncuestador.get_id());
                    escribirCampoXml(serializer, SQLConstantes.resultado_encuestador_id_vivienda, resVisitaEncuestador.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.resultado_encuestador_vis_resultado_final, resVisitaEncuestador.getVis_resultado_final());
                    escribirCampoXml(serializer, SQLConstantes.resultado_encuestador_vis_fecha_final_dd, resVisitaEncuestador.getVis_fecha_final_dd());
                    escribirCampoXml(serializer, SQLConstantes.resultado_encuestador_vis_fecha_final_mm, resVisitaEncuestador.getVis_fecha_final_mm());
                    escribirCampoXml(serializer, SQLConstantes.resultado_encuestador_vis_fecha_final_aa, resVisitaEncuestador.getVis_fecha_final_aa());
                    serializer.endTag("", "RESULTADO_VISITA_ENCUESTADOR");
                }
                serializer.endTag("", "RESULTADOS_VISITA_ENCUESTADOR");
            }

            if(visitaSupervisors.size()>0) {
                serializer.startTag("", "VISITAS_SUPERVISOR");
                for (VisitaSupervisor visitaSupervisor : visitaSupervisors) {
                    serializer.startTag("", "VISITA_SUPERVISOR");
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_id, visitaSupervisor.get_id());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_id_vivienda, visitaSupervisor.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_id_hogar , visitaSupervisor.getId_hogar());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_numero , visitaSupervisor.getNumero());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_fecha_dd , visitaSupervisor.getVis_fecha_dd());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_fecha_mm , visitaSupervisor.getVis_fecha_mm());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_fecha_aa , visitaSupervisor.getVis_fecha_aa());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_hor_ini , visitaSupervisor.getVis_hor_ini());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_min_ini , visitaSupervisor.getVis_min_ini());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_hor_fin , visitaSupervisor.getVis_hor_fin());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_min_fin , visitaSupervisor.getVis_min_fin());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_resu , visitaSupervisor.getVis_resu());
                    escribirCampoXml(serializer, SQLConstantes.visita_supervisor_vis_resu_esp , visitaSupervisor.getVis_resu_esp());
                    serializer.endTag("", "VISITA_SUPERVISOR");
                }
                serializer.endTag("", "VISITAS_SUPERVISOR");
            }

            if(resVisitaSupervisors.size()>0) {
                serializer.startTag("", "RESULTADOS_VISITA_SUPERVISOR");
                for (ResVisitaSupervisor resVisitaSupervisor : resVisitaSupervisors) {
                    serializer.startTag("", "RESULTADO_VISITA_SUPERVISOR");
                    escribirCampoXml(serializer, SQLConstantes.resultado_supervisor_id, resVisitaSupervisor.get_id());
                    escribirCampoXml(serializer, SQLConstantes.resultado_supervisor_id_vivienda, resVisitaSupervisor.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.resultado_supervisor_vis_resultado_final, resVisitaSupervisor.getVis_resultado_final());
                    escribirCampoXml(serializer, SQLConstantes.resultado_supervisor_vis_fecha_final_dd, resVisitaSupervisor.getVis_fecha_final_dd());
                    escribirCampoXml(serializer, SQLConstantes.resultado_supervisor_vis_fecha_final_mm, resVisitaSupervisor.getVis_fecha_final_mm());
                    escribirCampoXml(serializer, SQLConstantes.resultado_supervisor_vis_fecha_final_aa, resVisitaSupervisor.getVis_fecha_final_aa());
                    serializer.endTag("", "RESULTADO_VISITA_SUPERVISOR");
                }
                serializer.endTag("", "RESULTADOS_VISITA_SUPERVISOR");
            }


            if(funcionario != null) {
                serializer.startTag("", "FUNCIONARIO");
                escribirCampoXml(serializer, SQLConstantes.funcionarios_id, funcionario.get_id());
                escribirCampoXml(serializer, SQLConstantes.funcionarios_dni_encu, funcionario.getDni_encu());
                escribirCampoXml(serializer, SQLConstantes.funcionarios_dni_sup, funcionario.getDni_sup());
                escribirCampoXml(serializer, SQLConstantes.funcionarios_dni_coord, funcionario.getDni_coor());
                escribirCampoXml(serializer, SQLConstantes.funcionarios_nombre_encu, funcionario.getNombre_encu());
                escribirCampoXml(serializer, SQLConstantes.funcionarios_nombre_sup, funcionario.getNombre_sup());
                escribirCampoXml(serializer, SQLConstantes.funcionarios_nombre_coord, funcionario.getNombre_coord());
                serializer.endTag("", "FUNCIONARIO");
            }

            if(modulo1V != null) {
                serializer.startTag("", "MODULO1V");
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_id, modulo1V.get_id());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p101, modulo1V.getC1_p101());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p101_o, modulo1V.getC1_p101_o());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p102, modulo1V.getC1_p102());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p102_o, modulo1V.getC1_p102_o());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p103, modulo1V.getC1_p103());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p103_o, modulo1V.getC1_p103_o());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p104, modulo1V.getC1_p104());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p104_o, modulo1V.getC1_p104_o());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p105, modulo1V.getC1_p105());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p106, modulo1V.getC1_p106());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_c1_p107, modulo1V.getC1_p107());
                escribirCampoXml(serializer, SQLConstantes.modulo1_v_COB100A, modulo1V.getCOB100A());
                serializer.endTag("", "MODULO1V");
            }

            if(modulo1HS.size()>0) {
                serializer.startTag("", "MODULO1_HOGARES");
                for (Modulo1H modulo1H : modulo1HS) {
                    serializer.startTag("", "MODULO1_HOGAR");
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_id, modulo1H.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_idVivienda, modulo1H.getIdVivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p108, modulo1H.getC1_p108());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p108_o, modulo1H.getC1_p108_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p109, modulo1H.getC1_p109());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p109_o, modulo1H.getC1_p109_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p110, modulo1H.getC1_p110());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p110_o, modulo1H.getC1_p110_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p111, modulo1H.getC1_p111());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p111_o, modulo1H.getC1_p111_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p112, modulo1H.getC1_p112());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p112_o, modulo1H.getC1_p112_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_1, modulo1H.getC1_p113_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_2, modulo1H.getC1_p113_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_3, modulo1H.getC1_p113_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_4, modulo1H.getC1_p113_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_5, modulo1H.getC1_p113_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_6, modulo1H.getC1_p113_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_7, modulo1H.getC1_p113_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_8, modulo1H.getC1_p113_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_9, modulo1H.getC1_p113_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_7_o, modulo1H.getC1_p113_7_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_8_o, modulo1H.getC1_p113_8_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_c1_p113_9_o, modulo1H.getC1_p113_9_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo1_h_COB100B, modulo1H.getCOB100B());
                    serializer.endTag("", "MODULO1_HOGAR");
                }
                serializer.endTag("", "MODULO1_HOGARES");
            }

            if(residentes.size()>0) {
                serializer.startTag("", "MODULO2_RESIDENTES");
                for (Residente residente : residentes) {
                    serializer.startTag("", "MODULO2_RESIDENTE");
                    escribirCampoXml(serializer, SQLConstantes.residentes_id, residente.get_id());
                    escribirCampoXml(serializer, SQLConstantes.residentes_id_informante, residente.getId_informante());
                    escribirCampoXml(serializer, SQLConstantes.residentes_id_hogar, residente.getId_hogar());
                    escribirCampoXml(serializer, SQLConstantes.residentes_id_vivienda, residente.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.residentes_numero, residente.getNumero());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p202, residente.getC2_p202());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p203, residente.getC2_p203());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p204, residente.getC2_p204());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p205_a, residente.getC2_p205_a());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p205_m, residente.getC2_p205_m());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p206, residente.getC2_p206());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p207, residente.getC2_p207());
                    escribirCampoXml(serializer, SQLConstantes.residentes_COB200, residente.getCOB200());
                    escribirCampoXml(serializer, SQLConstantes.residentes_encuestado_cobertura, residente.getEncuestado_cobertura());
                    serializer.endTag("", "MODULO2_RESIDENTE");
                }
                serializer.endTag("", "MODULO2_RESIDENTES");
            }

            if(modulo3s.size()>0) {
                serializer.startTag("", "MODULO3S");
                for (Modulo3 modulo3 : modulo3s) {
                    serializer.startTag("", "MODULO3");
                    escribirCampoXml(serializer, SQLConstantes.modulo3_id, modulo3.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_id_informante, modulo3.getIdInformante());//esta que toma idformante y deberia ser id_informante; debere cambiar la bd principal x idinformante
                    escribirCampoXml(serializer, SQLConstantes.modulo3_id_hogar, modulo3.getIdHogar());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_id_vivienda, modulo3.getIdVivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p301_d, modulo3.getC3_p301_d());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p301_m, modulo3.getC3_p301_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p301_a, modulo3.getC3_p301_a());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p302, modulo3.getC3_p302());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p303_m, modulo3.getC3_p303_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p303_a, modulo3.getC3_p303_a());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p303_no_nacio, modulo3.getC3_p303_no_nacio());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p304, modulo3.getC3_p304());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p305, modulo3.getC3_p305());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p305_o, modulo3.getC3_p305_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p306, modulo3.getC3_p306());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p306_o, modulo3.getC3_p306_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p307_d, modulo3.getC3_p307_d());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p307_m, modulo3.getC3_p307_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p307_a, modulo3.getC3_p307_a());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p308_e, modulo3.getC3_p308_e());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p308_m, modulo3.getC3_p308_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p308_e_seleccion, modulo3.getC3_p308_e_seleccion());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p308_m_seleccion, modulo3.getC3_p308_m_seleccion());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p310_1, modulo3.getC3_p310_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p310_2, modulo3.getC3_p310_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p310_3, modulo3.getC3_p310_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p310_4, modulo3.getC3_p310_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p311, modulo3.getC3_p311());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p312_dist, modulo3.getC3_p312_dist());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p312_prov, modulo3.getC3_p312_prov());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p312_dep, modulo3.getC3_p312_dep());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p313, modulo3.getC3_p313());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p314, modulo3.getC3_p314());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p314_o, modulo3.getC3_p314_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_1, modulo3.getC3_p315_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_2, modulo3.getC3_p315_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_3, modulo3.getC3_p315_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_4, modulo3.getC3_p315_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_5, modulo3.getC3_p315_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_6, modulo3.getC3_p315_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_7, modulo3.getC3_p315_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_8, modulo3.getC3_p315_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_9, modulo3.getC3_p315_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_10, modulo3.getC3_p315_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p315_10_o, modulo3.getC3_p315_10_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p316, modulo3.getC3_p316());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p316_o, modulo3.getC3_p316_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p317, modulo3.getC3_p317());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p318, modulo3.getC3_p318());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_obs_cap3, modulo3.getObs_cap3());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_COB300, modulo3.getCOB300());
                    serializer.endTag("", "MODULO3");
                }
                serializer.endTag("", "MODULO3S");
            }

            if(m3Pregunta309s.size()>0) {
                serializer.startTag("", "M3P309RUTAS");
                for (M3Pregunta309 m3Pregunta309 : m3Pregunta309s) {
                    serializer.startTag("", "M3P309RUTA");
                    escribirCampoXml(serializer, SQLConstantes.modulo3_p309_id, m3Pregunta309.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_p309_id_encuestado, m3Pregunta309.getId_encuestado());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_p309_id_vivienda, m3Pregunta309.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_p309_numero, m3Pregunta309.getNumero());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p309_p, m3Pregunta309.getC3_p309_p());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p309_p_nom, m3Pregunta309.getC3_p309_p_nom());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p309_c, m3Pregunta309.getC3_p309_c());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p309_mod, m3Pregunta309.getC3_p309_mod());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p309_m, m3Pregunta309.getC3_p309_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p309_a, m3Pregunta309.getC3_p309_a());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p309_m_cod, m3Pregunta309.getC3_p309_m_cod());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p309_a_cod, m3Pregunta309.getC3_p309_a_cod());
                    serializer.endTag("", "M3P309RUTA");
                }
                serializer.endTag("", "M3P309RUTAS");
            }


            if(m3Pregunta318s.size()>0) {
                serializer.startTag("", "M3P318PERSONAS");
                for (M3Pregunta318 m3Pregunta318 : m3Pregunta318s) {
                    serializer.startTag("", "M3P318PERSONA");
                    escribirCampoXml(serializer, SQLConstantes.modulo3_p318_id, m3Pregunta318.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_p318_idEncuestado, m3Pregunta318.getIdEncuestado());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_p318_id_vivienda, m3Pregunta318.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_p318_numero, m3Pregunta318.getNumero());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p318_f, m3Pregunta318.getC3_p318_f());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p318_s, m3Pregunta318.getC3_p318_s());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p318_e, m3Pregunta318.getC3_p318_e());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_c3_p318_p, m3Pregunta318.getC3_p318_p());
                    serializer.endTag("", "M3P318PERSONA");
                }
                serializer.endTag("", "M3P318PERSONAS");
            }


            if(modulo4s.size()>0) {
                serializer.startTag("", "MODULO4S");
                for (Modulo4 modulo4 : modulo4s) {
                    serializer.startTag("", "MODULO4");
                    escribirCampoXml(serializer, SQLConstantes.modulo4_id, modulo4.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_id_informante, modulo4.getIdInformante());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_id_hogar, modulo4.getIdHogar());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_id_vivienda, modulo4.getIdVivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p401_1, modulo4.getC4_p401_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p401_2, modulo4.getC4_p401_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p401_3, modulo4.getC4_p401_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p401_4, modulo4.getC4_p401_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p401_5, modulo4.getC4_p401_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p401_o, modulo4.getC4_p401_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p402, modulo4.getC4_p402());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_1, modulo4.getC4_p403_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_2, modulo4.getC4_p403_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_3, modulo4.getC4_p403_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_4, modulo4.getC4_p403_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_5, modulo4.getC4_p403_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_6, modulo4.getC4_p403_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_7, modulo4.getC4_p403_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_8, modulo4.getC4_p403_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_9, modulo4.getC4_p403_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_10, modulo4.getC4_p403_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_11, modulo4.getC4_p403_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_12, modulo4.getC4_p403_12());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_13, modulo4.getC4_p403_13());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_14, modulo4.getC4_p403_14());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p403_o, modulo4.getC4_p403_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p404, modulo4.getC4_p404());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p405_1, modulo4.getC4_p405_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p405_2, modulo4.getC4_p405_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p405_3, modulo4.getC4_p405_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p405_4, modulo4.getC4_p405_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p405_5, modulo4.getC4_p405_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p405_6, modulo4.getC4_p405_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p405_7, modulo4.getC4_p405_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_1, modulo4.getC4_p406_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_2, modulo4.getC4_p406_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_3, modulo4.getC4_p406_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_4, modulo4.getC4_p406_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_5, modulo4.getC4_p406_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_6, modulo4.getC4_p406_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_7, modulo4.getC4_p406_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_8, modulo4.getC4_p406_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p406_o, modulo4.getC4_p406_o());





                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_1, modulo4.getC4_p407_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_2, modulo4.getC4_p407_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_3, modulo4.getC4_p407_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_4, modulo4.getC4_p407_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_5, modulo4.getC4_p407_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_6, modulo4.getC4_p407_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_7, modulo4.getC4_p407_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_8, modulo4.getC4_p407_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_9, modulo4.getC4_p407_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_10, modulo4.getC4_p407_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_11, modulo4.getC4_p407_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_12, modulo4.getC4_p407_12());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_13, modulo4.getC4_p407_13());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p407_o, modulo4.getC4_p407_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p408_1, modulo4.getC4_p408_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p408_2, modulo4.getC4_p408_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p408_3, modulo4.getC4_p408_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p408_4, modulo4.getC4_p408_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p408_5, modulo4.getC4_p408_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p408_6, modulo4.getC4_p408_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p409, modulo4.getC4_p409());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p410, modulo4.getC4_p410());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_1, modulo4.getC4_p411_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_2, modulo4.getC4_p411_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_3, modulo4.getC4_p411_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_4, modulo4.getC4_p411_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_5, modulo4.getC4_p411_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_6, modulo4.getC4_p411_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_7, modulo4.getC4_p411_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_8, modulo4.getC4_p411_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_9, modulo4.getC4_p411_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_10, modulo4.getC4_p411_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_11, modulo4.getC4_p411_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_12, modulo4.getC4_p411_12());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_13, modulo4.getC4_p411_13());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_14, modulo4.getC4_p411_14());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p411_o, modulo4.getC4_p411_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p412, modulo4.getC4_p412());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p413, modulo4.getC4_p413());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p414, modulo4.getC4_p414());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p415, modulo4.getC4_p415());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_1, modulo4.getC4_p416_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_2, modulo4.getC4_p416_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_3, modulo4.getC4_p416_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_4, modulo4.getC4_p416_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_5, modulo4.getC4_p416_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_6, modulo4.getC4_p416_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_7, modulo4.getC4_p416_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_8, modulo4.getC4_p416_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_c4_p416_o, modulo4.getC4_p416_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_obs_cap4, modulo4.getObs_cap4());
                    escribirCampoXml(serializer, SQLConstantes.modulo4_COB400, modulo4.getCOB400());
                    serializer.endTag("", "MODULO4");
                }
                serializer.endTag("", "MODULO4S");
            }

            if(modulo5s.size()>0) {
                serializer.startTag("", "MODULO5S");
                for (Modulo5 modulo5 : modulo5s) {
                    serializer.startTag("", "MODULO5");
                    escribirCampoXml(serializer, SQLConstantes.modulo5_id, modulo5.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_id_informante, modulo5.getIdInformante());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_id_hogar, modulo5.getIdHogar());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_id_vivienda, modulo5.getIdVivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p501, modulo5.getC5_p501());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p502_c, modulo5.getC5_p502_c());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p502, modulo5.getC5_p502());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p502_eleccion, modulo5.getC5_p502_eleccion());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p502_o, modulo5.getC5_p502_o());

                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p503, modulo5.getC5_p503());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p504, modulo5.getC5_p504());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p505, modulo5.getC5_p505());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p506_1, modulo5.getC5_p506_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p506_2, modulo5.getC5_p506_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p506_3, modulo5.getC5_p506_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p506_4, modulo5.getC5_p506_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p507, modulo5.getC5_p507());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p507_dist, modulo5.getC5_p507_dist());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p507_prov, modulo5.getC5_p507_prov());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p507_dep, modulo5.getC5_p507_dep());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_1, modulo5.getC5_p508_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_2, modulo5.getC5_p508_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_3, modulo5.getC5_p508_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_4, modulo5.getC5_p508_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_5, modulo5.getC5_p508_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_6, modulo5.getC5_p508_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_7, modulo5.getC5_p508_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_8, modulo5.getC5_p508_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_9, modulo5.getC5_p508_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_10, modulo5.getC5_p508_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_11, modulo5.getC5_p508_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p508_o, modulo5.getC5_p508_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p509, modulo5.getC5_p509());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p510, modulo5.getC5_p510());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p511, modulo5.getC5_p511());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p511_o, modulo5.getC5_p511_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p512, modulo5.getC5_p512());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p512_o, modulo5.getC5_p512_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p513, modulo5.getC5_p513());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_c5_p513_o, modulo5.getC5_p513_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_obs_cap5, modulo5.getObs_cap5());
                    escribirCampoXml(serializer, SQLConstantes.modulo5_COB500, modulo5.getCOB500());
                    serializer.endTag("", "MODULO5");
                }
                serializer.endTag("", "MODULO5S");
            }

            if(modulo6s.size()>0) {
                serializer.startTag("", "MODULO6S");
                for (Modulo6 modulo6 : modulo6s) {
                    serializer.startTag("", "MODULO6");
                    escribirCampoXml(serializer, SQLConstantes.modulo6_id, modulo6.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_id_informante, modulo6.getIdInformante());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_id_hogar, modulo6.getIdHogar());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_id_vivienda, modulo6.getIdVivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p601, modulo6.getC6_p601());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p602, modulo6.getC6_p602());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p603, modulo6.getC6_p603());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_1, modulo6.getC6_p604_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_2, modulo6.getC6_p604_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_3, modulo6.getC6_p604_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_4, modulo6.getC6_p604_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_5, modulo6.getC6_p604_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_6, modulo6.getC6_p604_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_7, modulo6.getC6_p604_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_8, modulo6.getC6_p604_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_9, modulo6.getC6_p604_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_10, modulo6.getC6_p604_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_11, modulo6.getC6_p604_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p604_o, modulo6.getC6_p604_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p605, modulo6.getC6_p605());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p606, modulo6.getC6_p606());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p607, modulo6.getC6_p607());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p608, modulo6.getC6_p608());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p608_o, modulo6.getC6_p608_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p609, modulo6.getC6_p609());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_pd, modulo6.getC6_p610_pd());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_pl, modulo6.getC6_p610_pl());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_pm, modulo6.getC6_p610_pm());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_pmi, modulo6.getC6_p610_pmi());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_pj, modulo6.getC6_p610_pj());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_pv, modulo6.getC6_p610_pv());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_ps, modulo6.getC6_p610_ps());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_pt, modulo6.getC6_p610_pt());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_sd, modulo6.getC6_p610_sd());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_sl, modulo6.getC6_p610_sl());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_sm, modulo6.getC6_p610_sm());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_smi, modulo6.getC6_p610_smi());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_sj, modulo6.getC6_p610_sj());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_sv, modulo6.getC6_p610_sv());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_ss, modulo6.getC6_p610_ss());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_st, modulo6.getC6_p610_st());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p610_t, modulo6.getC6_p610_t());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p611, modulo6.getC6_p611());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p611a, modulo6.getC6_p611a());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p611b, modulo6.getC6_p611b());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p612, modulo6.getC6_p612());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p612_nro, modulo6.getC6_p612_nro());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p613, modulo6.getC6_p613());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p614_mon, modulo6.getC6_p614_mon());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p614_esp, modulo6.getC6_p614_esp());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p615_mon, modulo6.getC6_p615_mon());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p615_esp, modulo6.getC6_p615_esp());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p616_mon, modulo6.getC6_p616_mon());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p616_esp, modulo6.getC6_p616_esp());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p616_nas, modulo6.getC6_p616_nas());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p617, modulo6.getC6_p617());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p617_dist, modulo6.getC6_p617_dist());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p617_prov, modulo6.getC6_p617_prov());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p617_dep, modulo6.getC6_p617_dep());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p618, modulo6.getC6_p618());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p619, modulo6.getC6_p619());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p619_o, modulo6.getC6_p619_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p620, modulo6.getC6_p620());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p621, modulo6.getC6_p621());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p622, modulo6.getC6_p622());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p622_o, modulo6.getC6_p622_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p623, modulo6.getC6_p623());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p623_o, modulo6.getC6_p623_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p624, modulo6.getC6_p624());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p625_1, modulo6.getC6_p625_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p625_2, modulo6.getC6_p625_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p625_3, modulo6.getC6_p625_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p625_4, modulo6.getC6_p625_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p625_5, modulo6.getC6_p625_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p625_6, modulo6.getC6_p625_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p625_o, modulo6.getC6_p625_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p626, modulo6.getC6_p626());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p627, modulo6.getC6_p627());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p628, modulo6.getC6_p628());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_1, modulo6.getC6_p629_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_2, modulo6.getC6_p629_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_3, modulo6.getC6_p629_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_4, modulo6.getC6_p629_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_o, modulo6.getC6_p629_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_1_f, modulo6.getC6_p629_1_f());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_1_m, modulo6.getC6_p629_1_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_2_f, modulo6.getC6_p629_2_f());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_2_m, modulo6.getC6_p629_2_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_3_f, modulo6.getC6_p629_3_f());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_3_m, modulo6.getC6_p629_3_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_4_f, modulo6.getC6_p629_4_f());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p629_4_m, modulo6.getC6_p629_4_m());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_1, modulo6.getC6_p630_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_1med, modulo6.getC6_p630_1med());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_1o, modulo6.getC6_p630_1o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_1frec, modulo6.getC6_p630_1frec());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_1frec, modulo6.getC6_p630_1frec_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_1mont, modulo6.getC6_p630_1mont());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_2, modulo6.getC6_p630_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_2med, modulo6.getC6_p630_2med());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_2o, modulo6.getC6_p630_2o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_2mont, modulo6.getC6_p630_2mont());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_2frec, modulo6.getC6_p630_2frec());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_c6_p630_2frec_o, modulo6.getC6_p630_2frec_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_obs_cap6, modulo6.getObs_cap6());
                    escribirCampoXml(serializer, SQLConstantes.modulo6_COB600, modulo6.getCOB600());
                    serializer.endTag("", "MODULO6");
                }
                serializer.endTag("", "MODULO6S");
            }

            if(modulo7s.size()>0) {
                serializer.startTag("", "MODULO7S");
                for (Modulo7 modulo7 : modulo7s) {
                    serializer.startTag("", "MODULO7");
                    escribirCampoXml(serializer, SQLConstantes.modulo7_id, modulo7.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_id_informante, modulo7.getIdInformante());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_id_hogar, modulo7.getIdHogar());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_id_vivienda, modulo7.getIdVivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p701, modulo7.getC7_p701());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_1, modulo7.getC7_p702_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_2, modulo7.getC7_p702_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_3, modulo7.getC7_p702_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_4, modulo7.getC7_p702_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_5, modulo7.getC7_p702_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_6, modulo7.getC7_p702_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_7, modulo7.getC7_p702_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_8, modulo7.getC7_p702_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_9, modulo7.getC7_p702_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_10, modulo7.getC7_p702_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p702_o, modulo7.getC7_p702_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p703, modulo7.getC7_p703());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p704_1, modulo7.getC7_p704_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p704_2, modulo7.getC7_p704_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p704_3, modulo7.getC7_p704_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p704_4, modulo7.getC7_p704_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p704_5, modulo7.getC7_p704_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p704_6, modulo7.getC7_p704_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p704_o, modulo7.getC7_p704_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p705_1, modulo7.getC7_p705_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p705_2, modulo7.getC7_p705_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p705_3, modulo7.getC7_p705_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p705_4, modulo7.getC7_p705_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p705_5, modulo7.getC7_p705_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p705_6, modulo7.getC7_p705_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p705_7, modulo7.getC7_p705_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p705_o, modulo7.getC7_p705_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p706, modulo7.getC7_p706());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_1, modulo7.getC7_p707_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_2, modulo7.getC7_p707_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_3, modulo7.getC7_p707_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_4, modulo7.getC7_p707_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_5, modulo7.getC7_p707_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_6, modulo7.getC7_p707_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_7, modulo7.getC7_p707_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_8, modulo7.getC7_p707_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_9, modulo7.getC7_p707_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p707_o, modulo7.getC7_p707_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p708_1, modulo7.getC7_p708_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p708_2, modulo7.getC7_p708_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p708_3, modulo7.getC7_p708_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p708_4, modulo7.getC7_p708_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p708_5, modulo7.getC7_p708_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_1, modulo7.getC7_p709_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_2, modulo7.getC7_p709_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_3, modulo7.getC7_p709_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_4, modulo7.getC7_p709_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_5, modulo7.getC7_p709_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_6, modulo7.getC7_p709_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_7, modulo7.getC7_p709_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_8, modulo7.getC7_p709_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_9, modulo7.getC7_p709_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_10, modulo7.getC7_p709_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_c7_p709_o, modulo7.getC7_p709_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_obs_cap7, modulo7.getObs_cap7());
                    escribirCampoXml(serializer, SQLConstantes.modulo7_COB700, modulo7.getCOB700());
                    serializer.endTag("", "MODULO7");
                }
                serializer.endTag("", "MODULO7S");
            }

            if(modulo8s.size()>0) {
                serializer.startTag("", "MODULO8S");
                for (Modulo8 modulo8 : modulo8s) {
                    serializer.startTag("", "MODULO8");
                    escribirCampoXml(serializer, SQLConstantes.modulo8_id, modulo8.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_id_informante, modulo8.getIdInformante());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_id_hogar, modulo8.getIdHogar());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_id_vivienda, modulo8.getIdVivienda());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p801, modulo8.getC8_p801());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p802, modulo8.getC8_p802());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p803, modulo8.getC8_p803());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p804, modulo8.getC8_p804());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p805_1, modulo8.getC8_p805_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p805_2, modulo8.getC8_p805_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p805_3, modulo8.getC8_p805_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p805_4, modulo8.getC8_p805_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p805_5, modulo8.getC8_p805_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p806_1, modulo8.getC8_p806_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p806_2, modulo8.getC8_p806_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p806_3, modulo8.getC8_p806_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p806_4, modulo8.getC8_p806_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p806_5, modulo8.getC8_p806_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p806_6, modulo8.getC8_p806_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p807, modulo8.getC8_p807());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_1, modulo8.getC8_p808_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_2, modulo8.getC8_p808_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_3, modulo8.getC8_p808_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_4, modulo8.getC8_p808_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_5, modulo8.getC8_p808_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_6, modulo8.getC8_p808_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_7, modulo8.getC8_p808_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_8, modulo8.getC8_p808_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_9, modulo8.getC8_p808_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_10, modulo8.getC8_p808_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_11, modulo8.getC8_p808_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_12, modulo8.getC8_p808_12());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_13, modulo8.getC8_p808_13());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p808_o, modulo8.getC8_p808_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p809, modulo8.getC8_p809());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_1, modulo8.getC8_p810_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_2, modulo8.getC8_p810_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_3, modulo8.getC8_p810_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_4, modulo8.getC8_p810_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_5, modulo8.getC8_p810_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_6, modulo8.getC8_p810_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_7, modulo8.getC8_p810_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_8, modulo8.getC8_p810_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_9, modulo8.getC8_p810_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_10, modulo8.getC8_p810_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_11, modulo8.getC8_p810_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_12, modulo8.getC8_p810_12());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_13, modulo8.getC8_p810_13());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p810_o, modulo8.getC8_p810_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p811, modulo8.getC8_p811());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p812, modulo8.getC8_p812());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_1, modulo8.getC8_p813_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_2, modulo8.getC8_p813_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_3, modulo8.getC8_p813_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_4, modulo8.getC8_p813_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_5, modulo8.getC8_p813_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_6, modulo8.getC8_p813_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_7, modulo8.getC8_p813_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_8, modulo8.getC8_p813_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_9, modulo8.getC8_p813_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_10, modulo8.getC8_p813_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_11, modulo8.getC8_p813_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_12, modulo8.getC8_p813_12());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_13, modulo8.getC8_p813_13());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_14, modulo8.getC8_p813_14());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p813_o, modulo8.getC8_p813_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p814_1, modulo8.getC8_p814_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p814_2, modulo8.getC8_p814_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p814_3, modulo8.getC8_p814_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p814_4, modulo8.getC8_p814_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p814_5, modulo8.getC8_p814_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p814_6, modulo8.getC8_p814_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p814_7, modulo8.getC8_p814_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p814_8, modulo8.getC8_p814_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p815, modulo8.getC8_p815());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_1, modulo8.getC8_p816_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_2, modulo8.getC8_p816_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_3, modulo8.getC8_p816_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_4, modulo8.getC8_p816_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_5, modulo8.getC8_p816_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_6, modulo8.getC8_p816_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_7, modulo8.getC8_p816_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_8, modulo8.getC8_p816_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_9, modulo8.getC8_p816_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_10, modulo8.getC8_p816_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_11, modulo8.getC8_p816_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_12, modulo8.getC8_p816_12());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_13, modulo8.getC8_p816_13());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p816_o, modulo8.getC8_p816_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p817, modulo8.getC8_p817());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p818, modulo8.getC8_p818());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_1, modulo8.getC8_p819_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_2, modulo8.getC8_p819_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_3, modulo8.getC8_p819_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_4, modulo8.getC8_p819_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_5, modulo8.getC8_p819_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_6, modulo8.getC8_p819_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_7, modulo8.getC8_p819_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_8, modulo8.getC8_p819_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_9, modulo8.getC8_p819_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_10, modulo8.getC8_p819_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_11, modulo8.getC8_p819_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_12, modulo8.getC8_p819_12());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_13, modulo8.getC8_p819_13());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_14, modulo8.getC8_p819_14());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p819_o, modulo8.getC8_p819_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_1, modulo8.getC8_p820_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_2, modulo8.getC8_p820_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_3, modulo8.getC8_p820_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_4, modulo8.getC8_p820_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_5, modulo8.getC8_p820_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_6, modulo8.getC8_p820_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_7, modulo8.getC8_p820_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_8, modulo8.getC8_p820_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_9, modulo8.getC8_p820_9());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_10, modulo8.getC8_p820_10());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_11, modulo8.getC8_p820_11());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p820_o, modulo8.getC8_p820_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p821_1, modulo8.getC8_p821_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p821_2, modulo8.getC8_p821_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p821_3, modulo8.getC8_p821_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p821_4, modulo8.getC8_p821_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p821_5, modulo8.getC8_p821_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p821_6, modulo8.getC8_p821_6());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p821_7, modulo8.getC8_p821_7());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p821_8, modulo8.getC8_p821_8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p822, modulo8.getC8_p822());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p823_1, modulo8.getC8_p823_1());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p823_2, modulo8.getC8_p823_2());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p823_3, modulo8.getC8_p823_3());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p823_4, modulo8.getC8_p823_4());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p823_5, modulo8.getC8_p823_5());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_c8_p823_o, modulo8.getC8_p823_o());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_obs_cap8, modulo8.getObs_cap8());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_COB800, modulo8.getCOB800());
                    escribirCampoXml(serializer, SQLConstantes.modulo8_email, modulo8.getEmail());

                    serializer.endTag("", "MODULO8");
                }
                serializer.endTag("", "MODULO8S");
            }

            if(pojoFragmentViviendas.size()>0) {
                serializer.startTag("", "FRAGMENTS_VIVIENDA");
                for (POJOFragmentVivienda pojoFragmentVivienda : pojoFragmentViviendas) {
                    serializer.startTag("", "FRAGMENT_VIVIENDA");
                    escribirCampoXml(serializer, SQLConstantes.fragments_vivienda_id, pojoFragmentVivienda.get_id());
                    escribirCampoXml(serializer, SQLConstantes.fragments_vivienda_caratula, pojoFragmentVivienda.getCaratula());
                    escribirCampoXml(serializer, SQLConstantes.fragments_vivienda_hogares, pojoFragmentVivienda.getHogares());
                    serializer.endTag("", "FRAGMENT_VIVIENDA");
                }
                serializer.endTag("", "FRAGMENTS_VIVIENDA");
            }

            if(pojoFragmentHogars.size()>0) {
                serializer.startTag("", "FRAGMENTS_HOGAR");
                for (POJOFragmentHogar pojoFragmentHogar : pojoFragmentHogars) {
                    serializer.startTag("", "FRAGMENT_HOGAR");
                    escribirCampoXml(serializer, SQLConstantes.fragments_hogar_id, pojoFragmentHogar.get_id());
                    escribirCampoXml(serializer, SQLConstantes.fragments_hogar_id_vivienda, pojoFragmentHogar.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.fragments_hogar_visitas_encuestador, pojoFragmentHogar.getVisitas_encuestador());
                    escribirCampoXml(serializer, SQLConstantes.fragments_hogar_visitas_supervisor, pojoFragmentHogar.getVisitas_supervisor());
                    escribirCampoXml(serializer, SQLConstantes.fragments_hogar_funcionarios, pojoFragmentHogar.getFuncionarios());
                    escribirCampoXml(serializer, SQLConstantes.fragments_hogar_p101p107, pojoFragmentHogar.getP101p107());
                    escribirCampoXml(serializer, SQLConstantes.fragments_hogar_p108p113, pojoFragmentHogar.getP108p113());
                    escribirCampoXml(serializer, SQLConstantes.fragments_hogar_p201p207, pojoFragmentHogar.getP201p207());
                    serializer.endTag("", "FRAGMENT_HOGAR");
                }
                serializer.endTag("", "FRAGMENTS_HOGAR");
            }

            if(pojoFragments.size()>0) {
                serializer.startTag("", "FRAGMENTS_ENCUESTADO");
                for (POJOFragment pojoFragment : pojoFragments) {
                    serializer.startTag("", "FRAGMENT_ENCUESTADO");
                    escribirCampoXml(serializer, SQLConstantes.fragments_id, pojoFragment.get_id());
                    escribirCampoXml(serializer, SQLConstantes.fragments_id_vivienda, pojoFragment.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p301p305, pojoFragment.getP301p305());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p306p308, pojoFragment.getP306p308());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p309, pojoFragment.getP309());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p310p312, pojoFragment.getP310p312());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p313p317, pojoFragment.getP313p317());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p318, pojoFragment.getP318());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p401p404, pojoFragment.getP401p404());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p405p407, pojoFragment.getP405p407());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p408p410, pojoFragment.getP408p410());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p411p416, pojoFragment.getP411p416());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p501p505, pojoFragment.getP501p505());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p506p507, pojoFragment.getP506p507());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p508p511, pojoFragment.getP508p511());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p512p513, pojoFragment.getP512p513());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p601p604, pojoFragment.getP601p604());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p605p608, pojoFragment.getP605p608());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p609p612, pojoFragment.getP609p612());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p613p617, pojoFragment.getP613p617());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p618p621, pojoFragment.getP618p621());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p622p625, pojoFragment.getP622p625());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p626p629, pojoFragment.getP626p629());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p630, pojoFragment.getP630());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p701p705, pojoFragment.getP701p705());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p706p709, pojoFragment.getP706p709());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p801p804, pojoFragment.getP801p804());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p805p808, pojoFragment.getP805p808());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p809p812, pojoFragment.getP809p812());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p813p816, pojoFragment.getP813p816());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p817p820, pojoFragment.getP817p820());
                    escribirCampoXml(serializer, SQLConstantes.fragments_p821p823, pojoFragment.getP821p823());
                    serializer.endTag("", "FRAGMENT_ENCUESTADO");
                }
                serializer.endTag("", "FRAGMENTS_ENCUESTADO");
            }

            if(pojoLayouts.size()>0) {
                serializer.startTag("", "LAYOUTS_ENCUESTADO");
                for (POJOLayout pojoLayout : pojoLayouts) {
                    serializer.startTag("", "LAYOUT_ENCUESTADO");
                    escribirCampoXml(serializer, SQLConstantes.layouts_id, pojoLayout.get_id());
                    escribirCampoXml(serializer, SQLConstantes.layouts_id_vivienda, pojoLayout.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p301, pojoLayout.getP301());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p302, pojoLayout.getP302());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p303, pojoLayout.getP303());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p304, pojoLayout.getP304());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p305, pojoLayout.getP305());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p306, pojoLayout.getP306());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p307, pojoLayout.getP307());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p308, pojoLayout.getP308());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p309, pojoLayout.getP309());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p310, pojoLayout.getP310());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p311, pojoLayout.getP311());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p312, pojoLayout.getP312());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p313, pojoLayout.getP313());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p314, pojoLayout.getP314());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p315, pojoLayout.getP315());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p316, pojoLayout.getP316());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p317, pojoLayout.getP317());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p318, pojoLayout.getP318());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p401, pojoLayout.getP401());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p402, pojoLayout.getP402());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p403, pojoLayout.getP403());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p404, pojoLayout.getP404());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p405, pojoLayout.getP405());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p406, pojoLayout.getP406());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p407, pojoLayout.getP407());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p408, pojoLayout.getP408());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p409, pojoLayout.getP409());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p410, pojoLayout.getP410());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p411, pojoLayout.getP411());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p412, pojoLayout.getP412());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p413, pojoLayout.getP413());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p414, pojoLayout.getP414());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p415, pojoLayout.getP415());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p416, pojoLayout.getP416());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p501, pojoLayout.getP501());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p502, pojoLayout.getP502());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p503, pojoLayout.getP503());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p504, pojoLayout.getP504());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p505, pojoLayout.getP505());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p506, pojoLayout.getP506());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p507, pojoLayout.getP507());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p508, pojoLayout.getP508());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p509, pojoLayout.getP509());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p510, pojoLayout.getP510());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p511, pojoLayout.getP511());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p512, pojoLayout.getP512());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p513, pojoLayout.getP513());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p601, pojoLayout.getP601());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p602, pojoLayout.getP602());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p603, pojoLayout.getP603());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p604, pojoLayout.getP604());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p605, pojoLayout.getP605());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p606, pojoLayout.getP606());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p607, pojoLayout.getP607());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p608, pojoLayout.getP608());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p609, pojoLayout.getP609());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p610, pojoLayout.getP610());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p611, pojoLayout.getP611());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p611a, pojoLayout.getP611a());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p611b, pojoLayout.getP611b());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p612, pojoLayout.getP612());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p613, pojoLayout.getP613());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p614, pojoLayout.getP614());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p615, pojoLayout.getP615());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p616, pojoLayout.getP616());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p617, pojoLayout.getP617());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p618, pojoLayout.getP618());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p619, pojoLayout.getP619());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p620, pojoLayout.getP620());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p621, pojoLayout.getP621());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p622, pojoLayout.getP622());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p623, pojoLayout.getP623());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p624, pojoLayout.getP624());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p625, pojoLayout.getP625());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p626, pojoLayout.getP626());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p627, pojoLayout.getP627());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p628, pojoLayout.getP628());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p629, pojoLayout.getP629());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p630, pojoLayout.getP630());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p701, pojoLayout.getP701());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p702, pojoLayout.getP702());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p703, pojoLayout.getP703());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p704, pojoLayout.getP704());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p705, pojoLayout.getP705());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p706, pojoLayout.getP706());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p707, pojoLayout.getP707());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p708, pojoLayout.getP708());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p709, pojoLayout.getP709());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p801, pojoLayout.getP801());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p802, pojoLayout.getP802());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p803, pojoLayout.getP803());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p804, pojoLayout.getP804());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p805, pojoLayout.getP805());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p806, pojoLayout.getP806());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p807, pojoLayout.getP807());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p808, pojoLayout.getP808());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p809, pojoLayout.getP809());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p810, pojoLayout.getP810());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p811, pojoLayout.getP811());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p812, pojoLayout.getP812());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p813, pojoLayout.getP813());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p814, pojoLayout.getP814());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p815, pojoLayout.getP815());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p816, pojoLayout.getP816());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p817, pojoLayout.getP817());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p818, pojoLayout.getP818());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p819, pojoLayout.getP819());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p820, pojoLayout.getP820());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p821, pojoLayout.getP821());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p822, pojoLayout.getP822());
                    escribirCampoXml(serializer, SQLConstantes.layouts_p823, pojoLayout.getP823());
                    serializer.endTag("", "LAYOUT_ENCUESTADO");
                }
                serializer.endTag("", "LAYOUTS_ENCUESTADO");
            }

            if(coberturaFragments.size()>0) {
                serializer.startTag("", "COBERTURAS_FRAGMENT");
                for (CoberturaFragment coberturaFragment : coberturaFragments) {
                    serializer.startTag("", "COBERTURA_FRAGMENT");
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_id, coberturaFragment.get_id());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_id_vivienda, coberturaFragment.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp301p305, coberturaFragment.getCp301p305());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp306p308, coberturaFragment.getCp306p308());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp309, coberturaFragment.getCp309());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp310p312, coberturaFragment.getCp310p312());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp313p317, coberturaFragment.getCp313p317());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp318, coberturaFragment.getCp318());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp401p404, coberturaFragment.getCp401p404());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp405p407, coberturaFragment.getCp405p407());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp408p410, coberturaFragment.getCp408p410());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp411p416, coberturaFragment.getCp411p416());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp501p505, coberturaFragment.getCp501p505());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp506p507, coberturaFragment.getCp506p507());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp508p511, coberturaFragment.getCp508p511());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp512p513, coberturaFragment.getCp512p513());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp601p604, coberturaFragment.getCp601p604());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp605p608, coberturaFragment.getCp605p608());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp609p612, coberturaFragment.getCp609p612());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp613p617, coberturaFragment.getCp613p617());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp618p621, coberturaFragment.getCp618p621());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp622p625, coberturaFragment.getCp622p625());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp626p629, coberturaFragment.getCp626p629());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp630, coberturaFragment.getCp630());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp701p705, coberturaFragment.getCp701p705());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp706p709, coberturaFragment.getCp706p709());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp801p804, coberturaFragment.getCp801p804());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp805p808, coberturaFragment.getCp805p808());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp809p812, coberturaFragment.getCp809p812());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp813p816, coberturaFragment.getCp813p816());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp817p820, coberturaFragment.getCp817p820());
                    escribirCampoXml(serializer, SQLConstantes.cobertura_fragments_cp821p823, coberturaFragment.getCp821p823());
                    serializer.endTag("", "COBERTURA_FRAGMENT");
                }
                serializer.endTag("", "COBERTURAS_FRAGMENT");
            }

            serializer.endTag("", "ENPOVE");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "ENPOVE2018");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
//            IOHelper.writeToFile(this, "cities.xml", result);
//                    txtXml.setText("From writeToXmlFile\n" + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void escribirCampoXml(XmlSerializer s, String campo,String valor){
        try {
            s.startTag("", campo);
            if(valor != null) s.text(valor);
            else s.text("");
            s.endTag("", campo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtMensaje.setText("Exportando...");
            txtMensaje.setVisibility(View.VISIBLE);
            progreso.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            String mensaje = "";
            int i = 1;
            for(ExportarItem exportarItem : exportarItems){
                if(exportarItem.getSeleccionado() == 1){
                    //aqui exporta
                    exportarVivienda(exportarItem.getIdVivienda());
                    publishProgress(i);
                }
                i++;
            }
            return "Listo";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progreso.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);
            txtMensaje.setText(string);
            progreso.setVisibility(View.GONE);
            txtMensaje.setVisibility(View.GONE);
            Toast.makeText(ExportarActivity.this, "Exportacion Completa", Toast.LENGTH_SHORT).show();
        }
    }
}
