/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Timestamp;

/**
 *
 * @author Molka
 */
public class Commande {
    
    private int id_commande ; 
    private int id_parent ; 
    private int id_ligne ; 
    private float total ; 
    private Timestamp date ; 

    public Commande(int id_commande, Timestamp date) {
        this.id_commande = id_commande;
        this.date = date;
    }

    public Commande(int id_parent, int id_ligne, float total) {
        this.id_parent = id_parent;
        this.id_ligne = id_ligne;
        this.total = total;
    }

    public Commande(int id_commande, int id_parent, int id_ligne, float total,Timestamp date) {
        this.id_commande = id_commande;
        this.id_parent = id_parent;
        this.id_ligne = id_ligne;
        this.total = total;
        this.date=date ; 
    }

    public Commande(int id_commande, int id_parent, int id_ligne, float total) {
        this.id_commande = id_commande;
        this.id_parent = id_parent;
        this.id_ligne = id_ligne;
        this.total = total;
    }

    public int getId_commande() {
        return id_commande;
    }

    public int getId_parent() {
        return id_parent;
    }

    public int getId_ligne() {
        return id_ligne;
    }

    public float getTotal() {
        return total;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setId_ligne(int id_ligne) {
        this.id_ligne = id_ligne;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", id_parent=" + id_parent + ", id_ligne=" + id_ligne + ", total=" + total + '}';
    }
    
    
    
    
}
