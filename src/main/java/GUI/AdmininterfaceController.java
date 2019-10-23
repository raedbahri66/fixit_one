/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AdmininterfaceController implements Initializable {
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> cat;
    @FXML
    private TableColumn<?, ?> dat;
    @FXML
    private TableColumn<?, ?> sou;
    @FXML
    private TextField nomarticle;
    @FXML
    private TextArea descriptionarticle;
    @FXML
    private ChoiceBox<?> categories;
    @FXML
    private DatePicker dateajout;
    @FXML
    private TextField source;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_posteurgestion(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("../fxml/Posteur_gestion.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();        
    }

    @FXML
    private void btn_jobeurgestion(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("../fxml/Jobeur_gestion.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    }

    @FXML
    private void ajouterArticle(ActionEvent event) {
    }

    @FXML
    private void afficherarticle(ActionEvent event) {
    }
    
}
