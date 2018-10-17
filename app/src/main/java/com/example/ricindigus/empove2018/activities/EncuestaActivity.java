package com.example.ricindigus.empove2018.activities;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import com.example.ricindigus.empove2018.adapters.ExpandListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.ricindigus.empove2018.R;

public class EncuestaActivity extends AppCompatActivity{
    private ArrayList<String> listDataHeader;
    private ExpandableListView expListView;
    private HashMap<String, List<String>> listDataChild;
    private ExpandListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        enableExpandableList();
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
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void prepareListData(List<String> listDataHeader, Map<String, List<String>> listDataChild) {
        listDataHeader.add(getString(R.string.modulo_1_menu));
        listDataHeader.add(getString(R.string.modulo_2_menu));
        listDataHeader.add(getString(R.string.modulo_3_menu));
        listDataHeader.add(getString(R.string.modulo_4_menu));
        listDataHeader.add(getString(R.string.modulo_5_menu));
        listDataHeader.add(getString(R.string.modulo_6_menu));
        listDataHeader.add(getString(R.string.modulo_7_menu));
        listDataHeader.add(getString(R.string.modulo_8_menu));

        List<String> modulo1 = new ArrayList<String>();
        modulo1.add(getString(R.string.modulo_1_submenu_1));
        modulo1.add(getString(R.string.modulo_1_submenu_2));
        modulo1.add(getString(R.string.modulo_1_submenu_3));
        modulo1.add(getString(R.string.modulo_1_submenu_4));
        modulo1.add(getString(R.string.modulo_1_submenu_5));
        modulo1.add(getString(R.string.modulo_1_submenu_6));

        List<String> modulo2 = new ArrayList<String>();
        modulo2.add(getString(R.string.modulo_2_submenu_1));
        modulo2.add(getString(R.string.modulo_2_submenu_2));

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
        modulo4.add(getString(R.string.modulo_4_submenu_5));

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
        modulo6.add(getString(R.string.modulo_6_submenu_9));

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

        listDataChild.put(listDataHeader.get(0), modulo1);
        listDataChild.put(listDataHeader.get(1), modulo2);
        listDataChild.put(listDataHeader.get(2), modulo3);
        listDataChild.put(listDataHeader.get(3), modulo4);
        listDataChild.put(listDataHeader.get(4), modulo5);
        listDataChild.put(listDataHeader.get(5), modulo6);

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
