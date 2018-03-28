/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Molka
 */
public class LigneCommande {
    
    private int id_ligne ; 
    private int id_produit ; 
    private float prix_produit ; 
    private int quantite ; 

    
    public LigneCommande(int id_produit, int quantite) {
        this.id_produit = id_produit;
        this.quantite = quantite;
    }

    public LigneCommande(float prix_produit) {
        this.prix_produit = prix_produit;
    }
    
    public LigneCommande( int id_produit, float prix_produit, int quantite) {
       // this.id_ligne = id_ligne;
        this.id_produit = id_produit;
        this.prix_produit = prix_produit;
        this.quantite = quantite;
    }

    public LigneCommande(int id_ligne, int id_produit, float prix_produit, int quantite) {
        this.id_ligne = id_ligne;
        this.id_produit = id_produit;
        this.prix_produit = prix_produit;
        this.quantite = quantite;
    }

    
    public LigneCommande() {
    }

    public int getId_ligne() {
        return id_ligne;
    }

    public int getId_produit() {
        return id_produit;
    }

    public float getPrix_produit() {
        return prix_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId_ligne(int id_ligne) {
        this.id_ligne = id_ligne;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setPrix_produit(float prix_produit) {
        this.prix_produit = prix_produit;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "LigneCommande{" + "id_ligne=" + id_ligne + ", id_produit=" + id_produit + ", prix_produit=" + prix_produit + ", quantite=" + quantite + '}';
    }
    
    
    
    
}
