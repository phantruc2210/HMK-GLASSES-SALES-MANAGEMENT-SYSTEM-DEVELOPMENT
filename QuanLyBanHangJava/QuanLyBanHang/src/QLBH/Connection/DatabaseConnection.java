/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBH.Connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author THUY TRUC
 */
public class DatabaseConnection {
 
    public static Connection openConnect() throws Exception 
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String ConnectionURL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Java_QLBanHangMatKinh;";
        String username = "sa";
        String password = "1234";
        Connection conn = DriverManager.getConnection(ConnectionURL, username, password);
        return conn;
    }
    
    public static void CloseConnect(Connection conn)
    {
        if(conn!=null)
        {
            try 
            {
                conn.close();
            } catch (SQLException ex) 
            {
                ex.printStackTrace();
                        
            }
        }
    } 
}
