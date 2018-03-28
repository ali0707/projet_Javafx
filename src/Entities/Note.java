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
public class Note {
    
    private int id_note ; 
    private int id_parent ; 
    private int id_produit ; 
    private String nb_etoiles ; 

    public Note(int id_note, int id_parent, int id_produit, String nb_etoiles) {
        this.id_note = id_note;
        this.id_parent = id_parent;
        this.id_produit = id_produit;
        this.nb_etoiles = nb_etoiles;
    }

    public Note(int id_parent, int id_produit, String nb_etoiles) {
        this.id_parent = id_parent;
        this.id_produit = id_produit;
        this.nb_etoiles = nb_etoiles;
    }

    public int getId_note() {
        return id_note;
    }

    public int getId_parent() {
        return id_parent;
    }

    public int getId_produit() {
        return id_produit;
    }

    public String getNb_etoiles() {
        return nb_etoiles;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public void setId_parent(int id_client) {
        this.id_parent = id_client;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setNb_etoiles(String nb_etoiles) {
        this.nb_etoiles = nb_etoiles;
    }

    @Override
    public String toString() {
        return "Note{" + "id_note=" + id_note + ", id_parent=" + id_parent + ", id_produit=" + id_produit + ", nb_etoiles=" + nb_etoiles + '}';
    }
    
    
    
}
