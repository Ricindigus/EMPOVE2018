package com.example.ricindigus.empove2018.fragments.vivienda;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
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
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCaratula extends FragmentPagina {

    String idVivienda;
    Context context;

    TextView nom_dep_TextView, nom_prov_TextView, nom_dist_TextView, nom_ccpp_TextView;
    TextView zona_TextView, manzana_id_TextView, vivienda_TextView;
    Spinner tipvia_Spinner;
    EditText nomvia_EditText, nropta_EditText, block_EditText, interior_EditText, piso_EditText, mza_EditText,
            lote_EditText, km_EditText, telefono_EditText;
//    EditText t_hogar_EditText;

    //variables
    private int tipvia = -1;
    private String nom_dep;
    private String nom_prov;
    private String nom_dist;
    private String nom_ccpp;
    private String zona;
    private String manzana_id;
    private String vivienda;
    private String nomvia = "";
    private String nropta = "";
    private String block = "";
    private String interior = "";
    private String piso = "";
    private String mza = "";
    private String lote = "";
    private String km = "";
    private String telefono = "";
//    private String t_hogar = "";


    @SuppressLint("ValidFragment")
    public FragmentCaratula(String idVivienda, Context context) {
        this.idVivienda = idVivienda;
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
//        t_hogar_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_T_HOGAR);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nomvia_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(40)});
        nropta_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        block_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        interior_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        piso_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        mza_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        lote_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        km_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        telefono_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(10)});
//        t_hogar_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});

        km_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        telefono_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
//        t_hogar_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.caratula_tipvia,tipvia+"");
        contentValues.put(SQLConstantes.caratula_nomvia,nomvia);
        contentValues.put(SQLConstantes.caratula_nropta,nropta);
        contentValues.put(SQLConstantes.caratula_block,block);
        contentValues.put(SQLConstantes.caratula_interior,interior);
        contentValues.put(SQLConstantes.caratula_piso,piso);
        contentValues.put(SQLConstantes.caratula_mza,mza);
        contentValues.put(SQLConstantes.caratula_lote,lote);
        contentValues.put(SQLConstantes.caratula_km,km);
        contentValues.put(SQLConstantes.caratula_telefono,telefono);
        if(data.existeElemento(getNombreTabla(),idVivienda)){
            data.actualizarElemento(getNombreTabla(),contentValues,idVivienda);
        }else{
            contentValues.put(SQLConstantes.caratula_id,idVivienda);
            contentValues.put(SQLConstantes.caratula_nom_dep,nom_dep);
            contentValues.put(SQLConstantes.caratula_nom_prov,nom_prov);
            contentValues.put(SQLConstantes.caratula_nom_dist,nom_dist);
            contentValues.put(SQLConstantes.caratula_nom_ccpp,nom_ccpp);
            contentValues.put(SQLConstantes.caratula_zona,zona);
            contentValues.put(SQLConstantes.caratula_manzana_id,manzana_id);
            contentValues.put(SQLConstantes.caratula_vivienda,vivienda);
            contentValues.put(SQLConstantes.caratula_t_hogar,"0");
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        nom_dep = nom_dep_TextView.getText().toString();
        nom_prov = nom_prov_TextView.getText().toString();
        nom_dist = nom_dist_TextView.getText().toString();
        nom_ccpp = nom_ccpp_TextView.getText().toString();
        zona = zona_TextView.getText().toString();
        manzana_id = manzana_id_TextView.getText().toString();
        vivienda = vivienda_TextView.getText().toString();
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
//        t_hogar = t_hogar_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Caratula caratula = null;
        Data data =  new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(),idVivienda)){
            caratula = data.getCaratula(idVivienda);
            nom_dep_TextView.setText(caratula.getNom_dep());
            nom_prov_TextView.setText(caratula.getNom_prov());
            nom_dist_TextView.setText(caratula.getNom_dist());
            nom_ccpp_TextView.setText(caratula.getNom_ccpp());
            zona_TextView.setText(caratula.getZona());
            manzana_id_TextView.setText(caratula.getManzana_id());
            vivienda_TextView.setText(caratula.getVivienda());

            if(!caratula.getTipvia().equals("") || !caratula.getTipvia().equals("0"))tipvia_Spinner.setSelection(Integer.parseInt(caratula.getTipvia()));
            nomvia_EditText.setText(caratula.getNomvia());
            nropta_EditText.setText(caratula.getNropta());
            block_EditText.setText(caratula.getBlock());
            interior_EditText.setText(caratula.getInterior());
            piso_EditText.setText(caratula.getPiso());
            mza_EditText.setText(caratula.getMza());
            lote_EditText.setText(caratula.getLote());
            km_EditText.setText(caratula.getKm());
            telefono_EditText.setText(caratula.getTelefono());
//            t_hogar_EditText.setText(caratula.getT_hogar());
        }else{
            Marco marco = data.getMarco(idVivienda);
            nom_dep_TextView.setText(marco.getDepartamento());
            nom_prov_TextView.setText(marco.getProvincia());
            nom_dist_TextView.setText(marco.getDistrito());
            nom_ccpp_TextView.setText(marco.getCcpp());

            zona_TextView.setText(marco.getZona());
            manzana_id_TextView.setText(marco.getManzana_id());
            vivienda_TextView.setText(marco.get_id()+"");
        }
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        int sumaValida = 0;
        String mensaje = "";
        if(tipvia == 0){ mostrarMensaje("Debe indicar el tipo de via"); return false; }
        if(nomvia.equals("")){ mostrarMensaje("Debe completar el NOMBRE DE LA VÍA"); return false; }
        if(nropta.equals("")){ mostrarMensaje("Debe completar NÚMERO DE LA PUERTA"); return false; }
        if(block.equals("")){ mostrarMensaje("Debe completar BLOCK"); return false; }
        if(interior.equals("")){ mostrarMensaje("Debe completar INTERIOR"); return false; }
        if(piso.equals("")){ mostrarMensaje("Debe completar el PISO"); return false; }
        if(mza.equals("")){ mostrarMensaje("Debe completar la MANZANA"); return false; }
        if(lote.equals("")){ mostrarMensaje("Debe completar el LOTE"); return false; }
        if(km.equals("")){ mostrarMensaje("Debe completar el KM"); return false; }
        if(telefono.equals("")){ mostrarMensaje("Debe completar el TELÉFONO"); return false; }
//        if(t_hogar.equals("")){ mostrarMensaje("Debe indicar la CANTIDAD DE HOGARES"); return false; }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablacaratula;
    }


    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
