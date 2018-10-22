package com.example.ricindigus.empove2018.fragments.modulo8;


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
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP821P823 extends FragmentPagina {

    CheckBox c8_p821_1_Checkbox, c8_p821_2_Checkbox, c8_p821_3_Checkbox , c8_p821_4_Checkbox, c8_p821_5_Checkbox,
            c8_p821_6_Checkbox, c8_p821_7_Checkbox, c8_p821_8_Checkbox;
    RadioGroup c8_p822_RadioGroup;
    CheckBox c8_p823_1_Checkbox, c8_p823_2_Checkbox, c8_p823_3_Checkbox , c8_p823_4_Checkbox, c8_p823_5_Checkbox;
    EditText c8_p823_o_EditText;
    LinearLayout m8_p821_linearlayout, m8_p822_linearlayout, m8_p823_linearlayout;

    private int c8_p821_1;
    private int c8_p821_2;
    private int c8_p821_3;
    private int c8_p821_4;
    private int c8_p821_5;
    private int c8_p821_6;
    private int c8_p821_7;
    private int c8_p821_8;
    private int c8_p822;
    private int c8_p823_1;
    private int c8_p823_2;
    private int c8_p823_3;
    private int c8_p823_4;
    private int c8_p823_5;
    private String c8_p823_o;

    public FragmentP821P823() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p821_p823, container, false);

        c8_p821_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_1);
        c8_p821_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_2);
        c8_p821_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_3);
        c8_p821_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_4);
        c8_p821_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_5);
        c8_p821_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_6);
        c8_p821_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_7);
        c8_p821_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_8);

        c8_p822_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_822_radiogroup_C8_P822);

        c8_p823_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_1);
        c8_p823_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_2);
        c8_p823_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_3);
        c8_p823_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_4);
        c8_p823_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_5);
        c8_p823_o_EditText = (EditText) rootView.findViewById(R.id.mod8_823_edittext_C8_P823_O);

        m8_p821_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p821);
        m8_p822_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p822);
        m8_p823_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p823);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        if(c8_p821_1_Checkbox.isChecked()) c8_p821_1 = 1; else c8_p821_1 = 0;
        if(c8_p821_2_Checkbox.isChecked()) c8_p821_2 = 1; else c8_p821_2 = 0;
        if(c8_p821_3_Checkbox.isChecked()) c8_p821_3 = 1; else c8_p821_3 = 0;
        if(c8_p821_4_Checkbox.isChecked()) c8_p821_4 = 1; else c8_p821_4 = 0;
        if(c8_p821_5_Checkbox.isChecked()) c8_p821_5 = 1; else c8_p821_5 = 0;
        if(c8_p821_6_Checkbox.isChecked()) c8_p821_6 = 1; else c8_p821_6 = 0;
        if(c8_p821_7_Checkbox.isChecked()) c8_p821_7 = 1; else c8_p821_7 = 0;
        if(c8_p821_8_Checkbox.isChecked()) c8_p821_8 = 1; else c8_p821_8 = 0;
        c8_p822 = c8_p822_RadioGroup.indexOfChild(c8_p822_RadioGroup.findViewById(c8_p822_RadioGroup.getCheckedRadioButtonId()));
        if(c8_p823_1_Checkbox.isChecked()) c8_p823_1 = 1; else c8_p823_1 = 0;
        if(c8_p823_2_Checkbox.isChecked()) c8_p823_2 = 1; else c8_p823_2 = 0;
        if(c8_p823_3_Checkbox.isChecked()) c8_p823_3 = 1; else c8_p823_3 = 0;
        if(c8_p823_4_Checkbox.isChecked()) c8_p823_4 = 1; else c8_p823_4 = 0;
        if(c8_p823_5_Checkbox.isChecked()) c8_p823_5 = 1; else c8_p823_5 = 0;
        c8_p823_o = c8_p823_o_EditText.getText().toString();

    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(c8_p821_1==0 && c8_p821_2==0 && c8_p821_3==0 && c8_p821_4==0 && c8_p821_5==0 && c8_p821_6==0
                && c8_p821_7==0 && c8_p821_8==0){
            mostrarMensaje("PREGUNTA 821: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(c8_p822<1){
            mostrarMensaje("PREGUNTA 822: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p823_1==0 && c8_p823_2==0 && c8_p823_3==0 && c8_p823_4==0 && c8_p823_5==0){
            mostrarMensaje("PREGUNTA 823: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(c8_p823_5==1){
            if(c8_p823_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 823 - OPCION 5: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        return false;
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

    @Override
    public String getNombreTabla() {
        return null;
    }
}
