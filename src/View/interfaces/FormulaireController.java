/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utils.Whatsapp;
import static utils.Whatsapp.ACCOUNT_SID;
import static utils.Whatsapp.AUTH_TOKEN;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class FormulaireController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXComboBox<String> role;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField number;
    @FXML
    private Button submit;
    @FXML
    private JFXTextField msg;
    @FXML
    private Button back;
   

    /**
     * Initializes the controller class.
     */
    
     public boolean controle_mail (String mail ) {
    if(mail.indexOf(" ")!=-1)
        return false ;
return ( Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail));}
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msg.setVisible(true);
         
        role.getItems().addAll("MEN","WOMEN" );
        
        
    }    

    @FXML
    private void submit(ActionEvent event) throws SQLException {
        
         UserService us = new UserService() ;
         Boolean exist=false;
           exist = us.existeUser(username.getText());
             

           
        if (username.getText().equals("")) {
            msg.setText("Username  invalid ");
            
        } else if (exist==true) {
            msg.setText("Username  already exists ");
            
        } else if (nom.getText().equals(""))
        {
            msg.setText("Last name invalid ");
        }
        else if (prenom.getText().equals(""))
        {
            msg.setText("First name invalid");
        }
        else if (!controle_mail(email.getText())) {
            msg.setText("email invalde");
        }
        else if (pass.getText().length()<5) {
            msg.setText("Your password must contain a minimum of 5 characters");
        }
        else if (prenom.getText().equals(""))
            
        {
            msg.setText("First name invalid");
        }
        else if (number.getText().length()!=8 || !number.getText().matches("[0-9]*") )
        {
            msg.setText("invalid Number");
        }
        else if (address.getText().equals(""))
        {msg.setText("invalid Address");}
        else {
            String z =role.getSelectionModel().getSelectedItem();
            User u = new User(username.getText(), nom.getText(), prenom.getText(), email.getText(), pass.getText(), address.getText(), number.getText(),z);
            UserService x = new UserService();
            x.AddUser(u);
            submit.setVisible(false);
            msg.setVisible(true);
            
            username.setEditable(false);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Registred");
            alert.setHeaderText("Welcome");
            alert.setContentText("Registration completed !");
            alert.showAndWait();
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:+216"+u.getNumtel()),
                    new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                    "Hello Fashionista welcome to our Blog 💖   "+u.getPrenom()+"   💖")
                    .create();
            
            System.out.println(message.getSid());
        }
    }
    
    public Alert getAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        return alert;
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("interface_princ.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("interface principale");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
