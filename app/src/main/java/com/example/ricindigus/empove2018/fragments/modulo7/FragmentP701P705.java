package com.example.ricindigus.empove2018.fragments.modulo7;


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
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo7;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentP701P705 extends FragmentPagina {

    Context context;
    String idEncuestado;
    String idVivienda, idHogar, idInformante;

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
    LinearLayout m7_p701_linearlayout, m7_p702_linearlayout, m7_p703_linearlayout, m7_p704_linearlayout,
            m7_p705_linearlayout;
    Spinner informanteSpinner;

    private String c7_p701;
    private String c7_p702_1;
    private String c7_p702_2;
    private String c7_p702_3;
    private String c7_p702_4;
    private String c7_p702_5;
    private String c7_p702_6;
    private String c7_p702_7;
    private String c7_p702_8;
    private String c7_p702_9;
    private String c7_p702_10;
    private String c7_p702_o;
    private String c7_p703;
    private String c7_p704_1;
    private String c7_p704_2;
    private String c7_p704_3;
    private String c7_p704_4;
    private String c7_p704_5;
    private String c7_p704_6;
    private String c7_p704_o;
    private String c7_p705_1;
    private String c7_p705_2;
    private String c7_p705_3;
    private String c7_p705_4;
    private String c7_p705_5;
    private String c7_p705_6;
    private String c7_p705_7;
    private String c7_p705_o;

    @SuppressLint("ValidFragment")
    public FragmentP701P705( String idEncuestado, Context context) {
        this.context = context;
        this.idEncuestado = idEncuestado;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idVivienda = residente.getId_vivienda();
        idHogar = residente.getId_hogar();
        idInformante = "";
        data.close();

    }

    public FragmentP701P705(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p701_p705, container, false);

        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);
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

        m7_p701_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p701);
        m7_p702_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p702);
        m7_p703_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p703);
        m7_p704_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p704);
        m7_p705_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p705);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Data data =  new Data(context);
        data.open();
        ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(idHogar);
        data.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        informanteSpinner.setAdapter(adapter);

        controlarChecked(c7_p702_10_Checkbox,c7_p702_o_EditText);
        controlarChecked(c7_p704_6_Checkbox,c7_p704_o_EditText);
        controlarChecked(c7_p705_6_Checkbox,c7_p705_o_EditText);

        configurarEditText(c7_p702_o_EditText,m7_p702_linearlayout,1,30);
        configurarEditText(c7_p704_o_EditText,m7_p704_linearlayout,1,30);
        configurarEditText(c7_p705_o_EditText,m7_p705_linearlayout,1,30);

        c7_p701_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 1: m7_p702_linearlayout.setVisibility(View.VISIBLE);break;
                    case 2:
                        c7_p702_1_Checkbox.setChecked(false);
                        c7_p702_2_Checkbox.setChecked(false);
                        c7_p702_3_Checkbox.setChecked(false);
                        c7_p702_4_Checkbox.setChecked(false);
                        c7_p702_5_Checkbox.setChecked(false);
                        c7_p702_6_Checkbox.setChecked(false);
                        c7_p702_7_Checkbox.setChecked(false);
                        c7_p702_8_Checkbox.setChecked(false);
                        c7_p702_9_Checkbox.setChecked(false);
                        c7_p702_10_Checkbox.setChecked(false);
                        c7_p702_o_EditText.setText("");
                        m7_p702_linearlayout.setVisibility(View.GONE);
                        break;
                }
            }
        });

        c7_p703_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 1: m7_p704_linearlayout.setVisibility(View.VISIBLE);m7_p705_linearlayout.setVisibility(View.VISIBLE);break;
                    case 2:
                        c7_p704_1_Checkbox.setChecked(false);
                        c7_p704_2_Checkbox.setChecked(false);
                        c7_p704_3_Checkbox.setChecked(false);
                        c7_p704_4_Checkbox.setChecked(false);
                        c7_p704_5_Checkbox.setChecked(false);
                        c7_p704_6_Checkbox.setChecked(false);
                        c7_p705_1_Checkbox.setChecked(false);
                        c7_p705_2_Checkbox.setChecked(false);
                        c7_p705_3_Checkbox.setChecked(false);
                        c7_p705_4_Checkbox.setChecked(false);
                        c7_p705_5_Checkbox.setChecked(false);
                        c7_p705_6_Checkbox.setChecked(false);
                        c7_p705_7_Checkbox.setChecked(false);
                        c7_p704_o_EditText.setText("");
                        c7_p705_o_EditText.setText("");
                        m7_p704_linearlayout.setVisibility(View.GONE);
                        m7_p705_linearlayout.setVisibility(View.GONE);
                        break;
                }
            }
        });
        llenarVista();
        cargarDatos();
    }

    public void guardarDatos(){
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo7_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo7_c7_p701, c7_p701);
        contentValues.put(SQLConstantes.modulo7_c7_p702_1, c7_p702_1);
        contentValues.put(SQLConstantes.modulo7_c7_p702_2, c7_p702_2);
        contentValues.put(SQLConstantes.modulo7_c7_p702_3, c7_p702_3);
        contentValues.put(SQLConstantes.modulo7_c7_p702_4, c7_p702_4);
        contentValues.put(SQLConstantes.modulo7_c7_p702_5, c7_p702_5);
        contentValues.put(SQLConstantes.modulo7_c7_p702_6, c7_p702_6);
        contentValues.put(SQLConstantes.modulo7_c7_p702_7, c7_p702_7);
        contentValues.put(SQLConstantes.modulo7_c7_p702_8, c7_p702_8);
        contentValues.put(SQLConstantes.modulo7_c7_p702_9, c7_p702_9);
        contentValues.put(SQLConstantes.modulo7_c7_p702_10, c7_p702_10);
        contentValues.put(SQLConstantes.modulo7_c7_p702_o, c7_p702_o);
        contentValues.put(SQLConstantes.modulo7_c7_p703,c7_p703);
        contentValues.put(SQLConstantes.modulo7_c7_p704_1,c7_p704_1);
        contentValues.put(SQLConstantes.modulo7_c7_p704_2,c7_p704_2);
        contentValues.put(SQLConstantes.modulo7_c7_p704_3,c7_p704_3);
        contentValues.put(SQLConstantes.modulo7_c7_p704_4,c7_p704_4);
        contentValues.put(SQLConstantes.modulo7_c7_p704_5,c7_p704_5);
        contentValues.put(SQLConstantes.modulo7_c7_p704_6,c7_p704_6);
        contentValues.put(SQLConstantes.modulo7_c7_p704_o,c7_p704_o);
        contentValues.put(SQLConstantes.modulo7_c7_p705_1,c7_p705_1);
        contentValues.put(SQLConstantes.modulo7_c7_p705_2,c7_p705_2);
        contentValues.put(SQLConstantes.modulo7_c7_p705_3,c7_p705_3);
        contentValues.put(SQLConstantes.modulo7_c7_p705_4,c7_p705_4);
        contentValues.put(SQLConstantes.modulo7_c7_p705_5,c7_p705_5);
        contentValues.put(SQLConstantes.modulo7_c7_p705_6,c7_p705_6);
        contentValues.put(SQLConstantes.modulo7_c7_p705_7,c7_p705_7);
        contentValues.put(SQLConstantes.modulo7_c7_p705_o,c7_p705_o);

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo7 modulo7 = new Modulo7();
            modulo7.set_id(idEncuestado);
            modulo7.setIdVivienda(idVivienda);
            modulo7.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(), modulo7.toValues());
        }
        data.actualizarElemento(getNombreTabla(), contentValues, idEncuestado);
        data.close();
    }


    public void llenarVariables(){
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c7_p701 = c7_p701_RadioGroup.indexOfChild(c7_p701_RadioGroup.findViewById(c7_p701_RadioGroup.getCheckedRadioButtonId()))+"";
        if (c7_p702_1_Checkbox.isChecked()) c7_p702_1 = "1"; else c7_p702_1 = "0";
        if (c7_p702_2_Checkbox.isChecked()) c7_p702_2 = "1"; else c7_p702_2 = "0";
        if (c7_p702_3_Checkbox.isChecked()) c7_p702_3 = "1"; else c7_p702_3 = "0";
        if (c7_p702_4_Checkbox.isChecked()) c7_p702_4 = "1"; else c7_p702_4 = "0";
        if (c7_p702_5_Checkbox.isChecked()) c7_p702_5 = "1"; else c7_p702_5 = "0";
        if (c7_p702_6_Checkbox.isChecked()) c7_p702_6 = "1"; else c7_p702_6 = "0";
        if (c7_p702_7_Checkbox.isChecked()) c7_p702_7 = "1"; else c7_p702_7 = "0";
        if (c7_p702_8_Checkbox.isChecked()) c7_p702_8 = "1"; else c7_p702_8 = "0";
        if (c7_p702_9_Checkbox.isChecked()) c7_p702_9 = "1"; else c7_p702_9 = "0";
        if (c7_p702_10_Checkbox.isChecked()) c7_p702_10 ="1"; else c7_p702_10 = "0";
        c7_p702_o = c7_p702_o_EditText.getText().toString();
        c7_p703 = c7_p703_RadioGroup.indexOfChild(c7_p703_RadioGroup.findViewById(c7_p703_RadioGroup.getCheckedRadioButtonId()))+"";
        if (c7_p704_1_Checkbox.isChecked()) c7_p704_1 = "1"; else c7_p704_1 = "0";
        if (c7_p704_2_Checkbox.isChecked()) c7_p704_2 = "1"; else c7_p704_2 = "0";
        if (c7_p704_3_Checkbox.isChecked()) c7_p704_3 = "1"; else c7_p704_3 = "0";
        if (c7_p704_4_Checkbox.isChecked()) c7_p704_4 = "1"; else c7_p704_4 = "0";
        if (c7_p704_5_Checkbox.isChecked()) c7_p704_5 = "1"; else c7_p704_5 = "0";
        if (c7_p704_6_Checkbox.isChecked()) c7_p704_6 = "1"; else c7_p704_6 = "0";
        c7_p704_o = c7_p704_o_EditText.getText().toString();
        if (c7_p705_1_Checkbox.isChecked()) c7_p705_1 = "1"; else c7_p705_1 = "0";
        if (c7_p705_2_Checkbox.isChecked()) c7_p705_2 = "1"; else c7_p705_2 = "0";
        if (c7_p705_3_Checkbox.isChecked()) c7_p705_3 = "1"; else c7_p705_3 = "0";
        if (c7_p705_4_Checkbox.isChecked()) c7_p705_4 = "1"; else c7_p705_4 = "0";
        if (c7_p705_5_Checkbox.isChecked()) c7_p705_5 = "1"; else c7_p705_5 = "0";
        if (c7_p705_6_Checkbox.isChecked()) c7_p705_6 = "1"; else c7_p705_6 = "0";
        if (c7_p705_7_Checkbox.isChecked()) c7_p705_7 = "1"; else c7_p705_7 = "0";
        c7_p705_o = c7_p705_o_EditText.getText().toString();

    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(), idEncuestado)){
            Modulo7 modulo7 = data.getModulo7(idEncuestado);
            informanteSpinner.setSelection(Integer.parseInt(modulo7.getIdInformante()));
            if(!modulo7.getC7_p701().equals("-1"))((RadioButton)c7_p701_RadioGroup.getChildAt(Integer.parseInt(modulo7.getC7_p701()))).setChecked(true);
            if(modulo7.getC7_p702_1().equals("1")) c7_p702_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_2().equals("1")) c7_p702_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_3().equals("1")) c7_p702_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_4().equals("1")) c7_p702_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_5().equals("1")) c7_p702_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_6().equals("1")) c7_p702_6_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_7().equals("1")) c7_p702_7_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_8().equals("1")) c7_p702_8_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_9().equals("1")) c7_p702_9_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_10().equals("1")) c7_p702_10_Checkbox.setChecked(true);
            c7_p702_o_EditText.setText(modulo7.getC7_p702_o());
            if(!modulo7.getC7_p703().equals("-1"))((RadioButton)c7_p703_RadioGroup.getChildAt(Integer.parseInt(modulo7.getC7_p703()))).setChecked(true);
            if(modulo7.getC7_p704_1().equals("1")) c7_p704_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_2().equals("1")) c7_p704_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_3().equals("1")) c7_p704_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_4().equals("1")) c7_p704_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_5().equals("1")) c7_p704_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_6().equals("1")) c7_p704_6_Checkbox.setChecked(true);
            c7_p704_o_EditText.setText(modulo7.getC7_p704_o());
            if(modulo7.getC7_p705_1().equals("1")) c7_p705_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_2().equals("1")) c7_p705_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_3().equals("1")) c7_p705_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_4().equals("1")) c7_p705_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_5().equals("1")) c7_p705_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_6().equals("1")) c7_p705_6_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_7().equals("1")) c7_p705_7_Checkbox.setChecked(true);
            c7_p705_o_EditText.setText(modulo7.getC7_p705_o());
        }
        data.close();


    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p701,idEncuestado)) m7_p701_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p702,idEncuestado)) m7_p702_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p703,idEncuestado)) m7_p703_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p704,idEncuestado)) m7_p704_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p705,idEncuestado)) m7_p705_linearlayout.setVisibility(View.GONE);
        data.close();
    }


    public boolean validarDatos(){
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if (c7_p701.equals("-1")){mostrarMensaje("PREGUNTA 701: DEBE MARCAR UNA OPCIÓN"); return false;}

        if (m7_p702_linearlayout.getVisibility() == View.VISIBLE){
            if (c7_p702_1.equals("0") && c7_p702_2.equals("0") && c7_p702_3.equals("0") && c7_p702_4.equals("0") && c7_p702_5.equals("0") && c7_p702_6.equals("0")
                    && c7_p702_7.equals("0") && c7_p702_8.equals("0") && c7_p702_9.equals("0") && c7_p702_10.equals("0")){
                mostrarMensaje("PREGUNTA 702: DEBE SELECCIONAR ALGUNA OPCION");return false;
            }
            if (c7_p702_10.equals("1")){
                if (c7_p702_o.trim().equals("")){ mostrarMensaje("PREGUNTA 702 - OPCION 10: DEBE ESPECIFICAR OTRO");return false;}
            }
        }else{
            c7_p702_1 = "";
            c7_p702_2 = "";
            c7_p702_3 = "";
            c7_p702_4 = "";
            c7_p702_5 = "";
            c7_p702_6 = "";
            c7_p702_7 = "";
            c7_p702_8 = "";
            c7_p702_9 = "";
            c7_p702_10 = "";
            c7_p702_o = "";
        }

        if (c7_p703.equals("-1")){ mostrarMensaje("PREGUNTA 703: DEBE MARCAR UNA OPCIÓN"); return false; }

        if (m7_p704_linearlayout.getVisibility() == View.VISIBLE){
            if (c7_p704_1.equals("0") && c7_p704_2.equals("0") && c7_p704_3.equals("0") && c7_p704_4.equals("0") && c7_p704_5.equals("0") && c7_p704_6.equals("0")){
                mostrarMensaje("PREGUNTA 704: DEBE SELECCIONAR ALGUNA OPCION"); return false;
            }
            if (c7_p704_6.equals("1")){
                if (c7_p704_o.trim().equals("")){ mostrarMensaje("PREGUNTA 704 - OPCION 6: DEBE ESPECIFICAR OTRO"); return false; }
            }
        }else{
            c7_p704_1 = "";
            c7_p704_2 = "";
            c7_p704_3 = "";
            c7_p704_4 = "";
            c7_p704_5 = "";
            c7_p704_6 = "";
            c7_p704_o = "";
        }

        if (m7_p705_linearlayout.getVisibility() == View.VISIBLE){
            if (c7_p705_1.equals("0") && c7_p705_2.equals("0") && c7_p705_3.equals("0") && c7_p705_4.equals("0") && c7_p705_5.equals("0") && c7_p705_6.equals("0") && c7_p705_7.equals("0")){
                mostrarMensaje("PREGUNTA 705: DEBE SELECCIONAR ALGUNA OPCION"); return false;
            }
            if (c7_p705_6.equals("1")){
                if (c7_p705_o.trim().equals("")){ mostrarMensaje("PREGUNTA 705 - OPCION 6: DEBE ESPECIFICAR OTRO");return false; }
            }
        }else{
            c7_p705_1 = "";
            c7_p705_2 = "";
            c7_p705_3 = "";
            c7_p705_4 = "";
            c7_p705_5 = "";
            c7_p705_6 = "";
            c7_p705_7 = "";
            c7_p705_o = "";
        }
        return true;
    }

    public String getNombreTabla() {
        return SQLConstantes.tablamodulo7;
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


    private void controlarEspecifiqueRadio(RadioGroup group, int checkedId, int opcionEsp, EditText editTextEspecifique) {
        int seleccionado = group.indexOfChild(group.findViewById(checkedId));
        if(seleccionado == opcionEsp){
            editTextEspecifique.setBackgroundResource(R.drawable.input_text_enabled);
            editTextEspecifique.setEnabled(true);
        }else{
            editTextEspecifique.setText("");
            editTextEspecifique.setBackgroundResource(R.drawable.input_text_disabled);
            editTextEspecifique.setEnabled(false);
        }
    }

    private void configurarEditText(final EditText editText, final View view, int tipo,int longitud){
        if (tipo == 1) editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud)});

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(editText);
                    view.requestFocus();
                    return true;
                }
                return false;
            }
        });
        if (tipo == 2) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(longitud)});
            editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        }
    }


    public void controlarChecked(CheckBox checkBox,final EditText editText){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    editText.setBackgroundResource(R.drawable.input_text_enabled);
                    editText.setEnabled(true);
                }else{
                    editText.setText("");
                    editText.setBackgroundResource(R.drawable.input_text_disabled);
                    editText.setEnabled(false);
                }
            }
        });
    }
}
