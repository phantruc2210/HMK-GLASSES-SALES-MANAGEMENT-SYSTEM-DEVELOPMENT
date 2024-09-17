/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.LoaiSP;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class LoaiSPDao {
    public boolean insert(LoaiSP lsp) throws Exception 
    {
        String Sql = "insert into LoaiSanPham(MaloaiSP, TenloaiSP, GhiChu) values(?,?,?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, lsp.getMaloaiSP());
        pm.setString(2, lsp.getTenloaiSP());
        pm.setString(3, lsp.getGhiChu());
        return pm.executeUpdate() > 0;
    }
    
    public boolean Update(LoaiSP lsp) throws Exception 
    {
        String Sql = "Update LoaiSanPham SET MaloaiSP=?,TenloaiSP=?,GhiChu=? where MaloaiSP=?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, lsp.getMaloaiSP());
        pm.setString(2, lsp.getTenloaiSP());
        pm.setString(3, lsp.getGhiChu());
        pm.setString(4, lsp.getMaloaiSP());
        return pm.executeUpdate() > 0;
    }
    
    public boolean Delete(String lsp) throws Exception 
    {
        String sql = "Delete from LoaiSanPham where BINARY_CHECKSUM(MaloaiSP) = BINARY_CHECKSUM (?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, lsp);
        return pm.executeUpdate() > 0;
    }
}
