/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Article;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.Articlegestion;
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

    public static int cinlogin;
    @FXML
    private TableView table_article;
    @FXML
    private TableColumn<?, ?> id1;
    @FXML
    private TableColumn<?, ?> nom_art;
    @FXML
    private TableColumn<?, ?> descr_art;
    @FXML
    private TableColumn<?, ?> cat1;
    @FXML
    private TableColumn<?, ?> dat1;
    @FXML
    private TableColumn<?, ?> sou1;

    /**
     * Initializes the controller class.
     */
    Articlegestion art = new Articlegestion();
  ArrayList<Article> articles= (ArrayList<Article>) art.afficherArticle();  
  public ObservableList<Article> data = FXCollections.observableArrayList(articles);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TOD
        table_article.setItems(data);
    id1.setCellValueFactory(new PropertyValueFactory <>("id"));
     nom_art.setCellValueFactory(new PropertyValueFactory <>("nom_article"));
     descr_art.setCellValueFactory(new PropertyValueFactory <>("descriptionarticle"));
     cat1.setCellValueFactory(new PropertyValueFactory <>("categorie"));
     dat1.setCellValueFactory(new PropertyValueFactory <>("date_article"));
     sou1.setCellValueFactory(new PropertyValueFactory <>("sources"));
    
    }
    @FXML
    private void Btn_SignIn(ActionEvent event) throws IOException {
     int cin = Integer.parseInt(label_UserName.getText());
     cinlogin=cin;
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
