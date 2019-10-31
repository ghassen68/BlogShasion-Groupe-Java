/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.product;
import Services.productCRUD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Produit_a_vendre1Controller implements Initializable {
    @FXML
    private AnchorPane ab;

    @FXML
    private TextField DESCRIPTION;
    @FXML
    private ComboBox<String> catégorie;
    @FXML
    private ComboBox<String> taille;
    @FXML
    private TextField marque;
    @FXML
    private ComboBox<String> color;
     @FXML
    private ComboBox<String> genre;
   @FXML
    private Spinner<Double> price;
    @FXML
    private Button ajouterproductt;
    @FXML
    private Button vv;
    @FXML
    private Button ret;
    @FXML
    private Button em;
       @FXML
    private TextField typp;
     @FXML
    private ImageView typee;
   
    private File file;
    @FXML
    private Button btn_pic;
    String imageFile1;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           // SpinnerValueFactory<Integer> grade = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
         // price.setValueFactory(grade);
   // SpinnerValueFactory<Double>  gardeFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 100.00, 0.00);
       // this.price.setValueFactory(gardeFactory);
       
           
               
           
    this.price.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 100.0,10.5, 0.1));
      
    color.getItems().addAll("white","red","green","black","yellow","blue","pink","orange","purple");
    catégorie.getItems().addAll("clothes","accessories","shoes","makeup","bag","jewelry");
    taille.getItems().addAll("xs","s","m","l","xl","xxl","xxxl","xxxxl");
    genre.getItems().addAll("men","women","baby","girl","boy");
    
    
    }    

    @FXML
    private void ajouterproduct(ActionEvent event) {
        
        
        
        
    
          //  product song = ttable.getSelectionModel().getSelectedItem();
          product p = new product();
 //System.out.println(song);
  productCRUD myTool = new productCRUD();
  //Image1=new type_P(file.toURI().toURL().toString());
              

          try {
                 JOptionPane.showMessageDialog(null,"ajout");
                 
   
            p.setCat_p(catégorie.getSelectionModel().getSelectedItem());
            p.setType_p(typp.getText());
           
            p.setMarque_P(marque.getText());
            p.setColor_P(color.getSelectionModel().getSelectedItem());
            p.setSize_P(taille.getSelectionModel().getSelectedItem());
            double a = (double) price.getValue();
            p.setPrice_P(a);
            p.setDescription_p(DESCRIPTION.getText());
             p.setGenre_P(genre.getSelectionModel().getSelectedItem());
                
            myTool.ajouterproduct(p);
        } catch (SQLException ex) {
            Logger.getLogger(Produit_a_vendre1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @FXML
    void affichagep(MouseEvent event) {

    }

    @FXML
    void affichagepr(ActionEvent event) {

   
  if (event.getTarget() == vv) {
            try {
               Stage stage = (Stage) ab.getScene().getWindow();
                System.err.println("bbbb2");
                 AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("afficheproduct.fxml"));
                 
                   
               ab.getChildren().clear();
               ab.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(Produit_a_vendre1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        
        
   // }
        //System.err.println(info);
            
          
    /*
    product p = new product();
      productCRUD myTool = new productCRUD();
   
    p.setDescription_p(DESCRIPTION.getText());
    p.setType_p(type.getText());
    p.setCat_p(catégorie.getSelectionModel().getSelectedItem());
    p.setSize_P(taille.getSelectionModel().getSelectedItem());
    p.setColor_P(color.getSelectionModel().getSelectedItem());  
    p.setMarque_P(marque.getText());
    p.setPrice_P(price.getValue(););
    myTool.ajouterproduct(p);

*/
     @FXML
    void preturn(ActionEvent event) {
if (event.getTarget() == ret) {
            try {
               Stage stage = (Stage) ab.getScene().getWindow();
                System.err.println("bbb2");
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("menu_product.fxml"));
                 
                   
                ab.getChildren().clear();
                ab.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(Produit_a_vendre1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     @FXML
    void sendmail(ActionEvent event) {
if (event.getTarget() == em) {
            try {
               Stage stage = (Stage) ab.getScene().getWindow();
                System.err.println("bbb2");
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("emaill.fxml"));
                 
                   
                ab.getChildren().clear();
                ab.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(Produit_a_vendre1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void CopyImage(String url, String imageDestination) throws IOException {

        //URL l'emplacement de fichier image sous wamp exemple (http://localhost/image/product)
        InputStream inputStream = new FileInputStream(imageDestination);//upload l'image
        System.out.println("Start uploading second file");

        OutputStream output = new FileOutputStream(url);
        byte[] bytesIn = new byte[4096];
        int read = 1;
        while ((read = inputStream.read(bytesIn)) != -1) {//copier l'image au serveur
            output.write(bytesIn, 0, read);
        }
        output.close();
        inputStream.close();
    }
    
@FXML
    void upload(ActionEvent event) throws IOException {
        
      FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {

            Image image = new Image(selectedFile.toURI().toString());
            typee.setImage(image);
            imageFile1 = selectedFile.getName();
            int pos = imageFile1.lastIndexOf("/");
            if (pos > 0) {
                imageFile1 = imageFile1.substring(0, pos);
            }
            typee.setImage(image);
            String emplacement = "C:\\wamp64\\www\\image\\" + imageFile1;
            System.out.println(emplacement);
            CopyImage(emplacement, selectedFile.toPath().toString());

        } else {
            System.out.println("file doesn't exist");
}
            
        
    }     
        
        

    
      
}
