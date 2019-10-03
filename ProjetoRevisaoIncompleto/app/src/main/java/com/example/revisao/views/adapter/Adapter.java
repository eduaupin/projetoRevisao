package com.example.revisao.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.R;
import com.example.revisao.views.interfaces.RecyclerViewOnClick;
import com.example.revisao.views.model.Musica;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Musica> listaMusica;
    private RecyclerViewOnClick listener;

    public Adapter(List<Musica> listaMusica, RecyclerViewOnClick listener) {
        this.listaMusica = listaMusica;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Musica musica = listaMusica.get(position);
        holder.bind(musica);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(musica);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaMusica.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeMusica;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeMusica = itemView.findViewById(R.id.nomeMusica);

        }
        public void bind(Musica musica){
            nomeMusica.setText(musica.getNomeMusica());
        }
    }
}
