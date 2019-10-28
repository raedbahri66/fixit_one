package service;
import entites.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.ConnexionBD;
//xfgdrgd

/**
 *
 * @author Wael
 */
public class GestionProduit {
          Connection c = ConnexionBD.getInstanceConnexionBD().getConnection();
        Statement ste;
    public GestionProduit()
    {
        try {
       
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
         
    public void ajouterProduit(Produit E) {
        String req1="INSERT INTO `produit` "
                    + "(`nomproduit`, `prix`,`description`, `categorie`, `num`, `etat_vente`, `etat_validation`, `idposteur_fg`, `idjobeur_fg`,`nom_proprietere`,`date_produit`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            try{
                PreparedStatement ste = c.prepareStatement(req1);
            
           // ste.setInt(1,E.getId());
            ste.setString(1,E.getNom());
            ste.setString(2,E.getPrix());
            ste.setString(3, E.getDescription());
            ste.setString(4, E.getCategorie());
            ste.setString(5, E.getNumero());
            ste.setString(6, E.getEtatVente());
            ste.setString(7, E.getEtatValidation());
            ste.setInt(8, E.getIdPosteurfg());
            ste.setInt(9, E.getIdJobeurfg());
            ste.setString(10, E.getNomproprietere());
            ste.setString(11, E.getDate1());
              ste.executeUpdate();
            System.out.println("Ajouter avec sucées ");
                    // JOptionPane.showMessageDialog(null,"requete execute correctement"); 
            } catch (SQLException e) 
            {System.err.println(e);
  
        }    
    }
    
    
    
    
   public List<Produit> afficherProduit() {
        
    List<Produit> echanges= new ArrayList<>();
    //Echange e = null;
      try {
          String etat="non_vendu";
         String req2="select * from produit where etat_vente=?";
         PreparedStatement pstm = c.prepareStatement(req2);
         pstm.setString(1,etat);
          ResultSet res=  pstm.executeQuery();
          while (res.next()) { 
              Produit e = new Produit();
               e.setId(res.getString(1));
                     e.setPrix(res.getString(3));
                     e.setNom(res.getString(2));
                       e.setDescription(res.getString(4));
                        e.setCategorie(res.getString(5));
                         e.setNumero(res.getString(6));
                         e.setNomproprietere(res.getString(11));
                         e.setDate1(res.getString(13));
                          echanges.add(e);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10))); 
          } 
    }catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }   
     return echanges;
    } 
    
          
     public List<Produit> afficherProduit1(int id) {
        
       List<Produit> table1= new ArrayList<>();
    //Echange e = null;
      try {
         String req2="select * from produit Where idposteur_fg=? ";
         PreparedStatement pstm = c.prepareStatement(req2);
        pstm.setInt(1,id);
          ResultSet res=  pstm.executeQuery();
          while (res.next()) { 
              Produit e = new Produit();
               e.setId(res.getString(1));
                     e.setPrix(res.getString(3));
                     e.setNom(res.getString(2));
                       e.setDescription(res.getString(4));
                        e.setCategorie(res.getString(5));
                         e.setNumero(res.getString(6));
                          e.setEtatVente(res.getString(7));
                         e.setEtatValidation(res.getString(8));
                          table1.add(e);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10))); 
          } 
    }catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }   
     return table1;
    }
     
       public List<Produit> RechercheCategorie(String cat) {
        
       List<Produit> table1= new ArrayList<>();
    //Echange e = null;
    String etat="non_vendu";
      try {
          if ("Tous()".equals(cat)){
              
           String req2="select * from produit where etat_vente=?";
         PreparedStatement pstm = c.prepareStatement(req2);
         pstm.setString(1,etat);
          ResultSet res=  pstm.executeQuery();
          while (res.next()) { 
              Produit e = new Produit();
               e.setId(res.getString(1));
                     e.setPrix(res.getString(3));
                     e.setNom(res.getString(2));
                       e.setDescription(res.getString(4));
                        e.setCategorie(res.getString(5));
                         e.setNumero(res.getString(6));
                         e.setNomproprietere(res.getString(11));
                         e.setDate1(res.getString(13));
                          table1.add(e);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10))); 
          } 
          
          
          }
          else{
         String req2="select * from produit Where categorie=? and etat_vente=?";
         PreparedStatement pstm = c.prepareStatement(req2);
         pstm.setString(1,cat);
         pstm.setString(2,etat);
          ResultSet res=  pstm.executeQuery();
          while (res.next()) { 
              Produit e = new Produit();
               e.setId(res.getString(1));
                     e.setPrix(res.getString(3));
                     e.setNom(res.getString(2));
                       e.setDescription(res.getString(4));
                        e.setCategorie(res.getString(5));
                         e.setNumero(res.getString(6));
                         e.setNomproprietere(res.getString(11));
                         e.setDate1(res.getString(13));
                          table1.add(e);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10))); 
                           }
          } 
    }catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }   
     return table1;
    }
     
      public List<Produit> RechercheNom(String nom) {
        
       List<Produit> table1= new ArrayList<>();
    //Echange e = null;
    String etat="non_vendu";
      try {
         String req2="select * from produit Where nomproduit LIKE '"+nom+"' and etat_vente=?" ;
         PreparedStatement pstm = c.prepareStatement(req2);
         pstm.setString(1,etat);
         //pstm.setString(1,nom);
          ResultSet res=  pstm.executeQuery();
          while (res.next()) { 
              Produit e = new Produit();
               e.setId(res.getString(1));
                     e.setPrix(res.getString(3));
                     e.setNom(res.getString(2));
                       e.setDescription(res.getString(4));
                        e.setCategorie(res.getString(5));
                         e.setNumero(res.getString(6));
                         e.setNomproprietere(res.getString(11));
                         e.setDate1(res.getString(13));
                          table1.add(e);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10))); 
                           }
          } 
    catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }   
     return table1;
    }
     
     
     
     
     
     public void modifierProduit(Produit E) {
    String req= "update produit SET  nomproduit=?,prix=?,description=?,categorie=?,num=?,etat_vente=? Where id=? ";
    
   try { 
          PreparedStatement ste = c.prepareStatement(req);
           ste.setString(7,E.getId());
          ste.setString(1,E.getNom());
            ste.setString(3,E.getDescription());
            ste.setString(2,E.getPrix());
              ste.setString(4,E.getCategorie());
              ste.setString(5,E.getNumero());
              ste.setString(6,E.getEtatVente());
             ste.executeUpdate();
           
          
    }catch(SQLException ex)
    {
    System.out.println(ex.getMessage());
    }
    }

        public void supprimerProduit(Produit E) {
    String req= "delete from produit Where id=? ";
    
   try { 
          PreparedStatement ste = c.prepareStatement(req);
           ste.setString(1,E.getId());   
             ste.executeUpdate();
    }catch(SQLException ex)
    {
    System.out.println(ex.getMessage());
    }
    }

  
     
     
     
}
