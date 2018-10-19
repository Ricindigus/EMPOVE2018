package com.example.ricindigus.empove2018.fragments.modulo3;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP306P308 extends Fragment {
    Context context;
    private static final String CERO = "0";
    public final Calendar c = Calendar.getInstance();
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    TextView tv_fecha_dia_307, tv_fecha_mes_307, tv_fecha_anio_307;
    Button btn_obtenerFecha_307;
    public FragmentP306P308() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p306_p308, container, false);
        tv_fecha_dia_307 = (TextView) rootView.findViewById(R.id.mostrar_fecha_dia_307_TextView);
        tv_fecha_mes_307 = (TextView) rootView.findViewById(R.id.mostrar_fecha_mes_307_TextView);
        tv_fecha_anio_307 = (TextView) rootView.findViewById(R.id.mostrar_fecha_anio_307_TextView);
        btn_obtenerFecha_307 = (Button) rootView.findViewById(R.id.btn_obtener_fecha_307);

        btn_obtenerFecha_307.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog recogeFecha = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final int mesActual = month + 1;
                        String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                        tv_fecha_dia_307.setText(""+diaFormateado);
                        tv_fecha_mes_307.setText(""+mesFormateado);
                        tv_fecha_anio_307.setText(""+year);
                    }
                },anio,mes,dia);
                recogeFecha.show();
            }
        });

        return rootView;
    }

}
