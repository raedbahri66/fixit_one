/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

import entites.Article;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IArticle {
    public void ajouterArticle(Article A);
    public void modifierArticle(Article A);
    public void supprimerArticle(Article A);
    public List<Article> afficherArticle();
}
