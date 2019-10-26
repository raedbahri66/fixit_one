/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;
import entites.Favoris;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IFavoris {
    public void ajouterFavoris(Favoris A);
    public void supprimerFavoris(Favoris A);
    public List<Favoris> afficherfavoris();
    
}
