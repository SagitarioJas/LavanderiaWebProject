package pe.com.overux.domain;

public class Perfil extends  Base {

    int id;
    String nombre;

    public Perfil() {
    }

    public Perfil(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
