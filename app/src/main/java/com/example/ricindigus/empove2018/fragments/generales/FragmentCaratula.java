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
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Caratula;
import com.example.ricindigus.empove2018.modelo.pojos.Marco;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCaratula extends FragmentPagina {

    String idEncuestado;
    Context context;

    TextView nom_dep_TextView, nom_prov_TextView, nom_dist_TextView, nom_ccpp_TextView;
    TextView zona_TextView, manzana_id_TextView, aer_TextView, vivienda_TextView;
    Spinner tipvia_Spinner;
    EditText nomvia_EditText, nropta_EditText, block_EditText, interior_EditText, piso_EditText, mza_EditText,
            lote_EditText, km_EditText, telefono_EditText;
    EditText t_hogar_EditText;

    //variables
    private int tipvia;
    private String nomvia;
    private String nropta;
    private String block;
    private String interior;
    private String piso;
    private String mza;
    private String lote;
    private String km;
    private String telefono;
    private String t_hogar;


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
        nom_dep_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_NOM_DEP);
        nom_prov_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_NOM_PROV);
        nom_dist_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_NOM_DIST);
        nom_ccpp_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_NOM_CCPP);
        zona_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_ZONA);
        manzana_id_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_MANZANA_ID);
        aer_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_AER);
        vivienda_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_VIVIENDA);
        tipvia_Spinner = (Spinner) rootView.findViewById(R.id.caratula_spinner_TIPVIA);
        nomvia_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_NOMVIA);
        nropta_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_NROPTA);
        block_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_BLOCK);
        interior_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_INTERIO);
        piso_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_PISO);
        mza_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_MZA);
        lote_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_LOTE);
        km_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_KM);
        telefono_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_TELEFONO);
        t_hogar_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_T_HOGAR);
        return rootView;
    }


    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        tipvia = tipvia_Spinner.getSelectedItemPosition();
        nomvia = nomvia_EditText.getText().toString();
        nropta = nropta_EditText.getText().toString();
        block = block_EditText.getText().toString();
        interior = interior_EditText.getText().toString();
        piso = piso_EditText.getText().toString();
        mza = mza_EditText.getText().toString();
        lote = lote_EditText.getText().toString();
        km = km_EditText.getText().toString();
        telefono = telefono_EditText.getText().toString();
        t_hogar = t_hogar_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Caratula caratula = null;
        Data data =  new Data(context);
        data.open();
        caratula = data.getCaratula(idEncuestado);
        if(caratula != null){
            nom_dep_TextView.setText(caratula.getNom_dep());
            nom_prov_TextView.setText(caratula.getNom_prov());
            nom_dist_TextView.setText(caratula.getNom_dist());
            nom_ccpp_TextView.setText(caratula.getNom_ccpp());

            zona_TextView.setText(caratula.getZona());
            manzana_id_TextView.setText(caratula.getManzana_id());
            aer_TextView.setText(caratula.getAer());
            vivienda_TextView.setText(caratula.getVivienda());

            tipvia_Spinner.setSelection(Integer.parseInt(caratula.getTipvia()));
            nomvia_EditText.setText(caratula.getNomvia());
            nropta_EditText.setText(caratula.getNropta());
            block_EditText.setText(caratula.getBlock());
            interior_EditText.setText(caratula.getInterior());
            piso_EditText.setText(caratula.getPiso());
            mza_EditText.setText(caratula.getMza());
            lote_EditText.setText(caratula.getLote());
            km_EditText.setText(caratula.getKm());
            telefono_EditText.setText(caratula.getTelefono());
        }else{
            Marco marco = data.getMarco(idEncuestado);
            caratula = copiarDatosMarcoACaratula(marco);
            data.insertarModulo(getNombreTabla(),caratula.toValues());
        }

        data.close();
    }

    @Override
    public boolean validarDatos() {
        boolean valido = true;

        return valido;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablacaratula;
    }


    public Caratula copiarDatosMarcoACaratula(Marco marco){
        Caratula caratula = new Caratula();
        caratula.setNom_dep(marco.getDepartamento());
        caratula.setNom_prov(marco.getProvincia());
        caratula.setNom_dist(marco.getDistrito());
        caratula.setNom_ccpp(marco.getCcpp());

        caratula.setZona(marco.getZona());
        caratula.setManzana_id(marco.getManzana_id() + " " + marco.getManzana_a());
        caratula.setAer(marco.getAerini() + " " + marco.getAerfin());
        caratula.setVivienda(marco.get_id()+"");
        return caratula;
    }
}
