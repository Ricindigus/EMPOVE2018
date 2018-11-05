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
import android.util.Log;
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
public class FragmentP623P625 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;

    RadioGroup c6_p622_RadioGroup;
    EditText c6_p622_o_EditText;
    RadioGroup c6_p623_RadioGroup;
    EditText c6_p623_o_EditText;
    EditText c6_p624_EditText;
    CheckBox c6_p625_1_Checkbox, c6_p625_2_Checkbox, c6_p625_3_Checkbox , c6_p625_4_Checkbox, c6_p625_5_Checkbox,
            c6_p625_6_Checkbox;
    EditText c6_p625_o_EditText;
    LinearLayout m6_p622_linearlayout, m6_p623_linearlayout, m6_p624_linearlayout, m6_p625_linearlayout;

    private boolean c6_604=true;

    private int c6_p622;
    private String c6_p622_o;
    private int c6_p623;
    private String c6_p623_o;
    private String c6_p624;
    private int c6_p625_1;
    private int c6_p625_2;
    private int c6_p625_3;
    private int c6_p625_4;
    private int c6_p625_5;
    private int c6_p625_6;
    private String c6_p625_o;

    boolean pasar_a_623=false, pasar_a_625=false;
    boolean existe_menor_edad=false;

    private int edad;

    @SuppressLint("ValidFragment")
    public FragmentP623P625(String idEncuestado, Context context) {
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

    public FragmentP623P625() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p623_p625, container, false);

        c6_p622_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_623_radiogroup_C6_P623);
        c6_p622_o_EditText = (EditText) rootView.findViewById(R.id.mod6_623_edittext_C6_P623_O);
        c6_p623_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_624_radiogroup_C6_P624);
        c6_p623_o_EditText = (EditText) rootView.findViewById(R.id.mod6_624_edittext_C6_P624_O);
        c6_p624_EditText = (EditText) rootView.findViewById(R.id.mod6_625_edittext_C6_P625);

        c6_p625_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_1);
        c6_p625_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_2);
        c6_p625_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_3);
        c6_p625_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_4);
        c6_p625_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_5);
        c6_p625_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod6_618_checkbox_C6_P618_6);
        c6_p625_o_EditText = (EditText) rootView.findViewById(R.id.mod6_618_edittext_C6_P618_O);

        m6_p622_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p623);
        m6_p623_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p624);
        m6_p624_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p625);
        m6_p625_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p618);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c6_p622_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p622_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p622_o_EditText);
                    m6_p622_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p622_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p622_RadioGroup.findViewById(c6_p622_RadioGroup.getCheckedRadioButtonId()));
                if(pos>=0 && pos<=9){
                    limpiar_p623(); limpiar_p624();
                    m6_p623_linearlayout.setVisibility(View.GONE);
                    m6_p624_linearlayout.setVisibility(View.GONE);
                    if(pos==9){
                        c6_p622_o_EditText.setEnabled(true);
                        c6_p622_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                    }else{
                        c6_p622_o_EditText.setText("");
                        c6_p622_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                        c6_p622_o_EditText.setEnabled(false);
                    }
                }else{
                    c6_p622_o_EditText.setText("");
                    c6_p622_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c6_p622_o_EditText.setEnabled(false);
                    m6_p623_linearlayout.setVisibility(View.VISIBLE);
                    m6_p624_linearlayout.setVisibility(View.VISIBLE);
                }
            }
        });
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
        c6_p623_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p623_RadioGroup.findViewById(c6_p623_RadioGroup.getCheckedRadioButtonId()));
                if(pos==6){
                    limpiar_p624(); m6_p624_linearlayout.setVisibility(View.GONE);
                }else{
                    m6_p624_linearlayout.setVisibility(View.VISIBLE);
                    if(pos==5){
                        c6_p623_o_EditText.setEnabled(true);
                        c6_p623_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                    }else{
                        c6_p623_o_EditText.setText("");
                        c6_p623_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                        c6_p623_o_EditText.setEnabled(false);
                    }
                }
            }
        });
        c6_p624_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p624_EditText);
                    m6_p624_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p624_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});
        c6_p624_EditText.setInputType(18);
        c6_p624_EditText.setTransformationMethod(null);
        c6_p625_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p625_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p625_o_EditText);
                    m6_p625_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p625_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p625_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p625_o_EditText);
                    m6_p625_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p625_6_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    c6_p625_o_EditText.setEnabled(true);
                    c6_p625_o_EditText.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    c6_p625_o_EditText.setText("");
                    c6_p625_o_EditText.setBackgroundResource(R.drawable.cajas_de_texto_disabled);
                    c6_p625_o_EditText.setEnabled(false);
                }
            }
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p622,c6_p622+"");
        contentValues.put(SQLConstantes.modulo6_c6_p622_o,c6_p622_o);
        contentValues.put(SQLConstantes.modulo6_c6_p623,c6_p623+"");
        contentValues.put(SQLConstantes.modulo6_c6_p623_o,c6_p623_o);
        contentValues.put(SQLConstantes.modulo6_c6_p624,c6_p624);
        contentValues.put(SQLConstantes.modulo6_c6_p625_1,c6_p625_1+"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_2,c6_p625_2+"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_3,c6_p625_3+"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_4,c6_p625_4+"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_5,c6_p625_5+"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_6,c6_p625_6+"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_o,c6_p625_o);

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
        c6_p622 = c6_p622_RadioGroup.indexOfChild(c6_p622_RadioGroup.findViewById(c6_p622_RadioGroup.getCheckedRadioButtonId()));
        c6_p622_o = c6_p622_o_EditText.getText().toString();
        c6_p623 = c6_p623_RadioGroup.indexOfChild(c6_p623_RadioGroup.findViewById(c6_p623_RadioGroup.getCheckedRadioButtonId()));
        c6_p623_o = c6_p623_o_EditText.getText().toString();
        c6_p624 = c6_p624_EditText.getText().toString();
        if(c6_p625_1_Checkbox.isChecked()) c6_p625_1 = 1; else c6_p625_1 = 0;
        if(c6_p625_2_Checkbox.isChecked()) c6_p625_2 = 1; else c6_p625_2 = 0;
        if(c6_p625_3_Checkbox.isChecked()) c6_p625_3 = 1; else c6_p625_3 = 0;
        if(c6_p625_4_Checkbox.isChecked()) c6_p625_4 = 1; else c6_p625_4 = 0;
        if(c6_p625_5_Checkbox.isChecked()) c6_p625_5 = 1; else c6_p625_5 = 0;
        if(c6_p625_6_Checkbox.isChecked()) c6_p625_6 = 1; else c6_p625_6 = 0;
        c6_p625_o = c6_p625_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo6 modulo6 = data.getModulo6(idEncuestado);
            c6_604 = modulo6.getC6_p604_trabajo();
            pasar_a_623 = modulo6.pasar_a_p623();
            pasar_a_625 = modulo6.pasar_a_p625();
            if(!(modulo6.getC6_p622().equals("-1") || modulo6.getC6_p622().equals("")))((RadioButton)c6_p622_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p622()))).setChecked(true);
            c6_p622_o_EditText.setText(modulo6.getC6_p622_o());
            if(!(modulo6.getC6_p623().equals("-1") || modulo6.getC6_p623().equals("")))((RadioButton)c6_p623_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p623()))).setChecked(true);
            c6_p623_o_EditText.setText(modulo6.getC6_p623_o());
            c6_p624_EditText.setText(modulo6.getC6_p624());
            if(modulo6.getC6_p625_1().equals("0")) c6_p625_1_Checkbox.setChecked(false);
            if(modulo6.getC6_p625_2().equals("0")) c6_p625_2_Checkbox.setChecked(false);
            if(modulo6.getC6_p625_3().equals("0")) c6_p625_3_Checkbox.setChecked(false);
            if(modulo6.getC6_p625_4().equals("0")) c6_p625_4_Checkbox.setChecked(false);
            if(modulo6.getC6_p625_5().equals("0")) c6_p625_5_Checkbox.setChecked(false);
            if(modulo6.getC6_p625_6().equals("0")) c6_p625_6_Checkbox.setChecked(false);
            if(modulo6.getC6_p625_1().equals("1")) c6_p625_1_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_2().equals("1")) c6_p625_2_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_3().equals("1")) c6_p625_3_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_4().equals("1")) c6_p625_4_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_5().equals("1")) c6_p625_5_Checkbox.setChecked(true);
            if(modulo6.getC6_p625_6().equals("1")) c6_p625_6_Checkbox.setChecked(true);
            c6_p625_o_EditText.setText(modulo6.getC6_p625_o());
            Data data2 = new Data(context);
            data2.open();
            existe_menor_edad = data2.menor_edad_hogar(idHogar);
            Log.e("existe_menor_edad", "cargarDatos: " +existe_menor_edad );
            data2.close();
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
        if(m6_p622_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p622<0){
                mostrarMensaje("PREGUNTA 622: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p622==9){
                if(c6_p622_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 622 - OPCION 9: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(m6_p623_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p623<0){
                mostrarMensaje("PREGUNTA 623: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c6_p623==5){
                if(c6_p623_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 623 - OPCION 6: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }
        if(c6_p624.trim().length()==0 && m6_p624_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 624: DEBE INGRESAR NRO DE SEMANAS");
            return false;
        }
        if(m6_p625_linearlayout.getVisibility()==View.VISIBLE) {
            if(c6_p625_1==0 && c6_p625_2==0 && c6_p625_3==0 && c6_p625_4==0 && c6_p625_5==0 &&
                    c6_p625_6==0){
                mostrarMensaje("PREGUNTA 625: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c6_p625_6==1){
                if(c6_p625_o.trim().length()==0){
                    mostrarMensaje("PREGUNTA 625 - OPCION 6: DEBE ESPECIFICAR OTRO");
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

    public void limpiar_p622(){
        c6_p622_RadioGroup.clearCheck();
        c6_p622_o_EditText.setText("");
    }

    public void limpiar_p623(){
        c6_p623_RadioGroup.clearCheck();
        c6_p623_o_EditText.setText("");
    }

    public void limpiar_p624(){
        c6_p624_EditText.setText("");
    }

    public void limpiar_p625(){
        c6_p625_1_Checkbox.setChecked(false);
        c6_p625_2_Checkbox.setChecked(false);
        c6_p625_3_Checkbox.setChecked(false);
        c6_p625_4_Checkbox.setChecked(false);
        c6_p625_5_Checkbox.setChecked(false);
        c6_p625_6_Checkbox.setChecked(false);
        c6_p625_o_EditText.setText("");
    }

    public void inicio(){
        if(edad>=5){
            if(!c6_604){
                int pos_622 = c6_p622_RadioGroup.indexOfChild(c6_p622_RadioGroup.findViewById(c6_p622_RadioGroup.getCheckedRadioButtonId()));
                int pos_623 = c6_p623_RadioGroup.indexOfChild(c6_p623_RadioGroup.findViewById(c6_p623_RadioGroup.getCheckedRadioButtonId()));
                if(pasar_a_623){
                    limpiar_p622(); m6_p622_linearlayout.setVisibility(View.GONE);
                }else{
                    if(pasar_a_625){
                        limpiar_p622(); limpiar_p623(); limpiar_p624();
                        m6_p622_linearlayout.setVisibility(View.GONE);
                        m6_p623_linearlayout.setVisibility(View.GONE);
                        m6_p624_linearlayout.setVisibility(View.GONE);
                    }else{
                        m6_p622_linearlayout.setVisibility(View.VISIBLE);
                        if(pos_622>=0 && pos_622<=9){
                            limpiar_p623(); limpiar_p624();
                            m6_p623_linearlayout.setVisibility(View.GONE);
                            m6_p624_linearlayout.setVisibility(View.GONE);
                        }else{
                            m6_p623_linearlayout.setVisibility(View.VISIBLE);
                            if(pos_623==6){
                                limpiar_p624(); m6_p624_linearlayout.setVisibility(View.GONE);
                            }else m6_p624_linearlayout.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }else{
                limpiar_p622(); limpiar_p623(); limpiar_p624();
                m6_p622_linearlayout.setVisibility(View.GONE);
                m6_p623_linearlayout.setVisibility(View.GONE);
                m6_p624_linearlayout.setVisibility(View.GONE);
            }
            if(existe_menor_edad && edad>=12){
                m6_p625_linearlayout.setVisibility(View.VISIBLE);
            }else{
                limpiar_p625(); m6_p625_linearlayout.setVisibility(View.GONE);
            }
        }else{
            limpiar_p622(); limpiar_p623(); limpiar_p624(); limpiar_p625();
            m6_p622_linearlayout.setVisibility(View.GONE);
            m6_p623_linearlayout.setVisibility(View.GONE);
            m6_p624_linearlayout.setVisibility(View.GONE);
            m6_p625_linearlayout.setVisibility(View.GONE);
        }

    }
}
