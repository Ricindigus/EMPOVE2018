package com.example.ricindigus.empove2018.fragments.modulo5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP506P507 extends Fragment {

    RadioGroup c5_p506_1_RadioGroup, c5_p506_2_RadioGroup, c5_p506_3_RadioGroup, c5_p506_4_RadioGroup;



    public FragmentP506P507() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rooView = inflater.inflate(R.layout.fragment_p506_p507, container, false);
        c5_p506_1_RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod5_506_radiogroup_C5_P506_1);
        c5_p506_4_RadioGroup = (RadioGroup) rooView.findViewById(R.id.mod5_506_sp1_radiogroup_C5_P506_4);


        return rooView;

    }

}
