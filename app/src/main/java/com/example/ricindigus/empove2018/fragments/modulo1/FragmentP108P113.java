package com.example.ricindigus.empove2018.fragments.modulo1;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1H;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo1V;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP108P113 extends FragmentPagina {

    String idHogar;
    String idVivienda;
    Context context;

    RadioGroup c1_p108_RadioGroup, c1_p109_RadioGroup, c1_p110_RadioGroup, c1_p111_RadioGroup, c1_p112_RadioGroup;
    RadioGroup c1_p113_1_RadioGroup, c1_p113_2_RadioGroup, c1_p113_3_RadioGroup, c1_p113_4_RadioGroup, c1_p113_5_RadioGroup,
            c1_p113_6_RadioGroup, c1_p113_7_RadioGroup, c1_p113_8_RadioGroup, c1_p113_9_RadioGroup;
    EditText c1_p108_o_EditText, c1_p109_o_EditText, c1_p110_o_EditText, c1_p111_o_EditText, c1_p112_o_EditText;
    EditText c1_p113_7o_EditText, c1_p113_8o_EditText, c1_p113_9o_EditText;

    LinearLayout m1_p108_linearlayout, m1_p109_linearlayout, m1_p110_linearlayout,
            m1_p111_linearlayout, m1_p112_linearlayout, m1_p113_linearlayout;

    private int c1_p108;
    private String c1_p108_o;
    private int c1_p109;
    private String c1_p109_o;
    private int c1_p110;
    private String c1_p110_o;
    private int c1_p111;
    private String c1_p111_o;
    private int c1_p112;
    private String c1_p112_o;
    private int c1_p113_1;
    private int c1_p113_2;
    private int c1_p113_3;
    private int c1_p113_4;
    private int c1_p113_5;
    private int c1_p113_6;
    private int c1_p113_7;
    private int c1_p113_8;
    private int c1_p113_9;
    private String c1_p113_7_o;
    private String c1_p113_8_o;
    private String c1_p113_9_o;

    public FragmentP108P113() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP108P113(String idHogar, String idVivienda, Context context) {
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p108_p113, container, false);
        c1_p108_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_108_radiogroup_C1_P108);
        c1_p108_o_EditText = (EditText) rootView.findViewById(R.id.mod1_108_edittext_C1_P108_O);
        c1_p109_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_109_radiogroup_C1_P109);
        c1_p109_o_EditText = (EditText) rootView.findViewById(R.id.mod1_109_edittext_C1_P109_O);
        c1_p110_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_110_radiogroup_C1_P110);
        c1_p110_o_EditText = (EditText) rootView.findViewById(R.id.mod1_110_edittext_C1_P110_O);
        c1_p111_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_111_radiogroup_C1_P111);
        c1_p111_o_EditText = (EditText) rootView.findViewById(R.id.mod1_111_edittext_C1_P111_O);
        c1_p112_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_112_radiogroup_C1_P112);
        c1_p112_o_EditText = (EditText) rootView.findViewById(R.id.mod1_112_edittext_C1_P112_O);

        c1_p113_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_1);
        c1_p113_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_2);
        c1_p113_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_3);
        c1_p113_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_4);
        c1_p113_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_5);
        c1_p113_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_6);
        c1_p113_7_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_7);
        c1_p113_8_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_8);
        c1_p113_9_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod1_113_radiogroup_C1_P113_9);
        c1_p113_7o_EditText = (EditText) rootView.findViewById(R.id.mod1_113_edittext_C1_P113_7O);
        c1_p113_8o_EditText = (EditText) rootView.findViewById(R.id.mod1_113_edittext_C1_P113_8O);
        c1_p113_9o_EditText = (EditText) rootView.findViewById(R.id.mod1_113_edittext_C1_P113_9O);

        m1_p108_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p108);
        m1_p109_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p109);
        m1_p110_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p110);
        m1_p111_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p111);
        m1_p112_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p112);
        m1_p113_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m1_p113);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c1_p108_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,6,c1_p108_o_EditText);
            }
        });
        c1_p109_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,5,c1_p109_o_EditText);
            }
        });
        c1_p110_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,8,c1_p110_o_EditText);
            }
        });
        c1_p111_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,4,c1_p111_o_EditText);
            }
        });
        c1_p112_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,8,c1_p112_o_EditText);
            }
        });
        c1_p113_7_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,1,c1_p113_7o_EditText);
            }
        });
        c1_p113_8_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,1,c1_p113_8o_EditText);
            }
        });
        c1_p113_9_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,1,c1_p113_9o_EditText);
            }
        });

        configurarEditText(c1_p108_o_EditText,m1_p108_linearlayout,0,30);
        configurarEditText(c1_p109_o_EditText,m1_p109_linearlayout,0,30);
        configurarEditText(c1_p110_o_EditText,m1_p110_linearlayout,0,30);
        configurarEditText(c1_p111_o_EditText,m1_p111_linearlayout,0,30);
        configurarEditText(c1_p112_o_EditText,m1_p112_linearlayout,0,30);
        configurarEditText(c1_p113_7o_EditText,m1_p113_linearlayout,0,30);
        configurarEditText(c1_p113_8o_EditText,m1_p113_linearlayout,0,30);
        configurarEditText(c1_p113_9o_EditText,m1_p113_linearlayout,0,30);

        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo1_h_c1_p108,c1_p108+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p108_o,c1_p108_o);
        contentValues.put(SQLConstantes.modulo1_h_c1_p109,c1_p109+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p109_o,c1_p109_o);
        contentValues.put(SQLConstantes.modulo1_h_c1_p110,c1_p110+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p110_o,c1_p110_o);
        contentValues.put(SQLConstantes.modulo1_h_c1_p111,c1_p111+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p111_o,c1_p111_o);
        contentValues.put(SQLConstantes.modulo1_h_c1_p112,c1_p112+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p112_o,c1_p112_o);
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_1,c1_p113_1+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_2,c1_p113_2+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_3,c1_p113_3+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_4,c1_p113_4+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_5,c1_p113_5+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_6,c1_p113_6+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_7,c1_p113_7+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_8,c1_p113_8+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_9,c1_p113_9+"");
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_7_o,c1_p113_7_o);
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_8_o,c1_p113_8_o);
        contentValues.put(SQLConstantes.modulo1_h_c1_p113_9_o,c1_p113_9_o);
        if(!data.existeElemento(getNombreTabla(),idHogar)){
            Modulo1H modulo1H = new Modulo1H();
            modulo1H.set_id(idHogar);
            modulo1H.setIdVivienda(idVivienda);
            data.insertarElemento(getNombreTabla(), modulo1H.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idHogar);
        data.close();
    }

    @Override
    public void llenarVariables() {
        c1_p108 = c1_p108_RadioGroup.indexOfChild(c1_p108_RadioGroup.findViewById(c1_p108_RadioGroup.getCheckedRadioButtonId()));
        c1_p108_o = c1_p108_o_EditText.getText().toString();
        c1_p109 = c1_p109_RadioGroup.indexOfChild(c1_p109_RadioGroup.findViewById(c1_p109_RadioGroup.getCheckedRadioButtonId()));
        c1_p109_o = c1_p109_o_EditText.getText().toString();
        c1_p110 = c1_p110_RadioGroup.indexOfChild(c1_p110_RadioGroup.findViewById(c1_p110_RadioGroup.getCheckedRadioButtonId()));
        c1_p110_o = c1_p110_o_EditText.getText().toString();
        c1_p111 = c1_p111_RadioGroup.indexOfChild(c1_p111_RadioGroup.findViewById(c1_p111_RadioGroup.getCheckedRadioButtonId()));
        c1_p111_o = c1_p111_o_EditText.getText().toString();
        c1_p112 = c1_p112_RadioGroup.indexOfChild(c1_p112_RadioGroup.findViewById(c1_p112_RadioGroup.getCheckedRadioButtonId()));
        c1_p112_o = c1_p112_o_EditText.getText().toString();

        c1_p113_1 = c1_p113_1_RadioGroup.indexOfChild(c1_p113_1_RadioGroup.findViewById(c1_p113_1_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_2 = c1_p113_2_RadioGroup.indexOfChild(c1_p113_2_RadioGroup.findViewById(c1_p113_2_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_3 = c1_p113_3_RadioGroup.indexOfChild(c1_p113_3_RadioGroup.findViewById(c1_p113_3_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_4 = c1_p113_4_RadioGroup.indexOfChild(c1_p113_4_RadioGroup.findViewById(c1_p113_4_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_5 = c1_p113_5_RadioGroup.indexOfChild(c1_p113_5_RadioGroup.findViewById(c1_p113_5_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_6 = c1_p113_6_RadioGroup.indexOfChild(c1_p113_6_RadioGroup.findViewById(c1_p113_6_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_7 = c1_p113_7_RadioGroup.indexOfChild(c1_p113_7_RadioGroup.findViewById(c1_p113_7_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_8 = c1_p113_8_RadioGroup.indexOfChild(c1_p113_8_RadioGroup.findViewById(c1_p113_8_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_9 = c1_p113_9_RadioGroup.indexOfChild(c1_p113_9_RadioGroup.findViewById(c1_p113_9_RadioGroup.getCheckedRadioButtonId()));
        c1_p113_7_o = c1_p113_7o_EditText.getText().toString();
        c1_p113_8_o = c1_p113_8o_EditText.getText().toString();
        c1_p113_9_o = c1_p113_9o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idHogar)){
            Modulo1H modulo1H = data.getModulo1H(idHogar);
            if(!modulo1H.getC1_p108().equals("-1") && !modulo1H.getC1_p108().equals(""))((RadioButton)c1_p108_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p108()))).setChecked(true);
            c1_p108_o_EditText.setText(modulo1H.getC1_p108_o());

            if(!modulo1H.getC1_p109().equals("-1") && !modulo1H.getC1_p109().equals(""))((RadioButton)c1_p109_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p109()))).setChecked(true);
            c1_p109_o_EditText.setText(modulo1H.getC1_p109_o());

            if(!modulo1H.getC1_p110().equals("-1") && !modulo1H.getC1_p110().equals(""))((RadioButton)c1_p110_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p110()))).setChecked(true);
            c1_p110_o_EditText.setText(modulo1H.getC1_p110_o());

            if(!modulo1H.getC1_p111().equals("-1") && !modulo1H.getC1_p111().equals(""))((RadioButton)c1_p111_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p111()))).setChecked(true);
            c1_p111_o_EditText.setText(modulo1H.getC1_p111_o());

            if(!modulo1H.getC1_p112().equals("-1") && !modulo1H.getC1_p112().equals(""))((RadioButton)c1_p112_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p112()))).setChecked(true);
            c1_p112_o_EditText.setText(modulo1H.getC1_p112_o());

            if(!modulo1H.getC1_p113_1().equals("-1") && !modulo1H.getC1_p113_1().equals(""))((RadioButton)c1_p113_1_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_1()))).setChecked(true);
            if(!modulo1H.getC1_p113_2().equals("-1") && !modulo1H.getC1_p113_2().equals(""))((RadioButton)c1_p113_2_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_2()))).setChecked(true);
            if(!modulo1H.getC1_p113_3().equals("-1") && !modulo1H.getC1_p113_3().equals(""))((RadioButton)c1_p113_3_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_3()))).setChecked(true);
            if(!modulo1H.getC1_p113_4().equals("-1") && !modulo1H.getC1_p113_4().equals(""))((RadioButton)c1_p113_4_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_4()))).setChecked(true);
            if(!modulo1H.getC1_p113_5().equals("-1") && !modulo1H.getC1_p113_5().equals(""))((RadioButton)c1_p113_5_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_5()))).setChecked(true);
            if(!modulo1H.getC1_p113_6().equals("-1") && !modulo1H.getC1_p113_6().equals(""))((RadioButton)c1_p113_6_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_6()))).setChecked(true);
            if(!modulo1H.getC1_p113_7().equals("-1") && !modulo1H.getC1_p113_7().equals(""))((RadioButton)c1_p113_7_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_7()))).setChecked(true);
            if(!modulo1H.getC1_p113_8().equals("-1") && !modulo1H.getC1_p113_8().equals(""))((RadioButton)c1_p113_8_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_8()))).setChecked(true);
            if(!modulo1H.getC1_p113_9().equals("-1") && !modulo1H.getC1_p113_9().equals(""))((RadioButton)c1_p113_9_RadioGroup.getChildAt(Integer.parseInt(modulo1H.getC1_p113_9()))).setChecked(true);

            c1_p113_7o_EditText.setText(modulo1H.getC1_p113_7_o());
            c1_p113_8o_EditText.setText(modulo1H.getC1_p113_8_o());
            c1_p113_9o_EditText.setText(modulo1H.getC1_p113_9_o());
        }
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if (c1_p108 == -1){mostrarMensaje("PREGUNTA 108: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p108 == 6){
                if (c1_p108_o.trim().equals("")){mostrarMensaje("PREGUNTA 108: DEBE ESPECIFICAR");return false;}
            }
        }

        if (c1_p109 == -1){mostrarMensaje("PREGUNTA 109: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p109 == 5){
                if (c1_p109_o.trim().equals("")){mostrarMensaje("PREGUNTA 109: DEBE ESPECIFICAR");return false;}
            }
        }

        if (c1_p110 == -1){mostrarMensaje("PREGUNTA 110: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p110 == 8){
                if (c1_p110_o.trim().equals("")){mostrarMensaje("PREGUNTA 110: DEBE ESPECIFICAR");return false;}
            }
        }

        if (c1_p111 == -1){mostrarMensaje("PREGUNTA 111: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p111 == 4){
                if (c1_p111_o.trim().equals("")){mostrarMensaje("PREGUNTA 111: DEBE ESPECIFICAR");return false;}
            }
        }

        if (c1_p112 == -1){mostrarMensaje("PREGUNTA 112: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p112 == 8){
                if (c1_p112_o.trim().equals("")){mostrarMensaje("PREGUNTA 112: DEBE ESPECIFICAR");return false;}
            }
        }

        if (c1_p113_1 == -1){mostrarMensaje("PREGUNTA 113-1: DEBE MARCAR UNA OPCIÓN"); return false;}
        if (c1_p113_2 == -1){mostrarMensaje("PREGUNTA 113-2: DEBE MARCAR UNA OPCIÓN"); return false;}
        if (c1_p113_3 == -1){mostrarMensaje("PREGUNTA 113-3: DEBE MARCAR UNA OPCIÓN"); return false;}
        if (c1_p113_4 == -1){mostrarMensaje("PREGUNTA 113-4: DEBE MARCAR UNA OPCIÓN"); return false;}
        if (c1_p113_5 == -1){mostrarMensaje("PREGUNTA 113-5: DEBE MARCAR UNA OPCIÓN"); return false;}
        if (c1_p113_6 == -1){mostrarMensaje("PREGUNTA 113-6: DEBE MARCAR UNA OPCIÓN"); return false;}

        if (c1_p113_7 == -1){mostrarMensaje("PREGUNTA 113-7: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p113_7 == 1){
                if (c1_p113_7_o.trim().equals("")){mostrarMensaje("PREGUNTA 113-7: DEBE ESPECIFICAR");return false;}
            }
        }
        if (c1_p113_8 == -1){mostrarMensaje("PREGUNTA 113-8: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p113_8 == 1){
                if (c1_p113_8_o.trim().equals("")){mostrarMensaje("PREGUNTA 113-8: DEBE ESPECIFICAR");return false;}
            }
        }
        if (c1_p113_9 == -1){mostrarMensaje("PREGUNTA 113-9: DEBE MARCAR UNA OPCIÓN"); return false;}
        else{
            if (c1_p113_9 == 1){
                if (c1_p113_9_o.trim().equals("")){mostrarMensaje("PREGUNTA 113-9: DEBE ESPECIFICAR");return false;}
            }
        }

        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo1h;
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
