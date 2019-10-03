package com.example.revisao.views;

import android.drm.DrmStore;
import android.os.Bundle;

import com.example.revisao.R;
import com.example.revisao.views.activity.HomeActivity;
import com.example.revisao.views.fragment.BandaFragment;
import com.example.revisao.views.fragment.ComidaFragment;
import com.example.revisao.views.fragment.ListaMusicasFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_nav);
        //Criar uma nova instancia do Toolbar e inicializar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Inicializar o drawer
        drawer = findViewById(R.id.drawer_layout);

        //Cria uma nova instância do NavigationView e inicializa
        NavigationView navigationView = findViewById(R.id.nav_view);

        //O ActionBarDraweToggle configura o icone para abrir e fechar
        //E recebe como parametro: activity, uma instancia do drawer para vincular a actionBar da activity,
        //uma instância da Toolbar para vincular o DrawerLayout
        //e as Strings para abertura e fechamento (acessibilidade)
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        //invocamos o método addDrawerListener() do DrawerLayout para conectar o ActionBarDrawerToggle no próprio DrawerLayout.
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        //Passa cada ID de menu como um conjunto de IDs, pois cada menu deve ser considerado como destino de nível superior.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();

        //Ação de clique nos itens do menu do drawerLayout e replace dos respectivos fragmentos
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Criação de uma variavel que vai receber o id do item selecionado
                int id = menuItem.getItemId();

                //Verifica se o id recebido é igual ao do layout e realiza uma ação
//                if(id == R.id.nav_music){
//                    replaceFragment(new BandaFragment());
//                }else if(id == R.id.nav_food){
//                    replaceFragment(new ComidaFragment());
//                }else if(id == R.id.nav_banda){
//                    replaceFragment(new BandaFragment());
//                }

                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_nav, menu);
        return true;
    }


}
