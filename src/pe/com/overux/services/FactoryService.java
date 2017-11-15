package pe.com.overux.services;

import pe.com.overux.model.iface.IUsuario;
import pe.com.overux.services.iface.IClienteService;
import pe.com.overux.services.iface.IPedidoService;
import pe.com.overux.services.iface.IUsuarioService;
import pe.com.overux.services.impl.ClienteService;
import pe.com.overux.services.impl.PedidoService;
import pe.com.overux.services.impl.UsuarioService;

public class FactoryService {

    private static FactoryService singleton = null;

    private FactoryService() {

    }

    public static synchronized FactoryService getInstance() {
        if (singleton == null) {
            singleton = new FactoryService();
        }
        return singleton;
    }

    public IClienteService getClienteService() {
        return new ClienteService();
    }
    public IPedidoService getPedidoService(){
        return new PedidoService();
    }
    public IUsuarioService getUsuarioService(){
        return new UsuarioService();
    }



}
