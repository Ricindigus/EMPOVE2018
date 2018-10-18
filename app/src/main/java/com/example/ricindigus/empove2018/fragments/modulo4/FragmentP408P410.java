package com.example.ricindigus.empove2018.fragments.modulo4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP408P410 extends Fragment {

    CheckBox c4_p408_1CheckBox, c4_p408_2CheckBox, c4_p408_3CheckBox, c4_p408_4CheckBox, c4_p408_5CheckBox,
            c4_p408_6CheckBox, c4_p408_7CheckBox, c4_p408_8CheckBox, c4_p408_9CheckBox, c4_p408_10CheckBox,
            c4_p408_11CheckBox, c4_p408_12CheckBox, c4_p408_13CheckBox, c4_p408_14CheckBox;
    EditText c4_p408_oEditText;
    RadioGroup c4_p409RadioGroup, c4_p410RadioGroup;
    LinearLayout m4_p408_linearlayout, m4_p409_linearlayout, m4_p410_linearlayout;

    public FragmentP408P410() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p408_p410, container, false);
        c4_p408_1CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_1);
        c4_p408_2CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_2);
        c4_p408_3CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_3);
        c4_p408_4CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_4);
        c4_p408_5CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_5);
        c4_p408_6CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_6);
        c4_p408_7CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_7);
        c4_p408_8CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_8);
        c4_p408_9CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_9);
        c4_p408_10CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_10);
        c4_p408_11CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_11);
        c4_p408_12CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_12);
        c4_p408_13CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_13);
        c4_p408_14CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_14);
        c4_p408_oEditText = (EditText) rootView.findViewById(R.id.mod4_408_edittext_C4_P408_O);

        c4_p409RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_409_radiogroup_C4_P409);

        c4_p410RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_410_radiogroup_C4_P410);

        m4_p408_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p408);
        m4_p409_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p409);
        m4_p410_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p410);


        return rootView;
    }

}
