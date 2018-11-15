package com.example.ricindigus.empove2018.fragments.modulo3;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.activities.EncuestaActivity;
import com.example.ricindigus.empove2018.activities.agregacion.AgregarResidenteActivity;
import com.example.ricindigus.empove2018.activities.agregacion.AgregarRutaActivity;
import com.example.ricindigus.empove2018.adapters.M3Pregunta309Adapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta309;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.util.FragmentPagina;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP309 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    String idVivienda;
    String idHogar;
    Context contexto;
    LinearLayout layoutp309;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    M3Pregunta309Adapter m3Pregunta309Adapter;
    ArrayList<M3Pregunta309> m3Pregunta309s;
    Spinner informanteSpinner;

    public FragmentP309() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP309(String idEncuestado, String idVivienda,Context contexto) {
        this.idEncuestado = idEncuestado;
        this.idVivienda = idVivienda;
        this.contexto = contexto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_p309, container, false);
        fab = (FloatingActionButton) rootView.findViewById(R.id.rutas_fab);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rutas_recyclerview);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);
        layoutp309 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p309);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(contexto);
        recyclerView.setLayoutManager(layoutManager);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(contexto, AgregarRutaActivity.class);
                intent.putExtra("idEncuestado",idEncuestado);
                intent.putExtra("idVivienda",idVivienda);
                intent.putExtra("numero",(m3Pregunta309s.size()+1)+"");
                intent.putExtra("idRuta",idEncuestado + "_" +(m3Pregunta309s.size()+1));
                startActivity(intent);
            }
        });
        llenarVista();
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(contexto);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_idInformante,idInformante);
        data.actualizarElemento(SQLConstantes.tablamodulo3,contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(contexto);
        data.open();
        if (data.existeElemento(SQLConstantes.tablamodulo3,idEncuestado)){
            Modulo3 modulo3 = data.getModulo3(idEncuestado);
            idHogar = modulo3.getIdHogar();
            idInformante = modulo3.getIdInformante();
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(idHogar);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            informanteSpinner.setSelection(Integer.parseInt(idInformante));
        }
        data.close();

    }

    @Override
    public void llenarVista() {
        Data data = new Data(contexto);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p309,idEncuestado)) layoutp309.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        if(informanteSpinner.getSelectedItemPosition() == 0) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if(m3Pregunta309s.size() == 0){ mostrarMensaje("DEBE AGREGAR RUTAS");return false;}
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablam3p309rutas;
    }

    public void inicializarDatos(){
        m3Pregunta309s = new ArrayList<>();
        Data data =  new Data(contexto);
        data.open();
        m3Pregunta309s = data.getAllM3Pregunta309(idEncuestado);
        data.close();
    }

    public void setearAdapter(){
        m3Pregunta309Adapter =  new M3Pregunta309Adapter(m3Pregunta309s, contexto, new M3Pregunta309Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                final PopupMenu popupMenu = new PopupMenu(contexto,view);
                if (m3Pregunta309s.size() == position + 1){
                    popupMenu.getMenuInflater().inflate(R.menu.menu_rutas_1,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId()){
//                                case R.id.opcion_editar:
//                                    Intent intent =  new Intent(contexto, AgregarRutaActivity.class);
//                                    intent.putExtra("idEncuestado",idEncuestado);
//                                    intent.putExtra("idVivienda",idVivienda);
//                                    intent.putExtra("numero",m3Pregunta309s.get(position).getNumero());
//                                    intent.putExtra("idRuta",m3Pregunta309s.get(position).get_id());
//                                    startActivity(intent);
//                                    break;
                                case R.id.opcion_eliminar:
                                    eliminarRuta(position);
                                    break;
                            }
                            return true;
                        }
                    });
                    popupMenu.show();
                }
//                else{
//                    popupMenu.getMenuInflater().inflate(R.menu.menu_rutas_2,popupMenu.getMenu());
//                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem item) {
//                            switch(item.getItemId()){
//                                case R.id.opcion_editar:
//                                    Intent intent =  new Intent(contexto, AgregarRutaActivity.class);
//                                    intent.putExtra("idEncuestado",idEncuestado);
//                                    intent.putExtra("idVivienda",idVivienda);
//                                    intent.putExtra("numero",m3Pregunta309s.get(position).getNumero());
//                                    intent.putExtra("idRuta",m3Pregunta309s.get(position).get_id());
//                                    startActivity(intent);
//                                    break;
//                            }
//
//                            return true;
//                        }
//                    });
//                    popupMenu.show();
//                }
            }
        });
        recyclerView.setAdapter(m3Pregunta309Adapter);
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void eliminarRuta(int position){
        Data data = new Data(contexto);
        data.open();
        data.eliminarDato(SQLConstantes.tablam3p309rutas,m3Pregunta309s.get(position).get_id());
        inicializarDatos();
        setearAdapter();
        data.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        inicializarDatos();
        setearAdapter();
    }
}
