/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ghass
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            
         Parent root = FXMLLoader.load(getClass().getResource("choix2.fxml"));
        
        Scene scene = new Scene(root);
         stage.setTitle("LogIn");
        stage.setScene(scene);
        stage.show();
    }
        catch(IOException ex){
            System.out.println(ex);
        }}
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
