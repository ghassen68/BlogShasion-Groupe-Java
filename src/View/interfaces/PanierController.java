/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Services.CmdCrud;
import static utils.MyConnexion.cnx;
import Entities.Commande;
import java.io.IOException;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class PanierController implements Initializable {

    @FXML
    private TableView tab_panier;
    @FXML
    private TableColumn<?, ?> idc_panier;
    @FXML
    private TableColumn<?, ?> idp_panier;
    @FXML
    private TableColumn<Commande, String> nomp_panier;
    @FXML
    private TableColumn<Commande, Integer> pricep_panier;
    @FXML
    private TableColumn<Commande, String> colorp_panier;
    @FXML
    private TableColumn<Commande, Integer> quantite_panier;
    @FXML
    private Label lb_basket;
    @FXML
    private Button bt_conf;
    @FXML
    private Button bt_delete;
    @FXML
    private Button bt_update;

    /**
     * Initializes the controller class.
     */
      public int cg;
    @FXML
    private TextField id_supp;
    @FXML
    private ComboBox<String> modif_color;
    @FXML
    private ComboBox<Integer> modif_qua;
    @FXML
    private TextField tfsearch;
    
    
    
    
    public void a() {
        tab_panier.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Commande A = (Commande) tab_panier.getItems().get(tab_panier.getSelectionModel().getSelectedIndex());
                id_supp.setText(String.valueOf((A.getNom_P())));
               // System.out.println("////////"+A.getId_c());

            }
        });
    }
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CmdCrud p = new CmdCrud();
       
        
        ArrayList<Commande> ccmd = (ArrayList<Commande>) p.displayCMD();
        ObservableList<Commande> obs = FXCollections.observableArrayList(ccmd);
        tab_panier.setItems(obs);
       nomp_panier.setCellValueFactory(new PropertyValueFactory<Commande, String>("Nom_P"));
       pricep_panier.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("price_P"));
       colorp_panier.setCellValueFactory(new PropertyValueFactory<Commande, String>("color_P"));
       quantite_panier.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("quantite"));
       
       a();
       
       
       modif_color.getItems().removeAll(modif_color.getItems());
        modif_color.getItems().addAll("noire", "blanc","rouge","vert");
        modif_qua.getItems().removeAll(modif_qua.getItems());
        modif_qua.getItems().addAll(1,2,3,4,5);
 
       
       
       //tab_panier.setOnMouseClicked((MouseEvent event)

        // TODO
     
    }

    @FXML
    private void bt_conf(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("payement.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("your basket");
        stage.hide();
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void bt_delete(ActionEvent event) {
        
        
        CmdCrud c= new CmdCrud();
        Commande cm=new Commande();
        cm.setNom_P(id_supp.getText());
        c.supprimerCMD(cm,cm.getNom_P());
        
        
         CmdCrud p = new CmdCrud();
       
        
        ArrayList<Commande> ccmd = (ArrayList<Commande>) p.displayCMD();
        ObservableList<Commande> obs = FXCollections.observableArrayList(ccmd);
        tab_panier.setItems(obs);
       nomp_panier.setCellValueFactory(new PropertyValueFactory<Commande, String>("Nom_P"));
       pricep_panier.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("price_P"));
       colorp_panier.setCellValueFactory(new PropertyValueFactory<Commande, String>("color_P"));
       quantite_panier.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("quantite"));
        
        
        
      
        /*   CmdCrud c = new CmdCrud();
        Commande Co = new Commande();
        
        tab_panier.setOnMouseClicked((MouseEvent event1) -> {
        Commande CC = (Commande) tab_panier.getItems().get(tab_panier.getSelectionModel().getSelectedIndex());
        
        Co.setId_c(CC.getId_c());
        Co.setNom_P(CC.getNom_P());
        Co.setPrice_P(CC.getPrice_P());
        Co.setQuantite(CC.getQuantite());
        c.supprimerCMD(CC.getId_c());
        
        });
        tab_panier.getItems().removeAll(tab_panier.getSelectionModel().getSelectedItem());*/
        /*tab_panier.setOnMouseClicked((MouseEvent event1) -> {
            Commande CC = (Commande) tab_panier.getItems().get(tab_panier.getSelectionModel().getSelectedIndex());

            Co.setId_c(CC.getId_c());
            Co.setNom_P(CC.getNom_P());
            Co.setPrice_P(CC.getPrice_P());
            Co.setQuantite(CC.getQuantite());
           ;
        
        });
         /*Commande cmd = new Commande();
        
        Commande CO = (Commande) tab_panier.getItems().get(tab_panier.getSelectionModel().getSelectedIndex());
        cmd.setId_c(CO.getId_c());
        cmd.setNom_P(CO.getNom_P());
        cmd.setPrice_P(CO.getPrice_P());
        cmd.setColor_P(CO.getColor_P());
        cmd.setQuantite(CO.getQuantite());
        /*  ;
        CmdCrud cc = new CmdCrud();
       int id;
       
       
       ObservableList<Commande> allCommande,SingleCommande;
       allCommande =tab_panier.getItems();
       SingleCommande=tab_panier.getSelectionModel().getSelectedItems();
       SingleCommande.forEach(allCommande::remove);
       
           
             Commande CO = (Commande) tab_panier.getItems().get(tab_panier.getSelectionModel().getSelectedIndex());
            cmd.setNom_P(CO.getNom_P());
            cmd.setPrice_P(CO.getPrice_P());
            cmd.setColor_P(CO.getColor_P());
            cmd.setQuantite(CO.getQuantite());
            cmd.setId_c(CO.getId_c());
            id=cmd.getId_c();
            System.out.println("bb= "+id);
             cc.supprimerCMD(id);
                                                
    */
                
                }

    @FXML
    private void bt_update(ActionEvent event) {
        CmdCrud p = new CmdCrud();
        Commande c =new Commande();
        c.setColor_P(modif_color.getValue());
        c.setQuantite(modif_qua.getValue());
        System.out.println("fgfgfgf"+modif_color.getValue());
        System.out.println("jhjhjhjh"+modif_qua.getValue());
        CmdCrud CM =new CmdCrud();
         c.setNom_P(id_supp.getText());
        CM.modifierCMD(c,c.getNom_P());
        
         ArrayList<Commande> ccmd = (ArrayList<Commande>) p.displayCMD();
        ObservableList<Commande> obs = FXCollections.observableArrayList(ccmd);
        tab_panier.setItems(obs);
       nomp_panier.setCellValueFactory(new PropertyValueFactory<Commande, String>("Nom_P"));
       pricep_panier.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("price_P"));
       colorp_panier.setCellValueFactory(new PropertyValueFactory<Commande, String>("color_P"));
       quantite_panier.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("quantite"));
    }

    @FXML
    private void click(MouseEvent event) {
    }

    

    private void bt_totale(MouseEvent event) throws SQLException {
        String req="SELECT SUM(price_P*quantite) FROM commande";
 Statement stm=cnx.createStatement();
         ResultSet rst=stm.executeQuery(req);
 rst.next();
 
           
    }

    @FXML
    private void search(KeyEvent event) {
       
             CmdCrud ps = new CmdCrud();
            String msg = tfsearch.getText().concat("%");
            //(!(msg.equals(""))){ 
            ArrayList<Commande> pers=(ArrayList<Commande>) ps.chercher(msg);
            ObservableList<Commande> obs1 = FXCollections.observableArrayList(pers);
            tab_panier.setItems(obs1);
    }
   
    }

    
    
    

    
    

