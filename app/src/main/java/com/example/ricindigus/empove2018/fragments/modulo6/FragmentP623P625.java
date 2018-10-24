package com.example.ricindigus.empove2018.fragments.modulo6;


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
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP623P625 extends FragmentPagina {
    String idVivienda, idHogar, idPersona, idInformante;
    Context context;

    RadioGroup c6_p623_RadioGroup;
    EditText c6_p623_o_EditText;
    RadioGroup c6_p624_RadioGroup;
    EditText c6_p624_o_EditText;
    EditText c6_p625_EditText;
    LinearLayout m6_p623_linearlayout, m6_p624_linearlayout, m6_p625_linearlayout;

    private int c6_p623;
    private String c6_p623_o;
    private int c6_p624;
    private String c6_p624_o;
    private String c6_p625;

    @SuppressLint("ValidFragment")
    public FragmentP623P625(String idVivienda, String idHogar, String idPersona, String idInformante, Context context) {
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idPersona = idPersona;
        this.idInformante = idInformante;
        this.context = context;
    }

    public FragmentP623P625() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p623_p625, container, false);

        c6_p623_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_623_radiogroup_C6_P623);
        c6_p623_o_EditText = (EditText) rootView.findViewById(R.id.mod6_623_edittext_C6_P623_O);
        c6_p624_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_624_radiogroup_C6_P624);
        c6_p624_o_EditText = (EditText) rootView.findViewById(R.id.mod6_624_edittext_C6_P624_O);
        c6_p625_EditText = (EditText) rootView.findViewById(R.id.mod6_625_edittext_C6_P625);

        m6_p623_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p623);
        m6_p624_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p624);
        m6_p625_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p625);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c6_p623_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p623_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p623_o_EditText);
                    m6_p623_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p624_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p624_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p624_o_EditText);
                    m6_p624_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p625_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p625_EditText);
                    m6_p625_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p625_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p623,c6_p623+"");
        contentValues.put(SQLConstantes.modulo6_c6_p623_o,c6_p623_o);
        contentValues.put(SQLConstantes.modulo6_c6_p624,c6_p624+"");
        contentValues.put(SQLConstantes.modulo6_c6_p624_o,c6_p624_o);
        contentValues.put(SQLConstantes.modulo6_c6_p625,c6_p625);

        if(data.existeElemento(getNombreTabla(),idPersona)){
            data.actualizarElemento(getNombreTabla(),contentValues,idPersona);
        }else{
            contentValues.put(SQLConstantes.modulo6_idVivienda,idVivienda+"");
            contentValues.put(SQLConstantes.modulo6_idHogar,idHogar+"");
            contentValues.put(SQLConstantes.modulo6_id,idPersona+"");
            contentValues.put(SQLConstantes.modulo6_idInformante,idInformante+"");
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        c6_p623 = c6_p623_RadioGroup.indexOfChild(c6_p623_RadioGroup.findViewById(c6_p623_RadioGroup.getCheckedRadioButtonId()));
        c6_p623_o = c6_p623_o_EditText.getText().toString();
        c6_p624 = c6_p624_RadioGroup.indexOfChild(c6_p624_RadioGroup.findViewById(c6_p624_RadioGroup.getCheckedRadioButtonId()));
        c6_p624_o = c6_p624_o_EditText.getText().toString();
        c6_p625 = c6_p625_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(m6_p623_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p623<1){
                mostrarMensaje("PREGUNTA 623: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p623==9){
                if(c6_p623_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 623 - OPCION 9: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(m6_p624_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p624<1){
                mostrarMensaje("PREGUNTA 624: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p624==6){
                if(c6_p624_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 624 - OPCION 6: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c6_p625.trim().length()==0 && m6_p625_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 625: DEBE INGRESAR NRO DE SEMANAS");
            return false;
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo6;
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
