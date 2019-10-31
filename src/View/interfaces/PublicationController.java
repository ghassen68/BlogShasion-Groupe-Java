
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.Publication;
import Services.PublicationCRUD;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
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
import java.util.Base64;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import static javax.xml.crypto.dsig.Transform.BASE64;
import sun.misc.BASE64Encoder;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PublicationController implements Initializable {

    final FileChooser fileChooser = new FileChooser();
    private String file_image;
    private Desktop desktop = Desktop.getDesktop();
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;

    @FXML
    private TextField userID;
    @FXML
    private TextArea zonepublication;
    @FXML
    private Button ajouterpublication;

    @FXML
    private ImageView imageView;

    private int modifPubId;

    private String base64;
    //private int modifPubId;
    @FXML
    private ImageView image;

    @FXML
    private Button uploadImage;
    @FXML
    private Button aff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//    private void openPhoto(ActionEvent event) {
//
//        JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
//        chooser.setApproveButtonText("Choix du fichier..."); //intitulé du bouton
//        chooser.showOpenDialog(null); //affiche la boite de dialogue
//        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//            String fileName = chooser.getSelectedFile().getAbsolutePath().toString();
//            fileName.replace("\\", "/");
//            fileName = "file:///" + fileName;
//            File file = new File(chooser.getSelectedFile().getAbsolutePath().toString());
//            base64 = encodeFileToBase64Binary(chooser.getSelectedFile());
//
//            imageView.setImage(new Image(fileName));
//
//        }
//    }
//
//    private static String encodeFileToBase64Binary(File file) {
//        String encodedfile = null;
//        try {
//            FileInputStream fileInputStreamReader = new FileInputStream(file);
//            byte[] bytes = new byte[(int) file.length()];
//            fileInputStreamReader.read(bytes);
//            encodedfile = new String(Base64.getEncoder().encode(bytes), "UTF-8");
//            //encodedfile = Base64.getEncoder().encode(bytes).toString();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//
//        }
//
//        return encodedfile;
//    }
    @FXML
    private void addpublication(ActionEvent event) throws SQLException, IOException {

        PublicationCRUD pc = new PublicationCRUD();
        Publication p = new Publication();
        p.setUsername(userID.getText());
        p.setContent(zonepublication.getText());

        p.setImage(file_image);
        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        
        pathto = FileSystems.getDefault().getPath("C:\\Users\\Ghass\\Documents\\NetBeansProjects\\pi final\\PI\\src\\View\\image" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\Ghass\\Documents\\NetBeansProjects\\pi final\\PI\\src\\View\\image");

        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
        pc.ajouterPublication(p);
        
        try {
             

                Parent root;
                root = FXMLLoader.load(getClass().getResource("AffichagePub.fxml"));
                ajouterpublication.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(PublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
         
    }

//        Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("DetailsWindow.fxml"));
//            ajouterpublication.getScene().setRoot(root);
//        } catch (IOException ex) {
//            Logger.getLogger(PublicationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    @FXML
    private void uploadImage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            image.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnaff(ActionEvent event) throws IOException,SQLException {
        
       try {

                Parent root;
                root = FXMLLoader.load(getClass().getResource("AffichagePub.fxml"));
                aff.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(PublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        

       
    }
}

//    @FXML
//    private void modifpublication(ActionEvent event) {
//
//        PublicationCRUD pc = new PublicationCRUD();
//        Publication p = pc.getById(modifPubId);
//
//        p.setContent(modifPubArea.getText());
//
//        pc.modifierPublication(p, modifPubId);
//
//        Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("DetailsWindow.fxml"));
//            modifPubArea.getScene().setRoot(root);
//        } catch (IOException ex) {
//            Logger.getLogger(PublicationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    void setModifPubId(int pubID) {
//        this.modifPubId = pubID;
//        PublicationCRUD pc = new PublicationCRUD();
//        Publication p = pc.getById(pubID);
//        modifPubArea.setText(p.getContent());
//    }
//    @FXML
//    private void retour(ActionEvent event) {
//        Parent root;
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsWindow.fxml"));
//        try {
//            root = loader.load();
//            retour.getScene().setRoot(root);
//
//        } catch (IOException ex) {
//            Logger.getLogger(DetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

