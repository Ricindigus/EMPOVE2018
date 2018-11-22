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
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP626P629 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    Context context;
    Spinner informanteSpinner;

    RadioGroup c6_p626_RadioGroup, c6_p627_RadioGroup;
    EditText c6_p628_EditText;

    TextView c6_p629_TextView;
    RadioGroup c6_p629_1_RadioGroup, c6_p629_2_RadioGroup, c6_p629_3_RadioGroup, c6_p629_4_RadioGroup;
    EditText c6_p629_o_EditText;
    Spinner c6_p629_1_f_Spinner;
    EditText c6_p629_1_m_EditText;
    Spinner c6_p629_2_f_Spinner;
    EditText c6_p629_2_m_EditText;
    Spinner c6_p629_3_f_Spinner;
    EditText c6_p629_3_m_EditText;
    Spinner c6_p629_4_f_Spinner;
    EditText c6_p629_4_m_EditText;
    LinearLayout m6_p626_linearlayout, m6_p627_linearlayout, m6_p628_linearlayout, m6_p629_linearlayout;

    private String c6_p626;
    private String c6_p627;
    private String c6_p628;
    private String c6_p629_1;
    private String c6_p629_2;
    private String c6_p629_3;
    private String c6_p629_4;
    private String c6_p629_o;
    private String c6_p629_1_f;
    private String c6_p629_1_m;
    private String c6_p629_2_f;
    private String c6_p629_2_m;
    private String c6_p629_3_f;
    private String c6_p629_3_m;
    private String c6_p629_4_f;
    private String c6_p629_4_m;

    @SuppressLint("ValidFragment")
    public FragmentP626P629(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentP626P629() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p626_p629, container, false);

        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);


        c6_p626_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_626_radiogroup_C6_P626);
        c6_p627_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_627_radiogroup_C6_P627);
        c6_p628_EditText = (EditText) rootView.findViewById(R.id.mod6_628_edittext_C6_P628);

        c6_p629_TextView = (TextView) rootView.findViewById(R.id.mod6_601_textview_C6_P629);
        c6_p629_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_1);
        c6_p629_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_2);
        c6_p629_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_3);
        c6_p629_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_629_radiogroup_C6_P629_4);
        c6_p629_o_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_O);

        c6_p629_1_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_1_F);
        c6_p629_1_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_1_M);
        c6_p629_2_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_2_F);
        c6_p629_2_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_2_M);
        c6_p629_3_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_3_F);
        c6_p629_3_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_3_M);
        c6_p629_4_f_Spinner = (Spinner) rootView.findViewById(R.id.mod6_629_spinner_C6_P629_4_F);
        c6_p629_4_m_EditText = (EditText) rootView.findViewById(R.id.mod6_629_edittext_C6_P629_4_M);

        m6_p626_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p626);
        m6_p627_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p627);
        m6_p628_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p628);
        m6_p629_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p629);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c6_p629_1_f_Spinner.setEnabled(false);
        c6_p629_2_f_Spinner.setEnabled(false);
        c6_p629_3_f_Spinner.setEnabled(false);
        c6_p629_4_f_Spinner.setEnabled(false);


        configurarEditText(c6_p628_EditText,m6_p628_linearlayout,1,30);
        configurarEditText(c6_p629_o_EditText,m6_p629_linearlayout,1,30);

        configurarEditText(c6_p629_1_m_EditText,m6_p629_linearlayout,2,5);
        configurarEditText(c6_p629_2_m_EditText,m6_p629_linearlayout,2,5);
        configurarEditText(c6_p629_3_m_EditText,m6_p629_linearlayout,2,5);
        configurarEditText(c6_p629_4_m_EditText,m6_p629_linearlayout,2,5);

        c6_p627_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p627_RadioGroup.findViewById(c6_p627_RadioGroup.getCheckedRadioButtonId()));
                if(pos==2){
                    m6_p628_linearlayout.setVisibility(View.GONE); limpiar_p628();
                }else{
                    m6_p628_linearlayout.setVisibility(View.VISIBLE);
                    c6_p628_EditText.requestFocus();
                }
            }
        });

        c6_p629_1_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p629_1_RadioGroup.findViewById(c6_p629_1_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    c6_p629_1_f_Spinner.setEnabled(true);
                    c6_p629_1_m_EditText.setEnabled(true);
                    c6_p629_1_m_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    c6_p629_1_f_Spinner.setEnabled(false);
                    c6_p629_1_m_EditText.setEnabled(false);
                    c6_p629_1_f_Spinner.setSelection(0);
                    c6_p629_1_m_EditText.setText("");
                    c6_p629_1_m_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                }
            }
        });

        c6_p629_2_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p629_2_RadioGroup.findViewById(c6_p629_2_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    c6_p629_2_f_Spinner.setEnabled(true);
                    c6_p629_2_m_EditText.setEnabled(true);
                    c6_p629_2_m_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    c6_p629_2_f_Spinner.setEnabled(false);
                    c6_p629_2_m_EditText.setEnabled(false);
                    c6_p629_2_f_Spinner.setSelection(0);
                    c6_p629_2_m_EditText.setText("");
                    c6_p629_2_m_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                }
            }
        });

        c6_p629_3_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p629_3_RadioGroup.findViewById(c6_p629_3_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    c6_p629_3_f_Spinner.setEnabled(true);
                    c6_p629_3_m_EditText.setEnabled(true);
                    c6_p629_3_m_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    c6_p629_3_f_Spinner.setEnabled(false);
                    c6_p629_3_m_EditText.setEnabled(false);
                    c6_p629_3_f_Spinner.setSelection(0);
                    c6_p629_3_m_EditText.setText("");
                    c6_p629_3_m_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                }
            }
        });

        c6_p629_4_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p629_4_RadioGroup.findViewById(c6_p629_4_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    c6_p629_o_EditText.setEnabled(true);
                    c6_p629_o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                    c6_p629_4_f_Spinner.setEnabled(true);
                    c6_p629_4_m_EditText.setEnabled(true);
                    c6_p629_4_m_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    c6_p629_o_EditText.setText("");
                    c6_p629_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                    c6_p629_o_EditText.setEnabled(false);
                    c6_p629_4_f_Spinner.setEnabled(false);
                    c6_p629_4_m_EditText.setEnabled(false);
                    c6_p629_4_f_Spinner.setSelection(0);
                    c6_p629_4_m_EditText.setText("");
                    c6_p629_4_m_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                }
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
        contentValues.put(SQLConstantes.modulo6_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo6_c6_p626,c6_p626);
        contentValues.put(SQLConstantes.modulo6_c6_p627,c6_p627);
        contentValues.put(SQLConstantes.modulo6_c6_p628,c6_p628);
        contentValues.put(SQLConstantes.modulo6_c6_p629_1,c6_p629_1);
        contentValues.put(SQLConstantes.modulo6_c6_p629_2,c6_p629_2);
        contentValues.put(SQLConstantes.modulo6_c6_p629_3,c6_p629_3);
        contentValues.put(SQLConstantes.modulo6_c6_p629_4,c6_p629_4);
        contentValues.put(SQLConstantes.modulo6_c6_p629_o,c6_p629_o);
        contentValues.put(SQLConstantes.modulo6_c6_p629_1_f,c6_p629_1_f);
        contentValues.put(SQLConstantes.modulo6_c6_p629_1_m,c6_p629_1_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_2_f,c6_p629_2_f);
        contentValues.put(SQLConstantes.modulo6_c6_p629_2_m,c6_p629_2_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_3_f,c6_p629_3_f);
        contentValues.put(SQLConstantes.modulo6_c6_p629_3_m,c6_p629_3_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_4_f,c6_p629_4_f);
        contentValues.put(SQLConstantes.modulo6_c6_p629_4_m,c6_p629_4_m);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        //Ya valido y guardo correctamente el fragment, ahora actualizamos el valor de la cobertura del fragment a correcto(1)
        data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp626p629,"1",idEncuestado);
        //verificamos la cobertura del capitulo y actualizamos su valor de cobertura.
        if (verificarCoberturaCapitulo()) data.actualizarValor(getNombreTabla(),SQLConstantes.modulo6_COB600,"1",idEncuestado);
        else data.actualizarValor(getNombreTabla(),SQLConstantes.modulo6_COB600,"0",idEncuestado);
        data.actualizarValor(SQLConstantes.tablaresidentes,SQLConstantes.residentes_encuestado_cobertura,"0",idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c6_p626 = c6_p626_RadioGroup.indexOfChild(c6_p626_RadioGroup.findViewById(c6_p626_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p627 = c6_p627_RadioGroup.indexOfChild(c6_p627_RadioGroup.findViewById(c6_p627_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p628 = c6_p628_EditText.getText().toString();
        c6_p629_1 = c6_p629_1_RadioGroup.indexOfChild(c6_p629_1_RadioGroup.findViewById(c6_p629_1_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p629_2 = c6_p629_2_RadioGroup.indexOfChild(c6_p629_2_RadioGroup.findViewById(c6_p629_2_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p629_3 = c6_p629_3_RadioGroup.indexOfChild(c6_p629_3_RadioGroup.findViewById(c6_p629_3_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p629_4 = c6_p629_4_RadioGroup.indexOfChild(c6_p629_4_RadioGroup.findViewById(c6_p629_4_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p629_o = c6_p629_o_EditText.getText().toString();
        c6_p629_1_f = c6_p629_1_f_Spinner.getSelectedItemPosition()+"";
        c6_p629_1_m = c6_p629_1_m_EditText.getText().toString();
        c6_p629_2_f = c6_p629_2_f_Spinner.getSelectedItemPosition()+"";
        c6_p629_2_m = c6_p629_2_m_EditText.getText().toString();
        c6_p629_3_f = c6_p629_3_f_Spinner.getSelectedItemPosition()+"";
        c6_p629_3_m = c6_p629_3_m_EditText.getText().toString();
        c6_p629_4_f = c6_p629_4_f_Spinner.getSelectedItemPosition()+"";
        c6_p629_4_m = c6_p629_4_m_EditText.getText().toString();
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
            if(!modulo6.getC6_p626().equals("-1") && !modulo6.getC6_p626().equals(""))((RadioButton)c6_p626_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p626()))).setChecked(true);
            if(!modulo6.getC6_p627().equals("-1") && !modulo6.getC6_p627().equals(""))((RadioButton)c6_p627_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p627()))).setChecked(true);
            c6_p628_EditText.setText(modulo6.getC6_p628());
            if(!modulo6.getC6_p629_1().equals("-1") && !modulo6.getC6_p629_1().equals(""))((RadioButton)c6_p629_1_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p629_1()))).setChecked(true);
            if(!modulo6.getC6_p629_2().equals("-1") && !modulo6.getC6_p629_2().equals(""))((RadioButton)c6_p629_2_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p629_2()))).setChecked(true);
            if(!modulo6.getC6_p629_3().equals("-1") && !modulo6.getC6_p629_3().equals(""))((RadioButton)c6_p629_3_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p629_3()))).setChecked(true);
            if(!modulo6.getC6_p629_4().equals("-1") && !modulo6.getC6_p629_4().equals(""))((RadioButton)c6_p629_4_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p629_4()))).setChecked(true);
            c6_p629_o_EditText.setText(modulo6.getC6_p629_o());
            if(!modulo6.getC6_p629_1_f().equals("")) c6_p629_1_f_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p629_1_f()));
            c6_p629_1_m_EditText.setText(modulo6.getC6_p629_1_m());
            if(!modulo6.getC6_p629_2_f().equals("")) c6_p629_2_f_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p629_2_f()));
            c6_p629_2_m_EditText.setText(modulo6.getC6_p629_2_m());
            if(!modulo6.getC6_p629_3_f().equals("")) c6_p629_3_f_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p629_3_f()));
            c6_p629_3_m_EditText.setText(modulo6.getC6_p629_3_m());
            if(!modulo6.getC6_p629_4_f().equals("")) c6_p629_4_f_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p629_4_f()));
            c6_p629_4_m_EditText.setText(modulo6.getC6_p629_4_m());
        }
        fecha();
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p626,idEncuestado)) m6_p626_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p627,idEncuestado)) m6_p627_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p628,idEncuestado)) m6_p628_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p629,idEncuestado)) m6_p629_linearlayout.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if(c6_p626.equals("-1")){ mostrarMensaje("PREGUNTA 626: DEBE SELECCIONAR UNA OPCION");return false; }
        if(c6_p627.equals("-1")){ mostrarMensaje("PREGUNTA 627: DEBE SELECCIONAR UNA OPCION");return false; }

        if (m6_p628_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p628.trim().equals("")){ mostrarMensaje("PREGUNTA 628: DEBE INGRESAR NRO DE SEMANAS");return false; }
        }else{c6_p628="";}
        if (m6_p629_linearlayout.getVisibility()==View.VISIBLE) {
            if (c6_p629_1.equals("-1")) {
                mostrarMensaje("PREGUNTA 629-A: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if (c6_p629_1.equals("1")) {
                if (c6_p629_1_f.equals("0")) {
                    mostrarMensaje("PREGUNTA 629-A: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if (c6_p629_1_m.trim().equals("")) {
                    mostrarMensaje("PREGUNTA 629-A: DEBE INGRESAR MONTO");
                    return false;
                }
            }

            if (c6_p629_2.equals("-1")) {
                mostrarMensaje("PREGUNTA 629-B: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if (c6_p629_2.equals("1")) {
                if (c6_p629_2_f.equals("0")) {
                    mostrarMensaje("PREGUNTA 629-B: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if (c6_p629_2_m.trim().equals("")) {
                    mostrarMensaje("PREGUNTA 629-B: DEBE INGRESAR MONTO");
                    return false;
                }
            }

            if (c6_p629_3.equals("-1")) {
                mostrarMensaje("PREGUNTA 629-C: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if (c6_p629_3.equals("1")) {
                if (c6_p629_3_f.equals("0")) {
                    mostrarMensaje("PREGUNTA 629-C: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if (c6_p629_3_m.trim().equals("")) {
                    mostrarMensaje("PREGUNTA 629-C: DEBE INGRESAR MONTO");
                    return false;
                }
            }
            if (c6_p629_4.equals("-1")) {
                mostrarMensaje("PREGUNTA 629-D: DEBE SELECCIONAR UNA OPCION");
                return false;
            }

            if (c6_p629_4.equals("1")) {
                if (c6_p629_o.trim().equals("")) {
                    mostrarMensaje("PREGUNTA 629-D: DEBE ESPECIFICAR OTRO");
                    return false;
                }
                if (c6_p629_4_f.equals("0")) {
                    mostrarMensaje("PREGUNTA 629-D: DEBE SELECCIONAR FRECUENCIA");
                    return false;
                }
                if (c6_p629_4_m.trim().equals("")) {
                    mostrarMensaje("PREGUNTA 629-D: DEBE INGRESAR MONTO");
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

    public void limpiar_p626(){
        c6_p626_RadioGroup.clearCheck();
    }

    public void limpiar_p627(){
        c6_p627_RadioGroup.clearCheck();
    }

    public void limpiar_p628(){
        c6_p628_EditText.setText("");
    }

    public void limpiar_p629(){
        c6_p629_1_RadioGroup.clearCheck(); c6_p629_2_RadioGroup.clearCheck();
        c6_p629_3_RadioGroup.clearCheck(); c6_p629_4_RadioGroup.clearCheck();
        c6_p629_o_EditText.setText("");
        c6_p629_1_f_Spinner.setSelection(0); c6_p629_2_f_Spinner.setSelection(0);
        c6_p629_3_f_Spinner.setSelection(0); c6_p629_4_f_Spinner.setSelection(0);
        c6_p629_1_m_EditText.setText("");
        c6_p629_2_m_EditText.setText("");
        c6_p629_3_m_EditText.setText("");
        c6_p629_4_m_EditText.setText("");
    }


    public String NombreMes(int mes){
        String nom_mes="";
        switch(mes){
            case 0: nom_mes="ENERO"; break;
            case 1: nom_mes="FEBRERO"; break;
            case 2: nom_mes="MARZO"; break;
            case 3: nom_mes="ABRIL"; break;
            case 4: nom_mes="MAYO"; break;
            case 5: nom_mes="JUNIO"; break;
            case 6: nom_mes="JULIO"; break;
            case 7: nom_mes="AGOSTO"; break;
            case 8: nom_mes="SETIEMBRE"; break;
            case 9: nom_mes="OCTUBRE"; break;
            case 10: nom_mes="NOVIEMBRE"; break;
            case 11: nom_mes="DICIEMBRE"; break;
        }
        return nom_mes;
    }

    public void fecha(){
        Calendar calendario;
        int mm=0;
        String fecha_inicial="", fecha_final="";
        calendario = Calendar.getInstance();
        mm = calendario.get(Calendar.MONTH);
        fecha_final = "" + NombreMes(mm);
        calendario.add(Calendar.MONTH,-6);
        mm = calendario.get(Calendar.MONTH);
        fecha_inicial = "" + NombreMes(mm);
        String enunciado_p629 = c6_p629_TextView.getText()+"";
        enunciado_p629 = enunciado_p629.replace("FECHAINI", fecha_inicial);
        enunciado_p629 = enunciado_p629.replace("FECHAFIN", fecha_final);
        c6_p629_TextView.setText(enunciado_p629);
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
    public boolean verificarCoberturaCapitulo(){
        Data data = new Data(context);
        data.open();
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p601p604,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp601p604,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp605p608,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp609p612,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p617,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp613p617,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p618p621,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp618p621,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp622p625,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p626p629,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp626p629,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p630,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp630,idEncuestado).equals("0")) return false;
        data.close();
        return true;
    }
}
