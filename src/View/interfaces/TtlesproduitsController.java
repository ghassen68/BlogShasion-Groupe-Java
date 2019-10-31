/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.product;
import Services.productCRUD;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class TtlesproduitsController implements Initializable {

    @FXML
    private AnchorPane aaa;
    @FXML
    private TableView<product> ttv;
    @FXML
    private TableColumn<product,String> catt;
    @FXML
    private TableColumn<product,String> typt;
    @FXML
    private TableColumn<product,String> marqt;
    @FXML
    private TableColumn<product,String> coltt;
    @FXML
    private TableColumn<product,String> sizt;
    @FXML
    private TableColumn<product,Double> prict;
    @FXML
    private TableColumn<product,String> desct;
     @FXML
    private TableColumn<product,String> genrt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
     productCRUD es = new productCRUD();
        // System.out.println("fxml.AfficherEController.initialize()");
        ArrayList<product> arrayList = null;
        arrayList = (ArrayList<product>) es.displayproduct();
        ObservableList obs = FXCollections.observableArrayList(arrayList);
        ttv.setItems(obs);
        catt.setCellValueFactory(new PropertyValueFactory<product, String>("Cat_P"));
        typt.setCellValueFactory(new PropertyValueFactory<product, String>("type_P"));
        marqt.setCellValueFactory(new PropertyValueFactory<product, String>("marque_P"));
        coltt.setCellValueFactory(new PropertyValueFactory<product, String>("color_P"));
        sizt.setCellValueFactory(new PropertyValueFactory<product, String>("size_P"));
        prict.setCellValueFactory(new PropertyValueFactory<product, Double>("price_P"));
       desct.setCellValueFactory(new PropertyValueFactory<product, String>("description_p"));
       genrt.setCellValueFactory(new PropertyValueFactory<product, String>("genre_p"));
      
    }    
    
}
