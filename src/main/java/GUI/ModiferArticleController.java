/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entites.Article;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.omg.CORBA.SystemException;
import service.Articlegestion;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModiferArticleController implements Initializable {
    @FXML
    private TableView <Article>table_article;
    @FXML
    private TableColumn<?,?> id1;
    @FXML
    private TableColumn<?,?>nom_art;
    @FXML
    private TableColumn<?,?>cat1;
    @FXML
    private TableColumn<?,?>dat1;
    @FXML
    private TableColumn<?,?> sou1;
     @FXML
    private TableColumn<?,?> descr_art;
    @FXML
    private TextField nomarticle1;
    @FXML
    private TextArea descriptionarticle1;
    @FXML
    private ChoiceBox categories1;
    @FXML
    private DatePicker dateajout1;
    @FXML
    private TextField source1;
    @FXML
    private TextField id_article;
   /***date aujourdhui**/
   public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }  
 public void a() {
     table_article.setOnMouseClicked(new EventHandler<MouseEvent>()
     {
         @Override
         public void handle(MouseEvent event) {
         Article A = table_article.getItems().get(table_article.getSelectionModel().getSelectedIndex());
         id_article.setText( String.valueOf((A.getId())));
         nomarticle1.setText(A.getNom_article());
         descriptionarticle1.setText(A.getDescriptionarticle());
         categories1.setValue(A.getCategorie()); 
         dateajout1.setValue(A.getDate_article().toLocalDate());
         source1.setText(A.getSources());       
             
         }
     });}
             
    /**
     * Initializes the controller class.
     */
  boolean canInscription = true;
   Articlegestion art = new Articlegestion();
  ArrayList<Article> articles= (ArrayList<Article>) art.afficherArticle();  
  public ObservableList<Article> data = FXCollections.observableArrayList(articles);
  ObservableList<String> categoriesList= FXCollections.
  observableArrayList("Bricolage","jardinage","informatique");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     Article a = new Article();
        
     dateajout1.setValue(NOW_LOCAL_DATE());
      categories1.setValue("Bricolage");
      categories1.setItems(categoriesList);
      table_article.setItems(data);
    
     id1.setCellValueFactory(new PropertyValueFactory <>("id"));
     nom_art.setCellValueFactory(new PropertyValueFactory <>("nom_article"));
     descr_art.setCellValueFactory(new PropertyValueFactory <>("descriptionarticle"));
     cat1.setCellValueFactory(new PropertyValueFactory <>("categorie"));
     dat1.setCellValueFactory(new PropertyValueFactory <>("date_article"));
     sou1.setCellValueFactory(new PropertyValueFactory <>("sources"));
    a();
    }    

    @FXML
    private void modifierarticle(ActionEvent event) {  
  
   String id=id_article.getText();
   int id3=Integer.parseInt(id);
   String nom1=nomarticle1.getText();
   String descriptionart=descriptionarticle1.getText();
    LocalDate date_article = dateajout1.getValue();
    Date date = Date.valueOf(date_article);
    String categorie=(String)categories1.getValue();
    String sources= source1.getText();
   Article a = new Article(id3,nom1,descriptionart,date,categorie,sources);
  
        try { 
            if (JOptionPane.showConfirmDialog (null,"confirmer la modification","modification",
                 JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                 if(canInscription)
                art.modifierArticle(a);     
                
            } 
        } catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de modifier");
        System.err.println(e);
         Articlegestion art = new Articlegestion();
   ArrayList<Article> articles= (ArrayList<Article>) art.afficherArticle();  
   ObservableList<Article> data = FXCollections.observableArrayList(articles);
     table_article.getItems().clear();
     table_article.setItems(data);
     id1.setCellValueFactory(new PropertyValueFactory <>("id"));
     nom_art.setCellValueFactory(new PropertyValueFactory <>("nom_article"));
     descr_art.setCellValueFactory(new PropertyValueFactory <>("descriptionarticle"));
     cat1.setCellValueFactory(new PropertyValueFactory <>("categorie"));
     dat1.setCellValueFactory(new PropertyValueFactory <>("date_article"));
     sou1.setCellValueFactory(new PropertyValueFactory <>("sources"));
    }
    
    }

    @FXML
    private void supprimerarticle(ActionEvent event){ 
  
     String id=id_article.getText();
     int id3=Integer.parseInt(id.trim());
     Article a = new Article(id3);
     Articlegestion a1=new Articlegestion();
    
     
        try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer artcile,est ce que tu et sure?"
                     ,"supprimer etudient",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
             {
             a1.supprimerArticle(a);
             JOptionPane.showMessageDialog(null,"l'article est supprimé !");
             }
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ nom !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());
   

    }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
                 Parent page = FXMLLoader.load(getClass().getResource("/fxml/Admin_interface.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
                
    }

    @FXML
    private void actualiser(ActionEvent event) {
     Articlegestion art = new Articlegestion();
    ArrayList<Article> articles= (ArrayList<Article>) art.afficherArticle();  
   ObservableList<Article> data = FXCollections.observableArrayList(articles);
   table_article.getItems().clear();
     table_article.setItems(data);
     id1.setCellValueFactory(new PropertyValueFactory <>("id"));
     nom_art.setCellValueFactory(new PropertyValueFactory <>("nom_article"));
     descr_art.setCellValueFactory(new PropertyValueFactory <>("descriptionarticle"));
     cat1.setCellValueFactory(new PropertyValueFactory <>("categorie"));
     dat1.setCellValueFactory(new PropertyValueFactory <>("date_article"));
     sou1.setCellValueFactory(new PropertyValueFactory <>("sources"));
    }



  

}
    
