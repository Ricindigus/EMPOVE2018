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
public class FragmentP623P625 extends Fragment {

    RadioGroup c6_p623_RadioGroup;
    EditText c6_p623_o_EditText;
    RadioGroup c6_p624_RadioGroup;
    EditText c6_p624_o_EditText;
    EditText c6_p625_EditText;

    public FragmentP623P625() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p623_p625, container, false);

        c6_p623_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_623_radiogroup_C6_P623);
        c6_p623_o_EditText = (EditText) rootView.findViewById(R.id.mod6_623_edittext_C6_P623_O);
        c6_p624_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_624_radiogroup_C6_P624);
        c6_p624_o_EditText = (EditText) rootView.findViewById(R.id.mod6_624_edittext_C6_P624_O);
        c6_p625_EditText = (EditText) rootView.findViewById(R.id.mod6_625_edittext_C6_P625);

        return rootView;
    }

}
