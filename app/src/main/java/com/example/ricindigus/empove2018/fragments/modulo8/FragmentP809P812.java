package com.example.ricindigus.empove2018.fragments.modulo8;


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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP809P812 extends FragmentPagina {

    Context context;
    String idVivienda, idHogar, idInformante, idPersona;

    RadioGroup c8_p809_RadioGroup;
    CheckBox c8_p810_1_Checkbox, c8_p810_2_Checkbox, c8_p810_3_Checkbox , c8_p810_4_Checkbox, c8_p810_5_Checkbox,
            c8_p810_6_Checkbox, c8_p810_7_Checkbox, c8_p810_8_Checkbox, c8_p810_9_Checkbox, c8_p810_10_Checkbox,
            c8_p810_11_Checkbox, c8_p810_12_Checkbox, c8_p810_13_Checkbox;
    EditText c8_p810_o_EditText;
    RadioGroup c8_p811_RadioGroup, c8_p812_RadioGroup;
    LinearLayout m8_p809_linearlayout, m8_p810_linearlayout, m8_p811_linearlayout, m8_p812_linearlayout;

    private int c8_p809;
    private int c8_p810_1;
    private int c8_p810_2;
    private int c8_p810_3;
    private int c8_p810_4;
    private int c8_p810_5;
    private int c8_p810_6;
    private int c8_p810_7;
    private int c8_p810_8;
    private int c8_p810_9;
    private int c8_p810_10;
    private int c8_p810_11;
    private int c8_p810_12;
    private int c8_p810_13;
    private String c8_p810_o;
    private int c8_p811;
    private int c8_p812;

    public FragmentP809P812() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p809_p812, container, false);

        c8_p809_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_809_radiogroup_C8_P809);

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
        c8_p810_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c8_p810_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c8_p810_o_EditText);
                    m8_p810_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c8_p809 = c8_p809_RadioGroup.indexOfChild(c8_p809_RadioGroup.findViewById(c8_p809_RadioGroup.getCheckedRadioButtonId()));
        if(c8_p810_1_Checkbox.isChecked()) c8_p810_1 = 1; else c8_p810_1 = 0;
        if(c8_p810_2_Checkbox.isChecked()) c8_p810_2 = 1; else c8_p810_2 = 0;
        if(c8_p810_3_Checkbox.isChecked()) c8_p810_3 = 1; else c8_p810_3 = 0;
        if(c8_p810_4_Checkbox.isChecked()) c8_p810_4 = 1; else c8_p810_4 = 0;
        if(c8_p810_5_Checkbox.isChecked()) c8_p810_5 = 1; else c8_p810_5 = 0;
        if(c8_p810_6_Checkbox.isChecked()) c8_p810_6 = 1; else c8_p810_6 = 0;
        if(c8_p810_7_Checkbox.isChecked()) c8_p810_7 = 1; else c8_p810_7 = 0;
        if(c8_p810_8_Checkbox.isChecked()) c8_p810_8 = 1; else c8_p810_8 = 0;
        if(c8_p810_9_Checkbox.isChecked()) c8_p810_9 = 1; else c8_p810_9 = 0;
        if(c8_p810_10_Checkbox.isChecked()) c8_p810_10 = 1; else c8_p810_10 = 0;
        if(c8_p810_11_Checkbox.isChecked()) c8_p810_11 = 1; else c8_p810_11 = 0;
        if(c8_p810_12_Checkbox.isChecked()) c8_p810_12 = 1; else c8_p810_12 = 0;
        if(c8_p810_13_Checkbox.isChecked()) c8_p810_13 = 1; else c8_p810_13 = 0;
        c8_p810_o = c8_p810_o_EditText.getText().toString();
        c8_p811 = c8_p811_RadioGroup.indexOfChild(c8_p811_RadioGroup.findViewById(c8_p811_RadioGroup.getCheckedRadioButtonId()));
        c8_p812 = c8_p812_RadioGroup.indexOfChild(c8_p812_RadioGroup.findViewById(c8_p812_RadioGroup.getCheckedRadioButtonId()));

    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo8_c8_p809,""+c8_p809);

        contentValues.put(SQLConstantes.modulo8_c8_p810_1,""+c8_p810_1);
        contentValues.put(SQLConstantes.modulo8_c8_p810_2,""+c8_p810_2);
        contentValues.put(SQLConstantes.modulo8_c8_p810_3,""+c8_p810_3);
        contentValues.put(SQLConstantes.modulo8_c8_p810_4,""+c8_p810_4);
        contentValues.put(SQLConstantes.modulo8_c8_p810_5,""+c8_p810_5);
        contentValues.put(SQLConstantes.modulo8_c8_p810_6,""+c8_p810_6);
        contentValues.put(SQLConstantes.modulo8_c8_p810_7,""+c8_p810_7);
        contentValues.put(SQLConstantes.modulo8_c8_p810_8,""+c8_p810_8);
        contentValues.put(SQLConstantes.modulo8_c8_p810_9,""+c8_p810_9);
        contentValues.put(SQLConstantes.modulo8_c8_p810_10,""+c8_p810_10);
        contentValues.put(SQLConstantes.modulo8_c8_p810_11,""+c8_p810_11);
        contentValues.put(SQLConstantes.modulo8_c8_p810_12,""+c8_p810_12);
        contentValues.put(SQLConstantes.modulo8_c8_p810_13,""+c8_p810_13);
        contentValues.put(SQLConstantes.modulo8_c8_p810_o,""+c8_p810_o);

        contentValues.put(SQLConstantes.modulo8_c8_p811,""+c8_p811);
        contentValues.put(SQLConstantes.modulo8_c8_p812,""+c8_p812);

        if(data.existeElemento(getNombreTabla(),idPersona)){
            data.actualizarElemento(getNombreTabla(),contentValues,idPersona);
        }else{
            contentValues.put(SQLConstantes.modulo8_idVivienda,""+idVivienda);
            contentValues.put(SQLConstantes.modulo8_idHogar,""+idHogar);
            contentValues.put(SQLConstantes.modulo8_idInformante,""+idInformante);
            contentValues.put(SQLConstantes.modulo8_id,""+idPersona);
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        if(c8_p809<1){
            mostrarMensaje("PREGUNTA 809: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p810_1==0 && c8_p810_2==0 && c8_p810_3==0 && c8_p810_4==0 && c8_p810_5==0 && c8_p810_6==0
                && c8_p810_7==0 && c8_p810_8==0 && c8_p810_9==0 && c8_p810_10==0 && c8_p810_11==0 && c8_p810_12==0 && c8_p810_13==0){
            mostrarMensaje("PREGUNTA 810: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if (c8_p810_13==1){
            if(c8_p810_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 810 - OPCION 13: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if(c8_p811<1){
            mostrarMensaje("PREGUNTA 811: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p812<1){
            mostrarMensaje("PREGUNTA 812: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        return false;
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
}
