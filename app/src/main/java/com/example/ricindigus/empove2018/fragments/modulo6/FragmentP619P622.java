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
public class FragmentP619P622 extends Fragment {

    RadioGroup c6_p619_RadioGroup,
            c6_p620_1_RadioGroup, c6_p620_2_RadioGroup, c6_p620_3_RadioGroup, c6_p620_4_RadioGroup,
            c6_p620_5_RadioGroup, c6_p620_6_RadioGroup, c6_p620_7_RadioGroup, c6_p620_8_RadioGroup,
            c6_p620_9_RadioGroup;
    EditText c6_p620_o_EditText;
    RadioGroup c6_p621_RadioGroup, c6_p622_RadioGroup;

    public FragmentP619P622() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_p619_p622, container, false);

        c6_p619_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_619_radiogroup_C6_P619);

        c6_p620_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_1);
        c6_p620_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_2);
        c6_p620_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_3);
        c6_p620_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_4);
        c6_p620_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_5);
        c6_p620_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_6);
        c6_p620_7_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_7);
        c6_p620_8_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_8);
        c6_p620_9_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_9);
        c6_p620_o_EditText = (EditText) rootView.findViewById(R.id.mod6_620_edittext_C6_P620_O);

        c6_p621_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_621_radiogroup_C6_P621);
        c6_p622_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_622_radiogroup_C6_P622);

        return rootView;
    }

}
