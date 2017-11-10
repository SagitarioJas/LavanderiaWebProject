package pe.com.overux.model.impl;

import pe.com.overux.domain.Cliente;
import pe.com.overux.domain.Parametro;
import pe.com.overux.domain.Ubigeo;
import pe.com.overux.model.iface.ICliente;
import pe.com.overux.connection.ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class ClienteDao implements ICliente {

    @Override
    public String insert(Cliente cliente) {
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
                ps.setInt(i++, cliente.getId());
                if (cliente.getTipoCliente().getId() != 0) {
                    ps.setInt(i++, cliente.getTipoCliente().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, cliente.getNombre());
                ps.setString(i++, cliente.getApellidoPat());
                ps.setString(i++, cliente.getApellidoMat());
                ps.setString(i++, cliente.getRazonSocial());
                if (cliente.getTipoDocumento().getId() != 0) {
                    ps.setInt(i++, cliente.getTipoDocumento().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, cliente.getNumeroDoc());

                if (cliente.getEstadoCivil().getId() != 0) {
                    ps.setInt(i++, cliente.getEstadoCivil().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setDate(i++, (cliente.getFechaRegistro() != null ? new Date(cliente.getFechaRegistro().getTime()) : null));
                ps.setDate(i++, (cliente.getFechaCese() != null ? new Date(cliente.getFechaCese().getTime()) : null));
                ps.setString(i++, cliente.getUbigeo().getCodigo());
                if (cliente.getEstado().getId() != 0) {
                    ps.setInt(i++, cliente.getEstado().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, cliente.getTelefono());
                ps.setString(i++, cliente.getDireccion());
                ps.setString(i++, cliente.getCorreo());
                ps.setString(i++, cliente.getCelular());
                ps.setString(i++, cliente.getTelefonoRef());
                ps.setInt(i++, cliente.getUsuarioCreacion());
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
    public String update(Cliente cliente) {
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
                if (cliente.getTipoCliente().getId() != 0) {
                    ps.setInt(i++, cliente.getTipoCliente().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, cliente.getNombre());
                ps.setString(i++, cliente.getApellidoPat());
                ps.setString(i++, cliente.getApellidoMat());
                ps.setString(i++, cliente.getRazonSocial());
                if (cliente.getTipoDocumento().getId() != 0) {
                    ps.setInt(i++, cliente.getTipoDocumento().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, cliente.getNumeroDoc());

                if (cliente.getEstadoCivil().getId() != 0) {
                    ps.setInt(i++, cliente.getEstadoCivil().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setDate(i++, (cliente.getFechaRegistro() != null ? new Date(cliente.getFechaRegistro().getTime()) : null));
                ps.setDate(i++, (cliente.getFechaCese() != null ? new Date(cliente.getFechaCese().getTime()) : null));
                ps.setString(i++, cliente.getUbigeo().getCodigo());
                if (cliente.getEstado().getId() != 0) {
                    ps.setInt(i++, cliente.getEstado().getId());
                } else {
                    ps.setNull(i++, java.sql.Types.INTEGER);
                }
                ps.setString(i++, cliente.getTelefono());
                ps.setString(i++, cliente.getDireccion());
                ps.setString(i++, cliente.getCorreo());
                ps.setString(i++, cliente.getCelular());
                ps.setString(i++, cliente.getTelefonoRef());
                ps.setInt(i++, cliente.getUsuarioModificacion());
                ps.setInt(i++, cliente.getId());
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
    public String delete(Cliente cliente) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                String sql = "delete from  tab_cliente "
                        + "where n_cliente_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, cliente.getId());
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
    public ArrayList<Cliente> listar(Cliente cliente) {
        Connection c = ConnectionDatabase.getConnection();
        Cliente e = null;
        ArrayList<Cliente> Empleado = new ArrayList<>();
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
                    e = new Cliente();
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
    public Cliente get(Cliente cliente) {
        Connection c = ConnectionDatabase.getConnection();
        Cliente e = null;
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
                ps.setInt(1, cliente.getId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    e = new Cliente();
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
