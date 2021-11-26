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

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ImageButton nuevaNota;
    private ArrayList<Object> listaNotas = null;
    public String nota;
    private TinyDB tinyDB;
    private RecyclerView recycler;
    private NotasAdapter notasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tinyDB = new TinyDB(this);
        try {
            listaNotas = tinyDB.getListObject("notasdata", Object.class);
            nuevaNota = findViewById(R.id.nueva);
            notasAdapter = new NotasAdapter(listaNotas);
            recycler = (RecyclerView) findViewById(R.id.reciclarnotas);
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setAdapter(notasAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }

        nuevaNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Notas.class));
            }
        });
    }

}