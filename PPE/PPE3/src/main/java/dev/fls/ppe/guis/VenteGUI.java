/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.fls.ppe.guis;

import com.itextpdf.text.DocumentException;
import dev.fls.ppe.accounts.Client;
import dev.fls.ppe.accounts.Product;
import dev.fls.ppe.accounts.Vente;
import dev.fls.ppe.managers.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 *
 * @author b.siniak
 */
public class VenteGUI extends javax.swing.JFrame {

    Vente vente = null;
    /**
     * Creates new form GlobalGUI
     */
    public VenteGUI() {
        initComponents();
        updateLists();
    }

    private void updateLists() {
        updateClients(clientsList);
        updateProducts(productsList);
    }

    private void updateProducts(JComboBox list) {
        DefaultComboBoxModel model = (DefaultComboBoxModel)  list.getModel();
        model.removeAllElements();

        ProductManager.getInstance().getProductsFromDB();
        for(int i = 0; i < ProductManager.getInstance().getProducts().size(); i++) {
            Product product = ProductManager.getInstance().getProducts().get(i);
            if(product.getQuantite() > 0) {
                model.addElement(product.getNomProduit() + " - (" + product.getPrix() + ")");
            }
        }

        list.setModel(model);
    }

    private void updatePanierProducts(JList list) {
        DefaultListModel model = (DefaultListModel)  list.getModel();
        model.removeAllElements();

        VenteManager.getInstance().addAllProductsFromVente(vente);
        for(int i = 0; i < vente.getPanier().size(); i++) {
            Product product = vente.getPanier().get(i);
            model.addElement(product.getNomProduit());
        }

        list.setModel(model);
    }

    private void updateClients(JComboBox list) {
        DefaultComboBoxModel model = (DefaultComboBoxModel)  list.getModel();
        model.removeAllElements();

        ClientManager.getInstance().addAllClientsFromDB();
        for(int i = 0; i < ClientManager.getInstance().getClients().size(); i++) {
            Client client = ClientManager.getInstance().getClients().get(i);
            model.addElement(client.getId() + " - " + client.getPrenom() + " " + client.getNom());
        }

        list.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    private void initComponents() {

        ventesPanel1 = new javax.swing.JPanel();
        nomLabel1 = new javax.swing.JLabel();
        prenomLabel1 = new javax.swing.JLabel();
        emailLabel1 = new javax.swing.JLabel();
        telephoneLabel1 = new javax.swing.JLabel();
        prenomField1 = new javax.swing.JTextField();
        nomField1 = new javax.swing.JTextField();
        emailField1 = new javax.swing.JTextField();
        telephoneField1 = new javax.swing.JTextField();
        creerFactureButton1 = new javax.swing.JButton();
        menuPanel = new javax.swing.JPanel();
        produitsButton = new javax.swing.JButton();
        clientsButton = new javax.swing.JButton();
        adminButton = new javax.swing.JButton();
        gererPanel = new javax.swing.JTabbedPane();
        creerVente = new javax.swing.JPanel();
        clientsList = new javax.swing.JComboBox<>();
        nomLabel2 = new javax.swing.JLabel();
        createVente = new javax.swing.JButton();
        addProductPanel = new javax.swing.JPanel();
        productsList = new javax.swing.JComboBox<>();
        nomLabel4 = new javax.swing.JLabel();
        addProduct = new javax.swing.JButton();
        panierPanel = new javax.swing.JPanel();
        nomLabel5 = new javax.swing.JLabel();
        modifierQuantite = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panierProductsList = new JList<Object>();
        deleteProduct = new javax.swing.JButton();
        FinishVente = new javax.swing.JButton();
        CancelVente = new javax.swing.JButton();
        finVentePanel = new javax.swing.JPanel();
        genererFacture = new javax.swing.JButton();

        ventesPanel1.setBackground(new java.awt.Color(96, 96, 96));
        ventesPanel1.setEnabled(false);

        nomLabel1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        nomLabel1.setForeground(new java.awt.Color(255, 255, 255));
        nomLabel1.setText("Nom");

        prenomLabel1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        prenomLabel1.setForeground(new java.awt.Color(255, 255, 255));
        prenomLabel1.setText("Prénom");

        emailLabel1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        emailLabel1.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel1.setText("Email");

        telephoneLabel1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        telephoneLabel1.setForeground(new java.awt.Color(255, 255, 255));
        telephoneLabel1.setText("Téléphone");

        prenomField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        nomField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        emailField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        telephoneField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        creerFactureButton1.setBackground(new java.awt.Color(16, 86, 160));
        creerFactureButton1.setForeground(new java.awt.Color(255, 255, 255));
        creerFactureButton1.setText("Créer la facture");

        javax.swing.GroupLayout ventesPanel1Layout = new javax.swing.GroupLayout(ventesPanel1);
        ventesPanel1.setLayout(ventesPanel1Layout);
        ventesPanel1Layout.setHorizontalGroup(
            ventesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ventesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomLabel1)
                    .addComponent(prenomLabel1)
                    .addGroup(ventesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(prenomField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addComponent(nomField1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(emailLabel1)
                    .addGroup(ventesPanel1Layout.createSequentialGroup()
                        .addGroup(ventesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telephoneLabel1)
                            .addComponent(telephoneField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(creerFactureButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ventesPanel1Layout.setVerticalGroup(
            ventesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ventesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(creerFactureButton1)
                    .addGroup(ventesPanel1Layout.createSequentialGroup()
                        .addComponent(nomLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prenomLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prenomField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telephoneLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telephoneField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(96, 96, 96));

        menuPanel.setBackground(new java.awt.Color(96, 96, 96));

        produitsButton.setBackground(new java.awt.Color(16, 86, 160));
        produitsButton.setForeground(new java.awt.Color(255, 255, 255));
        produitsButton.setText("PRODUITS");
        produitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produitsButtonActionPerformed(e);
            }});

        clientsButton.setBackground(new java.awt.Color(16, 86, 160));
        clientsButton.setForeground(new java.awt.Color(255, 255, 255));
        clientsButton.setText("CLIENTS");

        adminButton.setBackground(new java.awt.Color(16, 86, 160));
        adminButton.setForeground(new java.awt.Color(255, 255, 255));
        adminButton.setText("ADMIN");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminButtonActionPerformed(e);
            }});

        gererPanel.setBackground(new java.awt.Color(96, 96, 96));

        creerVente.setBackground(new java.awt.Color(96, 96, 96));

        clientsList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M. Olivier Gilbert", "Item 2", "Item 3", "Item 4" }));

        nomLabel2.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        nomLabel2.setForeground(new java.awt.Color(255, 255, 255));
        nomLabel2.setText("Client");

        createVente.setBackground(new java.awt.Color(16, 86, 160));
        createVente.setForeground(new java.awt.Color(255, 255, 255));
        createVente.setText("Créer la vente");
        createVente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createVenteActionPerformed(e);
            }
        });

        javax.swing.GroupLayout creerVenteLayout = new javax.swing.GroupLayout(creerVente);
        creerVente.setLayout(creerVenteLayout);
        creerVenteLayout.setHorizontalGroup(
            creerVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creerVenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(creerVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creerVenteLayout.createSequentialGroup()
                        .addComponent(clientsList, 0, 185, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createVente)
                        .addGap(50, 50, 50))
                    .addGroup(creerVenteLayout.createSequentialGroup()
                        .addComponent(nomLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        creerVenteLayout.setVerticalGroup(
            creerVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creerVenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomLabel2)
                .addGap(3, 3, 3)
                .addGroup(creerVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientsList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createVente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        gererPanel.addTab("Créer", creerVente);

        addProductPanel.setBackground(new java.awt.Color(96, 96, 96));

        productsList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        nomLabel4.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        nomLabel4.setForeground(new java.awt.Color(255, 255, 255));
        nomLabel4.setText("Produit");

        addProduct.setBackground(new java.awt.Color(16, 86, 160));
        addProduct.setForeground(new java.awt.Color(255, 255, 255));
        addProduct.setText("Ajouter le produit");
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductActionListener(e);
            }
        });

        javax.swing.GroupLayout addProductPanelLayout = new javax.swing.GroupLayout(addProductPanel);
        addProductPanel.setLayout(addProductPanelLayout);
        addProductPanelLayout.setHorizontalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addProductPanelLayout.createSequentialGroup()
                        .addComponent(productsList, 0, 169, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addProduct)
                        .addGap(50, 50, 50))
                    .addGroup(addProductPanelLayout.createSequentialGroup()
                        .addComponent(nomLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        addProductPanelLayout.setVerticalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomLabel4)
                .addGap(3, 3, 3)
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productsList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        gererPanel.addTab("Ajouter des produits", addProductPanel);

        panierPanel.setBackground(new java.awt.Color(96, 96, 96));

        nomLabel5.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        nomLabel5.setForeground(new java.awt.Color(255, 255, 255));
        nomLabel5.setText("Liste des produits");

        modifierQuantite.setBackground(new java.awt.Color(16, 86, 160));
        modifierQuantite.setForeground(new java.awt.Color(255, 255, 255));
        modifierQuantite.setText("Modifier quantité");
        modifierQuantite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifierQuantiteActionPerformed(e);
            }
        });

        panierProductsList.setModel(new DefaultListModel<>());
        jScrollPane1.setViewportView(panierProductsList);

        deleteProduct.setBackground(new java.awt.Color(16, 86, 160));
        deleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        deleteProduct.setText("Supprimer");
        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProductActionPerformed(e);
            }
        });

        FinishVente.setBackground(new java.awt.Color(16, 86, 160));
        FinishVente.setForeground(new java.awt.Color(255, 255, 255));
        FinishVente.setText("Terminer la vente");
        FinishVente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinishVenteActionPerformed(e);
            }
        });

        CancelVente.setBackground(new java.awt.Color(16, 86, 160));
        CancelVente.setForeground(new java.awt.Color(255, 255, 255));
        CancelVente.setText("Annuler la vente");
        CancelVente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelVenteActionPerformed(e);
            }
        });

        javax.swing.GroupLayout panierPanelLayout = new javax.swing.GroupLayout(panierPanel);
        panierPanel.setLayout(panierPanelLayout);
        panierPanelLayout.setHorizontalGroup(
            panierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panierPanelLayout.createSequentialGroup()
                        .addComponent(nomLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panierPanelLayout.createSequentialGroup()
                        .addGroup(panierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modifierQuantite, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FinishVente, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(CancelVente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addGap(77, 77, 77))
        );
        panierPanelLayout.setVerticalGroup(
            panierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifierQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinishVente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelVente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gererPanel.addTab("Panier", panierPanel);

        finVentePanel.setBackground(new java.awt.Color(96, 96, 96));

        genererFacture.setBackground(new java.awt.Color(16, 86, 160));
        genererFacture.setForeground(new java.awt.Color(255, 255, 255));
        genererFacture.setText("Générer la facture");
        genererFacture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genererFactureActionPerformed(e);
            }
        });

        javax.swing.GroupLayout finVentePanelLayout = new javax.swing.GroupLayout(finVentePanel);
        finVentePanel.setLayout(finVentePanelLayout);
        finVentePanelLayout.setHorizontalGroup(
            finVentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finVentePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(genererFacture)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        finVentePanelLayout.setVerticalGroup(
            finVentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finVentePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(genererFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        gererPanel.addTab("Fin de vente", finVentePanel);

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produitsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    )
                .addGap(18, 18, 18)
                .addComponent(gererPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addComponent(produitsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(produitsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(clientsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(adminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gererPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genererFactureActionPerformed(ActionEvent e) {
        FactureManager facture = null;
        try {
            facture = new FactureManager(vente);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        }
        VenteManager.getInstance().removeStockFromProducts(vente);
    }

    private void CancelVenteActionPerformed(ActionEvent e) {
        if(vente.cancel()) {
            ProduitsGUI produitsGUI = new ProduitsGUI();
            produitsGUI.setLocation(this.getLocation());
            produitsGUI.setVisible(true);
            this.setVisible(false);
            dispose();
        }
    }

    private void modifierQuantiteActionPerformed(ActionEvent e) {
        if(panierProductsList.getSelectedIndex() < 0) panierProductsList.setSelectedIndex(0);
        QuantiteGUI quantiteGUI = new QuantiteGUI(this);
        quantiteGUI.setProduct(ProductManager.getInstance().getProductWithNameFromDB((String) panierProductsList.getSelectedValue()));
        quantiteGUI.setLocation(this.getLocation());
        quantiteGUI.setVisible(true);
    }

    private void FinishVenteActionPerformed(ActionEvent e) {
        gererPanel.setEnabledAt(1, false);
        gererPanel.setSelectedComponent(finVentePanel);
    }

    private void addProductActionListener(ActionEvent e) {
        DefaultListModel model = (DefaultListModel) panierProductsList.getModel();
        String product = productsList.getSelectedItem().toString().split(" - ")[0].replace(" - ", "");
        boolean contains = false;

        for(int i = 0; i< model.size(); i++) {
            Object element = model.getElementAt(i);
            System.out.println(element.toString());
            if(element.toString().equals(product)) contains = true;
        }

        if(!contains) {
            System.out.println(product);
            ProductManager.getInstance().addProductInVente(vente, ProductManager.getInstance().getProductWithNameFromDB(product));
            model.addElement(product);
        } else {
            JOptionPane.showMessageDialog(null, "Produit déjà présent, veuillez modifier sa quantité dans \"Panier\"");
        }

    }

    private void createVenteActionPerformed(ActionEvent e) {
        int idClient = Integer.parseInt(clientsList.getSelectedItem().toString().split(" ")[0].replace(" ", ""));
        Date date = new Date();
        vente = new Vente(VenteManager.getInstance().getMaxIdFromDB() + 1, idClient, AccountManager.getInstance().getAccountsConnected().get(0).getIdAgent(), date.getDay() + "/" + date.getMonth() + "/" + date.getYear(),0);
        VenteManager.getInstance().createVenteOnDB(vente);
        gererPanel.setEnabledAt(0, false);
        gererPanel.setSelectedComponent(addProductPanel);
        creerVente.setVisible(false);
    }

    private void deleteProductActionPerformed(ActionEvent e) {
        VenteManager.getInstance().removeProductFromVente(vente, ProductManager.getInstance().getProductWithNameFromDB((String) panierProductsList.getSelectedValue()));
        updatePanierProducts(panierProductsList);
    }

    private void produitsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ProduitsGUI produitsGUI = new ProduitsGUI();
        produitsGUI.setLocation(this.getLocation());
        produitsGUI.setVisible(true);
        this.setVisible(false);
        dispose();
    }

    private void adminButtonActionPerformed(ActionEvent evt) {
        AdminGUI adminGUI = new AdminGUI();
        adminGUI.setLocation(this.getLocation());
        adminGUI.setVisible(true);
        this.setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VenteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VenteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VenteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VenteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelVente;
    private javax.swing.JButton FinishVente;
    private javax.swing.JButton addProduct;
    private javax.swing.JPanel addProductPanel;
    private javax.swing.JButton adminButton;
    private javax.swing.JButton clientsButton;
    private javax.swing.JComboBox<String> clientsList;
    private javax.swing.JButton createVente;
    private javax.swing.JButton creerFactureButton1;
    private javax.swing.JPanel creerVente;
    private javax.swing.JButton deleteProduct;
    private javax.swing.JTextField emailField1;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JPanel finVentePanel;
    private javax.swing.JButton genererFacture;
    private javax.swing.JTabbedPane gererPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton modifierQuantite;
    private javax.swing.JTextField nomField1;
    private javax.swing.JLabel nomLabel1;
    private javax.swing.JLabel nomLabel2;
    private javax.swing.JLabel nomLabel4;
    private javax.swing.JLabel nomLabel5;
    private javax.swing.JPanel panierPanel;
    private JList<Object> panierProductsList;
    private javax.swing.JTextField prenomField1;
    private javax.swing.JLabel prenomLabel1;
    private javax.swing.JComboBox<String> productsList;
    private javax.swing.JButton produitsButton;
    private javax.swing.JTextField telephoneField1;
    private javax.swing.JLabel telephoneLabel1;
    private javax.swing.JPanel ventesPanel1;
    // End of variables declaration//GEN-END:variables
}
