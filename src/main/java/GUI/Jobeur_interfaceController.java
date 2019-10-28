/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import entites.Echange;
import entites.Jobeur;
import entites.Posteur;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.EchangeGestion;
import service.JobeurService;
import service.PosteurService;

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
    private FileInputStream fis;
    private File file;
    private FileInputStream pdf;
    private File pdff;
    


       Echange E=new Echange();
    
      EchangeGestion es = new  EchangeGestion();
       ArrayList Echange= (ArrayList)es.afficherEchange(); 
         public ObservableList data= FXCollections.observableArrayList(Echange);
          public ObservableList data1= FXCollections.observableArrayList(Echange);
    @FXML
    private Label nomp_1;
    @FXML
    private Label telp_1;
    @FXML
    private Label emailp_1;
    @FXML
    private Label prenomp_1;
    @FXML
    private Label datep_1;
    @FXML
    private TextField tf_nom1;
    @FXML
    private TextField tf_prenom1;
    @FXML
    private TextField tef_email1;
    @FXML
    private TextField tf_tel1;
    @FXML
    private DatePicker df_date1;
    @FXML
    private ImageView image_post;
    @FXML
    private Label nomp_11;
    @FXML
    private TextField file_image_p;
    @FXML
    private Button image_p_btn;
    private boolean canModif=true;
    @FXML
    private TextField file_pdf_p1;
    @FXML
    private Button pdf_p_btn1;

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
      //////////////////////////////////////////////Raed Bahri///////////////////////////////
              Stage stage = new Stage();

      image_p_btn.setOnAction(e->{
                    stage.setTitle("File Chooser ");
                    
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open image File");
            
                         file = fileChooser.showOpenDialog(stage);
                        if (file != null) {
                                file_image_p.setText(file.getAbsolutePath());
                                System.out.println(file.getAbsolutePath()); 
                        try {
                            fis = new FileInputStream(file);// file is selected using filechooser which is in last tutorial
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(InscrirePosteurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            //     Image image=  new Image(file.toURI().toString());
                            URL url1 = file.toURI().toURL();
                            System.out.println(new Image(url1.toExternalForm()));
                            image_post.setImage(new Image(url1.toExternalForm()));
                        } catch (MalformedURLException ex) {
                          
                            Logger.getLogger(InscrirePosteurController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                                

    }

        });
      pdf_p_btn1.setOnAction(e->{
                    stage.setTitle("File Chooser ");
                    
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Pdf File");
            
                         pdff = fileChooser.showOpenDialog(stage);
                        if (pdff != null) {
                                file_pdf_p1.setText(pdff.getAbsolutePath());
                                System.out.println(pdff.getAbsolutePath()); 
                        try {
                            pdf = new FileInputStream(pdff);// file is selected using filechooser which is in last tutorial
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(InscrirePosteurController.class.getName()).log(Level.SEVERE, null, ex);
                        }


                        try {
                            //     Image image=  new Image(file.toURI().toString());
                            URL url1 = pdff.toURI().toURL();
                            System.out.println(new File(url1.toExternalForm()));
                           // image_post.setImage(new Image(url1.toExternalForm()));
                        } catch (MalformedURLException ex) {
                          
                            Logger.getLogger(InscrirePosteurController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                                

    };
            

        });
      df_date1.setValue(NOW_LOCAL_DATE());

        System.err.println(AcceuilController.cinlogin);
        JobeurService p = new JobeurService();
        Jobeur p1= new Jobeur();
        try {
            p1 = p.getJobeurInfobyCin(AcceuilController.cinlogin);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Posteur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nomp_1.setText(p1.getNom());
        nomp_11.setText(p1.getNom());
        prenomp_1.setText(p1.getPrenom());
        emailp_1.setText(p1.getEmail());
        telp_1.setText(Integer.toString(p1.getTel()));
         datep_1.setText(p1.getDate_naissance().toString());
        image_post.setImage(JobeurService.A1);
         System.out.println(JobeurService.A1);
        datep_1.setText(p1.getDate_naissance().toString());

         ///////////////////////////Raed bahri*//////////////////////////////////
                
    }    

    @FXML
    private void btn_modifprofil(ActionEvent event) {
        if(tf_nom1.getText().isEmpty()){
            canModif = false;
        }
        if(tf_prenom1.getText().isEmpty()){
            canModif = false;
        }
        if(tf_tel1.getText().isEmpty()){
            canModif = false;
        }
        if(tef_email1.getText().isEmpty()){
            canModif = false;
        }
        if(canModif)
        {
        LocalDate locald = df_date1.getValue();
        Date date = Date.valueOf(locald);
        JobeurService p = new JobeurService();
        Jobeur p1= new Jobeur(AcceuilController.cinlogin, tf_nom1.getText(), tf_prenom1.getText(), tef_email1.getText(), date, Integer.parseInt(tf_tel1.getText()));
        p.modifierProfil(p1,fis,file,pdf,pdff);
        JOptionPane.showMessageDialog(null, "Account edited Successfull");
        nomp_1.setText(p1.getNom());
        nomp_11.setText(p1.getNom());
        prenomp_1.setText(p1.getPrenom());
        emailp_1.setText(p1.getEmail());
        telp_1.setText(Integer.toString(p1.getTel()));
        datep_1.setText(p1.getDate_naissance().toString());
        //numero.setText(Integer.toString(p1.getTel()));
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canModif = true;
        }
    }
    
}
