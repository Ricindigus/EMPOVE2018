package com.example.ricindigus.empove2018.activities.agregacion;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta309;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

public class AgregarRutaActivity extends AppCompatActivity {

    TextInputEditText edtCiudad;
    Spinner spPais;
    Spinner spAnio, spMes;
    Spinner spModo;
    TextView btnCancelar, btnGuardar;
    String _id, idEncuestado, idVivienda;
    int pais,anio,mes;
    String ciudad;
    int modo;
    String numero;
    String pais_nombre;

    String c3_p307_d;
    String c3_p307_m;
    String c3_p307_a;
    String c3_p309_a="";

    LinearLayout layoutCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ruta);

        idEncuestado = getIntent().getExtras().getString("idEncuestado");
        idVivienda = getIntent().getExtras().getString("idVivienda");
        _id = getIntent().getExtras().getString("idRuta");
        numero = getIntent().getExtras().getString("numero");


        spPais = (Spinner) findViewById(R.id.agregar_ruta_spPais);
        edtCiudad = (TextInputEditText) findViewById(R.id.agregar_ruta_edtCiudad);

        spMes = (Spinner) findViewById(R.id.agregar_ruta_spMes);
        spAnio = (Spinner) findViewById(R.id.agregar_ruta_spAnio);

        spModo = (Spinner) findViewById(R.id.agregar_ruta_spModo);
        btnCancelar = (TextView) findViewById(R.id.agregar_ruta_btnCancelar);
        btnGuardar = (TextView) findViewById(R.id.agregar_ruta_btnGuardar);

        layoutCiudad = (LinearLayout) findViewById(R.id.layout_rutas_ciudad);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarDatos()) {
                    guardarDatos();
                    finish();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        configurarEditText(edtCiudad,layoutCiudad,1,20);

        cargarDatos();
    }

    public void cargarDatos(){
        Data data = new Data(this);
        data.open();
        if(data.existeElemento(getNombreTabla(),_id)){
            M3Pregunta309 m3Pregunta309 = data.getM3Pregunta309(_id);
            spPais.setSelection(Integer.parseInt(m3Pregunta309.getC3_p309_p()));
            edtCiudad.setText(m3Pregunta309.getC3_p309_c());
            spModo.setSelection(data.getNumeroRutaPais(m3Pregunta309.getC3_p309_mod()));
            spMes.setSelection(Integer.parseInt(m3Pregunta309.getC3_p309_m_cod()));
            spAnio.setSelection(Integer.parseInt(m3Pregunta309.getC3_p309_a_cod()));
        }
        Modulo3 modulo3 = data.getModulo3(idEncuestado);
        c3_p307_d  = modulo3.getC3_p307_d();
        c3_p307_m  = modulo3.getC3_p307_m();
        c3_p307_a  = modulo3.getC3_p307_a();
        Log.e("c3_p307_d", "cargarDatos: "+c3_p307_d);
        Log.e("c3_p307_m", "cargarDatos: "+c3_p307_m);
        Log.e("c3_p307_a", "cargarDatos: "+c3_p307_a);
    }

    public void llenarVariables(){
        pais = spPais.getSelectedItemPosition();
        pais_nombre = spPais.getSelectedItem().toString();
        ciudad = edtCiudad.getText().toString();
        mes = spMes.getSelectedItemPosition();
        anio = spAnio.getSelectedItemPosition();
        modo = spModo.getSelectedItemPosition();
        c3_p309_a = spAnio.getSelectedItem().toString();
    }

    public void guardarDatos(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_c3_p309_p,data.getCodigoRutaPais(pais));
        contentValues.put(SQLConstantes.modulo3_c3_p309_p_nom,pais_nombre);
        contentValues.put(SQLConstantes.modulo3_c3_p309_c,ciudad);
        contentValues.put(SQLConstantes.modulo3_p309_numero,numero);
        contentValues.put(SQLConstantes.modulo3_c3_p309_mod,modo+"");
        contentValues.put(SQLConstantes.modulo3_c3_p309_m,getResources().getStringArray(R.array.numeros_meses)[mes]);
        contentValues.put(SQLConstantes.modulo3_c3_p309_a,getResources().getStringArray(R.array.numeros_anios)[anio]);
        contentValues.put(SQLConstantes.modulo3_c3_p309_m_cod,mes);
        contentValues.put(SQLConstantes.modulo3_c3_p309_a_cod,anio);


        if(!data.existeElemento(getNombreTabla(),_id)){
            M3Pregunta309 m3Pregunta309 =  new M3Pregunta309();
            m3Pregunta309.set_id(_id);
            m3Pregunta309.setId_encuestado(idEncuestado);
            m3Pregunta309.setId_vivienda(idVivienda);
            data.insertarElemento(getNombreTabla(),m3Pregunta309.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,_id);
        data.close();
    }



    public boolean validarDatos(){
        llenarVariables();
        if(pais == 0){mostrarMensaje("DEBE INDICAR EL PAIS");return false;}
        if(ciudad.trim().equals("")){mostrarMensaje("DEBE INDICAR EL CIUDAD");return false;}
        if(modo == 0){mostrarMensaje("DEBE SELECCIONAR EL MODO DE TRANSPORTE");return false;}
        if(mes == 0){mostrarMensaje("DEBE INDICAR EL MES");return false;}
        if(anio == 0){mostrarMensaje("DEBE INDICAR EL AÑO");return false;}
        if(Integer.parseInt(c3_p307_a)>Integer.parseInt(c3_p309_a)){
            mostrarMensaje("PREGUNTA 309: AÑO DEBE SER MAYOR O IGUAL QUE EL AÑO DE INICIO DE VIAJE("+c3_p307_a+")");return false;
        }else if(Integer.parseInt(c3_p307_a)==Integer.parseInt(c3_p309_a)){
            if(Integer.parseInt(c3_p307_m)>mes){
                mostrarMensaje("PREGUNTA 309: MES DEBE SER MAYOR O IGUAL QUE EL MES DE NACIMENTO("+c3_p307_m+")");return false;
            }
        }
        return true;
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
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public String getNombreTabla(){
        return SQLConstantes.tablam3p309rutas;
    }
}
