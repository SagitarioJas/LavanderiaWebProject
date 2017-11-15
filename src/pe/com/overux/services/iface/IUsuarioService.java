package pe.com.overux.services.iface;

import pe.com.overux.domain.Usuario;

import java.util.ArrayList;

public interface IUsuarioService {
    public String insert(Usuario user);
    public String update(Usuario user);
    public String delete(Usuario user);
    public ArrayList<Usuario> listar(Usuario user);
    public Usuario get(Usuario user);
}
