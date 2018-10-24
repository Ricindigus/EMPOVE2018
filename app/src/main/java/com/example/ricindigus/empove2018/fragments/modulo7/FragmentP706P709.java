package com.example.ricindigus.empove2018.fragments.modulo7;


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
public class FragmentP706P709 extends FragmentPagina {

    Context context;
    String idVivienda, idHogar, idInformante, idPersona;

    RadioGroup c7_p706_RadioGroup, c7_p707_RadioGroup;
    EditText c7_p707_o_EditText;
    CheckBox c7_p708_1_Checkbox, c7_p708_2_Checkbox, c7_p708_3_Checkbox , c7_p708_4_Checkbox, c7_p708_5_Checkbox,
            c7_p708_6_Checkbox, c7_p708_7_Checkbox, c7_p708_8_Checkbox,
            c7_p709_1_Checkbox, c7_p709_2_Checkbox, c7_p709_3_Checkbox , c7_p709_4_Checkbox, c7_p709_5_Checkbox,
            c7_p709_6_Checkbox, c7_p709_7_Checkbox, c7_p709_8_Checkbox, c7_p709_9_Checkbox, c7_p709_10_Checkbox;
    EditText c7_p709_o_EditText;
    LinearLayout m7_p706_linearlayout, m7_p707_linearlayout, m7_p708_linearlayout, m7_p709_linearlayout;

    private int c7_p706, c7_p707;
    private String c7_p707_o, c7_p709_o;
    private int c7_p708_1, c7_p708_2, c7_p708_3, c7_p708_4, c7_p708_5;
    private int c7_p709_1, c7_p709_2, c7_p709_3, c7_p709_4, c7_p709_5, c7_p709_6, c7_p709_7, c7_p709_8,
            c7_p709_9, c7_p709_10;

    @SuppressLint("ValidFragment")
    public FragmentP706P709(Context context, String idVivienda, String idHogar, String idInformante, String idPersona) {
        this.context = context;
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idInformante = idInformante;
        this.idPersona = idPersona;// Required empty public constructor
    }

    public FragmentP706P709() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p706_p709, container, false);

        c7_p706_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod7_706_radiogroup_C7_P706);

        c7_p707_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod7_707_radiogroup_C7_P707);
        c7_p707_o_EditText = (EditText) rootView.findViewById(R.id.mod7_707_edittext_C7_P707_O);

        c7_p708_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_1);
        c7_p708_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_2);
        c7_p708_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_3);
        c7_p708_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_4);
        c7_p708_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_708_checkbox_C7_P708_5);

        c7_p709_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_1);
        c7_p709_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_2);
        c7_p709_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_3);
        c7_p709_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_4);
        c7_p709_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_5);
        c7_p709_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_6);
        c7_p709_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_7);
        c7_p709_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_8);
        c7_p709_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_9);
        c7_p709_o_EditText = (EditText) rootView.findViewById(R.id.mod7_709_edittext_C7_P709_O);
        c7_p709_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_709_checkbox_C7_P709_10);

        m7_p706_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p706);
        m7_p707_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p707);
        m7_p708_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p708);
        m7_p709_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p709);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c7_p707_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c7_p707_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c7_p707_o_EditText);
                    m7_p707_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c7_p709_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c7_p709_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c7_p709_o_EditText);
                    m7_p709_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        cargarDatos();
    }

    public void guardarDatos(){
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo7_c7_p706, ""+c7_p706);
        contentValues.put(SQLConstantes.modulo7_c7_p707, ""+c7_p707);
        contentValues.put(SQLConstantes.modulo7_c7_p707_o, ""+c7_p707_o);

        contentValues.put(SQLConstantes.modulo7_c7_p708_1, ""+c7_p708_1);
        contentValues.put(SQLConstantes.modulo7_c7_p708_2, ""+c7_p708_2);
        contentValues.put(SQLConstantes.modulo7_c7_p708_3, ""+c7_p708_3);
        contentValues.put(SQLConstantes.modulo7_c7_p708_4, ""+c7_p708_4);
        contentValues.put(SQLConstantes.modulo7_c7_p708_5, ""+c7_p708_5);

        contentValues.put(SQLConstantes.modulo7_c7_p709_1, ""+c7_p709_1);
        contentValues.put(SQLConstantes.modulo7_c7_p709_2, ""+c7_p709_2);
        contentValues.put(SQLConstantes.modulo7_c7_p709_3, ""+c7_p709_3);
        contentValues.put(SQLConstantes.modulo7_c7_p709_4, ""+c7_p709_4);
        contentValues.put(SQLConstantes.modulo7_c7_p709_5, ""+c7_p709_5);
        contentValues.put(SQLConstantes.modulo7_c7_p709_6, ""+c7_p709_6);
        contentValues.put(SQLConstantes.modulo7_c7_p709_7, ""+c7_p709_7);
        contentValues.put(SQLConstantes.modulo7_c7_p709_8, ""+c7_p709_8);
        contentValues.put(SQLConstantes.modulo7_c7_p709_9, ""+c7_p709_9);
        contentValues.put(SQLConstantes.modulo7_c7_p709_10, ""+c7_p709_10);
        contentValues.put(SQLConstantes.modulo7_c7_p709_o, ""+c7_p709_o);

        if(data.existeElemento(getNombreTabla(),idPersona)){
            data.actualizarElemento(getNombreTabla(),contentValues,idPersona);
        }else{
            contentValues.put(SQLConstantes.modulo7_idVivienda,""+idVivienda);
            contentValues.put(SQLConstantes.modulo7_idHogar,""+idHogar);
            contentValues.put(SQLConstantes.modulo7_idInformante,""+idInformante);
            contentValues.put(SQLConstantes.modulo7_id,""+idPersona);
            data.insertarElemento(getNombreTabla(),contentValues);
        }

        data.close();
    }

    public void llenarVariables(){
        c7_p706 = c7_p706_RadioGroup.indexOfChild(c7_p706_RadioGroup.findViewById(c7_p706_RadioGroup.getCheckedRadioButtonId()));
        c7_p707 = c7_p707_RadioGroup.indexOfChild(c7_p707_RadioGroup.findViewById(c7_p707_RadioGroup.getCheckedRadioButtonId()));
        c7_p707_o = c7_p707_o_EditText.getText().toString();

        if (c7_p708_1_Checkbox.isChecked()) c7_p708_1 = 1; else c7_p708_1 = 0;
        if (c7_p708_2_Checkbox.isChecked()) c7_p708_2 = 1; else c7_p708_2 = 0;
        if (c7_p708_3_Checkbox.isChecked()) c7_p708_3 = 1; else c7_p708_3 = 0;
        if (c7_p708_4_Checkbox.isChecked()) c7_p708_4 = 1; else c7_p708_4 = 0;
        if (c7_p708_5_Checkbox.isChecked()) c7_p708_5 = 1; else c7_p708_5 = 0;

        if (c7_p709_1_Checkbox.isChecked()) c7_p709_1 = 1; else c7_p709_1 = 0;
        if (c7_p709_2_Checkbox.isChecked()) c7_p709_2 = 1; else c7_p709_2 = 0;
        if (c7_p709_3_Checkbox.isChecked()) c7_p709_3 = 1; else c7_p709_3 = 0;
        if (c7_p709_4_Checkbox.isChecked()) c7_p709_4 = 1; else c7_p709_4 = 0;
        if (c7_p709_5_Checkbox.isChecked()) c7_p709_5 = 1; else c7_p709_5 = 0;
        if (c7_p709_6_Checkbox.isChecked()) c7_p709_6 = 1; else c7_p709_6 = 0;
        if (c7_p709_7_Checkbox.isChecked()) c7_p709_7 = 1; else c7_p709_7 = 0;
        if (c7_p709_8_Checkbox.isChecked()) c7_p709_8 = 1; else c7_p709_8 = 0;
        if (c7_p709_9_Checkbox.isChecked()) c7_p709_9 = 1; else c7_p709_9 = 0;
        if (c7_p709_10_Checkbox.isChecked()) c7_p709_10 = 1; else c7_p709_10 = 0;
        c7_p709_o = c7_p709_o_EditText.getText().toString();

    }

    @Override
    public void cargarDatos() {

    }

    public boolean validarDatos(){
        if(c7_p706<1){
            mostrarMensaje("PREGUNTA 706: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(c7_p707<1){
            mostrarMensaje("PREGUNTA 706: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if (c7_p707==1){
            if(c7_p707_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 707 - OPCION 8: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if(c7_p708_1==0 && c7_p708_2==0 && c7_p708_3==0 && c7_p708_4==0 && c7_p708_5==0){
            mostrarMensaje("PREGUNTA 708: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if(c7_p709_1==0 && c7_p709_2==0 && c7_p709_3==0 && c7_p709_4==0 && c7_p709_5==0 &&
                c7_p709_6==0 && c7_p709_7==0 && c7_p709_8==0 && c7_p709_9==0 && c7_p709_10==0){
            mostrarMensaje("PREGUNTA 709: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if (c7_p709_9==1){
            if(c7_p709_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 709 - OPCION 9: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        return false;
    }

    public String getNombreTabla() {
        return SQLConstantes.tablamodulo7;
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
