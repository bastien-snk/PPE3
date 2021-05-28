package dev.fls.ppe.managers;

import dev.fls.ppe.accounts.Profil;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe gère tout ce qui est en lien avec les profils
 *
 * @author b.siniak
 */
public class ProfileManager {

    /**
     * Instance de la classe (permet d'éviter de faire passer l'instance dans tout les constructeurs
     * des classes qui utilisent ProfileManager et d'utiliser ProfileManager.getInstance())
     */
    private static ProfileManager instance = new ProfileManager();

    /**
     * Cette méthode permet de retourner l'instance de la classe actuelle
     *
     * @return instance - L'instance de l'objet
     */
    public static ProfileManager getInstance() {
        return instance;
    }

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public List<Profil> getProfils() {
        List<Profil> profils = new ArrayList<>();

        ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `profils`");
        try {
            while (rs.next()) {
                profils.add(new Profil(rs.getInt("idProfil"), rs.getString("type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profils;
    }

    /**
     * Permet de rechercher un profil dans la BDD avec un ID
     *
     * @param id - ID du profil recherché
     * @return profil - Le profil recherché avec l'id (null si aucun correspondant)
     */
    public Profil getProfilById(int id) {
        Profil profil = null;
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `profils` WHERE `idProfil` = '"+ id +"'");
            while (rs.next()) {
                int idProfil = rs.getInt("idProfil");
                String type = rs.getString("type");
                profil = new Profil(idProfil, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profil;
    }

    /**
     * Permet de rechercher un profil dans la BDD avec un type de profil
     *
     * @param name - ID du profil recherché
     * @return profil - Le profil recherché avec l'id (null si aucun correspondant)
     */
    public Profil getProfil(String name) {
        Profil profil = null;
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `profils` WHERE `type` = '"+ name +"'");
            while (rs.next()) {
                int idProfil = rs.getInt("idProfil");
                String type = rs.getString("type");
                profil = new Profil(idProfil, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profil;
    }

    /**
     * Ajouter un profil à la BDD
     *
     * @param type
     */
    public void addProfil(String type) {
        DataAccessObject.getInstance().requeteAction("INSERT INTO `profils` (`idProfil`, `type`) VALUES (NULL, '"+ type +"');");
    }

    /**
     * Compter le nombre de profils existants dans la BDD
     *
     * @return count - Le nombre de profils (0 si aucun)
     */
    public int countProfils() {
        int count = 0;
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT count(*) FROM `profils`");
            while (rs.next()) {
                count = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Supprimer un profil de la BDD si il existe
     *
     * @param currentProfil - Profil supprimé
     */
    public void removeProfil(Profil currentProfil) {
        if(DataAccessObject.getInstance().requeteAction("DELETE FROM `profils` WHERE `profils`.`idProfil` = '"+ currentProfil.getId() + "'") > 0) {
            JOptionPane.showMessageDialog(null, "Le profil " + currentProfil.getType() + " à été supprimé !");
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Erreur ! Veuillez réessayer");
            return;
        }
    }

    /**
     * Mettre à jour un profil séléctionné (son type) dans la BDD si il existe
     *
     * @param currentProfil - Profil à changer
     */
    public void updateProfil(Profil currentProfil) {
        if(DataAccessObject.getInstance().requeteAction("UPDATE `profils` SET type = '"+ currentProfil.getType() +"' WHERE `idProfil` = '"+ currentProfil.getId() +"'") > 0) {
            JOptionPane.showMessageDialog(null, "Le profil " + currentProfil.getType() + " à été modifié !");
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Erreur ! Veuillez réessayer");
            return;
        }
    }
}
