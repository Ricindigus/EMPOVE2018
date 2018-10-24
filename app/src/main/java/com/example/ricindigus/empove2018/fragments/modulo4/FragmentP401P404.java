package com.example.ricindigus.empove2018.fragments.modulo4;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP401P404 extends FragmentPagina {
    String idVivienda, idHogar, idPersona, idInformante;
    Context context;

    CheckBox c4_p401_1_CheckBox, c4_p401_2_CheckBox, c4_p401_3_CheckBox, c4_p401_4_CheckBox, c4_p401_5_CheckBox ;
    EditText c4_p401_o_EditText;
    RadioGroup c4_p402_RadioGroup;
    CheckBox c4_p403_1_CheckBox, c4_p403_2_CheckBox, c4_p403_3_CheckBox, c4_p403_4_CheckBox, c4_p403_5_CheckBox,
            c4_p403_6_CheckBox, c4_p403_7_CheckBox, c4_p403_8_CheckBox, c4_p403_9_CheckBox, c4_p403_10_CheckBox,
            c4_p403_11_CheckBox, c4_p403_12_CheckBox, c4_p403_13_CheckBox, c4_p403_14_CheckBox;
    EditText c4_p403_o_EditText;
    RadioGroup c4_p404_RadioGroup;
    LinearLayout m4_p401_linearlayout, m4_p402_linearlayout, m4_p403_linearlayout, m4_p404_linearlayout;

    private int c4_p401_1;
    private int c4_p401_2;
    private int c4_p401_3;
    private int c4_p401_4;
    private int c4_p401_5;
    private String c4_p401_o;
    private int c4_p402;
    private int c4_p403_1;
    private int c4_p403_2;
    private int c4_p403_3;
    private int c4_p403_4;
    private int c4_p403_5;
    private int c4_p403_6;
    private int c4_p403_7;
    private int c4_p403_8;
    private int c4_p403_9;
    private int c4_p403_10;
    private int c4_p403_11;
    private int c4_p403_12;
    private int c4_p403_13;
    private int c4_p403_14;
    private String c4_p403_o;
    private int c4_p404;

    @SuppressLint("ValidFragment")
    public FragmentP401P404(String idVivienda, String idHogar, String idPersona, String idInformante, Context context) {
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idPersona = idPersona;
        this.idInformante = idInformante;
        this.context = context;
    }

    public FragmentP401P404() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p401_p404, container, false);

        c4_p401_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_1);
        c4_p401_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_2);
        c4_p401_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_3);
        c4_p401_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_4);
        c4_p401_o_EditText = (EditText) rootView.findViewById(R.id.mod4_401_edtittext_C4_P401_O);
        c4_p401_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_401_checkbox_C4_P401_5);

        c4_p402_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_402_radiogroup_C4_P402);

        c4_p403_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_1);
        c4_p403_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_2);
        c4_p403_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_3);
        c4_p403_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_4);
        c4_p403_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_5);
        c4_p403_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_6);
        c4_p403_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_7);
        c4_p403_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_8);
        c4_p403_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_9);
        c4_p403_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_10);
        c4_p403_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_11);
        c4_p403_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_12);
        c4_p403_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_13);
        c4_p403_14_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_403_checkbox_C4_P403_14);
        c4_p403_o_EditText = (EditText) rootView.findViewById(R.id.mod4_403_edittext_C4_P403_O);

        c4_p404_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_404_radiogroup_C4_P404);

        m4_p401_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p401);
        m4_p402_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p402);
        m4_p403_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p403);
        m4_p404_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p404);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);c4_p401_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c4_p401_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c4_p401_o_EditText);
                    m4_p401_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c4_p403_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c4_p403_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c4_p403_o_EditText);
                    m4_p403_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo4_c4_p401_1,c4_p401_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p401_2,c4_p401_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p401_3,c4_p401_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p401_4,c4_p401_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p401_5,c4_p401_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p401_o,c4_p401_o);
        contentValues.put(SQLConstantes.modulo4_c4_p402,c4_p402+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_1,c4_p403_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_2,c4_p403_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_3,c4_p403_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_4,c4_p403_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_5,c4_p403_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_6,c4_p403_6+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_7,c4_p403_7+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_8,c4_p403_8+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_9,c4_p403_9+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_10,c4_p403_10+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_11,c4_p403_11+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_12,c4_p403_12+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_13,c4_p403_13+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_14,c4_p403_14+"");
        contentValues.put(SQLConstantes.modulo4_c4_p403_o,c4_p403_o);
        contentValues.put(SQLConstantes.modulo4_c4_p404,c4_p404+"");

        if(data.existeElemento(getNombreTabla(),idPersona)){
            data.actualizarElemento(getNombreTabla(),contentValues,idPersona);
        }else{
            contentValues.put(SQLConstantes.modulo4_idVivienda,idVivienda+"");
            contentValues.put(SQLConstantes.modulo4_idHogar,idHogar+"");
            contentValues.put(SQLConstantes.modulo4_id,idPersona+"");
            contentValues.put(SQLConstantes.modulo4_idInformante,idInformante+"");
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        if(c4_p401_1_CheckBox.isChecked()) c4_p401_1 = 1; else c4_p401_1 = 0;
        if(c4_p401_2_CheckBox.isChecked()) c4_p401_2 = 1; else c4_p401_2 = 0;
        if(c4_p401_3_CheckBox.isChecked()) c4_p401_3 = 1; else c4_p401_3 = 0;
        if(c4_p401_4_CheckBox.isChecked()) c4_p401_4 = 1; else c4_p401_4 = 0;
        if(c4_p401_5_CheckBox.isChecked()) c4_p401_5 = 1; else c4_p401_5 = 0;
        c4_p401_o = c4_p401_o_EditText.getText().toString();
        c4_p402 = c4_p402_RadioGroup.indexOfChild(c4_p402_RadioGroup.findViewById(c4_p402_RadioGroup.getCheckedRadioButtonId()));
        if(c4_p403_1_CheckBox.isChecked()) c4_p403_1 = 1; else c4_p403_1 = 0;
        if(c4_p403_2_CheckBox.isChecked()) c4_p403_2 = 1; else c4_p403_2 = 0;
        if(c4_p403_3_CheckBox.isChecked()) c4_p403_3 = 1; else c4_p403_3 = 0;
        if(c4_p403_4_CheckBox.isChecked()) c4_p403_4 = 1; else c4_p403_4 = 0;
        if(c4_p403_5_CheckBox.isChecked()) c4_p403_5 = 1; else c4_p403_5 = 0;
        if(c4_p403_6_CheckBox.isChecked()) c4_p403_6 = 1; else c4_p403_6 = 0;
        if(c4_p403_7_CheckBox.isChecked()) c4_p403_7 = 1; else c4_p403_7 = 0;
        if(c4_p403_8_CheckBox.isChecked()) c4_p403_8 = 1; else c4_p403_8 = 0;
        if(c4_p403_9_CheckBox.isChecked()) c4_p403_9 = 1; else c4_p403_9 = 0;
        if(c4_p403_10_CheckBox.isChecked()) c4_p403_10 = 1; else c4_p403_10 = 0;
        if(c4_p403_11_CheckBox.isChecked()) c4_p403_11 = 1; else c4_p403_11 = 0;
        if(c4_p403_12_CheckBox.isChecked()) c4_p403_12 = 1; else c4_p403_12 = 0;
        if(c4_p403_13_CheckBox.isChecked()) c4_p403_13 = 1; else c4_p403_13 = 0;
        if(c4_p403_14_CheckBox.isChecked()) c4_p403_14 = 1; else c4_p403_14 = 0;
        c4_p403_o = c4_p403_o_EditText.getText().toString();
        c4_p404 = c4_p404_RadioGroup.indexOfChild(c4_p404_RadioGroup.findViewById(c4_p404_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(m4_p401_linearlayout.getVisibility()==View.VISIBLE) {
            if (c4_p401_1 == 0 && c4_p401_2 == 0 && c4_p401_3 == 0 && c4_p401_4 == 0) {
                mostrarMensaje("PREGUNTA 401: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if (c4_p401_4 == 1) {
                if (c4_p401_o.trim().length() == 0) {
                    mostrarMensaje("PREGUNTA 401 - OPCION 4: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c4_p402<1 && m4_p402_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 402: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(m4_p403_linearlayout.getVisibility()==View.VISIBLE) {
            if (c4_p403_1 == 0 && c4_p403_2 == 0 && c4_p403_3 == 0 && c4_p403_4 == 0 && c4_p403_5 == 0 &&
                    c4_p403_6 == 0 && c4_p403_7 == 0 && c4_p403_8 == 0 && c4_p403_9 == 0 && c4_p403_10 == 0 &&
                    c4_p403_11 == 0 && c4_p403_12 == 0 && c4_p403_13 == 0 && c4_p403_14 == 0) {
                mostrarMensaje("PREGUNTA 403: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if (c4_p403_14 == 1) {
                if (c4_p403_o.trim().length() == 0) {
                    mostrarMensaje("PREGUNTA 403 - OPCION 14: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c4_p404<1 && m4_p404_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 404: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo4;
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
