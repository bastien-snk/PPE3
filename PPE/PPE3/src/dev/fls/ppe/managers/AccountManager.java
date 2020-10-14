package dev.fls.ppe.managers;

import dev.fls.ppe.accounts.Account;
import dev.fls.ppe.accounts.Profil;
import dev.fls.ppe.guis.LoginGUI;
import dev.fls.ppe.guis.ProduitsGUI;
import sun.management.Agent;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe gère tout ce qui est en lien avec les comptesAgents
 *
 * @author b.siniak
 */
public class AccountManager {

    /**
     * Instance de la classe (permet d'éviter de faire passer l'instance dans tout les constructeurs
     * des classes qui utilisent AccountManager et d'utiliser AccountManager.getInstance())
     */
    private static AccountManager instance = new AccountManager();

    /**
     * Cette méthode permet de retourner l'instance de la classe actuelle
     *
     * @return instance
     */
    public static AccountManager getInstance() {
        return AccountManager.instance;
    }

    /**
     * Liste des objets Account
     */
    private List<Account> accountsConnected = new ArrayList<>();

    private List<Account> agents = new ArrayList<>();


    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public List<Account> getAccountsConnected() {
        return accountsConnected;
    }

    public List<Account> getAgents() {
        return agents;
    }

    /**
     * Permet de retourner l'id Max de la table compte_agents
     */
    public int getMaxIdAgent() {
        ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT MAX(idAgent) FROM comptes_agents");
        try {
            while (rs.next()) {
                int idClient = rs.getInt("MAX(idAgent)");
                return idClient;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * Permet d'obtenir un des comptes de la liste en demandant son nom
     *
     * @return account - compte recherché (null si aucun correspondant)
     */
    public Account getAccountByName(String name) {
        for(Account account : this.accountsConnected) {
            if(account.getUsername().equals(name)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Permet d'obtenir toutes les informations d'un compte en demandant un nom d'utilisateur
     *
     * @param username - Nom d'utilisateur du compte
     * @return infos - Liste des infos du compte
     */
    public List<String> getAccountInfo(String username) {
        List<String> infos = new ArrayList<>();
        try {
            ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `comptes_agents` WHERE username = '"+ username + "'");
            rs.next();
            infos.add(0, rs.getString("idAgent"));
            infos.add(1, rs.getString("email"));
            infos.add(2, rs.getString("username"));
            infos.add(3, rs.getString("telephone"));
            infos.add(4, rs.getString("password"));
            infos.add(5, rs.getString("idProfil"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return infos;
    }

    /**
     * Ajouter un compte à la liste de comptes
     *
     * @param account - Le compte ajouté à la liste
     */
    public void addAccount(Account account) {
        accountsConnected.add(account);
    }

    /**
     * Retirer un compte de la liste des comptes
     *
     * @param account - Le compte supprimé de la liste
     */
    public void removeAccount(Account account) {
        accountsConnected.remove(account);
    }

    /**
     * Permet de connecter l'utilisateur si les informations saisies sont bonnes
     *
     * @param username - Nom d'utilisateur entré
     * @param password - Mot de passe entré
     * @param loginGUI - Formulaire de connexion actuel
     */
    public void checkLogin(String username, String password, LoginGUI loginGUI) {
        try {
            if(hasAccount(username, password)) {
                ProduitsGUI produitsGUI = new ProduitsGUI();
                produitsGUI.setLocation(loginGUI.getLocation());
                produitsGUI.setVisible(true);
                loginGUI.setVisible(false);
                JOptionPane.showMessageDialog(null, "Bienvenue " + username + " !");
            } else {
                JOptionPane.showMessageDialog(null, "Votre compte n'existe pas...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet d'insérer un client dans la BDD
     *
     * @param account - Le compte ajouté à la BDD
     */
    public void createAccount(Account account) throws SQLException {
        String username = account.getUsername();
        String password = account.getPassword();
        String email = account.getEmail();
        String telephone = account.getTelephone();
        int idProfil = account.getIdProfil();

        if(!hasAccount(username, password)) {
            DataAccessObject.getInstance().requeteAction("INSERT INTO `comptes_agents` (`email`, `username`, `telephone`, `password`, `idProfil`) VALUES ('"+ email +"', '"+ username +"', '"+ telephone +"', '"+ password +"', '"+ idProfil +"');");
        }
    }

    /**
     * Cette méthode permet de savoir si un utilisateur possède un compte agent dans la BDD
     *
     * @param username - Nom d'utilisateur de l'agent
     * @param password - Mot de passe de l'agent
     *
     * @return hasAccount - Booléen signifiant si le compte existe
     */
    public boolean hasAccount(String username, String password) throws SQLException {
        boolean hasAccount = false;

        ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT count(*) FROM `comptes_agents` WHERE username = '"+ username + "' AND password = '"+ password +"'");
        if(rs.next() && rs.getInt("count(*)") > 0) {
            hasAccount = true;
            List<String> infos = getAccountInfo(username);
            Account account = new Account(Integer.valueOf(infos.get(0)), infos.get(2), infos.get(4), infos.get(1), infos.get(3), Integer.valueOf(infos.get(5)));
            if(!accountsConnected.contains(account)) accountsConnected.add(account);
        }
        return hasAccount;
    }

    /**
     * Permet de savoir si un compte à les permissions Administrateur
     *
     * @param account - Compte à vérifier
     * @return boolean - Booleéen indiquant si le compte à les permissions (true)
     */
    public boolean isAdmin(Account account) {
        if(account.getIdProfil() != 1) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public void addAccountsFromDB() {
        agents.clear();
        ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `comptes_agents`");
        try {
            while(rs.next()) {
                int idAgent = rs.getInt("idAgent");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String telephone = rs.getString("telephone");
                String password = rs.getString("password");
                int idProfil = rs.getInt("idProfil");
                addAgent(new Account(idAgent, username, password, email, telephone, idProfil));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAgent(Account account) {
        agents.add(account);
    }

    public Account getAccountInfoById(int id) {
        ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `comptes_agents` WHERE idAgent = '" + id +"'");
        try {
            while(rs.next()) {
                id = rs.getInt("idAgent");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String telephone = rs.getString("telephone");
                String password = rs.getString("password");
                int idProfil = rs.getInt("idProfil");
                return new Account(id, username, password, email, telephone, idProfil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteAgent(Account currentAccount) {
        if(DataAccessObject.getInstance().requeteAction("DELETE FROM `comptes_agents` WHERE `comptes_agents`.`idAgent` = '"+ currentAccount.getIdAgent() +"'") > 0) {
            JOptionPane.showMessageDialog(null, "Suppression de l'agent " + currentAccount.getUsername() + " réussie !");
        } else {
            JOptionPane.showMessageDialog(null, "Erreur ! Veuillez réessayer ultérieurement...");
        }
    }
}
