/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class MapController implements Initializable {

    @FXML
    private Button return22;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ret22(ActionEvent event) {
         try {

            Parent root;
            root = FXMLLoader.load(getClass().getResource("Publication.fxml"));
            return22.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichagePubController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
