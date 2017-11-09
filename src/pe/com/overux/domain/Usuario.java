package pe.com.overux.domain;

public class Usuario {

    int usuario;
    Parametro numPerfil = new Parametro();
    String nombre;
    String clave;

    public Usuario(int usuario, Parametro numPerfil, String nombre, String clave) {
        this.usuario = usuario;
        this.numPerfil = numPerfil;
        this.nombre = nombre;
        this.clave = clave;
    }

    public Usuario() {
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Parametro getNumPerfil() {
        return numPerfil;
    }

    public void setNumPerfil(Parametro numPerfil) {
        this.numPerfil = numPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
