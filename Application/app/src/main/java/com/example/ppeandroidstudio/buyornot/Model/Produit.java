package com.example.ppeandroidstudio.buyornot.Model;


public class Produit {
    private int id_produit;
    private String nom_produit;
    private String denomination_generique_produit;
    private int quantite_produit;
    private String site_web_produit;
    private String code_emballeur_produit;
    private String ingredients_produit;
    private double energie_produit;
    private double matieres_grasses_lipides_produit;
    private double dont_acides_gras_satures_produit;
    private double glucides_produit;
    private double dont_sucres_produit;
    private double fibres_alimentaires_produit;
    private double proteines_produit;
    private double sel_produit;
    private double sodium_produit;
    private double fruits_legumes_noix_produit;
    private double cacao_produit;


    public Produit(int id_produit, String nom_produit, String denomination_generique_produit, int quantite_produit, String site_web_produit, String code_emballeur_produit, String ingredients_produit, double energie_produit, double matieres_grasses_lipides_produit, double dont_acides_gras_satures_produit, double glucides_produit, double dont_sucres_produit, double fibres_alimentaires_produit, double proteines_produit, double sel_produit, double sodium_produit, double fruits_legumes_noix_produit, double cacao_produit) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.denomination_generique_produit = denomination_generique_produit;
        this.quantite_produit = quantite_produit;
        this.site_web_produit = site_web_produit;
        this.code_emballeur_produit = code_emballeur_produit;
        this.ingredients_produit = ingredients_produit;
        this.energie_produit = energie_produit;
        this.matieres_grasses_lipides_produit = matieres_grasses_lipides_produit;
        this.dont_acides_gras_satures_produit = dont_acides_gras_satures_produit;
        this.glucides_produit = glucides_produit;
        this.dont_sucres_produit = dont_sucres_produit;
        this.fibres_alimentaires_produit = fibres_alimentaires_produit;
        this.proteines_produit = proteines_produit;
        this.sel_produit = sel_produit;
        this.sodium_produit = sodium_produit;
        this.fruits_legumes_noix_produit = fruits_legumes_noix_produit;
        this.cacao_produit = cacao_produit;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getDenomination_generique_produit() {
        return denomination_generique_produit;
    }

    public void setDenomination_generique_produit(String denomination_generique_produit) {
        this.denomination_generique_produit = denomination_generique_produit;
    }

    public int getQuantite_produit() {
        return quantite_produit;
    }

    public void setQuantite_produit(int quantite_produit) {
        this.quantite_produit = quantite_produit;
    }

    public String getSite_web_produit() {
        return site_web_produit;
    }

    public void setSite_web_produit(String site_web_produit) {
        this.site_web_produit = site_web_produit;
    }

    public String getCode_emballeur_produit() {
        return code_emballeur_produit;
    }

    public void setCode_emballeur_produit(String code_emballeur_produit) {
        this.code_emballeur_produit = code_emballeur_produit;
    }

    public String getIngredients_produit() {
        return ingredients_produit;
    }

    public void setIngredients_produit(String ingredients_produit) {
        this.ingredients_produit = ingredients_produit;
    }

    public double getEnergie_produit() {
        return energie_produit;
    }

    public void setEnergie_produit(double energie_produit) {
        this.energie_produit = energie_produit;
    }

    public double getMatieres_grasses_lipides_produit() {
        return matieres_grasses_lipides_produit;
    }

    public void setMatieres_grasses_lipides_produit(double matieres_grasses_lipides_produit) {
        this.matieres_grasses_lipides_produit = matieres_grasses_lipides_produit;
    }

    public double getDont_acides_gras_satures_produit() {
        return dont_acides_gras_satures_produit;
    }

    public void setDont_acides_gras_satures_produit(double dont_acides_gras_satures_produit) {
        this.dont_acides_gras_satures_produit = dont_acides_gras_satures_produit;
    }

    public double getGlucides_produit() {
        return glucides_produit;
    }

    public void setGlucides_produit(double glucides_produit) {
        this.glucides_produit = glucides_produit;
    }

    public double getDont_sucres_produit() {
        return dont_sucres_produit;
    }

    public void setDont_sucres_produit(double dont_sucres_produit) {
        this.dont_sucres_produit = dont_sucres_produit;
    }

    public double getFibres_alimentaires_produit() {
        return fibres_alimentaires_produit;
    }

    public void setFibres_alimentaires_produit(double fibres_alimentaires_produit) {
        this.fibres_alimentaires_produit = fibres_alimentaires_produit;
    }

    public double getProteines_produit() {
        return proteines_produit;
    }

    public void setProteines_produit(double proteines_produit) {
        this.proteines_produit = proteines_produit;
    }

    public double getSel_produit() {
        return sel_produit;
    }

    public void setSel_produit(double sel_produit) {
        this.sel_produit = sel_produit;
    }

    public double getSodium_produit() {
        return sodium_produit;
    }

    public void setSodium_produit(double sodium_produit) {
        this.sodium_produit = sodium_produit;
    }

    public double getFruits_legumes_noix_produit() {
        return fruits_legumes_noix_produit;
    }

    public void setFruits_legumes_noix_produit(double fruits_legumes_noix_produit) {
        this.fruits_legumes_noix_produit = fruits_legumes_noix_produit;
    }

    public double getCacao_produit() {
        return cacao_produit;
    }

    public void setCacao_produit(double cacao_produit) {
        this.cacao_produit = cacao_produit;
    }
} // class Produit