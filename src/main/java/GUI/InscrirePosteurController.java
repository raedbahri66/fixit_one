/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.*;
import java.awt.Desktop;
import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import entites.Posteur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ControleSaisie;
import service.PosteurService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;


/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class InscrirePosteurController implements Initializable {

    @FXML
    private TextField id_p;
    @FXML
    private TextField nom_p;
    @FXML
    private TextField prenom_p;
    @FXML
    private TextField email_p;
    @FXML
    private TextField tel_p;
    @FXML
    private PasswordField pass_p;
    @FXML
    private ComboBox sexe_p;
    @FXML
    private DatePicker date_p;
    @FXML
    private Label cin_valid;
    @FXML
    private Label nom_valid;
    @FXML
    private Label sex_valid;
    @FXML
    private Label pass_valid;
    @FXML
    private Label email_valid;
    @FXML
    private Label prenom_valid;
    @FXML
    private Label tel_valid;
    @FXML
    private Label date_valid;
    public boolean canInscription=true;
    @FXML
    private ImageView image_post;
    @FXML
    private TextField file_image_p;
    

    private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Button image_p_btn;
    private FileInputStream fis;
    private File file;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                ObservableList<String> sexelist = FXCollections.observableArrayList("Homme","Femme");

        sexe_p.setValue("Homme");
        sexe_p.setItems(sexelist);
        date_p.setValue(NOW_LOCAL_DATE());
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

                                

    };
            

        });
        // TODO
        
                }

    @FXML
    private void btn_inscrireposteur(ActionEvent event) {
        ControleSaisie C= new ControleSaisie();
        if(!C.cinisValid(id_p.getText()) ){
            canInscription = false;;
           
        } else cin_valid.setText("Cin must contain 8 numbers");
        
        
        if (C.cinisValid(id_p.getText()) )   cin_valid.setText("Accepted");

        if(nom_p.getText().isEmpty()){
            canInscription = false;
        } else nom_valid.setText("Accepted");

        if(prenom_p.getText().isEmpty()){
            canInscription = false;
        } else prenom_valid.setText("Accepted");

        if(!C.emailisValid(email_p.getText())){
            canInscription = false;
        } else email_valid.setText("Email is correct");
        if(pass_p.getText().isEmpty()){
            
            canInscription = false;
        } else pass_valid.setText("Accepted");
        if(!C.cinisValid(tel_p.getText())){
            canInscription = false;
        } else tel_valid.setText("Accepted");
        if(date_p.getValue().toString().isEmpty()){
            canInscription = false;
        }
            else date_valid.setText("Accepted");
        if(sexe_p.getValue().toString().isEmpty()){
            canInscription = false;
        } else             sex_valid.setText("Accepted");
        

       if(canInscription){
           int cin = Integer.parseInt(id_p.getText());
        String nom= nom_p.getText();
        String prenom= prenom_p.getText();
        String email= email_p.getText();
        String sexe= (String) sexe_p.getValue();

        int tel= Integer.parseInt(tel_p.getText());
        String password= pass_p.getText();
        LocalDate locald = date_p.getValue();
        Date date = Date.valueOf(locald);

           Posteur P1= new Posteur(cin,nom,prenom,email,sexe,password,date,tel);
           PosteurService p = new PosteurService();
           p.creerPosteur(P1,fis,file);

       }
       else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

       }
    }

    @FXML
    private void retour_bt(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/acceuil.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
    }

    
    
}
