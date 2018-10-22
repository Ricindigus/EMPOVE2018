package com.example.ricindigus.empove2018.activities;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.fragments.generales.FragmentCaratula;
import com.example.ricindigus.empove2018.fragments.generales.FragmentHogares;
import com.example.ricindigus.empove2018.modelo.pojos.Vivienda;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.TipoFragmentEncuestado;
import com.example.ricindigus.empove2018.util.TipoFragmentVivienda;

public class ViviendaActivity extends AppCompatActivity {

    Toolbar viviendaToolbar;
    TextView anteriorTextView;
    TextView siguienteTextView;
    String idVivienda;
    FragmentPagina fragmentActual;
    int numFragment = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vivienda);
        viviendaToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        anteriorTextView = (TextView) findViewById(R.id.boton_anterior);
        siguienteTextView = (TextView) findViewById(R.id.boton_siguiente);
        String conglomerado = getIntent().getExtras().getString("idConglomerado");
        idVivienda = getIntent().getExtras().getString("idVivienda");
        setSupportActionBar(viviendaToolbar);
        getSupportActionBar().setTitle("VIVIENDA " + idVivienda);
        getSupportActionBar().setSubtitle("CONGLOMERADO" + conglomerado);

        viviendaToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        siguienteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(siguienteTextView);
                if(fragmentActual.validarDatos()){
                    fragmentActual.guardarDatos();
                    if(numFragment == 2) finish();
                    else {
                        numFragment++;
                        setFragment(numFragment,1);
                        siguienteTextView.setText("Finalizar");
                        anteriorTextView.setVisibility(View.VISIBLE);
                    }
                }

            }
        });

        anteriorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(anteriorTextView);
                if(numFragment > 1){
                    numFragment--;
                    setFragment(numFragment,-1);
                    siguienteTextView.setText("Siguiente");
                    anteriorTextView.setVisibility(View.GONE);
                }
                else finish();
            }
        });


        setFragment(TipoFragmentVivienda.CARATULA,1);
    }

    public void setFragment(int tipoFragment, int direccion){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(direccion > 0){
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }else{
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        }
        switch (tipoFragment){
            case TipoFragmentEncuestado.CARATULA:
                FragmentCaratula fragmentCaratula = new FragmentCaratula(idVivienda,ViviendaActivity.this);
                fragmentTransaction.replace(R.id.vivienda_fragment, fragmentCaratula);
                fragmentActual = fragmentCaratula;
                break;
            case TipoFragmentEncuestado.HOGARES:
                FragmentHogares fragmentHogares = new FragmentHogares(idVivienda,ViviendaActivity.this);
                fragmentTransaction.replace(R.id.vivienda_fragment, fragmentHogares);
                fragmentActual = fragmentHogares;
                break;
        }
        fragmentTransaction.commit();
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
