package pe.com.overux.model;

import pe.com.overux.model.iface.ICliente;
import pe.com.overux.model.iface.IPedido;
import pe.com.overux.model.iface.IUsuario;
import pe.com.overux.model.impl.ClienteDao;
import pe.com.overux.model.impl.PedidoDao;
import pe.com.overux.model.impl.UsuarioDao;

import java.io.Serializable;

public class FactoryDao implements Serializable {

    private static FactoryDao singleton = null;

    private FactoryDao() {

    }

    public static synchronized FactoryDao getInstance() {
        if (singleton == null) {
            singleton = new FactoryDao();
        }
        return singleton;
    }

    public ICliente getClienteDao(){
        return new ClienteDao();
    }

    public IPedido getPedidoDao(){
        return new PedidoDao();
    }

    public IUsuario getUsuarioDao(){
        return new UsuarioDao();
    }










}
