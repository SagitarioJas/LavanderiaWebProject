package pe.com.overux.domain;

public class Filtro {
    private int codigo;
    private String tabla;
    private String titulo;
    private String valor;
    private int orden;

    public Filtro() {
    }

    public Filtro(int codigo, String tabla, String titulo, String valor, int orden) {
        this.codigo = codigo;
        this.tabla = tabla;
        this.titulo = titulo;
        this.valor = valor;
        this.orden = orden;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
