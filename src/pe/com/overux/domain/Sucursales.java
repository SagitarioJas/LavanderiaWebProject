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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
