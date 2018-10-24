package com.example.ricindigus.empove2018.fragments.modulo7;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentP701P705 extends Fragment {

    Context context;
    String idVivienda, idHogar, idInformante, idPersona;

    RadioGroup c7_p701_RadioGroup;
    CheckBox c7_p702_1_Checkbox, c7_p702_2_Checkbox, c7_p702_3_Checkbox , c7_p702_4_Checkbox, c7_p702_5_Checkbox,
            c7_p702_6_Checkbox, c7_p702_7_Checkbox, c7_p702_8_Checkbox, c7_p702_9_Checkbox, c7_p702_10_Checkbox;
    EditText c7_p702_o_EditText;
    RadioGroup c7_p703_RadioGroup;
    CheckBox c7_p704_1_Checkbox, c7_p704_2_Checkbox, c7_p704_3_Checkbox , c7_p704_4_Checkbox, c7_p704_5_Checkbox,
            c7_p704_6_Checkbox;
    EditText c7_p704_o_EditText;
    CheckBox c7_p705_1_Checkbox, c7_p705_2_Checkbox, c7_p705_3_Checkbox , c7_p705_4_Checkbox, c7_p705_5_Checkbox,
            c7_p705_6_Checkbox, c7_p705_7_Checkbox;
    EditText c7_p705_o_EditText;
    LinearLayout m7_p701_linearlayout, m7_p702_linearlayout, m7_p703_linearlayout, m7_p704_linearlayout,
            m7_p705_linearlayout;


    private int c7_p701;
    private int c7_p702_1, c7_p702_2, c7_p702_3, c7_p702_4, c7_p702_5, c7_p702_6, c7_p702_7,
                c7_p702_8, c7_p702_9, c7_p702_10;
    private String c7_p702_o, c7_p704_o, c7_p705_o;
    private int c7_p703;
    private int  c7_p704_1, c7_p704_2, c7_p704_3, c7_p704_4, c7_p704_5, c7_p704_6;
    private int c7_p705_1, c7_p705_2, c7_p705_3, c7_p705_4, c7_p705_5, c7_p705_6, c7_p705_7;

    @SuppressLint("ValidFragment")
    public FragmentP701P705(Context context, String idVivienda, String idHogar, String idInformante, String idPersona) {
        this.context = context;
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idInformante = idInformante;
        this.idPersona = idPersona;
        // Required empty public constructor
    }

    public FragmentP701P705(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p701_p705, container, false);

        c7_p701_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod7_701_radiogroup_C7_P701);

        c7_p702_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_1);
        c7_p702_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_2);
        c7_p702_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_3);
        c7_p702_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_4);
        c7_p702_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_5);
        c7_p702_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_6);
        c7_p702_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_7);
        c7_p702_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_8);
        c7_p702_9_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_9);
        c7_p702_10_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_702_checkbox_C7_P702_10);
        c7_p702_o_EditText = (EditText) rootView.findViewById(R.id.mod7_702_edittext_C7_P702_O);

        c7_p703_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod7_703_radiogroup_C7_P703);

        c7_p704_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_1);
        c7_p704_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_2);
        c7_p704_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_3);
        c7_p704_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_4);
        c7_p704_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_5);
        c7_p704_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_704_checkbox_C7_P704_6);
        c7_p704_o_EditText = (EditText) rootView.findViewById(R.id.mod7_704_edittext_C7_P704_O);

        c7_p705_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_1);
        c7_p705_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_2);
        c7_p705_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_3);
        c7_p705_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_4);
        c7_p705_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_5);
        c7_p705_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_6);
        c7_p705_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod7_705_checkbox_C7_P705_7);
        c7_p705_o_EditText = (EditText) rootView.findViewById(R.id.mod7_705_edittext_C7_P705_O);

        m7_p701_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p701);
        m7_p702_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p702);
        m7_p703_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p703);
        m7_p704_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p704);
        m7_p705_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m7_p705);

        return rootView;
    }

    public void guardarDatos(){
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo7_c7_p701, ""+c7_p701);
        contentValues.put(SQLConstantes.modulo7_c7_p702_1, ""+c7_p702_1);
        contentValues.put(SQLConstantes.modulo7_c7_p702_2, ""+c7_p702_2);
        contentValues.put(SQLConstantes.modulo7_c7_p702_3, ""+c7_p702_3);
        contentValues.put(SQLConstantes.modulo7_c7_p702_4, ""+c7_p702_4);
        contentValues.put(SQLConstantes.modulo7_c7_p702_5, ""+c7_p702_5);
        contentValues.put(SQLConstantes.modulo7_c7_p702_6, ""+c7_p702_6);
        contentValues.put(SQLConstantes.modulo7_c7_p702_7, ""+c7_p702_7);
        contentValues.put(SQLConstantes.modulo7_c7_p702_8, ""+c7_p702_8);
        contentValues.put(SQLConstantes.modulo7_c7_p702_9, ""+c7_p702_9);
        contentValues.put(SQLConstantes.modulo7_c7_p702_10, ""+c7_p702_10);
        contentValues.put(SQLConstantes.modulo7_c7_p702_o, ""+c7_p702_o);
        contentValues.put(SQLConstantes.modulo7_c7_p703, ""+c7_p703);

        contentValues.put(SQLConstantes.modulo7_c7_p704_1, ""+c7_p704_1);
        contentValues.put(SQLConstantes.modulo7_c7_p704_2, ""+c7_p704_2);
        contentValues.put(SQLConstantes.modulo7_c7_p704_3, ""+c7_p704_3);
        contentValues.put(SQLConstantes.modulo7_c7_p704_4, ""+c7_p704_4);
        contentValues.put(SQLConstantes.modulo7_c7_p704_5, ""+c7_p704_5);
        contentValues.put(SQLConstantes.modulo7_c7_p704_6, ""+c7_p704_6);
        contentValues.put(SQLConstantes.modulo7_c7_p704_o, ""+c7_p704_o);

        contentValues.put(SQLConstantes.modulo7_c7_p705_1, ""+c7_p705_1);
        contentValues.put(SQLConstantes.modulo7_c7_p705_2, ""+c7_p705_2);
        contentValues.put(SQLConstantes.modulo7_c7_p705_3, ""+c7_p705_3);
        contentValues.put(SQLConstantes.modulo7_c7_p705_4, ""+c7_p705_4);
        contentValues.put(SQLConstantes.modulo7_c7_p705_5, ""+c7_p705_5);
        contentValues.put(SQLConstantes.modulo7_c7_p705_6, ""+c7_p705_6);
        contentValues.put(SQLConstantes.modulo7_c7_p705_7, ""+c7_p705_7);
        contentValues.put(SQLConstantes.modulo7_c7_p705_o, ""+c7_p705_o);

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

        c7_p701 = c7_p701_RadioGroup.indexOfChild(c7_p701_RadioGroup.findViewById(c7_p701_RadioGroup.getCheckedRadioButtonId()));
        if (c7_p702_1_Checkbox.isChecked()) c7_p702_1 = 1; else c7_p702_1 = 0;
        if (c7_p702_2_Checkbox.isChecked()) c7_p702_2 = 1; else c7_p702_2 = 0;
        if (c7_p702_3_Checkbox.isChecked()) c7_p702_3 = 1; else c7_p702_3 = 0;
        if (c7_p702_4_Checkbox.isChecked()) c7_p702_4 = 1; else c7_p702_4 = 0;
        if (c7_p702_5_Checkbox.isChecked()) c7_p702_5 = 1; else c7_p702_5 = 0;
        if (c7_p702_6_Checkbox.isChecked()) c7_p702_6 = 1; else c7_p702_6 = 0;
        if (c7_p702_7_Checkbox.isChecked()) c7_p702_7 = 1; else c7_p702_7 = 0;
        if (c7_p702_8_Checkbox.isChecked()) c7_p702_8 = 1; else c7_p702_8 = 0;
        if (c7_p702_9_Checkbox.isChecked()) c7_p702_9 = 1; else c7_p702_9 = 0;
        if (c7_p702_10_Checkbox.isChecked()) c7_p702_10 = 1; else c7_p702_10 = 0;
        c7_p702_o = c7_p702_o_EditText.getText().toString();
        c7_p703 = c7_p703_RadioGroup.indexOfChild(c7_p703_RadioGroup.findViewById(c7_p703_RadioGroup.getCheckedRadioButtonId()));
        if (c7_p704_1_Checkbox.isChecked()) c7_p704_1 = 1; else c7_p704_1 = 0;
        if (c7_p704_2_Checkbox.isChecked()) c7_p704_2 = 1; else c7_p704_2 = 0;
        if (c7_p704_3_Checkbox.isChecked()) c7_p704_3 = 1; else c7_p704_3 = 0;
        if (c7_p704_4_Checkbox.isChecked()) c7_p704_4 = 1; else c7_p704_4 = 0;
        if (c7_p704_5_Checkbox.isChecked()) c7_p704_5 = 1; else c7_p704_5 = 0;
        if (c7_p704_6_Checkbox.isChecked()) c7_p704_6 = 1; else c7_p704_6 = 0;
        c7_p704_o = c7_p704_o_EditText.getText().toString();
        if (c7_p705_1_Checkbox.isChecked()) c7_p705_1 = 1; else c7_p705_1 = 0;
        if (c7_p705_2_Checkbox.isChecked()) c7_p705_2 = 1; else c7_p705_2 = 0;
        if (c7_p705_3_Checkbox.isChecked()) c7_p705_3 = 1; else c7_p705_3 = 0;
        if (c7_p705_4_Checkbox.isChecked()) c7_p705_4 = 1; else c7_p705_4 = 0;
        if (c7_p705_5_Checkbox.isChecked()) c7_p705_5 = 1; else c7_p705_5 = 0;
        if (c7_p705_6_Checkbox.isChecked()) c7_p705_6 = 1; else c7_p705_6 = 0;
        if (c7_p705_7_Checkbox.isChecked()) c7_p705_7 = 1; else c7_p705_7 = 0;
        c7_p705_o = c7_p705_o_EditText.getText().toString();

    }


    public boolean validarDatos(){
        if (c7_p701 <1){
            mostrarMensaje("PREGUNTA 701: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if (c7_p702_1==0 && c7_p702_2==0 && c7_p702_3==0 && c7_p702_4==0 && c7_p702_5==0 && c7_p702_6==0
                && c7_p702_7==0 && c7_p702_8==0 && c7_p702_9==0 && c7_p702_10==0){
            mostrarMensaje("PREGUNTA 702: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if (c7_p702_10==1){
            if (c7_p702_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 702 - OPCION 10: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if (c7_p703 < 1){
            mostrarMensaje("PREGUNTA 703: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if (c7_p704_1==0 && c7_p704_2==0 && c7_p704_3==0 && c7_p704_4==0 && c7_p704_5==0 && c7_p704_6==0){
            mostrarMensaje("PREGUNTA 704: DEBE SELECCIONAR ALGUNA OPCION");
        }
        if (c7_p704_6==1){
            if (c7_p704_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 704 - OPCION 6: DEBE ESPECIFICAR OTRO");
                return false;
            }
        }
        if (c7_p705_1==0 && c7_p705_2==0 && c7_p705_3==0 && c7_p705_4==0 && c7_p705_5==0 && c7_p705_6==0
                && c7_p705_7==0){
            mostrarMensaje("PREGUNTA 705: DEBE SELECCIONAR ALGUNA OPCION");
            return false;
        }
        if (c7_p705_6==1){
            if (c7_p705_o.trim().length()==0){
                mostrarMensaje("PREGUNTA 705 - OPCION 6: DEBE ESPECIFICAR OTRO");
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

}
