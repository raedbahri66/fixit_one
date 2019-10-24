/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

import entites.Offre;
import entites.Service;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IOffre {
    public void creerOffre(Offre O);
    public List<Service> afficherOffre();
    
}
