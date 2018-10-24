package com.example.ricindigus.empove2018.fragments.modulo1;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP101P107 extends FragmentPagina {

    String idHogar;
    String idVivienda;
    Context context;


    RadioGroup c1_p101_RadioGroup, c1_p102_RadioGroup, c1_p103_RadioGroup, c1_p104_RadioGroup;
    EditText c1_p101_o_EditText, c1_p102_o_EditText, c1_p103_o_EditText, c1_p104_o_EditText;
    EditText c1_p105_EditText,c1_p106_EditText,c1_p107_EditText;

    LinearLayout m1_p101_linearlayout, m1_p102_linearlayout, m1_p103_linearlayout,
            m1_p104_linearlayout, m1_p105_linearlayout, m1_p106_linearlayout, m1_p107_linearlayout;

    public FragmentP101P107() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP101P107(String idHogar, String idVivienda, Context context) {
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p101_p107, container, false);
        c1_p101_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_101_radiogroup_C1_P101);
        c1_p101_o_EditText = (EditText) rootView.findViewById(R.id.mod1_101_edittext_C1_P101_O);
        c1_p102_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_102_radiogroup_C1_P102);
        c1_p102_o_EditText = (EditText) rootView.findViewById(R.id.mod1_102_edittext_C1_P102_O);
        c1_p103_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_103_radiogroup_C1_P103);
        c1_p103_o_EditText = (EditText) rootView.findViewById(R.id.mod1_103_edittext_C1_P103_O);
        c1_p104_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_104_radiogroup_C1_P104);
        c1_p104_o_EditText = (EditText) rootView.findViewById(R.id.mod1_104_edittext_C1_P104_O);
        c1_p105_EditText = (EditText) rootView.findViewById(R.id.mod1_105_edittext_C1_P105);
        c1_p106_EditText = (EditText) rootView.findViewById(R.id.mod1_106_edittext_C1_P106);
        c1_p107_EditText = (EditText) rootView.findViewById(R.id.mod1_107_edittext_C1_P107);

        m1_p101_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p101);
        m1_p102_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p102);
        m1_p103_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p103);
        m1_p104_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p104);
        m1_p105_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p105);
        m1_p106_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p106);
        m1_p107_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p107);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c1_p101_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c1_p101_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c1_p101_o_EditText);
                    m1_p101_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c1_p102_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c1_p102_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c1_p102_o_EditText);
                    m1_p102_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c1_p103_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c1_p103_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c1_p103_o_EditText);
                    m1_p103_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c1_p104_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c1_p104_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c1_p104_o_EditText);
                    m1_p104_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c1_p105_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c1_p105_EditText);
                    m1_p105_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c1_p105_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c1_p106_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c1_p106_EditText);
                    m1_p106_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c1_p106_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c1_p107_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c1_p107_EditText);
                    m1_p107_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c1_p107_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        cargarDatos();
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {

    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo1;
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void mostrarTeclado(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}
