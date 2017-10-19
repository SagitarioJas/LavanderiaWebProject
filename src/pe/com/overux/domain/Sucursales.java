package pe.com.overux.domain;

public class Sucursales extends  Base {

    private int id;
    private Clientes clientes=new Clientes();
    private String nombre;
    private String direccion;
    private Ubigeo ubigeo=new Ubigeo();
    private String telefono;
    private String celular;

    public Sucursales() {
    }

    public Sucursales(int id, Clientes clientes, String nombre, String direccion, Ubigeo ubigeo, String telefono, String celular) {
        this.id = id;
        this.clientes = clientes;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ubigeo = ubigeo;
        this.telefono = telefono;
        this.celular = celular;
    }


}
