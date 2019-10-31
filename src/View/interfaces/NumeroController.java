package View.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javax.mail.Message;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class NumeroController implements Initializable {

    @FXML
    private TextField tf_num;
    @FXML
    private Button bt_SMS;
    @FXML
    private TextField test;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bt_SMS(ActionEvent event) {
        
        String ACCOUNT_SID = "AC8b47dd0c042a653ba0d449a1e2d3d44e";
        String AUTH_TOKEN = "1b9ac1ccff5f8aa227894a7b6f9a5e28";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21695565555"),
                new com.twilio.type.PhoneNumber("+14842473893"),
                "your payment is effected")
                .setMediaUrl(
                        Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))
                .create();

        System.out.println(message.getSid());
        
         Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
        ajoutdoneAlert.setTitle("Done");
        ajoutdoneAlert.setContentText("!!Check your phone SMS!!");
        ajoutdoneAlert.show();
    }
                
                
                
    
}
