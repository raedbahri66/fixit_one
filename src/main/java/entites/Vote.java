/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Vote {
       private int id;
   private int idjobeur_fg;
   private int idposteur_fg;
   private String nomp;

    public Vote(int idjobeur_fg, int idposteur_fg) {
        this.idjobeur_fg = idjobeur_fg;
        this.idposteur_fg = idposteur_fg;
    }
   private String prenomp;
   private int nb_like;
   private int nb_dislike;

    public Vote() {
    }

    public Vote(int idjobeur_fg, int idposteur_fg, String nomp, String prenomp, int nb_like) {
        this.idjobeur_fg = idjobeur_fg;
        this.idposteur_fg = idposteur_fg;
        this.nomp = nomp;
        this.prenomp = prenomp;
        this.nb_like = nb_like;
        this.nb_dislike = nb_dislike;
    }

    public Vote(int idjobeur_fg, int idposteur_fg, String nomp, String prenomp, int nb_like, int nb_dislike) {
        this.idjobeur_fg = idjobeur_fg;
        this.idposteur_fg = idposteur_fg;
        this.nomp = nomp;
        this.prenomp = prenomp;
        this.nb_like = nb_like;
        this.nb_dislike = nb_dislike;
    }

    @Override
    public String toString() {
        return "Vote{" + "id=" + id + ", idjobeur_fg=" + idjobeur_fg + ", idposteur_fg=" + idposteur_fg + ", nomp=" + nomp + ", prenomp=" + prenomp + ", nb_like=" + nb_like + ", nb_dislike=" + nb_dislike + '}';
    }

    
    
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdjobeur_fg() {
        return idjobeur_fg;
    }

    public void setIdjobeur_fg(int idjobeur_fg) {
        this.idjobeur_fg = idjobeur_fg;
    }

    public int getIdposteur_fg() {
        return idposteur_fg;
    }

    public void setIdposteur_fg(int idposteur_fg) {
        this.idposteur_fg = idposteur_fg;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public String getPrenomp() {
        return prenomp;
    }

    public void setPrenomp(String prenomp) {
        this.prenomp = prenomp;
    }

    public int getNb_like() {
        return nb_like;
    }

    public void setNb_like(int nb_like) {
        this.nb_like = nb_like;
    }

    public int getNb_dislike() {
        return nb_dislike;
    }

    public void setNb_dislike(int nb_dislike) {
        this.nb_dislike = nb_dislike;
    }
   
    
}
