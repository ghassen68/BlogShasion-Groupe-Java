package pi;


import Entities.CurrentUser;
import Entities.User;
import Services.UserService;
import java.sql.Connection;
import java.sql.SQLException;
import utils.ConnexionDB;
import utils.SendingMail;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ghass
 */
public class Main {
static Connection connection = null;
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
       connection = ConnexionDB.getInstance().getConnection();
       User x = new User(2, "xxxxxx", "xxxx", "xxxx", "xxx", "xxxx", "xxxx", "xxxx", "xxxx", "xxxxx");
        UserService s = new UserService();
      x= s.getUserByUsername("ghassen");
      CurrentUser cu = new CurrentUser(x);
        System.out.println(CurrentUser.id+CurrentUser.username);
        cu.disconnect();
                System.out.println(CurrentUser.id+CurrentUser.username);
        
                SendingMail se = new SendingMail("fqdsj", "ghassen.nouri@esprit.tn", "api");
              SendingMail.envoyer();
              
              
        
        
       // s.AddUser(x);
      // s.UpdateUser(x);
       //s.DeleteUser(1);
      
      
        
             
     
    }
    
}
