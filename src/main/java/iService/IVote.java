/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;
import entites.Vote;
import java.util.List;
/**
 *
 * @author ASUS
 */
public interface IVote { 
    public void ajouterVote(Vote A);
    public void ajouterVotedislike(Vote A) ;
    public void UpdateVote(Vote A,int cin_jobeur);
     public void UpdateVotedislike(Vote A, int cin_jobeur);
    public void supprimerVote(Vote A);
    public List<Vote> afficherVote();
    public List<Vote> afficherVote(int cin_jobeur);
}
