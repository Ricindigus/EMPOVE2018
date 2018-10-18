package com.example.ricindigus.empove2018.fragments.modulo5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP506P507 extends Fragment {

    RadioGroup c5_p506_1_RadioGroup, c5_p506_4_1_RadioGroup, c5_p506_4_2_RadioGroup, c5_p506_4_3_RadioGroup,
                c5_p506_4_4_RadioGroup, c5_p506_4_5_RadioGroup, c5_p506_4_6_RadioGroup ;
    EditText c5_p506_2_1_EditText, c5_p506_3_EditText, c5_p506_2_3_EditText, c5_p506_2_4_EditText, c5_p506_2_5_EditText, c5_p506_2_6_EditText;
    RadioGroup c5_p507_RadioGroup;
    Spinner c5_p507_dist_Spinner,  c5_p507_prov_Spinner, c5_p507_dep_Spinner;
    LinearLayout m5_p506_linearlayout, m5_p507_linearlayout;

    public FragmentP506P507() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p506_p507, container, false);
        c5_p506_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_radiogroup_C5_P506_1);
        c5_p506_2_1_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp1_textview_C5_P506_2);
        c5_p506_3_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp2_textview_C5_P506_3);
        c5_p506_2_3_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp3_textview_C5_P506_2);
        c5_p506_2_4_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp4_textview_C5_P506_2);
        c5_p506_2_5_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp5_textview_C5_P506_2);
        c5_p506_2_6_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp6_textview_C5_P506_2);
        c5_p506_4_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp1_radiogroup_C5_P506_4);
        c5_p506_4_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp2_radiogroup_C5_P506_4);
        c5_p506_4_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp3_radiogroup_C5_P506_4);
        c5_p506_4_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp4_radiogroup_C5_P506_4);
        c5_p506_4_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp5_radiogroup_C5_P506_4);
        c5_p506_4_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp6_radiogroup_C5_P506_4);
        c5_p507_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_507_radiogroup_C5_P507);
        c5_p507_dist_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_DIST);
        c5_p507_prov_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_PROV);
        c5_p507_dep_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_DEP);

        m5_p506_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p506);
        m5_p507_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p507);

        return rootView;

    }

}
