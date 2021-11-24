package com.example.appnotas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.ViewHolder> {
    private ArrayList<Object> notas;
    private TinyDB tinyDB;

    public NotasAdapter(ArrayList<Object>notas){
        this.notas = notas;
    }
    @NonNull
    @Override
    public NotasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.formanotas, parent, false);
        tinyDB = new TinyDB(parent.getContext());

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotasAdapter.ViewHolder holder, int position) {
        ConstructorNotas nota = (ConstructorNotas) notas.get(position);
        holder.tituloText.setText(nota.getTitulo());
        holder.notaText.setText(nota.getNota());
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloText,notaText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloText = itemView.findViewById(R.id.textView);
            notaText = itemView.findViewById(R.id.notaView);
        }
    }

}
