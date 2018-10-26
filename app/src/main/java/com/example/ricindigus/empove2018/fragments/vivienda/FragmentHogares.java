package com.example.ricindigus.empove2018.fragments.vivienda;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.activities.EncuestaActivity;
import com.example.ricindigus.empove2018.activities.HogarActivity;
import com.example.ricindigus.empove2018.activities.ViviendaActivity;
import com.example.ricindigus.empove2018.adapters.HogarAdapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.TipoFragmentVivienda;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHogares extends FragmentPagina {

    String idVivienda;
    Context context;
    TextView numeroHogaresTextView;
    RecyclerView hogaresRecyclerView;
    FloatingActionButton agregarHogarFAB;
    RecyclerView.LayoutManager layoutManager;
    HogarAdapter hogarAdapter;
    ArrayList<Hogar> hogares;

    @SuppressLint("ValidFragment")
    public FragmentHogares(String idVivienda, Context context) {
        this.idVivienda = idVivienda;
        this.context = context;
    }

    public FragmentHogares() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hogares, container, false);
        numeroHogaresTextView = (TextView) rootView.findViewById(R.id.hogares_textview_numero_hogares);
        hogaresRecyclerView = (RecyclerView) rootView.findViewById(R.id.hogares_recyclerview);
        agregarHogarFAB = (FloatingActionButton) rootView.findViewById(R.id.hogares_fab);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hogaresRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        hogaresRecyclerView.setLayoutManager(layoutManager);
        inicializarDatos();
        setearAdapter();

        agregarHogarFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_jefe_hogar, null);
                final EditText jefeEditText = (EditText) dialogView.findViewById(R.id.dialog_jefe_edittext_nombre);
                jefeEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(50)});
                alert.setTitle("AGREGAR HOGAR");
                alert.setView(dialogView);
                alert.setPositiveButton("Agregar",null);
                alert.setNegativeButton("Cancelar",null);
                final AlertDialog alertDialog = alert.create();

                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        Button btnAdd = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        btnAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // TODO Do something
                                if(!jefeEditText.getText().toString().trim().equals("")){
                                    Hogar hogar = new Hogar();
                                    hogar.set_id(idVivienda+"_"+hogares.size()+1);
                                    hogar.setId_vivienda(idVivienda);
                                    hogar.setNumero((hogares.size()+1)+"");
                                    hogar.setNom_ape(jefeEditText.getText().toString());
                                    hogar.setEstado("0");
                                    Data data = new Data(context);
                                    data.open();
                                    data.insertarElemento(getNombreTabla(),hogar.toValues());
                                    data.close();
                                    inicializarDatos();
                                    setearAdapter();
                                    alertDialog.dismiss();
                                }else Toast.makeText(context, "DEBE INDICAR NOMBRES Y APELLIDOS DEL JEDE DE HOGAR", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                alertDialog.show();
            }
        });
        cargarDatos();
    }

    private void inicializarDatos() {
        hogares = new ArrayList<Hogar>();
        Data data = new Data(context);
        data.open();
        hogares = data.getAllHogaresVivienda(idVivienda);
        data.close();
    }

    public void setearAdapter(){
        hogarAdapter = new HogarAdapter(hogares, new HogarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, HogarActivity.class);
                intent.putExtra("idHogar",hogares.get(position).get_id());
                ViviendaActivity viviendaActivity = (ViviendaActivity)getActivity();
                intent.putExtra("nombreUsuario", viviendaActivity.getNombreUsuario());
                startActivity(intent);
            }
        });
        hogaresRecyclerView.setAdapter(hogarAdapter);
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {

    }

    @Override
    public void cargarDatos() {
        Data data = new Data(context);
        data.open();
        if (data.existeElemento(SQLConstantes.tablacaratula,idVivienda)){
            numeroHogaresTextView.setText(data.getCaratula(idVivienda).getT_hogar());
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablahogares;
    }


}
