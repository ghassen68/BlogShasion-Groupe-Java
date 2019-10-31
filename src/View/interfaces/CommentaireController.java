/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;





import Entities.Commentaire;
import Entities.CurrentUser;
import Services.CommentaireCRUD;
import Services.UserCRUD;
import java.util.Properties;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;


import java.io.IOException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import javax.mail.Session;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class CommentaireController implements Initializable {

    @FXML
    private TextArea zonecomment;
    @FXML
    private Button ajoutercomment;
    @FXML
    private TextField userID;
    private Button reclamationbutt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserCRUD uc = new UserCRUD();
        int idUser=1; // tochange
        int nbrGrosMots=0;
        try {
            nbrGrosMots = uc.getNbrGrosMots(idUser);
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(nbrGrosMots == 3) {
            zonecomment.setDisable(true);
        }
    
    }    

    @FXML
    private void addComment(ActionEvent event) {
        if(userID.getText().equals("")||zonecomment.getText().equals("")){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrez un commentaire");
            alert.showAndWait();
            
        }else{
            java.sql.Date updatedAt = new java.sql.Date(System.currentTimeMillis());
        Commentaire c = new Commentaire();
        c.setUserID(userID.getText());
        c.setContent(zonecomment.getText());
        c.setDatecomment(updatedAt);
        //c.setUserID(CurrentUser.id);
        //Notification e = new Notification();
        String postTitle="bien organiser travail";//to change to get Post Title
        String userName="abc"; //to  String userName="abc"; change togetUserName
        int idU=1; // to change get currentconnected user
      //  e.setContenu("Nouveau commentaire : "+postTitle+" by "+userName);
        //e.setIdUser(idU);
        CommentaireCRUD pc = new CommentaireCRUD();
        //NotificationCRUD nc = new NotificationCRUD();
            UserCRUD uc = new UserCRUD();
        pc.ajouterCommentaire(c);
       // nc.ajouterNotification(e);
        
        String commentWords[] = c.getContent().split(" ");
        List<String> badWord = new ArrayList<String>();
        badWord.add("jaja");
        badWord.add("kaka");
        //// you can add other words
        int verifBadWords= 0;
        for(String a : commentWords) {
            if(verifBadWords == 0){
                if(badWord.contains(a)){
                 uc.increaseGrosMots(idU);
                 verifBadWords=1;
                }
            }
            
            //System.out.println(a);
        }
            
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DetailsWindow1.fxml"));
            ajoutercomment.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
        Notifications notificationBuilder = Notifications.create()
                .title("You have added a new comment to this publication")
                .text("Check the publication comments")
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.showConfirm();
    }

    private void addreclamation(ActionEvent event) throws IOException, MessagingException, SQLException {
        
       	Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
            ajoutercomment.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }
    
