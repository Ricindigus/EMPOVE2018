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

    int c7_p701;
    private String c7_p702_1, c7_p702_2, c7_p702_3, c7_p702_4, c7_p702_5, c7_p702_6, c7_p702_7,
                c7_p702_8, c7_p702_9, c7_p702_10;
    private String c7_p702_o, c7_p704_o, c7_p705_o;
    int c7_p703;
    private String  c7_p704_1, c7_p704_2, c7_p704_3, c7_p704_4, c7_p704_5, c7_p704_6;
    private String c7_p705_1, c7_p705_2, c7_p705_3, c7_p705_4, c7_p705_5, c7_p705_6, c7_p705_7;

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
        c7_p702_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(30)});

//        c7_p702_o_EditText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    ocultarTeclado(c7_p702_o_EditText);
//                    m7_p702_linearlayout.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
        c7_p704_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(30)});
//        c7_p704_o_EditText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    ocultarTeclado(c7_p704_o_EditText);
//                    m7_p704_linearlayout.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
        c7_p705_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(30)});
//        c7_p705_o_EditText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    ocultarTeclado(c7_p705_o_EditText);
//                    m7_p705_linearlayout.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
        Data data = new Data(context);
        data.open();
        ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(idHogar);
        data.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, residentes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        informanteSpinner.setAdapter(adapter);
        cargarDatos();
    }

    public void guardarDatos(){
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo7_c7_p701, ""+c7_p701);
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
        contentValues.put(SQLConstantes.modulo7_c7_p703, ""+c7_p703);

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
        c7_p701 = c7_p701_RadioGroup.indexOfChild(c7_p701_RadioGroup.findViewById(c7_p701_RadioGroup.getCheckedRadioButtonId()));
        if (c7_p702_1_Checkbox.isChecked()) c7_p702_1 = "1"; else c7_p702_1 = "0";
        if (c7_p702_2_Checkbox.isChecked()) c7_p702_2 = "1"; else c7_p702_2 = "0";
        if (c7_p702_3_Checkbox.isChecked()) c7_p702_3 = "1"; else c7_p702_3 = "0";
        if (c7_p702_4_Checkbox.isChecked()) c7_p702_4 = "1"; else c7_p702_4 = "0";
        if (c7_p702_5_Checkbox.isChecked()) c7_p702_5 = "1"; else c7_p702_5 = "0";
        if (c7_p702_6_Checkbox.isChecked()) c7_p702_6 = "1"; else c7_p702_6 = "0";
        if (c7_p702_7_Checkbox.isChecked()) c7_p702_7 = "1"; else c7_p702_7 = "0";
        if (c7_p702_8_Checkbox.isChecked()) c7_p702_8 = "1"; else c7_p702_8 = "0";
        if (c7_p702_9_Checkbox.isChecked()) c7_p702_9 = "1"; else c7_p702_9 = "0";
        if (c7_p702_10_Checkbox.isChecked()) c7_p702_10 = "1"; else c7_p702_10 = "0";
        c7_p702_o = c7_p702_o_EditText.getText().toString();
        c7_p703 = c7_p703_RadioGroup.indexOfChild(c7_p703_RadioGroup.findViewById(c7_p703_RadioGroup.getCheckedRadioButtonId()));
        if (c7_p704_1_Checkbox.isChecked()) c7_p704_1 = "1"; else c7_p704_1 = "0";
        if (c7_p704_2_Checkbox.isChecked()) c7_p704_2 = "1"; else c7_p704_2 = "0";
        if (c7_p704_3_Checkbox.isChecked()) c7_p704_3 = "1"; else c7_p704_3 = "0";
        if (c7_p704_4_Checkbox.isChecked()) c7_p704_4 = "1"; else c7_p704_4 = "0";
        if (c7_p704_5_Checkbox.isChecked()) c7_p704_5 = "1"; else c7_p704_5 = "0";
        if (c7_p704_6_Checkbox.isChecked()) c7_p704_6 = "1"; else c7_p704_6 = "0";
        c7_p704_o = c7_p704_o_EditText.getText().toString();
        if (c7_p705_1_Checkbox.isChecked()) c7_p705_1 = "1"; else c7_p705_1 ="0";
        if (c7_p705_2_Checkbox.isChecked()) c7_p705_2 = "1"; else c7_p705_2 = "0";
        if (c7_p705_3_Checkbox.isChecked()) c7_p705_3 = "1"; else c7_p705_3 = "0";
        if (c7_p705_4_Checkbox.isChecked()) c7_p705_4 = "1"; else c7_p705_4 = "0";
        if (c7_p705_5_Checkbox.isChecked()) c7_p705_5 = "1"; else c7_p705_5 = "0";
        if (c7_p705_6_Checkbox.isChecked()) c7_p705_6 = "1"; else c7_p705_6 ="0";
        if (c7_p705_7_Checkbox.isChecked()) c7_p705_7 = "1"; else c7_p705_7 = "0";
        c7_p705_o = c7_p705_o_EditText.getText().toString();

    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(), idEncuestado)){
            Modulo7 modulo7 = data.getModulo7(idEncuestado);

            //informanteSpinner.setSelection(Integer.parseInt(modulo7.getIdInformante()));
            informanteSpinner.setSelection(1);
            if(!modulo7.getC7_p701().equals("-1"))((RadioButton)c7_p701_RadioGroup.getChildAt(Integer.parseInt(modulo7.getC7_p701()))).setChecked(true);
            if(modulo7.getC7_p702_1().equals("1")) c7_p702_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_1().equals("0")) c7_p702_1_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_2().equals("1")) c7_p702_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_2().equals("0")) c7_p702_2_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_3().equals("1")) c7_p702_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_3().equals("0")) c7_p702_3_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_4().equals("1")) c7_p702_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_4().equals("0")) c7_p702_4_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_5().equals("1")) c7_p702_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_5().equals("0")) c7_p702_5_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_6().equals("1")) c7_p702_6_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_6().equals("0")) c7_p702_6_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_7().equals("1")) c7_p702_7_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_7().equals("0")) c7_p702_7_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_8().equals("1")) c7_p702_8_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_8().equals("0")) c7_p702_8_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_9().equals("1")) c7_p702_9_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_9().equals("0")) c7_p702_9_Checkbox.setChecked(false);
            if(modulo7.getC7_p702_10().equals("1")) c7_p702_10_Checkbox.setChecked(true);
            if(modulo7.getC7_p702_10().equals("0")) c7_p702_10_Checkbox.setChecked(false);
            c7_p702_o_EditText.setText(modulo7.getC7_p702_o());
            if(!modulo7.getC7_p703().equals("-1"))((RadioButton)c7_p703_RadioGroup.getChildAt(Integer.parseInt(modulo7.getC7_p703()))).setChecked(true);
            if(modulo7.getC7_p704_1().equals("1")) c7_p704_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_1().equals("0")) c7_p704_1_Checkbox.setChecked(false);
            if(modulo7.getC7_p704_2().equals("1")) c7_p704_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_2().equals("0")) c7_p704_2_Checkbox.setChecked(false);
            if(modulo7.getC7_p704_3().equals("1")) c7_p704_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_3().equals("0")) c7_p704_3_Checkbox.setChecked(false);
            if(modulo7.getC7_p704_4().equals("1")) c7_p704_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_4().equals("0")) c7_p704_4_Checkbox.setChecked(false);
            if(modulo7.getC7_p704_5().equals("1")) c7_p704_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_5().equals("0")) c7_p704_5_Checkbox.setChecked(false);
            if(modulo7.getC7_p704_6().equals("1")) c7_p704_6_Checkbox.setChecked(true);
            if(modulo7.getC7_p704_6().equals("0")) c7_p704_6_Checkbox.setChecked(false);
            c7_p704_o_EditText.setText(modulo7.getC7_p704_o());
            if(modulo7.getC7_p705_1().equals("1")) c7_p705_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_1().equals("0")) c7_p705_1_Checkbox.setChecked(false);
            if(modulo7.getC7_p705_2().equals("1")) c7_p705_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_2().equals("0")) c7_p705_2_Checkbox.setChecked(false);
            if(modulo7.getC7_p705_3().equals("1")) c7_p705_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_3().equals("0")) c7_p705_3_Checkbox.setChecked(false);
            if(modulo7.getC7_p705_4().equals("1")) c7_p705_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_4().equals("0")) c7_p705_4_Checkbox.setChecked(false);
            if(modulo7.getC7_p705_5().equals("1")) c7_p705_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_5().equals("0")) c7_p705_5_Checkbox.setChecked(false);
            if(modulo7.getC7_p705_6().equals("1")) c7_p705_6_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_6().equals("0")) c7_p705_6_Checkbox.setChecked(false);
            if(modulo7.getC7_p705_7().equals("1")) c7_p705_7_Checkbox.setChecked(true);
            if(modulo7.getC7_p705_7().equals("0")) c7_p705_7_Checkbox.setChecked(false);
            c7_p705_o_EditText.setText(modulo7.getC7_p705_o());

        }
        data.close();


    }


    public boolean validarDatos(){
        llenarVariables();
        if(informanteSpinner.getSelectedItemPosition() == 0) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if (c7_p701 == -1){mostrarMensaje("PREGUNTA 304: DEBE MARCAR UNA OPCIÓN"); return false;}

        if (c7_p702_1.equals("0") && c7_p702_2.equals("0") && c7_p702_3.equals("0") && c7_p702_4.equals("0") && c7_p702_5.equals("0") && c7_p702_6.equals("0")
                && c7_p702_7.equals("0") && c7_p702_8.equals("0") && c7_p702_9.equals("0") && c7_p702_10.equals("0")){
            mostrarMensaje("PREGUNTA 702: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if (c7_p702_10.equals("1")){
            if (c7_p702_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 702 - OPCION 10: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if (c7_p703 ==-1){mostrarMensaje("PREGUNTA 703: DEBE MARCAR UNA OPCIÓN"); return false;}

        if (c7_p704_1.equals("0") && c7_p704_2.equals("0") && c7_p704_3.equals("0") && c7_p704_4.equals("0") && c7_p704_5.equals("0") && c7_p704_6.equals("0")){
            mostrarMensaje("PREGUNTA 704: DEBE SELECCIONAR ALGUNA OPCION");
        }
        if (c7_p704_6.equals("1")){
            if (c7_p704_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 704 - OPCION 6: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if (c7_p705_1.equals("0") && c7_p705_2.equals("0") && c7_p705_3.equals("0") && c7_p705_4.equals("0") && c7_p705_5.equals("0") && c7_p705_6.equals("0")
                && c7_p705_7.equals("0")){
            mostrarMensaje("PREGUNTA 705: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if (c7_p705_6.equals("1")){
            if (c7_p705_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 705 - OPCION 6: DEBE ESPECIFICAR OTRO");
                return false;
            }
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
}
