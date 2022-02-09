package com.example.appnotas;

import android.media.metrics.Event;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.EventListener;

public class LeerEscribir {
    private static final String TAG = "ReadAndWriteSnippets";

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    public LeerEscribir(DatabaseReference database) {
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance("https://appnotas-c6dc9-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        // [END initialize_database_ref]
    }

    // [START rtdb_write_new_user]
    public void write(ArrayList<Object> listaNotas) {
        mDatabase.child("Notas").child("Notas").setValue(listaNotas);
    }

    public void borrar (){

    }

 /*   public ArrayList<Object> getlista(DatabaseReference mPostReference) {
        // [START post_value_event_listener]
        ArrayList<Object> listanotas = new ArrayList<Object>();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Notas notas = dataSnapshot.getValue(Notas.class);
                listanotas.add(notas);
                // ..
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        mPostReference.addValueEventListener(postListener);
        // [END post_value_event_listener]

        return listanotas;
    }

    public ArrayList<Object> getlista2(DatabaseReference mPostReference){
        ArrayList<Object> lista = new ArrayList<>();
        // [START post_value_event_listener]
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot data) {
                GenericTypeIndicator<ArrayList<Object>> t = new GenericTypeIndicator<ArrayList<Object>>() {
                };
                ArrayList<Object> lista = data.getValue(t);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mPostReference.addValueEventListener(postListener);
        return lista;
    }*/

    public ArrayList<Object> getlista3(DatabaseReference mPostReference,ArrayList<Object> list){
        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    String titulo = " ";
                    int num = list.size();
                    try {
                        while (titulo != null) {
                            titulo = snapshot.child("Notas").child("Notas").child(Integer.toString(num)).child("titulo").getValue().toString();
                            String texto = snapshot.child("Notas").child("Notas").child(Integer.toString(num)).child("nota").getValue().toString();
                            if (titulo != null) {
                                ConstructorNotas nota = new ConstructorNotas(titulo, texto);
                                list.add(nota);
                            }
                            ++num;
                        }
                    }catch (NullPointerException e){

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        };
        mPostReference.addValueEventListener(postListener);
        //ConstructorNotas nota = new ConstructorNotas("hey","mundo");
        //list.add(nota);
        return list;
    }

}

