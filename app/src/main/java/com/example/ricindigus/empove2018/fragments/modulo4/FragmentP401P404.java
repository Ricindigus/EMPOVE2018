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
public class FragmentP401P404 extends Fragment {

    CheckBox c4_p401_1CheckBox, c4_p401_2CheckBox, c4_p401_3CheckBox, c4_p401_4CheckBox, c4_p401_6CheckBox ;
    EditText c4_p401_5_oEditText;
    RadioGroup c4_p402RadioGroup;
    CheckBox c4_p403_1CheckBox, c4_p403_2CheckBox, c4_p403_3CheckBox, c4_p403_4CheckBox, c4_p403_5CheckBox,
            c4_p403_6CheckBox, c4_p403_7CheckBox, c4_p403_8CheckBox, c4_p403_9CheckBox, c4_p403_10CheckBox,
            c4_p403_11CheckBox, c4_p403_12CheckBox, c4_p403_13CheckBox, c4_p403_14CheckBox;
    EditText c4_p403_oEditText;
    RadioGroup c4_p404RadioGroup;
    LinearLayout m4_p401_linearlayout, m4_p402_linearlayout, m4_p403_linearlayout, m4_p404_linearlayout;

    public FragmentP401P404() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p401_p404, container, false);

        c4_p401_1CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_1);
        c4_p401_2CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_2);
        c4_p401_3CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_3);
        c4_p401_4CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_4);
        c4_p401_5_oEditText = (EditText) rootView.findViewById(R.id.mod4_401_edtittext_C4_P401_O);
        c4_p401_6CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_5);

        c4_p402RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_402_radiogroup_C4_P402);

        c4_p403_1CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_1);
        c4_p403_2CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_2);
        c4_p403_3CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_3);
        c4_p403_4CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_4);
        c4_p403_5CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_5);
        c4_p403_6CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_6);
        c4_p403_7CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_7);
        c4_p403_8CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_8);
        c4_p403_9CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_9);
        c4_p403_10CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_10);
        c4_p403_11CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_11);
        c4_p403_12CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_12);
        c4_p403_13CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_13);
        c4_p403_14CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_14);
        c4_p403_oEditText = (EditText) rootView.findViewById(R.id.mod4_403_edittext_C4_P403_O);

        c4_p404RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_404_radiogroup_C4_P404);

        m4_p401_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p401);
        m4_p402_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p402);
        m4_p403_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p403);
        m4_p404_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p404);

        return rootView;
    }

}
