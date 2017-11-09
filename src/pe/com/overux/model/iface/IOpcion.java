package pe.com.overux.model.iface;


import pe.com.overux.domain.Opcion;

import java.util.ArrayList;
import java.util.List;

public interface IOpcion {
    public String insert(Opcion opcion);
    public String update(Opcion opcion);
    public String delete(Opcion opcion);
    public ArrayList<Opcion> listar(Opcion opcion);
    public List<Opcion> list(Opcion option);
    public Opcion get(Opcion opcion);
}
