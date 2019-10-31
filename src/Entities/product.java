/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import static com.sun.org.apache.bcel.internal.generic.Type.FLOAT;
import static java.sql.JDBCType.FLOAT;
import static java.sql.Types.FLOAT;
import java.util.Objects;

/**
 *
 * @author MSI
 */
public class product {
    
    private int id_P;
    private String description_p;
    private String Cat_p;
    private String type_p;
    private String marque_P;	
    private String color_P;	
    private String size_P;	
    private Double price_P;
    private String genre_P;
 

    public product() {
    }

    public product(int id_P, String Cat_p, String type_p, String marque_P, String color_P, String size_P, Double price_P, String description_p,String genre_P) {
        this.id_P = id_P;
        this.Cat_p = Cat_p;
        this.type_p = type_p;
        this.marque_P = marque_P;
        this.color_P = color_P;
        this.size_P = size_P;
        this.price_P = price_P;
        this.description_p = description_p;
        this.genre_P=genre_P;
    }

    public product( String Cat_p, String type_p, String marque_P, String color_P, String size_P,Double price_P,String description_p,String genre_P) {
        
        this.Cat_p = Cat_p;
        this.type_p = type_p;
        this.marque_P = marque_P;
        this.color_P = color_P;
        this.size_P = size_P;
        this.price_P = price_P;
        this.description_p = description_p;
        this.genre_P=genre_P;
    }

  
    

    public int getId_P() {
        return id_P;
    }

    public void setId(int id_P) {
        this.id_P = id_P;
    }

    public String getDescription_p() {
        return description_p;
    }

    public void setDescription_p(String description_p) {
        this.description_p = description_p;
    }

    public String getCat_p() {
        return Cat_p;
    }

    public void setCat_p(String Cat_p) {
        this.Cat_p = Cat_p;
    }

    public String getType_p() {
        return type_p;
    }

    public void setType_p(String type_p) {
        this.type_p = type_p;
    }

    public void setId_P(int id_P) {
        this.id_P = id_P;
    }

    public String getMarque_P() {
        return marque_P;
    }

    public void setMarque_P(String marque_P) {
        this.marque_P = marque_P;
    }

   
    public String getColor_P() {
        return color_P;
    }

    public void setColor_P(String color_P) {
        this.color_P = color_P;
    }

    public String getSize_P() {
        return size_P;
    }

    public void setSize_P(String size_P) {
        this.size_P = size_P;
    }

    public Double getPrice_P() {
        return price_P;
    }

    public void setPrice_P(Double price_P) {
        this.price_P = price_P;
    }

    public String getGenre_P() {
        return genre_P;
    }

    public void setGenre_P(String genre_P) {
        this.genre_P = genre_P;
    }

    @Override
    public String toString() {
        return "product{" + "id_P=" + id_P + ", description_p=" + description_p + ", Cat_p=" + Cat_p + ", type_p=" + type_p + ", marque_P=" + marque_P + ", color_P=" + color_P + ", size_P=" + size_P + ", price_P=" + price_P + ", genre_P=" + genre_P + '}';
    }

    

    

    
    

}