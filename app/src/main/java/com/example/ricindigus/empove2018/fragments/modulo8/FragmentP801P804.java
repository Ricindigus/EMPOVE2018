package com.example.ricindigus.empove2018.fragments.modulo8;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP801P804 extends Fragment {

    RadioGroup c8_p801_RadioGroup, c8_p802_RadioGroup, c8_p803_RadioGroup, c8_p804_RadioGroup;
    LinearLayout m8_p801_linearlayout, m8_p802_linearlayout, m8_p803_linearlayout, m8_p804_linearlayout;

    public FragmentP801P804() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p801_p804, container, false);

        c8_p801_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_801_radiogroup_C8_P801);
        c8_p802_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_802_radiogroup_C8_P802);
        c8_p803_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_803_radiogroup_C8_P803);
        c8_p804_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_804_radiogroup_C8_P804);

        m8_p801_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p801);
        m8_p802_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p802);
        m8_p803_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p803);
        m8_p804_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p804);

        return rootView;
    }

}
