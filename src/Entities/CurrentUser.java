/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Ghass
 */
public class CurrentUser {
    
 public static int id;
public static String username ; 
public static String nom ; 
public static String prenom ;
public static  String email ; 
public static String password ;
public static String role ; 
public  static  String adress ;
public  static  String numtel ;
public  static String image ; 
public  static  String sexe;

    
public CurrentUser(User u) {
    
    id=u.getId();
    nom=u.getNom() ;
    username=u.getUsername();
    prenom=u.getPrenom() ;
    email=u.getEmail();
    password=u.getPassword() ;
    role=u.getRole();
    adress=u.getAdress();
    numtel=u.getNumtel() ;
    image=u.getImage();
    sexe=u.getSexe();
    
    
}

    public CurrentUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

public void disconnect(){
    
    id=-1;
    username=null;
    nom=null ;
    prenom=null ; 
    email=null ;
    password=null;
    role=null;
    adress=null;
    numtel=null;
    image=null;
    sexe=null;
    
    
}

}
