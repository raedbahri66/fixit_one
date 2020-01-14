package entites;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Wael
 */
public class Produit {
    private String id ;
    private String nom;
    private String prix ;
    private String description;
    private int categorie;
    private String Nomcategorie;
    private String numero;
    private String etatVente;
    private String etatValidation;
    private int idPosteurfg;
    private int idJobeurfg;
    private String nomproprietere;
    private String date1;
    private String panier;
    
    public Produit() {
    }

    public Produit(String id, String nom, String prix, String description, int categorie, String Nomcategorie, String numero, String etatVente, String etatValidation, int idPosteurfg, int idJobeurfg, String nomproprietere, String date1, String panier) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.Nomcategorie = Nomcategorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
        this.idPosteurfg = idPosteurfg;
        this.idJobeurfg = idJobeurfg;
        this.nomproprietere = nomproprietere;
        this.date1 = date1;
        this.panier = panier;
    }

    
    public Produit(String id, String nom, String prix, String description, int categorie, String numero, String etatVente, String etatValidation, int idPosteurfg, int idJobeurfg, String nomproprietere, String date1) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
        this.idPosteurfg = idPosteurfg;
        this.idJobeurfg = idJobeurfg;
        this.nomproprietere = nomproprietere;
        this.date1 = date1;
    }

    public Produit(String nom, String prix, String description, int categorie, String numero, String etatVente, String etatValidation, int idPosteurfg, int idJobeurfg, String nomproprietere, String date1) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
        this.idPosteurfg = idPosteurfg;
        this.idJobeurfg = idJobeurfg;
        this.nomproprietere = nomproprietere;
        this.date1 = date1;
    }

    public Produit(String nom, String prix, String description, int categorie, String numero, String etatVente, String etatValidation, int idPosteurfg, int idJobeurfg, String nomproprietere) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
        this.idPosteurfg = idPosteurfg;
        this.idJobeurfg = idJobeurfg;
        this.nomproprietere = nomproprietere;
    }

    public Produit(String id, String nom, String prix, String description, int categorie, String numero, String etatVente, String etatValidation, int idPosteurfg, int idJobeurfg) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
        this.idPosteurfg = idPosteurfg;
        this.idJobeurfg = idJobeurfg;
    }

    public Produit(String id, String nom, String prix, String description, int categorie, String numero) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
    }

    public Produit(String nom, String prix, String description, int categorie, String numero, String etatVente, String etatValidation) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
    }

    public Produit(String nom, String prix, String description, int categorie, String numero, String etatVente, String etatValidation, int idPosteurfg, int idJobeurfg) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
        this.idPosteurfg = idPosteurfg;
        this.idJobeurfg = idJobeurfg;
    }

    public Produit(String id, String nom, String prix, String description, int categorie, String numero, String etatVente, String etatValidation) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
    }

    public Produit(String nom, String prix, String description, int categorie, String numero, String etatVente, String etatValidation, int idPosteurfg, String date1) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
        this.idPosteurfg = idPosteurfg;
        this.date1 = date1;
    }

  



    public Produit(String nom, String prix, String description, int categorie, String numero) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
    }

    public Produit(String id) {
        this.id = id;
    }



    public Produit(String id, String nom, String prix, String description) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }

    public Produit(String nom, String prix, String description) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }

    public Produit(String id, String panier) {
        this.id = id;
        this.panier = panier;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.prix);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.categorie);
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.etatVente);
        hash = 97 * hash + Objects.hashCode(this.etatValidation);
        hash = 97 * hash + this.idPosteurfg;
        hash = 97 * hash + this.idJobeurfg;
        hash = 97 * hash + Objects.hashCode(this.nomproprietere);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.idPosteurfg != other.idPosteurfg) {
            return false;
        }
        if (this.idJobeurfg != other.idJobeurfg) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prix, other.prix)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.etatVente, other.etatVente)) {
            return false;
        }
        if (!Objects.equals(this.etatValidation, other.etatValidation)) {
            return false;
        }
        if (!Objects.equals(this.nomproprietere, other.nomproprietere)) {
            return false;
        }
        return true;
    }

    public String getPanier() {
        return panier;
    }

    public void setPanier(String panier) {
        this.panier = panier;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEtatVente() {
        return etatVente;
    }

    public void setEtatVente(String etatVente) {
        this.etatVente = etatVente;
    }

    public String getEtatValidation() {
        return etatValidation;
    }

    public void setEtatValidation(String etatValidation) {
        this.etatValidation = etatValidation;
    }

    public int getIdPosteurfg() {
        return idPosteurfg;
    }

    public void setIdPosteurfg(int idPosteurfg) {
        this.idPosteurfg = idPosteurfg;
    }

    public int getIdJobeurfg() {
        return idJobeurfg;
    }

    public void setIdJobeurfg(int idJobeurfg) {
        this.idJobeurfg = idJobeurfg;
    }

    public String getNomproprietere() {
        return nomproprietere;
    }

    public void setNomproprietere(String nomprestataire) {
        this.nomproprietere = nomprestataire;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getNomcategorie() {
        return Nomcategorie;
    }

    public void setNomcategorie(String Nomcategorie) {
        this.Nomcategorie = Nomcategorie;
    }



    
    
}