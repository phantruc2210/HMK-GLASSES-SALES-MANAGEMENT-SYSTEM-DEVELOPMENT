/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.CTPNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class CTPNhapDao {
    public boolean insert(CTPNhap ctpn) throws Exception
    {
        String sql = "insert into CTPhieuNhap(SoPN, MaSP, SoLuong, DGNhap) values (?,?,?,?)";
        Connection conn = DatabaseConnection.openConnect();

        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, ctpn.getSoPN());
        pm.setString(2, ctpn.getMaSP());
        pm.setInt(3, ctpn.getSoLuong());
        pm.setDouble(4, ctpn.getDGNhap());
        
        
        return pm.executeUpdate() > 0;
    }

     public boolean Delete(String ctpn) throws Exception
    {
        String sql = "Delete from CTPhieuNhap where SoPN = ?";
        
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, ctpn);
       
        
        
        return pm.executeUpdate() > 0;
    }
     
    public boolean Update(CTPNhap ctpn) throws Exception
    {
        String Sql ="Update CTPhieuNhap SET SoPN=?, MaSP=?, SoLuong=?, DGNhap=? WHERE SoPN = ?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, ctpn.getSoPN());
        pm.setString(2, ctpn.getMaSP());
        pm.setInt(3, ctpn.getSoLuong());
        pm.setDouble(4, ctpn.getDGNhap());
        pm.setString(5, ctpn.getSoPN());
        
        return pm.executeUpdate() > 0;
    }
}
