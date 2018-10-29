package com.example.ricindigus.empove2018.activities.agregacion;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.InterfazOperaciones;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

public class AgregarResidenteActivity extends AppCompatActivity implements InterfazOperaciones{

    TextInputEditText c2_p202_TextInputET, c2_p205_a_TextInputET, c2_p205_m_TextInputET;
    Spinner c2_p203_Spinner,c2_p206_Spinner;
    RadioGroup c2_p204_RadioGroup;
    Toolbar toolbar;

    private String _id;
    private String id_hogar;
    private String id_vivienda;
    private String numero;
    private String id_informante = "";
    private String c2_p202;
    private int c2_p203;
    private int c2_p204;
    private String c2_p205_a;
    private String c2_p205_m;
    private int c2_p206;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_residente);

        _id = getIntent().getExtras().getString("idEncuestado");
        id_hogar = getIntent().getExtras().getString("idHogar");
        id_vivienda = getIntent().getExtras().getString("idVivienda");
        numero = getIntent().getExtras().getString("numero");


        c2_p202_TextInputET = (TextInputEditText) findViewById(R.id.mod2_202_textinputedittext_C2_P202);
        c2_p203_Spinner = (Spinner) findViewById(R.id.mod2_203_spinner_C2_P203);
        c2_p204_RadioGroup = (RadioGroup) findViewById(R.id.mod2_204_radiogroup_C2_P204);
        c2_p205_a_TextInputET = (TextInputEditText) findViewById(R.id.mod2_205_textinputedittext_C2_P205_A);
        c2_p205_m_TextInputET = (TextInputEditText) findViewById(R.id.mod2_205_textinputedittext_C2_P205_M);
        c2_p206_Spinner = (Spinner) findViewById(R.id.mod2_206_spinner_C2_P206);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("AGREGAR RESIDENTE");
        getSupportActionBar().setSubtitle("RESIDENTE Nº " + numero);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        c2_p202_TextInputET.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(40)});


        c2_p205_a_TextInputET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});
        c2_p205_m_TextInputET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        c2_p205_a_TextInputET.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        c2_p205_m_TextInputET.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        cargarDatos();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_guardar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_guardar:
                llenarVariables();
                if (validarDatos()){
                    guardarDatos();
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean validarDatos(){
        if(c2_p202.trim().equals("")){mostrarMensaje("PREGUNTA 202: DEBE INDICAR EL NOMBRE"); return false;}
        if(c2_p203 == 0) {mostrarMensaje("PREGUNTA 203: DEBE INDICSR EL PARENTESCO"); return false;}
        if(c2_p204 == -1) {mostrarMensaje("PREGUNTA 204: DEBE INDICAR EL SEXO"); return false;}
        if(c2_p205_a.trim().equals("") && c2_p205_m.trim().equals("")) {mostrarMensaje("PREGUNTA 205: DEBE INDICAR LA EDAD EN AÑOS O MESES"); return false;}
        if(c2_p206 == 0) {mostrarMensaje("PREGUNTA 206: DEBE INDICAR EL ESTADO CIVIL"); return false;}
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablaresidentes;
    }


    @Override
    public void llenarVariables(){
        id_informante = "";
        c2_p202 = c2_p202_TextInputET.getText().toString();
        c2_p203 = c2_p203_Spinner.getSelectedItemPosition();
        c2_p204 = c2_p204_RadioGroup.indexOfChild(c2_p204_RadioGroup.findViewById(c2_p204_RadioGroup.getCheckedRadioButtonId()));
        c2_p205_a = c2_p205_a_TextInputET.getText().toString();
        c2_p205_m = c2_p205_m_TextInputET.getText().toString();
        c2_p206 = c2_p206_Spinner.getSelectedItemPosition();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(this);
        data.open();
        if(data.existeElemento(getNombreTabla(),_id)){
            Residente residente = data.getResidente(_id);
            c2_p202_TextInputET.setText(residente.getC2_p202());
            c2_p203_Spinner.setSelection(Integer.parseInt(residente.getC2_p203()));
            ((RadioButton)c2_p204_RadioGroup.getChildAt(Integer.parseInt(residente.getC2_p204()))).setChecked(true);
            c2_p205_a_TextInputET.setText(residente.getC2_p205_a());
            c2_p205_m_TextInputET.setText(residente.getC2_p205_m());
            c2_p206_Spinner.setSelection(Integer.parseInt(residente.getC2_p206()));
        }
        data.close();

    }

    @Override
    public void guardarDatos(){

            Data data = new Data(this);
            data.open();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLConstantes.residentes_c2_p202,c2_p202);
            contentValues.put(SQLConstantes.residentes_c2_p203,c2_p203);
            contentValues.put(SQLConstantes.residentes_c2_p204,c2_p204);
            contentValues.put(SQLConstantes.residentes_c2_p205_a,c2_p205_a);
            contentValues.put(SQLConstantes.residentes_c2_p205_m,c2_p205_m);
            contentValues.put(SQLConstantes.residentes_c2_p206,c2_p206);

            if(!data.existeElemento(getNombreTabla(),_id)){
                contentValues.put(SQLConstantes.residentes_id,_id);
                contentValues.put(SQLConstantes.residentes_idHogar, id_hogar);
                contentValues.put(SQLConstantes.residentes_idInformante, id_informante);
                contentValues.put(SQLConstantes.residentes_idVivienda, id_vivienda);
                contentValues.put(SQLConstantes.residentes_numero,numero);
                data.insertarElemento(getNombreTabla(),contentValues);
            }
            data.actualizarElemento(getNombreTabla(),contentValues,_id);
            data.close();

    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void configurarEditText(final EditText editText, final View view, int tipo,int longitud){
        if (tipo == 1) editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
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
        if (tipo == 2) editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
