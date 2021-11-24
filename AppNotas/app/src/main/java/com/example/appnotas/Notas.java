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
    private static List<Object> listaNotas = new ArrayList<Object>();

    public static List<Object> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Object> listaNotas) {
        this.listaNotas = listaNotas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        guardar = findViewById(R.id.guardar);
        editable = findViewById(R.id.editable);
        title = findViewById(R.id.titulo);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Notas.this, MainActivity.class));
                String titulo = title.getText().toString();
                String nota = editable.getText().toString();
                ConstructorNotas nota1 = new ConstructorNotas(titulo,nota);
                listaNotas.add(nota1);
            }
        });

    }

}