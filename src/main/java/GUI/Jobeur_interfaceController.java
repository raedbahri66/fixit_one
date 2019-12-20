/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static API.CAM.Capture;
import static GUI.Interface_choisir_jobeurController.j1;
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
import entites.Offre;
import javafx.scene.text.Text;
import service.GestionVote;
import entites.Service;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import service.PosteurService;
import service.gestion_offre_service;

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
    private TextField Label_id;
    @FXML
    private Button Btn_accepter_offre;

    @FXML
    private Button Btn_refuser_offre;
    @FXML
    private TextField Label_nomp;

    @FXML
    private TextField Label_prenomp;

    @FXML
    private TextField Label_telp;
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
    
    @FXML
    private TableView<Offre> Table_offre_jobeur;

    @FXML
    private TableColumn<Offre, String> Column_adresse;

    @FXML
    private TableColumn<Offre, String> Column_date;

    @FXML
    private TableColumn<Offre, String> Column_heure;

    @FXML
    private TableColumn<Offre, String> Column__description;

    @FXML
    private TableColumn<Offre, String> Column__tel;

    @FXML
    private TableColumn<Offre, String> Column_nomp;

    @FXML
    private TableColumn<Offre, String> Column_prenomp;
    @FXML
    private TableColumn<Offre,Integer> Column_id;


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
    private Text label_top;
    @FXML
    private Text label_flop;
    @FXML
    private ImageView logout;
    @FXML
    private TabPane produitpane;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> table_nom;
    @FXML
    private TableColumn<?, ?> table_id;
    @FXML
    private TableColumn<?, ?> table_prix;
    @FXML
    private TableColumn<?, ?> table_categorie;
    @FXML
    private TableColumn<?, ?> table_num;
    @FXML
    private TableColumn<?, ?> table_description;
    @FXML
    private TableColumn<?, ?> table_proprietere;
    @FXML
    private TableColumn<?, ?> table_date1;
    @FXML
    private ComboBox<?> combobox_filter;
    @FXML
    private TextField recherche_produit;
    @FXML
    private Label label_description1;
    @FXML
    private Label nom_proprietaire;
    @FXML
    private Label label_num;
    @FXML
    private Label afficher_date;
    @FXML
    private Button btnajouterpanier;
    @FXML
    private Label idpanier;
    @FXML
    private Label prix_panier;
    @FXML
    private Label produit_panier;
    @FXML
    private ImageView afficher_image;
    @FXML
    private TextField nom_produit;
    @FXML
    private TextField prix_produit;
    @FXML
    private TextArea description_produit;
    @FXML
    private Label statut;
    @FXML
    private ComboBox<?> categorie_produit;
    @FXML
    private TextField numero;
    @FXML
    private Label validation_prix;
    @FXML
    private Label validation_numero;
    @FXML
    private Label validation_produit;
    @FXML
    private Label validation_categorie;
    @FXML
    private Label validation_description;
    @FXML
    private Label datelocal;
    @FXML
    private ImageView image_produit;
    @FXML
    private TextField image_path;
    @FXML
    private Button importAction;
    @FXML
    private TableView<?> table1;
    @FXML
    private TableColumn<?, ?> table_nom1;
    @FXML
    private TableColumn<?, ?> table_prix1;
    @FXML
    private TableColumn<?, ?> table_description1;
    @FXML
    private TableColumn<?, ?> table_categorie1;
    @FXML
    private TableColumn<?, ?> table_numero1;
    @FXML
    private TableColumn<?, ?> table_etat_vente;
    @FXML
    private TableColumn<?, ?> table_etat_validation;
    @FXML
    private TableColumn<?, ?> table_id1;
    @FXML
    private TextField nom2;
    @FXML
    private TextField prix2;
    @FXML
    private Button modifier;
    @FXML
    private TextArea description2;
    @FXML
    private Label label_id;
    @FXML
    private Label statut2;
    @FXML
    private TextField numero1;
    @FXML
    private ComboBox<?> categorie_produit2;
    @FXML
    private ComboBox<?> categorie_produit3;
    @FXML
    private Label label_statut;
    @FXML
    private Label validation_produit1;
    @FXML
    private Label validation_prix1;
    @FXML
    private Label validation_description1;
    @FXML
    private Label validation_numero1;
    @FXML
    private ImageView image_modifier;
    @FXML
    private TextField image_path2;
    @FXML
    private Button importModifier;
    @FXML
    private Tab panier;
    @FXML
    private Label nom_produit_acheter;
    @FXML
    private Label nom_proprietaire11;
    @FXML
    private Label nom_proprietaire12;
    @FXML
    private TextField numero_carte;
    @FXML
    private TextField mois_validite;
    @FXML
    private Label montant_total;
    @FXML
    private Label idproduitacheter;
    @FXML
    private PasswordField cvc;
    @FXML
    private TextField year_validite;
    @FXML
    private Label card_validation;
    @FXML
    private Label mois_validation;
    @FXML
    private Label date_validation;
    @FXML
    private Label cvc_validation;
    @FXML
    private ImageView image_panier;
    @FXML
    private Label prix_payer;
    @FXML
    private Label frais_payment;
    @FXML
    private Label dollar3;
    @FXML
    private Label dollar2;
    @FXML
    private Label dollar1;

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
    @FXML
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
        /////Oussama//
     try {
         afficher_offre_jobeur();
     } catch (SQLException ex) {
         Logger.getLogger(Jobeur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(Jobeur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
     }
     b();
       //Oussama//
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
        
        GestionVote v1 =new GestionVote();
         int nblike = v1.countlike(AcceuilController.cinlogin);
         int nbdislike = v1.countdislik(AcceuilController.cinlogin);
        label_top.setText(String.valueOf(nblike));
        label_flop.setText(String.valueOf(nbdislike));
       Jobeur j=new Jobeur(nblike,nbdislike,AcceuilController.cinlogin);
       p.putVote(j);
        try {
            System.out.println(p.top5());
             } catch (SQLException ex) {
            Logger.getLogger(Jobeur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
            
            ///////////////////////////Raed bahri*//////////////////////////////////
            /*   Table_offre_jobeur.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
            
            
            GestionVote v1 =new GestionVote();
            int nblike = v1.countlike(AcceuilController.cinlogin);
            int nbdislike = v1.countdislik(AcceuilController.cinlogin);
            label_top.setText(String.valueOf(nblike));
            label_flop.setText(String.valueOf(nbdislike));
            Parent root = null;
            try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Validation_offre.fxml"));
            } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            //  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // stage.hide();
            stage.setScene(scene);
            stage.show();
            
            }}); */     
       

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
    
    public void afficher_offre_jobeur() throws SQLException, IOException
    {
       
           
            int  cin_jobeur=AcceuilController.cinlogin;
             gestion_offre_service gos = new gestion_offre_service();
    ArrayList<Offre> offre3= (ArrayList) gos.afficherOffre_Jobeur(cin_jobeur);
    ObservableList<Offre> data6 = FXCollections.observableArrayList(offre3);
       //gos.afficherOffre_Jobeur(cin_jobeur);
        Table_offre_jobeur.setItems(data6);
     Column_adresse.setCellValueFactory(new PropertyValueFactory <Offre,String>("adresse"));
     Column_date.setCellValueFactory(new PropertyValueFactory <Offre,String>("Date_debut"));
     Column_heure.setCellValueFactory(new PropertyValueFactory <Offre,String>("heure"));
     Column__description.setCellValueFactory(new PropertyValueFactory <Offre,String>("description_offre"));
     Column__tel.setCellValueFactory(new PropertyValueFactory <Offre,String>("tel"));
     Column_nomp.setCellValueFactory(new PropertyValueFactory <Offre,String>("nomposteur"));
     Column_prenomp.setCellValueFactory(new PropertyValueFactory <Offre,String>("prenomposteur"));
     Column_id.setCellValueFactory(new PropertyValueFactory <Offre,Integer>("id"));
   
    }
     public void b() {
     Table_offre_jobeur.setOnMouseClicked(new EventHandler<MouseEvent>()
     {
         @Override
         public void handle(MouseEvent event) {
         Offre S = Table_offre_jobeur.getItems().get(Table_offre_jobeur.getSelectionModel().getSelectedIndex());
         Label_nomp.setText(S.getNomposteur());
         Label_prenomp.setText(S.getPrenomposteur());
         Label_telp.setText(S.getTel());
         Label_id.setText(S.getId());
             
         }
     });
             }
       @FXML
    void Accepter_Offre(ActionEvent event) throws SQLException {
        String idoffre =Label_id.getText();
         gestion_offre_service A1=new gestion_offre_service();
            A1.Accepter_Offre_service(idoffre);
            JOptionPane.showMessageDialog (null," L'offre est Accepté ");

    }

    @FXML
    void Refuser_Offre(ActionEvent event) throws SQLException {
        String idoffre =Label_id.getText();
         gestion_offre_service A1=new gestion_offre_service();
            A1.Refuser_Offre_service(idoffre);
            JOptionPane.showMessageDialog (null," L'offre est Refusé ");

    }
     
     

    // Oussama//

    @FXML
    private void Chosier_ph_bt(ActionEvent event) {
        Image image1=new Image("file:image1.png");
        image_post.setImage(null);
        image_post.setImage(image1);
       // image_post.setImage(new Image("file:/C:/Users/lenovo/Documents/NetBeansProjects/Fixit_one/image1.jpg"));
        file_image_p.setText("C:/Users/lenovo/Documents/NetBeansProjects/Fixit_one/image1.jpg");
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

    /*@FXML
    private void clickedtable(SortEvent<C> event) {
    }*/

    @FXML
    private void OnkeyTypedfilter(KeyEvent event) {
    }

    @FXML
    private void btnsearchAction(ActionEvent event) {
    }

    @FXML
    private void ajouter_panier(ActionEvent event) {
    }

    @FXML
    private void addaction(ActionEvent event) {
    }

    @FXML
    private void modifierAction(ActionEvent event) {
    }

    @FXML
    private void SupprimerAction(ActionEvent event) {
    }

    @FXML
    private void bnt_payment(ActionEvent event) {
    }

    @FXML
    private void clickedtable(SortEvent event) {
    }
    
    
}
