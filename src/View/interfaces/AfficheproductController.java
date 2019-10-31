/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.product;
import Services.productCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AfficheproductController implements Initializable {
public static String p1;
public static String p2;
public static String p3;
public static String p4;
public static String p5;
public static double p6;
public static String p7;
public static String p8;
public static product modifiedproduct;

@FXML
    private AnchorPane aaa;

    @FXML
    private TableView<product> tv;
    
     @FXML
    private TableColumn<product,String> cat;
    @FXML
    private TableColumn<product,String> typ;

    @FXML
    private TableColumn <product,String> marq;

    @FXML
    private TableColumn <product,String> col;

    @FXML
    private TableColumn <product,String> siz;

    @FXML
    private TableColumn <product,Double> pric;

    @FXML
    private TableColumn <product,String> desc;
    @FXML
    private TableColumn<product,String> genr;
    @FXML
    private Button issup;
  @FXML
    private Button updateprod;

 @FXML
    private TextField recherche;
 
    @FXML
    private Button imprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productCRUD es = new productCRUD();
        // System.out.println("fxml.AfficherEController.initialize()");
        ArrayList<product> arrayList = null;
        arrayList = (ArrayList<product>) es.displayproduct();
        ObservableList obs = FXCollections.observableArrayList(arrayList);
        tv.setItems(obs);
        pric.setCellValueFactory(new PropertyValueFactory<product, Double>("price_P"));
        desc.setCellValueFactory(new PropertyValueFactory<product, String>("description_p"));
        cat.setCellValueFactory(new PropertyValueFactory<product, String>("Cat_P"));
        typ.setCellValueFactory(new PropertyValueFactory<product, String>("type_P"));
        marq.setCellValueFactory(new PropertyValueFactory<product, String>("marque_P"));
        col.setCellValueFactory(new PropertyValueFactory<product, String>("color_P"));
        siz.setCellValueFactory(new PropertyValueFactory<product, String>("size_P"));
        genr.setCellValueFactory(new PropertyValueFactory<product, String>("genre_P"));
     
      
    }    

    @FXML
    private void delate(ActionEvent event) {
        product song = tv.getSelectionModel().getSelectedItem();
        System.out.println(song);
        productCRUD e = new productCRUD();
        tv.getItems().removeAll(tv.getSelectionModel().getSelectedItem());
        if (song != null) {
            JOptionPane.showMessageDialog(null, "Article Supprimee");
            e.supprimerproduct(song);
        }
    }
   @FXML
    void modifierproduit(ActionEvent event) {
        product song = tv.getSelectionModel().getSelectedItem();
 modifiedproduct = song ;

 productCRUD e = new productCRUD();
 if (song != null){

                p1=song.getCat_p();
                p2=song.getType_p();
                p3=song.getMarque_P();
                p4=song.getColor_P();
                p5=song.getSize_P();
                p6=song.getPrice_P();
                p7=song.getDescription_p();
                p8=song.getGenre_P();
                
                
                
                
            if (event.getTarget() == updateprod) {
            try {
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("detailproduct.fxml"));
                aaa.getChildren().clear();
                aaa.getChildren().add(newLoadedPane);
          
            } catch (IOException ex) {
                Logger.getLogger(AfficheproductController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
   }
        

    } 
     @FXML
    void rechercheproduct(KeyEvent event) throws SQLException {
        productCRUD fs = new productCRUD();
        ArrayList<product> formations = new ArrayList<>();
        formations = (ArrayList<product>) fs.rechercheproduct(
                recherche.getText());
       
        ObservableList obs = FXCollections.observableArrayList(formations);
        tv.setItems(obs);
        cat.setCellValueFactory(new PropertyValueFactory<product, String>("Cat_P"));
        typ.setCellValueFactory(new PropertyValueFactory<product, String>("type_P"));
        marq.setCellValueFactory(new PropertyValueFactory<product, String>("marque_P"));
        col.setCellValueFactory(new PropertyValueFactory<product, String>("color_P"));
        siz.setCellValueFactory(new PropertyValueFactory<product, String>("size_P"));
        pric.setCellValueFactory(new PropertyValueFactory<product, Double>("price_P"));
       desc.setCellValueFactory(new PropertyValueFactory<product, String>("description_p"));
       genr.setCellValueFactory(new PropertyValueFactory<product, String>("genre_p"));
      
    }
     @FXML
    void print(ActionEvent event) {
        System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(primaryStage); 
            
    Node root = this.tv;
           job.printPage(root);
           job.endJob();

    }
    }

    }



