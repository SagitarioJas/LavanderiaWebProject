package pe.com.overux.model.impl;

import pe.com.overux.connection.ConnectionDatabase;
import pe.com.overux.domain.Busqueda;
import pe.com.overux.domain.Columna;
import pe.com.overux.domain.Filtro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusquedaDao {
    public List<HashMap<String, Object>> list(String select, boolean admin) {
        List<HashMap<String, Object>> lista = new ArrayList<>();
        try {
            Connection c;
            c = ConnectionDatabase.getConnection();
            PreparedStatement ps = c.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                HashMap<String, Object> item = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    item.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
                }
                lista.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusquedaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Busqueda get(String tabla) {
        Connection c = ConnectionDatabase.getConnection();
        Busqueda f = null;
        if (c != null) {
            try {
                String sql = "SELECT "
                        + "n_busqueda_pk, "
                        + "c_tabla, "
                        + "c_select, "
                        + "c_order   "
                        + "FROM tab_busqueda "
                        + "WHERE c_tabla='" + tabla + "'";

                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    f = new Busqueda();
                    f.setCodigo(rs.getInt("n_busqueda_pk"));
                    f.setTabla(rs.getString("c_tabla"));
                    f.setSelect(rs.getString("c_select"));
                    f.setOrderBy(rs.getString("c_order"));
                    sql = " SELECT "
                            + "n_filtro_pk, "
                            + "c_tabla, "
                            + "c_titulo, "
                            + "c_valor, "
                            + "n_orden, "
                            + "n_busqueda "
                            + "FROM tab_filtro "
                            + "WHERE n_busqueda=" + f.getCodigo()
                            + " ORDER BY n_orden";
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Filtro filtro = new Filtro();
                        filtro.setCodigo(rs.getInt("n_filtro_pk"));
                        filtro.setTabla(rs.getString("c_tabla"));
                        filtro.setTitulo(rs.getString("c_titulo"));
                        filtro.setValor(rs.getString("c_valor"));
                        filtro.setOrden(rs.getInt("n_orden"));
                        f.getFiltros().add(filtro);
                    }
                    sql = " SELECT n_columna_pk, "
                            + "c_valor, "
                            + "c_titulo, "
                            + "n_orden, "
                            + "n_busqueda "
                            + "FROM tab_columnas_busqueda "
                            + "WHERE n_busqueda=" + f.getCodigo()
                            + " ORDER BY n_orden";
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Columna columna = new Columna();
                        columna.setCodigo(rs.getInt("n_columna_pk"));
                        columna.setTitulo(rs.getString("c_titulo"));
                        columna.setValor(rs.getString("c_valor"));
                        columna.setOrden(rs.getInt("n_orden"));
                        f.getColumnas().add(columna);
                    }

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return f;
    }

}
