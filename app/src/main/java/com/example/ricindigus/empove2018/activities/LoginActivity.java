package com.example.ricindigus.empove2018.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.ricindigus.empove2018.R;

public class LoginActivity extends AppCompatActivity {
    private Button ingresarButton;
    private TextInputEditText usuarioEditText;
    private TextInputEditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ingresarButton = (Button) findViewById(R.id.login_button_ingresar);
        usuarioEditText = (TextInputEditText) findViewById(R.id.login_textInput_usuario);
        passwordEditText = (TextInputEditText) findViewById(R.id.login_textInput_password);


        ingresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, EncuestaActivity.class);
                startActivity(intent);
            }
        });
    }
}
