package com.example.examenfinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the ViewModel
        ItemViewModel itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        // Observe the LiveData
        itemViewModel.getItems().observe(this, items -> {
            // Update the UI
            itemAdapter = new ItemAdapter(items);
            recyclerView.setAdapter(itemAdapter);
        });

        // Load the items
        itemViewModel.loadItems();
    }
}
