package com.example.ricindigus.empove2018.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.Data;
import com.example.ricindigus.empove2018.modelo.pojos.Usuario;

public class LoginActivity extends AppCompatActivity {
    private Button ingresarButton;
    private TextInputEditText usuarioEditText;
    private TextInputEditText passwordEditText;
    String nombreUsuario;

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
                Intent intent = new Intent(LoginActivity.this, MarcoActivity.class);
                nombreUsuario = usuarioEditText.getText().toString();
                Data data =  new Data(LoginActivity.this);
                data.open();
                Usuario user = data.getUsuario(nombreUsuario);
                data.close();
                intent.putExtra("idUsuario",user.get_id());
                startActivity(intent);
            }
        });
    }
}
