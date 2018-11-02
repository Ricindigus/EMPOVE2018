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
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo7;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo8;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.FragmentPagina;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP801P804 extends FragmentPagina {

    Context context;
    String idEncuestado;

    String idVivienda, idHogar, idInformante;

    RadioGroup c8_p801_RadioGroup, c8_p802_RadioGroup, c8_p803_RadioGroup, c8_p804_RadioGroup;
    LinearLayout m8_p801_linearlayout, m8_p802_linearlayout, m8_p803_linearlayout, m8_p804_linearlayout;
    Spinner informanteSpinner;

    int c8_p801;
    int c8_p802;
    int c8_p803;
    int c8_p804;

    @SuppressLint("ValidFragment")
    public FragmentP801P804( String idEncuestado, Context context) {
        this.context = context;
        this.idEncuestado = idEncuestado;
        Data data = new Data(context);
        data.open();
        Residente residente = data.getResidente(idEncuestado);
        idVivienda = residente.getId_vivienda();
        idHogar = residente.getId_hogar();
        idInformante = "";
        data.close();
    }

    public FragmentP801P804() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p801_p804, container, false);

        informanteSpinner = (Spinner) rootView.findViewById(R.id.cabecera_spinner_informante);

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


    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Data data = new Data(context);
        data.open();
        ArrayList<String> residentes = data.getListaSpinnerResidentesHogar(idHogar);
        data.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, residentes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        informanteSpinner.setAdapter(adapter);
        //cargarDatos();
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

        if(!data.existeElemento(getNombreTabla(),idEncuestado)){
            Modulo8 modulo8 = new Modulo8();
            modulo8.set_id(idEncuestado);
            modulo8.setIdVivienda(idVivienda);
            modulo8.setIdHogar(idHogar);
            data.insertarElemento(getNombreTabla(), modulo8.toValues());
        }
        data.actualizarElemento(getNombreTabla(), contentValues, idEncuestado);
        data.close();
    }

    @Override
    public void llenarVariables() {
        idInformante = informanteSpinner.getSelectedItemPosition()+"";
        c8_p801 = c8_p801_RadioGroup.indexOfChild(c8_p801_RadioGroup.findViewById(c8_p801_RadioGroup.getCheckedRadioButtonId()));
        c8_p802 = c8_p802_RadioGroup.indexOfChild(c8_p802_RadioGroup.findViewById(c8_p802_RadioGroup.getCheckedRadioButtonId()));
        c8_p803 = c8_p803_RadioGroup.indexOfChild(c8_p803_RadioGroup.findViewById(c8_p803_RadioGroup.getCheckedRadioButtonId()));
        c8_p804 = c8_p804_RadioGroup.indexOfChild(c8_p804_RadioGroup.findViewById(c8_p804_RadioGroup.getCheckedRadioButtonId()));
    }

    @Override
    public void cargarDatos() {
        Data data =  new Data(context);
        data.open();
        if(data.existeElemento(getNombreTabla(),idEncuestado)){

                Modulo8 modulo8 = data.getModulo8(idEncuestado);
                //informanteSpinner.setSelection(Integer.parseInt(modulo8.getIdInformante()));
                //informanteSpinner.setSelection(1);
                if(!modulo8.getC8_p801().equals("-1") && !modulo8.getC8_p801().equals(""))((RadioButton)c8_p801_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p801()))).setChecked(true);
                if(!modulo8.getC8_p802().equals("-1") && !modulo8.getC8_p802().equals(""))((RadioButton)c8_p802_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p802()))).setChecked(true);
                if(!modulo8.getC8_p803().equals("-1") && !modulo8.getC8_p803().equals(""))((RadioButton)c8_p803_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p803()))).setChecked(true);
                if(!modulo8.getC8_p804().equals("-1") && !modulo8.getC8_p804().equals(""))((RadioButton)c8_p804_RadioGroup.getChildAt(Integer.parseInt(modulo8.getC8_p804()))).setChecked(true);


             }
        data.close();

    }

    @Override
    public void llenarVista() {

    }

    @Override
    public boolean validarDatos() {
        llenarVariables();
        if(informanteSpinner.getSelectedItemPosition() == 0) {mostrarMensaje("NÚMERO INFORMANTE: DEBE INDICAR INFORMANTE");return false;}

        if (c8_p801 == -1){mostrarMensaje("PREGUNTA 801: DEBE MARCAR UNA OPCIÓN"); return false;}

        if (c8_p802  == -1){mostrarMensaje("PREGUNTA 802: DEBE MARCAR UNA OPCIÓN"); return false;}

        if (c8_p803 == -1){mostrarMensaje("PREGUNTA 803: DEBE MARCAR UNA OPCIÓN"); return false;}

        if (c8_p804 == -1){mostrarMensaje("PREGUNTA 804: DEBE MARCAR UNA OPCIÓN"); return false;}


        return true;
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
