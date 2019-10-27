/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Jobeur;
import entites.Posteur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.JobeurService;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ProfilJobeurController implements Initializable {

    @FXML
    private Label datep_1;
    @FXML
    private Label spec_11;
    @FXML
    private Label nomp_11;
    @FXML
    private Label nomp_1;
    @FXML
    private Label prenomp_1;
    @FXML
    private Label emailp_1;
    @FXML
    private Label telp_1;
    @FXML
    private ImageView image_post;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        JobeurService p = new JobeurService();
        Jobeur p1= new Jobeur();
        try {
            p1 = p.getJobeurInfobyCin(JobeurgestionController.cin);
                     System.out.println(PosteurgestionController.cin);

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
        spec_11.setText(p1.getJob());
         System.out.println(JobeurService.A1);
    }    

    @FXML
    private void close_bt(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
    }
    
}
