package com.livtrack.livreurstracking;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Livreur {

    private final StringProperty idLivreur;
    private final StringProperty nomLivreur;
    private final StringProperty telephoneLivreur;

    public Livreur()
    {
        idLivreur = new SimpleStringProperty(this, "idLivreur");
        nomLivreur = new SimpleStringProperty(this, "nomLivreur");
        telephoneLivreur = new SimpleStringProperty(this, "telephoneLivreur");
    }

    public StringProperty idProperty() { return idLivreur; }
    public String getId() { return idLivreur.get(); }
    public void setId(String newId) { idLivreur.set(newId); }

    public StringProperty nomProperty() { return nomLivreur; }
    public String getName() { return nomLivreur.get(); }
    public void setName(String newName) { nomLivreur.set(newName); }

    public StringProperty telephoneProperty() { return telephoneLivreur; }
    public String getMobile() { return telephoneLivreur.get(); }
    public void setMobile(String newMobile) { telephoneLivreur.set(newMobile); }


}
