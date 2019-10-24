package entites;

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
    private String categorie;
    private String numero;
    private String etatVente;
    private String etatValidation;
    private String idPosteurfg;
    private String idJobeurfg;
    public Produit() {
    }

    public Produit(String id, String nom, String prix, String description, String categorie, String numero, String etatVente, String etatValidation, String idPosteurfg, String idJobeurfg) {
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

    public Produit(String id, String nom, String prix, String description, String categorie, String numero) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
    }

    public Produit(String nom, String prix, String description, String categorie, String numero, String etatVente, String etatValidation) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
    }

    public Produit(String id, String nom, String prix, String description, String categorie, String numero, String etatVente, String etatValidation) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.numero = numero;
        this.etatVente = etatVente;
        this.etatValidation = etatValidation;
    }

  



    public Produit(String nom, String prix, String description, String categorie, String numero) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nom);
        hash = 53 * hash + Objects.hashCode(this.prix);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.categorie);
        hash = 53 * hash + Objects.hashCode(this.numero);
        hash = 53 * hash + Objects.hashCode(this.etatVente);
        hash = 53 * hash + Objects.hashCode(this.etatValidation);
        hash = 53 * hash + Objects.hashCode(this.idPosteurfg);
        hash = 53 * hash + Objects.hashCode(this.idJobeurfg);
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
        if (!Objects.equals(this.idPosteurfg, other.idPosteurfg)) {
            return false;
        }
        return true;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
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

    public String getIdPosteurfg() {
        return idPosteurfg;
    }

    public void setIdPosteurfg(String idPosteurfg) {
        this.idPosteurfg = idPosteurfg;
    }

    public String getIdJobeurfg() {
        return idJobeurfg;
    }

    public void setIdJobeurfg(String idJobeurfg) {
        this.idJobeurfg = idJobeurfg;
    }

    
    
}