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
public class FragmentP813P816 extends FragmentPagina {

    Context context;
    String idVivienda, idHogar, idInformante, idPersona;

    CheckBox c8_p813_1_Checkbox, c8_p813_2_Checkbox, c8_p813_3_Checkbox , c8_p813_4_Checkbox, c8_p813_5_Checkbox,
            c8_p813_6_Checkbox, c8_p813_7_Checkbox, c8_p813_8_Checkbox, c8_p813_9_Checkbox, c8_p813_10_Checkbox,
            c8_p813_11_Checkbox, c8_p813_12_Checkbox, c8_p813_13_Checkbox, c8_p813_14_Checkbox;
    EditText c8_p813_o_EditText;
    CheckBox c8_p814_1_Checkbox, c8_p814_2_Checkbox, c8_p814_3_Checkbox , c8_p814_4_Checkbox, c8_p814_5_Checkbox,
            c8_p814_6_Checkbox, c8_p814_7_Checkbox, c8_p814_8_Checkbox;
    RadioGroup c8_p815_RadioGroup;
    CheckBox c8_p816_1_Checkbox, c8_p816_2_Checkbox, c8_p816_3_Checkbox , c8_p816_4_Checkbox, c8_p816_5_Checkbox,
            c8_p816_6_Checkbox, c8_p816_7_Checkbox, c8_p816_8_Checkbox, c8_p816_9_Checkbox, c8_p816_10_Checkbox,
            c8_p816_11_Checkbox, c8_p816_12_Checkbox, c8_p816_13_Checkbox;
    EditText c8_p816_o_EditText;
    LinearLayout m8_p813_linearlayout, m8_p814_linearlayout, m8_p815_linearlayout, m8_p816_linearlayout;

    private int c8_p813_1;
    private int c8_p813_2;
    private int c8_p813_3;
    private int c8_p813_4;
    private int c8_p813_5;
    private int c8_p813_6;
    private int c8_p813_7;
    private int c8_p813_8;
    private int c8_p813_9;
    private int c8_p813_10;
    private int c8_p813_11;
    private int c8_p813_12;
    private int c8_p813_13;
    private int c8_p813_14;
    private String c8_p813_o;
    private int c8_p814_1;
    private int c8_p814_2;
    private int c8_p814_3;
    private int c8_p814_4;
    private int c8_p814_5;
    private int c8_p814_6;
    private int c8_p814_7;
    private int c8_p814_8;
    private int c8_p815;
    private int c8_p816_1;
    private int c8_p816_2;
    private int c8_p816_3;
    private int c8_p816_4;
    private int c8_p816_5;
    private int c8_p816_6;
    private int c8_p816_7;
    private int c8_p816_8;
    private int c8_p816_9;
    private int c8_p816_10;
    private int c8_p816_11;
    private int c8_p816_12;
    private int c8_p816_13;
    private String c8_p816_o;

    @SuppressLint("ValidFragment")
    public FragmentP813P816(Context context, String idVivienda, String idHogar, String idInformante, String idPersona) {
        this.context = context;
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idInformante = idInformante;
        this.idPersona = idPersona;
    }

    public FragmentP813P816() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p813_p816, container, false);

        c8_p813_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_1);
        c8_p813_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_2);
        c8_p813_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_3);
        c8_p813_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_4);
        c8_p813_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_5);
        c8_p813_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_6);
        c8_p813_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_7);
        c8_p813_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_8);
        c8_p813_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_9);
        c8_p813_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_10);
        c8_p813_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_11);
        c8_p813_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_12);
        c8_p813_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_13);
        c8_p813_14_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_813_checkbox_C8_P813_14);
        c8_p813_o_EditText = (EditText) rootView.findViewById(R.id.mod8_813_edittext_C8_P813_O);

        c8_p814_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_1);
        c8_p814_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_2);
        c8_p814_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_3);
        c8_p814_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_4);
        c8_p814_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_5);
        c8_p814_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_6);
        c8_p814_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_7);
        c8_p814_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_814_checkbox_C8_P814_8);

        c8_p815_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_815_radiogroup_C8_P815);

        c8_p816_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_1);
        c8_p816_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_2);
        c8_p816_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_3);
        c8_p816_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_4);
        c8_p816_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_5);
        c8_p816_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_6);
        c8_p816_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_7);
        c8_p816_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_8);
        c8_p816_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_9);
        c8_p816_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_10);
        c8_p816_11_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_11);
        c8_p816_12_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_12);
        c8_p816_13_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_816_checkbox_C8_P816_13);
        c8_p816_o_EditText = (EditText) rootView.findViewById(R.id.mod8_816_edittext_C8_P816_O);

        m8_p813_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p813);
        m8_p814_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p814);
        m8_p815_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p815);
        m8_p816_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p816);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c8_p813_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c8_p813_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c8_p813_o_EditText);
                    m8_p813_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c8_p816_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c8_p816_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c8_p816_o_EditText);
                    m8_p816_linearlayout.requestFocus();
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
        contentValues.put(SQLConstantes.modulo8_c8_p813_1,""+c8_p813_1);
        contentValues.put(SQLConstantes.modulo8_c8_p813_2,""+c8_p813_2);
        contentValues.put(SQLConstantes.modulo8_c8_p813_3,""+c8_p813_3);
        contentValues.put(SQLConstantes.modulo8_c8_p813_4,""+c8_p813_4);
        contentValues.put(SQLConstantes.modulo8_c8_p813_5,""+c8_p813_5);
        contentValues.put(SQLConstantes.modulo8_c8_p813_6,""+c8_p813_6);
        contentValues.put(SQLConstantes.modulo8_c8_p813_7,""+c8_p813_7);
        contentValues.put(SQLConstantes.modulo8_c8_p813_8,""+c8_p813_8);
        contentValues.put(SQLConstantes.modulo8_c8_p813_9,""+c8_p813_9);
        contentValues.put(SQLConstantes.modulo8_c8_p813_10,""+c8_p813_10);
        contentValues.put(SQLConstantes.modulo8_c8_p813_11,""+c8_p813_11);
        contentValues.put(SQLConstantes.modulo8_c8_p813_12,""+c8_p813_12);
        contentValues.put(SQLConstantes.modulo8_c8_p813_13,""+c8_p813_13);
        contentValues.put(SQLConstantes.modulo8_c8_p813_14,""+c8_p813_14);
        contentValues.put(SQLConstantes.modulo8_c8_p813_o,""+c8_p813_o);

        contentValues.put(SQLConstantes.modulo8_c8_p814_1,""+c8_p814_1);
        contentValues.put(SQLConstantes.modulo8_c8_p814_2,""+c8_p814_2);
        contentValues.put(SQLConstantes.modulo8_c8_p814_3,""+c8_p814_3);
        contentValues.put(SQLConstantes.modulo8_c8_p814_4,""+c8_p814_4);
        contentValues.put(SQLConstantes.modulo8_c8_p814_5,""+c8_p814_5);
        contentValues.put(SQLConstantes.modulo8_c8_p814_6,""+c8_p814_6);
        contentValues.put(SQLConstantes.modulo8_c8_p814_7,""+c8_p814_7);
        contentValues.put(SQLConstantes.modulo8_c8_p814_8,""+c8_p814_8);

        contentValues.put(SQLConstantes.modulo8_c8_p815,""+c8_p815);

        contentValues.put(SQLConstantes.modulo8_c8_p816_1,""+c8_p816_1);
        contentValues.put(SQLConstantes.modulo8_c8_p816_2,""+c8_p816_1);
        contentValues.put(SQLConstantes.modulo8_c8_p816_3,""+c8_p816_1);
        contentValues.put(SQLConstantes.modulo8_c8_p816_4,""+c8_p816_1);
        contentValues.put(SQLConstantes.modulo8_c8_p816_5,""+c8_p816_1);
        contentValues.put(SQLConstantes.modulo8_c8_p816_6,""+c8_p816_1);
        contentValues.put(SQLConstantes.modulo8_c8_p816_7,""+c8_p816_1);
        contentValues.put(SQLConstantes.modulo8_c8_p816_8,""+c8_p816_1);
        contentValues.put(SQLConstantes.modulo8_c8_p816_9,""+c8_p816_9);
        contentValues.put(SQLConstantes.modulo8_c8_p816_10,""+c8_p816_10);
        contentValues.put(SQLConstantes.modulo8_c8_p816_11,""+c8_p816_11);
        contentValues.put(SQLConstantes.modulo8_c8_p816_12,""+c8_p816_12);
        contentValues.put(SQLConstantes.modulo8_c8_p816_13,""+c8_p816_13);

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
    public void llenarVariables() {
        if(c8_p813_1_Checkbox.isChecked()) c8_p813_1 = 1; else c8_p813_1 = 0;
        if(c8_p813_2_Checkbox.isChecked()) c8_p813_2 = 1; else c8_p813_2 = 0;
        if(c8_p813_3_Checkbox.isChecked()) c8_p813_3 = 1; else c8_p813_3 = 0;
        if(c8_p813_4_Checkbox.isChecked()) c8_p813_4 = 1; else c8_p813_4 = 0;
        if(c8_p813_5_Checkbox.isChecked()) c8_p813_5 = 1; else c8_p813_5 = 0;
        if(c8_p813_6_Checkbox.isChecked()) c8_p813_6 = 1; else c8_p813_6 = 0;
        if(c8_p813_7_Checkbox.isChecked()) c8_p813_7 = 1; else c8_p813_7 = 0;
        if(c8_p813_8_Checkbox.isChecked()) c8_p813_8 = 1; else c8_p813_8 = 0;
        if(c8_p813_9_Checkbox.isChecked()) c8_p813_9 = 1; else c8_p813_9 = 0;
        if(c8_p813_10_Checkbox.isChecked()) c8_p813_10 = 1; else c8_p813_10 = 0;
        if(c8_p813_11_Checkbox.isChecked()) c8_p813_11 = 1; else c8_p813_11 = 0;
        if(c8_p813_12_Checkbox.isChecked()) c8_p813_12 = 1; else c8_p813_12 = 0;
        if(c8_p813_13_Checkbox.isChecked()) c8_p813_13 = 1; else c8_p813_13 = 0;
        if(c8_p813_14_Checkbox.isChecked()) c8_p813_14 = 1; else c8_p813_14 = 0;
        c8_p813_o = c8_p813_o_EditText.getText().toString();
        if(c8_p814_1_Checkbox.isChecked()) c8_p814_1 = 1; else c8_p814_1 = 0;
        if(c8_p814_2_Checkbox.isChecked()) c8_p814_2 = 1; else c8_p814_2 = 0;
        if(c8_p814_3_Checkbox.isChecked()) c8_p814_3 = 1; else c8_p814_3 = 0;
        if(c8_p814_4_Checkbox.isChecked()) c8_p814_4 = 1; else c8_p814_4 = 0;
        if(c8_p814_5_Checkbox.isChecked()) c8_p814_5 = 1; else c8_p814_5 = 0;
        if(c8_p814_6_Checkbox.isChecked()) c8_p814_6 = 1; else c8_p814_6 = 0;
        if(c8_p814_7_Checkbox.isChecked()) c8_p814_7 = 1; else c8_p814_7 = 0;
        if(c8_p814_8_Checkbox.isChecked()) c8_p814_8 = 1; else c8_p814_8 = 0;
        c8_p815 = c8_p815_RadioGroup.indexOfChild(c8_p815_RadioGroup.findViewById(c8_p815_RadioGroup.getCheckedRadioButtonId()));
        if(c8_p816_1_Checkbox.isChecked()) c8_p816_1 = 1; else c8_p816_1 = 0;
        if(c8_p816_2_Checkbox.isChecked()) c8_p816_2 = 1; else c8_p816_2 = 0;
        if(c8_p816_3_Checkbox.isChecked()) c8_p816_3 = 1; else c8_p816_3 = 0;
        if(c8_p816_4_Checkbox.isChecked()) c8_p816_4 = 1; else c8_p816_4 = 0;
        if(c8_p816_5_Checkbox.isChecked()) c8_p816_5 = 1; else c8_p816_5 = 0;
        if(c8_p816_6_Checkbox.isChecked()) c8_p816_6 = 1; else c8_p816_6 = 0;
        if(c8_p816_7_Checkbox.isChecked()) c8_p816_7 = 1; else c8_p816_7 = 0;
        if(c8_p816_8_Checkbox.isChecked()) c8_p816_8 = 1; else c8_p816_8 = 0;
        if(c8_p816_9_Checkbox.isChecked()) c8_p816_9 = 1; else c8_p816_9 = 0;
        if(c8_p816_10_Checkbox.isChecked()) c8_p816_10 = 1; else c8_p816_10 = 0;
        if(c8_p816_11_Checkbox.isChecked()) c8_p816_11 = 1; else c8_p816_11 = 0;
        if(c8_p816_12_Checkbox.isChecked()) c8_p816_12 = 1; else c8_p816_12 = 0;
        if(c8_p816_13_Checkbox.isChecked()) c8_p816_13 = 1; else c8_p816_13 = 0;
        c8_p816_o = c8_p816_o_EditText.getText().toString();

    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        if(c8_p813_1==0 && c8_p813_2==0 && c8_p813_3==0 && c8_p813_4==0 && c8_p813_5==0 && c8_p813_6==0
                && c8_p813_7==0 && c8_p813_8==0 && c8_p813_9==0 && c8_p813_10==0 && c8_p813_11==0 && c8_p813_12==0 && c8_p813_13==0 && c8_p813_14==0){
            mostrarMensaje("PREGUNTA 813: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if (c8_p813_14==1){
            if(c8_p813_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 813 - OPCION 14: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if(c8_p814_1==0 && c8_p814_2==0 && c8_p814_3==0 && c8_p814_4==0 && c8_p814_5==0 && c8_p814_6==0
                && c8_p814_7==0 && c8_p814_8==0 ){
            mostrarMensaje("PREGUNTA 814: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(c8_p815<1){
            mostrarMensaje("PREGUNTA 815: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p816_1==0 && c8_p816_2==0 && c8_p816_3==0 && c8_p816_4==0 && c8_p816_5==0 && c8_p816_6==0
                && c8_p816_7==0 && c8_p816_8==0 && c8_p816_9==0 && c8_p816_10==0 && c8_p816_11==0 && c8_p816_12==0 && c8_p816_13==0){
            mostrarMensaje("PREGUNTA 813: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if (c8_p816_13==1){
            if(c8_p816_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 816 - OPCION 13: DEBE ESPECIFICAR OTRO");
                return false;
            }
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
//XD
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
