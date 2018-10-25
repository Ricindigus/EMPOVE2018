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
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP405P407 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    CheckBox c4_p405_1_CheckBox, c4_p405_2_CheckBox, c4_p405_3_CheckBox, c4_p405_4_CheckBox, c4_p405_5_CheckBox,
            c4_p405_6_CheckBox, c4_p405_7_CheckBox;
    CheckBox c4_p406_1_CheckBox, c4_p406_2_CheckBox, c4_p406_3_CheckBox, c4_p406_4_CheckBox, c4_p406_5_CheckBox,
            c4_p406_6_CheckBox, c4_p406_7_CheckBox, c4_p406_8_CheckBox;
    EditText c4_p406_o_EditText;
    CheckBox c4_p407_1_CheckBox, c4_p407_2_CheckBox, c4_p407_3_CheckBox, c4_p407_4_CheckBox, c4_p407_5_CheckBox,
            c4_p407_6_CheckBox, c4_p407_7_CheckBox, c4_p407_8_CheckBox, c4_p407_9_CheckBox, c4_p407_10_CheckBox,
            c4_p407_11_CheckBox, c4_p407_12_CheckBox, c4_p407_13_CheckBox;
    EditText c4_p407_o_EditText;
    LinearLayout m4_p405_linearlayout, m4_p406_linearlayout, m4_p407_linearlayout;

    private int c4_p405_1;
    private int c4_p405_2;
    private int c4_p405_3;
    private int c4_p405_4;
    private int c4_p405_5;
    private int c4_p405_6;
    private int c4_p405_7;
    private int c4_p406_1;
    private int c4_p406_2;
    private int c4_p406_3;
    private int c4_p406_4;
    private int c4_p406_5;
    private int c4_p406_6;
    private int c4_p406_7;
    private int c4_p406_8;
    private String c4_p406_o;
    private int c4_p407_1;
    private int c4_p407_2;
    private int c4_p407_3;
    private int c4_p407_4;
    private int c4_p407_5;
    private int c4_p407_6;
    private int c4_p407_7;
    private int c4_p407_8;
    private int c4_p407_9;
    private int c4_p407_10;
    private int c4_p407_11;
    private int c4_p407_12;
    private int c4_p407_13;
    private String c4_p407_o;

    @SuppressLint("ValidFragment")
    public FragmentP405P407(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idHogar = residente.getId_hogar();
        idVivienda = residente.getId_vivienda();
        idInformante = "";
        data.close();
    }

    public FragmentP405P407() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p405_p407, container, false);
        c4_p405_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_1);
        c4_p405_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_2);
        c4_p405_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_3);
        c4_p405_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_4);
        c4_p405_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_5);
        c4_p405_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_6);
        c4_p405_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_405_checkbox_C4_P405_7);

        c4_p406_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_1);
        c4_p406_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_2);
        c4_p406_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_3);
        c4_p406_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_4);
        c4_p406_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_5);
        c4_p406_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_6);
        c4_p406_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_checkbox_C4_P406_7);
        c4_p406_o_EditText = (EditText) rootView.findViewById(R.id.mod4_406_edittext_C4_P406_O);
        c4_p406_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_406_ck8);

        c4_p407_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_checkbox_C4_P407_1);
        c4_p407_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_2);
        c4_p407_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_3);
        c4_p407_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_4);
        c4_p407_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_5);
        c4_p407_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_6);
        c4_p407_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_7);
        c4_p407_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_8);
        c4_p407_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_9);
        c4_p407_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_10);
        c4_p407_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_11);
        c4_p407_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_12);
        c4_p407_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_407_C4_P407_13);
        c4_p407_o_EditText = (EditText) rootView.findViewById(R.id.mod4_407_edittext_C4_P407_O);

        m4_p405_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p405);
        m4_p406_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p406);
        m4_p407_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p407);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c4_p406_7_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p406_o_EditText.setEnabled(true);
                    c4_p406_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c4_p406_o_EditText.setText("");
                    c4_p406_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c4_p406_o_EditText.setEnabled(false);
                }
            }
        });
        c4_p406_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c4_p406_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c4_p406_o_EditText);
                    m4_p406_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c4_p406_8_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p406_1_CheckBox.setChecked(false);
                    c4_p406_1_CheckBox.setEnabled(false);
                    c4_p406_2_CheckBox.setChecked(false);
                    c4_p406_2_CheckBox.setEnabled(false);
                    c4_p406_3_CheckBox.setChecked(false);
                    c4_p406_3_CheckBox.setEnabled(false);
                    c4_p406_4_CheckBox.setChecked(false);
                    c4_p406_4_CheckBox.setEnabled(false);
                    c4_p406_5_CheckBox.setChecked(false);
                    c4_p406_5_CheckBox.setEnabled(false);
                    c4_p406_6_CheckBox.setChecked(false);
                    c4_p406_6_CheckBox.setEnabled(false);
                    c4_p406_7_CheckBox.setChecked(false);
                    c4_p406_7_CheckBox.setEnabled(false);
                    c4_p406_o_EditText.setText("");
                    c4_p406_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                }else{
                    c4_p406_1_CheckBox.setEnabled(true);
                    c4_p406_2_CheckBox.setEnabled(true);
                    c4_p406_3_CheckBox.setEnabled(true);
                    c4_p406_4_CheckBox.setEnabled(true);
                    c4_p406_5_CheckBox.setEnabled(true);
                    c4_p406_6_CheckBox.setEnabled(true);
                    c4_p406_7_CheckBox.setEnabled(true);                }
            }
        });
        c4_p407_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c4_p407_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c4_p407_o_EditText);
                    m4_p407_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c4_p407_13_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p407_o_EditText.setEnabled(true);
                    c4_p407_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c4_p407_o_EditText.setText("");
                    c4_p407_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c4_p407_o_EditText.setEnabled(false);
                }
            }
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo4_c4_p405_1,c4_p405_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p405_2,c4_p405_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p405_3,c4_p405_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p405_4,c4_p405_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p405_5,c4_p405_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p405_6,c4_p405_6+"");
        contentValues.put(SQLConstantes.modulo4_c4_p405_7,c4_p405_7+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_1,c4_p406_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_2,c4_p406_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_3,c4_p406_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_4,c4_p406_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_5,c4_p406_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_6,c4_p406_6+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_7,c4_p406_7+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_8,c4_p406_8+"");
        contentValues.put(SQLConstantes.modulo4_c4_p406_o,c4_p406_o);
        contentValues.put(SQLConstantes.modulo4_c4_p407_1,c4_p407_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_2,c4_p407_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_3,c4_p407_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_4,c4_p407_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_5,c4_p407_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_6,c4_p407_6+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_7,c4_p407_7+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_8,c4_p407_8+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_9,c4_p407_9+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_10,c4_p407_10+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_11,c4_p407_11+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_12,c4_p407_12+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_13,c4_p407_13+"");
        contentValues.put(SQLConstantes.modulo4_c4_p407_o,c4_p407_o);

        if(data.existeElemento(getNombreTabla(),idEncuestado)){
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        }else{
            Modulo4 modulo4 = new Modulo4();
            modulo4.setIdInformante(idInformante);
            modulo4.set_id(idEncuestado);
            modulo4.setIdVivienda(idVivienda);
            modulo4.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo4.toValues());
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        if(c4_p405_1_CheckBox.isChecked()) c4_p405_1 = 1; else c4_p405_1 = 0;
        if(c4_p405_2_CheckBox.isChecked()) c4_p405_2 = 1; else c4_p405_2 = 0;
        if(c4_p405_3_CheckBox.isChecked()) c4_p405_3 = 1; else c4_p405_3 = 0;
        if(c4_p405_4_CheckBox.isChecked()) c4_p405_4 = 1; else c4_p405_4 = 0;
        if(c4_p405_5_CheckBox.isChecked()) c4_p405_5 = 1; else c4_p405_5 = 0;
        if(c4_p405_6_CheckBox.isChecked()) c4_p405_6 = 1; else c4_p405_6 = 0;
        if(c4_p405_7_CheckBox.isChecked()) c4_p405_7 = 1; else c4_p405_7 = 0;
        if(c4_p406_1_CheckBox.isChecked()) c4_p406_1 = 1; else c4_p406_1 = 0;
        if(c4_p406_2_CheckBox.isChecked()) c4_p406_2 = 1; else c4_p406_2 = 0;
        if(c4_p406_3_CheckBox.isChecked()) c4_p406_3 = 1; else c4_p406_3 = 0;
        if(c4_p406_4_CheckBox.isChecked()) c4_p406_4 = 1; else c4_p406_4 = 0;
        if(c4_p406_5_CheckBox.isChecked()) c4_p406_5 = 1; else c4_p406_5 = 0;
        if(c4_p406_6_CheckBox.isChecked()) c4_p406_6 = 1; else c4_p406_6 = 0;
        if(c4_p406_7_CheckBox.isChecked()) c4_p406_7 = 1; else c4_p406_7 = 0;
        if(c4_p406_8_CheckBox.isChecked()) c4_p406_8 = 1; else c4_p406_8 = 0;
        c4_p406_o = c4_p406_o_EditText.getText().toString();
        if(c4_p407_1_CheckBox.isChecked()) c4_p407_1 = 1; else c4_p407_1 = 0;
        if(c4_p407_2_CheckBox.isChecked()) c4_p407_2 = 1; else c4_p407_2 = 0;
        if(c4_p407_3_CheckBox.isChecked()) c4_p407_3 = 1; else c4_p407_3 = 0;
        if(c4_p407_4_CheckBox.isChecked()) c4_p407_4 = 1; else c4_p407_4 = 0;
        if(c4_p407_5_CheckBox.isChecked()) c4_p407_5 = 1; else c4_p407_5 = 0;
        if(c4_p407_6_CheckBox.isChecked()) c4_p407_6 = 1; else c4_p407_6 = 0;
        if(c4_p407_7_CheckBox.isChecked()) c4_p407_7 = 1; else c4_p407_7 = 0;
        if(c4_p407_8_CheckBox.isChecked()) c4_p407_8 = 1; else c4_p407_8 = 0;
        if(c4_p407_9_CheckBox.isChecked()) c4_p407_9 = 1; else c4_p407_9 = 0;
        if(c4_p407_10_CheckBox.isChecked()) c4_p407_10 = 1; else c4_p407_10 = 0;
        if(c4_p407_11_CheckBox.isChecked()) c4_p407_11 = 1; else c4_p407_11 = 0;
        if(c4_p407_12_CheckBox.isChecked()) c4_p407_12 = 1; else c4_p407_12 = 0;
        if(c4_p407_13_CheckBox.isChecked()) c4_p407_13 = 1; else c4_p407_13 = 0;
        c4_p407_o = c4_p407_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo4 modulo4 = data.getModulo4(idEncuestado);
            if(modulo4.getC4_p405_1().equals("0")) c4_p405_1_CheckBox.setChecked(false);
            if(modulo4.getC4_p405_2().equals("0")) c4_p405_2_CheckBox.setChecked(false);
            if(modulo4.getC4_p405_3().equals("0")) c4_p405_3_CheckBox.setChecked(false);
            if(modulo4.getC4_p405_4().equals("0")) c4_p405_4_CheckBox.setChecked(false);
            if(modulo4.getC4_p405_5().equals("0")) c4_p405_5_CheckBox.setChecked(false);
            if(modulo4.getC4_p405_6().equals("0")) c4_p405_6_CheckBox.setChecked(false);
            if(modulo4.getC4_p405_7().equals("0")) c4_p405_7_CheckBox.setChecked(false);
            if(modulo4.getC4_p406_1().equals("0")) c4_p406_1_CheckBox.setChecked(false);
            if(modulo4.getC4_p406_2().equals("0")) c4_p406_2_CheckBox.setChecked(false);
            if(modulo4.getC4_p406_3().equals("0")) c4_p406_3_CheckBox.setChecked(false);
            if(modulo4.getC4_p406_4().equals("0")) c4_p406_4_CheckBox.setChecked(false);
            if(modulo4.getC4_p406_5().equals("0")) c4_p406_5_CheckBox.setChecked(false);
            if(modulo4.getC4_p406_6().equals("0")) c4_p406_6_CheckBox.setChecked(false);
            if(modulo4.getC4_p406_7().equals("0")) c4_p406_7_CheckBox.setChecked(false);
            if(modulo4.getC4_p406_8().equals("0")) c4_p406_8_CheckBox.setChecked(false);
            if(modulo4.getC4_p405_1().equals("1")) c4_p405_1_CheckBox.setChecked(true);
            if(modulo4.getC4_p405_2().equals("1")) c4_p405_2_CheckBox.setChecked(true);
            if(modulo4.getC4_p405_3().equals("1")) c4_p405_3_CheckBox.setChecked(true);
            if(modulo4.getC4_p405_4().equals("1")) c4_p405_4_CheckBox.setChecked(true);
            if(modulo4.getC4_p405_5().equals("1")) c4_p405_5_CheckBox.setChecked(true);
            if(modulo4.getC4_p405_6().equals("1")) c4_p405_6_CheckBox.setChecked(true);
            if(modulo4.getC4_p405_7().equals("1")) c4_p405_7_CheckBox.setChecked(true);
            if(modulo4.getC4_p406_1().equals("1")) c4_p406_1_CheckBox.setChecked(true);
            if(modulo4.getC4_p406_2().equals("1")) c4_p406_2_CheckBox.setChecked(true);
            if(modulo4.getC4_p406_3().equals("1")) c4_p406_3_CheckBox.setChecked(true);
            if(modulo4.getC4_p406_4().equals("1")) c4_p406_4_CheckBox.setChecked(true);
            if(modulo4.getC4_p406_5().equals("1")) c4_p406_5_CheckBox.setChecked(true);
            if(modulo4.getC4_p406_6().equals("1")) c4_p406_6_CheckBox.setChecked(true);
            if(modulo4.getC4_p406_7().equals("1")) c4_p406_7_CheckBox.setChecked(true);
            if(modulo4.getC4_p406_8().equals("1")) c4_p406_8_CheckBox.setChecked(true);
            c4_p406_o_EditText.setText(modulo4.getC4_p406_o());
            if(modulo4.getC4_p407_1().equals("0")) c4_p407_1_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_2().equals("0")) c4_p407_2_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_3().equals("0")) c4_p407_3_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_4().equals("0")) c4_p407_4_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_5().equals("0")) c4_p407_5_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_6().equals("0")) c4_p407_6_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_7().equals("0")) c4_p407_7_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_8().equals("0")) c4_p407_8_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_9().equals("0")) c4_p407_9_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_10().equals("0")) c4_p407_10_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_11().equals("0")) c4_p407_11_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_12().equals("0")) c4_p407_12_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_13().equals("0")) c4_p407_13_CheckBox.setChecked(false);
            if(modulo4.getC4_p407_1().equals("1")) c4_p407_1_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_2().equals("1")) c4_p407_2_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_3().equals("1")) c4_p407_3_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_4().equals("1")) c4_p407_4_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_5().equals("1")) c4_p407_5_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_6().equals("1")) c4_p407_6_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_7().equals("1")) c4_p407_7_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_8().equals("1")) c4_p407_8_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_9().equals("1")) c4_p407_9_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_10().equals("1")) c4_p407_10_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_11().equals("1")) c4_p407_11_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_12().equals("1")) c4_p407_12_CheckBox.setChecked(true);
            if(modulo4.getC4_p407_13().equals("1")) c4_p407_13_CheckBox.setChecked(true);
            c4_p407_o_EditText.setText(modulo4.getC4_p407_o());
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(c4_p405_1==0 && c4_p405_2==0 && c4_p405_3==0 && c4_p405_4==0 && c4_p405_5==0 &&
                c4_p405_6==0 && c4_p405_7==0 && m4_p405_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 405: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(m4_p406_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p406_1==0 && c4_p406_2==0 && c4_p406_3==0 && c4_p406_4==0 && c4_p406_5==0 &&
                    c4_p406_6==0 && c4_p406_7==0 && c4_p406_8==0){
                mostrarMensaje("PREGUNTA 406: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p406_7==1){
                if(c4_p406_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 406 - OPCION 7: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(m4_p407_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p407_1==0 && c4_p407_2==0 && c4_p407_3==0 && c4_p407_4==0 && c4_p407_5==0 &&
                    c4_p407_6==0 && c4_p407_7==0 && c4_p407_8==0 && c4_p407_9==0 && c4_p407_10==0 &&
                    c4_p407_11==0 && c4_p407_12==0 && c4_p407_13==0){
                mostrarMensaje("PREGUNTA 407: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p407_13==1){
                if(c4_p407_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 407 - OPCION 13: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
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
