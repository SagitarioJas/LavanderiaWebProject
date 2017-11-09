package pe.com.overux.domain;

import java.util.Date;

public class Producto extends  Base{

    private int id;
    private Parametro tipoRopa = new Parametro();
    private String nombre;

    public Producto() {
    }

    public Producto(int id, Parametro tipoRopa, String nombre) {
        this.id = id;
        this.tipoRopa = tipoRopa;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parametro getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(Parametro tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
