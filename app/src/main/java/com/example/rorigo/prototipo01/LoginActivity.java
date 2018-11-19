package com.example.rorigo.prototipo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_login, et_senha;
    Button bt_login;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db =  new DBHelper (this);

        et_login = (EditText)findViewById(R.id.et_login);
        et_senha = (EditText)findViewById(R.id.et_senha);

        bt_login = (Button) findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_login.getText().toString();
                String password = et_senha.getText().toString();

                if (username.equals("")){
                    Toast.makeText(LoginActivity.this, "Usuario não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Senha não inserida, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else {
                    //tudo ok
                    String res = db.ValidarLogin(username, password);
                    if (res.equals("OK")){
                        Toast.makeText(LoginActivity.this, "Login ok", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login invalido, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
