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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

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
    LinearLayout layoutp306, layoutp307, layoutp308;

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
        layoutp306 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p306);
        layoutp307 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p307);
        layoutp308 = (LinearLayout) rootView.findViewById(R.id.layout_m3_p308);

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

        configurarEditText(c3_p306_EditText,layoutp306,1,30);
        configurarEditText(c3_p308_estado_EditText,layoutp308,1,30);
        configurarEditText(c3_p308_municipio_EditText,layoutp308,1,30);

        c3_p306_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,6,c3_p306_EditText);
            }
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_c3_p306,c3_p306+"");
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
        if (c3_p306 == 6){
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

}
