package dev.fls.ppe.accounts;

import dev.fls.ppe.managers.DataAccessObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe est un objet Vente
 *
 * @author b.siniak
 */
public class Vente {

    /**
     * Paramètres de la classe
     */
    private int idVente, idClient, idAgent;
    private String dateVente;
    private float chiffreAffaire;

    /**
     *  Constructeur de la classe/objet
     *
     * @param idVente - id de la vente
     * @param idClient - id du client correspondant
     * @param idAgent - id de l'agent effectuant la vente
     * @param dateVente - date de la vente
     * @param chiffreAffaire - chiffre d'affaire de la vente
     */
    public Vente(int idVente, int idClient, int idAgent, String dateVente, float chiffreAffaire) {
        this.idVente = idVente;
        this.idClient = idClient;
        this.idAgent = idAgent;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        this.dateVente = dtf.format(now);
        this.chiffreAffaire = chiffreAffaire;
    }

    private List<Product> panier = new ArrayList<>();

    /**
     * Ajouter un produit à la vente
     *
     * @param product
     */
    public void addProduct(Product product) {
        panier.add(product);
    }

    /**
     * Supprimer un produit de la vente
     *
     * @param product
     */
    public void removeProduct(Product product) {
        panier.add(product);
    }

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public List<Product> getPanier() {
        return panier;
    }

    public int getIdVente() {
        return idVente;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public String getDateVente() {
        return dateVente;
    }

    public float getChiffreAffaire() {
        return chiffreAffaire;
    }

    public Product getProductByName(String product) {
        for(Product products : panier) {
            if(products.getNomProduit().equals(product)) {
                return products;
            }
        }
        return null;
    }

    public boolean cancel() {
        int countRemoveProduits = DataAccessObject.getInstance().requeteAction("DELETE FROM comporter WHERE idVente = "+ this.getIdVente() +"");
        if(countRemoveProduits > 0) {
            if(DataAccessObject.getInstance().requeteAction("DELETE FROM ventes WHERE idVente = '"+ this.getIdVente() +"'") >0) {
                return true;
            }
        }
        return false;
    }
}
