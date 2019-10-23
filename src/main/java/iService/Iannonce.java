/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

import entites.annonce;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface Iannonce {
    public void ajouterannonce(annonce an);
    public void modifierannonce(annonce an);
    public void supprimerannonce(annonce an);
    public List<annonce> afficherannonce();
    
}
