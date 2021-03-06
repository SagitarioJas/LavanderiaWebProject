package pe.com.overux.controllers;

import pe.com.overux.domain.Cliente;
import pe.com.overux.services.FactoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ClienteController", urlPatterns = "/clientes")

public class ClienteController {
    private FactoryService fs;
    private Cliente cliente;
    private boolean edit;

    String url;

    public ClienteController() {
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
                List<Cliente> clientes = fs.getClienteService().listar(cliente);
                request.setAttribute("clientes", clientes);
                url = "listClientes.jsp";
            }
            //action == show
            if(action.equals("show")) {
                cliente.setId(Integer.parseInt(request.getParameter("id")));
                cliente = fs.getClienteService().get(cliente);
                request.setAttribute("cliente", cliente);
                url = "showCliente.jsp";
            }
            // action == new
            if(action.equals("new")) {
                url = "newCliente.jsp";
            }
            // action == edit
            if(action.equals("edit")) {
                cliente.setId(Integer.parseInt(request.getParameter("id")));
                cliente = fs.getClienteService().get(cliente);
                request.setAttribute("cliente", cliente);
                url = "editCliente.jsp";
            }
        }
        if(method.equals("POST")) {
            // action == create
            if(action.equals("create")) {
                Cliente cliente = new Cliente();
                cliente .setApellidoMat(request.getParameter("apellidoMat"));
                cliente.setNombre(request.getParameter("nomMat"));
                fs.getClienteService().insert(cliente);
                List<Cliente> clientes = fs.getClienteService().listar(cliente);
                request.setAttribute("clientes", clientes);
                url = "listClientes.jsp";
            }
            // action == update
            if(action.equals("update")) {
                Cliente cliente = new Cliente();
                cliente .setApellidoMat(request.getParameter("apellidoMat"));
                cliente.setNombre(request.getParameter("nomMat"));
                fs.getClienteService().update(cliente);
                List<Cliente> clientes = fs.getClienteService().listar(cliente);
                request.setAttribute("clientes", clientes);
                url = "listClientes.jsp";
            }

        }

        request.getRequestDispatcher(url).forward(request, response);
    }



}
