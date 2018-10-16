package com.example.ricindigus.empove2018.fragments.modulo4;


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
public class FragmentP411P416 extends Fragment {

    RadioGroup c4_p411RadioGroup, c4_p412RadioGroup, c4_p413RadioGroup, c4_p414RadioGroup;
    CheckBox c4_p415_1CheckBox, c4_p415_2CheckBox, c4_p415_3CheckBox, c4_p415_4CheckBox, c4_p415_5CheckBox,
            c4_p415_6CheckBox, c4_p415_7CheckBox, c4_p415_8CheckBox, c4_p415_9CheckBox;
    EditText c4_p415_oEditText;
    RadioGroup c4_p416_1RadioGroup, c4_p416_2RadioGroup, c4_p416_3RadioGroup, c4_p416_4RadioGroup,
            c4_p416_5RadioGroup, c4_p416_6RadioGroup;

    public FragmentP411P416() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rooView = inflater.inflate(R.layout.fragment_p411_p416, container, false);
        c4_p411RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_411_radiogroup_C4_P411);
        c4_p412RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_412_radiogroup_C4_P412);
        c4_p413RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_413_radiogroup_C4_P413);
        c4_p414RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_414_radiogroup_C4_P414);
        c4_p415_1CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_1);
        c4_p415_2CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_2);
        c4_p415_3CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_3);
        c4_p415_4CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_4);
        c4_p415_5CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_5);
        c4_p415_6CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_6);
        c4_p415_oEditText = (EditText) rooView.findViewById(R.id.mod4_415_edittext_C4_P415_O);
        c4_p415_7CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_7);
        c4_p415_8CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_8);
        c4_p415_9CheckBox = (CheckBox) rooView.findViewById(R.id.mod4_415_checkbox_C4_P415_9);
        c4_p416_1RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_416_radiogroup_C4_P416_1);
        c4_p416_2RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_416_radiogroup_C4_P416_2);
        c4_p416_3RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_416_radiogroup_C4_P416_3);
        c4_p416_4RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_416_radiogroup_C4_P416_4);
        c4_p416_5RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_416_radiogroup_C4_P416_5);
        c4_p416_6RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod4_416_radiogroup_C4_P416_6);


        return rooView;
    }

}
