package com.acharcitox.panaderiabit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PanificadoViewHolder extends RecyclerView.ViewHolder {
    private final TextView panificadoItemView;

    private PanificadoViewHolder(View itemView) {
        super(itemView);
        panificadoItemView = itemView.findViewById(R.id.textViewNombre);
    }

    public void bind(String texto) {
        panificadoItemView.setText(texto);
    }

    static PanificadoViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.panificado_item, parent, false);
        return new PanificadoViewHolder(view);
    }
}
