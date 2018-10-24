package com.example.ricindigus.empove2018.fragments.modulo6;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP630 extends FragmentPagina {
    String idVivienda, idHogar, idPersona, idInformante;
    Context context;

    RadioGroup c6_p630_1_RadioGroup, c6_p630_1_med_RadioGroup;
    EditText c6_p630_1_o_EditText;
    Spinner c6_p630_1_frec_Spinner, c6_p630_1_mont_Spinner;
    RadioGroup c6_p630_2_RadioGroup, c6_p630_2_med_RadioGroup;
    EditText c6_p630_2_o_EditText;
    Spinner c6_p630_2_frec_Spinner, c6_p630_2_mont_Spinner;
    LinearLayout m6_p630_linearlayout;

    private int c6_p630_1;
    private int c6_p630_1_med;
    private String c6_p630_1_o;
    private int c6_p630_1_frec;
    private int c6_p630_1_mont;
    private int c6_p630_2;
    private int c6_p630_2_med;
    private String c6_p630_2_o;
    private int c6_p630_2_frec;
    private int c6_p630_2_mont;

    @SuppressLint("ValidFragment")
    public FragmentP630(String idVivienda, String idHogar, String idPersona, String idInformante, Context context) {
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idPersona = idPersona;
        this.idInformante = idInformante;
        this.context = context;
    }

    public FragmentP630() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p630, container, false);

        c6_p630_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_1);
        c6_p630_1_med_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_1_MED);
        c6_p630_1_o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_1_O);
        c6_p630_1_frec_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_1_FREC);
        c6_p630_1_mont_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_1_MONT);

        c6_p630_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_2);
        c6_p630_2_med_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_2_MED);
        c6_p630_2_o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_2_O);
        c6_p630_2_frec_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_2_FREC);
        c6_p630_2_mont_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_2_MONT);

        m6_p630_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p630);

        return rootView;
    }


    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p630_1,c6_p630_1+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1_med,c6_p630_1_med+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1_o,c6_p630_1_o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1_frec,c6_p630_1_frec+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1_mont,c6_p630_1_mont+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2,c6_p630_2+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2_med,c6_p630_2_med+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2_o,c6_p630_2_o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2_frec,c6_p630_2_frec+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2_mont,c6_p630_2_mont+"");

        if(data.existeElemento(getNombreTabla(),idPersona)){
            data.actualizarElemento(getNombreTabla(),contentValues,idPersona);
        }else{
            contentValues.put(SQLConstantes.modulo6_idVivienda,idVivienda+"");
            contentValues.put(SQLConstantes.modulo6_idHogar,idHogar+"");
            contentValues.put(SQLConstantes.modulo6_id,idPersona+"");
            contentValues.put(SQLConstantes.modulo6_idInformante,idInformante+"");
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        c6_p630_1 = c6_p630_1_RadioGroup.indexOfChild(c6_p630_1_RadioGroup.findViewById(c6_p630_1_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_1_med = c6_p630_1_med_RadioGroup.indexOfChild(c6_p630_1_med_RadioGroup.findViewById(c6_p630_1_med_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_1_o = c6_p630_1_o_EditText.getText().toString();
        c6_p630_1_frec = c6_p630_1_frec_Spinner.getSelectedItemPosition();
        c6_p630_1_mont = c6_p630_1_mont_Spinner.getSelectedItemPosition();
        c6_p630_2 = c6_p630_2_RadioGroup.indexOfChild(c6_p630_2_RadioGroup.findViewById(c6_p630_2_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_2_med = c6_p630_2_med_RadioGroup.indexOfChild(c6_p630_2_med_RadioGroup.findViewById(c6_p630_2_med_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_2_o = c6_p630_2_o_EditText.getText().toString();
        c6_p630_2_frec = c6_p630_2_frec_Spinner.getSelectedItemPosition();
        c6_p630_2_mont = c6_p630_2_mont_Spinner.getSelectedItemPosition();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(m6_p630_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p630_1<1){
                mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p630_1==1){
                if(c6_p630_1_med<1){
                    mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR MEDIO DE ENVIO");
                    return false;
                }
                if(c6_p630_1_med==3){
                    if(c6_p630_1_o.trim().length()==0){
                        mostrarMensaje("PREGUNTA 630-A: DEBE ESPECIFICAR OTRO");
                        return false;
                    }
                }
                if(c6_p630_1_frec<1){
                    mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if(c6_p630_1_mont<1){
                    mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR MONTO");
                    return false;
                }
            }
            if(c6_p630_2<1){
                mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p630_2==1){
                if(c6_p630_2_med<1){
                    mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR MEDIO DE ENVIO");
                    return false;
                }
                if(c6_p630_2_med==3){
                    if(c6_p630_2_o.trim().length()==0){
                        mostrarMensaje("PREGUNTA 630-B: DEBE ESPECIFICAR OTRO");
                        return false;
                    }
                }
                if(c6_p630_2_frec<1){
                    mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if(c6_p630_2_mont<1){
                    mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR MONTO");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo6;
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
