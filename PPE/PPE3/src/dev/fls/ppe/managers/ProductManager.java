package dev.fls.ppe.managers;

import dev.fls.ppe.accounts.Categorie;
import dev.fls.ppe.accounts.Product;
import dev.fls.ppe.accounts.Vente;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe gère tout ce qui est en lien avec les produits
 *
 * @author b.siniak
 */
public class ProductManager {

    /**
     * Instance de la classe (permet d'éviter de faire passer l'instance dans tout les constructeurs
     * des classes qui utilisent ProductManager et d'utiliser ProductManager.getInstance())
     */
    private static ProductManager instance = new ProductManager();

    /**
     * Cette méthode permet de retourner l'instance de la classe actuelle
     *
     * @return instance
     */
    public static ProductManager getInstance() {
        return ProductManager.instance;
    }

    /**
     * Liste des objets Produits
     */
    private List<Product> products = new ArrayList<>();

    /**
     * Liste des objets Categories
     */
    private List<Categorie> categories = new ArrayList<>();

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public List<Product> getProducts() {
        return products;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    /**
     * Permet d'ajouter tout les produits de la BDD dans la liste products
     */
    public void getProductsFromDB() {
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `produits`");
            while(rs.next()) {
                int idProduit = rs.getInt("idProduit");
                double prix = rs.getDouble("prix");
                String nomProduit = rs.getString("nomProduit");
                int quantite = rs.getInt("quantite");
                String image = rs.getString("image");
                double evalutations = rs.getDouble("evaluations");
                int idCategorie = rs.getInt("idCategorie");
                addProduct(new Product(idProduit, idCategorie, quantite, nomProduit, image, prix, evalutations));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet d'ajouter un produit dans la liste products si elle ne le contient pas
     *
     * @param product - Produit ajouté
     */
    public void addProduct(Product product) {
        boolean validAdd = true;
        for (Product prods : this.getProducts()) {
            if(prods.getIdProduit() == product.getIdProduit()) {
                validAdd = false;
            }
        }
        if(!validAdd) return;
        products.add(product);
    }

    /**
     * Permet de supprimer un Produit de la liste products
     *
     * @param product
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * Ajouter les catégories de la BDD dans la liste categories
     */
    public void getCategoriesFromDB() {
        try {
            categories.clear();
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `categories`");
            while(rs.next()) {
                int idCategorie = rs.getInt("idCategorie");
                String categorie = rs.getString("nom");
                addCategorie(new Categorie(idCategorie, categorie));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ajouter une categorie à la liste
     *
     * @param categorie - categorie ajoutée
     */
    private void addCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    public Product getProductWithId(int id) {
        try {
            categories.clear();
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `produits` WHERE idProduit = '"+ id +"'");
            while(rs.next()) {
                int idProduit = rs.getInt("idProduit");
                double prix = rs.getDouble("prix");
                String nomProduit = rs.getString("nomProduit");
                int quantite = rs.getInt("quantite");
                String lienImage = rs.getString("image");
                float evaluation = rs.getFloat("evaluations");
                int idCategorie = rs.getInt("idCategorie");
                return new Product(idProduit, idCategorie, quantite, nomProduit, lienImage, prix, evaluation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addProductInVente(Vente vente, Product product) {
        if(DataAccessObject.getInstance().requeteAction("INSERT INTO `comporter` (`idProduit`, `idVente`, `quantite`) VALUES ("+ product.getIdProduit()+ ", "+ vente.getIdVente()+", "+ product.getQuantite() +");") > 0) {
            JOptionPane.showMessageDialog(null, "Produit ajouté !");
        } else {
            JOptionPane.showMessageDialog(null, "Erreur !");
        }
    }

    public Product getProductWithNameFromDB(String name) {
        try {
            categories.clear();
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `produits` WHERE nomProduit = '"+ name +"'");
            while(rs.next()) {
                int idProduit = rs.getInt("idProduit");
                double prix = rs.getDouble("prix");
                String nomProduit = rs.getString("nomProduit");
                int quantite = rs.getInt("quantite");
                String lienImage = rs.getString("image");
                float evaluation = rs.getFloat("evaluations");
                int idCategorie = rs.getInt("idCategorie");
                return new Product(idProduit, idCategorie, quantite, nomProduit, lienImage, prix, evaluation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductInVenteFromDB(Vente vente) {
        List<Product> panier = new ArrayList<>();
        List<Integer> id = new ArrayList<>();
        try {
            categories.clear();
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `comporter` WHERE idVente = '"+ vente.getIdVente() +"'");
            while (rs.next()) {
                id.add(rs.getInt("idProduit"));
            }
            for(int currentId : id) {
                rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `produits` WHERE idProduit = '"+ currentId +"'");
                while (rs.next()) {
                    int idProduit = rs.getInt("idProduit");
                    double prix = rs.getDouble("prix");
                    String nomProduit = rs.getString("nomProduit");
                    int quantite = rs.getInt("quantite");
                    String lienImage = rs.getString("image");
                    float evaluation = rs.getFloat("evaluations");
                    int idCategorie = rs.getInt("idCategorie");
                    panier.add(new Product(idProduit, idCategorie, quantite, nomProduit, lienImage, prix, evaluation));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return panier;
    }
}
