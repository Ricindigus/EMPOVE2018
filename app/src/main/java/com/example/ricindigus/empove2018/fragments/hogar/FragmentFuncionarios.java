package com.example.ricindigus.empove2018.fragments.hogar;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Funcionario;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.modelo.pojos.Marco;
import com.example.ricindigus.empove2018.modelo.pojos.Usuario;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFuncionarios extends FragmentPagina {
    EditText nomEncuestador, nomSupervisor, nomCoordinador;
    EditText dniEncuestador, dniSupervisor, dniCoordinador;

    RadioGroup radiogroupPersonas;
    EditText numeroPersonas;

    String idHogar;
    String idVivienda;
    Context context;

    CardView cvEncuestador, cvsupervisor, cvCoordinador;
    LinearLayout layoutPersonas;

    private String dni_encu;
    private String dni_sup;
    private  String dni_coor;
    private  String nombre_encu;
    private String nombre_sup;
    private String nombre_coord;

    private String nropersonas;
    private int vive;



    @SuppressLint("ValidFragment")
    public FragmentFuncionarios(String idHogar, String idVivienda, Context context) {
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        this.context = context;
    }

    public FragmentFuncionarios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_funcionarios, container, false);
        nomEncuestador = (EditText)rootView.findViewById(R.id.funcionarios_edtnombre_encuestador);
        nomSupervisor = (EditText)rootView.findViewById(R.id.funcionarios_edtnombre_supervisor);
        nomCoordinador = (EditText)rootView.findViewById(R.id.funcionarios_edtnombre_coordinador);
        dniEncuestador = (EditText)rootView.findViewById(R.id.funcionarios_edtdni_encuestador);
        dniSupervisor = (EditText)rootView.findViewById(R.id.funcionarios_edtdni_supervisor);
        dniCoordinador = (EditText)rootView.findViewById(R.id.funcionarios_edtdni_coordinador);
        numeroPersonas = (EditText)rootView.findViewById(R.id.funcionarios_npersonas_hogar);
        radiogroupPersonas = (RadioGroup) rootView.findViewById(R.id.funcionarios_radiogroup_personas);

        cvEncuestador = (CardView) rootView.findViewById(R.id.funcionarios_cvEncuestador);
        cvCoordinador = (CardView) rootView.findViewById(R.id.funcionarios_cvCoordinador);
        cvsupervisor = (CardView) rootView.findViewById(R.id.funcionarios_cvSupervisor);

        layoutPersonas = (LinearLayout) rootView.findViewById(R.id.layout_pregunta15);

        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configurarEditText(dniCoordinador,cvCoordinador,2,8);
        configurarEditText(dniSupervisor,cvsupervisor,2,8);
        configurarEditText(dniEncuestador,cvEncuestador,2,8);

        configurarEditText(numeroPersonas,layoutPersonas,2,2);

        configurarEditText(nomEncuestador,cvEncuestador,0,100);
        configurarEditText(nomSupervisor,cvsupervisor,0,100);
        configurarEditText(nomCoordinador,cvCoordinador,0,100);

        radiogroupPersonas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                controlarEspecifiqueRadio(group, checkedId,1,numeroPersonas);
            }
        });
        cargarDatos();
    }

    private void configurarEditText(final EditText editText, final View viewLayout, int tipo,int longitud){
        switch (tipo){
            case 0:editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud), new InputFilterSoloLetras()});break;
            case 1:editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud)});break;
            case 2:editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(longitud)});
                editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());break;
        }
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(editText);
                    viewLayout.requestFocus();
                    return true;
                }
                return false;
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
    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.funcionarios_dni_encu,dni_encu);
        contentValues.put(SQLConstantes.funcionarios_dni_sup,dni_sup);
        contentValues.put(SQLConstantes.funcionarios_dni_coord,dni_coor);
        contentValues.put(SQLConstantes.funcionarios_nombre_encu,nombre_encu);
        contentValues.put(SQLConstantes.funcionarios_nombre_sup,nombre_sup);
        contentValues.put(SQLConstantes.funcionarios_nombre_coord,nombre_coord);
        if(!data.existeElemento(getNombreTabla(),idVivienda)){
            Funcionario funcionario = new Funcionario();
            funcionario.set_id(idVivienda);
            data.insertarElemento(getNombreTabla(),funcionario.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,idVivienda);

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(SQLConstantes.hogar_vive,vive+"");
//        contentValues1.put(SQLConstantes.hogar_nropersonas,nropersonas);
        data.actualizarElemento(SQLConstantes.tablahogares,contentValues1,idHogar);
        data.close();
    }

    @Override
    public void llenarVariables() {
        dni_encu = dniEncuestador.getText().toString();
        dni_coor = dniCoordinador.getText().toString().trim();
        dni_sup = dniSupervisor.getText().toString().trim();

        nombre_coord = nomCoordinador.getText().toString().trim();
        nombre_sup = nomSupervisor.getText().toString().trim();
        nombre_encu = nomEncuestador.getText().toString().trim();

//        vive = radiogroupPersonas.indexOfChild(radiogroupPersonas.findViewById(radiogroupPersonas.getCheckedRadioButtonId()));
        vive = 1;
//        nropersonas = numeroPersonas.getText().toString().trim();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idVivienda)){
            Funcionario funcionario = data.getFuncionario(idVivienda);

            dniSupervisor.setText(funcionario.getDni_sup());
            dniCoordinador.setText(funcionario.getDni_coor());
            dniEncuestador.setText(funcionario.getDni_encu());

            nomSupervisor.setText(funcionario.getNombre_sup());
            nomCoordinador.setText(funcionario.getNombre_coord());
            nomEncuestador.setText(funcionario.getNombre_encu());

//            Hogar hogar = data.getHogar(idHogar);
//            if(!hogar.getVive().equals("-1") && !hogar.getVive().equals(""))((RadioButton)radiogroupPersonas.getChildAt(Integer.parseInt(hogar.getVive()))).setChecked(true);
//            numeroPersonas.setText(hogar.getNropersonas());
        }else{
            Marco marco = data.getMarco(idVivienda);
            Usuario user = data.getUsuario2(marco.getUsuario_id());
            nomEncuestador.setText(user.getNombre());
            dniEncuestador.setText(user.getDni());
        }
        data.close();
        layoutPersonas.setVisibility(View.GONE);
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if (dni_encu.trim().equals("")){mostrarMensaje("DNI ENCUESTADOR: FALTA COMPLETAR");return false;}
        if (dni_encu.length()!=8){mostrarMensaje("DNI ENCUESTADOR: COMPLETAR 8 DIGITOS");return false;}
        if (nombre_encu.trim().equals("")){mostrarMensaje("NOMBRE ENCUESTADOR: FALTA COMPLETAR");return false;}
        if(!dni_sup.equals("") || !nombre_sup.equals("")){
            if (dni_sup.trim().equals("")){mostrarMensaje("DNI SUPERVISOR: FALTA COMPLETAR");return false;}
            if (dni_sup.length()!=8){mostrarMensaje("DNI SUPERVISOR: COMPLETAR 8 DIGITOS");return false;}
            if (nombre_sup.trim().equals("")){mostrarMensaje("NOMBRE SUPERVISOR: FALTA COMPLETAR");return false;}
        }

        if(!dni_coor.equals("") || !nombre_coord.equals("")) {
            if (dni_coor.trim().equals("")) {
                mostrarMensaje("DNI COORDINADOR: FALTA COMPLETAR");
                return false;
            }
            if (dni_coor.length() != 8) {
                mostrarMensaje("DNI COORDINADOR: COMPLETAR 8 DIGITOS");
                return false;
            }
            if (nombre_coord.trim().equals("")) {
                mostrarMensaje("NOMBRE COORDINADOR: FALTA COMPLETAR");
                return false;
            }
        }
//        if (vive == -1){mostrarMensaje("PREGUNTA 15: DEBE MARCAR UNA OPCIÓN"); return false;}
//        else{
//            if (vive == 1){
//                if (nropersonas.trim().equals("")){mostrarMensaje("PREGUNTA 15: DEBE ESPECIFICAR NUMERO DE PERSONAS");return false;}
//            }
//        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablafuncionarios;
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
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
}
