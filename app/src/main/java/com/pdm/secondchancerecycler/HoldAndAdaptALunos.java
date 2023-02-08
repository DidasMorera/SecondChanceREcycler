package com.pdm.secondchancerecycler;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HoldAndAdaptALunos extends RecyclerView.Adapter<HoldAndAdaptALunos.ViewHolder> {

    ArrayList<Aluno> alunoList = MainActivity.alunoList;
    Context context;

    public HoldAndAdaptALunos(ArrayList<Aluno> alunoList, Context context) {
        this.alunoList = alunoList;
        this.context = context;
    }

    @NonNull
    @Override
    public HoldAndAdaptALunos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_aluno,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoldAndAdaptALunos.ViewHolder holder, int position) {
        holder.nomeAlun.setText(alunoList.get(position).getNome());
        holder.teleAlu.setText(alunoList.get(position).getTelefone());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alunoList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), alunoList.size());
            }
        });




    }

    @Override
    public int getItemCount() {
        return alunoList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nomeAlun;
        TextView teleAlu;
        ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeAlun = itemView.findViewById(R.id.tv_nomeAl);
            teleAlu = itemView.findViewById(R.id.tv_telefone);
            delete = itemView.findViewById(R.id.deletarr);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positio = getAdapterPosition();

                    Snackbar.make(v, "Clicou no card"+(positio+1), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    visualizar();


                }
                public void visualizar(){


                    int position = getAdapterPosition();
                    Intent intent = new Intent(itemView.getContext(), Resultados.class);

                    intent.putExtra("nome", alunoList.get(position).getNome());
                    intent.putExtra("telefone", alunoList.get(position).getTelefone());
                    intent.putExtra("morada", alunoList.get(position).getMorada());
                    intent.putExtra("idade", alunoList.get(position).getIdade());
                    intent.putExtra("sexo", alunoList.get(position).getSexo());


                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }

}
