package dev.fls.ppe.accounts;

/**
 * Cette classe est un objet Product
 *
 * @author b.siniak
 */
public class Profil {

    /**
     * Paramètres de la classe
     */
    private int id;
    private String type;

    /**
     * Constructeur de la classe/objet
     *
     * @param id - id du profil
     * @param type - type du profil
     */
    public Profil(int id, String type) {
        this.id = id;
        this.type = type;
    }

    /**
     * ------------------
     * GETTERS ET SETTERS
     * ------------------
     */

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Méthode de retour de l'objet sous forme de String
     *
     * @return infos du profil
     */
    @Override
    public String toString() {
        return id + " - " + type;
    }
}
