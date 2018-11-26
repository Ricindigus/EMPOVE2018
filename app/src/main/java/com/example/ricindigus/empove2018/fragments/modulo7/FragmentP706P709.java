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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo7;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP706P709 extends FragmentPagina {

    Context context;
    String idEncuestado;
    String idInformante;

    RadioGroup c7_p706_RadioGroup;
    EditText c7_p707_o_EditText;
    CheckBox c7_p707_1_Checkbox, c7_p707_2_Checkbox, c7_p707_3_Checkbox , c7_p707_4_Checkbox, c7_p707_5_Checkbox,
            c7_p707_6_Checkbox, c7_p707_7_Checkbox, c7_p707_8_Checkbox, c7_p707_9_Checkbox,
            c7_p708_1_Checkbox, c7_p708_2_Checkbox, c7_p708_3_Checkbox , c7_p708_4_Checkbox, c7_p708_5_Checkbox,
            c7_p709_1_Checkbox, c7_p709_2_Checkbox, c7_p709_3_Checkbox , c7_p709_4_Checkbox, c7_p709_5_Checkbox,
            c7_p709_6_Checkbox, c7_p709_7_Checkbox, c7_p709_8_Checkbox, c7_p709_9_Checkbox, c7_p709_10_Checkbox;
    EditText c7_p709_o_EditText;
    LinearLayout m7_p706_linearlayout, m7_p707_linearlayout, m7_p708_linearlayout, m7_p709_linearlayout;
    Spinner informanteSpinner;

    private String c7_p706;
    private String c7_p707_1;
    private String c7_p707_2;
    private String c7_p707_3;
    private String c7_p707_4;
    private String c7_p707_5;
    private String c7_p707_6;
    private String c7_p707_7;
    private String c7_p707_8;
    private String c7_p707_9;
    private String c7_p707_o;
    private String c7_p708_1;
    private String c7_p708_2;
    private String c7_p708_3;
    private String c7_p708_4;
    private String c7_p708_5;
    private String c7_p709_1;
    private String c7_p709_2;
    private String c7_p709_3;
    private String c7_p709_4;
    private String c7_p709_5;
    private String c7_p709_6;
    private String c7_p709_7;
    private String c7_p709_8;
    private String c7_p709_9;
    private String c7_p709_10;
    private String c7_p709_o;

    @SuppressLint("ValidFragment")
    public FragmentP706P709(String idEncuestado, Context context) {
        this.context = context;
        this.idEncuestado = idEncuestado;
    }

    public FragmentP706P709() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p706_p709, container, false);

        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);
        c7_p706_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod7_706_radiogroup_C7_P706);

        c7_p707_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_1);
        c7_p707_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_2);
        c7_p707_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_3);
        c7_p707_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_4);
        c7_p707_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_5);
        c7_p707_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_6);
        c7_p707_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_7);
        c7_p707_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_8);
        c7_p707_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_707_checkbox_C7_P707_9);
        c7_p707_o_EditText = (EditText) rootView.findViewById(R.id.mod7_707_edittext_C7_P707_O);

        c7_p708_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_1);
        c7_p708_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_2);
        c7_p708_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_3);
        c7_p708_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_4);
        c7_p708_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_5);

        c7_p709_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_1);
        c7_p709_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_2);
        c7_p709_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_3);
        c7_p709_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_4);
        c7_p709_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_5);
        c7_p709_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_6);
        c7_p709_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_7);
        c7_p709_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_8);
        c7_p709_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_9);
        c7_p709_o_EditText = (EditText) rootView.findViewById(R.id.mod7_709_edittext_C7_P709_O);
        c7_p709_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_10);

        m7_p706_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p706);
        m7_p707_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p707);
        m7_p708_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p708);
        m7_p709_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p709);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c7_p707_9_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    c7_p707_1_Checkbox.setChecked(false);
                    c7_p707_2_Checkbox.setChecked(false);
                    c7_p707_3_Checkbox.setChecked(false);
                    c7_p707_4_Checkbox.setChecked(false);
                    c7_p707_5_Checkbox.setChecked(false);
                    c7_p707_6_Checkbox.setChecked(false);
                    c7_p707_7_Checkbox.setChecked(false);
                    c7_p707_8_Checkbox.setChecked(false);
                    c7_p707_o_EditText.setText("");
                    c7_p707_1_Checkbox.setEnabled(false);
                    c7_p707_2_Checkbox.setEnabled(false);
                    c7_p707_3_Checkbox.setEnabled(false);
                    c7_p707_4_Checkbox.setEnabled(false);
                    c7_p707_5_Checkbox.setEnabled(false);
                    c7_p707_6_Checkbox.setEnabled(false);
                    c7_p707_7_Checkbox.setEnabled(false);
                    c7_p707_8_Checkbox.setEnabled(false);
                    c7_p707_o_EditText.setEnabled(false);
                }else{
                    c7_p707_1_Checkbox.setEnabled(true);
                    c7_p707_2_Checkbox.setEnabled(true);
                    c7_p707_3_Checkbox.setEnabled(true);
                    c7_p707_4_Checkbox.setEnabled(true);
                    c7_p707_5_Checkbox.setEnabled(true);
                    c7_p707_6_Checkbox.setEnabled(true);
                    c7_p707_7_Checkbox.setEnabled(true);
                    c7_p707_8_Checkbox.setEnabled(true);
                }
            }
        });

        controlarChecked(c7_p707_8_Checkbox,c7_p707_o_EditText);

        controlarChecked(c7_p709_9_Checkbox,c7_p709_o_EditText);
        configurarEditText(c7_p707_o_EditText,m7_p707_linearlayout,0,30);
        configurarEditText(c7_p709_o_EditText,m7_p709_linearlayout,0,30);

        c7_p708_5_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    c7_p708_1_Checkbox.setChecked(false);
                    c7_p708_2_Checkbox.setChecked(false);
                    c7_p708_3_Checkbox.setChecked(false);
                    c7_p708_4_Checkbox.setChecked(false);
                    c7_p708_1_Checkbox.setEnabled(false);
                    c7_p708_2_Checkbox.setEnabled(false);
                    c7_p708_3_Checkbox.setEnabled(false);
                    c7_p708_4_Checkbox.setEnabled(false);

                }else{
                    c7_p708_1_Checkbox.setEnabled(true);
                    c7_p708_2_Checkbox.setEnabled(true);
                    c7_p708_3_Checkbox.setEnabled(true);
                    c7_p708_4_Checkbox.setEnabled(true);
                }
            }
        });

        c7_p709_10_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    c7_p709_1_Checkbox.setChecked(false);
                    c7_p709_2_Checkbox.setChecked(false);
                    c7_p709_3_Checkbox.setChecked(false);
                    c7_p709_4_Checkbox.setChecked(false);
                    c7_p709_5_Checkbox.setChecked(false);
                    c7_p709_6_Checkbox.setChecked(false);
                    c7_p709_7_Checkbox.setChecked(false);
                    c7_p709_8_Checkbox.setChecked(false);
                    c7_p709_9_Checkbox.setChecked(false);
                    c7_p709_o_EditText.setText("");
                    c7_p709_1_Checkbox.setEnabled(false);
                    c7_p709_2_Checkbox.setEnabled(false);
                    c7_p709_3_Checkbox.setEnabled(false);
                    c7_p709_4_Checkbox.setEnabled(false);
                    c7_p709_5_Checkbox.setEnabled(false);
                    c7_p709_6_Checkbox.setEnabled(false);
                    c7_p709_7_Checkbox.setEnabled(false);
                    c7_p709_8_Checkbox.setEnabled(false);
                    c7_p709_9_Checkbox.setEnabled(false);
                    c7_p709_o_EditText.setEnabled(false);
                }else{
                    c7_p709_1_Checkbox.setEnabled(true);
                    c7_p709_2_Checkbox.setEnabled(true);
                    c7_p709_3_Checkbox.setEnabled(true);
                    c7_p709_4_Checkbox.setEnabled(true);
                    c7_p709_5_Checkbox.setEnabled(true);
                    c7_p709_6_Checkbox.setEnabled(true);
                    c7_p709_7_Checkbox.setEnabled(true);
                    c7_p709_8_Checkbox.setEnabled(true);
                    c7_p709_9_Checkbox.setEnabled(true);
                    c7_p709_o_EditText.setEnabled(true);
                }
            }
        });
        cargarDatos();
    }

    public void llenarVariables(){
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c7_p706 = c7_p706_RadioGroup.indexOfChild(c7_p706_RadioGroup.findViewById(c7_p706_RadioGroup.getCheckedRadioButtonId()))+"";
        if (c7_p707_1_Checkbox.isChecked()) c7_p707_1 = "1"; else c7_p707_1 = "0";
        if (c7_p707_2_Checkbox.isChecked()) c7_p707_2 = "1"; else c7_p707_2 = "0";
        if (c7_p707_3_Checkbox.isChecked()) c7_p707_3 = "1"; else c7_p707_3 = "0";
        if (c7_p707_4_Checkbox.isChecked()) c7_p707_4 = "1"; else c7_p707_4 = "0";
        if (c7_p707_5_Checkbox.isChecked()) c7_p707_5 = "1"; else c7_p707_5 = "0";
        if (c7_p707_6_Checkbox.isChecked()) c7_p707_6 = "1"; else c7_p707_6 = "0";
        if (c7_p707_7_Checkbox.isChecked()) c7_p707_7 = "1"; else c7_p707_7 = "0";
        if (c7_p707_8_Checkbox.isChecked()) c7_p707_8 = "1"; else c7_p707_8 = "0";
        if (c7_p707_9_Checkbox.isChecked()) c7_p707_9 = "1"; else c7_p707_9 = "0";
        c7_p707_o = c7_p707_o_EditText.getText().toString();

        if (c7_p708_1_Checkbox.isChecked()) c7_p708_1 = "1"; else c7_p708_1 = "0";
        if (c7_p708_2_Checkbox.isChecked()) c7_p708_2 = "1"; else c7_p708_2 = "0";
        if (c7_p708_3_Checkbox.isChecked()) c7_p708_3 = "1"; else c7_p708_3 = "0";
        if (c7_p708_4_Checkbox.isChecked()) c7_p708_4 = "1"; else c7_p708_4 = "0";
        if (c7_p708_5_Checkbox.isChecked()) c7_p708_5 = "1"; else c7_p708_5 = "0";

        if (c7_p709_1_Checkbox.isChecked()) c7_p709_1 = "1"; else c7_p709_1 = "0";
        if (c7_p709_2_Checkbox.isChecked()) c7_p709_2 = "1"; else c7_p709_2 = "0";
        if (c7_p709_3_Checkbox.isChecked()) c7_p709_3 = "1"; else c7_p709_3 = "0";
        if (c7_p709_4_Checkbox.isChecked()) c7_p709_4 = "1"; else c7_p709_4 = "0";
        if (c7_p709_5_Checkbox.isChecked()) c7_p709_5 = "1"; else c7_p709_5 = "0";
        if (c7_p709_6_Checkbox.isChecked()) c7_p709_6 = "1"; else c7_p709_6 = "0";
        if (c7_p709_7_Checkbox.isChecked()) c7_p709_7 = "1"; else c7_p709_7 = "0";
        if (c7_p709_8_Checkbox.isChecked()) c7_p709_8 = "1"; else c7_p709_8 = "0";
        if (c7_p709_9_Checkbox.isChecked()) c7_p709_9 = "1"; else c7_p709_9 = "0";
        if (c7_p709_10_Checkbox.isChecked()) c7_p709_10 = "1"; else c7_p709_10 = "0";
        c7_p709_o = c7_p709_o_EditText.getText().toString();

    }

    public boolean validarDatos(){
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if (c7_p706.equals("-1")){mostrarMensaje("PREGUNTA 706: DEBE MARCAR UNA OPCIÓN"); return false;}

        if(c7_p707_1.equals("0") && c7_p707_2.equals("0") && c7_p707_3.equals("0") && c7_p707_4.equals("0") && c7_p707_5.equals("0") &&
                c7_p707_6.equals("0") && c7_p707_7.equals("0") && c7_p707_8.equals("0") && c7_p707_9.equals("0")){
            mostrarMensaje("PREGUNTA 707: DEBE SELECCIONAR ALGUNA OPCION");return false;
        }
        if (c7_p707_8.equals("1")){
            if(c7_p707_o.trim().equals("")){mostrarMensaje("PREGUNTA 707 - OPCION 8: DEBE ESPECIFICAR OTRO");return false; }
        }
        if(c7_p708_1.equals("0") && c7_p708_2.equals("0") && c7_p708_3.equals("0") && c7_p708_4.equals("0") && c7_p708_5.equals("0")){
            mostrarMensaje("PREGUNTA 708: DEBE SELECCIONAR ALGUNA OPCION");return false;
        }

        if(c7_p709_1.equals("0") && c7_p709_2.equals("0") && c7_p709_3.equals("0") && c7_p709_4.equals("0") && c7_p709_5.equals("0") &&
                c7_p709_6.equals("0") && c7_p709_7.equals("0") && c7_p709_8.equals("0") && c7_p709_9.equals("0") && c7_p709_10.equals("0")){
            mostrarMensaje("PREGUNTA 709: DEBE SELECCIONAR LAS TRES PRINCIPALES RAZONES O INDICAR QUE YA ESTAN CUBIERTAS");return false;
        }else{
            if (c7_p709_10.equals("0")){
                int contCheck = 0;
                if(c7_p709_1.equals("1")) contCheck ++;
                if(c7_p709_2.equals("1")) contCheck ++;
                if(c7_p709_3.equals("1")) contCheck ++;
                if(c7_p709_4.equals("1")) contCheck ++;
                if(c7_p709_5.equals("1")) contCheck ++;
                if(c7_p709_6.equals("1")) contCheck ++;
                if(c7_p709_7.equals("1")) contCheck ++;
                if(c7_p709_8.equals("1")) contCheck ++;
                if(c7_p709_9.equals("1")) contCheck ++;
                if (contCheck < 3){
                    mostrarMensaje("PREGUNTA 709: DEBE SELECCIONAR LAS TRES PRINCIPALES RAZONES");return false;
                }else if (contCheck > 3){ mostrarMensaje("PREGUNTA 709: DEBE SELECCIONAR SOLO TRES PRINCIPALES RAZONES");return false;}
            }
        }
        if (c7_p709_9.equals("1")){
            if(c7_p709_o.trim().equals("")){mostrarMensaje("PREGUNTA 709 - OPCION 9: DEBE ESPECIFICAR OTRO");return false; }
        }
        return true;
    }

    public void guardarDatos(){
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo7_id_informante,idInformante);
        contentValues.put(SQLConstantes.modulo7_c7_p706, c7_p706 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_1,c7_p707_1 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_2,c7_p707_2 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_3,c7_p707_3 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_4,c7_p707_4 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_5,c7_p707_5 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_6,c7_p707_6 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_7,c7_p707_7 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_8,c7_p707_8 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_9,c7_p707_9 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p707_o,c7_p707_o);
        contentValues.put(SQLConstantes.modulo7_c7_p708_1,c7_p708_1 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p708_2,c7_p708_2 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p708_3,c7_p708_3 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p708_4,c7_p708_4 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p708_5,c7_p708_5 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_1,c7_p709_1 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_2,c7_p709_2 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_3,c7_p709_3 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_4,c7_p709_4 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_5,c7_p709_5 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_6,c7_p709_6 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_7,c7_p709_7 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_8,c7_p709_8 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_9,c7_p709_9 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_10,c7_p709_10 + "");
        contentValues.put(SQLConstantes.modulo7_c7_p709_o,c7_p709_o);
        data.actualizarElemento(getNombreTabla(), contentValues, idEncuestado);
        //Ya valido y guardo correctamente el fragment, ahora actualizamos el valor de la cobertura del fragment a correcto(1)
        data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp706p709,"1",idEncuestado);
        //verificamos la cobertura del capitulo y actualizamos su valor de cobertura.
        if (verificarCoberturaCapitulo()) data.actualizarValor(getNombreTabla(),SQLConstantes.modulo7_COB700,"1",idEncuestado);
        else data.actualizarValor(getNombreTabla(),SQLConstantes.modulo7_COB700,"0",idEncuestado);
        data.actualizarValor(SQLConstantes.tablaresidentes,SQLConstantes.residentes_encuestado_cobertura,"0",idEncuestado);
        data.close();

    }



    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo7 modulo7 =  data.getModulo7(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo7.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            if(!modulo7.getIdInformante().equals(""))informanteSpinner.setSelection(Integer.parseInt(modulo7.getIdInformante()));
            if(!modulo7.getC7_p706().equals("-1") && !modulo7.getC7_p706().equals("")) ((RadioButton)c7_p706_RadioGroup.getChildAt(Integer.parseInt(modulo7.getC7_p706()))).setChecked(true);
            if(modulo7.getC7_p707_1().equals("1")) c7_p707_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p707_2().equals("1")) c7_p707_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p707_3().equals("1")) c7_p707_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p707_4().equals("1")) c7_p707_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p707_5().equals("1")) c7_p707_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p707_6().equals("1")) c7_p707_6_Checkbox.setChecked(true);
            if(modulo7.getC7_p707_7().equals("1")) c7_p707_7_Checkbox.setChecked(true);
            if(modulo7.getC7_p707_8().equals("1")) c7_p707_8_Checkbox.setChecked(true);
            if(modulo7.getC7_p707_9().equals("1")) c7_p707_9_Checkbox.setChecked(true);
            c7_p707_o_EditText.setText(modulo7.getC7_p707_o());
            if(modulo7.getC7_p708_1().equals("1")) c7_p708_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p708_2().equals("1")) c7_p708_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p708_3().equals("1")) c7_p708_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p708_4().equals("1")) c7_p708_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p708_5().equals("1")) c7_p708_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_1().equals("1")) c7_p709_1_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_2().equals("1")) c7_p709_2_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_3().equals("1")) c7_p709_3_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_4().equals("1")) c7_p709_4_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_5().equals("1")) c7_p709_5_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_6().equals("1")) c7_p709_6_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_7().equals("1")) c7_p709_7_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_8().equals("1")) c7_p709_8_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_9().equals("1")) c7_p709_9_Checkbox.setChecked(true);
            if(modulo7.getC7_p709_10().equals("1")) c7_p709_10_Checkbox.setChecked(true);
            c7_p709_o_EditText.setText(modulo7.getC7_p709_o());

        }
        data.close();
    }

    @Override
    public void llenarVista() {

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

    private void configurarEditText(final EditText editText, final View viewLayout, int tipo,int longitud){
        switch (tipo){
            case 0:editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud), new InputFilterSoloLetras()});break;
            case 1:editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud)});break;
            case 2:editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(longitud)});
                editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());break;
        }
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(editText);
                    viewLayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
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

    public boolean verificarCoberturaCapitulo(){
        Data data = new Data(context);
        data.open();
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p701p705,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp701p705,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p706p709,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp706p709,idEncuestado).equals("0")) return false;
        data.close();
        return true;
    }
}
