package com.example.ricindigus.empove2018.fragments.modulo5;


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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP508P511 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    CheckBox c5_p508_1_Checkbox, c5_p508_2_Checkbox, c5_p508_3_Checkbox , c5_p508_4_Checkbox, c5_p508_5_Checkbox,
            c5_p508_6_Checkbox, c5_p508_7_Checkbox, c5_p508_8_Checkbox, c5_p508_9_Checkbox, c5_p508_10_Checkbox, c5_p508_11_Checkbox;
    EditText c5_p508_o_EditText, c5_p511_o_EditText;
    RadioGroup c5_p509_RadioGroup, c5_p510_RadioGroup, c5_p511_RadioGroup;
    LinearLayout m5_p508_linearlayout, m5_p509_linearlayout, m5_p510_linearlayout, m5_p511_linearlayout;

    private String c5_p501="";
    private int c5_p508_1;
    private int c5_p508_2;
    private int c5_p508_3;
    private int c5_p508_4;
    private int c5_p508_5;
    private int c5_p508_6;
    private int c5_p508_7;
    private int c5_p508_8;
    private int c5_p508_9;
    private int c5_p508_10;
    private int c5_p508_11;
    private String c5_p508_o;
    private int c5_p509;
    private int c5_p510;
    private int c5_p511;
    private String c5_p511_o;

    private int edad, sexo;

    @SuppressLint("ValidFragment")
    public FragmentP508P511(String idEncuestado, Context context) {
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

    public FragmentP508P511() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p508_p511, container, false);
        c5_p508_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_1);
        c5_p508_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_2);
        c5_p508_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_3);
        c5_p508_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_4);
        c5_p508_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_5);
        c5_p508_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_6);
        c5_p508_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_7);
        c5_p508_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_8);
        c5_p508_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_9);
        c5_p508_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_10);
        c5_p508_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_11);
        c5_p508_o_EditText = (EditText) rootView.findViewById(R.id.mod5_508_edittext_C5_P508_O);
        c5_p509_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_509_radiogroup_C5_P509);
        c5_p510_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_510_radiogroup_C5_P510);
        c5_p511_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_511_radiogroup_C5_P511);
        c5_p511_o_EditText = (EditText) rootView.findViewById(R.id.mod5_511_edittext_C5_P511_O);

        m5_p508_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p508);
        m5_p509_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p509);
        m5_p510_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p510);
        m5_p511_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p511);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c5_p508_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c5_p508_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p508_o_EditText);
                    m5_p508_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p508_11_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c5_p508_o_EditText.setEnabled(true);
                    c5_p508_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c5_p508_o_EditText.setText("");
                    c5_p508_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c5_p508_o_EditText.setEnabled(false);
                }
            }
        });
        c5_p509_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c5_p509_RadioGroup.findViewById(c5_p509_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    m5_p510_linearlayout.setVisibility(View.GONE); limpiar_p510();
                    m5_p511_linearlayout.setVisibility(View.GONE); limpiar_p511();
                }else{
                    if(c5_p501.equals("9") || c5_p501.equals("10")){
                        m5_p510_linearlayout.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        c5_p510_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c5_p510_RadioGroup.findViewById(c5_p510_RadioGroup.getCheckedRadioButtonId()));
                if(pos==0){
                    m5_p511_linearlayout.setVisibility(View.GONE); limpiar_p511();
                }else{
                    if(c5_p501.equals("9") || c5_p501.equals("10")) {
                        m5_p511_linearlayout.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        c5_p511_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c5_p511_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p511_o_EditText);
                    m5_p511_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p511_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c5_p511_RadioGroup.findViewById(c5_p511_RadioGroup.getCheckedRadioButtonId()));
                if(pos==3){
                    c5_p511_o_EditText.setEnabled(true);
                    c5_p511_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c5_p511_o_EditText.setText("");
                    c5_p511_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c5_p511_o_EditText.setEnabled(false);
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
        contentValues.put(SQLConstantes.modulo5_c5_p508_1,c5_p508_1+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_2,c5_p508_2+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_3,c5_p508_3+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_4,c5_p508_4+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_5,c5_p508_5+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_6,c5_p508_6+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_7,c5_p508_7+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_8,c5_p508_8+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_9,c5_p508_9+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_10,c5_p508_10+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_11,c5_p508_11+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_o,c5_p508_o);
        contentValues.put(SQLConstantes.modulo5_c5_p509,c5_p509+"");
        contentValues.put(SQLConstantes.modulo5_c5_p510,c5_p510+"");
        contentValues.put(SQLConstantes.modulo5_c5_p511,c5_p511+"");
        contentValues.put(SQLConstantes.modulo5_c5_p511_o,c5_p511_o);

        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        if(c5_p508_1_Checkbox.isChecked()) c5_p508_1 = 1; else c5_p508_1 = 0;
        if(c5_p508_2_Checkbox.isChecked()) c5_p508_2 = 1; else c5_p508_2 = 0;
        if(c5_p508_3_Checkbox.isChecked()) c5_p508_3 = 1; else c5_p508_3 = 0;
        if(c5_p508_4_Checkbox.isChecked()) c5_p508_4 = 1; else c5_p508_4 = 0;
        if(c5_p508_5_Checkbox.isChecked()) c5_p508_5 = 1; else c5_p508_5 = 0;
        if(c5_p508_6_Checkbox.isChecked()) c5_p508_6 = 1; else c5_p508_6 = 0;
        if(c5_p508_7_Checkbox.isChecked()) c5_p508_7 = 1; else c5_p508_7 = 0;
        if(c5_p508_8_Checkbox.isChecked()) c5_p508_8 = 1; else c5_p508_8 = 0;
        if(c5_p508_9_Checkbox.isChecked()) c5_p508_9 = 1; else c5_p508_9 = 0;
        if(c5_p508_10_Checkbox.isChecked()) c5_p508_10 = 1; else c5_p508_10 = 0;
        if(c5_p508_11_Checkbox.isChecked()) c5_p508_11 = 1; else c5_p508_11 = 0;
        c5_p508_o = c5_p508_o_EditText.getText().toString();
        c5_p509 = c5_p509_RadioGroup.indexOfChild(c5_p509_RadioGroup.findViewById(c5_p509_RadioGroup.getCheckedRadioButtonId()));
        c5_p510 = c5_p510_RadioGroup.indexOfChild(c5_p510_RadioGroup.findViewById(c5_p510_RadioGroup.getCheckedRadioButtonId()));
        c5_p511 = c5_p511_RadioGroup.indexOfChild(c5_p511_RadioGroup.findViewById(c5_p511_RadioGroup.getCheckedRadioButtonId()));
        c5_p511_o = c5_p511_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo5 modulo5 = data.getModulo5(idEncuestado);
            c5_p501 = modulo5.getC5_p501();
            if(modulo5.getC5_p508_1().equals("0")) c5_p508_1_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_2().equals("0")) c5_p508_2_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_3().equals("0")) c5_p508_3_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_4().equals("0")) c5_p508_4_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_5().equals("0")) c5_p508_5_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_6().equals("0")) c5_p508_6_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_7().equals("0")) c5_p508_7_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_8().equals("0")) c5_p508_8_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_9().equals("0")) c5_p508_9_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_10().equals("0")) c5_p508_10_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_11().equals("0")) c5_p508_11_Checkbox.setChecked(false);
            if(modulo5.getC5_p508_1().equals("1")) c5_p508_1_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_2().equals("1")) c5_p508_2_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_3().equals("1")) c5_p508_3_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_4().equals("1")) c5_p508_4_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_5().equals("1")) c5_p508_5_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_6().equals("1")) c5_p508_6_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_7().equals("1")) c5_p508_7_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_8().equals("1")) c5_p508_8_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_9().equals("1")) c5_p508_9_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_10().equals("1")) c5_p508_10_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_11().equals("1")) c5_p508_11_Checkbox.setChecked(true);
            c5_p508_o_EditText.setText(modulo5.getC5_p508_o());
            if(!(modulo5.getC5_p509().equals("-1") || modulo5.getC5_p509().equals("")))((RadioButton)c5_p509_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p509()))).setChecked(true);
            if(!(modulo5.getC5_p510().equals("-1") || modulo5.getC5_p510().equals("")))((RadioButton)c5_p510_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p510()))).setChecked(true);
            if(!(modulo5.getC5_p511().equals("-1") || modulo5.getC5_p511().equals("")))((RadioButton)c5_p511_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p511()))).setChecked(true);
            c5_p511_o_EditText.setText(modulo5.getC5_p511_o());
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
        if(m5_p508_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p508_1==0 && c5_p508_2==0 && c5_p508_3==0 && c5_p508_4==0 && c5_p508_5==0 &&
                    c5_p508_6==0 && c5_p508_7==0 && c5_p508_8==0 && c5_p508_9==0 && c5_p508_10==0 &&
                    c5_p508_11==0){
                mostrarMensaje("PREGUNTA 508: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c5_p508_11==1){
                if(c5_p508_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 508 - OPCION 11: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c5_p509<0 && m5_p509_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 509: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c5_p510<0 && m5_p510_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 510: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c5_p511<0 && m5_p511_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 511: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo5;
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

    public void limpiar_p508(){
        c5_p508_1_Checkbox.setChecked(false);
        c5_p508_2_Checkbox.setChecked(false);
        c5_p508_3_Checkbox.setChecked(false);
        c5_p508_4_Checkbox.setChecked(false);
        c5_p508_5_Checkbox.setChecked(false);
        c5_p508_6_Checkbox.setChecked(false);
        c5_p508_7_Checkbox.setChecked(false);
        c5_p508_8_Checkbox.setChecked(false);
        c5_p508_9_Checkbox.setChecked(false);
        c5_p508_10_Checkbox.setChecked(false);
        c5_p508_11_Checkbox.setChecked(false);
        c5_p508_o_EditText.setText("");
    }

    public void limpiar_p509(){
        c5_p509_RadioGroup.clearCheck();
    }

    public void limpiar_p510(){
        c5_p510_RadioGroup.clearCheck();
    }

    public void limpiar_p511(){
        c5_p511_RadioGroup.clearCheck();
        c5_p511_o_EditText.setText("");
    }

    public void inicio(){
        if(edad>=3 && edad<=25){
            m5_p508_linearlayout.setVisibility(View.VISIBLE);
        }else{
            m5_p508_linearlayout.setVisibility(View.GONE); limpiar_p508();
        }
        if(c5_p501.equals("9") || c5_p501.equals("10")){
            m5_p509_linearlayout.setVisibility(View.VISIBLE);
            m5_p510_linearlayout.setVisibility(View.VISIBLE);
            m5_p511_linearlayout.setVisibility(View.VISIBLE);
        }else{
            m5_p509_linearlayout.setVisibility(View.GONE);
            m5_p510_linearlayout.setVisibility(View.GONE);
            m5_p511_linearlayout.setVisibility(View.GONE);
            limpiar_p509(); limpiar_p510(); limpiar_p511();
        }
    }
}
