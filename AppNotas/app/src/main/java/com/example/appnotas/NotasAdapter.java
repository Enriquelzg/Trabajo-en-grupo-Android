package com.example.appnotas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.ViewHolder> {
    ArrayList<Object> notas;

    public NotasAdapter(ArrayList<Object>notas){
        this.notas = notas;
    }
    @NonNull
    @Override
    public NotasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.formanotas, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotasAdapter.ViewHolder holder, int position) { ;
        holder.tituloText.setText(ConstructorNotas.getTitulo());
        holder.notaText.setText(ConstructorNotas.getNota());
    }

    @Override
    public int getItemCount() {
        return 0;
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
