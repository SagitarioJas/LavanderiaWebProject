package pe.com.overux.domain;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import pe.com.overux.services.impl.ProductoService;

import java.util.ArrayList;

public class ProductoAction extends ActionSupport implements ModelDriven<Producto> {
    ProductoService service = new ProductoService();
    Producto producto;

    public ProductoAction(){
        producto=service.listar(producto).get(0);
    }

    public ArrayList<Producto> getProducto(){
        return service.listar(producto);
    }

    @Override
    public Producto getModel() {
        return producto;
    }

    public String execute(){
        return SUCCESS;
    }
}
