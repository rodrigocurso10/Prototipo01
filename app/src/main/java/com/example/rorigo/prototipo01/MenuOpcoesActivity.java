package com.example.rorigo.prototipo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOpcoesActivity extends AppCompatActivity {

    Button bebidas, comidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcoes);

        bebidas = findViewById(R.id.bebidas);
        bebidas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MenuOpcoesActivity.this, BebidasActivity.class));
            }
        });

        comidas = findViewById(R.id.comidas);
        comidas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(new Intent(MenuOpcoesActivity.this, ComidasActivity.class));
            }
        });

    }
}

