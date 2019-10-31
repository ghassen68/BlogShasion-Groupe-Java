/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import static Entities.Compteur.count;
import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import static utils.Whatsapp.ACCOUNT_SID;
import static utils.Whatsapp.AUTH_TOKEN;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class ChoixController implements Initializable {

    @FXML
    private AnchorPane signupqst11;
    @FXML
    private Button Login;
    @FXML
    private JFXTextField msg;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXComboBox<String> role;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField number;
    @FXML
    private Button submit;
    @FXML
    private JFXTextField msg1;
    @FXML
    private JFXPasswordField pass;
    public static int i=0 ;
      String[] quotes = {"\nThe joy of dressing is an art. \n —John Galliano"
          ,"\n Whoever said that money can't buy happiness, simply didn't know where to go shopping \n —Bo Derek"
              ,"\nOne is never over-dressed or under-dressed with a Little Black Dress. \n —Karl Lagerfeld"
                ,"\nI firmly believe that with the right footwear one can rule the world \n —Bette Midler"
                ,"\n When in doubt, wear red \n—Bill Blass"
                ,"\n In difficult times, fashion is always outrageous \n —Elsa Schiaparelli"
                , "\n I always find beauty in things that are odd and imperfect, they are much more interesting. \n —Marc Jacobs"
              ,"\n In order to be irreplaceable one must always be different \n —Coco Chanel"
              
        
            

        };

  public boolean controle_mail (String mail ) {
    if(mail.indexOf(" ")!=-1)
        return false ;
return ( Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail));}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       msg.setVisible(true);
      i=0;   
        role.getItems().addAll("MEN","WOMEN" );
        
        String[] suggestions = {"Agareb",
            "Aïn Draham",
            "Akouda",
            "Amdoun",
            "Ariana Ville",
            "Bab El Bhar",
            "Bab Souika",
            "Balta-Bou Aouane",
            "Bargou",
            "Béja Nord",
            "Béja Sud",
            "Bekalta",
            "Belkhir",
            "Bembla",
            "Ben Arous",
            "Ben Gardane",
            "Beni Hassen",
            "Béni Khalled",
            "Beni Khedache",
            "Béni Khiar",
            "Bir Ali Ben Khalifa",
            "Bir El Hafey",
            "Bir Lahmar",
            "Bir Mcherga",
            "Bizerte Nord",
            "Bizerte Sud",
            "Borj El Amri",
            "Bou Arada",
            "Bou Argoub",
            "Bou Hajla",
            "Bou Merdes",
            "Bou Mhel el-Bassatine",
            "Bou Salem",
            "Bouficha",
            "Carthage",
            "Cebbala Ouled Asker",
            "Chebba",
            "Chebika",
            "Chorbane",
            "Cité El Khadra",
            "Dahmani",
            "Dar Chaâbane El Fehri",
            "Degache",
            "Dehiba",
            "Djebel Jelloud",
            "Djedeida",
            "Djerba - Ajim",
            "Djerba - Houmt Souk",
            "Djerba - Midoun",
            "Douar Hicher",
            "Douz Nord",
            "Douz Sud",
            "Echrarda",
            "El Alâa",
            "El Alia",
            "El Amra",
            "El Aroussa",
            "El Ayoun",
            "El Batan",
            "El Fahs",
            "El Guettar",
            "El Hamma",
            "El Haouaria",
            "El Hencha",
            "El Jem",
            "El Kabaria",
            "El Krib",
            "El Ksar",
            "El Ksour",
            "El Menzah",
            "El Mida",
            "El Mourouj",
            "El Omrane",
            "El Omrane supérieur",
            "El Ouardia",
            "Enfida",
            "Essouassi",
            "Ettadhamen",
            "Ettahrir",
            "Ezzahra",
            "Ezzouhour",
            "Ezzouhour",
            "Faouar",
            "Fériana",
            "Fernana",
            "Fouchana",
            "Foussana",
            "Gaâfour",
            "Gabès Médina",
            "Gabès Ouest",
            "Gabès Sud",
            "Gafsa Nord",
            "Gafsa Sud",
            "Ghannouch",
            "Ghar El Melh",
            "Ghardimaou",
            "Ghezala",
            "Ghomrassen",
            "Goubellat",
            "Graïba",
            "Grombalia",
            "Haffouz",
            "Haïdra",
            "Hajeb El Ayoun",
            "Hammam Chott",
            "Hammam Ghezèze",
            "Hammam Lif",
            "Hammam Sousse",
            "Hammamet",
            "Hassi El Ferid",
            "Hazoua",
            "Hebira",
            "Hergla",
            "Hraïria",
            "Jebiniana",
            "Jedelienne",
            "Jemmal",
            "Jendouba Nord",
            "Jendouba Sud",
            "Jérissa",
            "Jilma",
            "Joumine",
            "Kairouan Nord",
            "Kairouan Sud",
            "Kalâa Kebira",
            "Kalâa Seghira",
            "Kalâat el-Andalous",
            "Kalâat Khasba",
            "Kalaat Senan",
            "Kasserine Nord",
            "Kasserine Sud",
            "Kébili Nord",
            "Kébili Sud",
            "Kef Est",
            "Kef Ouest",
            "Kélibia",
            "Kerkennah",
            "Kesra",
            "Kondar",
            "Korba",
            "Ksar Hellal",
            "Ksibet el-Mediouni",
            "Ksour Essef",
            "La Goulette",
            "La Manouba",
            "La Marsa",
            "La Soukra",
            "Le Bardo",
            "Le Kram",
            "Msaken",
            "Mahdia",
            "Mahres",
            "Majel Bel Abbes",
            "Makthar",
            "Mareth",
            "Mateur",
            "Matmata",
            "Mdhilla",
            "Medenine Nord",
            "Medenine Sud",
            "Medina",
            "Medina Jedida",
            "Medjez el-Bab",
            "Megrine",
            "Meknassy",
            "Melloulèche",
            "Menzel Bourguiba",
            "Menzel Bouzaiane",
            "Menzel Bouzelfa",
            "Menzel Chaker",
            "Menzel El Habib",
            "Menzel Jemil",
            "Menzel Temime",
            "Métlaoui",
            "Métouia",
            "Mezzouna",
            "Mnihla",
            "Mohamedia",
            "Moknine",
            "Monastir",
            "Mornag",
            "Mornaguia",
            "Moularès",
            "Nabeul",
            "Nadhour",
            "Nasrallah",
            "Nebeur",
            "Nefta",
            "Nefza",
            "Nouvelle Matmata",
            "Oued Ellil",
            "Oued Meliz",
            "Ouerdanine",
            "Oueslatia",
            "Ouled Chamekh",
            "Ouled Haffouz",
            "Radès",
            "Raoued",
            "Ras Jebel",
            "Redeyef",
            "Regueb",
            "Remada",
            "Rouhia",
            "Sahline",
            "Sakiet Eddaïer",
            "Sakiet Ezzit",
            "Sakiet Sidi Youssef",
            "Saouaf",
            "Sayada-Lamta-Bou Hajar",
            "Sbeïtla",
            "Sbiba",
            "Sbikha",
            "Sejnane",
            "Séjoumi",
            "Sened",
            "Sers",
            "Sfax Ouest",
            "Sfax Sud",
            "Sfax Ville",
            "Sidi Aïch",
            "Sidi Ali Ben Aoun",
            "Sidi Alouane",
            "Sidi Bou Ali",
            "Sidi Bou Rouis",
            "Sidi Bouzid Est",
            "Sidi Bouzid Ouest",
            "Sidi El Béchir",
            "Sidi El Hani",
            "Sidi Hassine",
            "Sidi Makhlouf",
            "Sidi Thabet",
            "Siliana Nord",
            "Siliana Sud",
            "Skhira",
            "Smâr",
            "Soliman",
            "Souk Jedid",
            "Souk Lahad",
            "Sousse Jawhara",
            "Sousse Médina",
            "Sousse Riadh",
            "Sousse Sidi Abdelhamid",
            "Tabarka",
            "Tajerouine",
            "Takelsa",
            "Tameghza",
            "Tataouine Nord",
            "Tataouine Sud",
            "Téboulba",
            "Tebourba",
            "Téboursouk",
            "Testour",
            "Thala",
            "Thibar",
            "Thyna",
            "Tinja",
            "Tozeur",
            "Utique",
            "Zaghouan",
            "Zarzis",
            "Zarzouna",
            "Zéramdine",
            "Zriba"

        };
        TextFields.bindAutoCompletion(address, suggestions);
        
      
     
        
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
                 FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("choix2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void submit(ActionEvent event) throws IOException, SQLException {
          UserService us = new UserService() ;
         Boolean exist=false;
           exist = us.existeUser(username.getText());
             

           
        if (username.getText().equals("")) {
            msg.setText("Username  invalid ");
            
        } else if (exist==true) {
            msg.setText("Username  already exists ");
            
        } else if (nom.getText().equals(""))
        {
            msg.setText("Last name invalid ");
        }
        else if (prenom.getText().equals(""))
        {
            msg.setText("First name invalid");
        }
        else if (!controle_mail(email.getText())) {
            msg.setText("email invalde");
        }
        else if (pass.getText().length()<5) {
            msg.setText("Your password must contain a minimum of 5 characters");
        }
        else if (prenom.getText().equals(""))
            
        {
            msg.setText("First name invalid");
        }
        else if (number.getText().length()!=8 || !number.getText().matches("[0-9]*") )
        {
            msg.setText("invalid Number");
        }
        else if (address.getText().equals(""))
        {msg.setText("invalid Address");}
        else {
            String z =role.getSelectionModel().getSelectedItem();
            User u = new User(username.getText(), nom.getText(), prenom.getText(), email.getText(), pass.getText(), address.getText(), number.getText(),z);
            UserService x = new UserService();
            x.AddUser(u);
            submit.setVisible(false);
            msg.setVisible(true);
            
            username.setEditable(false);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Registred");
            alert.setHeaderText("Welcome");
            alert.setContentText("Registration completed !");
            alert.showAndWait();
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:+216"+u.getNumtel()),
                    new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                    "Hello "+u.getPrenom()+","+" welcome to the land of Fashionista 💖  "+quotes[count])
                    .create();
            System.out.println(message.getSid());
            if (count>7)
            {count=0;}
            else 
            {count++;
            }
           
             FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("choix2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
    }
    
    public Alert getAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        return alert;

    }
    
}
