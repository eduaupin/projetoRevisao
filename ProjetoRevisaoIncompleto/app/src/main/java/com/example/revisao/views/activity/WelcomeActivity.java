package com.example.revisao.views.activity;

import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.revisao.R;
import com.google.android.material.navigation.NavigationView;

import static com.example.revisao.views.activity.StartActivity.NOME_KEY;

public class WelcomeActivity extends AppCompatActivity {
    private TextView txtBoasVindas;
    private Button btnComecar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



        initViews();

        //Implementar a lógica de recebimento de dados e setar o nome no textView
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nome = bundle.getString(NOME_KEY);

        txtBoasVindas.setText("Seja bem-vindo " + nome + "! Esse é um app de revisão!");

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
            }
        });


    }

    private void initViews() {
        txtBoasVindas = findViewById(R.id.textViewBemVindo);
        btnComecar = findViewById(R.id.btnComecar);
    }
}
