/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import static Entities.CurrentUser.username;
import Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionDB;

/**
 *
 * @author Ghass
 */
public class UserService {
   
    Statement ste;
    ConnexionDB mycnx;
    PreparedStatement pste;
     Connection cx ; 
    public UserService(){
        cx =ConnexionDB.getInstance().getConnection();
        try{
            ste = cx.createStatement();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void AddUser(User s) {
        String hashedpw = BCrypt.hashpw(s.getPassword(), BCrypt.gensalt(12));
 String req1 =" INSERT INTO `user`(`username`,`nom`,`prenom`,`email`,`password`,`role`,`adress`,`numtel`,`image`,`sexe`)"+"VALUES ('"+s.getUsername()+"','"+s.getNom()+"','"+s.getPrenom()+"','"+s.getEmail()+"','"+hashedpw+"','"+s.getRole()+"','"+s.getAdress()+"','"+s.getNumtel()+"','"+s.getImage()+"','"+s.getSexe()+"')";
 try{
        ste.executeUpdate(req1);
        System.out.println(req1);
            System.out.println("Ajout fait avec succes!");
    
    }
    catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }}
public void UpdateUser(User s) {
        System.out.println(s+"***");
 String req="UPDATE `user` SET `username`=?,`nom`=?,`prenom`=?,`email`=?,`adress`=?,`numtel`=? WHERE id=? ";
        try {
            pste=(PreparedStatement) cx.prepareStatement(req);
             pste.setInt(7,s.getId());
             pste.setString(1,s.getUsername());
             pste.setString(2, s.getNom());
             pste.setString(3, s.getPrenom());
             pste.setString(4, s.getEmail());
             pste.setString(5, s.getAdress());
             pste.setString(6, s.getNumtel());
             
             
             pste.executeUpdate();
             System.out.println("Mise à jour réussie");
        } catch (SQLException ex) {
            System.out.println(ex);;
        }


    }
 public void DeleteUser(int id) {
       //String req="DELETE FROM `services` WHERE id =?"+id+";"; 
         try { 
             cx.createStatement().execute("DELETE FROM `User` WHERE id ="+id+";");
             System.out.println("user deleted ");
              
           } catch (SQLException ex) {
               Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    
     public List<User> ListUsers() {
        List<User> mylist = new ArrayList();
try {
    String req="select * from user";
    ResultSet res = ste.executeQuery(req);
    
    
    while(res.next()){
        User s = new User();
        System.out.println(res.getInt(1)+" "+res.getString(2)+ " "+res.getString(3)+" ");
       s.setId(res.getInt(1));
     s.setUsername(res.getString(2));
     s.setNom(res.getString(3));
     s.setPrenom(res.getString(4));
    s.setEmail(res.getString(5));
     s.setPassword(res.getString(6));
     s.setRole(res.getString(7));
     s.setAdress(res.getString(8));
     s.setNumtel(res.getString(9));
      s.setImage(res.getString(10));
     
   
    mylist.add(s);
    }
}
catch (SQLException ex){
    System.out.println(ex.getMessage());
}

  return mylist;
    }
     
    public boolean login(String username, String password) throws SQLException {
        if (!username.isEmpty() && !password.isEmpty() ) {
            String req = "SELECT password from user where username = '" + username +"'";
            Statement s = cx.createStatement();
            ResultSet rs = s.executeQuery(req);
            if (rs.next()){
            String pw = rs.getString(1);
                System.out.println(rs.getString(1));
                     return (BCrypt.checkpw(password, pw));}
            else return false ;
        }  
        else {
            return false;
        }

    }
    
     public User getUserByUsername( String username) throws SQLException { 
        String req="select * from user where username='"+username+"'"    ;
        Statement s = cx.createStatement() ;
        ResultSet rs =s.executeQuery(req) ;
        User u = new User() ;
            if (rs.next()) {
                u=new User(rs.getInt("id"),rs.getString("username"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("password"),rs.getString("role"),rs.getString("adress"),rs.getString("numtel"),rs.getString("image"),rs.getString("sexe"));
             }   
        return u ;
        
    }

    public void ListUsers(User x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public boolean existeUser (String username) throws SQLException {
        
          String req = "SELECT * from user where username = '" + username +"'";
            Statement s = cx.createStatement();
            ResultSet rs = s.executeQuery(req);
            if (rs.next()){
            
            return true ; 
            }
            
            else {
                
                return false ;
            }
        
    } 
     public void modifierPassword(String username , String password) throws SQLException {
                String hpass=BCrypt.hashpw(password, BCrypt.gensalt(12)) ;
        String req=" update user set password='" +hpass+"'"+"where username='"+username+"'";
        Statement s = cx.createStatement(); 
        s.executeUpdate(req) ; 
        
    }
     
      public List<User> recherche(String usernamee) {
        List<User> mylist = new ArrayList();
try {
    String req="select * from user where username like '" + usernamee + "'";
    ResultSet res = ste.executeQuery(req);
    
    
    while(res.next()){
        User s = new User();
        System.out.println(res.getInt(1)+" "+res.getString(2)+ " "+res.getString(3)+" ");
       s.setId(res.getInt(1));
     s.setUsername(res.getString(2));
     s.setNom(res.getString(3));
     s.setPrenom(res.getString(4));
    s.setEmail(res.getString(5));
     s.setPassword(res.getString(6));
     s.setRole(res.getString(7));
     s.setAdress(res.getString(8));
     s.setNumtel(res.getString(9));
      s.setImage(res.getString(10));
     
   
    mylist.add(s);
    }
}
catch (SQLException ex){
    System.out.println(ex.getMessage());
}

  return mylist;
    }
     
 
     
     
}
