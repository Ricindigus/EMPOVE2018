package com.example.ricindigus.empove2018.fragments.modulo3;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterMinMax;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */

import java.util.ArrayList;
import java.util.Calendar;

public class FragmentP301P305 extends FragmentPagina {
    String idEncuestado;
    Context context;

    private static final String CERO = "0";
    public final Calendar c = Calendar.getInstance();
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    TextView c3_p301_d_TextView, c3_p301_m_TextView, c3_p301_a_TextView;
    AutoCompleteTextView c3_p302_AutoCompleteTextView;
    CheckBox c3_p303_CheckBox;
    RadioGroup c3_p304_RadioGroup,c3_p305_RadioGroup;
    EditText c3_p305_o_EditText;
    EditText p303edtMes,p303edtAnio;


    Spinner informanteSpinner;

    Button c3_p301_d_f_Button;

    String idInformante;
    String idHogar;
    String idVivienda;
    String c3_p301_d;
    String c3_p301_m;
    String c3_p301_a;
    String c3_p302;
    String c3_p303_m;
    String c3_p303_a;
    int c3_p303_no_nacio;
    int c3_p304;
    int c3_p305;
    String c3_p305_o;

    public FragmentP301P305() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP301P305(String idEncuestado, Context context) {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p301_p305, container, false);
        c3_p301_d_TextView = (TextView) rootView.findViewById(R.id.mod3_301_textview_C3_P301_D);
        c3_p301_m_TextView = (TextView) rootView.findViewById(R.id.mod3_301_textview_C3_P301_M);
        c3_p301_a_TextView = (TextView) rootView.findViewById(R.id.mod3_301_textview_C3_P301_A);
        c3_p301_d_f_Button = (Button) rootView.findViewById(R.id.mod3_301_button_C3_P301_F);
        c3_p302_AutoCompleteTextView = (AutoCompleteTextView) rootView.findViewById(R.id.mod3_302_autotextview_C3_P302);
        p303edtMes = (EditText) rootView.findViewById(R.id.mod3_303_edittext_C3_P303_M);
        p303edtAnio = (EditText)rootView.findViewById(R.id.mod3_303_edittext_C3_P303_A);
        c3_p303_CheckBox = (CheckBox) rootView.findViewById(R.id.mod3_303_checkbox_C3_P303_NO_NACIO);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);


        c3_p304_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod3_304_radiogroup_C3_P304);
        c3_p305_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod3_305_radiogroup_C3_P305);
        c3_p305_o_EditText = (EditText) rootView.findViewById(R.id.mod3_305_edittext_C3_P305_O);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c3_p301_d_f_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog recogerFecha = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final int mesActual = month + 1;
                        String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                        c3_p301_d_TextView.setText(""+diaFormateado);
                        c3_p301_m_TextView.setText(""+mesFormateado);
                        c3_p301_a_TextView.setText(""+year);

                    }
                },anio, mes, dia);
                recogerFecha.show();
            }
        });

        Data data =  new Data(context);
        data.open();
        ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(idHogar);
        data.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        informanteSpinner.setAdapter(adapter);
        c3_p302_AutoCompleteTextView.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(20)});
        c3_p305_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(30)});
        p303edtMes.setFilters(new InputFilter[]{new InputFilterMinMax("1", "12"),new InputFilter.LengthFilter(2)});
        p303edtAnio.setFilters(new InputFilter[]{new InputFilterMinMax("1", "2018"),new InputFilter.LengthFilter(4)});
        p303edtMes.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        p303edtAnio.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        cargarDatos();
    }



    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_c3_p301_d,c3_p301_d);
        contentValues.put(SQLConstantes.modulo3_c3_p301_m,c3_p301_m);
        contentValues.put(SQLConstantes.modulo3_c3_p301_a,c3_p301_a);
        contentValues.put(SQLConstantes.modulo3_c3_p302,c3_p302);
        contentValues.put(SQLConstantes.modulo3_c3_p303_m,c3_p303_m);
        contentValues.put(SQLConstantes.modulo3_c3_p303_a,c3_p303_a);
        contentValues.put(SQLConstantes.modulo3_c3_p303_no_nacio, c3_p303_no_nacio+"");
        contentValues.put(SQLConstantes.modulo3_c3_p304,c3_p304+"");
        contentValues.put(SQLConstantes.modulo3_c3_p305,c3_p305+"");
        contentValues.put(SQLConstantes.modulo3_c3_p305_o,c3_p305_o);
        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo3 modulo3 = new Modulo3();
            modulo3.set_id(idEncuestado);
            modulo3.setIdVivienda(idVivienda);
            modulo3.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo3.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c3_p301_d = c3_p301_d_TextView.getText().toString();
        c3_p301_m = c3_p301_m_TextView.getText().toString();
        c3_p301_a = c3_p301_a_TextView.getText().toString();
        c3_p302 = c3_p302_AutoCompleteTextView.getText().toString();
        c3_p303_m = p303edtMes.getText().toString();
        c3_p303_a = p303edtAnio.getText().toString();
        if(c3_p303_CheckBox.isChecked())c3_p303_no_nacio = 1;
        else c3_p303_no_nacio = 0;
        c3_p304 = c3_p304_RadioGroup.indexOfChild(c3_p304_RadioGroup.findViewById(c3_p304_RadioGroup.getCheckedRadioButtonId()));
        c3_p305  = c3_p305_RadioGroup.indexOfChild(c3_p305_RadioGroup.findViewById(c3_p305_RadioGroup.getCheckedRadioButtonId()));
        c3_p305_o = c3_p305_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo3 modulo3 = data.getModulo3(idEncuestado);
            informanteSpinner.setSelection(Integer.parseInt(modulo3.getIdInformante()));
            c3_p301_d_TextView.setText(modulo3.getC3_p301_d());
            c3_p301_m_TextView.setText(modulo3.getC3_p301_m());
            c3_p301_a_TextView.setText(modulo3.getC3_p301_a());
            c3_p302_AutoCompleteTextView.setText(modulo3.getC3_p302());
            if(Integer.parseInt(modulo3.getC3_p303_no_nacio()) == 1) c3_p303_CheckBox.setChecked(true);
            else{
                p303edtMes.setText(modulo3.getC3_p303_m());
                p303edtAnio.setText(modulo3.getC3_p303_a());
            }
            if(!modulo3.getC3_p304().equals("-1"))((RadioButton)c3_p304_RadioGroup.getChildAt(Integer.parseInt(modulo3.getC3_p304()))).setChecked(true);
            if(!modulo3.getC3_p305().equals("-1"))((RadioButton)c3_p305_RadioGroup.getChildAt(Integer.parseInt(modulo3.getC3_p305()))).setChecked(true);
            c3_p305_o_EditText.setText(modulo3.getC3_p305_o());
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(informanteSpinner.getSelectedItemPosition() == 0) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if (c3_p301_d.trim().equals("")){mostrarMensaje("PREGUNTA 301: DEBE AGREGAR FECHA");return false;}
        if (c3_p302.trim().equals("")) {mostrarMensaje("PREGUNTA 302: DEBE INDICAR PAIS DE NACIMIENTO");return false;}
        if (!c3_p303_CheckBox.isChecked()){
            if(c3_p303_m.trim().equals("")) {mostrarMensaje("PREGUNTA 302: DEBE AGREGAR MES Y AÑO");return false;}
        }
        if (c3_p304 == -1){mostrarMensaje("PREGUNTA 304: DEBE MARCAR UNA OPCIÓN"); return false;}
        if (c3_p305 == -1){mostrarMensaje("PREGUNTA 305: DEBE MARCAR UNA OPCIÓN");return false;}
        if (c3_p305 == 3){mostrarMensaje("PREGUNTA 305: DEBE ESPECIFICAR EL PUESTO DE CONTROL");return false;}
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo3;
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
