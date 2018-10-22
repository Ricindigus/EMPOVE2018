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
public class FragmentP401P404 extends FragmentPagina {

    CheckBox c4_p401_1_CheckBox, c4_p401_2_CheckBox, c4_p401_3_CheckBox, c4_p401_4_CheckBox, c4_p401_5_CheckBox ;
    EditText c4_p401_o_EditText;
    RadioGroup c4_p402_RadioGroup;
    CheckBox c4_p403_1_CheckBox, c4_p403_2_CheckBox, c4_p403_3_CheckBox, c4_p403_4_CheckBox, c4_p403_5_CheckBox,
            c4_p403_6_CheckBox, c4_p403_7_CheckBox, c4_p403_8_CheckBox, c4_p403_9_CheckBox, c4_p403_10_CheckBox,
            c4_p403_11_CheckBox, c4_p403_12_CheckBox, c4_p403_13_CheckBox, c4_p403_14_CheckBox;
    EditText c4_p403_o_EditText;
    RadioGroup c4_p404_RadioGroup;
    LinearLayout m4_p401_linearlayout, m4_p402_linearlayout, m4_p403_linearlayout, m4_p404_linearlayout;

    private int c4_p401_1;
    private int c4_p401_2;
    private int c4_p401_3;
    private int c4_p401_4;
    private int c4_p401_5;
    private String c4_p401_o;
    private int c4_p402;
    private int c4_p403_1;
    private int c4_p403_2;
    private int c4_p403_3;
    private int c4_p403_4;
    private int c4_p403_5;
    private int c4_p403_6;
    private int c4_p403_7;
    private int c4_p403_8;
    private int c4_p403_9;
    private int c4_p403_10;
    private int c4_p403_11;
    private int c4_p403_12;
    private int c4_p403_13;
    private int c4_p403_14;
    private String c4_p403_o;
    private int c4_p404;

    public FragmentP401P404() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p401_p404, container, false);

        c4_p401_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_1);
        c4_p401_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_2);
        c4_p401_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_3);
        c4_p401_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_4);
        c4_p401_o_EditText = (EditText) rootView.findViewById(R.id.mod4_401_edtittext_C4_P401_O);
        c4_p401_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_5);

        c4_p402_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_402_radiogroup_C4_P402);

        c4_p403_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_1);
        c4_p403_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_2);
        c4_p403_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_3);
        c4_p403_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_4);
        c4_p403_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_5);
        c4_p403_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_6);
        c4_p403_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_7);
        c4_p403_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_8);
        c4_p403_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_9);
        c4_p403_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_10);
        c4_p403_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_11);
        c4_p403_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_12);
        c4_p403_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_13);
        c4_p403_14_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_14);
        c4_p403_o_EditText = (EditText) rootView.findViewById(R.id.mod4_403_edittext_C4_P403_O);

        c4_p404_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_404_radiogroup_C4_P404);

        m4_p401_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p401);
        m4_p402_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p402);
        m4_p403_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p403);
        m4_p404_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p404);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        if(c4_p401_1_CheckBox.isChecked()) c4_p401_1 = 1; else c4_p401_1 = 0;
        if(c4_p401_2_CheckBox.isChecked()) c4_p401_2 = 1; else c4_p401_2 = 0;
        if(c4_p401_3_CheckBox.isChecked()) c4_p401_3 = 1; else c4_p401_3 = 0;
        if(c4_p401_4_CheckBox.isChecked()) c4_p401_4 = 1; else c4_p401_4 = 0;
        if(c4_p401_5_CheckBox.isChecked()) c4_p401_5 = 1; else c4_p401_5 = 0;
        c4_p401_o = c4_p401_o_EditText.getText().toString();
        c4_p402 = c4_p402_RadioGroup.indexOfChild(c4_p402_RadioGroup.findViewById(c4_p402_RadioGroup.getCheckedRadioButtonId()));
        if(c4_p403_1_CheckBox.isChecked()) c4_p403_1 = 1; else c4_p403_1 = 0;
        if(c4_p403_2_CheckBox.isChecked()) c4_p403_2 = 1; else c4_p403_2 = 0;
        if(c4_p403_3_CheckBox.isChecked()) c4_p403_3 = 1; else c4_p403_3 = 0;
        if(c4_p403_4_CheckBox.isChecked()) c4_p403_4 = 1; else c4_p403_4 = 0;
        if(c4_p403_5_CheckBox.isChecked()) c4_p403_5 = 1; else c4_p403_5 = 0;
        if(c4_p403_6_CheckBox.isChecked()) c4_p403_6 = 1; else c4_p403_6 = 0;
        if(c4_p403_7_CheckBox.isChecked()) c4_p403_7 = 1; else c4_p403_7 = 0;
        if(c4_p403_8_CheckBox.isChecked()) c4_p403_8 = 1; else c4_p403_8 = 0;
        if(c4_p403_9_CheckBox.isChecked()) c4_p403_9 = 1; else c4_p403_9 = 0;
        if(c4_p403_10_CheckBox.isChecked()) c4_p403_10 = 1; else c4_p403_10 = 0;
        if(c4_p403_11_CheckBox.isChecked()) c4_p403_11 = 1; else c4_p403_11 = 0;
        if(c4_p403_12_CheckBox.isChecked()) c4_p403_12 = 1; else c4_p403_12 = 0;
        if(c4_p403_13_CheckBox.isChecked()) c4_p403_13 = 1; else c4_p403_13 = 0;
        if(c4_p403_14_CheckBox.isChecked()) c4_p403_14 = 1; else c4_p403_14 = 0;
        c4_p403_o = c4_p403_o_EditText.getText().toString();
        c4_p404 = c4_p404_RadioGroup.indexOfChild(c4_p404_RadioGroup.findViewById(c4_p404_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(c4_p401_1==0 && c4_p401_2==0 && c4_p401_3==0 && c4_p401_4==0 ){
            mostrarMensaje("PREGUNTA 401: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(c4_p401_4==1){
            if(c4_p401_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 401 - OPCION 4: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if(c4_p402<1){
            mostrarMensaje("PREGUNTA 402: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p403_1==0 && c4_p403_2==0 && c4_p403_3==0 && c4_p403_4==0 && c4_p403_5==0 &&
                c4_p403_6==0 && c4_p403_7==0 && c4_p403_8==0 && c4_p403_9==0 && c4_p403_10==0 &&
                c4_p403_11==0 && c4_p403_12==0 && c4_p403_13==0 && c4_p403_14==0){
            mostrarMensaje("PREGUNTA 403: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(c4_p403_14==1){
            if(c4_p403_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 403 - OPCION 14: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if(c4_p404<1){
            mostrarMensaje("PREGUNTA 404: DEBE SELECCIONAR UNA OPCION");
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
