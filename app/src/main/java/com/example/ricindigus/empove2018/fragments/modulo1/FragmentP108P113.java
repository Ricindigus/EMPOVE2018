package com.example.ricindigus.empove2018.fragments.modulo1;


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
public class FragmentP108P113 extends Fragment {

    RadioGroup c1_p108_RadioGroup, c1_p109_RadioGroup, c1_p110_RadioGroup, c1_p111_RadioGroup, c1_p112_RadioGroup;
    RadioGroup c1_p113_1_RadioGroup, c1_p113_2_RadioGroup, c1_p113_3_RadioGroup, c1_p113_4_RadioGroup, c1_p113_5_RadioGroup,
            c1_p113_6_RadioGroup, c1_p113_7_RadioGroup, c1_p113_8_RadioGroup, c1_p113_9_RadioGroup;
    EditText c1_p108_o_EditText, c1_p109_o_EditText, c1_p110_o_EditText, c1_p111_o_EditText, c1_p112_o_EditText;
    EditText c1_p113_7o_EditText, c1_p113_8o_EditText, c1_p113_9o_EditText;
    public FragmentP108P113() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p108_p113, container, false);
        c1_p108_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_108_radiogroup_C1_P108);
        c1_p108_o_EditText = (EditText) rootView.findViewById(R.id.mod1_108_edittext_C1_P108_O);
        c1_p109_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_109_radiogroup_C1_P109);
        c1_p109_o_EditText = (EditText) rootView.findViewById(R.id.mod1_109_edittext_C1_P109_O);
        c1_p110_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_110_radiogroup_C1_P110);
        c1_p110_o_EditText = (EditText) rootView.findViewById(R.id.mod1_110_edittext_C1_P110_O);
        c1_p111_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_111_radiogroup_C1_P111);
        c1_p111_o_EditText = (EditText) rootView.findViewById(R.id.mod1_111_edittext_C1_P111_O);
        c1_p112_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_112_radiogroup_C1_P112);
        c1_p112_o_EditText = (EditText) rootView.findViewById(R.id.mod1_112_edittext_C1_P112_O);

        c1_p113_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_1);
        c1_p113_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_2);
        c1_p113_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_3);
        c1_p113_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_4);
        c1_p113_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_5);
        c1_p113_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_6);
        c1_p113_7_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_7);
        c1_p113_8_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_8);
        c1_p113_9_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_9);
        c1_p113_7o_EditText = (EditText) rootView.findViewById(R.id.mod1_113_edittext_C1_P113_7O);
        c1_p113_8o_EditText = (EditText) rootView.findViewById(R.id.mod1_113_edittext_C1_P113_8O);
        c1_p113_9o_EditText = (EditText) rootView.findViewById(R.id.mod1_113_edittext_C1_P113_9O);

        return rootView;
    }

}
