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
    public void UpdateVote(Vote A,int cin_jobeur,int cin_posteur);
     public void UpdateVotedislike(Vote A, int cin_jobeur,int cin_posteur);
    public void supprimerVote(Vote A,int cin_jobeur,int cin_posteur);
    public int countlike(int cin_jobeur);
    public int countdislik(int cin_jobeur);

}
