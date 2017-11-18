package pe.com.overux.domain;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import pe.com.overux.services.impl.UsuarioService;

import java.util.ArrayList;

public class UsuarioAction extends ActionSupport implements ModelDriven<Usuario> {
    UsuarioService service = new UsuarioService();
    Usuario user;

    public UsuarioAction(){
        user = service.listar(user).get(0);
   }

    public ArrayList<Usuario> getUsuario(){
        return service.listar(user);
    }

    @Override
    public Usuario getModel() {
        return user;
    }

    public String execute(){
        return  SUCCESS;
    }
}
