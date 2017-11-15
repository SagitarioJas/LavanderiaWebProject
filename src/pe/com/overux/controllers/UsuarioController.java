package pe.com.overux.controllers;

import pe.com.overux.domain.Pedido;
import pe.com.overux.domain.Usuario;
import pe.com.overux.services.FactoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "UsuarioController", urlPatterns = "/usuario")
public class UsuarioController {
    private FactoryService fs;
    private Usuario usuario;
    private boolean edit;

    String url;

    public UsuarioController() {
        super();
        fs = FactoryService.getInstance();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method,
                                HttpServletRequest request,
                                HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");
        if(method.equals("GET")) {
            // action == index
            if(action.equals("index")) {
                List<Usuario> usuarios = fs.getUsuarioService().listar(usuario);
                request.setAttribute("usuarios", usuarios);
                url = "listUsuarios.jsp";
            }
            //action == show
            if(action.equals("show")) {
                usuario.setUsuario(Integer.parseInt(request.getParameter("id")));
                usuario = fs.getUsuarioService().get(usuario);
                request.setAttribute("usuario", usuario);
                url = "showUsuarios.jsp";
            }
            // action == new
            if(action.equals("new")) {
                url = "newUsuario.jsp";
            }
            // action == edit
            if(action.equals("edit")) {
                usuario.setUsuario(Integer.parseInt(request.getParameter("id")));
                usuario = fs.getUsuarioService().get(usuario);
                request.setAttribute("usuario", usuario);
                url = "editUsuario.jsp";
            }
        }
        if(method.equals("POST")) {
            // action == create
            if(action.equals("create")) {
                Usuario usuario = new Usuario();
                usuario.setNombre(request.getParameter("fecha"));
                usuario.setClave(request.getParameter("numero"));
                fs.getUsuarioService().insert(usuario);
                List<Usuario> usuarios = fs.getUsuarioService().listar(usuario);
                request.setAttribute("usuarios", usuarios);
                url = "listUsuarios.jsp";
            }
            // action == update
            if(action.equals("update")) {
                Usuario usuario = new Usuario();
                usuario.setNombre(request.getParameter("fecha"));
                usuario.setClave(request.getParameter("numero"));
                fs.getUsuarioService().update(usuario);
                List<Usuario> usuarios = fs.getUsuarioService().listar(usuario);
                request.setAttribute("usuarios", usuarios);
                url = "listUsuarios.jsp";
            }

        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
