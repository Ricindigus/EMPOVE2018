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

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.POJOLayout;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP618P621 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    Context context;

    Spinner informanteSpinner;
    RadioGroup c6_p618_RadioGroup,
            c6_p619_1_RadioGroup, c6_p619_2_RadioGroup, c6_p619_3_RadioGroup, c6_p619_4_RadioGroup,
            c6_p619_5_RadioGroup, c6_p619_6_RadioGroup, c6_p619_7_RadioGroup, c6_p619_8_RadioGroup,
            c6_p619_9_RadioGroup;
    EditText c6_p619_o_EditText;
    RadioGroup c6_p620_RadioGroup, c6_p621_RadioGroup;
    LinearLayout m6_p618_linearlayout, m6_p619_linearlayout, m6_p620_linearlayout, m6_p621_linearlayout;

    private boolean c6_604=true;

    private String c6_p618;
    private String c6_p619_1;
    private String c6_p619_2;
    private String c6_p619_3;
    private String c6_p619_4;
    private String c6_p619_5;
    private String c6_p619_6;
    private String c6_p619_7;
    private String c6_p619_8;
    private String c6_p619_9;
    private String c6_p619_o;
    private String c6_p620;
    private String c6_p621;


    @SuppressLint("ValidFragment")
    public FragmentP618P621(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentP618P621() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_p618_p621, container, false);

        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c6_p618_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_619_radiogroup_C6_P619);

        c6_p619_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_1);
        c6_p619_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_2);
        c6_p619_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_3);
        c6_p619_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_4);
        c6_p619_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_5);
        c6_p619_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_6);
        c6_p619_7_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_7);
        c6_p619_8_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_8);
        c6_p619_9_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_620_radiogroup_C6_P620_9);
        c6_p619_o_EditText = (EditText) rootView.findViewById(R.id.mod6_620_edittext_C6_P620_O);

        c6_p620_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_621_radiogroup_C6_P621);
        c6_p621_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_622_radiogroup_C6_P622);

        m6_p618_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p619);
        m6_p619_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p620);
        m6_p620_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p621);
        m6_p621_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p622);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configurarEditText(c6_p619_o_EditText,m6_p619_linearlayout,0,30);
        c6_p619_9_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group,checkedId,1,c6_p619_o_EditText);
            }
        });



        c6_p618_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p618_RadioGroup.findViewById(c6_p618_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    limpiar_p619(); limpiar_p620(); limpiar_p621();
                    m6_p619_linearlayout.setVisibility(View.GONE);
                    m6_p620_linearlayout.setVisibility(View.GONE);
                    m6_p621_linearlayout.setVisibility(View.GONE);
                }else{
                    m6_p619_linearlayout.setVisibility(View.VISIBLE);
                    m6_p620_linearlayout.setVisibility(View.VISIBLE);
                    m6_p621_linearlayout.setVisibility(View.VISIBLE);
                    c6_p619_1_RadioGroup.requestFocus();
                }
            }
        });


        c6_p620_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p620_RadioGroup.findViewById(c6_p620_RadioGroup.getCheckedRadioButtonId()));
                if(pos==2){
                    limpiar_p621();
                    m6_p621_linearlayout.setVisibility(View.GONE);
                }else{
                    m6_p621_linearlayout.setVisibility(View.VISIBLE);
                    c6_p621_RadioGroup.requestFocus();
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
        contentValues.put(SQLConstantes.modulo6_c6_p618,c6_p618);
        contentValues.put(SQLConstantes.modulo6_c6_p619_1,c6_p619_1);
        contentValues.put(SQLConstantes.modulo6_c6_p619_2,c6_p619_2);
        contentValues.put(SQLConstantes.modulo6_c6_p619_3,c6_p619_3);
        contentValues.put(SQLConstantes.modulo6_c6_p619_4,c6_p619_4);
        contentValues.put(SQLConstantes.modulo6_c6_p619_5,c6_p619_5);
        contentValues.put(SQLConstantes.modulo6_c6_p619_6,c6_p619_6);
        contentValues.put(SQLConstantes.modulo6_c6_p619_7,c6_p619_7);
        contentValues.put(SQLConstantes.modulo6_c6_p619_8,c6_p619_8);
        contentValues.put(SQLConstantes.modulo6_c6_p619_9,c6_p619_9);
        contentValues.put(SQLConstantes.modulo6_c6_p619_o,c6_p619_o);
        contentValues.put(SQLConstantes.modulo6_c6_p620,c6_p620);
        contentValues.put(SQLConstantes.modulo6_c6_p621,c6_p621);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        //Ya valido y guardo correctamente el fragment, ahora actualizamos el valor de la cobertura del fragment a correcto(1)
        data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp618p621,"1",idEncuestado);
        //ocultamos o mostramos preguntas o fragments
        ocultarOtrosLayouts();
        //verificamos la cobertura del capitulo y actualizamos su valor de cobertura.
        if (verificarCoberturaCapitulo()) data.actualizarValor(getNombreTabla(),SQLConstantes.modulo6_COB600,"1",idEncuestado);
        else data.actualizarValor(getNombreTabla(),SQLConstantes.modulo6_COB600,"0",idEncuestado);
        data.actualizarValor(SQLConstantes.tablaresidentes,SQLConstantes.residentes_encuestado_cobertura,"0",idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c6_p618 = c6_p618_RadioGroup.indexOfChild(c6_p618_RadioGroup.findViewById(c6_p618_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_1 = c6_p619_1_RadioGroup.indexOfChild(c6_p619_1_RadioGroup.findViewById(c6_p619_1_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_2 = c6_p619_2_RadioGroup.indexOfChild(c6_p619_2_RadioGroup.findViewById(c6_p619_2_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_3 = c6_p619_3_RadioGroup.indexOfChild(c6_p619_3_RadioGroup.findViewById(c6_p619_3_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_4 = c6_p619_4_RadioGroup.indexOfChild(c6_p619_4_RadioGroup.findViewById(c6_p619_4_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_5 = c6_p619_5_RadioGroup.indexOfChild(c6_p619_5_RadioGroup.findViewById(c6_p619_5_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_6 = c6_p619_6_RadioGroup.indexOfChild(c6_p619_6_RadioGroup.findViewById(c6_p619_6_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_7 = c6_p619_7_RadioGroup.indexOfChild(c6_p619_7_RadioGroup.findViewById(c6_p619_7_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_8 = c6_p619_8_RadioGroup.indexOfChild(c6_p619_8_RadioGroup.findViewById(c6_p619_8_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_9 = c6_p619_9_RadioGroup.indexOfChild(c6_p619_9_RadioGroup.findViewById(c6_p619_9_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p619_o = c6_p619_o_EditText.getText().toString();
        c6_p620 = c6_p620_RadioGroup.indexOfChild(c6_p620_RadioGroup.findViewById(c6_p620_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p621 = c6_p621_RadioGroup.indexOfChild(c6_p621_RadioGroup.findViewById(c6_p621_RadioGroup.getCheckedRadioButtonId()))+"";
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
            if(!modulo6.getC6_p618().equals("-1") && !modulo6.getC6_p618().equals(""))((RadioButton)c6_p618_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p618()))).setChecked(true);
            if(!modulo6.getC6_p619_1().equals("-1") && !modulo6.getC6_p619_1().equals(""))((RadioButton)c6_p619_1_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_1()))).setChecked(true);
            if(!modulo6.getC6_p619_2().equals("-1") && !modulo6.getC6_p619_2().equals(""))((RadioButton)c6_p619_2_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_2()))).setChecked(true);
            if(!modulo6.getC6_p619_3().equals("-1") && !modulo6.getC6_p619_3().equals(""))((RadioButton)c6_p619_3_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_3()))).setChecked(true);
            if(!modulo6.getC6_p619_4().equals("-1") && !modulo6.getC6_p619_4().equals(""))((RadioButton)c6_p619_4_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_4()))).setChecked(true);
            if(!modulo6.getC6_p619_5().equals("-1") && !modulo6.getC6_p619_5().equals(""))((RadioButton)c6_p619_5_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_5()))).setChecked(true);
            if(!modulo6.getC6_p619_6().equals("-1") && !modulo6.getC6_p619_6().equals(""))((RadioButton)c6_p619_6_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_6()))).setChecked(true);
            if(!modulo6.getC6_p619_7().equals("-1") && !modulo6.getC6_p619_7().equals(""))((RadioButton)c6_p619_7_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_7()))).setChecked(true);
            if(!modulo6.getC6_p619_8().equals("-1") && !modulo6.getC6_p619_8().equals(""))((RadioButton)c6_p619_8_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_8()))).setChecked(true);
            if(!modulo6.getC6_p619_9().equals("-1") && !modulo6.getC6_p619_9().equals(""))((RadioButton)c6_p619_9_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p619_9()))).setChecked(true);
            c6_p619_o_EditText.setText(modulo6.getC6_p619_o());
            if(!modulo6.getC6_p620().equals("-1") && !modulo6.getC6_p620().equals(""))((RadioButton)c6_p620_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p620()))).setChecked(true);
            if(!modulo6.getC6_p621().equals("-1") && !modulo6.getC6_p621().equals(""))((RadioButton)c6_p621_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p621()))).setChecked(true);
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

        if(c6_p618.equals("-1")){ mostrarMensaje("PREGUNTA 618: DEBE SELECCIONAR UNA OPCION");return false;}
        if(m6_p619_linearlayout.getVisibility()==View.VISIBLE) {
            if(c6_p619_1.equals("-1")){mostrarMensaje("PREGUNTA 619-1: DEBE SELECCIONAR UNA OPCION");return false;}
            if(c6_p619_2.equals("-1")){ mostrarMensaje("PREGUNTA 619-2: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p619_3.equals("-1")){ mostrarMensaje("PREGUNTA 619-3: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p619_4.equals("-1")){ mostrarMensaje("PREGUNTA 619-4: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p619_5.equals("-1")){ mostrarMensaje("PREGUNTA 619-5: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p619_6.equals("-1")){ mostrarMensaje("PREGUNTA 619-6: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p619_7.equals("-1")){ mostrarMensaje("PREGUNTA 619-7: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p619_8.equals("-1")){ mostrarMensaje("PREGUNTA 619-8: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p619_9.equals("-1")){ mostrarMensaje("PREGUNTA 619-9: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p619_9.equals("1")){
                if(c6_p619_o.trim().equals("")){ mostrarMensaje("PREGUNTA 619 - OPCION 9: DEBE ESPECIFICAR OTRO");return false; }
            }
        }else{
            c6_p619_1 = "";
            c6_p619_2 = "";
            c6_p619_3 = "";
            c6_p619_4 = "";
            c6_p619_5 = "";
            c6_p619_6 = "";
            c6_p619_7 = "";
            c6_p619_8 = "";
            c6_p619_9 = "";
            c6_p619_o = "";
        }

        if (m6_p620_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p620.equals("-1")){ mostrarMensaje("PREGUNTA 620: DEBE SELECCIONAR UNA OPCION");return false; }
        }else c6_p620 = "";

        if (m6_p621_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p621.equals("-1")){ mostrarMensaje("PREGUNTA 621: DEBE SELECCIONAR UNA OPCION");return false; }
        }else c6_p621 = "";

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

    public void limpiar_p618(){
        c6_p618_RadioGroup.clearCheck();
    }

    public void limpiar_p619(){
        c6_p619_1_RadioGroup.clearCheck();
        c6_p619_2_RadioGroup.clearCheck();
        c6_p619_3_RadioGroup.clearCheck();
        c6_p619_4_RadioGroup.clearCheck();
        c6_p619_5_RadioGroup.clearCheck();
        c6_p619_6_RadioGroup.clearCheck();
        c6_p619_7_RadioGroup.clearCheck();
        c6_p619_8_RadioGroup.clearCheck();
        c6_p619_9_RadioGroup.clearCheck();
        c6_p619_o_EditText.setText("");
    }

    public void limpiar_p620(){
        c6_p620_RadioGroup.clearCheck();
    }

    public void limpiar_p621(){
        c6_p621_RadioGroup.clearCheck();
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

    private void configurarEditText(final EditText editText, final View viewLayout, int tipo,int longitud){
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
                    viewLayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
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

    public void ocultarOtrosLayouts() {
        Data data = new Data(context);
        data.open();
        if (c6_p618.equals("1") || c6_p620.equals("2") || c6_p621.equals("2")){
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo6_c6_p622,"");
            contentValues.put(SQLConstantes.modulo6_c6_p622_o,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);

            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p622,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);

        }else{
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p622,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
            data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp622p625,"0",idEncuestado);
        }

        POJOLayout pojoLayout = data.getLayouts(idEncuestado);

        if (c6_p620.equals("2") || c6_p621.equals("2")){
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo6_c6_p623,"");
            contentValues.put(SQLConstantes.modulo6_c6_p623_o,"");
            contentValues.put(SQLConstantes.modulo6_c6_p624,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);

            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p623,"0");
            contentValues.put(SQLConstantes.layouts_p624,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
        }else{
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p623,"1");
            contentValues.put(SQLConstantes.layouts_p624,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
            data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp622p625,"0",idEncuestado);
        }
        POJOLayout pojoLayout1 = data.getLayouts(idEncuestado);
        if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p622,idEncuestado).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p623,idEncuestado).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p624,idEncuestado).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p625,idEncuestado).equals("0")){
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"-1",idEncuestado);
        }else{
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"1",idEncuestado);
        }
        data.close();
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
