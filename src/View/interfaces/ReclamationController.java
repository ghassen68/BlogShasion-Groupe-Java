/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReclamationController implements Initializable {

    @FXML
    private Button tfreclamation;
    @FXML
    private TextArea tfreclamer;
    @FXML
    private Button tfCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Sendreclamation(ActionEvent event) {
        
        final String fromEmail = "eya.haribi@esprit.tn"; //requires valid gmail id
		final String password = "Eyaharibi98205730"; // correct password for gmail id
		final String toEmail = "eyaharibi@gmail.com"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		Service.sendEmail(session, toEmail,"Service reclamation de BlogFashion", tfreclamer.getText());
    }

    @FXML
    private void cancelbutton(ActionEvent event) {
        
        	Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DetailsWindow1.fxml"));
            tfCancel.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
