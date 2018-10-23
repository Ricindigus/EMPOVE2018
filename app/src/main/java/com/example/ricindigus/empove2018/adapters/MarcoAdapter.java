package com.example.ricindigus.empove2018.adapters;

/**
 * Created by otin016 on 27/06/2017.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ricindigus.empove2018.modelo.pojos.ItemMarco;

import java.util.ArrayList;
import com.example.ricindigus.empove2018.R;



public class MarcoAdapter extends RecyclerView.Adapter<MarcoAdapter.ViewHolder>{
    ArrayList<ItemMarco> itemMarcos;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public MarcoAdapter(ArrayList<ItemMarco> itemMarcos, OnItemClickListener onItemClickListener) {
        this.itemMarcos = itemMarcos;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marco_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtId.setText(String.valueOf(itemMarcos.get(position).get_id()));
        holder.txtAnio.setText(String.valueOf(itemMarcos.get(position).getAnio()));
        holder.txtMes.setText(String.valueOf(itemMarcos.get(position).getMes()));
        holder.txtPeriodo.setText(String.valueOf(itemMarcos.get(position).getPeriodo()));
        holder.txtConglomerado.setText(String.valueOf(itemMarcos.get(position).getConglomerado()));
        holder.txtNroOrden.setText(String.valueOf(itemMarcos.get(position).getNorden()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemMarcos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView txtId;
        TextView txtAnio;
        TextView txtMes;
        TextView txtPeriodo;
        TextView txtConglomerado;
        TextView txtNroOrden;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.marco_item_cardview);
            txtId = itemView.findViewById(R.id.marco_item_txtId);
            txtAnio = itemView.findViewById(R.id.marco_item_txtAnio);
            txtMes = itemView.findViewById(R.id.marco_item_txtMes);
            txtPeriodo = itemView.findViewById(R.id.marco_item_txtPeriodo);
            txtConglomerado = itemView.findViewById(R.id.marco_item_txtConglomerado);
            txtNroOrden = itemView.findViewById(R.id.marco_item_txtNroOrden);

        }
    }
}

