package com.example.ricindigus.empove2018.fragments.modulo8;


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
public class FragmentP817P820 extends Fragment {

    RadioGroup c8_p817_RadioGroup, c8_p818_RadioGroup;
    CheckBox c8_p819_1_Checkbox, c8_p819_2_Checkbox, c8_p819_3_Checkbox , c8_p819_4_Checkbox, c8_p819_5_Checkbox,
            c8_p819_6_Checkbox, c8_p819_7_Checkbox, c8_p819_8_Checkbox, c8_p819_9_Checkbox, c8_p819_10_Checkbox,
            c8_p819_11_Checkbox, c8_p819_12_Checkbox, c8_p819_13_Checkbox, c8_p819_14_Checkbox;
    EditText c8_p819_o_EditText;
    CheckBox c8_p820_1_Checkbox, c8_p820_2_Checkbox, c8_p820_3_Checkbox , c8_p820_4_Checkbox, c8_p820_5_Checkbox,
            c8_p820_6_Checkbox, c8_p820_7_Checkbox, c8_p820_8_Checkbox, c8_p820_9_Checkbox, c8_p820_10_Checkbox,
            c8_p820_11_Checkbox;
    EditText c8_p820_o_EditText;
    LinearLayout m8_p817_linearlayout, m8_p818_linearlayout, m8_p819_linearlayout, m8_p820_linearlayout;

    public FragmentP817P820() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p817_p820, container, false);

        c8_p817_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_817_radiogroup_C8_P817);

        c8_p818_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_818_radiogroup_C8_P818);

        c8_p819_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_1);
        c8_p819_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_2);
        c8_p819_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_3);
        c8_p819_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_4);
        c8_p819_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_5);
        c8_p819_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_6);
        c8_p819_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_7);
        c8_p819_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_8);
        c8_p819_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_9);
        c8_p819_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_10);
        c8_p819_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_11);
        c8_p819_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_12);
        c8_p819_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_13);
        c8_p819_14_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_819_checkbox_C8_P819_14);
        c8_p819_o_EditText = (EditText) rootView.findViewById(R.id.mod8_819_edittext_C8_P819_O);

        c8_p820_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_1);
        c8_p820_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_2);
        c8_p820_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_3);
        c8_p820_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_4);
        c8_p820_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_5);
        c8_p820_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_6);
        c8_p820_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_7);
        c8_p820_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_8);
        c8_p820_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_9);
        c8_p820_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_10);
        c8_p820_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_820_checkbox_C8_P820_11);
        c8_p820_o_EditText = (EditText) rootView.findViewById(R.id.mod8_820_edittext_C8_P820_O);

        m8_p817_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p817);
        m8_p818_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p818);
        m8_p819_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p819);
        m8_p820_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p820);

        return rootView;
    }

}
