package com.example.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

public class EditarNotas extends AppCompatActivity {

    private ImageButton guardar;
    private EditText editable;
    private List<String> listaNotas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_notas);

        guardar = findViewById(R.id.guardar);
        editable = findViewById(R.id.editable);
        listaNotas = Notas.getListaNotas();

    }
}