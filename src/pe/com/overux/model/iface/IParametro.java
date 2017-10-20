package pe.com.overux.model.iface;

import pe.com.overux.domain.Parametro;
import java.util.List;

public interface IParametro {
    public List<Parametro> list(Parametro p);
    public Parametro get(Parametro p);

}
