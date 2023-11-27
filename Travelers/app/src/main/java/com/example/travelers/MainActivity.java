package com.example.travelers;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageSwitcher imageSwitcher;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        imageSwitcher = findViewById(R.id.imageSwitcher);

        List<Integer> imageList = new ArrayList<>();

        // Agrega tus recursos de imágenes
        for (int i = 1; i <= 10; i++) {
            imageList.add(getResources().getIdentifier("image" + i, "drawable", getPackageName()));
        }

        adapter = new ImageAdapter(imageList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Configura el ImageSwitcher
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        // Configura el listener del RecyclerView para manejar clics en las imágenes
        adapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Cambia la imagen en el ImageSwitcher al hacer clic en la imagen en el RecyclerView
                imageSwitcher.setImageResource(imageList.get(position));
            }
        });
    }
}
