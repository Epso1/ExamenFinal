package com.example.examenfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ItemDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM = "com.example.item_prueba.item";

    public static Intent newIntent(Context packageContext, Item item) {
        Intent intent = new Intent(packageContext, ItemDetailsActivity.class);
        intent.putExtra(EXTRA_ITEM, item);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        Item item = (Item) getIntent().getSerializableExtra(EXTRA_ITEM);

        TextView itemNameTextView = findViewById(R.id.itemNameTextView);
        TextView itemCostTextView = findViewById(R.id.itemCostTextView);
        TextView itemCategoryTextView = findViewById(R.id.itemCategoryTextView);
        TextView itemEffectTextView = findViewById(R.id.itemEffectTextView);
        ImageView itemImageView = findViewById(R.id.itemImageView);

        itemNameTextView.setText(item.getName());
        itemCostTextView.setText(String.valueOf(item.getCost()));
        itemCategoryTextView.setText(item.getCategory());
        itemEffectTextView.setText(item.getEfecto());

        // Use Glide to load the image from the URL into the ImageView
        Glide.with(this)
                .load(item.getImageUrl())
                .into(itemImageView);
    }
}