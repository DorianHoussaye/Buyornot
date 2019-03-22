package com.example.ppeandroidstudio.buyornot.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ppeandroidstudio.buyornot.Model.Pays;
import com.example.ppeandroidstudio.buyornot.SQLite.MySQLite;

public class PaysManager {
    private static final String TABLE_NAME = "pays";
    public static final String KEY_ID_PAYS = "pay_id";
    public static final String KEY_LIBELLE_PAYS= "pay_libelle";

    public static final String CREATE_TABLE_PAYS = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_ID_PAYS + " INTEGER primary key AUTOINCREMENT," +
            " " + KEY_LIBELLE_PAYS + " TEXT " +
            ");";

    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur

    public PaysManager(Context context) {
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

    public long addPays(Pays pays) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_ID_PAYS, pays.getId_pays());
        values.put(KEY_LIBELLE_PAYS, pays.getLibelle_pays());
        String where = KEY_ID_PAYS+" = ?";
        return db.insert(TABLE_NAME,null,values);
    }

    public int modPays(Pays pays) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_ID_PAYS, pays.getId_pays());

        String where = KEY_ID_PAYS+" = ?";
        String[] whereArgs = {pays.getLibelle_pays()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supPays(Pays pays) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_PAYS+" = ?";
        String[] whereArgs = {pays.getId_pays()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }
}
// class PaysManagers