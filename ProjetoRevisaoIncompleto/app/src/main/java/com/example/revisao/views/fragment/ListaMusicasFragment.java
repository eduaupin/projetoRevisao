package com.example.revisao.views.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.revisao.R;
import com.example.revisao.views.activity.DetalheMusica;
import com.example.revisao.views.adapter.Adapter;
import com.example.revisao.views.interfaces.RecyclerViewOnClick;
import com.example.revisao.views.model.Musica;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMusicasFragment extends Fragment implements RecyclerViewOnClick {
    //Declarar os atributos componentes e o adapter
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<Musica> listaMusicas = new ArrayList<>();
    public static final String MUSICA_KEY = "musica";

    public ListaMusicasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Implementar a lógica de setar o adapter e o LayoutManager para o componente do recyclerView

        //Criar a classe modelo

        //Criar a classe adapter e viewHolder e realizar toda a implementação lógica dos métodos

        //Implementar a ação de click na lista lista, para isso crie a interface para click
        // implemente no fragmento que contém o componente do recyclerView a interface
        // setar na classe adapter o atributo do tipo da interface de click
        // setar a ação de click no método onBindView da classe adapter como no seguinte exemplo:
        // holder.itemView.setOnClickListener e dentro dele chamar o método da interface a partir do
        // atributo do tipo da interface

        View view = inflater.inflate(R.layout.fragment_lista_musicas, container, false);

        recyclerView = view.findViewById(R.id.recyclerMusicas);
        adapter = new Adapter(popularMusicas(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    public List<Musica> popularMusicas(){
        listaMusicas.add(new Musica("Living on the edge", R.drawable.aero));
        listaMusicas.add(new Musica("Musica 2", R.drawable.aero));
        listaMusicas.add(new Musica("Musica 3", R.drawable.aero));
        listaMusicas.add(new Musica("Musica 4", R.drawable.aero));
        listaMusicas.add(new Musica("Musica 5", R.drawable.aero));

        return listaMusicas;
    }

    @Override
    public void onClick(Musica musica) {
        Intent intent = new Intent(getContext(), DetalheMusica.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(MUSICA_KEY, musica);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
