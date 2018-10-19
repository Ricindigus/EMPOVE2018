package com.example.ricindigus.empove2018.fragments.modulo4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP405P407 extends FragmentPagina {

    CheckBox c4_p405_1CheckBox, c4_p405_2CheckBox, c4_p405_3CheckBox, c4_p405_4CheckBox, c4_p405_5CheckBox,
            c4_p405_6CheckBox, c4_p405_7CheckBox;
    CheckBox c4_p406_1CheckBox, c4_p406_2CheckBox, c4_p406_3CheckBox, c4_p406_4CheckBox, c4_p406_5CheckBox,
            c4_p406_6CheckBox, c4_p406_7CheckBox, c4_p406_8CheckBox;
    EditText c4_p406_oEditText;
    CheckBox c4_p407_1CheckBox, c4_p407_2CheckBox, c4_p407_3CheckBox, c4_p407_4CheckBox, c4_p407_5CheckBox,
            c4_p407_6CheckBox, c4_p407_7CheckBox, c4_p407_8CheckBox, c4_p407_9CheckBox, c4_p407_10CheckBox,
            c4_p407_11CheckBox, c4_p407_12CheckBox, c4_p407_13CheckBox;
    EditText c4_p407_oEditText;
    LinearLayout m4_p405_linearlayout, m4_p406_linearlayout, m4_p407_linearlayout;

    int c4_p405_1;


    public FragmentP405P407() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p405_p407, container, false);
        c4_p405_1CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_1);
        c4_p405_2CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_2);
        c4_p405_3CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_3);
        c4_p405_4CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_4);
        c4_p405_5CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_5);
        c4_p405_6CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_6);
        c4_p405_7CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_7);

        c4_p406_1CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_1);
        c4_p406_2CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_2);
        c4_p406_3CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_3);
        c4_p406_4CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_4);
        c4_p406_5CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_5);
        c4_p406_6CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_6);
        c4_p406_7CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_7);
        c4_p406_oEditText = (EditText) rootView.findViewById(R.id.mod4_406_edittext_C4_P406_O);
        c4_p406_8CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_ck8);

        c4_p407_1CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_checkbox_C4_P407_1);
        c4_p407_2CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_2);
        c4_p407_3CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_3);
        c4_p407_4CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_4);
        c4_p407_5CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_5);
        c4_p407_6CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_6);
        c4_p407_7CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_7);
        c4_p407_8CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_8);
        c4_p407_9CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_9);
        c4_p407_10CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_10);
        c4_p407_11CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_11);
        c4_p407_12CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_12);
        c4_p407_13CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_13);
        c4_p407_oEditText = (EditText) rootView.findViewById(R.id.mod4_407_edittext_C4_P407_O);

        m4_p405_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p405);
        m4_p406_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p406);
        m4_p407_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p407);

        return rootView;

    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        if(c4_p405_1CheckBox.isChecked()) c4_p405_1 = 1 ;
        else c4_p405_1 = 0;


    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        return true;
    }
}
