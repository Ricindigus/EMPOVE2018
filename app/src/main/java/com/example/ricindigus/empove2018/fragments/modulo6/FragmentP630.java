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
