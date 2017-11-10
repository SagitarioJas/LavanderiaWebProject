package pe.com.overux.services.iface;

import pe.com.overux.domain.Producto;

import java.util.ArrayList;

public interface IProductoService {

    public String insert(Producto clientes);
    public String update(Producto clientes);
    public String delete(Producto clientes);
    public ArrayList<Producto> listar(Producto clientes);
    public Producto get(Producto clientes);
}
