/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Ctrl;
import com.sv.udb.Modelos.Equi_comp;
import com.sv.udb.Modelos.Luga_acce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sv.udb.recursos.Conexion;
/**
 *
 * @author aerc
 */
public class CtrlEqui_comp {
    public boolean guar(Equi_comp obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "INSERT INTO equi_comp VALUES(NULL, ?, ?, ?, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setString(1, obje.getNomb_equi_comb());
            cmd.setString(2, obje.getCodi_luga_acce().getNomb_luga_acce());
            cmd.setString(3, obje.getMac_addr_equi_comp());
            cmd.setString(4, obje.getIp_addr_equi_comp());
            cmd.setString(5, obje.getFech_alta());
            cmd.setString(6, obje.getFech_baja());
            cmd.executeUpdate();
            resp = true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    
    public boolean elim(Equi_comp obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "DELETE FROM equi_comp WHERE CODI_EQUI_COMP = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, obje.getCodi_equi_comp());
            cmd.executeUpdate();
            resp = true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    
    public boolean modi(Equi_comp obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "UPDATE EQUIPOS SET NOMB_EQUI_COM = ?, CODI_LUGA_ACCE = ?, MAC_ADDR_EQUI_COMP = ?, IP_ADDR_EQUI_COMP = ?, FECH_ALTA = ?, FECH_BAJA = ? WHERE CODI_EQUI_COMP = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setString(1, obje.getNomb_equi_comb());
            cmd.setInt(2, obje.getCodi_luga_acce().getCodi_luga_acce());
            cmd.setString(3, obje.getMac_addr_equi_comp());
            cmd.setString(4, obje.getIp_addr_equi_comp());
            cmd.setString(5, obje.getFech_alta());
            cmd.setString(6, obje.getFech_baja());
            cmd.setInt(7, obje.getCodi_equi_comp());
            cmd.executeUpdate();
            resp = true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    
    public List<Equi_comp> consTodoxd(int cod)
    {
        List<Equi_comp> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT * FROM equi_comp WHERE CODI_EQUI_COMP = "+ cod;
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                    resp.add(new Equi_comp(rs.getInt(1), rs.getString(2), new Luga_acce(rs.getInt(3), null, null, null), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    
    public List<Equi_comp> consTodo()
    {
        List<Equi_comp> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT * FROM EQUIPOS";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                    resp.add(new Equi_comp(rs.getInt(1), rs.getString(2), new Luga_acce(rs.getInt(3), null, null, null), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
}
