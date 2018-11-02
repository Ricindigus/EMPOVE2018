package com.example.ricindigus.empove2018.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.ricindigus.empove2018.adapters.ExpandListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP301P305;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP306P308;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP309;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP310P312;
import com.example.ricindigus.empove2018.fragments.modulo3.FragmentP313P317;
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
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InterfazEncuesta;
import com.example.ricindigus.empove2018.util.TipoFragmentEncuestado;
import com.example.ricindigus.empove2018.util.TipoFragmentVivienda;

public class EncuestaActivity extends AppCompatActivity implements InterfazEncuesta{
    private ArrayList<String> listDataHeader;
    private ExpandableListView expListView;
    private HashMap<String, List<String>> listDataChild;
    private ExpandListAdapter listAdapter;
    private String idEncuestado;
    private String idVivienda;
    private String idHogar;
    private String numero;

    private TextView btnAtras;
    private TextView btnSiguiente;
    int tFragment = 1;
    FragmentPagina fragmentActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        btnAtras = (TextView) findViewById(R.id.boton_anterior);
        btnSiguiente = (TextView) findViewById(R.id.boton_siguiente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idVivienda = getIntent().getExtras().getString("idVivienda");
        idHogar = getIntent().getExtras().getString("idHogar");
        idEncuestado = getIntent().getExtras().getString("idEncuestado");
        numero = getIntent().getExtras().getString("numero");

        Data data =  new Data(this);
        data.open();
        Hogar hogar = data.getHogar(idHogar);
        Residente residente = data.getResidente(idEncuestado);
        data.close();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("RESIDENTE N° " + numero + " - HOGAR N° " + hogar.getNumero() + " - VIVIENDA N° " + hogar.getId_vivienda());
        getSupportActionBar().setSubtitle(residente.getC2_p202());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        enableExpandableList();


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnSiguiente);
                if(fragmentActual.validarDatos()){
                    fragmentActual.guardarDatos();
                    tFragment++;
                    if(tFragment == 31) tFragment = 1;
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
            case TipoFragmentEncuestado.P301P305:
                btnAtras.setVisibility(View.GONE);
                FragmentP301P305 fragmentP301P305 = new FragmentP301P305(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP301P305);
                tFragment = TipoFragmentEncuestado.P301P305;
                fragmentActual = fragmentP301P305;
                break;
            case TipoFragmentEncuestado.P306P308:
                FragmentP306P308 fragmentP306P308 = new FragmentP306P308(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP306P308);
                tFragment = TipoFragmentEncuestado.P306P308;
                fragmentActual = fragmentP306P308;
                break;
            case TipoFragmentEncuestado.P309:
                FragmentP309 fragmentP309 = new FragmentP309(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP309);
                tFragment = TipoFragmentEncuestado.P309;
                fragmentActual = fragmentP309;
                break;
            case TipoFragmentEncuestado.P310P313:
                FragmentP310P312 fragmentP310P312 = new FragmentP310P312(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP310P312);
                tFragment = TipoFragmentEncuestado.P310P313;
                fragmentActual = fragmentP310P312;
                break;
            case TipoFragmentEncuestado.P314P317:
                FragmentP313P317 fragmentP313P317 = new FragmentP313P317(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP313P317);
                tFragment = TipoFragmentEncuestado.P314P317;
                fragmentActual = fragmentP313P317;
                break;
            case TipoFragmentEncuestado.P318:
                FragmentP318 fragmentP318 = new FragmentP318(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP318);
                tFragment = TipoFragmentEncuestado.P318;
                fragmentActual = fragmentP318;
                break;
            case TipoFragmentEncuestado.P401P404:
                FragmentP401P404 fragmentP401P404 = new FragmentP401P404(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP401P404);
                tFragment = TipoFragmentEncuestado.P401P404;
                fragmentActual = fragmentP401P404;
                break;
            case TipoFragmentEncuestado.P405P407:
                FragmentP405P407 fragmentP405P407 = new FragmentP405P407(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP405P407);
                tFragment = TipoFragmentEncuestado.P405P407;
                fragmentActual = fragmentP405P407;
                break;
            case TipoFragmentEncuestado.P408P410:
                FragmentP408P410 fragmentP408P410 = new FragmentP408P410(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP408P410);
                tFragment = TipoFragmentEncuestado.P408P410;
                fragmentActual = fragmentP408P410;
                break;
            case TipoFragmentEncuestado.P411P416:
                FragmentP411P416 fragmentP411P416 = new FragmentP411P416(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP411P416);
                tFragment = TipoFragmentEncuestado.P411P416;
                fragmentActual = fragmentP411P416;
                break;
            case TipoFragmentEncuestado.P501P505:
                FragmentP501P505 fragmentP501P505 = new FragmentP501P505(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP501P505);
                tFragment = TipoFragmentEncuestado.P501P505;
                fragmentActual = fragmentP501P505;
                break;
            case TipoFragmentEncuestado.P506P507:
                FragmentP506P507 fragmentP506P507 = new FragmentP506P507(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP506P507);
                tFragment = TipoFragmentEncuestado.P506P507;
                fragmentActual = fragmentP506P507;
                break;
            case TipoFragmentEncuestado.P508P511:
                FragmentP508P511 fragmentP508P511 = new FragmentP508P511(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP508P511);
                tFragment = TipoFragmentEncuestado.P508P511;
                fragmentActual = fragmentP508P511;
                break;
            case TipoFragmentEncuestado.P512P513:
                FragmentP512P513 fragmentP512P513 = new FragmentP512P513(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP512P513);
                tFragment = TipoFragmentEncuestado.P512P513;
                fragmentActual = fragmentP512P513;
                break;
            case TipoFragmentEncuestado.P601P604:
                FragmentP601P604 fragmentP601P604 = new FragmentP601P604(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP601P604);
                tFragment = TipoFragmentEncuestado.P601P604;
                fragmentActual = fragmentP601P604;
                break;
            case TipoFragmentEncuestado.P605P608:
                FragmentP605P608 fragmentP605P608 = new FragmentP605P608(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP605P608);
                tFragment = TipoFragmentEncuestado.P605P608;
                fragmentActual = fragmentP605P608;
                break;
            case TipoFragmentEncuestado.P609P612:
                FragmentP609P612 fragmentP609P612 = new FragmentP609P612(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP609P612);
                tFragment = TipoFragmentEncuestado.P609P612;
                fragmentActual = fragmentP609P612;
                break;
            case TipoFragmentEncuestado.P613P618:
                FragmentP613P618 fragmentP613P618 = new FragmentP613P618(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP613P618);
                tFragment = TipoFragmentEncuestado.P613P618;
                fragmentActual = fragmentP613P618;
                break;
            case TipoFragmentEncuestado.P619P622:
                FragmentP619P622 fragmentP619P622 = new FragmentP619P622(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP619P622);
                tFragment = TipoFragmentEncuestado.P619P622;
                fragmentActual = fragmentP619P622;
                break;
            case TipoFragmentEncuestado.P623P625:
                FragmentP623P625 fragmentP623P625 = new FragmentP623P625(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP623P625);
                tFragment = TipoFragmentEncuestado.P623P625;
                fragmentActual = fragmentP623P625;
                break;
            case TipoFragmentEncuestado.P626P629:
                FragmentP626P629 fragmentP626P629 = new FragmentP626P629(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP626P629);
                tFragment = TipoFragmentEncuestado.P626P629;
                fragmentActual = fragmentP626P629;
                break;
            case TipoFragmentEncuestado.P630:
                FragmentP630 fragmentP630 = new FragmentP630(idEncuestado,EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP630);
                tFragment = TipoFragmentEncuestado.P630;
                fragmentActual = fragmentP630;
                break;
            case TipoFragmentEncuestado.P701P705:
                FragmentP701P705 fragmentP701P705 = new FragmentP701P705(idEncuestado, EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP701P705);
                tFragment = TipoFragmentEncuestado.P701P705;
                fragmentActual = fragmentP701P705;
                break;
            case TipoFragmentEncuestado.P706P709:
                FragmentP706P709 fragmentP706P709 = new FragmentP706P709(idEncuestado, EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP706P709);
                tFragment = TipoFragmentEncuestado.P706P709;
                fragmentActual = fragmentP706P709;
                break;
            case TipoFragmentEncuestado.P801P804:
                FragmentP801P804 fragmentP801P804 = new FragmentP801P804(idEncuestado, EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP801P804);
                tFragment = TipoFragmentEncuestado.P801P804;
                fragmentActual = fragmentP801P804;
                break;
            case TipoFragmentEncuestado.P805P808:
                FragmentP805P808 fragmentP805P808 = new FragmentP805P808(idEncuestado, EncuestaActivity.this);
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP805P808);
                //tFragment = TipoFragmentEncuestado.P805P808;
                //fragmentActual = fragmentP805P808;
                break;
            case TipoFragmentEncuestado.P809P812:
                FragmentP809P812 fragmentP809P812 = new FragmentP809P812();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP809P812);
                break;
            case TipoFragmentEncuestado.P813P816:
                FragmentP813P816 fragmentP813P816 = new FragmentP813P816();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP813P816);
                break;
            case TipoFragmentEncuestado.P817P820:
                FragmentP817P820 fragmentP817P820 = new FragmentP817P820();
                fragmentTransaction.replace(R.id.fragment_layout, fragmentP817P820);
                break;
            case TipoFragmentEncuestado.P821P823:
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
                            case 0: setFragment(TipoFragmentEncuestado.P301P305,0);tFragment = TipoFragmentEncuestado.P301P305;break;
                            case 1: setFragment(TipoFragmentEncuestado.P306P308,0);tFragment = TipoFragmentEncuestado.P306P308;break;
                            case 2: setFragment(TipoFragmentEncuestado.P309,0);tFragment = TipoFragmentEncuestado.P309;break;
                            case 3: setFragment(TipoFragmentEncuestado.P310P313,0);tFragment = TipoFragmentEncuestado.P310P313;break;
                            case 4: setFragment(TipoFragmentEncuestado.P314P317,0);tFragment = TipoFragmentEncuestado.P314P317;break;
                            case 5: setFragment(TipoFragmentEncuestado.P318,0);tFragment = TipoFragmentEncuestado.P318;break;
                        }break;
                    case 1:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P401P404,0);tFragment = TipoFragmentEncuestado.P401P404;break;
                            case 1: setFragment(TipoFragmentEncuestado.P405P407,0);tFragment = TipoFragmentEncuestado.P405P407;break;
                            case 2: setFragment(TipoFragmentEncuestado.P408P410,0);tFragment = TipoFragmentEncuestado.P408P410;break;
                            case 3: setFragment(TipoFragmentEncuestado.P411P416,0);tFragment = TipoFragmentEncuestado.P411P416;break;
                        }break;
                    case 2:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P501P505,0);tFragment = TipoFragmentEncuestado.P501P505;break;
                            case 1: setFragment(TipoFragmentEncuestado.P506P507,0);tFragment = TipoFragmentEncuestado.P506P507;break;
                            case 2: setFragment(TipoFragmentEncuestado.P508P511,0);tFragment = TipoFragmentEncuestado.P508P511;break;
                            case 3: setFragment(TipoFragmentEncuestado.P512P513,0);tFragment = TipoFragmentEncuestado.P512P513;break;
                        }break;
                    case 3:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P601P604,0);tFragment = TipoFragmentEncuestado.P601P604;break;
                            case 1: setFragment(TipoFragmentEncuestado.P605P608,0);tFragment = TipoFragmentEncuestado.P605P608;break;
                            case 2: setFragment(TipoFragmentEncuestado.P609P612,0);tFragment = TipoFragmentEncuestado.P609P612;break;
                            case 3: setFragment(TipoFragmentEncuestado.P613P618,0);tFragment = TipoFragmentEncuestado.P613P618;break;
                            case 4: setFragment(TipoFragmentEncuestado.P619P622,0);tFragment = TipoFragmentEncuestado.P619P622;break;
                            case 5: setFragment(TipoFragmentEncuestado.P623P625,0);tFragment = TipoFragmentEncuestado.P623P625;break;
                            case 6: setFragment(TipoFragmentEncuestado.P626P629,0);tFragment = TipoFragmentEncuestado.P626P629;break;
                            case 7: setFragment(TipoFragmentEncuestado.P630,0);tFragment = TipoFragmentEncuestado.P630;break;
                        }break;
                    case 4:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P701P705,0);tFragment = TipoFragmentEncuestado.P701P705;break;
                            case 1: setFragment(TipoFragmentEncuestado.P706P709,0);tFragment = TipoFragmentEncuestado.P706P709;break;
                        }break;
                    case 5:
                        switch (childPosition){
                            case 0: setFragment(TipoFragmentEncuestado.P801P804,0);tFragment = TipoFragmentEncuestado.P801P804;break;
                            case 1: setFragment(TipoFragmentEncuestado.P805P808,0);tFragment = TipoFragmentEncuestado.P805P808;break;
                            case 2: setFragment(TipoFragmentEncuestado.P809P812,0);tFragment = TipoFragmentEncuestado.P809P812;break;
                            case 3: setFragment(TipoFragmentEncuestado.P813P816,0);tFragment = TipoFragmentEncuestado.P813P816;break;
                            case 4: setFragment(TipoFragmentEncuestado.P817P820,0);tFragment = TipoFragmentEncuestado.P817P820;break;
                            case 5: setFragment(TipoFragmentEncuestado.P821P823,0);tFragment = TipoFragmentEncuestado.P821P823;break;
                        }break;
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void prepareListData(List<String> listDataHeader, Map<String, List<String>> listDataChild) {
        listDataHeader.add(getString(R.string.modulo_3_menu));
        listDataHeader.add(getString(R.string.modulo_4_menu));
        listDataHeader.add(getString(R.string.modulo_5_menu));
        listDataHeader.add(getString(R.string.modulo_6_menu));
        listDataHeader.add(getString(R.string.modulo_7_menu));
        listDataHeader.add(getString(R.string.modulo_8_menu));

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

        listDataChild.put(listDataHeader.get(0), modulo3);
        listDataChild.put(listDataHeader.get(1), modulo4);
        listDataChild.put(listDataHeader.get(2), modulo5);
        listDataChild.put(listDataHeader.get(3), modulo6);
        listDataChild.put(listDataHeader.get(4), modulo7);
        listDataChild.put(listDataHeader.get(5), modulo8);


    }

    @Override
    public void setFragmentFromOtherFragment(int tipoFragment, String idHogar, String idEncuestado) {
        this.tFragment = tipoFragment;
        this.idHogar = idHogar;
        this.idEncuestado = idEncuestado;
        setFragment(tipoFragment,1);
        btnSiguiente.setVisibility(View.VISIBLE);
    }



    @Override
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
        if (id == R.id.action_volver_residentes) {
            salirActivityEncuestado();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void salirActivityEncuestado(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Está seguro que desea salir de la encuesta y volver a la lista de los residentes del hogar?")
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

    /*

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
