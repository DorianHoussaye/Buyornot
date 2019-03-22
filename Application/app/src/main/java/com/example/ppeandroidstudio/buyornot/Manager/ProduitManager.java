package com.example.ppeandroidstudio.buyornot.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ppeandroidstudio.buyornot.Model.Produit;
import com.example.ppeandroidstudio.buyornot.SQLite.MySQLite;

public class ProduitManager {
    private static final String TABLE_NAME = "produit";
    public static final String KEY_ID_PRODUIT ="pro_id";
    public static final String KEY_NOM_PRODUIT="pro_nom ";
    public static final String KEY_DENOMINATION_GENERIQUE_PRODUIT="pro_denomination_generique";
    public static final String KEY_QUANTITE_PRODUIT="pro_quantite";
    public static final String KEY_SITE_WEB_PRODUIT="pro_site_web";
    public static final String KEY_CODE_EMBALLEUR_PRODUIT="pro_code_emballeur";
    public static final String KEY_INGREDIENTS_PRODUIT="pro_ingredients";
    public static final String KEY_ENERGIE_PRODUIT="pro_energie";
    public static final String KEY_MATIERES_GRASSES_PRODUIT="pro_matieres_grasses";
    public static final String KEY_DONT_ACIDES_GRAS_SATURES_PRODUIT="pro_dont_acides_gras_satures";
    public static final String KEY_GLUCIDES_PRODUIT="pro_glucides";
    public static final String KEY_DONT_SUCRES_PRODUIT="pro_dont_sucres";
    public static final String KEY_FIBRES_ALIMENTAIRES_PRODUIT="pro_fibres_alimentaires";
    public static final String KEY_PROTEINES_PRODUIT="pro_proteines";
    public static final String KEY_SEL_PRODUIT="pro_sel";
    public static final String KEY_SODIUM_PRODUIT="pro_sodium";
    public static final String KEY_FRUITS_LEGUMES_NOIX_PRODUIT="pro_fruits_legumes_noix";
    public static final String KEY_CACAO_PRODUIT="pro_cacao";
    public static final String CREATE_TABLE_PRODUIT = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+KEY_ID_PRODUIT+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_NOM_PRODUIT+" TEXT" +
            " "+KEY_DENOMINATION_GENERIQUE_PRODUIT+" TEXT" +
            " "+KEY_QUANTITE_PRODUIT+" TEXT" +
            " "+KEY_SITE_WEB_PRODUIT+" TEXT" +
            " "+KEY_CODE_EMBALLEUR_PRODUIT+" TEXT" +
            " "+KEY_INGREDIENTS_PRODUIT+" TEXT" +
            " "+KEY_ENERGIE_PRODUIT+" DOUBLE" +
            " "+KEY_MATIERES_GRASSES_PRODUIT+" DOUBLE" +
            " "+KEY_DONT_ACIDES_GRAS_SATURES_PRODUIT+" DOUBLE" +
            " "+KEY_GLUCIDES_PRODUIT+" DOUBLE" +
            " "+KEY_DONT_SUCRES_PRODUIT+" DOUBLE" +
            " "+KEY_FIBRES_ALIMENTAIRES_PRODUIT+" DOUBLE" +
            " "+KEY_PROTEINES_PRODUIT+" DOUBLE" +
            " "+KEY_SEL_PRODUIT+" DOUBLE" +
            " "+KEY_SODIUM_PRODUIT+" DOUBLE" +
            " "+KEY_FRUITS_LEGUMES_NOIX_PRODUIT+" DOUBLE" +
            " "+KEY_CACAO_PRODUIT+" DOUBLE" +
            ");";
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public ProduitManager(Context context)
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

    public long addProduit(Produit produit) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_NOM_PRODUIT, produit.getNom_produit());
        values.put(KEY_DENOMINATION_GENERIQUE_PRODUIT, produit.getDenomination_generique_produit());
        values.put(KEY_QUANTITE_PRODUIT, produit.getQuantite_produit());
        values.put(KEY_SITE_WEB_PRODUIT, produit.getSite_web_produit());
        values.put(KEY_CODE_EMBALLEUR_PRODUIT, produit.getCode_emballeur_produit());
        values.put(KEY_INGREDIENTS_PRODUIT, produit.getIngredients_produit());
        values.put(KEY_ENERGIE_PRODUIT, produit.getEnergie_produit());
        values.put(KEY_MATIERES_GRASSES_PRODUIT, produit.getMatieres_grasses_lipides_produit());
        values.put(KEY_DONT_ACIDES_GRAS_SATURES_PRODUIT, produit.getDont_acides_gras_satures_produit());
        values.put(KEY_GLUCIDES_PRODUIT, produit.getGlucides_produit());
        values.put(KEY_DONT_SUCRES_PRODUIT, produit.getDont_sucres_produit());
        values.put(KEY_FIBRES_ALIMENTAIRES_PRODUIT, produit.getFibres_alimentaires_produit());
        values.put(KEY_PROTEINES_PRODUIT, produit.getProteines_produit());
        values.put(KEY_SEL_PRODUIT, produit.getSel_produit());
        values.put(KEY_SODIUM_PRODUIT, produit.getSodium_produit());
        values.put(KEY_FRUITS_LEGUMES_NOIX_PRODUIT, produit.getFruits_legumes_noix_produit());
        values.put(KEY_CACAO_PRODUIT, produit.getCacao_produit());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int modProduit(Produit produit) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_NOM_PRODUIT, produit.getNom_produit());
        values.put(KEY_DENOMINATION_GENERIQUE_PRODUIT, produit.getDenomination_generique_produit());
        values.put(KEY_QUANTITE_PRODUIT, produit.getQuantite_produit());
        values.put(KEY_SITE_WEB_PRODUIT, produit.getSite_web_produit());
        values.put(KEY_CODE_EMBALLEUR_PRODUIT, produit.getCode_emballeur_produit());
        values.put(KEY_INGREDIENTS_PRODUIT, produit.getIngredients_produit());
        values.put(KEY_ENERGIE_PRODUIT, produit.getEnergie_produit());
        values.put(KEY_MATIERES_GRASSES_PRODUIT, produit.getMatieres_grasses_lipides_produit());
        values.put(KEY_DONT_ACIDES_GRAS_SATURES_PRODUIT, produit.getDont_acides_gras_satures_produit());
        values.put(KEY_GLUCIDES_PRODUIT, produit.getGlucides_produit());
        values.put(KEY_DONT_SUCRES_PRODUIT, produit.getDont_sucres_produit());
        values.put(KEY_FIBRES_ALIMENTAIRES_PRODUIT, produit.getFibres_alimentaires_produit());
        values.put(KEY_PROTEINES_PRODUIT, produit.getProteines_produit());
        values.put(KEY_SEL_PRODUIT, produit.getSel_produit());
        values.put(KEY_SODIUM_PRODUIT, produit.getSodium_produit());
        values.put(KEY_FRUITS_LEGUMES_NOIX_PRODUIT, produit.getFruits_legumes_noix_produit());
        values.put(KEY_CACAO_PRODUIT, produit.getCacao_produit());

        String where = KEY_ID_PRODUIT+" = ?";
        String[] whereArgs = {produit.getId_produit()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supProduit(Produit produit) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_PRODUIT+" = ?";
        String[] whereArgs = {produit.getId_produit()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Produit getProduit(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Produit a=new Produit(1,"Poulet Fermier Label Rouge de Loué", "Poulet Fermier Label Rouge de Loué", 1448, "http://www.loue.fr" , "FR 72.168.001 CE - Loué (Sarthe, France", "Poulet fermier 100%", 152, 7.34, 0, 0.36, 0, 0, 22.4, 0, 0, 0, 0);

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_PRODUIT+"="+id, null);
        if (c.moveToFirst()) {
            a.setId_produit(c.getInt(c.getColumnIndex(KEY_ID_PRODUIT)));
            a.setNom_produit(c.getString(c.getColumnIndex(KEY_NOM_PRODUIT)));
            a.setDenomination_generique_produit(c.getString(c.getColumnIndex(KEY_DENOMINATION_GENERIQUE_PRODUIT)));
            a.setQuantite_produit(c.getInt(c.getColumnIndex(KEY_QUANTITE_PRODUIT)));
            a.setSite_web_produit(c.getString(c.getColumnIndex(KEY_SITE_WEB_PRODUIT)));
            a.setCode_emballeur_produit(c.getString(c.getColumnIndex(KEY_CODE_EMBALLEUR_PRODUIT)));
            a.setIngredients_produit(c.getString(c.getColumnIndex(KEY_INGREDIENTS_PRODUIT)));
            a.setEnergie_produit(c.getDouble(c.getColumnIndex(KEY_ENERGIE_PRODUIT)));
            a.setMatieres_grasses_lipides_produit(c.getDouble(c.getColumnIndex(KEY_MATIERES_GRASSES_PRODUIT)));
            a.setDont_acides_gras_satures_produit(c.getDouble(c.getColumnIndex(KEY_DONT_ACIDES_GRAS_SATURES_PRODUIT)));
            a.setGlucides_produit(c.getDouble(c.getColumnIndex(KEY_GLUCIDES_PRODUIT)));
            a.setDont_sucres_produit(c.getDouble(c.getColumnIndex(KEY_DONT_SUCRES_PRODUIT)));
            a.setFibres_alimentaires_produit(c.getDouble(c.getColumnIndex(KEY_FIBRES_ALIMENTAIRES_PRODUIT)));
            a.setProteines_produit(c.getDouble(c.getColumnIndex(KEY_PROTEINES_PRODUIT)));
            a.setSel_produit(c.getDouble(c.getColumnIndex(KEY_SEL_PRODUIT)));
            a.setSodium_produit(c.getDouble(c.getColumnIndex(KEY_SODIUM_PRODUIT)));
            a.setFruits_legumes_noix_produit(c.getDouble(c.getColumnIndex(KEY_FRUITS_LEGUMES_NOIX_PRODUIT)));
            a.setCacao_produit(c.getDouble(c.getColumnIndex(KEY_CACAO_PRODUIT)));
            c.close();
        }
        return a;
    }
    public Cursor getProduits() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
} // class ProduitManager