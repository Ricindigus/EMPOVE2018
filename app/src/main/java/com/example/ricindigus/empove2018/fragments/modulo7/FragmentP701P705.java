package com.example.ricindigus.empove2018.fragments.modulo7;


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
public class FragmentP701P705 extends Fragment {

    RadioGroup c7_p701_RadioGroup;
    CheckBox c7_p702_1_Checkbox, c7_p702_2_Checkbox, c7_p702_3_Checkbox , c7_p702_4_Checkbox, c7_p702_5_Checkbox,
            c7_p702_6_Checkbox, c7_p702_7_Checkbox, c7_p702_8_Checkbox, c7_p702_9_Checkbox, c7_p702_10_Checkbox;
    EditText c7_p702_o_EditText;
    RadioGroup c7_p703_RadioGroup;
    CheckBox c7_p704_1_Checkbox, c7_p704_2_Checkbox, c7_p704_3_Checkbox , c7_p704_4_Checkbox, c7_p704_5_Checkbox,
            c7_p704_6_Checkbox;
    EditText c7_p704_o_EditText;
    CheckBox c7_p705_1_Checkbox, c7_p705_2_Checkbox, c7_p705_3_Checkbox , c7_p705_4_Checkbox, c7_p705_5_Checkbox,
            c7_p705_6_Checkbox, c7_p705_7_Checkbox;
    EditText c7_p705_o_EditText;

    public FragmentP701P705() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p701_p705, container, false);

        c7_p701_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod7_701_radiogroup_C7_P701);

        c7_p702_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_1);
        c7_p702_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_2);
        c7_p702_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_3);
        c7_p702_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_4);
        c7_p702_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_5);
        c7_p702_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_6);
        c7_p702_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_7);
        c7_p702_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_8);
        c7_p702_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_9);
        c7_p702_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_10);
        c7_p702_o_EditText = (EditText) rootView.findViewById(R.id.mod7_702_edittext_C7_P702_O);

        c7_p703_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod7_703_radiogroup_C7_P703);

        c7_p704_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_1);
        c7_p704_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_2);
        c7_p704_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_3);
        c7_p704_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_4);
        c7_p704_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_5);
        c7_p704_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_6);
        c7_p704_o_EditText = (EditText) rootView.findViewById(R.id.mod7_704_edittext_C7_P704_O);

        c7_p705_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_1);
        c7_p705_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_2);
        c7_p705_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_3);
        c7_p705_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_4);
        c7_p705_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_5);
        c7_p705_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_6);
        c7_p705_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_7);
        c7_p705_o_EditText = (EditText) rootView.findViewById(R.id.mod7_705_edittext_C7_P705_O);

        return rootView;
    }

}
