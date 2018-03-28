/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Molka
 */
public class Promotion {
    private int id_promotion ; 
    private int id_produit ; 
    private int pourcentage ; 
    private String date_debut ; 
    private String date_fin ; 
    private float prixPromo ; 
    
    public java.sql.Date convert(String date) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        return sqlDate;
    }
    
    

    public Promotion(int id_promotion, int id_produit, int pourcentage, String date_debut, String date_fin, float prixPromo) {
        this.id_promotion = id_promotion;
        this.id_produit = id_produit;
        this.pourcentage = pourcentage;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prixPromo = prixPromo;
    }

    public Promotion(int id_produit, int pourcentage, String date_debut, String date_fin) {
        this.id_produit = id_produit;
        this.pourcentage = pourcentage;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        
    }
    public Promotion(int id_promotion,int id_produit, int pourcentage, String date_debut, String date_fin) {
       this.id_promotion = id_promotion ; 
        this.id_produit = id_produit;
        this.pourcentage = pourcentage;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        
    }

    public void setPrixPromo(float prixPromo) {
        this.prixPromo = prixPromo;
    }

    public float getPrixPromo() {
        return prixPromo;
    }

    

    public int getId_promotion() {
        return id_promotion;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id_promotion=" + id_promotion + ", id_produit=" + id_produit + ", pourcentage=" + pourcentage + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", prixPromo=" + prixPromo + '}';
    }
    
   

   
    
    
    
    
    
}
