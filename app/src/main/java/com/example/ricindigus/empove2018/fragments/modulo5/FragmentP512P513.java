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
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP512P513 extends FragmentPagina {
    String idVivienda, idHogar, idPersona, idInformante;
    Context context;

    RadioGroup c5_p512_RadioGroup, c5_p513_RadioGroup;
    EditText c5_p512_o_EditText, c5_p513_o_EditText;
    LinearLayout m5_p512_linearlayout, m5_p513_linearlayout;
    private int c5_p512;
    private String c5_p512_o;
    private int c5_p513;
    private String c5_p513_o;

    @SuppressLint("ValidFragment")
    public FragmentP512P513(String idVivienda, String idHogar, String idPersona, String idInformante, Context context) {
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idPersona = idPersona;
        this.idInformante = idInformante;
        this.context = context;
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
        c5_p512 = c5_p512_RadioGroup.indexOfChild(c5_p512_RadioGroup.findViewById(c5_p512_RadioGroup.getCheckedRadioButtonId()));
        c5_p512_o = c5_p512_o_EditText.getText().toString();
        c5_p513 = c5_p513_RadioGroup.indexOfChild(c5_p513_RadioGroup.findViewById(c5_p513_RadioGroup.getCheckedRadioButtonId()));
        c5_p513_o = c5_p513_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(m5_p512_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p512<1){
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
            if(c5_p513<1){
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
