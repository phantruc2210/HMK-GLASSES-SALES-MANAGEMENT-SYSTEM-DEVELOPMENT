/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.CTPXuat;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class CTPXuatDao {
    public boolean insert(CTPXuat ctpx) throws Exception
    {
        String sql = "insert into CTPhieuXuat(SoPX, MaSP, SoLuong, DGBan) values (?,?,?,?)";
        Connection conn = DatabaseConnection.openConnect();

        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, ctpx.getSoPX());
        pm.setString(2, ctpx.getMaSP());
        pm.setInt(3, ctpx.getSoLuong());
        pm.setDouble(4, ctpx.getDGBan());
        
        
        return pm.executeUpdate() > 0;
    }

     public boolean Delete(String ctpx1) throws Exception
    {
        String sql = "Delete from CTPhieuXuat where BINARY_CHECKSUM (SoPX)= BINARY_CHECKSUM(?)";
        
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, ctpx1);
       
        
        
        return pm.executeUpdate() > 0;
    }
     
    public boolean Update(CTPXuat ctpx) throws Exception
    {
        String Sql ="Update CTPhieuXuat SET SoPX=?, MaSP=?, SoLuong=?, DGBan=? WHERE SoPX = ?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, ctpx.getSoPX());
        pm.setString(2, ctpx.getMaSP());
        pm.setInt(3, ctpx.getSoLuong());
        pm.setDouble(4, ctpx.getDGBan());
        pm.setString(5, ctpx.getSoPX());
        
        return pm.executeUpdate() > 0;
    }
}
