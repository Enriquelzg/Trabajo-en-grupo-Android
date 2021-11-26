package com.example.appnotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ImageButton nuevaNota;
    private List<Object> listaNotas = null;
    public String nota;
    private TinyDB tinyDB;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tinyDB = new TinyDB(this);
        nuevaNota = findViewById(R.id.nueva);
        listaNotas = Notas.getListaNotas();
        recycler = (RecyclerView) findViewById(R.id.reciclarnotas);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recycler.setAdapter(NotasAdapter);

        nuevaNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Notas.class));
            }
        });

    }
}