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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo8;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP805P808 extends FragmentPagina {

    Context context;
    String idVivienda, idHogar, idInformante, idEncuestado;

    RadioGroup c8_p805_1_RadioGroup, c8_p805_2_RadioGroup, c8_p805_3_RadioGroup, c8_p805_4_RadioGroup,
            c8_p805_5_RadioGroup;
    Spinner c8_p806_1_Spinner, c8_p806_2_Spinner, c8_p806_3_Spinner, c8_p806_4_Spinner,
            c8_p806_5_Spinner, c8_p806_6_Spinner;
    RadioGroup c8_p807_RadioGroup;
    CheckBox c8_p808_1_CheckBox, c8_p808_2_CheckBox, c8_p808_3_CheckBox, c8_p808_4_CheckBox,
            c8_p808_5_CheckBox, c8_p808_6_CheckBox, c8_p808_7_CheckBox, c8_p808_8_CheckBox,
            c8_p808_9_CheckBox, c8_p808_10_CheckBox, c8_p808_11_CheckBox, c8_p808_12_CheckBox,
            c8_p808_13_CheckBox;
    EditText c8_p808_o_EditText;
    LinearLayout m8_p805_linearlayout, m8_p806_linearlayout, m8_p807_linearlayout, m8_p808_linearlayout;

    private int c8_p805_1;
    private int c8_p805_2;
    private int c8_p805_3;
    private int c8_p805_4;
    private int c8_p805_5;
    private int c8_p806_1;
    private int c8_p806_2;
    private int c8_p806_3;
    private int c8_p806_4;
    private int c8_p806_5;
    private int c8_p806_6;
    private int c8_p807;
    private String c8_p808_1;
    private String c8_p808_2;
    private String c8_p808_3;
    private String c8_p808_4;
    private String c8_p808_5;
    private String c8_p808_6;
    private String c8_p808_7;
    private String c8_p808_8;
    private String c8_p808_9;
    private String c8_p808_10;
    private String c8_p808_11;
    private String c8_p808_12;
    private String c8_p808_13;
    private String c8_p808_o;


    @SuppressLint("ValidFragment")
    public FragmentP805P808(String idEncuestado, Context context) {
        this.context = context;
        this.idEncuestado = idEncuestado;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idVivienda = residente.getId_vivienda();
        idHogar = residente.getId_hogar();
        idInformante = "";
        data.close();
    }

    public FragmentP805P808() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p805_p808, container, false);

        c8_p805_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_1);
        c8_p805_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_2);
        c8_p805_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_3);
        c8_p805_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_4);
        c8_p805_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_805_radiogroup_C8_P805_5);

        c8_p806_1_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_1);
        c8_p806_2_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_2);
        c8_p806_3_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_3);
        c8_p806_4_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_4);
        c8_p806_5_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_5);
        c8_p806_6_Spinner = (Spinner) rootView.findViewById(R.id.mod8_806_spinner_C8_P806_6);

        c8_p807_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_807_radiogroup_C8_P807);

        c8_p808_1_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_1);
        c8_p808_2_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_2);
        c8_p808_3_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_3);
        c8_p808_4_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_4);
        c8_p808_5_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_5);
        c8_p808_6_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_6);
        c8_p808_7_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_7);
        c8_p808_8_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_8);
        c8_p808_9_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_9);
        c8_p808_10_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_10);
        c8_p808_11_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_11);
        c8_p808_12_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_12);
        c8_p808_13_CheckBox = (CheckBox) rootView.findViewById(R.id.mod8_808_checkbox_C8_P808_13);

        c8_p808_o_EditText = (EditText) rootView.findViewById(R.id.mod8_808_edittext_C8_P808_O);

        m8_p805_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p805);
        m8_p806_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p806);
        m8_p807_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p807);
        m8_p808_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p808);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c8_p808_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(30)});
//        c8_p808_o_EditText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    ocultarTeclado(c8_p808_o_EditText);
//                    m8_p808_linearlayout.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });

        //cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo8_c8_p805_1,""+c8_p805_1);
        contentValues.put(SQLConstantes.modulo8_c8_p805_2,""+c8_p805_2);
        contentValues.put(SQLConstantes.modulo8_c8_p805_3,""+c8_p805_3);
        contentValues.put(SQLConstantes.modulo8_c8_p805_4,""+c8_p805_4);
        contentValues.put(SQLConstantes.modulo8_c8_p805_5,""+c8_p805_5);

        contentValues.put(SQLConstantes.modulo8_c8_p806_1,""+c8_p806_1);
        contentValues.put(SQLConstantes.modulo8_c8_p806_2,""+c8_p806_2);
        contentValues.put(SQLConstantes.modulo8_c8_p806_3,""+c8_p806_3);
        contentValues.put(SQLConstantes.modulo8_c8_p806_4,""+c8_p806_4);
        contentValues.put(SQLConstantes.modulo8_c8_p806_5,""+c8_p806_5);
        contentValues.put(SQLConstantes.modulo8_c8_p806_6,""+c8_p806_6);

        contentValues.put(SQLConstantes.modulo8_c8_p807,""+c8_p807);

        contentValues.put(SQLConstantes.modulo8_c8_p808_1,c8_p808_1);
        contentValues.put(SQLConstantes.modulo8_c8_p808_2,c8_p808_2);
        contentValues.put(SQLConstantes.modulo8_c8_p808_3,c8_p808_3);
        contentValues.put(SQLConstantes.modulo8_c8_p808_4,c8_p808_4);
        contentValues.put(SQLConstantes.modulo8_c8_p808_5,c8_p808_5);
        contentValues.put(SQLConstantes.modulo8_c8_p808_6,c8_p808_6);
        contentValues.put(SQLConstantes.modulo8_c8_p808_7,c8_p808_7);
        contentValues.put(SQLConstantes.modulo8_c8_p808_8,c8_p808_8);
        contentValues.put(SQLConstantes.modulo8_c8_p808_9,c8_p808_9);
        contentValues.put(SQLConstantes.modulo8_c8_p808_10,c8_p808_10);
        contentValues.put(SQLConstantes.modulo8_c8_p808_11,c8_p808_11);
        contentValues.put(SQLConstantes.modulo8_c8_p808_12,c8_p808_12);
        contentValues.put(SQLConstantes.modulo8_c8_p808_13,c8_p808_13);
        contentValues.put(SQLConstantes.modulo8_c8_p808_o,c8_p808_o);

//        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
//            Modulo8 modulo8 =  new Modulo8();
//            modulo8.set_id(idEncuestado);
//            modulo8.setIdVivienda(idVivienda);
//            modulo8.setIdHogar(idHogar);
//            data.insertarElemento(getNombreTabla(),modulo8.toValues());
//
//        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        c8_p805_1 = c8_p805_1_RadioGroup.indexOfChild(c8_p805_1_RadioGroup.findViewById(c8_p805_1_RadioGroup.getCheckedRadioButtonId()));
        c8_p805_2 = c8_p805_2_RadioGroup.indexOfChild(c8_p805_2_RadioGroup.findViewById(c8_p805_2_RadioGroup.getCheckedRadioButtonId()));
        c8_p805_3 = c8_p805_3_RadioGroup.indexOfChild(c8_p805_3_RadioGroup.findViewById(c8_p805_3_RadioGroup.getCheckedRadioButtonId()));
        c8_p805_4 = c8_p805_4_RadioGroup.indexOfChild(c8_p805_4_RadioGroup.findViewById(c8_p805_4_RadioGroup.getCheckedRadioButtonId()));
        c8_p805_5 = c8_p805_5_RadioGroup.indexOfChild(c8_p805_5_RadioGroup.findViewById(c8_p805_5_RadioGroup.getCheckedRadioButtonId()));
        c8_p806_1 = c8_p806_1_Spinner.getSelectedItemPosition();
        c8_p806_2 = c8_p806_2_Spinner.getSelectedItemPosition();
        c8_p806_3 = c8_p806_3_Spinner.getSelectedItemPosition();
        c8_p806_4 = c8_p806_4_Spinner.getSelectedItemPosition();
        c8_p806_5 = c8_p806_5_Spinner.getSelectedItemPosition();
        c8_p806_6 = c8_p806_6_Spinner.getSelectedItemPosition();
        c8_p807 = c8_p807_RadioGroup.indexOfChild(c8_p807_RadioGroup.findViewById(c8_p807_RadioGroup.getCheckedRadioButtonId()));
        if(c8_p808_1_CheckBox.isChecked()) c8_p808_1 = "1"; else c8_p808_1 = "0";
        if(c8_p808_2_CheckBox.isChecked()) c8_p808_2 = "1"; else c8_p808_2 = "0";
        if(c8_p808_3_CheckBox.isChecked()) c8_p808_3 = "1"; else c8_p808_3 = "0";
        if(c8_p808_4_CheckBox.isChecked()) c8_p808_4 = "1"; else c8_p808_4 = "0";
        if(c8_p808_5_CheckBox.isChecked()) c8_p808_5 = "1"; else c8_p808_5 = "0";
        if(c8_p808_6_CheckBox.isChecked()) c8_p808_6 = "1"; else c8_p808_6 = "0";
        if(c8_p808_7_CheckBox.isChecked()) c8_p808_7 = "1"; else c8_p808_7 = "0";
        if(c8_p808_8_CheckBox.isChecked()) c8_p808_8 = "1"; else c8_p808_8 = "0";
        if(c8_p808_9_CheckBox.isChecked()) c8_p808_9 = "1"; else c8_p808_9 = "0";
        if(c8_p808_10_CheckBox.isChecked()) c8_p808_10 = "1"; else c8_p808_10 = "0";
        if(c8_p808_11_CheckBox.isChecked()) c8_p808_11 = "1"; else c8_p808_11 = "0";
        if(c8_p808_12_CheckBox.isChecked()) c8_p808_12 = "1"; else c8_p808_12 = "0";
        if(c8_p808_13_CheckBox.isChecked()) c8_p808_13 = "1"; else c8_p808_13 = "0";
        c8_p808_o = c8_p808_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(), idEncuestado)){
            Modulo8 modulo8 = data.getModulo8(idEncuestado);
            if(!modulo8.getC8_p805_1().equals("-1")||!modulo8.getC8_p805_1().equals(""))((RadioButton)c8_p805_1_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p805_1()))).setChecked(true);
            if(!modulo8.getC8_p805_2().equals("-1")||!modulo8.getC8_p805_2().equals(""))((RadioButton)c8_p805_2_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p805_2()))).setChecked(true);
            if(!modulo8.getC8_p805_3().equals("-1")||!modulo8.getC8_p805_3().equals(""))((RadioButton)c8_p805_3_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p805_3()))).setChecked(true);
            if(!modulo8.getC8_p805_4().equals("-1")||!modulo8.getC8_p805_4().equals(""))((RadioButton)c8_p805_4_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p805_4()))).setChecked(true);
            if(!modulo8.getC8_p805_5().equals("-1")||!modulo8.getC8_p805_5().equals(""))((RadioButton)c8_p805_5_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p805_5()))).setChecked(true);

            if(!modulo8.getC8_p807().equals("-1")||!modulo8.getC8_p807().equals(""))((RadioButton)c8_p807_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p807()))).setChecked(true);
            if(modulo8.getC8_p808_1().equals("1")) c8_p808_1_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_1().equals("0")) c8_p808_1_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_2().equals("1")) c8_p808_2_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_2().equals("0")) c8_p808_2_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_3().equals("1")) c8_p808_3_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_3().equals("0")) c8_p808_3_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_4().equals("1")) c8_p808_4_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_4().equals("0")) c8_p808_4_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_5().equals("1")) c8_p808_5_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_5().equals("0")) c8_p808_5_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_6().equals("1")) c8_p808_6_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_6().equals("0")) c8_p808_6_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_7().equals("1")) c8_p808_7_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_7().equals("0")) c8_p808_7_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_8().equals("1")) c8_p808_8_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_8().equals("0")) c8_p808_8_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_9().equals("1")) c8_p808_9_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_9().equals("0")) c8_p808_9_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_10().equals("1")) c8_p808_10_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_10().equals("0")) c8_p808_10_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_11().equals("1")) c8_p808_11_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_11().equals("0")) c8_p808_11_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_12().equals("1")) c8_p808_12_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_12().equals("0")) c8_p808_12_CheckBox.setChecked(false);
            if(modulo8.getC8_p808_13().equals("1")) c8_p808_13_CheckBox.setChecked(true);
            if(modulo8.getC8_p808_13().equals("0")) c8_p808_13_CheckBox.setChecked(false);
            c8_p808_o_EditText.setText(modulo8.getC8_p808_o());
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(c8_p805_1<1){
            mostrarMensaje("PREGUNTA 805 - a: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p805_2<1){
            mostrarMensaje("PREGUNTA 805 - b: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p805_3<1){
            mostrarMensaje("PREGUNTA 805 - c: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p805_4<1){
            mostrarMensaje("PREGUNTA 805 - d: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p805_5<1){
            mostrarMensaje("PREGUNTA 805 - e: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p806_1<1){
            mostrarMensaje("PREGUNTA 806-A: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p806_2<1){
            mostrarMensaje("PREGUNTA 806-B: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p806_3<1){
            mostrarMensaje("PREGUNTA 806-C: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p806_4<1){
            mostrarMensaje("PREGUNTA 806-D: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p806_5<1){
            mostrarMensaje("PREGUNTA 806-E: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c8_p806_6<1){
            mostrarMensaje("PREGUNTA 806-F: DEBE SELECCIONAR UNA OPCION");
            return false;
        }

        if(c8_p807<1){
            mostrarMensaje("PREGUNTA 807: DEBE SELECCIONAR UNA OPCION");
            return false;
        }

        if(c8_p808_1.equals("0") && c8_p808_2.equals("0") && c8_p808_3.equals("0") && c8_p808_4.equals("0") && c8_p808_5.equals("0")
                && c8_p808_6.equals("0") && c8_p808_7.equals("0") && c8_p808_8.equals("0") && c8_p808_9.equals("0") && c8_p808_10.equals("0")
                && c8_p808_11.equals("0") && c8_p808_12.equals("0") && c8_p808_13.equals("0")){
            mostrarMensaje("PREGUNTA 808: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(c8_p808_13.equals("1")){
            if(c8_p808_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 808 - OPCION 13: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }

        return true;
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
