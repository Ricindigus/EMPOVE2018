package com.example.ricindigus.empove2018.activities.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.activities.LoginActivity;
import com.example.ricindigus.empove2018.util.FileChooser;

import java.io.File;

public class AdminActivity extends AppCompatActivity {

    Button btnCargarMarco;
    Button btnHorarioAsistencia;
    Button btnSalir;
    Button btnExportarBD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btnCargarMarco = (Button) findViewById(R.id.btnCargarMarco);
        btnExportarBD = (Button) findViewById(R.id.btnExportaBD);

        btnHorarioAsistencia = (Button) findViewById(R.id.btnHorarioAsistencia);
        btnSalir = (Button) findViewById(R.id.btnSalir);

//        btnCargarMarco.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FileChooser fileChooser = new FileChooser(AdminActivity.this);
//                fileChooser.setFileListener(new FileChooser.FileSelectedListener() {
//                    @Override
//                    public void fileSelected(File file) {
//                        String filename = file.getAbsolutePath();
//                        if(filename.substring(filename.length()-7,filename.length()).toLowerCase().equals(".sqlite")){
//                            Intent intent = new Intent(AdminActivity.this, AdmMarcoActivity.class);
//                            intent.putExtra("filename",filename);
//                            intent.putExtra("tipo_carga",1);
//                            startActivity(intent);
//                            finish();
//                        }else{
//                            Toast.makeText(AdminActivity.this, "archivo de tipo incorrecto", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                fileChooser.showDialog();
//
//            }
//        });

        btnCargarMarco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileChooser fileChooser = new FileChooser(AdminActivity.this);
                fileChooser.setFileListener(new FileChooser.FileSelectedListener() {
                    @Override
                    public void fileSelected(File file) {
                        String filename = file.getAbsolutePath();
                        if(filename.substring(filename.length()-4,filename.length()).toLowerCase().equals(".xml")){
                            Intent intent = new Intent(AdminActivity.this, AdmMarcoActivity.class);
                            intent.putExtra("filename",filename);
                            intent.putExtra("tipo_carga",1);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(AdminActivity.this, "archivo de tipo incorrecto", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                fileChooser.showDialog();

            }
        });

        btnExportarBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AdmMarcoActivity.class);
                intent.putExtra("tipo_carga",2);
                startActivity(intent);
            }
        });




        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }





}
