package com.example.coffee_shop;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static List<DataModel> getData() {
        List<DataModel> data = new ArrayList<>();
        data.add(new DataModel(R.drawable.images1, "Antico Caffè Greco", "St. Italy, Rome", 0.0f));
        data.add(new DataModel(R.drawable.images2, "Coffee Room", "St. Germany, Berlin", 0.0f));
        data.add(new DataModel(R.drawable.images3, "Coffee Ibiza", "St. Colon, Madrid", 0.0f));
        data.add(new DataModel(R.drawable.images4, "Pudding Coffee Shop", "St. Diagonal, Barcelona", 0.0f));
        data.add(new DataModel(R.drawable.images5, "LExpress", "St. Picadilly Circus, London", 0.0f));
        data.add(new DataModel(R.drawable.images6, "Coffee Corner", "St. Àngel Guimerà, Valencia", 0.0f));
        return data;
    }
}
