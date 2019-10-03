package com.example.revisao.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.revisao.R;
import com.example.revisao.views.model.Musica;

import static com.example.revisao.views.fragment.ListaMusicasFragment.MUSICA_KEY;

public class DetalheMusica extends AppCompatActivity {
    private ImageView imgMusica;
    private TextView nomeMusica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_musica);
        initViews();

        if(getIntent() != null && getIntent().getExtras() != null){
            Musica musica = getIntent().getExtras().getParcelable(MUSICA_KEY);

            Drawable drawable = getResources().getDrawable(musica.getImagemMusica());
            imgMusica.setImageDrawable(drawable);
            nomeMusica.setText(musica.getNomeMusica());
        }

    }

    public void initViews(){
        imgMusica = findViewById(R.id.imgMusica);
        nomeMusica = findViewById(R.id.nomeMusica);
    }
}
