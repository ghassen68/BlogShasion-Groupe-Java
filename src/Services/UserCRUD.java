/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.MyConnection;

/**
 *
 * @author HP
 */
public class UserCRUD {
    public void increaseGrosMots(int idUser) {
        MyConnection myc = new MyConnection.getInstance();
       Connection cnx = myc.getConnection();
    String requete = "UPDATE `bloc` SET NbrGrosMots=NbrGrosMots+1 WHERE `id`="+idUser;    
    try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("increased gros mots avec succes");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion !"+ex.getMessage());       }
      }
    
    public Integer getNbrGrosMots(int idUser) throws SQLException{
       MyConnection myc = new MyConnection.getInstance();
       Connection cnx = myc.getConnection();
        Statement st = cnx.createStatement();
        String req = "SELECT NbrGrosMots FROM bloc Where id="+idUser;
        
        ResultSet rs = st.executeQuery(req);
        Integer nbrGrosMots=0;
        while(rs.next()){
            nbrGrosMots=rs.getInt(1);
        }
        return nbrGrosMots;
        
    }
    
}
