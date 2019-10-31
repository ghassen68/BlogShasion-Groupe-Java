/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.Publication;
import Services.PublicationCRUD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AffichagePubController implements Initializable {

    @FXML
    private TableView<Publication> tab;
    @FXML
    private ImageView img;
    @FXML
    private Button retour;
    public static Publication pub;
    @FXML
    private Button supp;
    @FXML
    private Button modif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PublicationCRUD ps = new PublicationCRUD();
        ObservableList<Publication> list1 = ps.readAllDV();
        TableColumn username = new TableColumn("username");
        username.setPrefWidth(100);
        username.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn content = new TableColumn("content");
        content.setPrefWidth(500);
        content.setCellValueFactory(new PropertyValueFactory<>("content"));

        tab.setItems(list1);
        tab.getColumns().addAll(username, content);
        tab.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tab.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            System.out.println(newSelection);

            if (newSelection != null) {
                String x = tab.getSelectionModel().getSelectedItem().getImage();
                File file = new File("C:\\Users\\asus\\Documents\\NetBeansProjects\\JavaApplication1\\src\\blogfashion\\testpublication\\images" + x);
                Image image = new Image(file.toURI().toString());
                img.setImage(image);
                pub = newSelection;
                System.out.println("id: " + newSelection.getPubID());

            }

        });

    }

    @FXML
    private void retour(ActionEvent event) {
        try {

            Parent root;
            root = FXMLLoader.load(getClass().getResource("Publication.fxml"));
            retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichagePubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Suppp(ActionEvent event) {
        PublicationCRUD ms = new PublicationCRUD();
        ms.deleteM(tab.getSelectionModel().getSelectedItem().getPubID());
        refreshTableDV(event);
        
    }

    @FXML
    private void btnModif(ActionEvent event) {
        try {

            Parent root;
            root = FXMLLoader.load(getClass().getResource("ModifierPub.fxml"));
            modif.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(PublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void refreshTableDV(Event event) {
        tab.setItems(null);
        tab.getColumns().clear();
        PublicationCRUD ps = new PublicationCRUD();
        ObservableList<Publication> list1 = ps.readAllDV();

        TableColumn username = new TableColumn("username");
        username.setPrefWidth(100);
        username.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn content = new TableColumn("content");
        content.setPrefWidth(500);
        content.setCellValueFactory(new PropertyValueFactory<>("content"));

        tab.setItems(list1);
        tab.getColumns().addAll(username, content);
        tab.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tab.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            System.out.println(newSelection);
            if (newSelection != null) {
               

            }
        });
    }

    @FXML
    private void commenter(ActionEvent event) {
        
        
    }

}
