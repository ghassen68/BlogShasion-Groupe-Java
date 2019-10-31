/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAFSAF
 */
public class ConnexionDB {
    String url="jdbc:mysql://localhost:3306/esprit";
    String login="root";
    String pwd="";
    Connection cx; 
  static  ConnexionDB cBd;
    public ConnexionDB() {
      try {
                cx = DriverManager.getConnection(url, login,pwd);
                System.out.println("Connexion etablie");
            } catch (SQLException ex) {
                Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de connexion a la base de donnée");
        }
    }
    
    public static  ConnexionDB getInstance(){
        if(cBd == null)
            cBd = new ConnexionDB();
         return 
                 cBd;
    }
    
    public Connection getConnection(){
        return cx;
    } 
}
