package com.example.ricindigus.empove2018.activities.agregacion;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta309;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;

public class AgregarRutaActivity extends AppCompatActivity {

    TextInputEditText edtPais, edtCiudad;
    EditText edtAnio, edtMes;
    Spinner spModo;
    TextView btnCancelar, btnGuardar;
    String _id, idEncuestado;
    String pais, ciudad, anio,mes;
    int modo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ruta);

        idEncuestado = getIntent().getExtras().getString("idEncuestado");
        _id = getIntent().getExtras().getString("idRuta");


        edtPais = (TextInputEditText) findViewById(R.id.agregar_ruta_edtPais);
        edtCiudad = (TextInputEditText) findViewById(R.id.agregar_ruta_edtCiudad);

        edtMes = (EditText) findViewById(R.id.agregar_ruta_edtMes);
        edtAnio = (EditText) findViewById(R.id.agregar_ruta_edtAnio);

        spModo = (Spinner) findViewById(R.id.agregar_ruta_spModo);
        btnCancelar = (TextView) findViewById(R.id.agregar_ruta_btnCancelar);
        btnGuardar = (TextView) findViewById(R.id.agregar_ruta_btnGuardar);


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

    }

    public void llenarVariables(){
        pais = edtPais.getText().toString();
        ciudad = edtCiudad.getText().toString();
        mes = edtMes.getText().toString();
        anio = edtAnio.getText().toString();
        modo = spModo.getSelectedItemPosition();
    }

    public void guardarDatos(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_c3_p309_p,pais);
        contentValues.put(SQLConstantes.modulo3_c3_p309_c,ciudad);
        contentValues.put(SQLConstantes.modulo3_c3_p309_mod,modo+"");
        contentValues.put(SQLConstantes.modulo3_c3_p309_m,mes);
        contentValues.put(SQLConstantes.modulo3_c3_p309_a,anio);

        if(!data.existeElemento(getNombreTabla(),_id)){
            M3Pregunta309 m3Pregunta309 =  new M3Pregunta309();
            m3Pregunta309.set_id(_id);
            m3Pregunta309.setId_encuestado(idEncuestado);
            data.insertarElemento(getNombreTabla(),m3Pregunta309.toValues());
        }
        data.actualizarElemento(getNombreTabla(),contentValues,_id);
        data.close();
    }



    public boolean validarDatos(){
        llenarVariables();
        if(pais.trim().equals("")){mostrarMensaje("DEBE INDICAR EL PAIS");return false;}
        if(ciudad.trim().equals("")){mostrarMensaje("DEBE INDICAR EL CIUDAD");return false;}
        if(modo == 0){mostrarMensaje("DEBE SELECCIONAR EL MODO DE TRANSPORTE");return false;}
        if(mes.trim().equals("")){mostrarMensaje("DEBE INDICAR EL MES");return false;}
        if(anio.trim().equals("")){mostrarMensaje("DEBE INDICAR LA CIUDAD");return false;}
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

    public String getNombreTabla(){
        return SQLConstantes.tablam3p309rutas;
    }
}
