 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Ctrl;

import com.sv.udb.Modelos.TipoDocu;
import com.sv.udb.Modelos.UbicGeog;
import com.sv.udb.Modelos.UnidOrga;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vaness
 */
 
public class UnidOrgaCtrl {
    
     /*public boolean guar(TipoDocu obje){
          boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO procesador VALUES(NULL, ?,?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombre());
            cmd.setString(2, obje.getDescripcion());
            
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }

         public boolean modi(TipoDocu obje){
          boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE procesador SET nombreProcesador=?, descripcion=? WHERE idProcesador=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombre());
            cmd.setString(2, obje.getDescripcion());
            cmd.setInt(3, obje.getId());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
     
         
            public boolean elim(TipoDocu obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM procesador WHERE idProcesador=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getId());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    
    public TipoDocu cons(int id)
    {
        TipoDocu resp = null;
        Connection cn = new Conexion().getConn();
        try
        {
          //  String consulta = "select i.idInstitucion, i.nombreInstitucion, i.direccion, d.idDepartamento, d.nombreDepartamento FROM institucion i inner join departamento d on i.idDepartamentoI=d.idDepartamento where idInstitucion=?";
            String consulta = "select idProcesador, nombreProcesador, descripcion from procesador where idProcesador=?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = (new TipoDocu(rs.getInt(1),rs.getString(2),rs.getString(3)));
                //resp = (new Institucion(rs.getInt(1),rs.getString(2),rs.getString(3),new Departamento(rs.getInt(5),rs.getString(6))));
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
*/
     
    public List<UnidOrga> consTodo()
    {
       List<UnidOrga> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("Select * from unid_orga, ubic_geog where unid_orga.codi_ubic_geog = ubic_geog.codi_ubic_geog");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {   
                resp.add(new UnidOrga(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),new UbicGeog(rs.getInt(14),rs.getString(15),rs.getInt(16),rs.getString(17),rs.getString(18), rs.getBlob(19)),rs.getString(11),rs.getString(12),rs.getBlob(13)));
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
            System.out.print(err);
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    
}
