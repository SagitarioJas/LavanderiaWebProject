package pe.com.overux.services;

import pe.com.overux.services.iface.IClienteService;
import pe.com.overux.services.impl.ClienteService;

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



}
