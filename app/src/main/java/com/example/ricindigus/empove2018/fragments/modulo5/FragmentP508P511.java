package com.example.ricindigus.empove2018.fragments.modulo5;


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
public class FragmentP508P511 extends FragmentPagina {
    String idVivienda, idHogar, idPersona, idInformante;
    Context context;

    CheckBox c5_p508_1_Checkbox, c5_p508_2_Checkbox, c5_p508_3_Checkbox , c5_p508_4_Checkbox, c5_p508_5_Checkbox,
            c5_p508_6_Checkbox, c5_p508_7_Checkbox, c5_p508_8_Checkbox, c5_p508_9_Checkbox, c5_p508_10_Checkbox, c5_p508_11_Checkbox;
    EditText c5_p508_o_EditText, c5_p511_o_EditText;
    RadioGroup c5_p509_RadioGroup, c5_p510_RadioGroup, c5_p511_RadioGroup;
    LinearLayout m5_p508_linearlayout, m5_p509_linearlayout, m5_p510_linearlayout, m5_p511_linearlayout;

    private int c5_p508_1;
    private int c5_p508_2;
    private int c5_p508_3;
    private int c5_p508_4;
    private int c5_p508_5;
    private int c5_p508_6;
    private int c5_p508_7;
    private int c5_p508_8;
    private int c5_p508_9;
    private int c5_p508_10;
    private int c5_p508_11;
    private String c5_p508_o;
    private int c5_p509;
    private int c5_p510;
    private int c5_p511;
    private String c5_p511_o;

    @SuppressLint("ValidFragment")
    public FragmentP508P511(String idVivienda, String idHogar, String idPersona, String idInformante, Context context) {
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idPersona = idPersona;
        this.idInformante = idInformante;
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
        c5_p508_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c5_p508_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p508_o_EditText);
                    m5_p508_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p511_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c5_p511_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p511_o_EditText);
                    m5_p511_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_c5_p508_1,c5_p508_1+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_2,c5_p508_2+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_3,c5_p508_3+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_4,c5_p508_4+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_5,c5_p508_5+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_6,c5_p508_6+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_7,c5_p508_7+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_8,c5_p508_8+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_9,c5_p508_9+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_10,c5_p508_10+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_11,c5_p508_11+"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_o,c5_p508_o);
        contentValues.put(SQLConstantes.modulo5_c5_p509,c5_p509+"");
        contentValues.put(SQLConstantes.modulo5_c5_p510,c5_p510+"");
        contentValues.put(SQLConstantes.modulo5_c5_p511,c5_p511+"");
        contentValues.put(SQLConstantes.modulo5_c5_p511_o,c5_p511_o);

        if(data.existeElemento(getNombreTabla(),idPersona)){
            data.actualizarElemento(getNombreTabla(),contentValues,idPersona);
        }else{
            contentValues.put(SQLConstantes.modulo5_idVivienda,idVivienda+"");
            contentValues.put(SQLConstantes.modulo5_idHogar,idHogar+"");
            contentValues.put(SQLConstantes.modulo5_id,idPersona+"");
            contentValues.put(SQLConstantes.modulo5_idInformante,idInformante+"");
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        if(c5_p508_1_Checkbox.isChecked()) c5_p508_1 = 1; else c5_p508_1 = 0;
        if(c5_p508_2_Checkbox.isChecked()) c5_p508_2 = 1; else c5_p508_2 = 0;
        if(c5_p508_3_Checkbox.isChecked()) c5_p508_3 = 1; else c5_p508_3 = 0;
        if(c5_p508_4_Checkbox.isChecked()) c5_p508_4 = 1; else c5_p508_4 = 0;
        if(c5_p508_5_Checkbox.isChecked()) c5_p508_5 = 1; else c5_p508_5 = 0;
        if(c5_p508_6_Checkbox.isChecked()) c5_p508_6 = 1; else c5_p508_6 = 0;
        if(c5_p508_7_Checkbox.isChecked()) c5_p508_7 = 1; else c5_p508_7 = 0;
        if(c5_p508_8_Checkbox.isChecked()) c5_p508_8 = 1; else c5_p508_8 = 0;
        if(c5_p508_9_Checkbox.isChecked()) c5_p508_9 = 1; else c5_p508_9 = 0;
        if(c5_p508_10_Checkbox.isChecked()) c5_p508_10 = 1; else c5_p508_10 = 0;
        if(c5_p508_11_Checkbox.isChecked()) c5_p508_11 = 1; else c5_p508_11 = 0;
        c5_p508_o = c5_p508_o_EditText.getText().toString();
        c5_p509 = c5_p509_RadioGroup.indexOfChild(c5_p509_RadioGroup.findViewById(c5_p509_RadioGroup.getCheckedRadioButtonId()));
        c5_p510 = c5_p510_RadioGroup.indexOfChild(c5_p510_RadioGroup.findViewById(c5_p510_RadioGroup.getCheckedRadioButtonId()));
        c5_p511 = c5_p511_RadioGroup.indexOfChild(c5_p511_RadioGroup.findViewById(c5_p511_RadioGroup.getCheckedRadioButtonId()));
        c5_p511_o = c5_p511_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(m5_p508_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p508_1==0 && c5_p508_2==0 && c5_p508_3==0 && c5_p508_4==0 && c5_p508_5==0 &&
                    c5_p508_6==0 && c5_p508_7==0 && c5_p508_8==0 && c5_p508_9==0 && c5_p508_10==0 &&
                    c5_p508_11==0){
                mostrarMensaje("PREGUNTA 508: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c5_p508_11==1){
                if(c5_p508_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 508 - OPCION 11: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c5_p509<1 && m5_p509_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 509: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c5_p510<1 && m5_p510_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 510: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c5_p511<1 && m5_p511_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 511: DEBE SELECCIONAR UNA OPCION");
            return false;
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
}
