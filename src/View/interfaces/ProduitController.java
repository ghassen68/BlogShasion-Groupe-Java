/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Services.CmdCrud;
import Entities.Commande;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class ProduitController implements Initializable {

    @FXML
    private Label lb_product;
    @FXML
    private Label lb_nom;
    @FXML
    private Label lb_prix;
    @FXML
    private Label lb_color;
    @FXML
    private Label lb_pay;
    @FXML
    private Label lb_qu;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prix;
    @FXML
    private ComboBox<String> cb_color;
    @FXML
    private ComboBox<Integer> cb_qu;
    @FXML
    private ComboBox<String> cb_pay;
    @FXML
    private Button bt_panier;
    @FXML
    private Button add_btt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Commande c = new Commande();
        cb_color.getItems().removeAll(cb_color.getItems());
        cb_color.getItems().addAll("noire", "blanc","rouge","vert");
        cb_qu.getItems().removeAll(cb_qu.getItems());
        cb_qu.getItems().addAll(1,2,3,4,5);
        cb_pay.getItems().removeAll(cb_pay.getItems());
        cb_pay.getItems().addAll("cach","credit card");
       
        
           
           
        
        // TODO
    }    

    @FXML
    private void bt_ajouter(ActionEvent event) {
        CmdCrud cr;
        cr = new CmdCrud();
        Commande c = new Commande();
        c.setNom_P(tf_nom.getText()); 
        c.setPrice_P(Integer.valueOf(tf_prix.getText())); 
        c.setColor_P(cb_color.getValue()); 
        c.setQuantite(cb_qu.getValue());
        c.setPay_c(cb_pay.getValue());
        cr.ajouterCMD(c);
        
        Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
        ajoutdoneAlert.setTitle("Done");
        ajoutdoneAlert.setContentText("**Product add successfully**");
        ajoutdoneAlert.show();
        
        
     
        
        
        
    }

    @FXML
    private void P_panier(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("panier.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("your basket");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
       
    }
    
}
