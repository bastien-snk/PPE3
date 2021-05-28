package dev.fls.ppe.accounts;

/**
 * Cette classe est un objet Client
 *
 * @author b.siniak
 */
public class Client {

    /**
     * Paramètres de la classe
     */
    private int id;
    private String nom, prenom, email, telephone;

    /**
     * Constructeur de la classe/objet
     *
     * @param id - id du Client correspondant
     * @param nom - nom du Client correspondant
     * @param prenom - prenom du Client correspondant
     * @param email - email du Client correspondant
     * @param telephone - numéro de téléphone du Client correspondant
     */
    public Client(int id, String nom, String prenom, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }
}
