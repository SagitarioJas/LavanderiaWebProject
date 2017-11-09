package pe.com.overux.model.iface;

import pe.com.overux.domain.Pedido;
import java.util.ArrayList;

public interface IPedido {

    public String insert(Pedido clientes);
    public String update(Pedido clientes);
    public String delete(Pedido clientes);
    public ArrayList<Pedido> listar(Pedido clientes);
    public Pedido get(Pedido clientes);
}
