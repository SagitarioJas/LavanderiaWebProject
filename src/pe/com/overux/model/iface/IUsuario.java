package pe.com.overux.model.iface;

import pe.com.overux.domain.Usuario;

import java.util.ArrayList;

public interface IUsuario {
    public String insert(Usuario user);
    public String update(Usuario user);
    public String delete(Usuario user);
    public ArrayList<Usuario> listar(Usuario user);
    public Usuario get(Usuario user);
}
