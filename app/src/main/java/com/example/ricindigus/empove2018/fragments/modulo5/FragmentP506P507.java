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
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
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
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP506P507 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c5_p506_1_RadioGroup, c5_p506_4_1_RadioGroup, c5_p506_4_2_RadioGroup, c5_p506_4_3_RadioGroup,
                c5_p506_4_4_RadioGroup, c5_p506_4_5_RadioGroup, c5_p506_4_6_RadioGroup ;
    EditText c5_p506_2_1_EditText, c5_p506_3_EditText, c5_p506_2_3_EditText, c5_p506_2_4_EditText, c5_p506_2_5_EditText, c5_p506_2_6_EditText;
    RadioGroup c5_p507_RadioGroup;
    Spinner c5_p507_dist_Spinner,  c5_p507_prov_Spinner, c5_p507_dep_Spinner;
    LinearLayout m5_p506_linearlayout, m5_p507_linearlayout;
    LinearLayout m5_p506_1_linearlayout, m5_p506_2_linearlayout, m5_p506_3_linearlayout, m5_p506_4_linearlayout,
            m5_p506_5_linearlayout, m5_p506_6_linearlayout;


    private String c5_p504="";
    private String c5_p505="";
    private int c5_p506_1=-1;
    private String c5_p506_2;
    private String c5_p506_3;
    private int c5_p506_4;
    private int c5_p507;
    private int c5_p507_dist;
    private int c5_p507_prov;
    private int c5_p507_dep;

    private int edad, sexo;

    @SuppressLint("ValidFragment")
    public FragmentP506P507(String idEncuestado, Context context) {
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

    public FragmentP506P507() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p506_p507, container, false);
        c5_p506_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_radiogroup_C5_P506_1);
        c5_p506_2_1_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp1_textview_C5_P506_2);
        c5_p506_3_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp2_textview_C5_P506_3);
        c5_p506_2_3_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp3_textview_C5_P506_2);
        c5_p506_2_4_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp4_textview_C5_P506_2);
        c5_p506_2_5_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp5_textview_C5_P506_2);
        c5_p506_2_6_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp6_textview_C5_P506_2);
        c5_p506_4_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp1_radiogroup_C5_P506_4);
        c5_p506_4_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp2_radiogroup_C5_P506_4);
        c5_p506_4_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp3_radiogroup_C5_P506_4);
        c5_p506_4_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp4_radiogroup_C5_P506_4);
        c5_p506_4_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp5_radiogroup_C5_P506_4);
        c5_p506_4_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp6_radiogroup_C5_P506_4);
        c5_p507_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_507_radiogroup_C5_P507);
        c5_p507_dist_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_DIST);
        c5_p507_prov_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_PROV);
        c5_p507_dep_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_DEP);

        m5_p506_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p506);
        m5_p506_1_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_506_1);
        m5_p506_2_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_506_2);
        m5_p506_3_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_506_3);
        m5_p506_4_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_506_4);
        m5_p506_5_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_506_5);
        m5_p506_6_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_506_6);
        m5_p507_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p507);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c5_p506_1_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                seleccionar_506();
            }
        });
        c5_p506_2_1_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p506_2_1_EditText);
                    m5_p506_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p506_3_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p506_3_EditText);
                    m5_p506_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p506_2_3_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p506_2_3_EditText);
                    m5_p506_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p506_2_4_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p506_2_4_EditText);
                    m5_p506_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p506_2_5_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p506_2_5_EditText);
                    m5_p506_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p506_2_6_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p506_2_6_EditText);
                    m5_p506_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p506_2_1_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});
        c5_p506_3_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});
        c5_p506_2_3_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});
        c5_p506_2_4_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});
        c5_p506_2_5_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});
        c5_p506_2_6_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});
        //Log.e("onViewCreated", "c5_p506_2_1_EditText.getInputType()-1: "+ c5_p506_2_1_EditText.getInputType());
        c5_p506_2_1_EditText.setInputType(18);
        c5_p506_3_EditText.setInputType(18);
        c5_p506_2_3_EditText.setInputType(18);
        c5_p506_2_4_EditText.setInputType(18);
        c5_p506_2_5_EditText.setInputType(18);
        c5_p506_2_6_EditText.setInputType(18);

        c5_p506_2_1_EditText.setTransformationMethod(null);
        c5_p506_3_EditText.setTransformationMethod(null);
        c5_p506_2_3_EditText.setTransformationMethod(null);
        c5_p506_2_4_EditText.setTransformationMethod(null);
        c5_p506_2_5_EditText.setTransformationMethod(null);
        c5_p506_2_6_EditText.setTransformationMethod(null);

        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_c5_p506_1,c5_p506_1+"");
        contentValues.put(SQLConstantes.modulo5_c5_p506_2,c5_p506_2);
        contentValues.put(SQLConstantes.modulo5_c5_p506_3,c5_p506_3);
        contentValues.put(SQLConstantes.modulo5_c5_p506_4,c5_p506_4+"");
        contentValues.put(SQLConstantes.modulo5_c5_p507,c5_p507+"");
        contentValues.put(SQLConstantes.modulo5_c5_p507_dist,c5_p507_dist+"");
        contentValues.put(SQLConstantes.modulo5_c5_p507_prov,c5_p507_prov+"");
        contentValues.put(SQLConstantes.modulo5_c5_p507_dep,c5_p507_dep+"");

        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        inicio();
        data.close();
    }

    @Override
    public void llenarVariables() {
        String nombre_radio_506 = c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId())+"";
        String ultimo = nombre_radio_506.substring(nombre_radio_506.length() - 2,nombre_radio_506.length() - 1);
        int pos = -1;
        c5_p506_1 = c5_p506_1_RadioGroup.indexOfChild(c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId()));
        if(c5_p506_1>-1){
            pos = Integer.parseInt(ultimo);
            pos--;
        }
        c5_p506_1 = pos;
        switch (pos){
            case 0: c5_p506_2 = c5_p506_2_1_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_1_RadioGroup.indexOfChild(c5_p506_4_1_RadioGroup.findViewById(c5_p506_4_1_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 1: c5_p506_3 = c5_p506_3_EditText.getText().toString(); c5_p506_2 = "";
                    c5_p506_4 = c5_p506_4_2_RadioGroup.indexOfChild(c5_p506_4_2_RadioGroup.findViewById(c5_p506_4_2_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 2: c5_p506_2 = c5_p506_2_3_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_3_RadioGroup.indexOfChild(c5_p506_4_3_RadioGroup.findViewById(c5_p506_4_3_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 3: c5_p506_2 = c5_p506_2_4_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_4_RadioGroup.indexOfChild(c5_p506_4_4_RadioGroup.findViewById(c5_p506_4_4_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 4: c5_p506_2 = c5_p506_2_5_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_5_RadioGroup.indexOfChild(c5_p506_4_5_RadioGroup.findViewById(c5_p506_4_5_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 5: c5_p506_2 = c5_p506_2_6_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_6_RadioGroup.indexOfChild(c5_p506_4_6_RadioGroup.findViewById(c5_p506_4_6_RadioGroup.getCheckedRadioButtonId()));
                    break;
            default: c5_p506_2 = ""; c5_p506_3 = ""; c5_p506_4 = -1; break;
        }

        c5_p506_3 = c5_p506_3_EditText.getText().toString();
        c5_p507 = c5_p507_RadioGroup.indexOfChild(c5_p507_RadioGroup.findViewById(c5_p507_RadioGroup.getCheckedRadioButtonId()));
        c5_p507_dist = c5_p507_dist_Spinner.getSelectedItemPosition();
        c5_p507_prov = c5_p507_prov_Spinner.getSelectedItemPosition();
        c5_p507_dep = c5_p507_dep_Spinner.getSelectedItemPosition();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo5 modulo5 = data.getModulo5(idEncuestado);
            c5_p504 = modulo5.getC5_p504();
            c5_p505 = modulo5.getC5_p505();
            if(!(modulo5.getC5_p506_1().equals("-1") || modulo5.getC5_p506_1().equals(""))) {
                c5_p506_1 = Integer.parseInt(modulo5.getC5_p506_1());
//                Log.e("cargarDatos", "c5_p506_1: "+c5_p506_1);
                int pos = -1;
                switch(Integer.parseInt(modulo5.getC5_p506_1())){
                    case 0: pos = 0; break;
                    case 1: pos = 2; break;
                    case 2: pos = 4; break;
                    case 3: pos = 6; break;
                    case 4: pos = 8; break;
                    case 5: pos = 10; break;
                }
                ((RadioButton) c5_p506_1_RadioGroup.getChildAt(pos)).setChecked(true);
                switch (modulo5.getC5_p506_1()) {
                    case "0":
                        c5_p506_2_1_EditText.setText(modulo5.getC5_p506_2());
                        if (!(modulo5.getC5_p506_4().equals("-1") || modulo5.getC5_p506_4().equals(""))){
                            ((RadioButton) c5_p506_4_1_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p506_4()))).setChecked(true);
                        }
                        break;
                    case "1":
                        c5_p506_3_EditText.setText(modulo5.getC5_p506_3());
                        if (!(modulo5.getC5_p506_4().equals("-1") || modulo5.getC5_p506_4().equals(""))){
                            ((RadioButton) c5_p506_4_2_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p506_4()))).setChecked(true);
                        }
                        break;
                    case "2":
                        c5_p506_2_3_EditText.setText(modulo5.getC5_p506_2());
                        if (!(modulo5.getC5_p506_4().equals("-1") || modulo5.getC5_p506_4().equals(""))){
                            ((RadioButton) c5_p506_4_3_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p506_4()))).setChecked(true);
                        }
                        break;
                    case "3":
                        c5_p506_2_4_EditText.setText(modulo5.getC5_p506_2());
                        if (!(modulo5.getC5_p506_4().equals("-1") || modulo5.getC5_p506_4().equals(""))){
                            ((RadioButton) c5_p506_4_4_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p506_4()))).setChecked(true);
                        }
                        break;
                    case "4":
                        c5_p506_2_5_EditText.setText(modulo5.getC5_p506_2());
                        if (!(modulo5.getC5_p506_4().equals("-1") || modulo5.getC5_p506_4().equals(""))){
                            ((RadioButton) c5_p506_4_5_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p506_4()))).setChecked(true);
                        }
                        break;
                    case "5":
                        c5_p506_2_6_EditText.setText(modulo5.getC5_p506_2());
                        if (!(modulo5.getC5_p506_4().equals("-1") || modulo5.getC5_p506_4().equals(""))){
                            ((RadioButton) c5_p506_4_6_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p506_4()))).setChecked(true);
                        }
                        break;
                }
            }
            if(!(modulo5.getC5_p507().equals("-1") || modulo5.getC5_p507().equals("")))((RadioButton)c5_p507_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p507()))).setChecked(true);
            if(!modulo5.getC5_p507_dist().equals("")) c5_p507_dist_Spinner.setSelection(Integer.parseInt(modulo5.getC5_p507_dist()));
            if(!modulo5.getC5_p507_prov().equals("") )c5_p507_prov_Spinner.setSelection(Integer.parseInt(modulo5.getC5_p507_prov()));
            if(!modulo5.getC5_p507_dep().equals("")) c5_p507_dep_Spinner.setSelection(Integer.parseInt(modulo5.getC5_p507_dep()));
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
        if(m5_p506_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p506_1<0){
                mostrarMensaje("PREGUNTA 506: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
//            Log.e("validarDatos", "c5_p506_1: "+c5_p506_1 );
            if(c5_p506_1==1){
                if(c5_p506_3.trim().length()==0){
                    mostrarMensaje("PREGUNTA 506: DEBE INGRESAR GRADO");
                    return false;
                }
            }else{
                if(c5_p506_2.trim().length()==0){
                    mostrarMensaje("PREGUNTA 506: DEBE INGRESAR AÑO");
                    return false;
                }
            }
            if(c5_p506_4<0){
                mostrarMensaje("PREGUNTA 506-OPCION 1: DEBE SELECCIONAR CENTRO DE ESTUDIOS");
                return false;
            }
        }
        if(m5_p507_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p507<0){
                mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c5_p507==2){
                if(c5_p507_dist<0){
                    mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR DISTRITO");
                    return false;
                }
                if(c5_p507_prov<0){
                    mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR PROVINCIA");
                    return false;
                }
                if(c5_p507_dep<0){
                    mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR DEPARTAMENTO");
                    return false;
                }
            }
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

    public void limpiar_p506_1(){
        c5_p506_2_1_EditText.setText(""); c5_p506_4_1_RadioGroup.clearCheck();
    }

    public void limpiar_p506_2(){
        c5_p506_3_EditText.setText(""); c5_p506_4_2_RadioGroup.clearCheck();
    }

    public void limpiar_p506_3(){
        c5_p506_2_3_EditText.setText(""); c5_p506_4_3_RadioGroup.clearCheck();
    }

    public void limpiar_p506_4(){
        c5_p506_2_4_EditText.setText(""); c5_p506_4_4_RadioGroup.clearCheck();
    }

    public void limpiar_p506_5(){
        c5_p506_2_5_EditText.setText(""); c5_p506_4_5_RadioGroup.clearCheck();
    }

    public void limpiar_p506_6(){
        c5_p506_2_6_EditText.setText(""); c5_p506_4_6_RadioGroup.clearCheck();
    }

    public void limpiar_p506(){
        c5_p506_1_RadioGroup.clearCheck(); limpiar_p506_1(); limpiar_p506_2(); limpiar_p506_3();
        limpiar_p506_4(); limpiar_p506_5(); limpiar_p506_6();
    }

    public void limpiar_p507(){
        c5_p507_RadioGroup.clearCheck();
        c5_p507_dist_Spinner.setSelection(-1);
        c5_p507_prov_Spinner.setSelection(-1);
        c5_p507_dep_Spinner.setSelection(-1);
    }

    public void seleccionar_506(){
        int pos;// = c5_p506_1_RadioGroup.indexOfChild(c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId()));
//        Log.e("seleccionar_506", "c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId()): " + c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId()));
//        Log.e("seleccionar_506", "c5_p506_1_RadioGroup.getCheckedRadioButtonId(): " + c5_p506_1_RadioGroup.getCheckedRadioButtonId());

        String nombre_radio_506 = c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId())+"";
        String ultimo = nombre_radio_506.substring(nombre_radio_506.length() - 2,nombre_radio_506.length() - 1);
//        Log.e("seleccionar_506", "radio_506: " + c5_p506_1_RadioGroup.indexOfChild(c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId())));
//        Log.e("seleccionar_506", "ultimo: " + ultimo);
        pos = Integer.parseInt(ultimo);
//        Log.e("seleccionar_506", "pos: " + pos);
        pos--;
        switch(pos){
            case 0:
                m5_p506_1_linearlayout.setVisibility(View.VISIBLE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                limpiar_p506_2(); limpiar_p506_3();
                limpiar_p506_4(); limpiar_p506_5(); limpiar_p506_6();
                break;
            case 1:
                m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.VISIBLE);
                m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                limpiar_p506_1(); limpiar_p506_3();
                limpiar_p506_4(); limpiar_p506_5(); limpiar_p506_6();
                break;
            case 2:
                m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                m5_p506_3_linearlayout.setVisibility(View.VISIBLE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                limpiar_p506_1(); limpiar_p506_3();
                limpiar_p506_4(); limpiar_p506_5(); limpiar_p506_6();
                break;
            case 3:
                m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.VISIBLE);
                m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                limpiar_p506_1(); limpiar_p506_2();
                limpiar_p506_4(); limpiar_p506_5(); limpiar_p506_6();
                break;
            case 4:
                m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                m5_p506_5_linearlayout.setVisibility(View.VISIBLE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                limpiar_p506_1(); limpiar_p506_2(); limpiar_p506_3();
                limpiar_p506_5(); limpiar_p506_6();
                break;
            case 5:
                m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.VISIBLE);
                limpiar_p506_1(); limpiar_p506_2(); limpiar_p506_3();
                limpiar_p506_4(); limpiar_p506_6();
                break;
            default:
                m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                limpiar_p506_1(); limpiar_p506_2(); limpiar_p506_3();
                limpiar_p506_4(); limpiar_p506_5(); limpiar_p506_6();
                break;
        }
    }

    public void inicio(){
        if(c5_p504.equals("1") && c5_p505.equals("1")){
            limpiar_p506(); limpiar_p507();
            m5_p506_linearlayout.setVisibility(View.GONE);
            m5_p507_linearlayout.setVisibility(View.GONE);
        }else{
            m5_p506_linearlayout.setVisibility(View.VISIBLE);
            m5_p507_linearlayout.setVisibility(View.VISIBLE);
//            Log.e("inicio", "c5_p506_1: "+c5_p506_1);
            switch(c5_p506_1){
                case 0:
                    m5_p506_1_linearlayout.setVisibility(View.VISIBLE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                    m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                    m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                    break;
                case 1:
                    m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.VISIBLE);
                    m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                    m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                    break;
                case 2:
                    m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                    m5_p506_3_linearlayout.setVisibility(View.VISIBLE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                    m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                    break;
                case 3:
                    m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                    m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.VISIBLE);
                    m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                    break;
                case 4:
                    m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                    m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                    m5_p506_5_linearlayout.setVisibility(View.VISIBLE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                    break;
                case 5:
                    m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                    m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                    m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.VISIBLE);
                    break;
                default:
                    m5_p506_1_linearlayout.setVisibility(View.GONE); m5_p506_2_linearlayout.setVisibility(View.GONE);
                    m5_p506_3_linearlayout.setVisibility(View.GONE); m5_p506_4_linearlayout.setVisibility(View.GONE);
                    m5_p506_5_linearlayout.setVisibility(View.GONE); m5_p506_6_linearlayout.setVisibility(View.GONE);
                    break;
            }
        }
    }
}
