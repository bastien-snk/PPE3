package dev.fls.ppe.managers;

import dev.fls.ppe.accounts.Product;
import dev.fls.ppe.accounts.Vente;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe gère tout ce qui est en lien avec les ventes
 *
 * @author b.siniak
 */
public class VenteManager {

    /**
     * Instance de la classe (permet d'éviter de faire passer l'instance dans tout les constructeurs
     * des classes qui utilisent VenteManager et d'utiliser VenteManager.getInstance())
     */
    private static VenteManager instance = new VenteManager();

    /**
     * Cette méthode permet de retourner l'instance de la classe actuelle
     *
     * @return instance - L'instance de l'objet
     */
    public static VenteManager getInstance() {
        return instance;
    }

    private List<Vente> ventes = new ArrayList<>();

    /**
     * Ajouter une vente si elle n'existe pas déjà dans la liste ventes
     *
     * @param vente
     */
    public void addVente(Vente vente) {
        if(getVenteById(vente.getIdVente()) == null) ventes.add(vente);
    }

    /**
     * Supprimer une vente de la liste
     *
     * @param vente - Vente supprimée
     */
    public void removeVente(Vente vente) {
        ventes.remove(vente);
    }

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public List<Vente> getVentes() {
        return ventes;
    }

    /**
     * Obtenir une vente grâce à son ID
     *
     * @param id - ID de recherche
     * @return vente - vente recherchée (null si aucune correspondante)
     */
    public Vente getVenteById(int id) {
        for (Vente vente : ventes) {
            if (vente.getIdVente() == id) {
                return vente;
            }
        }
        return null;
    }

    /**
     * Ajouter toutes les ventes à la liste ventes depuis la BDD
     */
    public void getVentesFromBDD() {
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `ventes`");
            while(rs.next()) {
                int idVente = rs.getInt("idVente");
                String dateVente = rs.getString("dateVente");
                float chiffreAffaire = rs.getFloat("chiffreAffaire");
                int idClient = rs.getInt("idClient");
                int idAgent = rs.getInt("idAgent");
                addVente(new Vente(idVente, idClient, idAgent, dateVente, chiffreAffaire));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vente getVenteByIdFromDB(int idVente) {
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `ventes` WHERE idVente = '" + idVente +"'");
            while(rs.next()) {
                int id = rs.getInt("idVente");
                String dateVente = rs.getString("dateVente");
                float chiffreAffaire = rs.getFloat("chiffreAffaire");
                int idClient = rs.getInt("idClient");
                int idAgent = rs.getInt("idAgent");
                return new Vente(id, idClient, idAgent, dateVente, chiffreAffaire);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getMaxIdFromDB() {
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT max(idVente) FROM `ventes`");
            while(rs.next()) {
                int id = rs.getInt("max(idVente)");
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void createVenteOnDB(Vente vente) {
        addVente(vente);
        if(DataAccessObject.getInstance().requeteAction("INSERT INTO `ventes` (`dateVente`, `chiffreAffaire`, `idClient`, `idAgent`) VALUES ('"+ vente.getDateVente() +"', '"+ vente.getChiffreAffaire() +"', '"+ vente.getIdClient() +"', '"+ vente.getIdAgent() +"');") > 0) {
            JOptionPane.showMessageDialog(null, "Vente crée ! Vous pouvez maintenant ajouter les produits.");
        } else {
            JOptionPane.showMessageDialog(null, "Erreur ! Veuillez réessayer...");
        }
    }

    public void editProductQuantityInVente(Vente vente, Product product) {
        if(DataAccessObject.getInstance().requeteAction("UPDATE `comporter` SET `quantite` = '"+ product.getQuantite() +"' WHERE `comporter`.`idProduit` = '"+ product.getIdProduit() +"' AND `comporter`.`idVente` = '"+ vente.getIdVente() +"';") > 0) {
            JOptionPane.showMessageDialog(null, "La quantité du produit " + product.getNomProduit() + " pour la vente " + vente.getIdVente() + " à été modifiée à " + product.getQuantite() + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Erreur ! Veuillez réessayer...");
        }
    }

    public void addAllProductsFromVente(Vente vente) {
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `comporter` WHERE idVente = '" + vente.getIdVente() +"'");
            while(rs.next()) {
                int idVente = rs.getInt("idVente");
                int idProduit = rs.getInt("idProduit");
                int quantite = rs.getInt("quantite");

                vente.getPanier().add(ProductManager.getInstance().getProductWithId(idProduit));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeProductFromVente(Vente vente, Product product) {
        if(DataAccessObject.getInstance().requeteAction("DELETE FROM `comporter` WHERE `comporter`.`idProduit` = '"+ product.getIdProduit() +"' AND `comporter`.`idVente` = '"+ vente.getIdVente() +"'") > 0) {
        } else {
            JOptionPane.showMessageDialog(null, "Erreur ! Veuillez réessayer...");
        }
    }

    public void removeStockFromProducts(Vente vente) {
        for(Product product : vente.getPanier()) {
            try {
                int quantite = ProductManager.getInstance().getProductWithId(product.getIdProduit()).getQuantite();
                DataAccessObject.getInstance().requeteSelection("UPDATE produits SET quantite = " + (quantite - product.getQuantite()) + " WHERE idProduit = '" + product.getIdProduit()  +"'");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
