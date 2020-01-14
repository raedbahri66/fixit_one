/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author waelb
 */
public class Categorie {
    private String Categorie ;
    private int id ;

    public Categorie() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Categorie(String Categorie) {
        this.Categorie = Categorie;
    }

    public Categorie(String Categorie, int id) {
        this.Categorie = Categorie;
        this.id = id;
    }
    
    

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }
    
    
    
    
    
}
