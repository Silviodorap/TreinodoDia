package com.silviosantana.treinododia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TreinosAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public TreinosAdapter (Context context, int resource){
        super (context,resource);
    }

    public void  add(Object object){
        super.add(object);
        list.add(object);
    }

    public int getCount(){
        return this.list.size();
    }

    public Object getItem(int position){
        return this.list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row;

        row = convertView;
        DataHandler handler;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.celula_treino,parent, false);
            handler = new DataHandler();
            handler.icone = (ImageView)row.findViewById(R.id.imageView);
            handler.treino = (TextView)row.findViewById(R.id.textNomeTreino);
            handler.inicial = (TextView)row.findViewById(R.id.textIdTreino);
            row.setTag(handler);
        }else{
            handler = (DataHandler)row.getTag();
        }

        TreinoDataProvider dataProvider;
        dataProvider = (TreinoDataProvider) this.getItem(position);
        handler.icone.setImageResource(dataProvider.getlistaIcones());
        handler.treino.setText(dataProvider.getlistatreinos());
        handler.inicial.setText(dataProvider.getlistainiciais());

        return row;
    }

    static class DataHandler{
        ImageView icone;
        TextView treino;
        TextView inicial;

    }

}