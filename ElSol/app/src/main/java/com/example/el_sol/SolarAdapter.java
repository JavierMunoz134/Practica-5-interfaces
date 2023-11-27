package com.example.el_sol;

// SolarAdapter.java

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class SolarAdapter extends RecyclerView.Adapter<SolarAdapter.SolarViewHolder> {
    private List<SolarItem> solarItemList;

    public SolarAdapter(List<SolarItem> solarItemList) {
        this.solarItemList = solarItemList;
    }

    @NonNull
    @Override
    public SolarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solar, parent, false);
        return new SolarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SolarViewHolder holder, int position) {
        SolarItem solarItem = solarItemList.get(position);

        holder.imageViewSolar.setImageResource(solarItem.getImageResource());
        holder.toolbarSolar.setTitle(solarItem.getName());
        holder.toolbarSolar.inflateMenu(R.menu.menu);

        holder.toolbarSolar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.action_copy) {
                copyItem(position);
                return true;
            } else if (id == R.id.action_delete) {
                deleteItem(position);
                return true;
            } else {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return solarItemList.size();
    }

    public static class SolarViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewSolar;
        Toolbar toolbarSolar;

        public SolarViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewSolar = itemView.findViewById(R.id.imageViewSolar);
            toolbarSolar = itemView.findViewById(R.id.toolbarSolar);
        }
    }

    void copyItem(int position) {
        // Lógica para la opción Copiar
        SolarItem copiedItem = solarItemList.get(position);
        solarItemList.add(position + 1, new SolarItem(copiedItem.getName() + " (Copia)", copiedItem.getImageResource()));
        notifyItemInserted(position + 1);
    }

    void deleteItem(int position) {
        // Lógica para la opción Eliminar
        solarItemList.remove(position);
        notifyItemRemoved(position);
    }
}
