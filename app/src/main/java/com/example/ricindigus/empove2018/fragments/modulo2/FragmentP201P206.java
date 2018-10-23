package com.example.ricindigus.empove2018.fragments.modulo2;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP201P206 extends FragmentPagina {

    String idHogar;
    Context contexto;

    TextInputEditText c2_p202_TextInputET, c2_p205_a_TextInputET, c2_p205_m_TextInputET;
    Spinner c2_p203_Spinner,c2_p206_Spinner;
    RadioGroup c2_p204_RadioGroup;

    public FragmentP201P206() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP201P206(String idHogar, Context contexto) {
        this.idHogar = idHogar;
        this.contexto = contexto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p201_p206, container, false);
        c2_p202_TextInputET = (TextInputEditText) rootView.findViewById(R.id.mod2_202_textinputedittext_C2_P202);
        c2_p203_Spinner = (Spinner) rootView.findViewById(R.id.mod2_203_spinner_C2_P203);
        c2_p204_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod2_204_radiogroup_C2_P204);
        c2_p205_a_TextInputET = (TextInputEditText) rootView.findViewById(R.id.mod2_205_textinputedittext_C2_P205_A);
        c2_p205_m_TextInputET = (TextInputEditText) rootView.findViewById(R.id.mod2_205_textinputedittext_C2_P205_M);
        c2_p206_Spinner = (Spinner) rootView.findViewById(R.id.mod2_206_spinner_C2_P206);
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
        return null;
    }
}
