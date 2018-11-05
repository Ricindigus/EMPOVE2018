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

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP630 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c6_p630_1_RadioGroup, c6_p630_1med_RadioGroup;
    EditText c6_p630_1o_EditText;
    Spinner c6_p630_1frec_Spinner, c6_p630_1mont_Spinner;
    RadioGroup c6_p630_2_RadioGroup, c6_p630_2med_RadioGroup;
    EditText c6_p630_2o_EditText;
    Spinner c6_p630_2frec_Spinner, c6_p630_2mont_Spinner;
    LinearLayout m6_p630_linearlayout;
//    LinearLayout m6_p630_1_linearlayout, m6_p630_2_linearlayout;

    private int c6_p630_1;
    private int c6_p630_1med;
    private String c6_p630_1o;
    private int c6_p630_1frec;
    private int c6_p630_1mont;
    private int c6_p630_2;
    private int c6_p630_2med;
    private String c6_p630_2o;
    private int c6_p630_2frec;
    private int c6_p630_2mont;

    private int edad;

    @SuppressLint("ValidFragment")
    public FragmentP630(String idEncuestado, Context context) {
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

    public FragmentP630() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p630, container, false);

        c6_p630_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_1);
        c6_p630_1med_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_1_MED);
        c6_p630_1o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_1_O);
        c6_p630_1frec_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_1_FREC);
        c6_p630_1mont_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_1_MONT);

        c6_p630_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_2);
        c6_p630_2med_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_2_MED);
        c6_p630_2o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_2_O);
        c6_p630_2frec_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_2_FREC);
        c6_p630_2mont_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_2_MONT);

        m6_p630_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p630);
//        m6_p630_1_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_630_1);
//        m6_p630_2_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_630_2);

        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c6_p630_1o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p630_1o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p630_1o_EditText);
                    m6_p630_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p630_2o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p630_2o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p630_2o_EditText);
                    m6_p630_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p630_1_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p630_1_RadioGroup.findViewById(c6_p630_1_RadioGroup.getCheckedRadioButtonId()));
                Log.e("pos", "onCheckedChanged: "+pos );
                if(pos==0){
//                    m6_p630_1_linearlayout.setVisibility(View.VISIBLE);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(0)).setEnabled(true);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(1)).setEnabled(true);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(2)).setEnabled(true);
                    c6_p630_1frec_Spinner.setEnabled(true);
                    c6_p630_1mont_Spinner.setEnabled(true);
                }else{
                    limpiar_p630_1();
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(0)).setEnabled(false);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(1)).setEnabled(false);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(2)).setEnabled(false);
                    c6_p630_1o_EditText.setEnabled(false);
                    c6_p630_1frec_Spinner.setEnabled(false);
                    c6_p630_1mont_Spinner.setEnabled(false);
//                    m6_p630_1_linearlayout.setVisibility(View.GONE);
                }
            }
        });
        c6_p630_2_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p630_2_RadioGroup.findViewById(c6_p630_2_RadioGroup.getCheckedRadioButtonId()));
                if(pos==0){
//                    m6_p630_2_linearlayout.setVisibility(View.VISIBLE);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(0)).setEnabled(true);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(1)).setEnabled(true);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(2)).setEnabled(true);
                    c6_p630_2frec_Spinner.setEnabled(true);
                    c6_p630_2mont_Spinner.setEnabled(true);
                }else{
                    limpiar_p630_2();
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(0)).setEnabled(false);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(1)).setEnabled(false);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(2)).setEnabled(false);
                    c6_p630_2o_EditText.setEnabled(false);
                    c6_p630_2frec_Spinner.setEnabled(false);
                    c6_p630_2mont_Spinner.setEnabled(false);
//                    m6_p630_2_linearlayout.setVisibility(View.GONE);
                }
            }
        });
        c6_p630_1med_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p630_1med_RadioGroup.findViewById(c6_p630_1med_RadioGroup.getCheckedRadioButtonId()));
                if(pos==2){
                    c6_p630_1o_EditText.setEnabled(true);
                    c6_p630_1o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p630_1o_EditText.setText("");
                    c6_p630_1o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c6_p630_1o_EditText.setEnabled(false);
                }
            }
        });
        c6_p630_2med_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p630_2med_RadioGroup.findViewById(c6_p630_2med_RadioGroup.getCheckedRadioButtonId()));
                if(pos==2){
                    c6_p630_2o_EditText.setEnabled(true);
                    c6_p630_2o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p630_2o_EditText.setText("");
                    c6_p630_2o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c6_p630_2o_EditText.setEnabled(false);
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
        contentValues.put(SQLConstantes.modulo6_c6_p630_1,c6_p630_1+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1med,c6_p630_1med+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1o,c6_p630_1o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1frec,c6_p630_1frec+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1mont,c6_p630_1mont+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2,c6_p630_2+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2med,c6_p630_2med+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2o,c6_p630_2o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2frec,c6_p630_2frec+"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2mont,c6_p630_2mont+"");

        Log.e("c6_p630_1med", "guardarDatos: " + c6_p630_1med);
        Log.e("c6_p630_1o", "guardarDatos: " + c6_p630_1o);
        Log.e("c6_p630_1frec", "guardarDatos: " + c6_p630_1frec);
        Log.e("c6_p630_1mont", "guardarDatos: " + c6_p630_1mont);

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
        c6_p630_1 = c6_p630_1_RadioGroup.indexOfChild(c6_p630_1_RadioGroup.findViewById(c6_p630_1_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_1med = c6_p630_1med_RadioGroup.indexOfChild(c6_p630_1med_RadioGroup.findViewById(c6_p630_1med_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_1o = c6_p630_1o_EditText.getText().toString();
        c6_p630_1frec = c6_p630_1frec_Spinner.getSelectedItemPosition();
        c6_p630_1mont = c6_p630_1mont_Spinner.getSelectedItemPosition();
        c6_p630_2 = c6_p630_2_RadioGroup.indexOfChild(c6_p630_2_RadioGroup.findViewById(c6_p630_2_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_2med = c6_p630_2med_RadioGroup.indexOfChild(c6_p630_2med_RadioGroup.findViewById(c6_p630_2med_RadioGroup.getCheckedRadioButtonId()));
        c6_p630_2o = c6_p630_2o_EditText.getText().toString();
        c6_p630_2frec = c6_p630_2frec_Spinner.getSelectedItemPosition();
        c6_p630_2mont = c6_p630_2mont_Spinner.getSelectedItemPosition();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = data.getModulo6(idEncuestado);
            if(!(modulo6.getC6_p630_1().equals("-1") || modulo6.getC6_p630_1().equals("")))((RadioButton)c6_p630_1_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p630_1()))).setChecked(true);
            if(!(modulo6.getC6_p630_1med().equals("-1") || modulo6.getC6_p630_1med().equals("")))((RadioButton)c6_p630_1med_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p630_1med()))).setChecked(true);
            c6_p630_1o_EditText.setText(modulo6.getC6_p630_1o());
            if(!modulo6.getC6_p630_1frec().equals("")) c6_p630_1frec_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p630_1frec()));
            if(!modulo6.getC6_p630_1mont().equals("")) c6_p630_1mont_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p630_1mont()));
            if(!(modulo6.getC6_p630_2().equals("-1") || modulo6.getC6_p630_2().equals("")))((RadioButton)c6_p630_2_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p630_2()))).setChecked(true);
            if(!(modulo6.getC6_p630_2med().equals("-1") || modulo6.getC6_p630_2med().equals("")))((RadioButton)c6_p630_2med_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p630_2med()))).setChecked(true);
            c6_p630_2o_EditText.setText(modulo6.getC6_p630_2o());
            if(!modulo6.getC6_p630_2frec().equals("")) c6_p630_2frec_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p630_2frec()));
            if(!modulo6.getC6_p630_2mont().equals("")) c6_p630_2mont_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p630_2mont()));
            Log.e("getC6_p630_1med", "cargarDatos: "+modulo6.getC6_p630_1med() );
            Log.e("getC6_p630_1o", "cargarDatos: "+modulo6.getC6_p630_1o() );
            Log.e("getC6_p630_1frec", "cargarDatos: "+modulo6.getC6_p630_1frec() );
            Log.e("getC6_p630_1mont", "cargarDatos: "+modulo6.getC6_p630_1mont() );
//            ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(0)).setChecked(true);

        }
//        inicio();
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(m6_p630_linearlayout.getVisibility()==View.VISIBLE){
            if (c6_p630_1 < 0) {
                mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
//            if(m6_p630_1_linearlayout.getVisibility()==View.VISIBLE) {
                if (c6_p630_1 == 0) {
                    if (c6_p630_1med == 2) {
                        if (c6_p630_1o.trim().length() == 0) {
                            mostrarMensaje("PREGUNTA 630-A: DEBE ESPECIFICAR OTRO");
                            return false;
                        }
                    }
                    if (c6_p630_1frec == 0) {
                        mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR FRECUENCIA");
                        return false;
                    }
                    if (c6_p630_1mont == 0) {
                        mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR MONTO");
                        return false;
                    }
                }
//            }
            if (c6_p630_2 < 0) {
                mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
//            if(m6_p630_2_linearlayout.getVisibility()==View.VISIBLE) {
                if (c6_p630_2 == 0) {
                    if (c6_p630_2med < 0) {
                        mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR MEDIO DE ENVIO");
                        return false;
                    }
                    if (c6_p630_2med == 2) {
                        if (c6_p630_2o.trim().length() == 0) {
                            mostrarMensaje("PREGUNTA 630-B: DEBE ESPECIFICAR OTRO");
                            return false;
                        }
                    }
                    if (c6_p630_2frec == 0) {
                        mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR FRECUENCIA");
                        return false;
                    }
                    if (c6_p630_2mont == 0) {
                        mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR MONTO");
                        return false;
                    }
//                }
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

    public void limpiar_p630_1(){
        c6_p630_1med_RadioGroup.clearCheck();
        c6_p630_1o_EditText.setText("");
        c6_p630_1frec_Spinner.setSelection(0);
        c6_p630_1mont_Spinner.setSelection(0);
    }

    public void limpiar_p630_2(){
        c6_p630_1med_RadioGroup.clearCheck();
        c6_p630_1o_EditText.setText("");
        c6_p630_1frec_Spinner.setSelection(0);
        c6_p630_1mont_Spinner.setSelection(0);
    }

    public void inicio(){
        if(edad>=14){
            m6_p630_linearlayout.setVisibility(View.VISIBLE);

        }else{
            c6_p630_1_RadioGroup.clearCheck(); limpiar_p630_1();
            c6_p630_2_RadioGroup.clearCheck(); limpiar_p630_2();
            m6_p630_linearlayout.setVisibility(View.GONE);
        }
    }
}
