package com.example.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ImageButton nuevaNota;
    private List<EditText> listaNotas;
    public EditText nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nuevaNota = findViewById(R.id.nueva);
        nota = findViewById(R.id.nota);
        listaNotas = Notas.getListaNotas();

        nota=listaNotas.get(0);

        nuevaNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Notas.class));
            }
        });
    }
}