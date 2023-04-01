package com.livtrack.livreurstracking;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Commande {

    private final StringProperty idCommande;
    private final StringProperty idClient;
    private final StringProperty prixCommande;

    public Commande()
    {
        idCommande = new SimpleStringProperty(this, "idCommande");
        idClient = new SimpleStringProperty(this, "idClient");
        prixCommande = new SimpleStringProperty(this, "prixCommande");
    }

    public StringProperty idCommandeProperty() { return idCommande; }
    public String getIdCommande() { return idCommande.get(); }
    public void setIdCommande(String newIdCommande) { idCommande.set(newIdCommande); }

    public StringProperty idClientProperty() { return idClient; }
    public String getidClient() { return idClient.get(); }
    public void setidClient(String newidClient) { idClient.set(newidClient); }

    public StringProperty prixCommandeProperty() { return prixCommande; }
    public String getPrixCommande() { return prixCommande.get(); }
    public void setPrixCommande(String newPrixCommande) { prixCommande.set(newPrixCommande); }




}
