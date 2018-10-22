package com.example.ricindigus.empove2018.fragments.modulo5;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP501P505 extends FragmentPagina {

    RadioGroup c5_p501_RadioGroup, c5_p503_RadioGroup, c5_p504_RadioGroup, c5_p505_RadioGroup;
    EditText c5_p502_c_EditText;
    CheckBox c5_p502_CheckBox;
    LinearLayout m5_p501_linearlayout, m5_p502_linearlayout, m5_p503_linearlayout, m5_p504_linearlayout,
            m5_p505_linearlayout;

    private int c5_p501;
    private String c5_p502_c;
    private int c5_p502;
    private int c5_p503;
    private int c5_p504;
    private int c5_p505;

    public FragmentP501P505() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p501_p505, container, false);

        c5_p501_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_501_radiogroup_C5_P501);
        c5_p502_c_EditText = (EditText) rootView.findViewById(R.id.mod5_502_edittext_C5_P502_C);
        c5_p502_CheckBox = (CheckBox) rootView.findViewById(R.id.mod5_502_checkbox_C5_P502);
        c5_p503_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_503_radiogroup_C5_P503);
        c5_p504_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_504_radiogroup_C5_P504);
        c5_p505_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_505_radiogroup_C5_P505);

        m5_p501_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p501);
        m5_p502_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p502);
        m5_p503_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p503);
        m5_p504_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p504);
        m5_p505_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p505);

        return rootView;


    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c5_p501 = c5_p501_RadioGroup.indexOfChild(c5_p501_RadioGroup.findViewById(c5_p501_RadioGroup.getCheckedRadioButtonId()));
        c5_p502_c = c5_p502_c_EditText.getText().toString();
        if(c5_p502_CheckBox.isChecked()) c5_p502 = 1; else c5_p502 = 0;
        c5_p503 = c5_p503_RadioGroup.indexOfChild(c5_p503_RadioGroup.findViewById(c5_p503_RadioGroup.getCheckedRadioButtonId()));
        c5_p504 = c5_p504_RadioGroup.indexOfChild(c5_p504_RadioGroup.findViewById(c5_p504_RadioGroup.getCheckedRadioButtonId()));
        c5_p505 = c5_p505_RadioGroup.indexOfChild(c5_p505_RadioGroup.findViewById(c5_p505_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(c5_p501<1 && m5_p501_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 501: DEBE SELECCIONAR UNA OPCION");
            //c5_p501_RadioGroup.requestFocus();
            return false;
        }
        if(c5_p502==0 && m5_p502_linearlayout.getVisibility()==View.VISIBLE){
            if(c5_p502_c.trim().length()==0){
                mostrarMensaje("PREGUNTA 502: DEBE SELECCIONAR O ESPECIFICAR");
                return false;
            }
        }
        if(c5_p503<1 && m5_p503_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 503: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c5_p504<1 && m5_p504_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 504: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c5_p505<1 && m5_p505_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 505: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo5;
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
