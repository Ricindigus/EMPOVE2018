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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP626P629 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c6_p626_RadioGroup, c6_p627_RadioGroup;
    EditText c6_p628_EditText;
    RadioGroup c6_p629_1_RadioGroup, c6_p629_2_RadioGroup, c6_p629_3_RadioGroup, c6_p629_4_RadioGroup;
    EditText c6_p629_o_EditText;
    Spinner c6_p629_1_f_Spinner;
    EditText c6_p629_1_m_EditText;
    Spinner c6_p629_2_f_Spinner;
    EditText c6_p629_2_m_EditText;
    Spinner c6_p629_3_f_Spinner;
    EditText c6_p629_3_m_EditText;
    Spinner c6_p629_4_f_Spinner;
    EditText c6_p629_4_m_EditText;
    LinearLayout m6_p626_linearlayout, m6_p627_linearlayout, m6_p628_linearlayout, m6_p629_linearlayout;

    private int c6_p626;
    private int c6_p627;
    private String c6_p628;
    private int c6_p629_1;
    private int c6_p629_2;
    private int c6_p629_3;
    private int c6_p629_4;
    private String c6_p629_o;
    private int c6_p629_1_f;
    private String c6_p629_1_m;
    private int c6_p629_2_f;
    private String c6_p629_2_m;
    private int c6_p629_3_f;
    private String c6_p629_3_m;
    private int c6_p629_4_f;
    private String c6_p629_4_m;

    private int edad;

    @SuppressLint("ValidFragment")
    public FragmentP626P629(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idHogar = residente.getId_hogar();
        idVivienda = residente.getId_vivienda();
        idInformante = "";
        if(residente.getC2_p205_a()=="") edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
        data.close();
    }

    public FragmentP626P629() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p626_p629, container, false);

        c6_p626_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_626_radiogroup_C6_P626);
        c6_p627_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_627_radiogroup_C6_P627);
        c6_p628_EditText = (EditText) rootView.findViewById(R.id.mod6_628_edittext_C6_P628);

        c6_p629_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_1);
        c6_p629_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_2);
        c6_p629_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_3);
        c6_p629_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_4);
        c6_p629_o_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_O);

        c6_p629_1_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_1_F);
        c6_p629_1_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_1_M);
        c6_p629_2_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_2_F);
        c6_p629_2_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_2_M);
        c6_p629_3_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_3_F);
        c6_p629_3_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_3_M);
        c6_p629_4_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_4_F);
        c6_p629_4_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_4_M);

        m6_p626_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p626);
        m6_p627_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p627);
        m6_p628_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p628);
        m6_p629_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p629);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c6_p627_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p627_RadioGroup.findViewById(c6_p627_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    m6_p628_linearlayout.setVisibility(View.GONE); limpiar_p628();
                }else{
                    m6_p628_linearlayout.setVisibility(View.VISIBLE);
                    c6_p628_EditText.requestFocus();
                }
            }
        });
        c6_p628_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p628_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p628_EditText);
                    m6_p628_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p629_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p629_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p629_o_EditText);
                    m6_p629_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p629_1_m_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p629_1_m_EditText);
                    m6_p629_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p629_1_m_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p629_1_m_EditText.setInputType(18);
        c6_p629_1_m_EditText.setTransformationMethod(null);
        c6_p629_1_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p629_1_RadioGroup.findViewById(c6_p629_1_RadioGroup.getCheckedRadioButtonId()));
                if(pos==0){
                    c6_p629_1_f_Spinner.setEnabled(true);
                    c6_p629_1_m_EditText.setEnabled(true);
                    c6_p629_1_m_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p629_1_f_Spinner.setEnabled(false);
                    c6_p629_1_m_EditText.setEnabled(false);
                    c6_p629_1_f_Spinner.setSelection(0);
                    c6_p629_1_m_EditText.setText("");
                    c6_p629_1_m_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                }
            }
        });
        c6_p629_2_m_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p629_2_m_EditText);
                    m6_p629_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p629_2_m_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p629_2_m_EditText.setInputType(18);
        c6_p629_2_m_EditText.setTransformationMethod(null);
        c6_p629_2_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p629_2_RadioGroup.findViewById(c6_p629_2_RadioGroup.getCheckedRadioButtonId()));
                if(pos==0){
                    c6_p629_2_f_Spinner.setEnabled(true);
                    c6_p629_2_m_EditText.setEnabled(true);
                    c6_p629_2_m_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p629_2_f_Spinner.setEnabled(false);
                    c6_p629_2_m_EditText.setEnabled(false);
                    c6_p629_2_f_Spinner.setSelection(0);
                    c6_p629_2_m_EditText.setText("");
                    c6_p629_2_m_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                }
            }
        });
        c6_p629_3_m_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p629_3_m_EditText);
                    m6_p629_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p629_3_m_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p629_3_m_EditText.setInputType(18);
        c6_p629_3_m_EditText.setTransformationMethod(null);
        c6_p629_3_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p629_3_RadioGroup.findViewById(c6_p629_3_RadioGroup.getCheckedRadioButtonId()));
                if(pos==0){
                    c6_p629_3_f_Spinner.setEnabled(true);
                    c6_p629_3_m_EditText.setEnabled(true);
                    c6_p629_3_m_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p629_3_f_Spinner.setEnabled(false);
                    c6_p629_3_m_EditText.setEnabled(false);
                    c6_p629_3_f_Spinner.setSelection(0);
                    c6_p629_3_m_EditText.setText("");
                    c6_p629_3_m_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                }
            }
        });
        c6_p629_4_m_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p629_4_m_EditText);
                    m6_p629_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p629_4_m_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p629_4_m_EditText.setInputType(18);
        c6_p629_4_m_EditText.setTransformationMethod(null);
        c6_p629_4_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p629_4_RadioGroup.findViewById(c6_p629_4_RadioGroup.getCheckedRadioButtonId()));
                if(pos==0){
                    c6_p629_o_EditText.setEnabled(true);
                    c6_p629_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                    c6_p629_4_f_Spinner.setEnabled(true);
                    c6_p629_4_m_EditText.setEnabled(true);
                    c6_p629_4_m_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p629_o_EditText.setText("");
                    c6_p629_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c6_p629_o_EditText.setEnabled(false);
                    c6_p629_4_f_Spinner.setEnabled(false);
                    c6_p629_4_m_EditText.setEnabled(false);
                    c6_p629_4_f_Spinner.setSelection(0);
                    c6_p629_4_m_EditText.setText("");
                    c6_p629_4_m_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
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
        contentValues.put(SQLConstantes.modulo6_c6_p626,c6_p626+"");
        contentValues.put(SQLConstantes.modulo6_c6_p627,c6_p627+"");
        contentValues.put(SQLConstantes.modulo6_c6_p628,c6_p628);
        contentValues.put(SQLConstantes.modulo6_c6_p629_1,c6_p629_1+"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_2,c6_p629_2+"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_3,c6_p629_3+"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_4,c6_p629_4+"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_o,c6_p629_o);
        contentValues.put(SQLConstantes.modulo6_c6_p629_1_f,c6_p629_1_f+"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_1_m,c6_p629_1_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_2_f,c6_p629_2_f+"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_2_m,c6_p629_2_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_3_f,c6_p629_3_f+"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_3_m,c6_p629_3_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_4_f,c6_p629_4_f+"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_4_m,c6_p629_4_m);

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = new Modulo6(idEncuestado,idHogar,idVivienda);
            modulo6.setIdInformante(idInformante);
            modulo6.set_id(idEncuestado);
            modulo6.setIdVivienda(idVivienda);
            modulo6.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo6.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        c6_p626 = c6_p626_RadioGroup.indexOfChild(c6_p626_RadioGroup.findViewById(c6_p626_RadioGroup.getCheckedRadioButtonId()));
        c6_p627 = c6_p627_RadioGroup.indexOfChild(c6_p627_RadioGroup.findViewById(c6_p627_RadioGroup.getCheckedRadioButtonId()));
        c6_p628 = c6_p628_EditText.getText().toString();
        c6_p629_1 = c6_p629_1_RadioGroup.indexOfChild(c6_p629_1_RadioGroup.findViewById(c6_p629_1_RadioGroup.getCheckedRadioButtonId()));
        c6_p629_2 = c6_p629_2_RadioGroup.indexOfChild(c6_p629_2_RadioGroup.findViewById(c6_p629_2_RadioGroup.getCheckedRadioButtonId()));
        c6_p629_3 = c6_p629_3_RadioGroup.indexOfChild(c6_p629_3_RadioGroup.findViewById(c6_p629_3_RadioGroup.getCheckedRadioButtonId()));
        c6_p629_4 = c6_p629_4_RadioGroup.indexOfChild(c6_p629_4_RadioGroup.findViewById(c6_p629_4_RadioGroup.getCheckedRadioButtonId()));
        c6_p629_o = c6_p629_o_EditText.getText().toString();
        c6_p629_1_f = c6_p629_1_f_Spinner.getSelectedItemPosition();
        c6_p629_1_m = c6_p629_1_m_EditText.getText().toString();
        c6_p629_2_f = c6_p629_2_f_Spinner.getSelectedItemPosition();
        c6_p629_2_m = c6_p629_2_m_EditText.getText().toString();
        c6_p629_3_f = c6_p629_3_f_Spinner.getSelectedItemPosition();
        c6_p629_3_m = c6_p629_3_m_EditText.getText().toString();
        c6_p629_4_f = c6_p629_4_f_Spinner.getSelectedItemPosition();
        c6_p629_4_m = c6_p629_4_m_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = data.getModulo6(idEncuestado);
            if(!(modulo6.getC6_p626().equals("-1") || modulo6.getC6_p626().equals("")))((RadioButton)c6_p626_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p626()))).setChecked(true);
            if(!(modulo6.getC6_p627().equals("-1") || modulo6.getC6_p627().equals("")))((RadioButton)c6_p627_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p627()))).setChecked(true);
            c6_p628_EditText.setText(modulo6.getC6_p628());
            if(!(modulo6.getC6_p629_1().equals("-1") || modulo6.getC6_p629_1().equals("")))((RadioButton)c6_p629_1_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p629_1()))).setChecked(true);
            if(!(modulo6.getC6_p629_2().equals("-1") || modulo6.getC6_p629_2().equals("")))((RadioButton)c6_p629_2_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p629_2()))).setChecked(true);
            if(!(modulo6.getC6_p629_3().equals("-1") || modulo6.getC6_p629_3().equals("")))((RadioButton)c6_p629_3_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p629_3()))).setChecked(true);
            if(!(modulo6.getC6_p629_4().equals("-1") || modulo6.getC6_p629_4().equals("")))((RadioButton)c6_p629_4_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p629_4()))).setChecked(true);
            c6_p629_o_EditText.setText(modulo6.getC6_p629_o());
            if(!modulo6.getC6_p629_1_f().equals("")) c6_p629_1_f_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p629_1_f()));
            c6_p629_1_m_EditText.setText(modulo6.getC6_p629_1_m());
            if(!modulo6.getC6_p629_2_f().equals("")) c6_p629_2_f_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p629_2_f()));
            c6_p629_2_m_EditText.setText(modulo6.getC6_p629_2_m());
            if(!modulo6.getC6_p629_3_f().equals("")) c6_p629_3_f_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p629_3_f()));
            c6_p629_3_m_EditText.setText(modulo6.getC6_p629_3_m());
            if(!modulo6.getC6_p629_4_f().equals("")) c6_p629_4_f_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p629_4_f()));
            c6_p629_4_m_EditText.setText(modulo6.getC6_p629_4_m());
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
        if(c6_p626<0 && m6_p626_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 626: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c6_p627<0 && m6_p627_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 627: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c6_p628.trim().length()==0 && m6_p628_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 628: DEBE INGRESAR NRO DE SEMANAS");
            return false;
        }
        if(m6_p629_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p629_1<0){
                mostrarMensaje("PREGUNTA 629-A: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p629_1==0){
                if(c6_p629_1_f==0){
                    mostrarMensaje("PREGUNTA 629-A: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if(c6_p629_1_m.trim().length()==0){
                    mostrarMensaje("PREGUNTA 629-A: DEBE INGRESAR MONTO");
                    return false;
                }
            }
            if(c6_p629_2<0){
                mostrarMensaje("PREGUNTA 629-B: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p629_2==0){
                if(c6_p629_2_f==0){
                    mostrarMensaje("PREGUNTA 629-B: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if(c6_p629_2_m.trim().length()==0){
                    mostrarMensaje("PREGUNTA 629-B: DEBE INGRESAR MONTO");
                    return false;
                }
            }
            if(c6_p629_3<0){
                mostrarMensaje("PREGUNTA 629-C: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p629_3==0){
                if(c6_p629_3_f==0){
                    mostrarMensaje("PREGUNTA 629-C: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if(c6_p629_3_m.trim().length()==0){
                    mostrarMensaje("PREGUNTA 629-C: DEBE INGRESAR MONTO");
                    return false;
                }
            }
            if(c6_p629_4<0){
                mostrarMensaje("PREGUNTA 629-D: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p629_4==0){
                if(c6_p629_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 629-D: DEBE ESPECIFICAR OTRO");
                    return false;
                }
                if(c6_p629_4_f==0){
                    mostrarMensaje("PREGUNTA 629-D: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if(c6_p629_4_m.trim().length()==0){
                    mostrarMensaje("PREGUNTA 629-D: DEBE INGRESAR MONTO");
                    return false;
                }
            }
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

    public void limpiar_p626(){
        c6_p626_RadioGroup.clearCheck();
    }

    public void limpiar_p627(){
        c6_p627_RadioGroup.clearCheck();
    }

    public void limpiar_p628(){
        c6_p628_EditText.setText("");
    }

    public void limpiar_p629(){
        c6_p629_1_RadioGroup.clearCheck(); c6_p629_2_RadioGroup.clearCheck();
        c6_p629_3_RadioGroup.clearCheck(); c6_p629_4_RadioGroup.clearCheck();
        c6_p629_o_EditText.setText("");
        c6_p629_1_f_Spinner.setSelection(0); c6_p629_2_f_Spinner.setSelection(0);
        c6_p629_3_f_Spinner.setSelection(0); c6_p629_4_f_Spinner.setSelection(0);
        c6_p629_1_m_EditText.setText("");
        c6_p629_2_m_EditText.setText("");
        c6_p629_3_m_EditText.setText("");
        c6_p629_4_m_EditText.setText("");
    }

    public void inicio(){
        if(edad>=5){
            m6_p626_linearlayout.setVisibility(View.VISIBLE);
            m6_p627_linearlayout.setVisibility(View.VISIBLE);
            int pos_627 = c6_p627_RadioGroup.indexOfChild(c6_p627_RadioGroup.findViewById(c6_p627_RadioGroup.getCheckedRadioButtonId()));
            if(pos_627==1){
                limpiar_p628(); m6_p628_linearlayout.setVisibility(View.GONE);
            }else{
                m6_p628_linearlayout.setVisibility(View.VISIBLE);
            }
            if(edad>=14){
                m6_p629_linearlayout.setVisibility(View.VISIBLE);
            }else{
                limpiar_p629(); m6_p629_linearlayout.setVisibility(View.GONE);
            }
        }else{
            limpiar_p626(); limpiar_p627(); limpiar_p628(); limpiar_p629();
            m6_p626_linearlayout.setVisibility(View.GONE); m6_p627_linearlayout.setVisibility(View.GONE);
            m6_p628_linearlayout.setVisibility(View.GONE); m6_p629_linearlayout.setVisibility(View.GONE);
        }
    }
}
