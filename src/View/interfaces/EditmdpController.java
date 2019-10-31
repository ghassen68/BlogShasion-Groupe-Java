/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.SendingMail;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class EditmdpController implements Initializable {

    @FXML
    private JFXButton sendmdp;
    @FXML
    private JFXTextField username;
    @FXML
    private Text verif;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
      @FXML
     private void sendmdp(ActionEvent event) throws SQLException, IOException {
        int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 9;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
        int randomLimitedInt = leftLimit + (int) 
          (random.nextFloat() * (rightLimit - leftLimit + 1));
        buffer.append((char) randomLimitedInt);
    }
    String generatedString = buffer.toString();
        UserService x = new UserService () ;
                
        if (username.getText().equals("")) {
            verif.setText("veuillez saisir votre username");
        }
        else if (!x.existeUser(username.getText())) {
            verif.setText("ivalid Username ");
        }
        else {
        SendingMail sm =new SendingMail("your password has been reset  , you can now login  with : \n password="+ generatedString,x.getUserByUsername(username.getText()).getEmail(), "New Password");
       SendingMail.envoyer();
       x.modifierPassword(username.getText(), generatedString);
        verif.setText("veuillez consulter votre Email");
        
         FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("choix2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
        
        
        }
     }  

    @FXML
    private void back(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("choix2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }
          
    } 

