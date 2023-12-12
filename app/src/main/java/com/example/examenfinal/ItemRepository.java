package com.example.examenfinal;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ItemRepository {

    private static final String API_URL = "https://pokeapi.co/api/v2/item";
    private final ExecutorService executorService;

    public ItemRepository() {
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void loadItems(final Callback callback) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                final List<Item> itemList = new ArrayList<>();
                try {
                    URL url = new URL(API_URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    reader.close();
                    connection.disconnect();

                    JSONObject jsonResponse = new JSONObject(response.toString());
                    JSONArray results = jsonResponse.getJSONArray("results");

                    for (int i = 0; i < results.length(); i++) {
                        JSONObject itemObject = results.getJSONObject(i);
                        String itemName = itemObject.getString("name");
                        String itemUrl = itemObject.getString("url");

                        // Fetch additional data from the item's URL
                        HttpURLConnection itemConnection = (HttpURLConnection) new URL(itemUrl).openConnection();
                        BufferedReader itemReader = new BufferedReader(new InputStreamReader(itemConnection.getInputStream()));
                        StringBuilder itemResponse = new StringBuilder();
                        String itemLine;

                        while ((itemLine = itemReader.readLine()) != null) {
                            itemResponse.append(itemLine);
                        }

                        itemReader.close();
                        itemConnection.disconnect();

                        JSONObject itemDetails = new JSONObject(itemResponse.toString());
                        int itemCost = itemDetails.getInt("cost");

                        // Obtain category details
                        JSONObject categoryObject = itemDetails.getJSONObject("category");
                        String categoryName = categoryObject.getString("name");

                        // Obtain effect details
                        JSONArray effectEntries = itemDetails.getJSONArray("effect_entries");
                        String itemEffect = "";
                        for (int j = 0; j < effectEntries.length(); j++) {
                            JSONObject effectEntry = effectEntries.getJSONObject(j);
                            JSONObject language = effectEntry.getJSONObject("language");
                            if (language.getString("name").equals("en")) {
                                // Check if "short_effect" field exists
                                if (effectEntry.has("short_effect")) {
                                    itemEffect = effectEntry.getString("short_effect");
                                } else {
                                    // Handle case where "short_effect" field does not exist
                                    itemEffect = "No short effect available";
                                }
                                break;
                            }
                        }

                        // Obtain image URL
                        JSONObject spritesObject = itemDetails.getJSONObject("sprites");
                        String imageUrl = spritesObject.getString("default");

                        // Create Item object and add it to the list
                        Item item = new Item(itemName, itemCost, categoryName, itemEffect, imageUrl);
                        itemList.add(item);
                    }

                    callback.onItemsLoaded(itemList);

                } catch (IOException | JSONException e) {
                    Log.e("ItemLoader", "Error fetching data: " + e.getMessage());
                }
            }
        });


    }

    public interface Callback {
        void onItemsLoaded(List<Item> items);
    }
}