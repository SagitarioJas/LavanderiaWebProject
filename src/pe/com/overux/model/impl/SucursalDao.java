package pe.com.overux.model.impl;

import pe.com.overux.connection.ConnectionDatabase;
import pe.com.overux.domain.Clientes;
import pe.com.overux.domain.Sucursal;
import pe.com.overux.domain.Ubigeo;
import pe.com.overux.model.iface.ISucursales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SucursalDao implements ISucursales {
    @Override
    public String insert(Sucursal clientes) {
        return null;
    }

    @Override
    public String update(Sucursal clientes) {
        return null;
    }

    @Override
    public String delete(Sucursal clientes) {
        Connection c = ConnectionDatabase.getConnection();
        if (c != null) {
            try {
                String sql = "delete from  tab_sucursal "
                        + "where n_sucursal_pk=?";
                PreparedStatement ps = c.prepareStatement(sql);
                //ps.setInt(1, sucursal.getIdSucursal());
                ps.executeQuery();
            } catch (SQLException ex) {
                ex.getMessage();
            } finally {
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
    public ArrayList<Sucursal> listar(Sucursal clientes) {
        Connection c = ConnectionDatabase.getConnection();
        Sucursal oSucursal = null;
        ArrayList<Sucursal> Sucursal = null;
        if (c != null) {
            try {
                String sql = "select "
                        + "a.n_sucursal_pk,"
                        + "a.n_cliente,"
                        + "a.c_nombre, "
                        + "a.c_direccion, "
                        + "a.c_ubigeo,"
                        + "b.c_departamento,"
                        + "b.c_provincia,"
                        + "b.c_distrito, "
                        + "a.c_telefono, "
                        + "a.c_celular, "
                        + "a.c_hora_inicial, "
                        + "a.c_hora_final "
                        + "from tab_sucursal a "
                        + "left join mae_ubigeo b on a.c_ubigeo = b.c_ubigeo_pk ";
                if (clientes.getClientes().getId() != 0) {
                    sql += "where n_cliente = " + clientes.getClientes().getId();
                }
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                Sucursal = new ArrayList<>();
                while (rs.next()) {
                    oSucursal = new Sucursal();
                    oSucursal.setId(rs.getInt("n_sucursal_pk"));
                    oSucursal.setClientes(new Clientes(rs.getInt("n_cliente")));
                    oSucursal.setNombre(rs.getString("c_nombre"));
                    oSucursal.setDireccion(rs.getString("c_direccion"));
                    if (rs.getString("c_ubigeo") != null) {
                        oSucursal.setDepartamento(new Ubigeo(rs.getString("c_ubigeo").substring(0, 2), rs.getString("c_departamento"), null, null));
                        oSucursal.setProvincia(new Ubigeo(rs.getString("c_ubigeo").substring(0, 4), null, rs.getString("c_provincia"), null));
                        oSucursal.setUbigeo(new Ubigeo(rs.getString("c_ubigeo"), null, null, rs.getString("c_distrito")));
                    }
                    oSucursal.setTelefono(rs.getString("c_telefono"));
                    oSucursal.setCelular(rs.getString("c_celular"));
                    oSucursal.setHoraini(rs.getString("c_hora_inicial"));
                    oSucursal.setHorafin(rs.getString("c_hora_final"));
                    Sucursal.add(oSucursal);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
            }
        }
        return Sucursal;
    }

    @Override
    public Sucursal get(Sucursal clientes) {
        Connection c = ConnectionDatabase.getConnection();
        Sucursal oSucursal = null;
        if (c != null) {
            try {
                String sql = "select "
                        + "a.n_sucursal_pk,"
                        + "a.c_nombre, "
                        + "a.c_direccion, "
                        + "a.c_codigo_destinatario, "
                        + "a.n_socio_negocio, "
                        + "a.c_ubigeo,"
                        + "b.c_departamento,"
                        + "b.c_provincia,"
                        + "b.c_distrito, "
                        + "a.n_zona_transporte, "
                        + "c.c_nombre as nombre_zona, "
                        + "a.f_principal "
                        + "from tab_sucursal a "
                        + "left join mae_ubigeo b on a.c_ubigeo = b.c_ubigeo_pk "
                        + "where ";
                if (clientes.getId() != 0) {
                    sql = sql + " a.n_sucursal_pk=? ";
                }  else if (clientes.getClientes().getId() != 0) {
                    sql = sql + " a.n_socio_negocio=? ";
                }
                PreparedStatement ps = c.prepareStatement(sql);
                if (clientes.getId() != 0) {
                    ps.setInt(1, clientes.getId());
                } else if (clientes.getClientes().getId() != 0) {
                    ps.setInt(1, clientes.getClientes().getId());
                }
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    oSucursal = new Sucursal();
                    oSucursal.setId(rs.getInt("n_sucursal_pk"));
                    oSucursal.setClientes(new Clientes(rs.getInt("n_cliente")));
                    oSucursal.setNombre(rs.getString("c_nombre"));
                    oSucursal.setDireccion(rs.getString("c_direccion"));
                    if (rs.getString("c_ubigeo") != null) {
                        oSucursal.setDepartamento(new Ubigeo(rs.getString("c_ubigeo").substring(0, 2), rs.getString("c_departamento"), null, null));
                        oSucursal.setProvincia(new Ubigeo(rs.getString("c_ubigeo").substring(0, 4), null, rs.getString("c_provincia"), null));
                        oSucursal.setUbigeo(new Ubigeo(rs.getString("c_ubigeo"), null, null, rs.getString("c_distrito")));
                    }
                    oSucursal.setTelefono(rs.getString("c_telefono"));
                    oSucursal.setCelular(rs.getString("c_celular"));
                    oSucursal.setHoraini(rs.getString("c_hora_inicial"));
                    oSucursal.setHorafin(rs.getString("c_hora_final"));
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
            }
        }
        return oSucursal;
    }
}
