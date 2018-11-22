package com.example.ricindigus.empove2018.fragments.modulo5;


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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.POJOLayout;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.Ubigeo;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP501P505 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;
    Spinner informanteSpinner;


    RadioGroup c5_p501_RadioGroup, c5_p503_RadioGroup, c5_p504_RadioGroup, c5_p505_RadioGroup;
    TextView txtNombreCarrera, txtCodigoCarrera;
    EditText c5_p502_o_EditText;
    AutoCompleteTextView c5_p502_Autocomplete;
    CheckBox c5_p502_c_CheckBox;
    LinearLayout m5_p501_linearlayout, m5_p502_linearlayout, m5_p503_linearlayout, m5_p504_linearlayout,
            m5_p505_linearlayout;

    private String c5_p501;
    private String c5_p502_c;
    private String c5_p502;
    private String c5_p502_eleccion;
    private String c5_p502_o;
    private String c5_p503;
    private String c5_p504;
    private String c5_p505;
    int edad=0;

    @SuppressLint("ValidFragment")
    public FragmentP501P505(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idHogar = residente.getId_hogar();
        idVivienda = residente.getId_vivienda();
        if(residente.getC2_p205_a().equals("")) edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
        idInformante = "";
        data.close();
    }

    public FragmentP501P505() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p501_p505, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c5_p501_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_501_radiogroup_C5_P501);

        c5_p502_Autocomplete = (AutoCompleteTextView) rootView.findViewById(R.id.mod5_502_autocompletetextview);
        txtCodigoCarrera = (TextView) rootView.findViewById(R.id.mod5_c502_txtCodigoCarrera);
        txtNombreCarrera = (TextView) rootView.findViewById(R.id.mod5_c502_txtNombreCarrera);
        c5_p502_o_EditText = (EditText) rootView.findViewById(R.id.mod5_502_edittext_C5_P502_o);
        c5_p502_c_CheckBox = (CheckBox) rootView.findViewById(R.id.mod5_502_checkbox_C5_P502_C);

        c5_p503_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_503_radiogroup_C5_P503);
        c5_p504_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_504_radiogroup_C5_P504);
        c5_p505_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_505_radiogroup_C5_P505);

        m5_p501_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p501);
        m5_p502_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p502);
        m5_p503_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p503);
        m5_p504_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p504);
        m5_p505_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p505);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c5_p502_c_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    txtNombreCarrera.setText("");
                    txtCodigoCarrera.setText("");
                    c5_p502_o_EditText.setText("");
                    c5_p502_Autocomplete.setEnabled(false);
                    c5_p502_o_EditText.setEnabled(false);
                    c5_p502_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                }else{
                    c5_p502_Autocomplete.setEnabled(true);
                }
            }
        });

        c5_p501_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c5_p501_RadioGroup.findViewById(c5_p501_RadioGroup.getCheckedRadioButtonId()));

                if(pos>=1 && pos<=6){
                    txtCodigoCarrera.setText("");
                    txtNombreCarrera.setText("");
                    c5_p502_o_EditText.setText("");
                    c5_p502_o_EditText.setEnabled(false);
                    m5_p502_linearlayout.setVisibility(View.GONE);
                }else{
                    m5_p502_linearlayout.setVisibility(View.VISIBLE);
                }

                if (pos == 7 || pos == 8){
                    limpiar_p502();
                    ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.lista_item,R.id.item, getResources().getStringArray(R.array.array_carreras_tecnicas));
                    c5_p502_Autocomplete.setAdapter(adapter);
                    c5_p502_Autocomplete.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                            if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                                ocultarTeclado(c5_p502_Autocomplete);
                                m5_p502_linearlayout.requestFocus();
                                return true;
                            }
                            return false;
                        }
                    });
                }

                if (pos >= 9 && pos <= 11){
                    limpiar_p502();
                    ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.lista_item,R.id.item, getResources().getStringArray(R.array.array_carreras_universitarias));
                    c5_p502_Autocomplete.setAdapter(adapter);
                    c5_p502_Autocomplete.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                            if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                                ocultarTeclado(c5_p502_Autocomplete);
                                m5_p502_linearlayout.requestFocus();
                                return true;
                            }
                            return false;
                        }
                    });
                }

            }
        });

        c5_p502_Autocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String textoCarrera = c5_p502_Autocomplete.getText().toString();
                String codigo = textoCarrera.substring(0,textoCarrera.indexOf("-"));
                if (codigo.equals("99999")){
                    c5_p502_o_EditText.setEnabled(true);
                    c5_p502_o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                } else {
                    c5_p502_o_EditText.setText("");
                    c5_p502_o_EditText.setEnabled(false);
                    c5_p502_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                }
                String nombre = textoCarrera.substring(textoCarrera.indexOf("-")+2);
                txtCodigoCarrera.setText(codigo);
                txtNombreCarrera.setText(nombre);
                c5_p502_Autocomplete.setText("");
                ocultarTeclado(c5_p502_Autocomplete);
                m5_p502_linearlayout.requestFocus();
            }
        });
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo5_c5_p501,c5_p501);
        contentValues.put(SQLConstantes.modulo5_c5_p502_c,c5_p502_c);
        contentValues.put(SQLConstantes.modulo5_c5_p502,c5_p502);
        contentValues.put(SQLConstantes.modulo5_c5_p502_eleccion,c5_p502_eleccion);
        contentValues.put(SQLConstantes.modulo5_c5_p502_o,c5_p502_o);
        contentValues.put(SQLConstantes.modulo5_c5_p503,c5_p503);
        contentValues.put(SQLConstantes.modulo5_c5_p504,c5_p504);
        contentValues.put(SQLConstantes.modulo5_c5_p505,c5_p505);

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo5 modulo5 = new Modulo5(idEncuestado,idHogar,idVivienda);
            data.insertarElemento(getNombreTabla(),modulo5.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
        ocultarOtrosLayouts();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c5_p501 = c5_p501_RadioGroup.indexOfChild(c5_p501_RadioGroup.findViewById(c5_p501_RadioGroup.getCheckedRadioButtonId()))+"";
        c5_p502 = txtCodigoCarrera.getText().toString();
        c5_p502_eleccion = txtNombreCarrera.getText().toString();
        if (c5_p502_c_CheckBox.isChecked()) c5_p502_c = "1"; else c5_p502_c = "0";
        c5_p502_o = c5_p502_o_EditText.getText().toString();
        c5_p503 = c5_p503_RadioGroup.indexOfChild(c5_p503_RadioGroup.findViewById(c5_p503_RadioGroup.getCheckedRadioButtonId()))+"";
        c5_p504 = c5_p504_RadioGroup.indexOfChild(c5_p504_RadioGroup.findViewById(c5_p504_RadioGroup.getCheckedRadioButtonId()))+"";
        c5_p505 = c5_p505_RadioGroup.indexOfChild(c5_p505_RadioGroup.findViewById(c5_p505_RadioGroup.getCheckedRadioButtonId()))+"";
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo5 modulo5 = data.getModulo5(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo5.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            if(!modulo5.getIdInformante().equals(""))informanteSpinner.setSelection(Integer.parseInt(modulo5.getIdInformante()));
            if(!modulo5.getC5_p501().equals("-1") && !modulo5.getC5_p501().equals(""))((RadioButton)c5_p501_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p501()))).setChecked(true);
            txtNombreCarrera.setText(modulo5.getC5_p502_eleccion());
            txtCodigoCarrera.setText(modulo5.getC5_p502());
            if (modulo5.getC5_p502().equals("99999"))c5_p502_o_EditText.setText(modulo5.getC5_p502_o());
            if(modulo5.getC5_p502_c().equals("1")) c5_p502_c_CheckBox.setChecked(true);
            if(!modulo5.getC5_p503().equals("-1") && ! modulo5.getC5_p503().equals(""))((RadioButton)c5_p503_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p503()))).setChecked(true);
            if(!modulo5.getC5_p504().equals("-1") && !modulo5.getC5_p504().equals(""))((RadioButton)c5_p504_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p504()))).setChecked(true);
            if(!modulo5.getC5_p505().equals("-1") && !modulo5.getC5_p505().equals(""))((RadioButton)c5_p505_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p505()))).setChecked(true);
        }
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if(c5_p501.equals("-1")){ mostrarMensaje("PREGUNTA 501: DEBE SELECCIONAR UNA OPCION");return false; }
        if((Integer.parseInt(c5_p501)>=3 && edad<5) || (Integer.parseInt(c5_p501)>=4 && edad<14) ||
            (Integer.parseInt(c5_p501)>=5 && edad<14) || (Integer.parseInt(c5_p501)>=6 && edad<15) ||
            (Integer.parseInt(c5_p501)>=7 && edad<16) || (Integer.parseInt(c5_p501)>=8 && edad<16) ||
            (Integer.parseInt(c5_p501)>=9 && edad<16) || (Integer.parseInt(c5_p501)>=10 && edad<21)){
            mostrarMensaje("PREGUNTA 501: EDAD NO CONCUERDA CON NIVEL DE ESTUDIO ALCANZADO");
        }
        if (m5_p502_linearlayout.getVisibility()==View.VISIBLE){
            if(c5_p502_c.equals("0")){
                if(c5_p502.equals("")){ mostrarMensaje("PREGUNTA 502: DEBE INDICAR LA CARRERA");return false; }
                if(c5_p502.equals("99999")){
                    if (c5_p502_o.trim().equals("")){ mostrarMensaje("PREGUNTA 502: DEBE ESPECIFICAR EL NOMBRE DE LA CARRERA");return false; }
                }
            }
        }else{
            c5_p502 = "";
            c5_p502_o = "";
            c5_p502_c = "";
            c5_p502_eleccion = "";
        }

        if(c5_p503.equals("-1")){ mostrarMensaje("PREGUNTA 503: DEBE SELECCIONAR UNA OPCION");return false; }
        if(c5_p504.equals("-1")){ mostrarMensaje("PREGUNTA 504: DEBE SELECCIONAR UNA OPCION");return false; }
        if(c5_p505.equals("-1")){mostrarMensaje("PREGUNTA 505: DEBE SELECCIONAR UNA OPCION");return false; }
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

    public void limpiar_p502(){
        txtCodigoCarrera.setText("");
        txtNombreCarrera.setText("");
        c5_p502_o_EditText.setText("");
        c5_p502_o_EditText.setEnabled(false);
        c5_p502_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
        c5_p502_c_CheckBox.setEnabled(true);
        c5_p502_Autocomplete.setEnabled(true);
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

    public void controlarChecked(CheckBox checkBox,final EditText editText){
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

    public void ocultarOtrosLayouts(){
        if (!c5_p501.equals("10") && !c5_p501.equals("11")){
            Data data = new Data(context);
            data.open();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo5_c5_p509,"");
            contentValues.put(SQLConstantes.modulo5_c5_p510,"");
            contentValues.put(SQLConstantes.modulo5_c5_p511,"");
            contentValues.put(SQLConstantes.modulo5_c5_p511_o,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);

            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p509,"0");
            contentValues.put(SQLConstantes.layouts_p510,"0");
            contentValues.put(SQLConstantes.layouts_p511,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);

            POJOLayout pojoLayout = data.getLayouts(idEncuestado);
            if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p508,idEncuestado).equals("0"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"-1",idEncuestado);
            data.close();
        }else{
            Data data = new Data(context);
            data.open();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p509,"1");
            contentValues.put(SQLConstantes.layouts_p510,"1");
            contentValues.put(SQLConstantes.layouts_p511,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p306p308,"1",idEncuestado);
            data.close();
        }

        if (c5_p504.equals("2") && c5_p505.equals("2")){
            Data data = new Data(context);
            data.open();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo5_c5_p506_1,"");
            contentValues.put(SQLConstantes.modulo5_c5_p506_2,"");
            contentValues.put(SQLConstantes.modulo5_c5_p506_3,"");
            contentValues.put(SQLConstantes.modulo5_c5_p506_4,"");
            contentValues.put(SQLConstantes.modulo5_c5_p507,"");
            contentValues.put(SQLConstantes.modulo5_c5_p507_dist,"");
            contentValues.put(SQLConstantes.modulo5_c5_p507_prov,"");
            contentValues.put(SQLConstantes.modulo5_c5_p507_dep,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p506p507,"-1",idEncuestado);

            Residente residente = data.getResidente(idEncuestado);
            int edad = 0;
            if (!residente.getC2_p205_a().equals("")) edad = Integer.parseInt(residente.getC2_p205_a());
            if (edad >= 3 && edad <=25){
                contentValues = new ContentValues();
                contentValues.put(SQLConstantes.layouts_p508,"1");
                data.actualizarElemento(SQLConstantes.tablalayouts,contentValues,idEncuestado);
                if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,idEncuestado).equals("-1"))
                    data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"1",idEncuestado);
            }
            POJOLayout pojoLayout = data.getLayouts(idEncuestado);
            data.close();
        }else{
            Data data = new Data(context);
            data.open();
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p506p507,idEncuestado).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p506p507,"1",idEncuestado);
            POJOLayout pojoLayout = data.getLayouts(idEncuestado);
            data.close();
        }



    }


}
