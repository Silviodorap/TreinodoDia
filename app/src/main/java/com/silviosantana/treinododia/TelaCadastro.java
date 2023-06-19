package com.silviosantana.treinododia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class TelaCadastro extends AppCompatActivity {
    private EditText editNome;
    private EditText editDate;
    private EditText editAltura;
    private EditText editPeso;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button butnCadastro;


    String [] mensagem = {"Preencha todos os campos"};

    BancoDados db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

       db = new BancoDados(this);
        editNome = findViewById(R.id.editNome);
        editDate = findViewById(R.id.editDate);
        editAltura = findViewById(R.id.editAltura);
        editPeso= findViewById(R.id.editPeso);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        butnCadastro= findViewById(R.id.butnCadastro);

        butnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = editNome.getText().toString();
                String data = editDate.getText().toString();
                String altura = editAltura.getText().toString();
                String peso = editPeso.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();

                if (nome.isEmpty() || data.isEmpty() || altura.isEmpty() || peso.isEmpty() || email.isEmpty() || senha.isEmpty()){

                    Snackbar snackbar = Snackbar.make(view,mensagem[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setActionTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    //insert
                    db.addUsuario(new Usuario(nome,data,altura,peso,email,senha));
                    Toast.makeText(TelaCadastro.this, " Cadastrado realizado com sucesso", Toast.LENGTH_SHORT).show();


                }
                Intent intent = new Intent(getApplicationContext(), FormLogin.class);
                startActivity(intent);


            }
        });


    }
}