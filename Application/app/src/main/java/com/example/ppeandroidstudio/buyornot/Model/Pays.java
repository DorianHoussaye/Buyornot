package com.example.ppeandroidstudio.buyornot.Model;

public class Pays {
    private int id_pays;
    private String libelle_pays;

    public Pays(int id_pays, String libelle_pays) {
        this.id_pays = id_pays;
        this.libelle_pays = libelle_pays;
    }

    public int getId_pays() {
        return id_pays;
    }

    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }

    public String getLibelle_pays() {
        return libelle_pays;
    }

    public void setLibelle_pays(String libelle_pays) {
        this.libelle_pays = libelle_pays;
    }
}
