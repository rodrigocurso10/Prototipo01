package com.example.rorigo.prototipo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Administrador extends AppCompatActivity {

    Button bt_admin_entrar, bt_voltar_ini;
    EditText usuario;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

//        bt_admin_entrar=(Button) findViewById(R.id.bt_admin_entrar);
//
//        bt_admin_entrar.setOnClickListener (new View.OnClickListener(){
//            public void  onClick(View view){
//                Intent i = new Intent(Administrador.this, RegistrarActivity.class);
//                startActivity(i);
//            }
//        });

        usuario = findViewById(R.id.et_admin);
        senha = findViewById(R.id.et_admin_senha);
        bt_admin_entrar = findViewById(R.id.bt_admin_entrar);
        bt_voltar_ini = findViewById(R.id.bt_voltar_ini);

        bt_admin_entrar.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                String usu = usuario.getText().toString();
                String sen = senha.getText().toString();
                if (usu.equals("cliente") && sen.equals("123")) {
                    startActivity(new Intent(Administrador.this, RegistrarActivity.class));
                }
                else if (usu.equals("produto") && sen.equals("123")) {
                    startActivity(new Intent(Administrador.this, CadastroProdutoActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Usuário ou senha inválida", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_voltar_ini.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Administrador.this, MainActivity.class));
            }
        });
    }
}
