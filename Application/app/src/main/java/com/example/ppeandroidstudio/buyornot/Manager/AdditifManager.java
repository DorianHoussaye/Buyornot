package com.example.ppeandroidstudio.buyornot.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ppeandroidstudio.buyornot.Model.Additif;
import com.example.ppeandroidstudio.buyornot.Model.Produit;
import com.example.ppeandroidstudio.buyornot.SQLite.MySQLite;

public class AdditifManager {
    private static final String TABLE_NAME = "additif";
    public static final String KEY_ID_ADDITIF = "add_id";
    public static final String KEY_LIBELLE_ADDITIF = "add_libelle";

    public static final String CREATE_TABLE_ADDITIF = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_ID_ADDITIF + " INTEGER primary key AUTOINCREMENT," +
            " " + KEY_LIBELLE_ADDITIF + " TEXT " +
            ");";

    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur

    public AdditifManager(Context context) {
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

    public long addAdditif(Additif additif) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_ID_ADDITIF, additif.getId_additif());
        values.put(KEY_LIBELLE_ADDITIF, additif.getLibelle_additif());
        String where = KEY_ID_ADDITIF+" = ?";
        return db.insert(TABLE_NAME,null,values);
    }
    public int modAdditif(Additif additif) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_ID_ADDITIF, additif.getId_additif());

        String where = KEY_ID_ADDITIF+" = ?";
        String[] whereArgs = {additif.getId_additif()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supAdditif(Additif additif) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_ADDITIF+" = ?";
        String[] whereArgs = {additif.getId_additif()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Additif getAdditif(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Additif a=new Additif(1, "E323 - Lécithines");

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_ADDITIF+"="+id, null);
        if (c.moveToFirst()) {
            a.setId_additif(c.getInt(c.getColumnIndex(KEY_ID_ADDITIF)));
            a.setLibelle_additif(c.getString(c.getColumnIndex(KEY_LIBELLE_ADDITIF)));
            c.close();
        }
        return a;
    }
    public Cursor getAdditif() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

}
// class AdditifManager