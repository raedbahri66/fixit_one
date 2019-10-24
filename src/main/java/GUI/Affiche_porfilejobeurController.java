/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Jobeur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Affiche_porfilejobeurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Jobeur A=new Jobeur();
        A=Interface_choisir_jobeurController.j1;
       /* tiitre_article.setText(A.getNom_article());
        desc_artcile.setText(A.getDescriptionarticle());*/
        System.out.println(Interface_choisir_jobeurController.j1);
    }    
    
}
