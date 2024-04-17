package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
   ActivityMainBinding binding;
   DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.edUserName.getText().toString();
                String password = binding.edPassword.getText().toString();

                if (email.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "Todos los campos son requeridos", Toast.LENGTH_LONG).show();
                }else {

                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email,password);

                    if (checkCredentials == true ){
                        Toast.makeText(MainActivity.this, "Login Exitoso", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Datos Incorrectos", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }




}