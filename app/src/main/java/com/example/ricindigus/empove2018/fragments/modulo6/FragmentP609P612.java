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
public class FragmentP609P612 extends FragmentPagina {

    RadioGroup c6_p609_RadioGroup;
    EditText c6_p610_pd_EditText, c6_p610_pl_EditText, c6_p610_pm_EditText, c6_p610_pmi_EditText,
            c6_p610_pj_EditText, c6_p610_pv_EditText, c6_p610_ps_EditText,
            c6_p610_sd_EditText, c6_p610_sl_EditText, c6_p610_sm_EditText, c6_p610_smi_EditText,
            c6_p610_sj_EditText, c6_p610_sv_EditText, c6_p610_ss_EditText, c6_p610_t_EditText;
    EditText c6_p611_EditText;
    RadioGroup c6_p612_RadioGroup;
    EditText c6_p612_nro_EditText;
    LinearLayout m6_p609_linearlayout, m6_p610_linearlayout, m6_p611_linearlayout, m6_p612_linearlayout;

    private int c6_p609;
    private String c6_p610_pd;
    private String c6_p610_pl;
    private String c6_p610_pm;
    private String c6_p610_pmi;
    private String c6_p610_pj;
    private String c6_p610_pv;
    private String c6_p610_ps;
    private String c6_p610_pt;
    private String c6_p610_sd;
    private String c6_p610_sl;
    private String c6_p610_sm;
    private String c6_p610_smi;
    private String c6_p610_sj;
    private String c6_p610_sv;
    private String c6_p610_ss;
    private String c6_p610_st;
    private String c6_p610_t;
    private String c6_p611;
    private int c6_p612;
    private String c6_p612_nro;

    public FragmentP609P612() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p609_p612, container, false);

        c6_p609_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_609_radiogroup_C6_P609);

        c6_p610_pd_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PD);
        c6_p610_pl_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PL);
        c6_p610_pm_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PM);
        c6_p610_pmi_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PMI);
        c6_p610_pj_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PJ);
        c6_p610_pv_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PV);
        c6_p610_ps_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PS);

        c6_p610_sd_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SD);
        c6_p610_sl_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SL);
        c6_p610_sm_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SM);
        c6_p610_smi_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SMI);
        c6_p610_sj_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SJ);
        c6_p610_sv_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SV);
        c6_p610_ss_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SS);

        c6_p610_t_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_T);

        c6_p611_EditText = (EditText) rootView.findViewById(R.id.mod6_611_edittext_C6_P611);

        c6_p612_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_612_radiogroup_C6_P612);

        c6_p612_nro_EditText = (EditText) rootView.findViewById(R.id.mod6_612_edittext_C6_P612_NRO);

        m6_p609_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p609);
        m6_p610_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p610);
        m6_p611_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p611);
        m6_p612_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p612);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c6_p609 = c6_p609_RadioGroup.indexOfChild(c6_p609_RadioGroup.findViewById(c6_p609_RadioGroup.getCheckedRadioButtonId()));
        c6_p610_pd = c6_p610_pd_EditText.getText().toString();
        c6_p610_pl = c6_p610_pl_EditText.getText().toString();
        c6_p610_pm = c6_p610_pm_EditText.getText().toString();
        c6_p610_pmi = c6_p610_pmi_EditText.getText().toString();
        c6_p610_pj = c6_p610_pj_EditText.getText().toString();
        c6_p610_pv = c6_p610_pv_EditText.getText().toString();
        c6_p610_ps = c6_p610_ps_EditText.getText().toString();
        c6_p610_sd = c6_p610_sd_EditText.getText().toString();
        c6_p610_sl = c6_p610_sl_EditText.getText().toString();
        c6_p610_sm = c6_p610_sm_EditText.getText().toString();
        c6_p610_smi = c6_p610_smi_EditText.getText().toString();
        c6_p610_sj = c6_p610_sj_EditText.getText().toString();
        c6_p610_sv = c6_p610_sv_EditText.getText().toString();
        c6_p610_ss = c6_p610_ss_EditText.getText().toString();
        c6_p610_t = c6_p610_t_EditText.getText().toString();
        c6_p611 = c6_p611_EditText.getText().toString();
        c6_p612 = c6_p612_RadioGroup.indexOfChild(c6_p612_RadioGroup.findViewById(c6_p612_RadioGroup.getCheckedRadioButtonId()));
        c6_p612_nro = c6_p612_nro_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        return false;
    }
}
