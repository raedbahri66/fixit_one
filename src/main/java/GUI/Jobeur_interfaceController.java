/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lenovo
 */

public class Jobeur_interfaceController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private DatePicker dateajoute;

    @FXML
    private Button ajoutechange;

    @FXML
    private TextArea Descriptionpro;

    @FXML
    private TextField Nom_proposition;

    @FXML
    private TableView<?> tableechanges;

    @FXML
    private TableColumn<?, ?> idechanges;

    @FXML
    private TableColumn<?, ?> nomechanges;

    @FXML
    private TableColumn<?, ?> Descriptionechanges;

    @FXML
    private TableColumn<?, ?> dateechanges;

    @FXML
    private TableColumn<?, ?> idjobeurechanges;

    @FXML
    private TableColumn<?, ?> nomjoubeurechanges;

    @FXML
    private TableColumn<?, ?> prenomjoubeurechanges;

    @FXML
    private TableColumn<?, ?> nom_echange;

    @FXML
    private TableView<?> tablemonechange;

    @FXML
    private TableColumn<?, ?> idechange;
    
    
    @FXML
    private TableColumn<?, ?> Descriptionechange;

    @FXML
    private TableColumn<?, ?> dateechange;

    @FXML
    private Button modifierechange;

    @FXML
    private TextField mNom_proposition;

    @FXML
    private TextArea mDescriptionpro;

    @FXML
    private DatePicker mdateajout;

    @FXML
    void ajouterechange(ActionEvent event) {

    }

    @FXML
    void modifierechange(ActionEvent event) {

    }

    @FXML
    void supprimerechange(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
