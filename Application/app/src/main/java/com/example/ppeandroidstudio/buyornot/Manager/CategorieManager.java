package com.example.ppeandroidstudio.buyornot.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ppeandroidstudio.buyornot.Model.Categorie;
import com.example.ppeandroidstudio.buyornot.SQLite.MySQLite;

public class CategorieManager {
    private static final String TABLE_NAME = "categorie";
    public static final String KEY_ID_CATEGORIE = "cat_id";
    public static final String KEY_LIBELLE_CATEGORIE = "cat_libelle";

    public static final String CREATE_TABLE_CATEGORIE = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_ID_CATEGORIE + " INTEGER primary key AUTOINCREMENT," +
            " " + KEY_LIBELLE_CATEGORIE + " TEXT " +
            ");";

    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur

    public CategorieManager(Context context) {
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

    public long addCategorie(Categorie categorie) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_ID_CATEGORIE, categorie.getId_categorie());
        values.put(KEY_LIBELLE_CATEGORIE, categorie.getLibelle_categorie());
        String where = KEY_ID_CATEGORIE+" = ?";
        return db.insert(TABLE_NAME,null,values);
    }

    public int modCategorie(Categorie categorie) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_ID_CATEGORIE, categorie.getId_categorie());

        String where = KEY_ID_CATEGORIE+" = ?";
        String[] whereArgs = {categorie.getId_categorie()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supCategorie(Categorie categorie) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_CATEGORIE+" = ?";
        String[] whereArgs = {categorie.getId_categorie()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Categorie getCategorie(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Categorie a = new Categorie(1, "Sandwitch");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_CATEGORIE + "=" + id, null);
        if (c.moveToFirst()) {
            a.setId_categorie(c.getInt(c.getColumnIndex(KEY_ID_CATEGORIE)));
            a.setLibelle_categorie(c.getString(c.getColumnIndex(KEY_LIBELLE_CATEGORIE)));
            c.close();
        }
        return a;
    }
        public Cursor getCategorie() {
            // sélection de tous les enregistrements de la table
            return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        }

}


