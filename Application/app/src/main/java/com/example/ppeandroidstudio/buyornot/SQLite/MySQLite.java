package com.example.ppeandroidstudio.buyornot.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.ppeandroidstudio.buyornot.Manager.AdditifManager;
import com.example.ppeandroidstudio.buyornot.Manager.LabelManager;
import com.example.ppeandroidstudio.buyornot.Manager.MagasinManager;
import com.example.ppeandroidstudio.buyornot.Manager.MarqueManager;
import com.example.ppeandroidstudio.buyornot.Manager.PaysManager;
import com.example.ppeandroidstudio.buyornot.Manager.ProduitManager;
import com.example.ppeandroidstudio.buyornot.Manager.CategorieManager;
import com.example.ppeandroidstudio.buyornot.Manager.AllergeneManager;
import com.example.ppeandroidstudio.buyornot.Manager.CondionnementManager;



public class MySQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static MySQLite sInstance;

    public static synchronized MySQLite getInstance(Context context) {
        if (sInstance == null) { sInstance = new MySQLite(context); }
        return sInstance;
    }

    private MySQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Création de la base de données
        // on exécute ici les requêtes de création des tables
        sqLiteDatabase.execSQL(ProduitManager.CREATE_TABLE_PRODUIT); // création table "produit"
        sqLiteDatabase.execSQL(MarqueManager.CREATE_TABLE_MARQUE); // création table "marque"
        sqLiteDatabase.execSQL(AdditifManager.CREATE_TABLE_ADDITIF); // création table "additifs"
        sqLiteDatabase.execSQL(LabelManager.CREATE_TABLE_LABEL); // création table "label"
        sqLiteDatabase.execSQL(MagasinManager.CREATE_TABLE_MAGASIN); // création table "magasin"
        sqLiteDatabase.execSQL(PaysManager.CREATE_TABLE_PAYS); // création table "magasin"
        sqLiteDatabase.execSQL(CategorieManager.CREATE_TABLE_CATEGORIE); // création table "categorie"
        sqLiteDatabase.execSQL(AllergeneManager.CREATE_TABLE_ALLERGENE); // création table "allergene"
        sqLiteDatabase.execSQL(CondionnementManager.CREATE_TABLE_CONDITIONNEMENT); // création table "conditionnement"

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // Mise à jour de la base de données
        // méthode appelée sur incrémentation de DATABASE_VERSION
        // on peut faire ce qu'on veut ici, comme recréer la base :
        onCreate(sqLiteDatabase);
    }
} // class MySQLite