package com.example.ricindigus.empove2018.fragments.modulo3;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricindigus.empove2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP310P313 extends Fragment {
    String idEcnuestado;
    Context contexto;

    public FragmentP310P313() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP310P313(String idEcnuestado, Context contexto) {
        this.idEcnuestado = idEcnuestado;
        this.contexto = contexto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_p310_p313, container, false);
    }

}
