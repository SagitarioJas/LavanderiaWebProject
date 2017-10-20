package pe.com.overux.model.iface;

import pe.com.overux.domain.Clientes;
import java.util.ArrayList;

public interface IClientes {

    public String insert(Clientes clientes);
    public String update(Clientes clientes);
    public String delete(Clientes clientes);
    public ArrayList<Clientes> listar(Clientes clientes);
    public Clientes get(Clientes clientes);
}
