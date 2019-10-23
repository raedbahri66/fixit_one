/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author asus
 */
package iService;

import entites.Service;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IService {
    public void creerService(Service S);
    public void modifierService(Service S);
    public void supprimerService(Service S);
    public List<Service> afficherService();
    
}
