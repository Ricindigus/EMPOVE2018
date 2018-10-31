package com.example.ricindigus.empove2018.fragments.modulo3;


import android.annotation.SuppressLint;
import android.content.ContentValues;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.activities.agregacion.AgregarPersonaActivity;
import com.example.ricindigus.empove2018.adapters.M3Pregunta309Adapter;
import com.example.ricindigus.empove2018.adapters.M3Pregunta318Adapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta318;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.util.FragmentPagina;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP318 extends FragmentPagina {
    String idEncuestado;
    Context contexto;
    String idInformante;
    String idHogar;
    ArrayList<M3Pregunta318> m3Pregunta318s;
    Spinner spInformante;
    RecyclerView recyclerView;
    RadioGroup radioGroup;

    FloatingActionButton fab;
    LinearLayout lytRecyclerP318;
    M3Pregunta318Adapter m3Pregunta318Adapter;
    RecyclerView.LayoutManager layoutManager;

    private int c3_p318;



    public FragmentP318() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentP318(String idEncuestado, Context contexto) {
        this.idEncuestado = idEncuestado;
        this.contexto = contexto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_p318, container, false);
        spInformante = (Spinner) rootview.findViewById(R.id.cabecera_spinner_informante);
        radioGroup = (RadioGroup) rootview.findViewById(R.id.mod3_318_radiogroup_C3_P318);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_p318);
        fab = (FloatingActionButton) rootview.findViewById(R.id.fab_p318);
        lytRecyclerP318 = (LinearLayout) rootview.findViewById(R.id.layout_recycler_p318);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setHasFixedSize(true);
        layoutManager =  new LinearLayoutManager(contexto);
        recyclerView.setLayoutManager(layoutManager);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado = group.indexOfChild(group.findViewById(checkedId));
                if(seleccionado == 1) lytRecyclerP318.setVisibility(View.VISIBLE);
                else {
                    lytRecyclerP318.setVisibility(View.GONE);
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, AgregarPersonaActivity.class);
                intent.putExtra("numero",(m3Pregunta318s.size()+1)+"");
                intent.putExtra("idEncuestado",idEncuestado);
                intent.putExtra("id",idEncuestado+"_persona"+(m3Pregunta318s.size()+1)+"");
                startActivity(intent);
            }
        });
        cargarDatos();

    }


    public void inicializarDatos(){
        m3Pregunta318s = new ArrayList<>();
        Data data =  new Data(contexto);
        data.open();
        m3Pregunta318s = data.getAllM3Pregunta318(idEncuestado);
        data.close();
    }

    public void setearAdapter(){
        m3Pregunta318Adapter =  new M3Pregunta318Adapter(m3Pregunta318s,contexto);
        recyclerView.setAdapter(m3Pregunta318Adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        inicializarDatos();
        setearAdapter();
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(contexto);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo3_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo3_c3_p318,c3_p318+"");
        data.actualizarElemento(SQLConstantes.tablamodulo3,contentValues,idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = spInformante.getSelectedItemPosition()+"";
        c3_p318 = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(contexto);
        data.open();
        if (data.existeElemento(SQLConstantes.tablamodulo3,idEncuestado)){
            Modulo3 modulo3 = data.getModulo3(idEncuestado);
            idHogar = modulo3.getIdHogar();
            idInformante = modulo3.getIdInformante();
            ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(idHogar);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item,residentes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spInformante.setAdapter(adapter);
            spInformante.setSelection(Integer.parseInt(idInformante));
            if(!modulo3.getC3_p318().equals("-1") && !modulo3.getC3_p318().equals(""))((RadioButton)radioGroup.getChildAt(Integer.parseInt(modulo3.getC3_p318()))).setChecked(true);
        }
        data.close();
    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(spInformante.getSelectedItemPosition() == 0) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}
        if (c3_p318 == -1){mostrarMensaje("PREGUNTA 318: DEBE SELECCIONAR UNA OPCION");return false;}
        else{
            if (c3_p318 == 1 && m3Pregunta318s.size() == 0) { mostrarMensaje("DEBE AGREGAR PERSONAS");return false;}
        }
        return true;
    }
    @Override
    public String getNombreTabla() {
        return null;
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
