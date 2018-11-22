package com.example.ricindigus.empove2018.fragments.modulo6;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.text.TextWatcher;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterMinMax;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP609P612 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    Context context;
    Spinner informanteSpinner;

    TextView c6_p610_TextView;

    RadioGroup c6_p609_RadioGroup;
    EditText c6_p610_pd_EditText, c6_p610_pl_EditText, c6_p610_pm_EditText, c6_p610_pmi_EditText,
            c6_p610_pj_EditText, c6_p610_pv_EditText, c6_p610_ps_EditText,
            c6_p610_sd_EditText, c6_p610_sl_EditText, c6_p610_sm_EditText, c6_p610_smi_EditText,
            c6_p610_sj_EditText, c6_p610_sv_EditText, c6_p610_ss_EditText;
    TextView c6_p610_t_TextView;
    EditText c6_p611_EditText;
    RadioGroup c6_p612_RadioGroup;
    EditText c6_p612_nro_EditText;
    LinearLayout m6_p609_linearlayout, m6_p610_linearlayout, m6_p611_linearlayout, m6_p612_linearlayout;

    private String c6_p609;
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
    private String c6_p612;
    private String c6_p612_nro;

    private int p610_pd=0;
    private int p610_pl=0;
    private int p610_pm=0;
    private int p610_pmi=0;
    private int p610_pj=0;
    private int p610_pv=0;
    private int p610_ps=0;
    private int p610_pt=0;
    private int p610_sd=0;
    private int p610_sl=0;
    private int p610_sm=0;
    private int p610_smi=0;
    private int p610_sj=0;
    private int p610_sv=0;
    private int p610_ss=0;
    private int p610_st=0;
    private int p610_t=0;


    @SuppressLint("ValidFragment")
    public FragmentP609P612(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
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
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c6_p609_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_609_radiogroup_C6_P609);

        c6_p610_TextView = (TextView) rootView.findViewById(R.id.mod6_601_textview_C6_P610);
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

        c6_p610_t_TextView = (TextView) rootView.findViewById(R.id.mod6_610_textview_C6_P610_T);

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

        configurarEditText(c6_p610_pd_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_pl_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_pm_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_pmi_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_pj_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_pv_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_ps_EditText,m6_p610_linearlayout,3,2);

        configurarEditText(c6_p610_sd_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_sl_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_sm_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_smi_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_sj_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_sv_EditText,m6_p610_linearlayout,3,2);
        configurarEditText(c6_p610_ss_EditText,m6_p610_linearlayout,3,2);


        configurarEditText(c6_p611_EditText,m6_p611_linearlayout,2,3);
        configurarEditText(c6_p612_nro_EditText,m6_p612_linearlayout,2,2);


        configurarTextWatcher(c6_p610_pd_EditText);
        configurarTextWatcher(c6_p610_pl_EditText);
        configurarTextWatcher(c6_p610_pm_EditText);
        configurarTextWatcher(c6_p610_pmi_EditText);
        configurarTextWatcher(c6_p610_pj_EditText);
        configurarTextWatcher(c6_p610_pv_EditText);
        configurarTextWatcher(c6_p610_ps_EditText);
        configurarTextWatcher(c6_p610_sd_EditText);
        configurarTextWatcher(c6_p610_sl_EditText);
        configurarTextWatcher(c6_p610_sm_EditText);
        configurarTextWatcher(c6_p610_smi_EditText);
        configurarTextWatcher(c6_p610_sj_EditText);
        configurarTextWatcher(c6_p610_sv_EditText);
        configurarTextWatcher(c6_p610_ss_EditText);

        c6_p612_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group,checkedId,1,c6_p612_nro_EditText);
            }
        });
        fecha();
        llenarVista();
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo6_c6_p609,c6_p609);
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
        contentValues.put(SQLConstantes.modulo6_c6_p612,c6_p612);
        contentValues.put(SQLConstantes.modulo6_c6_p612_nro,c6_p612_nro);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        //Ya valido y guardo correctamente el fragment, ahora actualizamos el valor de la cobertura del fragment a correcto(1)
        data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp609p612,"1",idEncuestado);
        //verificamos la cobertura del capitulo y actualizamos su valor de cobertura.
        if (verificarCoberturaCapitulo()) data.actualizarValor(getNombreTabla(),SQLConstantes.modulo6_COB600,"1",idEncuestado);
        else data.actualizarValor(getNombreTabla(),SQLConstantes.modulo6_COB600,"0",idEncuestado);
        data.actualizarValor(SQLConstantes.tablaresidentes,SQLConstantes.residentes_encuestado_cobertura,"0",idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition() + "";
        c6_p609 = c6_p609_RadioGroup.indexOfChild(c6_p609_RadioGroup.findViewById(c6_p609_RadioGroup.getCheckedRadioButtonId()))+"";
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
        c6_p610_t = c6_p610_t_TextView.getText().toString();
        c6_p611 = c6_p611_EditText.getText().toString();
        c6_p612 = c6_p612_RadioGroup.indexOfChild(c6_p612_RadioGroup.findViewById(c6_p612_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p612_nro = c6_p612_nro_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = data.getModulo6(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo6.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            if(!modulo6.getIdInformante().equals(""))informanteSpinner.setSelection(Integer.parseInt(modulo6.getIdInformante()));
            if(!modulo6.getC6_p609().equals("-1") && !modulo6.getC6_p609().equals(""))((RadioButton)c6_p609_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p609()))).setChecked(true);
            c6_p610_pd_EditText.setText(modulo6.getC6_p610_pd());
            c6_p610_pl_EditText.setText(modulo6.getC6_p610_pl());
            c6_p610_pm_EditText.setText(modulo6.getC6_p610_pm());
            c6_p610_pmi_EditText.setText(modulo6.getC6_p610_pmi());
            c6_p610_pj_EditText.setText(modulo6.getC6_p610_pj());
            c6_p610_pv_EditText.setText(modulo6.getC6_p610_pv());
            c6_p610_ps_EditText.setText(modulo6.getC6_p610_ps());
            c6_p610_sd_EditText.setText(modulo6.getC6_p610_sd());
            c6_p610_sl_EditText.setText(modulo6.getC6_p610_sl());
            c6_p610_sm_EditText.setText(modulo6.getC6_p610_sm());
            c6_p610_smi_EditText.setText(modulo6.getC6_p610_smi());
            c6_p610_sj_EditText.setText(modulo6.getC6_p610_sj());
            c6_p610_sv_EditText.setText(modulo6.getC6_p610_sv());
            c6_p610_ss_EditText.setText(modulo6.getC6_p610_ss());
            c6_p611_EditText.setText(modulo6.getC6_p611());
            if(!modulo6.getC6_p612().equals("-1") && !modulo6.getC6_p612().equals(""))((RadioButton)c6_p612_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p612()))).setChecked(true);
            c6_p612_nro_EditText.setText(modulo6.getC6_p612_nro());
        }
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p609,idEncuestado)) m6_p609_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p610,idEncuestado)) m6_p610_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p611,idEncuestado)) m6_p611_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p612,idEncuestado)) m6_p612_linearlayout.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if (m6_p609_linearlayout.getVisibility() == View.VISIBLE){
            if(c6_p609.equals("-1")){ mostrarMensaje("PREGUNTA 609: DEBE SELECCIONAR UNA OPCION");return false; }
        }

        if(c6_p610_pd.trim().equals("")){ mostrarMensaje("PREGUNTA 610 PRINCIPAL - DOMINGO: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_pl.trim().equals("")){ mostrarMensaje("PREGUNTA 610 PRINCIPAL - LUNES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_pm.trim().equals("")){ mostrarMensaje("PREGUNTA 610 PRINCIPAL - MARTES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_pmi.trim().equals("")){ mostrarMensaje("PREGUNTA 610 PRINCIPAL - MIERCOLES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_pj.trim().equals("")){ mostrarMensaje("PREGUNTA 610 PRINCIPAL - JUEVES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_pv.trim().equals("")){ mostrarMensaje("PREGUNTA 610 PRINCIPAL - VIERNES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_ps.trim().equals("")){ mostrarMensaje("PREGUNTA 610 PRINCIPAL - SABADO: DEBE INGRESAR HORAS TRABAJADAS");return false; }

        if(c6_p610_sd.trim().equals("")){ mostrarMensaje("PREGUNTA 610 SECUNDARIA - DOMINGO: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_sl.trim().equals("")){ mostrarMensaje("PREGUNTA 610 SECUNDARIA - LUNES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_sm.trim().equals("")){ mostrarMensaje("PREGUNTA 610 SECUNDARIA - MARTES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_smi.trim().equals("")){ mostrarMensaje("PREGUNTA 610 SECUNDARIA - MIERCOLES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_sj.trim().equals("")){ mostrarMensaje("PREGUNTA 610 SECUNDARIA - JUEVES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_sv.trim().equals("")){ mostrarMensaje("PREGUNTA 610 SECUNDARIA - VIERNES: DEBE INGRESAR HORAS TRABAJADAS");return false; }
        if(c6_p610_ss.trim().equals("")){ mostrarMensaje("PREGUNTA 610 SECUNDARIA - SABADO: DEBE INGRESAR HORAS TRABAJADAS");return false; }

        if(c6_p611.trim().equals("")){ mostrarMensaje("PREGUNTA 611: Nº DE HORAS");return false;}
        if(c6_p612.equals("-1")){ mostrarMensaje("PREGUNTA 612: DEBE SELECCIONAR UNA OPCION");return false; }
        if(c6_p612.equals("1")){
            if(c6_p612_nro.trim().equals("")){ mostrarMensaje("PREGUNTA 612 - OPCION 1: NRO DE PERSONAS");return false;}
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

    public String NombreMes(int mes){
        String nom_mes="";
        switch(mes){
            case 0: nom_mes="ENERO"; break;
            case 1: nom_mes="FEBRERO"; break;
            case 2: nom_mes="MARZO"; break;
            case 3: nom_mes="ABRIL"; break;
            case 4: nom_mes="MAYO"; break;
            case 5: nom_mes="JUNIO"; break;
            case 6: nom_mes="JULIO"; break;
            case 7: nom_mes="AGOSTO"; break;
            case 8: nom_mes="SETIEMBRE"; break;
            case 9: nom_mes="OCTUBRE"; break;
            case 10: nom_mes="NOVIEMBRE"; break;
            case 11: nom_mes="DICIEMBRE"; break;
        }
        return nom_mes;
    }
    public void fecha(){
        Calendar calendario;
        int mm=0, dd=0;
        String fecha_inicial="", fecha_final="";
        calendario = Calendar.getInstance();
        mm = calendario.get(Calendar.MONTH);
        dd = calendario.get(Calendar.DAY_OF_MONTH);
        fecha_final = "" + dd + " DE " + NombreMes(mm);
        calendario.add(Calendar.DAY_OF_MONTH,-7);
        mm = calendario.get(Calendar.MONTH);
        dd = calendario.get(Calendar.DAY_OF_MONTH);
        fecha_inicial = "" + dd + " DE " + NombreMes(mm);
        String enunciado_p610 = c6_p610_TextView.getText()+"";
        enunciado_p610 = enunciado_p610.replace("FECHAINI", fecha_inicial);
        enunciado_p610 = enunciado_p610.replace("FECHAFIN", fecha_final);
        c6_p610_TextView.setText(enunciado_p610);
    }

    public boolean rango(int ini, int fin, String numero){
        if(Integer.parseInt(numero)>=ini && Integer.parseInt(numero)<=fin) return true; else return false;
    }

    public void configurarTextWatcher(EditText editText){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().equals("")){
                    c6_p610_t_TextView.setText((Integer.parseInt(c6_p610_t_TextView.getText().toString()) - Integer.parseInt(charSequence.toString()))+"");
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int despues = 0;
                if(!editable.toString().equals("")) despues = Integer.parseInt(editable.toString());
                if(!(Integer.parseInt(c6_p610_t_TextView.getText().toString())== 0)){
                    c6_p610_t_TextView.setText((Integer.parseInt(c6_p610_t_TextView.getText().toString()) + despues) +"");
                }else{
                    c6_p610_t_TextView.setText(despues+"");
                }
            }
        });
    }

    private void controlarEspecifiqueRadio(RadioGroup group, int checkedId, int opcionEsp, EditText editTextEspecifique) {
        int seleccionado = group.indexOfChild(group.findViewById(checkedId));
        if(seleccionado == opcionEsp){
            editTextEspecifique.setBackgroundResource(R.drawable.input_text_enabled);
            editTextEspecifique.setEnabled(true);
        }else{
            editTextEspecifique.setText("");
            editTextEspecifique.setBackgroundResource(R.drawable.input_text_disabled);
            editTextEspecifique.setEnabled(false);
        }
    }

    private void configurarEditText(final EditText editText, final View view, int tipo,int longitud){
        if (tipo == 1) editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud)});

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(editText);
                    view.requestFocus();
                    return true;
                }
                return false;
            }
        });
        if (tipo == 2) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(longitud)});
            editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
//            editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(longitud)});
//            editText.setInputType(18);
//            editText.setTransformationMethod(null);
        }

        if (tipo == 3){
            editText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "23")});
            editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        }
    }

    public void controlarChecked(CheckBox checkBox, final EditText editText){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    editText.setBackgroundResource(R.drawable.input_text_enabled);
                    editText.setEnabled(true);
                }else{
                    editText.setText("");
                    editText.setBackgroundResource(R.drawable.input_text_disabled);
                    editText.setEnabled(false);
                }
            }
        });
    }

    public boolean verificarCoberturaCapitulo(){
        Data data = new Data(context);
        data.open();
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p601p604,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp601p604,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp605p608,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp609p612,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p617,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp613p617,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p618p621,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp618p621,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp622p625,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p626p629,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp626p629,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p630,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp630,idEncuestado).equals("0")) return false;
        data.close();
        return true;
    }
}