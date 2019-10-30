/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import static API.CAM.Capture;
import API.Payment;

import service.GestionProduit;
import entites.Produit;
import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import com.stripe.exception.StripeException;
import entites.Echange;
import entites.Favoris;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ControleSaisie;
import service.EchangeGestion;
import service.GestionFavoris;
import service.JobeurService;
import service.PosteurService;
import entites.Offre;
import entites.annonce;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseButton;
import service.gestion_offre_service;
import service.gestionannonce;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Posteur_interfaceController implements Initializable {
    public String Service_choisi = "";
    
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
    private TableColumn<Produit,String> table_date1;
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
    private Label validation_produit1;
    @FXML
    private Label validation_numero1;
    @FXML
    private Label validation_prix1;
     @FXML
    private Label validation_description1;
    @FXML
    private Label validation_produit;
    @FXML
    private Label validation_numero;
    @FXML
    private Label validation_prix;
    @FXML
    private Label validation_categorie;
    @FXML
    private Label validation_description;
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
    private Label datelocal;
    @FXML
    private Label statut2;
    @FXML
    private ComboBox<String> categorie_produit;
    
    @FXML
    private Label afficher_date;
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
    public ObservableList<Produit> data3;
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
    private TableView<Echange> tablemesproposition;
       @FXML
    private TableColumn<Echange, String> tabid;

    @FXML
    private TableColumn<Echange, String> tabmpof;

    @FXML
    private TableColumn<Echange, String> tabmpos;

    @FXML
    private TableColumn<Echange, String> tabd;

    @FXML
    private TableColumn<Echange, String> tabdatem;

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
     @FXML
    private TableView<Offre> Table_panier_service;

    @FXML
    private TableColumn<Offre, String> Column_adress;

    @FXML
    private TableColumn<Offre, String> Column_date;

    @FXML
    private TableColumn<Offre, String> Column_heure;

    @FXML
    private TableColumn<Offre, String> Column_description;

    @FXML
    private TableColumn<Offre, String> Column_etat;
     @FXML
    private TableColumn<Offre, String> Column_Nomservice;

     @FXML
    private TextField idme;
      @FXML
    private DatePicker textdat;
    @FXML
    private TabPane tabheni_m;
    @FXML
    private TableView table_annonce;
    @FXML
    private TableColumn<?, ?> nom_annonce;
    @FXML
    private TableColumn<?, ?> adresse;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> tel;
    @FXML
    private TableColumn<?, ?> prix;
   
    @FXML
    private TextField Nomann;
    @FXML
    private TextField adrann;
    @FXML
    private TextArea descann;
    @FXML
    private TextField telann;
    @FXML
    private TextField prixann;
    @FXML
    private DatePicker dateann;
    @FXML
    private Tab modifheni_tab;
    @FXML
    private TextField modif_nomannonce;
    @FXML
    private TextField modif_adresseannonce;
    @FXML
    private TextArea modif_descannonce;
    @FXML
    private TextField modif_prix;
    @FXML
    private DatePicker modif_date;
    @FXML
    private TextField idheni;
    @FXML
    private TableView table_annonce1;
    @FXML
    private TableColumn<?, ?> id1;
    @FXML
    private TableColumn<?, ?> nom_annonce1;
    @FXML
    private TableColumn<?, ?> adresse1;
    @FXML
    private TableColumn<?, ?> date1;
    @FXML
    private TableColumn<?, ?> description1;
    @FXML
    private TableColumn<?, ?> etat1;
    @FXML
    private TableColumn<?, ?> tel1;
    @FXML
    private TableColumn<?, ?> prix1;
      @FXML
    private Label vprof;

    @FXML
    private Label vpros;

    @FXML
    private Label vdp;

    @FXML
    private Label vdap;
    
     @FXML
    private Label idpanier;
    @FXML
    private Label produit_panier;
    @FXML
    private Label prix_panier;
   @FXML
    private Label nom_produit_acheter;
    @FXML
    private Label nom_proprietaire11;
    @FXML
    private Label prix_payer;
    @FXML
    private Label frais_payment;
    @FXML
    private Label montant_total;
    @FXML
    private Label idproduitacheter;
       
   
    @FXML
    private TextField numero_carte;
    @FXML
    private TextField mois_validite;
    @FXML
    private TextField year_validite;
    @FXML
    private TextField cvc;
    @FXML
    private Label date_validation;
    @FXML
    private Label mois_validation;
    @FXML
    private Label card_validation;
    @FXML
    private Label cvc_validation;
     @FXML
    private Button voirpdf;
       @FXML
    private Button anglais;

    @FXML
    private Button arabe;
        @FXML
    private Button programmation;
            @FXML
    private TableColumn<Echange, String> tabletel;
    
       @FXML
    void voirpdffrancais(ActionEvent event) {
 try
        {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\iheb\\Documents\\NetBeansProjects\\fixit_one\\src\\main\\resources\\Image\\document_complet.pdf");
        }catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, "error");
        }
    }
     @FXML
    void apprendreanglais(ActionEvent event) {
         try
        {
         Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\iheb\\Documents\\NetBeansProjects\\fixit_one\\src\\main\\resources\\Image\\anglais-pln.pdf");
        }catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, "error");
        }

    }

    @FXML
    void apprendrearabe(ActionEvent event) {
        try
        {
         Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\iheb\\Documents\\NetBeansProjects\\fixit_one\\src\\main\\resources\\Image\\ar_barab_kazana.pdf");
        }catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, "error");
        }

    }
      @FXML
    void apprendreprogrammation(ActionEvent event) {
         try
        {
         Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\iheb\\Documents\\NetBeansProjects\\fixit_one\\src\\main\\resources\\Image\\polyX2003.pdf");
        }catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, "error");
        }

    }
    
    
    
    
    
    public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }
    @FXML
    private TableColumn<?, ?> id_h;
    @FXML
    private TabPane produitpane;
    @FXML
    private Button btnajouterpanier;
    @FXML
    private Tab panier;
    @FXML
    private Label nom_proprietaire12;
    
  
    
  
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
    private void OnkeyTypedfilter(KeyEvent event) throws SQLException {
        //String fil=combo_filter.getValue().toString();
       /*String a=event.getCharacter();
         ab=ab.concat(a);*/
 
         String msg = recherche_produit.getText().concat("%");
   GestionProduit GS = new GestionProduit();
   ArrayList Produit1= (ArrayList)GS.RechercheNom(msg);
    data= FXCollections.observableArrayList(Produit1);

        table.getItems().clear();
        table.setItems(data);
        table_nom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
         table_id.setCellValueFactory(new PropertyValueFactory<Produit,String>("id"));
            table_description.setCellValueFactory(new PropertyValueFactory<Produit,String>("description"));
                table_prix.setCellValueFactory(new PropertyValueFactory<Produit,String>("prix"));
                table_categorie.setCellValueFactory(new PropertyValueFactory<Produit,String>("categorie"));
                table_num.setCellValueFactory(new PropertyValueFactory<Produit,String>("numero"));
                table_proprietere.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom_proprietere"));
                table_date1.setCellValueFactory(new PropertyValueFactory<Produit,String>("date1"));

    }
    
    
    
    
    
    
    
    
    public boolean canInscription=true;
    @FXML
    void addaction(ActionEvent event) throws SQLException, IOException {
        
        PosteurService p = new PosteurService();
        Posteur p1= new Posteur();
        p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
        
          ControleSaisie C= new ControleSaisie();
          if(nom_produit.getText().isEmpty())
        {canInscription = false;  validation_produit.setText("Champ vide");}
          else if(!nom_produit.getText().isEmpty()) validation_produit.setText("");
          
          
        if(!C.isInt(prix_produit.getText()) )
        {canInscription = false; validation_prix.setText("Inccorect Prix");} 
        else if (C.isInt(prix_produit.getText()) ) { validation_prix.setText("");}
        
        if (!C.cinisValid(numero.getText()) )
        {canInscription = false; validation_numero.setText("Inccorect Numero");} 
        else if(C.cinisValid(numero.getText())){validation_numero.setText("");}
        
        if(prix_produit.getText().isEmpty())
        {canInscription = false;  validation_prix.setText("Champ vide");}
        else if(!prix_produit.getText().isEmpty()&&C.isInt(prix_produit.getText())) validation_prix.setText("");
        
        if(numero.getText().isEmpty())
        {canInscription = false;  validation_numero.setText("Champ vide");}
        else if(!numero.getText().isEmpty()&&C.cinisValid(numero.getText())) validation_numero.setText("");
        
        //if(categorie_produit.getValue()!="Jardinage"||categorie_produit.getValue()!="Informatique"||categorie_produit.getValue()!="Batimmant"||categorie_produit.getValue()!="Electromenager"||categorie_produit.getValue()!="Electricité")
        //{canInscription = false;  validation_categorie.setText("Champ vide");}
     //else  validation_categorie.setText("");
       
        if(description_produit.getText().isEmpty())
        {canInscription = false;  validation_description.setText("Champ vide");}
        else if(!description_produit.getText().isEmpty()) validation_description.setText("");
        
        
        
        
        if(canInscription){
        int idposteur=p1.getId();
        String nom=nom_produit.getText();
        String desc=description_produit.getText();
        String prix=prix_produit.getText();
        String categorie=categorie_produit.getValue().toString();
        String num=numero.getText();
        String etatvente="non_vendu";
        int idjobeur = 0;
        
        datelocal.setText(NOW_LOCAL_DATE().toString());
        String date=datelocal.getText();
        String nomproprietere=p1.getNom();
        String etatvalidation="non_valider";
        Produit E = new Produit(nom,prix,desc,categorie,num,etatvente,etatvalidation,idposteur,idjobeur,nomproprietere,date);
        GestionProduit gs = new  GestionProduit();
        gs.ajouterProduit(E);
          JOptionPane.showMessageDialog(null, "Produit Ajouter avec succée");
        nom_produit.setText("");
        prix_produit.setText("");
        description_produit.setText("");       
        categorie_produit.setValue("");
        numero.setText(Integer.toString(p1.getTel()));
        refrech();
        validation_prix.setText("");
        validation_numero.setText("");
        validation_produit.setText("");
        }
        else{ canInscription = true;}

    }

   
    
    
    @FXML
    void ajouter_panier(ActionEvent event) {
        
        nom_produit_acheter.setText(produit_panier.getText());
        nom_proprietaire11.setText(nom_proprietaire.getText());
        prix_payer.setText(prix_panier.getText());
        idproduitacheter.setText(idpanier.getText());
        
        int prix=Integer.parseInt(prix_payer.getText());
        int frais=(int) (prix*0.02);
        frais_payment.setText(Integer.toString(frais));
        int prixtotal=frais+prix;
        montant_total.setText(Integer.toString(prixtotal));
       JOptionPane.showMessageDialog(null, "Produit ajouter avec succées vous devez consultez votre panier pour finaliser le paymment");

    }
    
    public boolean controlepayment=true;
       @FXML
    void bnt_payment(ActionEvent event) throws StripeException {
       
   
     
     
          if(year_validite.getText().isEmpty())
        {controlepayment = false;  date_validation.setText("Champ vide");}
          else if(!year_validite.getText().isEmpty()){ date_validation.setText("");}
       if(mois_validite.getText().isEmpty())
        {controlepayment = false;  mois_validation.setText("Champ vide");}
          else if(!mois_validite.getText().isEmpty()){ mois_validation.setText("");}
        if(cvc.getText().isEmpty())
        {controlepayment = false;  cvc_validation.setText("Champ vide");}
          else if(!cvc.getText().isEmpty()) {cvc_validation.setText("");}
    if(numero_carte.getText().isEmpty())
        {controlepayment = false;  card_validation.setText("Champ vide");}
          else if(!numero_carte.getText().isEmpty()) {card_validation.setText("");}
    
    if (  "".equals(montant_total.getText())){
        JOptionPane.showMessageDialog(null, "Veuillez choisir un produit");
        controlepayment = false;
    }
    
    
    
    if(controlepayment){
             String cvc1=cvc.getText();
     String mois=mois_validite.getText();
     String year=year_validite.getText();
     String numC=numero_carte.getText();
    int prix=Integer.parseInt(montant_total.getText()); 
    Payment p=new Payment(); 
     ControleSaisie C= new ControleSaisie();
      int  mois2=Integer.parseInt(mois);
      int year2=Integer.parseInt(year);  
    if(p.Paymment(prix,numC,mois2,year2,cvc1)==true)
    {
    String id=idproduitacheter.getText();
    Produit E = new Produit(id);
   GestionProduit gs = new  GestionProduit();
     gs.modifierEtatProduit(E);
      JOptionPane.showMessageDialog(null, "Paymment effectuer avec succeés");
      nom_produit_acheter.setText("");
        nom_proprietaire11.setText("");
        prix_payer.setText("");
        idproduitacheter.setText("");
      montant_total.setText("");
      numero_carte.setText("");
      year_validite.setText("");
      mois_validite.setText("");
              cvc.setText("");
              frais_payment.setText("");
      refrech();
    }
    else{JOptionPane.showMessageDialog(null, "Erreur de paymment veuillez verifier vos données ");}
    
    
    
   
    
    
    }
    
     else{ controlepayment = true;}
  
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    public boolean controlemodifier=true;
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
   
   
    ControleSaisie C= new ControleSaisie();
          if(nom2.getText().isEmpty())
        {controlemodifier = false;  validation_produit1.setText("Champ vide");}
          else if(!nom2.getText().isEmpty()) validation_produit1.setText("");
          
         
        if(!C.isInt(prix2.getText()) )
        {controlemodifier = false; validation_prix1.setText("Inccorect Prix");} 
        else if (C.isInt(prix2.getText()) ) { validation_prix1.setText("");}
      
        if (!C.cinisValid(numero1.getText()) )
        {controlemodifier = false; validation_numero1.setText("Inccorect Numero");} 
        else if(C.cinisValid(numero1.getText())){validation_numero1.setText("");}
          
        if(prix2.getText().isEmpty())
        {controlemodifier = false;  validation_prix1.setText("Champ vide");}
        else if(!prix2.getText().isEmpty()&&C.isInt(prix2.getText())) validation_prix1.setText("");
        
        if(numero1.getText().isEmpty())
        {controlemodifier = false;  validation_numero1.setText("Champ vide");}
        else if(!numero1.getText().isEmpty()&&C.cinisValid(numero1.getText())) validation_numero1.setText("");
        
        if(description2.getText().isEmpty())
        {controlemodifier = false;  validation_description1.setText("Champ vide");}
        else if(!description2.getText().isEmpty()) validation_description1.setText("");
        
        
   
   
   if(controlemodifier){
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
    }
   catch(Exception e)
    {
       System.out.println(e.getMessage());  
    }
    }
    
    else{ controlemodifier = true;}
    
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
                table_date1.setCellValueFactory(new PropertyValueFactory<Produit,String>("date1"));
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
             afficher_date.setText(A.getDate1());
                idpanier.setText(A.getId());
                prix_panier.setText(A.getPrix());
                produit_panier.setText(A.getNom());
                
                
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
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service_jardinage.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
     
          

    }

    @FXML
    void Menage(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service_menage.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();

    }

    @FXML
    void Plomberie(ActionEvent event)throws IOException {
         Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service_plomberie.fxml"));
         Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();

    }

    @FXML
    void Renovation(ActionEvent event)throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service_renovation.fxml"));
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
          
          @FXML
   public void utilisertableechange() {
        tablemesproposition.setOnMouseClicked(new EventHandler<MouseEvent>()
         {
             @Override
             public void handle(MouseEvent event) {
                Echange E=tablemesproposition.getItems().get(tablemesproposition.getSelectionModel().getSelectedIndex());
               idme.setText(E.getId());
                filedpof.setText(E.getPropositionofferte());
                filedpos.setText(E.getPropositionsouhaitée());
              fileddes.setText(E.getDescription_echange());
                 String date1=E.getDate();
                                   LocalDate date2 = LocalDate.parse(date1);
                  textdat.setValue(date2);
             }
         });

    }   
           

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            afficher_panier_offre();
        } catch (SQLException ex) {
            Logger.getLogger(Posteur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Posteur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        // TODO
        //*******heni
        table_annonce1.setOnMouseClicked((MouseEvent event) -> {
     
             if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
         annonce an = (annonce) table_annonce1.getItems().get(table_annonce1.getSelectionModel().getSelectedIndex());
         //id.setText(an.getId());
                        tabheni_m.getSelectionModel().select(modifheni_tab);

         idheni.setText(String.valueOf((an.getId())));
         //date.setText(p1.getDate().toString());
         modif_nomannonce.setText(an.getNom_annonce());
         modif_adresseannonce.setText(an.getAdress());
         modif_date.setValue(an.getDate().toLocalDate()); 
         //description1.setValue(an.getDate().toLocalDate());
         modif_descannonce.setText(an.getDescription_annonce());   
         
         modif_prix.setText(String.valueOf(an.getPrix()));
         }
                 if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){
         annonce an = (annonce) table_annonce1.getItems().get(table_annonce1.getSelectionModel().getSelectedIndex());
         //id.setText(an.getId());

         idheni.setText(String.valueOf((an.getId())));
                 }});  
         df_date1.setValue(NOW_LOCAL_DATE());
                dateann.setValue(NOW_LOCAL_DATE());
                
                 gestionannonce an= new gestionannonce();
        ArrayList<annonce> annonces=(ArrayList<annonce>) an.afficherannonce();
        ObservableList<annonce> ans=FXCollections.observableArrayList(annonces);
        table_annonce.setItems(ans);
        id_h.setCellValueFactory(new PropertyValueFactory<>("id") );
        nom_annonce.setCellValueFactory(new PropertyValueFactory<>("Nom_annonce") );
        adresse.setCellValueFactory(new PropertyValueFactory<>("Adress") );
        date.setCellValueFactory(new PropertyValueFactory<>("Date") );
        description.setCellValueFactory(new PropertyValueFactory<>("description_annonce") );
        //etat.setCellValueFactory(new PropertyValueFactory<>("etat_annonce") );
        tel.setCellValueFactory(new PropertyValueFactory<>("tel") );
        prix.setCellValueFactory(new PropertyValueFactory<>("prix") );

        
        
        /******///
        favoris();
        /////
      
        

           tableechangesposteur.setItems(dataeesp);
      
                tablepofp.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionofferte"));
     tableposp.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionsouhaitée"));
            tablepdp.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                 tabledap.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                 tablenpos.setCellValueFactory(new PropertyValueFactory<Echange,String>("nom_posteur"));
                 tabletel.setCellValueFactory(new PropertyValueFactory<Echange,String>("id_jobeurfg"));
                // tableechangesposteur.setItems(dataeesp);*/

        Stage stage = new Stage();
        image_p_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
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

                    
                    
                }       }
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
        if(p1.getDate_naissance()!=null)
        {
       telp_1.setText(Integer.toString(p1.getTel()));
       datep_1.setText(p1.getDate_naissance().toString());
        image_post.setImage(PosteurService.A1);
         System.out.println(PosteurService.A1);
        datep_1.setText(p1.getDate_naissance().toString());

         numero.setText(Integer.toString(p1.getTel()));
        }
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
                table_date1.setCellValueFactory(new PropertyValueFactory<Produit,String>("date1"));
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
 
                 categorie_produit.getItems().addAll("Autre","Jardinage","Electricité","Batimmant","Informatique","Electromenager");
                 categorie_produit2.getItems().addAll("Autre","Jardinage","Electricité","Batimmant","Informatique","Electromenager");
                 categorie_produit3.getItems().addAll("non_vendu","vendu");
                 combobox_filter.getItems().addAll("Tous()","Autre","Jardinage","Electricité","Batimmant","Informatique","Electromenager");
                 categorie_produit.setValue("Autre");
                 combobox_filter.setValue("Tous()");
        ArrayList Echange2= (ArrayList)es.affichermesEchange(id); 
        ObservableList datames= FXCollections.observableArrayList(Echange2);
            tablemesproposition.setItems(datames);
            tabid.setCellValueFactory(new PropertyValueFactory<Echange,String>("id"));
                 tabmpof.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionofferte"));
     tabmpos.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionsouhaitée"));
           tabd.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                tabdatem.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                 utilisertableechange();
                // tablenpos.setCellValueFactory(new PropertyValueFactory<Echange,String>("nom_posteur"));
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
        if(!file_image_p.getText().isEmpty()){
        p.modifierProfil(p1,fis,file);
        file_image_p.setText(""); 
        image_post.setImage(null);
        }
        else {p.modifierPosteur(p1);}
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
    private void ajouterechangep(ActionEvent event) throws SQLException, IOException, ParseException, FacebookException {
              // boolean test= true;
                String date8 = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
                // LocalDate locald =dap.getValue();
                // Date dates = Date.valueOf(locald);
      
       
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date9 =  sdf.parse(date8);
                boolean test= true;
        if( pofp.getText().isEmpty()){
           //pofp.getText().setVisible(true);
            test = false;
            vprof.setText("champs vide");
        }
             else if(! pofp.getText().isEmpty()) 
             {
                 vprof.setText("");
          
        }
       if( posp.getText().isEmpty())
         {
           test = false;
            vpros.setText("champs vide"); 
        } else if(! posp.getText().isEmpty()) 
        {
             vpros.setText("");
        }
       if( pdp.getText().isEmpty())
         {
           test = false;
           vdp.setText("champs vide");
        }else if (! vdp.getText().isEmpty())
        {
           vdp.setText(""); 
        }
            LocalDate locald =dap.getValue();
                 Date dates = Date.valueOf(locald);
    
      
             /*if ((dates.before(date9))&&*/ 
             if ((dap.getValue() == null) ||(dates.before(date9)))
         {
           test = false;
           vdap.setText("champs Invalide");
           
         } 
             else
             {
                vdap.setText(""); 
             }
                   
            if(test){
        PosteurService p = new PosteurService();
          Posteur p1= new Posteur();
        p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
        int idposteur1=p1.getId();
        String nomposteur =p1.getNom();
        //String prenomposteur=p1.getPrenom();
          String nomo=pofp.getText();
     String nomf=posp.getText();
       String description=pdp.getText();
  //LocalDate locald =dap.getValue();
        String date10 =locald.toString();
        int idjobeur=p1.getTel();
   Echange E = new Echange(nomo,nomf,description,date10,idposteur1,nomposteur,idjobeur);
  EchangeGestion es = new  EchangeGestion();
   es.ajouterEchange(E);
   JOptionPane.showMessageDialog(null, "ajout avec succes ");
  facebook4j.Facebook facebook = new FacebookFactory().getInstance();
    
    facebook.setOAuthAppId("", "");
  
    String accessTokenString = "EAAjdVZBDPFWIBADMdaOnnL5xLLzy18ZCYW8yNTzAoTCZBAoZAIzh1z0HvIwSLEVKMC9VbU2BRIBdHr6WBdCcZA4cRObmcPRLOwwg49hoglYhP0fPnQd81a4Nxq4A8WP37jY14YUQ5svbqQAtzVZCd8a3nLiQtHCYj8DXl7SZCZBhCdX4xVEM9996bQWhUZCO3cEYZD";
    AccessToken at = new AccessToken(accessTokenString);
    facebook.setOAuthAccessToken(at);
        try{
         
        facebook.postStatusMessage("\n Pubilerpar:"+p1.getNom()+ "\n son numero de telephone est:"+p1.getTel()+ "\n Propositionofferte: "+E.getPropositionofferte()+ "\n Propositionsouhaitée: "+ E.getPropositionsouhaitée() +"\n Description: " + E.getDescription_echange());
      
        }
        catch(FacebookException fex)
        {System.out.println(fex);}
   pofp.setText("");
   posp.setText("");
   pdp.setText("");
  dap.setValue(null);
  refrechtabechange();
   
            }   else 
        {
            //JOptionPane.showMessageDialog(null, "Remplir tous les champs");
                          test = false;
        }
    }
      @FXML
    void OnkeyTypeechange(KeyEvent event) {
        // String msg = repos.getText().concat("%");
          String ech =repos.getText().concat("%");
  dataeesp.clear();
   
       EchangeGestion ES = new EchangeGestion();
   ArrayList Echange= (ArrayList) ES.Rechercheprpo(ech);
    dataeesp= FXCollections.observableArrayList(Echange);
   tableechangesposteur.setItems(dataeesp);
        tablepofp.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionofferte"));
     tableposp.setCellValueFactory(new PropertyValueFactory<Echange,String>("propositionsouhaitée"));
            tablepdp.setCellValueFactory(new PropertyValueFactory<Echange,String>("description_echange"));
                 tabledap.setCellValueFactory(new PropertyValueFactory<Echange,String>("date"));
                 tablenpos.setCellValueFactory(new PropertyValueFactory<Echange,String>("nom_posteur"));
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
    
    Posteur p1= new Posteur();
    int id =p1.getId();
     ArrayList Echange2= (ArrayList)es.affichermesEchange(id); 
        ObservableList datames= FXCollections.observableArrayList(Echange2);
            //tablemesproposition.setItems(datames);
     public void refrechtabechange() {
        
         try
         {
           dataeesp.clear();
           datames.clear();
            System.err.println(AcceuilController.cinlogin);
            PosteurService p = new PosteurService();
            Posteur p1= new Posteur();
            p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
           EchangeGestion eg= new EchangeGestion();
            ArrayList Echange= (ArrayList)eg.afficherEchange();
           
            int id=p1.getId();
            ArrayList Echange2= (ArrayList)eg.affichermesEchange(id);
           dataeesp= FXCollections.observableArrayList(Echange);
           datames= FXCollections.observableArrayList(Echange2);
          tableechangesposteur.setItems(dataeesp);
            tablemesproposition.setItems(datames);
           } catch (SQLException ex) {
            Logger.getLogger(Posteur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Posteur_interfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
   
    
    
    
    @FXML
    void suppmechange(ActionEvent event) {
         String id=idme.getText();
Echange E = new Echange(id);
   //GestionProduit gs = new  GestionProduit();
   es.supprimerEchange(E);
   JOptionPane.showMessageDialog(null, "Supprimer avec succée");
   filedpof.setText("");
   filedpos.setText("");
   fileddes.setText("");
   textdat.setValue(null);
   refrechtabechange();

    }
      @FXML
    void modifiermechange(ActionEvent event) {
       String id=idme.getText();
        String pof=filedpof.getText();
         String pos=filedpos.getText();
   String description=fileddes.getText();
   String date=textdat.getValue().toString();
 Echange E = new Echange(id,pof,pos,description,date);
   EchangeGestion EG = new EchangeGestion();
  
    try{
   EG.modifierEchange(E);
     JOptionPane.showMessageDialog(null, "modifications avec sucess");
    }catch(Exception e)
    {
       System.out.println(e.getMessage());  
    }
     filedpof.setText("");
   filedpos.setText("");
   fileddes.setText("");
   textdat.setValue(null);
   refrechtabechange();

            
    }
    //Oussama//
       
    
    public void afficher_panier_offre() throws SQLException, IOException
    {    PosteurService p = new PosteurService();
            Posteur p1= new Posteur();
            p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
         int o =p1.getId();
         System.out.println(o+"aaaaaaaaaaaaaaaaaaaaaa");
        
        gestion_offre_service gos = new gestion_offre_service();
        ArrayList<Offre> offre2= (ArrayList) gos.afficherOffre(o);
        ObservableList <Offre> data5 = FXCollections.observableArrayList(offre2);
        Table_panier_service.setItems(data5);
     Column_adress.setCellValueFactory(new PropertyValueFactory <Offre,String>("adresse"));
     Column_date.setCellValueFactory(new PropertyValueFactory <Offre,String>("Date_debut"));
     Column_heure.setCellValueFactory(new PropertyValueFactory <Offre,String>("heure"));
     Column_description.setCellValueFactory(new PropertyValueFactory <Offre,String>("description_offre"));
     Column_etat.setCellValueFactory(new PropertyValueFactory <Offre,String>("etatoffre"));
     Column_Nomservice.setCellValueFactory(new PropertyValueFactory <Offre,String>("Nomservice"));
   
    }
     
        
    

    // Oussama//

    @FXML
    private void bt_actualiser(ActionEvent event) {
         gestionannonce an= new gestionannonce();
        ArrayList<annonce> annonces=(ArrayList<annonce>) an.afficherannonce();
        ObservableList<annonce> ans=FXCollections.observableArrayList(annonces);
        table_annonce.getItems().clear();
        table_annonce.setItems(ans);
        id_h.setCellValueFactory(new PropertyValueFactory<>("id") );
        nom_annonce.setCellValueFactory(new PropertyValueFactory<>("Nom_annonce") );
        adresse.setCellValueFactory(new PropertyValueFactory<>("Adress") );
        date.setCellValueFactory(new PropertyValueFactory<>("Date") );
        description.setCellValueFactory(new PropertyValueFactory<>("description_annonce") );
        //etat.setCellValueFactory(new PropertyValueFactory<>("etat_annonce") );
        tel.setCellValueFactory(new PropertyValueFactory<>("tel") );
        prix.setCellValueFactory(new PropertyValueFactory<>("prix") );
    }

    @FXML
    private void bt_ajouterannonce(ActionEvent event) {
         if(Nomann.getText().isEmpty()){
           Nomann.setVisible(true);
            canInscription = false;
           JOptionPane.showMessageDialog (null,"il faut un nom pour l'annonce");
        }
     if(dateann.getValue().toString().isEmpty()){
           dateann.setVisible(true);
            canInscription = false;
           JOptionPane.showMessageDialog (null,"il faut une date pour l'annonce");
        }
     
     if(descann.getText().isEmpty()){
           descann.setVisible(true);
            canInscription = false;
           JOptionPane.showMessageDialog (null,"il faut une description pour l'annonce");
        }
     if(telann.getText().isEmpty()){
           telann.setVisible(true);
            canInscription = false;
           JOptionPane.showMessageDialog (null,"il faut donner votre numero de telephone");}
           
        if(prixann.getText().isEmpty()){
           prixann.setVisible(true);
            canInscription = false;
           JOptionPane.showMessageDialog (null,"il faut un prix pour l'annonce");
        }
  
     if(canInscription){
    String Nmann=Nomann.getText();
    String adressann=adrann.getText();
    
    LocalDate locald = dateann.getValue();
        Date dat = Date.valueOf(locald);
    
    String dscann=descann.getText();
    //String etann=(String) etatann.getValue();
    int tel= Integer.parseInt(telann.getText());
    int prix= Integer.parseInt(prixann.getText());
   
   
     annonce an= new annonce(Nmann,adressann,dat,dscann,tel,prix);
            gestionannonce an1 = new gestionannonce();
              an1.ajouterannonce(an);
              JOptionPane.showMessageDialog(null, "annonce Created Successfull");
     
    
    }
    }

    @FXML
    private void bt_modifierannonce(ActionEvent event) {
        
        if(modif_nomannonce.getText().isEmpty()){
            canModif = false;
        }
        if(modif_adresseannonce.getText().isEmpty()){
            canModif = false;
        }
        if(modif_descannonce.getText().isEmpty()){
            canModif = false;
        }
        if(modif_prix.getText().isEmpty()){
            canModif = false;
        }
        if(canModif)
        {
        LocalDate locald = modif_date.getValue();
        Date date = Date.valueOf(locald);
        gestionannonce an = new gestionannonce();
        annonce an1= new annonce(Integer.parseInt(idheni.getText()),modif_nomannonce.getText(), modif_adresseannonce.getText(),date, modif_descannonce.getText(), Integer.parseInt(modif_prix.getText()));
        an.modifierannonce(an1);
        JOptionPane.showMessageDialog(null, "Account edited Successfull");
        //nomp_1.setText(an1.getNom_annonce());
        //prenomp_1.setText(an1.getAdress());
        //emailp_1.setText(an1.getDescription_annonce());
        //emailp_1.setText(an1.getPrix());
        //modif_prix.setText(String.valueOf(an1.getPrix()));
        //telp_1.setText(Integer.toString(p1.getTel()));
         //datep_1.setText(p1.getDate_naissance().toString());
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canModif = true;
        }
    }

    @FXML
    private void bt_actualiser1(ActionEvent event) {
        gestionannonce an= new gestionannonce();
        ArrayList<annonce> annonces=(ArrayList<annonce>) an.afficherannonce();
        ObservableList<annonce> obs=FXCollections.observableArrayList(annonces);
        table_annonce1.getItems().clear();
        table_annonce1.setItems(obs);
        id1.setCellValueFactory(new PropertyValueFactory<>("id") );
        nom_annonce1.setCellValueFactory(new PropertyValueFactory<>("Nom_annonce") );
        adresse1.setCellValueFactory(new PropertyValueFactory<>("Adress") );
        date1.setCellValueFactory(new PropertyValueFactory<>("Date") );
        description1.setCellValueFactory(new PropertyValueFactory<>("description_annonce") );
        etat1.setCellValueFactory(new PropertyValueFactory<>("etat_annonce") );
        tel1.setCellValueFactory(new PropertyValueFactory<>("tel") );
        prix1.setCellValueFactory(new PropertyValueFactory<>("prix") );
    }

    @FXML
    private void bt_supprimerannonce(ActionEvent event) {
        gestionannonce an= new gestionannonce();
    String id1=idheni.getText();
     int idheni=Integer.parseInt(id1);
     annonce an1 = new annonce(idheni);
     //gestionannonce an1=new gestionannonce();
        try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer annonce,est ce que tu et sure?"
                     ,"supprimer etudient",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
             {
             an.supprimerannonce(an1);
                          JOptionPane.showMessageDialog(null,"annonce supprimé !");
                          bt_actualiser1(event);

      
             }
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ nom !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());
    }
    
    }

    @FXML
    private void Conciergerie2(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_formulaire_posteur_service_conciergerie.fxml"));
         Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void Chosier_ph_bt(ActionEvent event) {
       Image image1=new Image("file:image1.png");
        image_post.setImage(null);
        image_post.setImage(image1);
       // image_post.setImage(new Image("file:/C:/Users/lenovo/Documents/NetBeansProjects/Fixit_one/image1.jpg"));
        file_image_p.setText("C:/Users/lenovo/Documents/NetBeansProjects/Fixit_one/image1.jpg");
    }
    
}
