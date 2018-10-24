package com.example.ricindigus.empove2018.fragments.hogar;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.activities.EncuestaActivity;
import com.example.ricindigus.empove2018.activities.agregacion.AgregarVisitaActivity;
import com.example.ricindigus.empove2018.adapters.VisitaEncuestadorAdapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.VisitaEncuestador;
import com.example.ricindigus.empove2018.util.FragmentPagina;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVisitasEncuestador extends FragmentPagina {

    String idHogar;
    String idVivienda;
    Context context;

    TextView resultadoTextView, fechaTextView;
    FloatingActionButton agregarVisitaFAB;
    RecyclerView visitasRecyclerView;

    ArrayList<VisitaEncuestador> visitaEncuestadors;
    RecyclerView.LayoutManager layoutManager;
    VisitaEncuestadorAdapter visitaEncuestadorAdapter;


    @SuppressLint("ValidFragment")
    public FragmentVisitasEncuestador(String idHogar, String idVivienda, Context context) {
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        this.context = context;
    }

    public FragmentVisitasEncuestador() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_visitas_encuestador, container, false);
        resultadoTextView = (TextView) rootView.findViewById(R.id.visitas_encuestador_resultado_textview);
        fechaTextView = (TextView) rootView.findViewById(R.id.visitas_encuestador_fecha_textview);
        agregarVisitaFAB = (FloatingActionButton) rootView.findViewById(R.id.visitas_encuestador_fab);
        visitasRecyclerView = (RecyclerView) rootView.findViewById(R.id.visitas_encuestador_recyclerview);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        visitasRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        visitasRecyclerView.setLayoutManager(layoutManager);
        inicializardatos();
        setearAdapter();

        agregarVisitaFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AgregarVisitaActivity.class);
                intent.putExtra("accion",0);
                intent.putExtra("idVisita",idHogar + "_" + (visitaEncuestadors.size()+1));
                startActivity(intent);
            }
        });
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {

    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablavisitasencuestador;
    }


    public void inicializardatos(){
        visitaEncuestadors = new ArrayList<>();
        Data data =  new Data(context);
        data.open();
        visitaEncuestadors = data.getAllVisitasHogar(idHogar);
        data.close();
    }

    public void setearAdapter(){
        visitaEncuestadorAdapter = new VisitaEncuestadorAdapter(visitaEncuestadors, new VisitaEncuestadorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                if(visitaEncuestadors.get(position).getVis_resu().equals("")){
                    PopupMenu popupMenu = new PopupMenu(context,view);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_visita,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            int opcion = 0;
                            switch(item.getItemId()){
                                case R.id.opcion_finalizar:
                                    opcion = 1;
                                    break;
                                case R.id.opcion_editar:
                                    opcion = 2;
                                    break;
                                case R.id.opcion_eliminar:
                                    opcion = 3;
                                    break;
                            }
                            Intent intent = new Intent(context,AgregarVisitaActivity.class);
                            intent.putExtra("accion",opcion);
                            intent.putExtra("idVisita",visitaEncuestadors.get(position).get_id());
                            startActivity(intent);
                            return true;
                        }
                    });
                    popupMenu.show();
                }
            }
        });
        visitasRecyclerView.setAdapter(visitaEncuestadorAdapter);
    }
}
