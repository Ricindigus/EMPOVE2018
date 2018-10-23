package com.example.ricindigus.empove2018.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.ricindigus.empove2018.adapters.ExpandListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.fragments.vivienda.FragmentCaratula;
import com.example.ricindigus.empove2018.fragments.hogar.FragmentFuncionarios;
import com.example.ricindigus.empove2018.fragments.vivienda.FragmentHogares;
import com.example.ricindigus.empove2018.fragments.hogar.FragmentVisitasEncuestador;
import com.example.ricindigus.empove2018.fragments.hogar.FragmentVisitasSupervisor;
import com.example.ricindigus.empove2018.fragments.modulo1.FragmentP101P107;
import com.example.ricindigus.empove2018.fragments.modulo1.FragmentP108P113;
import com.example.ricindigus.empove2018.fragments.modulo2.FragmentP201P206;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP301P305;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP306P308;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP309;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP310P313;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP314P317;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP318;
import com.example.ricindigus.empove2018.fragments.modulo4.FragmentP401P404;
import com.example.ricindigus.empove2018.fragments.modulo4.FragmentP405P407;
import com.example.ricindigus.empove2018.fragments.modulo4.FragmentP408P410;
import com.example.ricindigus.empove2018.fragments.modulo4.FragmentP411P416;
import com.example.ricindigus.empove2018.fragments.modulo5.FragmentP501P505;
import com.example.ricindigus.empove2018.fragments.modulo5.FragmentP506P507;
import com.example.ricindigus.empove2018.fragments.modulo5.FragmentP508P511;
import com.example.ricindigus.empove2018.fragments.modulo5.FragmentP512P513;
import com.example.ricindigus.empove2018.fragments.modulo6.FragmentP601P604;
import com.example.ricindigus.empove2018.fragments.modulo6.FragmentP605P608;
import com.example.ricindigus.empove2018.fragments.modulo6.FragmentP609P612;
import com.example.ricindigus.empove2018.fragments.modulo6.FragmentP613P618;
import com.example.ricindigus.empove2018.fragments.modulo6.FragmentP619P622;
import com.example.ricindigus.empove2018.fragments.modulo6.FragmentP623P625;
import com.example.ricindigus.empove2018.fragments.modulo6.FragmentP626P629;
import com.example.ricindigus.empove2018.fragments.modulo6.FragmentP630;
import com.example.ricindigus.empove2018.fragments.modulo7.FragmentP701P705;
import com.example.ricindigus.empove2018.fragments.modulo7.FragmentP706P709;
import com.example.ricindigus.empove2018.fragments.modulo8.FragmentP801P804;
import com.example.ricindigus.empove2018.fragments.modulo8.FragmentP805P808;
import com.example.ricindigus.empove2018.fragments.modulo8.FragmentP809P812;
import com.example.ricindigus.empove2018.fragments.modulo8.FragmentP813P816;
import com.example.ricindigus.empove2018.fragments.modulo8.FragmentP817P820;
import com.example.ricindigus.empove2018.fragments.modulo8.FragmentP821P823;
import com.example.ricindigus.empove2018.util.TipoFragmentEncuestado;

public class EncuestaActivity extends AppCompatActivity{
    private ArrayList<String> listDataHeader;
    private ExpandableListView expListView;
    private HashMap<String, List<String>> listDataChild;
    private ExpandListAdapter listAdapter;
    private String idEncuestado;
    private Button btnAtras;
    private Button btnSiguiente;
    int tFragment = 1;
    int numeroPaginasTotal = 38;
    TextView txtNombreSeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        txtNombreSeccion = (TextView) findViewById(R.id.textoNombreSeccion);
        btnAtras = (Button) findViewById(R.id.btn_anterior);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        enableExpandableList();


        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (tFragment - 1 >= 1) {
//                    do{
//                        tFragment--;
//                    }while(!validoSetearPagina(tFragment));
//                    setFragment(tFragment, -1);
//                }
                ocultarTeclado(btnAtras);
                if (tFragment - 1 >= 1) {
                    tFragment--;
                    setFragment(tFragment);

                }

            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (validarPagina(tFragment)) {
//                    guardarPagina(tFragment);
//                    do{
//                        if (tFragment + 1 <= numeroPaginasTotal) tFragment++;
//                        else tFragment = 1;
//                    }while(!validoSetearPagina(tFragment));
//                    setPagina(tFragment, 1);
//                    setNombreSeccion(tFragment, 1);
//                }
                ocultarTeclado(btnSiguiente);
                if (tFragment + 1 <= numeroPaginasTotal) tFragment++;
                else tFragment = 1;
                setFragment(tFragment);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void setFragment(int tipoFragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (tipoFragment){
            case TipoFragmentEncuestado.CARATULA:
                txtNombreSeccion.setText("CARÁTULA");
                FragmentCaratula fragmentCaratula = new FragmentCaratula(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentCaratula);
                break;
            case TipoFragmentEncuestado.HOGARES:
                txtNombreSeccion.setText("HOGARES");
                FragmentHogares fragmentHogares = new FragmentHogares(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentHogares);
                break;
            case TipoFragmentEncuestado.VISITAS_ENCUESTADOR:
                txtNombreSeccion.setText("CONTROL DE VISITAS - ENCUESTADOR");
                FragmentVisitasEncuestador fragmentVisitasEncuestador = new FragmentVisitasEncuestador(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentVisitasEncuestador);
                break;
            case TipoFragmentEncuestado.VISITAS_SUPERVISOR:
                txtNombreSeccion.setText("CONTROL DE VISITAS - SUPERVISOR");
                FragmentVisitasSupervisor fragmentVisitasSupervisor = new FragmentVisitasSupervisor(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentVisitasSupervisor);
                break;
            case TipoFragmentEncuestado.FUNCIONARIOS:
                txtNombreSeccion.setText("FUNCIONARIOS DE LA ENCUESTA");
                FragmentFuncionarios fragmentFuncionarios = new FragmentFuncionarios(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentFuncionarios);
                break;
            case TipoFragmentEncuestado.P101P107:
                txtNombreSeccion.setText(getString(R.string.modulo_1_nombre));
                FragmentP101P107 fragmentP101P107 = new FragmentP101P107();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP101P107);
                break;
            case TipoFragmentEncuestado.P108P113:
                txtNombreSeccion.setText(getString(R.string.modulo_1_nombre));
                FragmentP108P113 fragmentP108P113 = new FragmentP108P113();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP108P113);
                break;
            case TipoFragmentEncuestado.P201P206:
                txtNombreSeccion.setText(getString(R.string.modulo_2_nombre));
                FragmentP201P206 fragmentP201P206 = new FragmentP201P206();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP201P206);
                break;
            case TipoFragmentEncuestado.P301P305:
                txtNombreSeccion.setText(getString(R.string.modulo_3_nombre));
                FragmentP301P305 fragmentP301P305 = new FragmentP301P305();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP301P305);
                break;
            case TipoFragmentEncuestado.P306P308:
                txtNombreSeccion.setText(getString(R.string.modulo_3_nombre));
                FragmentP306P308 fragmentP306P308 = new FragmentP306P308();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP306P308);
                break;
            case TipoFragmentEncuestado.P309:
                txtNombreSeccion.setText(getString(R.string.modulo_3_nombre));
                FragmentP309 fragmentP309 = new FragmentP309();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP309);
                break;
            case TipoFragmentEncuestado.P310P313:
                txtNombreSeccion.setText(getString(R.string.modulo_3_nombre));
                FragmentP310P313 fragmentP310P313 = new FragmentP310P313();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP310P313);
                break;
            case TipoFragmentEncuestado.P314P317:
                txtNombreSeccion.setText(getString(R.string.modulo_3_nombre));
                FragmentP314P317 fragmentP314P317 = new FragmentP314P317();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP314P317);
                break;
            case TipoFragmentEncuestado.P318:
                txtNombreSeccion.setText(getString(R.string.modulo_3_nombre));
                FragmentP318 fragmentP318 = new FragmentP318();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP318);
                break;
            case TipoFragmentEncuestado.P401P404:
                txtNombreSeccion.setText(getString(R.string.modulo_4_nombre));
                FragmentP401P404 fragmentP401P404 = new FragmentP401P404();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP401P404);
                break;
            case TipoFragmentEncuestado.P405P407:
                txtNombreSeccion.setText(getString(R.string.modulo_4_nombre));
                FragmentP405P407 fragmentP405P407 = new FragmentP405P407();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP405P407);
                break;
            case TipoFragmentEncuestado.P408P410:
                txtNombreSeccion.setText(getString(R.string.modulo_4_nombre));
                FragmentP408P410 fragmentP408P410 = new FragmentP408P410();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP408P410);
                break;
            case TipoFragmentEncuestado.P411P416:
                txtNombreSeccion.setText(getString(R.string.modulo_4_nombre));
                FragmentP411P416 fragmentP411P416 = new FragmentP411P416();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP411P416);
                break;
            case TipoFragmentEncuestado.P501P505:
                txtNombreSeccion.setText(getString(R.string.modulo_5_nombre));
                FragmentP501P505 fragmentP501P505 = new FragmentP501P505();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP501P505);
                break;
            case TipoFragmentEncuestado.P506P507:
                txtNombreSeccion.setText(getString(R.string.modulo_5_nombre));
                FragmentP506P507 fragmentP506P507 = new FragmentP506P507();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP506P507);
                break;
            case TipoFragmentEncuestado.P508P511:
                txtNombreSeccion.setText(getString(R.string.modulo_5_nombre));
                FragmentP508P511 fragmentP508P511 = new FragmentP508P511();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP508P511);
                break;
            case TipoFragmentEncuestado.P512P513:
                txtNombreSeccion.setText(getString(R.string.modulo_5_nombre));
                FragmentP512P513 fragmentP512P513 = new FragmentP512P513();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP512P513);
                break;
            case TipoFragmentEncuestado.P601P604:
                txtNombreSeccion.setText(getString(R.string.modulo_6_nombre));
                FragmentP601P604 fragmentP601P604 = new FragmentP601P604();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP601P604);
                break;
            case TipoFragmentEncuestado.P605P608:
                txtNombreSeccion.setText(getString(R.string.modulo_6_nombre));
                FragmentP605P608 fragmentP605P608 = new FragmentP605P608();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP605P608);
                break;
            case TipoFragmentEncuestado.P609P612:
                txtNombreSeccion.setText(getString(R.string.modulo_6_nombre));
                FragmentP609P612 fragmentP609P612 = new FragmentP609P612();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP609P612);
                break;
            case TipoFragmentEncuestado.P613P618:
                txtNombreSeccion.setText(getString(R.string.modulo_6_nombre));
                FragmentP613P618 fragmentP613P618 = new FragmentP613P618();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP613P618);
                break;
            case TipoFragmentEncuestado.P619P622:
                txtNombreSeccion.setText(getString(R.string.modulo_6_nombre));
                FragmentP619P622 fragmentP619P622 = new FragmentP619P622();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP619P622);
                break;
            case TipoFragmentEncuestado.P623P625:
                txtNombreSeccion.setText(getString(R.string.modulo_6_nombre));
                FragmentP623P625 fragmentP623P625 = new FragmentP623P625();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP623P625);
                break;
            case TipoFragmentEncuestado.P626P629:
                txtNombreSeccion.setText(getString(R.string.modulo_6_nombre));
                FragmentP626P629 fragmentP626P629 = new FragmentP626P629();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP626P629);
                break;
            case TipoFragmentEncuestado.P630:
                txtNombreSeccion.setText(getString(R.string.modulo_6_nombre));
                FragmentP630 fragmentP630 = new FragmentP630();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP630);
                break;
            case TipoFragmentEncuestado.P701P705:
                txtNombreSeccion.setText(getString(R.string.modulo_7_nombre));
                FragmentP701P705 fragmentP701P705 = new FragmentP701P705();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP701P705);
                break;
            case TipoFragmentEncuestado.P706P709:
                txtNombreSeccion.setText(getString(R.string.modulo_7_nombre));
                FragmentP706P709 fragmentP706P709 = new FragmentP706P709();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP706P709);
                break;
            case TipoFragmentEncuestado.P801P804:
                txtNombreSeccion.setText(getString(R.string.modulo_8_nombre));
                FragmentP801P804 fragmentP801P804 = new FragmentP801P804();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP801P804);
                break;
            case TipoFragmentEncuestado.P805P808:
                txtNombreSeccion.setText(getString(R.string.modulo_8_nombre));
                FragmentP805P808 fragmentP805P808 = new FragmentP805P808();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP805P808);
                break;
            case TipoFragmentEncuestado.P809P812:
                txtNombreSeccion.setText(getString(R.string.modulo_8_nombre));
                FragmentP809P812 fragmentP809P812 = new FragmentP809P812();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP809P812);
                break;
            case TipoFragmentEncuestado.P813P816:
                txtNombreSeccion.setText(getString(R.string.modulo_8_nombre));
                FragmentP813P816 fragmentP813P816 = new FragmentP813P816();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP813P816);
                break;
            case TipoFragmentEncuestado.P817P820:
                txtNombreSeccion.setText(getString(R.string.modulo_8_nombre));
                FragmentP817P820 fragmentP817P820 = new FragmentP817P820();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP817P820);
                break;
            case TipoFragmentEncuestado.P821P823:
                txtNombreSeccion.setText(getString(R.string.modulo_8_nombre));
                FragmentP821P823 fragmentP821P823 = new FragmentP821P823();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP821P823);
                break;
        }
        fragmentTransaction.commit();
    }

    private void enableExpandableList() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        expListView = (ExpandableListView) findViewById(R.id.left_drawer);

        prepareListData(listDataHeader, listDataChild);
        listAdapter = new ExpandListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (groupPosition){
                    case 0:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.CARATULA);tFragment = TipoFragmentEncuestado.CARATULA;break;
                            case 1: setFragment(TipoFragmentEncuestado.HOGARES);tFragment = TipoFragmentEncuestado.HOGARES;break;
                            case 2: setFragment(TipoFragmentEncuestado.VISITAS_ENCUESTADOR);tFragment = TipoFragmentEncuestado.VISITAS_ENCUESTADOR;break;
                            case 3: setFragment(TipoFragmentEncuestado.VISITAS_SUPERVISOR);tFragment = TipoFragmentEncuestado.VISITAS_SUPERVISOR;break;
                            case 4: setFragment(TipoFragmentEncuestado.FUNCIONARIOS);tFragment = TipoFragmentEncuestado.FUNCIONARIOS;break;
                        }break;
                    case 1:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P101P107);tFragment = TipoFragmentEncuestado.P101P107;break;
                            case 1: setFragment(TipoFragmentEncuestado.P108P113);tFragment = TipoFragmentEncuestado.P108P113;break;
                        }break;
                    case 2:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P201P206);tFragment = TipoFragmentEncuestado.P201P206;break;
                        }break;
                    case 3:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P301P305);tFragment = TipoFragmentEncuestado.P301P305;break;
                            case 1: setFragment(TipoFragmentEncuestado.P306P308);tFragment = TipoFragmentEncuestado.P306P308;break;
                            case 2: setFragment(TipoFragmentEncuestado.P309);tFragment = TipoFragmentEncuestado.P309;break;
                            case 3: setFragment(TipoFragmentEncuestado.P310P313);tFragment = TipoFragmentEncuestado.P310P313;break;
                            case 4: setFragment(TipoFragmentEncuestado.P314P317);tFragment = TipoFragmentEncuestado.P314P317;break;
                            case 5: setFragment(TipoFragmentEncuestado.P318);tFragment = TipoFragmentEncuestado.P318;break;
                        }break;
                    case 4:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P401P404);tFragment = TipoFragmentEncuestado.P401P404;break;
                            case 1: setFragment(TipoFragmentEncuestado.P405P407);tFragment = TipoFragmentEncuestado.P405P407;break;
                            case 2: setFragment(TipoFragmentEncuestado.P408P410);tFragment = TipoFragmentEncuestado.P408P410;break;
                            case 3: setFragment(TipoFragmentEncuestado.P411P416);tFragment = TipoFragmentEncuestado.P411P416;break;
                        }break;
                    case 5:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P501P505);tFragment = TipoFragmentEncuestado.P501P505;break;
                            case 1: setFragment(TipoFragmentEncuestado.P506P507);tFragment = TipoFragmentEncuestado.P506P507;break;
                            case 2: setFragment(TipoFragmentEncuestado.P508P511);tFragment = TipoFragmentEncuestado.P508P511;break;
                            case 3: setFragment(TipoFragmentEncuestado.P512P513);tFragment = TipoFragmentEncuestado.P512P513;break;
                        }break;
                    case 6:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P601P604);tFragment = TipoFragmentEncuestado.P501P505;break;
                            case 1: setFragment(TipoFragmentEncuestado.P605P608);tFragment = TipoFragmentEncuestado.P506P507;break;
                            case 2: setFragment(TipoFragmentEncuestado.P609P612);tFragment = TipoFragmentEncuestado.P508P511;break;
                            case 3: setFragment(TipoFragmentEncuestado.P613P618);tFragment = TipoFragmentEncuestado.P512P513;break;
                            case 4: setFragment(TipoFragmentEncuestado.P619P622);tFragment = TipoFragmentEncuestado.P512P513;break;
                            case 5: setFragment(TipoFragmentEncuestado.P623P625);tFragment = TipoFragmentEncuestado.P512P513;break;
                            case 6: setFragment(TipoFragmentEncuestado.P626P629);tFragment = TipoFragmentEncuestado.P626P629;break;
                            case 7: setFragment(TipoFragmentEncuestado.P630);tFragment = TipoFragmentEncuestado.P630;break;
                        }break;
                    case 7:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P701P705);tFragment = TipoFragmentEncuestado.P701P705;break;
                            case 1: setFragment(TipoFragmentEncuestado.P706P709);tFragment = TipoFragmentEncuestado.P706P709;break;
                        }break;
                    case 8:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P801P804);tFragment = TipoFragmentEncuestado.P801P804;break;
                            case 1: setFragment(TipoFragmentEncuestado.P805P808);tFragment = TipoFragmentEncuestado.P805P808;break;
                            case 2: setFragment(TipoFragmentEncuestado.P809P812);tFragment = TipoFragmentEncuestado.P809P812;break;
                            case 3: setFragment(TipoFragmentEncuestado.P813P816);tFragment = TipoFragmentEncuestado.P813P816;break;
                            case 4: setFragment(TipoFragmentEncuestado.P817P820);tFragment = TipoFragmentEncuestado.P817P820;break;
                            case 5: setFragment(TipoFragmentEncuestado.P821P823);tFragment = TipoFragmentEncuestado.P821P823;break;
                        }break;
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void prepareListData(List<String> listDataHeader, Map<String, List<String>> listDataChild) {
        listDataHeader.add(getString(R.string.datos_generales_menu));
        listDataHeader.add(getString(R.string.modulo_1_menu));
        listDataHeader.add(getString(R.string.modulo_2_menu));
        listDataHeader.add(getString(R.string.modulo_3_menu));
        listDataHeader.add(getString(R.string.modulo_4_menu));
        listDataHeader.add(getString(R.string.modulo_5_menu));
        listDataHeader.add(getString(R.string.modulo_6_menu));
        listDataHeader.add(getString(R.string.modulo_7_menu));
        listDataHeader.add(getString(R.string.modulo_8_menu));

        List<String> moduloDatosGenerales = new ArrayList<String>();
        moduloDatosGenerales.add(getString(R.string.datos_generales_submenu_1));
        moduloDatosGenerales.add(getString(R.string.datos_generales_submenu_2));
        moduloDatosGenerales.add(getString(R.string.datos_generales_submenu_3));
        moduloDatosGenerales.add(getString(R.string.datos_generales_submenu_4));
        moduloDatosGenerales.add(getString(R.string.datos_generales_submenu_5));


        List<String> modulo1 = new ArrayList<String>();
        modulo1.add(getString(R.string.modulo_1_submenu_1));
        modulo1.add(getString(R.string.modulo_1_submenu_2));


        List<String> modulo2 = new ArrayList<String>();
        modulo2.add(getString(R.string.modulo_2_submenu_1));


        List<String> modulo3 = new ArrayList<String>();
        modulo3.add(getString(R.string.modulo_3_submenu_1));
        modulo3.add(getString(R.string.modulo_3_submenu_2));
        modulo3.add(getString(R.string.modulo_3_submenu_3));
        modulo3.add(getString(R.string.modulo_3_submenu_4));
        modulo3.add(getString(R.string.modulo_3_submenu_5));
        modulo3.add(getString(R.string.modulo_3_submenu_6));


        List<String> modulo4 = new ArrayList<String>();
        modulo4.add(getString(R.string.modulo_4_submenu_1));
        modulo4.add(getString(R.string.modulo_4_submenu_2));
        modulo4.add(getString(R.string.modulo_4_submenu_3));
        modulo4.add(getString(R.string.modulo_4_submenu_4));

        List<String> modulo5 = new ArrayList<String>();
        modulo5.add(getString(R.string.modulo_5_submenu_1));
        modulo5.add(getString(R.string.modulo_5_submenu_2));
        modulo5.add(getString(R.string.modulo_5_submenu_3));
        modulo5.add(getString(R.string.modulo_5_submenu_4));

        List<String> modulo6 = new ArrayList<String>();
        modulo6.add(getString(R.string.modulo_6_submenu_1));
        modulo6.add(getString(R.string.modulo_6_submenu_2));
        modulo6.add(getString(R.string.modulo_6_submenu_3));
        modulo6.add(getString(R.string.modulo_6_submenu_4));
        modulo6.add(getString(R.string.modulo_6_submenu_5));
        modulo6.add(getString(R.string.modulo_6_submenu_6));
        modulo6.add(getString(R.string.modulo_6_submenu_7));
        modulo6.add(getString(R.string.modulo_6_submenu_8));

        List<String> modulo7 = new ArrayList<String>();
        modulo7.add(getString(R.string.modulo_7_submenu_1));
        modulo7.add(getString(R.string.modulo_7_submenu_2));

        List<String> modulo8 = new ArrayList<String>();
        modulo8.add(getString(R.string.modulo_8_submenu_1));
        modulo8.add(getString(R.string.modulo_8_submenu_2));
        modulo8.add(getString(R.string.modulo_8_submenu_3));
        modulo8.add(getString(R.string.modulo_8_submenu_4));
        modulo8.add(getString(R.string.modulo_8_submenu_5));
        modulo8.add(getString(R.string.modulo_8_submenu_6));

        listDataChild.put(listDataHeader.get(0), moduloDatosGenerales);
        listDataChild.put(listDataHeader.get(1), modulo1);
        listDataChild.put(listDataHeader.get(2), modulo2);
        listDataChild.put(listDataHeader.get(3), modulo3);
        listDataChild.put(listDataHeader.get(4), modulo4);
        listDataChild.put(listDataHeader.get(5), modulo5);
        listDataChild.put(listDataHeader.get(6), modulo6);
        listDataChild.put(listDataHeader.get(7), modulo7);
        listDataChild.put(listDataHeader.get(8), modulo8);


    }



    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.encuesta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/




}
