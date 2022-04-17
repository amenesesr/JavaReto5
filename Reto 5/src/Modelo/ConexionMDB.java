
package Modelo;

import java.sql.Connection ;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager ;
import java.sql.SQLException;

public class ConexionMDB {
    
    private final String url = "jdbc:mariadb://localhost:3306/db_prueba";
    private Connection con = null;
    
    public Connection getConexion(){
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(this.url);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(ConexionMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("conexion exitosa");
    return con;
    }
}