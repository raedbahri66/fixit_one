/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Article;
import entites.Commentaire;
import entites.Jobeur;
import entites.Posteur;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.Articlegestion;
import service.CommentaireService;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Affiche_porfilejobeurController implements Initializable {
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
    
     Boolean canAjout = true;
     PosteurService p = new PosteurService();
     CommentaireService c1=new CommentaireService();
     ArrayList<Commentaire> commentaires= (ArrayList<Commentaire>) c1.afficherCommentaire();
     public  ObservableList<Commentaire>data = FXCollections.observableArrayList(commentaires); 
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
         Commentaire.setText(c.getDescription());
         cin_posteur.setText(String.valueOf(c.getId_posteur()));
         
               
         }
     });
      } 
     
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

      afficher();
        getid();
        Jobeur A=new Jobeur();
        A=Interface_choisir_jobeurController.j1;
        nom_J.setText(A.getNom());
        prenom_J.setText(A.getPrenom());
        String date=A.getDate_naissance().toLocalDate().toString();
        datenaissance_J.setText(date);
        String tele= String.valueOf(A.getTel());
        tele_J.setText(tele);
        Email_J.setText(A.getEmail());
        
        String cin= String.valueOf(A.getCin());
        cin_J.setText(cin);
        System.out.println(Interface_choisir_jobeurController.j1);
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
        A=Interface_choisir_jobeurController.j1;
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
                if(verfication())
                c1.modifierCommentaire(c);  
                else
               JOptionPane.showMessageDialog(null,"choisir votre avis svp");
                
            } 
        } catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de modifier");
        System.err.println(e);}}
        else
               JOptionPane.showMessageDialog(null,"choisir votre avis svp");
  
      afficher();
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
             }
             
            else { JOptionPane.showMessageDialog(null,"suppression annuler ");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());}
                    }
 else JOptionPane.showMessageDialog(null," attention choisissiez votre commenatire svp");
    
        afficher();
    }

    @FXML
    private void Retour(ActionEvent event) {
         Parent root = null;
        try {
             root = FXMLLoader.load(getClass().getResource("/fxml/Interface_choisir_jobeur.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    
    }

    @FXML
    private void favoris(ActionEvent event) {
        
    }

    @FXML
    private void Demander_Service(ActionEvent event) {
    }

   
    
}
