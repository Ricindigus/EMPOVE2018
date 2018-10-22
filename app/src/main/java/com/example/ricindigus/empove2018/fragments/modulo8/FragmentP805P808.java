package com.example.ricindigus.empove2018.fragments.modulo8;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP805P808 extends FragmentPagina {

    RadioGroup c8_p805_1_RadioGroup, c8_p805_2_RadioGroup, c8_p805_3_RadioGroup, c8_p805_4_RadioGroup,
            c8_p805_5_RadioGroup;
    Spinner c8_p806_1_Spinner, c8_p806_2_Spinner, c8_p806_3_Spinner, c8_p806_4_Spinner,
            c8_p806_5_Spinner, c8_p806_6_Spinner;
    RadioGroup c8_p807_RadioGroup;
    CheckBox c8_p808_1_CheckBox, c8_p808_2_CheckBox, c8_p808_3_CheckBox, c8_p808_4_CheckBox,
            c8_p808_5_CheckBox, c8_p808_6_CheckBox, c8_p808_7_CheckBox, c8_p808_8_CheckBox,
            c8_p808_9_CheckBox, c8_p808_10_CheckBox, c8_p808_11_CheckBox, c8_p808_12_CheckBox,
            c8_p808_13_CheckBox;
    EditText c8_p808_o_EditText;
    LinearLayout m8_p805_linearlayout, m8_p806_linearlayout, m8_p807_linearlayout, m8_p808_linearlayout;

    private int c8_p805_1;
    private int c8_p805_2;
    private int c8_p805_3;
    private int c8_p805_4;
    private int c8_p805_5;
    private int c8_p806_1;
    private int c8_p806_2;
    private int c8_p806_3;
    private int c8_p806_4;
    private int c8_p806_5;
    private int c8_p806_6;
    private int c8_p807;
    private int c8_p808_1;
    private int c8_p808_2;
    private int c8_p808_3;
    private int c8_p808_4;
    private int c8_p808_5;
    private int c8_p808_6;
    private int c8_p808_7;
    private int c8_p808_8;

    public FragmentP805P808() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p805_p808, container, false);

        c8_p805_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_1);
        c8_p805_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_2);
        c8_p805_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_3);
        c8_p805_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_4);
        c8_p805_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_5);

        c8_p806_1_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_1);
        c8_p806_2_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_2);
        c8_p806_3_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_3);
        c8_p806_4_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_4);
        c8_p806_5_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_5);
        c8_p806_6_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_6);

        c8_p807_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_807_radiogroup_C8_P807);

        c8_p808_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_1);
        c8_p808_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_2);
        c8_p808_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_3);
        c8_p808_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_4);
        c8_p808_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_5);
        c8_p808_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_6);
        c8_p808_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_7);
        c8_p808_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_8);
        c8_p808_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_9);
        c8_p808_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_10);
        c8_p808_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_11);
        c8_p808_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_12);
        c8_p808_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_13);

        c8_p808_o_EditText = (EditText) rootView.findViewById(R.id.mod8_808_edittext_C8_P808_O);

        m8_p805_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p805);
        m8_p806_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p806);
        m8_p807_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p807);
        m8_p808_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p808);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c8_p805_1 = c8_p805_1_RadioGroup.indexOfChild(c8_p805_1_RadioGroup.findViewById(c8_p805_1_RadioGroup.getCheckedRadioButtonId()));
        c8_p805_2 = c8_p805_2_RadioGroup.indexOfChild(c8_p805_2_RadioGroup.findViewById(c8_p805_2_RadioGroup.getCheckedRadioButtonId()));
        c8_p805_3 = c8_p805_3_RadioGroup.indexOfChild(c8_p805_3_RadioGroup.findViewById(c8_p805_3_RadioGroup.getCheckedRadioButtonId()));
        c8_p805_4 = c8_p805_4_RadioGroup.indexOfChild(c8_p805_4_RadioGroup.findViewById(c8_p805_4_RadioGroup.getCheckedRadioButtonId()));
        c8_p805_5 = c8_p805_5_RadioGroup.indexOfChild(c8_p805_5_RadioGroup.findViewById(c8_p805_5_RadioGroup.getCheckedRadioButtonId()));
        c8_p806_1 = c8_p806_1_Spinner.getSelectedItemPosition();
        c8_p806_2 = c8_p806_2_Spinner.getSelectedItemPosition();
        c8_p806_3 = c8_p806_3_Spinner.getSelectedItemPosition();
        c8_p806_4 = c8_p806_4_Spinner.getSelectedItemPosition();
        c8_p806_5 = c8_p806_5_Spinner.getSelectedItemPosition();
        c8_p806_6 = c8_p806_6_Spinner.getSelectedItemPosition();
        c8_p807 = c8_p807_RadioGroup.indexOfChild(c8_p807_RadioGroup.findViewById(c8_p807_RadioGroup.getCheckedRadioButtonId()));
        if(c8_p808_1_CheckBox.isChecked()) c8_p808_1 = 1; else c8_p808_1 = 0;
        if(c8_p808_2_CheckBox.isChecked()) c8_p808_2 = 1; else c8_p808_2 = 0;
        if(c8_p808_3_CheckBox.isChecked()) c8_p808_3 = 1; else c8_p808_3 = 0;
        if(c8_p808_4_CheckBox.isChecked()) c8_p808_4 = 1; else c8_p808_4 = 0;
        if(c8_p808_5_CheckBox.isChecked()) c8_p808_5 = 1; else c8_p808_5 = 0;
        if(c8_p808_6_CheckBox.isChecked()) c8_p808_6 = 1; else c8_p808_6 = 0;
        if(c8_p808_7_CheckBox.isChecked()) c8_p808_7 = 1; else c8_p808_7 = 0;
        if(c8_p808_8_CheckBox.isChecked()) c8_p808_8 = 1; else c8_p808_8 = 0;

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
        return null;
    }
}
