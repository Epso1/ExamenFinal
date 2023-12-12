package com.example.examenfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaMovimientosFragment extends Fragment {

    private ArrayList<String> movimientos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_movimientos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de movimientos
        movimientos = new ArrayList<>();
        // Agrega datos a la lista de movimientos (aquí puedes agregar tus propios datos)
        movimientos.add("Movimiento 1");
        movimientos.add("Movimiento 2");
        movimientos.add("Movimiento 3");

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        MovimientosAdapter adapter = new MovimientosAdapter(movimientos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}