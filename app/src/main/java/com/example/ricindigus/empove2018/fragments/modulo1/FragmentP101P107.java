package com.example.ricindigus.empove2018.fragments.modulo1;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP101P107 extends FragmentPagina {

    String idHogar;
    String idVivienda;
    Context context;


    RadioGroup c1_p101_RadioGroup, c1_p102_RadioGroup, c1_p103_RadioGroup, c1_p104_RadioGroup;
    EditText c1_p101_o_EditText, c1_p102_o_EditText, c1_p103_o_EditText, c1_p104_o_EditText;
    EditText c1_p105_EditText,c1_p106_EditText,c1_p107_EditText;

    public FragmentP101P107() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP101P107(String idHogar, String idVivienda, Context context) {
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p101_p107, container, false);
        c1_p101_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_101_radiogroup_C1_P101);
        c1_p101_o_EditText = (EditText) rootView.findViewById(R.id.mod1_101_edittext_C1_P101_O);
        c1_p102_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_102_radiogroup_C1_P102);
        c1_p102_o_EditText = (EditText) rootView.findViewById(R.id.mod1_102_edittext_C1_P102_O);
        c1_p103_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_103_radiogroup_C1_P103);
        c1_p103_o_EditText = (EditText) rootView.findViewById(R.id.mod1_103_edittext_C1_P103_O);
        c1_p104_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_104_radiogroup_C1_P104);
        c1_p104_o_EditText = (EditText) rootView.findViewById(R.id.mod1_104_edittext_C1_P104_O);
        c1_p105_EditText = (EditText) rootView.findViewById(R.id.mod1_105_edittext_C1_P105);
        c1_p106_EditText = (EditText) rootView.findViewById(R.id.mod1_106_edittext_C1_P106);
        c1_p107_EditText = (EditText) rootView.findViewById(R.id.mod1_107_edittext_C1_P107);
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
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo1;
    }
}
