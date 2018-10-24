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
import com.example.ricindigus.empove2018.modelo.pojos.VisitaEncuestador;

import java.util.ArrayList;


public class VisitaEncuestadorAdapter extends RecyclerView.Adapter<VisitaEncuestadorAdapter.ViewHolder>{
    ArrayList<VisitaEncuestador> visitaEncuestadors;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public VisitaEncuestadorAdapter(ArrayList<VisitaEncuestador> visitaEncuestadors, OnItemClickListener onItemClickListener) {
        this.visitaEncuestadors = visitaEncuestadors;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.visita_encuestador_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(visitaEncuestadors.get(position).getNumero());
        holder.txtFecha.setText(
                visitaEncuestadors.get(position).getVis_fecha_dd() + "/" +
                        visitaEncuestadors.get(position).getVis_fecha_mm()+ "/" +
                        visitaEncuestadors.get(position).getVis_fecha_aa());
        holder.txtHoraInicio.setText(
                visitaEncuestadors.get(position).getVis_hor_ini() +":"+ visitaEncuestadors.get(position).getVis_min_ini() );
        holder.txtFechaProximo.setText(visitaEncuestadors.get(position).getProx_vis_fecha_dd() + "/" +
                visitaEncuestadors.get(position).getProx_vis_fecha_mm()+ "/" +
                visitaEncuestadors.get(position).getProx_vis_fecha_aa());
        holder.txtHoraInicio.setText(
                visitaEncuestadors.get(position).getProx_vis_hor() +":"+ visitaEncuestadors.get(position).getProx_vis_min() );
        holder.txtResultado.setText(visitaEncuestadors.get(position).getVis_resu());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return visitaEncuestadors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumero;
        TextView txtFecha;
        TextView txtHoraInicio;
        TextView txtHoraFinal;
        TextView txtFechaProximo;
        TextView txtHoraProximo;
        TextView txtResultado;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.item_visita_encuestador_cardview);
            txtNumero = itemView.findViewById(R.id.item_visita_encuestador_numero);
            txtFecha = itemView.findViewById(R.id.item_visita_encuestador_fecha);
            txtHoraInicio = itemView.findViewById(R.id.item_visita_encuestador_hora_inicio);
            txtHoraFinal = itemView.findViewById(R.id.item_visita_encuestador_hora_final);
            txtFechaProximo = itemView.findViewById(R.id.item_visita_encuestador_prox_fecha);
            txtHoraProximo = itemView.findViewById(R.id.item_visita_encuestador_prox_hora);
            txtResultado = itemView.findViewById(R.id.item_visita_encuestador_resultado);
        }
    }
}

