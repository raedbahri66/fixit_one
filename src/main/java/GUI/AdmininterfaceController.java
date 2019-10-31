/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ModiferArticleController.NOW_LOCAL_DATE;
import entites.Article;
import entites.Service;
import entites.Posteur;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import service.gestion_service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
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
    private Button Btn_ajouter_service;

    @FXML
    private TextArea Label_description;

    @FXML
    private TextField Label_nom;

    @FXML
    private Button Btn_afficher_service;
    @FXML
    private TableView table;
    @FXML
    private TableColumn <?,?> nom;
    @FXML
    private TableColumn <?,?>cat;
    @FXML
    private TableColumn <?,?>dat;
    @FXML
    private TableColumn <?,?>sou;
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
    @FXML
    private TextField file_image_A;
     @FXML
    private Button image_a_btn;
    @FXML
    private ImageView image_article;
    private FileInputStream fis;
    private File file;
    
    /****date de aujourdhui****/
  public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;}
    /**
     * Initializes the controller class.
     */
    /**ayed**/
 
  Boolean canInscription = true;
  Articlegestion art = new Articlegestion();
  ArrayList<Article> articles= (ArrayList<Article>) art.afficherArticle();  
  public ObservableList<Article> data = FXCollections.observableArrayList(articles);
  ObservableList<String> categoriesList= FXCollections.
  observableArrayList("Bricolage","Plomberie","Jardinage","Ménage","Rénovation","Electricité");
    public void initialize(URL url, ResourceBundle rb) {
        PosteurService p= new PosteurService();
        ArrayList<Posteur> pers=(ArrayList<Posteur>) p.afficherPosteur();
         Stage stage = new Stage();
         
    image_a_btn.setOnAction(e->{
            stage.setTitle("File Chooser ");        
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open image File");
            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
            file_image_A.setText(file.getAbsolutePath());
            System.out.println(file.getAbsolutePath()); 
                try {
                fis = new FileInputStream(file);// file is selected using filechooser which is in last tutorial
                 } catch (FileNotFoundException ex) {
            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        } try {
                     
                            URL url1 = file.toURI().toURL();
                            System.out.println(url1);
                            System.out.println("zzz"+url1.toExternalForm());
                            image_article.setImage(new Image(url1.toExternalForm()));
                        } catch (MalformedURLException ex) {
                          
                            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        };
            }});
    
        // TODO
        /******ayeeeeed***///
     dateajout.setValue(NOW_LOCAL_DATE());
     categories.setValue("Bricolage");
     categories.setItems(categoriesList);
     table.setItems(data);
     nom.setCellValueFactory(new PropertyValueFactory <>("nom_article"));
     cat.setCellValueFactory(new PropertyValueFactory <>("categorie"));
     dat.setCellValueFactory(new PropertyValueFactory <>("date_article"));
     sou.setCellValueFactory(new PropertyValueFactory <>("sources"));
  
    }    

    @FXML
    private void btn_posteurgestion(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Posteur_gestion.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();        
    }

    @FXML
    private void btn_jobeurgestion(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Jobeur_gestion.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    }

    @FXML
    private void ajouterArticle(ActionEvent event) {
    
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
         if(canInscription && file_image_A.getText().isEmpty()){
                String nom = nomarticle.getText();
                String descriptionart=descriptionarticle.getText();
                 LocalDate date_article =dateajout.getValue();
                 Date date = Date.valueOf(date_article);
                String sources= source.getText();
                String categorie=(String) categories.getValue();
                Article a = new Article(nom,descriptionart,date,categorie,sources);
                Articlegestion a1=new Articlegestion();
                a1.ajouterArticle(a);
                nomarticle.setText("");
                descriptionarticle.setText("");
                source.setText("");
                file_image_A.setText("");
         }else
        
    if(canInscription&& !file_image_A.getText().isEmpty()){
   String nom = nomarticle.getText();
   String descriptionart=descriptionarticle.getText();
   LocalDate date_article =dateajout.getValue();
   Date date = Date.valueOf(date_article);
   String sources= source.getText();
   String categorie=(String) categories.getValue();
   Article a = new Article(nom,descriptionart,date,categorie,sources);
   Articlegestion a1=new Articlegestion();
   a1.ajouterArticle(a,fis,file);
   nomarticle.setText("");
   descriptionarticle.setText("");
   source.setText("");
   file_image_A.setText("");
   image_article.setImage(null);
  
    }
    Articlegestion art = new Articlegestion();
    ArrayList<Article> articles= (ArrayList<Article>) art.afficherArticle();  
    ObservableList<Article> data = FXCollections.observableArrayList(articles);
     table.getItems().clear();
     table.setItems(data);
     nom.setCellValueFactory(new PropertyValueFactory <>("nom_article"));
     cat.setCellValueFactory(new PropertyValueFactory <>("categorie"));
     dat.setCellValueFactory(new PropertyValueFactory <>("date_article"));
     sou.setCellValueFactory(new PropertyValueFactory <>("sources"));
    }
       @FXML
    void Afficher_service(ActionEvent event)throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/fxml/Interface_afficher_service.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();

    }
    @FXML
    void ajouter_service(ActionEvent event) {
        if(Label_nom.getText().isEmpty()){
            canInscription = false;}
        
        if(Label_description.getText().isEmpty()){
            canInscription = false;}
        
        
        if(canInscription){
            String NomService;
        NomService = Label_nom.getText();
        String Description = Label_description.getText();
           Service S1= new Service(NomService,Description);
           gestion_service g = new gestion_service();
              g.creerService(S1);
              JOptionPane.showMessageDialog(null, "Account Created Successfull");
    }
    else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

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

    @FXML
    private void logout(ActionEvent event) throws IOException {
          Parent root=FXMLLoader.load(getClass().getResource("/fxml/acceuil.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
    }
    }
    

