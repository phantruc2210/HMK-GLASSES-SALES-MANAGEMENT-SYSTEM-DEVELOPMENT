/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.PNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class PNhapDao {
   public boolean insert(PNhap pn) throws Exception
    {
        String sql = "insert into PhieuNhap(SoPN, NgayNhap, GhiChu, MaNCC) values (?,?,?,?)";
        Connection conn = DatabaseConnection.openConnect();

        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, pn.getSoPN());
        pm.setString(2, pn.getNgayNhap());
        pm.setString(3, pn.getGhiChu());
        pm.setString(4, pn.getMaNCC());
        
        
        return pm.executeUpdate() > 0;
    }

     public boolean Delete(String pn) throws Exception
    {
        String sql = "Delete from PhieuNhap where SoPN = ? ";
        
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, pn);
        
        
        
        return pm.executeUpdate() > 0;
    }
     
    public boolean Update(PNhap pn) throws Exception
    {
        String Sql ="Update PhieuNhap SET SoPN=?, NgayNhap=?, GhiChu=?, MaNCC=? WHERE SoPN=?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, pn.getSoPN());
        pm.setString(2, pn.getNgayNhap());
        pm.setString(3, pn.getGhiChu());
        pm.setString(4, pn.getMaNCC());
        pm.setString(5, pn.getSoPN());
       
        return pm.executeUpdate() > 0;
    }
}
