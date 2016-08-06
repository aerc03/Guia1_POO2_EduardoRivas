/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Ctrl;

import com.sv.udb.Modelos.Pers;
import com.sv.udb.Modelos.Tipo_gafe;
import com.sv.udb.Modelos.Tipo_pers;
import com.sv.udb.Modelos.UbicGeog;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerc
 */
public class Tipo_gafeCtrl {
    public List<Tipo_gafe> consTodo()
    {
        List<Tipo_gafe> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT * FROM tipo_gafe";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Tipo_gafe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBlob(5)));
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
