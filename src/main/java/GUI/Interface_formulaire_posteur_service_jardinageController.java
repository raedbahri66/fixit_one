/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Offre;
import entites.Posteur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.PosteurService;
import service.gestion_offre_service;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Interface_formulaire_posteur_service_jardinageController implements Initializable {

        @FXML
    private TextField Label_adresse;

    @FXML
    private DatePicker Label_date;

    @FXML
    private TextField Label_tel;

    @FXML
    private TextArea Label_description;

    @FXML
    private Button Btn_ajouter_service;

    @FXML
    private TextField Label_heure;
    public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;}

    /**
     * Initializes the controller class.
     */
    public boolean canInscription= true;
    Posteur p = new Posteur();
    
    @FXML
    void Ajouter_offre_service(ActionEvent event) throws SQLException, IOException, ParseException {
        PosteurService p = new PosteurService();
        Posteur p1= new Posteur();
        p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
        
        
        int idposteur=p1.getId();
        String nomposteur=p1.getNom();
        String prenomposteur=p1.getPrenom();
        String etatoffre="en-attente";
        String date8 = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
         LocalDate LCD =Label_date.getValue();
         Date datess = Date.valueOf(LCD);
      
       
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date9 =  sdf.parse(date8);
        if (datess.before(date9))
        {JOptionPane.showMessageDialog(null, "Date Invalide");
        canInscription=false;}
        if(Label_adresse.getText().isEmpty()){
            canInscription = false;}
        
        if(Label_heure.getText().isEmpty()){
            canInscription = false;}
        if(Label_tel.getText().isEmpty()){
            canInscription = false;}
        if(Label_description.getText().isEmpty()){
            canInscription = false;}
        
     
        
        
        if(canInscription){
        
        String adresse = Label_adresse.getText();
        String Description = Label_description.getText();
        String Tel = Label_tel.getText();
        String Heure =Label_heure.getText();
        String Nomservice ="Electricité";
       
         String date = LCD.toString();
         Offre O = new Offre(adresse,date ,Heure ,Description,Tel,idposteur,etatoffre,nomposteur,prenomposteur,Nomservice);
        gestion_offre_service g = new gestion_offre_service();
              g.creerOffre(O);
              JOptionPane.showMessageDialog(null, "votre details du service sont enregistré");
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/Interface_choisir_jobeur.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    }
    else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

       }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label_date.setValue(NOW_LOCAL_DATE());
        // TODO
    } 
}
