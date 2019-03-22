package com.example.ppeandroidstudio.buyornot.Model;

public class Magasin {
    private int id_magasin;
    private String libelle_magasin;

    public Magasin(int id_magasin, String libelle_magasin) {
        this.id_magasin = id_magasin;
        this.libelle_magasin = libelle_magasin;
    }

    public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }

    public String getLibelle_magasin() {
        return libelle_magasin;
    }

    public void setLibelle_magasin(String libelle_magasin) {
        this.libelle_magasin = libelle_magasin;
    }



}
// class AdditifManager