package com.example.ricindigus.empove2018.fragments.modulo5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP512P513 extends Fragment {

    RadioGroup c5_p512_RadioGroup, c5_p513_RadioGroup;
    EditText c5_p512_o_EditText, c5_p513_o_EditText;
    LinearLayout m5_p512_linearlayout, m5_p513_linearlayout;

    public FragmentP512P513() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p512_p513, container, false);
        c5_p512_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_512_radiogroup_C5_P512);
        c5_p512_o_EditText = (EditText) rootView.findViewById(R.id.mod5_512_edittext_C5_P512_O);
        c5_p513_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_513_radiogroup_C5_P513);
        c5_p513_o_EditText = (EditText) rootView.findViewById(R.id.mod5_513_edittext_C5_P513_O);

        m5_p512_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p512);
        m5_p513_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p513);

        return rootView;
    }

}
