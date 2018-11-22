package com.example.ricindigus.empove2018.fragments.modulo5;


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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP508P511 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    Context context;

    Spinner informanteSpinner;
    CheckBox c5_p508_1_Checkbox, c5_p508_2_Checkbox, c5_p508_3_Checkbox , c5_p508_4_Checkbox, c5_p508_5_Checkbox,
            c5_p508_6_Checkbox, c5_p508_7_Checkbox, c5_p508_8_Checkbox, c5_p508_9_Checkbox, c5_p508_10_Checkbox, c5_p508_11_Checkbox;
    EditText c5_p508_o_EditText, c5_p511_o_EditText;
    RadioGroup c5_p509_RadioGroup, c5_p510_RadioGroup, c5_p511_RadioGroup;
    LinearLayout m5_p508_linearlayout, m5_p509_linearlayout, m5_p510_linearlayout, m5_p511_linearlayout;

    private String c5_p508_1;
    private String c5_p508_2;
    private String c5_p508_3;
    private String c5_p508_4;
    private String c5_p508_5;
    private String c5_p508_6;
    private String c5_p508_7;
    private String c5_p508_8;
    private String c5_p508_9;
    private String c5_p508_10;
    private String c5_p508_11;
    private String c5_p508_o;
    private String c5_p509;
    private String c5_p510;
    private String c5_p511;
    private String c5_p511_o;


    @SuppressLint("ValidFragment")
    public FragmentP508P511(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentP508P511() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p508_p511, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c5_p508_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_1);
        c5_p508_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_2);
        c5_p508_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_3);
        c5_p508_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_4);
        c5_p508_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_5);
        c5_p508_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_6);
        c5_p508_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_7);
        c5_p508_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_8);
        c5_p508_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_9);
        c5_p508_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_10);
        c5_p508_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod5_508_checkbox_C5_P508_11);
        c5_p508_o_EditText = (EditText) rootView.findViewById(R.id.mod5_508_edittext_C5_P508_O);
        c5_p509_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_509_radiogroup_C5_P509);
        c5_p510_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_510_radiogroup_C5_P510);
        c5_p511_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_511_radiogroup_C5_P511);
        c5_p511_o_EditText = (EditText) rootView.findViewById(R.id.mod5_511_edittext_C5_P511_O);

        m5_p508_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p508);
        m5_p509_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p509);
        m5_p510_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p510);
        m5_p511_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p511);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configurarEditText(c5_p508_o_EditText,m5_p508_linearlayout,0,30);
        configurarEditText(c5_p511_o_EditText,m5_p511_linearlayout,0,30);
        controlarChecked(c5_p508_11_Checkbox,c5_p508_o_EditText);
        c5_p511_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group,checkedId,4,c5_p511_o_EditText);
            }
        });

        c5_p509_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
                switch (pos){
                    case 1:
                        m5_p510_linearlayout.setVisibility(View.VISIBLE);
                        m5_p511_linearlayout.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        c5_p510_RadioGroup.clearCheck();
                        c5_p511_RadioGroup.clearCheck();
                        m5_p510_linearlayout.setVisibility(View.GONE);
                        m5_p511_linearlayout.setVisibility(View.GONE);
                        break;
                }
            }
        });

        c5_p510_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c5_p510_RadioGroup.findViewById(c5_p510_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    m5_p511_linearlayout.setVisibility(View.GONE); limpiar_p511();
                }else{
                    m5_p511_linearlayout.setVisibility(View.VISIBLE);
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
        contentValues.put(SQLConstantes.modulo5_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo5_c5_p508_1,c5_p508_1);
        contentValues.put(SQLConstantes.modulo5_c5_p508_2,c5_p508_2);
        contentValues.put(SQLConstantes.modulo5_c5_p508_3,c5_p508_3);
        contentValues.put(SQLConstantes.modulo5_c5_p508_4,c5_p508_4);
        contentValues.put(SQLConstantes.modulo5_c5_p508_5,c5_p508_5);
        contentValues.put(SQLConstantes.modulo5_c5_p508_6,c5_p508_6);
        contentValues.put(SQLConstantes.modulo5_c5_p508_7,c5_p508_7);
        contentValues.put(SQLConstantes.modulo5_c5_p508_8,c5_p508_8);
        contentValues.put(SQLConstantes.modulo5_c5_p508_9,c5_p508_9);
        contentValues.put(SQLConstantes.modulo5_c5_p508_10,c5_p508_10);
        contentValues.put(SQLConstantes.modulo5_c5_p508_11,c5_p508_11);
        contentValues.put(SQLConstantes.modulo5_c5_p508_o,c5_p508_o);
        contentValues.put(SQLConstantes.modulo5_c5_p509,c5_p509);
        contentValues.put(SQLConstantes.modulo5_c5_p510,c5_p510);
        contentValues.put(SQLConstantes.modulo5_c5_p511,c5_p511);
        contentValues.put(SQLConstantes.modulo5_c5_p511_o,c5_p511_o);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        //Ya valido y guardo correctamente el fragment, ahora actualizamos el valor de la cobertura del fragment a correcto(1)
        data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp508p511,"1",idEncuestado);
        //verificamos la cobertura del capitulo y actualizamos su valor de cobertura.
        if (verificarCoberturaCapitulo()) data.actualizarValor(getNombreTabla(),SQLConstantes.modulo5_COB500,"1",idEncuestado);
        else data.actualizarValor(getNombreTabla(),SQLConstantes.modulo5_COB500,"0",idEncuestado);
        data.actualizarValor(SQLConstantes.tablaresidentes,SQLConstantes.residentes_encuestado_cobertura,"0",idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        if(c5_p508_1_Checkbox.isChecked()) c5_p508_1 = "1"; else c5_p508_1 = "0";
        if(c5_p508_2_Checkbox.isChecked()) c5_p508_2 = "1"; else c5_p508_2 = "0";
        if(c5_p508_3_Checkbox.isChecked()) c5_p508_3 = "1"; else c5_p508_3 = "0";
        if(c5_p508_4_Checkbox.isChecked()) c5_p508_4 = "1"; else c5_p508_4 = "0";
        if(c5_p508_5_Checkbox.isChecked()) c5_p508_5 = "1"; else c5_p508_5 = "0";
        if(c5_p508_6_Checkbox.isChecked()) c5_p508_6 = "1"; else c5_p508_6 = "0";
        if(c5_p508_7_Checkbox.isChecked()) c5_p508_7 = "1"; else c5_p508_7 = "0";
        if(c5_p508_8_Checkbox.isChecked()) c5_p508_8 = "1"; else c5_p508_8 = "0";
        if(c5_p508_9_Checkbox.isChecked()) c5_p508_9 = "1"; else c5_p508_9 = "0";
        if(c5_p508_10_Checkbox.isChecked()) c5_p508_10 = "1"; else c5_p508_10 = "0";
        if(c5_p508_11_Checkbox.isChecked()) c5_p508_11 = "1"; else c5_p508_11 = "0";
        c5_p508_o = c5_p508_o_EditText.getText().toString();
        c5_p509 = c5_p509_RadioGroup.indexOfChild(c5_p509_RadioGroup.findViewById(c5_p509_RadioGroup.getCheckedRadioButtonId()))+"";
        c5_p510 = c5_p510_RadioGroup.indexOfChild(c5_p510_RadioGroup.findViewById(c5_p510_RadioGroup.getCheckedRadioButtonId()))+"";
        c5_p511 = c5_p511_RadioGroup.indexOfChild(c5_p511_RadioGroup.findViewById(c5_p511_RadioGroup.getCheckedRadioButtonId()))+"";
        c5_p511_o = c5_p511_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo5 modulo5 = data.getModulo5(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo5.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            informanteSpinner.setSelection(Integer.parseInt(modulo5.getIdInformante()));
            if(modulo5.getC5_p508_1().equals("1")) c5_p508_1_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_2().equals("1")) c5_p508_2_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_3().equals("1")) c5_p508_3_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_4().equals("1")) c5_p508_4_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_5().equals("1")) c5_p508_5_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_6().equals("1")) c5_p508_6_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_7().equals("1")) c5_p508_7_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_8().equals("1")) c5_p508_8_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_9().equals("1")) c5_p508_9_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_10().equals("1")) c5_p508_10_Checkbox.setChecked(true);
            if(modulo5.getC5_p508_11().equals("1")) c5_p508_11_Checkbox.setChecked(true);
            c5_p508_o_EditText.setText(modulo5.getC5_p508_o());
            if(!modulo5.getC5_p509().equals("-1") && !modulo5.getC5_p509().equals(""))((RadioButton)c5_p509_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p509()))).setChecked(true);
            if(!modulo5.getC5_p510().equals("-1") && !modulo5.getC5_p510().equals(""))((RadioButton)c5_p510_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p510()))).setChecked(true);
            if(!modulo5.getC5_p511().equals("-1") && !modulo5.getC5_p511().equals(""))((RadioButton)c5_p511_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p511()))).setChecked(true);
            c5_p511_o_EditText.setText(modulo5.getC5_p511_o());
        }

        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p508,idEncuestado)) m5_p508_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p509,idEncuestado)) m5_p509_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p510,idEncuestado)) m5_p510_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p511,idEncuestado)) m5_p511_linearlayout.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if(m5_p508_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p508_1.equals("0") && c5_p508_2.equals("0") && c5_p508_3.equals("0") && c5_p508_4.equals("0") && c5_p508_5.equals("0") &&
                    c5_p508_6.equals("0") && c5_p508_7.equals("0") && c5_p508_8.equals("0") && c5_p508_9.equals("0") && c5_p508_10.equals("0") &&
                    c5_p508_11.equals("0")){
                mostrarMensaje("PREGUNTA 508: DEBE SELECCIONAR ALGUNA OPCION");return false;
            }else{
                if(c5_p508_11.equals("11")){
                    if(c5_p508_o.trim().equals("")){ mostrarMensaje("PREGUNTA 508 - OPCION 11: DEBE ESPECIFICAR OTRO");return false; }
                }
            }

        }else{
            c5_p508_1 = "";
            c5_p508_2 = "";
            c5_p508_3 = "";
            c5_p508_4 = "";
            c5_p508_5 = "";
            c5_p508_6 = "";
            c5_p508_7 = "";
            c5_p508_8 = "";
            c5_p508_9 = "";
            c5_p508_10 = "";
            c5_p508_11 = "";
            c5_p508_o = "";
        }
        if (m5_p509_linearlayout.getVisibility()==View.VISIBLE){
            if(c5_p509.equals("-1")){ mostrarMensaje("PREGUNTA 509: DEBE SELECCIONAR UNA OPCION");return false; }
        }else c5_p509 = "";

        if (m5_p510_linearlayout.getVisibility()==View.VISIBLE){
            if(c5_p510.equals("-1")){ mostrarMensaje("PREGUNTA 510: DEBE SELECCIONAR UNA OPCION");return false; }
        }else c5_p510 = "";

        if (m5_p511_linearlayout.getVisibility()==View.VISIBLE){
            if(c5_p511.equals("-1")){ mostrarMensaje("PREGUNTA 511: DEBE SELECCIONAR UNA OPCION");return false; }

            if(c5_p511.equals("4")){
                if (c5_p511_o.equals("")){ mostrarMensaje("PREGUNTA 511: DEBE ESPECIFICAR");return false;}
            }

        }else {
            c5_p511 = "";
            c5_p511_o = "";
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo5;
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



    public void limpiar_p511(){
        c5_p511_RadioGroup.clearCheck();
        c5_p511_o_EditText.setText("");
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



    public void controlarChecked(CheckBox checkBox,final EditText editText){
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
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p501p505,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp501p505,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p506p507,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp506p507,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp508p511,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p512p513,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp512p513,idEncuestado).equals("0")) return false;
        data.close();
        return true;
    }
}
