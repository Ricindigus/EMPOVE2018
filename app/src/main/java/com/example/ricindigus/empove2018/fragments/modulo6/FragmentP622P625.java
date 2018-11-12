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
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP622P625 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    Context context;

    Spinner informanteSpinner;
    RadioGroup c6_p622_RadioGroup;
    EditText c6_p622_o_EditText;
    RadioGroup c6_p623_RadioGroup;
    EditText c6_p623_o_EditText;
    EditText c6_p624_EditText;
    CheckBox c6_p625_1_Checkbox, c6_p625_2_Checkbox, c6_p625_3_Checkbox , c6_p625_4_Checkbox, c6_p625_5_Checkbox,
            c6_p625_6_Checkbox;
    EditText c6_p625_o_EditText;
    LinearLayout m6_p622_linearlayout, m6_p623_linearlayout, m6_p624_linearlayout, m6_p625_linearlayout;

    private String c6_p622;
    private String c6_p622_o;
    private String c6_p623;
    private String c6_p623_o;
    private String c6_p624;
    private String c6_p625_1;
    private String c6_p625_2;
    private String c6_p625_3;
    private String c6_p625_4;
    private String c6_p625_5;
    private String c6_p625_6;
    private String c6_p625_o;

    @SuppressLint("ValidFragment")
    public FragmentP622P625(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentP622P625() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p622_p625, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c6_p622_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_623_radiogroup_C6_P623);
        c6_p622_o_EditText = (EditText) rootView.findViewById(R.id.mod6_623_edittext_C6_P623_O);
        c6_p623_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_624_radiogroup_C6_P624);
        c6_p623_o_EditText = (EditText) rootView.findViewById(R.id.mod6_624_edittext_C6_P624_O);
        c6_p624_EditText = (EditText) rootView.findViewById(R.id.mod6_625_edittext_C6_P625);

        c6_p625_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_1);
        c6_p625_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_2);
        c6_p625_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_3);
        c6_p625_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_4);
        c6_p625_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_5);
        c6_p625_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_6);
        c6_p625_o_EditText = (EditText) rootView.findViewById(R.id.mod6_618_edittext_C6_P618_O);

        m6_p622_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p623);
        m6_p623_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p624);
        m6_p624_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p625);
        m6_p625_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p618);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configurarEditText(c6_p622_o_EditText,m6_p622_linearlayout,0,30);
        configurarEditText(c6_p623_o_EditText,m6_p623_linearlayout,0,30);
        configurarEditText(c6_p624_EditText,m6_p624_linearlayout,2,30);
        configurarEditText(c6_p625_o_EditText,m6_p625_linearlayout,0,30);


        c6_p622_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p622_RadioGroup.findViewById(c6_p622_RadioGroup.getCheckedRadioButtonId()));
                if(pos>=1 && pos<=10){
                    limpiar_p623(); limpiar_p624();
                    m6_p623_linearlayout.setVisibility(View.GONE);
                    m6_p624_linearlayout.setVisibility(View.GONE);
                    if(pos==10){
                        c6_p622_o_EditText.setEnabled(true);
                        c6_p622_o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                    }else{
                        c6_p622_o_EditText.setText("");
                        c6_p622_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                        c6_p622_o_EditText.setEnabled(false);
                    }
                }else{
                    c6_p622_o_EditText.setText("");
                    c6_p622_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                    c6_p622_o_EditText.setEnabled(false);
                    m6_p623_linearlayout.setVisibility(View.VISIBLE);
                    m6_p624_linearlayout.setVisibility(View.VISIBLE);
                }
            }
        });


        c6_p623_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p623_RadioGroup.findViewById(c6_p623_RadioGroup.getCheckedRadioButtonId()));
                if(pos==7){
                    limpiar_p624(); m6_p624_linearlayout.setVisibility(View.GONE);
                }else{
                    m6_p624_linearlayout.setVisibility(View.VISIBLE);
                    if(pos==6){
                        c6_p623_o_EditText.setEnabled(true);
                        c6_p623_o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                    }else{
                        c6_p623_o_EditText.setText("");
                        c6_p623_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                        c6_p623_o_EditText.setEnabled(false);
                    }
                }
            }
        });

        controlarChecked(c6_p625_6_Checkbox,c6_p625_o_EditText);
        llenarVista();
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo6_c6_p622,c6_p622);
        contentValues.put(SQLConstantes.modulo6_c6_p622_o,c6_p622_o);
        contentValues.put(SQLConstantes.modulo6_c6_p623,c6_p623);
        contentValues.put(SQLConstantes.modulo6_c6_p623_o,c6_p623_o);
        contentValues.put(SQLConstantes.modulo6_c6_p624,c6_p624);
        contentValues.put(SQLConstantes.modulo6_c6_p625_1,c6_p625_1);
        contentValues.put(SQLConstantes.modulo6_c6_p625_2,c6_p625_2);
        contentValues.put(SQLConstantes.modulo6_c6_p625_3,c6_p625_3);
        contentValues.put(SQLConstantes.modulo6_c6_p625_4,c6_p625_4);
        contentValues.put(SQLConstantes.modulo6_c6_p625_5,c6_p625_5);
        contentValues.put(SQLConstantes.modulo6_c6_p625_6,c6_p625_6);
        contentValues.put(SQLConstantes.modulo6_c6_p625_o,c6_p625_o);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c6_p622 = c6_p622_RadioGroup.indexOfChild(c6_p622_RadioGroup.findViewById(c6_p622_RadioGroup.getCheckedRadioButtonId())) +"";
        c6_p622_o = c6_p622_o_EditText.getText().toString();
        c6_p623 = c6_p623_RadioGroup.indexOfChild(c6_p623_RadioGroup.findViewById(c6_p623_RadioGroup.getCheckedRadioButtonId())) +"";
        c6_p623_o = c6_p623_o_EditText.getText().toString();
        c6_p624 = c6_p624_EditText.getText().toString();
        if(c6_p625_1_Checkbox.isChecked()) c6_p625_1 = "1"; else c6_p625_1 = "0";
        if(c6_p625_2_Checkbox.isChecked()) c6_p625_2 = "1"; else c6_p625_2 = "0";
        if(c6_p625_3_Checkbox.isChecked()) c6_p625_3 = "1"; else c6_p625_3 = "0";
        if(c6_p625_4_Checkbox.isChecked()) c6_p625_4 = "1"; else c6_p625_4 = "0";
        if(c6_p625_5_Checkbox.isChecked()) c6_p625_5 = "1"; else c6_p625_5 = "0";
        if(c6_p625_6_Checkbox.isChecked()) c6_p625_6 = "1"; else c6_p625_6 = "0";
        c6_p625_o = c6_p625_o_EditText.getText().toString();
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
            if(!modulo6.getC6_p622().equals("-1") && !modulo6.getC6_p622().equals(""))((RadioButton)c6_p622_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p622()))).setChecked(true);
            c6_p622_o_EditText.setText(modulo6.getC6_p622_o());
            if(!modulo6.getC6_p623().equals("-1") && !modulo6.getC6_p623().equals(""))((RadioButton)c6_p623_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p623()))).setChecked(true);
            c6_p623_o_EditText.setText(modulo6.getC6_p623_o());
            c6_p624_EditText.setText(modulo6.getC6_p624());
            if(modulo6.getC6_p625_1().equals("1")) c6_p625_1_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_2().equals("1")) c6_p625_2_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_3().equals("1")) c6_p625_3_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_4().equals("1")) c6_p625_4_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_5().equals("1")) c6_p625_5_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_6().equals("1")) c6_p625_6_Checkbox.setChecked(true);
            c6_p625_o_EditText.setText(modulo6.getC6_p625_o());
        }
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p622,idEncuestado)) m6_p622_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p623,idEncuestado)) m6_p623_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p624,idEncuestado)) m6_p624_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p625,idEncuestado)) m6_p625_linearlayout.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if(m6_p622_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p622.equals("-1")){ mostrarMensaje("PREGUNTA 622: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p622.equals("10")){
                if(c6_p622_o.trim().equals("")){ mostrarMensaje("PREGUNTA 622 - OPCION 9: DEBE ESPECIFICAR OTRO");return false; }
            }
        }else{
            c6_p622 = "";
            c6_p622_o = "";
        }
        if(m6_p623_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p623.equals("-1")){ mostrarMensaje("PREGUNTA 623: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p623.equals("6")){
                if(c6_p623_o.trim().equals("")){ mostrarMensaje("PREGUNTA 623 - OPCION 6: DEBE ESPECIFICAR OTRO");return false; }
            }
        }else{
            c6_p623 = "";
            c6_p623_o = "";
        }

        if (m6_p624_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p624.trim().equals("")){
                mostrarMensaje("PREGUNTA 624: DEBE INGRESAR NRO DE SEMANAS");
                return false;
            }
        }else{
            c6_p624 = "";
        }

        if (m6_p625_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p625_1.equals("0") && c6_p625_2.equals("0") && c6_p625_3.equals("0") && c6_p625_4.equals("0") && c6_p625_5.equals("0") && c6_p625_6.equals("0")){
                mostrarMensaje("PREGUNTA 625: DEBE SELECCIONAR ALGUNA OPCION");return false;
            }
            if(c6_p625_6.equals("1")){
                if(c6_p625_o.trim().equals("")){ mostrarMensaje("PREGUNTA 625 - OPCION 6: DEBE ESPECIFICAR OTRO");return false; }
            }
        }else{
            c6_p625_1 = "";
            c6_p625_2 = "";
            c6_p625_3 = "";
            c6_p625_4 = "";
            c6_p625_5 = "";
            c6_p625_6 = "";
            c6_p625_o = "";
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

    public void limpiar_p622(){
        c6_p622_RadioGroup.clearCheck();
        c6_p622_o_EditText.setText("");
    }

    public void limpiar_p623(){
        c6_p623_RadioGroup.clearCheck();
        c6_p623_o_EditText.setText("");
    }

    public void limpiar_p624(){
        c6_p624_EditText.setText("");
    }

    public void limpiar_p625(){
        c6_p625_1_Checkbox.setChecked(false);
        c6_p625_2_Checkbox.setChecked(false);
        c6_p625_3_Checkbox.setChecked(false);
        c6_p625_4_Checkbox.setChecked(false);
        c6_p625_5_Checkbox.setChecked(false);
        c6_p625_6_Checkbox.setChecked(false);
        c6_p625_o_EditText.setText("");
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
}
