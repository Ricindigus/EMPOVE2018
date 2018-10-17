package com.example.ricindigus.empove2018.fragments.modulo6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP626P629 extends Fragment {

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

        return rootView;
    }

}
