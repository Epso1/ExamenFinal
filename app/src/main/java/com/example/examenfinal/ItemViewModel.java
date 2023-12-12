package com.example.examenfinal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ItemViewModel extends ViewModel {

    private final ItemRepository itemRepository;
    private final MutableLiveData<List<Item>> itemsLiveData = new MutableLiveData<>();

    public ItemViewModel() {
        this.itemRepository = new ItemRepository();
    }

    public LiveData<List<Item>> getItems() {
        return itemsLiveData;
    }

    public void loadItems() {
        itemRepository.loadItems(new ItemRepository.Callback() {
            @Override
            public void onItemsLoaded(List<Item> items) {
                itemsLiveData.postValue(items);
            }
        });
    }
}