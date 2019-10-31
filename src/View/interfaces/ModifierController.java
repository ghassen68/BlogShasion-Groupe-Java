/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.Commentaire;
import Services.CommentaireCRUD;
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
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierController implements Initializable {

    @FXML
    private TextArea zonemodifcomment;
    @FXML
    private Button modifierbuton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        zonemodifcomment.setText(DetailsWindowController1.an.getContent());
        // TODO
    }    

    @FXML
    private void updatecomment(ActionEvent event) {
        CommentaireCRUD ccrud = new CommentaireCRUD();
        //Commentaire c = new Commentaire(1,"e","eya");
        ccrud.modifierCommentaire(zonemodifcomment.getText(),DetailsWindowController1.an.getCommentID());
        Parent root;
        try {
            root=FXMLLoader.load(getClass().getResource("DetailsWindow1.fxml"));
               modifierbuton.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DetailsWindowController1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
