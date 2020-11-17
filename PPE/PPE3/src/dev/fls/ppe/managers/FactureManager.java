package dev.fls.ppe.managers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import dev.fls.ppe.accounts.Account;
import dev.fls.ppe.accounts.Client;
import dev.fls.ppe.accounts.Product;
import dev.fls.ppe.accounts.Vente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * Cette classe permet la génération d'une facture en fournissant une vente
 *
 * @author b.siniak
 * @version 1.0
 */
public class FactureManager {

    /**
     * Attributs
     */
    Document document = new Document();
    PdfWriter pdf;
    String path = "C:\\Users\\b.siniak\\Documents\\";
    Vente vente;

    /**
     * Constructeur de l'objet, il permet de créer le fichier PDF avec une vente
     *
     * @param vente - Objet vente
     * @throws FileNotFoundException - Exception en cas de fichier non trouvé
     * @throws DocumentException
     */
    public FactureManager(Vente vente) throws FileNotFoundException, DocumentException {
        pdf = PdfWriter.getInstance(document, new FileOutputStream(path +"Facture-" + vente.getIdVente() + ".pdf"));
        this.vente = vente;
        this.printFacture();
    }

    /**
     * GETTERS ET SETTERS
     */
    public Document getDocument() {
        return document;
    }

    public PdfWriter getPdf() {
        return pdf;
    }

    /**
     * Utilise la vente pour trouver les paramètres de la facture et les insérer dans le PDF
     * @throws DocumentException
     */
    public void printFacture() throws DocumentException {
        Client client = ClientManager.getInstance().getClientByIdFromDB(vente.getIdClient());
        Account agent = AccountManager.getInstance().getAccountInfoById(vente.getIdAgent());
        document.open();
        addLine("Facture de vente n°" + vente.getIdVente() + " éffectuée le " + vente.getDateVente());
        addLine("Client:");
        addLine(" -> " + client.getPrenom() + " " + client.getNom());
        addLine(" -> " + client.getTelephone());
        addLine(" -> " + client.getEmail());
        addLine("");
        addLine("Vendeur:");
        addLine("Statut -> " + ProfileManager.getInstance().getProfilById(agent.getIdProfil()).getType());
        addLine(" -> " + agent.getUsername());
        addLine(" -> " + agent.getEmail());
        addLine(" -> " + agent.getTelephone());
        addLine("");
        addLine("Produits:");
        for(Product products : ProductManager.getInstance().getProductInVenteFromDB(vente)) {
            double prix = products.getPrix() * (double) products.getQuantite();
            addLine(products.getQuantite() + "x " + products.getNomProduit() + " - " + prix + "€");
        }
        document.close();
    }

    /**
     * Ajouter un ligne au document
     * @param line
     * @throws DocumentException
     */
    public void addLine(String line) throws DocumentException {
        document.add(new Paragraph(line));
    }
}