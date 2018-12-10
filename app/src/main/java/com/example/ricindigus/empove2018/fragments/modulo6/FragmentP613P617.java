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
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.Ubigeo;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP613P617 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante, id_informante="";
    Context context;

    Spinner informanteSpinner;
    AutoCompleteTextView autoCompleteTextView;
    RadioGroup c6_p613_RadioGroup;
    TextView c6_p614_TextView;
    EditText c6_p614_mon_EditText, c6_p614_esp_EditText, c6_p615_mon_EditText, c6_p615_esp_EditText,
            c6_p616_mon_EditText, c6_p616_esp_EditText;
    CheckBox c6_p616_nas_Checkbox;
    RadioGroup c6_p617_RadioGroup;
    TextView c6_p617_dist_TextView, c6_p617_prov_TextView, c6_p617_dep_TextView;
    LinearLayout m6_p613_linearlayout, m6_p614_linearlayout, m6_p615_linearlayout, m6_p616_linearlayout,
            m6_p617_linearlayout,m6_p617_linearlayout_subpregunta;

    private int c6_p610_tot_sec=0;

    private String c6_p613;
    private String c6_p614_mon;
    private String c6_p614_esp;
    private String c6_p615_mon;
    private String c6_p615_esp;
    private String c6_p616_mon;
    private String c6_p616_esp;
    private String c6_p616_nas;
    private String c6_p617;
    private String c6_p617_dist;
    private String c6_p617_prov;
    private String c6_p617_dep;

    int edad=0;

    @SuppressLint("ValidFragment")
    public FragmentP613P617(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idHogar = residente.getId_hogar();
        idVivienda = residente.getId_vivienda();
        idInformante = "";
        if(residente.getC2_p205_a().equals("")) edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
        data.close();
    }

    public FragmentP613P617() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p613_p617, container, false);

        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);


        autoCompleteTextView = (AutoCompleteTextView) rootView.findViewById(R.id.mod6_617_autocompletetextview);
        c6_p613_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_613_radiogroup_C6_P613);
        c6_p614_TextView = (TextView) rootView.findViewById(R.id.mod6_614_TextView_C6_P614);
        c6_p614_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_614_edittext_C6_P614_MON);
        c6_p614_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_614_edittext_C6_P614_ESP);
        c6_p615_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_615_edittext_C6_P615_MON);
        c6_p615_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_615_edittext_C6_P615_ESP);
        c6_p616_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_616_edittext_C6_P616_MON);
        c6_p616_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_616_edittext_C6_P616_ESP);
        c6_p616_nas_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_616_checkbox_C6_P616_NAS);
        c6_p617_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_617_radiogroup_C6_P617);

        c6_p617_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_617_radiogroup_C6_P617);
        c6_p617_dist_TextView = (TextView) rootView.findViewById(R.id.mod6_c617_txtDistrito);
        c6_p617_prov_TextView = (TextView) rootView.findViewById(R.id.mod6_c617_txtProvincia);
        c6_p617_dep_TextView = (TextView) rootView.findViewById(R.id.mod6_c617_txtDepartamento);

        m6_p613_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p613);
        m6_p614_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p614);
        m6_p615_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p615);
        m6_p616_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p616);
        m6_p617_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p617);
        m6_p617_linearlayout_subpregunta = (LinearLayout) rootView.findViewById(R.id.mod6_617_layout_subpregunta);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c6_p613_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                String tiempo =  "614.EN SU OCUPACION PRINCIPAL ¿CUÁNTO FUE SU INGRESO TOTAL SIN DESCUENTOS EN EL TIEMPO ANTERIOR, INCLUYENDO HORAS EXTRAS, BONIFICACIONES, PAGO POR CONCEPTO DE REFRIGERIO, MOVILIDAD, COMISIONES, ETC.?";
                int pos = radioGroup.indexOfChild(c6_p613_RadioGroup.findViewById(c6_p613_RadioGroup.getCheckedRadioButtonId()));
                switch(pos){
                    case 1:
                        tiempo = "614.EN SU OCUPACION PRINCIPAL ¿CUÁNTO FUE SU INGRESO TOTAL SIN DESCUENTOS EN EL DÍA ANTERIOR, INCLUYENDO HORAS EXTRAS, BONIFICACIONES, PAGO POR CONCEPTO DE REFRIGERIO, MOVILIDAD, COMISIONES, ETC.?";break;
                    case 2:
                        tiempo = "614.EN SU OCUPACION PRINCIPAL ¿CUÁNTO FUE SU INGRESO TOTAL SIN DESCUENTOS EN LA SEMANA ANTERIOR, INCLUYENDO HORAS EXTRAS, BONIFICACIONES, PAGO POR CONCEPTO DE REFRIGERIO, MOVILIDAD, COMISIONES, ETC.?";break;
                    case 3:
                        tiempo = "614.EN SU OCUPACION PRINCIPAL ¿CUÁNTO FUE SU INGRESO TOTAL SIN DESCUENTOS EN LA QUINCENA ANTERIOR, INCLUYENDO HORAS EXTRAS, BONIFICACIONES, PAGO POR CONCEPTO DE REFRIGERIO, MOVILIDAD, COMISIONES, ETC.?";break;
                    case 4:
                        tiempo = "614.EN SU OCUPACION PRINCIPAL ¿CUÁNTO FUE SU INGRESO TOTAL SIN DESCUENTOS EN EL MES ANTERIOR, INCLUYENDO HORAS EXTRAS, BONIFICACIONES, PAGO POR CONCEPTO DE REFRIGERIO, MOVILIDAD, COMISIONES, ETC.?";break;
                }
                c6_p614_TextView.setText(tiempo);
            }
        });

        configurarEditText(c6_p614_esp_EditText,m6_p614_linearlayout,2,6);
        configurarEditText(c6_p614_mon_EditText,m6_p614_linearlayout,2,6);
        configurarEditText(c6_p615_esp_EditText,m6_p615_linearlayout,2,6);
        configurarEditText(c6_p615_mon_EditText,m6_p615_linearlayout,2,6);
        configurarEditText(c6_p616_esp_EditText,m6_p616_linearlayout,2,6);
        configurarEditText(c6_p616_mon_EditText,m6_p616_linearlayout,2,6);

        c6_p616_nas_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    limpiar_p616();
                    c6_p616_mon_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                    c6_p616_esp_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                    c6_p616_mon_EditText.setEnabled(false);
                    c6_p616_esp_EditText.setEnabled(false);
                }else{
                    c6_p616_mon_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                    c6_p616_esp_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                    c6_p616_mon_EditText.setEnabled(true);
                    c6_p616_esp_EditText.setEnabled(true);
                }
            }
        });

        c6_p617_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 1:
                        c6_p617_dep_TextView.setText("");c6_p617_prov_TextView.setText("");c6_p617_dist_TextView.setText("");
                        c6_p617_dep = ""; c6_p617_prov = ""; c6_p617_dist = "";
                        m6_p617_linearlayout_subpregunta.setVisibility(View.GONE);break;
                    case 2:m6_p617_linearlayout_subpregunta.setVisibility(View.VISIBLE);break;
                }
            }
        });

        Data data = new Data(context);
        data.open();
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(),R.layout.lista_item,R.id.item,data.getUbigeos());
        data.close();
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(autoCompleteTextView);
                    m6_p617_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Data data1 = new Data(context);
                data1.open();
                Ubigeo ubigeo = data1.getUbigeo(autoCompleteTextView.getText().toString());
                data1.close();
                c6_p617_dep_TextView.setText(ubigeo.getNom_departamento());
                c6_p617_prov_TextView.setText(ubigeo.getNom_provincia());
                c6_p617_dist_TextView.setText(ubigeo.getNom_distrito());
                c6_p617_dep = ubigeo.getCod_departamento();
                c6_p617_prov = ubigeo.getCod_provincia();
                c6_p617_dist = ubigeo.getCod_distrito();
                autoCompleteTextView.setText("");
                ocultarTeclado(autoCompleteTextView);
                m6_p617_linearlayout.requestFocus();
            }
        });

        llenarVista();
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_id_informante,idInformante);
        contentValues.put(SQLConstantes.modulo6_c6_p613,c6_p613);
        contentValues.put(SQLConstantes.modulo6_c6_p614_mon,c6_p614_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p614_esp,c6_p614_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p615_mon,c6_p615_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p615_esp,c6_p615_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p616_mon,c6_p616_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p616_esp,c6_p616_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p616_nas,c6_p616_nas);
        contentValues.put(SQLConstantes.modulo6_c6_p617,c6_p617);
        contentValues.put(SQLConstantes.modulo6_c6_p617_dist,c6_p617_dist);
        contentValues.put(SQLConstantes.modulo6_c6_p617_prov,c6_p617_prov);
        contentValues.put(SQLConstantes.modulo6_c6_p617_dep,c6_p617_dep);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        //Ya valido y guardo correctamente el fragment, ahora actualizamos el valor de la cobertura del fragment a correcto(1)
        data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp613p617,"1",idEncuestado);
        //verificamos la cobertura del capitulo y actualizamos su valor de cobertura.
        if (verificarCoberturaCapitulo()) data.actualizarValor(getNombreTabla(),SQLConstantes.modulo6_COB600,"1",idEncuestado);
        else data.actualizarValor(getNombreTabla(),SQLConstantes.modulo6_COB600,"0",idEncuestado);
        data.actualizarValor(SQLConstantes.tablaresidentes,SQLConstantes.residentes_encuestado_cobertura,"0",idEncuestado);
        data.close();
        verificar_Fragament618_621();
        verificar_Fragament622_625();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        String[] infor_id = (informanteSpinner.getItemAtPosition(informanteSpinner.getSelectedItemPosition()).toString()).split("-");
        id_informante = idHogar + "_" + infor_id[0];
        c6_p613 = c6_p613_RadioGroup.indexOfChild(c6_p613_RadioGroup.findViewById(c6_p613_RadioGroup.getCheckedRadioButtonId())) + "";
        c6_p614_mon = c6_p614_mon_EditText.getText().toString();
        c6_p614_esp = c6_p614_esp_EditText.getText().toString();
        c6_p615_mon = c6_p615_mon_EditText.getText().toString();
        c6_p615_esp = c6_p615_esp_EditText.getText().toString();
        c6_p616_mon = c6_p616_mon_EditText.getText().toString();
        c6_p616_esp = c6_p616_esp_EditText.getText().toString();
        if(c6_p616_nas_Checkbox.isChecked()) c6_p616_nas = "1"; else c6_p616_nas = "0";
        c6_p617 = c6_p617_RadioGroup.indexOfChild(c6_p617_RadioGroup.findViewById(c6_p617_RadioGroup.getCheckedRadioButtonId())) + "";
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
            if(!modulo6.getC6_p613().equals("-1") && !modulo6.getC6_p613().equals(""))((RadioButton)c6_p613_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p613()))).setChecked(true);
            c6_p614_mon_EditText.setText(modulo6.getC6_p614_mon());
            c6_p614_esp_EditText.setText(modulo6.getC6_p614_esp());
            c6_p615_mon_EditText.setText(modulo6.getC6_p615_mon());
            c6_p615_esp_EditText.setText(modulo6.getC6_p615_esp());
            c6_p610_tot_sec = modulo6.getC6_p610_total_horas_secundarias();
            c6_p616_mon_EditText.setText(modulo6.getC6_p616_mon());
            c6_p616_esp_EditText.setText(modulo6.getC6_p616_esp());
            if(modulo6.getC6_p616_nas().equals("1")) c6_p616_nas_Checkbox.setChecked(true);
            if(!modulo6.getC6_p617().equals("-1") && !modulo6.getC6_p617().equals(""))((RadioButton)c6_p617_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p617()))).setChecked(true);
            if(!modulo6.getC6_p617_dep().equals("")){
                String codUbigeo = modulo6.getC6_p617_dep()+modulo6.getC6_p617_prov()+modulo6.getC6_p617_dist();
                Ubigeo ubigeo = data.getUbigeoxId(codUbigeo);
                c6_p617_dep = ubigeo.getCod_departamento();
                c6_p617_prov = ubigeo.getCod_provincia();
                c6_p617_dist = ubigeo.getCod_distrito();
                c6_p617_dep_TextView.setText(ubigeo.getNom_departamento());
                c6_p617_prov_TextView.setText(ubigeo.getNom_provincia());
                c6_p617_dist_TextView.setText(ubigeo.getNom_distrito());
            }
        }
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p613,idEncuestado)) m6_p613_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p614,idEncuestado)) m6_p614_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p615,idEncuestado)) m6_p615_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p616,idEncuestado)) m6_p616_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p617,idEncuestado)) m6_p617_linearlayout.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if(!id_informante.equals(idEncuestado) && edad>=12){mostrarMensaje("NÚMERO INFORMANTE: NO ES EL MISMO QUE ESTA SIENDO ENTREVISTADO");return false;}
        if (m6_p613_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p613.equals("-1")){ mostrarMensaje("PREGUNTA 613: DEBE SELECCIONAR UNA OPCION");return false; }
        } else c6_p613 = "";

        if(m6_p614_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p614_mon.trim().equals("")){
                mostrarMensaje("PREGUNTA 614 - DINERO: DEBE ESPECIFICAR");
                return false;
            }
//            if(c6_p614_esp.trim().equals("")){
//                mostrarMensaje("PREGUNTA 614 - ESPECIE: DEBE ESPECIFICAR");
//                return false;
//            }
        }else{
            c6_p614_mon = "";c6_p614_esp = "";
        }

        if(m6_p615_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p615_mon.trim().equals("")){ mostrarMensaje("PREGUNTA 615 - DINERO: DEBE ESPECIFICAR");return false; }
//            if(c6_p615_esp.trim().equals("")){ mostrarMensaje("PREGUNTA 615 - ESPECIE: DEBE ESPECIFICAR");return false; }
        }else{
            c6_p615_mon = ""; c6_p615_esp = "";
        }

        if(m6_p616_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p616_nas.equals("0")){
                if(c6_p616_mon.trim().equals("")){ mostrarMensaje("PREGUNTA 616 - DINERO: DEBE ESPECIFICAR");return false; }
//                if(c6_p616_esp.trim().equals("")){ mostrarMensaje("PREGUNTA 616 - ESPECIE: DEBE ESPECIFICAR");return false; }
            }else{
                if(c6_p610_tot_sec>0){ mostrarMensaje("PREGUNTA 616: VERIFICAR PREGUNTA 610 HORAS TRABAJADAS ACTIVIDAD SECUNDARIA");return false; }
            }
        }else{ c6_p616_nas=""; c6_p616_mon = ""; c6_p616_esp ="";}

        if(m6_p617_linearlayout.getVisibility()==View.VISIBLE) {
            if(c6_p617.equals("-1")){ mostrarMensaje("PREGUNTA 617: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p617.equals("2")){
                if(c6_p617_dist.equals("")){ mostrarMensaje("PREGUNTA 617: DEBE INDICAR DISTRITO");return false; }
            }
        }else {c6_p617="";c6_p617_dist="";c6_p617_prov="";c6_p617_dep="";}
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

    public void limpiar_p616(){
        c6_p616_mon_EditText.setText("");
        c6_p616_esp_EditText.setText("");
    }

    public void limpiar_p617(){
        c6_p617_dist_TextView.setText("");
        c6_p617_prov_TextView.setText("");
        c6_p617_dep_TextView.setText("");
    }

    public boolean rango(int ini, int fin, String numero){
        if(Integer.parseInt(numero)>=ini && Integer.parseInt(numero)<=fin) return true; else return false;
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

    public void verificar_Fragament618_621(){
        Data data = new Data(context);
        data.open();

        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p618p621,idEncuestado).equals("1")){
            if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p618,idEncuestado).equals("0") &&
                    data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p619,idEncuestado).equals("0") &&
                    data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p620,idEncuestado).equals("0") &&
                    data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p621,idEncuestado).equals("0")) {
                    data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p618p621,"-1",idEncuestado);
            }
        }

        data.close();
    }

    public void verificar_Fragament622_625(){
        Data data = new Data(context);
        data.open();

        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,idEncuestado).equals("1")){
            if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p622,idEncuestado).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p623,idEncuestado).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p624,idEncuestado).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p625,idEncuestado).equals("0")) {
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"-1",idEncuestado);
            }
        }

        data.close();
    }
}
