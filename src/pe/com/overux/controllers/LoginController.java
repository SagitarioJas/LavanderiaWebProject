package pe.com.overux.controllers;

import pe.com.overux.domain.Pedido;
import pe.com.overux.domain.Usuario;
import pe.com.overux.globals.Session;
import pe.com.overux.services.FactoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController {
    private FactoryService fs;
    private Usuario usuario ;
    private boolean edit;

    String url;

    public LoginController() {
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
        if(method.equals("POST")) {
            // action == create
            if(action.equals("iniciar")) {
                Usuario usuario = new Usuario();
                usuario.setNombre(request.getParameter("usuario"));
                usuario.setClave(request.getParameter("clave"));
                usuario = fs.getUsuarioService().get(usuario);
                if (usuario != null) {
                    Session.id = usuario.getUsuario();
                    Session.nombre = usuario.getNombre();
                    url = "Principal.jsp";
                }
            }


        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
