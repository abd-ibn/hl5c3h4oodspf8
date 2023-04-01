package com.livtrack.livreurstracking;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produit {

    private final StringProperty idProduit;
    private final StringProperty nomProduit;
    private final StringProperty prixProduit;

    public Produit()
    {
        idProduit = new SimpleStringProperty(this, "idProduit");
        nomProduit = new SimpleStringProperty(this, "nomProduit");
        prixProduit = new SimpleStringProperty(this, "prixProduit");
    }

    public StringProperty idProduitProperty() { return idProduit; }
    public String getIdProduit() { return idProduit.get(); }
    public void setIdProduit(String newIdProduit) { idProduit.set(newIdProduit); }

    public StringProperty nomProduitProperty() { return nomProduit; }
    public String getNomProduit() { return nomProduit.get(); }
    public void setNomProduit(String newNomProduit) { nomProduit.set(newNomProduit); }

    public StringProperty prixProduitProperty() { return prixProduit; }
    public String getPrixProduit() { return prixProduit.get(); }
    public void setPrixProduit(String newPrixProduit) { prixProduit.set(newPrixProduit); }




}
