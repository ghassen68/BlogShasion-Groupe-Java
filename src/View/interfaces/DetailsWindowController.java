package View.interfaces;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package blogfashion.testpublication.gui;
// 
//import blogfashion.testpublication.entities.Publication;
//import blogfashion.testpublication.entities.PublicationCRUD;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Base64;
//import static java.util.Collections.list;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javax.imageio.ImageIO;
//import sun.misc.BASE64Decoder;
//
///**
// * FXML Controller class
// *
// * @author HP
// */
//public class DetailsWindowController implements Initializable {
//
//    @FXML
//    private TableColumn<Publication, String> colUID;
//    @FXML
//    private TableColumn<Publication, ImageView> colP;
//    @FXML
//    private TableView<Publication> tableP;
//    @FXML
//    private Button suppPub;
//    @FXML
//    private Button modifierpublication;
//     
//    @FXML
//    private Button retour;
//    
//
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        
//// create a buffered image
//        PublicationCRUD cr = new PublicationCRUD();
//        ArrayList<Publication> list = (ArrayList<Publication>) cr.displayPub();
//        list.stream().forEach(tt->{
//            try {
//                tt.setImage(getImageFromString(tt.getContent()));
//            } catch (IOException ex) {
//                Logger.getLogger(DetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//        System.out.println(list);
//        ObservableList<Publication> obs = FXCollections.observableArrayList(list);
//        
//        
//        
//        tableP.setItems(obs);
//        colUID.setCellValueFactory(new PropertyValueFactory<Publication,String> ("userID"));
//        colP.setCellValueFactory(new PropertyValueFactory<Publication,ImageView> ("image"));
//        colP.setPrefWidth(200);
//        
//    }    
//
//    private ImageView getImageFromString (String value) throws IOException{
//        byte[] decoder = Base64.getDecoder().decode(value);
//        InputStream targetStream = new ByteArrayInputStream(decoder);
//
//   return new ImageView(new Image(targetStream));
//    }
//    @FXML
//    private void deletePub(ActionEvent event) {
//       if(tableP.getSelectionModel().getSelectedCells().size()==0){
//    showAlertWithoutHeaderText();
//    
//    }else{
//        showConfirmation();
//    } 
//    }
//     private void showAlertWithoutHeaderText() {
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("No Item Selected");
// 
//        // Header Text: null
//        alert.setHeaderText("plz Select item");
// 
//        alert.showAndWait();
//    }
//private void showConfirmation() {
// 
//      Alert alert = new Alert(AlertType.CONFIRMATION);
//      alert.setTitle("Delete post");
//      alert.setHeaderText("Are you sure want to move this file to the Recycle Bin?");
//         ButtonType ok = new ButtonType("OK");
//        ButtonType cancel = new ButtonType("Cancel");
//        
// 
//        // Remove default ButtonTypes
//        alert.getButtonTypes().clear();
//        alert.getButtonTypes().addAll(ok, cancel);
//      // option != null.
//      Optional<ButtonType> option = alert.showAndWait();
// 
//      if (option.get() == cancel) {
//      } else if (option.get() == ok) {
//          PublicationCRUD cr = new PublicationCRUD();
//        cr.supprimerPublication(tableP.getSelectionModel().getSelectedItem().getPubID());
//        Parent root;
//        try {
//            root=FXMLLoader.load(getClass().getResource("DetailsWindow.fxml"));
//               suppPub.getScene().setRoot(root);
//        } catch (IOException ex) {
//            Logger.getLogger(DetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//      } 
//   }
//
//@FXML
//    private void modifPub(ActionEvent event) {
//        
//        Parent root;
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificationPublication.fxml"));
//            root=loader.load();
//            PublicationController controller = loader.<PublicationController>getController();
//            controller.setModifPubId(tableP.getSelectionModel().getSelectedItem().getPubID());
//               suppPub.getScene().setRoot(root);
//        } catch (IOException ex) {
//            Logger.getLogger(DetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    /*
//    @FXML
//    
//    private void modifPub(ActionEvent event) {
//        
//        Parent root;
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificationPublication.fxml"));
//            root=loader.load();
//            PublicationController controller = loader.<PublicationController>getController();
//            controller.setModifPubId(tableP.getSelectionModel().getSelectedItem().getPubID());
//               suppPub.getScene().setRoot(root);
//        } catch (IOException ex) {
//            Logger.getLogger(DetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//*/
//     
//    
//    }