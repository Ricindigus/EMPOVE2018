package com.example.ricindigus.empove2018.adapters;

/**
 * Created by otin016 on 27/06/2017.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ricindigus.empove2018.R;
import com.example.ricindigus.empove2018.modelo.pojos.Hogar;
import com.example.ricindigus.empove2018.modelo.pojos.Residente;

import java.util.ArrayList;


public class ResidenteAdapter extends RecyclerView.Adapter<ResidenteAdapter.ViewHolder>{
    ArrayList<Residente> residentes;
    OnItemClickListener onItemClickListener;
    Context context;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public ResidenteAdapter(ArrayList<Residente> residentes, Context context, OnItemClickListener onItemClickListener) {
        this.residentes = residentes;
        this.onItemClickListener = onItemClickListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.residente_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(String.valueOf(residentes.get(position).getNumero()));
        holder.txtNombre.setText(String.valueOf(residentes.get(position).getC2_p202()));

        holder.txtParentesco.setText(context.getResources().getStringArray(R.array.modulo_2_p203_parentescos)[Integer.parseInt(residentes.get(position).getC2_p203())]);

        holder.txtSexo.setText(String.valueOf(residentes.get(position).getC2_p204()));
        holder.txtSexo.setText(context.getResources().getStringArray(R.array.modulo_2_p204_sexo)[Integer.parseInt(residentes.get(position).getC2_p204())]);

        if(!residentes.get(position).getC2_p205_a().equals(""))
            holder.txtEdad.setText(String.valueOf(residentes.get(position).getC2_p205_a()) + " Años");
        else
            holder.txtEdad.setText(String.valueOf(residentes.get(position).getC2_p205_m()) + " Meses");
        holder.txtEstadoCivil.setText(context.getResources().getStringArray(R.array.modulo_2_p206_estado_civil)[Integer.parseInt(residentes.get(position).getC2_p206())]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return residentes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumero;
        TextView txtNombre;
        TextView txtParentesco;
        TextView txtSexo;
        TextView txtEdad;
        TextView txtEstadoCivil;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.item_residente_cardview);
            txtNumero = itemView.findViewById(R.id.item_residente_numero);
            txtNombre = itemView.findViewById(R.id.item_residente_nombre);
            txtParentesco = itemView.findViewById(R.id.item_residente_parentesco);
            txtSexo = itemView.findViewById(R.id.item_residente_sexo);
            txtEdad = itemView.findViewById(R.id.item_residente_edad);
            txtEstadoCivil = itemView.findViewById(R.id.item_residente_estado_civil);

        }
    }
}

