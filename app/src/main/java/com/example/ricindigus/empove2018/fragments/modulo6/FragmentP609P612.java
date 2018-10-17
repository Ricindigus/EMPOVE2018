package com.example.ricindigus.empove2018.fragments.modulo6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP609P612 extends Fragment {

    RadioGroup c6_p609_RadioGroup;
    EditText c6_p610_pd_EditText, c6_p610_pl_EditText, c6_p610_pm_EditText, c6_p610_pmi_EditText,
            c6_p610_pj_EditText, c6_p610_pv_EditText, c6_p610_ps_EditText,
            c6_p610_sd_EditText, c6_p610_sl_EditText, c6_p610_sm_EditText, c6_p610_smi_EditText,
            c6_p610_sj_EditText, c6_p610_sv_EditText, c6_p610_ss_EditText, c6_p610_t_EditText;
    EditText c6_p611_EditText;
    RadioGroup c6_p612_RadioGroup;

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

        return rootView;
    }

}
