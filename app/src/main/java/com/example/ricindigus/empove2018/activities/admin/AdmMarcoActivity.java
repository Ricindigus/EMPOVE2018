package com.example.ricindigus.empove2018.activities.admin;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.activities.SplashActivity;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.SQLConstantes;
import com.example.ricindigus.empove2018.modelo.pojos.Marco;
import com.example.ricindigus.empove2018.util.MarcoPullParser;


public class AdmMarcoActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView txtMensaje;
    String filename = "";
    int tipoCarga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_marco);
        progressBar = (ProgressBar) findViewById(R.id.progreso_admin);
        txtMensaje = (TextView) findViewById(R.id.mensaje_admin);
        filename = getIntent().getExtras().getString("filename");
        tipoCarga = getIntent().getExtras().getInt("tipo_carga");

        if (tipoCarga == 1)
            new MyAsyncTaskCargarMarco().execute();
        else
            new MyAsyncTaskExportarBD().execute();

    }

    public void exportarBD()throws IOException {
        String inFileName = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        InputStream myInput = new FileInputStream(inFileName);
        String outFileName = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/bdENPOVE2018.sqlite";
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) != -1){
            if (length > 0){
                myOutput.write(buffer,0,length);
            }
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();
    }

//    public class MyAsyncTaskCargarMarco extends AsyncTask<Integer,Integer,String> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            progressBar.setVisibility(View.VISIBLE);
//            txtMensaje.setText("CARGANDO MARCO...");
//        }
//
//        @Override
//        protected String doInBackground(Integer... integers) {
//            try {
//                Data data = new Data(AdmMarcoActivity.this,filename);
//                data.open();
//                data.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return "LISTO";
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected void onPostExecute(String mensaje) {
//            super.onPostExecute(mensaje);
//            txtMensaje.setText(mensaje);
//            progressBar.setVisibility(View.GONE);
//            TimerTask timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(AdmMarcoActivity.this, SplashActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            };
//            Timer timer = new Timer();
//            timer.schedule(timerTask, 1000);
//        }
//    }
        public class MyAsyncTaskCargarMarco extends AsyncTask<Integer,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            txtMensaje.setText("CARGANDO MARCO...");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            Data data = new Data(AdmMarcoActivity.this);
            data.open();
            MarcoPullParser marcoPullParser = new MarcoPullParser();
            ArrayList<Marco> marcos = marcoPullParser.parseXML(AdmMarcoActivity.this,filename);
            for(Marco marco:marcos){
                if (!data.existeElemento(SQLConstantes.tablamarco,marco.get_id()+"")){
                    data.insertarElemento(SQLConstantes.tablamarco,marco.toValues());
                }

            }
            data.close();
            return "LISTO";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);
            txtMensaje.setText(mensaje);
            progressBar.setVisibility(View.GONE);
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(AdmMarcoActivity.this, SplashActivity.class);
                    startActivity(intent);
                    finish();
                }
            };
            Timer timer = new Timer();
            timer.schedule(timerTask, 1000);
        }
    }

    public class MyAsyncTaskExportarBD extends AsyncTask<Integer,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            txtMensaje.setText("EXPORTANDO BD...");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            try {
                exportarBD();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "LISTO";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);
            txtMensaje.setText(mensaje);
            progressBar.setVisibility(View.GONE);
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            };
            Timer timer = new Timer();
            timer.schedule(timerTask, 1000);
        }
    }
}
