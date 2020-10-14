package dev.fls.ppe;

import dev.fls.ppe.guis.LoginGUI;
import dev.fls.ppe.managers.AccountManager;
import dev.fls.ppe.managers.ClientManager;
import dev.fls.ppe.managers.DataAccessObject;
import dev.fls.ppe.managers.ProductManager;

/**
 * Point d'entrée du logiciel
 *
 * @author b.siniak
 * @version 1.0
 */
public class Main {

    /**
     * Menu de connexion
     */
    private final static LoginGUI loginGUI = new LoginGUI();

    /**
     * Méthode lue à l'allumage du logiciel
     * @param args
     */
    public static void main(String[] args) {
        loginGUI.setVisible(true);
    }
}
