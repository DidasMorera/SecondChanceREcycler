package com.pdm.secondchancerecycler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "recyclerDB";
    private static final String TABLE_NAME = "ESTUDANTES";

    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String TELEFONE = "telefone";
    private static final String MORADA = "morada";
    private static final String IDADE = "idade";
    private static final String SEXO = "sexo";


    private static final int DB_VERSION = 1;

    private static final String CREATE_DB = "CREATE TABLE " + TABLE_NAME + " ( " + ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOME + " TEXT NOT NULL, " + TELEFONE + " TEXT, "
            + MORADA + " TEXT, " + IDADE + " TEXT, " + SEXO + " TEXT);";

    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void gravarAluno(String nome, String telefone, String morada, String idade, String sexo){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(NOME, nome);
        valores.put(TELEFONE, telefone);
        valores.put(MORADA, morada);
        valores.put(IDADE, idade);
        valores.put(SEXO, sexo);

        db.insert(TABLE_NAME, null, valores);
        db.close();
    }
}
