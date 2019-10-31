/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Menu_productController implements Initializable {
    @FXML
    private Button ap;
    @FXML
    private Button allp;
    @FXML
    private AnchorPane ac;
    @FXML
    private Button rt;
    @FXML
    private Button bascket;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        btn.setOnAction(event->{
//            txt.setText("The first workshop :)))");
//        });
       
    }    
        @FXML
    void addproduct(ActionEvent event){
 
       /* ap.setOnAction(event->{
            try {
                Parent parent2=FXMLLoader.load(getClass().getResource("produit_a_vendre1.fxml"));
                
                Scene scene=new Scene(parent2);
                Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("In");
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(Menu_productController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });*/
  if (event.getTarget() == ap) {
            try {
               Stage stage = (Stage) ac.getScene().getWindow();
                System.err.println("bbb2");
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("Produit_a_vendre1.fxml"));
                 
                   
                ac.getChildren().clear();
                ac.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(Menu_productController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void rett(ActionEvent event) {
 if (event.getTarget() == rt) {
            try {
               Stage stage = (Stage) ac.getScene().getWindow();
                System.err.println("bbb2");
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("open.fxml"));
                 
                   
                ac.getChildren().clear();
                ac.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(Menu_productController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    void AFFICHAGE(ActionEvent event) {
        if (event.getTarget() == allp) {
            try {
               Stage stage = (Stage) ac.getScene().getWindow();
                System.err.println("bbb2");
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("ttlesproduits.fxml"));
                 
                   
                ac.getChildren().clear();
                ac.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(Menu_productController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void bascket(ActionEvent event) throws IOException {
           FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("produit.fxml"));
       
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Signup");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
    