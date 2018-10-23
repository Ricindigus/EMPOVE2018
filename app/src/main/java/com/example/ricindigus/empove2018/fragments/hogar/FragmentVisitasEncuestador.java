package com.example.ricindigus.empove2018.fragments.hogar;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVisitasEncuestador extends FragmentPagina {

    String idEncuestado;
    Context context;

    @SuppressLint("ValidFragment")
    public FragmentVisitasEncuestador(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }


    public FragmentVisitasEncuestador() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visitas_encuestador, container, false);
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
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablavisitasencuestador;
    }
}
