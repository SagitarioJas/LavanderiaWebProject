package pe.com.overux.domain;

public class Sucursal extends  Base {

    private int id;
    private Cliente cliente =new Cliente();
    private String nombre;
    private String direccion;
    private Ubigeo ubigeo=new Ubigeo();
    private Ubigeo provincia = new Ubigeo();
    private Ubigeo departamento = new Ubigeo();
    private String telefono;
    private String celular;
    private String horaini;
    private String horafin;

    public Sucursal() {
    }

    public Sucursal(int id) {
        this.id = id;
    }

    public Sucursal(int id, Cliente cliente, String nombre, String direccion, Ubigeo ubigeo, Ubigeo provincia, Ubigeo departamento, String telefono, String celular, String horaini, String horafin) {
        this.id = id;
        this.cliente = cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ubigeo = ubigeo;
        this.provincia = provincia;
        this.departamento = departamento;
        this.telefono = telefono;
        this.celular = celular;
        this.horaini = horaini;
        this.horafin = horafin;
    }

    public String getHoraini() {
        return horaini;
    }

    public void setHoraini(String horaini) {
        this.horaini = horaini;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public Ubigeo getProvincia() {
        return provincia;
    }

    public void setProvincia(Ubigeo provincia) {
        this.provincia = provincia;
    }

    public Ubigeo getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Ubigeo departamento) {
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
