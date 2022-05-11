package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service;

import java.util.ArrayList;
import java.util.List;

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Machine;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Marque;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.dao.IDao;

public class MarqueService implements IDao<Marque> {
    private List<Marque> marques;
    private static MarqueService instance;

    public MarqueService() {
        this.marques = new ArrayList<>();
    }

    public static MarqueService getInstance() {
        if (instance == null)
            instance = new MarqueService();
        return instance;
    }

    @Override
    public boolean create(Marque o) {
        return marques.add(o);
    }

    @Override
    public boolean update(Marque o) {
        return false;
    }

    @Override
    public boolean delete(Marque o) {
        return marques.remove(o);
    }

    @Override
    public Marque findById(int id) {
        for (Marque m :marques) {
            if(m.getId()==id)
            {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Marque> findAll() {
        return marques;
    }
}
