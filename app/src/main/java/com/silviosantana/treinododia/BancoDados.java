package com.silviosantana.treinododia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 3;
    private static final String BANCO_USUARIO = "bd_usuario";

    SQLiteDatabase db;



    private static final String TABELA_USUARIO = "tb_usuario";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_DATE = "data";
    private static final String COLUNA_ALTURA = "altura";
    private static final String COLUNA_PESO = "peso";
    static final String COLUNA_EMAIL = "email";
    static final String COLUNA_Senha = "senha";


    public BancoDados(@Nullable Context context) {
        super(context, BANCO_USUARIO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE  TABELA_USUARIO" +
                "("
                + COLUNA_NOME + " text not null, " + COLUNA_DATE + " text, " + COLUNA_ALTURA + " text, "
                + COLUNA_PESO + " text,  " + COLUNA_EMAIL + " text UNIQUE not null, " + COLUNA_Senha + " text not null" + ")";

      try {
          db.execSQL(str);

      }catch (SQLException e){

          Log.e("DB_LOG", "onCreate: "+e.getLocalizedMessage());


      }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String str = "DROP TABLE IF EXISTS TABELA_USUARIO";
        db.execSQL(str);
        onCreate(db);



    }

    public void addUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();



        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, usuario.getNome());
        values.put(COLUNA_DATE, usuario.getDataN());
        values.put(COLUNA_ALTURA, usuario.getAltura());
        values.put(COLUNA_PESO, usuario.getPeso());
        values.put(COLUNA_EMAIL, usuario.getEmail());
        values.put(COLUNA_Senha, usuario.getSenha());

      db.insert("TABELA_USUARIO", null, values);
        db.close();


    }

    public String ValidarLogin(String COLUNA_EMAIL, String COLUNA_Senha) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM TABELA_USUARIO WHERE COLUNA_EMAIL=? AND COLUNA_Senha=?", new String[]{COLUNA_EMAIL,COLUNA_Senha});
        if (c.getCount() > 0){
            return "ok";
        }

        return "ERRO";
    }
}


