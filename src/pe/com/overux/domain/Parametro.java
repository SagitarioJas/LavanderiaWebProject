package pe.com.overux.domain;

public class Parametro {

    private int id;
    private String codigo;
    private String nombre;
    private TipoParametro tipo = new TipoParametro();

    public Parametro() {
    }

    public Parametro(int id, String codigo, String nombre, TipoParametro tipo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoParametro getTipo() {
        return tipo;
    }

    public void setTipo(TipoParametro tipo) {
        this.tipo = tipo;
    }
}
