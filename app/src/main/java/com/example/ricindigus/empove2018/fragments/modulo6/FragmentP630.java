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
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP630 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    Spinner informanteSpinner;
    RadioGroup c6_p630_1_RadioGroup, c6_p630_1med_RadioGroup;
    EditText c6_p630_1o_EditText, c6_p630_1frec_o_EditText, c6_p630_2frec_o_EditText;
    Spinner c6_p630_1frec_Spinner, c6_p630_1mont_Spinner;
    RadioGroup c6_p630_2_RadioGroup, c6_p630_2med_RadioGroup;
    EditText c6_p630_2o_EditText;
    Spinner c6_p630_2frec_Spinner, c6_p630_2mont_Spinner;
    LinearLayout m6_p630_linearlayout;
    LinearLayout m6_p630_1_linearlayout, m6_p630_2_linearlayout;

    private String c6_p630_1;
    private String c6_p630_1med;
    private String c6_p630_1o;
    private String c6_p630_1frec;
    private String c6_p630_1frec_o;
    private String c6_p630_1mont;
    private String c6_p630_2;
    private String c6_p630_2med;
    private String c6_p630_2o;
    private String c6_p630_2mont;
    private String c6_p630_2frec;
    private String c6_p630_2frec_o;


    @SuppressLint("ValidFragment")
    public FragmentP630(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentP630() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p630, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c6_p630_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_1);
        c6_p630_1med_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_1_MED);
        c6_p630_1o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_1_O);
        c6_p630_1frec_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_1_FREC);
        c6_p630_1frec_o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_1_FREC_O);
        c6_p630_1mont_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_1_MONT);

        c6_p630_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_2);
        c6_p630_2med_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_630_radiogroup_C6_P630_2_MED);
        c6_p630_2o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_2_O);
        c6_p630_2frec_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_2_FREC);
        c6_p630_2frec_o_EditText = (EditText) rootView.findViewById(R.id.mod6_630_edittext_C6_P630_2_FREC_O);
        c6_p630_2mont_Spinner = (Spinner) rootView.findViewById(R.id.mod6_630_spinner_C6_P630_2_MONT);

        m6_p630_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p630);
        m6_p630_1_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_630_1);
        m6_p630_2_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_630_2);

        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configurarEditText(c6_p630_1o_EditText,m6_p630_1_linearlayout,1,30);
        configurarEditText(c6_p630_2o_EditText,m6_p630_2_linearlayout,1,30);

        c6_p630_1_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p630_1_RadioGroup.findViewById(c6_p630_1_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    m6_p630_1_linearlayout.setVisibility(View.VISIBLE);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(0)).setEnabled(true);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(1)).setEnabled(true);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(2)).setEnabled(true);
                    c6_p630_1frec_Spinner.setEnabled(true);
                    c6_p630_1mont_Spinner.setEnabled(true);
                }else{
                    limpiar_p630_1();
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(0)).setEnabled(false);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(1)).setEnabled(false);
                    ((RadioButton)c6_p630_1med_RadioGroup.getChildAt(2)).setEnabled(false);
                    c6_p630_1o_EditText.setEnabled(false);
                    c6_p630_1frec_Spinner.setEnabled(false);
                    c6_p630_1mont_Spinner.setEnabled(false);
                    m6_p630_1_linearlayout.setVisibility(View.GONE);
                }
            }
        });
        c6_p630_2_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p630_2_RadioGroup.findViewById(c6_p630_2_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    m6_p630_2_linearlayout.setVisibility(View.VISIBLE);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(0)).setEnabled(true);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(1)).setEnabled(true);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(2)).setEnabled(true);
                    c6_p630_2frec_Spinner.setEnabled(true);
                    c6_p630_2mont_Spinner.setEnabled(true);
                }else{
                    limpiar_p630_2();
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(0)).setEnabled(false);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(1)).setEnabled(false);
                    ((RadioButton)c6_p630_2med_RadioGroup.getChildAt(2)).setEnabled(false);
                    c6_p630_2o_EditText.setEnabled(false);
                    c6_p630_2frec_Spinner.setEnabled(false);
                    c6_p630_2mont_Spinner.setEnabled(false);
                    m6_p630_2_linearlayout.setVisibility(View.GONE);
                }
            }
        });
        c6_p630_1med_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p630_1med_RadioGroup.findViewById(c6_p630_1med_RadioGroup.getCheckedRadioButtonId()));
                if(pos==3){
                    c6_p630_1o_EditText.setEnabled(true);
                    c6_p630_1o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    c6_p630_1o_EditText.setText("");
                    c6_p630_1o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                    c6_p630_1o_EditText.setEnabled(false);
                }
            }
        });

        c6_p630_1frec_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos == 6){
                    c6_p630_1frec_o_EditText.setEnabled(true);
                    c6_p630_1frec_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p630_1frec_o_EditText.setEnabled(false);
                    c6_p630_1frec_o_EditText.setText("");
                    c6_p630_1frec_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        c6_p630_2med_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p630_2med_RadioGroup.findViewById(c6_p630_2med_RadioGroup.getCheckedRadioButtonId()));
                if(pos==3){
                    c6_p630_2o_EditText.setEnabled(true);
                    c6_p630_2o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    c6_p630_2o_EditText.setText("");
                    c6_p630_2o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                    c6_p630_2o_EditText.setEnabled(false);
                }
            }
        });

        c6_p630_2frec_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos == 6){
                    c6_p630_2frec_o_EditText.setEnabled(true);
                    c6_p630_2frec_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p630_2frec_o_EditText.setEnabled(false);
                    c6_p630_2frec_o_EditText.setText("");
                    c6_p630_2frec_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1,c6_p630_1);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1med,c6_p630_1med);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1o,c6_p630_1o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1frec,c6_p630_1frec);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1frec_o,c6_p630_1frec_o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1mont,c6_p630_1mont);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2,c6_p630_2);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2med,c6_p630_2med);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2o,c6_p630_2o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2frec,c6_p630_2frec);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2frec_o,c6_p630_2frec_o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2mont,c6_p630_2mont);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition() + "";
        c6_p630_1 = c6_p630_1_RadioGroup.indexOfChild(c6_p630_1_RadioGroup.findViewById(c6_p630_1_RadioGroup.getCheckedRadioButtonId())) + "";
        c6_p630_1med = c6_p630_1med_RadioGroup.indexOfChild(c6_p630_1med_RadioGroup.findViewById(c6_p630_1med_RadioGroup.getCheckedRadioButtonId()))+ "";
        c6_p630_1o = c6_p630_1o_EditText.getText().toString();
        c6_p630_1frec = c6_p630_1frec_Spinner.getSelectedItemPosition()+ "";
        c6_p630_1frec_o = c6_p630_1frec_o_EditText.getText().toString();
        c6_p630_1mont = c6_p630_1mont_Spinner.getSelectedItemPosition()+ "";
        c6_p630_2 = c6_p630_2_RadioGroup.indexOfChild(c6_p630_2_RadioGroup.findViewById(c6_p630_2_RadioGroup.getCheckedRadioButtonId()))+ "";
        c6_p630_2med = c6_p630_2med_RadioGroup.indexOfChild(c6_p630_2med_RadioGroup.findViewById(c6_p630_2med_RadioGroup.getCheckedRadioButtonId()))+ "";
        c6_p630_2o = c6_p630_2o_EditText.getText().toString();
        c6_p630_2frec = c6_p630_2frec_Spinner.getSelectedItemPosition()+ "";
        c6_p630_2frec_o = c6_p630_2frec_o_EditText.getText().toString();
        c6_p630_2mont = c6_p630_2mont_Spinner.getSelectedItemPosition()+ "";
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = data.getModulo6(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo6.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            if(!modulo6.getIdInformante().equals(""))informanteSpinner.setSelection(Integer.parseInt(modulo6.getIdInformante()));
            if(!modulo6.getC6_p630_1().equals("-1") && !modulo6.getC6_p630_1().equals(""))((RadioButton)c6_p630_1_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p630_1()))).setChecked(true);
            if(!modulo6.getC6_p630_1med().equals("-1") && !modulo6.getC6_p630_1med().equals(""))((RadioButton)c6_p630_1med_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p630_1med()))).setChecked(true);
            c6_p630_1o_EditText.setText(modulo6.getC6_p630_1o());
            if(!modulo6.getC6_p630_1frec().equals("")) c6_p630_1frec_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p630_1frec()));
            c6_p630_1frec_o_EditText.setText(modulo6.getC6_p630_1frec_o());
            if(!modulo6.getC6_p630_1mont().equals("")) c6_p630_1mont_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p630_1mont()));
            if(!modulo6.getC6_p630_2().equals("-1") && !modulo6.getC6_p630_2().equals(""))((RadioButton)c6_p630_2_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p630_2()))).setChecked(true);
            if(!modulo6.getC6_p630_2med().equals("-1") && !modulo6.getC6_p630_2med().equals(""))((RadioButton)c6_p630_2med_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p630_2med()))).setChecked(true);
            c6_p630_2o_EditText.setText(modulo6.getC6_p630_2o());
            if(!modulo6.getC6_p630_2frec().equals("")) c6_p630_2frec_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p630_2frec()));
            c6_p630_2frec_o_EditText.setText(modulo6.getC6_p630_2frec_o());
            if(!modulo6.getC6_p630_2mont().equals("")) c6_p630_2mont_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p630_2mont()));
        }
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if (c6_p630_1.equals("-1")) { mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR UNA OPCION");return false;}
        if (c6_p630_1.equals("1")) {
            if (c6_p630_1med.equals("3")) {
                if (c6_p630_1o.trim().equals("")){ mostrarMensaje("PREGUNTA 630-A: DEBE ESPECIFICAR OTRO");return false; }
            }
            if (c6_p630_1frec.equals("0")) { mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR FRECUENCIA");return false; }
            if (c6_p630_1frec.equals("6")) {
                if(c6_p630_1frec_o.trim().equals("")){
                    mostrarMensaje("PREGUNTA 630-A: DEBE ESPECIFICAR OTRA FRECUENCIA");return false;
                }
            }
            if (c6_p630_1mont.equals("0")) { mostrarMensaje("PREGUNTA 630-A: DEBE SELECCIONAR MONTO");return false; }
        }

        if (c6_p630_2.equals("-1")) { mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR UNA OPCION");return false; }
        if (c6_p630_2.equals("1")) {
            if (c6_p630_2med.equals("-1")) { mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR MEDIO DE ENVIO");return false; }
            if (c6_p630_2med.equals("3")) {
                if (c6_p630_2o.trim().equals("")) { mostrarMensaje("PREGUNTA 630-B: DEBE ESPECIFICAR OTRO");return false; }
            }
            if (c6_p630_2frec.equals("0")) { mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR FRECUENCIA");return false; }
            if (c6_p630_2frec.equals("6")) {
                if(c6_p630_2frec_o.trim().equals("")){
                    mostrarMensaje("PREGUNTA 630-B: DEBE ESPECIFICAR OTRA FRECUENCIA");return false;
                }
            }
            if (c6_p630_2mont.equals("0")) { mostrarMensaje("PREGUNTA 630-B: DEBE SELECCIONAR MONTO");return false; }
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

    public void limpiar_p630_1(){
        c6_p630_1med_RadioGroup.clearCheck();
        c6_p630_1o_EditText.setText("");
        c6_p630_1frec_Spinner.setSelection(0);
        c6_p630_1mont_Spinner.setSelection(0);
    }

    public void limpiar_p630_2(){
        c6_p630_2med_RadioGroup.clearCheck();
        c6_p630_2o_EditText.setText("");
        c6_p630_2frec_Spinner.setSelection(0);
        c6_p630_2mont_Spinner.setSelection(0);
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

    public void controlarChecked(CheckBox checkBox, final EditText editText){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    editText.setBackgroundResource(R.drawable.input_text_enabled);
                    editText.setEnabled(true);
                }else{
                    editText.setText("");
                    editText.setBackgroundResource(R.drawable.input_text_disabled);
                    editText.setEnabled(false);
                }
            }
        });
    }
}
