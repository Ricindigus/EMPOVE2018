package com.example.ricindigus.empove2018.fragments.generales;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCaratula extends FragmentPagina {

    String idEncuestado;
    Context context;

    TextView nom_dep_TextView, nom_prov_TextView, nom_dist_TextView, nom_ccpp_TextView;
    TextView zona_TextView, manzana_id_TextView, manzana_a_TextView, aer_ini_TextView, aer_fin_TextView, vivienda_TextView;
    Spinner nombrevia_Spinner;
    EditText tipvia_EditText, nropta_EditText, block_EditText, interio_EditText, piso_EditText, mza_EditText,
            lote_EditText, km_EditText, telefono_EditText;
    EditText t_hogar_EditText;



    @SuppressLint("ValidFragment")
    public FragmentCaratula(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentCaratula() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_caratula, container, false);
//        nom_dep_TextView = (TextView) rootView.findViewById(R.id.gralCaratula_ubicaciongeo_textview_NOM_DEP);
//        nom_prov_TextView = (TextView) rootView.findViewById(R.id.gralCaratula_ubicaciongeo_textview_NOM_PROV);
//        nom_dist_TextView = (TextView) rootView.findViewById(R.id.gralCaratula_ubicaciongeo_textview_NOM_DIST);
//        nom_ccpp_TextView = (TextView) rootView.findViewById(R.id.gralCaratula_ubicaciongeo_textview_NOM_CCPP);
//        zona_TextView = (TextView) rootView.findViewById(R.id.gralCaratula_ubicacionmue_textview_ZONA);
//        manzana_id_TextView = (TextView) rootView.findViewById(R.id.gralCaratula_ubicacionmue_textview_MANZANA_ID);
//        aer_ini_TextView = (TextView) rootView.findViewById(R.id.gralCaratula_ubicacionmue_textview_AER_INI);
//        vivienda_TextView = (TextView) rootView.findViewById(R.id.gralCaratula_ubicacionmue_textview_VIVIENDA);
//        nombrevia_Spinner = (Spinner) rootView.findViewById(R.id.formulario_sp_spinner);
//        tipvia_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_TIPVIA);
//        nropta_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_NROPTA);
//        block_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_BLOCK);
//        interio_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_INTERIO);
//        piso_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_PISO);
//        mza_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_MZA);
//        lote_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_LOTE);
//        km_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_KM);
//        telefono_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicaciondir_textview_TELEFONO);
//        t_hogar_EditText = (EditText) rootView.findViewById(R.id.gralCaratula_ubicacioncant_hogares_textview_T_HOGAR);
        return rootView;
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
        return false;
    }
}
