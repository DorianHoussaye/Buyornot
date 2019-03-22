package com.example.ppeandroidstudio.buyornot.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ppeandroidstudio.buyornot.Model.Magasin;
import com.example.ppeandroidstudio.buyornot.SQLite.MySQLite;

public class MagasinManager {

    private static final String TABLE_NAME = "magasin";
    public static final String KEY_ID_MAGASIN = "mag_id";
    public static final String KEY_LIBELLE_MAGASIN= "mag_libelle";

    public static final String CREATE_TABLE_MAGASIN = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_ID_MAGASIN + " INTEGER primary key AUTOINCREMENT," +
            " " + KEY_LIBELLE_MAGASIN + " TEXT " +
            ");";

    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur

    public MagasinManager(Context context) {
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
    public long addAdditif(Magasin magasin) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_ID_MAGASIN, magasin.getId_magasin());
        values.put(KEY_LIBELLE_MAGASIN, magasin.getLibelle_magasin());
        String where = KEY_ID_MAGASIN+" = ?";
        return db.insert(TABLE_NAME,null,values);
    }
    public int modMagasin(Magasin magasin) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_ID_MAGASIN, magasin.getId_magasin());

        String where = KEY_ID_MAGASIN+" = ?";
        String[] whereArgs = {magasin.getLibelle_magasin()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supMagasin(Magasin magasin) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_MAGASIN+" = ?";
        String[] whereArgs = {magasin.getId_magasin()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }
}
