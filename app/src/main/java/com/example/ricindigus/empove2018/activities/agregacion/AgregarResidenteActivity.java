package com.example.ricindigus.empove2018.activities.agregacion;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.CoberturaFragment;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo3;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo4;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo5;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo6;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo7;
import com.example.ricindigus.empove2018.modelo.pojos.Modulo8;
import com.example.ricindigus.empove2018.modelo.pojos.POJOFragment;
import com.example.ricindigus.empove2018.modelo.pojos.POJOLayout;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;
import com.example.ricindigus.empove2018.util.InterfazOperaciones;
import com.example.ricindigus.empove2018.util.NumericKeyBoardTransformationMethod;

import java.util.ArrayList;

public class AgregarResidenteActivity extends AppCompatActivity implements InterfazOperaciones{

    TextInputEditText c2_p202_TextInputET, c2_p205_a_TextInputET, c2_p205_m_TextInputET;
    Spinner c2_p203_Spinner,c2_p206_Spinner;
    RadioGroup c2_p204_RadioGroup,c2_p207_RadioGroup;
    Toolbar toolbar;

    private String _id;
    private String id_hogar;
    private String id_vivienda;
    private String numero;
    private String idJefeHogar;
    private String id_informante = "";
    private String c2_p202;
    private int c2_p203;
    private int c2_p204;
    private String c2_p205_a;
    private String c2_p205_m;
    private String edadJefeHogar="0";
    private String c2_p206;
    private int c2_p207;
    private int cant_p_s_h=0,cant_p_s_m=0;

    boolean jefe_hogar=false,existe_conyuge=false;
    int cant_padres_suegros=0,edad_jefe_hogar=0;

    boolean editar=true;

    int sexo_residente=-1;

    private LinearLayout linearLayout202,linearLayout203,linearLayout204,linearLayout205,linearLayout206;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_residente);

        _id = getIntent().getExtras().getString("idEncuestado");
        id_hogar = getIntent().getExtras().getString("idHogar");
        id_vivienda = getIntent().getExtras().getString("idVivienda");
        numero = getIntent().getExtras().getString("numero");
        idJefeHogar = getIntent().getExtras().getString("idJefeHogar");


        linearLayout202 = (LinearLayout) findViewById(R.id.layout_m2_p202);
        linearLayout203 = (LinearLayout) findViewById(R.id.layout_m2_p203);
        linearLayout204 = (LinearLayout) findViewById(R.id.layout_m2_p204);
        linearLayout205 = (LinearLayout) findViewById(R.id.layout_m2_p205);
        linearLayout206 = (LinearLayout) findViewById(R.id.layout_m2_p206);


        c2_p202_TextInputET = (TextInputEditText) findViewById(R.id.mod2_202_textinputedittext_C2_P202);
        c2_p203_Spinner = (Spinner) findViewById(R.id.mod2_203_spinner_C2_P203);
        c2_p204_RadioGroup = (RadioGroup) findViewById(R.id.mod2_204_radiogroup_C2_P204);
        c2_p205_a_TextInputET = (TextInputEditText) findViewById(R.id.mod2_205_textinputedittext_C2_P205_A);
        c2_p205_m_TextInputET = (TextInputEditText) findViewById(R.id.mod2_205_textinputedittext_C2_P205_M);
        c2_p206_Spinner = (Spinner) findViewById(R.id.mod2_206_spinner_C2_P206);
        c2_p207_RadioGroup = (RadioGroup) findViewById(R.id.mod2_207_radiogroup_C2_P207);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("AGREGAR RESIDENTE");
        getSupportActionBar().setSubtitle("RESIDENTE Nº " + numero);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        configurarEditText(c2_p202_TextInputET,linearLayout202,1,40);
        configurarEditText(c2_p205_a_TextInputET,linearLayout205,2,2);
        configurarEditText(c2_p205_m_TextInputET,linearLayout205,2,2);

        c2_p205_a_TextInputET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")){
                    c2_p205_m_TextInputET.setEnabled(true);
                }else{
                    c2_p205_m_TextInputET.setEnabled(false);
                    if (Integer.parseInt(editable.toString()) < 12){
                        c2_p206_Spinner.setSelection(0);
                        linearLayout206.setVisibility(View.GONE);
                    }else{
                        linearLayout206.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        c2_p205_m_TextInputET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")){
                    c2_p205_a_TextInputET.setEnabled(true);
                    linearLayout206.setVisibility(View.VISIBLE);
                }else {
                    linearLayout206.setVisibility(View.GONE);
                    c2_p205_a_TextInputET.setEnabled(false);
                }
            }
        });

        cargarDatos();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_guardar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_guardar:
                llenarVariables();
                if (validarDatos()){
                    guardarDatos();
                    Data data = new Data(AgregarResidenteActivity.this);
                    data.open();

                    String val = data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p401,_id);
                    String frag = data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p501p505,_id);
                    ArrayList<Residente> residentes = data.getAllResidentesHogar(id_hogar);
                    for (Residente r: residentes){
                        POJOLayout pojoLayout = data.getLayouts(r.get_id());
                        POJOFragment pojoFragment = data.getFragmentsLayouts(r.get_id());
                    }
                    data.close();
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    public String getNombreTabla() {
        return SQLConstantes.tablaresidentes;
    }


    @Override
    public void llenarVariables(){
        id_informante = "";
        c2_p202 = c2_p202_TextInputET.getText().toString();
        c2_p203 = c2_p203_Spinner.getSelectedItemPosition();
        c2_p204 = c2_p204_RadioGroup.indexOfChild(c2_p204_RadioGroup.findViewById(c2_p204_RadioGroup.getCheckedRadioButtonId()));
        c2_p205_a = c2_p205_a_TextInputET.getText().toString();
        c2_p205_m = c2_p205_m_TextInputET.getText().toString();
        c2_p206 = c2_p206_Spinner.getSelectedItemPosition() + "";
        c2_p207 = c2_p207_RadioGroup.indexOfChild(c2_p207_RadioGroup.findViewById(c2_p207_RadioGroup.getCheckedRadioButtonId()));
    }

    public boolean validarDatos(){
        llenarVariables();
        if(c2_p202.trim().equals("")){mostrarMensaje("PREGUNTA 202: DEBE INDICAR EL NOMBRE"); return false;}
        if(c2_p203 == 0) {mostrarMensaje("PREGUNTA 203: DEBE INDICAR EL PARENTESCO"); return false;}
        else{
            if (c2_p203 == 3 || c2_p203 == 5){
                int edad = 0;
                if (!c2_p205_a.equals("")) edad = Integer.parseInt(c2_p205_a);
                if(edadJefeHogar.equals("0")){mostrarMensaje("PREGUNTA 205: FALTA INGRESAR EDAD DE JEFE DE HOGAR, DEBE COMPLETAR PRIMERO LA INFORMACIÓN DEL JEFE DE HOGAR"); return false;}
                if (edad > Integer.parseInt(edadJefeHogar)){mostrarMensaje("PREGUNTA 205: SI ES HIJO/A O NIETO/A, LA EDAD DEBE SER MENOR A LA EDAD DEL JEFE DEL HOGAR ("+edadJefeHogar+")"); return false;}
                if (c2_p203 == 3 && (Integer.parseInt(edadJefeHogar) - edad)<12){mostrarMensaje("PREGUNTA 205: La diferencia de edades del jefe del hogar("+edadJefeHogar+") y el hijo no corresponde"); return false;}
                if (c2_p203 == 5 && (Integer.parseInt(edadJefeHogar) - edad)<30){mostrarMensaje("PREGUNTA 205: La diferencia de edades del jefe del hogar("+edadJefeHogar+") y el nieto  no corresponde"); return false;}
            }
        }
        if(!jefe_hogar && c2_p203 == 1){mostrarMensaje("PREGUNTA 203: Existe más de un jefe de hogar"); return false;}

        if(cant_padres_suegros>=4 && c2_p203 == 6){mostrarMensaje("PREGUNTA 203: Existe más de cuatro padres/suegros en el hogar"); return false;}
        if(existe_conyuge && c2_p203 == 2){mostrarMensaje("PREGUNTA 203: Existe más de un cónyuge en el hogar"); return false;}
        int edadd = 0;
        if (!c2_p205_a.equals("")) edadd = Integer.parseInt(c2_p205_a);
        if(c2_p203==1 && edadd<12) {mostrarMensaje("PREGUNTA 205: La edad del Jefe del hogar debe ser mayor o igual a 12 años"); return false;}
        if(c2_p203==2 && edadd<12) {mostrarMensaje("PREGUNTA 205: El cónyuge debe ser mayor o igual a 12 años"); return false;}
        if(c2_p203==6 && edadd<33) {mostrarMensaje("PREGUNTA 205: Los padres o suegros deben ser mayor o igual a 33 años"); return false;}
        if(c2_p203==9 && edadd<5) {mostrarMensaje("PREGUNTA 205: La trabajadora del hogar debe ser mayor o igual a 5 años"); return false;}
        if(c2_p203==4 && (edadd<12 || edadd>80)) {mostrarMensaje("PREGUNTA 205: Verificar la edad del yerno o nuera"); return false;}
        if(c2_p204 == -1) {mostrarMensaje("PREGUNTA 204: DEBE INDICAR EL SEXO"); return false;}
        if(c2_p203==6){
            if(editar){
                if(sexo_residente!=c2_p204){
                    if(cant_p_s_h>=2 && c2_p204==1){
                        mostrarMensaje("PREGUNTA 204: YA INGRESO DOS PADRES/SUEGOS - HOMBRE"); return false;
                    }
                    if(cant_p_s_m>=2 && c2_p204==2){
                        mostrarMensaje("PREGUNTA 204: YA INGRESO DOS PADRES/SUEGOS - MUJER"); return false;
                    }
                }
            }else{
                if(cant_p_s_h>=2 && c2_p204==1){
                    mostrarMensaje("PREGUNTA 204: YA INGRESO DOS PADRES/SUEGOS - HOMBRE"); return false;
                }
                if(cant_p_s_m>=2 && c2_p204==2){
                    mostrarMensaje("PREGUNTA 204: YA INGRESO DOS PADRES/SUEGOS - MUJER"); return false;
                }
            }
        }
        if(c2_p205_a.trim().equals("") && c2_p205_m.trim().equals("")) {mostrarMensaje("PREGUNTA 205: DEBE INDICAR LA EDAD EN AÑOS O MESES"); return false;}
        if(!c2_p205_a.trim().equals("")) {
            if(Integer.parseInt(c2_p205_a)<1 || Integer.parseInt(c2_p205_a)>99){
                mostrarMensaje("PREGUNTA 205: AÑOS DEBE SER MAYOR QUE CERO");
                return false;
            }
        }
        if(!c2_p205_m.trim().equals("")) {
            if(Integer.parseInt(c2_p205_m)<0 || Integer.parseInt(c2_p205_m)>11){
                mostrarMensaje("PREGUNTA 205: MESES DEBE ESTAR EN EL INTERVALO DE 0 A 11");
                return false;
            }
        }

        if(!c2_p205_a.trim().equals("")){
            if(Integer.parseInt(c2_p205_a)<12){
                if(c2_p203==1 || c2_p203==2 || c2_p203==4 || c2_p203==6 || c2_p203==10){
                    mostrarMensaje("PREGUNTA 203: NO SE DEBE SELECCIONAR LAS OPCIONES (Jefe/a del hogar, Esposo/a o compañero/a, Yerno/Nuera, Padres/Suegros, Pensionista)"); return false;
                }
            }
        }
        if(!c2_p205_m.trim().equals("")){
            if(c2_p203==1 || c2_p203==2 || c2_p203==4 || c2_p203==6 || c2_p203==10){
                mostrarMensaje("PREGUNTA 203: NO SE DEBE SELECCIONAR LAS OPCIONES (Jefe/a del hogar, Esposo/a o compañero/a, Yerno/Nuera, Padres/Suegros, Pensionista)"); return false;
            }
        }
        if (linearLayout206.getVisibility()==View.VISIBLE){
            if(c2_p206.equals("0")) {mostrarMensaje("PREGUNTA 206: DEBE INDICAR EL ESTADO CIVIL"); return false;}
            if(!jefe_hogar && c2_p203 == 4 && c2_p206.equals("6")){mostrarMensaje("PREGUNTA 206: Estado civil de yerno/nuera no corresponde"); return false;}
        }else{
            c2_p206 = "";
        }
        if(c2_p207 == -1) {mostrarMensaje("PREGUNTA 207: DEBE INDICAR SI LLEGÓ DE VENEZUELA"); return false;}

        if (Integer.parseInt(numero) > 1) {
            if (c2_p203 == 1) {mostrarMensaje("PREGUNTA 203: SOLO PUEDE HABER UN JEFE DE HOGAR"); return false;}
        }

        return true;
    }

    @Override
    public void cargarDatos() {
        editar=false;
        int edad_p=0;
        Data data = new Data(this);
        data.open();
        jefe_hogar = false; existe_conyuge = false; cant_padres_suegros = 0; edad_jefe_hogar = 0;
        if(data.existeElemento(getNombreTabla(),_id)){
            Residente residente = data.getResidente(_id);
            if (residente.getNumero().equals("1")){
                c2_p202_TextInputET.setEnabled(false);
                c2_p203_Spinner.setEnabled(false);
                jefe_hogar = true;
            }else {
                jefe_hogar = false;
            }
            c2_p202_TextInputET.setText(residente.getC2_p202());
            c2_p203_Spinner.setSelection(Integer.parseInt(residente.getC2_p203()));
            if (!residente.getC2_p204().equals("")){
                ((RadioButton)c2_p204_RadioGroup.getChildAt(Integer.parseInt(residente.getC2_p204()))).setChecked(true);
                sexo_residente = Integer.parseInt(residente.getC2_p204());
            }
            c2_p205_a_TextInputET.setText(residente.getC2_p205_a2());
            c2_p205_m_TextInputET.setText(residente.getC2_p205_m());
            if(!residente.getC2_p206().equals(""))c2_p206_Spinner.setSelection(Integer.parseInt(residente.getC2_p206()));
            if (!residente.getC2_p207().equals(""))((RadioButton)c2_p207_RadioGroup.getChildAt(Integer.parseInt(residente.getC2_p207()))).setChecked(true);
            if(!residente.getC2_p205_a().equals("")) edad_p = Integer.parseInt(residente.getC2_p205_a());
            if(edad_p<12){
                c2_p206_Spinner.setSelection(0);
                linearLayout206.setVisibility(View.GONE);
            }else{
                linearLayout206.setVisibility(View.VISIBLE);
            }
        }
        if(data.getResidente(idJefeHogar).getC2_p205_a()==null) {
            edadJefeHogar = "0";
        }else if(data.getResidente(idJefeHogar).getC2_p205_a().equals("")){
            edadJefeHogar = "0";
        }else {
            edadJefeHogar = data.getResidente(idJefeHogar).getC2_p205_a();
        }
        ArrayList<Residente> residentes;

        residentes = new ArrayList<>();

        residentes = data.getAllResidentesHogar(id_hogar);

        if(Integer.parseInt(numero)<=residentes.size()){
            editar = true;
        }
        cant_p_s_h=0; cant_p_s_m = 0;
        if(residentes.size()>0){
            for(Residente r: residentes){
                if(r.getC2_p203().equals("1")){
                    if(r.getC2_p205_a().equals("")){r.setC2_p205_a("0");}
                    edad_jefe_hogar = Integer.parseInt(r.getC2_p205_a());
                }
                if(r.getC2_p203().equals("2")){
                    existe_conyuge = true;
                }
                if(r.getC2_p203().equals("6")){
                    cant_padres_suegros++;
                    if(r.getC2_p204().equals("1")){
                        cant_p_s_m++;
                    }
                    if(r.getC2_p204().equals("2")){
                        cant_p_s_m++;
                    }
                }
            }
        }
        data.close();

    }

    @Override
    public void llenarVista() {

    }

    @Override
    public void guardarDatos(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.residentes_c2_p202,c2_p202);
        contentValues.put(SQLConstantes.residentes_c2_p203,c2_p203);
        contentValues.put(SQLConstantes.residentes_c2_p204,c2_p204);
        contentValues.put(SQLConstantes.residentes_c2_p205_a,c2_p205_a);
        contentValues.put(SQLConstantes.residentes_c2_p205_m,c2_p205_m);
        contentValues.put(SQLConstantes.residentes_c2_p206,c2_p206);
        contentValues.put(SQLConstantes.residentes_c2_p207,c2_p207 +"");
        contentValues.put(SQLConstantes.residentes_COB200,"1");
        contentValues.put(SQLConstantes.residentes_encuestado_cobertura,"0");

        if(!data.existeElemento(getNombreTabla(),_id)){
            contentValues.put(SQLConstantes.residentes_id,_id);
            contentValues.put(SQLConstantes.residentes_id_hogar, id_hogar);
            contentValues.put(SQLConstantes.residentes_id_informante, id_informante);
            contentValues.put(SQLConstantes.residentes_id_vivienda, id_vivienda);
            contentValues.put(SQLConstantes.residentes_numero,numero);
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.actualizarElemento(getNombreTabla(),contentValues,_id);
        data.actualizarValor(SQLConstantes.tablahogares,SQLConstantes.hogar_nroviven,numero,id_hogar);

        //SI ES MIGRANTE
        if (c2_p207 == 1){
            if(!data.existeElemento(SQLConstantes.tablalayouts,_id)){
                POJOLayout pojoLayout = new POJOLayout();
                pojoLayout.set_id(_id);
                pojoLayout.setId_vivienda(id_vivienda);
                data.insertarElemento(SQLConstantes.tablalayouts,pojoLayout.toValues());
                POJOFragment pojoFragment = new POJOFragment(_id);
                pojoFragment.setId_vivienda(id_vivienda);
                CoberturaFragment coberturaFragment = new CoberturaFragment(_id);
                coberturaFragment.setId_vivienda(id_vivienda);
                data.insertarElemento(SQLConstantes.tablafragments,pojoFragment.toValues());
                data.insertarElemento(SQLConstantes.tablacoberturafragments,coberturaFragment.toValues());
            }
            crearModulos();
            ocultarOtrosLayouts(c2_p205_a,c2_p204+"");
        }
        data.close();
    }


    public void crearModulos(){
        Data data = new Data(this);
        data.open();
        Modulo3 modulo3 = new Modulo3();
        modulo3.set_id(_id);
        modulo3.setIdHogar(id_hogar);
        modulo3.setIdVivienda(id_vivienda);
        Modulo4 modulo4 = new Modulo4();
        modulo4.set_id(_id);
        modulo4.setIdHogar(id_hogar);
        modulo4.setIdVivienda(id_vivienda);
        Modulo5 modulo5 = new Modulo5();
        modulo5.set_id(_id);
        modulo5.setIdHogar(id_hogar);
        modulo5.setIdVivienda(id_vivienda);
        Modulo6 modulo6 = new Modulo6();
        modulo6.set_id(_id);
        modulo6.setIdHogar(id_hogar);
        modulo6.setIdVivienda(id_vivienda);
        Modulo7 modulo7 = new Modulo7();
        modulo7.set_id(_id);
        modulo7.setIdHogar(id_hogar);
        modulo7.setIdVivienda(id_vivienda);
        Modulo8 modulo8 = new Modulo8();
        modulo8.set_id(_id);
        modulo8.setIdHogar(id_hogar);
        modulo8.setIdVivienda(id_vivienda);
        if (!data.existeElemento(SQLConstantes.tablamodulo3,_id)) data.insertarElemento(SQLConstantes.tablamodulo3,modulo3.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo4,_id)) data.insertarElemento(SQLConstantes.tablamodulo4,modulo4.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo5,_id)) data.insertarElemento(SQLConstantes.tablamodulo5,modulo5.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo6,_id)) data.insertarElemento(SQLConstantes.tablamodulo6,modulo6.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo7,_id)) data.insertarElemento(SQLConstantes.tablamodulo7,modulo7.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo8,_id)) data.insertarElemento(SQLConstantes.tablamodulo8,modulo8.toValues());
        data.close();
    }



    public void ocultarOtrosLayouts(String edad, String sexo){
        String ids_residentes="";
        Data data = new Data(AgregarResidenteActivity.this);
        data.open();
        int iEdad = 0;
        int iSexo = 0;
        boolean entro=false;
        if (!edad.equals("")) iEdad = Integer.parseInt(edad);
        iSexo = Integer.parseInt(sexo);

        ArrayList<Residente> residentes = data.getAllResidentesHogar(id_hogar);
        boolean todosMayoresEdad = true;
        for (Residente r : residentes){
            int ed = 0;
            if(!entro){//SOLO ID DE >=12
                if(Integer.parseInt(r.getC2_p205_a())>=12){
                    ids_residentes += r.get_id();entro=true;
                }
            }else{
                if(Integer.parseInt(r.getC2_p205_a())>=12){
                    ids_residentes += "," +r.get_id();
                }
            }
            //ids_residentes += r.get_id();
            if (!r.getC2_p205_a().equals("")) ed = Integer.parseInt(r.getC2_p205_a());
            if (ed < 18) todosMayoresEdad = false;
        }

        if (todosMayoresEdad){
            for (Residente r : residentes){
                ocultarP409(r.get_id());
                ocultarP410(r.get_id());
            }
        }else{
            for (Residente r : residentes){
                int ed = 0;
                if (!r.getC2_p205_a().equals("")) ed = Integer.parseInt(r.getC2_p205_a());
                if (ed >= 18 || r.getNumero().equals("1")) {
                    mostrarLayoutPregunta(SQLConstantes.layouts_p409,r.get_id());
                    mostrarLayoutPregunta(SQLConstantes.layouts_p410,r.get_id());
                }else{
                    ocultarP409(r.get_id());
                    ocultarP410(r.get_id());
                }
            }
        }

        if (iEdad <= 17)mostrarLayoutPregunta(SQLConstantes.layouts_p411);
        else ocultarP411();

        if (iEdad >= 12 && iEdad <= 49 && iSexo == 2){
            mostrarLayoutPregunta(SQLConstantes.layouts_p412);
            mostrarLayoutPregunta(SQLConstantes.layouts_p413);
            mostrarLayoutPregunta(SQLConstantes.layouts_p414);
            mostrarLayoutPregunta(SQLConstantes.layouts_p415);
        } else{ ocultarP412();ocultarP413();ocultarP414();ocultarP415(); }

        if (iEdad >= 15) mostrarLayoutPregunta(SQLConstantes.layouts_p416);
        else ocultarP416();



        if (iEdad >= 3) mostrarCapitulo5();
        else ocultarCapitulo5();

        if (iEdad >= 5) { mostrarCapitulo6();mostrarCapitulo7(); }
        else { ocultarCapitulo6();ocultarCapitulo7(); }

        if (iEdad >= 18) mostrarCapitulo8();
        else ocultarCapitulo8();


        if (iEdad >= 3 && iEdad <=25){
            mostrarLayoutPregunta(SQLConstantes.layouts_p508);
            //mostrarLayoutPregunta(SQLConstantes.layouts_p509);
            //mostrarLayoutPregunta(SQLConstantes.layouts_p510);
            //mostrarLayoutPregunta(SQLConstantes.layouts_p511);
            //if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,_id).equals("-1"))
            //    data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"1",_id);
        } else {
            ocultarP508();//ocultarP509();ocultarP510();ocultarP511();
            //data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"-1",_id);
        }

        if (iEdad >= 14){
            mostrarLayoutPregunta(SQLConstantes.layouts_p512);
            mostrarLayoutPregunta(SQLConstantes.layouts_p513);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p512p513,_id).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p512p513,"1",_id);
            mostrarLayoutPregunta(SQLConstantes.layouts_p629);
            mostrarLayoutPregunta(SQLConstantes.layouts_p630);
        } else {
            ocultarP512();ocultarP513();
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p512p513,"-1",_id);
            ocultarP629();ocultarP630(); }

        if (iEdad >= 12){
            if(!todosMayoresEdad) {
                Log.e("algun menor de edad", "ocultarOtrosLayouts: " + ids_residentes);
                String[] residente_id = ids_residentes.split(",");
                for(String id_residente:residente_id){
                    Log.e("mostrar", "ocultarOtrosLayouts: "+ id_residente);
                    mostrarLayoutPregunta(SQLConstantes.layouts_p625,id_residente);
                    if (data.getValor(SQLConstantes.tablafragments, SQLConstantes.fragments_p622p625, id_residente).equals("-1"))
                        data.actualizarValor(SQLConstantes.tablafragments, SQLConstantes.fragments_p622p625, "1", id_residente);
                }
            }else{
                Log.e("ningun menor de edad", "ocultarOtrosLayouts: " + ids_residentes);
                String[] residente_id = ids_residentes.split(",");
                for(String id_residente:residente_id){
                    Log.e("ocultar", "ocultarOtrosLayouts: "+ id_residente);
                    ocultarP625_2(id_residente);
                    if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p622,id_residente).equals("0") &&
                            data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p623,id_residente).equals("0") &&
                            data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p624,id_residente).equals("0") &&
                            data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p625,id_residente).equals("0")){
                        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"-1",id_residente);
                    }
                }
//                ocultarP625();
//                if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p622,_id).equals("0") &&
//                        data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p623,_id).equals("0") &&
//                        data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p624,_id).equals("0") &&
//                        data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p625,_id).equals("0")){
//                    data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"-1",_id);
//                }
            }
        } else {
//            String[] residente_id = ids_residentes.split(",");
//            for(String id_residente:residente_id){
//                ocultarP625_2(id_residente);
//                if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p622,id_residente).equals("0") &&
//                        data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p623,id_residente).equals("0") &&
//                        data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p624,id_residente).equals("0") &&
//                        data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p625,id_residente).equals("0")){
//                    data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"-1",id_residente);
//                }
//            }
            ocultarP625();
            if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p622,_id).equals("0") &&
                    data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p623,_id).equals("0") &&
                    data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p624,_id).equals("0") &&
                    data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p625,_id).equals("0")){
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"-1",_id);
            }
        }


        if(data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p411,_id).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p412,_id).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p413,_id).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p414,_id).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p415,_id).equals("0") &&
                data.getValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p416,_id).equals("0")){
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p411p416,"-1",_id);
        }else {
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p411p416,_id).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p411p416,"1",_id);
        }
        data.close();
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void configurarEditText(final EditText editText, final View view, int tipo,int longitud){
        if (tipo == 1) editText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(longitud)});

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(editText);
                    view.requestFocus();
                    return true;
                }
                return false;
            }
        });
        if (tipo == 2) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(longitud)});
            editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        }
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void ocultarP409(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_c4_p409,"",_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p409,"0",_id);
        data.close();
    }

    public void ocultarP409(String idEncuestado){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_c4_p409,"",idEncuestado);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p409,"0",idEncuestado);
        data.close();
    }

    public void ocultarP410(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_c4_p410,"",_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p410,"0",_id);
        data.close();
    }

    public void ocultarP410(String idEncuestado){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_c4_p410,"",idEncuestado);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p410,"0",idEncuestado);
        data.close();
    }

    public void ocultarP411(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo4_c4_p411_1,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_2,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_3,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_4,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_5,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_6,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_7,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_8,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_9,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_10,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_11,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_12,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_13,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_14,"");
        contentValues.put(SQLConstantes.modulo4_c4_p411_o,"");
        data.actualizarElemento(SQLConstantes.tablamodulo4,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p411,"0",_id);
        data.close();

    }

    public void ocultarP412(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_c4_p412,"",_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p412,"0",_id);
        data.close();
    }

    public void ocultarP413(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_c4_p413,"",_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p413,"0",_id);
        data.close();
    }
    public void ocultarP414(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_c4_p414,"",_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p414,"0",_id);
        data.close();
    }
    public void ocultarP415(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo4,SQLConstantes.modulo4_c4_p415,"",_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p415,"0",_id);
        data.close();
    }
    public void ocultarP416(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo4_c4_p416_1,"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_2,"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_3,"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_4,"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_5,"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_6,"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_7,"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_8,"");
        contentValues.put(SQLConstantes.modulo4_c4_p416_o,"");
        data.actualizarElemento(SQLConstantes.tablamodulo4,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p416,"0",_id);
        data.close();
    }

    public void ocultarP508(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_c5_p508_1,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_2,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_3,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_4,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_5,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_6,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_7,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_8,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_9,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_10,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_11,"");
        contentValues.put(SQLConstantes.modulo5_c5_p508_o,"");
        data.actualizarElemento(SQLConstantes.tablamodulo5,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p508,"0",_id);
        data.close();

    }
    public void ocultarP509(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo5,SQLConstantes.modulo5_c5_p509,"",_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p509,"0",_id);
        data.close();
    }
    public void ocultarP510(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablamodulo5,SQLConstantes.modulo5_c5_p510,"",_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p510,"0",_id);
        data.close();
    }
    public void ocultarP511(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_c5_p511,"");
        contentValues.put(SQLConstantes.modulo5_c5_p511_o,"");
        data.actualizarElemento(SQLConstantes.tablamodulo5,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p511,"0",_id);
        data.close();
    }
    public void ocultarP512(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_c5_p512,"");
        contentValues.put(SQLConstantes.modulo5_c5_p512_o,"");
        data.actualizarElemento(SQLConstantes.tablamodulo5,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p512,"0",_id);
        data.close();
    }
    public void ocultarP513(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo5_c5_p512,"");
        contentValues.put(SQLConstantes.modulo5_c5_p513_o,"");
        data.actualizarElemento(SQLConstantes.tablamodulo5,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p513,"0",_id);
        data.close();
    }

    public void ocultarP625(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p625_1,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_2,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_3,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_4,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_5,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_6,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_o,"");
        data.actualizarElemento(SQLConstantes.tablamodulo6,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p625,"0",_id);
        data.close();
    }

    public void ocultarP625_2(String id_residente){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p625_1,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_2,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_3,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_4,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_5,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_6,"");
        contentValues.put(SQLConstantes.modulo6_c6_p625_o,"");
        data.actualizarElemento(SQLConstantes.tablamodulo6,contentValues,id_residente);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p625,"0",id_residente);
        data.close();
    }

    public void ocultarP629(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p629_1,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_2,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_3,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_4,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_o,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_1_f,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_1_m,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_2_f,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_2_m,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_3_f,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_3_m,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_4_f,"");
        contentValues.put(SQLConstantes.modulo6_c6_p629_4_m,"");
        data.actualizarElemento(SQLConstantes.tablamodulo6,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p629,"0",_id);
        data.close();
    }
    public void ocultarP630(){
        Data data = new Data(this);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_c6_p630_1,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1med,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1o,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1frec,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_1mont,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2med,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2o,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2frec,"");
        contentValues.put(SQLConstantes.modulo6_c6_p630_2mont,"");
        data.actualizarElemento(SQLConstantes.tablamodulo6,contentValues,_id);
        data.actualizarValor(SQLConstantes.tablalayouts,SQLConstantes.layouts_p630,"0",_id);
        data.close();
    }

    public void mostrarLayoutPregunta(String varLayout){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablalayouts,varLayout,"1",_id);
        data.close();
    }

    public void mostrarLayoutPregunta(String varLayout, String idEncuestado){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablalayouts,varLayout,"1",idEncuestado);
        data.close();
    }

    public void ocultarCapitulo5(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p501p505,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p506p507,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p512p513,"-1",_id);
        data.eliminarDato(SQLConstantes.tablamodulo5,_id);
        data.close();
    }
    public void mostrarCapitulo5(){
        Data data = new Data(this);
        data.open();
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p501p505,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p501p505,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p506p507,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p506p507,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p512p513,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p512p513,"1",_id);
        Modulo5 modulo5 = new Modulo5();
        modulo5.set_id(_id);
        modulo5.setIdHogar(id_hogar);
        modulo5.setIdVivienda(id_vivienda);
        if (!data.existeElemento(SQLConstantes.tablamodulo5,_id)) data.insertarElemento(SQLConstantes.tablamodulo5,modulo5.toValues());
        data.close();
    }
    public void ocultarCapitulo6(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p601p604,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p617,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p618p621,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p626p629,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p630,"-1",_id);
        data.eliminarDato(SQLConstantes.tablamodulo6,_id);

        data.close();
    }
    public void mostrarCapitulo6(){
        Data data = new Data(this);
        data.open();
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p601p604,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p601p604,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p617,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p617,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p618p621,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p618p621,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p622p625,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p626p629,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p626p629,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p630,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p630,"1",_id);

        Modulo6 modulo6 = new Modulo6();
        modulo6.set_id(_id);
        modulo6.setIdHogar(id_hogar);
        modulo6.setIdVivienda(id_vivienda);
        if (!data.existeElemento(SQLConstantes.tablamodulo6,_id)) data.insertarElemento(SQLConstantes.tablamodulo6,modulo6.toValues());
        data.close();
    }
    public void ocultarCapitulo7(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p701p705,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p706p709,"-1",_id);
        data.eliminarDato(SQLConstantes.tablamodulo7,_id);
        data.close();
    }
    public void mostrarCapitulo7(){
        Data data = new Data(this);
        data.open();
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p701p705,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p701p705,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p706p709,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p706p709,"1",_id);

        Modulo7 modulo7 = new Modulo7();
        modulo7.set_id(_id);
        modulo7.setIdHogar(id_hogar);
        modulo7.setIdVivienda(id_vivienda);
        if (!data.existeElemento(SQLConstantes.tablamodulo7,_id)) data.insertarElemento(SQLConstantes.tablamodulo7,modulo7.toValues());
        data.close();
    }
    public void ocultarCapitulo8(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p801p804,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p805p808,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p809p812,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p813p816,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p817p820,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p821p823,"-1",_id);
        data.eliminarDato(SQLConstantes.tablamodulo8,_id);
        data.close();
    }
    public void mostrarCapitulo8(){
        Data data = new Data(this);
        data.open();
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p801p804,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p801p804,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p805p808,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p805p808,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p809p812,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p809p812,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p813p816,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p813p816,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p817p820,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p817p820,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p821p823,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p821p823,"1",_id);
        Modulo8 modulo8 = new Modulo8();
        modulo8.set_id(_id);
        modulo8.setIdHogar(id_hogar);
        modulo8.setIdVivienda(id_vivienda);
        if (!data.existeElemento(SQLConstantes.tablamodulo8,_id)) data.insertarElemento(SQLConstantes.tablamodulo8,modulo8.toValues());
        data.close();
    }
}
