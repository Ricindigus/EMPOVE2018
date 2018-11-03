package com.example.ricindigus.empove2018.fragments.modulo3;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.modelo.pojos.Ubigeo;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP310P312 extends FragmentPagina {
    String idEncuestado;
    Context contexto;
    String idInformante;

    Spinner spInformante;
    CheckBox ckp310_1,ckp310_2,ckp310_3,ckp310_4;
    RadioGroup rgp311;
    AutoCompleteTextView autoCompleteTextView;
    TextView txtDistrito,txtProvincia,txtDepartamento;

    LinearLayout lytp310,lytp311,lytp312;
    private String c3_p310_1;
    private String c3_p310_2;
    private String c3_p310_3;
    private String c3_p310_4;
    private int c3_p311;
    String c3_p312_dist;
    String c3_p312_prov;
    String c3_p312_dep;

    public FragmentP310P312() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP310P312(String idEncuestado, Context contexto) {
        this.idEncuestado = idEncuestado;
        this.contexto = contexto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p310_p312, container, false);
        spInformante = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);
        ckp310_1 = (CheckBox) rootView.findViewById(R.id.mod3_310_checkbox_C3_P310_1);
        ckp310_2 = (CheckBox) rootView.findViewById(R.id.mod3_310_checkbox_C3_P310_2);
        ckp310_3 = (CheckBox) rootView.findViewById(R.id.mod3_310_checkbox_C3_P310_3);
        ckp310_4 = (CheckBox) rootView.findViewById(R.id.mod3_310_checkbox_C3_P310_4);
        autoCompleteTextView = (AutoCompleteTextView) rootView.findViewById(R.id.mod3_312_autocompletetextview);
        txtDistrito = (TextView) rootView.findViewById(R.id.mod3_c312_txtDistrito);
        txtProvincia = (TextView) rootView.findViewById(R.id.mod3_c312_txtProvincia);
        txtDepartamento = (TextView) rootView.findViewById(R.id.mod3_c312_txtDepartamento);
        rgp311 =  (RadioGroup) rootView.findViewById(R.id.mod3_311_radiogroup_C3_P311);
        lytp310 =  (LinearLayout) rootView.findViewById(R.id.layout_m3_p310);
        lytp311 =  (LinearLayout) rootView.findViewById(R.id.layout_m3_p311);
        lytp312 =  (LinearLayout) rootView.findViewById(R.id.layout_m3_p312);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] paises = getResources().getStringArray(R.array.paises);
        Data data = new Data(contexto);
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
                    lytp312.requestFocus();
                    return true;
                }
                return false;
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Data data1 = new Data(contexto);
                data1.open();
                Ubigeo ubigeo = data1.getUbigeo(autoCompleteTextView.getText().toString());
                data1.close();
                txtDepartamento.setText(ubigeo.getNom_departamento());
                txtProvincia.setText(ubigeo.getNom_provincia());
                txtDistrito.setText(ubigeo.getNom_distrito());
                c3_p312_dep = ubigeo.getCod_departamento();
                c3_p312_prov = ubigeo.getCod_provincia();
                c3_p312_dist = ubigeo.getCod_distrito();
                autoCompleteTextView.setText("");
                ocultarTeclado(autoCompleteTextView);
                lytp312.requestFocus();
            }
        });

        ckp310_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ckp310_1.setChecked(false);
                    ckp310_2.setChecked(false);
                    ckp310_3.setChecked(false);
                    ckp310_1.setEnabled(false);
                    ckp310_2.setEnabled(false);
                    ckp310_3.setEnabled(false);
                }else{
                    ckp310_1.setEnabled(true);
                    ckp310_2.setEnabled(true);
                    ckp310_3.setEnabled(true);
                }
            }
        });

        rgp311.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 1:
                        txtDepartamento.setText("");txtProvincia.setText("");txtDistrito.setText("");
                        c3_p312_dep = "";c3_p312_prov = "";c3_p312_dist = "";
                        lytp312.setVisibility(View.GONE);break;
                    case 2:lytp312.setVisibility(View.VISIBLE);break;
                }
            }
        });
        llenarVista();
        cargarDatos();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(contexto);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_c3_p310_1,c3_p310_1);
        contentValues.put(SQLConstantes.modulo3_c3_p310_2,c3_p310_2);
        contentValues.put(SQLConstantes.modulo3_c3_p310_3,c3_p310_3);
        contentValues.put(SQLConstantes.modulo3_c3_p310_4,c3_p310_4);
        contentValues.put(SQLConstantes.modulo3_c3_p311,c3_p311);
        contentValues.put(SQLConstantes.modulo3_c3_p312_dist,c3_p312_dist);
        contentValues.put(SQLConstantes.modulo3_c3_p312_prov,c3_p312_prov);
        contentValues.put(SQLConstantes.modulo3_c3_p312_dep,c3_p312_dep);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = spInformante.getSelectedItemPosition()+"";
        if(ckp310_1.isChecked())c3_p310_1 = "1";else c3_p310_1 = "0";
        if(ckp310_2.isChecked())c3_p310_2 = "1";else c3_p310_2 = "0";
        if(ckp310_3.isChecked())c3_p310_3 = "1";else c3_p310_3 = "0";
        if(ckp310_4.isChecked())c3_p310_4 = "1";else c3_p310_4 = "0";
        c3_p311 = rgp311.indexOfChild(rgp311.findViewById(rgp311.getCheckedRadioButtonId()));

    }

    @Override
    public void cargarDatos() {
        Data data = new Data(contexto);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo3 modulo3 = data.getModulo3(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo3.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spInformante.setAdapter(adapter);
            spInformante.setSelection(Integer.parseInt(modulo3.getIdInformante()));
            if(modulo3.getC3_p310_1().equals("1")) ckp310_1.setChecked(true);
            if(modulo3.getC3_p310_2().equals("1")) ckp310_2.setChecked(true);
            if(modulo3.getC3_p310_3().equals("1")) ckp310_3.setChecked(true);
            if(modulo3.getC3_p310_4().equals("1")) ckp310_4.setChecked(true);
            if(!modulo3.getC3_p311().equals("-1") && !modulo3.getC3_p311().equals(""))((RadioButton)rgp311.getChildAt(Integer.parseInt(modulo3.getC3_p311()))).setChecked(true);
            if(!modulo3.getC3_p312_dep().equals("")){
                String codUbigeo = modulo3.getC3_p312_dep()+modulo3.getC3_p312_prov()+modulo3.getC3_p312_dist();
                Ubigeo ubigeo = data.getUbigeoxId(codUbigeo);
                c3_p312_dep = ubigeo.getCod_departamento();
                c3_p312_prov = ubigeo.getCod_provincia();
                c3_p312_dist = ubigeo.getCod_distrito();
                txtDepartamento.setText(ubigeo.getNom_departamento());
                txtProvincia.setText(ubigeo.getNom_provincia());
                txtDistrito.setText(ubigeo.getNom_distrito());
            }
        }
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(contexto);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p310,idEncuestado)) lytp310.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p311,idEncuestado)) lytp311.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p312,idEncuestado)) lytp312.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(spInformante.getSelectedItemPosition() == 0) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if (lytp310.getVisibility() == View.VISIBLE){
            if (c3_p310_1.equals("0") && c3_p310_2.equals("0") && c3_p310_3.equals("0")
                    && c3_p310_4.equals("0")) {mostrarMensaje("PREGUNTA 310: DEBE MARCAR AL MENOS UNA OPCION");return false;}
        }
        if (c3_p311 == -1){mostrarMensaje("PREGUNTA 311: DEBE MARCAR UNA OPCIÓN"); return false;}
        if(lytp312.getVisibility() == View.VISIBLE){
            if (txtDepartamento.getText().toString().equals("")){mostrarMensaje("PREGUNTA 312: DEBE INDICAR EL UBIGEO"); return false;}
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo3;
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

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
}
