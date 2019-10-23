/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

import entites.Echange;

/**
 *
 * @author iheb
 */
public interface Iechange {
      public void ajouterEchange(Echange  E);
    public void modifierEchange(Echange E);
    public void supprimerEchange(Echange  E);
    
}
