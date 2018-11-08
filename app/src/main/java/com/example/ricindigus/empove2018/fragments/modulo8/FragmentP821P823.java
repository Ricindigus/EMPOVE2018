package com.example.ricindigus.empove2018.fragments.modulo8;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
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
import com.example.ricindigus.empove2018.modelo.pojos.Modulo8;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP821P823 extends FragmentPagina {

    String idEncuestado;
    Context context;
    String idInformante;
    Spinner informanteSpinner;
    CheckBox c8_p821_1_Checkbox, c8_p821_2_Checkbox, c8_p821_3_Checkbox , c8_p821_4_Checkbox, c8_p821_5_Checkbox,
            c8_p821_6_Checkbox, c8_p821_7_Checkbox, c8_p821_8_Checkbox;
    RadioGroup c8_p822_RadioGroup;
    CheckBox c8_p823_1_Checkbox, c8_p823_2_Checkbox, c8_p823_3_Checkbox , c8_p823_4_Checkbox, c8_p823_5_Checkbox;
    EditText c8_p823_o_EditText;
    LinearLayout m8_p821_linearlayout, m8_p822_linearlayout, m8_p823_linearlayout;

    private String c8_p821_1;
    private String c8_p821_2;
    private String c8_p821_3;
    private String c8_p821_4;
    private String c8_p821_5;
    private String c8_p821_6;
    private String c8_p821_7;
    private String c8_p821_8;
    private String c8_p822;
    private String c8_p823_1;
    private String c8_p823_2;
    private String c8_p823_3;
    private String c8_p823_4;
    private String c8_p823_5;
    private String c8_p823_o;

    @SuppressLint("ValidFragment")
    public FragmentP821P823(String idEncuestado, Context context) {
        this.idEncuestado = idEncuestado;
        this.context = context;
    }

    public FragmentP821P823() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p821_p823, container, false);
        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);
        c8_p821_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_1);
        c8_p821_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_2);
        c8_p821_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_3);
        c8_p821_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_4);
        c8_p821_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_5);
        c8_p821_6_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_6);
        c8_p821_7_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_7);
        c8_p821_8_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_821_checkbox_C8_P821_8);

        c8_p822_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_822_radiogroup_C8_P822);

        c8_p823_1_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_1);
        c8_p823_2_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_2);
        c8_p823_3_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_3);
        c8_p823_4_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_4);
        c8_p823_5_Checkbox = (CheckBox) rootView.findViewById(R.id.mod8_823_checkbox_C8_P823_5);
        c8_p823_o_EditText = (EditText) rootView.findViewById(R.id.mod8_823_edittext_C8_P823_O);

        m8_p821_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p821);
        m8_p822_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p822);
        m8_p823_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p823);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configurarEditText(c8_p823_o_EditText,m8_p823_linearlayout,1,30);
        controlarChecked(c8_p823_5_Checkbox,c8_p823_o_EditText);
        c8_p822_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                switch (seleccionado){
                    case 1:
                        m8_p823_linearlayout.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        c8_p823_1_Checkbox.setChecked(false);
                        c8_p823_2_Checkbox.setChecked(false);
                        c8_p823_3_Checkbox.setChecked(false);
                        c8_p823_4_Checkbox.setChecked(false);
                        c8_p823_5_Checkbox.setChecked(false);
                        c8_p823_o_EditText.setText("");
                        m8_p823_linearlayout.setVisibility(View.GONE);
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
        contentValues.put(SQLConstantes.modulo8_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo8_c8_p821_1,c8_p821_1);
        contentValues.put(SQLConstantes.modulo8_c8_p821_2,c8_p821_2);
        contentValues.put(SQLConstantes.modulo8_c8_p821_3,c8_p821_3);
        contentValues.put(SQLConstantes.modulo8_c8_p821_4,c8_p821_4);
        contentValues.put(SQLConstantes.modulo8_c8_p821_5,c8_p821_5);
        contentValues.put(SQLConstantes.modulo8_c8_p821_6,c8_p821_6);
        contentValues.put(SQLConstantes.modulo8_c8_p821_7,c8_p821_7);
        contentValues.put(SQLConstantes.modulo8_c8_p821_8,c8_p821_8);
        contentValues.put(SQLConstantes.modulo8_c8_p822,c8_p822);
        contentValues.put(SQLConstantes.modulo8_c8_p823_1,c8_p823_1);
        contentValues.put(SQLConstantes.modulo8_c8_p823_2,c8_p823_2);
        contentValues.put(SQLConstantes.modulo8_c8_p823_3,c8_p823_3);
        contentValues.put(SQLConstantes.modulo8_c8_p823_4,c8_p823_4);
        contentValues.put(SQLConstantes.modulo8_c8_p823_5,c8_p823_5);
        contentValues.put(SQLConstantes.modulo8_c8_p823_o,c8_p823_o);
        data.actualizarElemento(getNombreTabla(),contentValues,idEncuestado);
        data.close();

    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition() + "";
        if(c8_p821_1_Checkbox.isChecked()) c8_p821_1 = "1"; else c8_p821_1 = "0";
        if(c8_p821_2_Checkbox.isChecked()) c8_p821_2 = "1"; else c8_p821_2 = "0";
        if(c8_p821_3_Checkbox.isChecked()) c8_p821_3 = "1"; else c8_p821_3 = "0";
        if(c8_p821_4_Checkbox.isChecked()) c8_p821_4 = "1"; else c8_p821_4 = "0";
        if(c8_p821_5_Checkbox.isChecked()) c8_p821_5 = "1"; else c8_p821_5 = "0";
        if(c8_p821_6_Checkbox.isChecked()) c8_p821_6 = "1"; else c8_p821_6 = "0";
        if(c8_p821_7_Checkbox.isChecked()) c8_p821_7 = "1"; else c8_p821_7 = "0";
        if(c8_p821_8_Checkbox.isChecked()) c8_p821_8 = "1"; else c8_p821_8 = "0";
        c8_p822 = c8_p822_RadioGroup.indexOfChild(c8_p822_RadioGroup.findViewById(c8_p822_RadioGroup.getCheckedRadioButtonId()))+"";
        if(c8_p823_1_Checkbox.isChecked()) c8_p823_1 = "1"; else c8_p823_1 = "0";
        if(c8_p823_2_Checkbox.isChecked()) c8_p823_2 = "1"; else c8_p823_2 = "0";
        if(c8_p823_3_Checkbox.isChecked()) c8_p823_3 = "1"; else c8_p823_3 = "0";
        if(c8_p823_4_Checkbox.isChecked()) c8_p823_4 = "1"; else c8_p823_4 = "0";
        if(c8_p823_5_Checkbox.isChecked()) c8_p823_5 = "1"; else c8_p823_5 = "0";
        c8_p823_o = c8_p823_o_EditText.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(), idEncuestado)){
            Modulo8 modulo8 = data.getModulo8(idEncuestado);
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(modulo8.getIdHogar());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            informanteSpinner.setAdapter(adapter);
            informanteSpinner.setSelection(Integer.parseInt(modulo8.getIdInformante()));
            if(modulo8.getC8_p821_1().equals("1")) c8_p821_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p821_2().equals("1")) c8_p821_2_Checkbox.setChecked(true);
            if(modulo8.getC8_p821_3().equals("1")) c8_p821_3_Checkbox.setChecked(true);
            if(modulo8.getC8_p821_4().equals("1")) c8_p821_4_Checkbox.setChecked(true);
            if(modulo8.getC8_p821_5().equals("1")) c8_p821_5_Checkbox.setChecked(true);
            if(modulo8.getC8_p821_6().equals("1")) c8_p821_6_Checkbox.setChecked(true);
            if(modulo8.getC8_p821_7().equals("1")) c8_p821_7_Checkbox.setChecked(true);
            if(modulo8.getC8_p821_8().equals("1")) c8_p821_8_Checkbox.setChecked(true);
            if(!modulo8.getC8_p822().equals("-1")&&!modulo8.getC8_p822().equals(""))((RadioButton)c8_p822_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p822()))).setChecked(true);
            if(modulo8.getC8_p823_1().equals("1")) c8_p823_1_Checkbox.setChecked(true);
            if(modulo8.getC8_p823_2().equals("1")) c8_p823_2_Checkbox.setChecked(true);
            if(modulo8.getC8_p823_3().equals("1")) c8_p823_3_Checkbox.setChecked(true);
            if(modulo8.getC8_p823_4().equals("1")) c8_p823_4_Checkbox.setChecked(true);
            if(modulo8.getC8_p823_5().equals("1")) c8_p823_5_Checkbox.setChecked(true);
            c8_p823_o_EditText.setText(modulo8.getC8_p823_o());
        }
        data.close();
    }

    @Override
    public void llenarVista() {
        Data data = new Data(context);
        data.open();
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p821,idEncuestado)) m8_p821_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p822,idEncuestado)) m8_p822_linearlayout.setVisibility(View.GONE);
        if(data.ocultarLayoutPregunta(SQLConstantes.layouts_p823,idEncuestado)) m8_p823_linearlayout.setVisibility(View.GONE);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if (m8_p821_linearlayout.getVisibility() == View.VISIBLE){
            if(c8_p821_1.equals("0") && c8_p821_2.equals("0") && c8_p821_3.equals("0") && c8_p821_4.equals("0") && c8_p821_5.equals("0") && c8_p821_6.equals("0")
                    && c8_p821_7.equals("0") && c8_p821_8.equals("0")){
                mostrarMensaje("PREGUNTA 821: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
        }
        if(c8_p822.equals("-1")){
            mostrarMensaje("PREGUNTA 822: DEBE SELECCIONAR UNA OPCION");
            return false;
        }

        if (m8_p823_linearlayout.getVisibility() == View.VISIBLE){
            if(c8_p823_1.equals("0") && c8_p823_2.equals("0") && c8_p823_3.equals("0") && c8_p823_4.equals("0") && c8_p823_5.equals("0")){
                mostrarMensaje("PREGUNTA 823: DEBE SELECCIONAR ALGUNA OPCION");
                return false;
            }
            if(c8_p823_5.equals("1")){
                if(c8_p823_o.trim().equals("")){
                    mostrarMensaje("PREGUNTA 823 - OPCION 5: DEBE ESPECIFICAR OTRO");
                    return false;
                }
            }
        }

        return true;
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

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo8;
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void mostrarTeclado(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
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
}
