package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans;

import java.util.Calendar;
import java.util.Date;

public class Machine {
    private int id;
    private String reference;
    private Date date ;
    private double prix;
    private Marque marque;

    public Machine(int id, double prix, String reference, Marque marque) {
        this.id = id;
        this.reference = reference;
        this.date = Calendar.getInstance().getTime();
        this.prix = prix;
        this.marque = marque;
    }

    public Machine() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }
}
