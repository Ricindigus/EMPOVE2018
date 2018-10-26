package com.example.ricindigus.empove2018.activities.agregacion;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;

public class AgregarRutaActivity extends AppCompatActivity {

    TextInputEditText edtPais, edtCiudad;
    EditText edtAnio, edtMes;
    Spinner spModo;
    TextView btnCancelar, btnGuardar;

    String pais, ciudad, anio,mes;
    int modo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ruta);

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

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    }

    public void cargarDatos(){}

    public void validarDatos(){

    }
}
