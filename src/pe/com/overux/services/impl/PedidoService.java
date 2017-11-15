package pe.com.overux.services.impl;

import pe.com.overux.domain.Pedido;
import pe.com.overux.model.FactoryDao;
import pe.com.overux.services.iface.IPedidoService;

import java.util.ArrayList;

public class PedidoService implements IPedidoService {

    FactoryDao dao;

    public PedidoService() {
        dao = FactoryDao.getInstance();
    }

    @Override
    public String insert(Pedido clientes) {
        return dao.getPedidoDao().insert(clientes);
    }

    @Override
    public String update(Pedido clientes) {
        return dao.getPedidoDao().update(clientes);
    }

    @Override
    public String delete(Pedido clientes) {
        return dao.getPedidoDao().delete(clientes);
    }

    @Override
    public ArrayList<Pedido> listar(Pedido clientes) {
        return dao.getPedidoDao().listar(clientes);
    }

    @Override
    public Pedido get(Pedido clientes) {
        return dao.getPedidoDao().get(clientes);
    }
}
