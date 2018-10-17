package com.example.ricindigus.empove2018.fragments.modulo5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP508P511 extends Fragment {

    CheckBox c5_p508_1_Checkbox, c5_p508_2_Checkbox, c5_p508_3_Checkbox , c5_p508_4_Checkbox, c5_p508_5_Checkbox,
            c5_p508_6_Checkbox, c5_p508_7_Checkbox, c5_p508_8_Checkbox, c5_p508_9_Checkbox, c5_p508_10_Checkbox, c5_p508_11_Checkbox;
    EditText c5_p508_o_EditText, c5_p511_o_EditText;
    RadioGroup c5_p509_RadioGroup, c5_p510_RadioGroup, c5_p511_RadioGroup;

    public FragmentP508P511() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p508_p511, container, false);
        c5_p508_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_1);
        c5_p508_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_2);
        c5_p508_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_3);
        c5_p508_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_4);
        c5_p508_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_5);
        c5_p508_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_6);
        c5_p508_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_7);
        c5_p508_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_8);
        c5_p508_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_9);
        c5_p508_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_10);
        c5_p508_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_11);
        c5_p508_o_EditText = (EditText) rootView.findViewById(R.id.mod5_508_edittext_C5_P508_O);
        c5_p509_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_509_radiogroup_C5_P509);
        c5_p510_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_510_radiogroup_C5_P510);
        c5_p511_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_511_radiogroup_C5_P511);
        c5_p511_o_EditText = (EditText) rootView.findViewById(R.id.mod5_511_edittext_C5_P511_O);


        return rootView;
    }

}
