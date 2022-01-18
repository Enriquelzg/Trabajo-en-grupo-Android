package com.example.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class Notas extends AppCompatActivity {

    private ImageButton guardar;
    private EditText editable,title;
    private TinyDB tinyDB;
    private static ArrayList<Object> listaNotas = new ArrayList<Object>();

    public static ArrayList<Object> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList<Object> listaNotas) {
        this.listaNotas = listaNotas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        guardar = findViewById(R.id.guardar);
        editable = findViewById(R.id.editable);
        title = findViewById(R.id.titulo);
        tinyDB = new TinyDB(this);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = title.getText().toString();
                String nota = editable.getText().toString();
                ConstructorNotas nota1 = new ConstructorNotas(titulo,nota);
                listaNotas.add(nota1);
                tinyDB.putListObject("notasdata3",listaNotas);
                startActivity(new Intent(Notas.this, MainActivity.class));
            }
        });

    }

}