package View.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class PayementController implements Initializable {

    @FXML
    private RadioButton bt_cash;
    @FXML
    private RadioButton bt_carte;
    @FXML
    private Button conf_pay;
    @FXML
    private ToggleGroup cc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void conf_pay(ActionEvent event) throws IOException {
        String message = "";
      if(bt_carte.isSelected()){
          message += bt_carte.getText();
          System.out.println(message);
        Parent root = FXMLLoader.load(getClass().getResource("carte.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Card payment");
        stage.setScene(scene);
        stage.show();
        }
      else 
          if(bt_cash.isSelected()){
              message += bt_cash.getText();
              System.out.println(message);
          
        Parent root = FXMLLoader.load(getClass().getResource("Numero.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("cash payment");
        stage.setScene(scene);
        stage.show();
               
          }
    
}
}


