package com.livtrack.livreurstracking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloController implements Initializable {

    @FXML
    private Button btnCommandes;

    @FXML
    private Button btnLivreurs;

    @FXML
    private Button btnProduits;

    @FXML
    private GridPane ongletCommandes;

    @FXML
    private GridPane ongletLivreurs;

    @FXML
    private GridPane ongletProduits;





    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnAjouterProduit;

    @FXML
    private Button btnModifierProduit;

    @FXML
    private Button btnSupprimerProduit;

    @FXML
    private Button btnAjouterCommande;

    @FXML
    private Button btnModifierCommande;

    @FXML
    private Button btnSupprimerCommande;



    @FXML
    private TableColumn<Livreur, String> columnIdLivreur;

    @FXML
    private TableColumn<Livreur, String> columnNomLivreur;

    @FXML
    private TableColumn<Livreur, String> columnNumTelephone;

    @FXML
    private TableColumn<Produit, String> columnIdProduit;

    @FXML
    private TableColumn<Produit, String> columnNomProduit;

    @FXML
    private TableColumn<Produit, String> columnPrixProduit;

    @FXML
    private TableColumn<Commande, String> columnIdCommande;

    @FXML
    private TableColumn<Commande, String> columnIdClient;

    @FXML
    private TableColumn<Commande, String> columnPrixCommande;





    @FXML
    private TextField fieldNomLivreur;

    @FXML
    private TextField fieldTelephoneLivreur;

    @FXML
    private TableView<Livreur> tableLivreurs;

    @FXML
    private TextField fieldNomProduit;

    @FXML
    private TextField fieldPrixProduit;

    @FXML
    private TableView<Produit> tableProduits;

    @FXML
    private TextField fieldIdClient;

    @FXML
    private TextField fieldPrixCommande;

    @FXML
    private TableView<Commande> tableCommandes;




    @FXML
    void Ajouter(ActionEvent event) {

        String nomLivreur, telephoneLivreur;
        Connect();
        nomLivreur = fieldNomLivreur.getText();
        telephoneLivreur = fieldTelephoneLivreur.getText();

        try{
            pst = con.prepareStatement("insert into livreur(nom,telephone)values(?,?)");
            pst.setString(1, nomLivreur);
            pst.setString(2, telephoneLivreur);
            pst.executeUpdate();


            table();


        } catch(SQLException ex) {

        }
    }

    @FXML
    void AjouterProduit(ActionEvent event) {

        String nomProduit, prixProduit;
        Connect();
        nomProduit = fieldNomProduit.getText();
        prixProduit = fieldPrixProduit.getText();

        try{
            pst = con.prepareStatement("insert into produit(nom_produit,prix_produit)values(?,?)");
            pst.setString(1, nomProduit);
            pst.setString(2, prixProduit);
            pst.executeUpdate();


            tableProduitt();


        } catch(SQLException ex) {

        }
    }

    @FXML
    void AjouterCommande(ActionEvent event) {

        String idClient, prixCommande;
        Connect();
        idClient = fieldIdClient.getText();
        prixCommande = fieldPrixCommande.getText();

        try{
            pst = con.prepareStatement("insert into commande(id_client,prix_commande)values(?,?)");
            pst.setString(1, idClient);
            pst.setString(2, prixCommande);
            pst.executeUpdate();


            tableCommandee();


        } catch(SQLException ex) {

        }
    }







    public void table()
    {
        Connect();
        ObservableList<Livreur> livreurs = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select id_livreur,nom,telephone from livreur");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Livreur st = new Livreur();
                    st.setId(rs.getString("id_livreur"));
                    st.setName(rs.getString("nom"));
                    st.setMobile(rs.getString("telephone"));
                    livreurs.add(st);
                }
            }
            tableLivreurs.setItems(livreurs);
            columnIdLivreur.setCellValueFactory(f -> f.getValue().idProperty());
            columnNomLivreur.setCellValueFactory(f -> f.getValue().nomProperty());
            columnNumTelephone.setCellValueFactory(f -> f.getValue().telephoneProperty());



        }

        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableLivreurs.setRowFactory( tv -> {
            TableRow<Livreur> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  tableLivreurs.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(tableLivreurs.getItems().get(myIndex).getId()));
                    fieldNomLivreur.setText(tableLivreurs.getItems().get(myIndex).getName());
                    fieldTelephoneLivreur.setText(tableLivreurs.getItems().get(myIndex).getMobile());



                }
            });
            return myRow;
        });


    }

    public void tableProduitt()
    {
        Connect();
        ObservableList<Produit> produits = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select id_produit,nom_produit,prix_produit from produit");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Produit st = new Produit();
                    st.setIdProduit(rs.getString("id_produit"));
                    st.setNomProduit(rs.getString("nom_produit"));
                    st.setPrixProduit(rs.getString("prix_produit"));
                    produits.add(st);
                }
            }
            tableProduits.setItems(produits);
            columnIdProduit.setCellValueFactory(f -> f.getValue().idProduitProperty());
            columnNomProduit.setCellValueFactory(f -> f.getValue().nomProduitProperty());
            columnPrixProduit.setCellValueFactory(f -> f.getValue().prixProduitProperty());



        }

        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableProduits.setRowFactory( tv -> {
            TableRow<Produit> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  tableProduits.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(tableProduits.getItems().get(myIndex).getIdProduit()));
                    fieldNomProduit.setText(tableProduits.getItems().get(myIndex).getNomProduit());
                    fieldPrixProduit.setText(tableProduits.getItems().get(myIndex).getPrixProduit());



                }
            });
            return myRow;
        });


    }

    public void tableCommandee()
    {
        Connect();
        ObservableList<Commande> commandes = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select id_commande,id_client,prix_commande from commande");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Commande st = new Commande();
                    st.setIdCommande(rs.getString("id_commande"));
                    st.setidClient(rs.getString("id_client"));
                    st.setPrixCommande(rs.getString("prix_commande"));
                    commandes.add(st);
                }
            }
            tableCommandes.setItems(commandes);
            columnIdCommande.setCellValueFactory(f -> f.getValue().idCommandeProperty());
            columnIdClient.setCellValueFactory(f -> f.getValue().idClientProperty());
            columnPrixCommande.setCellValueFactory(f -> f.getValue().prixCommandeProperty());



        }

        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableCommandes.setRowFactory( tv -> {
            TableRow<Commande> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  tableCommandes.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(tableCommandes.getItems().get(myIndex).getIdCommande()));
                    fieldIdClient.setText(tableCommandes.getItems().get(myIndex).getidClient());
                    fieldPrixCommande.setText(tableCommandes.getItems().get(myIndex).getPrixCommande());



                }
            });
            return myRow;
        });


    }





















    @FXML
    void Modifier(ActionEvent event) {

        String nomLivreur, telephoneLivreur;

        myIndex = tableLivreurs.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(tableLivreurs.getItems().get(myIndex).getId()));

        nomLivreur = fieldNomLivreur.getText();
        telephoneLivreur = fieldTelephoneLivreur.getText();

        try
        {
            pst = con.prepareStatement("update livreur set nom = ?,telephone = ? where id_livreur = ? ");
            pst.setString(1, nomLivreur);
            pst.setString(2, telephoneLivreur);
            pst.setInt(3, id);
            pst.executeUpdate();

            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void ModifierProduit(ActionEvent event) {

        String nomProduit, prixProduit;

        myIndex = tableProduits.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(tableProduits.getItems().get(myIndex).getIdProduit()));

        nomProduit = fieldNomProduit.getText();
        prixProduit = fieldPrixProduit.getText();

        try
        {
            pst = con.prepareStatement("update produit set nom_produit = ?,prix_produit = ? where id_produit = ? ");
            pst.setString(1, nomProduit);
            pst.setString(2, prixProduit);
            pst.setInt(3, id);
            pst.executeUpdate();

            tableProduitt();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void ModifierCommande(ActionEvent event) {

        String idClient, prixCommande;

        myIndex = tableCommandes.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(tableCommandes.getItems().get(myIndex).getIdCommande()));

        idClient = fieldIdClient.getText();
        prixCommande = fieldPrixCommande.getText();

        try
        {
            pst = con.prepareStatement("update commande set id_client = ?,prix_commande = ? where id_commande = ? ");
            pst.setString(1, idClient);
            pst.setString(2, prixCommande);
            pst.setInt(3, id);
            pst.executeUpdate();

            tableCommandee();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


















    @FXML
    void Supprimer(ActionEvent event) {

        myIndex = tableLivreurs.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(tableLivreurs.getItems().get(myIndex).getId()));


        try
        {
            pst = con.prepareStatement("delete from livreur where id_livreur = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void SupprimerProduit(ActionEvent event) {

        myIndex = tableProduits.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(tableProduits.getItems().get(myIndex).getIdProduit()));


        try
        {
            pst = con.prepareStatement("delete from produit where id_produit = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            tableProduitt();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void SupprimerCommande(ActionEvent event) {

        myIndex = tableCommandes.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(tableCommandes.getItems().get(myIndex).getIdCommande()));


        try
        {
            pst = con.prepareStatement("delete from commande where id_commande = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            tableCommandee();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

















    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;

    public void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/glovo","root","");
        } catch (ClassNotFoundException ex){

        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();
        table();
        tableProduitt();
        tableCommandee();
    }

    @FXML
    private void handleClicks(ActionEvent event){

        if(event.getSource() == btnLivreurs){
            ongletLivreurs.toFront();

        }else if(event.getSource() == btnProduits){
            ongletProduits.toFront();

        }else if(event.getSource() == btnCommandes){
            ongletCommandes.toFront();

        }

    }



}