/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Article;
import entites.Posteur;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.Articlegestion;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AdmininterfaceController implements Initializable {
    @FXML
    private TableView <Article>table;
    @FXML
    private TableColumn <Article,String> nom;
    @FXML
    private TableColumn <Article,String>cat;
    @FXML
    private TableColumn <Article,String>dat;
    @FXML
    private TableColumn <Article,String>sou;
    @FXML
    private TextField nomarticle;
    @FXML
    private TextArea descriptionarticle;
    @FXML
    private ChoiceBox categories;
    @FXML
    private DatePicker dateajout;
    @FXML
    private TextField source;

    /**
     * Initializes the controller class.
     */
    /**ayed**/
  Boolean canInscription = true;
  Articlegestion art = new Articlegestion();
  ArrayList<Article> articles= (ArrayList<Article>) art.afficherArticle();  
  public ObservableList<Article> data = FXCollections.observableArrayList(articles);
  ObservableList<String> categoriesList= FXCollections.
  observableArrayList("Bricolage","jardinage","informatique");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            PosteurService p= new PosteurService();
        ArrayList<Posteur> pers=(ArrayList<Posteur>) p.afficherPosteur();
        // TODO
        /******ayeeeeed***///
         categories.setValue("Bricolage");
      categories.setItems(categoriesList);
      table.setItems(data);
      nom.setCellValueFactory(new PropertyValueFactory <Article,String>("nom_article"));
     cat.setCellValueFactory(new PropertyValueFactory <Article,String>("categorie"));
     dat.setCellValueFactory(new PropertyValueFactory <Article,String>("date_article"));
     sou.setCellValueFactory(new PropertyValueFactory <Article,String>("sources"));
  
    }    

    @FXML
    private void btn_posteurgestion(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("../fxml/Posteur_gestion.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();        
    }

    @FXML
    private void btn_jobeurgestion(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("../fxml/Jobeur_gestion.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    }

    @FXML
    private void ajouterArticle(ActionEvent event) {
     table.setItems(data);
     nom.setCellValueFactory(new PropertyValueFactory <Article,String>("nom_article"));
     cat.setCellValueFactory(new PropertyValueFactory <Article,String>("categorie"));
     dat.setCellValueFactory(new PropertyValueFactory <Article,String>("date_article"));
     sou.setCellValueFactory(new PropertyValueFactory <Article,String>("source"));
        if(nomarticle.getText().isEmpty()){
           nomarticle.setVisible(true);
            canInscription = false;
           JOptionPane.showMessageDialog (null,"il faut un nom pour l'article");
        }
         if(descriptionarticle.getText().isEmpty())
         {
            canInscription = false;
           JOptionPane.showMessageDialog (null," ajouter voter article");
        }
         if(source.getText().isEmpty())
         {
            canInscription = false;
           JOptionPane.showMessageDialog (null," remplire le champ source ");
        }
        
        
        if(canInscription){
    String nom=nomarticle.getText();
   String descriptionart=descriptionarticle.getText();
   LocalDate date_article =dateajout.getValue();
   String date = date_article.toString();
   String sources= source.getText();
   String categorie=(String) categories.getValue();
   
   Article a = new Article(nom,descriptionart,date,categorie,sources);
   Articlegestion a1=new Articlegestion();
   a1.ajouterArticle(a);
    }
    }

    @FXML
    private void afficherarticle(ActionEvent event) throws IOException {
       
        Parent page = FXMLLoader.load(getClass().getResource("/fxml/modifierArticle.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
    }
    }
    

