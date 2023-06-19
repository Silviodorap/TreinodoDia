package com.silviosantana.treinododia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TelaExercicios extends AppCompatActivity {

    ListView listaExercicios;
    String exercicioSelecionado;
    int treinoSelecionado;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_exercicios);
        listaExercicios = (ListView)findViewById(R.id.listaExercicios);


        treinoSelecionado = getIntent().getExtras().getInt("numeroTreino");
        String[] listaTreino = {};
        switch (treinoSelecionado){
            case 0: listaTreino = new String[]{"Abdominal", "Corrida", "Barra", "Flexao"  };
                break;
            case 1: listaTreino = new String[]{"Corrida", "Barra", "Flexao", "Corrida", "Barra", "Flexao", "Corrida"};
                break;
            default: listaTreino = new String[]{"Corrida", "Barra", "Flexao", "Agachamento", "Barra", "Flexao", "Corrida"};
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaTreino);

        listaExercicios.setAdapter(adapter);

        listaExercicios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition  = position;
                String  itemValue  = (String) listaExercicios.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Item :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_SHORT) .show();
                exercicioSelecionado = itemValue;
                loadTelaVideos();
            }
        });
    }


    public void loadTelaVideos(){
        Intent intent = new Intent(getApplicationContext(), TelaVideos.class);
        intent.putExtra("nomeVideo", exercicioSelecionado);
        startActivity(intent);
    }


}