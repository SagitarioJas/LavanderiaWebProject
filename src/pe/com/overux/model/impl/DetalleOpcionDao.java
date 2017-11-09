package pe.com.overux.model.impl;

import pe.com.overux.connection.ConnectionDatabase;
import pe.com.overux.domain.DetalleOpcion;
import pe.com.overux.domain.Opcion;
import pe.com.overux.domain.Perfil;
import pe.com.overux.model.iface.IDetalleOpcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleOpcionDao implements IDetalleOpcion {


    @Override
    public String insert(DetalleOpcion opcion) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                String sql = "Insert into  det_perfil_opcion "
                        + "(n_perfil, "
                        + "n_opcion, "
                        + "f_acceso, "
                        + "f_escritura, "
                        + "f_lectura, "
                        + "f_eliminar, "
                        + "f_ejecucion, "
                        + "aud_usuario_creacion,"
                        + "aud_fecha_creacion) "
                        + " values (?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, opcion.getIdPerfil().getId());
                ps.setInt(2, opcion.getIdopcion().getId());
                ps.setString(3, opcion.getAcceso());
                ps.setString(4, opcion.getEscritura());
                ps.setString(5, opcion.getLectura());
                ps.setString(6, opcion.getEliminar());
                ps.setString(7, opcion.getEjecucion());
                ps.setInt(8, opcion.getUsuarioCreacion());
                ps.setDate(9, (Date) opcion.getFechaCreacion());
                ps.executeQuery();

            } catch (SQLException ex) {
                ex.getMessage();
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String update(DetalleOpcion opcion) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                String sql = "update  det_perfil_opcion set "
                        + "n_perfil=?, "
                        + "n_opcion=?, "
                        + "f_acceso=?, "
                        + "f_escritura=?, "
                        + "f_lectura=?, "
                        + "f_eliminar=?, "
                        + "f_ejecucion=?, "
                        + "aud_usuario_modificacion=?,"
                        + "aud_fecha_modificacion=? "
                        + " where n_correlativo_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, opcion.getIdPerfil().getId());
                ps.setInt(2, opcion.getIdopcion().getId());
                ps.setString(3, opcion.getAcceso());
                ps.setString(4, opcion.getEscritura());
                ps.setString(5, opcion.getLectura());
                ps.setString(6, opcion.getEliminar());
                ps.setString(7, opcion.getEjecucion());
                ps.setInt(8, opcion.getUsuarioModificacion());
                ps.setDate(9, (Date) opcion.getFechaModificacion());
                ps.setInt(10, opcion.getId());
                ps.executeQuery();

            } catch (SQLException ex) {
                ex.getMessage();
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String delete(DetalleOpcion opcion) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                String sql = "delete from  det_perfil_opcion "
                        + " where n_correlativo_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, opcion.getId());
                ps.executeQuery();
            } catch (SQLException ex) {
                ex.getMessage();
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<DetalleOpcion> listar(DetalleOpcion opcion) {
        Connection c = ConnectionDatabase.getConnection();
        DetalleOpcion oPerfil = null;
        ArrayList<DetalleOpcion> DetalleOpcion = null;
        if (c != null) {
            try {
                String sql = "SELECT n_correlativo, "
                        + "n_perfil, "
                        + "n_opcion, "
                        + "f_acceso, "
                        + "f_escritura, "
                        + "f_lectura, "
                        + "f_eliminar, "
                        + "f_ejecucion, "
                        + "aud_usuario_creacion, "
                        + "aud_usuario_modificacion, "
                        + "aud_fecha_creacion, "
                        + "aud_fecha_modificacion"
                        + " FROM det_perfil_permiso ";
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                DetalleOpcion = new ArrayList<DetalleOpcion>();
                if (rs.next()) {
                    oPerfil = new DetalleOpcion();
                    oPerfil.setIdPerfil(new Perfil(rs.getInt("n_perfil"),rs.getString("c_nombre")));
                    oPerfil.setIdopcion(new Opcion(rs.getInt("n_opcion")));
                    oPerfil.setAcceso(rs.getString("f_acceso"));
                    oPerfil.setEscritura(rs.getString("f_escritura"));
                    oPerfil.setLectura(rs.getString("f_lectura"));
                    oPerfil.setEliminar(rs.getString("f_eliminar"));
                    oPerfil.setEjecucion(rs.getString("f_ejecucion"));
                    DetalleOpcion.add(oPerfil);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
            }
        }
        return DetalleOpcion;
    }


    @Override
    public DetalleOpcion get(DetalleOpcion opcion) {
        Connection c = ConnectionDatabase.getConnection();
        DetalleOpcion oPerfil = null;
        if (c != null) {
            try {
                String sql = "SELECT n_correlativo, "
                        + "n_perfil, "
                        + "n_opcion, "
                        + "f_acceso, "
                        + "f_escritura, "
                        + "f_lectura, "
                        + "f_eliminar, "
                        + "f_ejecucion, "
                        + "aud_usuario_creacion, "
                        + "aud_usuario_modificacion, "
                        + "aud_fecha_creacion, "
                        + "aud_fecha_modificacion"
                        + " FROM det_perfil_permiso where n_correlativo_pk=? ";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, opcion.getId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    oPerfil = new DetalleOpcion();
                    oPerfil.setIdPerfil(new Perfil(rs.getInt("n_perfil"),rs.getString("c_nombre")));
                    oPerfil.setIdopcion(new Opcion(rs.getInt("n_opcion")));
                    oPerfil.setAcceso(rs.getString("f_acceso"));
                    oPerfil.setEscritura(rs.getString("f_escritura"));
                    oPerfil.setLectura(rs.getString("f_lectura"));
                    oPerfil.setEliminar(rs.getString("f_eliminar"));
                    oPerfil.setEjecucion(rs.getString("f_ejecucion"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
            }
        }
        return oPerfil;
    }
}
