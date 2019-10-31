/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Ghassen
 */
public class Commande {
     private int id_c;
    private int id_p;
    private String Nom_P;
    private int price_P;
    private String pay_c;
    private String color_P;
    private int quantite;

    public Commande(int id_c, String Nom_P, int price_P, String color_P, int quantite) {
        this.id_c = id_c;
        this.Nom_P = Nom_P;
        this.price_P = price_P;
        this.color_P = color_P;
        this.quantite = quantite;
        
    }
    
    public Commande(String Nom_P, int price_P, String color_P, int quantite) {
        this.Nom_P = Nom_P;
        this.price_P = price_P;
        this.color_P = color_P;
        this.quantite = quantite;
    }
   
    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    

    public String getNom_P() {
        return Nom_P;
    }

    public void setNom_P(String Nom_P) {
        this.Nom_P = Nom_P;
    }

    public int getPrice_P() {
        return price_P;
    }

    public void setPrice_P(int price_P) {
        this.price_P = price_P;
    }

   public String getPay_c() {
        return pay_c;
    }

   public void setPay_c(String pay_c) {
        this.pay_c = pay_c;
    }

    public String getColor_P() {
        return color_P;
    }

    public void setColor_P(String color_P) {
        this.color_P = color_P;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande() {
    }

    public Commande(int id_c, int id_p, String Nom_P, int price_P, String pay_c, String color_P, int quantite) {
        this.id_c = id_c;
        this.id_p = id_p;
        this.Nom_P = Nom_P;
        this.price_P = price_P;
        this.pay_c = pay_c;
        this.color_P = color_P;
        this.quantite = quantite;
    }

   

    @Override
    public String toString() {
        return "Commande{" + "id_c=" + id_c + ", id_p=" + id_p +",Nom_P="+Nom_P+",price_P="+price_P+ ",color_P="+color_P+",quantite=" + quantite + '}';
    }

   
    
}

    

