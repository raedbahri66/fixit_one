package entites;
import java.sql.Date;
/**
 *
 * @author DELL
 */
public class annonce {
    private int id;
    private String nom_annonce;
    private String adress;
    private String date;
    private String description_annonce;
    private String etat_annonce;
    private int  tel;
    private int prix;

    public annonce() {
    }

    public annonce(int id, String nom_annonce, String adress, String date, String description_annonce, String etat_annonce, int tel, int prix) {
        this.id = id;
        this.nom_annonce = nom_annonce;
        this.adress = adress;
        this.date = date;
        this.description_annonce = description_annonce;
        this.etat_annonce = etat_annonce;
        this.tel = tel;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_annonce() {
        return nom_annonce;
    }

    public void setNom_annonce(String nom_annonce) {
        this.nom_annonce = nom_annonce;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription_annonce() {
        return description_annonce;
    }

    public void setDescription_annonce(String description_annonce) {
        this.description_annonce = description_annonce;
    }

    public String getEtat_annonce() {
        return etat_annonce;
    }

    public void setEtat_annonce(String etat_annonce) {
        this.etat_annonce = etat_annonce;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "annonce{" + "id=" + id + ", nom_annonce=" + nom_annonce + ", adress=" + adress + ", date=" + date + ", description_annonce=" + description_annonce + ", etat_annonce=" + etat_annonce + ", tel=" + tel + ", prix=" + prix + '}';
    }

    public int getid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
