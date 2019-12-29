/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import API.SMS;
import entites.Article;
import entites.Commentaire;
import entites.Jobeur;
import entites.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.Articlegestion;
import service.CommentaireService;
import service.*;
import static service.gestion_offre_service.id_offre;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Affiche_porfilejobeur_menageController implements Initializable {
     @FXML
    private Button Btn_demande_service;
    @FXML
    private Label cin_J;
    @FXML
    private Label nom_J;
    @FXML
    private Label prenom_J;
    @FXML
    private Label datenaissance_J;
    @FXML
    private Label tele_J;
    @FXML
    private Label Email_J;
    @FXML
    private ImageView photo_profile;
    @FXML
    private TextArea Commentaire;
    @FXML
    private TableColumn<?, ?> Id_C;
    @FXML
    private TableColumn<?, ?> Nom_Pc;
    @FXML
    private TableColumn<?, ?> Prenom_PC;
    @FXML
    private TableColumn<?, ?> Avis_PC;
    @FXML
    private TableColumn <?, ?> Cin_J;
    @FXML
    private TableColumn<?, ?> Cin_P;
     @FXML
    private TableView tab_comment;
     @FXML
    private TextField id_com;
     @FXML
    private TextField cin_posteur;
     @FXML
    private RadioButton favoris_id;
    @FXML
    private RadioButton top;
    @FXML
    private RadioButton flop;
     @FXML
    private Label label_top;
    @FXML
    private Label label_flop;
    
    @FXML
    private Button ajouter_comment;
    @FXML
    private Button modifier_comment;
    @FXML
    private Button supprimer_c;
   
    final ToggleGroup vote = new ToggleGroup();
    
     Boolean canAjout = true;
     PosteurService p = new PosteurService();
     CommentaireService c1=new CommentaireService();
     ArrayList<Commentaire> commentaires= (ArrayList<Commentaire>) c1.afficherCommentaire();
     public  ObservableList<Commentaire>data = FXCollections.observableArrayList(commentaires); 
    
   
    public void AfficheVOTE(){
        int nbdislike;
        int nblike;
        Jobeur A=new Jobeur();
        A=Interface_choisir_jobeur_menageController.jm;
        int cin_jobeur=A.getCin();
        GestionVote v1 =new GestionVote();
        nblike = v1.countlike(cin_jobeur);
        nbdislike = v1.countdislik(cin_jobeur);
        label_top.setText(String.valueOf(nblike));
        label_flop.setText(String.valueOf(nbdislike));
    }
     
       public boolean verfication(){
        String cin_p=cin_posteur.getText();
        int cin_p1 =Integer.parseInt(cin_p);
        int cinlog=AcceuilController.cinlogin;
        if(cinlog==cin_p1){
            return true;
          
        }
        return false;
        
    }
     public void afficher(){
     CommentaireService c1=new CommentaireService();
     ArrayList<Commentaire> commentaires= (ArrayList<Commentaire>) c1.afficherCommentaire();
     ObservableList<Commentaire>data = FXCollections.observableArrayList(commentaires); 
     tab_comment.getItems().clear();
     tab_comment.setItems(data);
     Id_C.setCellValueFactory(new PropertyValueFactory <>("id"));
     Nom_Pc.setCellValueFactory(new PropertyValueFactory <>("nomp"));
     Prenom_PC.setCellValueFactory(new PropertyValueFactory <>("prenomp"));
     Avis_PC.setCellValueFactory(new PropertyValueFactory <>("description"));
     Cin_P.setCellValueFactory(new PropertyValueFactory <>("id_posteur"));
     Cin_J.setCellValueFactory(new PropertyValueFactory <>("id_jobeur"));
   
     }
     public void getid() {
     tab_comment.setOnMouseClicked(new EventHandler<MouseEvent>()
     {
         @Override
         public void handle(MouseEvent event) {
         Commentaire c = (Commentaire) tab_comment.getItems().get(tab_comment.getSelectionModel().getSelectedIndex());
         id_com.setText( String.valueOf((c.getId())));
         
         cin_posteur.setText(String.valueOf(c.getId_posteur()));  
         if(verfication()){
           ajouter_comment.setVisible(false);
            modifier_comment.setVisible (true);
            supprimer_c.setVisible(true);
           Commentaire.setText(c.getDescription());}
           else{
            ajouter_comment.setVisible(true);
            modifier_comment.setVisible (false);
            supprimer_c.setVisible(false);
           }
        
         
               
         }
     });
      } 
   public void ajouterfa(){
    
}

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            top.setToggleGroup(vote);
            flop.setToggleGroup(vote);
            afficher();
            getid();
            Jobeur A=new Jobeur();
            A=Interface_choisir_jobeur_menageController.jm;
            nom_J.setText(A.getNom());
            prenom_J.setText(A.getPrenom());
            String date=A.getDate_naissance().toLocalDate().toString();
            datenaissance_J.setText(date);
            String tele= String.valueOf(A.getTel());
            tele_J.setText(tele);
            Email_J.setText(A.getEmail());
            String cin= String.valueOf(A.getCin());
            cin_J.setText(cin);
            JobeurService j= new JobeurService();
             A=j.getJobeurInfobyCin(A.getCin());
            photo_profile.setImage(JobeurService.A1);
            System.out.println(Interface_choisir_jobeur_menageController.jm);
            Posteur p1=new Posteur();
         
            p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
            int cin_posteurvote=p1.getCin();
            int cin_jobeurvote=A.getCin();
            GestionVote v1 =new GestionVote();
            ajouter_comment.setVisible(true);
            modifier_comment.setVisible (false);
            supprimer_c.setVisible(false);
           
           AfficheVOTE();
           
            
            boolean t=v1.verificationvote(cin_posteurvote,cin_jobeurvote,"nb_like");
            System.out.println("zzzzzzzzzzzz"+t);
            
            if(v1.verificationvote(cin_posteurvote,cin_jobeurvote,"nb_like")){
                System.out.println("zzzzzzzzzzzz"+t);
            top.setSelected(true);}
            else if(v1.verificationvote(cin_posteurvote,cin_jobeurvote,"nb_dislike"))
            flop.setSelected(true);
            else{
              top.setSelected(false);
            flop.setSelected(false);}
            
        } catch (SQLException ex) {
            Logger.getLogger(Affiche_porfilejobeurController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Affiche_porfilejobeurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /******supprimer vote*************/
        top.setOnMouseClicked((MouseEvent event) -> {
         if (event.getButton().equals(MouseButton.SECONDARY) && event.getClickCount() == 1){
              GestionVote v1 =new GestionVote();
        int nbdislike;
        int nblike;
        Jobeur A=new Jobeur();
        A=Interface_choisir_jobeur_menageController.jm;
        int cin_jobeur=A.getCin();
        Posteur p1= new Posteur();
        int cin_posteur=AcceuilController.cinlogin;
        Vote v=new Vote(cin_jobeur,cin_posteur);
        v1.supprimerVote(v, cin_jobeur, cin_posteur); 
        AfficheVOTE();
             try {
                 if(v1.verificationvote(cin_posteur,cin_jobeur,"nb_like")){
                     top.setSelected(true);}
                 else if(v1.verificationvote(cin_posteur,cin_jobeur,"nb_dislike"))
                     flop.setSelected(true);
                 else{
                     top.setSelected(false);
                     flop.setSelected(false);}
             } catch (SQLException ex) {
                 Logger.getLogger(Affiche_porfilejobeurController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }});
        
         flop.setOnMouseClicked((MouseEvent event) -> {
         if (event.getButton().equals(MouseButton.SECONDARY) && event.getClickCount() == 1){
                 GestionVote v1 =new GestionVote();
                 int nbdislike;
                 int nblike;
                 Jobeur A=new Jobeur();
                 A=Interface_choisir_jobeur_menageController.jm;
                 int cin_jobeur=A.getCin();
                 Posteur p1= new Posteur();
                 int cin_posteur=AcceuilController.cinlogin;
                 Vote v=new Vote(cin_jobeur,cin_posteur);
                 v1.supprimerVote(v, cin_jobeur, cin_posteur);
                 AfficheVOTE();
             try {
                 if(v1.verificationvote(cin_posteur,cin_jobeur,"nb_like")){
                     
                     top.setSelected(true);}
                 else if(v1.verificationvote(cin_posteur,cin_jobeur,"nb_dislike"))
                     flop.setSelected(true);
                 else{
                     top.setSelected(false);
                     flop.setSelected(false);}
             } catch (SQLException ex) {
                 Logger.getLogger(Affiche_porfilejobeurController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }});
    }    

    @FXML
    private void Ajouter_C(ActionEvent event) {
        if(Commentaire.getText().isEmpty()){
           Commentaire.setVisible(true);
            canAjout = false;
           JOptionPane.showMessageDialog (null,"votre avis svp");
        }
           if(canAjout){
        Posteur p1= new Posteur();
               try {
                    p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
               } catch (SQLException ex) {
                   Logger.getLogger(Affiche_porfilejobeurController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Affiche_porfilejobeurController.class.getName()).log(Level.SEVERE, null, ex);
               }
        System.out.println("zzzz"+p1);
        String nom_P2 =p1.getNom();
        System.out.println(nom_P2);
        String prenom_P=p1.getPrenom();
        System.out.println(prenom_P);
        int cin_P=p1.getCin();
        System.out.println("cinpostteur"+cin_P);
        Jobeur A=new Jobeur();
        A=Interface_choisir_jobeur_menageController.jm;
        int cin_j=A.getCin();
        System.out.println("cinjobeur"+cin_j);
        String commentaire=Commentaire.getText(); 
        Commentaire c = new Commentaire(cin_j,cin_P,nom_P2,prenom_P,commentaire);
        CommentaireService c1=new CommentaireService();
        c1.ajoutercCommentaire(c);
      }
    afficher();
    }

    @FXML
    private void Modifier_c(ActionEvent event) {
    String id=id_com.getText();
    int id3=Integer.parseInt(id);
    String comment=Commentaire.getText();
     Commentaire c = new Commentaire(id3,comment);
     CommentaireService c1=new CommentaireService();
     if(verfication()){
      try { 
           
            if (JOptionPane.showConfirmDialog (null,"confirmer la modification","modification",
                 JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                c1.modifierCommentaire(c);  
             ajouter_comment.setVisible(true);
            modifier_comment.setVisible (false);
            supprimer_c.setVisible(false);
            } 
        } catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de modifier");
        System.err.println(e);}}
     else JOptionPane.showMessageDialog(null,"choisir votre avis svp");
  
      afficher();
            ajouter_comment.setVisible(true);
            modifier_comment.setVisible (false);
            supprimer_c.setVisible(false);
           
    }

    @FXML
    private void Supprimer_C(ActionEvent event) {
     String id=id_com.getText();
    int id3=Integer.parseInt(id);
    

     Commentaire c = new Commentaire(id3);
     CommentaireService c1=new CommentaireService();
                    if(verfication()){

      
        try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer votre commentaire,est ce que tu et sure?"
                     ,"supprimer etudient",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
             {
             c1.supprimerCommentaire(c);
             JOptionPane.showMessageDialog(null,"commentaire supprimé");
             ajouter_comment.setVisible(true);
            modifier_comment.setVisible (false);
            supprimer_c.setVisible(false);
             }
             
            else { JOptionPane.showMessageDialog(null,"suppression annuler ");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());}
                    }
 else JOptionPane.showMessageDialog(null," attention choisissiez votre commenatire svp");
    
        afficher();
        ajouter_comment.setVisible(true);
        modifier_comment.setVisible (false);
        supprimer_c.setVisible(false);
    }

    @FXML
    private void Retour(ActionEvent event) {
         Parent root = null;
        try {
             root = FXMLLoader.load(getClass().getResource("/fxml/Interface_choisir_jobeur_menage.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    
    }

    private void favoris(ActionEvent event) {
       Jobeur A=new Jobeur();
       
       GestionFavoris f1=new GestionFavoris();
       A=Interface_choisir_jobeur_menageController.jm;
       int cin_posteur=AcceuilController.cinlogin;
       int cin_jobeur=A.getCin();
       String nomj=A.getNom();
       String prenomJ=A.getPrenom();
       String date=A.getDate_naissance().toLocalDate().toString();
       String tele= String.valueOf(A.getTel());
       String mail=A.getEmail(); 
       String specalité=A.getJob();
     Favoris F =new Favoris(cin_posteur,cin_jobeur,nomj,prenomJ,date,tele,mail,specalité);
     f1.ajouterFavoris(F); 
    }

    @FXML
    private void Demander_Service(ActionEvent event) throws SQLException, IOException {
          Jobeur A=new Jobeur();
             
             GestionFavoris f1=new GestionFavoris();
             A=Interface_choisir_jobeurController.j1;
             int cin_posteur=AcceuilController.cinlogin;
             int cin_jobeur=A.getCin();
             PosteurService p = new PosteurService();
             Posteur pposteur= new Posteur();
             Posteur pjobeur= new Posteur();
             pjobeur=p.getPosteurInfobyCin(cin_jobeur);
            int idpo= pposteur.getTel();
            int idj2=pjobeur.getId();
            
            System.out.println("aaaslemaaaaa"+idj2);
            System.out.println("hetha id offre service"+id_offre);
            gestion_offre_service A1=new gestion_offre_service();
            A1.insererNomjobeur(idj2);
            JOptionPane.showMessageDialog (null," Votre demande à été sauvegardée ");
            SMS.sendSms();       
    }

    @FXML
    private void radio_favoris(ActionEvent event) {
       Jobeur A=new Jobeur();
       GestionFavoris f1=new GestionFavoris();
       A=Interface_choisir_jobeur_menageController.jm;
       int cin_posteur=AcceuilController.cinlogin;
       int cin_jobeur=A.getCin();
       String nomj=A.getNom();
       String prenomJ=A.getPrenom();
       String date=A.getDate_naissance().toLocalDate().toString();
       String tele= String.valueOf(A.getTel());
       String mail=A.getEmail(); 
       String specalité=A.getJob();
     Favoris F =new Favoris(cin_posteur,cin_jobeur,nomj,prenomJ,date,tele,mail,specalité);
     if(favoris_id.isSelected())
     f1.ajouterFavoris(F); 
     else
     f1.supprimerFavoris(F);
        
    }

    @FXML
    private void vote(ActionEvent event) throws SQLException, IOException {
           Jobeur A=new Jobeur();
       A=Interface_choisir_jobeur_menageController.jm;
      int cin_jobeur=A.getCin();
     Posteur p1= new Posteur();
     GestionVote v1 =new GestionVote();
        p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
         int cin_posteur=AcceuilController.cinlogin;
       if(top.isSelected()){
          Vote v=new Vote(cin_posteur,cin_jobeur);
         if(v1.verificationvote1(cin_posteur,cin_jobeur)){
            v1.UpdateVote(v,cin_jobeur,cin_posteur);
             int nblike = v1.countlike(cin_jobeur);
         int nbdislike = v1.countdislik(cin_jobeur);
       Jobeur j=new Jobeur(nblike,nbdislike,cin_jobeur);
       JobeurService p =new JobeurService();
       p.putVote(j);
             AfficheVOTE();
           }
         else{
             v1.ajouterVote(v);
          int nblike = v1.countlike(cin_jobeur);
         int nbdislike = v1.countdislik(cin_jobeur);
          Jobeur j=new Jobeur(nblike,nbdislike,cin_jobeur);
          JobeurService p =new JobeurService();
          p.putVote(j);
             AfficheVOTE();}
      }}


    @FXML
    private void vote_dislike(ActionEvent event) throws SQLException, IOException {
     
     Jobeur A=new Jobeur();
     A=Interface_choisir_jobeur_menageController.jm;
     int cin_jobeur=A.getCin();
     Posteur p1= new Posteur();
     GestionVote v1 =new GestionVote();
      p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
     int cin_posteur=AcceuilController.cinlogin;
     System.out.println(cin_jobeur+" gggggggg"+cin_posteur);
        Vote v=new Vote(cin_jobeur,cin_posteur);
        if(flop.isSelected()){
            boolean z=v1.verificationvote1(cin_posteur,cin_jobeur);
            System.out.println("ouuuuuuh"+z);
         if(v1.verificationvote1(cin_posteur,cin_jobeur)){
                System.out.println("ouuuuuuh"+z);
            v1.UpdateVotedislike(v,cin_jobeur,cin_posteur);
              int nblike = v1.countlike(cin_jobeur);
         int nbdislike = v1.countdislik(cin_jobeur);
          Jobeur j=new Jobeur(nblike,nbdislike,cin_jobeur);
          JobeurService p =new JobeurService();
          p.putVote(j);
             AfficheVOTE();
          ;}
            else
             v1.ajouterVotedislike(v);
           int nblike = v1.countlike(cin_jobeur);
         int nbdislike = v1.countdislik(cin_jobeur);
          Jobeur j=new Jobeur(nblike,nbdislike,cin_jobeur);
          JobeurService p =new JobeurService();
          p.putVote(j);
              AfficheVOTE();
             }
    }
    
}
         
        
        
  
