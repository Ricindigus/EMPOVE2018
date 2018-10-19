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

/**
 * A simple {@link Fragment} subclass.
 */

import java.util.Calendar;

public class FragmentP301P305 extends Fragment {
    Context context;
    private static final String CERO = "0";
    public final Calendar c = Calendar.getInstance();
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    TextView c3_p301_d_TextView, c3_p301_m_TextView, c3_p301_a_TextView;
    Button c3_p301_d_f_Button;

    public FragmentP301P305() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p301_p305, container, false);

        c3_p301_d_TextView = (TextView) rootView.findViewById(R.id.mod3_301_textview_C3_P301_D);
        c3_p301_m_TextView = (TextView) rootView.findViewById(R.id.mod3_301_textview_C3_P301_M);
        c3_p301_a_TextView = (TextView) rootView.findViewById(R.id.mod3_301_textview_C3_P301_A);
        c3_p301_d_f_Button = (Button) rootView.findViewById(R.id.mod3_301_button_C3_P301_F);
        c3_p301_d_f_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog recogerFecha = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final int mesActual = month + 1;
                        String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                        c3_p301_d_TextView.setText(""+diaFormateado);
                        c3_p301_m_TextView.setText(""+mesFormateado);
                        c3_p301_a_TextView.setText(""+year);

                    }
                    //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
                    /**
                     *También puede cargar los valores que usted desee
                     */
                },anio, mes, dia);
                recogerFecha.show();
            }
        });

        return rootView;
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_obtener_fecha:
//                obtenerFecha();
//                break;
//        }
//    }
//
//    private void obtenerFecha() {
//        DatePickerDialog recogerFecha = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
//                final int mesActual = month + 1;
//                //Formateo el día obtenido: antepone el 0 si son menores de 10
//                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
//                //Formateo el mes obtenido: antepone el 0 si son menores de 10
//                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
//                //Muestro la fecha con el formato deseado
//                tv_fecha_dia.setText(""+diaFormateado);
//                //tv_fecha_mes.setText(""+mesFormateado);
//                //tv_fecha_anio.setText(""+year);
//
//            }
//            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
//            /**
//             *También puede cargar los valores que usted desee
//             */
//        },anio, mes, dia);
//        //Muestro el widget
//        recogerFecha.show();
//    }
}
