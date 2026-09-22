package com.example.projetopdmii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaInicial extends AppCompatActivity implements View.OnClickListener {
    private Button botaoTelaMusica, botaoTelaSlides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_inicial);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botaoTelaMusica = findViewById(R.id.button2);
        botaoTelaSlides = findViewById(R.id.button);

        botaoTelaMusica.setOnClickListener(this);
        botaoTelaSlides.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == botaoTelaMusica) {
            startActivity(new Intent(this, Tela02.class));
        }

        if(view == botaoTelaSlides) {
            startActivity(new Intent(this, Tela03.class));
        }

    }
}