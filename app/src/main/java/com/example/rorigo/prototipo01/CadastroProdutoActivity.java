package com.example.rorigo.prototipo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroProdutoActivity extends AppCompatActivity {

    EditText et_produto, et_valor;
    Button bt_pro_entrar;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastroproduto);

        db =  new DBHelper (this);

        et_produto = (EditText)findViewById(R.id.et_produto);
        et_valor = (EditText)findViewById(R.id.et_valor);

        bt_pro_entrar = (Button) findViewById(R.id.bt_pro_entrar);

        bt_pro_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String produto = et_produto.getText().toString();
                String valor = et_valor.getText().toString();

                if (produto.equals("") || valor.equals("")) {
                    Toast.makeText(CadastroProdutoActivity.this, "Campo vazio, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else {
                    //tudo ok
                    long res = db.CriarUtilizador2(produto, valor);
                    if (res > 0){
                        Toast.makeText(CadastroProdutoActivity.this, "Registro ok", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(CadastroProdutoActivity.this, "Registro invalido, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}
