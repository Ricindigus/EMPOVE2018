package com.example.ricindigus.empove2018.fragments.modulo8;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP801P804 extends FragmentPagina {

    Context context;
    String idVivienda, idHogar, idInformante, idPersona;

    RadioGroup c8_p801_RadioGroup, c8_p802_RadioGroup, c8_p803_RadioGroup, c8_p804_RadioGroup;
    LinearLayout m8_p801_linearlayout, m8_p802_linearlayout, m8_p803_linearlayout, m8_p804_linearlayout;

    private int c8_p801;
    private int c8_p802;
    private int c8_p803;
    private int c8_p804;

    @SuppressLint("ValidFragment")
    public FragmentP801P804(Context context, String idVivienda, String idHogar, String idInformante, String idPersona) {
        this.context = context;
        this.idVivienda = idVivienda;
        this.idHogar = idHogar;
        this.idInformante = idInformante;
        this.idPersona = idPersona;
    }

    public FragmentP801P804() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p801_p804, container, false);

        c8_p801_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_801_radiogroup_C8_P801);
        c8_p802_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_802_radiogroup_C8_P802);
        c8_p803_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_803_radiogroup_C8_P803);
        c8_p804_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod8_804_radiogroup_C8_P804);

        m8_p801_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p801);
        m8_p802_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p802);
        m8_p803_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p803);
        m8_p804_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m8_p804);

        return rootView;
    }

    @Override
    public void guardarDatos() {
        Data data = new Data(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo8_c8_p801,""+c8_p801);
        contentValues.put(SQLConstantes.modulo8_c8_p802,""+c8_p802);
        contentValues.put(SQLConstantes.modulo8_c8_p803,""+c8_p803);
        contentValues.put(SQLConstantes.modulo8_c8_p804,""+c8_p804);

        if(data.existeElemento(getNombreTabla(),idPersona)){
            data.actualizarElemento(getNombreTabla(),contentValues,idPersona);
        }else{
            contentValues.put(SQLConstantes.modulo8_idVivienda,""+idVivienda);
            contentValues.put(SQLConstantes.modulo8_idHogar,""+idHogar);
            contentValues.put(SQLConstantes.modulo8_idInformante,""+idInformante);
            contentValues.put(SQLConstantes.modulo8_id,""+idPersona);
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.close();
    }

    @Override
    public void llenarVariables() {
        c8_p801 = c8_p801_RadioGroup.indexOfChild(c8_p801_RadioGroup.findViewById(c8_p801_RadioGroup.getCheckedRadioButtonId()));
        c8_p802 = c8_p802_RadioGroup.indexOfChild(c8_p802_RadioGroup.findViewById(c8_p802_RadioGroup.getCheckedRadioButtonId()));
        c8_p803 = c8_p803_RadioGroup.indexOfChild(c8_p803_RadioGroup.findViewById(c8_p803_RadioGroup.getCheckedRadioButtonId()));
        c8_p804 = c8_p804_RadioGroup.indexOfChild(c8_p804_RadioGroup.findViewById(c8_p804_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if (c8_p801 <1){
            mostrarMensaje("PREGUNTA 801: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if (c8_p802 <1){
            mostrarMensaje("PREGUNTA 802: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if (c8_p803 <1){
            mostrarMensaje("PREGUNTA 803: DEBE SELECCIONAR UNA OPCION");
            return false;
        }
        if (c8_p804 <1){
            mostrarMensaje("PREGUNTA 804: DEBE SELECCIONAR UNA OPCION");
            return false;
        }


        return false;
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

    //XD
    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo8;
    }
}
