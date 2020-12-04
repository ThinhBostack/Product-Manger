/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class MyDB {
    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        //Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Create connection string 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=J2_L_P0002";        
        //Open connection
        Connection cn = DriverManager.getConnection(url, "sa", "123456");
        return cn;
    }
        
}
