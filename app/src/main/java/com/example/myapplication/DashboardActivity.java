package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        userName = findViewById(R.id.textUser);
        Bundle bundle = getIntent().getExtras();
        userName.setText(bundle.getString("user"));




    }
}