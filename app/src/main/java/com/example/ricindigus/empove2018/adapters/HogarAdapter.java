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

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;

import java.util.ArrayList;


public class HogarAdapter extends RecyclerView.Adapter<HogarAdapter.ViewHolder>{
    ArrayList<Hogar> hogars;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public HogarAdapter(ArrayList<Hogar> hogars, OnItemClickListener onItemClickListener) {
        this.hogars = hogars;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hogar_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(String.valueOf(hogars.get(position).getNumero()));
        holder.txtJefe.setText(String.valueOf(hogars.get(position).getNom_ape()));
        holder.txtEstado.setText(String.valueOf(hogars.get(position).getEstado()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hogars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumero;
        TextView txtJefe;
        TextView txtEstado;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.item_hogar_cardview);
            txtNumero = itemView.findViewById(R.id.item_hogar_textview_numero);
            txtJefe = itemView.findViewById(R.id.item_hogar_textview_jefe);
            txtEstado = itemView.findViewById(R.id.item_hogar_textview_estado);
        }
    }
}

