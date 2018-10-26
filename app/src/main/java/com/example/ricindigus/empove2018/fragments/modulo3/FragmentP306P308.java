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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP306P308 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    Context context;
    private static final String CERO = "0";
    public final Calendar c = Calendar.getInstance();
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);
    Spinner informanteSpinner;

    TextView c3_p307_TextViewDia, c3_p307_TextViewMes, c3_p307_TextViewAnio;
    Button c3_p307_d_f_Button;
    RadioGroup c3_p306_RadioGroup;
    EditText c3_p306_EditText, c3_p308_estado_EditText, c3_p308_municipio_EditText;

    int c3_p306;
    String c3_p306_o;
    String c3_p307_d;
    String c3_p307_m;
    String c3_p307_a;
    String c3_p308_e;
    String c3_p308_m;

    public FragmentP306P308() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP306P308(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p306_p308, container, false);
        c3_p307_TextViewDia = (TextView) rootView.findViewById(R.id.mod3_307_textview_C3_P307_D);
        c3_p307_TextViewMes = (TextView) rootView.findViewById(R.id.mod3_307_textview_C3_P307_M);
        c3_p307_TextViewAnio = (TextView) rootView.findViewById(R.id.mod3_307_textview_C3_P307_A);
        c3_p307_d_f_Button = (Button) rootView.findViewById(R.id.mod3_307_button_C3_P307_F);
        c3_p306_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod3_306_radiogroup_C3_P306);
        c3_p306_EditText = (EditText) rootView.findViewById(R.id.mod3_306_edittext_C3_P306_O);
        c3_p308_estado_EditText = (EditText) rootView.findViewById(R.id.mod3_308_edittext_C3_P308_E);
        c3_p308_municipio_EditText = (EditText) rootView.findViewById(R.id.mod3_308_edittext_C3_P308_M);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c3_p307_d_f_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog recogeFecha = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final int mesActual = month + 1;
                        String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                        c3_p307_TextViewDia.setText(""+diaFormateado);
                        c3_p307_TextViewMes.setText(""+mesFormateado);
                        c3_p307_TextViewAnio.setText(""+year);
                    }
                },anio,mes,dia);
                recogeFecha.show();
            }
        });

        c3_p306_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(30)});
        c3_p308_estado_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(30)});
        c3_p308_municipio_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(30)});
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_c3_p306,c3_p306);
        contentValues.put(SQLConstantes.modulo3_c3_p306_o,c3_p306_o);
        contentValues.put(SQLConstantes.modulo3_c3_p307_d,c3_p307_d);
        contentValues.put(SQLConstantes.modulo3_c3_p307_m,c3_p307_m);
        contentValues.put(SQLConstantes.modulo3_c3_p307_a,c3_p307_a);
        contentValues.put(SQLConstantes.modulo3_c3_p308_e,c3_p308_e);
        contentValues.put(SQLConstantes.modulo3_c3_p308_m,c3_p308_m);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c3_p306 = c3_p306_RadioGroup.indexOfChild(c3_p306_RadioGroup.findViewById(c3_p306_RadioGroup.getCheckedRadioButtonId()));
        c3_p306_o  = c3_p306_EditText.getText().toString();
        c3_p307_d  = c3_p307_TextViewDia.getText().toString();
        c3_p307_m  = c3_p307_TextViewMes.getText().toString();
        c3_p307_a  = c3_p307_TextViewAnio.getText().toString();
        c3_p308_e  = c3_p308_estado_EditText.getText().toString();
        c3_p308_m  = c3_p308_municipio_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo3 modulo3 = data.getModulo3(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo3.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            informanteSpinner.setSelection(Integer.parseInt(modulo3.getIdInformante()));
            if(!modulo3.getC3_p306().equals("-1") && !modulo3.getC3_p306().equals(""))((RadioButton)c3_p306_RadioGroup.getChildAt(Integer.parseInt(modulo3.getC3_p306()))).setChecked(true);
            c3_p306_EditText.setText(modulo3.getC3_p306_o());
            c3_p307_TextViewDia.setText(modulo3.getC3_p307_d());
            c3_p307_TextViewMes.setText(modulo3.getC3_p307_m());
            c3_p307_TextViewAnio.setText(modulo3.getC3_p307_a());
            c3_p308_estado_EditText.setText(modulo3.getC3_p308_e());
            c3_p308_municipio_EditText.setText(modulo3.getC3_p308_m());
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(informanteSpinner.getSelectedItemPosition() == 0) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if (c3_p306 == -1){mostrarMensaje("PREGUNTA 306: DEBE MARCAR UNA OPCIÓN"); return false;}
        if (c3_p306 == 5){
            if (c3_p306_o.trim().equals("")){mostrarMensaje("PREGUNTA 306: DEBE ESPECIFICAR");return false;}
        }
        if (c3_p307_d.trim().equals("")){mostrarMensaje("PREGUNTA 307: DEBE AGREGAR FECHA");return false;}
        if (c3_p308_e.trim().equals("")){mostrarMensaje("PREGUNTA 308: DEBE INDICAR ESTADO");return false;}
        if (c3_p308_m.trim().equals("")){mostrarMensaje("PREGUNTA 308: DEBE INDICAR MUNICIPIO");return false;}
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
