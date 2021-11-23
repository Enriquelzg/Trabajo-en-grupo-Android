package com.example.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.transformation.ExpandableBehavior;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ImageButton nuevaNota;
    private List<String> listaNotas = null;
    public String nota;
    private TextView texto,texto1,texto2,texto3,texto4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nuevaNota = findViewById(R.id.nueva);
        texto = findViewById(R.id.nota);
        listaNotas = Notas.getListaNotas();
        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);
        texto3 = findViewById(R.id.texto3);
        texto4 = findViewById(R.id.texto4);

        try {
            nota=listaNotas.get(0);
            texto.setText(nota);
            try {
                nota=listaNotas.get(1);
                texto1.setText(nota);
                try {
                    nota=listaNotas.get(2);
                    texto2.setText(nota);
                    try {
                        nota=listaNotas.get(3);
                        texto3.setText(nota);
                        try {
                            nota=listaNotas.get(4);
                            texto4.setText(nota);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
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