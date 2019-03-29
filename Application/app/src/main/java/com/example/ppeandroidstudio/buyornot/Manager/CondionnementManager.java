package com.example.ppeandroidstudio.buyornot.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.ppeandroidstudio.buyornot.Model.Conditionnement;
import com.example.ppeandroidstudio.buyornot.SQLite.MySQLite;


public class CondionnementManager {
    private static final String TABLE_NAME = "condionnement";
    public static final String KEY_ID_CONDITIONNEMENT = "con_id";
    public static final String KEY_LIBELLE_CONDITIONNEMENT = "con_libelle";

    public static final String CREATE_TABLE_CONDITIONNEMENT = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_ID_CONDITIONNEMENT + " INTEGER primary key AUTOINCREMENT," +
            " " + KEY_LIBELLE_CONDITIONNEMENT + " TEXT " +
            ");";

    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur

    public CondionnementManager(Context context) {
        maBaseSQLite = MySQLite.getInstance(context);
    }

    public void open() {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close() {
        //on ferme l'accès à la BDD
        db.close();
    }

    public long addConditionnement(Conditionnement conditionnement) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_ID_CONDITIONNEMENT, conditionnement.getId_conditionnement());
        values.put(KEY_LIBELLE_CONDITIONNEMENT, conditionnement.getLibelle_conditionnement());
        String where = KEY_ID_CONDITIONNEMENT+" = ?";
        return db.insert(TABLE_NAME,null,values);
    }

    public int modConditionnement(Conditionnement conditionnement) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_ID_CONDITIONNEMENT, conditionnement.getId_conditionnement());

        String where = KEY_ID_CONDITIONNEMENT+" = ?";
        String[] whereArgs = {conditionnement.getId_conditionnement()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supConditionnement(Conditionnement conditionnement) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_CONDITIONNEMENT+" = ?";
        String[] whereArgs = {conditionnement.getId_conditionnement()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Conditionnement getAdditif(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Conditionnement a=new Conditionnement(1, "pot de verre");

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_CONDITIONNEMENT+"="+id, null);
        if (c.moveToFirst()) {
            a.setId_conditionnement(c.getInt(c.getColumnIndex(KEY_ID_CONDITIONNEMENT)));
            a.setLibelle_conditionnement(c.getString(c.getColumnIndex(KEY_LIBELLE_CONDITIONNEMENT)));
            c.close();
        }
        return a;
    }
    public Cursor getAdditif() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

}
