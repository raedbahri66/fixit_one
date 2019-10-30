 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import entites.Jobeur;
import entites.Posteur;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static javax.print.DocFlavor.BYTE_ARRAY.PDF;
import static javax.print.DocFlavor.URL.PDF;
import javax.swing.JOptionPane;
import service.ControleSaisie;
import service.JobeurService;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class InscrireJobeurController implements Initializable {

    @FXML
    private TextField id_j;
    @FXML
    private TextField nom_j;
    @FXML
    private TextField prenom_j;
    @FXML
    private TextField email_j;
    @FXML
    private TextField tel_j;
    @FXML
    private PasswordField pass_j;
    @FXML
    private ComboBox sexe_j;
    @FXML
    private DatePicker date_j;
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
    @FXML
    private ComboBox combo_j;
    @FXML
    private TextField file_image_p;
    @FXML
    private Button image_p_btn;
    private FileInputStream fis;
    private File file;
    private FileInputStream pdf;
    private File pdff;
        public boolean canInscription=true;
    @FXML
    private ImageView image_post;
    @FXML
    private TextField address_j;
    @FXML
    private Label address_vali;
    @FXML
    private TextField file_pdf_p1;
    @FXML
    private Button pdf_p_btn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> sexelist = FXCollections.observableArrayList("Homme","Femme");
        ObservableList<String> speclist = FXCollections.observableArrayList("Electricite","Plomberie","Jardinage","Menage","Conciergerie");


        sexe_j.setValue("Homme");
        sexe_j.setItems(sexelist);
        combo_j.setValue("Electricite");
        combo_j.setItems(speclist);
        date_j.setValue(NOW_LOCAL_DATE());
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
        // TODO
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
    
    

    @FXML
    private void btn_inscrirejobeur(ActionEvent event)  {
        ControleSaisie C= new ControleSaisie();
        if(!C.cinisValid(id_j.getText()) ){
            canInscription = false;;
           
        } else cin_valid.setText("Cin must contain 8 numbers");
        
        
        if (C.cinisValid(id_j.getText()) )   cin_valid.setText("Accepted");

        if(nom_j.getText().isEmpty()){
            canInscription = false;
        } else nom_valid.setText("Accepted");

        if(prenom_j.getText().isEmpty()){
            canInscription = false;
        } else prenom_valid.setText("Accepted");

        if(!C.emailisValid(email_j.getText())){
            canInscription = false;
        } else email_valid.setText("Email is correct");
        if(pass_j.getText().isEmpty()){
            
            canInscription = false;
        } else pass_valid.setText("Accepted");
        if(!C.cinisValid(tel_j.getText())){
            canInscription = false;
        } else tel_valid.setText("Accepted");
        if(date_j.getValue().toString().isEmpty()){
            canInscription = false;
        }
            else date_valid.setText("Accepted");
        if(sexe_j.getValue().toString().isEmpty()){
            canInscription = false;
        } else             sex_valid.setText("Accepted");
        if(address_j.toString().isEmpty()){
            canInscription = false;
        } else             address_vali.setText("Accepted");

       if(canInscription){
           int cin = Integer.parseInt(id_j.getText());
        String nom= nom_j.getText();
        String prenom= prenom_j.getText();
        String email= email_j.getText();
        String sexe= (String) sexe_j.getValue();
        String job= (String) combo_j.getValue();
        String address= address_j.getText();

        int tel= Integer.parseInt(tel_j.getText());
        String password= pass_j.getText();
        LocalDate locald = date_j.getValue();
        Date date = Date.valueOf(locald);
        System.out.println(date.getYear());

           Jobeur P1= new Jobeur (cin,nom,prenom,email,sexe,password,date,tel,job,address);
           JobeurService p = new JobeurService();
           System.out.println(fis);
                      System.out.println(file);

           p.creerJobeur(P1,fis,file,pdf,pdff);

       }
       else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

       }
}  
    
}
