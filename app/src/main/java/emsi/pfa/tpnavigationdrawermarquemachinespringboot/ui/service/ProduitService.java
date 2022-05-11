package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service;

import java.util.ArrayList;
import java.util.List;

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Produit;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.dao.IDao;

public class ProduitService implements IDao<Produit> {
    private List<Produit> produits;
    private static ProduitService instance;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }

    public static ProduitService getInstance() {
        if (instance == null)
            instance = new ProduitService();
        return instance;
    }

    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean update(Produit o) {
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        return produits.remove(o);
    }

    @Override
    public Produit findById(int id) {
        for (Produit p :produits) {
            if(p.getId()==id)
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }
}
