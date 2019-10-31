/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.Date;



/**
 *
 * @author eya
 */
public class Commentaire {
    private int commentID;
    private String userID;
    private Date datecomment;
    private String content;

    public Commentaire() {
    }

    public Commentaire(int commentID, String userID, String content) {
        this.commentID = commentID;
        this.userID = userID;
        this.content = content;
    }

    
    public Commentaire(int commentID, String userID, Date datecomment, String content) {
        this.commentID = commentID;
        this.userID = userID;
        this.datecomment = datecomment;
        this.content = content;
    }
    
    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDatecomment() {
        return datecomment;
    }

    public void setDatecomment(Date datecomment) {
        this.datecomment = datecomment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "commentID=" + commentID + ", userID=" + userID + ", datecomment=" + datecomment + ", content=" + content + '}';
    }

}