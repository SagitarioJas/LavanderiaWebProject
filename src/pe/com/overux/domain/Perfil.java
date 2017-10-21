package pe.com.overux.domain;

public class Perfil {

    int numPerfil;
    String nombre;

    public Perfil(int numPerfil, String nombre) {
        this.numPerfil = numPerfil;
        this.nombre = nombre;
    }

    public Perfil() {

    }

    public int getNumPerfil() {
        return numPerfil;
    }

    public void setNumPerfil(int numPerfil) {
        this.numPerfil = numPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
