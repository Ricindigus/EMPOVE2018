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
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP619P622 extends FragmentPagina {

    RadioGroup c6_p619_RadioGroup,
            c6_p620_1_RadioGroup, c6_p620_2_RadioGroup, c6_p620_3_RadioGroup, c6_p620_4_RadioGroup,
            c6_p620_5_RadioGroup, c6_p620_6_RadioGroup, c6_p620_7_RadioGroup, c6_p620_8_RadioGroup,
            c6_p620_9_RadioGroup;
    EditText c6_p620_o_EditText;
    RadioGroup c6_p621_RadioGroup, c6_p622_RadioGroup;
    LinearLayout m6_p619_linearlayout, m6_p620_linearlayout, m6_p621_linearlayout, m6_p622_linearlayout;

    private int c6_p619;
    private int c6_p620_1;
    private int c6_p620_2;
    private int c6_p620_3;
    private int c6_p620_4;
    private int c6_p620_5;
    private int c6_p620_6;
    private int c6_p620_7;
    private int c6_p620_8;
    private int c6_p620_9;
    private String c6_p620_o;
    private int c6_p621;
    private int c6_p622;


    public FragmentP619P622() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_p619_p622, container, false);

        c6_p619_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_619_radiogroup_C6_P619);

        c6_p620_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_1);
        c6_p620_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_2);
        c6_p620_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_3);
        c6_p620_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_4);
        c6_p620_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_5);
        c6_p620_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_6);
        c6_p620_7_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_7);
        c6_p620_8_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_8);
        c6_p620_9_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_9);
        c6_p620_o_EditText = (EditText) rootView.findViewById(R.id.mod6_620_edittext_C6_P620_O);

        c6_p621_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_621_radiogroup_C6_P621);
        c6_p622_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_622_radiogroup_C6_P622);

        m6_p619_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p619);
        m6_p620_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p620);
        m6_p621_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p621);
        m6_p622_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p622);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c6_p619 = c6_p619_RadioGroup.indexOfChild(c6_p619_RadioGroup.findViewById(c6_p619_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_1 = c6_p620_1_RadioGroup.indexOfChild(c6_p620_1_RadioGroup.findViewById(c6_p620_1_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_2 = c6_p620_2_RadioGroup.indexOfChild(c6_p620_2_RadioGroup.findViewById(c6_p620_2_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_3 = c6_p620_3_RadioGroup.indexOfChild(c6_p620_3_RadioGroup.findViewById(c6_p620_3_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_4 = c6_p620_4_RadioGroup.indexOfChild(c6_p620_4_RadioGroup.findViewById(c6_p620_4_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_5 = c6_p620_5_RadioGroup.indexOfChild(c6_p620_5_RadioGroup.findViewById(c6_p620_5_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_6 = c6_p620_6_RadioGroup.indexOfChild(c6_p620_6_RadioGroup.findViewById(c6_p620_6_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_7 = c6_p620_7_RadioGroup.indexOfChild(c6_p620_7_RadioGroup.findViewById(c6_p620_7_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_8 = c6_p620_8_RadioGroup.indexOfChild(c6_p620_8_RadioGroup.findViewById(c6_p620_8_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_9 = c6_p620_9_RadioGroup.indexOfChild(c6_p620_9_RadioGroup.findViewById(c6_p620_9_RadioGroup.getCheckedRadioButtonId()));
        c6_p620_o = c6_p620_o_EditText.getText().toString();
        c6_p621 = c6_p621_RadioGroup.indexOfChild(c6_p621_RadioGroup.findViewById(c6_p621_RadioGroup.getCheckedRadioButtonId()));
        c6_p622 = c6_p622_RadioGroup.indexOfChild(c6_p622_RadioGroup.findViewById(c6_p622_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        return false;
    }
}
