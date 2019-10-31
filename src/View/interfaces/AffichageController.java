/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.CurrentUser;
import Entities.User;
import Services.UserService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TablePosition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class AffichageController implements Initializable {

    @FXML
    private JFXButton export;
    @FXML
    private JFXTextField Username;
    @FXML
    private JFXTextField Sexe;
    @FXML
    private JFXTextField LastName;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField FirstName;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField email;
    @FXML
    private ListView<User> affichage;
    
    ObservableList<User> lista2;
    List<User> lst;
    @FXML
    private JFXTextField recherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UserService pr=new UserService();
        lista2 = FXCollections.observableArrayList(pr.ListUsers());
        
        //.setCellValueFactory(new PropertyValueFactory<>("titre"));
        
        affichage.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> param) { 
                return new AssociationListCell();
            }
        });
        affichage.setItems(lista2);
        
        affichage.setOnMouseClicked((event) -> {
            
            User p = (User)affichage.getSelectionModel().getSelectedItem();
            
            try{
            Username.setText(p.getUsername());
            FirstName.setText(p.getPrenom());
            LastName.setText(p.getNom());
            email.setText(p.getEmail());
            address.setText(p.getAdress());
            phone.setText(p.getNumtel());
            Sexe.setText(p.getRole());
            
            }catch(Exception ex){
                System.out.println("erreur");
            }
        });
        
         export.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent event) {
          
                String ad="C:\\Users\\Ghass\\Desktop\\List_users.pdf";
                Document doc=new Document();
                Alert dialogC = new Alert(Alert.AlertType.INFORMATION);
             dialogC.setTitle(" Confirmation ");
             dialogC.setHeaderText(null);
             dialogC.setContentText("Are you sure to export pdf ");
                          Optional<ButtonType> answer = dialogC.showAndWait();
               try {
                   PdfWriter.getInstance(doc, new FileOutputStream(ad));
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (DocumentException ex) {
                   Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
               }
               doc.open();
               try {
                    doc.add(new Paragraph("Blog Fashion"));
                    doc.add(new Paragraph("Users List"));
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                    LocalDateTime now = LocalDateTime.now();  
                    String d=dtf.format(now);
                    doc.add(new Paragraph("Date: "+d));
                    doc.add(new Paragraph(" "));
                    PdfPTable table = new PdfPTable(7);
                    PdfPCell c1=new PdfPCell(new Phrase("Username"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("First Name"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Last Name"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Sexe"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Email"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Phone"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Address"));
                    table.addCell(c1);
                    // table.setHeaderRows(0);
                    UserService s=new UserService();
                    ArrayList<User> e =(ArrayList<User>)s.ListUsers();
                    for(int i=0;i<e.size();i++)
                    {
                        String u=e.get(i).getUsername();
                        table.addCell(u);
                        String p=e.get(i).getPrenom();
                        table.addCell(p);
                        String nom=e.get(i).getNom();
                        table.addCell(nom);
                        String sexe=e.get(i).getRole();
                        table.addCell(sexe);
                        String em=e.get(i).getEmail();
                        table.addCell(em);
                        String ph=e.get(i).getNumtel();
                        table.addCell(ph);
                        String add=e.get(i).getAdress();
                        table.addCell(add);
                        
                    }
                    doc.add(table);
               }catch (DocumentException ex) {
                   Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
               }
               doc.close();
                }
        }) ;
    }    

    @FXML
    private void recherche(KeyEvent event) {
        UserService ps = new UserService();
        String msg = recherche.getText().concat("%");
        ArrayList<User> pers = (ArrayList<User>) ps.recherche(msg);
        ObservableList<User> obs1 = FXCollections.observableArrayList(pers);
        affichage.setItems(obs1);
    }

   
    
    
    private static class AssociationListCell extends ListCell<User> {
        private HBox content;
        private Text username;
        private Text lastname;
        private Text firstname;
        private Text email;
        private Text address;
        private Text phone;
        private Text sexe;
        private Label label1;
        private Label label2; 
        private Label label3;
        Button btnrem;
        
        private ImageView imge;
        javafx.scene.image.Image im;
        ObservableList<User> lista2;
         @FXML
    private JFXListView<User> listeView;
        public AssociationListCell() {
                    super();
            username = new Text();
            lastname = new Text();
            firstname= new Text();
            email =new Text();
            address =new Text();
            phone =new Text();
            sexe =new Text();
            
            
            imge = new ImageView();
            imge.setFitHeight(50);
            imge.setFitWidth(75);
            label1=new Label("Username : ");
            
            label3=new Label("Email : ");
             btnrem = new Button("Supprimer");
            
           VBox vBox = new VBox(new HBox(label1,username),new HBox(label3,email));
          
         
            vBox.setPrefWidth(250);
            content = new HBox(imge, vBox,btnrem);
            
            content.setSpacing(20);
        }
        UserService sa = new UserService();
        protected  void updateItem(User item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) {  
                username.setText(item.getUsername());
                firstname.setText(item.getPrenom()+"");
                phone.setText(item.getNumtel()+"");
                email.setText(item.getEmail()+"");
                
               
                btnrem.setOnAction((event) -> {
                    sa.DeleteUser(0);
                    Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
             dialogC.setTitle(" Confirmation ");
             dialogC.setHeaderText(null);
             dialogC.setContentText("Etes-vous sûr de vouloir supprimer "+item.getUsername());
                          Optional<ButtonType> answer = dialogC.showAndWait();
             if (answer.get() == ButtonType.OK) {
                        try {
                            //  int x = table.getSelectionModel().getSelectedItem().getId();
                            sa.DeleteUser(item.getId());
                            
                            
                            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                            
                            Parent root = FXMLLoader.load(getClass().getResource("./MainUI.fxml"));
                            
                            Scene scene = new Scene(root);
                            
                            stage.setScene(scene);
                            stage.show();   } catch (IOException ex) {
                            Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
                        }

     

      
                }});
                
                
               
                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }
    }

    
}
