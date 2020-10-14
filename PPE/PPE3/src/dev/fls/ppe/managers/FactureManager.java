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

public class FactureManager {
    Document document = new Document();
    PdfWriter pdf;
    String path = "C:\\Users\\b.siniak\\Documents\\";
    Vente vente;

    public FactureManager(Vente vente) throws FileNotFoundException, DocumentException {
        pdf = PdfWriter.getInstance(document, new FileOutputStream(path +"Facture-" + vente.getIdVente() + ".pdf"));
        this.vente = vente;
        this.printFacture();
    }

    public Document getDocument() {
        return document;
    }

    public PdfWriter getPdf() {
        return pdf;
    }

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

    public void addLine(String line) throws DocumentException {
        document.add(new Paragraph(line));
    }

    public void savePdf() {
    }
}