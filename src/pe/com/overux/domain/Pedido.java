package pe.com.overux.domain;

import java.util.Date;

public class Pedido extends  Base {

    Producto numProducto = new Producto();
    Sucursal numSucursal = new Sucursal();
    int numPedido;
    int numServicio;
    int numTotal;
    int numDescuento;
    int numSubtotal;
    int numComision;
    int numEstado;
    Date fechaEntrega;

    public Pedido() {
    }

    public Pedido(Producto numProducto, Sucursal numSucursal, int numPedido, int numServicio, int numTotal, int numDescuento, int numSubtotal, int numComision, int numEstado, Date fechaEntrega) {
        this.numProducto = numProducto;
        this.numSucursal = numSucursal;
        this.numPedido = numPedido;
        this.numServicio = numServicio;
        this.numTotal = numTotal;
        this.numDescuento = numDescuento;
        this.numSubtotal = numSubtotal;
        this.numComision = numComision;
        this.numEstado = numEstado;
        this.fechaEntrega = fechaEntrega;
    }

    public Producto getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(Producto numProducto) {
        this.numProducto = numProducto;
    }

    public Sucursal getNumSucursal() {
        return numSucursal;
    }

    public void setNumSucursal(Sucursal numSucursal) {
        this.numSucursal = numSucursal;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getNumServicio() {
        return numServicio;
    }

    public void setNumServicio(int numServicio) {
        this.numServicio = numServicio;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getNumTotal() {
        return numTotal;
    }

    public void setNumTotal(int numTotal) {
        this.numTotal = numTotal;
    }

    public int getNumDescuento() {
        return numDescuento;
    }

    public void setNumDescuento(int numDescuento) {
        this.numDescuento = numDescuento;
    }

    public int getNumSubtotal() {
        return numSubtotal;
    }

    public void setNumSubtotal(int numSubtotal) {
        this.numSubtotal = numSubtotal;
    }

    public int getNumComision() {
        return numComision;
    }

    public void setNumComision(int numComision) {
        this.numComision = numComision;
    }

    public int getNumEstado() {
        return numEstado;
    }

    public void setNumEstado(int numEstado) {
        this.numEstado = numEstado;
    }


}
