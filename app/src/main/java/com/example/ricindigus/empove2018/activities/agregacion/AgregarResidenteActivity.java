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
    RadioGroup c2_p204_RadioGroup;
    Toolbar toolbar;

    private String _id;
    private String id_hogar;
    private String id_vivienda;
    private String numero;
    private String id_informante = "";
    private String c2_p202;
    private int c2_p203;
    private int c2_p204;
    private String c2_p205_a;
    private String c2_p205_m;

    private int c2_p206;

    private LinearLayout linearLayout202,linearLayout203,linearLayout204,linearLayout205,linearLayout206;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_residente);

        _id = getIntent().getExtras().getString("idEncuestado");
        id_hogar = getIntent().getExtras().getString("idHogar");
        id_vivienda = getIntent().getExtras().getString("idVivienda");
        numero = getIntent().getExtras().getString("numero");

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
                }else c2_p205_m_TextInputET.setEnabled(false);
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
                }else c2_p205_a_TextInputET.setEnabled(false);
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

    public boolean validarDatos(){
        if(c2_p202.trim().equals("")){mostrarMensaje("PREGUNTA 202: DEBE INDICAR EL NOMBRE"); return false;}
        if(c2_p203 == 0) {mostrarMensaje("PREGUNTA 203: DEBE INDICAR EL PARENTESCO"); return false;}
        if(c2_p204 == -1) {mostrarMensaje("PREGUNTA 204: DEBE INDICAR EL SEXO"); return false;}
        if(c2_p205_a.trim().equals("") && c2_p205_m.trim().equals("")) {mostrarMensaje("PREGUNTA 205: DEBE INDICAR LA EDAD EN AÑOS O MESES"); return false;}
        if(!c2_p205_a.trim().equals("")) {
            if(Integer.parseInt(c2_p205_a)<1 || Integer.parseInt(c2_p205_a)>99){
                mostrarMensaje("PREGUNTA 205: AÑOS DEBE SER MAYOR QUE CERO");
                return false;
            }
        }
        if(!c2_p205_m.trim().equals("")) {
            if(Integer.parseInt(c2_p205_m)<1 || Integer.parseInt(c2_p205_m)>11){
                mostrarMensaje("PREGUNTA 205: MESES DEBE ESTAR EN EL INTERVALO DE 1 A 11");
                return false;
            }
        }
        if(c2_p206 == 0) {mostrarMensaje("PREGUNTA 206: DEBE INDICAR EL ESTADO CIVIL"); return false;}
        if(!c2_p205_a.trim().equals("")){
            if(Integer.parseInt(c2_p205_a)<12){
                if(c2_p203==1 || c2_p203==2 || c2_p203==4 || c2_p203==6 || c2_p203==10){
                    mostrarMensaje("PREGUNTA 203: NO SE DEBE SELECCIONAR LAS OPCIONES (Jefe/a del hogar, Esposo/a o compañero/a, Yerno/Nuera, Padres/Suegros, Pensionista)"); return false;
                }
                if(c2_p206!=6){
                    mostrarMensaje("PREGUNTA 206: DEBE SELECCIONAR ESTADO CIVIL (SOLTERO/A)"); return false;
                }
            }
        }
        if(!c2_p205_m.trim().equals("")){
            if(c2_p203==1 || c2_p203==2 || c2_p203==4 || c2_p203==6 || c2_p203==10){
                mostrarMensaje("PREGUNTA 203: NO SE DEBE SELECCIONAR LAS OPCIONES (Jefe/a del hogar, Esposo/a o compañero/a, Yerno/Nuera, Padres/Suegros, Pensionista)"); return false;
            }
            if(c2_p206!=6){
                mostrarMensaje("PREGUNTA 206: DEBE SELECCIONAR ESTADO CIVIL (SOLTERO/A)"); return false;
            }
        }
        return true;
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
        c2_p206 = c2_p206_Spinner.getSelectedItemPosition();
    }

    @Override
    public void cargarDatos() {
        Data data = new Data(this);
        data.open();
        if(data.existeElemento(getNombreTabla(),_id)){
            Residente residente = data.getResidente(_id);
            if (residente.getNumero().equals("1")){
                c2_p202_TextInputET.setEnabled(false);
                c2_p203_Spinner.setEnabled(false);
            }
            c2_p202_TextInputET.setText(residente.getC2_p202());
            c2_p203_Spinner.setSelection(Integer.parseInt(residente.getC2_p203()));
            if (!residente.getC2_p204().equals(""))((RadioButton)c2_p204_RadioGroup.getChildAt(Integer.parseInt(residente.getC2_p204()))).setChecked(true);
            c2_p205_a_TextInputET.setText(residente.getC2_p205_a());
            c2_p205_m_TextInputET.setText(residente.getC2_p205_m());
            if(!residente.getC2_p206().equals(""))c2_p206_Spinner.setSelection(Integer.parseInt(residente.getC2_p206()));
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

        if(!data.existeElemento(getNombreTabla(),_id)){
            contentValues.put(SQLConstantes.residentes_id,_id);
            contentValues.put(SQLConstantes.residentes_idHogar, id_hogar);
            contentValues.put(SQLConstantes.residentes_idInformante, id_informante);
            contentValues.put(SQLConstantes.residentes_idVivienda, id_vivienda);
            contentValues.put(SQLConstantes.residentes_numero,numero);
            data.insertarElemento(getNombreTabla(),contentValues);
        }
        data.actualizarElemento(getNombreTabla(),contentValues,_id);
        data.actualizarValor(SQLConstantes.tablahogares,SQLConstantes.hogar_nroviven,numero,id_hogar);
        if(!data.existeElemento(SQLConstantes.tablalayouts,_id)){
            POJOLayout pojoLayout = new POJOLayout();
            pojoLayout.set_id(_id);
            data.insertarElemento(SQLConstantes.tablalayouts,pojoLayout.toValues());
            POJOFragment pojoFragment = new POJOFragment();
            pojoFragment.set_id(_id);
            data.insertarElemento(SQLConstantes.tablafragments,pojoFragment.toValues());
        }
        data.close();
        crearModulos();
        ocultarOtrosLayouts(c2_p205_a,c2_p204+"");
    }


    public void crearModulos(){
        Data data = new Data(this);
        data.open();
        Modulo3 modulo3 = new Modulo3(_id,id_hogar,id_vivienda);
        Modulo4 modulo4 = new Modulo4(_id,id_hogar,id_vivienda);
        Modulo5 modulo5 = new Modulo5(_id,id_hogar,id_vivienda);
        Modulo6 modulo6 = new Modulo6(_id,id_hogar,id_vivienda);
        Modulo7 modulo7 = new Modulo7(_id,id_hogar,id_vivienda);
        Modulo8 modulo8 = new Modulo8(_id,id_hogar,id_vivienda);
        if (!data.existeElemento(SQLConstantes.tablamodulo3,_id)) data.insertarElemento(SQLConstantes.tablamodulo3,modulo3.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo4,_id)) data.insertarElemento(SQLConstantes.tablamodulo4,modulo4.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo5,_id)) data.insertarElemento(SQLConstantes.tablamodulo5,modulo5.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo6,_id)) data.insertarElemento(SQLConstantes.tablamodulo6,modulo6.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo7,_id)) data.insertarElemento(SQLConstantes.tablamodulo7,modulo7.toValues());
        if (!data.existeElemento(SQLConstantes.tablamodulo8,_id)) data.insertarElemento(SQLConstantes.tablamodulo8,modulo8.toValues());
        data.close();
    }



    public void ocultarOtrosLayouts(String edad, String sexo){
        Data data = new Data(AgregarResidenteActivity.this);
        data.open();
        int iEdad = 0;
        int iSexo = 0;
        if (!edad.equals("")) iEdad = Integer.parseInt(edad);
        iSexo = Integer.parseInt(sexo);

        ArrayList<Residente> residentes = data.getAllResidentesHogar(id_hogar);
        boolean todosMayoresEdad = true;
        for (Residente r : residentes){
            int ed = 0;
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
            mostrarLayoutPregunta(SQLConstantes.layouts_p509);
            mostrarLayoutPregunta(SQLConstantes.layouts_p510);
            mostrarLayoutPregunta(SQLConstantes.layouts_p511);
            if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,_id).equals("-1"))
                data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"1",_id);
        } else {
            ocultarP508();ocultarP509();ocultarP510();ocultarP511();
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p508p511,"-1",_id);
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
        data.close();
    }
    public void ocultarCapitulo6(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p601p604,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p605p608,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p609p612,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p618,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p619p622,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p623p625,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p626p629,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p630,"-1",_id);
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
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p618,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p613p618,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p619p622,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p619p622,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p623p625,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p623p625,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p626p629,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p626p629,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p630,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p630,"1",_id);
        data.close();
    }
    public void ocultarCapitulo7(){
        Data data = new Data(this);
        data.open();
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p701p705,"-1",_id);
        data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p706p709,"-1",_id);
        data.close();
    }
    public void mostrarCapitulo7(){
        Data data = new Data(this);
        data.open();
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p701p705,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p701p705,"1",_id);
        if(data.getValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p706p709,_id).equals("-1"))
            data.actualizarValor(SQLConstantes.tablafragments,SQLConstantes.fragments_p706p709,"1",_id);
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
        data.close();
    }
}
