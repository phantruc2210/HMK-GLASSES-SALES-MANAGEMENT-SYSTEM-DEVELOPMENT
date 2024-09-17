/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.HDon;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class HDonDao {
    public boolean insert(HDon hd) throws Exception
    {
        String sql = "insert into HoaDon(MaHD, MaKH, MaNV, NgayDH, NgayNH, PTTT) values (?,?,?,?,?,?)";
        Connection conn = DatabaseConnection.openConnect();

        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, hd.getMaHD());
        pm.setString(2, hd.getMaKH());
        pm.setString(3, hd.getMaNV());
        pm.setString(4, hd.getNgayDH());
        pm.setString(5, hd.getNgayNH());
        pm.setString(6, hd.getPTTT());
        
        return pm.executeUpdate() > 0;
    }

     public boolean Delete(String hd) throws Exception
    {
        String sql = "Delete from HoaDon where BINARY_CHECKSUM (MaHD)= BINARY_CHECKSUM(?) ";
        
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, hd);
        
        
        
        return pm.executeUpdate() > 0;
    }
     
    public boolean Update(HDon hd) throws Exception
    {
        String Sql ="Update HoaDon SET MaHD=?, MaKH=?, MaNV=?, NgayDH=?, NgayNH=?, PTTT=? WHERE MaHD=?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, hd.getMaHD());
        pm.setString(2, hd.getMaKH());
        pm.setString(3, hd.getMaNV());
        pm.setString(4, hd.getNgayDH());
        pm.setString(5, hd.getNgayNH());
        pm.setString(6, hd.getPTTT());
        pm.setString(7, hd.getMaHD());
       
        return pm.executeUpdate() > 0;
    }
}
