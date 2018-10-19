package com.example.ricindigus.empove2018.fragments.modulo4;


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
public class FragmentP411P416 extends FragmentPagina {

    RadioGroup c4_p411_RadioGroup, c4_p412_RadioGroup, c4_p413_RadioGroup, c4_p414_RadioGroup;
    CheckBox c4_p415_1_CheckBox, c4_p415_2_CheckBox, c4_p415_3_CheckBox, c4_p415_4_CheckBox, c4_p415_5_CheckBox,
            c4_p415_6_CheckBox, c4_p415_7_CheckBox, c4_p415_8_CheckBox, c4_p415_9_CheckBox;
    EditText c4_p415_o_EditText;
    RadioGroup c4_p416_1_RadioGroup, c4_p416_2_RadioGroup, c4_p416_3_RadioGroup, c4_p416_4_RadioGroup,
            c4_p416_5_RadioGroup, c4_p416_6_RadioGroup;
    LinearLayout m4_p411_linearlayout, m4_p412_linearlayout, m4_p413_linearlayout, m4_p414_linearlayout,
            m4_p415_linearlayout, m4_p416_linearlayout;

    private int c4_p411;
    private int c4_p412;
    private int c4_p413;
    private int c4_p414;
    private int c4_p415_1;
    private int c4_p415_2;
    private int c4_p415_3;
    private int c4_p415_4;
    private int c4_p415_5;
    private int c4_p415_6;
    private int c4_p415_7;
    private int c4_p415_8;
    private String c4_p415_o;
    private int c4_p416_1;
    private int c4_p416_2;
    private int c4_p416_3;
    private int c4_p416_4;
    private int c4_p416_5;
    private int c4_p416_6;


    public FragmentP411P416() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p411_p416, container, false);
        c4_p411_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_411_radiogroup_C4_P411);
        c4_p412_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_412_radiogroup_C4_P412);
        c4_p413_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_413_radiogroup_C4_P413);
        c4_p414_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_414_radiogroup_C4_P414);
        c4_p415_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_1);
        c4_p415_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_2);
        c4_p415_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_3);
        c4_p415_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_4);
        c4_p415_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_5);
        c4_p415_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_6);
        c4_p415_o_EditText = (EditText) rootView.findViewById(R.id.mod4_415_edittext_C4_P415_O);
        c4_p415_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_7);
        c4_p415_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_8);
        c4_p415_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_9);
        c4_p416_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_1);
        c4_p416_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_2);
        c4_p416_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_3);
        c4_p416_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_4);
        c4_p416_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_5);
        c4_p416_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_6);

        m4_p411_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p411);
        m4_p412_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p412);
        m4_p413_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p413);
        m4_p414_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p414);
        m4_p415_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p415);
        m4_p416_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p416);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c4_p411 = c4_p411_RadioGroup.indexOfChild(c4_p411_RadioGroup.findViewById(c4_p411_RadioGroup.getCheckedRadioButtonId()));
        c4_p412 = c4_p412_RadioGroup.indexOfChild(c4_p412_RadioGroup.findViewById(c4_p412_RadioGroup.getCheckedRadioButtonId()));
        c4_p413 = c4_p413_RadioGroup.indexOfChild(c4_p413_RadioGroup.findViewById(c4_p413_RadioGroup.getCheckedRadioButtonId()));
        c4_p414 = c4_p414_RadioGroup.indexOfChild(c4_p414_RadioGroup.findViewById(c4_p414_RadioGroup.getCheckedRadioButtonId()));
        if(c4_p415_1_CheckBox.isChecked()) c4_p415_1 = 1; else c4_p415_1 = 0;
        if(c4_p415_2_CheckBox.isChecked()) c4_p415_2 = 1; else c4_p415_2 = 0;
        if(c4_p415_3_CheckBox.isChecked()) c4_p415_3 = 1; else c4_p415_3 = 0;
        if(c4_p415_4_CheckBox.isChecked()) c4_p415_4 = 1; else c4_p415_4 = 0;
        if(c4_p415_5_CheckBox.isChecked()) c4_p415_5 = 1; else c4_p415_5 = 0;
        if(c4_p415_6_CheckBox.isChecked()) c4_p415_6 = 1; else c4_p415_6 = 0;
        if(c4_p415_7_CheckBox.isChecked()) c4_p415_7 = 1; else c4_p415_7 = 0;
        if(c4_p415_8_CheckBox.isChecked()) c4_p415_8 = 1; else c4_p415_8 = 0;
        c4_p415_o = c4_p415_o_EditText.getText().toString();
        c4_p416_1 = c4_p416_1_RadioGroup.indexOfChild(c4_p416_1_RadioGroup.findViewById(c4_p416_1_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_2 = c4_p416_2_RadioGroup.indexOfChild(c4_p416_2_RadioGroup.findViewById(c4_p416_2_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_3 = c4_p416_3_RadioGroup.indexOfChild(c4_p416_3_RadioGroup.findViewById(c4_p416_3_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_4 = c4_p416_4_RadioGroup.indexOfChild(c4_p416_4_RadioGroup.findViewById(c4_p416_4_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_5 = c4_p416_5_RadioGroup.indexOfChild(c4_p416_5_RadioGroup.findViewById(c4_p416_5_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_6 = c4_p416_6_RadioGroup.indexOfChild(c4_p416_6_RadioGroup.findViewById(c4_p416_6_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        return false;
    }
}
