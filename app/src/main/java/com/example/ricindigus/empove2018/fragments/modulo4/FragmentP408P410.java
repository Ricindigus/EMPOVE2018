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
public class FragmentP408P410 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    CheckBox c4_p408_1_CheckBox, c4_p408_2_CheckBox, c4_p408_3_CheckBox, c4_p408_4_CheckBox, c4_p408_5_CheckBox,
            c4_p408_6_CheckBox, c4_p408_7_CheckBox, c4_p408_8_CheckBox, c4_p408_9_CheckBox, c4_p408_10_CheckBox,
            c4_p408_11_CheckBox, c4_p408_12_CheckBox, c4_p408_13_CheckBox, c4_p408_14_CheckBox;
    EditText c4_p408_o_EditText;
    RadioGroup c4_p409_RadioGroup, c4_p410_RadioGroup;
    LinearLayout m4_p408_linearlayout, m4_p409_linearlayout, m4_p410_linearlayout;

    private int c4_p408_1;
    private int c4_p408_2;
    private int c4_p408_3;
    private int c4_p408_4;
    private int c4_p408_5;
    private int c4_p408_6;
    private int c4_p408_7;
    private int c4_p408_8;
    private int c4_p408_9;
    private int c4_p408_10;
    private int c4_p408_11;
    private int c4_p408_12;
    private int c4_p408_13;
    private int c4_p408_14;
    private String c4_p408_o;
    private int c4_p409;
    private int c4_p410;

    @SuppressLint("ValidFragment")
    public FragmentP408P410(String idEncuestado, Context context) {
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

    public FragmentP408P410() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p408_p410, container, false);
        c4_p408_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_1);
        c4_p408_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_2);
        c4_p408_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_3);
        c4_p408_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_4);
        c4_p408_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_5);
        c4_p408_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_6);
        c4_p408_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_7);
        c4_p408_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_8);
        c4_p408_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_9);
        c4_p408_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_10);
        c4_p408_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_11);
        c4_p408_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_12);
        c4_p408_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_13);
        c4_p408_14_CheckBox = (CheckBox) rootView.findViewById(R.id.mod4_408_checkbox_C4_P408_14);
        c4_p408_o_EditText = (EditText) rootView.findViewById(R.id.mod4_408_edittext_C4_P408_O);

        c4_p409_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_409_radiogroup_C4_P409);

        c4_p410_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_410_radiogroup_C4_P410);

        m4_p408_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p408);
        m4_p409_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p409);
        m4_p410_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p410);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);c4_p408_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c4_p408_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c4_p408_o_EditText);
                    m4_p408_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c4_p408_13_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c4_p408_o_EditText.setEnabled(true);
                    c4_p408_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c4_p408_o_EditText.setText("");
                    c4_p408_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c4_p408_o_EditText.setEnabled(false);
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
        contentValues.put(SQLConstantes.modulo4_c4_p408_1,c4_p408_1+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_2,c4_p408_2+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_3,c4_p408_3+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_4,c4_p408_4+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_5,c4_p408_5+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_6,c4_p408_6+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_7,c4_p408_7+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_8,c4_p408_8+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_9,c4_p408_9+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_10,c4_p408_10+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_11,c4_p408_11+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_12,c4_p408_12+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_13,c4_p408_13+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_14,c4_p408_14+"");
        contentValues.put(SQLConstantes.modulo4_c4_p408_o,c4_p408_o);
        contentValues.put(SQLConstantes.modulo4_c4_p409,c4_p409+"");
        contentValues.put(SQLConstantes.modulo4_c4_p410,c4_p410+"");

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
        if(c4_p408_1_CheckBox.isChecked()) c4_p408_1 = 1; else c4_p408_1 = 0;
        if(c4_p408_2_CheckBox.isChecked()) c4_p408_2 = 1; else c4_p408_2 = 0;
        if(c4_p408_3_CheckBox.isChecked()) c4_p408_3 = 1; else c4_p408_3 = 0;
        if(c4_p408_4_CheckBox.isChecked()) c4_p408_4 = 1; else c4_p408_4 = 0;
        if(c4_p408_5_CheckBox.isChecked()) c4_p408_5 = 1; else c4_p408_5 = 0;
        if(c4_p408_6_CheckBox.isChecked()) c4_p408_6 = 1; else c4_p408_6 = 0;
        if(c4_p408_7_CheckBox.isChecked()) c4_p408_7 = 1; else c4_p408_7 = 0;
        if(c4_p408_8_CheckBox.isChecked()) c4_p408_8 = 1; else c4_p408_8 = 0;
        if(c4_p408_9_CheckBox.isChecked()) c4_p408_9 = 1; else c4_p408_9 = 0;
        if(c4_p408_10_CheckBox.isChecked()) c4_p408_10 = 1; else c4_p408_10 = 0;
        if(c4_p408_11_CheckBox.isChecked()) c4_p408_11 = 1; else c4_p408_11 = 0;
        if(c4_p408_12_CheckBox.isChecked()) c4_p408_12 = 1; else c4_p408_12 = 0;
        if(c4_p408_13_CheckBox.isChecked()) c4_p408_13 = 1; else c4_p408_13 = 0;
        if(c4_p408_14_CheckBox.isChecked()) c4_p408_14 = 1; else c4_p408_14 = 0;
        c4_p408_o = c4_p408_o_EditText.getText().toString();
        c4_p409 = c4_p409_RadioGroup.indexOfChild(c4_p409_RadioGroup.findViewById(c4_p409_RadioGroup.getCheckedRadioButtonId()));
        c4_p410 = c4_p410_RadioGroup.indexOfChild(c4_p410_RadioGroup.findViewById(c4_p410_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo4 modulo4 = data.getModulo4(idEncuestado);
            if(modulo4.getC4_p408_1().equals("0")) c4_p408_1_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_2().equals("0")) c4_p408_2_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_3().equals("0")) c4_p408_3_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_4().equals("0")) c4_p408_4_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_5().equals("0")) c4_p408_5_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_6().equals("0")) c4_p408_6_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_7().equals("0")) c4_p408_7_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_8().equals("0")) c4_p408_8_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_9().equals("0")) c4_p408_9_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_10().equals("0")) c4_p408_10_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_11().equals("0")) c4_p408_11_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_12().equals("0")) c4_p408_12_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_13().equals("0")) c4_p408_13_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_14().equals("0")) c4_p408_14_CheckBox.setChecked(false);
            if(modulo4.getC4_p408_1().equals("1")) c4_p408_1_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_2().equals("1")) c4_p408_2_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_3().equals("1")) c4_p408_3_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_4().equals("1")) c4_p408_4_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_5().equals("1")) c4_p408_5_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_6().equals("1")) c4_p408_6_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_7().equals("1")) c4_p408_7_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_8().equals("1")) c4_p408_8_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_9().equals("1")) c4_p408_9_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_10().equals("1")) c4_p408_10_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_11().equals("1")) c4_p408_11_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_12().equals("1")) c4_p408_12_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_13().equals("1")) c4_p408_13_CheckBox.setChecked(true);
            if(modulo4.getC4_p408_14().equals("1")) c4_p408_14_CheckBox.setChecked(true);
            c4_p408_o_EditText.setText(modulo4.getC4_p408_o());
            if(!(modulo4.getC4_p409().equals("-1") || modulo4.getC4_p409().equals("")))((RadioButton)c4_p409_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p409()))).setChecked(true);
            if(!(modulo4.getC4_p410().equals("-1") || modulo4.getC4_p410().equals("")))((RadioButton)c4_p410_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p410()))).setChecked(true);
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(m4_p408_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p408_1==0 && c4_p408_2==0 && c4_p408_3==0 && c4_p408_4==0 && c4_p408_5==0 &&
                    c4_p408_6==0 && c4_p408_7==0 && c4_p408_8==0 && c4_p408_9==0 && c4_p408_10==0 &&
                    c4_p408_11==0 && c4_p408_12==0 && c4_p408_13==0 && c4_p408_14==0){
                mostrarMensaje("PREGUNTA 408: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c4_p408_13==1){
                if(c4_p408_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 408 - OPCION 13: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c4_p409<0 && m4_p409_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 409: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c4_p410<0 && m4_p410_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 410: DEBE SELECCIONAR UNA OPCION");
            return false;
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
