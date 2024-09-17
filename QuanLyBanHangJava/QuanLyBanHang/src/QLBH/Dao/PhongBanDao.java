/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Dao;

import QLBH.Connection.DatabaseConnection;
import QLBH.Model.PhongBan;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THUY TRUC
 */
public class PhongBanDao {
    
    public boolean insert(PhongBan pb) throws Exception 
    {
        String Sql = "insert into PhongBan(MaPB, TenPB, GhiChu) values(?,?,?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, pb.getMaPB());
        pm.setString(2, pb.getTenPB());
        pm.setString(3, pb.getGhiChu());
        return pm.executeUpdate() > 0;
    }
     
    public boolean Delete(String pb) throws Exception 
    {
        String sql = "Delete from PhongBan where BINARY_CHECKSUM(MaPB) = BINARY_CHECKSUM (?)";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(sql);
        pm.setString(1, pb);
        return pm.executeUpdate() > 0;
    }
      
    public boolean Update(PhongBan pb) throws Exception {
        String Sql = "Update PhongBan SET MaPB=?,TenPB=?,GhiChu=? WHERE MaPB=?";
        Connection conn = DatabaseConnection.openConnect();
        PreparedStatement pm = conn.prepareStatement(Sql);
        pm.setString(1, pb.getMaPB());
        pm.setString(2, pb.getTenPB());
        pm.setString(3, pb.getGhiChu());
        pm.setString(4, pb.getMaPB());

        return pm.executeUpdate() > 0;
    }
}
