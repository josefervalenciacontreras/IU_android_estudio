package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnRegister, btntxt_login;
    private EditText usuario, clave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.edUserName);
        clave = findViewById(R.id.edPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btntxt_login = findViewById(R.id.button2);

    }

    public void Registrar(View view){
        Toast.makeText(getApplicationContext(), "Abriendo registro de usuario...", Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    public void Ingresar(View view){
        String user = usuario.getText().toString();
        String pass = clave.getText().toString();
        if (user.equals("jose") && pass.equals("1234")){
            Toast.makeText(getApplicationContext(), "Datos correctos", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}