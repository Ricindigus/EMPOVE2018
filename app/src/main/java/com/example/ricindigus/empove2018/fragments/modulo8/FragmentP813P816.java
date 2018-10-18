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
public class FragmentP813P816 extends Fragment {

    CheckBox c8_p813_1_Checkbox, c8_p813_2_Checkbox, c8_p813_3_Checkbox , c8_p813_4_Checkbox, c8_p813_5_Checkbox,
            c8_p813_6_Checkbox, c8_p813_7_Checkbox, c8_p813_8_Checkbox, c8_p813_9_Checkbox, c8_p813_10_Checkbox,
            c8_p813_11_Checkbox, c8_p813_12_Checkbox, c8_p813_13_Checkbox, c8_p813_14_Checkbox;
    EditText c8_p813_o_EditText;
    CheckBox c8_p814_1_Checkbox, c8_p814_2_Checkbox, c8_p814_3_Checkbox , c8_p814_4_Checkbox, c8_p814_5_Checkbox,
            c8_p814_6_Checkbox, c8_p814_7_Checkbox, c8_p814_8_Checkbox;
    RadioGroup c8_p815_RadioGroup;
    CheckBox c8_p816_1_Checkbox, c8_p816_2_Checkbox, c8_p816_3_Checkbox , c8_p816_4_Checkbox, c8_p816_5_Checkbox,
            c8_p816_6_Checkbox, c8_p816_7_Checkbox, c8_p816_8_Checkbox, c8_p816_9_Checkbox, c8_p816_10_Checkbox,
            c8_p816_11_Checkbox, c8_p816_12_Checkbox, c8_p816_13_Checkbox;
    EditText c8_p816_o_EditText;

    public FragmentP813P816() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p813_p816, container, false);

        c8_p813_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_1);
        c8_p813_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_2);
        c8_p813_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_3);
        c8_p813_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_4);
        c8_p813_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_5);
        c8_p813_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_6);
        c8_p813_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_7);
        c8_p813_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_8);
        c8_p813_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_9);
        c8_p813_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_10);
        c8_p813_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_11);
        c8_p813_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_12);
        c8_p813_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_13);
        c8_p813_14_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_14);
        c8_p813_o_EditText = (EditText) rootView.findViewById(R.id.mod8_813_edittext_C8_P813_O);

        c8_p814_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_1);
        c8_p814_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_2);
        c8_p814_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_3);
        c8_p814_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_4);
        c8_p814_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_5);
        c8_p814_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_6);
        c8_p814_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_7);
        c8_p814_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_8);

        c8_p815_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_815_radiogroup_C8_P815);

        c8_p816_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_1);
        c8_p816_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_2);
        c8_p816_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_3);
        c8_p816_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_4);
        c8_p816_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_5);
        c8_p816_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_6);
        c8_p816_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_7);
        c8_p816_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_8);
        c8_p816_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_9);
        c8_p816_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_10);
        c8_p816_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_11);
        c8_p816_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_12);
        c8_p816_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_13);
        c8_p816_o_EditText = (EditText) rootView.findViewById(R.id.mod8_816_edittext_C8_P816_O);

        return rootView;
    }

}
