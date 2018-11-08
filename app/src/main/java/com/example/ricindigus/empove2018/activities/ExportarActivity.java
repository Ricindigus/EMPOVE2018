package com.example.ricindigus.empove2018.activities;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.ricindigus.empove2018.modelo.pojos.ExportarItem;
import com.example.ricindigus.empove2018.modelo.pojos.Funcionario;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.modelo.pojos.ItemMarco;
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
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.VisitaEncuestador;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import static android.os.Environment.getExternalStorageDirectory;

public class ExportarActivity extends AppCompatActivity {

    ArrayList<ItemMarco> marcos;
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
        marcos = new ArrayList<ItemMarco>();
        exportarItems = new ArrayList<>();
        Data data = new Data(this);
        data.open();
        marcos = data.getListMarco(idUsuario);
        data.close();

        for(ItemMarco itemMarco: marcos){
            ExportarItem exportarItem = new ExportarItem(0,itemMarco.get_id()+"",itemMarco.getAnio(), itemMarco.getMes(),
                    itemMarco.getPeriodo(),itemMarco.getConglomerado(),itemMarco.getNorden());
            exportarItems.add(exportarItem);
        }
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
        ArrayList<VisitaEncuestador> visitas = data.getAllVisitasVivienda(idVivienda);
        Funcionario funcionario = data.getFuncionario(idVivienda);
        Modulo1V modulo1V = data.getModulo1V(idVivienda);

        ArrayList<Modulo1H> modulo1HS = data.getAllModulo1H(idVivienda);
        ArrayList<Residente> residentes = data.getAllResidentesVivienda(idVivienda);
        ArrayList<Modulo3> modulo3s = data.getAllModulo3(idVivienda);
        ArrayList<M3Pregunta309> m3Pregunta309s = data.getAllM3Pregunta309(idVivienda);
        ArrayList<M3Pregunta318> m3Pregunta318s = data.getAllM3Pregunta318(idVivienda);
        ArrayList<Modulo4> modulo4s = data.getAllModulo4(idVivienda);
        ArrayList<Modulo5> modulo5s = data.getAllModulo5(idVivienda);
        ArrayList<Modulo6> modulo6s = data.getAllModulo6(idVivienda);
        ArrayList<Modulo7> modulo7s = data.getAllModulo7(idVivienda);
        ArrayList<Modulo8> modulo8s = data.getAllModulo8(idVivienda);

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "ENPOVE");
            serializer.attribute("", "id",idVivienda);

            if(caratula != null) {
                serializer.startTag("", "CARATULA");
                escribirCampoXml(serializer, SQLConstantes.caratula_id,caratula.get_id()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nom_dep,caratula.getNom_dep()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nom_prov,caratula.getNom_prov()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nom_dist ,caratula.getNom_dist()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_nom_ccpp,caratula.getNom_ccpp()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_zona ,caratula.getZona()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_manzana_id ,caratula.getManzana_id()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_vivienda ,caratula.getVivienda()+"");
                escribirCampoXml(serializer, SQLConstantes.caratula_tipvia ,caratula.getTipvia()+"");
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
                    serializer.endTag("", "HOGAR");
                }
                serializer.endTag("", "HOGARES");
            }

            if(visitas.size()>0) {
                serializer.startTag("", "VISITAS_ENCUESTADOR");
                for (VisitaEncuestador visita : visitas) {
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
                    serializer.endTag("", "MODULO1_HOGAR");
                }
                serializer.endTag("", "MODULO1_HOGARES");
            }

            if(residentes.size()>0) {
                serializer.startTag("", "MODULO2_RESIDENTES");
                for (Residente residente : residentes) {
                    serializer.startTag("", "MODULO2_RESIDENTE");
                    escribirCampoXml(serializer, SQLConstantes.residentes_id, residente.get_id());
                    escribirCampoXml(serializer, SQLConstantes.residentes_idInformante, residente.getId_informante());
                    escribirCampoXml(serializer, SQLConstantes.residentes_idHogar, residente.getId_hogar());
                    escribirCampoXml(serializer, SQLConstantes.residentes_idVivienda, residente.getId_vivienda());
                    escribirCampoXml(serializer, SQLConstantes.residentes_numero, residente.getNumero());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p202, residente.getC2_p202());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p203, residente.getC2_p203());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p204, residente.getC2_p204());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p205_a, residente.getC2_p205_a());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p205_m, residente.getC2_p205_m());
                    escribirCampoXml(serializer, SQLConstantes.residentes_c2_p206, residente.getC2_p206());
                    serializer.endTag("", "MODULO2_RESIDENTE");
                }
                serializer.endTag("", "MODULO2_RESIDENTES");
            }

            if(modulo3s.size()>0) {
                serializer.startTag("", "MODULO3S");
                for (Modulo3 modulo3 : modulo3s) {
                    serializer.startTag("", "MODULO3");
                    escribirCampoXml(serializer, SQLConstantes.modulo3_id, modulo3.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_idInformante, modulo3.get_id());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_idHogar, modulo3.getIdHogar());
                    escribirCampoXml(serializer, SQLConstantes.modulo3_idVivienda, modulo3.getIdVivienda());
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
                    serializer.endTag("", "MODULO3");
                }
                serializer.endTag("", "MODULO3S");
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
