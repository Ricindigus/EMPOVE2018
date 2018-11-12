package com.example.ricindigus.empove2018.fragments.modulo6;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
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
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.POJOLayout;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP601P604 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    Spinner informanteSpinner;
    TextView c6_p601_TextView;
    RadioGroup c6_p601_RadioGroup, c6_p602_RadioGroup, c6_p603_RadioGroup,
            c6_p604_1_RadioGroup, c6_p604_2_RadioGroup, c6_p604_3_RadioGroup, c6_p604_4_RadioGroup,
            c6_p604_5_RadioGroup, c6_p604_6_RadioGroup, c6_p604_7_RadioGroup, c6_p604_8_RadioGroup,
            c6_p604_9_RadioGroup, c6_p604_10_RadioGroup, c6_p604_11_RadioGroup;
    EditText c6_p604_o_EditText;
    LinearLayout m6_p601_linearlayout, m6_p602_linearlayout, m6_p603_linearlayout, m6_p604_linearlayout;

    private String c6_p601;
    private String c6_p602;
    private String c6_p603;
    private String c6_p604_1;
    private String c6_p604_2;
    private String c6_p604_3;
    private String c6_p604_4;
    private String c6_p604_5;
    private String c6_p604_6;
    private String c6_p604_7;
    private String c6_p604_8;
    private String c6_p604_9;
    private String c6_p604_10;
    private String c6_p604_11;
    private String c6_p604_o;

    @SuppressLint("ValidFragment")
    public FragmentP601P604(String idEncuestado, Context context) {
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

    public FragmentP601P604() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p601_p604, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c6_p601_TextView = (TextView) rootView.findViewById(R.id.mod6_601_textview_C6_P601);
        c6_p601_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_601_radiogroup_C6_P601);
        c6_p602_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_602_radiogroup_C6_P602);
        c6_p603_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_603_radiogroup_C6_P603);

        c6_p604_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_1);
        c6_p604_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_2);
        c6_p604_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_3);
        c6_p604_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_4);
        c6_p604_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_5);
        c6_p604_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_6);
        c6_p604_7_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_7);
        c6_p604_8_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_8);
        c6_p604_9_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_9);
        c6_p604_10_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_10);
        c6_p604_11_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_604_radiogroup_C6_P604_11);
        c6_p604_o_EditText = (EditText) rootView.findViewById(R.id.mod6_604_edittext_C6_P604_O);

        m6_p601_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p601);
        m6_p602_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p602);
        m6_p603_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p603);
        m6_p604_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p604);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c6_p601_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p601_RadioGroup.findViewById(c6_p601_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    m6_p602_linearlayout.setVisibility(View.GONE); limpiar_p602();
                    m6_p603_linearlayout.setVisibility(View.GONE); limpiar_p603();
                    m6_p604_linearlayout.setVisibility(View.GONE); limpiar_p604();
                }else{
                    m6_p602_linearlayout.setVisibility(View.VISIBLE);
                    m6_p603_linearlayout.setVisibility(View.VISIBLE);
                    m6_p604_linearlayout.setVisibility(View.VISIBLE);
                    c6_p602_RadioGroup.requestFocus();
                }
            }
        });
        c6_p602_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p602_RadioGroup.findViewById(c6_p602_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    m6_p603_linearlayout.setVisibility(View.GONE); limpiar_p603();
                    m6_p604_linearlayout.setVisibility(View.GONE); limpiar_p604();
                }else{
                    m6_p603_linearlayout.setVisibility(View.VISIBLE);
                    m6_p604_linearlayout.setVisibility(View.VISIBLE);
                    c6_p603_RadioGroup.requestFocus();
                }
            }
        });
        c6_p603_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p603_RadioGroup.findViewById(c6_p603_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    m6_p604_linearlayout.setVisibility(View.GONE); limpiar_p604();
                }else{
                    m6_p604_linearlayout.setVisibility(View.VISIBLE);
                    c6_p604_1_RadioGroup.requestFocus();
                }
            }
        });
        c6_p604_11_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p604_11_RadioGroup.findViewById(c6_p604_11_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    c6_p604_o_EditText.setEnabled(true);
                    c6_p604_o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    c6_p604_o_EditText.setText("");
                    c6_p604_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                    c6_p604_o_EditText.setEnabled(false);
                }
            }
        });

        configurarEditText(c6_p604_o_EditText,m6_p604_linearlayout,0,30);
        cargarDatos();

    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo6_c6_p601,c6_p601);
        contentValues.put(SQLConstantes.modulo6_c6_p602,c6_p602);
        contentValues.put(SQLConstantes.modulo6_c6_p603,c6_p603);
        contentValues.put(SQLConstantes.modulo6_c6_p604_1,c6_p604_1);
        contentValues.put(SQLConstantes.modulo6_c6_p604_2,c6_p604_2);
        contentValues.put(SQLConstantes.modulo6_c6_p604_3,c6_p604_3);
        contentValues.put(SQLConstantes.modulo6_c6_p604_4,c6_p604_4);
        contentValues.put(SQLConstantes.modulo6_c6_p604_5,c6_p604_5);
        contentValues.put(SQLConstantes.modulo6_c6_p604_6,c6_p604_6);
        contentValues.put(SQLConstantes.modulo6_c6_p604_7,c6_p604_7);
        contentValues.put(SQLConstantes.modulo6_c6_p604_8,c6_p604_8);
        contentValues.put(SQLConstantes.modulo6_c6_p604_9,c6_p604_9);
        contentValues.put(SQLConstantes.modulo6_c6_p604_10,c6_p604_10);
        contentValues.put(SQLConstantes.modulo6_c6_p604_11,c6_p604_11);
        contentValues.put(SQLConstantes.modulo6_c6_p604_o,c6_p604_o);

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = new Modulo6(idEncuestado,idHogar,idVivienda);
            data.insertarElemento(getNombreTabla(),modulo6.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
        ocultarOtrosLayouts();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c6_p601 = c6_p601_RadioGroup.indexOfChild(c6_p601_RadioGroup.findViewById(c6_p601_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p602 = c6_p602_RadioGroup.indexOfChild(c6_p602_RadioGroup.findViewById(c6_p602_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p603 = c6_p603_RadioGroup.indexOfChild(c6_p603_RadioGroup.findViewById(c6_p603_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_1 = c6_p604_1_RadioGroup.indexOfChild(c6_p604_1_RadioGroup.findViewById(c6_p604_1_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_2 = c6_p604_2_RadioGroup.indexOfChild(c6_p604_2_RadioGroup.findViewById(c6_p604_2_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_3 = c6_p604_3_RadioGroup.indexOfChild(c6_p604_3_RadioGroup.findViewById(c6_p604_3_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_4 = c6_p604_4_RadioGroup.indexOfChild(c6_p604_4_RadioGroup.findViewById(c6_p604_4_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_5 = c6_p604_5_RadioGroup.indexOfChild(c6_p604_5_RadioGroup.findViewById(c6_p604_5_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_6 = c6_p604_6_RadioGroup.indexOfChild(c6_p604_6_RadioGroup.findViewById(c6_p604_6_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_7 = c6_p604_7_RadioGroup.indexOfChild(c6_p604_7_RadioGroup.findViewById(c6_p604_7_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_8 = c6_p604_8_RadioGroup.indexOfChild(c6_p604_8_RadioGroup.findViewById(c6_p604_8_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_9 = c6_p604_9_RadioGroup.indexOfChild(c6_p604_9_RadioGroup.findViewById(c6_p604_9_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_10 = c6_p604_10_RadioGroup.indexOfChild(c6_p604_10_RadioGroup.findViewById(c6_p604_10_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_11 = c6_p604_11_RadioGroup.indexOfChild(c6_p604_11_RadioGroup.findViewById(c6_p604_11_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p604_o = c6_p604_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = data.getModulo6(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo6.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            if(!modulo6.getIdInformante().equals(""))informanteSpinner.setSelection(Integer.parseInt(modulo6.getIdInformante()));
            if(!modulo6.getC6_p601().equals("-1") && !modulo6.getC6_p601().equals(""))((RadioButton)c6_p601_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p601()))).setChecked(true);
            if(!modulo6.getC6_p602().equals("-1") && !modulo6.getC6_p602().equals(""))((RadioButton)c6_p602_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p602()))).setChecked(true);
            if(!modulo6.getC6_p603().equals("-1") && !modulo6.getC6_p603().equals(""))((RadioButton)c6_p603_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p603()))).setChecked(true);
            if(!modulo6.getC6_p604_1().equals("-1") && !modulo6.getC6_p604_1().equals(""))((RadioButton)c6_p604_1_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_1()))).setChecked(true);
            if(!modulo6.getC6_p604_2().equals("-1") && !modulo6.getC6_p604_2().equals(""))((RadioButton)c6_p604_2_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_2()))).setChecked(true);
            if(!modulo6.getC6_p604_3().equals("-1") && !modulo6.getC6_p604_3().equals(""))((RadioButton)c6_p604_3_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_3()))).setChecked(true);
            if(!modulo6.getC6_p604_4().equals("-1") && !modulo6.getC6_p604_4().equals(""))((RadioButton)c6_p604_4_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_4()))).setChecked(true);
            if(!modulo6.getC6_p604_5().equals("-1") && !modulo6.getC6_p604_5().equals(""))((RadioButton)c6_p604_5_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_5()))).setChecked(true);
            if(!modulo6.getC6_p604_6().equals("-1") && !modulo6.getC6_p604_6().equals(""))((RadioButton)c6_p604_6_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_6()))).setChecked(true);
            if(!modulo6.getC6_p604_7().equals("-1") && !modulo6.getC6_p604_7().equals(""))((RadioButton)c6_p604_7_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_7()))).setChecked(true);
            if(!modulo6.getC6_p604_8().equals("-1") && !modulo6.getC6_p604_8().equals(""))((RadioButton)c6_p604_8_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_8()))).setChecked(true);
            if(!modulo6.getC6_p604_9().equals("-1") && !modulo6.getC6_p604_9().equals(""))((RadioButton)c6_p604_9_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_9()))).setChecked(true);
            if(!modulo6.getC6_p604_10().equals("-1") && !modulo6.getC6_p604_10().equals(""))((RadioButton)c6_p604_10_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_10()))).setChecked(true);
            if(!modulo6.getC6_p604_11().equals("-1") && !modulo6.getC6_p604_11().equals(""))((RadioButton)c6_p604_11_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_11()))).setChecked(true);
            c6_p604_o_EditText.setText(modulo6.getC6_p604_o());

        }
        inicio();
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if(c6_p601.equals("-1")){
            mostrarMensaje("PREGUNTA 601: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if (m6_p602_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p602.equals("-1")){ mostrarMensaje("PREGUNTA 602: DEBE SELECCIONAR UNA OPCION");return false; }
        }else c6_p602 = "";

        if (m6_p603_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p603.equals("-1")){ mostrarMensaje("PREGUNTA 603: DEBE SELECCIONAR UNA OPCION");return false; }
        }else c6_p603 = "";


        if(m6_p604_linearlayout.getVisibility()==View.VISIBLE) {
            if(c6_p604_1.equals("-1")){ mostrarMensaje("PREGUNTA 604-1: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_2.equals("-1")){ mostrarMensaje("PREGUNTA 604-2: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_3.equals("-1")){ mostrarMensaje("PREGUNTA 604-3: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_4.equals("-1")){ mostrarMensaje("PREGUNTA 604-4: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_5.equals("-1")){ mostrarMensaje("PREGUNTA 604-5: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_6.equals("-1")){ mostrarMensaje("PREGUNTA 604-6: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_7.equals("-1")){ mostrarMensaje("PREGUNTA 604-7: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_8.equals("-1")){ mostrarMensaje("PREGUNTA 604-8: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_9.equals("-1")){ mostrarMensaje("PREGUNTA 604-9: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_10.equals("-1")){ mostrarMensaje("PREGUNTA 604-10: DEBE SELECCIONAR UNA OPCION");return false;}
            if(c6_p604_11.equals("-1")){ mostrarMensaje("PREGUNTA 604-11: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p604_11.equals("1")){
                if(c6_p604_o.trim().equals("")){ mostrarMensaje("PREGUNTA 604 - OPCION 11: DEBE ESPECIFICAR OTRO");return false; }
            }
        }else{
            c6_p604_1 = "";
            c6_p604_2 = "";
            c6_p604_3 = "";
            c6_p604_4 = "";
            c6_p604_5 = "";
            c6_p604_6 = "";
            c6_p604_7 = "";
            c6_p604_8 = "";
            c6_p604_9 = "";
            c6_p604_10 = "";
            c6_p604_11 = "";
            c6_p604_o = "";
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo6;
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

    public void limpiar_p601(){
        c6_p601_RadioGroup.clearCheck();
    }

    public void limpiar_p602(){
        c6_p602_RadioGroup.clearCheck();
    }

    public void limpiar_p603(){
        c6_p603_RadioGroup.clearCheck();
    }

    public void limpiar_p604(){
        c6_p604_1_RadioGroup.clearCheck(); c6_p604_2_RadioGroup.clearCheck(); c6_p604_3_RadioGroup.clearCheck();
        c6_p604_4_RadioGroup.clearCheck(); c6_p604_5_RadioGroup.clearCheck(); c6_p604_6_RadioGroup.clearCheck();
        c6_p604_7_RadioGroup.clearCheck(); c6_p604_8_RadioGroup.clearCheck(); c6_p604_9_RadioGroup.clearCheck();
        c6_p604_10_RadioGroup.clearCheck(); c6_p604_11_RadioGroup.clearCheck();
        c6_p604_o_EditText.setText("");
    }

    public String NombreMes(int mes){
        String nom_mes="";
        switch(mes){
            case 0: nom_mes="ENERO"; break;
            case 1: nom_mes="FEBRERO"; break;
            case 2: nom_mes="MARZO"; break;
            case 3: nom_mes="ABRIL"; break;
            case 4: nom_mes="MAYO"; break;
            case 5: nom_mes="JUNIO"; break;
            case 6: nom_mes="JULIO"; break;
            case 7: nom_mes="AGOSTO"; break;
            case 8: nom_mes="SETIEMBRE"; break;
            case 9: nom_mes="OCTUBRE"; break;
            case 10: nom_mes="NOVIEMBRE"; break;
            case 11: nom_mes="DICIEMBRE"; break;
        }
        return nom_mes;
    }

    public void fecha(){
        Calendar calendario;
        int mm=0, dd=0;
        String fecha_inicial="", fecha_final="";
        calendario = Calendar.getInstance();
        mm = calendario.get(Calendar.MONTH);
        dd = calendario.get(Calendar.DAY_OF_MONTH);
        fecha_final = "" + dd + " DE " + NombreMes(mm);
        calendario.add(Calendar.DAY_OF_MONTH,-7);
        mm = calendario.get(Calendar.MONTH);
        dd = calendario.get(Calendar.DAY_OF_MONTH);
        fecha_inicial = "" + dd + " DE " + NombreMes(mm);
        String enunciado_p601 = c6_p601_TextView.getText()+"";
        enunciado_p601 = enunciado_p601.replace("FECHAINI", fecha_inicial);
        enunciado_p601 = enunciado_p601.replace("FECHAFIN", fecha_final);
        c6_p601_TextView.setText(enunciado_p601);
    }

    public void inicio(){
        fecha();
    }

    public void ocultarOtrosLayouts() {
        Data data = new Data(context);
        data.open();
        if(c6_p601.equals("1") || c6_p602.equals("1") || c6_p603.equals("1")){
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo6_c6_p618,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_1,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_2,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_3,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_4,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_5,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_6,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_7,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_8,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_9,"");
            contentValues.put(SQLConstantes.modulo6_c6_p619_o,"");
            contentValues.put(SQLConstantes.modulo6_c6_p620,"");
            contentValues.put(SQLConstantes.modulo6_c6_p621,"");
            contentValues.put(SQLConstantes.modulo6_c6_p622,"");
            contentValues.put(SQLConstantes.modulo6_c6_p622_o,"");
            contentValues.put(SQLConstantes.modulo6_c6_p623,"");
            contentValues.put(SQLConstantes.modulo6_c6_p623_o,"");
            contentValues.put(SQLConstantes.modulo6_c6_p624,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);

            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p618,"0");
            contentValues.put(SQLConstantes.layouts_p619,"0");
            contentValues.put(SQLConstantes.layouts_p620,"0");
            contentValues.put(SQLConstantes.layouts_p621,"0");
            contentValues.put(SQLConstantes.layouts_p622,"0");
            contentValues.put(SQLConstantes.layouts_p623,"0");
            contentValues.put(SQLConstantes.layouts_p624,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);

            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p619p622,"-1",idEncuestado);
        }else{
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p618,"1");
            contentValues.put(SQLConstantes.layouts_p619,"1");
            contentValues.put(SQLConstantes.layouts_p620,"1");
            contentValues.put(SQLConstantes.layouts_p621,"1");
            contentValues.put(SQLConstantes.layouts_p622,"1");
            contentValues.put(SQLConstantes.layouts_p623,"1");
            contentValues.put(SQLConstantes.layouts_p624,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p619p622,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p619p622,"1",idEncuestado);
        }

        if (c6_p604_1.equals("2") && c6_p604_2.equals("2") && c6_p604_3.equals("2") &&
                c6_p604_4.equals("2") && c6_p604_5.equals("2") && c6_p604_6.equals("2") &&
                c6_p604_7.equals("2") && c6_p604_8.equals("2") && c6_p604_9.equals("2") &&
                c6_p604_10.equals("2") && c6_p604_11.equals("2")){
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo6_c6_p605,"");
            contentValues.put(SQLConstantes.modulo6_c6_p606,"");
            contentValues.put(SQLConstantes.modulo6_c6_p607,"");
            contentValues.put(SQLConstantes.modulo6_c6_p608,"");
            contentValues.put(SQLConstantes.modulo6_c6_p608_o,"");
            contentValues.put(SQLConstantes.modulo6_c6_p609,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_pd,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_pl,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_pm,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_pmi,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_pj,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_pv,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_ps,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_pt,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_sd,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_sl,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_sm,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_smi,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_sj,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_sv,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_ss,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_st,"");
            contentValues.put(SQLConstantes.modulo6_c6_p610_t,"");
            contentValues.put(SQLConstantes.modulo6_c6_p611,"");
            contentValues.put(SQLConstantes.modulo6_c6_p612,"");
            contentValues.put(SQLConstantes.modulo6_c6_p612_nro,"");
            contentValues.put(SQLConstantes.modulo6_c6_p613,"");
            contentValues.put(SQLConstantes.modulo6_c6_p614_mon,"");
            contentValues.put(SQLConstantes.modulo6_c6_p614_esp,"");
            contentValues.put(SQLConstantes.modulo6_c6_p615_mon,"");
            contentValues.put(SQLConstantes.modulo6_c6_p615_esp,"");
            contentValues.put(SQLConstantes.modulo6_c6_p616_mon,"");
            contentValues.put(SQLConstantes.modulo6_c6_p616_esp,"");
            contentValues.put(SQLConstantes.modulo6_c6_p616_nas,"");
            contentValues.put(SQLConstantes.modulo6_c6_p617,"");
            contentValues.put(SQLConstantes.modulo6_c6_p617_dist,"");
            contentValues.put(SQLConstantes.modulo6_c6_p617_prov,"");
            contentValues.put(SQLConstantes.modulo6_c6_p617_dep,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);

            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p613,"0");
            contentValues.put(SQLConstantes.layouts_p614,"0");
            contentValues.put(SQLConstantes.layouts_p615,"0");
            contentValues.put(SQLConstantes.layouts_p616,"0");
            contentValues.put(SQLConstantes.layouts_p617,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);

            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,"-1",idEncuestado);
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,"-1",idEncuestado);
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p618,"-1",idEncuestado);

        }else{
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p613,"1");
            contentValues.put(SQLConstantes.layouts_p614,"1");
            contentValues.put(SQLConstantes.layouts_p615,"1");
            contentValues.put(SQLConstantes.layouts_p616,"1");
            contentValues.put(SQLConstantes.layouts_p617,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,"1",idEncuestado);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,"1",idEncuestado);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p618,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p618,"1",idEncuestado);
        }
        POJOLayout pojoLayout = data.getLayouts(idEncuestado);
        data.close();

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


    public void controlarChecked(CheckBox checkBox, final EditText editText){
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
