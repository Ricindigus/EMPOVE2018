package com.example.ricindigus.empove2018.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.fragments.vivienda.FragmentCaratula;
import com.example.ricindigus.empove2018.fragments.vivienda.FragmentHogares;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.TipoFragmentVivienda;

public class ViviendaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private String idVivienda;
    public static String vivienda_anio;
    public static String vivienda_mes;
    public static String vivienda_periodo;
    public static String vivienda_conglomerado;
    private String nombreUsuario;
    private String idUsuario;

    private TextView btnAtras;
    private TextView btnSiguiente;
    int tFragment = 1;
    FragmentPagina fragmentActual;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vivienda);
        btnAtras = (TextView) findViewById(R.id.boton_anterior);
        btnSiguiente = (TextView) findViewById(R.id.boton_siguiente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idVivienda = getIntent().getExtras().getString("idVivienda");
        nombreUsuario = getIntent().getExtras().getString("nombreUsuario");
        idUsuario = getIntent().getExtras().getString("idUsuario");
        vivienda_anio = getIntent().getExtras().getString("vivienda_anio");
        vivienda_mes = getIntent().getExtras().getString("vivienda_mes");
        vivienda_periodo = getIntent().getExtras().getString("vivienda_periodo");
        vivienda_conglomerado = getIntent().getExtras().getString("vivienda_conglomerado");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("VIVIENDA N° " + idVivienda);
        getSupportActionBar().setSubtitle("CONGLOMERADO N° " + vivienda_conglomerado);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView txtHeaderVivienda = (TextView) headerView.findViewById(R.id.txtTituloVivienda);
        TextView txtHeaderUsuario = (TextView) headerView.findViewById(R.id.txtTituloUsuario);
        txtHeaderVivienda.setText("VIVIENDA N° " + idVivienda);
        txtHeaderUsuario.setText(nombreUsuario);
        navigationView.setNavigationItemSelectedListener(this);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnSiguiente);
                if(fragmentActual.validarDatos()){
                    fragmentActual.guardarDatos();
                    tFragment++;
                    setFragment(tFragment,1);
                }
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnAtras);
                tFragment--;
                setFragment(tFragment,-1);

            }
        });
        setFragment(TipoFragmentVivienda.CARATULA,1);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            salirActivityVivienda();
        }
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void setFragment(int tipoFragment, int direccion){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(direccion != 0){
            if(direccion > 0){
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
            }else{
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        }
        btnAtras.setVisibility(View.VISIBLE);
        btnSiguiente.setVisibility(View.VISIBLE);
        switch (tipoFragment){
            case TipoFragmentVivienda.CARATULA:
                btnAtras.setVisibility(View.GONE);
                FragmentCaratula fragmentCaratula = new FragmentCaratula(idVivienda,vivienda_mes,vivienda_anio,vivienda_conglomerado,vivienda_periodo,idUsuario,ViviendaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentCaratula);
                fragmentActual = fragmentCaratula;
                tFragment = TipoFragmentVivienda.CARATULA;
                navigationView.setCheckedItem(R.id.nav_caratula);
                break;
            case TipoFragmentVivienda.HOGARES:
                btnSiguiente.setVisibility(View.GONE);
                FragmentHogares fragmentHogares = new FragmentHogares(idVivienda,ViviendaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentHogares);
                fragmentActual = fragmentHogares;
                tFragment = TipoFragmentVivienda.HOGARES;
                navigationView.setCheckedItem(R.id.nav_hogares);
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vivienda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_volver_marco) {
            salirActivityVivienda();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_caratula:
                setFragment(TipoFragmentVivienda.CARATULA,0);
                break;
            case R.id.nav_hogares:
                setFragment(TipoFragmentVivienda.HOGARES,0);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void salirActivityVivienda(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Está seguro que desea volver al marco y salir de la encuesta?")
                .setTitle("Aviso")
                .setCancelable(false)
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Sí",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
