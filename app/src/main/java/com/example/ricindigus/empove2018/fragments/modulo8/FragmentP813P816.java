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

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP813P816 extends FragmentPagina {

    CheckBox c8_p813_1_Checkbox, c8_p813_2_Checkbox, c8_p813_3_Checkbox , c8_p813_4_Checkbox, c8_p813_5_Checkbox,
            c8_p813_6_Checkbox, c8_p813_7_Checkbox, c8_p813_8_Checkbox, c8_p813_9_Checkbox, c8_p813_10_Checkbox,
            c8_p813_11_Checkbox, c8_p813_12_Checkbox, c8_p813_13_Checkbox, c8_p813_14_Checkbox;
    EditText c8_p813_o_EditText;
    CheckBox c8_p814_1_Checkbox, c8_p814_2_Checkbox, c8_p814_3_Checkbox , c8_p814_4_Checkbox, c8_p814_5_Checkbox,
            c8_p814_6_Checkbox, c8_p814_7_Checkbox, c8_p814_8_Checkbox;
    RadioGroup c8_p815_RadioGroup;
    CheckBox c8_p816_1_Checkbox, c8_p816_2_Checkbox, c8_p816_3_Checkbox , c8_p816_4_Checkbox, c8_p816_5_Checkbox,
            c8_p816_6_Checkbox, c8_p816_7_Checkbox, c8_p816_8_Checkbox, c8_p816_9_Checkbox, c8_p816_10_Checkbox,
            c8_p816_11_Checkbox, c8_p816_12_Checkbox, c8_p816_13_Checkbox;
    EditText c8_p816_o_EditText;
    LinearLayout m8_p813_linearlayout, m8_p814_linearlayout, m8_p815_linearlayout, m8_p816_linearlayout;

    private int c8_p813_1;
    private int c8_p813_2;
    private int c8_p813_3;
    private int c8_p813_4;
    private int c8_p813_5;
    private int c8_p813_6;
    private int c8_p813_7;
    private int c8_p813_8;
    private int c8_p813_9;
    private int c8_p813_10;
    private int c8_p813_11;
    private int c8_p813_12;
    private int c8_p813_13;
    private int c8_p813_14;
    private String c8_p813_o;
    private int c8_p814_1;
    private int c8_p814_2;
    private int c8_p814_3;
    private int c8_p814_4;
    private int c8_p814_5;
    private int c8_p814_6;
    private int c8_p814_7;
    private int c8_p814_8;
    private int c8_p815;
    private int c8_p816_1;
    private int c8_p816_2;
    private int c8_p816_3;
    private int c8_p816_4;
    private int c8_p816_5;
    private int c8_p816_6;
    private int c8_p816_7;
    private int c8_p816_8;
    private String c8_p816_o;

    public FragmentP813P816() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p813_p816, container, false);

        c8_p813_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_1);
        c8_p813_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_2);
        c8_p813_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_3);
        c8_p813_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_4);
        c8_p813_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_5);
        c8_p813_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_6);
        c8_p813_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_7);
        c8_p813_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_8);
        c8_p813_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_9);
        c8_p813_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_10);
        c8_p813_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_11);
        c8_p813_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_12);
        c8_p813_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_13);
        c8_p813_14_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_14);
        c8_p813_o_EditText = (EditText) rootView.findViewById(R.id.mod8_813_edittext_C8_P813_O);

        c8_p814_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_1);
        c8_p814_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_2);
        c8_p814_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_3);
        c8_p814_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_4);
        c8_p814_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_5);
        c8_p814_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_6);
        c8_p814_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_7);
        c8_p814_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_8);

        c8_p815_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_815_radiogroup_C8_P815);

        c8_p816_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_1);
        c8_p816_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_2);
        c8_p816_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_3);
        c8_p816_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_4);
        c8_p816_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_5);
        c8_p816_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_6);
        c8_p816_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_7);
        c8_p816_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_8);
        c8_p816_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_9);
        c8_p816_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_10);
        c8_p816_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_11);
        c8_p816_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_12);
        c8_p816_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_13);
        c8_p816_o_EditText = (EditText) rootView.findViewById(R.id.mod8_816_edittext_C8_P816_O);

        m8_p813_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p813);
        m8_p814_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p814);
        m8_p815_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p815);
        m8_p816_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p816);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        if(c8_p813_1_Checkbox.isChecked()) c8_p813_1 = 1; else c8_p813_1 = 0;
        if(c8_p813_2_Checkbox.isChecked()) c8_p813_2 = 1; else c8_p813_2 = 0;
        if(c8_p813_3_Checkbox.isChecked()) c8_p813_3 = 1; else c8_p813_3 = 0;
        if(c8_p813_4_Checkbox.isChecked()) c8_p813_4 = 1; else c8_p813_4 = 0;
        if(c8_p813_5_Checkbox.isChecked()) c8_p813_5 = 1; else c8_p813_5 = 0;
        if(c8_p813_6_Checkbox.isChecked()) c8_p813_6 = 1; else c8_p813_6 = 0;
        if(c8_p813_7_Checkbox.isChecked()) c8_p813_7 = 1; else c8_p813_7 = 0;
        if(c8_p813_8_Checkbox.isChecked()) c8_p813_8 = 1; else c8_p813_8 = 0;
        if(c8_p813_9_Checkbox.isChecked()) c8_p813_9 = 1; else c8_p813_9 = 0;
        if(c8_p813_10_Checkbox.isChecked()) c8_p813_10 = 1; else c8_p813_10 = 0;
        if(c8_p813_11_Checkbox.isChecked()) c8_p813_11 = 1; else c8_p813_11 = 0;
        if(c8_p813_12_Checkbox.isChecked()) c8_p813_12 = 1; else c8_p813_12 = 0;
        if(c8_p813_13_Checkbox.isChecked()) c8_p813_13 = 1; else c8_p813_13 = 0;
        if(c8_p813_14_Checkbox.isChecked()) c8_p813_14 = 1; else c8_p813_14 = 0;
        c8_p813_o = c8_p813_o_EditText.getText().toString();
        if(c8_p814_1_Checkbox.isChecked()) c8_p814_1 = 1; else c8_p814_1 = 0;
        if(c8_p814_2_Checkbox.isChecked()) c8_p814_2 = 1; else c8_p814_2 = 0;
        if(c8_p814_3_Checkbox.isChecked()) c8_p814_3 = 1; else c8_p814_3 = 0;
        if(c8_p814_4_Checkbox.isChecked()) c8_p814_4 = 1; else c8_p814_4 = 0;
        if(c8_p814_5_Checkbox.isChecked()) c8_p814_5 = 1; else c8_p814_5 = 0;
        if(c8_p814_6_Checkbox.isChecked()) c8_p814_6 = 1; else c8_p814_6 = 0;
        if(c8_p814_7_Checkbox.isChecked()) c8_p814_7 = 1; else c8_p814_7 = 0;
        if(c8_p814_8_Checkbox.isChecked()) c8_p814_8 = 1; else c8_p814_8 = 0;
        c8_p815 = c8_p815_RadioGroup.indexOfChild(c8_p815_RadioGroup.findViewById(c8_p815_RadioGroup.getCheckedRadioButtonId()));
        if(c8_p816_1_Checkbox.isChecked()) c8_p816_1 = 1; else c8_p816_1 = 0;
        if(c8_p816_2_Checkbox.isChecked()) c8_p816_2 = 1; else c8_p816_2 = 0;
        if(c8_p816_3_Checkbox.isChecked()) c8_p816_3 = 1; else c8_p816_3 = 0;
        if(c8_p816_4_Checkbox.isChecked()) c8_p816_4 = 1; else c8_p816_4 = 0;
        if(c8_p816_5_Checkbox.isChecked()) c8_p816_5 = 1; else c8_p816_5 = 0;
        if(c8_p816_6_Checkbox.isChecked()) c8_p816_6 = 1; else c8_p816_6 = 0;
        if(c8_p816_7_Checkbox.isChecked()) c8_p816_7 = 1; else c8_p816_7 = 0;
        if(c8_p816_8_Checkbox.isChecked()) c8_p816_8 = 1; else c8_p816_8 = 0;
        c8_p816_o = c8_p816_o_EditText.getText().toString();

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
