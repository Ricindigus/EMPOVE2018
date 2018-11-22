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
        holder.txtNumero.setText(residentes.get(position).getNumero());
        holder.txtNombre.setText(residentes.get(position).getC2_p202());

        holder.txtParentesco.setText(context.getResources().getStringArray(R.array.modulo_2_p203_parentescos)[Integer.parseInt(residentes.get(position).getC2_p203())]);

//        holder.txtSexo.setText(String.valueOf(residentes.get(position).getC2_p204()));
        if(!residentes.get(position).getC2_p204().equals(""))
            holder.txtSexo.setText(context.getResources().getStringArray(R.array.modulo_2_p204_sexo)[Integer.parseInt(residentes.get(position).getC2_p204())]);
        else holder.txtSexo.setText("");

        if(residentes.get(position).getC2_p205_a().equals("") && residentes.get(position).getC2_p205_m().equals("")){
            holder.txtEdad.setText("");
        }else{
            if(!residentes.get(position).getC2_p205_a().equals(""))
                holder.txtEdad.setText(String.valueOf(residentes.get(position).getC2_p205_a()) + " Años");
            else
                holder.txtEdad.setText(String.valueOf(residentes.get(position).getC2_p205_m()) + " Meses");
        }

        if(!residentes.get(position).getC2_p206().equals(""))
            holder.txtEstadoCivil.setText(context.getResources().getStringArray(R.array.modulo_2_p206_estado_civil)[Integer.parseInt(residentes.get(position).getC2_p206())]);
        else holder.txtEstadoCivil.setText("");

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });

        if(residentes.get(position).getC2_p207().equals("1")) holder.txtLlegoVenezuela.setText("SI");
        else if (residentes.get(position).getC2_p207().equals("2"))holder.txtLlegoVenezuela.setText("NO");

        if(residentes.get(position).getEncuestado_cobertura().equals("0"))
            holder.txtCobertura.setText("NO");
        else if (residentes.get(position).getEncuestado_cobertura().equals("1"))
            holder.txtCobertura.setText("SI");

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
        TextView txtLlegoVenezuela;
        TextView txtCobertura;
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
            txtLlegoVenezuela = itemView.findViewById(R.id.item_residente_llego_venezuela);
            txtCobertura = itemView.findViewById(R.id.item_residente_cobertura);
        }
    }
}

