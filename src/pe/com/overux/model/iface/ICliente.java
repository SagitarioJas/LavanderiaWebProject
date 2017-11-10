package pe.com.overux.model.iface;

import pe.com.overux.domain.Cliente;
import java.util.ArrayList;

public interface ICliente {

    public String insert(Cliente cliente);
    public String update(Cliente cliente);
    public String delete(Cliente cliente);
    public ArrayList<Cliente> listar(Cliente cliente);
    public Cliente get(Cliente cliente);
}
