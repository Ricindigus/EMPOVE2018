package com.example.ricindigus.empove2018.fragments.modulo3;


import android.annotation.SuppressLint;
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
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.activities.agregacion.AgregarRutaActivity;
import com.example.ricindigus.empove2018.adapters.M3Pregunta309Adapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta309;
import com.example.ricindigus.empove2018.util.FragmentPagina;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP309 extends FragmentPagina {
    String idEncuestado;
    Context contexto;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    M3Pregunta309Adapter m3Pregunta309Adapter;
    ArrayList<M3Pregunta309> m3Pregunta309s;

    public FragmentP309() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP309(String idEncuestado, Context contexto) {
        this.idEncuestado = idEncuestado;
        this.contexto = contexto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_p309, container, false);
        fab = (FloatingActionButton) rootView.findViewById(R.id.rutas_fab);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rutas_recyclerview);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(contexto);
        inicializarDatos();
        setearAdapter();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(contexto, AgregarRutaActivity.class);
                intent.putExtra("idEncuestado",idEncuestado);
                startActivity(intent);
            }
        });
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {

    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
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
        m3Pregunta309s = data.getM3Pregunta309(idEncuestado);
        data.close();
    }

    public void setearAdapter(){
        inicializarDatos();
        m3Pregunta309Adapter =  new M3Pregunta309Adapter(m3Pregunta309s);
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
}
