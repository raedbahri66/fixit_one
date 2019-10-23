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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button Btn_SignIn;
    @FXML
    private TextField label_UserName;
    @FXML
    private TextField Label_Password;
    @FXML
    private Button Btn_formulaire_posteur;
    @FXML
    private Button Btn_fromulaire_jobeur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Btn_SignIn(ActionEvent event) throws IOException {
     int cin = Integer.parseInt(label_UserName.getText());
     String password= Label_Password.getText();
     String role;
     PosteurService p = new PosteurService();
    role=p.login(cin, password);
    if("fault".equals(role))
    {
        JOptionPane.showMessageDialog(null, "Please check your Cin and Password");
    }
    else
    {
    Parent root=FXMLLoader.load(getClass().getResource("/fxml/"+role+".fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();        
    }
    }

    
    
    
}
