package com.silviosantana.treinododia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    int treinoSelecionado;

    ImageView imagemTreinos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView;

        String[] lista_nomes_treinos;
        String[] inicial_treinos;

        TreinosAdapter adapter;

        int[] lista_e_icones = {R.drawable.estrelaa, R.drawable.estrelaa, R.drawable.estrelaa,
                R.drawable.estrelaa, R.drawable.estrelaa, R.drawable.estrelaa, R.drawable.estrelaa,
                R.drawable.estrelaa, R.drawable.estrelaa, R.drawable.estrelaa};

        listView = (ListView)findViewById(R.id.listaTreino);
        imagemTreinos = (ImageView)findViewById(R.id.imageTreino);

        imagemTreinos.animate().alpha(1f).setDuration(2000);


        lista_nomes_treinos = getResources().getStringArray(R.array.lista_treinos);
        inicial_treinos = getResources().getStringArray(R.array.inicial_treinos);

        int i=0;
        adapter = new TreinosAdapter(getApplicationContext(), R.layout.celula_treino);
        listView.setAdapter(adapter);

        for(String titles:lista_nomes_treinos)
        {
            TreinoDataProvider dataProvider = new TreinoDataProvider(lista_e_icones[i], titles, inicial_treinos[i]);
            adapter.add(dataProvider);
            i++;
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                treinoSelecionado = position;
                Toast.makeText(getApplicationContext(), "Hello " + String.valueOf(position), Toast.LENGTH_LONG).show();
                loadTelaExercicios();
            }
        });
    }
    public void loadTelaExercicios(){
        Intent intent = new Intent(getApplicationContext(), TelaExercicios.class);
        intent.putExtra("numeroTreino", treinoSelecionado);
        startActivity(intent);
    }


}