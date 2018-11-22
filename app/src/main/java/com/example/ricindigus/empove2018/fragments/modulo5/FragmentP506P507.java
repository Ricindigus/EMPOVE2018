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
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
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
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Marco;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.Ubigeo;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP506P507 extends FragmentPagina {
    String idEncuestado;
    String idVivienda, idHogar, idInformante;
    Context context;
    Spinner informanteSpinner;

    RadioGroup c5_p506_1_RadioGroup, c5_p506_4_RadioGroup;
    TextView c5_p506_2o3_TextView;
    EditText c5_p506_2o3_EditText;
    RadioGroup c5_p507_RadioGroup;
    AutoCompleteTextView autoCompleteTextView;
    TextView txtDistrito, txtProvincia, txtDepartamento;
    LinearLayout m5_p506_linearlayout,m5_p506_subpregunta_linearlayout, m5_p507_linearlayout, m5_p507_subpregunta_linearlayout;

    int c5_p501=0;
    private String c5_p506_1;
    private String c5_p506_2;
    private String c5_p506_3;
    private String c5_p506_4;
    private String c5_p507;
    private String c5_p507_dist;
    private String c5_p507_prov;
    private String c5_p507_dep;
    private String marco_dist;
    private String marco_prov;
    private String marco_dep;

    private int edad, sexo;

    @SuppressLint("ValidFragment")
    public FragmentP506P507(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentP506P507() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p506_p507, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c5_p506_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_radiogroup_C5_P506_1);
        c5_p506_2o3_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp6_edittext_C5_P506_2o3);
        c5_p506_2o3_TextView = (TextView) rootView.findViewById(R.id.mod5_506_sp6_TextView_C5_P506_2o3);
        c5_p506_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_radiogroup_C5_P506_4);

        c5_p507_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_507_radiogroup_C5_P507);
        autoCompleteTextView =  (AutoCompleteTextView) rootView.findViewById(R.id.mod5_507_autocompletetextview);
        txtDepartamento = (TextView) rootView.findViewById(R.id.mod5_c507_txtDepartamento);
        txtProvincia = (TextView) rootView.findViewById(R.id.mod5_c507_txtProvincia);
        txtDistrito = (TextView) rootView.findViewById(R.id.mod5_c507_txtDistrito);

        m5_p506_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p506);
        m5_p506_subpregunta_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_506_subpregunta);
        m5_p507_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p507);
        m5_p507_subpregunta_linearlayout= (LinearLayout) rootView.findViewById(R.id.mod5_507_layout_subpregunta);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configurarEditText(c5_p506_2o3_EditText,m5_p506_subpregunta_linearlayout,2,1);

        c5_p506_1_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 2:
                        c5_p506_2o3_TextView.setText("Grado");break;
                    default: c5_p506_2o3_TextView.setText("Año");break;
                }
            }
        });

        c5_p507_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 1:
                        txtDepartamento.setText("");txtProvincia.setText("");txtDistrito.setText("");
                        c5_p507_dep = "";c5_p507_prov = "";c5_p507_dist = "";
                        m5_p507_subpregunta_linearlayout.setVisibility(View.GONE);break;
                    case 2:m5_p507_subpregunta_linearlayout.setVisibility(View.VISIBLE);break;
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
                    m5_p507_linearlayout.requestFocus();
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
                txtDepartamento.setText(ubigeo.getCod_departamento()+"."+ubigeo.getNom_departamento());
                txtProvincia.setText(ubigeo.getCod_provincia()+"."+ubigeo.getNom_provincia());
                txtDistrito.setText(ubigeo.getCod_distrito()+"."+ubigeo.getNom_distrito());
                c5_p507_dep = ubigeo.getCod_departamento();
                c5_p507_prov = ubigeo.getCod_provincia();
                c5_p507_dist = ubigeo.getCod_distrito();
                autoCompleteTextView.setText("");
                ocultarTeclado(autoCompleteTextView);
                m5_p507_linearlayout.requestFocus();
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
        contentValues.put(SQLConstantes.modulo5_c5_p506_1,c5_p506_1);
        contentValues.put(SQLConstantes.modulo5_c5_p506_2,c5_p506_2);
        contentValues.put(SQLConstantes.modulo5_c5_p506_3,c5_p506_3);
        contentValues.put(SQLConstantes.modulo5_c5_p506_4,c5_p506_4);
        contentValues.put(SQLConstantes.modulo5_c5_p507,c5_p507);
        contentValues.put(SQLConstantes.modulo5_c5_p507_dist,c5_p507_dist);
        contentValues.put(SQLConstantes.modulo5_c5_p507_prov,c5_p507_prov);
        contentValues.put(SQLConstantes.modulo5_c5_p507_dep,c5_p507_dep);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        //Ya valido y guardo correctamente el fragment, ahora actualizamos el valor de la cobertura del fragment a correcto(1)
        data.actualizarValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp506p507,"1",idEncuestado);
        //ocultamos o mostramos preguntas o fragments
        ocultarOtrosLayouts();
        //verificamos la cobertura del capitulo y actualizamos su valor de cobertura.
        if (verificarCoberturaCapitulo()) data.actualizarValor(getNombreTabla(),SQLConstantes.modulo5_COB500,"1",idEncuestado);
        else data.actualizarValor(getNombreTabla(),SQLConstantes.modulo5_COB500,"0",idEncuestado);
        data.actualizarValor(SQLConstantes.tablaresidentes,SQLConstantes.residentes_encuestado_cobertura,"0",idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c5_p506_1 = c5_p506_1_RadioGroup.indexOfChild(c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId()))+"";

        if (!c5_p506_1.equals("-1")){
            if (c5_p506_1.equals("2")) {
                c5_p506_3 = c5_p506_2o3_EditText.getText().toString();
                c5_p506_2 = "";
            }
            else{
                c5_p506_2 = c5_p506_2o3_EditText.getText().toString();
                c5_p506_3 = "";
            }
        }

        c5_p506_4 = c5_p506_4_RadioGroup.indexOfChild(c5_p506_4_RadioGroup.findViewById(c5_p506_4_RadioGroup.getCheckedRadioButtonId()))+"";
        c5_p507 = c5_p507_RadioGroup.indexOfChild(c5_p507_RadioGroup.findViewById(c5_p507_RadioGroup.getCheckedRadioButtonId()))+"";
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
            informanteSpinner.setSelection(Integer.parseInt(modulo5.getIdInformante()));

            if (!modulo5.getC5_p501().equals("")) c5_p501 = Integer.parseInt(modulo5.getC5_p501());
            if(!modulo5.getC5_p506_1().equals("-1") && !modulo5.getC5_p506_1().equals(""))((RadioButton)c5_p506_1_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p506_1()))).setChecked(true);
            if (!modulo5.getC5_p506_2().equals("")) c5_p506_2o3_EditText.setText(modulo5.getC5_p506_2());
            if (!modulo5.getC5_p506_3().equals("")) c5_p506_2o3_EditText.setText(modulo5.getC5_p506_3());
            if(!modulo5.getC5_p506_4().equals("-1") && !modulo5.getC5_p506_4().equals(""))((RadioButton)c5_p506_4_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p506_4()))).setChecked(true);
            if (modulo5.getC5_p507() != null){
                if(!modulo5.getC5_p507().equals("-1") && !modulo5.getC5_p507().equals(""))((RadioButton)c5_p507_RadioGroup.getChildAt(Integer.parseInt(modulo5.getC5_p507()))).setChecked(true);

            }
            if(!modulo5.getC5_p507_dep().equals("")){
                String codUbigeo = modulo5.getC5_p507_dep()+modulo5.getC5_p507_prov()+modulo5.getC5_p507_dist();
                Ubigeo ubigeo = data.getUbigeoxId(codUbigeo);
                c5_p507_dep = ubigeo.getCod_departamento();
                c5_p507_prov = ubigeo.getCod_provincia();
                c5_p507_dist = ubigeo.getCod_distrito();
                txtDepartamento.setText(ubigeo.getNom_departamento());
                txtProvincia.setText(ubigeo.getNom_provincia());
                txtDistrito.setText(ubigeo.getNom_distrito());
            }
            idVivienda = modulo5.getIdVivienda();
        }
        Marco marco = data.getMarco(idVivienda);
        marco_dep = marco.getCcdd();
        marco_prov = marco.getCcpp();
        marco_dist = marco.getCcdi();
        Log.e("cod_dep", "cargarDatos: "+ marco.getCcdd());
        Log.e("cod_prov", "cargarDatos: "+ marco.getCcpp());
        Log.e("cod_dist", "cargarDatos: "+ marco.getCcdi());
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p506,idEncuestado)) m5_p506_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p507,idEncuestado)) m5_p507_linearlayout.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if (c5_p506_1.equals("-1")){
            mostrarMensaje("PREGUNTA 506: DEBE SELECCIONAR UNA OPCION");
            return false;
        }else{
            if (c5_p506_1.equals("2")) {
                if (c5_p506_3.equals("")){mostrarMensaje("PREGUNTA 506- AÑO o GRADO: DEBE COMPLETAR");return false;}
            }else{
                if (c5_p506_2.equals("")){mostrarMensaje("PREGUNTA 506- AÑO o GRADO: DEBE COMPLETAR");return false;}
            }
        }

        if((c5_p506_1.equals("1") && c5_p501>2) || (c5_p506_1.equals("2") && c5_p501>4) ||
            (c5_p506_1.equals("3") && c5_p501>6) || (c5_p506_1.equals("4") && c5_p501>8) ||
            (c5_p506_1.equals("5") && c5_p501>10) || (c5_p506_1.equals("6") && c5_p501>11)){
            mostrarMensaje("GRADO DE ESTUDIOS EN PERÚ NO CONCUERDA CON GRADO DE ESTUDIOS ALCANZADO EN VENEZUELA");

        }

        if (c5_p506_4.equals("-1")){
            mostrarMensaje("PREGUNTA 506 - CENTRO ESTUDIOS: DEBE SELECCIONAR UNA OPCION");
            return false;
        }

        if (c5_p507.equals("-1")){
            mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR UNA OPCION");
            return false;
        }else{
            if (m5_p507_subpregunta_linearlayout.getVisibility()==View.VISIBLE){
                if(txtDepartamento.getText().equals("")){
                    mostrarMensaje("PREGUNTA 507: DEBE INDICAR EL DISTRITO");
                    return false;
                }
                if(c5_p507_dep.equals(marco_dep) && c5_p507_prov.equals(marco_prov) && c5_p507_dist.equals(marco_dist)){
                    mostrarMensaje("PREGUNTA 507: INDICÓ OPCIÓN (OTRO DISTRITO), LOS UBIGEOS NO PUEDEN SER IGUALES");
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

    private void configurarEditText(final EditText editText, final View layoutView, int tipo,int longitud){
        if (tipo == 1) editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud)});

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(editText);
                    layoutView.requestFocus();
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

    public void ocultarOtrosLayouts() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_c5_p508_1,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_2,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_3,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_4,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_5,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_6,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_7,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_8,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_9,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_10,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_11,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_o,"");
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        contentValues = new ContentValues();
        contentValues.put(SQLConstantes.layouts_p508, "0");
        data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
        if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p509,idEncuestado).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p510,idEncuestado).equals("0")&&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p511,idEncuestado).equals("0"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"-1",idEncuestado);

        data.close();
    }

    public boolean verificarCoberturaCapitulo(){
        Data data = new Data(context);
        data.open();
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p501p505,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp501p505,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p506p507,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp506p507,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp508p511,idEncuestado).equals("0")) return false;
        if (data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p512p513,idEncuestado).equals("1") &&
                data.getValor(SQLConstantes.tablacoberturafragments,SQLConstantes.cobertura_fragments_cp512p513,idEncuestado).equals("0")) return false;
        data.close();
        return true;
    }
}
