package com.example.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private TextView prueba;

    private Button boton1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prueba = findViewById(R.id.textoprueba);
        boton1 =findViewById(R.id.boton_prueba);


    }
}