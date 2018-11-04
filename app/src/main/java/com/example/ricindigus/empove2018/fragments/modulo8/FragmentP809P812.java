package com.example.ricindigus.empove2018.fragments.modulo8;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo8;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP809P812 extends FragmentPagina {

    Context context;
    String idEncuestado;
    String idInformante;
    Spinner informanteSpinner;
    RadioGroup c8_p809_RadioGroup;
    CheckBox c8_p810_1_Checkbox, c8_p810_2_Checkbox, c8_p810_3_Checkbox , c8_p810_4_Checkbox, c8_p810_5_Checkbox,
            c8_p810_6_Checkbox, c8_p810_7_Checkbox, c8_p810_8_Checkbox, c8_p810_9_Checkbox, c8_p810_10_Checkbox,
            c8_p810_11_Checkbox, c8_p810_12_Checkbox, c8_p810_13_Checkbox;
    EditText c8_p810_o_EditText;
    RadioGroup c8_p811_RadioGroup, c8_p812_RadioGroup;
    LinearLayout m8_p809_linearlayout, m8_p810_linearlayout, m8_p811_linearlayout, m8_p812_linearlayout;

    private String c8_p809;
    private String c8_p810_1;
    private String c8_p810_2;
    private String c8_p810_3;
    private String c8_p810_4;
    private String c8_p810_5;
    private String c8_p810_6;
    private String c8_p810_7;
    private String c8_p810_8;
    private String c8_p810_9;
    private String c8_p810_10;
    private String c8_p810_11;
    private String c8_p810_12;
    private String c8_p810_13;
    private String c8_p810_o;
    private String c8_p811;
    private String c8_p812;

    public FragmentP809P812() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP809P812(String idEncuestado, Context context) {
        this.context = context;
        this.idEncuestado = idEncuestado;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p809_p812, container, false);
        c8_p809_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_809_radiogroup_C8_P809);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);
        c8_p810_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_1);
        c8_p810_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_2);
        c8_p810_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_3);
        c8_p810_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_4);
        c8_p810_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_5);
        c8_p810_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_6);
        c8_p810_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_7);
        c8_p810_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_8);
        c8_p810_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_9);
        c8_p810_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_10);
        c8_p810_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_11);
        c8_p810_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_12);
        c8_p810_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_810_checkbox_C8_P810_13);
        c8_p810_o_EditText = (EditText) rootView.findViewById(R.id.mod8_810_edittext_C8_P810_O);

        c8_p811_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_811_radiogroup_C8_P811);

        c8_p812_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_812_radiogroup_C8_P812);

        m8_p809_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p809);
        m8_p810_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p810);
        m8_p811_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p811);
        m8_p812_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p812);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configurarEditText(c8_p810_o_EditText,m8_p810_linearlayout,1,30);
        controlarChecked(c8_p810_13_Checkbox,c8_p810_o_EditText);

        c8_p809_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 1:
                        m8_p810_linearlayout.setVisibility(View.VISIBLE);
                        m8_p811_linearlayout.setVisibility(View.VISIBLE);
                        m8_p812_linearlayout.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        c8_p810_1_Checkbox.setChecked(false);
                        c8_p810_2_Checkbox.setChecked(false);
                        c8_p810_3_Checkbox.setChecked(false);
                        c8_p810_4_Checkbox.setChecked(false);
                        c8_p810_5_Checkbox.setChecked(false);
                        c8_p810_6_Checkbox.setChecked(false);
                        c8_p810_7_Checkbox.setChecked(false);
                        c8_p810_8_Checkbox.setChecked(false);
                        c8_p810_9_Checkbox.setChecked(false);
                        c8_p810_10_Checkbox.setChecked(false);
                        c8_p810_11_Checkbox.setChecked(false);
                        c8_p810_12_Checkbox.setChecked(false);
                        c8_p810_13_Checkbox.setChecked(false);
                        c8_p810_o_EditText.setText("");
                        c8_p811_RadioGroup.clearCheck();
                        c8_p812_RadioGroup.clearCheck();
                        m8_p810_linearlayout.setVisibility(View.GONE);
                        m8_p811_linearlayout.setVisibility(View.GONE);
                        m8_p812_linearlayout.setVisibility(View.GONE);
                        break;

                }
            }
        });

        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo8_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo8_c8_p809,c8_p809);
        contentValues.put(SQLConstantes.modulo8_c8_p810_1,c8_p810_1);
        contentValues.put(SQLConstantes.modulo8_c8_p810_2,c8_p810_2);
        contentValues.put(SQLConstantes.modulo8_c8_p810_3,c8_p810_3);
        contentValues.put(SQLConstantes.modulo8_c8_p810_4,c8_p810_4);
        contentValues.put(SQLConstantes.modulo8_c8_p810_5,c8_p810_5);
        contentValues.put(SQLConstantes.modulo8_c8_p810_6,c8_p810_6);
        contentValues.put(SQLConstantes.modulo8_c8_p810_7,c8_p810_7);
        contentValues.put(SQLConstantes.modulo8_c8_p810_8,c8_p810_8);
        contentValues.put(SQLConstantes.modulo8_c8_p810_9,c8_p810_9);
        contentValues.put(SQLConstantes.modulo8_c8_p810_10,c8_p810_10 );
        contentValues.put(SQLConstantes.modulo8_c8_p810_11,c8_p810_11 );
        contentValues.put(SQLConstantes.modulo8_c8_p810_12,c8_p810_12 );
        contentValues.put(SQLConstantes.modulo8_c8_p810_13,c8_p810_13 );
        contentValues.put(SQLConstantes.modulo8_c8_p810_o,c8_p810_o);
        contentValues.put(SQLConstantes.modulo8_c8_p811,c8_p811);
        contentValues.put(SQLConstantes.modulo8_c8_p812,c8_p812);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
        ocultarOtrosLayouts();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition() + "";
        c8_p809 = c8_p809_RadioGroup.indexOfChild(c8_p809_RadioGroup.findViewById(c8_p809_RadioGroup.getCheckedRadioButtonId()))+"";
        if(c8_p810_1_Checkbox.isChecked()) c8_p810_1 = "1"; else c8_p810_1 = "0";
        if(c8_p810_2_Checkbox.isChecked()) c8_p810_2 = "1"; else c8_p810_2 = "0";
        if(c8_p810_3_Checkbox.isChecked()) c8_p810_3 = "1"; else c8_p810_3 = "0";
        if(c8_p810_4_Checkbox.isChecked()) c8_p810_4 = "1"; else c8_p810_4 = "0";
        if(c8_p810_5_Checkbox.isChecked()) c8_p810_5 = "1"; else c8_p810_5 = "0";
        if(c8_p810_6_Checkbox.isChecked()) c8_p810_6 = "1"; else c8_p810_6 = "0";
        if(c8_p810_7_Checkbox.isChecked()) c8_p810_7 = "1"; else c8_p810_7 = "0";
        if(c8_p810_8_Checkbox.isChecked()) c8_p810_8 = "1"; else c8_p810_8 = "0";
        if(c8_p810_9_Checkbox.isChecked()) c8_p810_9 = "1"; else c8_p810_9 = "0";
        if(c8_p810_10_Checkbox.isChecked()) c8_p810_10 = "1"; else c8_p810_10 = "0";
        if(c8_p810_11_Checkbox.isChecked()) c8_p810_11 = "1"; else c8_p810_11 = "0";
        if(c8_p810_12_Checkbox.isChecked()) c8_p810_12 = "1"; else c8_p810_12 = "0";
        if(c8_p810_13_Checkbox.isChecked()) c8_p810_13 = "1"; else c8_p810_13 = "0";
        c8_p810_o = c8_p810_o_EditText.getText().toString();
        c8_p811 = c8_p811_RadioGroup.indexOfChild(c8_p811_RadioGroup.findViewById(c8_p811_RadioGroup.getCheckedRadioButtonId())) + "";
        c8_p812 = c8_p812_RadioGroup.indexOfChild(c8_p812_RadioGroup.findViewById(c8_p812_RadioGroup.getCheckedRadioButtonId())) + "";
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(), idEncuestado)){
            Modulo8 modulo8 = data.getModulo8(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo8.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            informanteSpinner.setSelection(Integer.parseInt(modulo8.getIdInformante()));
            if(!modulo8.getC8_p809().equals("-1")&&!modulo8.getC8_p809().equals(""))((RadioButton)c8_p809_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p809()))).setChecked(true);
            if(modulo8.getC8_p810_1().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_2().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_3().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_4().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_5().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_6().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_7().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_8().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_9().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_10().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_11().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_12().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p810_13().equals("1")) c8_p810_1_Checkbox.setChecked(true);
            c8_p810_o_EditText.setText(modulo8.getC8_p810_o());
            if(!modulo8.getC8_p811().equals("-1")&&!modulo8.getC8_p811().equals(""))((RadioButton)c8_p811_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p811()))).setChecked(true);
            if(!modulo8.getC8_p812().equals("-1")&&!modulo8.getC8_p812().equals(""))((RadioButton)c8_p812_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p812()))).setChecked(true);
        }
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(c8_p809.equals("-1")){ mostrarMensaje("PREGUNTA 809: DEBE SELECCIONAR UNA OPCION");return false; }

        if (m8_p810_linearlayout.getVisibility() == View.VISIBLE){
            if(c8_p810_1.equals("0")&& c8_p810_2.equals("0")&& c8_p810_3.equals("0")&& c8_p810_4.equals("0")&& c8_p810_5.equals("0")&& c8_p810_6.equals("0")
                    && c8_p810_7.equals("0")&& c8_p810_8.equals("0")&& c8_p810_9.equals("0")&& c8_p810_10.equals("0")&& c8_p810_11.equals("0")&& c8_p810_12.equals("0")&& c8_p810_13.equals("0")){
                mostrarMensaje("PREGUNTA 810: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if (c8_p810_13.equals("1")){
                if(c8_p810_o.trim().equals("")){
                    mostrarMensaje("PREGUNTA 810 - OPCION 13: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }else{
            c8_p810_1 = "";
            c8_p810_2 = "";
            c8_p810_3 = "";
            c8_p810_4 = "";
            c8_p810_5 = "";
            c8_p810_6 = "";
            c8_p810_7 = "";
            c8_p810_8 = "";
            c8_p810_9 = "";
            c8_p810_10 = "";
            c8_p810_11 = "";
            c8_p810_12 = "";
            c8_p810_13 = "";
            c8_p810_o = "";
        }

        if (m8_p811_linearlayout.getVisibility() == View.VISIBLE){
            if(c8_p811.equals("-1")){ mostrarMensaje("PREGUNTA 811: DEBE SELECCIONAR UNA OPCION");return false; }
        }else{c8_p811 = "";}

        if (m8_p812_linearlayout.getVisibility() == View.VISIBLE){
            if(c8_p812.equals("-1")){ mostrarMensaje("PREGUNTA 812: DEBE SELECCIONAR UNA OPCION");return false; }
        }else{c8_p812 = "";}
        return true;
    }

    public void ocultarOtrosLayouts(){
        if (c8_p809_RadioGroup.indexOfChild(c8_p809_RadioGroup.findViewById(c8_p809_RadioGroup.getCheckedRadioButtonId())) == 2){
            Data data = new Data(context);
            data.open();
            ContentValues contentValues = new ContentValues();
            //limpia valores de las preguntas a ocultar en otros fragments
            contentValues.put(SQLConstantes.modulo8_c8_p813_1,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_2,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_3,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_4,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_5,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_6,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_7,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_8,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_9,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_10,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_11,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_12,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_13,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_14,"");
            contentValues.put(SQLConstantes.modulo8_c8_p813_o,"");
            contentValues.put(SQLConstantes.modulo8_c8_p814_1,"");
            contentValues.put(SQLConstantes.modulo8_c8_p814_2,"");
            contentValues.put(SQLConstantes.modulo8_c8_p814_3,"");
            contentValues.put(SQLConstantes.modulo8_c8_p814_4,"");
            contentValues.put(SQLConstantes.modulo8_c8_p814_5,"");
            contentValues.put(SQLConstantes.modulo8_c8_p814_6,"");
            contentValues.put(SQLConstantes.modulo8_c8_p814_7,"");
            contentValues.put(SQLConstantes.modulo8_c8_p814_8,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
            //oculta layouts en otros fragments
            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p813,"0");
            contentValues.put(SQLConstantes.layouts_p814,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);
            data.close();
        }else{
            Data data = new Data(context);
            data.open();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p813,"1");
            contentValues.put(SQLConstantes.layouts_p814,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);
            data.close();
            if (c8_p812_RadioGroup.indexOfChild(c8_p812_RadioGroup.findViewById(c8_p812_RadioGroup.getCheckedRadioButtonId())) == 2){
                data.open();
                contentValues = new ContentValues();
                //limpia valores de las preguntas a ocultar en otros fragments
                contentValues.put(SQLConstantes.modulo8_c8_p813_1,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_2,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_3,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_4,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_5,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_6,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_7,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_8,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_9,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_10,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_11,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_12,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_13,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_14,"");
                contentValues.put(SQLConstantes.modulo8_c8_p813_o,"");
                data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
                //oculta layouts en otros fragments
                contentValues = new ContentValues();
                contentValues.put(SQLConstantes.layouts_p813,"0");
                data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);
                data.close();
            } else{
                data.open();
                contentValues = new ContentValues();
                contentValues.put(SQLConstantes.layouts_p813,"1");
                data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);
                data.close();
            }
        }
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

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo8;
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void mostrarTeclado(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
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
}
