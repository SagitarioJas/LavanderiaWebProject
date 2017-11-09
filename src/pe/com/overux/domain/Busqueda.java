package pe.com.overux.domain;

import java.util.ArrayList;
import java.util.List;

public class Busqueda {

    private int codigo;
    private String tabla;
    private String select;
    private String orderBy;
    private List<Filtro> filtros = new ArrayList<>();
    private List<Columna> columnas = new ArrayList<>();

    public Busqueda() {
    }

    public Busqueda(int codigo, String tabla, String select, String orderBy, List<Filtro> filtros, List<Columna> columnas) {
        this.codigo = codigo;
        this.tabla = tabla;
        this.select = select;
        this.orderBy = orderBy;
        this.filtros = filtros;
        this.columnas = columnas;
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

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<Filtro> getFiltros() {
        return filtros;
    }

    public void setFiltros(List<Filtro> filtros) {
        this.filtros = filtros;
    }

    public List<Columna> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<Columna> columnas) {
        this.columnas = columnas;
    }
}
