package com.example.ppeandroidstudio.buyornot.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ppeandroidstudio.buyornot.Model.Label;
import com.example.ppeandroidstudio.buyornot.SQLite.MySQLite;

public class LabelManager {
    private static final String TABLE_NAME = "label";
    public static final String KEY_ID_LABEL ="lab_id";
    public static final String KEY_LIBELLE_LABEL="lab_libelle";
    public static final String CREATE_TABLE_LABEL = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+KEY_ID_LABEL+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_LIBELLE_LABEL+" TEXT" +
            ");";
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public LabelManager(Context context)
    {
        maBaseSQLite = MySQLite.getInstance(context);
    }
    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }
    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }

    public long addLabel(Label label) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_LABEL, label.getLibelle_label());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int modLabel(Label label) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_LABEL, label.getLibelle_label());

        String where = KEY_ID_LABEL+" = ?";
        String[] whereArgs = {label.getId_label()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supLabel(Label label) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_LABEL+" = ?";
        String[] whereArgs = {label.getId_label()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Label getLabel(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Label a=new Label(1,"Nourri sans OGM");

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_LABEL+"="+id, null);
        if (c.moveToFirst()) {
            a.setId_label(c.getInt(c.getColumnIndex(KEY_ID_LABEL)));
            a.setLibelle_label(c.getString(c.getColumnIndex(KEY_LIBELLE_LABEL)));
            c.close();
        }
        return a;
    }
    public Cursor getLabels() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
}
