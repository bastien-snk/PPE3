package dev.fls.ppe.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données contenant des membres statiques afin de manipuler
 * la BDD ON implémente ici le Design Pattern Singleton
 *
 * @author b.siniak
 */
public class DataAccessObject {

    /**
     * Informations de connexion
     */
    private static String nomServeur = "127.0.0.1";
    private static String port = "3306";
    private static String nomBdd = "ppe3";
    private static String nomUtilisateur = "root";
    private static String motDePasse = "root";
    private static String chaineConnexion;

    private Connection connexion;
    private static DataAccessObject monDao = null;

    /**
     * Constructeur privé ! pour construire un objet, il faut utiliser la
     * méthode publique statique getInstance()
     *
     */
    private DataAccessObject() {
        try {
            //Définition de l'emplacement de la BDD
            DataAccessObject.chaineConnexion = "jdbc:mysql://" + DataAccessObject.nomServeur + ":" + DataAccessObject.port + "/" + DataAccessObject.nomBdd;

            //Création de la connexion à la BDD
            this.connexion = DriverManager.getConnection(DataAccessObject.chaineConnexion, DataAccessObject.nomUtilisateur, DataAccessObject.motDePasse);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Permet d'obtenir l'objet instancié
     * @return un Objet DataAccessObject avec connexion active ... pour une certaine durée
     */
    public static DataAccessObject getInstance() {
        if (DataAccessObject.monDao == null) {
            DataAccessObject.monDao = new DataAccessObject();
        } else {
            if(!DataAccessObject.monDao.connexionActive()){
            DataAccessObject.monDao = new DataAccessObject();
            }
        }
        return DataAccessObject.monDao;
    }

    /**
     * Permet de savoir si la connexion SQL est active
     *
     *
     * @return connexionActive - Etat de la connexion
     */
    public boolean connexionActive() {
        boolean connexionActive = true;
        try {
            if (this.connexion.isClosed()) {
                connexionActive = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connexionActive;
    }

    /**
     *
     * @param sql - Requête de séléction
     * @return rs - Resultat de la requete
     */
    public ResultSet requeteSelection(String sql){
   
        try {
            Statement requete = new DataAccessObject().connexion.createStatement();
            return requete.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
    }
    /**
     * 
     * @param sql - Requête d'action
     *
     * @return le nombre de lignes impactées par la requête action
     * 
     */
      public Integer requeteAction(String sql){
   
        try {
            Statement requete = new DataAccessObject().connexion.createStatement();
            return requete.executeUpdate(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }  
}
