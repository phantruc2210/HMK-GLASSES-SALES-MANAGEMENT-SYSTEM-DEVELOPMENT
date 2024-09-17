/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.PXuat;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class PXuatDao {
    public boolean insert(PXuat px) throws Exception
    {
        String sql = "insert into PhieuXuat(SoPX, NgayXuat, GhiChu, MaNV) values (?,?,?,?)";
        Connection conn = DatabaseConnection.openConnect();

        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, px.getSoPX());
        pm.setString(2, px.getNgayXuat());
        pm.setString(3, px.getGhiChu());
        pm.setString(4, px.getMaNV());
        
        
        return pm.executeUpdate() > 0;
    }

     public boolean Delete(String px1) throws Exception
    {
        String sql = "Delete from PhieuXuat where BINARY_CHECKSUM (SoPX)= BINARY_CHECKSUM(?) ";
        
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, px1);
        
        
        
        return pm.executeUpdate() > 0;
    }
     
    public boolean Update(PXuat px) throws Exception
    {
        String Sql ="Update PhieuXuat SET SoPX=?, NgayXuat=?, GhiChu=?, MaNV=? WHERE SoPX=?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, px.getSoPX());
        pm.setString(2, px.getNgayXuat());
        pm.setString(3, px.getGhiChu());
        pm.setString(4, px.getMaNV());
        pm.setString(5, px.getSoPX());
       
        return pm.executeUpdate() > 0;
    }
}
