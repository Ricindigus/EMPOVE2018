package com.example.ricindigus.empove2018.fragments.modulo4;


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
public class FragmentP408P410 extends FragmentPagina {

    CheckBox c4_p408_1_CheckBox, c4_p408_2_CheckBox, c4_p408_3_CheckBox, c4_p408_4_CheckBox, c4_p408_5_CheckBox,
            c4_p408_6_CheckBox, c4_p408_7_CheckBox, c4_p408_8_CheckBox, c4_p408_9_CheckBox, c4_p408_10_CheckBox,
            c4_p408_11_CheckBox, c4_p408_12_CheckBox, c4_p408_13_CheckBox, c4_p408_14_CheckBox;
    EditText c4_p408_o_EditText;
    RadioGroup c4_p409_RadioGroup, c4_p410_RadioGroup;
    LinearLayout m4_p408_linearlayout, m4_p409_linearlayout, m4_p410_linearlayout;

    private int c4_p408_1;
    private int c4_p408_2;
    private int c4_p408_3;
    private int c4_p408_4;
    private int c4_p408_5;
    private int c4_p408_6;
    private int c4_p408_7;
    private int c4_p408_8;
    private int c4_p408_9;
    private int c4_p408_10;
    private int c4_p408_11;
    private int c4_p408_12;
    private int c4_p408_13;
    private int c4_p408_14;
    private String c4_p408_o;
    private int c4_p409;
    private int c4_p410;


    public FragmentP408P410() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p408_p410, container, false);
        c4_p408_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_1);
        c4_p408_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_2);
        c4_p408_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_3);
        c4_p408_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_4);
        c4_p408_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_5);
        c4_p408_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_6);
        c4_p408_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_7);
        c4_p408_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_8);
        c4_p408_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_9);
        c4_p408_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_10);
        c4_p408_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_11);
        c4_p408_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_12);
        c4_p408_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_13);
        c4_p408_14_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_14);
        c4_p408_o_EditText = (EditText) rootView.findViewById(R.id.mod4_408_edittext_C4_P408_O);

        c4_p409_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_409_radiogroup_C4_P409);

        c4_p410_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_410_radiogroup_C4_P410);

        m4_p408_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p408);
        m4_p409_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p409);
        m4_p410_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p410);


        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        if(c4_p408_1_CheckBox.isChecked()) c4_p408_1 = 1; else c4_p408_1 = 0;
        if(c4_p408_2_CheckBox.isChecked()) c4_p408_2 = 1; else c4_p408_2 = 0;
        if(c4_p408_3_CheckBox.isChecked()) c4_p408_3 = 1; else c4_p408_3 = 0;
        if(c4_p408_4_CheckBox.isChecked()) c4_p408_4 = 1; else c4_p408_4 = 0;
        if(c4_p408_5_CheckBox.isChecked()) c4_p408_5 = 1; else c4_p408_5 = 0;
        if(c4_p408_6_CheckBox.isChecked()) c4_p408_6 = 1; else c4_p408_6 = 0;
        if(c4_p408_7_CheckBox.isChecked()) c4_p408_7 = 1; else c4_p408_7 = 0;
        if(c4_p408_8_CheckBox.isChecked()) c4_p408_8 = 1; else c4_p408_8 = 0;
        if(c4_p408_9_CheckBox.isChecked()) c4_p408_9 = 1; else c4_p408_9 = 0;
        if(c4_p408_10_CheckBox.isChecked()) c4_p408_10 = 1; else c4_p408_10 = 0;
        if(c4_p408_11_CheckBox.isChecked()) c4_p408_11 = 1; else c4_p408_11 = 0;
        if(c4_p408_12_CheckBox.isChecked()) c4_p408_12 = 1; else c4_p408_12 = 0;
        if(c4_p408_13_CheckBox.isChecked()) c4_p408_13 = 1; else c4_p408_13 = 0;
        if(c4_p408_14_CheckBox.isChecked()) c4_p408_14 = 1; else c4_p408_14 = 0;
        c4_p408_o = c4_p408_o_EditText.getText().toString();
        c4_p409 = c4_p409_RadioGroup.indexOfChild(c4_p409_RadioGroup.findViewById(c4_p409_RadioGroup.getCheckedRadioButtonId()));
        c4_p410 = c4_p410_RadioGroup.indexOfChild(c4_p410_RadioGroup.findViewById(c4_p410_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(m4_p408_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p408_1==0 && c4_p408_2==0 && c4_p408_3==0 && c4_p408_4==0 && c4_p408_5==0 &&
                    c4_p408_6==0 && c4_p408_7==0 && c4_p408_8==0 && c4_p408_9==0 && c4_p408_10==0 &&
                    c4_p408_11==0 && c4_p408_12==0 && c4_p408_13==0 && c4_p408_14==0){
                mostrarMensaje("PREGUNTA 408: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p408_13==1){
                if(c4_p408_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 408 - OPCION 13: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c4_p409<1 && m4_p409_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 409: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p410<1 && m4_p410_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 410: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo4;
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
