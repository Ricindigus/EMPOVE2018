package com.example.ricindigus.empove2018.activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.adapters.ViviendaAdapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.pojos.Vivienda;

import java.util.ArrayList;

public class MarcoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ViviendaAdapter viviendaAdapter;
    private ArrayList<Vivienda> viviendas;
    private ArrayList<String> anios;
    private ArrayList<String> meses;
    private ArrayList<String> periodos;
    private ArrayList<String> conglomerados;
    private int idUsuario;
    private String permisoUsuario;
    private Spinner spAnio;
    private Spinner spMeses;
    private Spinner spPeriodos;
    private Spinner spConglomerados;
    private Button btnFiltrar;
    private Button btnMostrarTodo;
    private LinearLayoutManager linearLayoutManager;

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marco);
        idUsuario = getIntent().getExtras().getInt("idUsuario");

        spAnio = (Spinner) findViewById(R.id.marco_sp_anio);
        spMeses = (Spinner) findViewById(R.id.marco_sp_mes);
        spPeriodos = (Spinner) findViewById(R.id.marco_sp_periodo);
        spConglomerados = (Spinner) findViewById(R.id.marco_sp_conglomerado);
        btnFiltrar = (Button) findViewById(R.id.marco_btnFiltrar);
        btnMostrarTodo = (Button) findViewById(R.id.marco_btnMotrarTodo);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_encuestado);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        inicializarDatos();
        cargarSpinerAnios(anios);
        cargarSpinerMeses(meses);
        cargarSpinerPeriodos(periodos);
        cargarSpinerConglomerados(conglomerados);
        viviendaAdapter= new ViviendaAdapter(viviendas, new ViviendaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), EncuestaActivity.class);
                intent.putExtra("idEmpresa",viviendas.get(position).get_id());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(viviendaAdapter);



        spAnio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0) obtenerMeses(Integer.parseInt(spAnio.getSelectedItem().toString()));
                if(i == 0) meses = new ArrayList<String>();
                cargarSpinerMeses(meses);
                periodos = new ArrayList<String>();
                cargarSpinerPeriodos(periodos);
                conglomerados = new ArrayList<String>();
                cargarSpinerConglomerados(conglomerados);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spMeses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0) obtenerPeriodos(Integer.parseInt(spMeses.getSelectedItem().toString()));
                if(i == 0) periodos = new ArrayList<String>();
                cargarSpinerPeriodos(periodos);
                conglomerados = new ArrayList<String>();
                cargarSpinerConglomerados(conglomerados);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spPeriodos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0) obtenerConglomerados(Integer.parseInt(spPeriodos.getSelectedItem().toString()));
                if(i == 0) conglomerados = new ArrayList<String>();
                cargarSpinerConglomerados(conglomerados);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conglomerados.size() > 1 && spConglomerados.getSelectedItemPosition() != 0){
                    obtenerMarcoFiltrado(spAnio.getSelectedItem().toString(),
                            spMeses.getSelectedItem().toString(),
                            spPeriodos.getSelectedItem().toString(),
                            spConglomerados.getSelectedItem().toString());
                }else{
                    Toast.makeText(MarcoActivity.this, "DEBE SELECCIONAR TODOS LOS CAMPOS ANTES DE FILTRAR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnMostrarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerMarcoTotal();
                spAnio.setSelection(0);
            }
        });
    }

    public void obtenerMarcoFiltrado(String anio,String mes, String periodo, String conglomerado){
        viviendas = new ArrayList<>();
        Data data = new Data(MarcoActivity.this);
        data.open();
        viviendas = data.getAllViviendasFiltrado(Integer.parseInt(anio), Integer.parseInt(mes),Integer.parseInt(periodo),Integer.parseInt(conglomerado));
        data.close();
        viviendaAdapter= new ViviendaAdapter(viviendas, new ViviendaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), EncuestaActivity.class);
                int idVivienda = viviendas.get(position).get_id();
                intent.putExtra("idVivienda", idVivienda);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(viviendaAdapter);
    }

    public void obtenerMarcoTotal(){
        inicializarDatos();
        cargarSpinerAnios(anios);
        cargarSpinerMeses(meses);
        cargarSpinerPeriodos(periodos);
        cargarSpinerConglomerados(conglomerados);
        viviendaAdapter= new ViviendaAdapter(viviendas, new ViviendaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), EncuestaActivity.class);
                intent.putExtra("idEmpresa",viviendas.get(position).get_id());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(viviendaAdapter);
    }

    public void obtenerMeses(int anio){
        meses = new ArrayList<String>();
        meses.add("Seleccione");
        for(Vivienda vivienda : viviendas){
            if(Integer.parseInt(vivienda.getAnio())== anio){
                if(!meses.contains(String.valueOf(vivienda.getMes()))){
                    meses.add(String.valueOf(vivienda.getMes()));
                }
            }
        }
    }
    public void obtenerPeriodos(int mes){
        periodos = new ArrayList<String>();
        periodos.add("Seleccione");
        for(Vivienda vivienda : viviendas){
            if(Integer.parseInt(vivienda.getMes())== mes){
                if(!periodos.contains(String.valueOf(vivienda.getPeriodo()))){
                    periodos.add(String.valueOf(vivienda.getPeriodo()));
                }
            }
        }
    }
    public void obtenerConglomerados(int periodo){
        conglomerados = new ArrayList<String>();
        conglomerados.add("Seleccione");
        for(Vivienda vivienda : viviendas){
            if(Integer.parseInt(vivienda.getPeriodo())== periodo){
                if(!conglomerados.contains(String.valueOf(vivienda.getConglomerado()))){
                    conglomerados.add(String.valueOf(vivienda.getConglomerado()));
                }
            }
        }
    }

    public void cargarSpinerAnios(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAnio.setAdapter(adapter);
    }
    public void cargarSpinerMeses(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMeses.setAdapter(adapter);
    }

    public void cargarSpinerPeriodos(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPeriodos.setAdapter(adapter);
    }

    public void cargarSpinerConglomerados(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spConglomerados.setAdapter(adapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_marco,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.opcion_exportar:
//                Intent intent = new Intent(MarcoActivity.this,ExportarActivity.class);
//                intent.putExtra("idUsuario",idUsuario);
//                intent.putExtra("permisoUsuario",permisoUsuario);
//                startActivity(intent);
//                return true;
//            case R.id.opcion_importar:
//                Intent intent1 = new Intent(MarcoActivity.this,ImportarActivity.class);
//                startActivity(intent1);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
    @SuppressLint("NewApi")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Está seguro que desea salir de la aplicación?")
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
        return super.onKeyDown(keyCode, event);
    }
    private void inicializarDatos() {
        viviendas = new ArrayList<Vivienda>();
        anios = new ArrayList<String>();
        meses = new ArrayList<String>();
        periodos = new ArrayList<String>();
        conglomerados = new ArrayList<String>();
        data = new Data(this);
        data.open();
        viviendas = data.getAllViviendas(idUsuario);
        data.close();
        anios.add("Seleccione");
        if (viviendas.size()>0) anios.add(String.valueOf(viviendas.get(0).getAnio()));
    }
}
