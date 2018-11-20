package com.example.ricindigus.empove2018.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
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
import com.example.ricindigus.empove2018.fragments.hogar.FragmentFuncionarios;
import com.example.ricindigus.empove2018.fragments.hogar.FragmentVisitasEncuestador;
import com.example.ricindigus.empove2018.fragments.hogar.FragmentVisitasSupervisor;
import com.example.ricindigus.empove2018.fragments.modulo1.FragmentP101P107;
import com.example.ricindigus.empove2018.fragments.modulo1.FragmentP108P113;
import com.example.ricindigus.empove2018.fragments.modulo2.FragmentP201P206;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.TipoFragmentHogar;
import com.example.ricindigus.empove2018.util.TipoFragmentVivienda;

public class HogarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private String idHogar;
    private String idVivienda;
    private String nombreUsuario;
    private Hogar hogar;
    private TextView btnAtras;
    private TextView btnSiguiente;
    int tFragment = 1;
    FragmentPagina fragmentActual;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hogar);
        btnAtras = (TextView) findViewById(R.id.boton_anterior);
        btnSiguiente = (TextView) findViewById(R.id.boton_siguiente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        idHogar = getIntent().getExtras().getString("idHogar");
        nombreUsuario = getIntent().getExtras().getString("nombreUsuario");


        Data data = new Data(this);
        data.open();
        hogar = data.getHogar(idHogar);
        data.close();

        idVivienda = hogar.getId_vivienda();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("HOGAR N° " + hogar.getNumero());
        getSupportActionBar().setSubtitle("JEFE: " + hogar.getNom_ape());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView txtHeaderVivienda = (TextView) headerView.findViewById(R.id.txtTituloHogar);
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
//                setFragment(tFragment,-1);
                while(!setFragment(tFragment,-1)){
                    tFragment--;
                }
            }
        });

        setFragment(TipoFragmentVivienda.CARATULA,1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            salirActivityHogar();
        }
    }

    public void habilitarFragment(int tipoFragment){
        Data data =  new Data(this);
        data.open();
        switch (tipoFragment){
            case TipoFragmentHogar.VISITAS_ENCUESTADOR:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_visitas_encuestador,idHogar).equals("0"))
                    data.actualizarValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_visitas_encuestador,"1",idHogar);
                break;
            case TipoFragmentHogar.VISITAS_SUPERVISOR:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_visitas_supervisor,idHogar).equals("0"))
                    data.actualizarValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_visitas_supervisor,"1",idHogar);
                break;
            case TipoFragmentHogar.FUNCIONARIOS:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_funcionarios,idHogar).equals("0"))
                    data.actualizarValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_funcionarios,"1",idHogar);
                break;
            case TipoFragmentHogar.P101P107:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p101p107,idHogar).equals("0"))
                    data.actualizarValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p101p107,"1",idHogar);
                break;
            case TipoFragmentHogar.P108P113:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p108p113,idHogar).equals("0"))
                    data.actualizarValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p108p113,"1",idHogar);
                break;
            case TipoFragmentHogar.P201P206:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p201p207,idHogar).equals("0"))
                    data.actualizarValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p201p207,"1",idHogar);
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
            case TipoFragmentHogar.VISITAS_ENCUESTADOR:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_visitas_encuestador,idHogar).equals("0")) valido = false;
                break;
            case TipoFragmentHogar.VISITAS_SUPERVISOR:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_visitas_supervisor,idHogar).equals("0")
                        || data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_visitas_supervisor,idHogar).equals("-1")) valido = false;
                break;
            case TipoFragmentHogar.FUNCIONARIOS:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_funcionarios,idHogar).equals("0")) valido = false;
                break;
            case TipoFragmentHogar.P101P107:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p101p107,idHogar).equals("0")
                        || data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p101p107,idHogar).equals("-1")) valido = false;
                break;
            case TipoFragmentHogar.P108P113:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p108p113,idHogar).equals("0")) valido = false;
                break;
            case TipoFragmentHogar.P201P206:
                if (data.getValor(SQLConstantes.tablafragmentshogar,SQLConstantes.fragments_hogar_p201p207,idHogar).equals("0")) valido = false;
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
                case TipoFragmentHogar.VISITAS_ENCUESTADOR:
                    btnAtras.setVisibility(View.GONE);
                    btnSiguiente.setVisibility(View.VISIBLE);
                    FragmentVisitasEncuestador fragmentVisitasEncuestador = new FragmentVisitasEncuestador(idHogar,idVivienda,HogarActivity.this);
                    fragmentTransaction.replace(R.id.fragment_layout, fragmentVisitasEncuestador);
                    fragmentActual = fragmentVisitasEncuestador; tFragment = TipoFragmentHogar.VISITAS_ENCUESTADOR;
                    navigationView.setCheckedItem(R.id.nav_visita_encuestador);break;
                case TipoFragmentHogar.VISITAS_SUPERVISOR:
                    FragmentVisitasSupervisor fragmentVisitasSupervisor = new FragmentVisitasSupervisor(idHogar,idVivienda,HogarActivity.this);
                    fragmentTransaction.replace(R.id.fragment_layout, fragmentVisitasSupervisor);
                    fragmentActual = fragmentVisitasSupervisor;tFragment = TipoFragmentHogar.VISITAS_SUPERVISOR;
                    navigationView.setCheckedItem(R.id.nav_visita_supervisor);break;
                case TipoFragmentHogar.FUNCIONARIOS:
                    FragmentFuncionarios fragmentFuncionarios = new FragmentFuncionarios(idHogar,idVivienda,HogarActivity.this);
                    fragmentTransaction.replace(R.id.fragment_layout, fragmentFuncionarios);
                    fragmentActual = fragmentFuncionarios;tFragment = TipoFragmentHogar.FUNCIONARIOS;
                    navigationView.setCheckedItem(R.id.nav_funcionario);break;
                case TipoFragmentHogar.P101P107:
                    FragmentP101P107 fragmentP101P107 = new FragmentP101P107(idHogar,idVivienda,HogarActivity.this);
                    fragmentTransaction.replace(R.id.fragment_layout, fragmentP101P107);
                    fragmentActual = fragmentP101P107;tFragment = TipoFragmentHogar.P101P107;
                    navigationView.setCheckedItem(R.id.nav_p101_p107);break;
                case TipoFragmentHogar.P108P113:
                    FragmentP108P113 fragmentP108P113 = new FragmentP108P113(idHogar,idVivienda,HogarActivity.this);
                    fragmentTransaction.replace(R.id.fragment_layout, fragmentP108P113);
                    fragmentActual = fragmentP108P113;tFragment = TipoFragmentHogar.P108P113;
                    navigationView.setCheckedItem(R.id.nav_p108_p113);break;
                case TipoFragmentHogar.P201P206:
                    btnSiguiente.setVisibility(View.GONE);
                    FragmentP201P206 fragmentP201P206 = new FragmentP201P206(idHogar,idVivienda,HogarActivity.this);
                    fragmentTransaction.replace(R.id.fragment_layout, fragmentP201P206);
                    fragmentActual = fragmentP201P206;tFragment = TipoFragmentHogar.P201P206;
                    navigationView.setCheckedItem(R.id.nav_p201_p206);break;
            }
            fragmentTransaction.commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hogar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_volver_hogares) {
            salirActivityHogar();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean correcto = true;
        switch (id){
            case R.id.nav_visita_encuestador:
                if (!setFragment(TipoFragmentHogar.VISITAS_ENCUESTADOR,0))correcto=false;
                break;
            case R.id.nav_visita_supervisor:
                if (!setFragment(TipoFragmentHogar.VISITAS_SUPERVISOR,0))correcto=false;
                break;
            case R.id.nav_funcionario:
                if (!setFragment(TipoFragmentHogar.FUNCIONARIOS,0))correcto=false;
                break;
            case R.id.nav_p101_p107:
                if (!setFragment(TipoFragmentHogar.P101P107,0))correcto=false;
                break;
            case R.id.nav_p108_p113:
                if (!setFragment(TipoFragmentHogar.P108P113,0))correcto=false;
                break;
            case R.id.nav_p201_p206:
                if (!setFragment(TipoFragmentHogar.P201P206,0))correcto=false;
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return correcto;
    }

    public void salirActivityHogar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Está seguro que desea volver a la lista de hogares?")
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
