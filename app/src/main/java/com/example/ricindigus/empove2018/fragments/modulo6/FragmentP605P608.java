package com.example.ricindigus.empove2018.fragments.modulo6;


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
public class FragmentP605P608 extends Fragment {

    EditText c6_p605_EditText, c6_p606_EditText, c6_p607_EditText;
    RadioGroup c6_p608_RadioGroup;
    EditText c6_p608_o_EditText;
    LinearLayout m6_p605_linearlayout, m6_p606_linearlayout, m6_p607_linearlayout, m6_p608_linearlayout;

    public FragmentP605P608() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p605_p608, container, false);

        c6_p605_EditText = (EditText) rootView.findViewById(R.id.mod6_605_edittext_C6_P605);
        c6_p606_EditText = (EditText) rootView.findViewById(R.id.mod6_606_edittext_C6_P606);
        c6_p607_EditText = (EditText) rootView.findViewById(R.id.mod6_606_edittext_C6_P606);
        c6_p608_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_8);
        c6_p608_o_EditText = (EditText) rootView.findViewById(R.id.mod6_608_edittext_C6_P608_O);

        m6_p605_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p605);
        m6_p606_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p606);
        m6_p607_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p607);
        m6_p608_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p608);

        return rootView;
    }

}
