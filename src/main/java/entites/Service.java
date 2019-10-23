/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import javafx.scene.control.TextField;

/**
 *
 * @author asus
 */
public class Service {

    public static void add(Service a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String nom_service;
    private String description_service;
    private String id;
    
    public Service()
            
    {
        super();
    }
    
    public Service(String nom_service, String description_service , String id  ) {
        super();
        this.nom_service = nom_service;
        this.description_service = description_service;
        this.id = id;
        
    }
     public Service(String nom_service, String description_service  ) {
        super();
        this.nom_service = nom_service;
        this.description_service = description_service;
        
    }

   

     

    public void setDescription_service(String description_service) {
        this.description_service = description_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }

    public String getDescription_service() {
        return description_service;
    }

    public String getNom_service() {
        return nom_service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
    
