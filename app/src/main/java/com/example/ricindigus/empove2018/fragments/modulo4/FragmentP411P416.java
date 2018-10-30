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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP411P416 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;
    CheckBox c4_p411_1_CheckBox, c4_p411_2_CheckBox, c4_p411_3_CheckBox, c4_p411_4_CheckBox, c4_p411_5_CheckBox,
            c4_p411_6_CheckBox, c4_p411_7_CheckBox, c4_p411_8_CheckBox, c4_p411_9_CheckBox, c4_p411_10_CheckBox,
            c4_p411_11_CheckBox, c4_p411_12_CheckBox, c4_p411_13_CheckBox, c4_p411_14_CheckBox;
    EditText c4_p411_o_EditText;
    RadioGroup c4_p412_RadioGroup, c4_p413_RadioGroup, c4_p414_RadioGroup, c4_p415_RadioGroup;
    CheckBox c4_p416_1_CheckBox, c4_p416_2_CheckBox, c4_p416_3_CheckBox, c4_p416_4_CheckBox, c4_p416_5_CheckBox,
            c4_p416_6_CheckBox, c4_p416_7_CheckBox, c4_p416_8_CheckBox;
    EditText c4_p416_o_EditText;
    LinearLayout m4_p411_linearlayout, m4_p412_linearlayout, m4_p413_linearlayout, m4_p414_linearlayout,
            m4_p415_linearlayout, m4_p416_linearlayout;

    private int c4_p411_1;
    private int c4_p411_2;
    private int c4_p411_3;
    private int c4_p411_4;
    private int c4_p411_5;
    private int c4_p411_6;
    private int c4_p411_7;
    private int c4_p411_8;
    private int c4_p411_9;
    private int c4_p411_10;
    private int c4_p411_11;
    private int c4_p411_12;
    private int c4_p411_13;
    private int c4_p411_14;
    private String c4_p411_o;
    private int c4_p412;
    private int c4_p413;
    private int c4_p414;
    private int c4_p415;
    private int c4_p416_1;
    private int c4_p416_2;
    private int c4_p416_3;
    private int c4_p416_4;
    private int c4_p416_5;
    private int c4_p416_6;
    private int c4_p416_7;
    private int c4_p416_8;
    private String c4_p416_o;

    private int edad, sexo;

    @SuppressLint("ValidFragment")
    public FragmentP411P416(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idHogar = residente.getId_hogar();
        idVivienda = residente.getId_vivienda();
        idInformante = "";
        if(residente.getC2_p204()=="") sexo = -1; else sexo = Integer.parseInt(residente.getC2_p204());
        if(residente.getC2_p205_a()=="") edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
        data.close();
    }

    public FragmentP411P416() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p411_p416, container, false);
        c4_p411_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_1);
        c4_p411_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_2);
        c4_p411_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_3);
        c4_p411_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_4);
        c4_p411_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_5);
        c4_p411_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_6);
        c4_p411_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_7);
        c4_p411_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_8);
        c4_p411_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_9);
        c4_p411_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_10);
        c4_p411_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_11);
        c4_p411_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_12);
        c4_p411_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_13);
        c4_p411_14_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_411_checkbox_C4_P411_14);
        c4_p411_o_EditText = (EditText) rootView.findViewById(R.id.mod4_411_edittext_C4_P411_O);
        c4_p412_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_412_radiogroup_C4_P412);
        c4_p413_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_413_radiogroup_C4_P413);
        c4_p414_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_414_radiogroup_C4_P414);
        c4_p415_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_415_radiogroup_C4_P415);
        c4_p416_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_416_checkbox_C4_P416_1);
        c4_p416_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_416_checkbox_C4_P416_2);
        c4_p416_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_416_checkbox_C4_P416_3);
        c4_p416_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_416_checkbox_C4_P416_4);
        c4_p416_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_416_checkbox_C4_P416_5);
        c4_p416_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_416_checkbox_C4_P416_6);
        c4_p416_o_EditText = (EditText) rootView.findViewById(R.id.mod4_416_edittext_C4_P416_O);
        c4_p416_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_416_checkbox_C4_P416_7);
        c4_p416_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_416_checkbox_C4_P416_8);

        m4_p411_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p411);
        m4_p412_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p412);
        m4_p413_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p413);
        m4_p414_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p414);
        m4_p415_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p415);
        m4_p416_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p416);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c4_p411_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(100)});
        c4_p411_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c4_p411_o_EditText);
                    m4_p411_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c4_p411_13_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p411_o_EditText.setEnabled(true);
                    c4_p411_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c4_p411_o_EditText.setText("");
                    c4_p411_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c4_p411_o_EditText.setEnabled(false);
                }
            }
        });
        c4_p416_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(100)});
        c4_p416_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c4_p416_o_EditText);
                    m4_p416_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c4_p416_6_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p416_o_EditText.setEnabled(true);
                    c4_p416_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c4_p416_o_EditText.setText("");
                    c4_p416_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c4_p416_o_EditText.setEnabled(false);
                }
            }
        });
        c4_p416_7_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p416_1_CheckBox.setChecked(false);
                    c4_p416_1_CheckBox.setEnabled(false);
                    c4_p416_2_CheckBox.setChecked(false);
                    c4_p416_2_CheckBox.setEnabled(false);
                    c4_p416_3_CheckBox.setChecked(false);
                    c4_p416_3_CheckBox.setEnabled(false);
                    c4_p416_4_CheckBox.setChecked(false);
                    c4_p416_4_CheckBox.setEnabled(false);
                    c4_p416_5_CheckBox.setChecked(false);
                    c4_p416_5_CheckBox.setEnabled(false);
                    c4_p416_6_CheckBox.setChecked(false);
                    c4_p416_6_CheckBox.setEnabled(false);
                    c4_p416_8_CheckBox.setChecked(false);
                    c4_p416_8_CheckBox.setEnabled(false);
                    c4_p416_o_EditText.setText("");
                    c4_p416_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                }else{
                    c4_p416_1_CheckBox.setEnabled(true);
                    c4_p416_2_CheckBox.setEnabled(true);
                    c4_p416_3_CheckBox.setEnabled(true);
                    c4_p416_4_CheckBox.setEnabled(true);
                    c4_p416_5_CheckBox.setEnabled(true);
                    c4_p416_6_CheckBox.setEnabled(true);
                    c4_p416_8_CheckBox.setEnabled(true);
                }
            }
        });
        c4_p416_8_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p416_1_CheckBox.setChecked(false);
                    c4_p416_1_CheckBox.setEnabled(false);
                    c4_p416_2_CheckBox.setChecked(false);
                    c4_p416_2_CheckBox.setEnabled(false);
                    c4_p416_3_CheckBox.setChecked(false);
                    c4_p416_3_CheckBox.setEnabled(false);
                    c4_p416_4_CheckBox.setChecked(false);
                    c4_p416_4_CheckBox.setEnabled(false);
                    c4_p416_5_CheckBox.setChecked(false);
                    c4_p416_5_CheckBox.setEnabled(false);
                    c4_p416_6_CheckBox.setChecked(false);
                    c4_p416_6_CheckBox.setEnabled(false);
                    c4_p416_7_CheckBox.setChecked(false);
                    c4_p416_7_CheckBox.setEnabled(false);
                    c4_p416_o_EditText.setText("");
                    c4_p416_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                }else{
                    c4_p416_1_CheckBox.setEnabled(true);
                    c4_p416_2_CheckBox.setEnabled(true);
                    c4_p416_3_CheckBox.setEnabled(true);
                    c4_p416_4_CheckBox.setEnabled(true);
                    c4_p416_5_CheckBox.setEnabled(true);
                    c4_p416_6_CheckBox.setEnabled(true);
                    c4_p416_7_CheckBox.setEnabled(true);
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
        contentValues.put(SQLConstantes.modulo4_c4_p411_1,c4_p411_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_2,c4_p411_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_3,c4_p411_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_4,c4_p411_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_5,c4_p411_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_6,c4_p411_6+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_7,c4_p411_7+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_8,c4_p411_8+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_9,c4_p411_9+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_10,c4_p411_10+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_11,c4_p411_11+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_12,c4_p411_12+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_13,c4_p411_13+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_14,c4_p411_14+"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_o,c4_p411_o);
        contentValues.put(SQLConstantes.modulo4_c4_p412,c4_p412+"");
        contentValues.put(SQLConstantes.modulo4_c4_p413,c4_p413+"");
        contentValues.put(SQLConstantes.modulo4_c4_p414,c4_p414+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415,c4_p415+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_1,c4_p416_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_2,c4_p416_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_3,c4_p416_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_4,c4_p416_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_5,c4_p416_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_6,c4_p416_6+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_7,c4_p416_7+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_8,c4_p416_8+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_o,c4_p416_o);

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo4 modulo4 = new Modulo4();
            modulo4.setIdInformante(idInformante);
            modulo4.set_id(idEncuestado);
            modulo4.setIdVivienda(idVivienda);
            modulo4.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo4.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        if(c4_p411_1_CheckBox.isChecked()) c4_p411_1 = 1; else c4_p411_1 = 0;
        if(c4_p411_2_CheckBox.isChecked()) c4_p411_2 = 1; else c4_p411_2 = 0;
        if(c4_p411_3_CheckBox.isChecked()) c4_p411_3 = 1; else c4_p411_3 = 0;
        if(c4_p411_4_CheckBox.isChecked()) c4_p411_4 = 1; else c4_p411_4 = 0;
        if(c4_p411_5_CheckBox.isChecked()) c4_p411_5 = 1; else c4_p411_5 = 0;
        if(c4_p411_6_CheckBox.isChecked()) c4_p411_6 = 1; else c4_p411_6 = 0;
        if(c4_p411_7_CheckBox.isChecked()) c4_p411_7 = 1; else c4_p411_7 = 0;
        if(c4_p411_8_CheckBox.isChecked()) c4_p411_8 = 1; else c4_p411_8 = 0;
        if(c4_p411_9_CheckBox.isChecked()) c4_p411_9 = 1; else c4_p411_9 = 0;
        if(c4_p411_10_CheckBox.isChecked()) c4_p411_10 = 1; else c4_p411_10 = 0;
        if(c4_p411_11_CheckBox.isChecked()) c4_p411_11 = 1; else c4_p411_11 = 0;
        if(c4_p411_12_CheckBox.isChecked()) c4_p411_12 = 1; else c4_p411_12 = 0;
        if(c4_p411_13_CheckBox.isChecked()) c4_p411_13 = 1; else c4_p411_13 = 0;
        if(c4_p411_14_CheckBox.isChecked()) c4_p411_14 = 1; else c4_p411_14 = 0;
        c4_p411_o = c4_p411_o_EditText.getText().toString();
        c4_p412 = c4_p412_RadioGroup.indexOfChild(c4_p412_RadioGroup.findViewById(c4_p412_RadioGroup.getCheckedRadioButtonId()));
        c4_p413 = c4_p413_RadioGroup.indexOfChild(c4_p413_RadioGroup.findViewById(c4_p413_RadioGroup.getCheckedRadioButtonId()));
        c4_p414 = c4_p414_RadioGroup.indexOfChild(c4_p414_RadioGroup.findViewById(c4_p414_RadioGroup.getCheckedRadioButtonId()));
        c4_p415 = c4_p415_RadioGroup.indexOfChild(c4_p415_RadioGroup.findViewById(c4_p415_RadioGroup.getCheckedRadioButtonId()));
        if(c4_p416_1_CheckBox.isChecked()) c4_p416_1 = 1; else c4_p416_1 = 0;
        if(c4_p416_2_CheckBox.isChecked()) c4_p416_2 = 1; else c4_p416_2 = 0;
        if(c4_p416_3_CheckBox.isChecked()) c4_p416_3 = 1; else c4_p416_3 = 0;
        if(c4_p416_4_CheckBox.isChecked()) c4_p416_4 = 1; else c4_p416_4 = 0;
        if(c4_p416_5_CheckBox.isChecked()) c4_p416_5 = 1; else c4_p416_5 = 0;
        if(c4_p416_6_CheckBox.isChecked()) c4_p416_6 = 1; else c4_p416_6 = 0;
        if(c4_p416_7_CheckBox.isChecked()) c4_p416_7 = 1; else c4_p416_7 = 0;
        if(c4_p416_8_CheckBox.isChecked()) c4_p416_8 = 1; else c4_p416_8 = 0;
        c4_p416_o = c4_p416_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo4 modulo4 = data.getModulo4(idEncuestado);
            if(modulo4.getC4_p411_1().equals("0")) c4_p411_1_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_2().equals("0")) c4_p411_2_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_3().equals("0")) c4_p411_3_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_4().equals("0")) c4_p411_4_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_5().equals("0")) c4_p411_5_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_6().equals("0")) c4_p411_6_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_7().equals("0")) c4_p411_7_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_8().equals("0")) c4_p411_8_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_9().equals("0")) c4_p411_9_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_10().equals("0")) c4_p411_10_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_11().equals("0")) c4_p411_11_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_12().equals("0")) c4_p411_12_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_13().equals("0")) c4_p411_13_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_14().equals("0")) c4_p411_14_CheckBox.setChecked(false);
            if(modulo4.getC4_p411_1().equals("1")) c4_p411_1_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_2().equals("1")) c4_p411_2_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_3().equals("1")) c4_p411_3_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_4().equals("1")) c4_p411_4_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_5().equals("1")) c4_p411_5_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_6().equals("1")) c4_p411_6_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_7().equals("1")) c4_p411_7_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_8().equals("1")) c4_p411_8_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_9().equals("1")) c4_p411_9_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_10().equals("1")) c4_p411_10_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_11().equals("1")) c4_p411_11_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_12().equals("1")) c4_p411_12_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_13().equals("1")) c4_p411_13_CheckBox.setChecked(true);
            if(modulo4.getC4_p411_14().equals("1")) c4_p411_14_CheckBox.setChecked(true);
            c4_p411_o_EditText.setText(modulo4.getC4_p411_o());
            if(!(modulo4.getC4_p412().equals("-1") || modulo4.getC4_p412().equals("")))((RadioButton)c4_p412_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p412()))).setChecked(true);
            if(!(modulo4.getC4_p413().equals("-1") || modulo4.getC4_p413().equals("")))((RadioButton)c4_p413_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p413()))).setChecked(true);
            if(!(modulo4.getC4_p414().equals("-1") || modulo4.getC4_p414().equals("")))((RadioButton)c4_p414_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p414()))).setChecked(true);
            if(!(modulo4.getC4_p415().equals("-1") || modulo4.getC4_p415().equals("")))((RadioButton)c4_p415_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p415()))).setChecked(true);
            if(modulo4.getC4_p416_1().equals("0")) c4_p416_1_CheckBox.setChecked(false);
            if(modulo4.getC4_p416_2().equals("0")) c4_p416_2_CheckBox.setChecked(false);
            if(modulo4.getC4_p416_3().equals("0")) c4_p416_3_CheckBox.setChecked(false);
            if(modulo4.getC4_p416_4().equals("0")) c4_p416_4_CheckBox.setChecked(false);
            if(modulo4.getC4_p416_5().equals("0")) c4_p416_5_CheckBox.setChecked(false);
            if(modulo4.getC4_p416_6().equals("0")) c4_p416_6_CheckBox.setChecked(false);
            if(modulo4.getC4_p416_7().equals("0")) c4_p416_7_CheckBox.setChecked(false);
            if(modulo4.getC4_p416_8().equals("0")) c4_p416_8_CheckBox.setChecked(false);
            if(modulo4.getC4_p416_1().equals("1")) c4_p416_1_CheckBox.setChecked(true);
            if(modulo4.getC4_p416_2().equals("1")) c4_p416_2_CheckBox.setChecked(true);
            if(modulo4.getC4_p416_3().equals("1")) c4_p416_3_CheckBox.setChecked(true);
            if(modulo4.getC4_p416_4().equals("1")) c4_p416_4_CheckBox.setChecked(true);
            if(modulo4.getC4_p416_5().equals("1")) c4_p416_5_CheckBox.setChecked(true);
            if(modulo4.getC4_p416_6().equals("1")) c4_p416_6_CheckBox.setChecked(true);
            if(modulo4.getC4_p416_7().equals("1")) c4_p416_7_CheckBox.setChecked(true);
            if(modulo4.getC4_p416_8().equals("1")) c4_p416_8_CheckBox.setChecked(true);
            c4_p416_o_EditText.setText(modulo4.getC4_p416_o());
        }
        inicio();
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(m4_p411_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p411_1==0 && c4_p411_2==0 && c4_p411_3==0 && c4_p411_4==0 && c4_p411_5==0 &&
                    c4_p411_6==0 && c4_p411_7==0 && c4_p411_8==0 && c4_p411_9==0 && c4_p411_10==0 &&
                    c4_p411_11==0 && c4_p411_12==0 && c4_p411_13==0 && c4_p411_14==0){
                mostrarMensaje("PREGUNTA 411: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p411_13==1){
                if(c4_p411_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 411 - OPCION 13: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c4_p412<0 && m4_p412_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 412: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p413<0 && m4_p413_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 413: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p414<0 && m4_p414_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 414: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p415<0 && m4_p415_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 415: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(m4_p416_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p416_1==0 && c4_p416_2==0 && c4_p416_3==0 && c4_p416_4==0 && c4_p416_5==0 &&
                    c4_p416_6==0 && c4_p416_7==0 && c4_p416_8==0){
                mostrarMensaje("PREGUNTA 416: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p416_6==1){
                if(c4_p416_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 416 - OPCION 6: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(m4_p416_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p416_1<0){
                mostrarMensaje("PREGUNTA 416-1: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_2<0){
                mostrarMensaje("PREGUNTA 416-2: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_3<0){
                mostrarMensaje("PREGUNTA 416-3: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_4<0){
                mostrarMensaje("PREGUNTA 416-4: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_5<0){
                mostrarMensaje("PREGUNTA 416-5: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_6<0){
                mostrarMensaje("PREGUNTA 416-6: DEBE SELECCIONAR UNA OPCION");
                return false;
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

    public void limpiar_p411(){
        c4_p411_1_CheckBox.setChecked(false);
        c4_p411_2_CheckBox.setChecked(false);
        c4_p411_3_CheckBox.setChecked(false);
        c4_p411_4_CheckBox.setChecked(false);
        c4_p411_5_CheckBox.setChecked(false);
        c4_p411_6_CheckBox.setChecked(false);
        c4_p411_7_CheckBox.setChecked(false);
        c4_p411_8_CheckBox.setChecked(false);
        c4_p411_9_CheckBox.setChecked(false);
        c4_p411_10_CheckBox.setChecked(false);
        c4_p411_11_CheckBox.setChecked(false);
        c4_p411_12_CheckBox.setChecked(false);
        c4_p411_13_CheckBox.setChecked(false);
        c4_p411_14_CheckBox.setChecked(false);
        c4_p411_o_EditText.setText("");
    }

    public void limpiar_p412(){
        c4_p412_RadioGroup.clearCheck();
    }

    public void limpiar_p413(){
        c4_p413_RadioGroup.clearCheck();
    }

    public void limpiar_p414(){
        c4_p414_RadioGroup.clearCheck();
    }

    public void limpiar_p415(){
        c4_p415_RadioGroup.clearCheck();
    }
    public void limpiar_p416(){
        c4_p416_1_CheckBox.setChecked(false);
        c4_p416_2_CheckBox.setChecked(false);
        c4_p416_3_CheckBox.setChecked(false);
        c4_p416_4_CheckBox.setChecked(false);
        c4_p416_5_CheckBox.setChecked(false);
        c4_p416_6_CheckBox.setChecked(false);
        c4_p416_7_CheckBox.setChecked(false);
        c4_p416_8_CheckBox.setChecked(false);
        c4_p416_o_EditText.setText("");
    }    

    public void inicio(){
        if(edad>=0 && edad<=17){
            m4_p411_linearlayout.setVisibility(View.VISIBLE);
        }else{
            limpiar_p411();
            m4_p411_linearlayout.setVisibility(View.GONE);
        }
        if((edad>=12 && edad<=49) && sexo==1){
            m4_p412_linearlayout.setVisibility(View.VISIBLE);
            int pos = c4_p412_RadioGroup.indexOfChild(c4_p412_RadioGroup.findViewById(c4_p412_RadioGroup.getCheckedRadioButtonId()));
            if(pos<1) m4_p413_linearlayout.setVisibility(View.VISIBLE);
            m4_p414_linearlayout.setVisibility(View.VISIBLE);
            m4_p415_linearlayout.setVisibility(View.VISIBLE);
        }else{
            limpiar_p412(); limpiar_p413(); limpiar_p414(); limpiar_p415();
            m4_p412_linearlayout.setVisibility(View.GONE);
            m4_p413_linearlayout.setVisibility(View.GONE);
            m4_p414_linearlayout.setVisibility(View.GONE);
            m4_p415_linearlayout.setVisibility(View.GONE);
        }
        if(edad>=15){
            m4_p416_linearlayout.setVisibility(View.VISIBLE);
        }else{
            limpiar_p416();
            m4_p416_linearlayout.setVisibility(View.GONE);
        }
    }
}
