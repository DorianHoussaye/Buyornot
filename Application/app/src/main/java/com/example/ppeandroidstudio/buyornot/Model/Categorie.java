package com.example.ppeandroidstudio.buyornot.Model;

public class Categorie {
    private int id_categorie;
    private String libelle_categorie;

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getLibelle_categorie() {
        return libelle_categorie;
    }

    public void setLibelle_categorie(String libelle_categorie) {
        this.libelle_categorie = libelle_categorie;
    }

    public Categorie(int id_categorie, String libelle_categorie) {
        this.id_categorie = id_categorie;
        this.libelle_categorie = libelle_categorie;

    }
}
