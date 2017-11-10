package pe.com.overux.model;

import pe.com.overux.model.iface.ICliente;
import pe.com.overux.model.impl.ClienteDao;

import java.io.Serializable;

public class FactoryDao implements Serializable {

    private static final long serialVersionUID = 5503010918387571847L;
    private static FactoryDao singleton = null;

    private FactoryDao() {

    }

    public static synchronized FactoryDao getInstance() {
        if (singleton == null) {
            singleton = new FactoryDao();
        }
        return singleton;
    }








}
