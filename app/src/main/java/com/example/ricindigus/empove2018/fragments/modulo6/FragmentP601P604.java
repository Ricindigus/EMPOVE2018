package com.example.ricindigus.empove2018.fragments.modulo6;


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
public class FragmentP601P604 extends FragmentPagina {

    RadioGroup c6_p601_RadioGroup, c6_p602_RadioGroup, c6_p603_RadioGroup,
            c6_p604_1_RadioGroup, c6_p604_2_RadioGroup, c6_p604_3_RadioGroup, c6_p604_4_RadioGroup,
            c6_p604_5_RadioGroup, c6_p604_6_RadioGroup, c6_p604_7_RadioGroup, c6_p604_8_RadioGroup,
            c6_p604_9_RadioGroup, c6_p604_10_RadioGroup, c6_p604_11_RadioGroup;
    EditText c6_p604_o_EditText;
    LinearLayout m6_p601_linearlayout, m6_p602_linearlayout, m6_p603_linearlayout, m6_p604_linearlayout;

    private int c6_p601;
    private int c6_p602;
    private int c6_p603;
    private int c6_p604_1;
    private int c6_p604_2;
    private int c6_p604_3;
    private int c6_p604_4;
    private int c6_p604_5;
    private int c6_p604_6;
    private int c6_p604_7;
    private int c6_p604_8;
    private int c6_p604_9;
    private int c6_p604_10;
    private int c6_p604_11;
    private String c6_p604_o;

    public FragmentP601P604() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p601_p604, container, false);
        c6_p601_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_601_radiogroup_C6_P601);
        c6_p602_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_602_radiogroup_C6_P602);
        c6_p603_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_603_radiogroup_C6_P603);

        c6_p604_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_1);
        c6_p604_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_2);
        c6_p604_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_3);
        c6_p604_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_4);
        c6_p604_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_5);
        c6_p604_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_6);
        c6_p604_7_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_7);
        c6_p604_8_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_8);
        c6_p604_9_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_9);
        c6_p604_10_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_10);
        c6_p604_11_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_11);
        c6_p604_o_EditText = (EditText) rootView.findViewById(R.id.mod6_604_edittext_C6_P604_O);

        m6_p601_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p601);
        m6_p602_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p602);
        m6_p603_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p603);
        m6_p604_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p604);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c6_p601 = c6_p601_RadioGroup.indexOfChild(c6_p601_RadioGroup.findViewById(c6_p601_RadioGroup.getCheckedRadioButtonId()));
        c6_p602 = c6_p602_RadioGroup.indexOfChild(c6_p602_RadioGroup.findViewById(c6_p602_RadioGroup.getCheckedRadioButtonId()));
        c6_p603 = c6_p603_RadioGroup.indexOfChild(c6_p603_RadioGroup.findViewById(c6_p603_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_1 = c6_p604_1_RadioGroup.indexOfChild(c6_p604_1_RadioGroup.findViewById(c6_p604_1_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_2 = c6_p604_2_RadioGroup.indexOfChild(c6_p604_2_RadioGroup.findViewById(c6_p604_2_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_3 = c6_p604_3_RadioGroup.indexOfChild(c6_p604_3_RadioGroup.findViewById(c6_p604_3_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_4 = c6_p604_4_RadioGroup.indexOfChild(c6_p604_4_RadioGroup.findViewById(c6_p604_4_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_5 = c6_p604_5_RadioGroup.indexOfChild(c6_p604_5_RadioGroup.findViewById(c6_p604_5_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_6 = c6_p604_6_RadioGroup.indexOfChild(c6_p604_6_RadioGroup.findViewById(c6_p604_6_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_7 = c6_p604_7_RadioGroup.indexOfChild(c6_p604_7_RadioGroup.findViewById(c6_p604_7_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_8 = c6_p604_8_RadioGroup.indexOfChild(c6_p604_8_RadioGroup.findViewById(c6_p604_8_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_9 = c6_p604_9_RadioGroup.indexOfChild(c6_p604_9_RadioGroup.findViewById(c6_p604_9_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_10 = c6_p604_10_RadioGroup.indexOfChild(c6_p604_10_RadioGroup.findViewById(c6_p604_10_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_11 = c6_p604_11_RadioGroup.indexOfChild(c6_p604_11_RadioGroup.findViewById(c6_p604_11_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_o = c6_p604_o_EditText.getText().toString();
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
        return SQLConstantes.tablamodulo6;
    }
}
