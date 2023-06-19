package com.silviosantana.treinododia;

import static com.silviosantana.treinododia.BancoDados.COLUNA_EMAIL;
import static com.silviosantana.treinododia.BancoDados.COLUNA_Senha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormLogin extends AppCompatActivity {

    TextView textCadastro;
    EditText editEmail, editSenha;
    Button btnLogin;

    BancoDados db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

    db = new BancoDados(this);

        editEmail =  findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnLogin = findViewById(R.id.btnLogin);
        textCadastro = findViewById(R.id.textCadastro);

        editEmail.requestFocus();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (editEmail.getText().toString().isEmpty() || editSenha.getText().toString().isEmpty()){
                    Toast.makeText(FormLogin.this, "Preencha os Campos", Toast.LENGTH_LONG).show();
                    editEmail.requestFocus();

                }else if (editEmail.getText().toString().equals (COLUNA_EMAIL) &&
                        editSenha.getText().toString().equals(COLUNA_Senha)){

                    db.ValidarLogin(COLUNA_EMAIL, COLUNA_Senha);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(FormLogin.this, "Login incorreto", Toast.LENGTH_LONG).show();
                    editEmail.requestFocus();
                }


            }
        });

       textCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TelaCadastro.class);
                startActivity(intent);

            }
        });

    }
}