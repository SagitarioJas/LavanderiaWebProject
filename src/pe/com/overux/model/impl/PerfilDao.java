package pe.com.overux.model.impl;

import pe.com.overux.connection.ConnectionDatabase;
import pe.com.overux.domain.Perfil;
import pe.com.overux.model.iface.IPerfil;

import java.sql.*;
import java.util.ArrayList;

public class PerfilDao implements IPerfil {

    @Override
    public String insert(Perfil perfil) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                String sql = "Insert into  tab_perfil "
                        + "(c_nombre, "
                        + "aud_usuario_creacion, "
                        + "aud_fecha_creacion) "
                        + " values (?,?,?)";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, perfil.getNombre().toUpperCase());
                ps.setInt(2, perfil.getUsuarioCreacion());
                ps.setDate(3, (Date) perfil.getFechaCreacion());
                ps.executeQuery();

            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        return null;
    }

    @Override
    public String update(Perfil perfil) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                String sql = "update  tab_perfil set "
                        + "c_nombre=?, "
                        + "aud_usuario_modificacion=?, "
                        + "aud_fecha_modificacion=? "
                        + " where n_pefil_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, perfil.getNombre().toUpperCase());
                ps.setInt(2, perfil.getUsuarioModificacion());
                ps.setDate(3, (Date) perfil.getFechaModificacion());
                ps.setInt(4, perfil.getId());
                ps.executeQuery();

            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        return null;
    }

    @Override
    public String delete(Perfil perfil) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                String sql = "delete from  tab_perfil "
                        + " where n_pefil_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, perfil.getId());
                ps.executeQuery();
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Perfil> listar(Perfil perfil) {
        Connection c = ConnectionDatabase.getConnection();
        Perfil oPerfil = null;
        ArrayList<Perfil> Perfil = null;
        if (c != null) {
            try {
                String sql = "SELECT "
                        + "n_pefil_pk, "
                        + "c_nombre, "
                        + "aud_usuario_creacion, "
                        + "aud_usuario_modificacion, "
                        + "aud_fecha_creacion, "
                        + "aud_fecha_modificacion"
                        + " FROM tab_perfil ";
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                Perfil = new ArrayList<Perfil>();
                if (rs.next()) {
                    oPerfil = new Perfil();
                    oPerfil.setNombre(rs.getString("c_nombre"));
                    Perfil.add(oPerfil);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return Perfil;
    }

    @Override
    public Perfil get(Perfil perfil) {
        Connection c = ConnectionDatabase.getConnection();
        Perfil oPerfil = null;
        if (c != null) {
            try {
                String sql = "SELECT "
                        + "n_pefil_pk, "
                        + "c_nombre, "
                        + "aud_usuario_creacion,"
                        + "aud_usuario_modificacion, "
                        + "aud_fecha_creacion, "
                        + "aud_fecha_modificacion"
                        + " FROM tab_perfil where n_pefil_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, perfil.getId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    oPerfil = new Perfil();
                    oPerfil.setNombre(rs.getString("c_nombre"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return oPerfil;
    }
}
