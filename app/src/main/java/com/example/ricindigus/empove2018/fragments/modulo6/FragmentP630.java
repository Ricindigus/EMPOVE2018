package com.example.ricindigus.empove2018.fragments.modulo6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP630 extends FragmentPagina {

    RadioGroup c6_p630_1_RadioGroup, c6_p630_1_med_RadioGroup;
    EditText c6_p630_1_o_EditText;
    Spinner c6_p630_1_frec_Spinner, c6_p630_1_mont_Spinner;
    RadioGroup c6_p630_2_RadioGroup, c6_p630_2_med_RadioGroup;
    EditText c6_p630_2_o_EditText;
    Spinner c6_p630_2_frec_Spinner, c6_p630_2_mont_Spinner;
    LinearLayout m6_p630_linearlayout;

    private int c6_p630_1;
    private int c6_p630_1_med;
    private String c6_p630_1_o;
    private int c6_p630_1_frec;
    private int c6_p630_1_mont;
    private int c6_p630_2;
    private int c6_p630_2_med;
    private String c6_p630_2_o;
    private int c6_p630_2_frec;
    private int c6_p630_2_mont;




    public FragmentP630() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p630, container, false);

        c6_p630_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_1);
        c6_p630_1_med_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_1_MED);
        c6_p630_1_o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_1_O);
        c6_p630_1_frec_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_1_FREC);
        c6_p630_1_mont_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_1_MONT);

        c6_p630_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_2);
        c6_p630_2_med_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_2_MED);
        c6_p630_2_o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_2_O);
        c6_p630_2_frec_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_2_FREC);
        c6_p630_2_mont_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_2_MONT);

        m6_p630_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p630);

        return rootView;
    }


    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c6_p630_1 = c6_p630_1_RadioGroup.indexOfChild(c6_p630_1_RadioGroup.findViewById(c6_p630_1_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_1_med = c6_p630_1_med_RadioGroup.indexOfChild(c6_p630_1_med_RadioGroup.findViewById(c6_p630_1_med_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_1_o = c6_p630_1_o_EditText.getText().toString();
        c6_p630_1_frec = c6_p630_1_frec_Spinner.getSelectedItemPosition();
        c6_p630_1_mont = c6_p630_1_mont_Spinner.getSelectedItemPosition();
        c6_p630_2 = c6_p630_2_RadioGroup.indexOfChild(c6_p630_2_RadioGroup.findViewById(c6_p630_2_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_2_med = c6_p630_2_med_RadioGroup.indexOfChild(c6_p630_2_med_RadioGroup.findViewById(c6_p630_2_med_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_2_o = c6_p630_2_o_EditText.getText().toString();
        c6_p630_2_frec = c6_p630_2_frec_Spinner.getSelectedItemPosition();
        c6_p630_2_mont = c6_p630_2_mont_Spinner.getSelectedItemPosition();
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
