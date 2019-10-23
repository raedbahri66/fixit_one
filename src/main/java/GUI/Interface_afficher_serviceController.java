/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Service;
import service.gestion_service;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import utils.ConnexionBD;


/**
 * FXML Controller class
 *
 * @author asus
 */

public class Interface_afficher_serviceController implements Initializable {
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
            Statement ste;
            public boolean canInscription= true;
            
            
    

    @FXML
    private Button Btn_modifier_service;
    @FXML
    private TableView<Service> Table_service;
    @FXML
    private TableColumn<Service,String> Column_nom;
    @FXML
    private TextField Label_nom1;
    @FXML
    private Button Btn_supprimer_service;

    @FXML
    private TextArea Label_description1;
    @FXML
    private TextField Label_id;

    @FXML
    private TableColumn<Service,String> Column_description;
    @FXML
    private TableColumn<Service,String> Column_id;

    /**
     * Initializes the controller class.
     */
    public void ActualiserTab_service()
    {        data.clear();
             gs.afficherService();
         ArrayList Service = (ArrayList)gs.afficherService(); 
        data= FXCollections.observableArrayList(Service);
        Table_service.setItems(data);
      
    }
    public void afficherTab_service()
    {
        
        gs.afficherService();
        Table_service.setItems(data);
     Column_nom.setCellValueFactory(new PropertyValueFactory <Service,String>("nom_service"));
     Column_description.setCellValueFactory(new PropertyValueFactory <Service,String>("description_service"));
     Column_id.setCellValueFactory(new PropertyValueFactory <Service,String>("id"));
   
    }
    gestion_service gs = new gestion_service();
    ArrayList service= (ArrayList) gs.afficherService();
    
    
    public ObservableList data = FXCollections.observableArrayList(service);
 
    
    public void a() {
     Table_service.setOnMouseClicked(new EventHandler<MouseEvent>()
     {
         @Override
         public void handle(MouseEvent event) {
         Service S = Table_service.getItems().get(Table_service.getSelectionModel().getSelectedIndex());
         Label_nom1.setText(S.getNom_service());
         Label_description1.setText(S.getDescription_service());
         Label_id.setText(S.getId());
             
         }
     });
             }
     
    
    @FXML
    public void Modifier_service(ActionEvent event) {
        if(Label_nom1.getText().isEmpty()){
           Label_nom1.setVisible(true);
            canInscription = false;
           JOptionPane.showMessageDialog (null,"il faut un nom ");
        }
         if(Label_description1.getText().isEmpty())
         {
            canInscription = false;
           JOptionPane.showMessageDialog (null," ajouter votre description");
        }
         
   String nom_service=Label_nom1.getText();
   String description_service=Label_description1.getText();
   String id =Label_id.getText();
  
   Service S = new Service(nom_service,description_service,id);
    gestion_service gs =new  gestion_service();
   
        try { 
            if (JOptionPane.showConfirmDialog (null,"confirmer la modification","modification",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                 if(canInscription)
                 gs.modifierService(S);
                 ActualiserTab_service();
                 
                 
                
                }
             
        } catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de modifier");
        System.err.println(e);
    }
        

    }
    
    @FXML
    void SupprimerService(ActionEvent event) {
        
         if(Label_nom1.getText().isEmpty()){
           Label_nom1.setVisible(true);
            canInscription = false;
           JOptionPane.showMessageDialog (null,"il faut un nom ");
        }
         if(Label_description1.getText().isEmpty())
         {
            canInscription = false;
           JOptionPane.showMessageDialog (null," ajouter votre description");
        }
         
   String nom_service=Label_nom1.getText();
   String description_service=Label_description1.getText();
   String id =Label_id.getText();
     Service S = new Service(nom_service,description_service,id);
    gestion_service gs =new  gestion_service();
     
        try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer artcile,est ce que tu et sure?"
                     ,"supprimer etudient",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
              
             gs.supprimerService(S);
             ActualiserTab_service();
            
             
             
             JOptionPane.showMessageDialog(null,"le Service est supprimé !");
             
             
            
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());
    }

    }
    
   

    /**
     *
     */
    

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherTab_service();
        a();
    
       
}}
