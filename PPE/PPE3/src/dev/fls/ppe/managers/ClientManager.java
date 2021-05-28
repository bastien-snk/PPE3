package dev.fls.ppe.managers;

import dev.fls.ppe.accounts.Account;
import dev.fls.ppe.accounts.Client;
import dev.fls.ppe.accounts.Profil;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Cette classe gère tout ce qui est en lien avec les clients
 *
 * @author b.siniak
 */
public class ClientManager {

    /**
     * Instance de la classe (permet d'éviter de faire passer l'instance dans tout les constructeurs
     * des classes qui utilisent ClientManager et d'utiliser ClientManager.getInstance())
     */
    private static ClientManager instance = new ClientManager();

    /**
     * Cette méthode permet de retourner l'instance de la classe actuelle
     *
     * @return instance
     */
    public static ClientManager getInstance() {
        return ClientManager.instance;
    }

    /**
     * Liste des objets Client
     */
    private List<Client> clients = new ArrayList<>();

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public List<Client> getClients() {
        return clients;
    }

    /**
     * Permet d'obtenir un des clients de la liste en demandant son nom
     *
     * @return client - Client recherché (null si aucun correspondant)
     */
    public Client getClientByName(String name) {
        for(Client client : this.clients) {
            if(client.getNom().equals(name)) return client;
        }
        return null;
    }

    /**
     * Permet d'obtenir un des clients de la liste en demandant son id
     *
     * @return client - Client recherché (null si aucun correspondant)
     */
    public Client getClientById(int id) {
        for(Client client : clients) {
            if(client.getId() == id) return client;
        }
        return null;
    }

    /**
     * Permet d'obtenir un des clients depuis la BDD en demandant son ID
     *
     * @param id - ID du Client recherché
     * @return client - Client recherché (null si aucun correspondant)
     */
    public Client getClientByIdFromDB(int id) {
        ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `cient_user` WHERE id = '"+ id +"'");
        try {
            while (rs.next()) {
                int idClient = rs.getInt("id");
                String nomClient = rs.getString("nom");
                String prenomClient = rs.getString("prenom");
                String emailClient = rs.getString("email");
                String telephoneClient = rs.getString("telephone");
                removeClient(getClientById(id));
                clients.add(new Client(idClient, nomClient, prenomClient, emailClient, telephoneClient));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getClientById(id);
    }

    /**
     * Permet d'obtenir l'id maximum de la BDD (table clients)
     *
     * @return idClient - id le plus grand
     */
    public int getMaxId() {
        ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT MAX(id) FROM client_user");
        try {
            while (rs.next()) {
                int idClient = rs.getInt("id");
                return idClient;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * Permet d'ajouter un Client à la BDD
     *
     * @param client - Client ajouté
     */
    public void addClient(Client client) {
        try {
            if(DataAccessObject.getInstance().requeteAction("INSERT INTO `client_user` (`id`, `nom`, `prenom`, `email`, `telephone`, `roles`, `password`) VALUES (NULL, '"+ client.getNom() +"', '"+ client.getPrenom() +"', '"+ client.getEmail() +"', '"+ client.getTelephone() +"', '[\"ROLE_USER\"', '123');") > 0) {
                clients.add(client);
                JOptionPane.showMessageDialog(null, "Client créé !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur ! Veuillez réessayer");
        }
    }

    /**
     * Retirer un client de la liste des Clients
     *
     * @param client - Client retiré
     */
    public void removeClient(Client client) {
        clients.remove(client);
    }

    /**
     * Remplir la liste des clients de ceux provenants de la BDD
     */
    public void addAllClientsFromDB() {
        int id = 0;
        String nomClient = "";
        String prenomClient = "";
        String emailClient = "";
        String telephoneClient = "";

        ResultSet rs = DataAccessObject.getInstance().requeteSelection("SELECT * FROM `client_user`");
        try {
            clients.clear();
            while (rs.next()) {
                id = rs.getInt("id");
                nomClient = rs.getString("nom");
                prenomClient = rs.getString("prenom");
                emailClient = rs.getString("email");
                telephoneClient = rs.getString("telephone");
                clients.add(new Client(id, nomClient, prenomClient, emailClient, telephoneClient));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Mettre à jour les informations d'un client dans la BDD
     *
     * @param client - Client mis à jour
     */
    public void updateClientInfos(Client client) {
        int successed = DataAccessObject.getInstance().requeteAction("UPDATE `client_user` SET `nom` = '"+ client.getNom() +"', `prenom` = '"+ client.getPrenom() +"', `email` = '"+ client.getEmail() +"', `telephone` = '"+ client.getTelephone() +"' WHERE `client_user`.`id` = '"+ client.getId() +"';");
        if(successed > 0) {
            JOptionPane.showMessageDialog(null, "Le client " + client.getPrenom() + " " + client.getNom() + " à été mis à jour !");
        } else {
            JOptionPane.showMessageDialog(null, "Erreur ! Veuillez réessayer.");
        }
    }
}
