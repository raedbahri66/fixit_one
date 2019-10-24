/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Posteur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ControleSaisie;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class PosteurgestionController implements Initializable {
        ObservableList<String> sexelist = FXCollections.observableArrayList("Homme","Femme");


    @FXML
    private TableView table_post;
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
    @FXML
    private TextField id_p1;
    @FXML
    private TextField nom_p1;
    @FXML
    private TextField prenom_p1;
    @FXML
    private TextField email_p1;
    @FXML
    private TextField tel_p1;
    @FXML
    private PasswordField pass_p1;
    @FXML
    private ComboBox sexe_p1;
    @FXML
    private DatePicker date_p1;
    @FXML
    private Label cin_valid1;
    @FXML
    private Label nom_valid1;
    @FXML
    private Label sex_valid1;
    @FXML
    private Label pass_valid1;
    @FXML
    private Label email_valid1;
    @FXML
    private Label prenom_valid1;
    @FXML
    private Label tel_valid1;
    @FXML
    private Label date_valid1;
    @FXML
    private TextField cinsupp_t;
    @FXML
    private Label nom_valid11;
    public boolean canInscription=true;
    public boolean valid= true;
    public boolean valid1= true;
    
    @FXML
    private TableColumn<?, ?> c1_cinp;
    @FXML
    private TableColumn<?, ?> c2_nomp;
    @FXML
    private TableColumn<?, ?> c3_prenomp;
    @FXML
    private TableColumn<?, ?> c4_emailp;
    @FXML
    private TableColumn<?, ?> c5_telp;
    private TableColumn<?, ?> c_datep;
    @FXML
    private TableColumn<?, ?> c_sexep;

     public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }  
     
    @FXML
    private Tab modif_posttab;
    @FXML
    private AnchorPane ancho_modifp;
    @FXML
    private TabPane tabpane1;
    @FXML
    private Tab supp_posttab;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexe_p.setValue("Homme");
        sexe_p.setItems(sexelist);
        date_p.setValue(NOW_LOCAL_DATE());
        sexe_p1.setValue("Homme");
        sexe_p1.setItems(sexelist);
        date_p1.setValue(NOW_LOCAL_DATE());
        ////////////////Afficher///////////
        PosteurService p= new PosteurService();
        ArrayList<Posteur> pers=(ArrayList<Posteur>) p.afficherPosteur();
        ObservableList<Posteur> obs=FXCollections.observableArrayList(pers);
        table_post.setItems(obs);
        c1_cinp.setCellValueFactory(new PropertyValueFactory<>("cin") );
        c2_nomp.setCellValueFactory(new PropertyValueFactory<>("nom") );
        c3_prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        c4_emailp.setCellValueFactory(new PropertyValueFactory<>("email") );
        c5_telp.setCellValueFactory(new PropertyValueFactory<>("tel") );
        c_sexep.setCellValueFactory(new PropertyValueFactory<>("Sexe") );
      
        
    table_post.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                Posteur p0 = new Posteur();
               p0=(Posteur) table_post.getItems().get(table_post.getSelectionModel().getSelectedIndex());
               tabpane1.getSelectionModel().select(modif_posttab);
               nom_p1.setText(p0.getNom());
                prenom_p1.setText(p0.getPrenom());
                sexe_p1.setValue(p0.getSexe());
                date_p1.setValue(p0.getDate_naissance().toLocalDate());
                email_p1.setText(p0.getEmail());
                pass_p1.setText(p0.getPassword());
                tel_p1.setText(Integer.toString(p0.getTel()));
                id_p1.setText(Integer.toString(p0.getCin()));
            }
            else if (event.getButton().equals(MouseButton.SECONDARY) && event.getClickCount() == 1){
                Posteur p0 = new Posteur();
               p0=(Posteur) table_post.getItems().get(table_post.getSelectionModel().getSelectedIndex());
               tabpane1.getSelectionModel().select(supp_posttab);
                cinsupp_t.setText(Integer.toString(p0.getCin()));
            }
        });

        
        // TODO
    }    

    @FXML
    private void btn_actualiser(ActionEvent event) {
        PosteurService p= new PosteurService();
        ArrayList<Posteur> pers=(ArrayList<Posteur>) p.afficherPosteur();
        ObservableList<Posteur> obs=FXCollections.observableArrayList(pers);
        table_post.getItems().clear();
        table_post.setItems(obs);
        c1_cinp.setCellValueFactory(new PropertyValueFactory<>("cin") );
        c2_nomp.setCellValueFactory(new PropertyValueFactory<>("nom") );
        c3_prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        c4_emailp.setCellValueFactory(new PropertyValueFactory<>("email") );
        c5_telp.setCellValueFactory(new PropertyValueFactory<>("tel") );
        c_sexep.setCellValueFactory(new PropertyValueFactory<>("Sexe") );
    }

    @FXML
    private void btn_ajouterposteur(ActionEvent event) {
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
           p.creerPosteur(P1);

       }
       else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

       }
    }

    @FXML
    private void btn_supprposteur(ActionEvent event) {
        if(cinsupp_t.getText().isEmpty()){
             valid = false;
        }
        if(valid)
        {
           int cin = Integer.parseInt(cinsupp_t.getText());
        Posteur P = new Posteur();
        P.setCin(cin);
        PosteurService p1 = new PosteurService();
        p1.supprimerPosteur(P); 
        JOptionPane.showMessageDialog(null, "Account Deleted Successfull");

        }
        else
        {
          JOptionPane.showMessageDialog(null, "Please insert cin");
          valid = true;
        }
    }

    @FXML
    private void btn_modifposteur(ActionEvent event) {
        if(id_p1.getText().isEmpty()){
            canInscription = false;
        }
        if(nom_p1.getText().isEmpty()){
            canInscription = false;
        }
        if(prenom_p1.getText().isEmpty()){
            canInscription = false;
        }
        if(email_p1.getText().isEmpty()){
            canInscription = false;
        }
        if(pass_p1.getText().isEmpty()){
            canInscription = false;
        }
        if(tel_p1.getText().isEmpty()){
            canInscription = false;
        }
        if(date_p1.getValue().toString().isEmpty()){
            canInscription = false;
        }
        if(sexe_p1.getValue().toString().isEmpty()){
            canInscription = false;
        }
        

       if(canInscription){
           int cin = Integer.parseInt(id_p1.getText());
        String nom= nom_p1.getText();
        String prenom= prenom_p1.getText();
        String email= email_p1.getText();
        String sexe= (String) sexe_p1.getValue();
        int tel= Integer.parseInt(tel_p1.getText());
        String password= pass_p1.getText();
        LocalDate locald = date_p1.getValue();
        Date date = Date.valueOf(locald);

           Posteur P1= new Posteur(cin,nom,prenom,email,sexe,password,date,tel);
           PosteurService p = new PosteurService();
              p.modifierPosteur(P1);
              JOptionPane.showMessageDialog(null, "Account edited Successfull");

       }
       else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

       }
    }

    @FXML
    private void btn_rechercher(ActionEvent event) {
        if(id_p1.getText().isEmpty()){
             valid1 = false;

        }
        if(valid1)
        {
         int cin = Integer.parseInt(id_p1.getText());
         Posteur P = new Posteur();
        PosteurService p1 = new PosteurService();
        P=p1.getPosteurInfobyCin(cin);
        nom_p1.setText(P.getNom());
        prenom_p1.setText(P.getPrenom());
        sexe_p1.setValue(P.getSexe());
        date_p1.setValue(P.getDate_naissance().toLocalDate());
        email_p1.setText(P.getEmail());
        pass_p1.setText(P.getPassword());
        tel_p1.setText(Integer.toString(P.getTel()));

        }
       else
        {
                JOptionPane.showMessageDialog(null, "Please insert cin");
                valid1 = true;
        }
    }
    /*public void setValueformtableviewtotext()
    {
        table_post.setOnMouseClicked((MouseEvent event) -> {
            //if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            //Posteur E=table_post.getItems().get(table_post.getSelectionModel().getSelectedIndex());
            tabpane1.getSelectionModel().select(modif_posttab);
            
            //}
        });
    }*/

    @FXML
    private void logout_bt(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/acceuil.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
    }
 
    
}
