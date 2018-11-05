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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP613P618 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c6_p613_RadioGroup;
    EditText c6_p614_mon_EditText, c6_p614_esp_EditText, c6_p615_mon_EditText, c6_p615_esp_EditText,
            c6_p616_mon_EditText, c6_p616_esp_EditText;
    CheckBox c6_p616_nas_Checkbox;
    RadioGroup c6_p617_RadioGroup;
    Spinner c6_p617_dist_Spinner, c6_p617_prov_Spinner, c6_p617_dep_Spinner;
    LinearLayout m6_p613_linearlayout, m6_p614_linearlayout, m6_p615_linearlayout, m6_p616_linearlayout,
            m6_p617_linearlayout;

    private boolean c6_604=true;
    private int c6_p608=-1;
    private int c6_p613;
    private String c6_p614_mon;
    private String c6_p614_esp;
    private String c6_p615_mon;
    private String c6_p615_esp;
    private String c6_p616_mon;
    private String c6_p616_esp;
    private int c6_p616_nas;
    private int c6_p617;
    private int c6_p617_dist;
    private int c6_p617_prov;
    private int c6_p617_dep;

    private int edad;

    @SuppressLint("ValidFragment")
    public FragmentP613P618(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idHogar = residente.getId_hogar();
        idVivienda = residente.getId_vivienda();
        idInformante = "";
        if(residente.getC2_p205_a()=="") edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
        data.close();
    }

    public FragmentP613P618() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p613_p618, container, false);

        c6_p613_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_613_radiogroup_C6_P613);
        c6_p614_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_614_edittext_C6_P614_MON);
        c6_p614_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_614_edittext_C6_P614_ESP);
        c6_p615_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_615_edittext_C6_P615_MON);
        c6_p615_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_615_edittext_C6_P615_ESP);
        c6_p616_mon_EditText = (EditText) rootView.findViewById(R.id.mod6_616_edittext_C6_P616_MON);
        c6_p616_esp_EditText = (EditText) rootView.findViewById(R.id.mod6_616_edittext_C6_P616_ESP);
        c6_p616_nas_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_616_checkbox_C6_P616_NAS);
        c6_p617_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_617_radiogroup_C6_P617);

        c6_p617_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_617_radiogroup_C6_P617);
        c6_p617_dist_Spinner = (Spinner) rootView.findViewById(R.id.mod6_617_edittext_C6_P617_DIST);
        c6_p617_prov_Spinner = (Spinner) rootView.findViewById(R.id.mod6_617_edittext_C6_P617_PROV);
        c6_p617_dep_Spinner = (Spinner) rootView.findViewById(R.id.mod6_617_edittext_C6_P617_DEP);

        m6_p613_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p613);
        m6_p614_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p614);
        m6_p615_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p615);
        m6_p616_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p616);
        m6_p617_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p617);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c6_p614_mon_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p614_mon_EditText);
                    m6_p614_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p615_mon_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p615_mon_EditText);
                    m6_p615_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p616_mon_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p616_mon_EditText);
                    m6_p616_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p614_esp_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p614_esp_EditText);
                    m6_p614_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p615_esp_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p615_esp_EditText);
                    m6_p615_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p616_esp_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p616_esp_EditText);
                    m6_p616_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p616_nas_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    limpiar_p616();
                    c6_p616_mon_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c6_p616_esp_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c6_p616_mon_EditText.setEnabled(false);
                    c6_p616_esp_EditText.setEnabled(false);
                }else{
                    c6_p616_mon_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                    c6_p616_esp_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                    c6_p616_mon_EditText.setEnabled(true);
                    c6_p616_esp_EditText.setEnabled(true);
                }
            }
        });

        c6_p617_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p617_RadioGroup.findViewById(c6_p617_RadioGroup.getCheckedRadioButtonId()));
                if(pos==1){
                    c6_p617_dist_Spinner.setEnabled(true);
                    c6_p617_prov_Spinner.setEnabled(true);
                    c6_p617_dep_Spinner.setEnabled(true);
                }else{
                    limpiar_p617();
                    c6_p617_dist_Spinner.setEnabled(false);
                    c6_p617_prov_Spinner.setEnabled(false);
                    c6_p617_dep_Spinner.setEnabled(false);
                }
            }
        });

        c6_p614_mon_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p614_mon_EditText.setInputType(18);
        c6_p614_mon_EditText.setTransformationMethod(null);

        c6_p614_esp_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p614_esp_EditText.setInputType(18);
        c6_p614_esp_EditText.setTransformationMethod(null);

        c6_p615_mon_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p615_mon_EditText.setInputType(18);
        c6_p615_mon_EditText.setTransformationMethod(null);

        c6_p615_esp_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p615_esp_EditText.setInputType(18);
        c6_p615_esp_EditText.setTransformationMethod(null);

        c6_p616_mon_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p616_mon_EditText.setInputType(18);
        c6_p616_mon_EditText.setTransformationMethod(null);

        c6_p616_esp_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(6)});
        c6_p616_esp_EditText.setInputType(18);
        c6_p616_esp_EditText.setTransformationMethod(null);

        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p613,c6_p613+"");
        contentValues.put(SQLConstantes.modulo6_c6_p614_mon,c6_p614_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p614_esp,c6_p614_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p615_mon,c6_p615_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p615_esp,c6_p615_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p616_mon,c6_p616_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p616_esp,c6_p616_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p616_nas,c6_p616_nas+"");
        contentValues.put(SQLConstantes.modulo6_c6_p617,c6_p617+"");
        contentValues.put(SQLConstantes.modulo6_c6_p617_dist,c6_p617_dist+"");
        contentValues.put(SQLConstantes.modulo6_c6_p617_prov,c6_p617_prov+"");
        contentValues.put(SQLConstantes.modulo6_c6_p617_dep,c6_p617_dep+"");

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = new Modulo6(idEncuestado,idHogar,idVivienda);
            modulo6.setIdInformante(idInformante);
            modulo6.set_id(idEncuestado);
            modulo6.setIdVivienda(idVivienda);
            modulo6.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(),modulo6.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        c6_p613 = c6_p613_RadioGroup.indexOfChild(c6_p613_RadioGroup.findViewById(c6_p613_RadioGroup.getCheckedRadioButtonId()));
        c6_p614_mon = c6_p614_mon_EditText.getText().toString();
        c6_p614_esp = c6_p614_esp_EditText.getText().toString();
        c6_p615_mon = c6_p615_mon_EditText.getText().toString();
        c6_p615_esp = c6_p615_esp_EditText.getText().toString();
        c6_p616_mon = c6_p616_mon_EditText.getText().toString();
        c6_p616_esp = c6_p616_esp_EditText.getText().toString();
        if(c6_p616_nas_Checkbox.isChecked()) c6_p616_nas = 1; else c6_p616_nas = 0;
        c6_p617 = c6_p617_RadioGroup.indexOfChild(c6_p617_RadioGroup.findViewById(c6_p617_RadioGroup.getCheckedRadioButtonId()));
        c6_p617_dist = c6_p617_dist_Spinner.getSelectedItemPosition();
        c6_p617_prov = c6_p617_prov_Spinner.getSelectedItemPosition();
        c6_p617_dep = c6_p617_dep_Spinner.getSelectedItemPosition();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = data.getModulo6(idEncuestado);
            c6_604 = modulo6.getC6_p604_trabajo();
            if(!modulo6.getC6_p608().equals(""))  c6_p608 = Integer.parseInt(modulo6.getC6_p608());
            if(!(modulo6.getC6_p613().equals("-1") || modulo6.getC6_p613().equals("")))((RadioButton)c6_p613_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p613()))).setChecked(true);
            c6_p614_mon_EditText.setText(modulo6.getC6_p614_mon());
            c6_p614_esp_EditText.setText(modulo6.getC6_p614_esp());
            c6_p615_mon_EditText.setText(modulo6.getC6_p615_mon());
            c6_p615_esp_EditText.setText(modulo6.getC6_p615_esp());
            c6_p616_mon_EditText.setText(modulo6.getC6_p616_mon());
            c6_p616_esp_EditText.setText(modulo6.getC6_p616_esp());
            if(modulo6.getC6_p616_nas().equals("0")) c6_p616_nas_Checkbox.setChecked(false);
            if(modulo6.getC6_p616_nas().equals("1")) c6_p616_nas_Checkbox.setChecked(true);
            if(!(modulo6.getC6_p617().equals("-1") || modulo6.getC6_p617().equals("")))((RadioButton)c6_p617_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p617()))).setChecked(true);
            if(!modulo6.getC6_p617_dist().equals("")) c6_p617_dist_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p617_dist()));
            if(!modulo6.getC6_p617_prov().equals("")) c6_p617_prov_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p617_prov()));
            if(!modulo6.getC6_p617_dep().equals("")) c6_p617_dep_Spinner.setSelection(Integer.parseInt(modulo6.getC6_p617_dep()));
        }
        inicio();
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(c6_p613<0 && m6_p613_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 613: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if(m6_p614_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p614_mon.trim().length()==0){
                mostrarMensaje("PREGUNTA 614 - DINERO: DEBE ESPECIFICAR");
                return false;
            }
            if(!rango(1,99998,c6_p614_mon)){
                mostrarMensaje("PREGUNTA 614 - DINERO: DEBE INGRESAR HORAS TRABAJADAS ENTRE  1 Y 99998");
                return false;
            }
            if(c6_p614_esp.trim().length()==0){
                mostrarMensaje("PREGUNTA 614 - ESPECIE: DEBE ESPECIFICAR");
                return false;
            }
            if(!rango(0,99998,c6_p614_esp)){
                mostrarMensaje("PREGUNTA 614 - ESPECIE: DEBE INGRESAR HORAS TRABAJADAS ENTRE  0 Y 99998");
                return false;
            }
        }
        if(m6_p615_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p615_mon.trim().length()==0){
                mostrarMensaje("PREGUNTA 615 - DINERO: DEBE ESPECIFICAR");
                return false;
            }
            if(!rango(1,99998,c6_p615_mon)){
                mostrarMensaje("PREGUNTA 615 - DINERO: DEBE INGRESAR HORAS TRABAJADAS ENTRE  1 Y 99998");
                return false;
            }
            if(c6_p615_esp.trim().length()==0){
                mostrarMensaje("PREGUNTA 615 - ESPECIE: DEBE ESPECIFICAR");
                return false;
            }
            if(!rango(0,99998,c6_p615_esp)){
                mostrarMensaje("PREGUNTA 615 - ESPECIE: DEBE INGRESAR HORAS TRABAJADAS ENTRE  0 Y 99998");
                return false;
            }
        }
        if(m6_p616_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p616_nas==0){
                if(c6_p616_mon.trim().length()==0){
                    mostrarMensaje("PREGUNTA 616 - DINERO: DEBE ESPECIFICAR");
                    return false;
                }
                if(!rango(0,99998,c6_p616_mon)){
                    mostrarMensaje("PREGUNTA 616 - DINERO: DEBE INGRESAR HORAS TRABAJADAS ENTRE  1 Y 99998");
                    return false;
                }
                if(c6_p616_esp.trim().length()==0){
                    mostrarMensaje("PREGUNTA 616 - ESPECIE: DEBE ESPECIFICAR");
                    return false;
                }
                if(!rango(0,99998,c6_p616_esp)){
                    mostrarMensaje("PREGUNTA 616 - ESPECIE: DEBE INGRESAR HORAS TRABAJADAS ENTRE  0 Y 99998");
                    return false;
                }
            }
        }
        if(m6_p617_linearlayout.getVisibility()==View.VISIBLE) {
            if(c6_p617<0){
                mostrarMensaje("PREGUNTA 617: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p617==1){
                if(c6_p617_dist<0){
                    mostrarMensaje("PREGUNTA 617: DEBE SELECCIONAR DISTRITO");
                    return false;
                }
                if(c6_p617_prov<0){
                    mostrarMensaje("PREGUNTA 617: DEBE SELECCIONAR PROVINCIA");
                    return false;
                }
                if(c6_p617_dep<0){
                    mostrarMensaje("PREGUNTA 617: DEBE SELECCIONAR DEPARTAMENTO");
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

    public void limpiar_p616(){
        c6_p616_mon_EditText.setText("");
        c6_p616_esp_EditText.setText("");
    }

    public void limpiar_p617(){
        c6_p617_dist_Spinner.setSelection(-1);
        c6_p617_prov_Spinner.setSelection(-1);
        c6_p617_dep_Spinner.setSelection(-1);
    }

    public boolean rango(int ini, int fin, String numero){
        if(Integer.parseInt(numero)>=ini && Integer.parseInt(numero)<=fin) return true; else return false;
    }

    public void inicio(){
        if(edad>=5){
            if(c6_604){
                if(c6_p608==2 || c6_p608==3 || c6_p608==5){
                    m6_p613_linearlayout.setVisibility(View.VISIBLE); m6_p614_linearlayout.setVisibility(View.VISIBLE);
                }else{
                    c6_p613_RadioGroup.clearCheck();
                    c6_p614_mon_EditText.setText("");
                    c6_p614_esp_EditText.setText("");
                    m6_p613_linearlayout.setVisibility(View.GONE); m6_p614_linearlayout.setVisibility(View.GONE);
                }
                if(c6_p608==0 || c6_p608==1){
                    m6_p615_linearlayout.setVisibility(View.VISIBLE); m6_p616_linearlayout.setVisibility(View.VISIBLE);
                    m6_p617_linearlayout.setVisibility(View.VISIBLE);
                }else{
                    limpiar_p616();
                    c6_p616_nas_Checkbox.setChecked(false);
                    c6_p617_RadioGroup.clearCheck();
                    limpiar_p617();
                    m6_p616_linearlayout.setVisibility(View.GONE);
                    m6_p617_linearlayout.setVisibility(View.GONE);
                }
            }else{
                c6_p613_RadioGroup.clearCheck();
                c6_p614_mon_EditText.setText("");
                c6_p614_esp_EditText.setText("");
                c6_p615_mon_EditText.setText("");
                c6_p615_esp_EditText.setText("");
                limpiar_p616();
                c6_p616_nas_Checkbox.setChecked(false);
                c6_p617_RadioGroup.clearCheck();
                limpiar_p617();
                m6_p613_linearlayout.setVisibility(View.GONE); m6_p614_linearlayout.setVisibility(View.GONE);
                m6_p615_linearlayout.setVisibility(View.GONE); m6_p616_linearlayout.setVisibility(View.GONE);
                m6_p617_linearlayout.setVisibility(View.GONE);
            }
        }else{
            c6_p613_RadioGroup.clearCheck();
            c6_p614_mon_EditText.setText("");
            c6_p614_esp_EditText.setText("");
            c6_p615_mon_EditText.setText("");
            c6_p615_esp_EditText.setText("");
            limpiar_p616();
            c6_p616_nas_Checkbox.setChecked(false);
            c6_p617_RadioGroup.clearCheck();
            limpiar_p617();
            m6_p613_linearlayout.setVisibility(View.GONE); m6_p614_linearlayout.setVisibility(View.GONE);
            m6_p615_linearlayout.setVisibility(View.GONE); m6_p616_linearlayout.setVisibility(View.GONE);
            m6_p617_linearlayout.setVisibility(View.GONE);
        }
    }
}
