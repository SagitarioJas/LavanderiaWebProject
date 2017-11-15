package pe.com.overux.services.impl;

import pe.com.overux.domain.Usuario;
import pe.com.overux.model.FactoryDao;
import pe.com.overux.services.iface.IUsuarioService;

import java.util.ArrayList;

public class UsuarioService implements IUsuarioService {

    FactoryDao dao;

    public UsuarioService() {
        dao = FactoryDao.getInstance();
    }

    @Override
    public String insert(Usuario user) {
        return dao.getUsuarioDao().insert(user);
    }

    @Override
    public String update(Usuario user) {
        return dao.getUsuarioDao().update(user);
    }

    @Override
    public String delete(Usuario user) {

        return dao.getUsuarioDao().delete(user);
    }

    @Override
    public ArrayList<Usuario> listar(Usuario user) {
        return dao.getUsuarioDao().listar(user);
    }

    @Override
    public Usuario get(Usuario user) {

        return dao.getUsuarioDao().get(user);
    }
}
