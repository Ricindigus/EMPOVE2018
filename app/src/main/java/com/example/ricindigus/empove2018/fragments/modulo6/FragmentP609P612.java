package com.example.ricindigus.empove2018.fragments.modulo6;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class FragmentP609P612 extends FragmentPagina {
    String idVivienda, idHogar, idPersona, idInformante;
    Context context;

    RadioGroup c6_p609_RadioGroup;
    EditText c6_p610_pd_EditText, c6_p610_pl_EditText, c6_p610_pm_EditText, c6_p610_pmi_EditText,
            c6_p610_pj_EditText, c6_p610_pv_EditText, c6_p610_ps_EditText,
            c6_p610_sd_EditText, c6_p610_sl_EditText, c6_p610_sm_EditText, c6_p610_smi_EditText,
            c6_p610_sj_EditText, c6_p610_sv_EditText, c6_p610_ss_EditText, c6_p610_t_EditText;
    EditText c6_p611_EditText;
    RadioGroup c6_p612_RadioGroup;
    EditText c6_p612_nro_EditText;
    LinearLayout m6_p609_linearlayout, m6_p610_linearlayout, m6_p611_linearlayout, m6_p612_linearlayout;

    private int c6_p609;
    private String c6_p610_pd;
    private String c6_p610_pl;
    private String c6_p610_pm;
    private String c6_p610_pmi;
    private String c6_p610_pj;
    private String c6_p610_pv;
    private String c6_p610_ps;
    private String c6_p610_pt;
    private String c6_p610_sd;
    private String c6_p610_sl;
    private String c6_p610_sm;
    private String c6_p610_smi;
    private String c6_p610_sj;
    private String c6_p610_sv;
    private String c6_p610_ss;
    private String c6_p610_st;
    private String c6_p610_t;
    private String c6_p611;
    private int c6_p612;
    private String c6_p612_nro;

    @SuppressLint("ValidFragment")
    public FragmentP609P612(String idVivienda, String idHogar, String idPersona, String idInformante, Context context) {
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idPersona = idPersona;
        this.idInformante = idInformante;
        this.context = context;
    }

    public FragmentP609P612() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p609_p612, container, false);

        c6_p609_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_609_radiogroup_C6_P609);

        c6_p610_pd_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PD);
        c6_p610_pl_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PL);
        c6_p610_pm_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PM);
        c6_p610_pmi_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PMI);
        c6_p610_pj_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PJ);
        c6_p610_pv_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PV);
        c6_p610_ps_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_PS);

        c6_p610_sd_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SD);
        c6_p610_sl_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SL);
        c6_p610_sm_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SM);
        c6_p610_smi_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SMI);
        c6_p610_sj_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SJ);
        c6_p610_sv_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SV);
        c6_p610_ss_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_SS);

        c6_p610_t_EditText = (EditText) rootView.findViewById(R.id.mod6_610_edittext_C6_P610_T);

        c6_p611_EditText = (EditText) rootView.findViewById(R.id.mod6_611_edittext_C6_P611);

        c6_p612_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_612_radiogroup_C6_P612);

        c6_p612_nro_EditText = (EditText) rootView.findViewById(R.id.mod6_612_edittext_C6_P612_NRO);

        m6_p609_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p609);
        m6_p610_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p610);
        m6_p611_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p611);
        m6_p612_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p612);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c6_p610_pd_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_pd_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_pl_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_pl_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_pm_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_pm_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_pmi_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_pmi_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_pj_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_pj_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_pv_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_pv_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_ps_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_ps_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });

        c6_p610_sd_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_sd_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_sl_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_sl_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_sm_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_sm_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_smi_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_smi_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_sj_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_sj_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_sv_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_sv_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p610_ss_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_ss_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });

        c6_p610_t_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p610_t_EditText);
                    m6_p610_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });

        c6_p611_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p611_EditText);
                    m6_p611_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });

        c6_p612_nro_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p612_nro_EditText);
                    m6_p611_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });

        c6_p610_pd_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_pl_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_pm_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_pmi_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_pj_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_pv_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_ps_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        c6_p610_sd_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_sl_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_sm_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_smi_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_sj_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_sv_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c6_p610_ss_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        c6_p610_t_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        c6_p611_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        c6_p612_nro_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p609,c6_p609+"");
        contentValues.put(SQLConstantes.modulo6_c6_p610_pd,c6_p610_pd);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pl,c6_p610_pl);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pm,c6_p610_pm);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pmi,c6_p610_pmi);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pj,c6_p610_pj);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pv,c6_p610_pv);
        contentValues.put(SQLConstantes.modulo6_c6_p610_ps,c6_p610_ps);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pt,c6_p610_pt);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sd,c6_p610_sd);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sl,c6_p610_sl);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sm,c6_p610_sm);
        contentValues.put(SQLConstantes.modulo6_c6_p610_smi,c6_p610_smi);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sj,c6_p610_sj);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sv,c6_p610_sv);
        contentValues.put(SQLConstantes.modulo6_c6_p610_ss,c6_p610_ss);
        contentValues.put(SQLConstantes.modulo6_c6_p610_st,c6_p610_st);
        contentValues.put(SQLConstantes.modulo6_c6_p610_t,c6_p610_t);
        contentValues.put(SQLConstantes.modulo6_c6_p611,c6_p611);
        contentValues.put(SQLConstantes.modulo6_c6_p612,c6_p612+"");
        contentValues.put(SQLConstantes.modulo6_c6_p612_nro,c6_p612_nro);

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
        c6_p609 = c6_p609_RadioGroup.indexOfChild(c6_p609_RadioGroup.findViewById(c6_p609_RadioGroup.getCheckedRadioButtonId()));
        c6_p610_pd = c6_p610_pd_EditText.getText().toString();
        c6_p610_pl = c6_p610_pl_EditText.getText().toString();
        c6_p610_pm = c6_p610_pm_EditText.getText().toString();
        c6_p610_pmi = c6_p610_pmi_EditText.getText().toString();
        c6_p610_pj = c6_p610_pj_EditText.getText().toString();
        c6_p610_pv = c6_p610_pv_EditText.getText().toString();
        c6_p610_ps = c6_p610_ps_EditText.getText().toString();
        c6_p610_sd = c6_p610_sd_EditText.getText().toString();
        c6_p610_sl = c6_p610_sl_EditText.getText().toString();
        c6_p610_sm = c6_p610_sm_EditText.getText().toString();
        c6_p610_smi = c6_p610_smi_EditText.getText().toString();
        c6_p610_sj = c6_p610_sj_EditText.getText().toString();
        c6_p610_sv = c6_p610_sv_EditText.getText().toString();
        c6_p610_ss = c6_p610_ss_EditText.getText().toString();
        c6_p610_t = c6_p610_t_EditText.getText().toString();
        c6_p611 = c6_p611_EditText.getText().toString();
        c6_p612 = c6_p612_RadioGroup.indexOfChild(c6_p612_RadioGroup.findViewById(c6_p612_RadioGroup.getCheckedRadioButtonId()));
        c6_p612_nro = c6_p612_nro_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(c6_p609<1 && m6_p609_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 609: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(m6_p610_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p610_pd.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 PRINCIPAL - DOMINGO: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_pl.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 PRINCIPAL - LUNES: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_pm.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 PRINCIPAL - MARTES: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_pmi.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 PRINCIPAL - MIERCOLES: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_pj.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 PRINCIPAL - JUEVES: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_pv.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 PRINCIPAL - VIERENS: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_ps.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 PRINCIPAL - SABADO: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_sd.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 SECUNDARIA - DOMINGO: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_sl.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 SECUNDARIA - LUNES: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_sm.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 SECUNDARIA - MARTES: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_smi.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 SECUNDARIA - MIERCOLES: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_sj.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 SECUNDARIA - JUEVES: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_sv.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 SECUNDARIA - VIERENS: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
            if(c6_p610_ss.trim().length()==0){
                mostrarMensaje("PREGUNTA 610 SECUNDARIA - SABADO: DEBE INGRESAR HORAS TRABAJADAS");
                return false;
            }
        }
        if(c6_p611.trim().length()==0 && m6_p611_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 611: DEBE INGRESAR HORAS TRABAJADAS EN LA SEMANA");
            return false;
        }
        if(m6_p612_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p612<1){
                mostrarMensaje("PREGUNTA 612: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p612==1){
                if(c6_p612_nro.trim().length()==0){
                    mostrarMensaje("PREGUNTA 612 - OPCION 1: NRO DE PERSONAS");
                    return false;
                }
            }
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
