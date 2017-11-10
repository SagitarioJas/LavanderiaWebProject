package pe.com.overux.services.iface;

import pe.com.overux.domain.Sucursal;

import java.util.ArrayList;

public interface ISucursalService {

    public String insert(Sucursal clientes);
    public String update(Sucursal clientes);
    public String delete(Sucursal clientes);
    public ArrayList<Sucursal> listar(Sucursal clientes);
    public Sucursal get(Sucursal clientes);

}
