package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.imputEmail.getText().toString();
                String name = binding.inputUserName.getText().toString();
                String password = binding.inputPassword.getText().toString();
                String confirmPassword = binding.inputConfirmPassword.getText().toString();

                if (email.equals("") || name.equals("") || password.equals("") || confirmPassword.equals(""))
                    Toast.makeText(RegisterActivity.this, "Todos los campos son obligatorios",Toast.LENGTH_LONG).show();
                else {
                    if (password.equals(confirmPassword)){
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail == false){
                            Boolean insert = databaseHelper.insertData(email, name, password);

                            if (insert == true){
                                Toast.makeText(RegisterActivity.this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registro falló", Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Toast.makeText(RegisterActivity.this, "Usuario ya existe, por favor ingresar", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "Contraseña Inválida", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        binding.loguinRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

