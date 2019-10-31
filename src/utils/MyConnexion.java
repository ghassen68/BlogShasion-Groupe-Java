/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ghassen
 */
public class MyConnexion {
      public String url="jdbc:mysql://localhost:3306/esprit";
    public String login="root";
    public String pwd="";
    public static Connection cnx;
    public static MyConnexion myc; 
     private MyConnexion(){
        try {
            cnx=DriverManager.getConnection(url,login,pwd);
            System.out.println("connection etablie "+url);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("connection non etablie");        
        }
    }

    /**
     *
     * @return
     */
     public static Connection getConnection(){
     return cnx;
     }
        public static MyConnexion getInstance(){
    if (myc==null){
    myc=new MyConnexion();
    }
    return myc;
    }
    
}
