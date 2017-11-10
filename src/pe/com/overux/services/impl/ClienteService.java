package pe.com.overux.services.impl;

import pe.com.overux.domain.Cliente;
import pe.com.overux.model.FactoryDao;
import pe.com.overux.services.iface.IClienteService;

import java.util.ArrayList;

public class ClienteService implements IClienteService {

    FactoryDao dao;

    public ClienteService() {
        dao = FactoryDao.getInstance();
    }

    @Override
    public String insert(Cliente cliente) {
        return null;
    }

    @Override
    public String update(Cliente cliente) {
        return null;
    }

    @Override
    public String delete(Cliente cliente) {
        return null;
    }

    @Override
    public ArrayList<Cliente> listar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente get(Cliente cliente) {
        return null;
    }
}
