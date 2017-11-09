package pe.com.overux.domain;

public class Columna {
    private int codigo;
    private String valor;
    private String titulo;
    private int orden;

    public Columna() {
    }

    public Columna(int codigo, String valor, String titulo, int orden) {
        this.codigo = codigo;
        this.valor = valor;
        this.titulo = titulo;
        this.orden = orden;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
