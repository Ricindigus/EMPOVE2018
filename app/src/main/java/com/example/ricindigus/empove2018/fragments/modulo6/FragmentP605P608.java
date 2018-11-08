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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.POJOLayout;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP605P608 extends FragmentPagina {
    String idEncuestado;
    String idInformante;
    Context context;
    Spinner informanteSpinner;

    EditText c6_p605_EditText, c6_p606_EditText, c6_p607_EditText;
    RadioGroup c6_p608_RadioGroup;
    EditText c6_p608_o_EditText;
    LinearLayout m6_p605_linearlayout, m6_p606_linearlayout, m6_p607_linearlayout, m6_p608_linearlayout;

    private String c6_p605;
    private String c6_p606;
    private String c6_p607;
    private String c6_p608;
    private String c6_p608_o;

    @SuppressLint("ValidFragment")
    public FragmentP605P608(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentP605P608() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p605_p608, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

        c6_p605_EditText = (EditText) rootView.findViewById(R.id.mod6_605_edittext_C6_P605);
        c6_p606_EditText = (EditText) rootView.findViewById(R.id.mod6_606_edittext_C6_P606);
        c6_p607_EditText = (EditText) rootView.findViewById(R.id.mod6_607_edittext_C6_P607);
        c6_p608_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod6_608_radiogroup_C6_P608);
        c6_p608_o_EditText = (EditText) rootView.findViewById(R.id.mod6_608_edittext_C6_P608_O);

        m6_p605_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p605);
        m6_p606_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p606);
        m6_p607_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p607);
        m6_p608_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m6_p608);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        c6_p605_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p605_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p605_EditText);
                    m6_p605_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p606_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p606_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p606_EditText);
                    m6_p606_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p607_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p607_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p607_EditText);
                    m6_p607_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p608_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        c6_p608_o_EditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(c6_p608_o_EditText);
                    m6_p608_linearlayout.requestFocus();
                    return true;
                }
                return false;
            }
        });
        c6_p608_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int pos = radioGroup.indexOfChild(c6_p608_RadioGroup.findViewById(c6_p608_RadioGroup.getCheckedRadioButtonId()));
                if(pos==7){
                    c6_p608_o_EditText.setEnabled(true);
                    c6_p608_o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    c6_p608_o_EditText.setText("");
                    c6_p608_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                    c6_p608_o_EditText.setEnabled(false);
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
        contentValues.put(SQLConstantes.modulo6_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo6_c6_p605,c6_p605);
        contentValues.put(SQLConstantes.modulo6_c6_p606,c6_p606);
        contentValues.put(SQLConstantes.modulo6_c6_p607,c6_p607);
        contentValues.put(SQLConstantes.modulo6_c6_p608,c6_p608+"");
        contentValues.put(SQLConstantes.modulo6_c6_p608_o,c6_p608_o);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();
        ocultarOtrosLayouts();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c6_p605 = c6_p605_EditText.getText().toString();
        c6_p606 = c6_p606_EditText.getText().toString();
        c6_p607 = c6_p607_EditText.getText().toString();
        c6_p608 = c6_p608_RadioGroup.indexOfChild(c6_p608_RadioGroup.findViewById(c6_p608_RadioGroup.getCheckedRadioButtonId()))+"";
        c6_p608_o = c6_p608_o_EditText.getText().toString();
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
            c6_p605_EditText.setText(modulo6.getC6_p605());
            c6_p606_EditText.setText(modulo6.getC6_p606());
            c6_p607_EditText.setText(modulo6.getC6_p607());
            if(!modulo6.getC6_p608().equals("-1") && !modulo6.getC6_p608().equals(""))((RadioButton)c6_p608_RadioGroup.getChildAt(Integer.parseInt(modulo6.getC6_p608()))).setChecked(true);
            c6_p608_o_EditText.setText(modulo6.getC6_p608_o());
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

        if(c6_p605.trim().equals("") && m6_p605_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 605: DEBE ESPECIFICAR");return false;
        }
        if(c6_p606.trim().equals("")&& m6_p606_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 606: DEBE ESPECIFICAR");return false;
        }
        if(c6_p607.trim().equals("") && m6_p607_linearlayout.getVisibility()==View.VISIBLE){
            mostrarMensaje("PREGUNTA 607: DEBE ESPECIFICAR");return false;
        }
        if(m6_p608_linearlayout.getVisibility()==View.VISIBLE){
            if(c6_p608.equals("-1")){ mostrarMensaje("PREGUNTA 608: DEBE SELECCIONAR UNA OPCION");return false; }
            if(c6_p608.equals("7")){
                if(c6_p608_o.trim().equals("")){ mostrarMensaje("PREGUNTA 608 - OPCION 7: DEBE ESPECIFICAR OTRO");return false;}
            }
        }else{
            c6_p608 = "";
            c6_p608_o = "";
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

    public void ocultarOtrosLayouts() {
        Data data = new Data(context);
        data.open();
        if (c6_p608.equals("1") || c6_p608.equals("2") || c6_p608.equals("5")){
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo6_c6_p609,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);

            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p609,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);

        }else{
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p609,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
        }
        POJOLayout pojoLayout = data.getLayouts(idEncuestado);

        if (!c6_p608.equals("3") && !c6_p608.equals("4") && !c6_p608.equals("6")){
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.modulo6_c6_p613,"");
            contentValues.put(SQLConstantes.modulo6_c6_p614_mon,"");
            contentValues.put(SQLConstantes.modulo6_c6_p614_esp,"");
            data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);

            contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p613,"0");
            contentValues.put(SQLConstantes.layouts_p614,"0");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
        }else{
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.layouts_p613,"1");
            contentValues.put(SQLConstantes.layouts_p614,"1");
            data.actualizarElemento(SQLConstantes.tablalayouts, contentValues, idEncuestado);
        }
        POJOLayout pojoLayout1 = data.getLayouts(idEncuestado);
        data.close();
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

}
