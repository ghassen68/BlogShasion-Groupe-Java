/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.product;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import utils.MyConnection;
/**
 *
 * @author MSI
 */
public class productCRUD {
   Connection c = MyConnection.getInstance().getConnection();

    Statement ste;

    public productCRUD() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     public void ajouterproduct(product p) throws SQLException{
         
        String requete = "INSERT INTO `product` (`cat_P`,`type_P`,`marque_P`,`color_P`,`size_P`,`price_P`,`description_p`,`genre_p`)"
                + "VALUES ('"+p.getCat_p()+"','"+p.getType_p()+"','"+p.getMarque_P() +"','"+p.getColor_P()+"','"+p.getSize_P()+"','"+p.getPrice_P()+"','"+p.getDescription_p()+"','"+p.getGenre_P()+"')";
   ste.executeUpdate(requete);
        System.out.println("elment insert");
    }
    
    public void modifierproduct(product A) throws SQLException{
       /*String requete = "UPDATE product SET Cat_P=?,type_P=?,marque_P=?,color_P=?,size_P=?,price_P=?,disp_P=? WHERE id_P=?";
        try {
            PreparedStatement pst = c.prepareStatement(requete);
           // pst.setInt(8,id_P);
            pst.setString(1,p.getDescription_p());
            pst.setString(2, p.getCat_p());
            pst.setString(3,p.getType_p());
            pst.setString(4,p.getMarque_P());
            pst.setString(5,p.getColor_P());
            pst.setString(6,p.getSize_P());
            pst.setDouble(7,p.getPrice_P());
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
       String requete="UPDATE `product` SET  `cat_P` = '"+A.getCat_p()+"',"
               
+ " `type_P` = '"+A.getType_p()+"', `marque_P` = '"+A.getMarque_P()+"', `color_P` = '"+A.getColor_P()+"', `size_P` = '"+A.getSize_P()+"', `price_P` = '"+A.getPrice_P()+"' , `description_p` = '"+A.getDescription_p()+", `genre_P` = '"+A.getGenre_P()+"''where  `Id_P`=" + A.getId_P();
        ste.executeUpdate(requete);
          System.out.println(requete);
           System.out.println("elment modifier");
    }
    
    public void supprimerproduct(product p){
        try {
            String requete = "DELETE FROM `product` WHERE `id_P`=?";
            
          PreparedStatement pst = c.prepareStatement(requete);
            pst.setInt(1, p.getId_P());
            pst.executeUpdate();
            System.out.println("produit supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public List<product> displayproduct(){
        List<product> myList = new ArrayList<>();
        product p=null;
         String requete = "SELECT id_P,Cat_p,type_P,marque_p,color_P,size_P,price_P,description_p,genre_P FROM product";
        try {
           
          //  Statement st = c.createStatement();
            ResultSet rs = ste.executeQuery(requete);
            while(rs.next()){
                 p = new product();
                 p.setId(rs.getInt("id_P"));
                 p.setCat_p(rs.getString("Cat_p"));
                 p.setType_p(rs.getString("type_P"));
                 p.setMarque_P(rs.getString("marque_p"));
                 p.setColor_P(rs.getString("color_P"));
                 p.setSize_P(rs.getString("size_P")); 
                 p.setPrice_P(rs.getDouble("price_P"));
                 p.setDescription_p(rs.getString("description_p")); 
                 p.setGenre_P(rs.getString("genre_P"));
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    
    
    
    public ArrayList<product> rechercheproduct(String rech) throws SQLException {

        ArrayList<product> off = new ArrayList<>();
           product e = null;
        String req = "SELECT * FROM product where marque_p Like  '%"+rech+"%'  ";     
        Statement stm = c.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
                              e = new product();
                
              
       
                 e.setCat_p(rst.getString("Cat_p"));
                 e.setType_p(rst.getString("type_P"));
                 e.setMarque_P(rst.getString("marque_p"));
                 e.setColor_P(rst.getString("color_P"));
                 e.setSize_P(rst.getString("size_P")); 
                 e.setPrice_P(rst.getDouble("price_P"));
                 e.setDescription_p(rst.getString("description_p")); 
                  e.setGenre_P(rst.getString("genre_P"));

             
                
                      
   product   per=new  product(rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getDouble(7),rst.getString(8),rst.getString(9));
  

            off.add(e);
        }
        return off;
    }
   
    
    public void CopyImage(String url, String imageDestination) throws IOException {

        //URL l'emplacement de fichier image sous wamp exemple (http://localhost/image/product)
        
        
        InputStream inputStream = new FileInputStream(imageDestination);//upload l'image
        System.out.println("Start uploading second file");

        OutputStream output = new FileOutputStream(url);
        byte[] bytesIn = new byte[4096];
        int read = 1;
        while ((read = inputStream.read(bytesIn)) != -1) {//copier l'image au serveur
            output.write(bytesIn, 0, read);
        }
        output.close();
        inputStream.close();
    }

    
    
    
}
