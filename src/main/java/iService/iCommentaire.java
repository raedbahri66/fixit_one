/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;
import entites.Commentaire;
import entites.Jobeur;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface iCommentaire {
    public void ajoutercCommentaire(Commentaire A);
    public void modifierCommentaire(Commentaire A);
    public void supprimerCommentaire(Commentaire A);
    public List<Commentaire> afficherCommentaire();
 
}
