package com.example.projetopdmii;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Tela03 extends AppCompatActivity implements View.OnClickListener {
    private ViewPager2 viewPager;
    private ArrayList<Slide> lista;
    private TextView textoTitulo, textoScroll;
    private ImageButton iconeMusica;
    private Button buttonVoltar;
    private MediaPlayer mediaPlayer;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.linearlayout3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);
        textoTitulo = findViewById(R.id.textView5);
        textoScroll = findViewById(R.id.textView6);
        iconeMusica = findViewById(R.id.imageButton);
        buttonVoltar = findViewById(R.id.button3);

        iconeMusica.setOnClickListener(this);
        buttonVoltar.setOnClickListener(this);

        textoTitulo.setText("Carros Esportivos");
        iconeMusica.setImageResource(R.drawable.music_note_48px);

        lista = new ArrayList<Slide>();
        lista.add(new Slide("Maserati MC20", R.drawable.maserati_mc20, "O mais belíssimo esportivo noturno da Maserati."));
        lista.add(new Slide("BMW M4", R.drawable.bmw_m4, "O clássico da BMW. Preta como a noite."));
        lista.add(new Slide("Ferrari 812", R.drawable.ferrari_812, "Seus motores são como música."));
        lista.add(new Slide("Audi RS5", R.drawable.audi_rs5, "Auge da tecnologia alemã."));
        lista.add(new Slide("Nissan 350Z", R.drawable.nissan_350z, "Clássico japonês do NFSU2."));

        SlideAdapter adapter = new SlideAdapter(lista, textoScroll);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                textoScroll.setText(lista.get(position).getTexto());
            }
        });

        viewPager.setAdapter(adapter);

        drawerLayout = findViewById(R.id.iddrawer3);
        navigationView = findViewById(R.id.navigationview3);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.idhome) {
                    drawerLayout.closeDrawers();
                    return false;

                }

                if(menuItem.getItemId() == R.id.idtela02) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela03.this, Tela02.class));

                }

                if(menuItem.getItemId() == R.id.idtela03) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela03.this, Tela03.class));

                }

                return false;
            }
        });




    }

    @Override
    public void onClick(View view) {
        if(view == iconeMusica) {
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.devileyes);
                mediaPlayer.start();
                iconeMusica.setImageResource(R.drawable.music_off_48px);
            }

            else if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                iconeMusica.setImageResource(R.drawable.music_note_48px);
            }
        }

        if(view == buttonVoltar) {
            finish();
        }

    }

}