/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class MyConnection {
    public String url="jdbc:mysql://localhost:3306/esprit";
    public String login="root";
    public String pwd="";
    public static Connection cnx;
    public static MyConnection myc;
    
    private MyConnection(){
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connextion établie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Connexion non établie!");
        }
    }
  
    public static Connection getConnection(){
        return cnx;
    }
    
   public static MyConnection getInstance(){
       if(myc ==null){
           myc = new MyConnection();
       }
       return myc;
   }

    public static class getInstance extends MyConnection {

        public getInstance() {
        }
    }
}
