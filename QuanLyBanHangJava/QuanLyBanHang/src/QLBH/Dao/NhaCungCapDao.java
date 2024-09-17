/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class NhaCungCapDao {
    public boolean insert(NhaCungCap ncc) throws Exception
    {
        String Sql = "insert into NhaCungCap( MaNCC, TenNCC, DiaChi, DienThoai, Email) values (?,?,?,?,?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, ncc.getMaNCC());
        pm.setString(2, ncc.getTenNCC());
        pm.setString(3, ncc.getDiaChi());
        pm.setString(4, ncc.getDienThoai());
        pm.setString(5, ncc.getEmail());
        return pm.executeUpdate() > 0;
    }
    
    public boolean Update(NhaCungCap ncc) throws Exception
    {
        String Sql = "update NhaCungCap SET MaNCC=?, TenNCC=?, DiaChi=?, DienThoai=?, Email=? WHERE MaNCC=?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, ncc.getMaNCC());
        pm.setString(2, ncc.getTenNCC());
        pm.setString(3, ncc.getDiaChi());
        pm.setString(4, ncc.getDienThoai());
        pm.setString(5, ncc.getEmail());
        pm.setString(6, ncc.getMaNCC());
        return pm.executeUpdate() > 0;
    }
    
    public boolean Delete(String ncc) throws Exception
    {
        String sql = "Delete from NhaCungCap where BINARY_CHECKSUM(MaNCC) = BINARY_CHECKSUM (?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, ncc);
        return pm.executeUpdate() > 0;
    }
}
