/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import static utils.MyConnexion.cnx;
import Entities.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnexion;

/**
 *
 * @author Ghassen
 */
public class CmdCrud {
    
    MyConnexion myc=MyConnexion.getInstance();
   
    Connection cnx = MyConnexion.getConnection();

    public CmdCrud() {
        this.myc = MyConnexion.getInstance();
    }
    
    public void ajouterCMD(Commande C){ 
        
        Statement st = null;
        try {
            String requete = "INSERT INTO commande (Nom_P,price_P,pay_C,color_P,quantite)" + " VALUES ('"+C.getNom_P()+"','"+C.getPrice_P()+"','"+C.getPay_c()+"','"+C.getColor_P()+"','"+C.getQuantite()+"')";
            st = (Statement) cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("commande ajoutee");
        } catch (SQLException ex) {
             System.out.println("erreur d'insertion");
              System.out.println(ex.getMessage());
        } 
            }
     public void modifierCMD(Commande C ,String nom){
        try {
            String requete = "UPDATE commande SET Color_P=?,quantite=? WHERE Nom_P='" + nom + "'";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, C.getColor_P());
            pst.setInt(2, C.getQuantite());
           
             pst.executeUpdate();
            System.out.println("modification effectué ");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
            
        }
     public void supprimerCMD(Commande c,String nom){
     try {
     String requete = "DELETE from commande  WHERE Nom_P='" + nom + "'";
     PreparedStatement pst = MyConnexion.getInstance().getConnection().prepareStatement(requete);
     System.out.println(requete);
     pst.executeUpdate();
     System.out.println("commande supprimée");
     } catch (SQLException ex) {
     System.out.println(ex.getMessage());
     
     }
     }
     
     
     /*public void supprimerCMD(Commande c) {
     try {
     String requete = "DELETE FROM Commande WHERE id_C=?";
     PreparedStatement pst = MyConnexion.getInstance().getConnection().prepareStatement(requete);
     pst.setInt(1,c.getId_c());
     pst.executeUpdate();
     System.out.println("Categorie supprimé");
     
     } catch (SQLException ex) {
     System.err.println(ex.getMessage());
     }
     }*/

        public List<Commande> displayCMD(){
             List<Commande> myList=new ArrayList<>();
        try {
           
            String requete="select * from commande";
            Statement st =(Statement) cnx.createStatement();
            ResultSet rs=st.executeQuery(requete);
            
            while(rs.next()){
                Commande c=new Commande();
              
                c.setNom_P(rs.getString("Nom_P"));
                c.setPrice_P(rs.getInt("price_P"));
              c.setColor_P(rs.getString("color_P"));

               c.setQuantite(rs.getInt("quantite"));
                myList.add(c);
             
                
                
          }  } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());              
        }       
        return myList;
                
        }        
        
       public List<Commande> chercher(String Name_E){
        String req="select * from commande where Nom_P like '"+Name_E+"'";
        List<Commande> list=new ArrayList<>();
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
               
                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
              list.add(new Commande(rs.getString("Nom_P"),rs.getInt("price_P"),rs.getString("Color_P"),rs.getInt("quantite")));  
                //list.add(new Event(rs.getInt("numero"),rs.getString("dateann"),rs.getString("nom"), rs.getString("prenom"),rs.getString("type"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CmdCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
        
    }
   
    }      
                
          
        
    
