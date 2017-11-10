package pe.com.overux.services.iface;

import pe.com.overux.domain.DetalleOpcion;

import java.util.ArrayList;

public interface IDetalleOpcionService {

    public String insert(DetalleOpcion opcion);
    public String update(DetalleOpcion opcion);
    public String delete(DetalleOpcion opcion);
    public ArrayList<DetalleOpcion> listar(DetalleOpcion opcion);
    public DetalleOpcion get(DetalleOpcion opcion);
}
