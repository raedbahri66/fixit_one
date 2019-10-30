/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import static GUI.PosteurgestionController.cin;
import entites.Jobeur;
import entites.Posteur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;
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
            static int cin;
    @FXML
    private Tab supp_posttab1;
    @FXML
    private TableView table_post1;
    @FXML
    private TableColumn<?, ?> c1_cinp1;
    @FXML
    private TableColumn<?, ?> c2_nomp1;
    @FXML
    private TableColumn<?, ?> c3_prenomp1;
    @FXML
    private TableColumn<?, ?> c4_emailp1;
    @FXML
    private TableColumn<?, ?> c5_telp1;
    @FXML
    private TableColumn<?, ?> c_spec1;
    @FXML
    private TableColumn<?, ?> C7_etat;
    @FXML
    private Button btn_text1;
    @FXML
    private TableColumn<?, ?> c_address;
    @FXML
    private TextField filter_field1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(JobeurService.affich) try {
            System.out.println("Actialiser");
            btn_actualiser1();
        } catch (SQLException ex) {
            Logger.getLogger(JobeurgestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String[] possible_ville = {"Agareb",
            "Aïn Draham",
            "Akouda",
            "Amdoun",
            "Ariana Ville",
            "Bab El Bhar",
            "Bab Souika",
            "Balta-Bou Aouane",
            "Bargou",
            "Béja Nord",
            "Béja Sud",
            "Bekalta",
            "Belkhir",
            "Bembla",
            "Ben Arous",
            "Ben Gardane",
            "Beni Hassen",
            "Béni Khalled",
            "Beni Khedache",
            "Béni Khiar",
            "Bir Ali Ben Khalifa",
            "Bir El Hafey",
            "Bir Lahmar",
            "Bir Mcherga",
            "Bizerte Nord",
            "Bizerte Sud",
            "Borj El Amri",
            "Bou Arada",
            "Bou Argoub",
            "Bou Hajla",
            "Bou Merdes",
            "Bou Mhel el-Bassatine",
            "Bou Salem",
            "Bouficha",
            "Carthage",
            "Cebbala Ouled Asker",
            "Chebba",
            "Chebika",
            "Chorbane",
            "Cité El Khadra",
            "Dahmani",
            "Dar Chaâbane El Fehri",
            "Degache",
            "Dehiba",
            "Djebel Jelloud",
            "Djedeida",
            "Djerba - Ajim",
            "Djerba - Houmt Souk",
            "Djerba - Midoun",
            "Douar Hicher",
            "Douz Nord",
            "Douz Sud",
            "Echrarda",
            "El Alâa",
            "El Alia",
            "El Amra",
            "El Aroussa",
            "El Ayoun",
            "El Batan",
            "El Fahs",
            "El Guettar",
            "El Hamma",
            "El Haouaria",
            "El Hencha",
            "El Jem",
            "El Kabaria",
            "El Krib",
            "El Ksar",
            "El Ksour",
            "El Menzah",
            "El Mida",
            "El Mourouj",
            "El Omrane",
            "El Omrane supérieur",
            "El Ouardia",
            "Enfida",
            "Essouassi",
            "Ettadhamen",
            "Ettahrir",
            "Ezzahra",
            "Ezzouhour",
            "Ezzouhour",
            "Faouar",
            "Fériana",
            "Fernana",
            "Fouchana",
            "Foussana",
            "Gaâfour",
            "Gabès Médina",
            "Gabès Ouest",
            "Gabès Sud",
            "Gafsa Nord",
            "Gafsa Sud",
            "Ghannouch",
            "Ghar El Melh",
            "Ghardimaou",
            "Ghezala",
            "Ghomrassen",
            "Goubellat",
            "Graïba",
            "Grombalia",
            "Haffouz",
            "Haïdra",
            "Hajeb El Ayoun",
            "Hammam Chott",
            "Hammam Ghezèze",
            "Hammam Lif",
            "Hammam Sousse",
            "Hammamet",
            "Hassi El Ferid",
            "Hazoua",
            "Hebira",
            "Hergla",
            "Hraïria",
            "Jebiniana",
            "Jedelienne",
            "Jemmal",
            "Jendouba Nord",
            "Jendouba Sud",
            "Jérissa",
            "Jilma",
            "Joumine",
            "Kairouan Nord",
            "Kairouan Sud",
            "Kalâa Kebira",
            "Kalâa Seghira",
            "Kalâat el-Andalous",
            "Kalâat Khasba",
            "Kalaat Senan",
            "Kasserine Nord",
            "Kasserine Sud",
            "Kébili Nord",
            "Kébili Sud",
            "Kef Est",
            "Kef Ouest",
            "Kélibia",
            "Kerkennah",
            "Kesra",
            "Kondar",
            "Korba",
            "Ksar Hellal",
            "Ksibet el-Mediouni",
            "Ksour Essef",
            "La Goulette",
            "La Manouba",
            "La Marsa",
            "La Soukra",
            "Le Bardo",
            "Le Kram",
            "Msaken",
            "Mahdia",
            "Mahres",
            "Majel Bel Abbes",
            "Makthar",
            "Mareth",
            "Mateur",
            "Matmata",
            "Mdhilla",
            "Medenine Nord",
            "Medenine Sud",
            "Medina",
            "Medina Jedida",
            "Medjez el-Bab",
            "Megrine",
            "Meknassy",
            "Melloulèche",
            "Menzel Bourguiba",
            "Menzel Bouzaiane",
            "Menzel Bouzelfa",
            "Menzel Chaker",
            "Menzel El Habib",
            "Menzel Jemil",
            "Menzel Temime",
            "Métlaoui",
            "Métouia",
            "Mezzouna",
            "Mnihla",
            "Mohamedia",
            "Moknine",
            "Monastir",
            "Mornag",
            "Mornaguia",
            "Moularès",
            "Nabeul",
            "Nadhour",
            "Nasrallah",
            "Nebeur",
            "Nefta",
            "Nefza",
            "Nouvelle Matmata",
            "Oued Ellil",
            "Oued Meliz",
            "Ouerdanine",
            "Oueslatia",
            "Ouled Chamekh",
            "Ouled Haffouz",
            "Radès",
            "Raoued",
            "Ras Jebel",
            "Redeyef",
            "Regueb",
            "Remada",
            "Rouhia",
            "Sahline",
            "Sakiet Eddaïer",
            "Sakiet Ezzit",
            "Sakiet Sidi Youssef",
            "Saouaf",
            "Sayada-Lamta-Bou Hajar",
            "Sbeïtla",
            "Sbiba",
            "Sbikha",
            "Sejnane",
            "Séjoumi",
            "Sened",
            "Sers",
            "Sfax Ouest",
            "Sfax Sud",
            "Sfax Ville",
            "Sidi Aïch",
            "Sidi Ali Ben Aoun",
            "Sidi Alouane",
            "Sidi Bou Ali",
            "Sidi Bou Rouis",
            "Sidi Bouzid Est",
            "Sidi Bouzid Ouest",
            "Sidi El Béchir",
            "Sidi El Hani",
            "Sidi Hassine",
            "Sidi Makhlouf",
            "Sidi Thabet",
            "Siliana Nord",
            "Siliana Sud",
            "Skhira",
            "Smâr",
            "Soliman",
            "Souk Jedid",
            "Souk Lahad",
            "Sousse Jawhara",
            "Sousse Médina",
            "Sousse Riadh",
            "Sousse Sidi Abdelhamid",
            "Tabarka",
            "Tajerouine",
            "Takelsa",
            "Tameghza",
            "Tataouine Nord",
            "Tataouine Sud",
            "Téboulba",
            "Tebourba",
            "Téboursouk",
            "Testour",
            "Thala",
            "Thibar",
            "Thyna",
            "Tinja",
            "Tozeur",
            "Utique",
            "Zaghouan",
            "Zarzis",
            "Zarzouna",
            "Zéramdine",
            "Zriba"

        };
        TextFields.bindAutoCompletion(filter_field1, possible_ville);

        
            active_filter.setToggleGroup(group);
            active_filter.setSelected(true);
            banned_filter.setToggleGroup(group);
            ObservableList<String> sexelist = FXCollections.observableArrayList("Homme","Femme");
            ObservableList<String> speclist = FXCollections.observableArrayList("Electricien","Menage","Plombier","Conciergerie","Renovation","Jardinage");
            ObservableList<String> filter_choix = FXCollections.observableArrayList("nom","email","cin");
            sexe_p.setValue("Homme");
            sexe_p.setItems(sexelist);
            combo_j.setValue("Electricien");
            combo_j.setItems(speclist);
            date_p.setValue(NOW_LOCAL_DATE());
            sexe_p1.setValue("Homme");
            sexe_p1.setItems(sexelist);
            combo_j1.setValue("Electricien");
            combo_j1.setItems(speclist);
            date_p1.setValue(NOW_LOCAL_DATE());
            combo_filter.setValue("cin");
            combo_filter.setItems(filter_choix);
            /////affiche//
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
                            c_address.setCellValueFactory(new PropertyValueFactory<>("address") );

            
            ArrayList<Jobeur> pers1;
        try {
            pers1 = (ArrayList<Jobeur>) p.afficherJobeurbyEtat("Attente");
            ObservableList<Jobeur> obs1=FXCollections.observableArrayList(pers1);
            table_post1.getItems().clear();
        table_post1.setItems(obs1);
        c1_cinp1.setCellValueFactory(new PropertyValueFactory<>("cin") );
        c2_nomp1.setCellValueFactory(new PropertyValueFactory<>("nom") );
        c3_prenomp1.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        c4_emailp1.setCellValueFactory(new PropertyValueFactory<>("email") );
        c5_telp1.setCellValueFactory(new PropertyValueFactory<>("tel") );
        c_spec1.setCellValueFactory(new PropertyValueFactory<>("job") );
                C7_etat.setCellValueFactory(new PropertyValueFactory<>("etat") );

        } catch (SQLException ex) {
            Logger.getLogger(JobeurgestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
            ///
            table_post.setOnMouseClicked((MouseEvent event) -> {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    Jobeur p0 = new Jobeur();
                    p0=(Jobeur) table_post.getItems().get(table_post.getSelectionModel().getSelectedIndex());
                    tabpane1.getSelectionModel().select(modif_posttab);
                    nom_p1.setText(p0.getNom());
                    prenom_p1.setText(p0.getPrenom());
                    sexe_p1.setValue(p0.getSexe());
                    date_p1.setValue(p0.getDate_naissance().toLocalDate());
                    email_p1.setText(p0.getEmail());
                    pass_p1.setText(p0.getPassword());
                    tel_p1.setText(Integer.toString(p0.getTel()));
                    id_p1.setText(Integer.toString(p0.getCin()));
                    address_j1.setText(p0.getAddress());
                    combo_j1.setValue(p0.getJob());
                }
                else if (event.getButton().equals(MouseButton.SECONDARY) && event.getClickCount() == 1){
                    Jobeur p0 = new Jobeur();
                    p0=(Jobeur) table_post.getItems().get(table_post.getSelectionModel().getSelectedIndex());
                    tabpane1.getSelectionModel().select(supp_posttab);
                    cinsupp_t.setText(Integer.toString(p0.getCin()));
                }
                
                else if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){
                    Jobeur p0 = new Jobeur();
                    p0=(Jobeur) table_post.getItems().get(table_post.getSelectionModel().getSelectedIndex());
                    int cin1=p0.getCin();
                    cin=cin1;
                    Parent root = null;
                    try {
                        root= FXMLLoader.load(getClass().getResource("/fxml/Profil_Jobeur.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(PosteurgestionController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Stage stage1 = new Stage();
                    
                    Scene scene = new Scene(root);
                    stage1.setScene(scene);
                    /* Stage stag1 = new Stage(root);*/
                    stage1.show();
                }
            });
            table_post1.setOnMouseClicked((MouseEvent event) -> {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){
                    Jobeur p0 = new Jobeur();
                    p0=(Jobeur) table_post1.getItems().get(table_post1.getSelectionModel().getSelectedIndex());
                    int cin1=p0.getCin();
                    cin=cin1;
                    Parent root = null;
                    try {
                        root= FXMLLoader.load(getClass().getResource("/fxml/Competance_jobeur.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(PosteurgestionController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Stage stage1 = new Stage();
                    
                    Scene scene = new Scene(root);
                    stage1.setScene(scene);
                    /* Stage stag1 = new Stage(root);*/
                    stage1.show();
                }
            });
        
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
        c_address.setCellValueFactory(new PropertyValueFactory<>("address") );
    }

    @FXML
    private void logout_bt(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/acceuil.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void Clearmouse_text(MouseEvent event) {
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
        c_address.setCellValueFactory(new PropertyValueFactory<>("address") );
      
    }

    @FXML
    private void Textchanged_flnom(InputMethodEvent event) {
    }

    @FXML
    private void OnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void OnkeyTypedfilter(KeyEvent event) throws SQLException {
        String fil=combo_filter.getValue().toString();
       /*String a=event.getCharacter();
         ab=ab.concat(a);*/
         String msg = filter_field.getText().concat("%");

        JobeurService p= new JobeurService(); 
        ArrayList<Jobeur> pers=(ArrayList<Jobeur>) p.afficherJobeurbynNom(fil,msg);
        ObservableList<Jobeur> obs=FXCollections.observableArrayList(pers);
        table_post.getItems().clear();
        table_post.setItems(obs);

        c1_cinp.setCellValueFactory(new PropertyValueFactory<>("cin") );
        c2_nomp.setCellValueFactory(new PropertyValueFactory<>("nom") );
        c3_prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        c4_emailp.setCellValueFactory(new PropertyValueFactory<>("email") );
        c5_telp.setCellValueFactory(new PropertyValueFactory<>("tel") );
        c_spec.setCellValueFactory(new PropertyValueFactory<>("job")) ;
                c_address.setCellValueFactory(new PropertyValueFactory<>("address") );
    }

    @FXML
    private void Active_filterBtn(MouseEvent event) throws SQLException {
        String msg = active_filter.getText().concat("%");
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
        c_address.setCellValueFactory(new PropertyValueFactory<>("address") );
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
        c_address.setCellValueFactory(new PropertyValueFactory<>("address") );
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

    @FXML
    private void btn_actualiser1() throws SQLException {
        JobeurService p= new JobeurService(); 
        ArrayList<Jobeur> pers=(ArrayList<Jobeur>) p.afficherJobeurbyEtat("Attente");
        ObservableList<Jobeur> obs=FXCollections.observableArrayList(pers);
       
        table_post1.getItems().clear();
        table_post1.setItems(obs);
        c1_cinp1.setCellValueFactory(new PropertyValueFactory<>("cin") );
        c2_nomp1.setCellValueFactory(new PropertyValueFactory<>("nom") );
        c3_prenomp1.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        c4_emailp1.setCellValueFactory(new PropertyValueFactory<>("email") );
        c5_telp1.setCellValueFactory(new PropertyValueFactory<>("tel") );
        c_spec1.setCellValueFactory(new PropertyValueFactory<>("job") );
        C7_etat.setCellValueFactory(new PropertyValueFactory<>("etat") );
    }

    @FXML
    private void OnkeyTypedfilter_address(KeyEvent event) {
        String msg = filter_field1.getText().concat("%");

        JobeurService p= new JobeurService(); 
        ArrayList<Jobeur> pers=(ArrayList<Jobeur>) p.afficherJobeurbyAddress(msg);
        ObservableList<Jobeur> obs=FXCollections.observableArrayList(pers);
        table_post.getItems().clear();
        table_post.setItems(obs);

        c1_cinp.setCellValueFactory(new PropertyValueFactory<>("cin") );
        c2_nomp.setCellValueFactory(new PropertyValueFactory<>("nom") );
        c3_prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        c4_emailp.setCellValueFactory(new PropertyValueFactory<>("email") );
        c5_telp.setCellValueFactory(new PropertyValueFactory<>("tel") );
        c_spec.setCellValueFactory(new PropertyValueFactory<>("job")) ;
        c_address.setCellValueFactory(new PropertyValueFactory<>("address") );
    }

    
    
}
