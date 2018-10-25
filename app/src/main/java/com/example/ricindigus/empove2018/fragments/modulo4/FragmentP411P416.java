package com.example.ricindigus.empove2018.fragments.modulo4;


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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP411P416 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c4_p411_RadioGroup, c4_p412_RadioGroup, c4_p413_RadioGroup, c4_p414_RadioGroup;
    CheckBox c4_p415_1_CheckBox, c4_p415_2_CheckBox, c4_p415_3_CheckBox, c4_p415_4_CheckBox, c4_p415_5_CheckBox,
            c4_p415_6_CheckBox, c4_p415_7_CheckBox, c4_p415_8_CheckBox, c4_p415_9_CheckBox;
    EditText c4_p415_o_EditText;
    RadioGroup c4_p416_1_RadioGroup, c4_p416_2_RadioGroup, c4_p416_3_RadioGroup, c4_p416_4_RadioGroup,
            c4_p416_5_RadioGroup, c4_p416_6_RadioGroup;
    LinearLayout m4_p411_linearlayout, m4_p412_linearlayout, m4_p413_linearlayout, m4_p414_linearlayout,
            m4_p415_linearlayout, m4_p416_linearlayout;

    private int c4_p411;
    private int c4_p412;
    private int c4_p413;
    private int c4_p414;
    private int c4_p415_1;
    private int c4_p415_2;
    private int c4_p415_3;
    private int c4_p415_4;
    private int c4_p415_5;
    private int c4_p415_6;
    private int c4_p415_7;
    private int c4_p415_8;
    private int c4_p415_9;
    private String c4_p415_o;
    private int c4_p416_1;
    private int c4_p416_2;
    private int c4_p416_3;
    private int c4_p416_4;
    private int c4_p416_5;
    private int c4_p416_6;

    @SuppressLint("ValidFragment")
    public FragmentP411P416(String idEncuestado, Context context) {
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

    public FragmentP411P416() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p411_p416, container, false);
        c4_p411_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_411_radiogroup_C4_P411);
        c4_p412_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_412_radiogroup_C4_P412);
        c4_p413_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_413_radiogroup_C4_P413);
        c4_p414_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_414_radiogroup_C4_P414);
        c4_p415_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_1);
        c4_p415_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_2);
        c4_p415_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_3);
        c4_p415_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_4);
        c4_p415_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_5);
        c4_p415_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_6);
        c4_p415_o_EditText = (EditText) rootView.findViewById(R.id.mod4_415_edittext_C4_P415_O);
        c4_p415_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_7);
        c4_p415_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_8);
        c4_p415_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_415_checkbox_C4_P415_9);
        c4_p416_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_1);
        c4_p416_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_2);
        c4_p416_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_3);
        c4_p416_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_4);
        c4_p416_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_5);
        c4_p416_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_416_radiogroup_C4_P416_6);

        m4_p411_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p411);
        m4_p412_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p412);
        m4_p413_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p413);
        m4_p414_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p414);
        m4_p415_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p415);
        m4_p416_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p416);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);c4_p415_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c4_p415_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c4_p415_o_EditText);
                    m4_p415_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c4_p415_6_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p415_o_EditText.setEnabled(true);
                    c4_p415_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c4_p415_o_EditText.setText("");
                    c4_p415_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c4_p415_o_EditText.setEnabled(false);
                }
            }
        });
        c4_p415_9_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p415_1_CheckBox.setChecked(false);
                    c4_p415_1_CheckBox.setEnabled(false);
                    c4_p415_2_CheckBox.setChecked(false);
                    c4_p415_2_CheckBox.setEnabled(false);
                    c4_p415_3_CheckBox.setChecked(false);
                    c4_p415_3_CheckBox.setEnabled(false);
                    c4_p415_4_CheckBox.setChecked(false);
                    c4_p415_4_CheckBox.setEnabled(false);
                    c4_p415_5_CheckBox.setChecked(false);
                    c4_p415_5_CheckBox.setEnabled(false);
                    c4_p415_6_CheckBox.setChecked(false);
                    c4_p415_6_CheckBox.setEnabled(false);
                    c4_p415_7_CheckBox.setChecked(false);
                    c4_p415_7_CheckBox.setEnabled(false);
                    c4_p415_8_CheckBox.setChecked(false);
                    c4_p415_8_CheckBox.setEnabled(false);
                    c4_p415_o_EditText.setText("");
                    c4_p415_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                }else{
                    c4_p415_1_CheckBox.setEnabled(true);
                    c4_p415_2_CheckBox.setEnabled(true);
                    c4_p415_3_CheckBox.setEnabled(true);
                    c4_p415_4_CheckBox.setEnabled(true);
                    c4_p415_5_CheckBox.setEnabled(true);
                    c4_p415_6_CheckBox.setEnabled(true);
                    c4_p415_7_CheckBox.setEnabled(true);
                    c4_p415_8_CheckBox.setEnabled(true);
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
        contentValues.put(SQLConstantes.modulo4_c4_p411,c4_p411+"");
        contentValues.put(SQLConstantes.modulo4_c4_p412,c4_p412+"");
        contentValues.put(SQLConstantes.modulo4_c4_p413,c4_p413+"");
        contentValues.put(SQLConstantes.modulo4_c4_p414,c4_p414+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_1,c4_p415_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_2,c4_p415_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_3,c4_p415_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_4,c4_p415_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_5,c4_p415_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_6,c4_p415_6+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_7,c4_p415_7+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_8,c4_p415_8+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_9,c4_p415_9+"");
        contentValues.put(SQLConstantes.modulo4_c4_p415_o,c4_p415_o);
        contentValues.put(SQLConstantes.modulo4_c4_p416_1,c4_p416_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_2,c4_p416_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_3,c4_p416_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_4,c4_p416_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_5,c4_p416_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_6,c4_p416_6+"");

        if(data.existeElemento(getNombreTabla(),idEncuestado)){
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        }else{
            Modulo4 modulo4 = new Modulo4();
            modulo4.setIdInformante(idInformante);
            modulo4.set_id(idEncuestado);
            modulo4.setIdVivienda(idVivienda);
            modulo4.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo4.toValues());
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        c4_p411 = c4_p411_RadioGroup.indexOfChild(c4_p411_RadioGroup.findViewById(c4_p411_RadioGroup.getCheckedRadioButtonId()));
        c4_p412 = c4_p412_RadioGroup.indexOfChild(c4_p412_RadioGroup.findViewById(c4_p412_RadioGroup.getCheckedRadioButtonId()));
        c4_p413 = c4_p413_RadioGroup.indexOfChild(c4_p413_RadioGroup.findViewById(c4_p413_RadioGroup.getCheckedRadioButtonId()));
        c4_p414 = c4_p414_RadioGroup.indexOfChild(c4_p414_RadioGroup.findViewById(c4_p414_RadioGroup.getCheckedRadioButtonId()));
        if(c4_p415_1_CheckBox.isChecked()) c4_p415_1 = 1; else c4_p415_1 = 0;
        if(c4_p415_2_CheckBox.isChecked()) c4_p415_2 = 1; else c4_p415_2 = 0;
        if(c4_p415_3_CheckBox.isChecked()) c4_p415_3 = 1; else c4_p415_3 = 0;
        if(c4_p415_4_CheckBox.isChecked()) c4_p415_4 = 1; else c4_p415_4 = 0;
        if(c4_p415_5_CheckBox.isChecked()) c4_p415_5 = 1; else c4_p415_5 = 0;
        if(c4_p415_6_CheckBox.isChecked()) c4_p415_6 = 1; else c4_p415_6 = 0;
        if(c4_p415_7_CheckBox.isChecked()) c4_p415_7 = 1; else c4_p415_7 = 0;
        if(c4_p415_8_CheckBox.isChecked()) c4_p415_8 = 1; else c4_p415_8 = 0;
        if(c4_p415_9_CheckBox.isChecked()) c4_p415_9 = 1; else c4_p415_9 = 0;
        c4_p415_o = c4_p415_o_EditText.getText().toString();
        c4_p416_1 = c4_p416_1_RadioGroup.indexOfChild(c4_p416_1_RadioGroup.findViewById(c4_p416_1_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_2 = c4_p416_2_RadioGroup.indexOfChild(c4_p416_2_RadioGroup.findViewById(c4_p416_2_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_3 = c4_p416_3_RadioGroup.indexOfChild(c4_p416_3_RadioGroup.findViewById(c4_p416_3_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_4 = c4_p416_4_RadioGroup.indexOfChild(c4_p416_4_RadioGroup.findViewById(c4_p416_4_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_5 = c4_p416_5_RadioGroup.indexOfChild(c4_p416_5_RadioGroup.findViewById(c4_p416_5_RadioGroup.getCheckedRadioButtonId()));
        c4_p416_6 = c4_p416_6_RadioGroup.indexOfChild(c4_p416_6_RadioGroup.findViewById(c4_p416_6_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo4 modulo4 = data.getModulo4(idEncuestado);
            if(!(modulo4.getC4_p411().equals("-1") || modulo4.getC4_p411().equals("")))((RadioButton)c4_p411_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p411()))).setChecked(true);
            if(!(modulo4.getC4_p412().equals("-1") || modulo4.getC4_p412().equals("")))((RadioButton)c4_p412_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p412()))).setChecked(true);
            if(!(modulo4.getC4_p413().equals("-1") || modulo4.getC4_p413().equals("")))((RadioButton)c4_p413_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p413()))).setChecked(true);
            if(!(modulo4.getC4_p414().equals("-1") || modulo4.getC4_p414().equals("")))((RadioButton)c4_p414_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p414()))).setChecked(true);
            if(modulo4.getC4_p415_1().equals("0")) c4_p415_1_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_2().equals("0")) c4_p415_2_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_3().equals("0")) c4_p415_3_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_4().equals("0")) c4_p415_4_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_5().equals("0")) c4_p415_5_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_6().equals("0")) c4_p415_6_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_7().equals("0")) c4_p415_7_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_8().equals("0")) c4_p415_8_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_9().equals("0")) c4_p415_9_CheckBox.setChecked(false);
            if(modulo4.getC4_p415_1().equals("1")) c4_p415_1_CheckBox.setChecked(true);
            if(modulo4.getC4_p415_2().equals("1")) c4_p415_2_CheckBox.setChecked(true);
            if(modulo4.getC4_p415_3().equals("1")) c4_p415_3_CheckBox.setChecked(true);
            if(modulo4.getC4_p415_4().equals("1")) c4_p415_4_CheckBox.setChecked(true);
            if(modulo4.getC4_p415_5().equals("1")) c4_p415_5_CheckBox.setChecked(true);
            if(modulo4.getC4_p415_6().equals("1")) c4_p415_6_CheckBox.setChecked(true);
            if(modulo4.getC4_p415_7().equals("1")) c4_p415_7_CheckBox.setChecked(true);
            if(modulo4.getC4_p415_8().equals("1")) c4_p415_8_CheckBox.setChecked(true);
            if(modulo4.getC4_p415_9().equals("1")) c4_p415_9_CheckBox.setChecked(true);
            c4_p415_o_EditText.setText(modulo4.getC4_p415_o());
            if(!(modulo4.getC4_p416_1().equals("-1") || modulo4.getC4_p416_1().equals("")))((RadioButton)c4_p416_1_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p416_1()))).setChecked(true);
            if(!(modulo4.getC4_p416_2().equals("-1") || modulo4.getC4_p416_2().equals("")))((RadioButton)c4_p416_2_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p416_2()))).setChecked(true);
            if(!(modulo4.getC4_p416_3().equals("-1") || modulo4.getC4_p416_3().equals("")))((RadioButton)c4_p416_3_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p416_3()))).setChecked(true);
            if(!(modulo4.getC4_p416_4().equals("-1") || modulo4.getC4_p416_4().equals("")))((RadioButton)c4_p416_4_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p416_4()))).setChecked(true);
            if(!(modulo4.getC4_p416_5().equals("-1") || modulo4.getC4_p416_5().equals("")))((RadioButton)c4_p416_5_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p416_5()))).setChecked(true);
            if(!(modulo4.getC4_p416_6().equals("-1") || modulo4.getC4_p416_6().equals("")))((RadioButton)c4_p416_6_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p416_6()))).setChecked(true);
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(c4_p411<0 && m4_p411_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 411: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p412<0 && m4_p412_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 412: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p413<0 && m4_p413_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 413: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p414<0 && m4_p414_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 414: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(m4_p415_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p415_1==0 && c4_p415_2==0 && c4_p415_3==0 && c4_p415_4==0 && c4_p415_5==0 &&
                    c4_p415_6==0 && c4_p415_7==0 && c4_p415_8==0 && c4_p415_9==0){
                mostrarMensaje("PREGUNTA 415: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p415_6==1){
                if(c4_p415_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 415 - OPCION 6: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(m4_p416_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p416_1<0){
                mostrarMensaje("PREGUNTA 416-1: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_2<0){
                mostrarMensaje("PREGUNTA 416-2: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_3<0){
                mostrarMensaje("PREGUNTA 416-3: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_4<0){
                mostrarMensaje("PREGUNTA 416-4: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_5<0){
                mostrarMensaje("PREGUNTA 416-5: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p416_6<0){
                mostrarMensaje("PREGUNTA 416-6: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo4;
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
