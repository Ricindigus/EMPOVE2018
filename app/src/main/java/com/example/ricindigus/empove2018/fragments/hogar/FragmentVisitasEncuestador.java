package com.example.ricindigus.empove2018.fragments.hogar;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.adapters.VisitaEncuestadorAdapter;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo7;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo8;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.modelo.pojos.VisitaEncuestador;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.InputFilterSoloLetras;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVisitasEncuestador extends FragmentPagina {
    private LinearLayoutManager linearLayoutManager;
    private VisitaEncuestadorAdapter visitaEncuestadorAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton btnAgregar;
    private TextView txtFechaFinal;
    private TextView txtResultadoFinal;

    private String idHogar;
    private String idVivienda;
    private String idCargo;

    private Context context;
    private VisitaEncuestador visita;
    private Data dataTablas;
    private Cursor cursor;
    private VisitaEncuestadorAdapter.OnItemClickListener onItemClickListener;


    int diaInicio;
    int mesInicio;
    int anioInicio;

    int horaInicio;
    int minutoInicio;
    int horaFin;
    int minutoFin;

    int diaProx;
    int mesProx;
    int anioProx;

    int horaProx;
    int minutoProx;


    public FragmentVisitasEncuestador() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FragmentVisitasEncuestador(String idHogar, String idVivienda, Context context, String idCargo) {
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        this.context = context;
        this.idCargo = idCargo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_visitas_encuestador, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.visita_recycler);
        txtResultadoFinal = (TextView) rootView.findViewById(R.id.visitas_resultado_final);
        txtFechaFinal = (TextView) rootView.findViewById(R.id.visitas_fecha_final);
        btnAgregar = (FloatingActionButton) rootView.findViewById(R.id.visitas_btnAgregarVisita);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (idCargo.equals("2")) btnAgregar.setVisibility(View.GONE);
        cargarDatos();
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        onItemClickListener = new VisitaEncuestadorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int pos) {
                cursor.moveToPosition(pos);
                Data dTablas = new Data(context);
                dTablas.open();
                String resultadoVisita = cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_resu));
                dTablas.close();
                if(resultadoVisita == null  && idCargo.equals("1")){
                    PopupMenu popupMenu = new PopupMenu(context,view);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_visita,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId()){
                                case R.id.opcion_editar:
                                            editarVisita(pos);
                                    break;
                                case R.id.opcion_eliminar:
                                            eliminarVisita(pos);
                                    break;
                                case R.id.opcion_finalizar:
                                    finalizarVisita(pos);
                                    break;
                            }
                            return true;
                        }
                    });
                    popupMenu.show();
                }
            }
        };

        try{
            dataTablas = new Data(context);
            dataTablas.open();
            cursor = dataTablas.getCursorVisitas(getIdTablaParte1(), idHogar);
            dataTablas.close();
            if(cursor != null){
                visitaEncuestadorAdapter = new VisitaEncuestadorAdapter(visita, context, cursor, onItemClickListener);
                recyclerView.setAdapter(visitaEncuestadorAdapter);
            }
        }catch (SQLException e){}



        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data data = new Data(context);
                data.open();
                String resultadoFinal = data.getValor(getIdTablaParte2(),SQLConstantes.resultado_supervisor_vis_resultado_final,idHogar);
                data.close();
                if (!resultadoFinal.equals("1")){
                    if(cursor.getCount() > 0) {
                        cursor.moveToPosition(cursor.getCount() - 1);
                        if(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_resu)) != null) agregarVisita();
                        else mostrarMensaje("DEBE FINALIZAR LA VISITA ACTUAL, ANTES DE AGREGAR UNA NUEVA");
                    }else{agregarVisita();}
                }else Toast.makeText(context, "La encuesta ya finalizó COMPLETA", Toast.LENGTH_SHORT).show();

            }
        });
    }


    public void agregarVisita(){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_agregar_visita, null);
        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_agregar_visita_lyt);
        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtNumero);
        final TextView txtFechaI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtFI);
        final TextView txtHoraI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtHI);

        alert.setTitle("AGREGAR VISITA");
        alert.setView(dialogView);
        alert.setPositiveButton("Agregar",null);
        alert.setNegativeButton("Cancelar",null);
        final AlertDialog alertDialog = alert.create();
//        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Calendar c = Calendar.getInstance();
                diaInicio = c.get(Calendar.DAY_OF_MONTH);
                mesInicio = c.get(Calendar.MONTH) + 1;
                anioInicio = c.get(Calendar.YEAR);
                horaInicio = c.get(Calendar.HOUR_OF_DAY);
                minutoInicio = c.get(Calendar.MINUTE);

                txtNumero.setText("VISITA N° " + checkDigito((visitaEncuestadorAdapter.getItemCount() + 1)));
                txtFechaI.setText(checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio));
                txtHoraI.setText(checkDigito(horaInicio) + ":" + checkDigito(minutoInicio));
                Button btnAdd = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Do something
                        boolean valido = true;
                        String mensaje = "";
                        boolean vFechaInicio = true, vHoraInicio = true;
                        if(cursor.getCount() > 0){
                            cursor.moveToPosition(cursor.getCount()-1);
                            int y = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_aa)));
                            int m = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_mm)));
                            int d = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_dd)));

                            int compHora = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_hor_ini)));
                            int compMinuto = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_min_ini)));


                            Date fi1 = new Date(y,m,d);
                            Date fi2 = new Date(anioInicio,mesInicio,diaInicio);
                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
                            String sfi2 = checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio);
                            if(fi2.before(fi1)){
                                vFechaInicio = false;
                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA NUEVA VISITA NO DEBE SER MENOR A LA VISITA ANTERIOR";
                            }else if(d == diaInicio && m == mesInicio && y == anioInicio){
                                if((horaInicio*60 + minutoInicio) <= (compHora*60+compMinuto)){
                                    vHoraInicio = false;
                                    if(mensaje.equals("")) mensaje = "FECHA: SI LA FECHA ES LA MISMA, LA HORA DE LA NUEVA VISITA NO DEBE SER MENOR O IGUAL A LA VISITA ANTERIOR";
                                }
                            }
                        }
                        valido = vFechaInicio && vHoraInicio;
                        if(valido){
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(SQLConstantes.visita_encuestador_id, idHogar + "visita" + String.valueOf(cursor.getCount()+1));
                            contentValues.put(SQLConstantes.visita_encuestador_id_hogar, idHogar);
                            contentValues.put(SQLConstantes.visita_encuestador_id_vivienda, idVivienda);
                            contentValues.put(SQLConstantes.visita_encuestador_numero,String.valueOf(cursor.getCount()+1));
                            contentValues.put(SQLConstantes.visita_encuestador_vis_fecha_dd,diaInicio+"");
                            contentValues.put(SQLConstantes.visita_encuestador_vis_fecha_mm,mesInicio+"");
                            contentValues.put(SQLConstantes.visita_encuestador_vis_fecha_aa,anioInicio+"");
                            contentValues.put(SQLConstantes.visita_encuestador_vis_hor_ini,horaInicio+"");
                            contentValues.put(SQLConstantes.visita_encuestador_vis_min_ini,minutoInicio+"");

                            try{
                                Data dTablas = new Data(context);
                                dTablas.open();
                                dTablas.insertarElemento(getIdTablaParte1(),contentValues);
                                cursor = dTablas.getCursorVisitas(getIdTablaParte1(), idHogar);
                                dTablas.close();
                                if(cursor != null){
                                    visitaEncuestadorAdapter = new VisitaEncuestadorAdapter(visita, context, cursor, onItemClickListener);
                                    recyclerView.setAdapter(visitaEncuestadorAdapter);
                                }
                            }catch (SQLException e){}
//                            recyclerView.getAdapter().notifyDataSetChanged();
                            alertDialog.dismiss();
                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        alertDialog.show();
    }

    public void editarVisita(final int posicion){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_agregar_visita, null);
        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_agregar_visita_lyt);
        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtNumero);
        final TextView txtFechaI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtFI);
        final TextView txtHoraI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtHI);

        alert.setTitle("EDITAR VISITA");
        alert.setView(dialogView);
        alert.setPositiveButton("Guardar",null);
        alert.setNegativeButton("Cancelar",null);
        final AlertDialog alertDialog = alert.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                cursor.moveToPosition(posicion);
                diaInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_dd)));
                mesInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_mm)));
                anioInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_aa)));
                horaInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_hor_ini)));
                minutoInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_min_ini)));

                txtNumero.setText("VISITA N° " + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_numero)))));
                txtFechaI.setText(checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio));
                txtHoraI.setText(checkDigito(horaInicio) + ":" + checkDigito(minutoInicio));
                Button btnAdd = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Do something
                        boolean valido =true;
                        String mensaje = "";
                        boolean vFechaInicio = true, vHoraInicio = true;

                        if(cursor.getCount() > 1){
                            cursor.moveToPosition(posicion-1);
                            int d = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_dd)));
                            int m = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_mm)));
                            int y = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_aa)));

                            int compHora = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_hor_ini)));
                            int compMinuto = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_min_ini)));

                            Date fi1 = new Date(y,m,d);
                            Date fi2 = new Date(anioInicio,mesInicio,diaInicio);
                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
                            String sfi2 = checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio);

                            if(fi2.before(fi1)){
                                vFechaInicio = false;
                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA PROXIMA VISITA NO DEBE SER MENOR A LA VISITA ACTUAL";
                            }else if(d == diaInicio && m == mesInicio && y == anioInicio){
                                if((horaInicio*60 + minutoInicio) <= (compHora*60+compMinuto)){
                                    vHoraInicio = false;
                                    if(mensaje.equals("")) mensaje = "FECHA: SI LA FECHA ES LA MISMA, LA HORA DE LA NUEVA VISITA NO DEBE SER MENOR O IGUAL A LA VISITA ANTERIOR";
                                }
                            }
                        }
                        valido = vFechaInicio && vHoraInicio;
                        if(valido){
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(SQLConstantes.visita_encuestador_vis_fecha_dd,diaInicio);
                            contentValues.put(SQLConstantes.visita_encuestador_vis_fecha_mm,mesInicio);
                            contentValues.put(SQLConstantes.visita_encuestador_vis_fecha_aa,anioInicio);
                            contentValues.put(SQLConstantes.visita_encuestador_vis_hor_ini,horaInicio);
                            contentValues.put(SQLConstantes.visita_encuestador_vis_min_ini,minutoInicio);
                            contentValues.put(SQLConstantes.visita_encuestador_vis_fecha_dd,diaInicio);
                            contentValues.put(SQLConstantes.visita_encuestador_vis_fecha_dd,diaInicio);
                            try{
                                cursor.moveToPosition(posicion);
                                String idVisita = cursor.getString(cursor.getColumnIndex("_id"));
                                dataTablas = new Data(context);
                                dataTablas.open();
                                dataTablas.actualizarElemento(getIdTablaParte1(),contentValues,idVisita);
                                cursor = dataTablas.getCursorVisitas(getIdTablaParte1(), idHogar);
                                dataTablas.close();
                                if(cursor != null){
                                    visitaEncuestadorAdapter = new VisitaEncuestadorAdapter(visita, context, cursor, onItemClickListener);
                                    recyclerView.setAdapter(visitaEncuestadorAdapter);
                                }
                            }catch (SQLException e){}
                            alertDialog.dismiss();
                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        alertDialog.show();
    }

    public void eliminarVisita(final int posicion){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("¿Está seguro que desea eliminar la visita? (no podrá revertir el cambio)")
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
                                try{
                                    cursor.moveToPosition(posicion);
                                    String idVisita = cursor.getString(cursor.getColumnIndex("_id"));
                                    dataTablas = new Data(context);
                                    dataTablas.open();
                                    dataTablas.eliminarDato(getIdTablaParte1(),idVisita);
                                    cursor = dataTablas.getCursorVisitas(getIdTablaParte1(), idHogar);
                                    dataTablas.close();
                                    if(cursor != null){
                                        visitaEncuestadorAdapter = new VisitaEncuestadorAdapter(visita, context, cursor, onItemClickListener);
                                        recyclerView.setAdapter(visitaEncuestadorAdapter);
                                    }
                                }catch (SQLException e){}
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void finalizarVisita(final int posicion){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_finalizar_visita_encuestador, null);
        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_finalizar_visita_lyt);
        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtNumero);
        final TextView txtHoraF = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtHoraFin);
        final Spinner spResultado = (Spinner) dialogView.findViewById(R.id.dialog_finalizar_visita_spResultado);
        final EditText edtEspecifique = (EditText) dialogView.findViewById(R.id.dialog_finalizar_visita_edtEspecifique);
        final CheckBox ckProxVisita = (CheckBox) dialogView.findViewById(R.id.dialog_finalizar_visita_ckProximaVisita);
        final TextView txtFechaProxVisita = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtFechaProx);
        final TextView txtHoraProxVisita = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtHoraProx);
        final CardView cardViewEspecifique = (CardView) dialogView.findViewById(R.id.dialog_cardview_finalizar_especifique);
        final CardView cardViewProxFecha= (CardView) dialogView.findViewById(R.id.dialog_cardview_proxFecha);
        final CardView cardViewProxHora = (CardView) dialogView.findViewById(R.id.dialog_cardview_proxHora);
        String especifique = "";

        edtEspecifique.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(100), new InputFilterSoloLetras()});

        spResultado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos == 4 || pos == 2){
                    ckProxVisita.setEnabled(true);
                    ckProxVisita.setChecked(true);
                }else{
                    ckProxVisita.setChecked(false);
                    ckProxVisita.setEnabled(false);
                }
                if(pos == 7){
                    edtEspecifique.setEnabled(true);
                    cardViewEspecifique.setVisibility(View.VISIBLE);
                }else{
                    if(edtEspecifique.isEnabled()){
                        edtEspecifique.setText("");
                        cardViewEspecifique.setVisibility(View.GONE);
                        edtEspecifique.setEnabled(false);
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        ckProxVisita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    txtFechaProxVisita.setEnabled(true);
                    txtHoraProxVisita.setEnabled(true);
                    txtFechaProxVisita.setClickable(true);
                    txtHoraProxVisita.setClickable(true);
                    cardViewProxFecha.setCardBackgroundColor(Color.WHITE);
                    cardViewProxHora.setCardBackgroundColor(Color.WHITE);
                }else{
                    cardViewProxFecha.setCardBackgroundColor(Color.GRAY);
                    cardViewProxHora.setCardBackgroundColor(Color.GRAY);
                    txtFechaProxVisita.setClickable(false);
                    txtHoraProxVisita.setClickable(false);
                    txtFechaProxVisita.setEnabled(false);
                    txtHoraProxVisita.setEnabled(false);
                }
            }
        });

        txtFechaProxVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int yy = calendario.get(Calendar.YEAR);
                int mm = calendario.get(Calendar.MONTH);
                int dd = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        diaProx = dayOfMonth;
                        mesProx = monthOfYear + 1;
                        anioProx = year;
                        String fecha = checkDigito(diaProx) +"/"+checkDigito(mesProx)
                                +"/"+checkDigito(anioProx);
                        txtFechaProxVisita.setText(fecha);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });
        txtHoraProxVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int hh = calendario.get(Calendar.HOUR_OF_DAY);
                int mm = calendario.get(Calendar.MINUTE);

                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
                        txtHoraProxVisita.setText(hora);
                        horaProx = hourofDay;
                        minutoProx = minute;
                    }
                }, hh, mm,true);
                timePicker.show();
            }
        });

        alert.setTitle("FINALIZAR VISITA");
        alert.setView(dialogView);
        alert.setPositiveButton("Finalizar",null);
        alert.setNegativeButton("Cancelar",null);
        final AlertDialog alertDialog = alert.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                ocultarTeclado(lytDialog);
                Calendar c = Calendar.getInstance();
                diaProx = c.get(Calendar.DAY_OF_MONTH);
                mesProx = c.get(Calendar.MONTH) + 1;
                anioProx = c.get(Calendar.YEAR);
                horaProx = c.get(Calendar.HOUR_OF_DAY);
                minutoProx = c.get(Calendar.MINUTE);
                horaFin = horaProx;
                minutoFin = minutoProx;
                cursor.moveToPosition(posicion);
                txtNumero.setText("VISITA N° " + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_numero)))));
                txtHoraF.setText(checkDigito(horaFin) + ":" + checkDigito(minutoFin));
                txtFechaProxVisita.setText(checkDigito(diaProx + 1) + "/" + checkDigito(mesProx) + "/" + checkDigito(anioProx));
                txtHoraProxVisita.setText(checkDigito(horaProx) + ":" + checkDigito(minutoProx));
                Button btnFinalizarVisita = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btnFinalizarVisita.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Do something
                        boolean valido = false;
                        boolean vHoraFin = true, vResultado = true, vEspecifique = true, vFechaProxima = true, vHoraProxima = true;
                        String mensaje = "";
                        cursor.moveToPosition(posicion);
                        int t1 = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_hor_ini)))*60 + Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_min_ini)));
                        int t2 = horaFin * 60 + minutoFin;

                        if(t1 >= t2){
                            vHoraFin = false;
                            if(mensaje.equals("")) mensaje = "LA HORA DE FIN DEBE SER MAYOR A LA DE INICIO";
                        }

                        if(spResultado.getSelectedItemPosition() == 0){
                            vResultado = false;
                            if(mensaje.equals("")) mensaje = "DEBE INDICAR EL RESULTADO DE LA VISITA";
                        }
                        if(spResultado.getSelectedItemPosition() == 1){
                            if(!coberturaCorrecta()){
                                vResultado = false;
                                if(mensaje.equals("")) mensaje = "LA COBERTURA Y CIERRE ES INCORRECTA NO PUEDE FINALIZAR COMO COMPLETA";
                            }
                        }
                        if(spResultado.getSelectedItemPosition() == 4 && !ckProxVisita.isChecked()){
                            vResultado = false;
                            if(mensaje.equals("")) mensaje = "DEBE REGISTRAR INFORMACION DE LA PROXIMA VISITA";
                        }
                        if(edtEspecifique.isEnabled() && edtEspecifique.getText().toString().trim().length() < 3){
                            vEspecifique = false;
                            if(mensaje.equals("")) mensaje = "DEBE ESPECIFICAR EL RESULTADO DE LA VISITA";
                        }
                        if(ckProxVisita.isChecked()){
                            cursor.moveToPosition(posicion);
                            int y = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_aa)));
                            int m = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_mm)));
                            int d = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_dd)));
                            Date fi1 = new Date(y,m,d);
                            Date fi2 = new Date(anioProx,mesProx,diaProx);
                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
                            String sfi2 = checkDigito(diaProx) + "/" + checkDigito(mesProx) + "/" + checkDigito(anioProx);

                            if(fi2.before(fi1)){
                                vFechaProxima = false;
                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA PROXIMA VISITA NO DEBE SER MENOR A LA VISITA ACTUAL";
                            }
                        }

                        valido = vHoraFin && vResultado && vEspecifique && vFechaProxima;



                        if(valido){
                            boolean finalizacion = true;
                            if (spResultado.getSelectedItemPosition() == 1) {
                                if(!coberturaCorrecta()) finalizacion = false;
                            }
                            if (finalizacion){
                                //actualizo visita con datos de finalizar
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(SQLConstantes.visita_encuestador_vis_resu,String.valueOf(spResultado.getSelectedItemPosition()));
                                contentValues.put(SQLConstantes.visita_encuestador_vis_hor_fin,horaFin);
                                contentValues.put(SQLConstantes.visita_encuestador_vis_min_fin,minutoFin);
                                //falta guardar el especifique del resultado otro
                                if(ckProxVisita.isChecked()){
                                    contentValues.put(SQLConstantes.visita_encuestador_prox_vis_fecha_dd,checkDigito(diaProx));
                                    contentValues.put(SQLConstantes.visita_encuestador_prox_vis_fecha_mm,checkDigito(mesProx));
                                    contentValues.put(SQLConstantes.visita_encuestador_prox_vis_fecha_aa,checkDigito(anioProx));
                                    contentValues.put(SQLConstantes.visita_encuestador_prox_vis_hor,checkDigito(horaProx));
                                    contentValues.put(SQLConstantes.visita_encuestador_prox_vis_min,checkDigito(minutoProx));
                                }
                                try{
                                    dataTablas = new Data(context);
                                    dataTablas.open();
                                    cursor.moveToPosition(posicion);
                                    //actualiza la visita con los datos de finalizacion
                                    dataTablas.actualizarElemento(getIdTablaParte1(),contentValues,cursor.getString(cursor.getColumnIndex("_id")));
                                    //recupero un cursor con informacion d ela ultima visita guardada
                                    cursor = dataTablas.getCursorVisitas(getIdTablaParte1(), idHogar);
                                    dataTablas.close();
                                    if(cursor != null){
                                        //seteo adapter
                                        visitaEncuestadorAdapter = new VisitaEncuestadorAdapter(visita, context, cursor, onItemClickListener);
                                        recyclerView.setAdapter(visitaEncuestadorAdapter);
                                    }
                                }catch (SQLException e){}

//                            //MUESTRO Y GUARDO DATOS DE RESULTADO FINAL
                                final Calendar cal = Calendar.getInstance();
                                cursor.moveToPosition(posicion);
                                //obtengo la fecha de la ultima visita
                                int yy = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_aa)));
                                int mm = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_mm)));
                                int dd = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_fecha_dd)));


                                //----nuevo content values final
                                ContentValues contentValuesFinal = new ContentValues();
                                cursor.moveToPosition(posicion);
                                contentValuesFinal.put(SQLConstantes.resultado_encuestador_vis_resultado_final,cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_resu)));
                                //FALTA GUARDAR RWESULTADO ESPECIFIQUE DE OTRO
                                contentValuesFinal.put(SQLConstantes.resultado_encuestador_vis_fecha_final_dd,dd);
                                contentValuesFinal.put(SQLConstantes.resultado_encuestador_vis_fecha_final_mm,mm);
                                contentValuesFinal.put(SQLConstantes.resultado_encuestador_vis_fecha_final_aa,yy);
                                dataTablas = new Data(context);
                                dataTablas.open();
                                if(!dataTablas.existeElemento(getIdTablaParte2(), idHogar)){
                                    contentValuesFinal.put(SQLConstantes.resultado_encuestador_id, idHogar);
                                    contentValuesFinal.put(SQLConstantes.resultado_encuestador_id_vivienda, idVivienda);
                                    //si no hay registro de resultado final, inserto un resultado
                                    dataTablas.insertarElemento(getIdTablaParte2(),contentValuesFinal);
                                    //muestro el resultado final
                                    txtResultadoFinal.setText(getResources().getStringArray(R.array.visita_array_resultados)[spResultado.getSelectedItemPosition()]);
                                    txtFechaFinal.setText(checkDigito(dd) + "/" + checkDigito(mm) + "/" + checkDigito(yy));
                                    //actualizo valor del estado del hogar
                                    dataTablas.actualizarValor(
                                            SQLConstantes.tablahogares,
                                            SQLConstantes.hogar_estado,
                                            spResultado.getSelectedItemPosition()+"",
                                            idHogar);
                                }else{
                                    int res = Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),SQLConstantes.resultado_encuestador_vis_resultado_final,idHogar));
                                    if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_resu))) <= res){
                                        //si existe , actualizo, solo si el nuevo resultado es de mayor prioridad que el anterior.
                                        dataTablas.actualizarElemento(getIdTablaParte2(),contentValuesFinal, idHogar);
                                        //muestro el nuevo resultado
                                        txtResultadoFinal.setText(getResources().getStringArray(R.array.visita_array_resultados)[spResultado.getSelectedItemPosition()]);
                                        txtFechaFinal.setText(checkDigito(dd) + "/" + checkDigito(mm) + "/" + checkDigito(yy));
                                        //actualizo valor del estado del hogar
                                        dataTablas.actualizarValor(
                                                SQLConstantes.tablahogares,
                                                SQLConstantes.hogar_estado,
                                                spResultado.getSelectedItemPosition()+"",
                                                idHogar);
                                    }
                                }
                                dataTablas.actualizarValor(
                                        SQLConstantes.tablahogares,
                                        SQLConstantes.hogar_estado,
                                        dataTablas.getValor(getIdTablaParte2(), SQLConstantes.resultado_supervisor_vis_resultado_final,idHogar),
                                        idHogar);
                                dataTablas.close();

                                alertDialog.dismiss();
                            }
                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        alertDialog.show();
    }

    public boolean coberturaCorrecta(){
        Data data = new Data(context);
        data.open();
        if (data.getValor(SQLConstantes.tablamodulo1v,SQLConstantes.modulo1_v_COB100A,idVivienda).equals("0")){
            mostrarMensaje("Falta coberturar modulo 1 vivienda"
                    + "\nNO PUEDE FINALIZAR COMPLETA AUN");return false;
        }
        if (data.getValor(SQLConstantes.tablamodulo1h,SQLConstantes.modulo1_h_COB100B,idHogar).equals("0")){
            mostrarMensaje("Falta coberturar modulo 1 hogar"
                    + "\nNO PUEDE FINALIZAR COMPLETA AUN");return false;
        }
        for (Residente residente: data.getAllResidentesHogar(idHogar)){
            if (!residente.getCOB200().equals("1")){
                mostrarMensaje("Falta coberturar modulo 2 - residente: " + residente.getNumero() + "." + residente.getC2_p202()
                        + "\nNO PUEDE FINALIZAR COMPLETA AUN");return false;
            }
            else if (residente.getC2_p207().equals("1")){
                if (residente.getEncuestado_cobertura().equals("0")){
                    mostrarMensaje("Falta coberturar la encuesta del residente: " + residente.getNumero() + "." + residente.getC2_p202()
                            + "\nNO PUEDE FINALIZAR COMPLETA AUN");return false;
                }
            }
        }
        data.close();
        return true;
    }

//    public boolean tieneVisitas(){
//        boolean correcto = true;
//        if(visitas.size() == 0) correcto = false;
//        return correcto;
//    }
//    public boolean finalizacionCorrecta(){
//        boolean correcto = true;
//        if(visitas.get(visitas.size()-1).getV_RESULTADO().equals("")) correcto = false;
//        return correcto;
//    }

    public void cargarDatos(){
        dataTablas = new Data(context);
        dataTablas.open();
        if(dataTablas.existeElemento(getIdTablaParte2(), idHogar)){
            txtResultadoFinal.setText(getResources().getStringArray(R.array.visita_array_resultados)[Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),SQLConstantes.resultado_encuestador_vis_resultado_final, idHogar))]);
            txtFechaFinal.setText(
                    checkDigito(Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),SQLConstantes.resultado_encuestador_vis_fecha_final_dd, idHogar))) +
                            "/" + checkDigito(Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),SQLConstantes.resultado_encuestador_vis_fecha_final_mm, idHogar))) +
                            "/" + checkDigito(Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),SQLConstantes.resultado_encuestador_vis_fecha_final_aa, idHogar))));
        }

        dataTablas.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {

    }

    public boolean validarDatos(){
        boolean valido = true;
        String mensaje = "";
        if(cursor.getCount() > 0){
            cursor.moveToPosition(cursor.getCount()-1);
            String resultado = cursor.getString(cursor.getColumnIndex(SQLConstantes.visita_encuestador_vis_resu));
            if(resultado != null){
                if (Integer.parseInt(resultado) > 1){
                    valido =  false;
                    mensaje = "DEBE INICIAR UNA VISITA ANTES DE CONTINUAR";
                }
            }
        }else{
            valido =  false;
            mensaje = "DEBE INICIAR UNA VISITA ANTES DE CONTINUAR";
        }

        if(!valido){
            mostrarMensaje(mensaje);
        }
        return valido;
    }

    @Override
    public String getNombreTabla() {
        return null;
    }


    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public String getIdTablaParte1(){
        return SQLConstantes.tablavisitasencuestador;
    }
    public String getIdTablaParte2(){
        return SQLConstantes.tablaresultadoencuestador;
    }

}
