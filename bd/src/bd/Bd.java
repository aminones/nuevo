/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bd {
      public static void main(String[] args) {
        String sql = "SELECT nombre FROM empleado ORDER BY 1";
        
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empresa", "root", "");
            PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Código de Error:" + e.getErrorCode() + "\n"
                    + "SLQState:" + e.getSQLState() + "\n"
                    + "Mensaje:" + e.getMessage() + "\n");
        }

    }
   
    
}
