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
public class FragmentP501P505 extends Fragment {

    RadioGroup c5_p501_RadioGroup, c5_p503_RadioGroup, c5_p504_RadioGroup, c5_p505_RadioGroup;
    EditText c5_p502_c_EditText;
    CheckBox c5_p502_CheckBox;
    public FragmentP501P505() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p501_p505, container, false);

        c5_p501_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_501_radiogroup_C5_P501);
        c5_p502_c_EditText = (EditText) rootView.findViewById(R.id.mod5_502_edittext_C5_P502_C);
        c5_p502_CheckBox = (CheckBox) rootView.findViewById(R.id.mod5_502_checkbox_C5_P502);
        c5_p503_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_503_radiogroup_C5_P503);
        c5_p504_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_504_radiogroup_C5_P504);
        c5_p505_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_505_radiogroup_C5_P505);


        return rootView;


    }

}
