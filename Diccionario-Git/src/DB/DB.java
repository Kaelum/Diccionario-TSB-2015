/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;


/**
 *
 * @author jorge
 */
public class DB {

    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;

    public DB() {
    }
    
    
    public void ConectarBD() {
        try {
            final String Controlador = "org.apache.derby.jdbc.ClientDriver";
            Class.forName(Controlador);
            final String url_bd = "jdbc:derby://localhost:1527/base de datos ejemplo buscar palabra";
            conexion = DriverManager.getConnection(url_bd, "jorge", "jorge");
            sentencia = conexion.createStatement();
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void DesconectarBD() {
        try {
            if (conexion != null) {
                if (sentencia != null) {
                    sentencia.close();
                }
                conexion.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return conexion;
    }
    
    

}
