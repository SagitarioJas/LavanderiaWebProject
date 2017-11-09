package pe.com.overux.domain;

public class Opcion extends  Base {
    private int id;
    private int padre;
    private String nombre;
    private String enlace;
    private int orden;
    private int perfil;

    public Opcion() {
    }

    public Opcion(int id) {
        this.id = id;
    }

    public Opcion(int id, int padre, String nombre, String enlace, int orden, int perfil) {
        this.id = id;
        this.padre = padre;
        this.nombre = nombre;
        this.enlace = enlace;
        this.orden = orden;
        this.perfil = perfil;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }


    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
}
