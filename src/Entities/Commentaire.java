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
public class Commentaire {
    
    private int id_commentaire ; 
    private int id_parent ; 
    private int id_produit ; 
    private String contenu ; 

    public Commentaire(int id_commentaire, int id_produit, int id_parent, String contenu) {
        this.id_commentaire = id_commentaire;
        this.id_produit = id_produit;
        this.id_parent = id_parent;
        this.contenu = contenu;
    }

    public Commentaire(int id_parent, int id_produit, String contenu) {
        this.id_produit = id_produit;
        this.id_parent = id_parent;
        this.contenu = contenu;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getId_parent() {
        return id_parent;
    }

    public String getContenu() {
        return contenu;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_commentaire=" + id_commentaire + ", id_parent=" + id_parent + ", id_produit=" + id_produit + ", contenu=" + contenu + '}';
    }
    
    
    
}
