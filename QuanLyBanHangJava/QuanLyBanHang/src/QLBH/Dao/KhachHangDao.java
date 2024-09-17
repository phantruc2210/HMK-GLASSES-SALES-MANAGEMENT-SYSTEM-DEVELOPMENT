/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class KhachHangDao {
    
    public boolean insert(KhachHang kh) throws Exception 
    {
        String Sql = "insert into KhachHang(MaKH, TenKH, DiaChi, NgaySinh, DienThoai) values(?,?,?,?,?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, kh.getMaKH());
        pm.setString(2, kh.getTenKH());
        pm.setString(3, kh.getDiaChi());
        pm.setString(4, kh.getNgaySinh());
        pm.setString(5, kh.getDienThoai());
        return pm.executeUpdate() > 0;
    }
    
    public boolean Update(KhachHang kh) throws Exception
    {
        String Sql ="update KhachHang SET MaKH=?,TenKH=?,DiaChi=?,NgaySinh=?,DienThoai=? WHERE MaKH=?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, kh.getMaKH());
        pm.setString(2, kh.getTenKH());
        pm.setString(3, kh.getDiaChi());
        pm.setString(4, kh.getNgaySinh());
        pm.setString(5, kh.getDienThoai());
        pm.setString(6, kh.getMaKH());
         return pm.executeUpdate() > 0;
    }
    
    public boolean Delete(String kh) throws Exception 
    {
        String sql = "Delete from KhachHang where BINARY_CHECKSUM(MaKH) = BINARY_CHECKSUM (?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, kh);
        return pm.executeUpdate() > 0;
    }
}
