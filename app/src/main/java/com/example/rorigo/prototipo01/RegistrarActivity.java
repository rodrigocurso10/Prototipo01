package com.example.rorigo.prototipo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {

    EditText et_usuario, et_senha1, et_senha2;
    Button bt_reg_novo;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        db =  new DBHelper (this);

        et_usuario = (EditText)findViewById(R.id.et_reg_usuario);
        et_senha1 = (EditText)findViewById(R.id.et_reg_senha1);
        et_senha2 = (EditText)findViewById(R.id.et_reg_senha2);

        bt_reg_novo = (Button) findViewById(R.id.bt__reg_novo);

        bt_reg_novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = et_usuario.getText().toString();
                String p1 = et_senha1.getText().toString();
                String p2 = et_senha2.getText().toString();

                if (username.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Usuario não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else if (p1.equals("") || p2.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Deve preencher a senha, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else if (!p1.equals(p2)){
                    Toast.makeText(RegistrarActivity.this, "As duas senhas não conrrespondem, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else {
                    //tudo ok
                    long res = db.CriarUtilizador(username, p1);
                    if (res>0){
                        Toast.makeText(RegistrarActivity.this, "Registro ok", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(RegistrarActivity.this, "Registro invalido, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}
