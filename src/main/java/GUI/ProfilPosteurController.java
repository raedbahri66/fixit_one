/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import entites.Posteur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ProfilPosteurController implements Initializable {

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
    private Label datep_1;
    @FXML
    private ImageView image_post;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //raed

        PosteurService p = new PosteurService();
        Posteur p1= new Posteur();
        try {
            p1 = p.getPosteurInfobyCin(PosteurgestionController.cin);
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
        image_post.setImage(PosteurService.A1);
         System.out.println(PosteurService.A1);
        // TODO
    }    

    @FXML
    private void close_bt(ActionEvent event) throws IOException {
        
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                
    }
    
}
