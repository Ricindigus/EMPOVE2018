package com.example.ricindigus.empove2018.fragments.modulo4;


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
import android.widget.ArrayAdapter;
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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP408P410 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    Context context;

    Spinner informanteSpinner;

    RadioGroup c4_p408_1_RadioGroup, c4_p408_2_RadioGroup, c4_p408_3_RadioGroup, c4_p408_4_RadioGroup,
        c4_p408_5_RadioGroup, c4_p408_6_RadioGroup;
    RadioGroup c4_p409_RadioGroup, c4_p410_RadioGroup;
    LinearLayout m4_p408_linearlayout, m4_p409_linearlayout, m4_p410_linearlayout;

    private String c4_p408_1;
    private String c4_p408_2;
    private String c4_p408_3;
    private String c4_p408_4;
    private String c4_p408_5;
    private String c4_p408_6;
    private String c4_p409;
    private String c4_p410;

    private int edad, sexo;

    @SuppressLint("ValidFragment")
    public FragmentP408P410(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
//        Data data = new Data(context);
//        data.open();
//        Residente residente = data.getResidente(idEncuestado);
//        if(residente.getC2_p204()=="") sexo = -1; else sexo = Integer.parseInt(residente.getC2_p204());
//        if(residente.getC2_p205_a()=="") edad = 0; else edad = Integer.parseInt(residente.getC2_p205_a());
//        data.close();
    }

    public FragmentP408P410() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p408_p410, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c4_p408_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_408_radiogroup_C4_P408_1);
        c4_p408_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_408_radiogroup_C4_P408_2);
        c4_p408_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_408_radiogroup_C4_P408_3);
        c4_p408_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_408_radiogroup_C4_P408_4);
        c4_p408_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_408_radiogroup_C4_P408_5);
        c4_p408_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_408_radiogroup_C4_P408_6);
        c4_p409_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_409_radiogroup_C4_P409);

        c4_p410_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod4_410_radiogroup_C4_P410);

        m4_p408_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p408);
        m4_p409_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p409);
        m4_p410_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m4_p410);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c4_p409_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c4_p409_RadioGroup.findViewById(c4_p409_RadioGroup.getCheckedRadioButtonId()));
                switch (pos){
                    case 1: m4_p410_linearlayout.setVisibility(View.VISIBLE); break;
                    case 2: m4_p410_linearlayout.setVisibility(View.GONE);
                        limpiar_p410();
                        break;
                }
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
        contentValues.put(SQLConstantes.modulo4_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo4_c4_p408_1,c4_p408_1);
        contentValues.put(SQLConstantes.modulo4_c4_p408_2,c4_p408_2);
        contentValues.put(SQLConstantes.modulo4_c4_p408_3,c4_p408_3);
        contentValues.put(SQLConstantes.modulo4_c4_p408_4,c4_p408_4);
        contentValues.put(SQLConstantes.modulo4_c4_p408_5,c4_p408_5);
        contentValues.put(SQLConstantes.modulo4_c4_p408_6,c4_p408_6);
        contentValues.put(SQLConstantes.modulo4_c4_p409,c4_p409);
        contentValues.put(SQLConstantes.modulo4_c4_p410,c4_p410);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c4_p408_1 = c4_p408_1_RadioGroup.indexOfChild(c4_p408_1_RadioGroup.findViewById(c4_p408_1_RadioGroup.getCheckedRadioButtonId()))+"";
        c4_p408_2 = c4_p408_2_RadioGroup.indexOfChild(c4_p408_2_RadioGroup.findViewById(c4_p408_2_RadioGroup.getCheckedRadioButtonId()))+"";
        c4_p408_3 = c4_p408_3_RadioGroup.indexOfChild(c4_p408_3_RadioGroup.findViewById(c4_p408_3_RadioGroup.getCheckedRadioButtonId()))+"";
        c4_p408_4 = c4_p408_4_RadioGroup.indexOfChild(c4_p408_4_RadioGroup.findViewById(c4_p408_4_RadioGroup.getCheckedRadioButtonId()))+"";
        c4_p408_5 = c4_p408_5_RadioGroup.indexOfChild(c4_p408_5_RadioGroup.findViewById(c4_p408_5_RadioGroup.getCheckedRadioButtonId()))+"";
        c4_p408_6 = c4_p408_6_RadioGroup.indexOfChild(c4_p408_6_RadioGroup.findViewById(c4_p408_6_RadioGroup.getCheckedRadioButtonId()))+"";
        c4_p409 = c4_p409_RadioGroup.indexOfChild(c4_p409_RadioGroup.findViewById(c4_p409_RadioGroup.getCheckedRadioButtonId()))+"";
        c4_p410 = c4_p410_RadioGroup.indexOfChild(c4_p410_RadioGroup.findViewById(c4_p410_RadioGroup.getCheckedRadioButtonId()))+"";
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo4 modulo4 = data.getModulo4(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo4.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            if(!modulo4.getIdInformante().equals(""))informanteSpinner.setSelection(Integer.parseInt(modulo4.getIdInformante()));
            if(!modulo4.getC4_p408_1().equals("-1") && !modulo4.getC4_p408_1().equals(""))((RadioButton)c4_p408_1_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p408_1()))).setChecked(true);
            if(!modulo4.getC4_p408_2().equals("-1") && !modulo4.getC4_p408_2().equals(""))((RadioButton)c4_p408_2_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p408_2()))).setChecked(true);
            if(!modulo4.getC4_p408_3().equals("-1") && !modulo4.getC4_p408_3().equals(""))((RadioButton)c4_p408_3_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p408_3()))).setChecked(true);
            if(!modulo4.getC4_p408_4().equals("-1") && !modulo4.getC4_p408_4().equals(""))((RadioButton)c4_p408_4_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p408_4()))).setChecked(true);
            if(!modulo4.getC4_p408_5().equals("-1") && !modulo4.getC4_p408_5().equals(""))((RadioButton)c4_p408_5_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p408_5()))).setChecked(true);
            if(!modulo4.getC4_p408_6().equals("-1") && !modulo4.getC4_p408_6().equals(""))((RadioButton)c4_p408_6_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p408_6()))).setChecked(true);
            if(!modulo4.getC4_p409().equals("-1") && !modulo4.getC4_p409().equals(""))((RadioButton)c4_p409_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p409()))).setChecked(true);
            if(!modulo4.getC4_p410().equals("-1") && !modulo4.getC4_p410().equals(""))((RadioButton)c4_p410_RadioGroup.getChildAt(Integer.parseInt(modulo4.getC4_p410()))).setChecked(true);
        }
//        inicio();
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p408,idEncuestado)) m4_p408_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p409,idEncuestado)) m4_p409_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p410,idEncuestado)) m4_p410_linearlayout.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(idInformante.equals("0")) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if(m4_p408_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p408_1.equals("-1")){
                mostrarMensaje("PREGUNTA 408-1: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p408_2.equals("-1")){
                mostrarMensaje("PREGUNTA 408-2: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p408_3.equals("-1")){
                mostrarMensaje("PREGUNTA 408-3: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p408_4.equals("-1")){
                mostrarMensaje("PREGUNTA 408-4: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p408_5.equals("-1")){
                mostrarMensaje("PREGUNTA 408-5: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c4_p408_6.equals("-1")){
                mostrarMensaje("PREGUNTA 408-6: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
        }
        if (m4_p409_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p409.equals("-1")){
                mostrarMensaje("PREGUNTA 409: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
        }else c4_p409 = "";

        if (m4_p410_linearlayout.getVisibility()==View.VISIBLE){
            if(c4_p410.equals("-1")){
                mostrarMensaje("PREGUNTA 410: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
        }else c4_p410 = "";

        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo4;
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

    public void limpiar_p409(){
        c4_p409_RadioGroup.clearCheck();
    }

    public void limpiar_p410(){
        c4_p410_RadioGroup.clearCheck();
    }

    public void inicio(){
        if(edad>=0 && edad<=17){
            m4_p409_linearlayout.setVisibility(View.VISIBLE);
            int pos = c4_p409_RadioGroup.indexOfChild(c4_p409_RadioGroup.findViewById(c4_p409_RadioGroup.getCheckedRadioButtonId()));
            if(pos!=1) m4_p410_linearlayout.setVisibility(View.VISIBLE);
        }else{
            limpiar_p409(); limpiar_p410();
            m4_p409_linearlayout.setVisibility(View.GONE);
            m4_p410_linearlayout.setVisibility(View.GONE);

        }
    }
}
