package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans;

import java.util.Date;

public class Produit {
    private int id;
    private String code;
    private String nom;
    private Date date;
    private Double prix;

    public Produit(int id, String code, String nom, Date date, Double prix) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.date = date;
        this.prix = prix;
    }

    public Produit() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}
