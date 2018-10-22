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
public class FragmentP626P629 extends FragmentPagina {

    RadioGroup c6_p626_RadioGroup, c6_p627_RadioGroup;
    EditText c6_p628_EditText;
    RadioGroup c6_p629_1_RadioGroup, c6_p629_2_RadioGroup, c6_p629_3_RadioGroup, c6_p629_4_RadioGroup;
    EditText c6_p629_o_EditText;
    Spinner c6_p629_1_f_Spinner;
    EditText c6_p629_1_m_EditText;
    Spinner c6_p629_2_f_Spinner;
    EditText c6_p629_2_m_EditText;
    Spinner c6_p629_3_f_Spinner;
    EditText c6_p629_3_m_EditText;
    Spinner c6_p629_4_f_Spinner;
    EditText c6_p629_4_m_EditText;
    LinearLayout m6_p626_linearlayout, m6_p627_linearlayout, m6_p628_linearlayout, m6_p629_linearlayout;

    private int c6_p626;
    private int c6_p627;
    private String c6_p628;
    private int c6_p629_1;
    private int c6_p629_2;
    private int c6_p629_3;
    private int c6_p629_4;
    private String c6_p629_o;
    private int c6_p629_1_f;
    private String c6_p629_1_m;
    private int c6_p629_2_f;
    private String c6_p629_2_m;
    private int c6_p629_3_f;
    private String c6_p629_3_m;
    private int c6_p629_4_f;
    private String c6_p629_4_m;

    public FragmentP626P629() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p626_p629, container, false);

        c6_p626_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_626_radiogroup_C6_P626);
        c6_p627_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_627_radiogroup_C6_P627);
        c6_p628_EditText = (EditText) rootView.findViewById(R.id.mod6_628_edittext_C6_P628);

        c6_p629_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_1);
        c6_p629_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_2);
        c6_p629_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_3);
        c6_p629_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_4);
        c6_p629_o_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_O);

        c6_p629_1_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_1_F);
        c6_p629_1_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_1_M);
        c6_p629_2_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_2_F);
        c6_p629_2_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_2_M);
        c6_p629_3_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_3_F);
        c6_p629_3_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_3_M);
        c6_p629_4_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_4_F);
        c6_p629_4_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_4_M);

        m6_p626_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p626);
        m6_p627_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p627);
        m6_p628_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p628);
        m6_p629_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p629);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c6_p626 = c6_p626_RadioGroup.indexOfChild(c6_p626_RadioGroup.findViewById(c6_p626_RadioGroup.getCheckedRadioButtonId()));
        c6_p627 = c6_p627_RadioGroup.indexOfChild(c6_p627_RadioGroup.findViewById(c6_p627_RadioGroup.getCheckedRadioButtonId()));
        c6_p628 = c6_p628_EditText.getText().toString();
        c6_p629_1 = c6_p629_1_RadioGroup.indexOfChild(c6_p629_1_RadioGroup.findViewById(c6_p629_1_RadioGroup.getCheckedRadioButtonId()));
        c6_p629_2 = c6_p629_2_RadioGroup.indexOfChild(c6_p629_2_RadioGroup.findViewById(c6_p629_2_RadioGroup.getCheckedRadioButtonId()));
        c6_p629_3 = c6_p629_3_RadioGroup.indexOfChild(c6_p629_3_RadioGroup.findViewById(c6_p629_3_RadioGroup.getCheckedRadioButtonId()));
        c6_p629_4 = c6_p629_4_RadioGroup.indexOfChild(c6_p629_4_RadioGroup.findViewById(c6_p629_4_RadioGroup.getCheckedRadioButtonId()));
        c6_p629_o = c6_p629_o_EditText.getText().toString();
        c6_p629_1_f = c6_p629_1_f_Spinner.getSelectedItemPosition();
        c6_p629_1_m = c6_p629_1_m_EditText.getText().toString();
        c6_p629_2_f = c6_p629_2_f_Spinner.getSelectedItemPosition();
        c6_p629_2_m = c6_p629_2_m_EditText.getText().toString();
        c6_p629_3_f = c6_p629_3_f_Spinner.getSelectedItemPosition();
        c6_p629_3_m = c6_p629_3_m_EditText.getText().toString();
        c6_p629_4_f = c6_p629_4_f_Spinner.getSelectedItemPosition();
        c6_p629_4_m = c6_p629_4_m_EditText.getText().toString();
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
