/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;



import Services.controle_mail;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class CarteController implements Initializable {

    @FXML
    private TextField tf_mail;
    @FXML
    private Label lb_CN;
    @FXML
    private TextField tf_nb;
    @FXML
    private Label lb_sign;
    @FXML
    private Label lb_add;
    @FXML
    private TextField tf_sig;
    @FXML
    private Button bt_ok;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmer_carte(ActionEvent event) throws MessagingException {
       controle_mail CM = new controle_mail();
        if (tf_nb.getText().equals("")) {
             Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
        ajoutdoneAlert.setTitle("Done");
        ajoutdoneAlert.setContentText("**put your number card**");
        ajoutdoneAlert.show();}
        else 
            if(tf_nb.getText().length()!=8){
                 Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
        ajoutdoneAlert.setTitle("Done");
        ajoutdoneAlert.setContentText("**Your number card must contain 8 numbers**");
        ajoutdoneAlert.show();
                
            }
            else 
                if(!CM.emailisValid(tf_mail.getText())) {
        Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
        ajoutdoneAlert.setTitle("Done");
        ajoutdoneAlert.setContentText("**your email is invalid**");
        ajoutdoneAlert.show();
            
                }
                else 
                    if (tf_sig.getText().length()!=4){
                 Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
        ajoutdoneAlert.setTitle("Done");
        ajoutdoneAlert.setContentText("**Your signature must contain 4 numbers**");
        ajoutdoneAlert.show();
                
            }
    
        
        
                else{
        String to=tf_mail.getText();
//        Mail.sendMail(to,"confirmation de payement blog_fashion ","You have just buy articles from our application Blog_Fashion" );
        
         Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
        ajoutdoneAlert.setTitle("Done");
        ajoutdoneAlert.setContentText("!!Check your Email!!");
        ajoutdoneAlert.show();
        
    }

    
}
}
