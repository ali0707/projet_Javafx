package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Molka
 */
public class Produit {
    
    private int id_produit;
    private String nom;
    private String catégorie;
    private float prix_produit ; 
    private String description ; 
    private String image;
    private int quantite ; 

   

    public Produit(int id_produit, String nom, String catégorie, float prix_produit, String description,int quantite) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.catégorie = catégorie;
        this.prix_produit = prix_produit;
        this.description = description;
         this.quantite = quantite ; 
    }        

    public Produit(int id_produit, float prix_produit) {
        this.id_produit = id_produit;
        this.prix_produit = prix_produit;
    }

    public Produit(float prix_produit) {
        this.prix_produit = prix_produit;
    }

    public Produit(String nom, String catégorie, float prix_produit, String description,int quantite) {
        this.nom = nom;
        this.catégorie = catégorie;
        this.prix_produit = prix_produit;
        this.description = description;
         this.quantite = quantite ; 
    }

    public Produit(int id_produit,String nom, String catégorie, float prix_produit, String description,String image) {
        
        this.id_produit = id_produit;
        this.nom = nom;
        this.catégorie = catégorie;
        this.prix_produit = prix_produit;
        this.description = description;
        this.image = image;
    }
     public Produit(int id_produit,String nom, String catégorie, float prix_produit, String description,String image,int quantite) {
        
        this.id_produit = id_produit;
        this.nom = nom;
        this.catégorie = catégorie;
        this.prix_produit = prix_produit;
        this.description = description;
        this.image = image;
        this.quantite = quantite ; 
    }
    public Produit(String nom, String catégorie, float prix_produit, String description,String image,int quantite) {
        
        
        this.nom = nom;
        this.catégorie = catégorie;
        this.prix_produit = prix_produit;
        this.description = description;
        this.image = image;
        this.quantite = quantite ;
    }

    public Produit() {
        
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
    

    
    public int getId_produit() {
        return id_produit;
    }

    

    public String getNom() {
        return nom;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public float getPrix_produit() {
        return prix_produit;
    }

    public String getDescription() {
        return description;
    }
     public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /*@Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom=" + nom + ", cat\u00e9gorie=" + catégorie + ", prix_produit=" + prix_produit + ", description=" + description + '}';
    }*/

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom=" + nom + ", catégorie=" + catégorie + ", prix_produit=" + prix_produit + ", description=" + description + ", image=" + image + '}';
    }

    public void setCatégorie(String catégorie) {
        this.catégorie = catégorie;
    }

    public void setPrix_produit(float prix_produit) {
        this.prix_produit = prix_produit;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    

    
}
