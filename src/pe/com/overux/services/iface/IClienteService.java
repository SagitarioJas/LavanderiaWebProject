package pe.com.overux.services.iface;

import pe.com.overux.domain.Cliente;

import java.util.ArrayList;

public interface IClienteService {

    public String insert(Cliente cliente);
    public String update(Cliente cliente);
    public String delete(Cliente cliente);
    public ArrayList<Cliente> listar(Cliente cliente);
    public Cliente get(Cliente cliente);
}
