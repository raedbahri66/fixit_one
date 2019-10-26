/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import entites.Jobeur;
import entites.Posteur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import service.ControleSaisie;
import service.JobeurService;
import service.PosteurService;

/**
 *
 * @author lenovo
 */
public class JobeurgestionController implements Initializable{

    @FXML
    private TabPane tabpane1;
    @FXML
    private TableView table_post;
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
    @FXML
    private Button btn_text;
    @FXML
    private TextField filter_field;
    @FXML
    private ComboBox combo_filter;
    @FXML
    private RadioButton active_filter;
    @FXML
    private RadioButton banned_filter;
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
    private ComboBox combo_j;
    @FXML
    private TextField address_j;
    @FXML
    private Label address_vali;
    @FXML
    private Tab modif_posttab;
    @FXML
    private AnchorPane ancho_modifp;
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
    private ComboBox sexe_p;
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
    private TextField address_j1;
    @FXML
    private ComboBox combo_j1;
    @FXML
    private Label address_valid;
    @FXML
    private Tab supp_posttab;
    @FXML
    private TextField cinsupp_t;
    @FXML
    private Label nom_valid11;
    @FXML
    private TextArea bannir_text;
    @FXML
    private TableColumn<?, ?> c_spec;
    public boolean canInscription=true;
    public boolean valid= true;
    public boolean valid1= true;
        final ToggleGroup group = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        active_filter.setToggleGroup(group);
                active_filter.setSelected(true);
                banned_filter.setToggleGroup(group);
        ObservableList<String> sexelist = FXCollections.observableArrayList("Homme","Femme");
        ObservableList<String> speclist = FXCollections.observableArrayList("Electricite","Plomberie","Jardinage","Menage","Conciergerie");
        sexe_p.setValue("Homme");
        sexe_p.setItems(sexelist);
        combo_j.setValue("Electricite");
        combo_j.setItems(speclist);
        date_p.setValue(NOW_LOCAL_DATE());
        sexe_p1.setValue("Homme");
        sexe_p1.setItems(sexelist);
        combo_j1.setValue("Electricite");
        combo_j1.setItems(speclist);
        date_p1.setValue(NOW_LOCAL_DATE());
        
    }
    @FXML
    private void btn_actualiser(ActionEvent event) {
        filter_field.clear();

        JobeurService p= new JobeurService();
        ArrayList<Jobeur> pers=(ArrayList<Jobeur>) p.afficherJobeur();
        ObservableList<Jobeur> obs=FXCollections.observableArrayList(pers);
        table_post.getItems().clear();
        table_post.setItems(obs);
        c1_cinp.setCellValueFactory(new PropertyValueFactory<>("cin") );
        c2_nomp.setCellValueFactory(new PropertyValueFactory<>("nom") );
        c3_prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        c4_emailp.setCellValueFactory(new PropertyValueFactory<>("email") );
        c5_telp.setCellValueFactory(new PropertyValueFactory<>("tel") );
        c_spec.setCellValueFactory(new PropertyValueFactory<>("job") );
    }

    @FXML
    private void logout_bt(ActionEvent event) {
    }

    @FXML
    private void Clearmouse_text(MouseEvent event) {
    }

    @FXML
    private void Textchanged_flnom(InputMethodEvent event) {
    }

    @FXML
    private void OnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void OnkeyTypedfilter(KeyEvent event) {
    }

    @FXML
    private void Active_filterBtn(MouseEvent event) {
    }

    @FXML
    private void banned_btnfilter(MouseEvent event) throws SQLException {
        String msg = banned_filter.getText().concat("%");
        JobeurService p= new JobeurService();
        ArrayList<Jobeur> pers=(ArrayList<Jobeur>) p.afficherJobeurbyEtat(msg);
        ObservableList<Jobeur> obs=FXCollections.observableArrayList(pers);
        table_post.getItems().clear();
        table_post.setItems(obs);
        c1_cinp.setCellValueFactory(new PropertyValueFactory<>("cin") );
        c2_nomp.setCellValueFactory(new PropertyValueFactory<>("nom") );
        c3_prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        c4_emailp.setCellValueFactory(new PropertyValueFactory<>("email") );
        c5_telp.setCellValueFactory(new PropertyValueFactory<>("tel") );
        c_spec.setCellValueFactory(new PropertyValueFactory<>("job") );
    }

    @FXML
    private void Onkeyfilter(KeyEvent event) {
    }

    @FXML
    private void btn_ajouterjobeu(ActionEvent event) {
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
        
         if(sexe_p.getValue().toString().isEmpty()){
            canInscription = false;
        } else             sex_valid.setText("Accepted");
        if(address_j.toString().isEmpty()){
            canInscription = false;
        } else             address_vali.setText("Accepted");
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
        String job= (String) combo_j.getValue();
        String address= address_j.getText();

           Jobeur P1= new Jobeur (cin,nom,prenom,email,sexe,password,date,tel,job,address);
           JobeurService p = new JobeurService();
           

           p.creerJobeur(P1);

       }
       else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

       }
    }


    @FXML
    private void btn_rechercher(ActionEvent event) throws SQLException, IOException {
        if(id_p1.getText().isEmpty()){
             valid1 = false;

        } else cin_valid1.setText("Accepted");
        if(valid1)
        {
         int cin = Integer.parseInt(id_p1.getText());
         Jobeur P = new Jobeur();
        JobeurService p1 = new JobeurService();
        P=p1.getJobeurInfobyCin(cin);
        nom_p1.setText(P.getNom());
        prenom_p1.setText(P.getPrenom());
        sexe_p1.setValue(P.getSexe());
        date_p1.setValue(P.getDate_naissance().toLocalDate());
        email_p1.setText(P.getEmail());
        pass_p1.setText(P.getPassword());
        tel_p1.setText(Integer.toString(P.getTel()));
        combo_j1.setValue(P.getJob());
        address_j1.setText(P.getAddress());
        }
       else
        {
                JOptionPane.showMessageDialog(null, "Please insert cin");
                valid1 = true;
        }
    }

    @FXML
    private void btn_supprjobeur(ActionEvent event) {
        if(cinsupp_t.getText().isEmpty()){
             valid = false;
        } else nom_valid11.setText("Accepted");
        if(valid)
        {
           int cin = Integer.parseInt(cinsupp_t.getText());
        Jobeur P = new Jobeur();
        P.setCin(cin);
        JobeurService p1 = new JobeurService();
        p1.supprimerJobeur(P); 
        JOptionPane.showMessageDialog(null, "Account Deleted Successfull");

        }
        else
        {
          JOptionPane.showMessageDialog(null, "Please insert cin");
          valid = true;
        }
    }

    @FXML
    private void bannir_btn(ActionEvent event) throws SQLException {
        int cin1= Integer.parseInt(cinsupp_t.getText());
        String role = bannir_text.getText();
        Jobeur P1= new Jobeur(cin1,role);
        JobeurService p= new JobeurService();
        try { 
            if (JOptionPane.showConfirmDialog (null,"confirmer la bannir","bannir",
                 JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                 if(canInscription)
       p.BannirJobeur(P1);
                
            } 
        } catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de modifier");
        
    }

    }

    @FXML
    private void btn_modifjobeur(ActionEvent event) {
        ControleSaisie C= new ControleSaisie();
        if(!C.cinisValid(id_p1.getText()) ){
            canInscription = false;;
           
        } else cin_valid1.setText("Cin must contain 8 numbers");
        
        
        if (C.cinisValid(id_p1.getText()) )   cin_valid1.setText("Accepted");

        if(nom_p1.getText().isEmpty()){
            canInscription = false;
        } else nom_valid1.setText("Accepted");

        if(prenom_p1.getText().isEmpty()){
            canInscription = false;
        } else prenom_valid1.setText("Accepted");

        if(!C.emailisValid(email_p1.getText())){
            canInscription = false;
        } else email_valid1.setText("Email is correct");
        if(pass_p1.getText().isEmpty()){
            
            canInscription = false;
        } else pass_valid1.setText("Accepted");
        if(!C.cinisValid(tel_p1.getText())){
            canInscription = false;
        } else tel_valid1.setText("Accepted");
        if(date_p1.getValue().toString().isEmpty()){
            canInscription = false;
        }
            else date_valid1.setText("Accepted");
        if(sexe_p1.getValue().toString().isEmpty()){
            canInscription = false;
        } else             sex_valid1.setText("Accepted");
        
         if(sexe_p1.getValue().toString().isEmpty()){
            canInscription = false;
        } else             sex_valid1.setText("Accepted");
        if(address_j1.toString().isEmpty()){
            canInscription = false;
        } else             address_valid.setText("Accepted");
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
        String job= (String) combo_j1.getValue();
        String address= address_j1.getText();

           Jobeur P1= new Jobeur (cin,nom,prenom,email,sexe,password,date,tel,job,address);
           JobeurService p = new JobeurService();
           

           p.modifierJobeur(P1);
           JOptionPane.showMessageDialog(null, "Account Modifided");

       }
       else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

       }
    }

    
    
}
