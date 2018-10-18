package com.example.ricindigus.empove2018.fragments.modulo6;


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
public class FragmentP613P618 extends Fragment {

    RadioGroup c6_p613_RadioGroup;
    EditText c6_p614_mon_EditText, c6_p614_esp_EditText, c6_p615_mon_EditText, c6_p615_esp_EditText,
            c6_p616_mon_EditText, c6_p616_esp_EditText;
    RadioGroup c6_p617_RadioGroup;
    CheckBox c6_p618_1_Checkbox, c6_p618_2_Checkbox, c6_p618_3_Checkbox , c6_p618_4_Checkbox, c6_p618_5_Checkbox,
            c6_p618_6_Checkbox;
    EditText c6_p618_o_EditText;
    LinearLayout m6_p613_linearlayout, m6_p614_linearlayout, m6_p615_linearlayout, m6_p616_linearlayout,
            m6_p617_linearlayout, m6_p618_linearlayout;

    public FragmentP613P618() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p613_p618, container, false);

        c6_p613_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_613_radiogroup_C6_P613);
        c6_p614_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_614_edittext_C6_P614_MON);
        c6_p614_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_614_edittext_C6_P614_ESP);
        c6_p615_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_615_edittext_C6_P615_MON);
        c6_p615_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_615_edittext_C6_P615_ESP);
        c6_p616_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_616_edittext_C6_P616_MON);
        c6_p616_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_616_edittext_C6_P616_ESP);
        c6_p617_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_617_radiogroup_C6_P617);

        c6_p618_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_1);
        c6_p618_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_2);
        c6_p618_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_3);
        c6_p618_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_4);
        c6_p618_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_5);
        c6_p618_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_6);
        c6_p618_o_EditText = (EditText) rootView.findViewById(R.id.mod6_618_edittext_C6_P618_O);

        m6_p613_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p613);
        m6_p614_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p614);
        m6_p615_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p615);
        m6_p616_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p616);
        m6_p617_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p617);
        m6_p618_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p618);

        return rootView;
    }

}
