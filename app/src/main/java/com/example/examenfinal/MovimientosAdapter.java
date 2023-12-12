package com.example.examenfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovimientosAdapter extends RecyclerView.Adapter<MovimientosAdapter.ViewHolder> {

    private ArrayList<String> movimientos;

    public MovimientosAdapter(ArrayList<String> movimientos) {
        this.movimientos = movimientos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movimiento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String movimiento = movimientos.get(position);
        holder.movimientoTextView.setText(movimiento);
    }

    @Override
    public int getItemCount() {
        return movimientos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView movimientoTextView;

        public ViewHolder(View view) {
            super(view);
            movimientoTextView = view.findViewById(R.id.movimientoTextView);
        }
    }
}