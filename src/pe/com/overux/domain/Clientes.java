package pe.com.overux.domain;

import java.util.Date;

public class Clientes extends  Base {

    private int id;
    private Parametro tipoCliente = new Parametro();
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String razonSocial;
    private Parametro tipoDocumento = new Parametro();
    private String numeroDoc;
    private Parametro estadoCivil = new Parametro();
    private Date fechaRegistro;
    private Date fechaCese;
    private Ubigeo ubigeo = new Ubigeo();
    private Parametro estado = new Parametro();
    private String telefono;
    private String direccion;
    private String correo;
    private String celular;
    private String telefonoRef;


    public Clientes() {
    }

    public Clientes(int id) {
        this.id = id;
    }

    public Clientes(int id, Parametro tipoCliente, String nombre, String apellidoPat, String apellidoMat, String razonSocial, Parametro tipoDocumento, String numeroDoc, Parametro estadoCivil, Date fechaRegistro, Date fechaCese, Ubigeo ubigeo, Parametro estado, String telefono, String direccion, String correo, String celular, String telefonoRef) {
        this.id = id;
        this.tipoCliente = tipoCliente;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.razonSocial = razonSocial;
        this.tipoDocumento = tipoDocumento;
        this.numeroDoc = numeroDoc;
        this.estadoCivil = estadoCivil;
        this.fechaRegistro = fechaRegistro;
        this.fechaCese = fechaCese;
        this.ubigeo = ubigeo;
        this.estado = estado;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.telefonoRef = telefonoRef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parametro getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Parametro tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Parametro getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Parametro tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public Parametro getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Parametro estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public Parametro getEstado() {
        return estado;
    }

    public void setEstado(Parametro estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefonoRef() {
        return telefonoRef;
    }

    public void setTelefonoRef(String telefonoRef) {
        this.telefonoRef = telefonoRef;
    }
}
