/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.Commentaire;
import Services.CommentaireCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DetailsWindowController1 implements Initializable {

    @FXML
    private TableView<Commentaire> tableC;
    @FXML
    private Button suppComment;
    public static ObservableList<Commentaire> com;
    CommentaireCRUD pss = new CommentaireCRUD();
    public static Commentaire an;
    @FXML
    private Button modifier;
    private Button retourajouter;
    @FXML
    private Button ajoutercommen;
    @FXML
    private Button complaints;
    @FXML
    private Button notificationsButton;
    @FXML
    private TextField textf;
    CommentaireCRUD cr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CommentaireCRUD cr = new CommentaireCRUD();
        ObservableList<Commentaire> list = cr.displayComments();
//        ObservableList<Commentaire> obs = FXCollections.observableArrayList(list);
//        
//        tableC.setItems(obs);
//        colUID.setCellValueFactory(new PropertyValueFactory<Commentaire,String> ("userID"));
//        colC.setCellValueFactory(new PropertyValueFactory<Commentaire,String> ("content"));
        //  ObservableList<Commentaire> list1 = cr.displayComments();
        //TableColumn id = new TableColumn("id");
        //id.setPrefWidth(100);
        //id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn userID = new TableColumn("userID");
        userID.setPrefWidth(100);
        userID.setCellValueFactory(new PropertyValueFactory<>("userID"));

        TableColumn content = new TableColumn("content");
        content.setPrefWidth(100);
        content.setCellValueFactory(new PropertyValueFactory<>("content"));

        TableColumn datecomment = new TableColumn("datecomment");
        datecomment.setPrefWidth(100);
        datecomment.setCellValueFactory(new PropertyValueFactory<>("datecomment"));

        tableC.setItems(list);
        tableC.getColumns().addAll(userID, content, datecomment);
        tableC.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableC.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

//                  String x = table.getSelectionModel().getSelectedItem().getPhoto();
//                  File file = new File ("C:\\Users\\ahmed\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java"+x);
//                  Image image = new Image (file.toURI().toString());
//                  impets.setImage(image);
            System.out.println(list);
            System.out.println(newSelection);
            if (newSelection != null) {
                an = newSelection;
            }
//                ajoutpanier.setOnAction(e->{
//            pss.inserta(newSelection);
//            System.out.println(newSelection);
            //AchatService ps4 = new AchatService();
        });
        textf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 try {
                    filter(oldValue, newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(DetailsWindowController1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                

    }
        public void filter(String oldValue, String newValue) throws SQLException {
            CommentaireCRUD c = new CommentaireCRUD();
        ObservableList<Commentaire> data = c.displayComments();
        
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) {
            tableC.setItems(data);
        } else {
            ObservableList<Commentaire> filter = FXCollections.observableArrayList();
            for (Commentaire r : data) {
                if (r.getContent().contains(newValue)) {
                    filter.add(r);
                }
            }
            tableC.setItems(filter);
        }
    }

    @FXML
    private void deleteComment(ActionEvent event) {
        if (tableC.getSelectionModel().getSelectedItem() != null) {
            CommentaireCRUD cr = new CommentaireCRUD();
            cr.supprimerCommentaire(tableC.getSelectionModel().getSelectedItem().getCommentID());
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("DetailsWindow1.fxml"));
                suppComment.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(DetailsWindowController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrez un commentaire");
            alert.showAndWait();
        }
    }



    @FXML
    private void modifier(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("modifier.fxml"));
            modifier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addcom(ActionEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Commentaire.fxml"));
            ajoutercommen.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addcomplain(ActionEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
            complaints.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onNotificationsButton(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Notifications.fxml"));
            notificationsButton.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
