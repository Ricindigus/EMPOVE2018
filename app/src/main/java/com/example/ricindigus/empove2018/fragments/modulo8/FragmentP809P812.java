package com.example.ricindigus.empove2018.fragments.modulo8;


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
public class FragmentP809P812 extends Fragment {

    RadioGroup c8_p809_RadioGroup;
    CheckBox c8_p810_1_Checkbox, c8_p810_2_Checkbox, c8_p810_3_Checkbox , c8_p810_4_Checkbox, c8_p810_5_Checkbox,
            c8_p810_6_Checkbox, c8_p810_7_Checkbox, c8_p810_8_Checkbox, c8_p810_9_Checkbox, c8_p810_10_Checkbox,
            c8_p810_11_Checkbox, c8_p810_12_Checkbox, c8_p810_13_Checkbox;
    EditText c8_p810_o_EditText;
    RadioGroup c8_p811_RadioGroup, c8_p812_RadioGroup;

    public FragmentP809P812() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p809_p812, container, false);

        c8_p809_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_809_radiogroup_C8_P809);

        c8_p810_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_1);
        c8_p810_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_2);
        c8_p810_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_3);
        c8_p810_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_4);
        c8_p810_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_5);
        c8_p810_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_6);
        c8_p810_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_7);
        c8_p810_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_8);
        c8_p810_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_9);
        c8_p810_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_10);
        c8_p810_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_11);
        c8_p810_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_12);
        c8_p810_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_13);
        c8_p810_o_EditText = (EditText) rootView.findViewById(R.id.mod8_810_edittext_C8_P810_O);

        c8_p811_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_811_radiogroup_C8_P811);

        c8_p812_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_812_radiogroup_C8_P812);

        return rootView;
    }

}
