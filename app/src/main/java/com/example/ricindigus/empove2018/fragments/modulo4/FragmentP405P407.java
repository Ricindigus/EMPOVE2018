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

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP405P407 extends FragmentPagina {

    CheckBox c4_p405_1_CheckBox, c4_p405_2_CheckBox, c4_p405_3_CheckBox, c4_p405_4_CheckBox, c4_p405_5_CheckBox,
            c4_p405_6_CheckBox, c4_p405_7_CheckBox;
    CheckBox c4_p406_1_CheckBox, c4_p406_2_CheckBox, c4_p406_3_CheckBox, c4_p406_4_CheckBox, c4_p406_5_CheckBox,
            c4_p406_6_CheckBox, c4_p406_7_CheckBox, c4_p406_8_CheckBox;
    EditText c4_p406_o_EditText;
    CheckBox c4_p407_1_CheckBox, c4_p407_2_CheckBox, c4_p407_3_CheckBox, c4_p407_4_CheckBox, c4_p407_5_CheckBox,
            c4_p407_6_CheckBox, c4_p407_7_CheckBox, c4_p407_8_CheckBox, c4_p407_9_CheckBox, c4_p407_10_CheckBox,
            c4_p407_11_CheckBox, c4_p407_12_CheckBox, c4_p407_13_CheckBox;
    EditText c4_p407_o_EditText;
    LinearLayout m4_p405_linearlayout, m4_p406_linearlayout, m4_p407_linearlayout;

    private int c4_p405_1;
    private int c4_p405_2;
    private int c4_p405_3;
    private int c4_p405_4;
    private int c4_p405_5;
    private int c4_p405_6;
    private int c4_p405_7;
    private int c4_p406_1;
    private int c4_p406_2;
    private int c4_p406_3;
    private int c4_p406_4;
    private int c4_p406_5;
    private int c4_p406_6;
    private int c4_p406_7;
    private int c4_p406_8;
    private String c4_p406_o;
    private int c4_p407_1;
    private int c4_p407_2;
    private int c4_p407_3;
    private int c4_p407_4;
    private int c4_p407_5;
    private int c4_p407_6;
    private int c4_p407_7;
    private int c4_p407_8;
    private int c4_p407_9;
    private int c4_p407_10;
    private int c4_p407_11;
    private int c4_p407_12;
    private int c4_p407_13;
    private String c4_p407_o;


    public FragmentP405P407() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p405_p407, container, false);
        c4_p405_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_1);
        c4_p405_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_2);
        c4_p405_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_3);
        c4_p405_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_4);
        c4_p405_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_5);
        c4_p405_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_6);
        c4_p405_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_7);

        c4_p406_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_1);
        c4_p406_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_2);
        c4_p406_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_3);
        c4_p406_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_4);
        c4_p406_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_5);
        c4_p406_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_6);
        c4_p406_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_7);
        c4_p406_o_EditText = (EditText) rootView.findViewById(R.id.mod4_406_edittext_C4_P406_O);
        c4_p406_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_ck8);

        c4_p407_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_checkbox_C4_P407_1);
        c4_p407_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_2);
        c4_p407_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_3);
        c4_p407_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_4);
        c4_p407_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_5);
        c4_p407_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_6);
        c4_p407_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_7);
        c4_p407_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_8);
        c4_p407_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_9);
        c4_p407_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_10);
        c4_p407_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_11);
        c4_p407_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_12);
        c4_p407_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_13);
        c4_p407_o_EditText = (EditText) rootView.findViewById(R.id.mod4_407_edittext_C4_P407_O);

        m4_p405_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p405);
        m4_p406_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p406);
        m4_p407_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p407);

        return rootView;

    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        if(c4_p405_1_CheckBox.isChecked()) c4_p405_1 = 1; else c4_p405_1 = 0;
        if(c4_p405_2_CheckBox.isChecked()) c4_p405_2 = 1; else c4_p405_2 = 0;
        if(c4_p405_3_CheckBox.isChecked()) c4_p405_3 = 1; else c4_p405_3 = 0;
        if(c4_p405_4_CheckBox.isChecked()) c4_p405_4 = 1; else c4_p405_4 = 0;
        if(c4_p405_5_CheckBox.isChecked()) c4_p405_5 = 1; else c4_p405_5 = 0;
        if(c4_p405_6_CheckBox.isChecked()) c4_p405_6 = 1; else c4_p405_6 = 0;
        if(c4_p405_7_CheckBox.isChecked()) c4_p405_7 = 1; else c4_p405_7 = 0;
        if(c4_p406_1_CheckBox.isChecked()) c4_p406_1 = 1; else c4_p406_1 = 0;
        if(c4_p406_2_CheckBox.isChecked()) c4_p406_2 = 1; else c4_p406_2 = 0;
        if(c4_p406_3_CheckBox.isChecked()) c4_p406_3 = 1; else c4_p406_3 = 0;
        if(c4_p406_4_CheckBox.isChecked()) c4_p406_4 = 1; else c4_p406_4 = 0;
        if(c4_p406_5_CheckBox.isChecked()) c4_p406_5 = 1; else c4_p406_5 = 0;
        if(c4_p406_6_CheckBox.isChecked()) c4_p406_6 = 1; else c4_p406_6 = 0;
        if(c4_p406_7_CheckBox.isChecked()) c4_p406_7 = 1; else c4_p406_7 = 0;
        if(c4_p406_8_CheckBox.isChecked()) c4_p406_8 = 1; else c4_p406_8 = 0;
        c4_p406_o = c4_p406_o_EditText.getText().toString();
        if(c4_p407_1_CheckBox.isChecked()) c4_p407_1 = 1; else c4_p407_1 = 0;
        if(c4_p407_2_CheckBox.isChecked()) c4_p407_2 = 1; else c4_p407_2 = 0;
        if(c4_p407_3_CheckBox.isChecked()) c4_p407_3 = 1; else c4_p407_3 = 0;
        if(c4_p407_4_CheckBox.isChecked()) c4_p407_4 = 1; else c4_p407_4 = 0;
        if(c4_p407_5_CheckBox.isChecked()) c4_p407_5 = 1; else c4_p407_5 = 0;
        if(c4_p407_6_CheckBox.isChecked()) c4_p407_6 = 1; else c4_p407_6 = 0;
        if(c4_p407_7_CheckBox.isChecked()) c4_p407_7 = 1; else c4_p407_7 = 0;
        if(c4_p407_8_CheckBox.isChecked()) c4_p407_8 = 1; else c4_p407_8 = 0;
        if(c4_p407_9_CheckBox.isChecked()) c4_p407_9 = 1; else c4_p407_9 = 0;
        if(c4_p407_10_CheckBox.isChecked()) c4_p407_10 = 1; else c4_p407_10 = 0;
        if(c4_p407_11_CheckBox.isChecked()) c4_p407_11 = 1; else c4_p407_11 = 0;
        if(c4_p407_12_CheckBox.isChecked()) c4_p407_12 = 1; else c4_p407_12 = 0;
        if(c4_p407_13_CheckBox.isChecked()) c4_p407_13 = 1; else c4_p407_13 = 0;
        c4_p407_o = c4_p407_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(c4_p405_1==0 && c4_p405_2==0 && c4_p405_3==0 && c4_p405_4==0 && c4_p405_5==0 &&
                c4_p405_6==0 && c4_p405_7==0 && m4_p405_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 405: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(m4_p406_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p406_1==0 && c4_p406_2==0 && c4_p406_3==0 && c4_p406_4==0 && c4_p406_5==0 &&
                    c4_p406_6==0 && c4_p406_7==0 && c4_p406_8==0){
                mostrarMensaje("PREGUNTA 406: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p406_7==1){
                if(c4_p406_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 406 - OPCION 7: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(m4_p407_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p407_1==0 && c4_p407_2==0 && c4_p407_3==0 && c4_p407_4==0 && c4_p407_5==0 &&
                    c4_p407_6==0 && c4_p407_7==0 && c4_p407_8==0 && c4_p407_9==0 && c4_p407_10==0 &&
                    c4_p407_11==0 && c4_p407_12==0 && c4_p407_13==0){
                mostrarMensaje("PREGUNTA 407: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p407_13==1){
                if(c4_p407_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 407 - OPCION 13: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
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
