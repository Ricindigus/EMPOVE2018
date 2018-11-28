package com.example.ricindigus.empove2018.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.fragments.vivienda.FragmentCaratula;
import com.example.ricindigus.empove2018.fragments.vivienda.FragmentHogares;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.TipoFragmentVivienda;

public class ViviendaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private String idVivienda;
    public static String vivienda_anio;
    public static String vivienda_mes;
    public static String vivienda_periodo;
    public static String vivienda_zona;
    private String nickUsuario;
    private String idUsuario;

    private TextView btnAtras;
    private TextView btnSiguiente;
    int tFragment = 1;
    int tFragmentAnterior = 1;
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
        nickUsuario = getIntent().getExtras().getString("nickUsuario");
        idUsuario = getIntent().getExtras().getString("idUsuario");
        vivienda_anio = getIntent().getExtras().getString("vivienda_anio");
        vivienda_mes = getIntent().getExtras().getString("vivienda_mes");
        vivienda_periodo = getIntent().getExtras().getString("vivienda_periodo");
        vivienda_zona = getIntent().getExtras().getString("vivienda_zona");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("VIVIENDA N° " + idVivienda);
        getSupportActionBar().setSubtitle("ZONA N° " + vivienda_zona);

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
        txtHeaderUsuario.setText(nickUsuario);
        navigationView.setNavigationItemSelectedListener(this);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnSiguiente);
                if(fragmentActual.validarDatos()){
                    fragmentActual.guardarDatos();
                    tFragment++;
                    habilitarFragment(tFragment);
                    while(!setFragment(tFragment,1)){
                        tFragment++;
                        habilitarFragment(tFragment);
                    }
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

    public String getNickUsuario() {
        return nickUsuario;
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

    public void habilitarFragment(int tipoFragment){
        Data data =  new Data(this);
        data.open();
        switch (tipoFragment){
            case TipoFragmentVivienda.CARATULA:
                if (data.getValor(SQLConstantes.tablafragmentsvivienda,SQLConstantes.fragments_vivienda_caratula,idVivienda).equals("0"))
                    data.actualizarValor(SQLConstantes.tablafragmentsvivienda,SQLConstantes.fragments_vivienda_caratula,"1",idVivienda);
                break;
            case TipoFragmentVivienda.HOGARES:
                if (data.getValor(SQLConstantes.tablafragmentsvivienda,SQLConstantes.fragments_vivienda_hogares,idVivienda).equals("0"))
                    data.actualizarValor(SQLConstantes.tablafragmentsvivienda,SQLConstantes.fragments_vivienda_hogares,"1",idVivienda);
                break;
        }
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public boolean seteoValido(int tipoFragment){
        boolean valido = true;
        Data data =  new Data(this);
        data.open();
        switch (tipoFragment){
            case TipoFragmentVivienda.CARATULA:
                if (data.getValor(SQLConstantes.tablafragmentsvivienda,SQLConstantes.fragments_vivienda_caratula,idVivienda).equals("0")) valido = false;
                break;
            case TipoFragmentVivienda.HOGARES:
                if (data.getValor(SQLConstantes.tablafragmentsvivienda,SQLConstantes.fragments_vivienda_hogares,idVivienda).equals("0")) valido = false;
                break;
        }
        return valido;
    }

    public boolean setFragment(int tipoFragment, int direccion){
        if (seteoValido(tipoFragment)){
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
                    FragmentCaratula fragmentCaratula = new FragmentCaratula(idVivienda,vivienda_mes,vivienda_anio, vivienda_zona,vivienda_periodo,idUsuario,ViviendaActivity.this);
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
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vivienda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_volver_marco) {
//            salirActivityVivienda();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);

        final int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_volver_marco) {
            salirActivityVivienda();
            return true;
        }else if (id == R.id.action_registrar_observacion) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            final View dialogView = this.getLayoutInflater().inflate(R.layout.dialog_observaciones, null);
            LinearLayout lytObservaciones = dialogView.findViewById(R.id.dialog_lytObservaciones);
            final EditText edtObservaciones = dialogView.findViewById(R.id.dialog_edtObservaciones);
            edtObservaciones.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            dialog.setView(dialogView);
            dialog.setTitle("OBSERVACIONES CARÁTULA");
            dialog.setPositiveButton("Guardar", null);
            dialog.setNegativeButton("Cancelar", null);
            final AlertDialog alertDialog = dialog.create();
            alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    Data data = new Data(ViviendaActivity.this);
                    data.open();
                    edtObservaciones.setText(data.getValor(SQLConstantes.tablacaratula,SQLConstantes.caratula_observaciones,idVivienda));
                    data.close();
                    Button b = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Data data = new Data(ViviendaActivity.this);
                            data.open();
                            data.actualizarValor(SQLConstantes.tablacaratula,SQLConstantes.caratula_observaciones,edtObservaciones.getText().toString(),idVivienda);
                            data.close();
                            alertDialog.dismiss();
                        }
                    });
                }
            });
            alertDialog.show();
            return true;
        }else if (id == R.id.action_finalizar_vivienda){
            Data data = new Data(ViviendaActivity.this);
            data.open();
            if (coberturaViviendaConMensaje()){
                data.actualizarValor(SQLConstantes.tablamarco,SQLConstantes.marco_estado,"1",idVivienda);
                finish();
            }
            else data.actualizarValor(SQLConstantes.tablamarco,SQLConstantes.marco_estado,"0'",idVivienda);
            data.close();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public boolean coberturaViviendaConMensaje(){
        Data data = new Data(ViviendaActivity.this);
        data.open();
        String cobCaratula = data.getValor(SQLConstantes.tablacaratula,SQLConstantes.caratula_cobertura,idVivienda);
        if (!cobCaratula.equals("1")){
            mostrarMensaje("FALTA COBERTURAR LA CARÁTULA, NO SE PUEDE FINALIZAR VIVIENDA");return false;
        }
        if (data.getAllHogaresVivienda(idVivienda).size() > 0){
            for (Hogar hogar : data.getAllHogaresVivienda(idVivienda)){
                if (!hogar.getCobertura().equals("1")) {
                    mostrarMensaje("FALTA COBERTURAR EL HOHAR " + hogar.getNumero());return false;
                }
            }
        }else {
            mostrarMensaje("NO REGISTRO HOGARES, NO SE PUEDE COBERTURAR ESTE MODULO");return false;
        }
        data.close();
        return true;
    }

    public boolean coberturaVivienda(){
        Data data = new Data(ViviendaActivity.this);
        data.open();
        String cobCaratula = data.getValor(SQLConstantes.tablacaratula,SQLConstantes.caratula_cobertura,idVivienda);
        if (!cobCaratula.equals("1")) return false;
        if (data.getAllHogaresVivienda(idVivienda).size() > 0){
            for (Hogar hogar : data.getAllHogaresVivienda(idVivienda)){
                if (!hogar.getCobertura().equals("1")) return false;
            }
        }else return false;
        data.close();
        return true;
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(ViviendaActivity.this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean correcto = true;
        switch (id){
            case R.id.nav_caratula:
                if (!setFragment(TipoFragmentVivienda.CARATULA,0))correcto=false;
                break;
            case R.id.nav_hogares:
                if (!setFragment(TipoFragmentVivienda.HOGARES,0))correcto=false;
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return correcto;
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
                                Data data = new Data(ViviendaActivity.this);
                                data.open();
                                if (coberturaVivienda()) data.actualizarValor(SQLConstantes.tablamarco,SQLConstantes.marco_estado,"1",idVivienda);
                                else data.actualizarValor(SQLConstantes.tablamarco,SQLConstantes.marco_estado,"0",idVivienda);
                                data.close();
                                finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
