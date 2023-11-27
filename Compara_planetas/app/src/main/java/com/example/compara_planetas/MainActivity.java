package com.example.compara_planetas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

// MainActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView1, autoCompleteTextView2;
    private TextView diametro1, distancia1, densidad1, diametro2, distancia2, densidad2;
    private TableLayout tableLayout;

    private List<Planeta> listaPlanetas;
    private ArrayAdapter<Planeta> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la lista de planetas
        listaPlanetas = new ArrayList<>();
        listaPlanetas.add(new Planeta("Mercurio", 0.382, 0.387, 5400));
        listaPlanetas.add(new Planeta("Venus", 0.949, 0.723, 5250));
        // ... Añadir otros planetas

        // Inicializar el ArrayAdapter para AutoCompleteTextView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, listaPlanetas);

        // Inicializar vistas
        autoCompleteTextView1 = findViewById(R.id.autoCompleteTextView1);
        autoCompleteTextView2 = findViewById(R.id.autoCompleteTextView2);
        diametro1 = findViewById(R.id.diametro1);
        distancia1 = findViewById(R.id.distancia1);
        densidad1 = findViewById(R.id.densidad1);
        diametro2 = findViewById(R.id.diametro2);
        distancia2 = findViewById(R.id.distancia2);
        densidad2 = findViewById(R.id.densidad2);
        tableLayout = findViewById(R.id.tableLayout);

        // Configurar adaptadores para AutoCompleteTextView
        autoCompleteTextView1.setAdapter(adapter);
        autoCompleteTextView2.setAdapter(adapter);

        // Configurar onItemClick para AutoCompleteTextView1
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planeta planetaSeleccionado = (Planeta) autoCompleteTextView1.getAdapter().getItem(position);
                diametro1.setText(String.valueOf(planetaSeleccionado.getDiametro()));
                distancia1.setText(String.valueOf(planetaSeleccionado.getDistanciaAlSol()));
                densidad1.setText(String.valueOf(planetaSeleccionado.getDensidad()));
            }
        });

        // Configurar onItemClick para AutoCompleteTextView2
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planeta planetaSeleccionado = (Planeta) autoCompleteTextView2.getAdapter().getItem(position);
                diametro2.setText(String.valueOf(planetaSeleccionado.getDiametro()));
                distancia2.setText(String.valueOf(planetaSeleccionado.getDistanciaAlSol()));
                densidad2.setText(String.valueOf(planetaSeleccionado.getDensidad()));
            }
        });
    }
}
