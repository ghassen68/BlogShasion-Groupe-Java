/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.CurrentUser;
import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.SendingMail;
import static utils.Whatsapp.ACCOUNT_SID;
import static utils.Whatsapp.AUTH_TOKEN;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class LoginMenuController implements Initializable {

    @FXML
    private JFXTextField user_name;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private Button btn_login;
    @FXML
    private JFXButton forgotten;
    @FXML
    private JFXTextField verif;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_login_signal(ActionEvent event) throws IOException, SQLException {
        UserService x = new UserService();
        if (user_name.getText().equals("")) {
            verif.setText("veuillez saisir votre email");
        }
        else if (pass.getText().equals("")){ 
            verif.setText("veuillez saisir votre mot de passe");
        }
        else if( !x.login(user_name.getText(),pass.getText())) {
           verif.setText("cordonnées invalides");
        }
        else {
                    CurrentUser cu=new CurrentUser(x.getUserByUsername(user_name.getText())) ;
 System.out.println(CurrentUser.id+CurrentUser.username);
        FXMLLoader fxmlLoader = new FXMLLoader();
     if (CurrentUser.role.equals("admin"))
             {
        fxmlLoader.setLocation(getClass().getResource("MainUI.fxml"));
       
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin Interface");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
       
        }
     else 
     {
       fxmlLoader.setLocation(getClass().getResource("UserInterface.fxml"));
       
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("User Interface");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();   
    }
    }
    }

    @FXML
    private void forgotten_signal(ActionEvent event) throws  IOException {
      {
          FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editmdp.fxml"));
       
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Forgotten Password");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    
    }
     
          
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
