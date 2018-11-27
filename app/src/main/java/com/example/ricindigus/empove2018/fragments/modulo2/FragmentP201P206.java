package com.example.ricindigus.empove2018.fragments.modulo2;


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
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.activities.EncuestaActivity;
import com.example.ricindigus.empove2018.activities.agregacion.AgregarResidenteActivity;
import com.example.ricindigus.empove2018.adapters.ResidenteAdapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP201P206 extends FragmentPagina {

    String idHogar;
    String idVivienda;
    Context context;

    TextView txtNroPersonas;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Residente> residentes;
    ResidenteAdapter residenteAdapter;


    public FragmentP201P206() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP201P206(String idHogar, String idVivienda, Context context) {
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p201_p206, container, false);
        fab = (FloatingActionButton) rootView.findViewById(R.id.mod2_fab);
        txtNroPersonas = (TextView) rootView.findViewById(R.id.mod2_txtNumeroPersonas);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.mod2_recyclerview);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = (residentes.size()+1);
                if (residentes.get(0).getCOB200().equals("1")){
                    Intent intent = new Intent(context, AgregarResidenteActivity.class);
                    intent.putExtra("idEncuestado",idHogar + "_" + num);
                    intent.putExtra("numero", num + "");
                    intent.putExtra("idHogar", idHogar);
                    intent.putExtra("idVivienda", idVivienda);
                    intent.putExtra("idJefeHogar", residentes.get(0).get_id());
                    startActivity(intent);
                }else { mostrarMensaje("ANTES DE INGRESAR ALGÚN MIEMBRO DEL HOGAR, DEBE COMPLETAR LA INFORMACIÓN DEL JEFE DE HOGAR");}

            }
        });
        cargarDatos();
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
        if (data.existeElemento(SQLConstantes.tablahogares,idHogar)){
            Hogar hogar = data.getHogar(idHogar);
            txtNroPersonas.setText(hogar.getNroviven());
        }
        data.close();
    }

    @Override
    public void llenarVista() {

    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean validarDatos() {
        return true;
    }

    @Override
    public String getNombreTabla() {
        return null;
    }

    public void inicializarDatos(){
        residentes = new ArrayList<>();
        Data data =  new Data(context);
        data.open();
        residentes = data.getAllResidentesHogar(idHogar);
        txtNroPersonas.setText(residentes.size()+"");
        data.close();
    }

    public void setearAdapter(){
        residenteAdapter = new ResidenteAdapter(residentes,context, new ResidenteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {

                    final PopupMenu popupMenu = new PopupMenu(context,view);
                    if (residentes.size() == position + 1){
                        popupMenu.getMenuInflater().inflate(R.menu.menu_residente_1,popupMenu.getMenu());
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch(item.getItemId()){
                                    case R.id.opcion_iniciar_encuesta:
                                        Residente residente = residentes.get(0);
                                        if(residente.getC2_p204().equals("")){
                                            Toast.makeText(context, "DEBE COMPLETAR LOS DATOS DEL JEFE DE HOGAR ANTES DE INICIAR LA ENCUESTA", Toast.LENGTH_SHORT).show();
                                        }else{
                                            if (residentes.get(position).getC2_p207().equals("2")){
                                                Toast.makeText(context, "LA ENCUESTA ESta DIRIGIDA SOLO A LA POBLACION VENEZOLANA", Toast.LENGTH_SHORT).show();
                                            }else{
                                                String idEncuestado = residentes.get(position).get_id()+"";
                                                Intent intent1 = new Intent(context, EncuestaActivity.class);
                                                intent1.putExtra("idEncuestado",idEncuestado);
                                                intent1.putExtra("numero", residentes.get(position).getNumero() + "");
                                                intent1.putExtra("idHogar", idHogar);
                                                intent1.putExtra("idVivienda", idVivienda);
                                                startActivity(intent1);
                                            }
                                        }
                                        break;
                                    case R.id.opcion_editar:
                                        Intent intent2 = new Intent(context, AgregarResidenteActivity.class);
                                        intent2.putExtra("idEncuestado",residentes.get(position).get_id()+"");
                                        intent2.putExtra("numero", residentes.get(position).getNumero() + "");
                                        intent2.putExtra("idHogar", idHogar);
                                        intent2.putExtra("idVivienda", idVivienda);
                                        intent2.putExtra("idJefeHogar", residentes.get(0).get_id());
                                        startActivity(intent2);
                                        break;
                                    case R.id.opcion_eliminar:
                                        if (position > 0) deseaEliminarDatos(position);
                                        else
                                            Toast.makeText(context, "NO PUEDE ELIMINAR AL JEFE DE HOGAR", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                                return true;
                            }
                        });
                        popupMenu.show();
                    }else{
                        popupMenu.getMenuInflater().inflate(R.menu.menu_residente_2,popupMenu.getMenu());
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch(item.getItemId()){
                                    case R.id.opcion_iniciar_encuesta:
                                        Residente residente = residentes.get(0);
                                        if(residente.getC2_p204().equals("")){
                                            Toast.makeText(context, "DEBE COMPLETAR LOS DATOS DEL JEFE DE HOGAR ANTES DE INICIAR LA ENCUESTA", Toast.LENGTH_SHORT).show();
                                        }else{
                                            if (residentes.get(position).getC2_p207().equals("2")){
                                                Toast.makeText(context, "LA ENCUESTA ESTA DIRIGIDA SOLO A LA POBLACION VENEZOLANA", Toast.LENGTH_SHORT).show();
                                            }else{
                                                String idEncuestado = residentes.get(position).get_id()+"";
                                                Intent intent1 = new Intent(context, EncuestaActivity.class);
                                                intent1.putExtra("idEncuestado",idEncuestado);
                                                intent1.putExtra("numero", residentes.get(position).getNumero() + "");
                                                intent1.putExtra("idHogar", idHogar);
                                                intent1.putExtra("idVivienda", idVivienda);
                                                startActivity(intent1);
                                            }
                                        }
                                        break;
                                    case R.id.opcion_editar:
                                        Intent intent2 = new Intent(context, AgregarResidenteActivity.class);
                                        intent2.putExtra("idEncuestado",residentes.get(position).get_id()+"");
                                        intent2.putExtra("numero", residentes.get(position).getNumero() + "");
                                        intent2.putExtra("idHogar", idHogar);
                                        intent2.putExtra("idVivienda", idVivienda);
                                        intent2.putExtra("idJefeHogar", residentes.get(0).get_id());
                                        startActivity(intent2);
                                        break;
                                }

                                return true;
                            }
                        });
                        popupMenu.show();
                    }
                }
        });
        recyclerView.setAdapter(residenteAdapter);
    }

    public void eliminarEncuestado(int position){
        Data data = new Data(context);
        data.open();
        String idDelEncuestado = residentes.get(position).get_id();
        data.eliminarDato(SQLConstantes.tablaresidentes,idDelEncuestado);
        data.eliminarDato(SQLConstantes.tablamodulo3,idDelEncuestado);
        data.eliminarDatos(SQLConstantes.tablam3p309rutas,SQLConstantes.modulo3_p309_id_encuestado,idDelEncuestado);
        data.eliminarDatos(SQLConstantes.tablam3p318personas,SQLConstantes.modulo3_p318_idEncuestado,idDelEncuestado);
        data.eliminarDato(SQLConstantes.tablamodulo4,idDelEncuestado);
        data.eliminarDato(SQLConstantes.tablamodulo5,idDelEncuestado);
        data.eliminarDato(SQLConstantes.tablamodulo6,idDelEncuestado);
        data.eliminarDato(SQLConstantes.tablamodulo7,idDelEncuestado);
        data.eliminarDato(SQLConstantes.tablamodulo8,idDelEncuestado);
        inicializarDatos();
        setearAdapter();
        data.close();
    }

    public void deseaEliminarDatos(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("¿Está seguro que desea eliminar el residente?, se perderán todos los datos asociados al encuestado/a")
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
                                eliminarEncuestado(position);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        inicializarDatos();
        setearAdapter();
    }
}
