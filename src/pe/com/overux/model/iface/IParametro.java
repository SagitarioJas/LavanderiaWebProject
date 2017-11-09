package pe.com.overux.model.iface;


import pe.com.overux.domain.Parametro;
import java.util.ArrayList;
import java.util.List;

public interface IParametro {
    public String insert(Parametro opcion);
    public String update(Parametro opcion);
    public String delete(Parametro opcion);
    public ArrayList<Parametro> listar(Parametro opcion);
    public List<Parametro> list(Parametro option);
    public Parametro get(Parametro opcion);

}
