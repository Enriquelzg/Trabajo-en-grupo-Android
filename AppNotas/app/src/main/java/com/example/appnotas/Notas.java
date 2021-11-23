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
    private EditText editable;
    private static List<String> listaNotas = new ArrayList<String>();

    public static List<String> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<String> listaNotas) {
        this.listaNotas = listaNotas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        guardar = findViewById(R.id.guardar);
        editable = findViewById(R.id.editable);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Notas.this, MainActivity.class));
                String str = editable.getText().toString();
                listaNotas.add(str);
            }
        });

    }

}