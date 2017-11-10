package pe.com.overux.services.iface;

import pe.com.overux.domain.TipoParametro;

import java.util.ArrayList;

public interface ITipoParametroService {

    public String insert(TipoParametro clientes);
    public String update(TipoParametro clientes);
    public String delete(TipoParametro clientes);
    public ArrayList<TipoParametro> listar(TipoParametro clientes);
    public TipoParametro get(TipoParametro clientes);
}
