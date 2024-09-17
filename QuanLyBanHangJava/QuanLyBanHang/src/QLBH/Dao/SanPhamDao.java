/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author THUY TRUC
 */
public class SanPhamDao {
    
    public boolean insert(SanPham sp) throws Exception
    {
        String Sql ="insert into SanPham(MaSP, TenSP, SLTon, DonViTinh, MaloaiSP) values (?,?,?,?,?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, sp.getMaSP());
        pm.setString(2, sp.getTenSP());
        pm.setInt(3, sp.getSLTon());
        pm.setString(4, sp.getDonViTinh());
        pm.setString(5, sp.getMaloaiSP());
        
        return pm.executeUpdate() > 0;
    }
    
    public boolean Update(SanPham sp) throws Exception
    {
        String Sql ="Update SanPham SET MaSP=?, TenSP=?, SLTon=?, DonViTinh=?, MaloaiSP=? WHERE MaSP=?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, sp.getMaSP());
        pm.setString(2, sp.getTenSP());
        pm.setInt(3, sp.getSLTon());
        pm.setString(4, sp.getDonViTinh());
        pm.setString(5, sp.getMaloaiSP());
        pm.setString(6, sp.getMaSP());
        return pm.executeUpdate() > 0;
    }
    
    public boolean Delete(String sp) throws Exception
    {
        String sql = "Delete from SanPham where BINARY_CHECKSUM(MaSP) = BINARY_CHECKSUM (?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, sp);
        
        return pm.executeUpdate() > 0;
    }
}
