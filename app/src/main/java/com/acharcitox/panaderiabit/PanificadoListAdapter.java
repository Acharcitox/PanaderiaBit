package com.acharcitox.panaderiabit;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.acharcitox.panaderiabit.entities.Panificado;

import java.util.List;

public class PanificadoListAdapter extends ListAdapter<Panificado, PanificadoViewHolder> {

    public PanificadoListAdapter(@NonNull DiffUtil.ItemCallback<Panificado> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PanificadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PanificadoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PanificadoViewHolder holder, int position) {
        Panificado panificadoActual = getItem(position);
        holder.bind(panificadoActual.getNombre());
    }

    static class PanificadoDiff extends DiffUtil.ItemCallback<Panificado> {
        @Override
        public boolean areItemsTheSame(@NonNull Panificado oldItem, @NonNull Panificado newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Panificado oldItem, @NonNull Panificado newItem) {
            return oldItem.getNombre().equals(newItem.getNombre());
        }
    }
}
