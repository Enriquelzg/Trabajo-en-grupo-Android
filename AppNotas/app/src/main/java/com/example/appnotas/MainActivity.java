package com.example.appnotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ImageButton nuevaNota, actualizar;
    private static ArrayList<Object> listaNotas = new ArrayList<>();
    public String nota;
   // private TinyDB tinyDB;
    private RecyclerView recycler;
    private NotasAdapter notasAdapter;
    private FirebaseAuth mAuth;
    private FirebaseDatabase myDB = FirebaseDatabase.getInstance("https://appnotas-c6dc9-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference mDataRef = myDB.getReference();
    private LeerEscribir database;

    /*public static void setListaNotas(ArrayList<Object> listNotas) {
        listaNotas = listNotas;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tinyDB = new TinyDB(this);
        database = new LeerEscribir(mDataRef);
        nuevaNota = findViewById(R.id.nueva);
        actualizar = findViewById(R.id.recargar);

        nuevaNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Notas.class));
                Notas.setListaNotas(listaNotas);
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listaNotas = database.getlista3(mDataRef, listaNotas);
                }catch (NullPointerException e){

                }

                nuevaNota = findViewById(R.id.nueva);
                notasAdapter = new NotasAdapter(listaNotas);
                recycler = (RecyclerView) findViewById(R.id.reciclarnotas);
                recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                recycler.setAdapter(notasAdapter);
            }
        });
    }

}