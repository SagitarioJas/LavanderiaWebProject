package pe.com.overux.domain;

public class DetalleOpcion extends Base  {

    private int Id;
    private Perfil idPerfil=new Perfil();
    private Opcion idopcion=new Opcion();
    private String Acceso;
    private String Escritura;
    private String Lectura;
    private String Eliminar;
    private String Ejecucion;

    public DetalleOpcion() {
    }

    public DetalleOpcion(int id, Perfil idPerfil, Opcion idopcion, String acceso, String escritura, String lectura, String eliminar, String ejecucion) {
        Id = id;
        this.idPerfil = idPerfil;
        this.idopcion = idopcion;
        Acceso = acceso;
        Escritura = escritura;
        Lectura = lectura;
        Eliminar = eliminar;
        Ejecucion = ejecucion;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Opcion getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(Opcion idopcion) {
        this.idopcion = idopcion;
    }

    public String getAcceso() {
        return Acceso;
    }

    public void setAcceso(String acceso) {
        Acceso = acceso;
    }

    public String getEscritura() {
        return Escritura;
    }

    public void setEscritura(String escritura) {
        Escritura = escritura;
    }

    public String getLectura() {
        return Lectura;
    }

    public void setLectura(String lectura) {
        Lectura = lectura;
    }

    public String getEliminar() {
        return Eliminar;
    }

    public void setEliminar(String eliminar) {
        Eliminar = eliminar;
    }

    public String getEjecucion() {
        return Ejecucion;
    }

    public void setEjecucion(String ejecucion) {
        Ejecucion = ejecucion;
    }
}
