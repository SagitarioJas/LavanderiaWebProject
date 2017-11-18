package pe.com.overux.controllers;


import pe.com.overux.domain.Cliente;
import pe.com.overux.domain.Pedido;
import pe.com.overux.services.FactoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "PedidoController", urlPatterns = "/pedido")
public class PedidoController {
    private FactoryService fs;
    private Pedido pedido;
    private boolean edit;

    String url;

    public PedidoController() {
        super();
        fs = FactoryService.getInstance();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException, ParseException {
        processRequest("POST", request, response);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException, ParseException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method,
                                HttpServletRequest request,
                                HttpServletResponse response)
            throws javax.servlet.ServletException, IOException, ParseException {

        String action = request.getParameter("action");
        if(method.equals("GET")) {
            // action == index
            if(action.equals("index")) {
                List<Pedido> pedidos = fs.getPedidoService().listar(pedido);
                request.setAttribute("pedidos", pedidos);
                url = "listPedido.jsp";
            }
            //action == show
            if(action.equals("show")) {
                pedido.setNumPedido(Integer.parseInt(request.getParameter("id")));
                pedido = fs.getPedidoService().get(pedido);
                request.setAttribute("pedido", pedido);
                url = "showPedido.jsp";
            }
            // action == new
            if(action.equals("new")) {
                url = "newPedido.jsp";
            }
            // action == edit
            if(action.equals("edit")) {
                pedido.setNumPedido(Integer.parseInt(request.getParameter("id")));
                pedido = fs.getPedidoService().get(pedido);
                request.setAttribute("pedido", pedido);
                url = "editPedido.jsp";
            }
        }
        if(method.equals("POST")) {
            // action == create
            if(action.equals("create")) {
                Pedido pedido = new Pedido();
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                pedido.setFechaEntrega(formatoDelTexto.parse(request.getParameter("fecha")));
                pedido.setNumServicio(Integer.parseInt(request.getParameter("numero")));
                fs.getPedidoService().insert(pedido);
                List<Pedido> pedidos = fs.getPedidoService().listar(pedido);
                request.setAttribute("pedido", pedidos);
                url = "listPedido.jsp";
            }
            // action == update
            if(action.equals("update")) {
                Pedido pedido = new Pedido();
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                pedido.setFechaEntrega(formatoDelTexto.parse(request.getParameter("fecha")));
                pedido.setNumServicio(Integer.parseInt(request.getParameter("numero")));
                fs.getPedidoService().update(pedido);
                List<Pedido> pedidos = fs.getPedidoService().listar(pedido);
                request.setAttribute("pedido", pedidos);
                url = "listPedido.jsp";
            }

        }

        request.getRequestDispatcher(url).forward(request, response);
    }

}
