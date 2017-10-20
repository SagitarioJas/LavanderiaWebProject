package pe.com.overux.model.impl;

import pe.com.overux.domain.Clientes;
import pe.com.overux.domain.Parametro;
import pe.com.overux.domain.Ubigeo;
import pe.com.overux.model.iface.IClientes;
import pe.com.overux.connection.ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ClienteDao implements IClientes {

    @Override
    public String insert(Clientes clientes) {
        Connection c = null;
        c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                String sql = "Insert into  tab_cliente "
                        + "(n_cliente_pk,"
                        + "n_tipo_cliente, "
                        + "c_nombre,"
                        + "c_apellido_paterno,"
                        + "c_apellido_materno,"
                        + "c_razon_social,"
                        + "n_tipo_documento,"
                        + "c_numero_documento,"
                        + "n_estado_civil,"
                        + "d_fecha_registro,"
                        + "d_fecha_cese,"
                        + "c_ubigeo,"
                        + "n_estado,"
                        + "c_telefono,"
                        + "c_direccion,"
                        + "c_correo,"
                        + "c_celular,"
                        + "c_telefono_referencia,"
                        + "aud_usuario_creacion, "
                        + "aud_fecha_creacion) "
                        + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp)";
                int i = 1;
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(i++, clientes.getId());
                if (clientes.getTipoCliente().getId() != 0) {
                    ps.setInt(i++, clientes.getTipoCliente().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, clientes.getNombre());
                ps.setString(i++, clientes.getApellidoPat());
                ps.setString(i++, clientes.getApellidoMat());
                ps.setString(i++, clientes.getRazonSocial());
                if (clientes.getTipoDocumento().getId() != 0) {
                    ps.setInt(i++, clientes.getTipoDocumento().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, clientes.getNumeroDoc());

                if (clientes.getEstadoCivil().getId() != 0) {
                    ps.setInt(i++, clientes.getEstadoCivil().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setDate(i++, (clientes.getFechaRegistro() != null ? new Date(clientes.getFechaRegistro().getTime()) : null));
                ps.setDate(i++, (clientes.getFechaCese() != null ? new Date(clientes.getFechaCese().getTime()) : null));
                ps.setString(i++, clientes.getUbigeo().getCodigo());
                if (clientes.getEstado().getId() != 0) {
                    ps.setInt(i++, clientes.getEstado().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, clientes.getTelefono());
                ps.setString(i++, clientes.getDireccion());
                ps.setString(i++, clientes.getCorreo());
                ps.setString(i++, clientes.getCelular());
                ps.setString(i++, clientes.getTelefonoRef());
                ps.setInt(i++, clientes.getUsuarioCreacion());
                ps.executeUpdate();
                c.commit();
            } catch (SQLException ex) {
                try {
                    c.rollback();
                } catch (SQLException ex1) {
                    return ex1.getMessage();
                }
                return ex.getMessage();
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String update(Clientes clientes) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                String sql = "update tab_cliente set "
                        + "n_tipo_cliente=?, "
                        + "c_nombre=?,"
                        + "c_apellido_paterno=?,"
                        + "c_apellido_materno=?,"
                        + "c_razon_social=?,"
                        + "n_tipo_documento=?,"
                        + "c_numero_documento=?,"
                        + "n_estado_civil=?,"
                        + "d_fecha_registro=?,"
                        + "d_fecha_cese=?,"
                        + "c_ubigeo=?,"
                        + "n_estado=?,"
                        + "c_telefono=?,"
                        + "c_direccion=?,"
                        + "c_correo=?,"
                        + "c_celular=?,"
                        + "c_telefono_referencia=?,"
                        + "aud_usuario_modificacion=?, "
                        + "aud_fecha_modificacion =current_timestamp "
                        + " where n_cliente_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                int i = 1;
                if (clientes.getTipoCliente().getId() != 0) {
                    ps.setInt(i++, clientes.getTipoCliente().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, clientes.getNombre());
                ps.setString(i++, clientes.getApellidoPat());
                ps.setString(i++, clientes.getApellidoMat());
                ps.setString(i++, clientes.getRazonSocial());
                if (clientes.getTipoDocumento().getId() != 0) {
                    ps.setInt(i++, clientes.getTipoDocumento().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, clientes.getNumeroDoc());

                if (clientes.getEstadoCivil().getId() != 0) {
                    ps.setInt(i++, clientes.getEstadoCivil().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setDate(i++, (clientes.getFechaRegistro() != null ? new Date(clientes.getFechaRegistro().getTime()) : null));
                ps.setDate(i++, (clientes.getFechaCese() != null ? new Date(clientes.getFechaCese().getTime()) : null));
                ps.setString(i++, clientes.getUbigeo().getCodigo());
                if (clientes.getEstado().getId() != 0) {
                    ps.setInt(i++, clientes.getEstado().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, clientes.getTelefono());
                ps.setString(i++, clientes.getDireccion());
                ps.setString(i++, clientes.getCorreo());
                ps.setString(i++, clientes.getCelular());
                ps.setString(i++, clientes.getTelefonoRef());
                ps.setInt(i++, clientes.getUsuarioModificacion());
                ps.setInt(i++, clientes.getId());
                ps.executeUpdate();
                c.commit();
            } catch (SQLException ex) {
                try {
                    c.rollback();
                    return ex.getMessage();
                } catch (SQLException ex1) {
                    return ex1.getMessage();
                }
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String delete(Clientes clientes) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                String sql = "delete from  tab_cliente "
                        + "where n_cliente_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, clientes.getId());
                ps.executeUpdate();
                c.commit();
            } catch (SQLException ex) {
                try {
                    c.rollback();
                    return ex.getMessage();
                } catch (SQLException ex1) {
                    return ex1.getMessage();
                }
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
    public ArrayList<Clientes> listar(Clientes clientes) {
        Connection c = ConnectionDatabase.getConnection();
        Clientes e = null;
        ArrayList<Clientes> Empleado = new ArrayList<>();
        if (c != null) {
            try {
                String sql = "Select "
                        + "n_cliente_pk,"
                        + "n_tipo_cliente, "
                        + "c_nombre,"
                        + "c_apellido_paterno,"
                        + "c_apellido_materno,"
                        + "c_razon_social,"
                        + "n_tipo_documento,"
                        + "c_numero_documento,"
                        + "n_estado_civil,"
                        + "d_fecha_registro,"
                        + "d_fecha_cese,"
                        + "c_ubigeo,"
                        + "n_estado,"
                        + "c_telefono,"
                        + "c_direccion,"
                        + "c_correo,"
                        + "c_celular,"
                        + "c_telefono_referencia,"
                        + "from tab_cliente "
                        + " order by n_cliente_pk desc ";
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    e = new Clientes();
                    e.setId(rs.getInt("n_cliente_pk"));
                    e.setTipoCliente(new Parametro(rs.getInt("n_tipo_cliente")));
                    e.setNombre(rs.getString("c_nombres"));
                    e.setApellidoPat(rs.getString("c_apellido_paterno"));
                    e.setApellidoMat(rs.getString("c_apellido_materno"));
                    e.setRazonSocial(rs.getString("c_razon_social"));
                    e.setNumeroDoc(rs.getString("c_numero_documento"));
                    e.setEstadoCivil(new Parametro(rs.getInt("n_estado_civil")));
                    if (rs.getDate("d_fecha_registro") != null) {
                        e.setFechaRegistro(new java.util.Date(rs.getDate("d_fecha_registro").getTime()));
                    }
                    if (rs.getDate("d_fecha_cese") != null) {
                        e.setFechaCese(new java.util.Date(rs.getDate("d_fecha_cese").getTime()));
                    }
                    e.setUbigeo(new Ubigeo(rs.getString("c_ubigeo")));
                    e.setEstado(new Parametro(rs.getInt("n_estado")));
                    e.setDireccion(rs.getString("c_direccion"));
                    e.setCorreo(rs.getString("c_correo"));
                    e.setCelular(rs.getString("c_celular"));
                    e.setTelefonoRef(rs.getString("c_telefono_referencia"));
                    Empleado.add(e);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException esql) {
                    }
                }
            }

        }
        return Empleado;
    }

    @Override
    public Clientes get(Clientes clientes) {
        Connection c = ConnectionDatabase.getConnection();
        Clientes e = null;
        if (c != null) {
            try {
                String sql = "Select "
                        + "n_cliente_pk,"
                        + "n_tipo_cliente, "
                        + "c_nombre,"
                        + "c_apellido_paterno,"
                        + "c_apellido_materno,"
                        + "c_razon_social,"
                        + "n_tipo_documento,"
                        + "c_numero_documento,"
                        + "n_estado_civil,"
                        + "d_fecha_registro,"
                        + "d_fecha_cese,"
                        + "c_ubigeo,"
                        + "n_estado,"
                        + "c_telefono,"
                        + "c_direccion,"
                        + "c_correo,"
                        + "c_celular,"
                        + "c_telefono_referencia,"
                        + " From tab_cliente where n_cliente_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, clientes.getId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    e = new Clientes();
                    e.setId(rs.getInt("n_cliente_pk"));
                    e.setTipoCliente(new Parametro(rs.getInt("n_tipo_cliente")));
                    e.setNombre(rs.getString("c_nombres"));
                    e.setApellidoPat(rs.getString("c_apellido_paterno"));
                    e.setApellidoMat(rs.getString("c_apellido_materno"));
                    e.setRazonSocial(rs.getString("c_razon_social"));
                    e.setNumeroDoc(rs.getString("c_numero_documento"));
                    e.setEstadoCivil(new Parametro(rs.getInt("n_estado_civil")));
                    if (rs.getDate("d_fecha_registro") != null) {
                        e.setFechaRegistro(new java.util.Date(rs.getDate("d_fecha_registro").getTime()));
                    }
                    if (rs.getDate("d_fecha_cese") != null) {
                        e.setFechaCese(new java.util.Date(rs.getDate("d_fecha_cese").getTime()));
                    }
                    e.setUbigeo(new Ubigeo(rs.getString("c_ubigeo")));
                    e.setEstado(new Parametro(rs.getInt("n_estado")));
                    e.setDireccion(rs.getString("c_direccion"));
                    e.setCorreo(rs.getString("c_correo"));
                    e.setCelular(rs.getString("c_celular"));
                    e.setTelefonoRef(rs.getString("c_telefono_referencia"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException esql) {
                        /* ignored */
                    }
                }
            }
        }
        return e;
    }
}
