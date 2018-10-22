package com.example.ricindigus.empove2018.fragments.modulo6;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP605P608 extends FragmentPagina {

    EditText c6_p605_EditText, c6_p606_EditText, c6_p607_EditText;
    RadioGroup c6_p608_RadioGroup;
    EditText c6_p608_o_EditText;
    LinearLayout m6_p605_linearlayout, m6_p606_linearlayout, m6_p607_linearlayout, m6_p608_linearlayout;

    private String c6_p605;
    private String c6_p606;
    private String c6_p607;
    private int c6_p608;
    private String c6_p608_o;

    public FragmentP605P608() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p605_p608, container, false);

        c6_p605_EditText = (EditText) rootView.findViewById(R.id.mod6_605_edittext_C6_P605);
        c6_p606_EditText = (EditText) rootView.findViewById(R.id.mod6_606_edittext_C6_P606);
        c6_p607_EditText = (EditText) rootView.findViewById(R.id.mod6_606_edittext_C6_P606);
        c6_p608_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_8);
        c6_p608_o_EditText = (EditText) rootView.findViewById(R.id.mod6_608_edittext_C6_P608_O);

        m6_p605_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p605);
        m6_p606_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p606);
        m6_p607_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p607);
        m6_p608_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p608);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c6_p605 = c6_p605_EditText.getText().toString();
        c6_p606 = c6_p606_EditText.getText().toString();
        c6_p607 = c6_p607_EditText.getText().toString();
        c6_p608 = c6_p608_RadioGroup.indexOfChild(c6_p608_RadioGroup.findViewById(c6_p608_RadioGroup.getCheckedRadioButtonId()));
        c6_p608_o = c6_p608_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(c6_p605.trim().length()==0){
            mostrarMensaje("PREGUNTA 605: DEBE ESPECIFICAR");
            return false;
        }
        if(c6_p606.trim().length()==0){
            mostrarMensaje("PREGUNTA 606: DEBE ESPECIFICAR");
            return false;
        }
        if(c6_p607.trim().length()==0){
            mostrarMensaje("PREGUNTA 607: DEBE ESPECIFICAR");
            return false;
        }
        if(c6_p608<1){
            mostrarMensaje("PREGUNTA 608: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c6_p608==7){
            if(c6_p608_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 608 - OPCION 7: DEBE ESPECIFICAR OTRO");
                return false;
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
