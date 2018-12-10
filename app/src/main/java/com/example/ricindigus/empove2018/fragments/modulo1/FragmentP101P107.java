package com.example.ricindigus.empove2018.fragments.modulo1;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1V;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP101P107 extends FragmentPagina {

    Context context;


    RadioGroup c1_p101_RadioGroup, c1_p102_RadioGroup, c1_p103_RadioGroup, c1_p104_RadioGroup;
    EditText c1_p101_o_EditText, c1_p102_o_EditText, c1_p103_o_EditText, c1_p104_o_EditText;
    EditText c1_p105_EditText,c1_p106_EditText,c1_p107_EditText;

    LinearLayout m1_p101_linearlayout, m1_p102_linearlayout, m1_p103_linearlayout,
            m1_p104_linearlayout, m1_p105_linearlayout, m1_p106_linearlayout, m1_p107_linearlayout;

    private String idHogar;
    private String idVivienda;
    private int c1_p101;
    private String c1_p101_o;
    private int c1_p102;
    private String c1_p102_o;
    private int c1_p103;
    private String c1_p103_o;
    private int c1_p104;
    private String c1_p104_o;
    private String c1_p105;
    private String c1_p106;
    private String c1_p107;



    public FragmentP101P107() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP101P107(String idHogar, String idVivienda, Context context) {
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p101_p107, container, false);
        c1_p101_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_101_radiogroup_C1_P101);
        c1_p101_o_EditText = (EditText) rootView.findViewById(R.id.mod1_101_edittext_C1_P101_O);
        c1_p102_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_102_radiogroup_C1_P102);
        c1_p102_o_EditText = (EditText) rootView.findViewById(R.id.mod1_102_edittext_C1_P102_O);
        c1_p103_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_103_radiogroup_C1_P103);
        c1_p103_o_EditText = (EditText) rootView.findViewById(R.id.mod1_103_edittext_C1_P103_O);
        c1_p104_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_104_radiogroup_C1_P104);
        c1_p104_o_EditText = (EditText) rootView.findViewById(R.id.mod1_104_edittext_C1_P104_O);
        c1_p105_EditText = (EditText) rootView.findViewById(R.id.mod1_105_edittext_C1_P105);
        c1_p106_EditText = (EditText) rootView.findViewById(R.id.mod1_106_edittext_C1_P106);
        c1_p107_EditText = (EditText) rootView.findViewById(R.id.mod1_107_edittext_C1_P107);

        m1_p101_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p101);
        m1_p102_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p102);
        m1_p103_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p103);
        m1_p104_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p104);
        m1_p105_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p105);
        m1_p106_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p106);
        m1_p107_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p107);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c1_p101_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,8,c1_p101_o_EditText);
            }
        });

        c1_p102_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,9,c1_p102_o_EditText);
            }
        });

        c1_p103_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,8,c1_p103_o_EditText);
            }
        });

        c1_p104_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,7,c1_p104_o_EditText);
            }
        });

        configurarEditText(c1_p101_o_EditText,m1_p101_linearlayout,0,30);
        configurarEditText(c1_p102_o_EditText,m1_p102_linearlayout,0,30);
        configurarEditText(c1_p103_o_EditText,m1_p103_linearlayout,0,30);
        configurarEditText(c1_p104_o_EditText,m1_p104_linearlayout,0,30);

        configurarEditText(c1_p105_EditText,m1_p105_linearlayout,2,2);
        configurarEditText(c1_p106_EditText,m1_p106_linearlayout,2,2);
        configurarEditText(c1_p107_EditText,m1_p107_linearlayout,2,2);

        cargarDatos();
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
                    view.requestFocus();
                    return true;
                }
                return false;
            }
        });
//        if (tipo == 2) {
//            editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(longitud)});
//            editText.setInputType(18);
//            editText.setTransformationMethod(null);
//        }
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo1_v_c1_p101,c1_p101);
        contentValues.put(SQLConstantes.modulo1_v_c1_p101_o,c1_p101_o);
        contentValues.put(SQLConstantes.modulo1_v_c1_p102,c1_p102);
        contentValues.put(SQLConstantes.modulo1_v_c1_p102_o,c1_p102_o);
        contentValues.put(SQLConstantes.modulo1_v_c1_p103,c1_p103);
        contentValues.put(SQLConstantes.modulo1_v_c1_p103_o,c1_p103_o);
        contentValues.put(SQLConstantes.modulo1_v_c1_p104,c1_p104);
        contentValues.put(SQLConstantes.modulo1_v_c1_p104_o,c1_p104_o);
        contentValues.put(SQLConstantes.modulo1_v_c1_p105,c1_p105);
        contentValues.put(SQLConstantes.modulo1_v_c1_p106,c1_p106);
        contentValues.put(SQLConstantes.modulo1_v_c1_p107,c1_p107);
        contentValues.put(SQLConstantes.modulo1_v_COB100A,"1");

        if(!data.existeElemento(getNombreTabla(),idVivienda)){
            Modulo1V modulo1V = new Modulo1V();
            modulo1V.set_id(idVivienda);
            data.insertarElemento(getNombreTabla(), modulo1V.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idVivienda);
        data.close();
    }

    @Override
    public void llenarVariables() {
        c1_p101 = c1_p101_RadioGroup.indexOfChild(c1_p101_RadioGroup.findViewById(c1_p101_RadioGroup.getCheckedRadioButtonId()));
        c1_p101_o = c1_p101_o_EditText.getText().toString();
        c1_p102 = c1_p102_RadioGroup.indexOfChild(c1_p102_RadioGroup.findViewById(c1_p102_RadioGroup.getCheckedRadioButtonId()));
        c1_p102_o = c1_p102_o_EditText.getText().toString();
        c1_p103 = c1_p103_RadioGroup.indexOfChild(c1_p103_RadioGroup.findViewById(c1_p103_RadioGroup.getCheckedRadioButtonId()));
        c1_p103_o = c1_p103_o_EditText.getText().toString();
        c1_p104 = c1_p104_RadioGroup.indexOfChild(c1_p104_RadioGroup.findViewById(c1_p104_RadioGroup.getCheckedRadioButtonId()));
        c1_p104_o = c1_p104_o_EditText.getText().toString();
        c1_p105 = c1_p105_EditText.getText().toString();
        c1_p106 = c1_p106_EditText.getText().toString();
        c1_p107 = c1_p107_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idVivienda)){
            Modulo1V modulo1V = data.getModulo1V(idVivienda);
            if(!modulo1V.getC1_p101().equals("-1"))((RadioButton)c1_p101_RadioGroup.getChildAt(Integer.parseInt(modulo1V.getC1_p101()))).setChecked(true);
            c1_p101_o_EditText.setText(modulo1V.getC1_p101_o());

            if(!modulo1V.getC1_p102().equals("-1"))((RadioButton)c1_p102_RadioGroup.getChildAt(Integer.parseInt(modulo1V.getC1_p102()))).setChecked(true);
            c1_p102_o_EditText.setText(modulo1V.getC1_p102_o());

            if(!modulo1V.getC1_p103().equals("-1"))((RadioButton)c1_p103_RadioGroup.getChildAt(Integer.parseInt(modulo1V.getC1_p103()))).setChecked(true);
            c1_p103_o_EditText.setText(modulo1V.getC1_p103_o());

            if(!modulo1V.getC1_p104().equals("-1"))((RadioButton)c1_p104_RadioGroup.getChildAt(Integer.parseInt(modulo1V.getC1_p104()))).setChecked(true);
            c1_p104_o_EditText.setText(modulo1V.getC1_p104_o());

            c1_p105_EditText.setText(modulo1V.getC1_p105());
            c1_p106_EditText.setText(modulo1V.getC1_p106());
            c1_p107_EditText.setText(modulo1V.getC1_p107());
        }
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        boolean verificar_p104_incorrecto=false, verificar_p105_incorrecto=false;
        llenarVariables();
        if (c1_p101 == -1){mostrarMensaje("PREGUNTA 101: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p101 == 8){
                if (c1_p101_o.trim().equals("")){mostrarMensaje("PREGUNTA 101: DEBE ESPECIFICAR");return false;}
            }
        }

        if (c1_p102 == -1){mostrarMensaje("PREGUNTA 102: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p102 == 9){
                if (c1_p102_o.trim().equals("")){mostrarMensaje("PREGUNTA 102: DEBE ESPECIFICAR");return false;}
            }
        }

        if (c1_p103 == -1){mostrarMensaje("PREGUNTA 103: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p103 == 8){
                if (c1_p103_o.trim().equals("")){mostrarMensaje("PREGUNTA 103: DEBE ESPECIFICAR");return false;}
            }
        }

        if((((c1_p102<5 && c1_p103<4) || (c1_p102==5 && c1_p103==2) || ((c1_p102==1 || c1_p102==3) && c1_p103==4)) && (c1_p101==5 || c1_p101==6)) ||
           (((c1_p102==9 && c1_p103==2) || ((c1_p102==6 || c1_p102>7) && c1_p103==4) || (c1_p102>6 && c1_p103==5) || (c1_p102==3 && c1_p103==6) || (c1_p102>4 && c1_p103>5)) && (c1_p101==2 || c1_p101==3 || c1_p101==5)) ||
           (((c1_p102==5 && c1_p103==3) || (c1_p102<5 && c1_p103==5)) && (c1_p101==2 || c1_p101==5 || c1_p101==6)) ||
           ((((c1_p102==6 || c1_p102==7) && c1_p103==3) || (c1_p102==6 && c1_p103==5) || ((c1_p102<3 || c1_p102==4) && c1_p103==6) || (c1_p102<4 && c1_p103>6)) && (c1_p101==2 || c1_p101==3 || c1_p101==5 || c1_p101==6)) ||
                ((c1_p102>4 && c1_p103==1) || ((c1_p102==6 || c1_p102==8) && c1_p103==2) || (c1_p102==8 && c1_p103==3))){
            mostrarMensaje("PREGUNTA 101: EL TIPO DE VIVIENDA NO HAY RELACION CON P102, P103");
        }

        if (c1_p104 == -1){mostrarMensaje("PREGUNTA 104: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p104 == 7){
                if (c1_p104_o.trim().equals("")){mostrarMensaje("PREGUNTA 104: DEBE ESPECIFICAR");return false;}
            }
        }
        if((c1_p101==2 || c1_p101==3)){
            if(c1_p104>5){
                if((c1_p102<5 && c1_p103==1) ||
                        ((c1_p102==1 || c1_p102==3 || c1_p102==4 || c1_p102==5|| c1_p102==7) && c1_p103==2) ||
                        ((c1_p102==1 || c1_p102==3 || c1_p102==4) && c1_p103==3) ||
                        ((c1_p102==1 || c1_p102==3 || c1_p102==4|| c1_p102==7) && c1_p103==4)){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p104<3 || c1_p104>5){
                if(((c1_p102==1 || c1_p102==3 || c1_p102==4) && c1_p103==5)){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p104<4 || c1_p104>5){
                if((c1_p102==2 && c1_p103==2) ||
                        ((c1_p102==2 || c1_p102==5) && c1_p103==3) ||
                        ((c1_p102==2 || c1_p102==5) && c1_p103==4) ||
                        ((c1_p102==2 || c1_p102==5) && c1_p103==5)){
                    verificar_p104_incorrecto = true;
                }
            }
            if((c1_p102>4 && c1_p103==1) || ((c1_p102==6 || c1_p102>=8) && c1_p103==2) || (c1_p102>5 && c1_p103==3) ||
                    ((c1_p102==6 || c1_p102>=8) && c1_p103==4) || (c1_p102>5 && c1_p103==5) || c1_p102>7 || c1_p103>5){
                verificar_p104_incorrecto = true;
            }
        }
        if((c1_p101==1 || c1_p101==4  || c1_p101==7 || c1_p101==8)){
            if(c1_p104<4){
                if(((c1_p102==2 || c1_p102==9) && c1_p103==2) ||
                        ((c1_p102==2 || c1_p102==5 || c1_p102==6 || c1_p102==7) && c1_p103==3) ||
                        ((c1_p102==2 || c1_p102==5 || c1_p102==6|| c1_p102>=8) && c1_p103==4) ||
                        ((c1_p102==2 || c1_p102==5 || c1_p102==7) && c1_p103==5) ||
                        (c1_p102==7 && c1_p103==6) ||
                        ((c1_p102==3 || c1_p102==4 || c1_p102==5 || c1_p102>6) && c1_p103==7) ||
                        (c1_p102==7 && c1_p103==8)){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p104<5 || c1_p104>7){
                if((c1_p102==9 && c1_p103==3) ||
                        ((c1_p102==6 || c1_p102==8 || c1_p102==9) && c1_p103==5) ||
                        ((c1_p102<6 || c1_p102>7) && c1_p103==6) ||
                        (c1_p102<3 && c1_p103==7) ||
                        ((c1_p102<3 || c1_p102==4 || c1_p102==5 || c1_p102>7) && c1_p103==8)){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p104<3 || c1_p104>7){
                if((c1_p102==1 || c1_p102==3 || c1_p102==4) && c1_p103==5){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p104<6 || c1_p104>7){
                if((c1_p102==6 && c1_p103==6) ||
                        (c1_p102==6 && c1_p103==7) ||
                        (c1_p102==6 && c1_p103==8)){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p104==1 || c1_p104==4 || c1_p104==6 || c1_p104>7){
                if(c1_p102==3 && c1_p103==8){
                    verificar_p104_incorrecto = true;
                }
            }
            if((c1_p102>4 && c1_p103==1) || ((c1_p102==6 || c1_p102==8) && c1_p103==2) || (c1_p102==8 && c1_p103==3)){
                verificar_p104_incorrecto = true;
            }
        }

        if((c1_p101==5 || c1_p101==6)){
            if(c1_p104<4 || c1_p104>7){
                if(((c1_p102==5 || c1_p102==7 || c1_p102==9) && c1_p103==2) ||
                        ((c1_p102>2 && c1_p102<8) && c1_p103==3) ||
                        (c1_p102>1 && c1_p103==4) ||
                        (((c1_p102>2 && c1_p102<6) || c1_p102==7) && c1_p103==5) ||
                        (c1_p102==7 && c1_p103==6) ||
                        (((c1_p102>2 && c1_p102<6) || c1_p102>6) && c1_p103==7) ||
                        (c1_p102==7 && c1_p103==8)){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p104<5 || c1_p104>7){
                if((c1_p102==9 && c1_p103==3) ||
                        ((c1_p102==6 || c1_p102>7) && c1_p103==5) ||
                        (((c1_p102>2 && c1_p102<6) || c1_p102>7) && c1_p103==6) ||
                        (((c1_p102>2 && c1_p102<6) || c1_p102>7) && c1_p103==8)){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p104<6 || c1_p104>7){
                if((c1_p102==6 && c1_p103==6) ||
                        (c1_p102==6 && c1_p103==7) ||
                        (c1_p102==6 && c1_p103==8)){
                    verificar_p104_incorrecto = true;
                }
            }
            if(c1_p102==1 || c1_p103==1 ||
                    (((c1_p102>1 && c1_p102<5) || c1_p102==6 || c1_p102==8) && c1_p103==2) ||
                    ((c1_p102==2 || c1_p102==8) && c1_p103==3) ||
                    (c1_p102==2 && c1_p103>4)){
                verificar_p104_incorrecto = true;
            }
        }

        if(verificar_p104_incorrecto){
            mostrarMensaje("PREGUNTA 104: EL MATERIAL EN LOS PISOS NO HAY RELACION CON P101, P102, P103");
        }

        if (c1_p105.trim().equals("")){mostrarMensaje("PREGUNTA 105: FALTA COMPLETAR LA PREGUNTA");return false;}
        if(Integer.parseInt(c1_p105)==0){mostrarMensaje("PREGUNTA 105: NO PUEDE SER CERO");return false;}
        if(c1_p101==1 && Integer.parseInt(c1_p105)>15) verificar_p105_incorrecto = true;
        if((c1_p101==2 || c1_p101==3) && Integer.parseInt(c1_p105)>10) verificar_p105_incorrecto = true;
        if((c1_p101==4 || c1_p101==5 || c1_p101==8) && Integer.parseInt(c1_p105)>5) verificar_p105_incorrecto = true;
        if((c1_p101==6 || c1_p101==7) && Integer.parseInt(c1_p105)>8) verificar_p105_incorrecto = true;
        if(verificar_p105_incorrecto) mostrarMensaje("PREGUNTA 105: EL NUMERO DE HABITACIONES NO CONCUERDA CON EL TIPO DE VIVIENDA");
        if (c1_p106.trim().equals("")){mostrarMensaje("PREGUNTA 106: FALTA COMPLETAR LA PREGUNTA");return false;}
        if(Integer.parseInt(c1_p105)<Integer.parseInt(c1_p106)){
            mostrarMensaje("PREGUNTA 106: DEBE SER MENOR O IGUAL QUE LA PREGUNTA 105");return false;
        }
        if((Integer.parseInt(c1_p105)<7 && (Integer.parseInt(c1_p105)<Integer.parseInt(c1_p106))) ||
           ((Integer.parseInt(c1_p105)>6 && Integer.parseInt(c1_p105)<16) && (Integer.parseInt(c1_p106)==0 || (Integer.parseInt(c1_p105)<Integer.parseInt(c1_p106))))){
            mostrarMensaje("PREGUNTA 106: EL NUMERO DE HABITACIONES EXCLUSIVAMENTE PARA DORMIR NO CONCUERDA CON EL TOTAL DE HABITACIONES");
        }
        if(((c1_p101<5 || c1_p101>5) && (Integer.parseInt(c1_p106)==0 || Integer.parseInt(c1_p106)>7)) ||
                (c1_p101==5 && (Integer.parseInt(c1_p106)<2 || Integer.parseInt(c1_p106)>7))){
            mostrarMensaje("PREGUNTA 106: EL NUMERO DE HABITACIONES QUE SE USAN EXCLUSIVAMENTE PARA DORMIR NO CONCUERDA CON EL TIPO DE VIVIENDA");
        }
        if (c1_p107.trim().equals("")){mostrarMensaje("PREGUNTA 107: FALTA COMPLETAR LA PREGUNTA");return false;}
        if(Integer.parseInt(c1_p107)==0){mostrarMensaje("PREGUNTA 107: NO PUEDE SER CERO");return false;}
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo1v;
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
