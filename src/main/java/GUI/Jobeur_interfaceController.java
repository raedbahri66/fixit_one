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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
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
    private TextField apos;

    @FXML
    private TextField apof;

    @FXML
    private TableView<Echange> tableechanges;

    @FXML
    private TableColumn<Echange, String> idechanges;

    @FXML
    private TableColumn<Echange, String> propositionoff;

    @FXML
    private TableColumn<Echange, String> propositionsou;

    @FXML
    private TableColumn<Echange, String>Descriptionechanges;

    @FXML
    private TableColumn<Echange, String> dateechanges;

    @FXML
    private TableColumn<Echange, String> idjobeurechanges;

    @FXML
    private TableColumn<Echange, String> nomjoubeurechanges;

    @FXML
    private TableColumn<Echange, String> prenomjoubeurechanges;

    @FXML
    private Tab nomechange;

    @FXML
    private TableView<Echange> tablemonechange;

    @FXML
    private TableColumn<Echange, String> idechange;

    @FXML
    private TableColumn<Echange, String> ctpf;

    @FXML
    private TableColumn<Echange, String> ctps;

    @FXML
    private TableColumn<Echange, String>Descriptionechange;

    @FXML
    private TableColumn<Echange, String> dateechange;

    @FXML
    private Button modifierechange;

    @FXML
    private Label propositionsouhaitee;

    @FXML
    private TextField mps;

    @FXML
    private TextArea mde;

    @FXML
    private DatePicker mda;

    @FXML
    private TextField idmp;

    @FXML
    private TextField mpf;



       Echange E=new Echange();
    
      EchangeGestion es = new  EchangeGestion();
       ArrayList Echange= (ArrayList)es.afficherEchange(); 
         public ObservableList data= FXCollections.observableArrayList(Echange);
          public ObservableList data1= FXCollections.observableArrayList(Echange);

    @FXML
    void ajouterechange(ActionEvent event) {
          String nomo=apof.getText();
     String nomf=apos.getText();
       String description=Descriptionpro.getText();
    
   
   
  
  LocalDate locald =dateajoute.getValue();
        String date =locald.toString();
   Echange E = new Echange(nomo,nomf,description,date);
  EchangeGestion es = new  EchangeGestion();
   es.ajouterEchange(E);
   JOptionPane.showMessageDialog(null, "ajout avec succes");
    
            
    

    }

    @FXML
    void modifierechange(ActionEvent event) {
             String id1=idmp.getText();
   String nom1=mpf.getText();
    String nom2=mps.getText();
   
   String description=mde.getText();
  LocalDate locald =mda.getValue();
        String date1 =locald.toString();
        
        Echange E = new Echange(id1,nom1,nom2,description,date1);
   EchangeGestion es = new  EchangeGestion();
   try{
   es.modifierEchange(E);
     JOptionPane.showMessageDialog(null, "modifications avec sucess");
    }catch(Exception e)
    {
       System.out.println(e.getMessage());  
    }
   //RefreshTable() ;*/
   

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
                mpf.setText(E.getPropositionofferte());
         mps.setText(E.getPropositionsouhaitée());
        
                 mde.setText(E.getDescription_echange());
                
                   String date1=E.getDate(); 
                   LocalDate date2 = LocalDate.parse(date1);
                   mda.setValue(date2);
     //String date1=date.toString();
        
                           
          
             }
         });
                 }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //tableechanges.setItems(data);
                         idechanges.setCellValueFactory(new PropertyValueFactory<Echange,String>("id"));
         propositionoff.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionofferte"));
         propositionsou.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionsouhaitée"));
            Descriptionechanges.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                 dateechanges.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                    tableechanges.setItems(data);
                 tablemonechange.setItems(data1);
                 idechange.setCellValueFactory(new PropertyValueFactory<Echange,String>("id"));
                  ctpf.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionofferte"));
                   ctps.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionsouhaitée"));
                  Descriptionechange.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                  dateechange.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                  setValueformtableviewtotext();
                  
                
    }    
    
}
