package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service;

import java.util.ArrayList;
import java.util.List;

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Machine;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.User;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.dao.IDao;

public class MachineService implements IDao<Machine> {
    private List<Machine> machines;
    private static MachineService instance;

    public MachineService() {
        this.machines = new ArrayList<>();
    }

    public static MachineService getInstance() {
        if (instance == null)
            instance = new MachineService();
        return instance;
    }

    @Override
    public boolean create(Machine o) {
        return machines.add(o);
    }

    @Override
    public boolean update(Machine o) {
        return false;
    }

    @Override
    public boolean delete(Machine o) {
        return machines.remove(o);
    }

    @Override
    public Machine findById(int id) {
        for (Machine m : machines) {
            if(m.getId() == id)
            {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Machine> findAll() {
        return machines;
    }
}
