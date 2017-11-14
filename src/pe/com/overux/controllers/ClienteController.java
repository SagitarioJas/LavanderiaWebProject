package pe.com.overux.controllers;

import pe.com.overux.services.FactoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ClienteController", urlPatterns = "/clientes")

public class ClienteController {
    FactoryService service;
    String url;

    public ClienteController() {
        super();
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
       /* if(method.equals("GET")) {
            // action == index
            if(action.equals("index")) {
                List<Region> regions = service.findAllRegions();
                request.setAttribute("regions", regions);
                url = "listRegions.jsp";
            }
            //action == show
            if(action.equals("show")) {
                Region region = service.findRegionById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("region", region);
                url = "showRegion.jsp";
            }
            // action == new
            if(action.equals("new")) {
                url = "newRegion.jsp";
            }
            // action == edit
            if(action.equals("edit")) {
                Region region = service.findRegionById(
                        Integer.parseInt(
                                request.getParameter("id")));
                request.setAttribute("region", region);
                url = "editRegion.jsp";
            }
        }
        if(method.equals("POST")) {
            // action == create
            if(action.equals("create")) {
                String name = request.getParameter("name");
                Region region = service.createRegion(name);
                request.setAttribute("regions", service.findAllRegions());
                url = "listRegions.jsp";
            }
            // action == update
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean isUpdated = service.updateRegion(new Region(id, name));
                request.setAttribute("regions", service.findAllRegions());
                url = "listRegions.jsp";
            }

        }*/

        request.getRequestDispatcher(url).forward(request, response);
    }



}
