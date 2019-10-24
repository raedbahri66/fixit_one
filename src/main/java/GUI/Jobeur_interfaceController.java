/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Echange;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import service.EchangeGestion;

/**
 * FXML Controller class
 *
 * @author lenovo
 */

public class Jobeur_interfaceController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private DatePicker dateajoute;

    @FXML
    private Button ajoutechange;

    @FXML
    private TextArea Descriptionpro;

    @FXML
    private TextField Nom_proposition;

    @FXML
    private TableView<Echange> tableechanges;

    @FXML
    private TableColumn<Echange, String> idechanges;

    @FXML
    private TableColumn<Echange, String> nomechanges;

    @FXML
    private TableColumn<Echange, String> Descriptionechanges;

    @FXML
    private TableColumn<Echange, String> dateechanges;

    @FXML
    private TableColumn<Echange, String> idjobeurechanges;

    @FXML
    private TableColumn<Echange, String> nomjoubeurechanges;

    @FXML
    private TableColumn<Echange, String> prenomjoubeurechanges;

 

    @FXML
    private TableView<Echange> tablemonechange;
    @FXML
    private TextField idmp;

    @FXML
    private TableColumn<Echange, String> idechange;
    @FXML
    private TableColumn<Echange, String> nom_echange;
    
    
    @FXML
    private TableColumn<Echange, String> Descriptionechange;

    @FXML
    private TableColumn<Echange, String> dateechange;

    @FXML
    private Button modifierechange;

    @FXML
    private TextField mNom_proposition;

    @FXML
    private TextArea mDescriptionpro;

    @FXML
    private DatePicker mdateajout;
       Echange E=new Echange();
    
      EchangeGestion es = new  EchangeGestion();
       ArrayList Echange= (ArrayList)es.afficherEchange(); 
         public ObservableList data= FXCollections.observableArrayList(Echange);
          public ObservableList data1= FXCollections.observableArrayList(Echange);

    @FXML
    void ajouterechange(ActionEvent event) {
           String nom=Nom_proposition.getText();
   String description=Descriptionpro.getText();
   
   
  
  LocalDate locald =dateajoute.getValue();
        String date =locald.toString();
   Echange E = new Echange(nom,description,date);
  EchangeGestion es = new  EchangeGestion();
   es.ajouterEchange(E);
   JOptionPane.showMessageDialog(null, "ajout avec succes");
    
            
    

    }

    @FXML
    void modifierechange(ActionEvent event) {
              String id1=idmp.getText();
   String nom1=mNom_proposition.getText();
   String description=mDescriptionpro.getText();
  LocalDate locald =mdateajout.getValue();
        String date1 =locald.toString();
        
        Echange E = new Echange(id1,nom1,description,date1);
   EchangeGestion es = new  EchangeGestion();
   try{
   es.modifierEchange(E);
     JOptionPane.showMessageDialog(null, "modifications avec sucess");
    }catch(Exception e)
    {
       System.out.println(e.getMessage());  
    }
   RefreshTable() ;
   

    }

       public void RefreshTable() 
    {
        data.clear();
   es.afficherEchange();
    ArrayList Echange= (ArrayList)es.afficherEchange(); 
        data= FXCollections.observableArrayList(Echange);
        tablemonechange.setItems(data);
        
        
    }
    @FXML
    void supprimerechange(ActionEvent event) {
          String id1= idmp.getText();
        Echange E= new Echange();
        E.setId(id1);
       
        es.supprimerEchange(E); 
        JOptionPane.showMessageDialog(null, "supp avec sucess ");
      RefreshTable();

    }
     public void setValueformtableviewtotext()
    {
        tablemonechange.setOnMouseClicked(new EventHandler<MouseEvent>()
         {
             @Override
             public void handle(MouseEvent event) {
                  Echange E=tablemonechange.getItems().get(tablemonechange.getSelectionModel().getSelectedIndex());
                idmp.setText(E.getId());
                 mNom_proposition.setText(E.getNom_echange());
                 mDescriptionpro.setText(E.getDescription_echange());
                
                   String date1=E.getDate(); 
                   LocalDate date2 = LocalDate.parse(date1);
                   mdateajout.setValue(date2);
     //String date1=date.toString();
        
                           
          
             }
         });
                 }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tableechanges.setItems(data);
                         idechanges.setCellValueFactory(new PropertyValueFactory<Echange,String>("id"));
         nomechanges.setCellValueFactory(new PropertyValueFactory<Echange,String>("nom_echange"));
            Descriptionechanges.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                 dateechanges.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                 tablemonechange.setItems(data1);
                 idechange.setCellValueFactory(new PropertyValueFactory<Echange,String>("id"));
                  nom_echange.setCellValueFactory(new PropertyValueFactory<Echange,String>("nom_echange"));
                  Descriptionechange.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                  dateechange.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                  setValueformtableviewtotext();
                  
                
    }    
    
}
