/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.interfaces;

import Entities.CurrentUser;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ghass
 */
public class UserInterfaceController implements Initializable{

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private HBox Navbar;
    @FXML
    private HBox HboxManagement;
    @FXML
    private Text SECOND;
    @FXML
    private HBox HboxStatis;
    @FXML
    private Text HboxStats;
    @FXML
    private HBox HboxManagement1;
    @FXML
    private Text SECOND1;
    @FXML
    private ImageView menu;
    @FXML
    private HBox hboxlogo;
    @FXML
    private Text copyrighttext;
    @FXML
    private Separator sep;
    @FXML
    private Text username;
    @FXML
    private ImageView profile;
    @FXML
    private HBox AnimationHBOX;
    @FXML
    private Text ROLE;
    @FXML
    private Pane Pane;
    @FXML
    private AnchorPane SecondScene;
    
    public final Interpolator WEB_EASE = Interpolator.SPLINE(0.25, 0.1, 0.25, 1);
    private static boolean Loaded=false;
    private Boolean Navplayed=false;
    @FXML
    private HBox HboxLogout;
    @FXML
    private Text SECOND11;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText(CurrentUser.username);    
        menu.setOnMousePressed(e1 ->{
			navbartransition();
		});
        
        HboxManagement.setOnMousePressed(e -> {
            LoadSecondScene("DetailsWindow1.fxml");
            WobbleAnimation(HboxManagement,50);
            Loaded =false;
	});
       
        HboxStatis.setOnMousePressed(e -> {
            LoadSecondScene("UserList.fxml");
            WobbleAnimation(HboxManagement,50);
            Loaded =false;
	});
        HboxManagement1.setOnMousePressed(e -> {
            LoadSecondScene("menu_product.fxml");
            WobbleAnimation(HboxManagement,50);
            Loaded =false;
            });
        profile.setOnMousePressed(e1 ->{
			LoadSecondScene("UpdateUser.fxml");
            WobbleAnimation(profile,50);
            Loaded =false;
        });
        HboxLogout.setOnMousePressed(e -> {
    CurrentUser.id=-1;
    CurrentUser.username=null;
    CurrentUser.nom=null ;
    CurrentUser.prenom=null ; 
    CurrentUser.email=null ;
    CurrentUser.password=null;
    CurrentUser.role=null;
    CurrentUser.adress=null;
    CurrentUser.numtel=null;
    CurrentUser.image=null;
    CurrentUser.sexe=null;
    
      FXMLLoader fxmlLoader = new FXMLLoader();

     fxmlLoader.setLocation(getClass().getResource("choix2.fxml"));
        /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene;
            try {
                Stage stage = new Stage();
        stage.setTitle("Connexion");
                scene = new Scene(fxmlLoader.load());
                 stage.setScene(scene);
                  stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MainUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       
       ((Node)(e.getSource())).getScene().getWindow().hide();
    
	});
    }
    
    public void LoadSecondScene(String scenee){
		
		Parent root;
		try {
			if (Loaded==false){
				Loaded=true;
			root = FXMLLoader.load(getClass().getResource("./"+scenee));
			Scene scene = SecondScene.getScene();
	        //root.translateYProperty().set(scene.getHeight());
                SecondScene.getChildren().clear();
	        SecondScene.getChildren().add(root);
                

	        Timeline timeline = new Timeline();
	        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
	        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
	        timeline.getKeyFrames().add(kf);
	        timeline.play();
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PulseAnimation(AnimationHBOX);
		BounceOutAnimation(ROLE);
		
        
	}
        
        public void PulseAnimation(Node node) {
        
        
		Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), 
                    new KeyValue(node.scaleXProperty(), 1, WEB_EASE),
                    new KeyValue(node.scaleYProperty(), 1, WEB_EASE)
                ),
                new KeyFrame(Duration.millis(500), 
                    new KeyValue(node.scaleXProperty(), 1.1, WEB_EASE),
                    new KeyValue(node.scaleYProperty(), 1.1, WEB_EASE)
                ),
                new KeyFrame(Duration.millis(1000), 
                    new KeyValue(node.scaleXProperty(), 1, WEB_EASE),
                    new KeyValue(node.scaleYProperty(), 1, WEB_EASE)
                )
        );
        
		timeline.setDelay(Duration.seconds(0.2));
		timeline.play();
    }
        
        
        public void BounceInAnimation(Node node) {
	       
	        
	        Timeline timeline  = new Timeline(
	                new KeyFrame(Duration.millis(0),    
	                    new KeyValue(node.opacityProperty(), 0, WEB_EASE),
	                    new KeyValue(node.scaleXProperty(), 0.3, WEB_EASE),
	                    new KeyValue(node.scaleYProperty(), 0.3, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(500),    
	                    new KeyValue(node.opacityProperty(), 1, WEB_EASE),
	                    new KeyValue(node.scaleXProperty(), 1.05, WEB_EASE),
	                    new KeyValue(node.scaleYProperty(), 1.05, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(700),    
	                    new KeyValue(node.scaleXProperty(), 0.9, WEB_EASE),
	                    new KeyValue(node.scaleYProperty(), 0.9, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(1000),    
	                    new KeyValue(node.scaleXProperty(), 1, WEB_EASE),
	                    new KeyValue(node.scaleYProperty(), 1, WEB_EASE)
	                )
	        );
	        
	        timeline.setDelay(Duration.seconds(0.2));
	        timeline.play();
	    }
        
        public void BounceOutAnimation(Node node) {
	        
	        
		 Timeline timeline  = new Timeline(
	                new KeyFrame(Duration.millis(0),    
	                    new KeyValue(node.scaleXProperty(), 1, WEB_EASE),
	                    new KeyValue(node.scaleYProperty(), 1, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(250),    
	                    new KeyValue(node.scaleXProperty(), 0.95, WEB_EASE),
	                    new KeyValue(node.scaleYProperty(), 0.95, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(500),    
	                    new KeyValue(node.opacityProperty(), 1, WEB_EASE),
	                    new KeyValue(node.scaleXProperty(), 1.1, WEB_EASE),
	                    new KeyValue(node.scaleYProperty(), 1.1, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(1000),    
	                    new KeyValue(node.opacityProperty(), 0, WEB_EASE),
	                    new KeyValue(node.scaleXProperty(), 0.3, WEB_EASE),
	                    new KeyValue(node.scaleYProperty(), 0.3, WEB_EASE)
	                )
	        );
		 timeline.setOnFinished(e->{
	        	ROLE.setText("Blog Fashion");
	    		BounceInAnimation(ROLE);
	        });
	        timeline.setDelay(Duration.seconds(0.2));
	        timeline.play();

	    }
        
        public void navbartransition(){
		TranslateTransition t = new TranslateTransition();
                
                
		if (Navplayed==false){
		  
		  t.setDuration(Duration.millis(500)); 
	      t.setNode(Navbar); 
	      t.setByX(150); 
	      t.setAutoReverse(false); 
	      t.play();
	      Navplayed=true;
	      SECOND.setVisible(false);
	      
	      HboxStats.setVisible(false);
	      hboxlogo.setVisible(false);
              HboxManagement1.setVisible(false);
              HboxLogout.setVisible(false);
	      copyrighttext.setVisible(false);
	      sep.setVisible(false);
		}
		else 
		{t.setDuration(Duration.millis(500)); 
	      t.setNode(Navbar); 
	      t.setByX(-150); 
	      t.setAutoReverse(false); 
	      t.play();
	      Navplayed=false;
	      SECOND.setVisible(true);
	      
	      HboxStats.setVisible(true);
	      hboxlogo.setVisible(true);
              HboxManagement1.setVisible(true);
              HboxLogout.setVisible(true);
	      copyrighttext.setVisible(true);
	      sep.setVisible(true);
                }
	}
        
        public void WobbleAnimation(Node node, double width) {
	        
		 Timeline timeline  = new Timeline(
	                new KeyFrame(Duration.millis(0),    
	                    new KeyValue(node.translateXProperty(), 0, WEB_EASE),
	                    new KeyValue(node.rotateProperty(), 0, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(150),    
	                    new KeyValue(node.translateXProperty(), -0.25 * width, WEB_EASE),
	                    new KeyValue(node.rotateProperty(), -5, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(300),    
	                    new KeyValue(node.translateXProperty(), 0.2 * width, WEB_EASE),
	                    new KeyValue(node.rotateProperty(), 3, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(450),    
	                    new KeyValue(node.translateXProperty(), -0.15 * width, WEB_EASE),
	                    new KeyValue(node.rotateProperty(), -3, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(600),    
	                    new KeyValue(node.translateXProperty(), 0.1 * width, WEB_EASE),
	                    new KeyValue(node.rotateProperty(), 2, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(750),    
	                    new KeyValue(node.translateXProperty(), -0.05 * width, WEB_EASE),
	                    new KeyValue(node.rotateProperty(), -1, WEB_EASE)
	                ),
	                new KeyFrame(Duration.millis(1000),    
	                    new KeyValue(node.translateXProperty(), 0, WEB_EASE),
	                    new KeyValue(node.rotateProperty(), 0, WEB_EASE)
	                )
	        );
	        
		 timeline.setDelay(Duration.seconds(0.2));
		 timeline.play();
 
	 }
    
}
