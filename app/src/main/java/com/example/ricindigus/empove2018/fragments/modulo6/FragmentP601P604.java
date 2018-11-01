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

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP601P604 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c6_p601_RadioGroup, c6_p602_RadioGroup, c6_p603_RadioGroup,
            c6_p604_1_RadioGroup, c6_p604_2_RadioGroup, c6_p604_3_RadioGroup, c6_p604_4_RadioGroup,
            c6_p604_5_RadioGroup, c6_p604_6_RadioGroup, c6_p604_7_RadioGroup, c6_p604_8_RadioGroup,
            c6_p604_9_RadioGroup, c6_p604_10_RadioGroup, c6_p604_11_RadioGroup;
    EditText c6_p604_o_EditText;
    LinearLayout m6_p601_linearlayout, m6_p602_linearlayout, m6_p603_linearlayout, m6_p604_linearlayout;

    private int c6_p601;
    private int c6_p602;
    private int c6_p603;
    private int c6_p604_1;
    private int c6_p604_2;
    private int c6_p604_3;
    private int c6_p604_4;
    private int c6_p604_5;
    private int c6_p604_6;
    private int c6_p604_7;
    private int c6_p604_8;
    private int c6_p604_9;
    private int c6_p604_10;
    private int c6_p604_11;
    private String c6_p604_o;

    private int edad;

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
        if(residente.getC2_p205_a()=="") edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
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
                if(pos==0){
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
                if(pos==0){
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
                if(pos==0){
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
                if(pos==0){
                    c6_p604_o_EditText.setEnabled(true);
                    c6_p604_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p604_o_EditText.setText("");
                    c6_p604_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c6_p604_o_EditText.setEnabled(false);
                }
            }
        });
        c6_p604_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p604_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p604_o_EditText);
                    m6_p604_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p601,c6_p601+"");
        contentValues.put(SQLConstantes.modulo6_c6_p602,c6_p602+"");
        contentValues.put(SQLConstantes.modulo6_c6_p603,c6_p603+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_1,c6_p604_1+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_2,c6_p604_2+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_3,c6_p604_3+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_4,c6_p604_4+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_5,c6_p604_5+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_6,c6_p604_6+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_7,c6_p604_7+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_8,c6_p604_8+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_9,c6_p604_9+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_10,c6_p604_10+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_11,c6_p604_11+"");
        contentValues.put(SQLConstantes.modulo6_c6_p604_o,c6_p604_o);

        if(c6_p604_1==1 && c6_p604_2==1 && c6_p604_3==1 && c6_p604_4==1 && c6_p604_5==1 && c6_p604_6==1 &&
                c6_p604_7==1 && c6_p604_8==1 && c6_p604_9==1 && c6_p604_10==1 && c6_p604_11==1){
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
        }

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = new Modulo6();
            modulo6.setIdInformante(idInformante);
            modulo6.set_id(idEncuestado);
            modulo6.setIdVivienda(idVivienda);
            modulo6.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo6.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        if(edad<5){
            data.eliminarDato(getNombreTabla(),idEncuestado);
            Modulo6 modulo6 = new Modulo6();
            modulo6.setIdInformante(idInformante);
            modulo6.set_id(idEncuestado);
            modulo6.setIdVivienda(idVivienda);
            modulo6.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo6.toValues());
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        c6_p601 = c6_p601_RadioGroup.indexOfChild(c6_p601_RadioGroup.findViewById(c6_p601_RadioGroup.getCheckedRadioButtonId()));
        c6_p602 = c6_p602_RadioGroup.indexOfChild(c6_p602_RadioGroup.findViewById(c6_p602_RadioGroup.getCheckedRadioButtonId()));
        c6_p603 = c6_p603_RadioGroup.indexOfChild(c6_p603_RadioGroup.findViewById(c6_p603_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_1 = c6_p604_1_RadioGroup.indexOfChild(c6_p604_1_RadioGroup.findViewById(c6_p604_1_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_2 = c6_p604_2_RadioGroup.indexOfChild(c6_p604_2_RadioGroup.findViewById(c6_p604_2_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_3 = c6_p604_3_RadioGroup.indexOfChild(c6_p604_3_RadioGroup.findViewById(c6_p604_3_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_4 = c6_p604_4_RadioGroup.indexOfChild(c6_p604_4_RadioGroup.findViewById(c6_p604_4_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_5 = c6_p604_5_RadioGroup.indexOfChild(c6_p604_5_RadioGroup.findViewById(c6_p604_5_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_6 = c6_p604_6_RadioGroup.indexOfChild(c6_p604_6_RadioGroup.findViewById(c6_p604_6_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_7 = c6_p604_7_RadioGroup.indexOfChild(c6_p604_7_RadioGroup.findViewById(c6_p604_7_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_8 = c6_p604_8_RadioGroup.indexOfChild(c6_p604_8_RadioGroup.findViewById(c6_p604_8_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_9 = c6_p604_9_RadioGroup.indexOfChild(c6_p604_9_RadioGroup.findViewById(c6_p604_9_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_10 = c6_p604_10_RadioGroup.indexOfChild(c6_p604_10_RadioGroup.findViewById(c6_p604_10_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_11 = c6_p604_11_RadioGroup.indexOfChild(c6_p604_11_RadioGroup.findViewById(c6_p604_11_RadioGroup.getCheckedRadioButtonId()));
        c6_p604_o = c6_p604_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = data.getModulo6(idEncuestado);
            if(!(modulo6.getC6_p601().equals("-1") || modulo6.getC6_p601().equals("")))((RadioButton)c6_p601_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p601()))).setChecked(true);
            if(!(modulo6.getC6_p602().equals("-1") || modulo6.getC6_p602().equals("")))((RadioButton)c6_p602_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p602()))).setChecked(true);
            if(!(modulo6.getC6_p603().equals("-1") || modulo6.getC6_p603().equals("")))((RadioButton)c6_p603_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p603()))).setChecked(true);
            if(!(modulo6.getC6_p604_1().equals("-1") || modulo6.getC6_p604_1().equals("")))((RadioButton)c6_p604_1_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_1()))).setChecked(true);
            if(!(modulo6.getC6_p604_2().equals("-1") || modulo6.getC6_p604_2().equals("")))((RadioButton)c6_p604_2_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_2()))).setChecked(true);
            if(!(modulo6.getC6_p604_3().equals("-1") || modulo6.getC6_p604_3().equals("")))((RadioButton)c6_p604_3_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_3()))).setChecked(true);
            if(!(modulo6.getC6_p604_4().equals("-1") || modulo6.getC6_p604_4().equals("")))((RadioButton)c6_p604_4_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_4()))).setChecked(true);
            if(!(modulo6.getC6_p604_5().equals("-1") || modulo6.getC6_p604_5().equals("")))((RadioButton)c6_p604_5_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_5()))).setChecked(true);
            if(!(modulo6.getC6_p604_6().equals("-1") || modulo6.getC6_p604_6().equals("")))((RadioButton)c6_p604_6_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_6()))).setChecked(true);
            if(!(modulo6.getC6_p604_7().equals("-1") || modulo6.getC6_p604_7().equals("")))((RadioButton)c6_p604_7_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_7()))).setChecked(true);
            if(!(modulo6.getC6_p604_8().equals("-1") || modulo6.getC6_p604_8().equals("")))((RadioButton)c6_p604_8_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_8()))).setChecked(true);
            if(!(modulo6.getC6_p604_9().equals("-1") || modulo6.getC6_p604_9().equals("")))((RadioButton)c6_p604_9_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_9()))).setChecked(true);
            if(!(modulo6.getC6_p604_10().equals("-1") || modulo6.getC6_p604_10().equals("")))((RadioButton)c6_p604_10_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_10()))).setChecked(true);
            if(!(modulo6.getC6_p604_11().equals("-1") || modulo6.getC6_p604_11().equals("")))((RadioButton)c6_p604_11_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p604_11()))).setChecked(true);
            c6_p604_o_EditText.setText(modulo6.getC6_p604_o());

        }
        inicio();
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(c6_p601<0 && m6_p601_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 601: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c6_p602<0 && m6_p602_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 602: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c6_p603<0 && m6_p603_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 603: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(m6_p604_linearlayout.getVisibility()==View.VISIBLE) {
            if(c6_p604_1<0){
                mostrarMensaje("PREGUNTA 604-1: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_2<0){
                mostrarMensaje("PREGUNTA 604-2: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_3<0){
                mostrarMensaje("PREGUNTA 604-3: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_4<0){
                mostrarMensaje("PREGUNTA 604-4: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_5<0){
                mostrarMensaje("PREGUNTA 604-5: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_6<0){
                mostrarMensaje("PREGUNTA 604-6: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_7<0){
                mostrarMensaje("PREGUNTA 604-7: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_8<0){
                mostrarMensaje("PREGUNTA 604-8: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_9<0){
                mostrarMensaje("PREGUNTA 604-9: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_10<0){
                mostrarMensaje("PREGUNTA 604-10: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_11<0){
                mostrarMensaje("PREGUNTA 604-11: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p604_11==0){
                if(c6_p604_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 604 - OPCION 11: DEBE ESPECIFICAR OTRO");
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

    public void inicio(){
        int pos_601 = c6_p601_RadioGroup.indexOfChild(c6_p601_RadioGroup.findViewById(c6_p601_RadioGroup.getCheckedRadioButtonId()));
        int pos_602 = c6_p602_RadioGroup.indexOfChild(c6_p602_RadioGroup.findViewById(c6_p602_RadioGroup.getCheckedRadioButtonId()));
        int pos_603 = c6_p603_RadioGroup.indexOfChild(c6_p603_RadioGroup.findViewById(c6_p603_RadioGroup.getCheckedRadioButtonId()));

        if(edad>=5){
            m6_p601_linearlayout.setVisibility(View.VISIBLE); m6_p602_linearlayout.setVisibility(View.VISIBLE);
            m6_p603_linearlayout.setVisibility(View.VISIBLE); m6_p604_linearlayout.setVisibility(View.VISIBLE);
            if(pos_601==0){
                limpiar_p602(); limpiar_p603(); limpiar_p604();
                m6_p602_linearlayout.setVisibility(View.GONE); m6_p603_linearlayout.setVisibility(View.GONE);
                m6_p604_linearlayout.setVisibility(View.GONE);
            }else{
                if(pos_602==0){
                    limpiar_p603(); limpiar_p604();
                    m6_p603_linearlayout.setVisibility(View.GONE); m6_p604_linearlayout.setVisibility(View.GONE);
                }else{
                    if(pos_603==0){
                        limpiar_p604(); m6_p604_linearlayout.setVisibility(View.GONE);
                    }
                }
            }
        }else{
            limpiar_p601(); limpiar_p602(); limpiar_p603(); limpiar_p604();
            m6_p601_linearlayout.setVisibility(View.GONE); m6_p602_linearlayout.setVisibility(View.GONE);
            m6_p603_linearlayout.setVisibility(View.GONE); m6_p604_linearlayout.setVisibility(View.GONE);
        }
    }
}
