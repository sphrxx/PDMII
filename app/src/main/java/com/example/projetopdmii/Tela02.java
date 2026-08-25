package com.example.projetopdmii;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Tela02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener, Runnable, View.OnClickListener {

    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Handler handler;
    private int musica, indiceLista;
    private ArrayList<Playlist> lista;
    private CardView card1, card2, card3, card4, card5;
    private TextView textoMusicaSeleciona, textoMusicaTocando;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Concede o poder de Actionbar à Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Habilita o botão de "Voltar"
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        handler = new Handler();

        musica = R.raw.forrodofarol_quincasmoreira;

        lista = new ArrayList<Playlist>();
        lista.add(new Playlist("GUARDIAN  - DELTARUNE", R.raw.guardian_deltarune));
        lista.add(new Playlist("MEGALOVANIA - UNDERTALE", R.raw.megalovania));
        lista.add(new Playlist("Eleventh Hour - ONESHOT", R.raw.eleventhhour_oneshot));
        lista.add(new Playlist("Zelda's Lullaby - Legend of Zelda", R.raw.zeldalullaby));
        lista.add(new Playlist("Devil Eyes - Hippie Sabottage", R.raw.devileyes));

        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 = findViewById(R.id.card2);
        card2.setOnClickListener(this);
        card3 = findViewById(R.id.card3);
        card3.setOnClickListener(this);
        card4 = findViewById(R.id.card4);
        card4.setOnClickListener(this);
        card5 = findViewById(R.id.card5);
        card5.setOnClickListener(this);
        textoMusicaSeleciona = findViewById(R.id.textView);
        textoMusicaTocando = findViewById(R.id.textView2);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            finish();
        }

        if(id == R.id.id001) {
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, musica);
                textoMusicaTocando.setText("Música tocando: " + lista.get(indiceLista).getNome());
                mediaPlayer.setOnCompletionListener(this);
                seekBar.setMax(mediaPlayer.getDuration());
                handler.post(this);
                mediaPlayer.start();
            }
            else if(!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        }

        if(id == R.id.id003) {
            if(mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }

        if(id == R.id.id002) {
            if(mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        }


        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        mediaPlayer = null;
        seekBar.setProgress(0);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(mediaPlayer != null) {
            mediaPlayer.seekTo(seekBar.getProgress());
        }



    }

    @Override
    public void run() {
        if(mediaPlayer != null) {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this, 1000);
        }

    }

    @Override
    public void onClick(View view) {

        if(view == card1) {
            indiceLista = 0;
            textoMusicaSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }

        if(view == card2) {
            indiceLista = 1;
            textoMusicaSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }

        if(view == card3) {
            indiceLista = 2;
            textoMusicaSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }

        if(view == card4) {
            indiceLista = 3;
            textoMusicaSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }

        if(view == card5) {
            indiceLista = 4;
            textoMusicaSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }



    }
}