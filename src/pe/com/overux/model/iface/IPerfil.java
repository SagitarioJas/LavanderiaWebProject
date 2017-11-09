package pe.com.overux.model.iface;

import pe.com.overux.domain.Perfil;
import java.util.ArrayList;

public interface IPerfil {

    public String insert(Perfil perfil);
    public String update(Perfil perfil);
    public String delete(Perfil perfil);
    public ArrayList<Perfil> listar(Perfil perfil);
    public Perfil get(Perfil perfil);
}
