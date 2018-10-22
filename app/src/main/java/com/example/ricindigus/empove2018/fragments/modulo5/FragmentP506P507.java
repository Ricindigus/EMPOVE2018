package com.example.ricindigus.empove2018.fragments.modulo5;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.util.FragmentPagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentP506P507 extends FragmentPagina {

    RadioGroup c5_p506_1_RadioGroup, c5_p506_4_1_RadioGroup, c5_p506_4_2_RadioGroup, c5_p506_4_3_RadioGroup,
                c5_p506_4_4_RadioGroup, c5_p506_4_5_RadioGroup, c5_p506_4_6_RadioGroup ;
    EditText c5_p506_2_1_EditText, c5_p506_3_EditText, c5_p506_2_3_EditText, c5_p506_2_4_EditText, c5_p506_2_5_EditText, c5_p506_2_6_EditText;
    RadioGroup c5_p507_RadioGroup;
    Spinner c5_p507_dist_Spinner,  c5_p507_prov_Spinner, c5_p507_dep_Spinner;
    LinearLayout m5_p506_linearlayout, m5_p507_linearlayout;

    private int c5_p506_1;
    private String c5_p506_2;
    private String c5_p506_3;
    private int c5_p506_4;
    private int c5_p507;
    private int c5_p507_dist;
    private int c5_p507_prov;
    private int c5_p507_dep;


    public FragmentP506P507() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_p506_p507, container, false);
        c5_p506_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_radiogroup_C5_P506_1);
        c5_p506_2_1_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp1_textview_C5_P506_2);
        c5_p506_3_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp2_textview_C5_P506_3);
        c5_p506_2_3_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp3_textview_C5_P506_2);
        c5_p506_2_4_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp4_textview_C5_P506_2);
        c5_p506_2_5_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp5_textview_C5_P506_2);
        c5_p506_2_6_EditText = (EditText) rootView.findViewById(R.id.mod5_506_sp6_textview_C5_P506_2);
        c5_p506_4_1_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp1_radiogroup_C5_P506_4);
        c5_p506_4_2_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp2_radiogroup_C5_P506_4);
        c5_p506_4_3_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp3_radiogroup_C5_P506_4);
        c5_p506_4_4_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp4_radiogroup_C5_P506_4);
        c5_p506_4_5_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp5_radiogroup_C5_P506_4);
        c5_p506_4_6_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_506_sp6_radiogroup_C5_P506_4);
        c5_p507_RadioGroup = (RadioGroup) rootView.findViewById(R.id.mod5_507_radiogroup_C5_P507);
        c5_p507_dist_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_DIST);
        c5_p507_prov_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_PROV);
        c5_p507_dep_Spinner = (Spinner) rootView.findViewById(R.id.mod5_507_edittext_C5_P507_DEP);

        m5_p506_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p506);
        m5_p507_linearlayout = (LinearLayout) rootView.findViewById(R.id.layout_m5_p507);

        return rootView;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void llenarVariables() {
        c5_p506_1 = c5_p506_1_RadioGroup.indexOfChild(c5_p506_1_RadioGroup.findViewById(c5_p506_1_RadioGroup.getCheckedRadioButtonId()));
        switch (c5_p506_1){
            case 1: c5_p506_2 = c5_p506_2_1_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_1_RadioGroup.indexOfChild(c5_p506_4_1_RadioGroup.findViewById(c5_p506_4_1_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 2: c5_p506_3 = c5_p506_3_EditText.getText().toString(); c5_p506_2 = "";
                    c5_p506_4 = c5_p506_4_2_RadioGroup.indexOfChild(c5_p506_4_2_RadioGroup.findViewById(c5_p506_4_2_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 3: c5_p506_2 = c5_p506_2_3_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_3_RadioGroup.indexOfChild(c5_p506_4_3_RadioGroup.findViewById(c5_p506_4_3_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 4: c5_p506_2 = c5_p506_2_4_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_4_RadioGroup.indexOfChild(c5_p506_4_4_RadioGroup.findViewById(c5_p506_4_4_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 5: c5_p506_2 = c5_p506_2_5_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_5_RadioGroup.indexOfChild(c5_p506_4_5_RadioGroup.findViewById(c5_p506_4_5_RadioGroup.getCheckedRadioButtonId()));
                    break;
            case 6: c5_p506_2 = c5_p506_2_6_EditText.getText().toString(); c5_p506_3 = "";
                    c5_p506_4 = c5_p506_4_6_RadioGroup.indexOfChild(c5_p506_4_6_RadioGroup.findViewById(c5_p506_4_6_RadioGroup.getCheckedRadioButtonId()));
                    break;
            default: c5_p506_2 = ""; c5_p506_3 = ""; c5_p506_4 = -1; break;
        }

        c5_p506_3 = c5_p506_3_EditText.getText().toString();
        c5_p507 = c5_p507_RadioGroup.indexOfChild(c5_p507_RadioGroup.findViewById(c5_p507_RadioGroup.getCheckedRadioButtonId()));
        c5_p507_dist = c5_p507_dist_Spinner.getSelectedItemPosition();
        c5_p507_prov = c5_p507_prov_Spinner.getSelectedItemPosition();
        c5_p507_dep = c5_p507_dep_Spinner.getSelectedItemPosition();

    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public boolean validarDatos() {
        if(m5_p506_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p506_1<1){
                mostrarMensaje("PREGUNTA 506: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c5_p506_1==2){
                if(c5_p506_3.trim().length()==0){
                    mostrarMensaje("PREGUNTA 506: DEBE INGRESAR GRADO");
                    return false;
                }
            }else{
                if(c5_p506_2.trim().length()==0){
                    mostrarMensaje("PREGUNTA 506: DEBE INGRESAR AÑO");
                    return false;
                }
            }
            if(c5_p506_4<1){
                mostrarMensaje("PREGUNTA 506-OPCION 1: DEBE SELECCIONAR CENTRO DE ESTUDIOS");
                return false;
            }
        }
        if(m5_p507_linearlayout.getVisibility()==View.VISIBLE) {
            if(c5_p507<1){
                mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR UNA OPCION");
                return false;
            }
            if(c5_p507==2){
                if(c5_p507_dist<1){
                    mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR DISTRITO");
                    return false;
                }
                if(c5_p507_prov<1){
                    mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR PROVINCIA");
                    return false;
                }
                if(c5_p507_dep<1){
                    mostrarMensaje("PREGUNTA 507: DEBE SELECCIONAR DEPARTAMENTO");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablamodulo5;
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
}
