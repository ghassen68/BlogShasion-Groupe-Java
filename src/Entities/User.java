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
public class User {

    int id;
    String username;
    String nom;
    String prenom;
    String email;
    String password;
    String role;
    String adress;
    String numtel;
    String image;
    String sexe;

    public User(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public User(int id, String username, String nom, String prenom, String email, String password, String role, String adress, String numtel, String image) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role = role;
        this.adress = adress;
        this.numtel = numtel;
        this.image = image;
    }

    public User(int id, String username, String nom, String prenom, String email, String password, String role, String adress, String numtel, String image, String sexe) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role = role;
        this.adress = adress;
        this.numtel = numtel;
        this.image = image;
        this.sexe = sexe;
    }

    public User(String username, String nom, String prenom, String email, String password, String adress, String numtel, String sexe) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.adress = adress;
        this.numtel = numtel;
        this.sexe = sexe;
    }

    public User(String username, String nom, String prenom, String email, String password, String role, String adress, String numtel, String image) {

        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role = role;
        this.adress = adress;
        this.numtel = numtel;
        this.image = image;
    }

    public User(int id, String username, String nom, String prenom, String email, String adress, String numtel) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adress = adress;
        this.numtel = numtel;
    }
    
    

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return id + " - " + username;
    }

}
