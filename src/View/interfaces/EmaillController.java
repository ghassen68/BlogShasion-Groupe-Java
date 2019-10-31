/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

//import entities.Mailer;
import Entities.product;
import Services.productCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class EmaillController implements Initializable {

    @FXML
    private AnchorPane am;
    @FXML
    private TextField idmail;
    @FXML
    private Button send;
    @FXML
    private Button ret;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
//    private void envoyer(ActionEvent event) {
//        product p = new product();
// //System.out.println(song);
//  Mailer m = new Mailer();
//
//
//  JOptionPane.showMessageDialog(null,"envoyer avec succes");
//  m.send(idmail.getText(), "vous avez ajouter un produit  dans notre application ", "email de confirmation");
  
//    }

//     @FXML
   private void reter1(ActionEvent event) {
        if (event.getTarget() == ret) {
            try {
               Stage stage = (Stage) am.getScene().getWindow();
                System.err.println("bbb2");
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("produit_a_vendre1.fxml"));
                 
                   
                am.getChildren().clear();
                am.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(EmaillController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
