package pe.com.overux.model.impl;

import pe.com.overux.connection.ConnectionDatabase;
import pe.com.overux.domain.Parametro;
import pe.com.overux.model.iface.IParametro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParametroDao implements IParametro {

    @Override
    public List<Parametro> list(Parametro p) {
        Connection c= ConnectionDatabase.getConnection();
        List<Parametro> lst=null;
        if(c!=null)
        {
            try {
                String sql="Select "
                        +"n_parametro_pk,"
                        +"c_codigo,"
                        +"n_tipo_parametro,"
                        +"c_nombre "
                        +"From tab_parametro "
                        +"Where n_tipo_parametro=? order by n_parametro_pk";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1,p.getTipo().getId());
                ResultSet rs=ps.executeQuery();
                lst=new ArrayList<>();
                while(rs.next()){
                    Parametro parametro=new Parametro();
                    parametro.setId(rs.getInt("n_parametro_pk"));
                    parametro.setNombre(rs.getString("c_nombre"));
                    parametro.setCodigo(rs.getString("c_codigo"));
                    lst.add(parametro);
                }
            }
            catch (SQLException ex)
            { ex.printStackTrace();
            }finally {
                if(c!=null)
                {
                    try{
                        c.close();
                    }catch (SQLException e){

                    }
                }
            }
        }
        return null;
    }

    @Override
    public Parametro get(Parametro p) {
        Connection c = ConnectionDatabase.getConnection();
        Parametro parameter = null;
        if (c != null) {
            try {
                String sql = "SELECT "
                        + "n_parametro_pk, "
                        + "c_codigo, "
                        + "n_tipo_parametro, "
                        + "c_nombre  "
                        + "FROM tab_parametro ";
                if (p.getId() != 0) {
                    sql = sql + "WHERE n_parametro_pk = ?";
                } else if (p.getCodigo() != null) {
                    sql = sql + "WHERE c_codigo = ?"
                            + " and n_tipo_parametro = ? ";
                }
                PreparedStatement ps = c.prepareStatement(sql);
                if (p.getId() != 0) {
                    ps.setInt(1, p.getId());
                } else if (p.getCodigo() != null) {
                    ps.setString(1, p.getCodigo());
                    ps.setInt(2, p.getTipo().getId());
                }
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    parameter = new Parametro();
                    parameter.setId(rs.getInt("n_parametro_pk"));
                    parameter.setNombre(rs.getString("c_nombre"));
                    parameter.setCodigo(rs.getString("c_codigo"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }
        return parameter;
    }
}
