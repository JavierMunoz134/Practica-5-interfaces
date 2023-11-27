package com.example.el_sol;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private SolarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<SolarItem> solarItemList = createDummyData();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewSolar);
        adapter = new SolarAdapter(solarItemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    private void copyItem() {
        // Llama al método del adaptador para copiar
        adapter.copyItem(0); // Puedes pasar el índice del elemento que deseas copiar
    }

    private void deleteItem() {
        // Llama al método del adaptador para eliminar
        adapter.deleteItem(0); // Puedes pasar el índice del elemento que deseas eliminar
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_copy) {
            // Lógica para la opción Copiar (puedes manejarla aquí o llamar a un método en el adaptador)
            copyItem();
            return true;
        } else if (id == R.id.action_delete) {
            // Lógica para la opción Eliminar (puedes manejarla aquí o llamar a un método en el adaptador)
            deleteItem();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private List<SolarItem> createDummyData() {
        List<SolarItem> solarItemList = new ArrayList<>();
        solarItemList.add(new SolarItem("Corona Solar", R.drawable.corona_solar));
        solarItemList.add(new SolarItem("Erupción Solar", R.drawable.erupcionsolar));
        solarItemList.add(new SolarItem("Espículas", R.drawable.espiculas));
        solarItemList.add(new SolarItem("Filamentos", R.drawable.filamentos));
        solarItemList.add(new SolarItem("Magnetosfera", R.drawable.magnetosfera));
        solarItemList.add(new SolarItem("Mancha Solar", R.drawable.manchasolar));
        return solarItemList;
    }


}
