package com.example.projetopdmii;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Tela03 extends AppCompatActivity {
    private ViewPager2 viewPager;
    private ArrayList<Slide> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager = findViewById(R.id.viewpager);

        lista = new ArrayList<Slide>();
        lista.add(new Slide("Maserati MC20", R.drawable.maserati_mc20, "O mais belíssimo esportivo noturno da Maserati."));
        lista.add(new Slide("BMW M4", R.drawable.bmw_m4, "O clássico da BMW. Preta como a noite."));
        lista.add(new Slide("Ferrari 812", R.drawable.ferrari_812, "Seus motores são como música."));
        SlideAdapter adapter = new SlideAdapter(lista);
        viewPager.setAdapter(adapter);




    }




}