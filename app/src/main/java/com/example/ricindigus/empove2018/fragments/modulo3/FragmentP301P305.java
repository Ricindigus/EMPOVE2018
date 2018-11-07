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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
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
    Spinner c3_p302_Spinner;
    CheckBox c3_p303_CheckBox;
    RadioGroup c3_p304_RadioGroup,c3_p305_RadioGroup;
    EditText c3_p305_o_EditText;
    Spinner p303spMes,p303spAnio;

    LinearLayout layout301,layout302,layout303,layout304,layout305;

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
    String c3_p303_no_nacio;
    String c3_p304;
    String c3_p305;
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
        c3_p302_Spinner = (Spinner) rootView.findViewById(R.id.mod3_302_spinner_C3_P302);
        p303spMes = (Spinner) rootView.findViewById(R.id.mod3_303_spinner_C3_P303_M);
        p303spAnio = (Spinner) rootView.findViewById(R.id.mod3_303_spinner_C3_P303_A);
        c3_p303_CheckBox = (CheckBox) rootView.findViewById(R.id.mod3_303_checkbox_C3_P303_NO_NACIO);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        layout301 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p301);
        layout302 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p302);
        layout303 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p303);
        layout304 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p304);
        layout305 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p305);


        c3_p304_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod3_304_radiogroup_C3_P304);
        c3_p305_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod3_305_radiogroup_C3_P305);
        c3_p305_o_EditText = (EditText) rootView.findViewById(R.id.mod3_305_edittext_C3_P305_O);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Data data =  new Data(context);
        data.open();


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

        configurarEditText(c3_p305_o_EditText,layout301,1,30);

        c3_p303_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    p303spMes.setSelection(0);
                    p303spAnio.setSelection(0);
                    p303spMes.setEnabled(false);
                    p303spAnio.setEnabled(false);
                    c3_p304_RadioGroup.clearCheck();layout304.setVisibility(View.GONE);
                    c3_p305_RadioGroup.clearCheck();c3_p305_o_EditText.setText("");layout305.setVisibility(View.GONE);
                }else{
                    p303spMes.setEnabled(true);p303spAnio.setEnabled(true);
                    layout304.setVisibility(View.VISIBLE);
                    layout305.setVisibility(View.VISIBLE);
                }
            }
        });

        c3_p304_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 1:layout305.setVisibility(View.VISIBLE);break;
                    case 2: c3_p305_RadioGroup.clearCheck();c3_p305_o_EditText.setText("");layout305.setVisibility(View.GONE);break;
                }
            }
        });

        c3_p305_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,4,c3_p305_o_EditText);
            }
        });
        llenarVista();
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
        contentValues.put(SQLConstantes.modulo3_c3_p302,data.getCodigoPais(Integer.parseInt(c3_p302)));
        contentValues.put(SQLConstantes.modulo3_c3_p303_m,c3_p303_m);
        contentValues.put(SQLConstantes.modulo3_c3_p303_a,getResources().getStringArray(R.array.numeros_anios)[Integer.parseInt(c3_p303_a)]);
        contentValues.put(SQLConstantes.modulo3_c3_p303_no_nacio, c3_p303_no_nacio);
        contentValues.put(SQLConstantes.modulo3_c3_p304,c3_p304);
        contentValues.put(SQLConstantes.modulo3_c3_p305,c3_p305);
        contentValues.put(SQLConstantes.modulo3_c3_p305_o,c3_p305_o);
        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo3 modulo3 = new Modulo3(idEncuestado,idHogar,idVivienda);
            data.insertarElemento(getNombreTabla(),modulo3.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
        ocultarOtrosLayouts();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c3_p301_d = c3_p301_d_TextView.getText().toString();
        c3_p301_m = c3_p301_m_TextView.getText().toString();
        c3_p301_a = c3_p301_a_TextView.getText().toString();
        c3_p302 = c3_p302_Spinner.getSelectedItemPosition() + "";
        c3_p303_m = p303spMes.getSelectedItemPosition() + "";
        c3_p303_a = p303spAnio.getSelectedItemPosition() + "";
        if(c3_p303_CheckBox.isChecked())c3_p303_no_nacio = 1 + "";
        else c3_p303_no_nacio = 0 + "";
        c3_p304 = c3_p304_RadioGroup.indexOfChild(c3_p304_RadioGroup.findViewById(c3_p304_RadioGroup.getCheckedRadioButtonId())) + "";
        c3_p305  = c3_p305_RadioGroup.indexOfChild(c3_p305_RadioGroup.findViewById(c3_p305_RadioGroup.getCheckedRadioButtonId())) + "";
        c3_p305_o = c3_p305_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo3 modulo3 = data.getModulo3(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(idHogar);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            if(!modulo3.getIdInformante().equals(""))informanteSpinner.setSelection(Integer.parseInt(modulo3.getIdInformante()));
            c3_p301_d_TextView.setText(modulo3.getC3_p301_d());
            c3_p301_m_TextView.setText(modulo3.getC3_p301_m());
            c3_p301_a_TextView.setText(modulo3.getC3_p301_a());
            if(!modulo3.getC3_p302().equals(""))c3_p302_Spinner.setSelection(data.getNumeroPais(modulo3.getC3_p302()));
            if(modulo3.getC3_p303_no_nacio().equals("1")) c3_p303_CheckBox.setChecked(true);
            else{
                if(!modulo3.getC3_p303_m().equals(""))p303spMes.setSelection(Integer.parseInt(modulo3.getC3_p303_m()));
                if(!modulo3.getC3_p303_a().equals(""))p303spAnio.setSelection(2019 - Integer.parseInt(modulo3.getC3_p303_a()));
            }
            if(!modulo3.getC3_p304().equals("-1") && !modulo3.getC3_p304().equals(""))((RadioButton)c3_p304_RadioGroup.getChildAt(Integer.parseInt(modulo3.getC3_p304()))).setChecked(true);
            if(!modulo3.getC3_p305().equals("-1") && !modulo3.getC3_p305().equals(""))((RadioButton)c3_p305_RadioGroup.getChildAt(Integer.parseInt(modulo3.getC3_p305()))).setChecked(true);
            c3_p305_o_EditText.setText(modulo3.getC3_p305_o());
        }
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p301,idEncuestado)) layout301.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p302,idEncuestado)) layout302.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p303,idEncuestado)) layout303.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p304,idEncuestado)) layout304.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p305,idEncuestado)) layout305.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if (c3_p301_d.trim().equals("")){mostrarMensaje("PREGUNTA 301: DEBE AGREGAR FECHA");return false;}
        if (c3_p302.equals("0")) {mostrarMensaje("PREGUNTA 302: DEBE INDICAR PAIS DE NACIMIENTO");return false;}
        if (!c3_p303_CheckBox.isChecked()){
            if(c3_p303_m.equals("0")) {mostrarMensaje("PREGUNTA 303: DEBE AGREGAR MES");return false;}
            if(c3_p303_a.equals("0")) {mostrarMensaje("PREGUNTA 303: DEBE AGREGAR ANIO");return false;}
        }
        if (layout304.getVisibility() == View.VISIBLE){
            if (c3_p304.equals("-1")){mostrarMensaje("PREGUNTA 304: DEBE MARCAR UNA OPCIÓN"); return false;}
        }else{ c3_p304 = "";}

        if (layout305.getVisibility() == View.VISIBLE){
            if (c3_p305.equals("-1")){mostrarMensaje("PREGUNTA 305: DEBE MARCAR UNA OPCIÓN");return false;}
            else if (c3_p305.equals("4")){
                if(c3_p305_o.trim().equals("")){ mostrarMensaje("PREGUNTA 305: DEBE ESPECIFICAR EL PUESTO DE CONTROL");return false;}
            }
        }else{
            c3_p305 = "";
            c3_p305_o = "";
        }
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

    private void configurarEditText(final EditText editText, final View view, int tipo,int longitud){
        if (tipo == 1) editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud)});

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
        if (tipo == 2) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(longitud)});
            editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        }
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
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

    public void ocultarOtrosLayouts(){
        if (c3_p303_CheckBox.isChecked()){
           // 6,7,8,9,10
            Data data = new Data(context);
            data.open();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo3_c3_p306,"");
            contentValues.put(SQLConstantes.modulo3_c3_p306_o,"");
            contentValues.put(SQLConstantes.modulo3_c3_p307_d,"");
            contentValues.put(SQLConstantes.modulo3_c3_p307_m,"");
            contentValues.put(SQLConstantes.modulo3_c3_p307_a,"");
            contentValues.put(SQLConstantes.modulo3_c3_p308_e,"");
            contentValues.put(SQLConstantes.modulo3_c3_p308_m,"");
            contentValues.put(SQLConstantes.modulo3_c3_p308_e_seleccion,"");
            contentValues.put(SQLConstantes.modulo3_c3_p308_m_seleccion,"");
            contentValues.put(SQLConstantes.modulo3_c3_p310_1,"");
            contentValues.put(SQLConstantes.modulo3_c3_p310_2,"");
            contentValues.put(SQLConstantes.modulo3_c3_p310_3,"");
            contentValues.put(SQLConstantes.modulo3_c3_p310_4,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
            data.borrarAllData(SQLConstantes.tablam3p309rutas);
            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p306,"0");
            contentValues.put(SQLConstantes.layouts_p307,"0");
            contentValues.put(SQLConstantes.layouts_p308,"0");
            contentValues.put(SQLConstantes.layouts_p309,"0");
            contentValues.put(SQLConstantes.layouts_p310,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p306p308,"-1",idEncuestado);
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p309,"-1",idEncuestado);
            data.close();
        }else{
            Data data = new Data(context);
            data.open();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p306,"1");
            contentValues.put(SQLConstantes.layouts_p307,"1");
            contentValues.put(SQLConstantes.layouts_p308,"1");
            contentValues.put(SQLConstantes.layouts_p309,"1");
            contentValues.put(SQLConstantes.layouts_p310,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p306p308,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p306p308,"1",idEncuestado);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p309,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p309,"1",idEncuestado);
            data.close();
        }
    }
}
