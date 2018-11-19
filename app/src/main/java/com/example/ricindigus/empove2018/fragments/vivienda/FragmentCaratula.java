package com.example.ricindigus.empove2018.fragments.vivienda;



import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Caratula;
import com.example.ricindigus.empove2018.modelo.pojos.Marco;
import com.example.ricindigus.empove2018.util.FragmentPagina;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCaratula extends FragmentPagina implements GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks,
        LocationListener {

    private static final String LOGTAG = "android-localizacion";
    private static final int PETICION_PERMISO_LOCALIZACION = 101;
    private static final int PETICION_CONFIG_UBICACION = 201;
    private GoogleApiClient apiClient;
    private LocationRequest locRequest;

    private View rootView;
    private CardView cvLongitud, cvAltitud, cvLatitud;
    private ToggleButton btnGPS;
    private TextView txtLatitud, txtLongitud, txtAltitud;
    private Context contexto;



    String idVivienda;
    String idMes;
    String idAnio;
    String idZona;
    String idPeriodo;
    String idUsuario;
    Context context;

    TextView nom_dep_TextView, nom_prov_TextView, nom_dist_TextView, nom_ccpp_TextView;
    TextView zona_TextView, manzana_id_TextView, vivienda_TextView;
    Spinner tipvia_Spinner;
    EditText tipvia_o_EditText, nomvia_EditText, nropta_EditText, block_EditText, interior_EditText, piso_EditText, mza_EditText,
            lote_EditText, km_EditText, telefono_EditText;
//    EditText t_hogar_EditText;

    //variables
    private int tipvia = -1;
    private String tipvia_o="";
    private String nom_dep;
    private String nom_prov;
    private String nom_dist;
    private String nom_ccpp;
    private String zona;
    private String manzana_id;
    private String vivienda;
    private String latitud;
    private String longitud;
    private String nomvia = "";
    private String nropta = "";
    private String block = "";
    private String interior = "";
    private String piso = "";
    private String mza = "";
    private String lote = "";
    private String km = "";
    private String telefono = "";
//    private String t_hogar = "";


    @SuppressLint("ValidFragment")
    public FragmentCaratula(String idVivienda, String idMes, String idAnio, String idZona, String idPeriodo, String idUsuario, Context context) {
        this.idVivienda = idVivienda;
        this.idMes = idMes;
        this.idAnio = idAnio;
        this.idZona = idZona;
        this.idPeriodo = idPeriodo;
        this.idUsuario = idUsuario;
        this.context = context;
    }

    public FragmentCaratula() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_caratula, container, false);
        nom_dep_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_NOM_DEP);
        nom_prov_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_NOM_PROV);
        nom_dist_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_NOM_DIST);
        nom_ccpp_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_NOM_CCPP);
        zona_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_ZONA);
        manzana_id_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_MANZANA_ID);
        vivienda_TextView = (TextView) rootView.findViewById(R.id.caratula_textview_VIVIENDA);

        tipvia_Spinner = (Spinner) rootView.findViewById(R.id.caratula_spinner_TIPVIA);
        tipvia_o_EditText = (EditText) rootView.findViewById(R.id.caratula_edittext_TIPVIA_O);
        nomvia_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_NOMVIA);
        nropta_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_NROPTA);
        block_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_BLOCK);
        interior_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_INTERIO);
        piso_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_PISO);
        mza_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_MZA);
        lote_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_LOTE);
        km_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_KM);
        telefono_EditText = (EditText) rootView.findViewById(R.id.caratula_textview_TELEFONO);

        cvAltitud = (CardView) rootView.findViewById(R.id.gps_layout_altitud);
        cvLatitud = (CardView) rootView.findViewById(R.id.gps_layout_latitud);
        cvLongitud = (CardView) rootView.findViewById(R.id.gps_layout_longitud);
        txtAltitud = (TextView) rootView.findViewById(R.id.gps_txt_altitud);
        txtLatitud = (TextView) rootView.findViewById(R.id.gps_txt_latitud);
        txtLongitud = (TextView) rootView.findViewById(R.id.gps_txt_longitud);
        btnGPS = (ToggleButton) rootView.findViewById(R.id.gps_btn_captura);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tipvia_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos == 7){
                    tipvia_o_EditText.setEnabled(true);
                    tipvia_o_EditText.setBackgroundResource(R.drawable.input_text_enabled);
                }else{
                    tipvia_o_EditText.setEnabled(false);
                    tipvia_o_EditText.setText("");
                    tipvia_o_EditText.setBackgroundResource(R.drawable.input_text_disabled);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        tipvia_o_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(40)});
        nomvia_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(40)});
        nropta_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        block_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        interior_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        piso_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        mza_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        lote_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        km_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(5)});
        telefono_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(9)});
//        t_hogar_EditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(2)});

        km_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        telefono_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
//        t_hogar_EditText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        cargarDatos();
        btnGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleLocationUpdates(btnGPS.isChecked());
                if(!btnGPS.isChecked()){
                    txtAltitud.setText("99.999999");
                    txtLatitud.setText("99.999999");
                    txtLongitud.setText("99.999999");
                }
            }
        });

        //Construcción cliente API Google
        apiClient = new GoogleApiClient.Builder(getActivity().getApplicationContext())
                .enableAutoManage(getActivity(), this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
    }



    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.caratula_longitud,longitud);
        contentValues.put(SQLConstantes.caratula_latitud,latitud);
        contentValues.put(SQLConstantes.caratula_tipvia,tipvia+"");
        contentValues.put(SQLConstantes.caratula_tipvia_o,tipvia_o);
        contentValues.put(SQLConstantes.caratula_nomvia,nomvia);
        contentValues.put(SQLConstantes.caratula_nropta,nropta);
        contentValues.put(SQLConstantes.caratula_block,block);
        contentValues.put(SQLConstantes.caratula_interior,interior);
        contentValues.put(SQLConstantes.caratula_piso,piso);
        contentValues.put(SQLConstantes.caratula_mza,mza);
        contentValues.put(SQLConstantes.caratula_lote,lote);
        contentValues.put(SQLConstantes.caratula_km,km);
        contentValues.put(SQLConstantes.caratula_telefono,telefono);
        if(data.existeElemento(getNombreTabla(),idVivienda)){
            data.actualizarElemento(getNombreTabla(),contentValues,idVivienda);
        }else{
            contentValues.put(SQLConstantes.caratula_id,idVivienda);
            contentValues.put(SQLConstantes.caratula_mes,idMes);
            contentValues.put(SQLConstantes.caratula_anio,idAnio);
            contentValues.put(SQLConstantes.caratula_periodo,idPeriodo);
            contentValues.put(SQLConstantes.caratula_usuario,idUsuario);
            contentValues.put(SQLConstantes.caratula_zona, idZona);
            contentValues.put(SQLConstantes.caratula_nom_dep,nom_dep);
            contentValues.put(SQLConstantes.caratula_nom_prov,nom_prov);
            contentValues.put(SQLConstantes.caratula_nom_dist,nom_dist);
            contentValues.put(SQLConstantes.caratula_nom_ccpp,nom_ccpp);
            contentValues.put(SQLConstantes.caratula_manzana_id,manzana_id);
            contentValues.put(SQLConstantes.caratula_vivienda,vivienda);
            contentValues.put(SQLConstantes.caratula_t_hogar,"0");
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        nom_dep = nom_dep_TextView.getText().toString();
        nom_prov = nom_prov_TextView.getText().toString();
        nom_dist = nom_dist_TextView.getText().toString();
        nom_ccpp = nom_ccpp_TextView.getText().toString();
        zona = zona_TextView.getText().toString();
        manzana_id = manzana_id_TextView.getText().toString();
        vivienda = vivienda_TextView.getText().toString();
        tipvia = tipvia_Spinner.getSelectedItemPosition();
        tipvia_o = tipvia_o_EditText.getText().toString();
        nomvia = nomvia_EditText.getText().toString();
        nropta = nropta_EditText.getText().toString();
        block = block_EditText.getText().toString();
        interior = interior_EditText.getText().toString();
        piso = piso_EditText.getText().toString();
        mza = mza_EditText.getText().toString();
        lote = lote_EditText.getText().toString();
        km = km_EditText.getText().toString();
        telefono = telefono_EditText.getText().toString();
        latitud = txtLatitud.getText().toString();
        longitud = txtLongitud.getText().toString();
    }

    @Override
    public void cargarDatos() {
        Caratula caratula = null;
        Data data =  new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(),idVivienda)){
            caratula = data.getCaratula(idVivienda);
            nom_dep_TextView.setText(caratula.getNom_dep());
            nom_prov_TextView.setText(caratula.getNom_prov());
            nom_dist_TextView.setText(caratula.getNom_dist());
            nom_ccpp_TextView.setText(caratula.getNom_ccpp());
            zona_TextView.setText(caratula.getZona());
            manzana_id_TextView.setText(caratula.getManzana_id());
            vivienda_TextView.setText(caratula.getVivienda());
            txtLatitud.setText(caratula.getLatitud());
            txtLongitud.setText(caratula.getLongitud());

            if(!caratula.getTipvia().equals("") || !caratula.getTipvia().equals("0"))
                tipvia_Spinner.setSelection(Integer.parseInt(caratula.getTipvia()));
            tipvia_o_EditText.setText(caratula.getTipvia_o());
            nomvia_EditText.setText(caratula.getNomvia());
            nropta_EditText.setText(caratula.getNropta());
            block_EditText.setText(caratula.getBlock());
            interior_EditText.setText(caratula.getInterior());
            piso_EditText.setText(caratula.getPiso());
            mza_EditText.setText(caratula.getMza());
            lote_EditText.setText(caratula.getLote());
            km_EditText.setText(caratula.getKm());
            telefono_EditText.setText(caratula.getTelefono());

//            t_hogar_EditText.setText(caratula.getT_hogar());
        }else{
            Marco marco = data.getMarco(idVivienda);
            nom_dep_TextView.setText(marco.getDepartamento());
            nom_prov_TextView.setText(marco.getProvincia());
            nom_dist_TextView.setText(marco.getDistrito());
            nom_ccpp_TextView.setText(marco.getCcpp());

            zona_TextView.setText(marco.getZona());
            manzana_id_TextView.setText(marco.getManzana_id());
            vivienda_TextView.setText(marco.get_id()+"");

            if(!marco.getTipvia().equals("")) tipvia_Spinner.setSelection(Integer.parseInt(marco.getTipvia()));
            nomvia_EditText.setText(marco.getNomvia());
            nropta_EditText.setText(marco.getNropta());
            block_EditText.setText(marco.getBlock());
            interior_EditText.setText(marco.getInterior());
            piso_EditText.setText(marco.getPiso());
            mza_EditText.setText(marco.getMza());
            lote_EditText.setText(marco.getLote());
        }

        String script_tablas_bd_hasta3 = "\n"+ SQLConstantes.SQL_CREATE_TABLA_CARATULA + "\n" + SQLConstantes.SQL_CREATE_TABLA_FUNCIONARIOS +
                "\n" + SQLConstantes.SQL_CREATE_TABLA_HOGARES + "\n" + SQLConstantes.SQL_CREATE_TABLA_VISITA_ENCUESTADOR +
                "\n" + SQLConstantes.SQL_CREATE_TABLA_VISITA_SUPERVISOR + "\n" + SQLConstantes.SQL_CREATE_TABLA_RESULTADO_ENCUESTADOR +
                "\n" + SQLConstantes.SQL_CREATE_TABLA_RESULTADO_SUPERVISOR + "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO1H +
                "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO1V + "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO2 +
                "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO3 + "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO3_P309_RUTAS +
                "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO3_P318_PERSONAS;
        String script_tablas_bd_desde4_6 = "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO4 +
                "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO5 + "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO6;
        String script_tablas_bd_desde7_8 = "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO7 + "\n" + SQLConstantes.SQL_CREATE_TABLA_MODULO8;
        String script_tablas_bd_despues8 = "\n" + SQLConstantes.SQL_CREATE_TABLA_LAYOUTS + "\n" + SQLConstantes.SQL_CREATE_TABLA_FRAGMENTS;

        Log.e("TABLA_CARATULA hasta 3", "cargarDatos: " +  script_tablas_bd_hasta3);
        Log.e("TABLA_CARATULA des 4-6", "cargarDatos: " +  script_tablas_bd_desde4_6);
        Log.e("TABLA_CARATULA des 7-8", "cargarDatos: " +  script_tablas_bd_desde7_8);
        Log.e("TABLA_CARATULA desp 8", "cargarDatos: " +  script_tablas_bd_despues8);

        data.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        int sumaValida = 0;
        String mensaje = "";
        if(tipvia == 0){ mostrarMensaje("Debe indicar el tipo de via"); return false; }
        if(tipvia == 7){
            Log.e("tipvia_o", "validarDatos: "+tipvia_o );
            if(tipvia_o.trim().equals("")){
                mostrarMensaje("TIPO DE VIA: DEBE ESPECIFICAR OTRO"); return false;
            }
        }
        if(nomvia.equals("")){ mostrarMensaje("Debe completar el NOMBRE DE LA VÍA"); return false; }
        if(nropta.equals("")){ mostrarMensaje("Debe completar NÚMERO DE LA PUERTA"); return false; }
        if(es_cero(nropta)){ mostrarMensaje("NO PUEDE SER CERO, NÚMERO DE LA PUERTA"); return false; }
//        if(block.equals("")){ mostrarMensaje("Debe completar BLOCK"); return false; }
//        if(interior.equals("")){ mostrarMensaje("Debe completar INTERIOR"); return false; }
        if(piso.equals("")){ mostrarMensaje("Debe completar el PISO"); return false; }
        if(es_cero(piso)){ mostrarMensaje("NO PUEDE SER CERO, PISO"); return false; }
//        if(mza.equals("")){ mostrarMensaje("Debe completar la MANZANA"); return false; }
//        if(lote.equals("")){ mostrarMensaje("Debe completar el LOTE"); return false; }
//        if(km.equals("")){ mostrarMensaje("Debe completar el KM"); return false; }
//        if(telefono.equals("")){ mostrarMensaje("Debe completar el TELÉFONO"); return false; }
//        if(t_hogar.equals("")){ mostrarMensaje("Debe indicar la CANTIDAD DE HOGARES"); return false; }
        if (latitud.equals("")) { mostrarMensaje("FALTA CAPTURAR EL GPS"); return false; }
        return true;
    }

    public boolean es_cero(String numero){
        int cant_cero=0;
        for(int i=0;i<numero.length();i++){
            if(numero.charAt(i)=='0'){
                cant_cero++;
            }
        }
        if(cant_cero==numero.length()) return true; else return false;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablacaratula;
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

    private void toggleLocationUpdates(boolean enable) {
        if (enable) {
            enableLocationUpdates();
        } else {
            disableLocationUpdates();
        }
    }

    private void enableLocationUpdates() {
        locRequest = new LocationRequest();
        locRequest.setInterval(2000);
        locRequest.setFastestInterval(1000);
        locRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest locSettingsRequest = new LocationSettingsRequest.Builder().addLocationRequest(locRequest).build();
        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(apiClient, locSettingsRequest);

        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult locationSettingsResult) {
                final Status status = locationSettingsResult.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        Log.i(LOGTAG, "Configuración correcta");
                        startLocationUpdates();
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            Log.i(LOGTAG, "Se requiere actuación del usuario");
                            status.startResolutionForResult(getActivity(), PETICION_CONFIG_UBICACION);
                            btnGPS.setChecked(false);
                        } catch (IntentSender.SendIntentException e) {
                            btnGPS.setChecked(false);
                            Log.i(LOGTAG, "Error al intentar solucionar configuración de ubicación");
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        Log.i(LOGTAG, "No se puede cumplir la configuración de ubicación necesaria");
                        btnGPS.setChecked(false);
                        break;
                }
            }
        });
    }

    private void disableLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(apiClient, this);
    }

    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //Ojo: estamos suponiendo que ya tenemos concedido el permiso.
            //Sería recomendable implementar la posible petición en caso de no tenerlo.
            Log.i(LOGTAG, "Inicio de recepción de ubicaciones");
            LocationServices.FusedLocationApi.requestLocationUpdates(apiClient, locRequest, this);
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        //Se ha producido un error que no se puede resolver automáticamente
        //y la conexión con los Google Play Services no se ha establecido.
        Log.e(LOGTAG, "Error grave al conectar con Google Play Services");
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //Conectado correctamente a Google Play Services
        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PETICION_PERMISO_LOCALIZACION);
        } else {
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient);
//            updateUI(lastLocation);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        //Se ha interrumpido la conexión con Google Play Services

        Log.e(LOGTAG, "Se ha interrumpido la conexión con Google Play Services");
    }

    private void updateUI(Location loc) {
        if (loc != null) {
            txtLatitud.setText(String.valueOf(loc.getLatitude()));
            txtLongitud.setText(String.valueOf(loc.getLongitude()));
            txtAltitud.setText(String.valueOf(loc.getAccuracy()));
        } else {
            txtLatitud.setText("99.999999");
            txtLongitud.setText("99.999999");
            txtAltitud.setText("99.999999");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PETICION_PERMISO_LOCALIZACION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //Permiso concedido
                @SuppressWarnings("MissingPermission")
                Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient);
                updateUI(lastLocation);

            } else {
                //Permiso denegado:
                //Deberíamos deshabilitar toda la funcionalidad relativa a la localización.

                Log.e(LOGTAG, "Permiso denegado");
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PETICION_CONFIG_UBICACION:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        Log.i(LOGTAG, "El usuario no ha realizado los cambios de configuración necesarios");
                        btnGPS.setChecked(false);
                        break;
                }
                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i(LOGTAG, "Recibida nueva ubicación!");
        disableLocationUpdates();
        btnGPS.setChecked(false);
        //Mostramos la nueva ubicación recibida
        updateUI(location);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        apiClient.stopAutoManage(getActivity());
        apiClient.disconnect();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
