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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP512P513 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c5_p512_RadioGroup, c5_p513_RadioGroup;
    EditText c5_p512_o_EditText, c5_p513_o_EditText;
    LinearLayout m5_p512_linearlayout, m5_p513_linearlayout;
    private int c5_p512;
    private String c5_p512_o;
    private int c5_p513;
    private String c5_p513_o;

    private int edad, sexo;

    @SuppressLint("ValidFragment")
    public FragmentP512P513(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idHogar = residente.getId_hogar();
        idVivienda = residente.getId_vivienda();
        idInformante = "";
        if(residente.getC2_p204()=="") sexo = -1; else sexo = Integer.parseInt(residente.getC2_p204());
        if(residente.getC2_p205_a()=="") edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
        data.close();
    }

    public FragmentP512P513() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p512_p513, container, false);
        c5_p512_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_512_radiogroup_C5_P512);
        c5_p512_o_EditText = (EditText) rootView.findViewById(R.id.mod5_512_edittext_C5_P512_O);
        c5_p513_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_513_radiogroup_C5_P513);
        c5_p513_o_EditText = (EditText) rootView.findViewById(R.id.mod5_513_edittext_C5_P513_O);

        m5_p512_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p512);
        m5_p513_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p513);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c5_p512_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c5_p512_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p512_o_EditText);
                    m5_p512_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c5_p513_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c5_p513_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c5_p513_o_EditText);
                    m5_p513_linearlayout.requestFocus();
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
        contentValues.put(SQLConstantes.modulo5_c5_p512,c5_p512+"");
        contentValues.put(SQLConstantes.modulo5_c5_p512_o,c5_p512_o);
        contentValues.put(SQLConstantes.modulo5_c5_p513,c5_p513+"");
        contentValues.put(SQLConstantes.modulo5_c5_p513_o,c5_p513_o);

        if(data.existeElemento(getNombreTabla(),idEncuestado)){
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        }else{
            Modulo5 modulo5 = new Modulo5();
            modulo5.setIdInformante(idInformante);
            modulo5.set_id(idEncuestado);
            modulo5.setIdVivienda(idVivienda);
            modulo5.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo5.toValues());
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        c5_p512 = c5_p512_RadioGroup.indexOfChild(c5_p512_RadioGroup.findViewById(c5_p512_RadioGroup.getCheckedRadioButtonId()));
        c5_p512_o = c5_p512_o_EditText.getText().toString();
        c5_p513 = c5_p513_RadioGroup.indexOfChild(c5_p513_RadioGroup.findViewById(c5_p513_RadioGroup.getCheckedRadioButtonId()));
        c5_p513_o = c5_p513_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo5 modulo5 = data.getModulo5(idEncuestado);
            if(!(modulo5.getC5_p512().equals("-1") || modulo5.getC5_p512().equals("")))((RadioButton)c5_p512_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p512()))).setChecked(true);
            c5_p512_o_EditText.setText(modulo5.getC5_p512_o());
            if(!(modulo5.getC5_p513().equals("-1") || modulo5.getC5_p513().equals("")))((RadioButton)c5_p513_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p513()))).setChecked(true);
            c5_p513_o_EditText.setText(modulo5.getC5_p513_o());
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        if(m5_p512_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p512<0){
                mostrarMensaje("PREGUNTA 512: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c5_p512==6){
                if(c5_p512_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 512 - OPCION 6: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(m5_p513_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p513<0){
                mostrarMensaje("PREGUNTA 513: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c5_p513==7){
                if(c5_p513_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 513 - OPCION 7: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
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
