package dev.fls.ppe.accounts;

/**
 * Cette classe est un objet Categirie
 *
 * @author b.siniak
 */
public class Categorie {

    /**
     * Paramètres de la classe
     */
    private int idCategorie;
    private String nom;

    /**
     * Constructeur de la classe/objet
     *
     * @param idCategorie - id de la catégorie
     * @param nom - nom de la catégorie
     */
    public Categorie(int idCategorie, String nom) {
        this.idCategorie = idCategorie;
        this.nom = nom;
    }

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
