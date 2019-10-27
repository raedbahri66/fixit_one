/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import service.GestionProduit;
import entites.Produit;
import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import entites.Echange;
import entites.Favoris;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.EchangeGestion;
import service.GestionFavoris;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Posteur_interfaceController implements Initializable {
    
    @FXML
    private Button Btn_electricite;
    @FXML
    private Button Btn_Menage;

    @FXML
    private Button Btn_Plomberie;

    @FXML
    private Button Btn_Renovation;

    @FXML
    private Button Btn_Conciergerie;

    @FXML
    private Button Btn_Jardinage;

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
    private TextField nom_produit;

    @FXML
    private TextField prix_produit;

    @FXML
    private TextArea description_produit;
      @FXML
    private TextField repos;

    @FXML
    private Button rechercherprop;

    
    @FXML
    private Label statut;
    @FXML
    private Label label_statut;

    
     @FXML
    private TableView<Produit> table1;
    @FXML
    private TableColumn<Produit,String> table_nom1;
    @FXML
    private TableColumn<Produit,String> table_prix1;
    @FXML
    private TableColumn<Produit,String> table_categorie1;
    @FXML
    private TableColumn<Produit,String> table_numero1;
    @FXML
    private TableColumn<Produit,String> table_etat_vente;
    @FXML
    private TableColumn<Produit,String> table_etat_validation;
    @FXML
    private TableColumn<Produit,String> table_description1;
    @FXML
    private TableColumn<Produit,String> table_id1;
    
    
    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit,String> table_nom;
    @FXML
    private TableColumn<Produit,String> table_prix;
    @FXML
    private TableColumn<Produit,String> table_num;
    @FXML
    private TableColumn<Produit,String> table_description;
    @FXML
    private TableColumn<Produit,String> table_proprietere;
    
    
    @FXML
    private TableColumn<Produit,String> table_id;
    @FXML
    private TableColumn<Produit,String> table_categorie;
 

   
    @FXML
    private TextField numero;
    
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
    private ComboBox<String> categorie_produit;
    
    @FXML
    private Label nom_proprietaire;
    @FXML
    private Label label_num;
    @FXML
    private Label label_description1;
    @FXML
    private ComboBox<String> combobox_filter;
    @FXML
    private TextField recherche_produit;
    
    
    @FXML
    private TextField numero1;
    @FXML
    private ComboBox<String> categorie_produit2;
    @FXML
    private ComboBox<String> categorie_produit3;
   
       
    public ObservableList<Produit> data;
    public ObservableList<Produit> data1;
    @FXML
    private ImageView image_post;
    @FXML
    private Label nomp_11;
    @FXML
    private TextField file_image_p;
    @FXML
    private Button image_p_btn;
     private FileInputStream fis;
    private File file;
    @FXML
    private TextField pofp;
    @FXML
    private TextField posp;
    @FXML
    private TextArea pdp;
    @FXML
    private DatePicker dap;
    @FXML
    private Button ajoutep;
    @FXML
    private TableView<Echange> tableechangesposteur;
    @FXML
    private TableColumn<Echange,String> tablepofp;
    @FXML
    private TableColumn<Echange, String> tableposp;
    @FXML
    private TableColumn<Echange, String> tablepdp;
    @FXML
    private TableColumn<Echange, String> tabledap;
    @FXML
    private TableColumn<Echange, String> tablenpos;
    @FXML
    private TableView favrois;
    @FXML
    private TableColumn<?, ?> c_nomj;
    @FXML
    private TableColumn<?, ?> c_prenomj;
    @FXML
    private TableColumn<?, ?> c_datej;
    @FXML
    private TableColumn<?, ?> c_specialite;
    @FXML
    private TableColumn<?, ?> c_telej2;
    @FXML
    private TableColumn<?, ?> c_email2;
    @FXML
    private TableView<?> tablemesproposition;

    @FXML
    private TableColumn<?, ?> tabmpof;

    @FXML
    private TableColumn<?, ?> tabmpos;

    @FXML
    private TableColumn<?, ?> tabd;

    @FXML
    private TableColumn<?, ?> tabdatem;

    @FXML
    private Label fileddaj;

    @FXML
    private TextField filedpof;

    @FXML
    private TextField filedpos;

    @FXML
    private TextArea fileddes;

    @FXML
    private Button modifierpro;

    @FXML
    private Button supppro;

    
  
   public void favoris(){
    GestionFavoris gf = new GestionFavoris ();
   ArrayList<Favoris> favroiss= (ArrayList<Favoris>) gf.afficherfavoris(AcceuilController.cinlogin);  
   ObservableList<Favoris> data = FXCollections.observableArrayList(favroiss);
       System.out.println(data);
     favrois.setItems(data);
     c_nomj.setCellValueFactory(new PropertyValueFactory <>("nomj"));
     c_prenomj.setCellValueFactory(new PropertyValueFactory <>("prenomj"));
     c_datej.setCellValueFactory(new PropertyValueFactory <>("datej"));
     c_telej2.setCellValueFactory(new PropertyValueFactory <>("telej"));
     c_email2.setCellValueFactory(new PropertyValueFactory <>("mailj"));
     c_specialite.setCellValueFactory(new PropertyValueFactory <>("specalite"));   
   }
   
 
    
    
    @FXML
    void addaction(ActionEvent event) throws SQLException, IOException {
        
        PosteurService p = new PosteurService();
        Posteur p1= new Posteur();
        p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
        
        
        int idposteur=p1.getId();
        String nom=nom_produit.getText();
        String desc=description_produit.getText();
        String prix=prix_produit.getText();
        String categorie=categorie_produit.getValue().toString();
        String num=numero.getText();
        String etatvente="non_vendu";
        int idjobeur = 0;
        String nomproprietere=p1.getNom();
        String etatvalidation="non_valider";
        Produit E = new Produit(nom,prix,desc,categorie,num,etatvente,etatvalidation,idposteur,idjobeur,nomproprietere);
        GestionProduit gs = new  GestionProduit();
        gs.ajouterProduit(E);
          JOptionPane.showMessageDialog(null, "Produit Ajouter avec succée");
        nom_produit.setText("");
        prix_produit.setText("");
        description_produit.setText("");       
        categorie_produit.setValue("");
        numero.setText(Integer.toString(p1.getTel()));
        refrech();
    }

     @FXML
    void modifierAction(ActionEvent event) {
        
   String nom=nom2.getText();
   String description=description2.getText();
   String prix=prix2.getText();
   String id=label_id.getText();
   String num=numero1.getText();
   String statut=label_statut.getText();
   String categorie=categorie_produit2.getValue().toString();
   String etat=categorie_produit3.getValue().toString();
   Produit E = new Produit(id,nom,prix,description,categorie,num,etat,statut);
   GestionProduit gs = new  GestionProduit();
   try{
   gs.modifierProduit(E);
   JOptionPane.showMessageDialog(null, "Modification avec succée");
   nom2.setText("");
   prix2.setText("");
   description2.setText("");
   categorie_produit2.setValue("");
   categorie_produit3.setValue("");
   numero1.setText("");
   refrech();
    }catch(Exception e)
    {
       System.out.println(e.getMessage());  
    }
    }
   
    @FXML
    void btnsearchAction(ActionEvent event) {
        data.clear();
     String cat =combobox_filter.getValue().toString();
         GestionProduit GS = new GestionProduit();
         // Produit E = new Produit(cat);
   ArrayList Produit1= (ArrayList)GS.RechercheCategorie(cat);
    data= FXCollections.observableArrayList(Produit1);
      table.setItems(data);
        table_nom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
         table_id.setCellValueFactory(new PropertyValueFactory<Produit,String>("id"));
            table_description.setCellValueFactory(new PropertyValueFactory<Produit,String>("description"));
                table_prix.setCellValueFactory(new PropertyValueFactory<Produit,String>("prix"));
                table_categorie.setCellValueFactory(new PropertyValueFactory<Produit,String>("categorie"));
                table_num.setCellValueFactory(new PropertyValueFactory<Produit,String>("numero"));
                table_proprietere.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom_proprietere"));
                clickedtable();   
        
    }
    
    
    
        @FXML
    void SupprimerAction(ActionEvent event) {
        
   String id=label_id.getText();
   Produit E = new Produit(id);
   GestionProduit gs = new  GestionProduit();
   try{
   gs.supprimerProduit(E);
   JOptionPane.showMessageDialog(null, "Supprimer avec succée");
   nom2.setText("");
   prix2.setText("");
   description2.setText("");
   categorie_produit2.setValue("");
   categorie_produit3.setValue("");
   numero1.setText("");
   refrech();
    }catch(Exception e)
    {
       System.out.println(e.getMessage());  
    }
    }
    
   @FXML
     public void clickedtable()
    {
        table.setOnMouseClicked(new EventHandler<MouseEvent>()
         {
             @Override
             public void handle(MouseEvent event) {
                Produit A=table.getItems().get(table.getSelectionModel().getSelectedIndex());
                label_description1.setText(A.getDescription());
                label_num.setText(A.getNumero());
                nom_proprietaire.setText(A.getNomproprietere());
             
                
                
             }
         });
                 }
    
    
    @FXML
          public void setValueformtableviewtotext()
    {
         table1.setOnMouseClicked(new EventHandler<MouseEvent>()
         {
             @Override
             public void handle(MouseEvent event) {
                Produit E=table1.getItems().get(table1.getSelectionModel().getSelectedIndex());
                nom2.setText(E.getNom());
                description2.setText(E.getDescription());
                label_id.setText(E.getId());
                prix2.setText(E.getPrix());
                numero1.setText(E.getNumero());
                categorie_produit2.setValue(E.getCategorie());
                categorie_produit3.setValue(E.getEtatVente());
               
             }
         });
                 }
          
          
   
  public void refrech(){
        try {
            data.clear();
            data1.clear();
            System.err.println(AcceuilController.cinlogin);
            PosteurService p = new PosteurService();
            Posteur p1= new Posteur();
            p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
            GestionProduit GS = new GestionProduit();
            ArrayList Produit1= (ArrayList)GS.afficherProduit();
            GestionProduit GS1= new GestionProduit();
            int id=p1.getId();
            ArrayList Produit2= (ArrayList)GS1.afficherProduit1(id);
            data= FXCollections.observableArrayList(Produit1);
            data1= FXCollections.observableArrayList(Produit2);
            table.setItems(data);
            table1.setItems(data1);
        } catch (SQLException ex) {
            Logger.getLogger(Posteur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Posteur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
  
    @FXML
    void Electricite(ActionEvent event) throws IOException {
         Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();  

    }
     @FXML
    void Jardinage(ActionEvent event)throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
     
        

    }

    @FXML
    void Menage(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();

    }

    @FXML
    void Plomberie(ActionEvent event)throws IOException {
         Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service.fxml"));
         Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();

    }

    @FXML
    void Renovation(ActionEvent event)throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();

    }
     @FXML
    void Conciergerie(ActionEvent event)throws IOException {
         Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service.fxml"));
         Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();

    }
    
    
    public boolean canModif=true;
    /**
     * Initializes the controller class.
     */
    
      EchangeGestion es = new  EchangeGestion();
       ArrayList Echange= (ArrayList)es.afficherEchange(); 
    
           public ObservableList dataeesp= FXCollections.observableArrayList(Echange);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /****ayed**///
        favoris();
        /////
           tableechangesposteur.setItems(dataeesp);
      
                tablepofp.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionofferte"));
     tableposp.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionsouhaitée"));
            tablepdp.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                 tabledap.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                 tablenpos.setCellValueFactory(new PropertyValueFactory<Echange,String>("nom_posteur"));
                // tableechangesposteur.setItems(dataeesp);*/

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
        /////raed///
                df_date1.setValue(NOW_LOCAL_DATE());

        System.err.println(AcceuilController.cinlogin);
        PosteurService p = new PosteurService();
        Posteur p1= new Posteur();
        try {
            p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Posteur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nomp_1.setText(p1.getNom());
        nomp_11.setText(p1.getNom());
        prenomp_1.setText(p1.getPrenom());
        emailp_1.setText(p1.getEmail());
        telp_1.setText(Integer.toString(p1.getTel()));
         datep_1.setText(p1.getDate_naissance().toString());
        image_post.setImage(PosteurService.A1);
         System.out.println(PosteurService.A1);
        datep_1.setText(p1.getDate_naissance().toString());

         numero.setText(Integer.toString(p1.getTel()));
        int id=p1.getId();
    GestionProduit GS = new GestionProduit();
   ArrayList Produit1= (ArrayList)GS.afficherProduit();
    data= FXCollections.observableArrayList(Produit1);
   GestionProduit GS1= new GestionProduit();
    ArrayList Produit2= (ArrayList)GS1.afficherProduit1(id);
   data1= FXCollections.observableArrayList(Produit2);
        table.setItems(data);
        table_nom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
         table_id.setCellValueFactory(new PropertyValueFactory<Produit,String>("id"));
            table_description.setCellValueFactory(new PropertyValueFactory<Produit,String>("description"));
                table_prix.setCellValueFactory(new PropertyValueFactory<Produit,String>("prix"));
                table_categorie.setCellValueFactory(new PropertyValueFactory<Produit,String>("categorie"));
                table_num.setCellValueFactory(new PropertyValueFactory<Produit,String>("numero"));
                table_proprietere.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom_proprietere"));
                clickedtable();
                
        table1.setItems(data1);
          table_nom1.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
          table_id1.setCellValueFactory(new PropertyValueFactory<Produit,String>("id"));
            table_description1.setCellValueFactory(new PropertyValueFactory<Produit,String>("description"));
                 table_prix1.setCellValueFactory(new PropertyValueFactory<Produit,String>("prix"));
                   table_categorie1.setCellValueFactory(new PropertyValueFactory<Produit,String>("categorie"));
                 table_numero1.setCellValueFactory(new PropertyValueFactory<Produit,String>("numero"));
                 table_etat_vente.setCellValueFactory(new PropertyValueFactory<Produit,String>("etatVente"));
                 table_etat_validation.setCellValueFactory(new PropertyValueFactory<Produit,String>("etatValidation"));
                 setValueformtableviewtotext();
 
                 categorie_produit.getItems().addAll("Jardinage","Electricité","Batimmant","Informatique","Electromenager");
                 categorie_produit2.getItems().addAll("Jardinage","Electricité","Batimmant","Informatique","Electromenager");
                 categorie_produit3.getItems().addAll("non_vendu","vendu");
                 combobox_filter.getItems().addAll("Tous()","Jardinage","Electricité","Batimmant","Informatique","Electromenager");
    
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
        PosteurService p = new PosteurService();
        Posteur p1= new Posteur(AcceuilController.cinlogin, tf_nom1.getText(), tf_prenom1.getText(), tef_email1.getText(), date, Integer.parseInt(tf_tel1.getText()));
        p.modifierProfil(p1,fis,file);
        JOptionPane.showMessageDialog(null, "Account edited Successfull");
        nomp_1.setText(p1.getNom());
        nomp_11.setText(p1.getNom());
        prenomp_1.setText(p1.getPrenom());
        emailp_1.setText(p1.getEmail());
        telp_1.setText(Integer.toString(p1.getTel()));
        datep_1.setText(p1.getDate_naissance().toString());
        numero.setText(Integer.toString(p1.getTel()));
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canModif = true;
        }
        
    }

    @FXML
    private void ajouterechangep(ActionEvent event) throws SQLException, IOException {
        PosteurService p = new PosteurService();
          Posteur p1= new Posteur();
        p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
        int idposteur1=p1.getId();
        String nomposteur =p1.getNom();
        //String prenomposteur=p1.getPrenom();
          String nomo=pofp.getText();
     String nomf=posp.getText();
       String description=pdp.getText();
  LocalDate locald =dap.getValue();
        String date =locald.toString();
        int idjobeur=0;
   Echange E = new Echange(nomo,nomf,description,date,idposteur1,nomposteur,idjobeur);
  EchangeGestion es = new  EchangeGestion();
   es.ajouterEchange(E);
   JOptionPane.showMessageDialog(null, "ajout avec succes");
   pofp.setText("");
   posp.setText("");
   pdp.setText("");
  dap.setValue(null);
   

    }
      @FXML
    void rechercherechange(ActionEvent event) throws SQLException {
        
        dataeesp.clear();
     String ech =repos.getText();
       EchangeGestion ES = new EchangeGestion();
   ArrayList Echange= (ArrayList) ES.Rechercheprpo(ech);
    dataeesp= FXCollections.observableArrayList(Echange);
   tableechangesposteur.setItems(dataeesp);
        tablepofp.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionofferte"));
     tableposp.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionsouhaitée"));
            tablepdp.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                 tabledap.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                 tablenpos.setCellValueFactory(new PropertyValueFactory<Echange,String>("nom_posteur"));
                 //table.setItems(dataeesp);
      


    }
    
    @FXML
    void suppmechange(ActionEvent event) {

    }
      @FXML
    void modifiermechange(ActionEvent event) {

    }
    
}
