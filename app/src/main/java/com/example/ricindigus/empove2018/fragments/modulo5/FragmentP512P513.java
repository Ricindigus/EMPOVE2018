package com.example.ricindigus.empove2018.fragments.modulo5;


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
public class FragmentP512P513 extends FragmentPagina {

    RadioGroup c5_p512_RadioGroup, c5_p513_RadioGroup;
    EditText c5_p512_o_EditText, c5_p513_o_EditText;
    LinearLayout m5_p512_linearlayout, m5_p513_linearlayout;
    private int c5_p512;
    private String c5_p512_o;
    private int c5_p513;
    private String c5_p513_o;

    public FragmentP512P513() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p512_p513, container, false);
        c5_p512_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_512_radiogroup_C5_P512);
        c5_p512_o_EditText = (EditText) rootView.findViewById(R.id.mod5_512_edittext_C5_P512_O);
        c5_p513_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_513_radiogroup_C5_P513);
        c5_p513_o_EditText = (EditText) rootView.findViewById(R.id.mod5_513_edittext_C5_P513_O);

        m5_p512_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p512);
        m5_p513_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p513);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c5_p512 = c5_p512_RadioGroup.indexOfChild(c5_p512_RadioGroup.findViewById(c5_p512_RadioGroup.getCheckedRadioButtonId()));
        c5_p512_o = c5_p512_o_EditText.getText().toString();
        c5_p513 = c5_p513_RadioGroup.indexOfChild(c5_p513_RadioGroup.findViewById(c5_p513_RadioGroup.getCheckedRadioButtonId()));
        c5_p513_o = c5_p513_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        return false;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo5;
    }
}
