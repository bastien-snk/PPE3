package dev.fls.ppe.accounts;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe est un objet Product
 *
 * @author b.siniak
 */
public class Product {

    /**
     * Paramètres de la classe
     */
    private int idProduit, idCategorie, quantite;
    private String nomProduit, image;
    private double prix, evaluations;

    /**
     * Constructeur de la classe/objet
     *
     * @param idProduit - id du Produit correspondant
     * @param idCategorie - catégorie du Produit correspondant
     * @param quantite - quantité du Produit correspondant
     * @param nomProduit - nom du Produit correspondant
     * @param image - Lien de l'image du Produit correspondant
     * @param prix - Prix du Produit correspondant
     * @param evaluations - Notes du Produit correspondant
     */
    public Product(int idProduit, int idCategorie, int quantite, String nomProduit, String image, double prix, double evaluations) {
        this.idProduit = idProduit;
        this.idCategorie = idCategorie;
        this.quantite = quantite;
        this.nomProduit = nomProduit;
        this.image = image;
        this.prix = prix;
        this.evaluations = evaluations;
    }

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public double getEvaluations() {
        return evaluations;
    }
}
