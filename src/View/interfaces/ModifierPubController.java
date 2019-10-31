/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.Publication;
import Services.PublicationCRUD;
import static View.interfaces.AffichagePubController.pub;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierPubController implements Initializable {

    @FXML
    private TextArea text;
    @FXML
    private Button annuler;
    @FXML
    private Button enr;
    @FXML
    private ImageView imageee;
    @FXML
    private Button modifimage;
    
    final FileChooser fileChooser = new FileChooser();
    private String file_image;
    private Desktop desktop = Desktop.getDesktop();
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text.setText(AffichagePubController.pub.getContent());
        String x = pub.getImage();
                File file = new File("C:\\Users\\asus\\Documents\\NetBeansProjects\\JavaApplication1\\src\\blogfashion\\testpublication\\images" + x);
                Image image = new Image(file.toURI().toString());
                imageee.setImage(image);
    }    

    @FXML
    private void annuleeer(ActionEvent event) {
        try {

            Parent root;
            root = FXMLLoader.load(getClass().getResource("AffichagePub.fxml"));
            annuler.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichagePubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void enregistrer(ActionEvent event) throws IOException {
        PublicationCRUD ms = new PublicationCRUD();
        Publication p = new Publication();
        p.setPubID(pub.getPubID());
        p.setContent(text.getText());
        p.setImage(file_image);
        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        pathto = FileSystems.getDefault().getPath("C:\\Users\\asus\\Documents\\NetBeansProjects\\JavaApplication1\\src\\blogfashion\\testpublication\\images" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\asus\\Documents\\NetBeansProjects\\JavaApplication1\\src\\blogfashion\\testpublication\\images");

        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
        ms.updateM(p);
        System.out.println("tessst "+pub.getContent());
        try {

            Parent root;
            root = FXMLLoader.load(getClass().getResource("AffichagePub.fxml"));
            annuler.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichagePubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modif(ActionEvent event) throws IOException,SQLException {
        
        
         FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            imageee.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModifierPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    
}
