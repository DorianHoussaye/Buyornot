package com.example.ppeandroidstudio.buyornot.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ppeandroidstudio.buyornot.Model.Allergene;
import com.example.ppeandroidstudio.buyornot.SQLite.MySQLite;

public class AllergeneManager {

    private static final String TABLE_NAME = "allergene";
    public static final String KEY_ID_ALLERGENE = "all_id";
    public static final String KEY_LIBELLE_ALLERGENE = "all_libele";

    public static final String CREATE_TABLE_ALLERGENE = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_ID_ALLERGENE + " INTEGER primary key AUTOINCREMENT," +
            " " + KEY_LIBELLE_ALLERGENE + " TEXT " +
            ");";

    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur

    public AllergeneManager(Context context) {
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
    public long addAllergene(Allergene allergene) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_ID_ALLERGENE, allergene.getId_allergene());
        values.put(KEY_LIBELLE_ALLERGENE, allergene.getLibelle_allergene());
        String where = KEY_ID_ALLERGENE+" = ?";
        return db.insert(TABLE_NAME,null,values);
    }
    public int modAdditif (Allergene allergene) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_ID_ALLERGENE, allergene.getId_allergene());

        String where = KEY_ID_ALLERGENE+" = ?";
        String[] whereArgs = {allergene.getId_allergene()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supAdditif(Allergene allergene) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_ALLERGENE+" = ?";
        String[] whereArgs = {allergene.getId_allergene()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }


    public Allergene getAllergene(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Allergene a=new Allergene(1, "Lait");

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_ALLERGENE+"="+id, null);
        if (c.moveToFirst()) {
            a.setId_allergene(c.getInt(c.getColumnIndex(KEY_ID_ALLERGENE)));
            a.setLibelle_allergene(c.getString(c.getColumnIndex(KEY_LIBELLE_ALLERGENE)));
            c.close();
        }
        return a;
    }
    public Cursor getAllergenef() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
}
