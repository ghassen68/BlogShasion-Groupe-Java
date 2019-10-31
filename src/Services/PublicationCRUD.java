/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Publication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author ASUS
 */
public class PublicationCRUD {

    MyConnection myc = new MyConnection.getInstance();
    Connection cnx = myc.getConnection();

    private Statement ste;
    private ResultSet rs;

    public boolean ajouterPublication(Publication p) throws SQLException {
        String requete = "INSERT INTO publication (username,content,image) VALUES ('" + p.getUsername() + "','" + p.getContent() + "','" + p.getImage() + "')";

        Statement st = cnx.createStatement();
        st.executeUpdate(requete);
        System.out.println("Publication ajouté");
        return true;
    }

    public ObservableList<Publication> readAllDV() {
        String req = "select * from publication ";
        ObservableList<Publication> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Publication pub = new Publication();
                pub.setPubID(rs.getInt("pubID"));
                pub.setUsername(rs.getString("username"));
                pub.setContent(rs.getString("content"));
                pub.setImage(rs.getString("image"));
                list.add(pub);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublicationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void deleteM(int id) {
        String req = "delete from publication where pubID=" + id;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PublicationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void updateM(Publication pub){
           // Publication pub =new Publication();
        String req="UPDATE `publication` SET `content` = '" + pub.getContent() + "',`image` = '" + pub.getImage() + "' where pubID='"+pub.getPubID()+"';";
        try {       

            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PublicationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//    public Publication modifierPublication(Publication p) {
//        String requete = "UPDATE  publication SET userID=?,content=? WHERE pubID=?";
//
//        try {
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.setString(1, p.getUserID());
//            pst.setString(2, p.getContent());
//            pst.setInt(3, pubID);
//            pst.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return p;
//    }
//    public void supprimerPublication(int pubID) {
//        try {
//            String requete = "DELETE FROM publication WHERE pubID=" + pubID;
//
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            //pst.setInt(1, p.getPubID());
//            pst.executeUpdate();
//            System.out.println("Publication supprimé");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    public List<Publication> displayPub() {
//        List<Publication> myList = new ArrayList<>();
//
//        try {
//            String requete = "SELECT * FROM publication";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(requete);
//            while (rs.next()) {
//                Publication p = new Publication();
//                p.setPubID(rs.getInt(1));
//                p.setUserID(rs.getString("UserID"));
//                p.setContent(rs.getString("content"));
//
//                myList.add(p);
//
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return myList;
//    }
//    public Publication getById(int pubID) {
//
//        try {
//            String requete = "SELECT * FROM publication WHERE pubID=" + pubID;
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(requete);
//            if (rs.next()) {
//                Publication p = new Publication();
//                p.setPubID(rs.getInt(1));
//                p.setUserID(rs.getString("UserID"));
//                p.setContent(rs.getString("content"));
//
//                return p;
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return null;
//    }

//}
