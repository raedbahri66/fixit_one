/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Article;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 import java.net.URI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Afficher_ArticleController implements Initializable {
    @FXML
    private Text tiitre_article;
   
    @FXML
    private Label desc_artcile;
    @FXML
    private Label lire;
    Article A=new Article();
    
    private Desktop desktop = Desktop.getDesktop();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODo
        Article A=new Article();
        A=AcceuilController.A1;
        tiitre_article.setText(A.getNom_article());
        desc_artcile.setText(A.getDescriptionarticle());
        System.out.println(AcceuilController.A1);
      

    
    }
    @FXML
    private void retour_accuiel(ActionEvent event) {
          Parent root = null;
        try {
             root = FXMLLoader.load(getClass().getResource("/fxml/acceuil.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    }

    @FXML
    private void lirelasuite(MouseEvent event) {
        A=AcceuilController.A1;
        String s1 =("http://"+A.getSources());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(URI.create(s1));
            } catch (IOException ex) {
            Logger.getLogger(Afficher_ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    }
    
    

  

  

