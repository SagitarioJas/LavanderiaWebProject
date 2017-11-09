package pe.com.overux.model.iface;

import pe.com.overux.domain.Producto;
import java.util.ArrayList;

public interface IProducto {

    public String insert(Producto clientes);
    public String update(Producto clientes);
    public String delete(Producto clientes);
    public ArrayList<Producto> listar(Producto clientes);
    public Producto get(Producto clientes);
}
