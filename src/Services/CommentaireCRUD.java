/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Commentaire;
import Entities.CurrentUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/** 
 *
 * @author HP  
 */
public class CommentaireCRUD {
    
       MyConnection myc = new MyConnection.getInstance();
       Connection cnx = myc.getConnection();
   
          public void ajouterCommentaire(Commentaire c) {
    String requete = "INSERT INTO commentaire (userID,content,datecomment)"+"VALUES ('"+c.getUserID()+"','"+c.getContent()+"','"+c.getDatecomment()+"')";  
     
    try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Commentaire ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion !"+ex.getMessage());       }
      }
          
     public void modifierCommentaire(String c,int commentID) {
                    String requete = "UPDATE  commentaire SET content='"+c+"' WHERE commentID="+commentID;

        try {
            //PreparedStatement pst = cnx.prepareStatement(requete);
            //pst.setString(1,c.getUserID());
            //pst.setDate(2,c.getDatecomment());
            //pst.setString(2,c.getContent());
            //pst.setInt(3,commentID);
            //pst.executeUpdate();
             Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
                }
      
      public void supprimerCommentaire(int commentID){
        try {
            String requete = "DELETE FROM commentaire WHERE commentID="+commentID;
            
            PreparedStatement pst = cnx.prepareStatement(requete);
            //pst.setInt(1, c.getCommentID());
            pst.executeUpdate();
            System.out.println("Commentaire supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      }
      
      public ObservableList<Commentaire> displayComments(){
      ObservableList<Commentaire> myList = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM commentaire";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Commentaire c = new Commentaire();
                c.setCommentID(rs.getInt(1));
                c.setUserID(rs.getString("UserID"));
              
                c.setContent(rs.getString("content"));
                  c.setDatecomment(rs.getDate("datecomment"));

                myList.add(c);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
   
      return myList;
}

}
