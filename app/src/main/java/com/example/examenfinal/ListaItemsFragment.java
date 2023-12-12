package com.example.examenfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaItemsFragment extends Fragment {

    private ArrayList<String> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_items, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de items
        items = new ArrayList<>();
        // Agrega datos a la lista de items (aquí puedes agregar tus propios datos)
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        ItemsAdapter adapter = new ItemsAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}