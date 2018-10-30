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
public class FragmentP501P505 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c5_p501_RadioGroup, c5_p503_RadioGroup, c5_p504_RadioGroup, c5_p505_RadioGroup;
    EditText c5_p502_c_EditText;
    CheckBox c5_p502_CheckBox;
    LinearLayout m5_p501_linearlayout, m5_p502_linearlayout, m5_p503_linearlayout, m5_p504_linearlayout,
            m5_p505_linearlayout;

    private int c5_p501;
    private String c5_p502_c;
    private int c5_p502;
    private int c5_p503;
    private int c5_p504;
    private int c5_p505;

    private int edad, sexo;

    @SuppressLint("ValidFragment")
    public FragmentP501P505(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idHogar = residente.getId_hogar();
        idVivienda = residente.getId_vivienda();
        idInformante = residente.get_id();//esto va a ha cambiar
        if(residente.getC2_p204()=="") sexo = -1; else sexo = Integer.parseInt(residente.getC2_p204());
        if(residente.getC2_p205_a()=="") edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
        data.close();
    }

    public FragmentP501P505() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p501_p505, container, false);

        c5_p501_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_501_radiogroup_C5_P501);
        c5_p502_c_EditText = (EditText) rootView.findViewById(R.id.mod5_502_edittext_C5_P502_C);
        c5_p502_CheckBox = (CheckBox) rootView.findViewById(R.id.mod5_502_checkbox_C5_P502);
        c5_p503_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_503_radiogroup_C5_P503);
        c5_p504_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_504_radiogroup_C5_P504);
        c5_p505_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_505_radiogroup_C5_P505);

        m5_p501_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p501);
        m5_p502_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p502);
        m5_p503_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p503);
        m5_p504_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p504);
        m5_p505_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p505);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);c5_p502_c_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        c5_p501_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c5_p501_RadioGroup.findViewById(c5_p501_RadioGroup.getCheckedRadioButtonId()));
                if(pos>=0 && pos<=5){
                    m5_p502_linearlayout.setVisibility(View.GONE); limpiar_p502();
                }else{
                    m5_p502_linearlayout.setVisibility(View.VISIBLE);
                }
            }
        });

        c5_p502_c_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p502_c_EditText);
                    m5_p502_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });

        c5_p502_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c5_p502_c_EditText.setText("");
                    c5_p502_c_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c5_p502_c_EditText.setEnabled(false);
                }else{
                    c5_p502_c_EditText.setEnabled(true);
                    c5_p502_c_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
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
        contentValues.put(SQLConstantes.modulo5_c5_p501,c5_p501+"");
        contentValues.put(SQLConstantes.modulo5_c5_p502_c,c5_p502_c);
        contentValues.put(SQLConstantes.modulo5_c5_p502,c5_p502+"");
        contentValues.put(SQLConstantes.modulo5_c5_p503,c5_p503+"");
        contentValues.put(SQLConstantes.modulo5_c5_p504,c5_p504+"");
        contentValues.put(SQLConstantes.modulo5_c5_p505,c5_p505+"");

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo5 modulo5 = new Modulo5();
            modulo5.setIdInformante(idInformante);
            modulo5.set_id(idEncuestado);
            modulo5.setIdVivienda(idVivienda);
            modulo5.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo5.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        c5_p501 = c5_p501_RadioGroup.indexOfChild(c5_p501_RadioGroup.findViewById(c5_p501_RadioGroup.getCheckedRadioButtonId()));
        c5_p502_c = c5_p502_c_EditText.getText().toString();
        if(c5_p502_CheckBox.isChecked()) c5_p502 = 1; else c5_p502 = 0;
        c5_p503 = c5_p503_RadioGroup.indexOfChild(c5_p503_RadioGroup.findViewById(c5_p503_RadioGroup.getCheckedRadioButtonId()));
        c5_p504 = c5_p504_RadioGroup.indexOfChild(c5_p504_RadioGroup.findViewById(c5_p504_RadioGroup.getCheckedRadioButtonId()));
        c5_p505 = c5_p505_RadioGroup.indexOfChild(c5_p505_RadioGroup.findViewById(c5_p505_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo5 modulo5 = data.getModulo5(idEncuestado);
            if(!(modulo5.getC5_p501().equals("-1") || modulo5.getC5_p501().equals("")))((RadioButton)c5_p501_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p501()))).setChecked(true);
            c5_p502_c_EditText.setText(modulo5.getC5_p502_c());
            if(modulo5.getC5_p502().equals("0")) c5_p502_CheckBox.setChecked(false);
            if(modulo5.getC5_p502().equals("1")) c5_p502_CheckBox.setChecked(true);
            if(!(modulo5.getC5_p503().equals("-1") || modulo5.getC5_p503().equals("")))((RadioButton)c5_p503_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p503()))).setChecked(true);
            if(!(modulo5.getC5_p504().equals("-1") || modulo5.getC5_p504().equals("")))((RadioButton)c5_p504_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p504()))).setChecked(true);
            if(!(modulo5.getC5_p505().equals("-1") || modulo5.getC5_p505().equals("")))((RadioButton)c5_p505_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p505()))).setChecked(true);
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(c5_p501<0 && m5_p501_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 501: DEBE SELECCIONAR UNA OPCION");
            //c5_p501_RadioGroup.requestFocus();
            return false;
        }
        if(c5_p502==0 && m5_p502_linearlayout.getVisibility()==View.VISIBLE){
            if(c5_p502_c.trim().length()==0){
                mostrarMensaje("PREGUNTA 502: DEBE SELECCIONAR O ESPECIFICAR");
                return false;
            }
        }
        if(c5_p503<0 && m5_p503_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 503: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c5_p504<0 && m5_p504_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 504: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c5_p505<0 && m5_p505_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 505: DEBE SELECCIONAR UNA OPCION");
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

    public void limpiar_p502(){
        c5_p502_c_EditText.setText("");
        c5_p502_CheckBox.setChecked(false);
    }
}
