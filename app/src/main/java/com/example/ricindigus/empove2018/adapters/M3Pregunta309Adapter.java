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
import com.example.ricindigus.empove2018.modelo.pojos.M3Pregunta309;

import java.util.ArrayList;


public class M3Pregunta309Adapter extends RecyclerView.Adapter<M3Pregunta309Adapter.ViewHolder>{
    ArrayList<M3Pregunta309> m3Pregunta309s;

    public M3Pregunta309Adapter(ArrayList<M3Pregunta309> m3Pregunta309s) {
        this.m3Pregunta309s = m3Pregunta309s;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ruta_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtPais.setText(String.valueOf(m3Pregunta309s.get(position).getC3_p309_p()));
        holder.txtCiudad.setText(String.valueOf(m3Pregunta309s.get(position).getC3_p309_c()));
        holder.txtModoTransito.setText(String.valueOf(m3Pregunta309s.get(position).getC3_p309_mod()));
        holder.txtFecha.setText(String.valueOf(m3Pregunta309s.get(position).getC3_p309_m() + "/"
                +String.valueOf(m3Pregunta309s.get(position).getC3_p309_a())));
    }

    @Override
    public int getItemCount() {
        return m3Pregunta309s.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtPais;
        TextView txtCiudad;
        TextView txtModoTransito;
        TextView txtFecha;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.item_ruta_cardview);
            txtPais = itemView.findViewById(R.id.txtpais);
            txtCiudad = itemView.findViewById(R.id.txtciudad);
            txtModoTransito = itemView.findViewById(R.id.txtmodotransito);
            txtFecha = itemView.findViewById(R.id.txtfecha);
        }
    }
}

