/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

import entites.Posteur;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface iPosteur {
     public void creerPosteur(Posteur p);
    public void modifierPosteur(Posteur p);
    public void supprimerPosteur(Posteur p);
    public List<Posteur> afficherPosteur();
}
