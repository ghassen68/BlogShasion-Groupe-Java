/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.CurrentUser;
import static Entities.CurrentUser.password;
import Entities.User;
import Services.BCrypt;
import Services.UserService;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class UpdateUserController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField address;
    @FXML
    private Button update;
    @FXML
    private JFXTextField msg;
    @FXML
    private JFXPasswordField oldmdp;
    @FXML
    private Button updatepassword;
    @FXML
    private JFXPasswordField newpassword;
    @FXML
    private JFXTextField msgmdp;
    @FXML
    private JFXPasswordField confirmation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(CurrentUser.username); 
        nom.setText(CurrentUser.nom);    
        prenom.setText(CurrentUser.prenom);    
        email.setText(CurrentUser.email);    
        phone.setText(CurrentUser.numtel);    
        address.setText(CurrentUser.adress);    


    }    
 public boolean controle_mail (String mail ) {
    if(mail.indexOf(" ")!=-1)
        return false ;
return ( Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail));}
    @FXML
    private void update(ActionEvent event) throws SQLException {
        
          UserService us = new UserService() ;
         Boolean exist=false;
           exist = us.existeUser(username.getText());
    if (username.getText().equals("")) {
            msg.setText("Username  invalid ");
            
//        } else if (exist==true) {
//            msg.setText("Username  already exists ");
//            
        } else if (nom.getText().equals(""))
        {
            msg.setText("Last name invalid ");
        }
        else if (prenom.getText().equals(""))
        {
            msg.setText("First name invalid");
        }
       
      
        else if (phone.getText().length()!=8 || !phone.getText().matches("[0-9]*") )
        {
            msg.setText("invalid Number");
        }
        else if (address.getText().equals(""))
        {msg.setText("invalid Address");}
        else {
        User s = new User(CurrentUser.id, username.getText(), nom.getText(), prenom.getText(), email.getText(), address.getText(), phone.getText());
            us.UpdateUser(s);
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Update");
            alert.setHeaderText("Welcome");
            alert.setContentText("Update completed !");
            alert.showAndWait();
            
    }
    } 

    @FXML
    private void updatepassword(ActionEvent event) throws SQLException {
                UserService x = new UserService () ;
            
             
                if ( !BCrypt.checkpw(oldmdp.getText(), CurrentUser.password) )
                {         msgmdp.setText("incorret password ");
                }
                else 
                {  
                    
                    if (newpassword.getText().length()<5) {
            msgmdp.setText("invalid password");
                
    }
                    else if(!newpassword.getText().equals(confirmation.getText()))
                            {msgmdp.setText("wrong confirmation !! ");}
                    else {
                    {x.modifierPassword(CurrentUser.username, newpassword.getText());
                 Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Update");
            alert.setHeaderText("Welcome");
            alert.setContentText("Password Updated !");
            alert.showAndWait();

                    }
                    }
                }
    }
}
