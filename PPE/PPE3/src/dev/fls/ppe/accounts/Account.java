package dev.fls.ppe.accounts;

/**
 * Cette classe est un objet Account
 *
 * @author b.siniak
 */
public class Account {

    /**
     * Paramètres de la classe
     */
    private String username, password, email, telephone;
    private int idAgent, idProfil;
    private boolean connected;

    /**
     * Constructeur de la classe/objet
     *
     * @param idAgent - id du compte
     * @param username - nom d'utilisateur du compte
     * @param password - mot de passe du compte
     * @param email - email du compte
     * @param telephone - numéro de téléphone du compte
     * @param idProfil - id du profil correspondant
     */
    public Account(int idAgent, String username, String password, String email, String telephone, int idProfil) {
        this.idAgent = idAgent;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.idProfil = idProfil;
        this.connected = false;
    }

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public boolean isConnected() {
        return connected;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }
}
